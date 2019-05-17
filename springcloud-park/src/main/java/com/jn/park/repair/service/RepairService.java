package com.jn.park.repair.service;

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
     * @param  jsonObject
     */
    void  automaticApprovalTaskByTaskId(JSONObject jsonObject);

    /**
     *
     * @param payBillCreateParamVo
     */
    void generateBill(PayBillCreateParamVo payBillCreateParamVo);

}
