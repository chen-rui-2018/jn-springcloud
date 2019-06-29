package com.jn.enterprise.data.util;

import com.jn.enterprise.data.model.CompanyTree;
import com.jn.enterprise.data.tool.GetCompanyTree;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
/**
 *
 * 纵向树形指标导出模式
 *    仅仅适用于企业
 *
 */
public class POICompany {

    public static void getTable(List<CompanyTree> list,HttpServletRequest req,
                                HttpServletResponse resp)throws IOException{

        String fileName = DateFormatUtils.format(new Date(),"yyyyMMddHHmm"); //设置文件名
        resp.addHeader("Content-Disposition", "attachment;filename=" +fileName+ ".xlsx");//设置文件头编码格式
        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");//设置类型
        resp.setDateHeader("Expires", 0);//设置日期头
        //转换成树形
        GetCompanyTree getCompanyTree = new GetCompanyTree();
        List<Map> treeList = getCompanyTree.buildPackage(list);
        //构建XSSFWorkBook
        Workbook wb = new XSSFWorkbook();
        // 生成一个样式
        XSSFCellStyle headstyle=((XSSFWorkbook) wb).createCellStyle();
        headstyle.setAlignment(HorizontalAlignment.CENTER);// 左右居中
        headstyle.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
        headstyle.setLocked(true);
        //指标值长度
        int lenth = 0;
        for (int i = 0; i < treeList.size(); i++) {
            HashMap map = (HashMap) treeList.get(i);
            Set set = map.keySet();
            Iterator iterator = set.iterator();
            String key = (String) iterator.next();
            List<CompanyTree> childs = (List<CompanyTree>) map.get(key);
            for (CompanyTree child : childs) {
                String str = child.getDATA();
                if(StringUtils.isNotBlank(str)){
                    String[] str1 = str.split(";");
                    int len = str1.length;
                    if (len > lenth) {
                        lenth = len;
                    }
                }
            }
        }
        Sheet sheet = wb.createSheet();
        //表头设置
        Row headrow = sheet.createRow(0);
        headrow.createCell(0).setCellValue("指标名称");
        headrow.createCell(1).setCellValue("单位");
        Cell cell = headrow.createCell(2);
        cell.setCellValue("指标值");
        cell.setCellStyle(headstyle);

        if((2+lenth-1)>2){
            sheet.addMergedRegionUnsafe(new CellRangeAddress(0, 0, 2, 2 + (lenth - 1)));
            headrow.createCell(2 + lenth).setCellValue("合计");
        }else{
            headrow.createCell(3).setCellValue("合计");
        }
        //填充数据
        int rowlen = 1;
        for (int i = 0; i < treeList.size(); i++) {
            Row row = sheet.createRow(rowlen);
            HashMap map = (HashMap) treeList.get(i);
            Set set = map.keySet();
            Iterator iterator = set.iterator();
            String key = (String) iterator.next();
            List<CompanyTree> children = (List<CompanyTree>) map.get(key);
            row.createCell(0).setCellValue(key);
            rowlen++;
            for (CompanyTree child2 : children) {
                Row row1 = sheet.createRow(rowlen);
                row1.createCell(0).setCellValue(child2.getFormname());
                row1.createCell(1).setCellValue(child2.getUnit());

                String str = child2.getDATA();
                if(StringUtils.isNotBlank(str)){
                    String[] str1 = str.split(";");
                    int len = str1.length;
                    for (int j = 0; j < len; j++) {
                        row1.createCell(2 + j).setCellValue(str1[j]);
                    }
                }
                    row1.createCell(2 + lenth).setCellValue(child2.getSumval());
                    rowlen++;
            }
        }
        wb.write(resp.getOutputStream());
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
        wb.close();
    }

}
