package com.jn.user.userinfo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.Assert;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.user.enums.UserExtensionExceptionEnum;
import com.jn.user.model.*;
import com.jn.user.userinfo.dao.TbUserPersonMapper;
import com.jn.user.userinfo.entity.TbUserPerson;
import com.jn.user.userinfo.entity.TbUserPersonCriteria;
import com.jn.user.userinfo.model.UserInfoParam;
import com.jn.user.userinfo.service.UserInfoService;
import com.jn.user.usertag.dao.TbTagCodeMapper;
import com.jn.user.usertag.dao.TbUserTagMapper;
import com.jn.user.usertag.dao.UserTagMapper;
import com.jn.user.usertag.entity.TbTagCode;
import com.jn.user.usertag.entity.TbTagCodeCriteria;
import com.jn.user.usertag.entity.TbUserTag;
import com.jn.user.usertag.entity.TbUserTagCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

/**
 * 获取用户信息
 * @Author: yangph
 * @Date: 2018/12/10 11:33
 * @Version v1.0
 * @modified By:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private TbUserPersonMapper tbUserPersonMapper;
    @Autowired
    private UserTagMapper userTagMapper;
    @Autowired
    private TbUserTagMapper tbUserTagMapper;

    @Autowired
    private RedisCacheFactory redisCacheFactory;
    @Autowired
    private TbTagCodeMapper tbTagCodeMapper;

    @Value(value = "${user.outhrache.information.expire}")
    private int expire;

    /**
     * 用户拓展信息组名
     */
    private static final String USER_EXTENSION_INFO="user_extension_info";

    /**
     * 数据状态 1:有效
     */
    private final static String RECORD_STATUS_VALID = "1";
    private final static String TAG_CODE_IS_HOBBY = "0";
    private final static String TAG_CODE_IS_JOB = "1";

    /**
     * 根据账号获取用户扩展信息
     * @param account 用户账号
     * @return
     */
    @ServiceLog(doAction = "根据账号获取用户扩展信息")
    @Override
    public UserExtensionInfo getUserExtension(String account) {
        if(StringUtils.isEmpty(account)){
            throw new JnSpringCloudException(UserExtensionExceptionEnum.USER_INFO_GET_ERROR);
        }
        //从redis中取出用户扩展信息
        Cache<Object> cache = redisCacheFactory.getCache(USER_EXTENSION_INFO, expire);
        UserExtensionInfo userExtensionInfo = (UserExtensionInfo)cache.get(account);
        if(userExtensionInfo==null){
           userExtensionInfo=new UserExtensionInfo();
        }else{
            return userExtensionInfo;
        }
        //redis中没有数据，从数据库中获取
        List<TbUserPerson> tbUserPeople = getTbUserPeople(account);
        //用户扩展表有当前用户信息，直接返回用户扩展信息,没有返回null
        if (tbUserPeople.isEmpty()) {
            logger.warn("用户[{}]扩展信息不存在或已被删除",account);
            return null;
        }else{
            TbUserPerson tbUserPerson = tbUserPeople.get(0);
            BeanUtils.copyProperties(tbUserPerson, userExtensionInfo);
            getUserHobbyAndJobs(userExtensionInfo);
            //把用户拓展信息写入redis中
            cache.put(account, userExtensionInfo);
            return userExtensionInfo;
        }
    }

    /**
     * 获取用户兴趣爱好和用户工作
     * @param userExtensionInfo
     */
    @ServiceLog(doAction = "获取用户兴趣爱好和用户工作")
    private void getUserHobbyAndJobs(UserExtensionInfo userExtensionInfo) {
        //获取用户兴趣爱好
        TbUserTagCriteria exampleHobby=new TbUserTagCriteria();
        exampleHobby.createCriteria().andUserIdEqualTo(userExtensionInfo.getId())
                .andTagTypeEqualTo(TAG_CODE_IS_HOBBY).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbUserTag> tbUserTaHobbygList = tbUserTagMapper.selectByExample(exampleHobby);
        if(!tbUserTaHobbygList.isEmpty()){
            List<String>hobbyList=new ArrayList<>();
            for(TbUserTag tbUserTag:tbUserTaHobbygList){
                hobbyList.add(tbUserTag.getTagName());
            }
            userExtensionInfo.setHobbys(hobbyList);
        }
        //获取用户工作
        TbUserTagCriteria exampleJob=new TbUserTagCriteria();
        exampleJob.createCriteria().andUserIdEqualTo(userExtensionInfo.getId())
                .andTagTypeEqualTo(TAG_CODE_IS_JOB).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbUserTag> tbUserTagJobList = tbUserTagMapper.selectByExample(exampleJob);
        if(!tbUserTagJobList.isEmpty()){
            List<String>jobList=new ArrayList<>();
            for(TbUserTag tbUserTag:tbUserTagJobList){
                jobList.add(tbUserTag.getTagName());
            }
            userExtensionInfo.setJobs(jobList);
        }
    }

    /**
     * 批量获取用户的扩展信息
     * @param accountList  用户账号集合
     * @return
     */
    @ServiceLog(doAction = "批量获取用户的扩展信息")
    @Override
    public List<UserExtensionInfo> getMoreUserExtension(List<String> accountList) {
        if(accountList.isEmpty()){
            return new ArrayList<>(16);
        }
        //返回的结果集
        List<UserExtensionInfo>userList=new ArrayList<>(16);
        //需要从数据库查询的用户账号
        List<String> needSelectAccountList=new ArrayList<>(32);
        //从缓存中获取用户信息，把缓存中没有的用户列出来从数据库中查询出来
        //从redis中取出用户扩展信息
        Cache<Object> cache = redisCacheFactory.getCache(USER_EXTENSION_INFO, expire);
        for(String account:accountList){
            UserExtensionInfo userExtensionInfo = (UserExtensionInfo)cache.get(account);
            if(userExtensionInfo!=null){
                userList.add(userExtensionInfo);
            }else{
                needSelectAccountList.add(account);
            }
        }
        //没有需要查询的账号，直接把缓存中获得的用户信息返回
        if(needSelectAccountList.isEmpty()){
            return userList;
        }

        //批量获取用户扩展信息
        List<UserExtensionInfo> personUserExtensionList = getPersonUserInfoBatche(needSelectAccountList);
        for(UserExtensionInfo user:personUserExtensionList){
            //用户兴趣爱好和工作信息
            getUserHobbyAndJobs(user);
            userList.add(user);
            //把用户拓展信息写入redis中
            cache.put(user.getAccount(), user);
        }
        if(userList.isEmpty()){
            logger.warn("批量获取用户的扩展信息失败，所获取用户信息不存在或已被删除");
        }
        return userList;
    }

    /**
     * 更新用户所属机构信息
     * @param userAffiliateInfo
     * @return
     */
    @ServiceLog(doAction = "更新用户所属机构信息")
    @Override
    public boolean updateAffiliateInfo(UserAffiliateInfo userAffiliateInfo) {
        TbUserPersonCriteria example=new TbUserPersonCriteria();
        List<String> updateAccountList = Arrays.asList(userAffiliateInfo.getAccountList());
        example.createCriteria().andAccountIn(updateAccountList);
        TbUserPerson tbUserPerson=new TbUserPerson();
        tbUserPerson.setAffiliateCode(userAffiliateInfo.getAffiliateCode());
        tbUserPerson.setAffiliateName(userAffiliateInfo.getAffiliateName());
        int i = tbUserPersonMapper.updateByExampleSelective(tbUserPerson, example);
        //修改成功 i==1
        return i==1;
    }

    /**
     * 更新用户所属企业信息
     * @param  userCompanyInfo
     * @return
     */
    @ServiceLog(doAction = "更新用户所属企业信息")
    @Override
    public boolean updateCompanyInfo(UserCompanyInfo userCompanyInfo) {
        TbUserPersonCriteria example=new TbUserPersonCriteria();
        example.createCriteria().andAccountIn(Arrays.asList(userCompanyInfo.getAccountList()));
        TbUserPerson tbUserPerson=new TbUserPerson();
        tbUserPerson.setCompanyCode(userCompanyInfo.getCompanyCode());
        tbUserPerson.setCompanyName(userCompanyInfo.getCompanyName());
        int i = tbUserPersonMapper.updateByExampleSelective(tbUserPerson, example);
        //修改成功 i==1
        return i==1;
    }


    /**
     * 批量获取个人用户扩展信息
     * @param accountList
     * @return
     */
    @ServiceLog(doAction = "批量获取个人用户扩展信息")
    private List<UserExtensionInfo> getPersonUserInfoBatche(List<String> accountList) {
        List<UserExtensionInfo> userExtensionList=new ArrayList<>();
        //一次允许查询的最大用户数
        int maxLength=200;
        if(accountList.size()<maxLength){
            getPersonUserInfoAndConvert(accountList, userExtensionList);
        }else{
            //查询用户数大于一次允许查询的最大用户数，分开查询
            List<String> newAccountList=new ArrayList<>(256);
            for(int i=0;i<accountList.size();i++){
                newAccountList.add(accountList.get(i));
                if(i%200==0){
                    getPersonUserInfoAndConvert(newAccountList,userExtensionList);
                    newAccountList.clear();
                }
            }
            //避免最后一次不足最大用户数的数据漏查
            if(!newAccountList.isEmpty()){
                getPersonUserInfoAndConvert(newAccountList,userExtensionList);
            }
        }
        return userExtensionList;
    }

    /**
     * 获取个人用户信息并转换为用户扩展信息bean
     * @param accountList
     * @param userExtensionList
     */
    @ServiceLog(doAction = "获取用户信息并转换为用户扩展信息bean")
    private void getPersonUserInfoAndConvert(List<String> accountList, List<UserExtensionInfo> userExtensionList) {
        TbUserPersonCriteria perExample = new TbUserPersonCriteria();
        //是否删除 0：已删除   1：正常
        byte recordStatus=1;
        perExample.createCriteria().andAccountIn(accountList).andRecordStatusEqualTo(recordStatus);
        List<TbUserPerson> tbUserPeople = tbUserPersonMapper.selectByExample(perExample);
        for(TbUserPerson user:tbUserPeople){
            UserExtensionInfo userExtensionInfo =new UserExtensionInfo();
            BeanUtils.copyProperties(user, userExtensionInfo);
            userExtensionList.add(userExtensionInfo);
        }
    }

    /**
     * 根据账号获取用户扩展信息
     * @param account  用户账号
     * @return
     */
    @ServiceLog(doAction = "根据账号获取用户扩展信息")
    private List<TbUserPerson> getTbUserPeople(String account) {
        TbUserPersonCriteria perExample = new TbUserPersonCriteria();
        //用户账号查询条件
        TbUserPersonCriteria.Criteria criteriaAccount = perExample.createCriteria();
        //用户手机号查询条件
        TbUserPersonCriteria.Criteria criteriaPhone = perExample.createCriteria();
        //用户邮箱查询条件
        TbUserPersonCriteria.Criteria criteriaEmail = perExample.createCriteria();
        //是否删除 0：已删除   1：正常
        byte recordStatus=1;
        criteriaAccount.andAccountEqualTo(account).andRecordStatusEqualTo(recordStatus);
        criteriaPhone.andPhoneEqualTo(account).andRecordStatusEqualTo(recordStatus);
        criteriaEmail.andEmailEqualTo(account).andRecordStatusEqualTo(recordStatus);
        perExample.or(criteriaAccount);
        perExample.or(criteriaPhone);
        perExample.or(criteriaEmail);
        return tbUserPersonMapper.selectByExample(perExample);
    }


    /**
     * 根据所属机构编码批量获取用户信息
     * @param affiliateParam  所属机构编码入参
     * @return
     */
    @ServiceLog(doAction = "根据所属机构编码批量获取用户信息")
    @Override
    public PaginationData getUserExtensionByAffiliateCode(AffiliateParam affiliateParam) {
        if(affiliateParam==null){
            throw new JnSpringCloudException(UserExtensionExceptionEnum.AFFILIATE_PARAM_NOT_NULL);
        }
        com.github.pagehelper.Page<Object> objects = null;
        //是否分页标识  0：不分页  1：分页
        String isPage="1";
        if(isPage.equals(affiliateParam.getNeedPage())){
            objects = PageHelper.startPage(affiliateParam.getPage(),
                    affiliateParam.getRows() == 0 ? 15 : affiliateParam.getRows(), true);
        }
        //数据状态正常  0:删除  1：正常
        byte recordStatus=1;
        TbUserPersonCriteria example=new TbUserPersonCriteria();
        example.createCriteria().andAffiliateCodeEqualTo(affiliateParam.getAffiliateCode())
                .andRecordStatusEqualTo(recordStatus);
        List<TbUserPerson> userPersonList = tbUserPersonMapper.selectByExample(example);
        return getPaginationData(objects, userPersonList);


    }


    /**
     * 根据所属企业编码批量获取用户信息
     * @param companyParam  所属企业编码
     * @return
     */
    @Override
    public PaginationData getUserExtensionByCompanyCode(CompanyParam companyParam) {
        if(companyParam==null){
            throw new JnSpringCloudException(UserExtensionExceptionEnum.COMPANY_PARAM_NOT_NULL);
        }
        com.github.pagehelper.Page<Object> objects = null;
        //是否分页标识  0：不分页  1：分页
        String isPage="1";
        if(isPage.equals(companyParam.getNeedPage())){
            objects = PageHelper.startPage(companyParam.getPage(),
                    companyParam.getRows() == 0 ? 15 : companyParam.getRows(), true);
        }
        //数据状态正常  0:删除  1：正常
        byte recordStatus=1;
        TbUserPersonCriteria example=new TbUserPersonCriteria();
        example.createCriteria().andCompanyCodeEqualTo(companyParam.getCompanyCode())
                .andRecordStatusEqualTo(recordStatus);
        List<TbUserPerson> companyList = tbUserPersonMapper.selectByExample(example);
        return getPaginationData(objects, companyList);
    }

    /**
     * 更新redis中的用户信息
     * @param account 用户账号
     * @return
     */
    @ServiceLog(doAction = "更新redis中的用户信息")
    @Override
    public boolean updateRedisUserInfo(String account) {
        Assert.notNull(account,UserExtensionExceptionEnum.USER_ACCOUNT_NOT_NULL.getMessage());
        //从数据库中获取用户信息
        List<TbUserPerson> tbUserPeople = getTbUserPeople(account);
        if (tbUserPeople.isEmpty()) {
            logger.warn("用户[{}]扩展信息不存在或已被删除",account);
            throw new JnSpringCloudException(UserExtensionExceptionEnum.USER_EXTENSION_NOT_EXISTS);
        }else{
            TbUserPerson tbUserPerson = tbUserPeople.get(0);
            UserExtensionInfo userExtensionInfo=new UserExtensionInfo();
            BeanUtils.copyProperties(tbUserPerson, userExtensionInfo);
            //用户兴趣爱好和工作信息
            getUserHobbyAndJobs(userExtensionInfo);
            //把用户拓展信息写入redis中
            Cache<Object> cache = redisCacheFactory.getCache(USER_EXTENSION_INFO, expire);
            cache.put(account, userExtensionInfo);
            return true;
        }
    }

    /**
     * 处理用户分页数据
     * @param objects
     * @param userPersonList
     * @return
     */
    @ServiceLog(doAction = "处理用户分页数据")
    private PaginationData getPaginationData(Page<Object> objects, List<TbUserPerson> userPersonList) {
        if (userPersonList.isEmpty()) {
            return new PaginationData(userPersonList, objects == null ? 0 : objects.getTotal());
        } else {
            List<UserExtensionInfo> resultList = new ArrayList<>(16);
            for (TbUserPerson userPerson : userPersonList) {
                UserExtensionInfo userExtensionInfo = new UserExtensionInfo();
                BeanUtils.copyProperties(userPerson, userExtensionInfo);
                getUserHobbyAndJobs(userExtensionInfo);
                resultList.add(userExtensionInfo);
            }
            return new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
        }
    }

    @Override
    @ServiceLog(doAction = "保存/修改用户信息")
    public int saveOrUpdateUserInfo(UserInfoParam userInfoParam, User user){
        if(null == user ){
            throw new JnSpringCloudException(UserExtensionExceptionEnum.USER_INFO_GET_ERROR);
        }
        TbUserPersonCriteria personCriteria = new TbUserPersonCriteria();
        personCriteria.createCriteria().andAccountEqualTo(user.getAccount()).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbUserPerson> tbUserPeople = tbUserPersonMapper.selectByExample(personCriteria);
        TbUserPerson tbUserPerson = new TbUserPerson();
        BeanUtils.copyProperties(user,tbUserPerson);
        BeanUtils.copyProperties(userInfoParam,tbUserPerson);

        // 出生年月不为空时，判断日期格式
        if (StringUtils.isNotEmpty(userInfoParam.getBirthday())) {
            try {
                tbUserPerson.setBirthday(DateUtils.parseDate(userInfoParam.getBirthday(),"yyyy-MM-dd"));
            } catch (ParseException e) {
                throw new JnSpringCloudException(UserExtensionExceptionEnum.BIRTHDAY_FORMAT_ERROR);
            }
        }

        int a;
        if(null == tbUserPeople || tbUserPeople.size() == 0){
            //新增
            tbUserPerson.setId(UUID.randomUUID().toString().replaceAll("-",""));
            tbUserPerson.setCreatedTime(new Date());
            tbUserPerson.setCreatorAccount(user.getAccount());

            tbUserPerson.setRecordStatus(new Byte(RECORD_STATUS_VALID));
            a = tbUserPersonMapper.insert(tbUserPerson);
        }else if(null!=tbUserPeople && tbUserPeople.size()==1){
            //修改
            tbUserPerson.setId(tbUserPeople.get(0).getId());
            tbUserPerson.setModifiedTime(new Date());
            tbUserPerson.setModifierAccount(user.getAccount());
            a = tbUserPersonMapper.updateByPrimaryKeySelective(tbUserPerson);
        }else{
            //用户数据存在多条
            throw new JnSpringCloudException(UserExtensionExceptionEnum.USER_DATA_MULTIPLE_ERROR);
        }
        TbTagCodeCriteria tbTagCodeCriteria = new TbTagCodeCriteria();
        tbTagCodeCriteria.createCriteria().andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbTagCode> tagCodes = tbTagCodeMapper.selectByExample(tbTagCodeCriteria);
        List<TbUserTag> hobbys = getUserTagList(userInfoParam.getHobbys(), TAG_CODE_IS_HOBBY, tbUserPerson.getId(), user.getAccount(),tagCodes);
        List<TbUserTag> jobs = getUserTagList(userInfoParam.getJobs(), TAG_CODE_IS_JOB, tbUserPerson.getId(), user.getAccount(),tagCodes);
        hobbys.addAll(jobs);
        TbUserTagCriteria tagCriteria = new TbUserTagCriteria();
        tagCriteria.createCriteria().andCreatorAccountEqualTo(user.getAccount());
        int i = tbUserTagMapper.deleteByExample(tagCriteria);
        logger.info("删除用户兴趣爱好/职业标签数据 {} 条",i);
        if(null!=hobbys && hobbys.size()>0){
            int i1 = userTagMapper.insertUserTag(hobbys);
            logger.info("【插入新数据】用户兴趣爱好/职业标签数据 {} 条",i1);
        }

        //更新redis缓存数据
        updateRedisUserInfo(user.getAccount());
        return a;
    }
    @ServiceLog(doAction = "根据条件查找用户账号列表")
    @Override
    public List<String> getAccountList( UserInfoQueryParam param) {
        List<String> accountLIst = new ArrayList<>(16);
        TbUserPersonCriteria criteria = new TbUserPersonCriteria();
        TbUserPersonCriteria.Criteria example = criteria.createCriteria();
        if (StringUtils.isNotBlank(param.getNickName())){
            example.andNickNameLike("%"+param.getNickName()+"%");
        }
        if(StringUtils.isNotBlank(param.getPhone())){
            example.andPhoneLike("%"+param.getPhone()+"%");
        }
        List<TbUserPerson> list=  tbUserPersonMapper.selectByExample(criteria);
        if(!list.isEmpty()){
            for(TbUserPerson user : list){
             accountLIst.add(user.getAccount());
            }
        }
      return  accountLIst;
    }

    @Override
    @ServiceLog(doAction = "根据查询字段获取用户信息")
    public PaginationData getUserExtensionBySearchFiled(SearchFiledParam searchFiledParam) {
        if(searchFiledParam == null){
            throw new JnSpringCloudException(UserExtensionExceptionEnum.SEARCH_PARAM_NOT_NULL);
        }
        com.github.pagehelper.Page<Object> objects = null;
        //是否分页标识  0：不分页  1：分页
        String isPage="1";
        if(isPage.equals(searchFiledParam.getNeedPage())){
            objects = PageHelper.startPage(searchFiledParam.getPage(),
                    searchFiledParam.getRows() == 0 ? 15 : searchFiledParam.getRows(), true);
        }
        //数据状态正常  0:删除  1：正常
        byte recordStatus=1;
        TbUserPersonCriteria example=new TbUserPersonCriteria();
        TbUserPersonCriteria.Criteria criteria = example.createCriteria();
        criteria.andRecordStatusEqualTo(recordStatus);
        if (StringUtils.isNotEmpty(searchFiledParam.getComId())) {
            criteria.andCompanyCodeEqualTo(searchFiledParam.getComId());
        }
        if (StringUtils.isNotEmpty(searchFiledParam.getName())) {
            criteria.andNameLike("%" + searchFiledParam.getName() + "%");
        }
        if (StringUtils.isNotEmpty(searchFiledParam.getPhone())) {
            criteria.andPhoneEqualTo(searchFiledParam.getPhone());
        }
        if (searchFiledParam.getAccountList() != null && !searchFiledParam.getAccountList().isEmpty()) {
            criteria.andAccountNotIn(searchFiledParam.getAccountList());
        }
        example.setOrderByClause("modifier_account DESC");
        List<TbUserPerson> companyList = tbUserPersonMapper.selectByExample(example);
        return getPaginationData(objects, companyList);
    }

    private List<TbUserTag> getUserTagList(String[] s,String type,String id,String account,List<TbTagCode> tagCodes){
        List<TbUserTag> tags = new ArrayList<>(8);

        if(null != s && s.length>0){
            for (String a:s) {
                if(StringUtils.isNotEmpty(a)){
                    TbUserTag tag = new TbUserTag();
                    tag.setId(UUID.randomUUID().toString().replaceAll("-",""));
                    tag.setTagId(a);
                    tag.setUserId(id);
                    tag.setTagType(type);
                    tag.setCreatedTime(new Date());
                    tag.setCreatorAccount(account);
                    tag.setRecordStatus(new Byte(RECORD_STATUS_VALID));
                    for (TbTagCode tbUserTag:tagCodes
                    ) {
                        if(StringUtils.equals(tbUserTag.getTagId(),a)){
                            tag.setTagName(tbUserTag.getTagVaule());
                        }
                    }
                    tags.add(tag);
                }

            }
        }
        return tags;
    }

    @Override
    @ServiceLog(doAction = "获取用户实名制状态")
    public Boolean getUserRealNameStatus(String account){
        UserExtensionInfo userExtension = this.getUserExtension(account);
        if(null!=userExtension && StringUtils.isNotEmpty(userExtension.getIdCard())){
            return true;
        }else{
            return false;
        }
    }

}
