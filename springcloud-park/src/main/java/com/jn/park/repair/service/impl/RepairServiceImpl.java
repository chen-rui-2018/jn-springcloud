package com.jn.park.repair.service.impl;

import com.alibaba.fastjson.JSON;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.CallOtherSwaggerUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.enums.PropertyExceptionEnum;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.park.repair.dao.RepairMapper;
import com.jn.park.repair.dao.TbPmRepairMapper;
import com.jn.park.repair.entity.TbPmRepair;
import com.jn.park.repair.enums.PaymentBillEnum;
import com.jn.park.repair.model.Repair;
import com.jn.park.repair.service.RepairService;
import com.jn.pay.api.PayClient;
import com.jn.pay.model.PayBill;
import com.jn.pay.model.PayBillParams;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.system.log.annotation.ServiceLog;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.xxpay.common.util.JsonUtil;

import java.util.*;


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

    @Autowired
    private RepairMapper repairMapper;

    /**
     * 自动执行ibps处理节点任务
     * @param payCallBackNotify 请求id
     */
    @Override
    @ServiceLog(doAction = "物业服务-创建报修缴费单,支付成功回调")

    public Result automaticApprovalTaskByTaskId(PayCallBackNotify  payCallBackNotify) {

        String billId=payCallBackNotify.getBillId();
        PayBillParams payBillParams=new PayBillParams();
        payBillParams.setBillId(billId);
        PayBill PayBillDetails= payClient.getBillBasicInfo(billId);
        if(PayBillDetails!=null){
            String paymentState=PayBillDetails.getPaymentState();
            logger.info("物业服务-创建报修缴费单回调,billId:{},paymentState:{}",billId,paymentState);
            //账单已支付，执行自动审核跳转节点
            if(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode().equals(paymentState)){
                //更新报修单支付状态
                TbPmRepair tbPmRepair=new TbPmRepair();
                tbPmRepair.setId(billId);
                tbPmRepair.setIsPay(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode());
                tbPmRepairMapper.updateByPrimaryKeySelective(tbPmRepair);
                logger.info("物业服务-创建报修缴费单,支付成功回调,billId:{}",billId);
                Result result= this.completeTask(billId);
                return  result;
            }

            logger.info("物业服务-创建报修缴费单回调,该缴费单未支付，不能修改报修单状态,billId:{},paymentState:{}",billId);
            throw new JnSpringCloudException(PropertyExceptionEnum.BILL_ORDER_IS_NOT_PAY);
        }
        logger.info("物业服务-创建报修缴费单回调,查询缴费单失败,billId:{},paymentState:{}",billId);
        throw new JnSpringCloudException(PropertyExceptionEnum.GET_PAY_BILL_DETAIL_FAIL);
    }

    /**
     * 审批 企业报修流程-企业缴费 任务
     * @param repairId
     */
    @ServiceLog(doAction ="审批 企业报修流程-企业缴费 任务" )
    public Result completeTask(String repairId){
        Repair tbPmRepairDb=repairMapper.selectRepairById(repairId);

        JSONObject jsonObject = new JSONObject();
        List list1 = new ArrayList<>();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("key","Q^PROC_INST_ID_^SL");
        jsonObject1.put("value",tbPmRepairDb.getFlowInstId());
        list1.add(jsonObject1);
        jsonObject.put("parameters", list1);


        logger.info("调用ibps 查询发起人的待办任务,请求参数{}",jsonObject);

        JSONObject result=CallOtherSwaggerUtils.request(tbPmRepairDb.getCreatorAccount(),"/api/webapi/bpmService/myTasks", HttpMethod.POST,jsonObject.toJSONString());
        logger.info("调用ibps 查询发起人的待办任务,返回参数{}",result);
        if(result==null||!StringUtils.equals(String.valueOf(result.get("state")),"200")){
            logger.info("查询发起人的待办任务失败，失败原因：{}",result.get("message"));
            throw new JnSpringCloudException(new Result("-1","查询发起人的待办任务失败，原因："+result.get("message")));
        }
        logger.info("查询发起人的待办任务成功");
        Object dataResult=((HashMap)result.get("data")).get("dataResult");
        if(dataResult==null){
            logger.info("没有待办任务");
            throw new JnSpringCloudException(PropertyExceptionEnum.NO_TO_DO_TASKS);
        }
        List<HashMap<String,String>>dataResultList=(List<HashMap<String,String>>)dataResult;
        if(dataResultList.size()!=1){
            logger.info("待办任务不唯一,待办数量:{}",dataResultList);
            throw new JnSpringCloudException(PropertyExceptionEnum.COMPLETE_TASK_NUMBER_IS_NOT_UNIQUE);
        }
        String taskId=dataResultList.get(0).get("taskId");
        Result resultData=this.complete(tbPmRepairDb.getCreatorAccount(),taskId,"agree",JsonUtil.object2Json(tbPmRepairDb));
        return resultData;
    }

    /**
     * 处理任务
     * @param taskId
     * @param actionName
     */
    @ServiceLog(doAction = "处理任务")
    private Result complete(String userAccount,String taskId,String actionName,String data){
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("taskId",taskId);
        map.add("actionName",actionName);
        //流程动态参数
        Map procVars=new HashMap();
        procVars.put("approval_action","agree");
        map.add("procVars",JsonUtil.object2Json(procVars) );
        //流程表单数据
        map.add("data",data);
        
        logger.info("调用ibps 处理任务 接口,请求参数{}",map);
        JSONObject result=CallOtherSwaggerUtils.request(userAccount,"/api/webapi/bpmService/complete", HttpMethod.POST,map);
        logger.info("调用ibps 处理任务 接口,返回参数{}",result);
        if(!StringUtils.equals(String.valueOf(result.get("state")),"200")){
            logger.info("处理任务失败，失败原因：{}",result.get("message"));
            throw new JnSpringCloudException(new Result("-1","处理任务失败，原因："+result.get("message")));
        }
        Result resultData=new Result();
        resultData.setData(result.get("data"));
        logger.info("处理任务成功");
        return resultData;
    }

    /**
     * 创建报修缴费单
     * @param payBillCreateParamVo
     */
    @Override
    public Result generateBill(PayBillCreateParamVo payBillCreateParamVo) {
        logger.info("物业服务-创建报修缴费单,billId:{}",payBillCreateParamVo.getBillId());
        Result result=payClient.billCreate(payBillCreateParamVo);
        return result;

    }

}
