package org.xxpay.shop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.util.DateUtil;
import org.xxpay.common.util.MyLog;
import org.xxpay.common.util.PayDigestUtil;
import org.xxpay.common.util.XXPayUtil;
import org.xxpay.shop.dao.model.GoodsOrder;
import org.xxpay.shop.service.GoodsOrderService;
import org.xxpay.shop.util.Constant;
import org.xxpay.shop.util.OAuth2RequestParamHelper;
import org.xxpay.shop.util.vx.WxApi;
import org.xxpay.shop.util.vx.WxApiClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/refund")
public class RefundOrderController {

    private final static MyLog _log = MyLog.getLog(RefundOrderController.class);

    @Autowired
    private GoodsOrderService goodsOrderService;
    //商户号
    static final String mchId = "10000000";
    //支付单号
    String payOrderId = "P0020190424201933000000";
    //商户支付单号
    static final String  mchOrderNo = "G20190424201929000000";
    //商户退款单号
    static final String  mchRefundNo = "3312312";
    //渠道用户标识,如微信openId,支付宝账号
    static final String channelUser = "cldgug1107@sandbox.com";
    // 用户姓名
    static final String userName = "何阳";
    // 备注号
    static final String remarkInfo = "";




    // 加签key
    static final String reqKey = "123";
    // 验签key
    static final String resKey = "123";
    //static final String baseUrl = "http://api.xxpay.org/api";
    static final String baseUrl = "http://127.0.0.1:3010";

    static final String notifyUrl = "http://localhost:8081/refund/payNotify";
    private AtomicLong seq = new AtomicLong(0L);
    private final static String QR_PAY_URL = "http://shop.xxpay.org/goods/qrPay.html";
    static final String AppID = "wx077cb62e341f8a5c";
    static final String AppSecret = "e663ea068f3e4f952f143de1432a35c2";
    private final static String GetOpenIdURL = "http://shop.xxpay.org/goods/getOpenId";
    private final static String GetOpenIdURL2 = "http://shop.xxpay.org/goods/getOpenId2";


    @RequestMapping("/toAliPay.html")
    @ResponseBody
    public String toAliPay(HttpServletRequest request, Long amount, String channelId,String payOrderId,String payType) {
        String logPrefix = "【支付宝退款】";
        _log.info("====== 开始接收支付宝退款请求 ======");
        String goodsId = "G_0001";
        _log.info("{}接收参数:goodsId={},amount={},channelId={}", logPrefix, goodsId, amount, channelId);
        // 先插入订单数据
        Map params = new HashMap<>();
        params.put("channelId", channelId);
        params.put("payType", payType);

        // 下单
        GoodsOrder goodsOrder = createGoodsOrder(goodsId, amount);
        this.payOrderId = payOrderId;
        Map<String, String> orderMap = createPayOrder(goodsOrder, params);
        if(orderMap != null && "success".equalsIgnoreCase(orderMap.get("resCode"))) {
            payOrderId = orderMap.get("payOrderId");
            GoodsOrder go = new GoodsOrder();
            go.setGoodsOrderId(goodsOrder.getGoodsOrderId());
            go.setPayOrderId(payOrderId);
            go.setChannelId(channelId);
            int ret = goodsOrderService.update(go);
            _log.info("修改商品订单,返回:{}", ret);
        }
        if(PayConstant.PAY_CHANNEL_ALIPAY_MOBILE.equalsIgnoreCase(channelId)) return orderMap.get("payParams");
        return orderMap.get("payUrl");
    }





    private Map createPayOrder(GoodsOrder goodsOrder, Map<String, Object> params) {
        JSONObject extra = new JSONObject();
        JSONObject paramMap = new JSONObject();
        //缴费类型
        paramMap.put("payType", params.get("payType"));
        //paramMap.put("mchId", mchId);                       // 商户ID
        paramMap.put("payOrderId", payOrderId);            // 支付订单号
        paramMap.put("mchOrderNo", mchOrderNo);            //商户支付单号
        paramMap.put("mchRefundNo", UUID.randomUUID().toString().substring(0,20));         // 商户退款单号
        paramMap.put("channelId", params.get("channelId"));    // 支付渠道ID, WX_NATIVE,ALIPAY_WAP
        paramMap.put("amount", goodsOrder.getAmount());        // 退款金额,单位分
        paramMap.put("clientIp", "114.112.124.236");        // 用户地址,IP或手机号
        paramMap.put("device", "WEB");                      // 设备
        paramMap.put("extra", extra.toJSONString());  // 附加参数
        paramMap.put("param1", "");                         // 扩展参数1
        paramMap.put("param2", "");                         // 扩展参数2
        paramMap.put("notifyUrl", notifyUrl);         // 回调URL
        paramMap.put("channelUser", channelUser);         // 渠道用户标识,如微信openId,支付宝账号
        paramMap.put("userName", userName);         // 用户姓名
        paramMap.put("remarkInfo", remarkInfo);         // 备注号
        String reqSign = PayDigestUtil.getSign(paramMap, reqKey);
        paramMap.put("sign", reqSign);   // 签名

        String reqData = "params=" + paramMap.toJSONString();
        System.out.println("请求支付中心退款下单接口,请求数据:" + reqData);
        String url = baseUrl + "/refund/create_order?";
        String result = XXPayUtil.call4Post(url + reqData);
        System.out.println("请求支付中心退款下单接口,响应数据:" + result);
        Map retMap = JSON.parseObject(result);
        if("SUCCESS".equals(retMap.get("retCode"))) {
            // 验签
            String checkSign = PayDigestUtil.getSign(retMap, resKey, "sign", "payParams");
            String retSign = (String) retMap.get("sign");
            if(checkSign.equals(retSign)) {
                System.out.println("=========支付中心下单验签成功=========");
            }else {
                System.err.println("=========支付中心下单验签失败=========");
                return null;
            }
        }
        return retMap;
    }



    GoodsOrder createGoodsOrder(String goodsId, Long amount) {
        // 先插入订单数据
        String goodsOrderId =  String.format("%s%s%06d", "G", DateUtil.getSeqString(), (int) seq.getAndIncrement() % 1000000);
        GoodsOrder goodsOrder = new GoodsOrder();
        goodsOrder.setGoodsOrderId(goodsOrderId);
        goodsOrder.setGoodsId(goodsId);
        goodsOrder.setGoodsName("XXPAY捐助商品G_0001");
        goodsOrder.setAmount(amount);
        goodsOrder.setUserId("xxpay_000001");
        goodsOrder.setStatus(Constant.GOODS_ORDER_STATUS_INIT);
        int result = goodsOrderService.addGoodsOrder(goodsOrder);
        _log.info("插入商品订单,返回:{}", result);
        return goodsOrder;
    }

    /**
     * 获取code
     * @return
     */
    @RequestMapping("/getOpenId")
    public void getOpenId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        _log.info("进入获取用户openID页面");
        String redirectUrl = request.getParameter("redirectUrl");
        String code = request.getParameter("code");
        String openId = "";
        if(!StringUtils.isBlank(code)){//如果request中包括code，则是微信回调
            try {
                openId = WxApiClient.getOAuthOpenId(AppID, AppSecret, code);
                _log.info("调用微信返回openId={}", openId);
            } catch (Exception e) {
                _log.error(e, "调用微信查询openId异常");
            }
            if(redirectUrl.indexOf("?") > 0) {
                redirectUrl += "&openId=" + openId;
            }else {
                redirectUrl += "?openId=" + openId;
            }
            response.sendRedirect(redirectUrl);
        }else{//oauth获取code
            String redirectUrl4Vx = GetOpenIdURL + "?redirectUrl=" + redirectUrl;
            String state = OAuth2RequestParamHelper.prepareState(request);
            String url = WxApi.getOAuthCodeUrl(AppID, redirectUrl4Vx, "snsapi_base", state);
            _log.info("跳转URL={}", url);
            response.sendRedirect(url);
        }
    }

    /**
     * 获取code
     * @return
     */
    @RequestMapping("/getOpenId2")
    public void getOpenId2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        _log.info("进入获取用户openID页面");
        String redirectUrl = request.getParameter("redirectUrl");
        String code = request.getParameter("code");
        String openId = "";
        if(!StringUtils.isBlank(code)){//如果request中包括code，则是微信回调
            try {
                openId = WxApiClient.getOAuthOpenId(AppID, AppSecret, code);
                _log.info("调用微信返回openId={}", openId);
            } catch (Exception e) {
                _log.error(e, "调用微信查询openId异常");
            }
            if(redirectUrl.indexOf("?") > 0) {
                redirectUrl += "&openId=" + openId;
            }else {
                redirectUrl += "?openId=" + openId;
            }
            response.sendRedirect(redirectUrl);
        }else{//oauth获取code
            //http://www.abc.com/xxx/get-weixin-code.html?appid=XXXX&scope=snsapi_base&state=hello-world&redirect_uri=http%3A%2F%2Fwww.xyz.com%2Fhello-world.html
            String redirectUrl4Vx = GetOpenIdURL2 + "?redirectUrl=" + redirectUrl;
            String url = String.format("http://www.xiaoshuding.com/get-weixin-code.html?appid=%s&scope=snsapi_base&state=hello-world&redirect_uri=%s", AppID, WxApi.urlEnodeUTF8(redirectUrl4Vx));
            _log.info("跳转URL={}", url);
            response.sendRedirect(url);
        }
    }

    /**
     * 接收退款通知
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/payNotify")
    public void  payNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        _log.info("====== 开始处理退款通知 ======");

        _log.info("====== 退款通知处理完成 ======");

        outResult(response,"success");
    }

    void outResult(HttpServletResponse response, String content) {
        response.setContentType("text/html");
        PrintWriter pw;
        try {
            pw = response.getWriter();
            pw.print(content);
            _log.error("response xxpay complete.");
        } catch (IOException e) {
            _log.error(e, "response xxpay write exception.");
        }
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

    public boolean verifyPayResponse(Map<String,Object> map) {
        String mchId = (String) map.get("mchId");
        String payOrderId = (String) map.get("payOrderId");
        String mchOrderNo = (String) map.get("mchOrderNo");
        String amount = (String) map.get("amount");
        String sign = (String) map.get("sign");

        if (StringUtils.isEmpty(mchId)) {
            _log.warn("Params error. mchId={}", mchId);
            return false;
        }
        if (StringUtils.isEmpty(payOrderId)) {
            _log.warn("Params error. payOrderId={}", payOrderId);
            return false;
        }
        if (StringUtils.isEmpty(amount) || !NumberUtils.isNumber(amount)) {
            _log.warn("Params error. amount={}", amount);
            return false;
        }
        if (StringUtils.isEmpty(sign)) {
            _log.warn("Params error. sign={}", sign);
            return false;
        }

        // 验证签名
        if (!verifySign(map)) {
            _log.warn("verify params sign failed. payOrderId={}", payOrderId);
            return false;
        }

        // 根据payOrderId查询业务订单,验证订单是否存在
        GoodsOrder goodsOrder = goodsOrderService.getGoodsOrder(mchOrderNo);
        if(goodsOrder == null) {
            _log.warn("业务订单不存在,payOrderId={},mchOrderNo={}", payOrderId, mchOrderNo);
            return false;
        }
        // 核对金额
        if(goodsOrder.getAmount() != Long.parseLong(amount)) {
            _log.warn("支付金额不一致,dbPayPrice={},payPrice={}", goodsOrder.getAmount(), amount);
            return false;
        }
        return true;
    }

    public boolean verifySign(Map<String, Object> map) {
        String mchId = (String) map.get("mchId");
        if(!this.mchId.equals(mchId)) return false;
        String localSign = PayDigestUtil.getSign(map, resKey, "sign");
        String sign = (String) map.get("sign");
        return localSign.equalsIgnoreCase(sign);
    }

    public static void main(String[] args) {
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("mchId","10000000");
        paramMap.put("payOrderId","P0020190428155543000004");

        String reqSign = PayDigestUtil.getSign(paramMap, reqKey);
        System.out.println(reqSign);


       /* PayTask payTask = new PayTask(DemoActivity.this);
        payTask.pay("",true);*/
    }


}