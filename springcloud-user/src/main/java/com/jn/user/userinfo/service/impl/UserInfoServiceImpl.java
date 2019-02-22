package com.jn.user.userinfo.service.impl;

import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.model.UserAffiliateInfo;
import com.jn.user.model.UserCompanyInfo;
import com.jn.user.model.UserExtensionInfo;
import com.jn.user.userinfo.dao.TbUserPersonMapper;
import com.jn.user.userinfo.entity.TbUserPerson;
import com.jn.user.userinfo.entity.TbUserPersonCriteria;
import com.jn.user.userinfo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    private RedisCacheFactory redisCacheFactory;

    @Value(value = "${user.outhrache.information.expire}")
    private int expire;

    /**
     * 用户拓展信息组名
     */
    private static final String USER_EXTENSION_INFO="user_extension_info";

    /**
     * 根据账号获取用户扩展信息
     * @param account 用户账号
     * @return
     */
    @ServiceLog(doAction = "根据账号获取用户扩展信息")
    @Override
    public UserExtensionInfo getUserExtension(String account) {
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
            //把用户拓展信息写入redis中
            cache.put(account, userExtensionInfo);
            return userExtensionInfo;
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
        example.createCriteria().andAccountEqualTo(userAffiliateInfo.getAccount());
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
        example.createCriteria().andAccountEqualTo(userCompanyInfo.getAccount());
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
}
