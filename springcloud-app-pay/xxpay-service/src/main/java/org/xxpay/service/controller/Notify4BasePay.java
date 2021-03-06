package org.xxpay.service.controller;

import com.alibaba.fastjson.JSONObject;
import com.jn.pay.model.PayOrderNotify;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.util.BeanToMap;
import org.xxpay.common.util.MyLog;
import org.xxpay.common.util.PayDigestUtil;
import org.xxpay.common.util.XXPayUtil;
import org.xxpay.dal.dao.mapper.MchNotifyMapper;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.dal.dao.model.MchNotify;
import org.xxpay.dal.dao.model.PayOrder;
import org.xxpay.service.mq.Mq4PayNotify;
import org.xxpay.service.service.MchInfoService;
import org.xxpay.service.service.MchNotifyService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 支付通知处理基类
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@Component
public class Notify4BasePay {

	private static final MyLog _log = MyLog.getLog(Notify4BasePay.class);

	@Autowired
	private Mq4PayNotify mq4PayNotify;

	@Autowired
	private MchInfoService mchInfoService;

	@Autowired
	private MchNotifyService mchNotifyService;

	@Autowired
	private MchNotifyMapper mchNotifyMapper;

	/**
	 * 创建响应URL
	 * @param payOrder
	 * @return
	 */
	public String createNotifyUrl(PayOrder payOrder, String backType) {
		String mchId = payOrder.getMchId();
		MchInfo mchInfo = mchInfoService.selectMchInfo(mchId);
		String resKey = mchInfo.getResKey();
		Map<String, Object> paramMap = new HashMap<>();
		// 支付订单号
		paramMap.put("payOrderId", payOrder.getPayOrderId() == null ? "" : payOrder.getPayOrderId());
		// 商户ID
		paramMap.put("mchId", payOrder.getMchId() == null ? "" : payOrder.getMchId());
		// 商户订单号
		paramMap.put("mchOrderNo", payOrder.getMchOrderNo() == null ? "" : payOrder.getMchOrderNo());
		// 渠道ID
		paramMap.put("channelId", payOrder.getChannelId() == null ? "" : payOrder.getChannelId());
		// 支付金额
		paramMap.put("amount", payOrder.getAmount() == null ? "" : payOrder.getAmount());
		// 货币类型
		paramMap.put("currency", payOrder.getCurrency() == null ? "" : payOrder.getCurrency());
		// 支付状态
		paramMap.put("status", payOrder.getStatus() == null ? "" : payOrder.getStatus());
		// 客户端IP
		paramMap.put("clientIp", payOrder.getClientIp()==null ? "" : payOrder.getClientIp());
		// 设备
		paramMap.put("device", payOrder.getDevice()==null ? "" : payOrder.getDevice());
		// 商品标题
		paramMap.put("subject", payOrder.getSubject()==null ? "" : payOrder.getSubject());
		// 渠道订单号
		paramMap.put("channelOrderNo", payOrder.getChannelOrderNo()==null ? "" : payOrder.getChannelOrderNo());
		// 扩展参数1
		paramMap.put("param1", payOrder.getParam1()==null ? "" : payOrder.getParam1());
		// 扩展参数2
		paramMap.put("param2", payOrder.getParam2()==null ? "" : payOrder.getParam2());
		// 支付成功时间
		paramMap.put("paySuccTime", payOrder.getPaySuccTime()==null ? "" : payOrder.getPaySuccTime());
		//通知类型
		paramMap.put("backType", backType==null ? "" : backType);
		// 先对原文签名
		String reqSign = PayDigestUtil.getSign(paramMap, resKey);
		// 签名
		paramMap.put("sign", reqSign);
		// 签名后再对有中文参数编码
		try {
			paramMap.put("device", URLEncoder.encode(payOrder.getDevice()==null ? "" : payOrder.getDevice(), PayConstant.RESP_UTF8));
			paramMap.put("subject", URLEncoder.encode(payOrder.getSubject()==null ? "" : payOrder.getSubject(), PayConstant.RESP_UTF8));
			paramMap.put("param1", URLEncoder.encode(payOrder.getParam1()==null ? "" : payOrder.getParam1(), PayConstant.RESP_UTF8));
			paramMap.put("param2", URLEncoder.encode(payOrder.getParam2()==null ? "" : payOrder.getParam2(), PayConstant.RESP_UTF8));
		}catch (UnsupportedEncodingException e) {
			_log.error("URL Encode exception.", e);
			return null;
		}
		String param = XXPayUtil.genUrlParams(paramMap);
		StringBuffer sb = new StringBuffer();
		sb.append(payOrder.getNotifyUrl()).append("?").append(param);
		return sb.toString();
	}

	/**
	 * 处理支付结果前台页面跳转
	 */
	public boolean doPage(PayOrder payOrder, HttpServletResponse response) {
		String redirectUrl = createNotifyUrl(payOrder, "1");
		_log.info("redirect to respUrl:"+redirectUrl);
		// 前台跳转业务系统
		try {
			response.sendRedirect(redirectUrl);
		} catch (IOException e) {
			_log.error("XxPay sendRedirect exception. respUrl="+redirectUrl, e);
			return false;
		}
		return true;
	}

	/**
	 * 处理支付结果后台服务器通知
	 * @param payOrder 支付订单对象
	 * @param isFirst  是否第一次通知
	 */
	public void doNotify(PayOrder payOrder,Boolean isFirst) {
		_log.info(">>>>>> PAY开始回调通知业务系统 <<<<<<");
		_log.info("请求参数 isFirst = {}  , payOrder = {} ",isFirst,payOrder.toString());
		// 发起后台通知业务系统
		JSONObject object = createNotifyInfo(payOrder,isFirst);
		try {
			mq4PayNotify.send(object.toJSONString());
		} catch (Exception e) {
			_log.error("payOrderId={},sendMessage error.", payOrder != null ? payOrder.getPayOrderId() : "", e);
			_log.info(">>>>>> PAY结束回调通知业务系统 <<<<<<");
		}
		_log.info(">>>>>> PAY回调通知业务系统完成 <<<<<<");
	}

	/**
	 * 创建通知商户
	 * 如果存在http方式回调 则不用springCloud方式
	 * @param payOrder 支付订单对象
	 * @param isFirst  是否第一次通知
	* */
	public JSONObject createNotifyInfo(PayOrder payOrder,Boolean isFirst) {
		//http回调通知地址
		String url = "";
		//springCloud 回调通知地址
		String serviceId  = "";
		String serviceUrl  = "";
		PayOrderNotify payOrderNotify = new PayOrderNotify();



		//如果存在http方式回调 则不用springCloud方式
		if(StringUtils.isNotBlank(payOrder.getNotifyUrl())){
			url = createNotifyUrl(payOrder, PayConstant.MCH_NOTICE_BACKSTAGE);
		}else{
			//springClound回调参数
			serviceId = payOrder.getServiceId();
			serviceUrl = payOrder.getServiceUrl();
			//把值赋予返回对象
			payOrder.setBackType(PayConstant.MCH_NOTICE_BACKSTAGE);
			BeanUtils.copyProperties(payOrder, payOrderNotify);
			//生成签名
			MchInfo mchInfo = mchInfoService.selectMchInfo(payOrderNotify.getMchId());
			String resKey = mchInfo.getResKey();
			String sign = PayDigestUtil.getSign(BeanToMap.toMap(payOrderNotify), resKey);
			payOrderNotify.setSign(sign);
		}

		if(isFirst) {
			int result = mchNotifyService.insertMchNotify(payOrder.getPayOrderId(), payOrder.getMchId(), payOrder.getMchOrderNo(), PayConstant.MCH_NOTIFY_TYPE_PAY, url);
			_log.info("增加支付商户通知记录,orderId={},result:{}", payOrder.getPayOrderId(), result);
		}
		int count = 0;
		if(!isFirst) {
			MchNotify mchNotify = mchNotifyMapper.selectByPrimaryKey(payOrder.getPayOrderId());
			if(mchNotify != null) {
				count = mchNotify.getNotifyCount();
			}
		}

		JSONObject object = new JSONObject();
		object.put("method", "GET");
		object.put("url", url);
		object.put("serviceId", serviceId);
		object.put("serviceUrl", serviceUrl);
		object.put("payOrderJson", JSONObject.toJSON(payOrderNotify));
		object.put("orderId", payOrder.getPayOrderId());
		object.put("count", count);
		object.put("createTime", System.currentTimeMillis());

		return object;
	}

	/**
	 * 计算手续费和实际收入
	 * @param  payOrder  支付信息对象
	 * @param  payRate   商户支付费率
	* */
	public PayOrder computationCost(PayOrder payOrder ,Double payRate){

		_log.info("支付单号为: {},商户支付费率：{}%  ===开始===计算手续费和实际收入",payOrder.getPayOrderId(),payRate);
		payOrder.setPayRate(payRate);

		//订单金额
		BigDecimal amount = new BigDecimal(payOrder.getAmount());

		//计算手续费
		BigDecimal platCost = amount.multiply(BigDecimal.valueOf(payRate)).divide(BigDecimal.valueOf(100), 0, BigDecimal.ROUND_HALF_UP);
		payOrder.setPlatCost(platCost.longValue());
		_log.info("订单总金额为：{},计算出手续费用:{}",payOrder.getAmount(),platCost.longValue());

		//商户实际收入
		Long realIncomeAmount = amount.subtract(platCost).longValue();
		payOrder.setRealIncomeAmount(realIncomeAmount);
		_log.info("计算出商户实际收入为：{}",realIncomeAmount);
		_log.info("===结束====计算手续费和实际收入");
		return payOrder;
	}
}
