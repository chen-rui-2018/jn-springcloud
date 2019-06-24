package com.jn.hr.common.util;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.jn.common.enums.CommonExcelExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * @author dt
 * @create 2019-05-14 上午 10:20
 */
public class HrExcelUtil {
	public static void writeExcelWithCol(ByteArrayOutputStream os, String fileName, String sheetName,
			String exportTitle, String exportColName, List dataList) {
		ExcelWriter writer = new ExcelWriter(os, ExcelTypeEnum.XLSX);
		List<List<String>> head = new ArrayList();
		String[] titleFields = exportTitle.split(",");
		String[] var9 = titleFields;
		int var10 = titleFields.length;

		ArrayList da;
		for (int var11 = 0; var11 < var10; ++var11) {
			String title = var9[var11];
			da = new ArrayList();
			da.add(title);
			head.add(da);
		}

		ArrayList data = new ArrayList();

		try {
			String[] colFields = exportColName.split(",");
			Iterator var26 = dataList.iterator();

			while (var26.hasNext()) {
				Object model = var26.next();
				da = new ArrayList();
				String[] var14 = colFields;
				int var15 = colFields.length;

				for (int var16 = 0; var16 < var15; ++var16) {
					String col = var14[var16];
					Field[] var18 = model.getClass().getDeclaredFields();
					int var19 = var18.length;

					for (int var20 = 0; var20 < var19; ++var20) {
						Field field = var18[var20];
						field.setAccessible(true);
						if (col.equals(field.getName())) {
							da.add(field.get(model));
						}
					}
				}

				data.add(da);
			}
		} catch (IllegalAccessException var22) {
			;
		}

		Sheet sheet = new Sheet(1, 0);
		sheet.setSheetName(sheetName);
		sheet.setHead(head);
		sheet.setAutoWidth(Boolean.TRUE);
		writer.write1(data, sheet);
		writer.finish();
	}

	/**
	 * 复杂表头导出
	 * 
	 * @param data           继承BaseRowModel的实体集合
	 * @param outputFileName 输出文件全路径
	 * @param sheet1         --> Sheet sheet1 = new Sheet(1, 0, T.class);
	 *                       T继承BaseRowModel的实体，属性添加@ExcelProperty(value = { "表头5",
	 *                       "表头51", "表头52" }, index = 4)，确定属性的显示位置
	 * @throws IOException
	 */
	public static void writeWithMultiHead(List<? extends BaseRowModel> data, String outputFileName, Sheet sheet1,
			String sheetName, HttpServletResponse response) {
		try {
			String filePath = outputFileName + ExcelTypeEnum.XLSX.getValue();
			OutputStream out = null;
			outputFileName = new String(filePath.getBytes(), "ISO-8859-1");
			response.addHeader("Content-Disposition", "filename=" + outputFileName);
			out = response.getOutputStream();
			ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
			
			
			sheet1.setSheetName(sheetName);
			sheet1.setAutoWidth(Boolean.TRUE);
			writer.write(data, sheet1);
			writer.finish();
		} catch (Exception exception) {
			;
		}
		throw new JnSpringCloudException(CommonExcelExceptionEnum.EXCEL_FORMAT_ERROR);

	}
}
