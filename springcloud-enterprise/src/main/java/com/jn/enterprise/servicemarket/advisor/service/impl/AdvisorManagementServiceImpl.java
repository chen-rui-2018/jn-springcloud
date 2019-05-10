package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.propaganda.enums.ApprovalStatusEnum;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceAdvisorMapper;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisor;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisorCriteria;
import com.jn.enterprise.servicemarket.advisor.enums.ApprovalTypeEnum;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementParam;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementShow;
import com.jn.enterprise.servicemarket.advisor.model.ApprovalParam;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorManagementService;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrg;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import com.jn.enterprise.servicemarket.org.model.UserRoleInfo;
import com.jn.enterprise.servicemarket.org.service.OrgColleagueService;
import com.jn.park.api.MessageClient;
import com.jn.park.message.model.addMessageModel;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserAffiliateInfo;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * 顾问管理
 * @Author: yangph
 * @Date: 2019/2/19 16:18
 * @Version v1.0
 * @modified By:
 */
@Service
public class AdvisorManagementServiceImpl implements AdvisorManagementService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorManagementServiceImpl.class);

    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;

    @Autowired
    private TbServiceAdvisorMapper tbServiceAdvisorMapper;

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private OrgColleagueService orgColleagueService;

    @Autowired
    private MessageClient messageClient;

    @Autowired
    private SystemClient systemClient;

    /**
     * 是否删除 0：删除  1：有效
     */
    private static final byte RECORD_STATUS=1;
    /**
     * 日期格式
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";


    /**
     * 邀请顾问
     * @param registerAccount   被邀请人手机号或邮箱
     * @param loginAccount      当前登录用户账号
     * @return
     */
    @Override
    @ServiceLog(doAction = "邀请顾问")
    @Transactional(rollbackFor = Exception.class)
    public int inviteAdvisor(String registerAccount,String loginAccount) {
        //判断当前登录用户是否为机构管理员
        judgeAccountIsOrgManage(loginAccount);
        //1.判断顾问表中是否已存在当前机构和顾问关联的数据（审核状态为非解除状态，非审批不通过状态）
        //通过机构账号从服务机构表获得机构编码和机构名称
        TbServiceOrg serviceOrgInfo = getServiceOrgInfo(loginAccount);
        if(serviceOrgInfo==null){
            logger.warn("当前账号{}在服务机构表中不存在",loginAccount);
            throw new JnSpringCloudException(AdvisorExceptionEnum.SERVICE_ORG_NOT_EXIST);
        }
        //审批状态为“解除（value="4"）”，“审批不通过（value="3"）”
        List<String>approvalStatus=new ArrayList<>(8);
        approvalStatus.add("3");
        approvalStatus.add("4");
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andOrgIdEqualTo(serviceOrgInfo.getOrgId())
                .andAdvisorAccountEqualTo(registerAccount)
                .andApprovalStatusNotIn(approvalStatus);
        List<TbServiceAdvisor> tbServiceAdvisorList = tbServiceAdvisorMapper.selectByExample(example);
        //不存在当前机构和顾问关联的数据（审核状态为非解除状态）
        if(tbServiceAdvisorList.isEmpty()){
            //2.往顾问信息表添加一条机构和顾问的信息
            int responseNum = insertServiceAdvisorInfo(registerAccount,loginAccount, serviceOrgInfo);
            //消息标题
            String messageTitle="机构["+serviceOrgInfo.getOrgName()+"]邀请信息";
            //消息内容
            String messageConnect="尊敬的"+registerAccount+"您好，"+serviceOrgInfo.getOrgName()+
                    "邀请您加入机构【机构编码：[orgId:"+serviceOrgInfo.getOrgId()+"],机构名称：[orgName:"+serviceOrgInfo.getOrgName()+
                    "],业务领域：[businessArea:"+serviceOrgInfo.getBusinessType()+"]】，成为机构顾问";
            //消息一级类别 （0：个人动态，1：企业空间）
            int oneSort=0;
            //消息二级类别（0：私人订单，1：信用动态，2：园区通知，3：消费汇总，4：收入汇总，5，付款通知，6：企业订单，7：信息发布动态，8：交费提醒，9：访客留言，10：数据上报提醒  11.机构邀请）
            int twoSort=11;
            //3.调用消息接口，往消息接口添加一条邀请信息
            addMessageModel addMessageModel = getAddMessageModel(registerAccount, loginAccount, messageTitle, messageConnect, oneSort, twoSort);
            Result<String> result = messageClient.addMessage(addMessageModel);
            if(GlobalConstants.SUCCESS_CODE.equals(result.getCode())){
                return responseNum;
            }else{
                logger.warn("机构邀请顾问调用消息接口失败");
                throw new JnSpringCloudException(AdvisorExceptionEnum.NETWORK_ANOMALY);
            }
        }else{
            //存在当前机构和顾问关联的数据（审核状态为非解除状态）
            logger.warn("当前被邀请的顾问[{}]已经被邀请，请不要重复邀请！！！",registerAccount);
            throw new JnSpringCloudException(AdvisorExceptionEnum.ADVISOR_IS_EXIT);
        }
    }

    /**
     * 封装消息信息
     * @param acceptAccount    消息接受人
     * @param sendAccount      消息发送人
     * @param messageTitle     消息标题
     * @param messageConnect   消息内容
     * @param oneSort          消息一级类别
     * @param twoSort          消息二级类别
     */
    @ServiceLog(doAction = "")
    private addMessageModel getAddMessageModel(String acceptAccount, String sendAccount, String messageTitle, String messageConnect, int oneSort, int twoSort) {
        addMessageModel addMessageModel=new addMessageModel();
        //消息id
        addMessageModel.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //消息标题
        addMessageModel.setMessageTitle(messageTitle);
        //消息内容
        addMessageModel.setMessageConnect(messageConnect);
        //消息接受人
        addMessageModel.setMessageRecipien(acceptAccount);
        //消息发送人
        addMessageModel.setMessageSender(sendAccount);
        //消息一级类别（0：个人动态，1：企业空间）
        addMessageModel.setMessageOneSort(oneSort);
        //消息二级类别（0：私人订单，1：信用动态，2：园区通知，3：消费汇总，4：收入汇总，5，付款通知，6：企业订单，7：信息发布动态，8：交费提醒，9：访客留言，10：数据上报提醒  11.机构邀请）
        addMessageModel.setMessageTowSort(twoSort);
        //创建者账号
        addMessageModel.setCreatorAccount(sendAccount);

        return addMessageModel;
    }

    /**
     * 判断登录用户是否为机构管理员
     * @param loginAccount  登录用户账号
     */
    @ServiceLog(doAction = "判断登录用户是否为机构管理员")
    private void judgeAccountIsOrgManage(String loginAccount) {
        List<String> accountList=new ArrayList<>(8);
        accountList.add(loginAccount);
        String roleName="机构管理员";
        List<UserRoleInfo> userRoleInfoList = orgColleagueService.getUserRoleInfoList(accountList, roleName);
        if(userRoleInfoList.isEmpty() || !StringUtils.equals(roleName, userRoleInfoList.get(0).getRoleName())){
            logger.warn("当前账号:[{}]不是{},不能邀请顾问",loginAccount,roleName);
            throw new JnSpringCloudException(AdvisorExceptionEnum.ACCOUNT_NOT_ORG_MANAGE);
        }
    }


    /**
     * 往顾问信息表添加顾问信息
     * @param registerAccount  被邀请顾问账号
     * @param loginAccount     登录用户
     * @param serviceOrgInfo
     * @return
     */
    @ServiceLog(doAction = "往顾问信息表添加顾问信息")
    private int insertServiceAdvisorInfo(String registerAccount,String loginAccount,TbServiceOrg serviceOrgInfo ) {
        TbServiceAdvisor tbServiceAdvisor=new TbServiceAdvisor();
        //主键id
        tbServiceAdvisor.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //机构id、机构名称
        tbServiceAdvisor.setOrgId(serviceOrgInfo.getOrgId());
        tbServiceAdvisor.setOrgName(serviceOrgInfo.getOrgName());
        //根据顾问账号获取顾问信息
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(registerAccount);
        if(userExtension==null ||userExtension.getData()==null){
            logger.warn("顾问邀请获取顾问[{}]信息失败",registerAccount);
            throw new JnSpringCloudException(AdvisorExceptionEnum.GET_ADVISOR_INFO_FAIL);
        }
        //顾问账号
        tbServiceAdvisor.setAdvisorAccount(userExtension.getData().getAccount());
        //顾问姓名
        tbServiceAdvisor.setAdvisorName(userExtension.getData().getName());
        //头像
        tbServiceAdvisor.setAvatar(userExtension.getData().getAvatar());
        //是否认证 0：未认证     1：已认证
        tbServiceAdvisor.setIsCertification("0");
        //审核状态  - 1：已拒绝    0：未反馈   1：待审批   2：审批通过  3：审批不通过  4：已解除
        tbServiceAdvisor.setApprovalStatus("0");
        //创建时间
        tbServiceAdvisor.setCreatedTime(DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd HH:mm:ss")));
        //创建人
        tbServiceAdvisor.setCreatorAccount(loginAccount);
        //记录状态 0标记删除，1正常
        tbServiceAdvisor.setRecordStatus((byte)1);
        return tbServiceAdvisorMapper.insertSelective(tbServiceAdvisor);
    }

    /**
     * 根据机构账号获取服务机构信息
     * @param orgAccount 机构账号
     */
    @ServiceLog(doAction = "根据机构账号获取服务机构信息")
    private TbServiceOrg getServiceOrgInfo(String orgAccount) {
        TbServiceOrgCriteria example=new TbServiceOrgCriteria();
        example.createCriteria().andOrgAccountEqualTo(orgAccount);
        List<TbServiceOrg> tbServiceOrgList = tbServiceOrgMapper.selectByExample(example);
        if(tbServiceOrgList.isEmpty()){
            return null;
        }else{
            return tbServiceOrgList.get(0);
        }
    }


    /**
     * 顾问管理
     * @param advisorManagementParam  顾问管理查询页面入参（顾问姓名，审批状态）
     * @return
     */
    @ServiceLog(doAction = "顾问管理")
    @Override
    public PaginationData getAdvisorManagementInfo(AdvisorManagementParam advisorManagementParam) {
        com.github.pagehelper.Page<Object> objects = null;
        boolean needPage=false;
        //需要分页标识
        String pageValue="1";
        if(pageValue.equals(advisorManagementParam.getNeedPage())){
            needPage=true;
        }
        //审批状态(- 1：已拒绝    0：未反馈   1：待审批   2：审批通过  3：审批不通过  4：已解除)
        //默认值为 1：待审批
        String approvalStatus="1";
        if(ApprovalTypeEnum.PENDING.getCode().equals(advisorManagementParam.getApprovalStatus())){
            //审批状态为空或审批状态为"待审批"   ignore
        }else if(ApprovalTypeEnum.APPROVAL_NOT_PASSED.getCode().equals(advisorManagementParam.getApprovalStatus())){
            //审批状态为"审批不通过"
            approvalStatus="3";
        }else if(ApprovalTypeEnum.NO_FEEDBACK.getCode().equals(advisorManagementParam.getApprovalStatus())){
            //审批状态为"未反馈"
            approvalStatus="0";
        }else if(ApprovalTypeEnum.REJECTED.getCode().equals(advisorManagementParam.getApprovalStatus())){
            //审批状态为"已拒绝"
            approvalStatus="-1";
        }else{
            logger.warn("顾问管理审批状态{}在系统中不存在", advisorManagementParam.getApprovalStatus());
            throw new JnSpringCloudException(AdvisorExceptionEnum.APPROVAL_STATUS_NOT_EXIST);
        }
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        //顾问姓名不为空，模糊查询顾问名称
        if(StringUtils.isNotBlank(advisorManagementParam.getAdvisorName())){
            example.createCriteria().andApprovalStatusEqualTo(approvalStatus)
                    .andAdvisorNameLike("%"+advisorManagementParam.getAdvisorName()+"%")
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        }else{
            example.createCriteria().andApprovalStatusEqualTo(approvalStatus)
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        }
        if(needPage){
            objects = PageHelper.startPage(advisorManagementParam.getPage(),
                    advisorManagementParam.getRows() == 0 ? 15 : advisorManagementParam.getRows(), true);
        }
        List<TbServiceAdvisor> tbServiceAdvisorList= tbServiceAdvisorMapper.selectByExample(example);
        List<AdvisorManagementShow>resultList=new ArrayList<>(16);
        for(TbServiceAdvisor advisor:tbServiceAdvisorList){
            if(ApprovalTypeEnum.PENDING.getCode().equals(advisor.getApprovalStatus())){
                //审批状态为"待审核"
                advisor.setApprovalStatus(ApprovalTypeEnum.PENDING.getMessage());
            }else if(ApprovalTypeEnum.APPROVAL_NOT_PASSED.getCode().equals(advisor.getApprovalStatus())){
                //审批状态为"审批不通过"
                advisor.setApprovalStatus(ApprovalTypeEnum.APPROVAL_NOT_PASSED.getMessage());
            }else if(ApprovalTypeEnum.NO_FEEDBACK.getCode().equals(advisorManagementParam.getApprovalStatus())){
                //审批状态为"未反馈"
                advisor.setApprovalStatus(ApprovalTypeEnum.NO_FEEDBACK.getMessage());
            }else if(ApprovalTypeEnum.REJECTED.getCode().equals(advisorManagementParam.getApprovalStatus())){
                //审批状态为"已拒绝"
                advisor.setApprovalStatus(ApprovalTypeEnum.REJECTED.getMessage());
            }
            AdvisorManagementShow advisorManagementShow=new AdvisorManagementShow();
            BeanUtils.copyProperties(advisor, advisorManagementShow);
            advisorManagementShow.setCreatedTime(DateUtils.formatDate(advisor.getCreatedTime(),PATTERN));
            resultList.add(advisorManagementShow);
        }
        return new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 审批顾问填写信息
     * @param approvalParam  审批顾问信息入参(顾问账号，审批结果，审批说明)
     */
    @ServiceLog(doAction = "审批顾问填写信息")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int approvalAdvisorInfo(ApprovalParam approvalParam) {
        //根据顾问账号判断待审批状态的顾问在系统中是否存在
        long result = countAdvisorByApprovalStatus(approvalParam.getAdvisorAccount(), ApprovalStatusEnum.APPROVAL.getValue());
        //待审批用户信息存在判断标识
        int size=1;
        if(result!=size){
            logger.warn("当前顾问[{}]在系统中不存在或状态非“待审批”", approvalParam.getAdvisorAccount());
            throw new JnSpringCloudException(AdvisorExceptionEnum.PENDING_ADVISOR_NOT_EXIT);
        }
        //根据审批结果更新顾问信息审批状态
        if(ApprovalTypeEnum.APPROVED.getCode().equals(approvalParam.getApprovalResults())){
            //审批结果为“审批通过”，根据顾问账号更新审批状态信息
            int responseNum = updateApprovalStatus(approvalParam.getAdvisorAccount(), ApprovalStatusEnum.APPROVED.getValue(), approvalParam.getApprovalDesc());
            //更新顾问的所属机构id和机构名称
            TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
            example.createCriteria().andAdvisorAccountEqualTo(approvalParam.getAdvisorAccount())
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            List<TbServiceAdvisor> tbServiceAdvisorList = tbServiceAdvisorMapper.selectByExample(example);
            UserAffiliateInfo userAffiliateInfo=new UserAffiliateInfo();
            List accountList=new ArrayList();
            accountList.add(approvalParam.getAdvisorAccount());
            userAffiliateInfo.setAccountList(accountList);
            userAffiliateInfo.setAffiliateCode(tbServiceAdvisorList.get(0).getOrgId());
            userAffiliateInfo.setAffiliateName(tbServiceAdvisorList.get(0).getOrgName());
            Result resultData = userExtensionClient.updateAffiliateInfo(userAffiliateInfo);
            if((Boolean)resultData.getData()){
                if(setAdvisorRole(approvalParam.getAdvisorAccount())){
                    return responseNum;
                }else{
                    logger.warn("审批顾问填写信息成功,更新用户角色为机构顾问失败");
                    throw new JnSpringCloudException(OrgExceptionEnum.NETWORK_ANOMALY);
                }
            }else{
                logger.warn("审批顾问填写信息成功，更新用户所属机构信息失败");
                throw new JnSpringCloudException(AdvisorExceptionEnum.NETWORK_ANOMALY);
            }
        }else if(ApprovalTypeEnum.APPROVAL_NOT_PASSED.getCode().equals(approvalParam.getApprovalResults())){
            //审批结果为“审批不通过”，根据顾问账号更新审批状态信息
            //审批不通过
            if(StringUtils.isBlank(approvalParam.getApprovalDesc())){
                logger.warn("审批结果为“审批不通过”时，审批说明不能为空");
                throw new JnSpringCloudException(AdvisorExceptionEnum.APPROVAL_DESC_NOT_NULL);
            }
            return updateApprovalStatus(approvalParam.getAdvisorAccount(),ApprovalStatusEnum.APPROVAL_NOT_PASSED.getValue(), approvalParam.getApprovalDesc());
        }else{
            logger.warn("审批顾问[{}]填写资料的审批状态值与系统不符", approvalParam.getAdvisorAccount());
            throw new JnSpringCloudException(AdvisorExceptionEnum.PENDING_ADVISOR_NOT_EXIT);
        }
    }

    /**
     * 把顾问账号的角色设置为机构账号
     * @param advisorAccount
     * @return
     */
    @ServiceLog(doAction = "把顾问账号的角色设置为机构账号")
    private Boolean setAdvisorRole(String advisorAccount) {
        //获取机构顾问角色id
        String roleName="机构顾问";
        Result<SysRole> sysRoleData = systemClient.getRoleByName(roleName);
        if(sysRoleData==null || sysRoleData.getData()==null){
            logger.warn("审批顾问填写信息,获取机构顾问角色id失败");
            throw new JnSpringCloudException(OrgExceptionEnum.NETWORK_ANOMALY);
        }
        //更新用户角色为机构顾问
        return orgColleagueService.updateOrgUserRole(advisorAccount, "", sysRoleData.getData().getId());
    }

    /**
     * 再次邀请
     * @param advisorAccount 顾问账号
     * @param loginAccount  当前登录用户账号
     * @return
     */
    @ServiceLog(doAction = "再次邀请")
    @Override
    public int inviteAgain(String advisorAccount,String loginAccount) {
        //判断登录用户是否为机构管理员
        judgeAccountIsOrgManage(loginAccount);
        //获取机构信息
        TbServiceOrg serviceOrgInfo = getServiceOrgInfo(loginAccount);
        if(serviceOrgInfo==null){
            logger.warn("当前账号{}在服务机构表中不存在",loginAccount);
            throw new JnSpringCloudException(AdvisorExceptionEnum.SERVICE_ORG_NOT_EXIST);
        }
        //判断顾问表中是否已存在当前机构和顾问关联的数据（状态为已拒绝（value="-1"））
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andOrgIdEqualTo(serviceOrgInfo.getOrgId())
                .andAdvisorAccountEqualTo(advisorAccount)
                .andApprovalStatusEqualTo("-1")
                .andRecordStatusEqualTo(RECORD_STATUS);
        long existNum = tbServiceAdvisorMapper.countByExample(example);
        //没有数据
        if(existNum==0){
            logger.warn("再次邀请的顾问：[{}]在系统中审批状态不是“已拒绝”，不能再次邀请",advisorAccount);
            throw new JnSpringCloudException(AdvisorExceptionEnum.ACCOUNT_STATUS_NOT_REJECTED);
        }
        //修改当前邀请顾问的审批状态为未反馈（value="0"）
        int responseNum = updateApprovalStatus(advisorAccount, "0", "");
        //3.todo:调用消息接口，向被邀顾问发送短信或邮件（顾问可通过信息中的链接直接跳转到接收机构邀请页面） yangph
        return responseNum;
    }

    /**
     * 修改顾问审批状态
     * @param advisorAccount  顾问账号
     * @param approvalStatus  审批状态
     * @param approvalDesc    审批说明
     */
     @ServiceLog(doAction = "修改顾问审批状态")
    private int updateApprovalStatus(String advisorAccount,String approvalStatus,String approvalDesc) {
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorAccount).andRecordStatusEqualTo(RECORD_STATUS);
        TbServiceAdvisor tbServiceAdvisor=new TbServiceAdvisor();
        tbServiceAdvisor.setApprovalStatus(approvalStatus);
        if(StringUtils.isNotBlank(approvalDesc)){
            tbServiceAdvisor.setApprovalDesc(approvalDesc);
        }else{
            //审批通过，没有审批说明，需清空审批不通过的审批说明
            tbServiceAdvisor.setApprovalDesc("");
        }
        return tbServiceAdvisorMapper.updateByExampleSelective(tbServiceAdvisor, example);
    }

    /**
     * 根据审批状态统计顾问信息条数
     * @param advisorAccount  顾问账号
     * @param approvalStatus  审批状态
     * @return
     */
    @ServiceLog(doAction = "根据审批状态统计顾问信息条数")
    private long countAdvisorByApprovalStatus(String advisorAccount,String approvalStatus) {
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorAccount)
                .andApprovalStatusEqualTo(approvalStatus);
        return tbServiceAdvisorMapper.countByExample(example);
    }


}
