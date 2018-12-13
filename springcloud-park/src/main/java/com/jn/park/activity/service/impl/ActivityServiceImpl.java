package com.jn.park.activity.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.activity.dao.ActivityDetailsMapper;
import com.jn.park.activity.dao.ActivityMapper;
import com.jn.park.activity.dao.TbActivityDetailMapper;
import com.jn.park.activity.dao.TbActivityMapper;
import com.jn.park.activity.entity.TbActivity;
import com.jn.park.activity.entity.TbActivityCriteria;
import com.jn.park.activity.entity.TbActivityDetail;
import com.jn.park.model.ActivitySlim;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.model.Activity;
import com.jn.park.model.ActivityDetail;
import com.jn.park.utils.ExcelUtils;
import com.jn.park.utils.ObjToMapUtil;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.*;

/**
 * @Author: jiangyl
 * @Date: 2018/12/5 17:00
 * @Version v1.0
 * @modified By:
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityDetailsMapper activityDetailsMapper;
    @Autowired
    private TbActivityMapper tbActivityMapper;
    @Autowired
    private TbActivityDetailMapper tbActivityDetailMapper;


    /**
     * 活动可报名
     */
    private static final String ACTIVITY_STATE_TRUE = "1";
    /**
     * 活动不可报名
     */
    private static final String ACTIVITY_STATE_FALSE = "0";
    /**
     * 活动草稿
     */
    private static final String ACTIVITY_STATE_DRAFT = "1";
    /**
     * 活动发布
     */
    private static final String ACTIVITY_STATE_PUBLISH = "2";

    /**
     * 日志组件
     */
    private static Logger logger= LoggerFactory.getLogger(ActivityServiceImpl.class);

    @ServiceLog(doAction = "查询活动列表")
    @Override
    public PaginationData selectActivityList(Activity activity){
        Page<Object> objects = PageHelper.startPage(activity.getPage(), activity.getRows() == 0?15:activity.getRows());
        List<Activity> activities = activityMapper.selectActivityList(activity);
        PaginationData data = new PaginationData(activities, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "查询活动详情")
    @Override
    public ActivityDetail getActivityDetailsForManage(String activityId){
        List<ActivityDetail> activityDetails = activityDetailsMapper.getActivityDetails(activityId);
        if(null == activityDetails||activityDetails.size()==0){
            logger.warn("[活动详情],查询活动详情失败，activityId: {},查询响应条数{}", activityId,activityDetails==null?0:activityDetails.size());
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_RESUT_ERROR);
        }
        return activityDetails.get(0);
    }

    @ServiceLog(doAction = "修改活动报名状态")
    @Override
    public int updateActivityApply(String activityId, String state){
        if(StringUtils.equals(state,ACTIVITY_STATE_FALSE)|| StringUtils.equals(state,ACTIVITY_STATE_TRUE)){
            TbActivity activity = new TbActivity();
            activity.setId(activityId);
            activity.setIsApply(state);
            int i = tbActivityMapper.updateByPrimaryKeySelective(activity);
            if(i==1){
               return i;
            }else{
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_UPDATE_ERROR);
            }
        }else{
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_STATE_ERROR);
        }
    }

    @ServiceLog(doAction = "新增/修改活动")
    @Override
    public int insertOrUpdateActivity(Activity activity,String account){
        if(null == activity.getActiOrder()){
            //如果排序为空，默认值为0.
            activity.setActiOrder(0);
        }
        TbActivity tbActivity = new TbActivity();
        BeanUtils.copyProperties(activity,tbActivity);
        try{
            Date actiStartDate = null ;
            Date actiEndDate = null ;
            Date actiApplyEndDate = null ;
            if(StringUtils.isNotEmpty(activity.getActiStartTime())){
                actiStartDate = DateUtils.parseDate(activity.getActiStartTime(), "yyyy-MM-dd HH:mm:ss");
                tbActivity.setActiStartTime(actiStartDate);
            }
            if(StringUtils.isNotEmpty(activity.getActiEndTime())){
                actiEndDate = DateUtils.parseDate(activity.getActiEndTime(), "yyyy-MM-dd HH:mm:ss");
                tbActivity.setActiEndTime(actiEndDate);
            }
            if(StringUtils.isNotEmpty(activity.getApplyEndTime())){
                actiApplyEndDate = DateUtils.parseDate(activity.getApplyEndTime(), "yyyy-MM-dd HH:mm:ss");
                tbActivity.setApplyEndTime(actiApplyEndDate);
            }
            if(actiStartDate!=null && actiEndDate!=null && actiEndDate.before(actiStartDate)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TIME_ERROR);
            }
            if(null !=actiStartDate && null!= actiApplyEndDate && actiApplyEndDate.after(actiStartDate)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_TIME_ERROR);
            }
            if(StringUtils.isNotEmpty(activity.getApplyStartTime())){
                tbActivity.setApplyStartTime(DateUtils.parseDate(activity.getApplyStartTime()));
            }
            if(StringUtils.isNotEmpty(activity.getMesSendTime())){
                tbActivity.setMesSendTime(DateUtils.parseDate(activity.getMesSendTime()));
            }
        }catch (ParseException e){
            logger.info("新增活动时间转换失败。失败原因{}",e.getMessage(),e);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TIME_PARSE_ERROR);
        }
        if(StringUtils.equals(ACTIVITY_STATE_PUBLISH,activity.getState())){
            //发布时间
            tbActivity.setIssueTime(new Date());
            //TODO jiangyl 调用定时器发送消息
            //TODO jiangyl 调用定时器修改活动状态
            logger.info("添加/修改活动成果，待调用定时器发送消息以及定时修改活动状态---------------------------------------------------");
        }
        TbActivityDetail tbActivityDetail = new TbActivityDetail();
        tbActivityDetail.setActiDetail(activity.getActiDetail());
        int num = 0 ;
        if(StringUtils.isEmpty(activity.getId())){
            //新增
            tbActivity.setCreateTime(new Date());
            tbActivity.setId(UUID.randomUUID().toString());
            tbActivity.setCreateAccount(account);
            num = tbActivityMapper.insert(tbActivity);
            tbActivityDetail.setActivityId(tbActivity.getId());
            tbActivityDetailMapper.insert(tbActivityDetail);
        }else{
            //修改
            tbActivity.setUpdateTime(new Date());
            tbActivity.setUpdateAccount(account);
            TbActivity tbActivity1 = tbActivityMapper.selectByPrimaryKey(activity.getId());
            if(null == tbActivity1){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
            }
            if(StringUtils.equals(tbActivity1.getState(),ACTIVITY_STATE_DRAFT)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_STATE_NOT_DRAFT);
            }
            num = tbActivityMapper.updateByPrimaryKeySelective(tbActivity);
            tbActivityDetail.setActivityId(tbActivity.getId());
            tbActivityDetailMapper.updateByPrimaryKeySelective(tbActivityDetail);
        }
        return num;
    }

    @ServiceLog(doAction = "删除活动草稿")
    @Override
    public int deleteDraftActivity(String activityId){
        String[] split = activityId.split(",");
        TbActivityCriteria tbActivityCriteria = new TbActivityCriteria();
        tbActivityCriteria.createCriteria().andIdIn(Arrays.asList(split));
        List<TbActivity> tbActivities = tbActivityMapper.selectByExample(tbActivityCriteria);
        if(null == tbActivities || tbActivities.size()==0){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_IS_NOT_EXIST_ERROR);
        }
        for(int a=0;a<tbActivities.size();a++){
            //校验是否有非草稿数据
            if(!StringUtils.equals(tbActivities.get(a).getState(),ACTIVITY_STATE_DRAFT)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_DRAFT_DELETE_ERROR);
            }
        }
        TbActivity tbActivity1 = new TbActivity();
        tbActivity1.setId(activityId);
        tbActivity1.setUpdateTime(new Date());
        tbActivity1.setState("5");
        int i1 = tbActivityMapper.updateByExampleSelective(tbActivity1, tbActivityCriteria);
        if(i1>0){
            return i1;
        }else{
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR);
        }
    }

    @ServiceLog(doAction = "删除活动（管理员权限）")
    @Override
    public int deleteActivity(String activityId){
        String[] split = activityId.split(",");
        TbActivityCriteria tbActivityCriteria = new TbActivityCriteria();
        tbActivityCriteria.createCriteria().andIdIn(Arrays.asList(split));
        TbActivity tbActivity = new TbActivity();
        tbActivity.setId(activityId);
        tbActivity.setState("5");
        tbActivity.setUpdateTime(new Date());
        int i1 = tbActivityMapper.updateByExampleSelective(tbActivity, tbActivityCriteria);
        if(i1>0){
           return i1;
        }else{
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR);
        }
    }

    @ServiceLog(doAction = "取消活动")
    @Override
    public int cancelActivity(String activityId){
        TbActivity tbActivity = new TbActivity();
        tbActivity.setId(activityId);
        tbActivity.setState("4");
        int i = tbActivityMapper.updateByPrimaryKeySelective(tbActivity);
        if(i>0){
            return i;
        }else{
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_CANCEL_ERROR);
        }
    }
    @ServiceLog(doAction = "前台简单活动列表")
    @Override
    public PaginationData activityListSlim(String typeId, com.jn.common.model.Page page, String keyWord) {
        int pageNumber = page.getPage();
        int pageSize = page.getRows()==0?15:page.getRows();
        List<ActivitySlim> list = new ArrayList<>();
        String invalid = "0";
        Page<Object> objects= PageHelper.startPage(pageNumber, pageSize, true);
        List<ActivitySlim> activitySlimList=activityMapper.activityListSlim(typeId,keyWord);
        for(ActivitySlim slim : activitySlimList){
            if(invalid.equals(slim.getShowApplyNum())){
                slim.setAvatar(null);
            }
            if(StringUtils.isNotBlank(slim.getAvatar())){
                slim.setAvatarList(Arrays.asList(slim.getAvatar().split(",")));
            }
        }
        return new PaginationData(activitySlimList,objects.getTotal());
    }

    @ServiceLog(doAction = "推动活动消息")
    @Override
    public int sendMsgForActivate(String activityId){
        TbActivity tbActivity = tbActivityMapper.selectByPrimaryKey(activityId);
        if(null == tbActivity){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
        }
        //判断是否为活动开始前24小时之内
        Date actiStartTime = tbActivity.getActiStartTime();
        Date nowDate = new Date();
        Date date = DateUtils.addHours(nowDate, 24);
        if(actiStartTime.after(date)||nowDate.after(actiStartTime)){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_SEND_MSG_TIME_EXPEPTION);
        }else{
            //TODO jiangyl 调用消息接口推送消息。

        }
        return 0;
    }

    /**
     * 数据导出  只支持excel（xls和xlsx）导出
     * @param codedFileName 下载文件名  不包含后缀
     * @param exportColName excel导出的字段别名 比如：name,phone
     * @param exportTitle   excel导出字段的标题 比如：姓名，手机
     * @param isMoreHead    是否多行表头  1：多行表头  0：单行表头
     * @param exportAs      导出格式   1：导出xls格式  2：导出为xlsx格式
     * @param rowIndex      多行表头从哪一行开始写数据，一般是多行表头占用行数加1
     * @param dataList      要导出的数据，一般为查询页面所展示的数据（不支持分页）
     * @param temp          多行表头的模板
     * @param response      响应
     */
    @ServiceLog(doAction = "数据导出")
    @Override
    public void exportDataExcel(String codedFileName , String exportColName, String exportTitle, String isMoreHead,int exportAs, int rowIndex, List<?>dataList, InputStream temp, HttpServletResponse response) {
        //导出入参校验
        exportAs = checkExportParameter(exportColName, exportTitle, isMoreHead, rowIndex, exportAs, dataList, temp);
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

            //（4）单行表头、多行表头
            //单行表头状态值
            String siginHead="0";
            //多行表头状态值
            String moreHead="1";
            if (isMoreHead == null || siginHead.equals(isMoreHead)) {
                //单行表头导出
                String[] title = exportTitle.split(",");
                //数组转换成list
                List<String> titleList= new ArrayList<String>(Arrays.asList(title));
                //导出方法，按照表头、列、数据、导出方式、输出流的顺序放入参数   后缀名是xlsx  ，传递2
                ExcelUtils.exportData(titleList, fieldList, exportList, exportAs, response.getOutputStream());
            }else if(moreHead.equals(isMoreHead)){
                //多行表头导出
                String []title = new String[]{};
                //数组转换成list
                List<String>titleList = new ArrayList<String>(Arrays.asList(title));
                ExcelUtils.exportDataTemplate(titleList, fieldList, exportList, temp, fOut, rowIndex);
            }
        }catch (Exception e){
            logger.info("导出失败，失败原因：{}",e.getMessage());
            throw new JnSpringCloudException(ActivityExceptionEnum.EXPORT_FAILED);
        }
    }

    /**
     * 导出入参校验
     * @param exportColName
     * @param exportTitle
     * @param isMoreHead
     * @param rowIndex
     * @param exportAs
     * @param dataList
     * @param temp
     * @return
     */
    private int checkExportParameter(String exportColName, String exportTitle, String isMoreHead, int rowIndex, int exportAs, List<?> dataList, InputStream temp) {
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
        //单行表头状态值
        String siginHead="0";
        //多行表头状态值
        String moreHead="1";
        //既不是单行表头，又不是多行表头
        if(!(siginHead.equals(isMoreHead) || moreHead.equals(isMoreHead))){
            logger.info("是否多行表头[isMoreHead]值只能是“0”、“1”");
            throw new JnSpringCloudException(ActivityExceptionEnum.EXPORT_PARAMETER_MORE_HEAD);
        }
        //若是多行表头，rowIndex至少是3，导出模板temp不能为空
        if(moreHead.equals(isMoreHead)){
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
