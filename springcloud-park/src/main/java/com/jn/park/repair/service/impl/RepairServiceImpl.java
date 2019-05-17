package com.jn.park.repair.service.impl;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.repair.dao.TbPmRepairMapper;
import com.jn.park.repair.entity.TbPmRepair;
import com.jn.park.repair.enums.PaymentBillEnum;
import com.jn.park.repair.service.RepairService;
import com.jn.pay.api.PayClient;
import com.jn.pay.model.PayBillDetails;
import com.jn.pay.model.PayBillParams;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.pay.vo.PayBillVo;
import com.jn.system.log.annotation.ServiceLog;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物业服务-企业报修流程serviceimpl
 *
 * @author： yuanyy
 * @date： Created on 2019/5/11 19:09
 * @version： v1.0
 * @modified By:
 */
@Service
public class RepairServiceImpl implements RepairService {
    private static Logger logger = LoggerFactory.getLogger(RepairServiceImpl.class);


    @Autowired
    private PayClient payClient;

    @Autowired
    private TbPmRepairMapper tbPmRepairMapper;

    /**
     * 自动执行ibps处理节点任务
     * @param jsonObject 请求id
     */
    @Override
    @ServiceLog(doAction = "物业服务-创建报修缴费单,支付成功回调")

    public void automaticApprovalTaskByTaskId(JSONObject jsonObject) {

        String billId=(String) jsonObject.get("billId");
        //String paymentState=(String) jsonObject.get("paymentState");
        PayBillParams payBillParams=new PayBillParams();
        payBillParams.setBillId(billId);
        Result<PaginationData<List<PayBillVo>>> PayBillDetails= payClient.billQuery(payBillParams);
        if(PayBillDetails!=null&&PayBillDetails.getData()!=null&&PayBillDetails.getData().getRows().size()>0){
            List<PayBillVo> payBillVoList=PayBillDetails.getData().getRows();
            String paymentState=payBillVoList.get(0).getPaymentState();
            logger.info("物业服务-创建报修缴费单回调,billId:{},paymentState:{}",billId,paymentState);
            //账单已支付，执行自动审核跳转节点
            if(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode().equals(paymentState)){
                //更新报修单支付状态
                TbPmRepair tbPmRepair=new TbPmRepair();
                tbPmRepair.setId(billId);
                tbPmRepair.setIsPay(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode());
                tbPmRepairMapper.updateByPrimaryKeySelective(tbPmRepair);
                //todo 根据流程taskId执行自动审批节点
                logger.info("物业服务-创建报修缴费单,支付成功回调,billId:{}",billId);
            }
        }
    }

    /**
     * 创建报修缴费单
     * @param payBillCreateParamVo
     */
    @Override
    public void generateBill(PayBillCreateParamVo payBillCreateParamVo) {
        logger.info("物业服务-创建报修缴费单,billId:{}",payBillCreateParamVo.getBillId());
        payClient.billCreate(payBillCreateParamVo);
    }

}
