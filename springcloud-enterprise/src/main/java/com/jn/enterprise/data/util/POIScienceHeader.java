package com.jn.enterprise.data.util;

import com.jn.enterprise.data.model.CompanyTree;
import com.jn.enterprise.data.tool.GetCompanyTree;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class POIScienceHeader {

    public void getScienceHeaderTable(List<CompanyTree> list, HttpServletRequest req,
                                      HttpServletResponse resp)throws IOException {

        String fileName = DateFormatUtils.format(new Date(),"yyyyMMddHHmm"); //设置文件名
        resp.addHeader("Content-Disposition", "attachment;filename=" +fileName+ ".xlsx");//设置文件头编码格式
        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");//设置类型
        resp.setDateHeader("Expires", 0);//设置日期头
        //转换成树形
        GetCompanyTree getCompanyTree = new GetCompanyTree();
        List<CompanyTree> treeList = getCompanyTree.listToTree(list);
        List<CompanyTree> companyTreeslist = getCompanyTree.treeToList(treeList);
        //构建XSSFWorkBook
        Workbook wb = new XSSFWorkbook();
        // 生成一个样式
        XSSFCellStyle headstyle=((XSSFWorkbook) wb).createCellStyle();
        headstyle.setAlignment(HorizontalAlignment.CENTER);// 左右居中
        headstyle.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
        headstyle.setLocked(true);
        //文件名
        Sheet sheet = wb.createSheet();
        int length = 0;
        //得到最长指标值
        for (CompanyTree trees : companyTreeslist
        ) {
            String d1 = trees.getDATA();
            if(StringUtils.isNotBlank(d1)){
                String[] d2 = d1.split(";");
                int nlen = d2.length;
                if (nlen > length) {
                    length = nlen;
            }
            }
        }
        int lent = 0;
        //创建第一行
        Row headrow1 = sheet.createRow(0);
        //得到数值行数
        Row[] row = new Row[length];
        for (int j = 0; j < length; j++) {
            Row headrow2 = sheet.createRow(j + 1);
            row[j] = headrow2;
        }
        for (int i = 0; i < companyTreeslist.size(); i++) {
            //得到指标值的长度
            String fa = companyTreeslist.get(i).getDATA();
            if(StringUtils.isNotBlank(fa)){
                String[] fa2 = fa.split(";");
                int len = fa2.length;
            }
            //指标名称
            Cell cell = headrow1.createCell(i);
            cell.setCellStyle(headstyle);
            cell.setCellValue(companyTreeslist.get(i).getTargetname());
        }
        wb.write(resp.getOutputStream());
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
        wb.close();
    }

}