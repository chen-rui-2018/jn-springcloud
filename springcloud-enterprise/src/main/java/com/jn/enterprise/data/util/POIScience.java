package com.jn.enterprise.data.util;


import com.jn.enterprise.data.model.CompanyTree;
import com.jn.enterprise.data.tool.GetCompanyTree;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * 科技园模板
 *
 */
public class POIScience {



    public  void getScienceTable(List<CompanyTree> list,  HttpServletRequest req,
                                       HttpServletResponse resp)throws IOException {


        Date date =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
        String time =sdf.format(date);
        String filename = time; //设置文件名
        resp.setHeader("Content-Disposition", "attachment;filename=File" + time +".xlsx");
        resp.setContentType("application/vnd.ms-excel;charset=UTF-8");//设置类型
        resp.setHeader("Cache-Control", "no-cache");//设置头
        resp.setDateHeader("Expires", 0);//设置日期头


        GetCompanyTree getCompanyTree = new GetCompanyTree();
        List<CompanyTree> treeList = getCompanyTree.bulidscience(list);
        List<Map> treeList2 = getCompanyTree.bulid(list);
        List<CompanyTree> companyTreeslist = getCompanyTree.bulidlist(treeList);


        //构建HSSFWorkBook
        HSSFWorkbook wb = new HSSFWorkbook();
        // 生成一个样式
        HSSFCellStyle headstyle = wb.createCellStyle();
        headstyle.setAlignment(HorizontalAlignment.CENTER);// 左右居中
        headstyle.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
        headstyle.setLocked(true);

        //文件名
        HSSFSheet sheet = wb.createSheet(filename);

        int length=0;

        //得到最长指标值
        for (CompanyTree tree:companyTreeslist
             ) {
            String d1 = tree.getDATA();
            String[] d2 = d1.split(";");
            int nlen = d2.length;
            if(nlen>length){
                length=nlen;
            }
        }

        int lent = 0;

        //创建第一行
        HSSFRow headrow1 = sheet.createRow(0);

        //得到数值行数
        HSSFRow[] row =new HSSFRow[length];
        for(int j=0;j<length;j++){
            HSSFRow headrow2 = sheet.createRow(j+1);
            row[j]=headrow2;
        }

        for(int i=0;i<companyTreeslist.size();i++) {

            //得到指标值的长度
            String fa = companyTreeslist.get(i).getDATA();
            String[] fa2 = fa.split(";");
            int len = fa2.length;

            //指标名称
            Cell cell = headrow1.createCell(i);
            cell.setCellStyle(headstyle);
            cell.setCellValue(companyTreeslist.get(i).getTargetname());


            //填充值
            for (int k=0;k<len;k++){
                row[k].createCell(lent).setCellValue(fa2[k]);
            }
            lent++;
        }


        wb.write(resp.getOutputStream());
        resp.getOutputStream().flush();
        resp.getOutputStream().close();

        wb.close();

    }





}
