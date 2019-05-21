package com.jn.hr.common.util;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author dt
 * @create 2019-05-14 上午 10:20
 */
public class HrExcelUtil {
    public static void writeExcelWithCol(ByteArrayOutputStream os, String fileName, String sheetName, String exportTitle, String exportColName, List dataList) {
        ExcelWriter writer = new ExcelWriter(os, ExcelTypeEnum.XLSX);
        List<List<String>> head = new ArrayList();
        String[] titleFields = exportTitle.split(",");
        String[] var9 = titleFields;
        int var10 = titleFields.length;

        ArrayList da;
        for(int var11 = 0; var11 < var10; ++var11) {
            String title = var9[var11];
            da = new ArrayList();
            da.add(title);
            head.add(da);
        }

        ArrayList data = new ArrayList();

        try {
            String[] colFields = exportColName.split(",");
            Iterator var26 = dataList.iterator();

            while(var26.hasNext()) {
                Object model = var26.next();
                da = new ArrayList();
                String[] var14 = colFields;
                int var15 = colFields.length;

                for(int var16 = 0; var16 < var15; ++var16) {
                    String col = var14[var16];
                    Field[] var18 = model.getClass().getDeclaredFields();
                    int var19 = var18.length;

                    for(int var20 = 0; var20 < var19; ++var20) {
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
}
