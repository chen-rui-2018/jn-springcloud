package com.jn.enterprise.data.util;


import com.jn.enterprise.data.model.CompanyTree;
import com.jn.enterprise.data.tool.GetCompanyTree;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 *
 *  指标描述导出模式
 *
 */
public class POIDescribe {

    public void getDescribeTable(List<CompanyTree> list,HttpServletRequest req,
                                 HttpServletResponse resp)throws IOException {

        String fileName = DateFormatUtils.format(new Date(),"yyyyMMddHHmm"); //设置文件名
        resp.addHeader("Content-Disposition", "attachment;filename=" +fileName+ ".xlsx");//设置文件头编码格式
        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");//设置类型
        resp.setDateHeader("Expires", 0);//设置日期头

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
        Sheet sheet = wb.createSheet(fileName);
        //表头设置
        Row headrow1 = sheet.createRow(0);
        headrow1.createCell(0).setCellValue("序号");
        headrow1.createCell(1).setCellValue("目标名称");
        headrow1.createCell(2).setCellValue("目标进展情况");
        headrow1.createCell(3).setCellValue("存在问题");
        headrow1.createCell(4).setCellValue("推进措施");
        headrow1.createCell(5).setCellValue("下月安排");

        for(int i=0;i<companyTreeslist.size();i++){
            Row headrow = sheet.createRow(i+1);
            headrow.createCell(0).setCellValue(i+1);
            headrow.createCell(1).setCellValue(companyTreeslist.get(i).getTargetname());
            //得到目标进展情况、是否已完成、是否已达到序时进度
            String str = companyTreeslist.get(i).getDATA();
            if(StringUtils.isNotBlank(str)){
                String[] str2 = str.split(";");
                int len=str2.length;
                String progress = str2[0]+";"+str2[1]+";"+str2[2];
                headrow.createCell(2).setCellValue(progress);
                for (int j=3;j<len;j++){
                    headrow.createCell(j).setCellValue(str2[j]);
                }
            }

        }
        wb.write(resp.getOutputStream());
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
        wb.close();
    }
}
