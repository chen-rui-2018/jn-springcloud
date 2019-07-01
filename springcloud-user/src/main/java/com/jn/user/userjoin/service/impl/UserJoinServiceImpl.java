package com.jn.user.userjoin.service.impl;

import com.jn.common.channel.MessageSource;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import com.jn.common.util.encryption.AESUtil;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import com.jn.system.vo.SysUserRoleVO;
import com.jn.user.enums.HomeRoleEnum;
import com.jn.user.enums.RecordStatusEnum;
import com.jn.user.enums.UserExtensionExceptionEnum;
import com.jn.user.userinfo.dao.TbUserPersonMapper;
import com.jn.user.userinfo.entity.TbUserPerson;
import com.jn.user.userjoin.enums.UserJoinExceptionEnum;
import com.jn.user.userjoin.model.UserRegister;
import com.jn.user.userjoin.service.UserJoinService;
import com.jn.user.utils.PasswordRuleUtil;
import com.jn.user.vo.PasswordValidVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 加入园区
 *
 * @author： lijun
 * @date： Created on 2019/2/28 17:57
 * @version： v1.0
 * @modified By:
 */
@Service
@EnableBinding(value = {MessageSource.class})
public class UserJoinServiceImpl implements UserJoinService {
    private static Logger logger = LoggerFactory.getLogger(UserJoinServiceImpl.class);

    @Autowired
    private RedisCacheFactory redisCacheFactory;

    @Autowired
    private TbUserPersonMapper tbUserPersonMapper;

    @Value(value = "${message.code.expire}")
    private int expire;
    /**
     * 日期格式
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     * 短信验证码组名
     */
    private static final String USER_MESSAGE_CODE="user_message_code";

    // 账号正则（手机号）
    public static final String PHONE_REG = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SystemClient systemClient;

    @ServiceLog(doAction = "获取验证码")
    @Override
    public void getCode(String phone){
        if(StringUtils.isEmpty(phone)){
            throw new JnSpringCloudException(UserJoinExceptionEnum.USER_PHONE_IS_NOT_EXIST);
        }
        String messageCode = String.valueOf(new Random().nextInt(899999) + 100000);
        Cache<Object> cache = redisCacheFactory.getCache(USER_MESSAGE_CODE, expire);
        cache.put(phone,messageCode);
        SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
        smsTemplateVo.setTemplateId("1000");
        String[] m = {phone};
        smsTemplateVo.setMobiles(m);
        String[] t = {messageCode};
        smsTemplateVo.setContents(t);
        logger.info("短信发送成功：接收号码：{},验证码：{}",phone,messageCode);
        messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
    }

    @ServiceLog(doAction = "用户注册")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addUser(UserRegister userRegister){
        String phone = userRegister.getPhone();
        String plainPassword = userRegister.getPassword();

        String code = this.getSendCodeByPhone(phone);
        if(!StringUtils.equals(code,userRegister.getMessageCode())){
            logger.warn("[用户注册] 验证码错误，phone：{}", phone);
            throw new JnSpringCloudException(UserJoinExceptionEnum.MESSAGE_CODE_IS_WRONG);
        }
        checkInfo(plainPassword, phone);

        User user = new User();
        user.setPhone(phone);
        user.setAccount(phone);
        user.setPassword(plainPassword);
        user.setName(phone);
        Result result = systemClient.addSysUser(user);
        if (result != null && result.getCode() != null && result.getCode().equals(GlobalConstants.SUCCESS_CODE)) {
            //给用户添加"普通用户"角色
            String roleName = HomeRoleEnum.NORMAL_USER.getCode();
            Result<SysRole> sysRoleResult = systemClient.getRoleByName(roleName);
            if (sysRoleResult == null || sysRoleResult.getData() == null) {
                logger.warn("用户注册失败，失败原因：无法获取“普通用户”角色信息，请确认系统服务是否正常，且“普通用户”角色在系统中存在");
                throw new JnSpringCloudException(UserExtensionExceptionEnum.NETWORK_ANOMALY);
            }
            //给用户拓展表添加用户信息
            TbUserPerson tbUserPerson = new TbUserPerson();
            BeanUtils.copyProperties(user, tbUserPerson);
            tbUserPerson.setId(UUID.randomUUID().toString());
            tbUserPerson.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
            tbUserPerson.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            tbUserPerson.setCreatorAccount(phone);
            int resNum = tbUserPersonMapper.insertSelective(tbUserPerson);
            if (resNum == 0) {
                logger.warn("用户注册失败，失败原因：添加用户信息到用户扩展信息表失败");
                throw new JnSpringCloudException(UserExtensionExceptionEnum.NETWORK_ANOMALY);
            }
            //更新用户角色
            SysUserRoleVO sysUserRoleVO = new SysUserRoleVO();
            Set<String> addRoleId = new HashSet<>();
            addRoleId.add(sysRoleResult.getData().getId());
            sysUserRoleVO.setAddRoleId(addRoleId);
            sysUserRoleVO.setUser(user);
            Result<Boolean> booleanResult = systemClient.updateUserRole(sysUserRoleVO);
            if (booleanResult.getData() == true) {
                return result;
            } else {
                logger.warn("用户注册失败，失败原因：更新用户角色为“普通用户”失败");
                throw new JnSpringCloudException(UserExtensionExceptionEnum.NETWORK_ANOMALY);
            }
        } else {
            return result;
        }
    }

    @ServiceLog(doAction = "修改密码")
    @Override
    public Result updateUser(UserRegister userRegister){
        String phone = AESUtil.decrypt(userRegister.getPhone(), AESUtil.DEFAULT_KEY);
        String plainPassword = AESUtil.decrypt(userRegister.getPassword(), AESUtil.DEFAULT_KEY);

        String code = this.getSendCodeByPhone(phone);
        if(!StringUtils.equals(code,userRegister.getMessageCode())){
            logger.warn("[修改密码] 验证码错误，phone：{}", phone);
            throw new JnSpringCloudException(UserJoinExceptionEnum.MESSAGE_CODE_IS_WRONG);
        }
        checkInfo(plainPassword, phone);

        User user = new User();
        user.setAccount(phone);
        user.setPassword(plainPassword);
        return systemClient.updateSysUser(user);
    }

    @Override
    public String getSendCodeByPhone(String phone){
        Cache<Object> cache = redisCacheFactory.getCache(USER_MESSAGE_CODE, expire);
        return (String)cache.get(phone);
    }

    /**
     * 正则判断数据有效性
     * @param password
     * @return
     */
    private boolean checkInfo(String password, String phone) {
        if (!Pattern.matches(PHONE_REG, phone)) {
            logger.warn("[用户注册] 手机号校验错误，请输入正确的手机号，account:{}", phone);
            throw new JnSpringCloudException(UserJoinExceptionEnum.PHONE_INVALID);
        }

        PasswordValidVO valid = PasswordRuleUtil.isValid(password);
        if (!valid.isValid()) {
            logger.warn("[用户注册] {}", valid.getMessage());
            throw new JnSpringCloudException(UserJoinExceptionEnum.PASSWORD_INVALID, UserJoinExceptionEnum.PASSWORD_INVALID.getMessage() + "（" + valid.getMessage() + "）");
        }
        return true;
    }

}
