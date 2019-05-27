package org.xxpay.service.channel.wechat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 14:40
 * 这里放置各种配置数据
 */
@RefreshScope
@Service
public class WxPayProperties {

	@Value("${cert.root.path}")
	private String certRootPath;

	@Value("${wx.notify_url}")
	private String notifyUrl;

	/**
	 * 手续费率(单位：%百分比)
	 * */
	@Value("${wx.pay_rate}")
	private Double pay_rate;

	public String getCertRootPath() {
		return certRootPath;
	}

	public void setCertRootPath(String certRootPath) {
		this.certRootPath = certRootPath;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public Double getPay_rate() {
		return pay_rate;
	}

	public void setPay_rate(Double pay_rate) {
		this.pay_rate = pay_rate;
	}
}
