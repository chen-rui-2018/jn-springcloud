/*
 * Copyright 2015-2102 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jn.reconciliation.fileDown.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.jn.config.WxConfig;
import com.jn.reconciliation.fileDown.service.FileDown;
import com.jn.reconciliation.utils.FileUtils;
import com.jn.reconciliation.utils.https.HttpClientUtil;
import com.jn.reconciliation.utils.https.HttpResponse;
import com.jn.reconciliation.utils.wx.SignHelper;
import com.jn.reconciliation.utils.wx.WeiXinBaseUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * @ClassName：微信文件下载类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
@Service("WXFileDown")
public class WeiXinFileDown implements FileDown {


	private static final Log LOG = LogFactory.getLog(WeiXinFileDown.class);


	@Autowired
	private WxConfig wxConfig;

	// 对账单日期 格式：20140603
	private String bill_date;



	/**
	 * 文件下载类
	 *
	 * @param billDate
	 *            账单日
	 * 
	 */
	@Override
	public File fileDown(Date billDate) throws IOException {
		// 时间格式转换
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		bill_date = sdf.format(billDate);
		HttpResponse response = null;
		try {
			// 生成xml文件
			String xml = this.generateXml();
			LOG.info(xml);

			response = HttpClientUtil.httpsRequest(wxConfig.getUrl(), "POST", xml);

			// String dir = "/home/roncoo/app/accountcheck/billfile/weixin";

			File file = new File(wxConfig.getDir(), bill_date + "_" + wxConfig.getBillType().toLowerCase() + ".txt");
			int index = 1;

			// 判断文件是否已经存在
			while (file.exists()) {
				file = new File(wxConfig.getDir(), bill_date + "_" + wxConfig.getBillType().toLowerCase() + index + ".txt");
				index++;
			}
			return FileUtils.saveFile(response, file);

		} catch (IOException e) {
			throw new IOException("下载微信账单失败", e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				LOG.error("关闭下载账单的流/连接失败", e);
			}
		}
	}

	/**
	 * 根据微信接口要求，生成xml文件
	 * @return
	 */
	public String generateXml() {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("appid", wxConfig.getAppId());
		params.put("mch_id", wxConfig.getMchId());
		params.put("bill_date", bill_date);
		params.put("bill_type", wxConfig.getBillType());
		// 随机字符串，不长于32，调用随机数函数生成，将得到的值转换为字符串
		params.put("nonce_str", WeiXinBaseUtils.createNoncestr());

		// 过滤空值
		for (Iterator<Entry<String, String>> it = params.entrySet().iterator(); it.hasNext();) {
			Entry<String, String> entry = it.next();
			if (StringUtils.isEmpty(entry.getValue())) {
				it.remove();
			}
		}

		String sign = SignHelper.getSign(params, wxConfig.getPartnerKey());
		params.put("sign", sign.toUpperCase());
		return WeiXinBaseUtils.arrayToXml(params);
	}

}
