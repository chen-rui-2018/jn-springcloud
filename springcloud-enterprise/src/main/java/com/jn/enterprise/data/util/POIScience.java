package com.jn.enterprise.data.util;


import com.jn.enterprise.data.model.CompanyTree;
import com.jn.enterprise.data.tool.GetCompanyTree;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.util.List;
import java.util.Map;

/**
 *
 * 科技园模板
 *
 */
public class POIScience {



    public static void getTable(List<CompanyTree> list, String filename) {


        //转换成树形
        GetCompanyTree getCompanyTree = new GetCompanyTree();
        List<Map> treeList = getCompanyTree.bulid(list);


        //构建HSSFWorkBook
        HSSFWorkbook wb = new HSSFWorkbook();
        // 生成一个样式
        HSSFCellStyle headstyle = wb.createCellStyle();
        headstyle.setAlignment(HorizontalAlignment.CENTER);// 左右居中
        headstyle.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
        headstyle.setLocked(true);

        //文件名
        HSSFSheet sheet = wb.createSheet(filename);







    }


}
