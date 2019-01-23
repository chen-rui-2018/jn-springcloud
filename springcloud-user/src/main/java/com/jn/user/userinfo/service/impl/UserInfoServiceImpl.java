package com.jn.user.userinfo.service.impl;

import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.model.UserCompany;
import com.jn.user.model.UserExtension;
import com.jn.user.model.UserPerson;
import com.jn.user.userinfo.dao.TbUserCompanyMapper;
import com.jn.user.userinfo.dao.TbUserPersonMapper;
import com.jn.user.userinfo.entity.TbUserCompany;
import com.jn.user.userinfo.entity.TbUserCompanyCriteria;
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
    private TbUserCompanyMapper tbUserCompanyMapper;

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
    public UserExtension getUserExtension(String account) {
        //从redis中取出用户扩展信息
        Cache<Object> cache = redisCacheFactory.getCache(USER_EXTENSION_INFO, expire);
        UserExtension userExtension = (UserExtension)cache.get(account);
        if(userExtension!=null){
            return  userExtension;
        }else{
            userExtension=new UserExtension();
        }
        //redis中没有数据，从数据库中获取
        List<TbUserPerson> tbUserPeople = getTbUserPeople(account);
        //个人用户扩展表有当前用户信息，直接返回个人用户扩展信息
        if (tbUserPeople.size() > 0) {
            TbUserPerson tbUserPerson = tbUserPeople.get(0);
            UserPerson userPerson=new UserPerson();
            BeanUtils.copyProperties(tbUserPerson, userPerson);
            userExtension.setUserPersonInfo(userPerson);
            //把用户拓展信息写入redis中
            cache.put(account, userExtension);
            return userExtension;
        }
        //个人用户信息表没有数据，查询企业用户信息表
        List<TbUserCompany> tbUserCompany = getTbUserCompany(account);
        if(tbUserCompany.size()>0){
            UserCompany userCompany=new UserCompany();
            BeanUtils.copyProperties(tbUserCompany, userCompany);
            //把用户拓展信息写入redis中
            cache.put(account, userExtension);
        }
        if(userExtension.getUserPersonInfo()==null && userExtension.getUserCompanyInfo()==null){
            logger.warn("用户[{}]扩展信息不存在或已被删除",account);
            return null;
        }
        return userExtension;
    }

    /**
     * 批量获取用户的扩展信息
     * @param accountList  用户账号集合
     * @return
     */
    @Override
    public List<UserExtension> getMoreUserExtension(List<String> accountList) {
        if(accountList==null || accountList.size()==0){
            return null;
        }
        //返回的结果集
        List<UserExtension>userList=new ArrayList<>(16);
        //需要从数据库查询的用户账号
        List<String> needSelectAccountList=new ArrayList<>(32);
        //从缓存中获取用户信息，把缓存中没有的用户列出来从数据库中查询出来
        //从redis中取出用户扩展信息
        Cache<Object> cache = redisCacheFactory.getCache(USER_EXTENSION_INFO, expire);
        for(String account:accountList){
            UserExtension userExtension = (UserExtension)cache.get(account);
            if(userExtension!=null){
                userList.add(userExtension);
            }else{
                needSelectAccountList.add(account);
            }
        }
        //没有需要查询的账号，直接把缓存中获得的用户信息返回
        if(needSelectAccountList.size()==0){
            return userList;
        }

        //批量获取个人用户扩展信息
        List<UserExtension> personUserExtensionList = getPersonUserInfoBatche(needSelectAccountList);
        for(UserExtension user:personUserExtensionList){
            userList.add(user);
            //把用户拓展信息写入redis中
            cache.put(user.getUserPersonInfo().getAccount(), user);
        }
        //批量获取企业用户扩展信息
        List<UserExtension> companyUserExtensionList= getCompanyUserInfoBatch(needSelectAccountList);
        for(UserExtension user:companyUserExtensionList){
            userList.add(user);
            //把用户拓展信息写入redis中
            cache.put(user.getUserCompanyInfo().getAccount(), user);
        }
        if(userList.isEmpty()){
            logger.warn("批量获取用户的扩展信息失败，所获取用户信息不存在或已被删除");
            return null;
        }
        return userList;
    }

    /**
     * 批量获取企业用户扩展信息
     * @param accountList
     * @return
     */
    @ServiceLog(doAction = "批量获取企业用户扩展信息")
    private List<UserExtension> getCompanyUserInfoBatch(List<String> accountList) {
        List<UserExtension> userExtensionList=new ArrayList<>();
        //一次允许查询的最大用户数
        int maxLength=200;
        if(accountList.size()<maxLength){
            getCompanyInfoAndConvert(accountList, userExtensionList);
        }else{
            List<String> newAccountList=new ArrayList<>(256);
            for(int i=0;i<accountList.size();i++){
                newAccountList.add(accountList.get(i));
                if(i%200==0){
                    getCompanyInfoAndConvert(newAccountList,userExtensionList);
                    newAccountList.clear();
                }
            }
            //避免最后一次不足最大用户数的数据漏查
            if(newAccountList.size()>0){
                getCompanyInfoAndConvert(newAccountList,userExtensionList);
            }
        }
        return userExtensionList;
    }

    /**
     * 获取企业用户信息并转换为用户扩展信息bean
     * @param accountList
     * @param userExtensionList
     */
    @ServiceLog(doAction = "获取企业用户信息并转换为用户扩展信息bean")
    private void getCompanyInfoAndConvert(List<String> accountList, List<UserExtension> userExtensionList) {
        TbUserCompanyCriteria comExample = new TbUserCompanyCriteria();
        //是否删除 0：已删除   1：正常
        byte recordStatus=1;
        comExample.createCriteria().andAccountIn(accountList).andRecordStatusEqualTo(recordStatus);
        List<TbUserCompany> tbUserCompanies = tbUserCompanyMapper.selectByExample(comExample);
        for(TbUserCompany user:tbUserCompanies){
            UserExtension userExtension=new UserExtension();
            UserCompany userCompany=new UserCompany();
            BeanUtils.copyProperties(user, userCompany);
            userExtension.setUserCompanyInfo(userCompany);
            userExtensionList.add(userExtension);
        }
    }

    /**
     * 批量获取个人用户扩展信息
     * @param accountList
     * @return
     */
    @ServiceLog(doAction = "批量获取个人用户扩展信息")
    private List<UserExtension> getPersonUserInfoBatche(List<String> accountList) {
        List<UserExtension> userExtensionList=new ArrayList<>();
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
            if(newAccountList.size()>0){
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
    @ServiceLog(doAction = "获取个人用户信息并转换为用户扩展信息bean")
    private void getPersonUserInfoAndConvert(List<String> accountList, List<UserExtension> userExtensionList) {
        TbUserPersonCriteria perExample = new TbUserPersonCriteria();
        //是否删除 0：已删除   1：正常
        byte recordStatus=1;
        perExample.createCriteria().andAccountIn(accountList).andRecordStatusEqualTo(recordStatus);
        List<TbUserPerson> tbUserPeople = tbUserPersonMapper.selectByExample(perExample);
        for(TbUserPerson user:tbUserPeople){
            UserExtension userExtension=new UserExtension();
            UserPerson userPerson=new UserPerson();
            BeanUtils.copyProperties(user, userPerson);
            userExtension.setUserPersonInfo(userPerson);
            userExtensionList.add(userExtension);
        }
    }

    /**
     * 根据账号获取个人用户扩展信息
     * @param account  用户账号
     * @return
     */
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
     * 根据账号获取企业用户扩展信息
     * @param account  用户账号
     * @return
     */
    private List<TbUserCompany> getTbUserCompany(String account) {
        TbUserCompanyCriteria comExample = new TbUserCompanyCriteria();
        //用户账号查询条件
        TbUserCompanyCriteria.Criteria comCriteriaAccount = comExample.createCriteria();
        //用户手机号查询条件
        TbUserCompanyCriteria.Criteria comCriteriaPhone = comExample.createCriteria();
        //用户邮箱查询条件
        TbUserCompanyCriteria.Criteria comCriteriaEmail = comExample.createCriteria();
        //是否删除 0：已删除   1：正常
        byte recordStatus=1;
        comCriteriaAccount.andAccountEqualTo(account).andRecordStatusEqualTo(recordStatus);
        comCriteriaPhone.andPhoneEqualTo(account).andRecordStatusEqualTo(recordStatus);
        comCriteriaEmail.andEmailEqualTo(account).andRecordStatusEqualTo(recordStatus);
        comExample.or(comCriteriaAccount);
        comExample.or(comCriteriaPhone);
        comExample.or(comCriteriaEmail);
        return tbUserCompanyMapper.selectByExample(comExample);
    }
}
