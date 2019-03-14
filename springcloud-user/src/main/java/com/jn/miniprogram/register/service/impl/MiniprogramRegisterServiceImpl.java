package com.jn.miniprogram.register.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.miniprogram.register.dao.TbWechatUserInfoMapper;
import com.jn.miniprogram.register.entity.TbWechatUserInfo;
import com.jn.miniprogram.register.entity.TbWechatUserInfoCriteria;
import com.jn.miniprogram.register.model.RegisterInfoParam;
import com.jn.miniprogram.register.service.MiniprogramRegisterService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.enums.MiniProgramRegisterExceptionEnum;
import com.jn.user.userjoin.service.UserJoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: yangph
 * @Date: 2019/3/11 20:16
 * @Version v1.0
 * @modified By:
 */
@Service
public class MiniprogramRegisterServiceImpl implements MiniprogramRegisterService {
    /**
     * 日志组件
     */
    private static final Logger logger= LoggerFactory.getLogger(MiniprogramRegisterServiceImpl.class);

    @Autowired
    private UserJoinService userJoinService;

    @Autowired
    private TbWechatUserInfoMapper tbWechatUserInfoMapper;

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
     * 数据响应条数
     */
    private static final int RESPONSE_NUM=1;


    /**
     * 判断OpenId是否已绑定
     * @param openId 微信用户openId
     * @return 0:未绑定  1：已绑定
     */
    @ServiceLog(doAction = "判断OpenId是否已绑定")
    @Override
    public int isBindingOpenId(String openId) {
        TbWechatUserInfoCriteria example=new TbWechatUserInfoCriteria();
        //数据状态  0：删除  1：有效
        byte recordStatus=1;
        example.createCriteria().andOpenIdEqualTo(openId).andRecordStatusEqualTo(recordStatus);
        long num = tbWechatUserInfoMapper.countByExample(example);
        //有数据则返回1，否则返回0
        return num>0?1:0;
    }

    /**
     * 注册并绑定
     * @param registerInfoParam  注册绑定入参
     * @return
     */
    @ServiceLog(doAction = "注册并绑定")
    @Override
    public int registerAndBinding(RegisterInfoParam registerInfoParam) {
        //判断手机号和验证码是否正确
        String codeByPhone = userJoinService.getSendCodeByPhone(registerInfoParam.getPhone());
        if(StringUtils.isBlank(codeByPhone) || !StringUtils.equals(registerInfoParam.getCode(), codeByPhone)){
            logger.info("注册并绑定失败，短信验证码错误或验证码已失效");
          throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.CODE_IS_ERROR);
        }
        //根据手机号判断是否在系统中存在
        TbWechatUserInfoCriteria example=new TbWechatUserInfoCriteria();
        //数据状态  0：删除  1：有效
        byte recordStatus=1;
        example.createCriteria().andPhoneEqualTo(registerInfoParam.getPhone()).andRecordStatusEqualTo(recordStatus);
        long num = tbWechatUserInfoMapper.countByExample(example);
        if(num>0){
            //用户信息已存在，直接绑定openId
            return bindingWeChatOpenId(registerInfoParam.getOpenId(),registerInfoParam.getUnionId(),registerInfoParam.getPhone());
        }else{
            TbWechatUserInfo tbWechatUserInfo=new TbWechatUserInfo();
            BeanUtils.copyProperties(registerInfoParam, tbWechatUserInfo);
            //主键id
            tbWechatUserInfo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            //创建时间
            tbWechatUserInfo.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //创建人
            tbWechatUserInfo.setCreatorAccount(registerInfoParam.getPhone());
            //数据状态
            tbWechatUserInfo.setRecordStatus(recordStatus);
            int insertNum = tbWechatUserInfoMapper.insert(tbWechatUserInfo);
            if(insertNum==RESPONSE_NUM){
                return bindingWeChatOpenId(registerInfoParam.getOpenId(),registerInfoParam.getUnionId(),registerInfoParam.getPhone());
            }else{
                logger.info("注册并绑定失败，数据响应条数为：{}条",insertNum);
                throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.NETWORK_ANOMALY);
            }

        }
    }

    /**
     * 绑定微信openxId和unionId
     * @param openId    微信用户openId
     * @param unionId   微信用户unionId
     * @param phone     手机号
     * @return
     */
    private int bindingWeChatOpenId(String openId,String unionId,String phone) {
        //判断openId不为空，且长度为28位
        if(StringUtils.isBlank(openId) || openId.length()!=OPEN_ID_LENGTH){
            throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.OPEN_ID_FORMAT_ERROR);
        }//判断unionId不为空，且长度为29位
        if(StringUtils.isBlank(unionId) || unionId.length()!=UNION_ID_LENGTH){
            throw new JnSpringCloudException(MiniProgramRegisterExceptionEnum.UNION_ID_FORMAT_ERROR);
        }
        TbWechatUserInfo tbWechatUserInfo=new TbWechatUserInfo();
        //openId
        tbWechatUserInfo.setOpenId(openId);
        //unionId
        tbWechatUserInfo.setUnionId(unionId);
        //修改时间
        tbWechatUserInfo.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //修改人
        tbWechatUserInfo.setModifierAccount(phone);
        TbWechatUserInfoCriteria example=new TbWechatUserInfoCriteria();
        example.createCriteria().andPhoneEqualTo(phone);
        return tbWechatUserInfoMapper.updateByExampleSelective(tbWechatUserInfo, example);
    }

}
