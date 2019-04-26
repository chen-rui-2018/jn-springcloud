package com.jn.enterprise.data.service.impl;

import com.jn.common.channel.MessageSource;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.service.Cache;
import com.jn.enterprise.company.dao.TbServiceCompanyMapper;
import com.jn.enterprise.company.entity.TbServiceCompany;
import com.jn.enterprise.company.entity.TbServiceCompanyCriteria;
import com.jn.enterprise.data.dao.*;
import com.jn.enterprise.data.entity.*;
import com.jn.enterprise.data.enums.DataUploadConstants;
import com.jn.enterprise.data.enums.DataUploadExceptionEnum;
import com.jn.enterprise.data.model.WarningTaskModel;
import com.jn.enterprise.data.service.DataTaskTimerService;
import com.jn.news.vo.EmailVo;
import com.jn.system.log.annotation.ServiceLog;
import io.swagger.models.auth.In;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.jn.news.vo.SmsTemplateVo;

import javax.xml.ws.BindingType;
import java.util.*;

/**
 * @author： yangh
 * @date： Created on 2019/4/18 10:40
 * @version： v1.0
 * @modified By:
 */
@Service
@EnableBinding(value = MessageSource.class)
public class DataTaskTimerServiceImpl implements DataTaskTimerService {
    private static Logger logger = LoggerFactory.getLogger(DataTaskTimerServiceImpl.class);

    @Autowired(required = false)
    private TbDataReportingModelMapper modelMapper;
    @Autowired(required = false)
    private TbDataReportingCreateTaskLogMapper taskLogMapper;
    @Autowired(required = false)
    private TbDataReportingGroupCompanyMapper groupCompanyMapper;

    @Autowired(required = false)
    private TbDataReportingSnapshotModelMapper snapshotModelMapper;

    @Autowired(required = false)
    private TbDataReportingTargetMapper targetMapper;
    @Autowired(required = false)
    private TbDataReportingModelTabMapper modelTabMapper;

    @Autowired(required = false)
    private TbDataReportingModelStructMapper modelStructMapper;
    @Autowired(required = false)
    private TbDataReportingTargetGroupMapper targetGroupMapper;
    @Autowired(required = false)
    private TbDataReportingTaskMapper taskMapper;

    @Autowired(required = false)
    private TargetDao targetDao;

    @Autowired(required = false)
    private MessageSource messageSource;

    @Autowired(required = false)
    private TbServiceCompanyMapper tbServiceCompanyMapper;
    @Autowired(required = false)
    private TbDataReportingGardenFillerMapper tbDataReportingGardenFillerMapper;

    @Autowired(required = false)
    private TbDataReportingGroupCompanyMapper tbDataReportingGroupCompanyMapper;
    @Override
    @ServiceLog(doAction = "创建任务")
    public void createTask() {
        //扫描有效的模板，检测是否到了新建任务的时候
        TbDataReportingModelCriteria modelCri = new TbDataReportingModelCriteria();
        modelCri.or().andRecordStatusEqualTo(new Byte(DataUploadConstants.MODEL_STATUS_VALID));
        List<TbDataReportingModel> modelList = modelMapper.selectByExample(modelCri);
        TbDataReportingGroupCompanyCriteria groupCompanyCriteria =new TbDataReportingGroupCompanyCriteria();

        for(TbDataReportingModel modleBean : modelList){

            String taskBatch = UUID.randomUUID().toString().replaceAll("-","");
            String formTime="";
            //是年报还是月报
            //年报
            if(modleBean.getModelCycle().toString().equals(DataUploadConstants.MODEL_CYCLE_YEAR)){
                //创建任务
                String createTime = modleBean.getTaskCreateTime();
                String cyear=createTime.substring(0,4);
                String cmonth=createTime.substring(4,6);
                String cday=createTime.substring(6);
                createTime =cyear+"-"+cmonth+"-"+cday;
                //是否到年报表生成日期
                Date isToCreatedTime = DateUtils.parseDate(createTime);

                Date nowDate = DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"));
                if(isToCreatedTime.getTime()<nowDate.getTime()){
                    continue;
                }
                //计算出任务的账期,并检测任务是否生成 ;
                formTime=String.valueOf(Integer.parseInt(DateUtils.getDate("yyyy-MM-dd").split("-")[0])-1);
                if(taskIsCreated(modleBean,formTime)){
                    continue;
                }

                //固化模板
                boolean result = createHistoryModel(modleBean,taskBatch);
                if(result){
                    continue;
                }

                //企业任务
                if(StringUtils.isNotBlank(modleBean.getGroupId()) && modleBean.getModelType().toString().equals(DataUploadConstants.COMPANY_TYPE)){
                    groupCompanyCriteria.clear();
                    groupCompanyCriteria.or().andGroupIdEqualTo(modleBean.getGroupId());
                    List<TbDataReportingGroupCompany> fillInFormIdList = groupCompanyMapper.selectByExample(groupCompanyCriteria);
                    //创建任务
                    String date = modleBean.getFilllInFormDeadline();
                    String year=date.substring(0,4);
                    String month=date.substring(4,6);
                    String day=date.substring(6);
                    date =year+"-"+month+"-"+day;
                    createConcretTaskForCompany(modleBean,taskBatch,formTime,fillInFormIdList,DateUtils.parseDate(date));

                }else{
                    //园区任务
                    String date = modleBean.getFilllInFormDeadline();
                    String year=date.substring(0,4);
                    String month=date.substring(4,6);
                    String day=date.substring(6);
                    date =year+"-"+month+"-"+day;
                    createConcretTaskForGarden(modleBean,taskBatch,formTime,DateUtils.parseDate(date));
                }

                //记录日志
                createLog(modleBean.getModelId(),formTime);

            }else{
            //月报

                String createTime = DataUploadConstants.DEAD_TYPE_THIS_MONTH+modleBean.getTaskCreateTime();
                Date isToCreatedTime = getDeadLine(createTime);
                Date nowDate = DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd"));
                if(isToCreatedTime.getTime()<nowDate.getTime()){
                    continue;
                }

                //计算出任务的账期(当月生成上月的账期)
                formTime=getFormTime();
                Date deadLine = getDeadLine(modleBean.getFilllInFormDeadline());
                if(taskIsCreated(modleBean,formTime)){
                    continue;
                }

                //固化模板
                boolean result = createHistoryModel(modleBean,taskBatch);
                if(result){
                    continue;
                }

                //企业任务
                if(modleBean.getModelType().toString().equals(DataUploadConstants.COMPANY_TYPE) && StringUtils.isNotBlank(modleBean.getGroupId())){
                    groupCompanyCriteria.clear();
                    groupCompanyCriteria.or().andGroupIdEqualTo(modleBean.getGroupId());
                    List<TbDataReportingGroupCompany> fillInFormIdList  = groupCompanyMapper.selectByExample(groupCompanyCriteria);
                    //创建任务
                    createConcretTaskForCompany(modleBean,taskBatch,formTime,fillInFormIdList,deadLine);

                }else{
                //园区任务

                    createConcretTaskForGarden(modleBean,taskBatch,formTime,deadLine);

                }
                //记录日志
                createLog(modleBean.getModelId(),formTime);

            }
        }
    }

    /**
     * 计算截至日期
     * @return
     */
    private Date getDeadLine(String deadLine){
        Date result =null;
        String deadType = deadLine.substring(0,2);//当月/下月
        Integer deadNum= Integer.parseInt(deadLine.substring(2));
        String deadNumStr=deadLine.substring(2);
        String[] date = DateUtils.getDate("yyyy-MM-dd").split("-");
        Integer year = Integer.parseInt(date[0]);
        String dat="";
        //下月截至
        if(deadType.equals(DataUploadConstants.DEAD_TYPE_NEXT_MONTH)){
            Integer month = Integer.parseInt(date[1]);
            if(month==12){
                deadNumStr = getDeadday(year+1,1,deadNum,deadNumStr);
                dat=String.valueOf(year+1)+"-"+"01";
                result =DateUtils.parseDate(dat+"-"+deadNumStr);
            }else{
                deadNumStr = getDeadday(year,month+1,deadNum,deadNumStr);
                month = month+1;
                dat=String.valueOf(year)+"-"+ (month>10?month:"0"+month);
                result =DateUtils.parseDate(dat+"-"+deadNumStr);
            }
        }else{
            //当月截至date
            //date = date+deadNum;
            Integer month = Integer.parseInt(date[1]);
            deadNumStr = getDeadday(year,month,deadNum,deadNumStr);
            String dStr = date[0]+"-"+date[1]+"-"+deadNumStr;
            result =DateUtils.parseDate(dStr);
        }
        return result;
    }


    /**
     * 获取截至日期的日
     * @param year
     * @param month
     * @param deadNum
     * @param deadNumStr
     * @return
     */
    private String getDeadday(Integer year,Integer month,Integer deadNum,String deadNumStr){
        if(deadNum>=1 && deadNum<=9){
            deadNumStr="0"+deadNum;
        }

        if(month==4 || month==6||month ==9 || month==11 ){
            if(deadNum>30){
                deadNumStr = "30";
            }
            if(deadNum<0){
                deadNumStr = "01";
            }
        }else if(month==2){
            if((year%4==0 && year%100!=0) || year%400==0){
                if(deadNum>29){
                    deadNumStr = "29";
                }
                if(deadNum<0){
                    deadNumStr = "01";
                }
            }else{
                if(deadNum>28){
                    deadNumStr = "28";
                }
                if(deadNum<0){
                    deadNumStr = "01";
                }
            }

        }else{
            if(deadNum>31){
                deadNumStr = "31";
            }
            if(deadNum<0){
                deadNumStr = "01";
            }
        }
        return deadNumStr;
    }

    /**
     * 园区-创建具体指定账期的任务
     * @param modleBean
     * @param taskBatch
     * @param formTime
     * @param deadLine
     */
    private void createConcretTaskForGarden(TbDataReportingModel modleBean, String taskBatch,String formTime,Date deadLine){

        TbDataReportingModelTabCriteria exam = new TbDataReportingModelTabCriteria();
        exam.or().andModelIdEqualTo(modleBean.getModelId()).andStatusEqualTo(new Byte(DataUploadConstants.VALID));
        List<TbDataReportingModelTab>  tabList = modelTabMapper.selectByExample(exam);

        //创建园区任务
        TbDataReportingTask taskBean= new TbDataReportingTask();
        Date creatTime = new Date();
        String id = UUID.randomUUID().toString().replaceAll("-","");
        taskBean.setFillId(id);
        taskBean.setFileType(modleBean.getModelType());
        taskBean.setModelId(modleBean.getModelId());
        taskBean.setTaskBatch(taskBatch);
        taskBean.setFormTime(formTime);
        taskBean.setStatus(new Byte(DataUploadConstants.NOT_FILL));
        taskBean.setCallingTimes(0);
        taskBean.setIsOverdue(new Byte(DataUploadConstants.TASK_IS_NOT_OVERDUE));
        taskBean.setOverdueDays(0);
        taskBean.setCreateTime(creatTime);
        taskBean.setRecordStatus(new Byte(DataUploadConstants.VALID));
        taskBean.setFillInFormDeadline(deadLine);
        taskMapper.insertSelective(taskBean);

        //创建园区任务的填报权限

        if(tabList !=null && tabList.size()>0){

            for(TbDataReportingModelTab tab : tabList){

                TbDataReportingModelStructCriteria structExam = new TbDataReportingModelStructCriteria();
                structExam.or().andModelIdEqualTo(modleBean.getModelId()).andTabIdEqualTo(tab.getTabId());
                List<TbDataReportingModelStruct> structs = modelStructMapper.selectByExample(structExam);
                List<String> targetStr = new ArrayList<>();
                if(structs ==null || structs.size()==0){
                    continue;
                }

                for(TbDataReportingModelStruct structsBean : structs){
                    targetStr.add(structsBean.getTargetId());
                }

                TbDataReportingTargetCriteria tgExamp = new TbDataReportingTargetCriteria();
                tgExamp.or().andTargetIdIn(targetStr).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID))
                        .andDepartmentIdIsNotNull();
                List<TbDataReportingTarget> tglist = targetMapper.selectByExample(tgExamp);

                Map<String,String> department  =new HashMap<>();

                if(tglist ==null || tglist.size()==0){
                    continue;
                }

                List<TbDataReportingGardenFiller> fillerList = new ArrayList<>();
                TbDataReportingGardenFiller fillerBean ;
                for(TbDataReportingTarget targetBean : tglist){
                    if(department.containsKey(targetBean.getDepartmentId())){
                        continue;
                    }
                    //用于存储部门信息,获取唯一的部门
                    department.put(targetBean.getDepartmentId(),targetBean.getDepartmentName());

                    //当前园区任务的某个tab哪些部门可以填报
                    fillerBean = new TbDataReportingGardenFiller();
                    fillerBean.setFillId(id);
                    fillerBean.setDepartmentId(targetBean.getDepartmentId());
                    fillerBean.setDepartmentName(targetBean.getDepartmentName());
                    fillerBean.setTabId(tab.getTabId());
                    fillerBean.setStatus(new Byte(DataUploadConstants.NOT_FILL));
                    fillerBean.setRecordStatus(new Byte(DataUploadConstants.VALID));
                    fillerList.add(fillerBean);
                }

                if(fillerList == null || fillerList.size() ==0){
                    continue;
                }

                targetDao.saveFillerList(fillerList);
            }

            // todo 任务推送
        }


    }


    /**
     * 企业-创建具体指定账期的任务
     * @param taskBatch
     * @param formTime
     * @param fillInFormIdList
     */
    private void createConcretTaskForCompany(TbDataReportingModel modleBean, String taskBatch,String formTime,List<TbDataReportingGroupCompany> fillInFormIdList,Date deadLine){

        List<TbDataReportingTask> dataReportingTasks = new ArrayList<>();
        TbDataReportingTask taskBean =null;
        Date creatTime = new Date();
        for(TbDataReportingGroupCompany companyBean : fillInFormIdList){
            taskBean= new TbDataReportingTask();
            String id = UUID.randomUUID().toString().replaceAll("-","");
            taskBean.setFillId(id);
            taskBean.setFileType(modleBean.getModelType());
            taskBean.setModelId(modleBean.getModelId());
            taskBean.setFillInFormId(companyBean.getCompanyId());
            taskBean.setFillInFormName(companyBean.getCompany());
            taskBean.setTaskBatch(taskBatch);
            taskBean.setFormTime(formTime);
            taskBean.setStatus(new Byte(DataUploadConstants.NOT_FILL));
            taskBean.setCallingTimes(0);
            taskBean.setIsOverdue(new Byte(DataUploadConstants.TASK_IS_NOT_OVERDUE));
            taskBean.setOverdueDays(0);
            taskBean.setCreateTime(creatTime);
            taskBean.setRecordStatus(new Byte(DataUploadConstants.VALID));
            taskBean.setFillInFormDeadline(deadLine);
            dataReportingTasks.add(taskBean);

            // todo 任务推送
        }

        targetDao.saveTaskList(dataReportingTasks);
    }

    /**
     * 创建任务创建日志
     * @param modelId
     * @param formTime
     */
    private void createLog(String modelId,String formTime){
        //插入日志
        TbDataReportingCreateTaskLog logBean = new TbDataReportingCreateTaskLog();
        logBean.setCreateTime(new Date());
        logBean.setId(UUID.randomUUID().toString().replaceAll("-",""));
        logBean.setFormTime(formTime);
        logBean.setModelId(modelId);
        taskLogMapper.insert(logBean);

    }

    /**
     * 固化model相关信息
     * @param model
     * @param taskBatch
     */
    private boolean createHistoryModel(TbDataReportingModel model,String taskBatch){
        boolean result=false;
        //model固化
        TbDataReportingSnapshotModel sM = new TbDataReportingSnapshotModel();
        BeanUtils.copyProperties(model,sM);
        sM.setTaskBatch(taskBatch);
        snapshotModelMapper.insert(sM);

        //tab信息固化
        TbDataReportingModelTabCriteria mtc = new TbDataReportingModelTabCriteria();
        mtc.or().andModelIdEqualTo(model.getModelId());
        List<TbDataReportingModelTab> tabList = modelTabMapper.selectByExample(mtc);
        TbDataReportingSnapshotModelTab tab = null;
        List<String> tabId = new ArrayList<>();
        List<TbDataReportingSnapshotModelTab> tabSnapList = new ArrayList<>();

        for(TbDataReportingModelTab tabBean : tabList){
            tab = new TbDataReportingSnapshotModelTab();
            BeanUtils.copyProperties(tabBean,tab);
            tab.setTaskBatch(taskBatch);
            tabId.add(tabBean.getTabId());
            tabSnapList.add(tab);
        }
        //有就存储
        if(tabSnapList!=null && tabSnapList.size()>0){
            targetDao.saveSnapTablist(tabSnapList);
        }
        //没有，就直接返回
        if(tabId.size()==0){
            result = true;
            return result;
        }
        //查询出Tab,Model,Target之间的关系，并保存这种关系
        TbDataReportingModelStructCriteria modelStructsExample = new TbDataReportingModelStructCriteria();
        modelStructsExample.or().andTabIdIn(tabId).andModelIdEqualTo(model.getModelId());
        List<TbDataReportingModelStruct> modelStructs = modelStructMapper.selectByExample(modelStructsExample);
        TbDataReportingSnapshotModelStruct smsBean ;
        List<TbDataReportingSnapshotModelStruct> snapshotModelStructList = new ArrayList<>();
        List<String> targets = new ArrayList<>();
        for(TbDataReportingModelStruct msBean : modelStructs){
            smsBean = new TbDataReportingSnapshotModelStruct();
            smsBean.setTaskBatch(taskBatch);
            BeanUtils.copyProperties(msBean,smsBean);
            snapshotModelStructList.add(smsBean);
            targets.add(msBean.getTargetId());
        }


        if(snapshotModelStructList !=null && snapshotModelStructList.size()>0){
            targetDao.saveSnapshotModelStruct(snapshotModelStructList);
        }

        if(targets.size()==0){
            result = true;
            return result;
        }

        //指标固化
        TbDataReportingTargetCriteria targetExample = new TbDataReportingTargetCriteria();
        targetExample.or().andTargetIdIn(targets);
        List<TbDataReportingTarget> list = targetMapper.selectByExample(targetExample);
        TbDataReportingSnapshotTarget snapshotTarget =null;
        List<TbDataReportingSnapshotTarget> snapshotTargetList = new ArrayList<>();
        for(TbDataReportingTarget targetBean : list){
            snapshotTarget = new TbDataReportingSnapshotTarget();
            BeanUtils.copyProperties(targetBean,snapshotTarget);
            snapshotTarget.setTaskBatch(taskBatch);
            snapshotTargetList.add(snapshotTarget);
        }

        if(snapshotTargetList!=null && snapshotTargetList.size()>0){
            targetDao.saveSnapshotTarget(snapshotTargetList);
        }
        //指标填报格式固化
        TbDataReportingTargetGroupCriteria tgExample = new TbDataReportingTargetGroupCriteria();
        tgExample.or().andTargetIdIn(targets);
        List<TbDataReportingTargetGroup> targetGroupsList =  targetGroupMapper.selectByExample(tgExample);
        TbDataReportingSnapshotTargetGroup snapshotTargetGroup =null;
        List<TbDataReportingSnapshotTargetGroup> snapshotTargetGroupList = new ArrayList<>();
        for(TbDataReportingTargetGroup tgBean :targetGroupsList){
            snapshotTargetGroup = new TbDataReportingSnapshotTargetGroup();
            BeanUtils.copyProperties(tgBean,snapshotTargetGroup);
            snapshotTargetGroup.setTaskBatch(taskBatch);
            snapshotTargetGroupList.add(snapshotTargetGroup);
        }

        if(snapshotTargetGroupList!=null && snapshotTargetGroupList.size()>0){
            targetDao.saveSnapshotTargetGroup(snapshotTargetGroupList);
        }
        return result;
    }

    /**
     * 获取账期
     * @return
     */
    private String getFormTime(){
        String str="";
        String[] dateStr = DateUtils.getDate("yyyy-MM-dd").split("-");
        //本月是1月份
        if(Integer.parseInt(dateStr[1])==DataUploadConstants.ONE_MONTH){
            String month="12";
            String lastYear = String.valueOf(Integer.parseInt(dateStr[0]));
            str =lastYear +month;
        }else{
        //本月是其他月
            String month = Integer.parseInt(dateStr[1])-1>9?
                    String.valueOf(Integer.parseInt(dateStr[1])-1)
                    :
                    "0"+(Integer.parseInt(dateStr[1])-1);
            str = dateStr[0]+month;
        }

        return str;
    }

    /**
     * 检测指定账期的任务是否已经生成
     * @param modleBean
     * @param formTime
     * @return
     */
    private boolean taskIsCreated(TbDataReportingModel modleBean,String formTime){
        TbDataReportingCreateTaskLogCriteria taskLogCriteria =new TbDataReportingCreateTaskLogCriteria();
        boolean result = false;
        //检测任务是否已经生成
        taskLogCriteria.or().andModelIdEqualTo(modleBean.getModelId()).andFormTimeEqualTo(formTime);
        List<TbDataReportingCreateTaskLog> taskLogList=  taskLogMapper.selectByExample(taskLogCriteria);

        if(taskLogList !=null && taskLogList.size()>0){
            result = true;
        }
        return result;
    }

    @Override
    @ServiceLog(doAction = "更新任务状态及预警")
    public void updateTask(){
        //未填报任务进行状态更新
        targetDao.updateTask(DateUtils.getDate("yyyy-MM-dd"));
    }

    @Override
    @ServiceLog(doAction = "未填报的任务进行提醒")
    public void taskWarning(){

        //获取未填报的任务【1：未填报已逾期，未填报到了提醒日期】
        List<WarningTaskModel> taskList = targetDao.getWarningTask(DateUtils.getDate("yyyy-MM-dd"));

        if(taskList != null && taskList.size()>0){

            for(WarningTaskModel taskBean : taskList){

                String[] warningBy=null;
                if(StringUtils.isNotBlank(taskBean.getWarningBy())){
                    warningBy = taskBean.getWarningBy().split(",");
                }

                for(String menthod :warningBy){
                    //进行提醒
                    if(DataUploadConstants.WARNING_BY_APP.equals(menthod)){
                        //todo

                    }
                    if(DataUploadConstants.WARNING_BY_EMAIL.equals(menthod)){

                        //园区
                        if(taskBean.getFileType().equals(DataUploadConstants.GARDEN_TYPE)){

                            TbDataReportingGardenFillerCriteria example = new TbDataReportingGardenFillerCriteria();
                            example.or().andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andFillIdEqualTo(taskBean.getFillId());
                            List<TbDataReportingGardenFiller> gardenFillers = tbDataReportingGardenFillerMapper.selectByExample(example);
                            if(gardenFillers !=null && gardenFillers.size() >0){
                                for(TbDataReportingGardenFiller gardenFiller : gardenFillers){
                                    //不等于未填报
                                    if(! gardenFiller.getStatus().toString().equals(DataUploadConstants.FILLED)){
                                        //对当前的部门进行预警提示
                                        //获取当前部门预警人的邮箱
                                        sendEmail();
                                    }
                                }
                            }

                        }else{
                        //企业
                            TbServiceCompanyCriteria exp = new  TbServiceCompanyCriteria();
                            exp.or().andIdEqualTo(taskBean.getFillInFormId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                            List<TbServiceCompany> list =  tbServiceCompanyMapper.selectByExample(exp);
                            if(list !=null && list.size()>0){
                               // phone  = list.get(0).get();
                            }

                        }

                    }
                    if(DataUploadConstants.WARNING_BY_SMSTEXT.equals(menthod)){
                        String phone="";
                        StringBuilder message =new StringBuilder();
                        //园区
                        if(taskBean.getFileType().equals(DataUploadConstants.GARDEN_TYPE)){
                            //查询电话

                        }else{
                        //企业,通过企业ID,查询预警人电话
                            TbServiceCompanyCriteria exp = new  TbServiceCompanyCriteria();
                            exp.or().andIdEqualTo(taskBean.getFillInFormId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                            List<TbServiceCompany> list =  tbServiceCompanyMapper.selectByExample(exp);
                            if(list !=null && list.size()>0){
                                phone  = list.get(0).getOwnerPhone();
                            }

                        }

                        message.append("任务名称 ：").append(taskBean.getTaskName());
                        if(taskBean.getInLine() !=0){
                            message.append(",还有").append(taskBean.getInLine()) .append("天逾期！请尽快填报!");
                        }else if(taskBean.getOutLine() !=0){
                            message.append(",已经逾期").append(taskBean.getOutLine()) .append("天！请尽快填报!");
                        }

                        sendSMS(phone,message.toString());
                    }
                }

            }
        }
    }

    /**
     * 短信预警
     * @param phone
     * @param message
     */
    private void sendSMS(String phone,String message){
        if(StringUtils.isEmpty(phone)){
            throw new JnSpringCloudException(DataUploadExceptionEnum.USER_PHONE_IS_NOT_EXIST);
        }
        SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
        smsTemplateVo.setTemplateId("1000");
        String[] m = {phone};
        smsTemplateVo.setMobiles(m);
        String[] t = {message};
        smsTemplateVo.setContents(t);
        logger.info("短信发送成功：接收号码：{},验证码：{}",phone,message);
        messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());

    }



    /**
     * 邮件预警
     */
    private void sendEmail(){
        EmailVo emailVo = new EmailVo();
        emailVo.setEmail("");
        emailVo.setEmailSubject("[白下智慧园区]数据填报任务提醒");
        emailVo.setTemplatesName("");

        //对模板数据进行封装
        Map map = new HashMap();
        map.put("title", ""); //数据填报任务提醒
        map.put("time", DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        if (StringUtils.isNotBlank("企业预警人")) {
            map.put("username", "");
        } else {
            map.put("username", "");
        }
        map.put("content", ""); //任务名称+账期还有几天逾期
        emailVo.setTemplatesDataMap(map);
        emailVo.setTemplateFlag(true);

        //发送邮件
        boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
        if (sendStatus) {
            logger.info("[工作计划] 任务提醒发送成功,workPlanId:{}", "");
        } else {
            logger.error("[工作计划] 任务提醒发送失败,workPlanId:{}", "");
        }
    }
}
