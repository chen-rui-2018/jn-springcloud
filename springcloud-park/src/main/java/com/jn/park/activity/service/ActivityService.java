package com.jn.park.activity.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.model.Activity;
import com.jn.park.model.ActivityDetail;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/**
 * 活动
 * @Author: jiangyl
 * @Date: 2018/12/5 16:59
 * @Version v1.0
 * @modified By:
 */
public interface ActivityService {

    /**
     * 查询后台管理活动列表
     * @param activity
     * @return
     */

    PaginationData selectActivityList(Activity activity);

    /**
     * 查询活动详情
     * @param activityId
     * @return
     */
    ActivityDetail getActivityDetailsForManage(String activityId);

    /**
     * 活动状态管理(修改)
     * @param activityId
     * @param state 1可报名 0不可报名
     * @return
     */
    int updateActivityApply(String activityId, String state);

    /**
     * 发布活动/保存草稿
     * @param activity
     * @param account 当前登录用户
     * @return
     */
    int insertOrUpdateActivity(Activity activity, String account);

    /**
     * 删除草稿活动数据
     * @param activityId . 多个id用,拼接
     * @return
     */
    int deleteDraftActivity(String activityId);

    /**
     * 删除活动(已发布列表，需管理员才能删除)
     * @param activityId . 多个id用,拼接
     * @return
     */
    int deleteActivity(String activityId);

    /**
     * 取消活动
     * @param activityId
     * @return
     */
    int cancelActivity(String activityId);

    /**
     * 活动列表App
     * @param typeId
     * @param page
     * @param keyWord
     * @return
     */

    PaginationData activityListSlim(String typeId, Page page, String keyWord);

	 /**
     * 手动发送活动通知接口
     * @param activityId
     * @return
     */
    int sendMsgForActivate(String activityId);

    /**
     * 数据导出  只支持excel（xls和xlsx）导出
     * @param codedFileName 下载文件名  不包含后缀
     * @param exportColName excel导出的字段别名 比如：name,phone
     * @param exportTitle   excel导出字段的标题 比如：姓名，手机
     * @param isMoreHead    是否多行表头  1：多行表头  0：单行表头
     * @param exportAs      导出格式   1：导出xls格式  2：导出为xlsx格式
     * @param rowIndex      多行表头从哪一行开始写数据，一般是多行表头占用行数加1  单行表头传0
     * @param dataList      要导出的数据，一般为查询页面所展示的数据（不支持分页）
     * @param temp          多行表头的模板  单行表头传null
     * @param response      响应
     */
    void exportDataExcel(String codedFileName , String exportColName, String exportTitle, String isMoreHead, int exportAs,int rowIndex,List<?> dataList, InputStream temp, HttpServletResponse response);


}
