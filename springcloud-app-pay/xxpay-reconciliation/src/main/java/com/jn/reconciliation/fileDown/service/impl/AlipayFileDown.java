
package com.jn.reconciliation.fileDown.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayDataDataserviceBillDownloadurlQueryModel;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.jn.common.util.StringUtils;
import com.jn.config.AlipayConfig;
import com.jn.reconciliation.fileDown.service.FileDown;
import com.jn.reconciliation.service.PayChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.common.util.MyLog;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationInterface;
import org.xxpay.dal.dao.model.PayChannel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName：支付宝账单下载
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
@Service("ALIPAYFileDown")
public class AlipayFileDown implements FileDown {

	private final MyLog logger = MyLog.getLog(AlipayFileDown.class);

	SimpleDateFormat billDateSdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private AlipayConfig alipayConfig;
	@Autowired
	private PayChannelService payChannelService;




	/**
	 * 文件下载类
	 * @parm reconciliationInter
	 * 				对账接口信息
	 * @param billDate
	 *            账单日
	 * 
	 */
	@Override
	public File fileDown(TbPayReconciliationInterface reconciliationInter, Date billDate) throws Exception {
		File file = null ;
		//账单日期
		String billDateStr = billDateSdf.format(billDate);

		/** step 1  加载参数 **/
		//加载支付宝配置参数
		PayChannel payChannel = payChannelService.selectPayChannel(reconciliationInter.getChannelId(),reconciliationInter.getMchId());
		alipayConfig.init(payChannel.getParam());

        //拼装文件存放路径(防止多个商户对账时解压在同一文件夹)
        //通过  账期 + appid方式生成文件夹
        StringBuilder filePathSb = new  StringBuilder();
        filePathSb.append(alipayConfig.getDir());
        filePathSb.append(billDateStr);
        filePathSb.append("_");
        filePathSb.append(alipayConfig.getAppId());
		File pathFile = new File(filePathSb.toString());
		int index = 1;
		// 判断文件夹是否已经存在，如果已经存在则加上下标
		while (pathFile.exists()) {
			pathFile = new File(filePathSb.toString() + "(" + index + ")");
			index++;
		}
		//创建文件夹
		pathFile.mkdir();


		//创建文件(文件夹路径 + alipay_bill_ +  "账期" + ".zip")
		StringBuilder fileSb = new  StringBuilder();
		fileSb.append(pathFile.getPath());
		fileSb.append("/alipay_bill_");
		fileSb.append(billDateStr);
		fileSb.append(".zip");
		file = new File(fileSb.toString());

		/** step 2  获取支付宝账单下载的URL **/
		String url = getAlipayBillUrl(alipayConfig,billDateStr);

		/** step 3  下载账单文件 **/
		if(StringUtils.isNotBlank(url)){
			file = getBillFile(url,file);
		}

		return file;
	}


	/**
	 * 获取支付宝账单下载的URL
	 * @parm alipayConfig
	 * 				支付宝配置信息
	 * @param billDate
	 *            账单日
	 *
	 * */
	String getAlipayBillUrl(AlipayConfig alipayConfig,String billDate){

		String downUrl  ;

		//支付宝客户端
		AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.getUrl(), alipayConfig.getAppId()
				, alipayConfig.getPrivateKey(), alipayConfig.getFormat(), alipayConfig.getCharset()
				, alipayConfig.getPublicKey(), alipayConfig.getSignType());

		AlipayDataDataserviceBillDownloadurlQueryRequest alipay_request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
		// 封装请求支付信息
		AlipayDataDataserviceBillDownloadurlQueryModel model = new AlipayDataDataserviceBillDownloadurlQueryModel();
		model.setBillDate(billDate);
		model.setBillType("trade");
		alipay_request.setBizModel(model);

		try {
			//通过alipayClient调用API，获得对应的response类
			AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(alipay_request);
			downUrl = response.getBillDownloadUrl();
			logger.info("账期 ：{}，获取支付宝账单下载的URL路径为：{} ",billDate,downUrl);
		} catch (AlipayApiException e) {
			logger.error("账期 ：{}，获取支付宝账单下载的URL路径失败 ",billDate,e);
			return null;
		}
		return downUrl;

	}


	/**
	 * 根据账单URL下载文件
	 * @parma urlStr   账单下载路径
	 * @param file 需要被写入的文件
	* */
	File getBillFile(String urlStr
			,File file
	){


		
		URL url = null;
		HttpURLConnection httpUrlConnection = null;
		InputStream fis = null;
		FileOutputStream fos = null;
		try {
			url = new URL(urlStr);
			httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5 * 1000);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setUseCaches(false);
			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.setRequestProperty("Charsert", "UTF-8");
			httpUrlConnection.connect();
			fis = httpUrlConnection.getInputStream();
			byte[] temp = new byte[1024];
			int b;
			fos = new FileOutputStream(file);
			while ((b = fis.read(temp)) != -1) {
				fos.write(temp, 0, b);
				fos.flush();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) {
					fis.close();
				}
				if(fos!=null) {
					fos.close();
				}
				if(httpUrlConnection!=null) {
					httpUrlConnection.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return file;
	}


}
