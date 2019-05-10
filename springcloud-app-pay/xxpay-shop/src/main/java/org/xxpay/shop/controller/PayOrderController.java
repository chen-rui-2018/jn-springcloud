package org.xxpay.shop.controller;

import com.jn.common.model.Result;
import com.jn.pay.model.PayOrderReq;
import com.jn.pay.model.alipay.AlipayMobilePayRsp;
import com.jn.pay.model.alipay.AlipayPcPayRsp;
import com.jn.pay.utils.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xxpay.common.util.DateUtil;
import org.xxpay.common.util.MyLog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName：
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/8 14:45
 * @Version： v1.0
 * @Modified By:
 */
@Controller
@RequestMapping("/pay")
public class PayOrderController {

    /**
     * 日志插件
    * */
    private final static MyLog _log = MyLog.getLog(GoodsOrderController.class);

    /**
     * 支付回调通知地址
    * */
    static final String notifyUrl = "http://127.0.0.1:8081/pay/payNotify";

    private AtomicLong seq = new AtomicLong(0L);


    @RequestMapping("/toUrl.html")
    @ResponseBody
    public String toAliPay(HttpServletRequest request, String returnUrl) {
        System.out.println("请求SHOP==========================");
        System.out.println("url" + returnUrl);
        return returnUrl;
    }

    @RequestMapping("/toAliPay.html")
    @ResponseBody
    public String toAliPay(HttpServletRequest request, Long amount, String channelId,String payType) {
        String logPrefix = "【支付宝支付】";
        _log.info("====== 开始接收支付宝支付请求 ======");
        String goodsId = "G_0001";
        _log.info("{}接收参数:goodsId={},amount={},channelId={}", logPrefix, goodsId, amount, channelId);
        // 先插入订单数据
        Map params = new HashMap<>();
        params.put("channelId", channelId);
        params.put("payType", payType);


        Result result  = createPayOrder(amount,params);
        if("0000".equals(result.getCode())) {

            _log.info("下单请求返回,返回:{}", result);
        }
        if("ALIPAY_MOBILE".equalsIgnoreCase(channelId)) {
            AlipayMobilePayRsp  alipayMobilePayRsp= (AlipayMobilePayRsp)result.getData();
            return alipayMobilePayRsp.getPayParams();
        }
        AlipayPcPayRsp alipayPcPayRsp = (AlipayPcPayRsp)result.getData();
        return alipayPcPayRsp.getPayUrl();
    }

    //创建支付订单
    private Result createPayOrder(Long amount,Map<String, Object> params) {

        PayOrderReq payOrder = new PayOrderReq();
        payOrder.setMchId(params.get("mchId").toString());
        payOrder.setMchOrderNo(String.format("%s%s%06d", "G", DateUtil.getSeqString(), (int) seq.getAndIncrement() % 1000000));
        payOrder.setChannelId(params.get("channelId").toString());
        payOrder.setAmount(new Long(amount));
        payOrder.setSubject("商品测试标题");
        payOrder.setBody("阳的测试消费");
        payOrder.setNotifyUrl(notifyUrl);



        Result result = new Result();

        return result;
    }


    /**
     * 接收支付中心通知
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/payNotify")
    public void payNotify(HttpServletRequest request, HttpServletResponse response , @ModelAttribute PayOrder model) throws Exception {
        _log.info("====== 开始处理支付中心通知 ======");
        Map<String,Object> paramMap = request2payResponseMap(request, new String[]{
                "payOrderId","mchId","mchOrderNo","channelId","amount","currency","status", "clientIp",
                "device",  "subject", "channelOrderNo", "param1",
                "param2","paySuccTime","backType","sign"
        });

        _log.info("接收参数为{}",paramMap);

        String resStr = "success";
        String payOrderId = (String) paramMap.get("payOrderId");
        String mchOrderNo = (String) paramMap.get("mchOrderNo");

        ResponseUtils.outResult(response, resStr);
        _log.info("====== 支付中心通知处理完成 ======");
    }

    public Map<String, Object> request2payResponseMap(HttpServletRequest request, String[] paramArray) {
        Map<String, Object> responseMap = new HashMap<>();
        for (int i = 0;i < paramArray.length; i++) {
            String key = paramArray[i];
            String v = request.getParameter(key);
            if (v != null) {
                responseMap.put(key, v);
            }
        }
        return responseMap;
    }
}
