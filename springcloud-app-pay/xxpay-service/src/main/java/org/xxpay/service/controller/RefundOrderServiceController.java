package org.xxpay.service.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xxpay.common.domain.BaseParam;
import org.xxpay.common.enumm.RetEnum;
import org.xxpay.common.util.*;
import org.xxpay.dal.dao.model.RefundOrder;
import org.xxpay.service.mq.Mq4RefundNotify;
import org.xxpay.service.service.RefundOrderService;

import java.util.Map;

/**
 * @Description: 退单订单接口
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@RestController
public class RefundOrderServiceController extends Notify4BasePay {

    private final MyLog _log = MyLog.getLog(RefundOrderServiceController.class);

    @Autowired
    private RefundOrderService refundOrderService;

    @Autowired
    private Mq4RefundNotify mq4RefundNotify;

    /**
     * 创建退款订单
     * @param jsonParam
    * */
    @RequestMapping(value = "/refund/create")
    public String createPayOrder(@RequestParam String jsonParam) {
        _log.info("接收创建退款订单请求,jsonParam={}", jsonParam);
        JSONObject retObj = new JSONObject();
        retObj.put("code", "0000");
        if(StringUtils.isBlank(jsonParam)) {
            retObj.put("code", "0001");
            retObj.put("msg", "缺少参数");
            return retObj.toJSONString();
        }
        try {
            RefundOrder refundOrder = JSON.parseObject(new String(MyBase64.decode(jsonParam)), RefundOrder.class);
            int result = refundOrderService.createRefundOrder(refundOrder);
            retObj.put("result", result);
        }catch (Exception e) {
            // 9999-系统错误
            retObj.put("code", "9999");
            retObj.put("msg", "系统错误");
            _log.error("创建退款订单失败：",e);
        }
        return retObj.toJSONString();
    }

    /**
     * 发送退款操作
     * @param
    * */
    @RequestMapping(value = "/refund/sendRefundNotify")
    public Map sendRefundNotify(@RequestParam String jsonParam) {
        BaseParam baseParam = JsonUtil.getObjectFromJson(new String(MyBase64.decode(jsonParam)), BaseParam.class);
        Map<String, Object> bizParamMap = baseParam.getBizParamMap();
        if (ObjectValidUtil.isInvalid(bizParamMap)) {
            _log.warn("发送退款订单处理失败, {}. jsonParam={}", RetEnum.RET_PARAM_NOT_FOUND.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_NOT_FOUND);
        }
        String msg = baseParam.isNullValue("msg") ? null : bizParamMap.get("msg").toString();
        if (ObjectValidUtil.isInvalid(msg)) {
            _log.warn("发送退款订单处理失败, {}. jsonParam={}", RetEnum.RET_PARAM_INVALID.getMessage(), jsonParam);
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_INVALID);
        }
        int result = 1;
        try {
            mq4RefundNotify.send(msg);
        }catch (Exception e) {
            _log.error(e, "");
            result = 0;
        }
        return RpcUtil.createBizResult(baseParam, result);
    }

}
