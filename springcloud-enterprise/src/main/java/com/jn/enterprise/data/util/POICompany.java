package com.jn.enterprise.data.util;

import com.jn.enterprise.data.model.CompanyTree;
import com.jn.enterprise.data.tool.GetCompanyTree;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 *
 * 纵向树形指标导出模式
 *    仅仅适用于企业
 *
 */


public class POICompany {




    public static void getTable(List<CompanyTree> list, String filename) {
        int rowlen = 1;

        //转换成树形
        GetCompanyTree getCompanyTree = new GetCompanyTree();
        List<Map> treeList = getCompanyTree.bulid(list);


        //指标值长度
        int lenth=0;

        for (int i=0;i<treeList.size();i++){

            HashMap map = (HashMap) treeList.get(i);
            Set set = map.keySet();
            Iterator iterator = set.iterator();
            String key = (String) iterator.next();
            List<CompanyTree> childs = (List<CompanyTree>) map.get(key);

            for (CompanyTree child:childs) {

               String str = child.getDATA();
               String[] str1 =str.split(";");
               int len =str1.length;

               if(len>lenth){
                   lenth=len;
               }

            }

        }


        //构建HSSFWorkBook
        HSSFWorkbook wb = new HSSFWorkbook();
        // 生成一个样式
        HSSFCellStyle headstyle = wb.createCellStyle();
        headstyle.setAlignment(HorizontalAlignment.CENTER);// 左右居中
        headstyle.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
        headstyle.setLocked(true);

        //文件名
        HSSFSheet sheet = wb.createSheet(filename);

        //表头设置
        HSSFRow headrow = sheet.createRow(0);
        headrow.createCell(0).setCellValue("指标名称");
        headrow.createCell(1).setCellValue("单位");

        HSSFCell cell = headrow.createCell(2);
        cell.setCellValue("指标值");
        cell.setCellStyle(headstyle);
        sheet.addMergedRegionUnsafe(new CellRangeAddress(0,0,2,2+(lenth-1)));

        headrow.createCell(2+lenth).setCellValue("合计");


        //填充数据
        for(int i=0;i<treeList.size();i++){
            HSSFRow row = sheet.createRow(rowlen);
            HashMap map = (HashMap) treeList.get(i);
            Set set = map.keySet();
            Iterator iterator = set.iterator();
            String key = (String) iterator.next();
            row.createCell(0).setCellValue(key);
            rowlen++;
            List<CompanyTree> childs2 = (List<CompanyTree>) map.get(key);
            for (CompanyTree child2 : childs2){
                HSSFRow row1 = sheet.createRow(rowlen);
                row1.createCell(0).setCellValue(child2.getForm_name());
                row1.createCell(1).setCellValue(child2.getUnit());

                String str = child2.getDATA();
                String[] str1 =str.split(";");
                int len =str1.length;

                for(int j=0;j<len;j++){
                    row1.createCell(2+j).setCellValue(str1[j]);
                }

                row1.createCell(2+lenth).setCellValue(child2.getSum_val());


                rowlen++;
            }
        }


        try {
            //写入到excel中去
            wb.write(new File("D:\\test.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    //测试数据

//
//    public static void main(String[] args) {
//
//
//        CompanyTree p = new CompanyTree();
//        p.setTarget_id("-1");
//        p.setTarget_name("指标一");
//        p.setParent_id("0");
//
//        CompanyTree companyTree2 = new CompanyTree();
//        companyTree2.setDATA("dasd;dasdsa;adasd;asd");
//        companyTree2.setForm_name("填报格式");
//        companyTree2.setTarget_id("10");
//        companyTree2.setParent_id("-1");
//        companyTree2.setSum_val("1000");
//        companyTree2.setTarget_name("1");
//        companyTree2.setUnit("dsda");
//
//        CompanyTree companyTree1 = new CompanyTree();
//        companyTree1.setDATA("dasd;dasdsa;adasd;asd");
//        companyTree1.setTarget_id("10");
//        companyTree1.setForm_name("填报格式");
//        companyTree1.setParent_id("-1");
//        companyTree1.setSum_val("1000");
//        companyTree1.setTarget_name("11");
//        companyTree1.setUnit("dsda");
//
//        CompanyTree p1 = new CompanyTree();
//        p1.setTarget_id("-11");
//        p1.setTarget_name("指标二");
//        p1.setParent_id("0");
//
//        CompanyTree companyTree3 = new CompanyTree();
//        companyTree3.setDATA("dasd;dasdsa;adasd;asd");
//        companyTree3.setTarget_id("10");
//        companyTree3.setForm_name("填报格式");
//        companyTree3.setParent_id("-11");
//        companyTree3.setSum_val("1000");
//        companyTree3.setTarget_name("rwewe");
//        companyTree3.setUnit("dsda");
//        CompanyTree companyTree4 = new CompanyTree();
//        companyTree4.setDATA("dasd;dasdsa;adasd;asd");
//        companyTree4.setTarget_id("10");
//        companyTree4.setForm_name("填报格式");
//        companyTree4.setParent_id("-11");
//        companyTree4.setSum_val("1000");
//        companyTree4.setTarget_name("rwewe");
//        companyTree4.setUnit("dsda");
//
//        ArrayList<CompanyTree> objects = new ArrayList<>();
//        objects.add(p);
//        objects.add(p1);
//        objects.add(companyTree1);
//        objects.add(companyTree2);
//        objects.add(companyTree3);
//        objects.add(companyTree4);
//        String name = "测试";
//        getTable(objects,name);
//
//
//    }










}
