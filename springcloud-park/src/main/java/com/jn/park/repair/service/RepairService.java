package com.jn.park.repair.service;

import com.jn.common.model.Result;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.pay.vo.PayBillCreateParamVo;
import org.json.simple.JSONObject;

/**
 * 物业服务-企业报修流程service
 *
 * @author： yuanyy
 * @date： Created on 2019/5/11 19:09
 * @version： v1.0
 * @modified By:
 */
public interface RepairService {

    /**
     * 物业服务-自动执行ibps处理节点任务
     * @param  payCallBackNotify
     */
    void  automaticApprovalTaskByTaskId(PayCallBackNotify  payCallBackNotify);

    /**
     *物业服务-创建缴费单
     * @param payBillCreateParamVo
     */
    Result generateBill(PayBillCreateParamVo payBillCreateParamVo);

}
