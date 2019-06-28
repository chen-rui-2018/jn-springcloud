package com.jn.miniprogram.register.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.miniprogram.register.dao.TbWechatPublicUserInfoMapper;
import com.jn.miniprogram.register.dao.TbWechatUserInfoMapper;
import com.jn.miniprogram.register.entity.TbWechatPublicUserInfo;
import com.jn.miniprogram.register.entity.TbWechatPublicUserInfoCriteria;
import com.jn.miniprogram.register.entity.TbWechatUserInfo;
import com.jn.miniprogram.register.entity.TbWechatUserInfoCriteria;
import com.jn.miniprogram.register.enums.RegisterTypeEnum;
import com.jn.system.api.SystemClient;
import com.jn.system.model.User;
import com.jn.user.enums.IsConCornEnum;
import com.jn.user.enums.RecordStatusEnum;
import com.jn.user.enums.UserExtensionExceptionEnum;
import com.jn.user.model.RegisterInfoParam;
import com.jn.miniprogram.register.service.MiniProgramRegistersService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.enums.MiniProgramRegisterExceptionEnum;
import com.jn.user.model.WeChatRequestParam;
import com.jn.user.userjoin.model.UserRegister;
import com.jn.user.userjoin.service.UserJoinService;
import org.apache.commons.lang.math.RandomUtils;
import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author: yangph
 * @Date: 2019/3/11 20:16
 * @Version v1.0
 * @modified By:
 */
@Service
public class MiniProgramRegistersServiceImpl implements MiniProgramRegistersService {
    /**
     * 日志组件
     */
    private static final Logger logger= LoggerFactory.getLogger(MiniProgramRegistersServiceImpl.class);

    @Autowired
    private UserJoinService userJoinService;

    @Autowired
    private TbWechatUserInfoMapper tbWechatUserInfoMapper;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private TbWechatPublicUserInfoMapper tbWechatPublicUserInfoMapper;


    /**
     * 日期格式
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     * 微信openId长度为28
     */
    private static final int OPEN_ID_LENGTH=28;

    /**
     * 微信unionId长度为29
     */
    private static final int UNION_ID_LENGTH=29;



    /**
     * 判断OpenId是否已绑定账号
     * @param weChatRequestParam 微信用户信息
     *
     * @return 已绑定，返回手机号   未绑定，返回空
     */
    @ServiceLog(doAction = "判断OpenId是否已绑定")
    @Override
    public String isBindingAccountByOpenId(WeChatRequestParam weChatRequestParam, RegisterTypeEnum registerTypeEnum) {
        if(weChatRequestParam==null){
            logger.warn("判断OpenId是否已绑定异常，请求参数为null");
            throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.NETWORK_ANOMALY);
        }
        logger.info("进入判断OpenId是否已绑定账号API,请求入参：{}",weChatRequestParam.toString());
        //校验openId和unionId的长度是否正常
        checkOpenIdAndUnionIdLength(weChatRequestParam.getOpenId(),weChatRequestParam.getUnionId());
        //判断openId在系统中是否存在
        long existNum = existNumOpenId(weChatRequestParam.getOpenId(),registerTypeEnum);
        //微信小程序
        if(StringUtils.equals(RegisterTypeEnum.SMALL_PROGRAM.getCode(), registerTypeEnum.getCode())){
            return saveOrUpdateWeChatUserInfo(weChatRequestParam, existNum,registerTypeEnum);
        }else if(StringUtils.equals(RegisterTypeEnum.PUBLIC_NUMBER.getCode(), registerTypeEnum.getCode())){
            //微信公众号
            return saveOrUpdateWeChatPublicUserInfo(weChatRequestParam, existNum,registerTypeEnum);
        }else{
            logger.warn("微信注册枚举:{}系统不识别",registerTypeEnum.getMessage());
            throw new JnSpringCloudException(UserExtensionExceptionEnum.REGISTER_TYPE_NOT_ALLOW);
        }
    }

    /**
     * 用户关注/取消关注服务号
     * @param weChatRequestParam
     */
    @ServiceLog(doAction = "用户关注/取消关注服务号")
    @Override
    public int concernOrCancelWeChat(WeChatRequestParam weChatRequestParam) {
        logger.info("进入用户关注/取消关注服务号API,请求入参：{}",weChatRequestParam.toString());
        //校验openId和unionId的长度是否正常
        checkOpenIdAndUnionIdLength(weChatRequestParam.getOpenId(),weChatRequestParam.getUnionId());
        //校验关注时间和关注标识
        if(weChatRequestParam.getIsConcern()==null){
            logger.info("用户关注/取消关注服务号的是否关注标志不能为空");
            throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.IS_CONCERN_NOT_NULL);
        }
        if(StringUtils.equals(weChatRequestParam.getIsConcern().getCode(), IsConCornEnum.CORN.getCode())
                && StringUtils.isBlank(weChatRequestParam.getSubscribeTime())){
            logger.info("用户关注/取消关注服务号的关注时间不能为空");
            throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.SUBSCRIBE_TIME_NOT_NULL);
        }
        TbWechatPublicUserInfo publicUserInfo=new TbWechatPublicUserInfo();
        BeanUtils.copyProperties(weChatRequestParam, publicUserInfo);
        //id
        publicUserInfo.setId(UUID.randomUUID().toString());
        //是否删除
        publicUserInfo.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        //是否关注
        publicUserInfo.setIsConcern(weChatRequestParam.getIsConcern().getCode());

        TbWechatPublicUserInfoCriteria example = new TbWechatPublicUserInfoCriteria();
        example.createCriteria().andOpenIdEqualTo(weChatRequestParam.getOpenId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        long existNum = tbWechatPublicUserInfoMapper.countByExample(example);
        if(existNum==0){
            //openId不存在则新增
            //创建时间
            publicUserInfo.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            return tbWechatPublicUserInfoMapper.insertSelective(publicUserInfo);
        }else{
            //openId在系统中存在更新数据
            //更新时间
            publicUserInfo.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            return tbWechatPublicUserInfoMapper.updateByExampleSelective(publicUserInfo, example);
        }

    }

    /**
     * 根据OpenId判断OpenId是否已绑定
     * @param openId
     * @param registerTypeEnum
     * @return
     */
    @ServiceLog(doAction = "根据OpenId判断OpenId是否已绑定")
    @Override
    public String openIdIsBindingAccount(String openId, RegisterTypeEnum registerTypeEnum) {
        logger.info("进入根据OpenId判断OpenId是否已绑定API,请求入参：{}",openId);
        //校验openId和unionId的长度是否正常
        checkOpenIdAndUnionIdLength(openId,"");
        //判断openId在系统中是否存在
        long existNum = existNumOpenId(openId,registerTypeEnum);
        if(existNum==0){
            logger.info("根据OpenId判断OpenId是否已绑定查询成功，当前openId：[{}]没有绑定账号",openId);
            return "";
        }else{
            //openId在系统汇中已经存在，返回绑定的账号
            return isBindingAccountByOpenId(openId,registerTypeEnum);
        }
    }

    /**
     * 保存或修改微信公众号信息
     * @param weChatRequestParam
     * @param existNum
     * @return
     */
    private String saveOrUpdateWeChatPublicUserInfo(WeChatRequestParam weChatRequestParam, long existNum, RegisterTypeEnum registerTypeEnum)
    {
        //微信公众号
        TbWechatPublicUserInfo publicUserInfo=new TbWechatPublicUserInfo();
        BeanUtils.copyProperties(weChatRequestParam, publicUserInfo);
        //id
        publicUserInfo.setId(UUID.randomUUID().toString());
        //是否删除
        publicUserInfo.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        TbWechatPublicUserInfoCriteria example=new TbWechatPublicUserInfoCriteria();
        example.createCriteria().andOpenIdEqualTo(weChatRequestParam.getOpenId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        if(existNum==0){
            //openId在系统中不存在则新增数据
            publicUserInfo.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            tbWechatPublicUserInfoMapper.insertSelective(publicUserInfo);
            //新增数据，没有绑定账号，直接返回空
            return "";
        }else{
            //openId在系统中存在更新数据
            //更新时间
            publicUserInfo.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            tbWechatPublicUserInfoMapper.updateByExampleSelective(publicUserInfo, example);
            //根据openId判断是否已经绑定账号
            return  isBindingAccountByOpenId(weChatRequestParam.getOpenId(),registerTypeEnum);
        }
    }

    /**
     * 保存或修改微信小程序信息
     * @param weChatRequestParam
     * @param existNum
     * @return
     */
    @ServiceLog(doAction = "保存或修改微信小程序信息")
    private String saveOrUpdateWeChatUserInfo(WeChatRequestParam weChatRequestParam, long existNum, RegisterTypeEnum registerTypeEnum) {
        TbWechatUserInfo tbWechatUserInfo=new TbWechatUserInfo();
        BeanUtils.copyProperties(weChatRequestParam, tbWechatUserInfo);
        //id
        tbWechatUserInfo.setId(UUID.randomUUID().toString());
        //是否删除
        tbWechatUserInfo.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        TbWechatUserInfoCriteria example=new TbWechatUserInfoCriteria();
        example.createCriteria().andOpenIdEqualTo(weChatRequestParam.getOpenId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        if(existNum>0){
            //openId在系统中存在更新数据
            //更新时间
            tbWechatUserInfo.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            tbWechatUserInfoMapper.updateByExampleSelective(tbWechatUserInfo, example);
            //根据openId判断是否已经绑定账号
            return  isBindingAccountByOpenId(weChatRequestParam.getOpenId(),registerTypeEnum);

        }else{
            //openId在系统中不存在则新增数据
            tbWechatUserInfo.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            tbWechatUserInfoMapper.insertSelective(tbWechatUserInfo);
            //新增数据，没有绑定账号，直接返回空
            return "";
        }
    }

    /**
     * 是否绑定账号
     * @param openId
     * @return
     */
    @ServiceLog(doAction = "是否绑定账号")
    private String  isBindingAccountByOpenId(String openId,RegisterTypeEnum registerTypeEnum) {
        //微信小程序
        if(StringUtils.equals(RegisterTypeEnum.SMALL_PROGRAM.getCode(),registerTypeEnum.getCode())){
            TbWechatUserInfoCriteria example=new TbWechatUserInfoCriteria();
            example.createCriteria().andOpenIdEqualTo(openId)
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            List<TbWechatUserInfo> weChatUserInfos = tbWechatUserInfoMapper.selectByExample(example);
            if(weChatUserInfos==null || weChatUserInfos.isEmpty()){
                return "";
            }
            return  StringUtils.isBlank(weChatUserInfos.get(0).getPhone())?"":weChatUserInfos.get(0).getPhone();
        }else if(StringUtils.equals(RegisterTypeEnum.PUBLIC_NUMBER.getCode(),registerTypeEnum.getCode())){
            //微信公众号
            TbWechatPublicUserInfoCriteria example=new TbWechatPublicUserInfoCriteria();
            example.createCriteria().andOpenIdEqualTo(openId)
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            List<TbWechatPublicUserInfo> publicUserInfos = tbWechatPublicUserInfoMapper.selectByExample(example);
            if(publicUserInfos==null || publicUserInfos.isEmpty()){
                return "";
            }
            return  StringUtils.isBlank(publicUserInfos.get(0).getPhone())?"":publicUserInfos.get(0).getPhone();
        }else{
            logger.warn("微信注册枚举:{}系统不识别",registerTypeEnum.getMessage());
            throw new JnSpringCloudException(UserExtensionExceptionEnum.REGISTER_TYPE_NOT_ALLOW);
        }
    }

    /**
     * 校验openId和unionId的长度是否正常
     * @param openId
     * @param unionId
     */
    @ServiceLog(doAction = "校验openId和unionId的长度是否正常")
    private void checkOpenIdAndUnionIdLength(String openId,String unionId) {
        if(openId.length()!=OPEN_ID_LENGTH){
            logger.warn("openId的长度不为28位");
            throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.OPEN_ID_FORMAT_ERROR);
        }
        if(StringUtils.isNotBlank(unionId)){
            if(unionId.length()!=UNION_ID_LENGTH){
                logger.warn("unionId的长度不为29位");
                throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.UNION_ID_FORMAT_ERROR);
            }
        }
    }


    /**
     * openId在系统中的数据条数
     * @param openId
     * @return
     */
    @ServiceLog(doAction = "openId在系统中的数据条数")
    private long existNumOpenId(String openId,RegisterTypeEnum registerTypeEnum) {
        //微信公众号
        if (StringUtils.equals(RegisterTypeEnum.PUBLIC_NUMBER.getCode(), registerTypeEnum.getCode())) {
            TbWechatPublicUserInfoCriteria example = new TbWechatPublicUserInfoCriteria();
            example.createCriteria().andOpenIdEqualTo(openId)
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            return tbWechatPublicUserInfoMapper.countByExample(example);
        } else if (StringUtils.equals(RegisterTypeEnum.SMALL_PROGRAM.getCode(), registerTypeEnum.getCode())) {
            //微信小程序
            TbWechatUserInfoCriteria example = new TbWechatUserInfoCriteria();
            example.createCriteria().andOpenIdEqualTo(openId)
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            return tbWechatUserInfoMapper.countByExample(example);
        } else {
            logger.warn("微信注册枚举:{}系统不识别",registerTypeEnum.getMessage());
            throw new JnSpringCloudException(UserExtensionExceptionEnum.REGISTER_TYPE_NOT_ALLOW);
        }
    }

    /**
     * 注册并绑定
     * @param registerInfoParam  注册绑定入参
     * @return 返回注册绑定的手机号
     */
    @ServiceLog(doAction = "注册并绑定")
    @Override
    public String registerAndBinding(RegisterInfoParam registerInfoParam,RegisterTypeEnum registerTypeEnum) {
        if(registerInfoParam==null){
            logger.warn("注册并绑定异常，请求的入参为null");
            throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.NETWORK_ANOMALY);
        }
        logger.info("进入注册并绑定API,请求入参：{}",registerInfoParam.toString());
        //判断手机号和验证码是否正确
        String codeByPhone = userJoinService.getSendCodeByPhone(registerInfoParam.getPhone());
        if(StringUtils.isBlank(codeByPhone) || !StringUtils.equals(registerInfoParam.getCode(), codeByPhone)){
            logger.info("注册并绑定失败，短信验证码错误或验证码已失效");
            throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.CODE_IS_ERROR);
        }
        //判断手机号在基础用户表是否已经存在
        Result<String> stringResult = systemClient.checkUserAccount(registerInfoParam.getPhone());
        if(stringResult==null || stringResult.getData()==null){
            logger.warn("注册并绑定异常，跨服务查询账号在系统中是否存在失败");
            throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.NETWORK_ANOMALY);
        }
        //是否存在 success:账号不存在; fail:账号存在
        String isExist="success";
        if(StringUtils.equals(isExist,stringResult.getData())){
            //若不存在，则先注册，然后再绑定账号
            UserRegister userRegister=new UserRegister();
            userRegister.setPhone(registerInfoParam.getPhone());
            userRegister.setMessageCode(registerInfoParam.getCode());
            userRegister.setPassword("weChat"+ RandomUtils.nextInt(9999));
            userJoinService.addUser(userRegister);
            logger.info("注册并绑定Api注册账号[{}]成功",registerInfoParam.getPhone());
        }
        //若存在，进入下一步绑定账号
        User user=new User();
        //系统中一定存在用户信息，根据账号获取用户信息
        user.setAccount(registerInfoParam.getPhone());
        Result<User> systemClientUser = systemClient.getUser(user);
        if(systemClientUser==null || systemClientUser.getData()==null){
            //根据账号获取无法用户信息，改用手机号获取用户信息
            user.setAccount("");
            user.setPhone(registerInfoParam.getPhone());
            systemClientUser = systemClient.getUser(user);
            if(systemClientUser==null || systemClientUser.getData()==null){
                logger.warn("注册并绑定异常，跨服务获取用户信息失败");
                throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.REGISTER_OR_BIDING_ERROR);
            }
        }
        if(StringUtils.equals(RegisterTypeEnum.SMALL_PROGRAM.getCode(), registerTypeEnum.getCode())){
            TbWechatUserInfo tbWechatUserInfo=new TbWechatUserInfo();
            tbWechatUserInfo.setPhone(systemClientUser.getData().getAccount());
            TbWechatUserInfoCriteria example=new TbWechatUserInfoCriteria();
            example.createCriteria().andOpenIdEqualTo(registerInfoParam.getOpenId())
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            int resNum = tbWechatUserInfoMapper.updateByExampleSelective(tbWechatUserInfo, example);
            if(resNum==0){
                logger.warn("注册并绑定失败，绑定手机号失败");
                throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.NETWORK_ANOMALY);
            }
            logger.info("注册并绑定Api绑定成功，数据响应条数：{}",resNum);
        }else if(StringUtils.equals(RegisterTypeEnum.PUBLIC_NUMBER.getCode(), registerTypeEnum.getCode())){
            TbWechatPublicUserInfo publicUserInfo=new TbWechatPublicUserInfo();
            publicUserInfo.setPhone(systemClientUser.getData().getAccount());
            TbWechatPublicUserInfoCriteria example=new TbWechatPublicUserInfoCriteria();
            example.createCriteria().andOpenIdEqualTo(registerInfoParam.getOpenId())
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            int resNum = tbWechatPublicUserInfoMapper.updateByExampleSelective(publicUserInfo, example);
            if(resNum==0){
                logger.warn("注册并绑定失败，绑定手机号失败");
                throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.NETWORK_ANOMALY);
            }
            logger.info("注册并绑定Api绑定成功，数据响应条数：{}",resNum);
        }else{
            logger.warn("微信注册枚举:{}系统不识别",registerTypeEnum.getMessage());
            throw new JnSpringCloudException(UserExtensionExceptionEnum.REGISTER_TYPE_NOT_ALLOW);
        }
        return systemClientUser.getData().getAccount();
    }

    /**
     * 根据账号获取openId
     * @param account
     * @param registerTypeEnum 微信注册枚举
     * @return
     */
    @ServiceLog(doAction = "根据账号获取openId")
    @Override
    public String getOpenIdByAccount(String account,RegisterTypeEnum registerTypeEnum) {
        //微信小程序
        if(StringUtils.equals(RegisterTypeEnum.SMALL_PROGRAM.getCode(),registerTypeEnum.getCode())){
            TbWechatUserInfoCriteria example=new TbWechatUserInfoCriteria();
            example.createCriteria().andPhoneEqualTo(account)
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            List<TbWechatUserInfo> userInfoList = tbWechatUserInfoMapper.selectByExample(example);
            if(userInfoList.isEmpty()|| StringUtils.isBlank(userInfoList.get(0).getOpenId())){
                return "";
            }else{
                return userInfoList.get(0).getOpenId();
            }
        }else if(StringUtils.equals(RegisterTypeEnum.PUBLIC_NUMBER.getCode(),registerTypeEnum.getCode())){
            //微信公众号
            TbWechatPublicUserInfoCriteria example=new TbWechatPublicUserInfoCriteria();
            example.createCriteria().andPhoneEqualTo(account)
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            List<TbWechatPublicUserInfo> userInfoList = tbWechatPublicUserInfoMapper.selectByExample(example);
            if(userInfoList.isEmpty()|| StringUtils.isBlank(userInfoList.get(0).getOpenId())){
                return "";
            }else{
                return userInfoList.get(0).getOpenId();
            }
        }else{
            logger.warn("微信注册枚举:{}系统不识别",registerTypeEnum.getMessage());
            throw new JnSpringCloudException(UserExtensionExceptionEnum.REGISTER_TYPE_NOT_ALLOW);
        }
    }
}
