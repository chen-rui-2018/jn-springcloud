package com.jn.reconciliation.service.impl;

import com.jn.reconciliation.service.ReconciliationNoticeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationNoticeUser;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationNoticeUserCriteria;
import org.xxpay.dal.dao.mapper.generator.reconciliation.TbPayReconciliationNoticeUserMapper;

import java.util.List;


/**
 * @ClassName：对账通知service
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class ReconciliationNoticeUserServiceImpl implements ReconciliationNoticeUserService {

    @Autowired
    private TbPayReconciliationNoticeUserMapper tbPayReconciliationNoticeUserMapper;


    /**
     * 查询通知状态为有效的用户
     * */
    @Override
    public List<TbPayReconciliationNoticeUser> getEffectiveUserList() {
        TbPayReconciliationNoticeUserCriteria example = new TbPayReconciliationNoticeUserCriteria();
        example.createCriteria().andStatusEqualTo(PayConstant.RECONCILIATION_NOTICE_EFFECTIVE_STATUS_USER);
        return tbPayReconciliationNoticeUserMapper.selectByExample(example);
    }
}
