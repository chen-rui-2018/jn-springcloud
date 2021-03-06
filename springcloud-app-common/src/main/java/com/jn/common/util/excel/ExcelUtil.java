package com.jn.common.util.excel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.jn.common.enums.CommonExcelExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel工具类
 *
 * @author： shenph
 * @date： Created on 2019/1/16 15:33
 * @version： v1.0
 * @modified By:
 */
public class ExcelUtil {

    /**
     * 读取 Excel(多个 sheet)
     *
     * @param excel    文件
     * @param rowModel 实体类映射，继承 BaseRowModel 类
     * @return Excel 数据 list
     */
    public static List<Object> readExcel(MultipartFile excel, BaseRowModel rowModel) {
        ExcelListener excelListener = new ExcelListener();
        ExcelReader reader = getReader(excel, excelListener);
        if (reader == null) {
            return null;
        }
        for (Sheet sheet : reader.getSheets()) {
            if (rowModel != null) {
                sheet.setClazz(rowModel.getClass());
            }
            reader.read(sheet);
        }
        return excelListener.getDatas();
    }

    /**
     * 读取某个 sheet 的 Excel
     *
     * @param excel    文件
     * @param rowModel 实体类映射，继承 BaseRowModel 类
     * @param sheetNo  sheet 的序号 从1开始
     * @return Excel 数据 list
     */
    public static List<Object> readExcel(MultipartFile excel, BaseRowModel rowModel, int sheetNo) {
        return readExcel(excel, rowModel, sheetNo, 1);
    }

    /**
     * 读取某个 sheet 的 Excel
     *
     * @param excel       文件
     * @param rowModel    实体类映射，继承 BaseRowModel 类
     * @param sheetNo     sheet 的序号 从1开始
     * @param headLineNum 表头行数，默认为1
     * @return Excel 数据 list
     */
    public static List<Object> readExcel(MultipartFile excel, BaseRowModel rowModel, int sheetNo,
                                         int headLineNum) {
        ExcelListener excelListener = new ExcelListener();
        ExcelReader reader = getReader(excel, excelListener);
        if (reader == null) {
            return null;
        }
        reader.read(new Sheet(sheetNo, headLineNum, rowModel.getClass()));
        return excelListener.getDatas();
    }

    /**
     * 导出 Excel ：一个 sheet，带表头
     *
     * @param response  HttpServletResponse
     * @param list      数据 list，每个元素为一个 BaseRowModel
     * @param fileName  导出的文件名
     * @param sheetName 导出文件的 sheet 名
     * @param object    映射实体类，Excel 模型
     */
    public static void writeExcel(HttpServletResponse response, List<? extends BaseRowModel> list,
                                  String fileName, String sheetName, BaseRowModel object) {
        ExcelWriter writer = new ExcelWriter(getOutputStream(fileName, response), ExcelTypeEnum.XLSX);
        Sheet sheet = new Sheet(1, 0, object.getClass());
        sheet.setSheetName(sheetName);
        writer.write(list, sheet);
        writer.finish();
    }


    /**
     * 导出 Excel ：支持选择列
     *
     * @param response      HttpServletResponse
     * @param fileName      导出的文件名
     * @param sheetName     导出文件的 sheet名
     * @param exportTitle   导出文件的表头
     * @param exportColName 导出文件的列
     * @param dataList      导出文件的数据
     */
    public static void writeExcelWithCol(HttpServletResponse response, String fileName,
                                         String sheetName, String exportTitle, String exportColName, List dataList) {
        ExcelWriter writer = new ExcelWriter(getOutputStream(fileName, response), ExcelTypeEnum.XLSX);
        //标题
        List<List<String>> head = new ArrayList<List<String>>();
        String titleFields[] = exportTitle.split(",");
        for (String title : titleFields) {
            List<String> headCoulumn = new ArrayList<String>();
            headCoulumn.add(title);
            head.add(headCoulumn);
        }

        //数据
        List<List<Object>> data = new ArrayList<List<Object>>();
        try {
            String colFields[] = exportColName.split(",");
            for (Object model : dataList) {
                List<Object> da = new ArrayList<Object>();
                for (String col : colFields) {
                    for (Field field : model.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                        if (col.equals(field.getName())) {
                            da.add(field.get(model));
                            continue;
                        }
                    }
                }
                data.add(da);
            }
        } catch (IllegalAccessException e) {
        }

        //生成sheet,导出
        Sheet sheet = new Sheet(1, 0);
        sheet.setSheetName(sheetName);
        sheet.setHead(head);
        sheet.setAutoWidth(Boolean.TRUE);
        writer.write1(data, sheet);
        writer.finish();
    }

    /**
     * 导出 Excel ：多个 sheet，带表头
     *
     * @param response  HttpServletResponse
     * @param list      数据 list，每个元素为一个 BaseRowModel
     * @param fileName  导出的文件名
     * @param sheetName 导入文件的 sheet 名
     * @param object    映射实体类，Excel 模型
     */
    public static ExcelWriterFactroy writeExcelWithSheets(HttpServletResponse response, List<? extends BaseRowModel> list,
                                                          String fileName, String sheetName, BaseRowModel object) {
        ExcelWriterFactroy writer = new ExcelWriterFactroy(getOutputStream(fileName, response), ExcelTypeEnum.XLSX);
        Sheet sheet = new Sheet(1, 0, object.getClass());
        sheet.setSheetName(sheetName);
        writer.write(list, sheet);
        return writer;
    }

    /**
     * 导出文件时为Writer生成OutputStream
     *
     * @param fileName 文件
     * @param response
     * @return
     */
    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) {
        String filePath = fileName + ExcelTypeEnum.XLSX.getValue();
        try {
            //TODO 创建并保存文件
            //File dbfFile = new File(filePath);
            //if (!dbfFile.exists() || dbfFile.isDirectory()) {
            //    dbfFile.createNewFile();
            //}
            fileName = new String(filePath.getBytes(), "ISO-8859-1");
            response.addHeader("Content-Disposition", "filename=" + fileName);
            return response.getOutputStream();
        } catch (IOException e) {
            throw new JnSpringCloudException(CommonExcelExceptionEnum.EXCEL_FORMAT_ERROR);
        }
    }

    /**
     * 返回 ExcelReader
     *
     * @param excel         需要解析的 Excel 文件
     * @param excelListener new ExcelListener()
     */
    private static ExcelReader getReader(MultipartFile excel,
                                         ExcelListener excelListener) {
        String filename = excel.getOriginalFilename();
        if (filename == null ||
                (!filename.toLowerCase().endsWith(ExcelTypeEnum.XLS.getValue())
                        && !filename.toLowerCase().endsWith(ExcelTypeEnum.XLSX.getValue()))
        ) {
            throw new JnSpringCloudException(CommonExcelExceptionEnum.EXCEL_FORMAT_ERROR);
        }
        InputStream inputStream;
        try {
            inputStream = excel.getInputStream();
            return new ExcelReader(inputStream, null, excelListener, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
