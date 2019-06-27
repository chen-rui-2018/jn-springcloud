package com.jn.enterprise.pd.declaration.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.channel.MessageSource;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.pd.declaration.dao.*;
import com.jn.enterprise.pd.declaration.entity.*;
import com.jn.enterprise.pd.declaration.enums.DeclaratStatusEnums;
import com.jn.enterprise.pd.declaration.enums.PdStatusEnums;
import com.jn.enterprise.pd.declaration.enums.PushEnums;
import com.jn.enterprise.pd.declaration.model.DeclarationNoticePushParams;
import com.jn.enterprise.pd.declaration.service.DeclarationNoticeService;
import com.jn.enterprise.pd.talent.enums.SortEnums;
import com.jn.news.vo.EmailVo;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.xxpay.common.util.JsonUtil;

import java.util.*;

/**
 * 申报中心公告管理业务实现层
 *
 * @author： wzy
 * @date： Created on 2019/4/10 20:09
 * @version： v1.0
 * @modified By:
 */
@Service
public class DeclarationNoticeServiceImpl implements DeclarationNoticeService {

    private static Logger logger = LoggerFactory.getLogger(DeclarationNoticeServiceImpl.class);

    @Autowired
    private TbPdDeclarationNoticeManageMapper tbPdDeclarationNoticeManageMapper;

    @Autowired
    private TbPdDeclarationNoticeRangeMapper tbPdDeclarationNoticeRangeMapper;

    @Autowired
    private TbPdDeclarationPushInformationManageMapper TbPdDeclarationPushInformationManageMapper;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private MessageSource messageSource;



    /**
     * 查询公告列表
     *
     * @param
     * @return
     */
    @Override
    public PaginationData<List<TbPdDeclarationNoticeManage>> selectByDeclarationNoticeList(String rangeId, String sortType,String titleName,int page,int rows) {
        Page<Object> objects = PageHelper.startPage(page, rows);
        TbPdDeclarationNoticeManageCriteria noticeCriteria = new TbPdDeclarationNoticeManageCriteria();
        if(sortType.equals(SortEnums.RELEASETIME_SORT.getCode())){
            noticeCriteria.setOrderByClause("is_roof_placement asc,created_time desc");
        }else if(sortType.equals(SortEnums.TIMENODE_SORT.getCode())){
            noticeCriteria.setOrderByClause("is_roof_placement asc,deadline desc");
        }else if(sortType.equals(SortEnums.HEAT_SORT.getCode())){
            noticeCriteria.setOrderByClause("is_roof_placement asc,browse_times desc");
        }
        TbPdDeclarationNoticeManageCriteria.Criteria criteria = noticeCriteria.createCriteria();
        Byte status = Byte.parseByte(DeclaratStatusEnums.RELEASE.getCode());
        criteria.andStatusEqualTo(status);
        if(StringUtils.isNotEmpty(rangeId)) {  criteria.andRangeIdEqualTo(rangeId);}
        if(StringUtils.isNotEmpty(titleName)) {  criteria.andTitleNameLike('%'+titleName+'%');}
        List<TbPdDeclarationNoticeManage> list = tbPdDeclarationNoticeManageMapper.selectByExample(noticeCriteria);
        for (TbPdDeclarationNoticeManage tb: list) {tb.setAnnouncementContent("");}
        return new PaginationData(list, objects.getTotal());
    }

    @Override
    public TbPdDeclarationNoticeManage selectByTalentNotice(String id) {
        return tbPdDeclarationNoticeManageMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询公告所属类型列表
     *
     * @param
     * @return
     */
    @Override
    public List<TbPdDeclarationNoticeRange> selectByNoticeRangeList() {
        TbPdDeclarationNoticeRangeCriteria rangeCriteria = new TbPdDeclarationNoticeRangeCriteria();
        List<TbPdDeclarationNoticeRange> selectByNoticeRangeList = tbPdDeclarationNoticeRangeMapper.selectByExample(rangeCriteria);
        return selectByNoticeRangeList;
    }

    /**
     * 用户点击查看一次公告，访问量加 1
     *
     * @param id
     * @return
     */
    @Override
    public void updateTrafficVolume(String id) {
        TbPdDeclarationNoticeManage noticeManage = new TbPdDeclarationNoticeManage();
        noticeManage = tbPdDeclarationNoticeManageMapper.selectByPrimaryKey(id);
        int trafficVolume = noticeManage.getBrowseTimes() + 1;
        noticeManage.setBrowseTimes(trafficVolume);
        tbPdDeclarationNoticeManageMapper.updateByPrimaryKey(noticeManage);
        logger.info("[申报中心公告访问量] 访问量更新成功，公告id:{}", id);
    }

    @Override
    @ServiceLog(doAction = "公告推送")
    public Result noticePush(DeclarationNoticePushParams declarationNoticePushParams,User user2) {
        logger.info("[公告推送] 入參declarationNoticePushParams:{}", JsonUtil.object2Json(declarationNoticePushParams));
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>(declarationNoticePushParams.getPushMode());
        list.addAll(set);
        /**存储企业异常信息组合*/
        List<String> entError = new ArrayList<>();
        /**存储用户异常信息组合*/
        List<String> userError = new ArrayList<>();
        /**存储用户手机号信息组合*/
        List<String> userPhone = new ArrayList<>();
        /**存储用户邮箱信息组合*/
        List<String> userEmail = new ArrayList<>();
        /**存储推送公告ID信息组合*/
        List<String> pushNotileId = new ArrayList<>();
        /**存储公告标题信息组合*/
        List<String> notileName = new ArrayList<>();
        Result<User> user1 = null;
        /**1.通过企业ID查询企业信息*/
        for (int i = 0; i < declarationNoticePushParams.getEntId().size(); i++) {
            logger.info("【公告推送】调用查询企业信息接口getCompanyDetailByAccountOrId入參【{}】",JsonUtil.object2Json(declarationNoticePushParams.getEntId().get(i)));
            ServiceCompany serviceCompany = companyService.getCompanyDetailByAccountOrId(declarationNoticePushParams.getEntId().get(i).toString());
            logger.info("【公告推送】调用查询企业信息接口getCompanyDetailByAccountOrId返回参数【{}】",JsonUtil.object2Json(serviceCompany));
            if (serviceCompany != null && StringUtils.isNotBlank(serviceCompany.getComAdmin())) {
                /**2.通过企业管理员查询用户信息；*/
                User user = new User();
                user.setAccount(serviceCompany.getComAdmin());
                logger.info("【公告推送】调用查询用户信息接口getUser,获取用户信息入參【{}】", JsonUtil.object2Json(user));
                user1 = systemClient.getUser(user);
                logger.info("【公告推送】调用查询用户信息接口getUse,获取用户信息返回结果【{}】", JsonUtil.object2Json(user1));
                if (user1 != null && user1.getData() != null) {
                    /**通过推送公告ID查询公告信息*/
                    TbPdDeclarationNoticeManageCriteria noticeCriteria = new TbPdDeclarationNoticeManageCriteria();
                    TbPdDeclarationNoticeManageCriteria.Criteria criteria = noticeCriteria.createCriteria();
                    criteria.andIdIn(declarationNoticePushParams.getNoticeId());
                    List<TbPdDeclarationNoticeManage> lists = tbPdDeclarationNoticeManageMapper.selectByExample(noticeCriteria);
                    for (TbPdDeclarationNoticeManage tb: lists) {
                        TbPdDeclarationPushInformationManage ma = new TbPdDeclarationPushInformationManage();
                        ma.setId(UUID.randomUUID().toString().replaceAll("-",""));
                        ma.setPushTitle(tb.getTitleName());
                        ma.setPushContent(tb.getTitleName());
                        ma.setReceiveEnterpriseId(serviceCompany.getId());
                        ma.setReceiveEnterprise(serviceCompany.getComName());
                        ma.setReceivePerson(user1.getData().getName());
                        if(user1 != null && user1.getData().getPhone() != null){
                            ma.setReceivePhone(user1.getData().getPhone());
                            /**将用户手机号添加到用户手机号组合中，用于批量发送短信*/
                            userPhone.add(user1.getData().getPhone());
                        }
                        if(user1 != null && user1.getData().getName() != null){
                            ma.setPushPerson(user1.getData().getName());
                        }
                        ma.setPushTime(new Date());
                        ma.setPushSource(Byte.parseByte("1"));
                        ma.setRecordStatus(Byte.parseByte(PdStatusEnums.EFFECTIVE.getCode()));
                        if(user2 != null && user2.getAccount() != null){
                            ma.setCreatorAccount(user2.getAccount());
                        }
                        ma.setCreatedTime(new Date());
                        ma.setPushId(tb.getId());
                        logger.info("【公告推送】插入推送信息表入參【{}】", JsonUtil.object2Json(ma));
                        int num = TbPdDeclarationPushInformationManageMapper.insertSelective(ma);
                        logger.info("【公告推送】插入推送信息表返回结果【{}】", JsonUtil.object2Json(num));
                        if(user1 != null && user1.getData().getEmail() != null){
                            /**将用户邮箱添加到用户邮箱组合中，用于批量发送邮件*/
                            userEmail.add(user1.getData().getEmail());
                        }
                        /**将公告标题添加到公告标题组合中，用于批量发送短信邮件等*/
                        notileName.add(tb.getTitleName());
                        pushNotileId.add(ma.getId());
                    }
                }
            }
            /**因需要一个一个记录是否推送成功，不能多个号码一起发送，判断是否包含短信推送*/
            if (list.contains(PushEnums.PUSH_SMS.getCode()) && (user1 != null && user1.getData().getPhone() != null)) {
                logger.info("【公告推送】短信发送参数：接收号码：{},短信内容：{}", JsonUtil.object2Json(user1.getData().getPhone()), JsonUtil.object2Json(notileName));
                boolean b = sendPaymentNotice(declarationNoticePushParams.getSmsTemplateId(), new String[]{user1.getData().getPhone()}, new String[]{String.valueOf(notileName)});
                if(b){
                    for (int j = 0; j < pushNotileId.size(); j++) {
                        TbPdDeclarationPushInformationManage manage = new TbPdDeclarationPushInformationManage();
                        manage.setId(pushNotileId.get(i));
                        manage.setPushSms("1");
                        TbPdDeclarationPushInformationManageMapper.updateByPrimaryKey(manage);
                    }
                }else {
                    for (int j = 0; j < pushNotileId.size(); j++) {
                        TbPdDeclarationPushInformationManage manage = new TbPdDeclarationPushInformationManage();
                        manage.setId(pushNotileId.get(i));
                        manage.setPushSms("2");
                        TbPdDeclarationPushInformationManageMapper.updateByPrimaryKey(manage);
                    }
                }
            }
            /**邮件推送*/
            if (list.contains(PushEnums.PUSH_EMAIL.getCode()) && (user1 != null && user1.getData().getEmail() != null)) {
                logger.info("【公告推送】邮件发送参数：接收邮箱：{},邮件标题：{}，邮件内容：{}", JsonUtil.object2Json(user1.getData().getEmail()),"申报中心公告推送" ,JsonUtil.object2Json(notileName));
                boolean b = sendPaymentEmail(user1.getData().getEmail(), "申报中心公告推送", "【白下高新区发布公告啦】公告标题："+JsonUtil.object2Json(notileName));
                if(b){
                    for (int j = 0; j < pushNotileId.size(); j++) {
                        TbPdDeclarationPushInformationManage manage = new TbPdDeclarationPushInformationManage();
                        manage.setId(pushNotileId.get(i));
                        manage.setPushEmail("1");
                        TbPdDeclarationPushInformationManageMapper.updateByPrimaryKeySelective(manage);
                    }
                }else{
                    for (int j = 0; j < pushNotileId.size(); j++) {
                        TbPdDeclarationPushInformationManage manage = new TbPdDeclarationPushInformationManage();
                        manage.setId(pushNotileId.get(i));
                        manage.setPushEmail("2");
                        TbPdDeclarationPushInformationManageMapper.updateByPrimaryKeySelective(manage);
                    }
                }
            }
        }
        return new Result();
    }

    /**通知提醒（短信，微信，APP，邮箱）*/
    @ServiceLog(doAction = "短信通知提醒")
    public boolean sendPaymentNotice(String templateId ,String[] phone,String[] message){
        logger.info("【公告推送】进入发送短信通知提醒方法");
        SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
        smsTemplateVo.setTemplateId(templateId);
        smsTemplateVo.setMobiles(phone);
        smsTemplateVo.setContents(message);
        logger.info("【公告推送】短信发送参数：接收号码：{},短信内容：{}", phone, message);
        boolean sendStatus = messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
        if (sendStatus) {
            logger.info("【公告推送】发送短信成功");
        } else {
            logger.error("【公告推送】发送短信失败");
        }
        return sendStatus;
    }

    @ServiceLog(doAction = "邮件通知提醒")
    public boolean sendPaymentEmail(String email ,String emailSubject,String emailContent){
        logger.info("【公告推送】进入发送邮件通知提醒方法");
        EmailVo emailVo = new EmailVo();
        emailVo.setEmail(email);
        emailVo.setEmailSubject(emailSubject);
        emailVo.setEmailContent(emailContent);
        logger.info("【公告推送】邮件发送参数：接收邮箱：{},邮件标题：{}，邮件内容：{}", email, emailSubject,emailContent);
        boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
        if (sendStatus) {
            logger.info("【公告推送】发送邮件成功");
        } else {
            logger.error("【公告推送】发送邮件失败");
        }
        return sendStatus;
    }
}
