package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.enterprise.servicemarket.advisor.dao.TbServiceAdvisorMapper;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisor;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisorCriteria;
import com.jn.enterprise.servicemarket.advisor.service.AcceptOrgInvitationService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Author: yangph
 * @Date: 2019/2/25 15:02
 * @Version v1.0
 * @modified By:
 */
@Service
public class AcceptOrgInvitationServiceImpl  implements AcceptOrgInvitationService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AcceptOrgInvitationServiceImpl.class);

    @Autowired
    private TbServiceAdvisorMapper tbServiceAdvisorMapper;


    /**
     * 接受机构邀请
     * @param advisorAccount 专员账号
     */
    @ServiceLog(doAction = "接受机构邀请")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int acceptOrgInvitation(String advisorAccount) {
        //更新专员信息的审批状态为“待审批”
        //“1”：待审批
        String approvalStatus="1";
        return updateApprovalStatusByAccount(advisorAccount,approvalStatus);
    }


    /**
     * 拒绝机构邀请
     * @param advisorAccount  专员账号
     */
    @ServiceLog(doAction = "拒绝机构邀请")
    @Override
    public int refuseInvitation(String advisorAccount) {
        //更新专员信息的审批状态为“拒绝邀请”
        //“-1”：拒绝邀请
        String approvalStatus="-1";
        return updateApprovalStatusByAccount(advisorAccount,approvalStatus);
    }
    /**
     * 更新专员审批状态
     * @param advisorAccount  专员账号
     */
    @ServiceLog(doAction = "更新专员审批状态")
    private int updateApprovalStatusByAccount(String advisorAccount,String approvalStatus) {
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(advisorAccount);
        TbServiceAdvisor tbServiceAdvisor=new TbServiceAdvisor();
        tbServiceAdvisor.setApprovalStatus(approvalStatus);
        return tbServiceAdvisorMapper.updateByExampleSelective(tbServiceAdvisor, example);
    }
}
