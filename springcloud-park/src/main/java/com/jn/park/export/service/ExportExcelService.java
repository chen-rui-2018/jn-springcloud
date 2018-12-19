package com.jn.park.export.service;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/**
 * 导出excel   支持xls和xlsx格式
 * @Author: yangph
 * @Date: 2018/12/18 15:25
 * @Version v1.0
 * @modified By:
 */
public interface ExportExcelService {
    /**
     * 单行表头数据导出  只支持excel（xls和xlsx）导出
     * @param codedFileName  下载文件名  不包含后缀
     * @param exportColName  excel导出的字段别名 比如：name,phone
     * @param exportTitle    excel导出字段的标题 比如：姓名，手机
     * @param exportAs       导出格式   1：导出xls格式  2：导出为xlsx格式
     * @param dataList       要导出的数据，一般为查询页面所展示的数据（不支持分页）
     * @param response       响应
     */
    void singleRowHeaderExport(String codedFileName , String exportColName, String exportTitle,int exportAs, List<?>dataList, HttpServletResponse response);

    /**
     * 多行表头数据导出  只支持excel（xls和xlsx）导出
     * @param codedFileName 下载文件名  不包含后缀
     * @param exportColName excel导出的字段别名 比如：name,phone
     * @param exportTitle   excel导出字段的标题 比如：姓名，手机
     * @param exportAs      导出格式   1：导出xls格式  2：导出为xlsx格式
     * @param rowIndex      多行表头从哪一行开始写数据，一般是多行表头占用行数加1  单行表头传0
     * @param dataList      要导出的数据，一般为查询页面所展示的数据（不支持分页）
     * @param temp          多行表头的模板  单行表头传null
     * @param response      响应
     */
    void multiRowHeaderExport(String codedFileName , String exportColName, String exportTitle, int exportAs, int rowIndex, List<?> dataList, InputStream temp, HttpServletResponse response);

}
