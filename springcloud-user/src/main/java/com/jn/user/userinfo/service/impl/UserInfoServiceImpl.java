package com.jn.user.userinfo.service.impl;

import com.jn.common.util.cache.RedisCache;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.userinfo.dao.TbUserCompanyMapper;
import com.jn.user.userinfo.dao.TbUserPersonMapper;
import com.jn.user.userinfo.entity.TbUserCompany;
import com.jn.user.userinfo.entity.TbUserCompanyCriteria;
import com.jn.user.userinfo.entity.TbUserPerson;
import com.jn.user.userinfo.entity.TbUserPersonCriteria;
import com.jn.user.userinfo.model.UserCompany;
import com.jn.user.userinfo.model.UserExtension;
import com.jn.user.userinfo.model.UserPerson;
import com.jn.user.userinfo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

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
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private TbUserPersonMapper tbUserPersonMapper;

    @Autowired
    private TbUserCompanyMapper tbUserCompanyMapper;

    @Value(value = "${user.outreach.information.key}")
    private String redisUserKey;

    @Value(value = "${user.outhrache.information.expire}")
    private int expire;

    @Value(value = "${user.outhrache.information.prefix}")
    private String prefix;
    /**
     * 根据账号获取用户扩展信息
     * @param account 用户账号
     * @return
     */
    @ServiceLog(doAction = "根据账号获取用户扩展信息")
    @Override
    public UserExtension getUserInfo(String account) {
        //从redis中取出用户扩展信息
        RedisCache cache = new RedisCache(redisTemplate, prefix, expire);
        UserExtension userExtension = (UserExtension) cache.get(redisUserKey + "_" + account);
        if(userExtension!=null){
            return  userExtension;
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
            cache.put(redisUserKey + "_" + account, userExtension);
            return userExtension;
        }
        //个人用户信息表没有数据，查询企业用户信息表
        List<TbUserCompany> tbUserCompany = getTbUserCompany(account);
        if(tbUserCompany.size()>0){
            UserCompany userCompany=new UserCompany();
            BeanUtils.copyProperties(tbUserCompany, userCompany);
            //把用户拓展信息写入redis中
            cache.put(redisUserKey + "_" + account, userExtension);
        }
        return userExtension;
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
        criteriaAccount.andAccountEqualTo(account);
        criteriaPhone.andPhoneEqualTo(account);
        criteriaEmail.andEmailEqualTo(account);
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
        comCriteriaAccount.andAccountEqualTo(account);
        comCriteriaPhone.andPhoneEqualTo(account);
        comCriteriaEmail.andEmailEqualTo(account);
        comExample.or(comCriteriaAccount);
        comExample.or(comCriteriaPhone);
        comExample.or(comCriteriaEmail);
        return tbUserCompanyMapper.selectByExample(comExample);
    }
}
