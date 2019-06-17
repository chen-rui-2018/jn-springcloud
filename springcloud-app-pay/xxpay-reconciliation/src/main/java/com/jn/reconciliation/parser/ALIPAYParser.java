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
package com.jn.reconciliation.parser;

import com.jn.config.AlipayConfig;
import com.jn.reconciliation.enums.BatchStatusEnum;
import com.jn.reconciliation.fileDown.service.impl.AlipayFileDown;
import com.jn.reconciliation.vo.ReconciliationEntityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xxpay.common.util.MyLog;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationCheckBatch;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @ClassName：支付宝对账单解析器
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
@Component("ALIPAYParser")
public class ALIPAYParser implements ParserInterface {

	private final MyLog logger = MyLog.getLog(AlipayFileDown.class);


	@Autowired
	private AlipayConfig alipayConfig;


	/**
	 * 解析器的入口方法，每个解析器都必须有这个方法
	 * 
	 * @param zipFile
	 *            需要解析的文件
	 * @param billDate
	 *            账单日
	 * @param batch
	 *            对账批次记录
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<ReconciliationEntityVo> parser(File zipFile, Date billDate, TbPayReconciliationCheckBatch batch) throws IOException {
		List<ReconciliationEntityVo> entityVoList = null;

		// 时间格式转换
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String billDateStr =sdf.format(billDate);

		//解压文件
		if(decompression(zipFile,batch)){
			//解释文件
			entityVoList = parserFile(zipFile.getParent(),zipFile.getName(),batch,billDateStr);
			logger.info("解析后的账单长度 entityVoList.size()：{}  ，内容 entityVoList.toString{}：" ,entityVoList.size(),entityVoList.toString());

		}

		return entityVoList;

	}

	/**
	 * 解压文件
	 * @param zipFile 压缩文件
	 * @param batch   对账批次记录
	* */
	private boolean decompression(File zipFile,TbPayReconciliationCheckBatch batch){
		try {
			Charset gbk = Charset.forName("gbk");
			//输入源zip路径
			ZipInputStream Zin = new ZipInputStream(new FileInputStream(zipFile),gbk);
			BufferedInputStream Bin = new BufferedInputStream(Zin);
			//输出路径（文件夹目录）
			String Parent = zipFile.getParent();
			File Fout = null;
			ZipEntry entry;
			try {
				while((entry = Zin.getNextEntry()) != null && !entry.isDirectory()){
					Fout=new File(Parent,entry.getName());
					if(!Fout.exists()){
						(new File(Fout.getParent())).mkdirs();
					}
					FileOutputStream out=new FileOutputStream(Fout);
					BufferedOutputStream Bout=new BufferedOutputStream(out);
					int b;
					while((b=Bin.read())!=-1){
						Bout.write(b);
					}
					Bout.close();
					out.close();
					logger.info(Fout + "解压成功");
				}
				Bin.close();
				Zin.close();
			} catch (IOException e) {
				logger.error("解压支付宝账单错误 " ,e);
				batch.setStatus(BatchStatusEnum.FAIL.getCode());
				batch.setCheckFailMsg("解压支付宝账单错误");
				return false;
			}
		} catch (FileNotFoundException e) {
			logger.error("解压支付宝账单错误 " ,e);
			batch.setStatus(BatchStatusEnum.FAIL.getCode());
			batch.setCheckFailMsg("解压支付宝账单错误");
			return false;
		}

		return true;
	}

	/**
	 * 解析文件
	 * @param path 存放文件的目录
	 * @param fileName  原来的解压文件名称
	 * @param batch   对账批次记录
	 * @param billDateStr   账期
	* */
	private List<ReconciliationEntityVo> parserFile(String path
			,String fileName
			,TbPayReconciliationCheckBatch batch
			,String billDateStr
	){

		/** 由于商户号有可能被其他平台使用 ，所以总值只能通过订单计算 **/
		// 总交易单数
		BigDecimal totalCount = BigDecimal.ZERO;
		// 总交易额
		BigDecimal totalAmount = BigDecimal.ZERO;
		// 手续费总金额
		BigDecimal feeAmount = BigDecimal.ZERO;

		//解释后的文件
		List<ReconciliationEntityVo> entityVoList = new ArrayList<>();

		//被解析的文件名称
		String csvName="";
		String name = fileName.split("\\.")[0];
		File fileDir = new File(path);
		File[] tempList = fileDir.listFiles();
		//排除"汇总" 和 "zip"的名称文件 ，只解析账单明细
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].getName().contains(billDateStr) && !tempList[i].getName().contains("汇总") && !tempList[i].getName().contains("zip")) {
				System.out.println(tempList[i].getName());
				csvName = tempList[i].getName();
			}
		}

		File excel  = new File(path + "/" + csvName);
		InputStreamReader inputStreamReader = null;
		InputStream fiStream = null;
		BufferedReader br = null;

		//暂时存放每一行的数据
		String rowRecord = "";
		//标记读取明细行数
		int redNum = 0;
		try {
			//文件流对象
			fiStream = new FileInputStream(excel);
			inputStreamReader = new InputStreamReader(fiStream, Charset.forName("GBK"));
			br = new BufferedReader(inputStreamReader);
			while ((rowRecord = br.readLine()) != null) {
				String[] lineList = rowRecord.split("\\,");
				if (lineList.length > 4) {
					//第一个为标题,不加载
					if(redNum > 0) {
						ReconciliationEntityVo entityVo = new ReconciliationEntityVo();
						// 设置支付宝流水号
						entityVo.setBankTrxNo(lineList[0]);
						// 设置平台订单号
						entityVo.setBankOrderNo(lineList[1]);

						// 设置账单金额:(单位是元)  并计算 总金订单金额
						entityVo.setBankAmount(new BigDecimal(lineList[11]));
						totalAmount = totalAmount.add(entityVo.getBankAmount());

						// 设置手续费 并计算总手续费金额
						entityVo.setBankFee(new BigDecimal(lineList[22]));
						feeAmount = feeAmount.add(entityVo.getBankFee());

						//计算出订单总数
						totalCount = totalCount.add(new BigDecimal("1"));

						//存入对账集合中
						entityVoList.add(entityVo);
					}
					redNum ++;
				}
			}

			/** 批次实体设置值 **/
			try {
				batch.setBankTradeCount(totalCount.intValue());
				// 微信账单金额单位是元
				batch.setBankTradeAmount(totalAmount);
				batch.setBankFee(feeAmount);
			} catch (NumberFormatException e) {
				logger.error("支付宝解析统计行失败, billDate[" + billDateStr + "], billType[SUCCESS], rawdata[" + br.toString() + "]", e);
				batch.setStatus(BatchStatusEnum.FAIL.getCode());
				batch.setCheckFailMsg("支付宝解析统计行失败, rawdata[" + br.toString() + "]");
				// 恢复空值
				batch.setBankTradeCount(null);
				batch.setBankTradeAmount(null);
				batch.setBankFee(null);
				return null;
			}


		} catch (Exception e) {
			logger.error("解析支付宝账单错误 " ,e);
			batch.setStatus(BatchStatusEnum.FAIL.getCode());
			batch.setCheckFailMsg("解析支付宝账单错误");
			return null;
		} finally {
			closeStream(br, inputStreamReader, fiStream);
		}

	return entityVoList;
	}



	/**
	 * 按顺序关闭流
	 */
	private void closeStream(BufferedReader bufferedReader, InputStreamReader inputStreamReader, InputStream inputStream) {
		try {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (inputStreamReader != null) {
			try {
				inputStreamReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
