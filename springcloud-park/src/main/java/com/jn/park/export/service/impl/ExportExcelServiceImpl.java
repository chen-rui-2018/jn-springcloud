package com.jn.park.export.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.export.service.ExportExcelService;
import com.jn.park.utils.ExcelUtils;
import com.jn.park.utils.ObjToMapUtil;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: yangph
 * @Date: 2018/12/18 15:26
 * @Version v1.0
 * @modified By:
 */
@Service
public class ExportExcelServiceImpl implements ExportExcelService {
    /**
     * 日志组件
     */
    private static Logger logger= LoggerFactory.getLogger(ExportExcelServiceImpl.class);

    /**
     * 单行表头数据导出  只支持excel（xls和xlsx）导出
     * @param codedFileName  下载文件名  不包含后缀
     * @param exportColName  excel导出的字段别名 比如：name,phone
     * @param exportTitle    excel导出字段的标题 比如：姓名，手机
     * @param exportAs       导出格式   1：导出xls格式  2：导出为xlsx格式
     * @param dataList       要导出的数据，一般为查询页面所展示的数据（不支持分页）
     * @param response       响应
     */
    @ServiceLog(doAction = "数据导出")
    @Override
    public void singleRowHeaderExport(String codedFileName , String exportColName, String exportTitle,int exportAs, List<?>dataList, HttpServletResponse response) {
        //导出入参校验
        exportAs = checkExportParameter(exportColName, exportTitle, false, 0, exportAs, dataList, null);
        //(1)下载文件名
        //xls导出方式
        int xlsFlag=1;
        //xlsx导出方式
        int xlsxFlag=2;
        if(exportAs==xlsFlag){
            codedFileName=codedFileName+".xls";
        }else if(exportAs==xlsxFlag){
            codedFileName=codedFileName+".xlsx";
        }
        try {
            codedFileName = new String(codedFileName.getBytes("gb2312"), "iso8859-1");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("content-disposition", "attachment;filename=" + codedFileName);

            //(2)导出字段名
            String []fields=exportColName.split(",");
            //数组转换成list
            List<String> fieldList=new ArrayList<>(Arrays.asList(fields));

            //(3)导出数据
            //list<bean>转换 List<Map<String, Object>>
            List<Map<String, Object>> exportList = ObjToMapUtil.listToMap(dataList);

            //（4）单行表头、多行表头

            //单行表头导出
            String[] title = exportTitle.split(",");
            //数组转换成list
            List<String> titleList= new ArrayList<String>(Arrays.asList(title));
            //导出方法，按照表头、列、数据、导出方式、输出流的顺序放入参数   后缀名是xlsx  ，传递2
            ExcelUtils.exportData(titleList, fieldList, exportList, exportAs, response.getOutputStream());
        } catch (Exception e) {
            logger.info("导出失败，失败原因：{}",e.getMessage());
            throw new JnSpringCloudException(ActivityExceptionEnum.EXPORT_FAILED);
        }
    }


    /**
     * 多行表头数据导出  只支持excel（xls和xlsx）导出
     * @param codedFileName 下载文件名  不包含后缀
     * @param exportColName excel导出的字段别名 比如：name,phone
     * @param exportTitle   excel导出字段的标题 比如：姓名，手机
     * @param exportAs      导出格式   1：导出xls格式  2：导出为xlsx格式
     * @param rowIndex      多行表头从哪一行开始写数据，一般是多行表头占用行数加1,单行表头传0
     * @param dataList      要导出的数据，一般为查询页面所展示的数据（不支持分页）
     * @param temp          多行表头的模板
     * @param response      响应
     */
    @ServiceLog(doAction = "数据导出")
    @Override
    public void multiRowHeaderExport(String codedFileName , String exportColName, String exportTitle, int exportAs, int rowIndex, List<?>dataList, InputStream temp, HttpServletResponse response) {
        //导出入参校验
        exportAs = checkExportParameter(exportColName, exportTitle, true, rowIndex, exportAs, dataList, temp);
        try(OutputStream fOut=response.getOutputStream()) {
            //(1)下载文件名
            //xls导出方式
            int xlsFlag=1;
            //xlsx导出方式
            int xlsxFlag=2;
            if(exportAs==xlsFlag){
                codedFileName=codedFileName+".xls";
            }else if(exportAs==xlsxFlag){
                codedFileName=codedFileName+".xlsx";
            }
            codedFileName = new String(codedFileName.getBytes("gb2312"), "iso8859-1");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("content-disposition", "attachment;filename=" + codedFileName);

            //(2)导出字段名
            String []fields=exportColName.split(",");
            //数组转换成list
            List<String> fieldList=new ArrayList<>(Arrays.asList(fields));

            //(3)导出数据
            //list<bean>转换 List<Map<String, Object>>
            List<Map<String, Object>> exportList = ObjToMapUtil.listToMap(dataList);

            //（4）多行表头
            //多行表头导出
            String []title = new String[]{};
            //数组转换成list
            List<String>titleList = new ArrayList<String>(Arrays.asList(title));
            ExcelUtils.exportDataTemplate(titleList, fieldList, exportList, temp, fOut, rowIndex);
        }catch (Exception e){
            logger.info("导出失败，失败原因：{}",e.getMessage());
            throw new JnSpringCloudException(ActivityExceptionEnum.EXPORT_FAILED);
        }
    }



    /**
     * 导出入参校验
     * @param exportColName  excel导出的字段别名 比如：name,phone
     * @param exportTitle    excel导出字段的标题 比如：姓名，手机
     * @param isMoreHead     是否多行表头  是：true  否：导出
     * @param rowIndex       多行表头从哪一行开始写数据，一般是多行表头占用行数加1，至少为3,单行表头传0
     * @param exportAs       导出格式   1：导出xls格式  2：导出为xlsx格式
     * @param dataList       要导出的数据，一般为查询页面所展示的数据（不支持分页）
     * @param temp
     * @return
     */
    private int checkExportParameter(String exportColName, String exportTitle, boolean isMoreHead, int rowIndex, int exportAs, List<?> dataList, InputStream temp) {
        //至少要导出一条数据,否则不能导出
        int minDataList=1;
        if(dataList.size()<minDataList){
            logger.info("没有数据，不能导出");
            throw new JnSpringCloudException(ActivityExceptionEnum.EXPORT_CANNOT_EMPTY);
        }
        //以逗号切割
        String splitReg=",";
        if(exportColName.split(splitReg).length!=exportTitle.split(splitReg).length){
            logger.info("excel导出字段别名[exportColName]个数和excel导出字段标题[exportTitle]个数不匹配");
            throw new JnSpringCloudException(ActivityExceptionEnum.EXPORT_PARAMETER_MORE_HEAD);
        }
        //若是多行表头，rowIndex至少是3，导出模板temp不能为空
        if(isMoreHead){
            int miniRowIndex=3;
            if(rowIndex<=miniRowIndex || temp==null){
                logger.info("多行表头从哪一行开始写数据[rowIndex]的值至少是3，多行表头导出模板[temp]不能为空");
                throw new JnSpringCloudException(ActivityExceptionEnum.EXPORT_PARAMETER_INDEX_OR_TEMP);
            }
        }
        //xls导出方式
        int xlsFlag=1;
        //xlsx导出方式
        int xlsxFlag=2;
        //导出方式不是xls和xlsx，默认为xlsx导出
        if( exportAs!=xlsFlag && exportAs!=xlsxFlag){
            exportAs=2;
        }
        return exportAs;
    }
}
