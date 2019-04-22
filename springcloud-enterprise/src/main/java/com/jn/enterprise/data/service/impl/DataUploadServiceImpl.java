package com.jn.enterprise.data.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.data.dao.*;
import com.jn.enterprise.data.entity.*;
import com.jn.enterprise.data.enums.DataUploadConstants;
import com.jn.enterprise.data.enums.DataUploadExceptionEnum;
import com.jn.enterprise.data.enums.TabColumnTypeEnum;
import com.jn.enterprise.data.model.*;
import com.jn.enterprise.data.service.DataUploadService;
import com.jn.enterprise.data.tool.GetTargetTree;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TabVO;
import com.jn.enterprise.data.vo.TargetModelVO;
import com.jn.enterprise.model.ServiceOrg;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.system.vo.SysDepartmentPostVO;
import com.jn.upload.api.UploadClient;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author： yangh
 * @date： Created on 2019/4/11 11:50
 * @version： v1.0
 * @modified By:
 */
@Service
public class DataUploadServiceImpl implements DataUploadService {

    private static Logger logger = LoggerFactory.getLogger(DataUploadServiceImpl.class);
    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired(required = false)
    private TbDataReportingTaskMapper tbDataReportingTaskMapper;

    @Autowired(required = false)
    private TbDataReportingSnapshotModelMapper tbDataReportingSnapshotModelMapper;
    @Autowired(required = false)
    private TbDataReportingSnapshotModelTabMapper tbDataReportingSnapshotModelTabMapper;
    @Autowired(required = false)
    private TbDataReportingSnapshotModelStructMapper tbDataReportingSnapshotModelStructMapper;
    @Autowired(required = false)
    private TbDataReportingSnapshotTargetMapper tbDataReportingSnapshotTargetMapper;
    @Autowired(required = false)
    private TbDataReportingSnapshotTargetGroupMapper tbDataReportingSnapshotTargetGroupMapper;
    @Autowired(required = false)
    private TbDataReportingTaskDataMapper TbDataReportingTaskDataMapper;

    @Autowired
    private UploadClient uploadClient;
    @Autowired
    private TargetDao targetDao;


    @Override
    @ServiceLog(doAction = "企业本月数据上报页面广告获取")
    public Map<String, Set<String>> getCompanyAd(User user) {
        return getAdsFromTask(user,DataUploadConstants.AD_DISPLAY_CLIENT_PC,DataUploadConstants.COMPANY_TYPE);
    }


    @Override
    @ServiceLog(doAction = "园区本月数据上报页面广告获取")
    public Map<String, Set<String>> getGardenAd(User user) {
        return getAdsFromTask(user,DataUploadConstants.AD_DISPLAY_CLIENT_PC,DataUploadConstants.COMPANY_TYPE);
    }

    /**广告页面获取方法*/
    /**
     * 园区广告图片，企业广告图片，分为PC和APP
     */
    private Map<String,Set<String>> getAdsFromTask(User user,String type,String fileType){
        Map<String,String> companyInfo  = getCompanyInfoByAccount(user);
        //账期为上月的任务，所对应的模板的广告连接
        List<String> fillInFormId =getFillId(companyInfo , user);

        String  lastMon=getLastMonth();
        TbDataReportingTaskCriteria tExample = new TbDataReportingTaskCriteria();
        tExample.or().andFormTimeEqualTo(lastMon).andFillInFormIdIn(fillInFormId).andFileTypeEqualTo(new Byte(fileType));
        List<TbDataReportingTask> taskList = tbDataReportingTaskMapper.selectByExample(tExample);

        //查询去年的未填报的任务
        String year = DateUtils.getDate("yyyy-MM-dd").split("-")[0];
        String lastyear = String.valueOf(Integer.parseInt(year)-1);
        tExample.clear();
        tExample.or().andFormTimeEqualTo(lastyear);
        List<TbDataReportingTask> yeartask =tbDataReportingTaskMapper.selectByExample(tExample);
        taskList.addAll(yeartask);
        List<String> taskbatch=new ArrayList<>();
        for(TbDataReportingTask taskBean: taskList){
            taskbatch.add(taskBean.getTaskBatch());
        }

        TbDataReportingSnapshotModelCriteria adExample = new TbDataReportingSnapshotModelCriteria();
        adExample.or().andTaskBatchIn(taskbatch);

        List<TbDataReportingSnapshotModel> modelList = tbDataReportingSnapshotModelMapper.selectByExample(adExample);


        Set<String> urlSet = new HashSet<>();
        for(TbDataReportingSnapshotModel url :modelList){
            if(DataUploadConstants.AD_DISPLAY_CLIENT_APP.equals(type)){
                urlSet.add(url.getAppAd());
            }
            if(DataUploadConstants.AD_DISPLAY_CLIENT_PC.equals(type)){
                urlSet.add(url.getPcAd());
            }

        }

        Map<String ,Set<String>> result = new HashMap<>();
        result.put("adUrls",urlSet);
        return result;
    }



    //获取最新需要填报的信息，这个信息，未逾期，未填报，账期最大（年/月）；
    //如果全部到已经填报
    @Override
    @ServiceLog(doAction = "企业待填报数据获取")
    public PaginationData<List<CompanyDataModel>> getNeedFormList(CompanyDataParamModel param,User user) {

        return getThisMonthTask(param,user,DataUploadConstants.COMPANY_TYPE.getBytes()[0]);
    }

    @Override
    @ServiceLog(doAction = "园区待填报数据获取")
    public PaginationData<List<CompanyDataModel>> getCurrentMonthTasks(CompanyDataParamModel param,User user) {
        return getThisMonthTask(param,user,DataUploadConstants.GARDEN_TYPE.getBytes()[0]);
    }

    /**
     * 园区/企业待上报任务获取
     * @param param
     * @param user
     * @param type
     * @return
     */
    private PaginationData<List<CompanyDataModel>> getThisMonthTask(CompanyDataParamModel param,User user,Byte type){
        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());
        //账期是上月的，未填报的任务,月任务
        String lastMon = getLastMonth();
        String year = DateUtils.getDate("yyyy-MM-dd").split("-")[0];
        String lastyear = String.valueOf(Integer.parseInt(year)-1);

        //计算本月生成的上月的账期
        List<String> formTimeList = new ArrayList<>();
        formTimeList.add(lastMon);
        formTimeList.add(lastyear);
        //获取用户信息
        Map<String,String> companyInfo = getCompanyInfoByAccount(user);
        List<String> fillInFormId =getFillId(companyInfo , user);

        List<CompanyDataModel> taskList = targetDao.getThisMonthTask(formTimeList,fillInFormId,type);

        PaginationData<List<CompanyDataModel>> data = new PaginationData(taskList, objects.getTotal());

        return data;
    }


    /**
     * 企业获取填报历史
     * @return
     */
    @ServiceLog(doAction = "获取企业填报历史")
    @Override
    public PaginationData<List<CompanyDataModel>> getFormedHistory(CompanyDataParamModel param,User user){
        return getHistoryList(param,user,DataUploadConstants.COMPANY_TYPE.getBytes()[0]);
    }


    /**
     * 园区获取填报历史
     * @return
     */
    @ServiceLog(doAction = "获取园区填报历史")
    @Override
    public PaginationData<List<CompanyDataModel>> getHostoryTask(CompanyDataParamModel param,User user){
        return getHistoryList(param,user,DataUploadConstants.GARDEN_TYPE.getBytes()[0]);
    }


    /**
     * 本月填报账期为上月的任务
     * @return
     */
    private String getLastMonth(){
        String lastMonthStr="";
        //0:year,1:month,2:day
        String[]  lastMon=DateUtils.getDate("yyyy-MM-dd").split("-");
        if(Integer.parseInt(lastMon[1]) == DataUploadConstants.ONE_MONTH){
            String mon ="12";
            String lastYear =String.valueOf(Integer.parseInt(lastMon[0])-1);
            lastMonthStr =lastYear+mon;
        }else{
            lastMonthStr = String.valueOf(Integer.parseInt(lastMon[1])-1);
        }
        return lastMonthStr;
    }

    /**
     * 园区/企业获取历史数据
     * @param param
     * @param user
     * @param type
     * @return
     */
    private PaginationData<List<CompanyDataModel>> getHistoryList(CompanyDataParamModel param,User user,Byte type){
        //已填报或者 已逾期

        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());

        //获取当前用户信息，确认填报对象
        Map<String,String> companyInfo  = getCompanyInfoByAccount(user);
        List<String> fillInFormId =getFillId(companyInfo , user);
        //园区或者企业类型获取历史

        List<CompanyDataModel> historyList = targetDao.getHistoryTaskList(param,fillInFormId,type);
        PaginationData<List<CompanyDataModel>> data = new PaginationData(historyList, objects.getTotal());
        return data;
    }

    /**
     * 获取填报对象的ID，如果是企业，则返回企业ID，如果是园区用户，则返回该用户的部门ID
     * @param companyInfo
     * @param user
     * @return
     */
    private List<String> getFillId(Map<String,String> companyInfo ,User user){
        List<String> fillInFormId=new ArrayList<>();
        if(companyInfo==null){
            List<SysDepartmentPostVO> list =  user.getSysDepartmentPostVO();
            for(SysDepartmentPostVO bean:list){
                fillInFormId.add(bean.getDepartmentId());
            }
        }else{
            fillInFormId.add(companyInfo.get("companyCode"));
        }
        return fillInFormId;
    }


    @Override
    @ServiceLog(doAction = "企业获取未填的任务的表单")
    public ModelDataVO getFormStruct(String fileId,User user) {
        String type=DataUploadConstants.NOT_FILL;
        //未填报的不用获取值
        return getModelDataByType(fileId,user,type);
    }

    @Override
    @ServiceLog(doAction = "园区获取未填的任务的表单")
    public ModelDataVO getCurrentMonthForm(String fileId,User user) {

        String type=DataUploadConstants.NOT_FILL;
        //未填报的不用获取值
        ModelDataVO result =  getModelDataByType(fileId,user,type);
        result.setUserDepartmentId(getFillId(null,user));
        return result;
    }

    /**
     * 通过信息获取模板
     * @param fillId
     * @param user
     * @param type 已填报/未填报
     * @return
     */
    private ModelDataVO getModelDataByType(String fillId,User user,String type){
        //获取企业信息
        Map<String,String> companyInfo = getCompanyInfoByAccount(user);
        //获取任务
        TbDataReportingTaskCriteria task = new TbDataReportingTaskCriteria();
        task.or().andFillIdEqualTo(fillId).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                //.andStatusEqualTo(new Byte(type));
        List<TbDataReportingTask> taskList =  tbDataReportingTaskMapper.selectByExample(task);
        if(taskList ==null || taskList.size()==0){
            logger.warn("填报任务未找到！！");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_NOT_EXIST);
        }

        //检测任务是否草稿状态
        String status = taskList.get(0).getStatus().toString();
        if(status.equals(DataUploadConstants.IS_DRAFT)){

        }

        TbDataReportingTask tbDataReportingTask = taskList.get(0);



        //拿出批次号 ， 查询结构信息--模板信息
        TbDataReportingSnapshotModelCriteria snapshotModelCriteria =new TbDataReportingSnapshotModelCriteria();
        snapshotModelCriteria.or().andTaskBatchEqualTo(tbDataReportingTask.getTaskBatch());
        List<TbDataReportingSnapshotModel>  snapshotModelList = tbDataReportingSnapshotModelMapper.selectByExample(snapshotModelCriteria);
        if(snapshotModelList ==null || snapshotModelList.size()==0){
            logger.warn("填报任务的模板未找到！！");
            throw new JnSpringCloudException(DataUploadExceptionEnum.MODEL_IS_NOT_EXIST);
        }
        TbDataReportingSnapshotModel model = snapshotModelList.get(0);
        //拿出批次号 ， 查询结构信息--tab信息
        TbDataReportingSnapshotModelTabCriteria modelTab =new TbDataReportingSnapshotModelTabCriteria();
        modelTab.or().andTaskBatchEqualTo(tbDataReportingTask.getTaskBatch());
        List<TbDataReportingSnapshotModelTab> modelTabList = tbDataReportingSnapshotModelTabMapper.selectByExample(modelTab);

        if(modelTabList ==null || modelTabList.size()==0){
            logger.warn("填报任务的模板表单未找到！！");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TAB_IS_NOT_EXIST);
        }
        //找寻关系信息
        TbDataReportingSnapshotModelStructCriteria  modelStruct =new TbDataReportingSnapshotModelStructCriteria();
        TbDataReportingSnapshotTargetCriteria  targetCriteria = new TbDataReportingSnapshotTargetCriteria();

        TbDataReportingSnapshotTargetGroupCriteria  inputFormat =new TbDataReportingSnapshotTargetGroupCriteria();
        List<TbDataReportingSnapshotTargetGroup> iList =null;

        List<TabVO> tabVOList = new ArrayList<>();
        TabVO tabVO =null;
        for(TbDataReportingSnapshotModelTab tab:modelTabList){
            tabVO = new TabVO();
            modelStruct.clear();
            modelStruct.or().andTaskBatchEqualTo(tbDataReportingTask.getTaskBatch()).andTabIdEqualTo(tab.getTabId());
            List<TbDataReportingSnapshotModelStruct> modelStructList = tbDataReportingSnapshotModelStructMapper.selectByExample(modelStruct);
            List<String> targetListFormTab =new ArrayList<>();
            for(TbDataReportingSnapshotModelStruct struct:modelStructList){
                targetListFormTab.add(struct.getTargetId());
            }

            //通过指标集合查询所有的指标--指标需要生成树,转换类型
            targetCriteria.clear();
            targetCriteria.or().andTargetIdIn(targetListFormTab).andTaskBatchEqualTo(tbDataReportingTask.getTaskBatch());
            List<TbDataReportingSnapshotTarget> tList = tbDataReportingSnapshotTargetMapper.selectByExample(targetCriteria);
            List<TargetModelVO>  targetModelVOList=GetTargetTree.changeToTreeStructure(tList);

            //查询所有的填报格式--tab包含的
            inputFormat.clear();
            inputFormat.or().andTargetIdIn(targetListFormTab).andTaskBatchEqualTo(tbDataReportingTask.getTaskBatch());
            iList = tbDataReportingSnapshotTargetGroupMapper.selectByExample(inputFormat);
            List<InputFormatModel> inputFormatModelList = getInputFormatModelList(iList);

            BeanUtils.copyProperties(tab,tabVO);
            String fillInId=tbDataReportingTask.getFillInFormId();
            String modelId =tbDataReportingTask.getModelId();
            String tabId =tab.getTabId();



            //本期值未填,那增幅列为空
            if(type.equals(DataUploadConstants.NOT_FILL)){
                String modelCycle=model.getModelCycle();
                String formTime=tbDataReportingTask.getFormTime();
                String[] tabColumnType=tab.getTabClumnTargetShow().split(DataUploadConstants.TAB_COLUMN_SEPARTOR);
                //tab的其他列数据
                Map<String,List<InputFormatModel>> otherColumn = new HashMap<>();

                for(int index=0,size=tabColumnType.length;index<size;index++){
                    List<InputFormatModel> history =getLastValue(fillInId,modelId,tabId,formTime,modelCycle,tabColumnType[index],null);
                    if(tabColumnType[index].equals(DataUploadConstants.AMPLIFICATION)){
                        otherColumn.put(TabColumnTypeEnum.AMPLIFICATION.getDesc(),history);
                    }else if(tabColumnType[index].equals(DataUploadConstants.LAST_MONTH_LAST_YEAR)){
                        otherColumn.put(TabColumnTypeEnum.LAST_MONTH_LAST_YEAR.getDesc(),history);
                    }else if(tabColumnType[index].equals(DataUploadConstants.LAST_MONTH)){
                        otherColumn.put(TabColumnTypeEnum.LAST_MONTH.getDesc(),history);
                    }else{
                        otherColumn.put(TabColumnTypeEnum.THIS_MONTH_LAST_YEAR.getDesc(),history);
                    }
                    //设置其他列数据
                    tabVO.setOtherColumn(otherColumn);
                }
            }else{
                //已填报,草稿
                String modelCycle=model.getModelCycle();
                String formTime=tbDataReportingTask.getFormTime();
                String[] tabColumnType=tab.getTabClumnTargetShow().split(DataUploadConstants.TAB_COLUMN_SEPARTOR);

                //获取本期值，并设置值到填报格式中
                TbDataReportingTaskDataCriteria tabData = new TbDataReportingTaskDataCriteria();
                tabData.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tab.getTabId()).andFillIdEqualTo(tbDataReportingTask.getFillId());
                List<TbDataReportingTaskData> data =  TbDataReportingTaskDataMapper.selectByExample(tabData);
                for(InputFormatModel bean :inputFormatModelList){
                    for(TbDataReportingTaskData dataBean:data){
                        if(bean.getFormId().equals(dataBean.getFormId())){
                            bean.setValue(dataBean.getData());
                            break;
                        }
                    }
                }

                //tab的其他列数据
                Map<String,List<InputFormatModel>> otherColumn = new HashMap<>();

                for(int index=0,size=tabColumnType.length;index<size;index++){
                    List<InputFormatModel> history =  getLastValue(fillInId,modelId,tabId,formTime,modelCycle,tabColumnType[index],inputFormatModelList);
                    if(tabColumnType[index].equals(DataUploadConstants.AMPLIFICATION)){
                        otherColumn.put(TabColumnTypeEnum.AMPLIFICATION.getDesc(),history);
                    }else if(tabColumnType[index].equals(DataUploadConstants.LAST_MONTH_LAST_YEAR)){
                        otherColumn.put(TabColumnTypeEnum.LAST_MONTH_LAST_YEAR.getDesc(),history);
                    }else if(tabColumnType[index].equals(DataUploadConstants.LAST_MONTH)){
                        otherColumn.put(TabColumnTypeEnum.LAST_MONTH.getDesc(),history);
                    }else{
                        otherColumn.put(TabColumnTypeEnum.THIS_MONTH_LAST_YEAR.getDesc(),history);
                    }
                }

                //设置其他列数据
                tabVO.setOtherColumn(otherColumn);
            }

            //设置指标信息
            tabVO.setTargetList(targetModelVOList);
            //设置指标对应的填报格式信息
            tabVO.setInputList(inputFormatModelList);
            tabVOList.add(tabVO);
        }
        ModelDataVO modelDataVO = new ModelDataVO();
        CompanyDataModel taskInfo = new CompanyDataModel();

        //设置模板信息
        BeanUtils.copyProperties(snapshotModelList.get(0),modelDataVO);
        modelDataVO.setTabs(tabVOList);
        //设置任务信息
        BeanUtils.copyProperties(tbDataReportingTask,taskInfo);
        modelDataVO.setTaskInfo(taskInfo);
        return modelDataVO;
    }

    /**
     * 获取数据的其他列的账期
     * @param modelCycle
     * @param formTime
     * @param tabColumnType
     * @return
     */
    private String getLastFormTime(String modelCycle,String formTime,String tabColumnType){
        //本月填报的账期的上一个月/上一年为上次的账期
        String formTimeBefore="";

        if(modelCycle.equals(DataUploadConstants.MODEL_CYCLE_MONTH)){
            Integer month = StringUtils.toInteger(formTime.substring(4));

            //上月值//增幅列也需要上月账期进行计算
            if(tabColumnType.equals(DataUploadConstants.LAST_MONTH) ||tabColumnType.equals(DataUploadConstants.AMPLIFICATION) ){
                if(month.equals(DataUploadConstants.ONE_MONTH)){
                    formTimeBefore="12";
                    Integer year = StringUtils.toInteger(formTime.substring(0,4))-1;
                    formTimeBefore = String.valueOf(year)+formTimeBefore;
                }else{
                    formTimeBefore=String.valueOf(StringUtils.toInteger(formTime)-1);
                }
            }

            //上年同期值
            if(tabColumnType.equals(DataUploadConstants.THIS_MONTH_LAST_YEAR)){
                //月
                String mon=formTime.substring(4);
                //去年
                Integer year = StringUtils.toInteger(formTime.substring(0,4))-1;
                //去年同期
                formTimeBefore = String.valueOf(year)+mon;

            }

            //上月去年同期值
            if(tabColumnType.equals(DataUploadConstants.LAST_MONTH_LAST_YEAR)){
                if(month.equals(DataUploadConstants.ONE_MONTH)){
                    //上月值
                    formTimeBefore="12";
                    Integer year = StringUtils.toInteger(formTime.substring(0,4))-1;
                    formTimeBefore = String.valueOf(year)+formTimeBefore;
                    //计算上年


                }else{
                    //上月
                    formTimeBefore=String.valueOf(StringUtils.toInteger(formTime)-1);
                    String mon = formTimeBefore.substring(4);
                    //上年
                    String year = String.valueOf(Integer.parseInt(formTimeBefore.substring(0,4))-1);
                    formTimeBefore=year+mon;
                }
            }
        }else{
            //年
            formTimeBefore=String.valueOf(StringUtils.toInteger(formTime)-1);
        }

        return formTimeBefore;

    }

    /**
     * 获取其他列数据
     * @param companyId 企业ID
     * @param modelId 模板ID
     * @param tabId 当前的TabId
     * @param formTime 当前的账期
     * @param modelCycle 模板填报周期
     * @param tabColumnType TAB需要的列数据类型
     * @return
     */
    private List<InputFormatModel> getLastValue(String companyId,String modelId,String tabId,String formTime,String modelCycle,String tabColumnType,List<InputFormatModel> thisMonthData){
        //根据Tab需要的类型获取账期
        List<InputFormatModel> resultList = null;
        //获取上次账期
        String formTimeBefore=getLastFormTime(modelCycle,formTime,tabColumnType);

        //
        TbDataReportingTaskCriteria example = new TbDataReportingTaskCriteria();
        example.or().andFillInFormIdEqualTo(companyId).andModelIdEqualTo(modelId).andFormTimeEqualTo(formTimeBefore).andStatusEqualTo(new Byte(DataUploadConstants.FILLED));

        //获取上期任务填报的账期，已填报的任务
        List<TbDataReportingTask> taskList =  tbDataReportingTaskMapper.selectByExample(example);
        if(taskList !=null || taskList.size()!=0){
            TbDataReportingTask concertTask =taskList.get(0);
            //value
            TbDataReportingSnapshotModelTabCriteria exampleTab=new TbDataReportingSnapshotModelTabCriteria();
            exampleTab.or().andTaskBatchEqualTo(concertTask.getTaskBatch()).andModelIdEqualTo(modelId).andTabIdEqualTo(tabId);
            List<TbDataReportingSnapshotModelTab> tabList = tbDataReportingSnapshotModelTabMapper.selectByExample(exampleTab);
            if(tabList !=null || tabList.size()!=0){
                TbDataReportingSnapshotModelTab tab = tabList.get(0);
                //获取一个Tab的值
                TbDataReportingTaskDataCriteria tabData = new TbDataReportingTaskDataCriteria();
                tabData.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tab.getTabId()).andFillIdEqualTo(concertTask.getFillId());
                List<TbDataReportingTaskData> data =  TbDataReportingTaskDataMapper.selectByExample(tabData);
                //获取formId从data中
                List<String> formIdList = new ArrayList<>();
                for(TbDataReportingTaskData dataBean:data){
                    formIdList.add(dataBean.getFormId());
                }
                //获取一个指标的填报格式信息
                TbDataReportingSnapshotTargetGroupCriteria targetGroupEx = new TbDataReportingSnapshotTargetGroupCriteria();
                targetGroupEx.or().andFormIdIn(formIdList).andTaskBatchEqualTo(concertTask.getTaskBatch());
                List<TbDataReportingSnapshotTargetGroup> inputList = tbDataReportingSnapshotTargetGroupMapper.selectByExample(targetGroupEx);

                //数据类型转换。转换成VO对象
                resultList = new ArrayList<>();
                InputFormatModel im=null;
                for(TbDataReportingSnapshotTargetGroup tgBean:inputList){
                    //拷贝数据
                    im = new InputFormatModel();
                    BeanUtils.copyProperties(tgBean,im);

                    String value="";
                    Integer rowNum=0;
                    //如果是需要的是增幅列
                    for(TbDataReportingTaskData tdrmBean:data){
                        //如果相等就进行值设置
                        if(tdrmBean.getFormId().equals(tgBean.getFormId())){
                            //增幅值(只能是数字,且不能为空)
                            if(tabColumnType.equals(DataUploadConstants.AMPLIFICATION) && StringUtils.isNotBlank(tdrmBean.getData())  && StringUtils.isNumeric(tdrmBean.getData())){
                                //如果本期值已经填写
                                if(thisMonthData !=null ||thisMonthData.size() !=0){
                                    //当前值的列表，
                                    for(InputFormatModel ifmBean:thisMonthData){

                                        if(ifmBean.getFormId().equals(tdrmBean.getFormId())){
                                            if(StringUtils.isNumeric(ifmBean.getValue()) &&  StringUtils.isNotBlank(ifmBean.getValue())){
                                                Double dValue = (Double.parseDouble(ifmBean.getValue()) - Double.parseDouble(tdrmBean.getData()))/Double.parseDouble(tdrmBean.getData());
                                                if(dValue>0){
                                                    //大于等于零
                                                    dValue = dValue * 100;
                                                    value = String.valueOf(dValue).substring(0,4)+"%";
                                                }else if(dValue==0){
                                                    value="0%";
                                                }else{
                                                    //小于零
                                                    dValue = dValue * 100;
                                                    value = String.valueOf(dValue).substring(0,5)+"%";
                                                }
                                                rowNum = tdrmBean.getRowNum();
                                            }else{
                                                value = "";
                                                rowNum = tdrmBean.getRowNum();
                                            }
                                            break;
                                        }
                                    }
                                }else{
                                    value = "";
                                    rowNum = tdrmBean.getRowNum();
                                }
                            }else{
                                value = tdrmBean.getData();
                                rowNum = tdrmBean.getRowNum();
                            }

                            break;
                        }

                    }
                    im.setValue(value);
                    im.setRowNum(rowNum);
                    resultList.add(im);
                }
            }
        }

        return resultList;
    }


    /**
     * 填报格式类型转换
     * @param iList
     * @return
     */
    private List<InputFormatModel> getInputFormatModelList(List<TbDataReportingSnapshotTargetGroup> iList){
        List<InputFormatModel> result = new ArrayList<>();
        InputFormatModel inputFormatModel =null;
        for(TbDataReportingSnapshotTargetGroup bean:iList){
            inputFormatModel =new InputFormatModel();
            BeanUtils.copyProperties(bean,inputFormatModel);
            result.add(inputFormatModel);
        }
        return result;
    }

    @Override
    @ServiceLog(doAction = "园区填报任务数据进行保存")
    public int saveTaskData(ModelDataVO data,User user){
        return saveData(data,DataUploadConstants.GARDEN_TYPE,user);
    }

    @Override
    @ServiceLog(doAction = "企业填报任务数据进行保存")
    public int saveCompanyFormData(ModelDataVO data,User user){
        return saveData(data,DataUploadConstants.COMPANY_TYPE,user);
    }

    /**
     *
     * @param data
     * @param fillType
     * @param user
     * @return
     */
    private int saveDataAsDraft(ModelDataVO data,String fillType,User user){
        return 0;
    }


    /**
     * 保存数据逻辑
     * @param data
     * @param fillType
     * @param user
     * @return
     */
    private int saveData(ModelDataVO data,String fillType,User user) {
        String fillId = data.getTaskInfo().getFillId();
        String modelId = data.getTaskInfo().getModelId();
        //通过fillId,查询task_Batch;

        //获取出所有的
        List<TbDataReportingTaskData> dataList =null;
        TbDataReportingTaskData dataBean =null;
        data.getTabs().get(0).getInputList();
        for(TabVO tabBean: data.getTabs()){
            dataList = new ArrayList<>();
            List<InputFormatModel> list = tabBean.getInputList();

            for(InputFormatModel ifmBean : list){
                dataBean.setRowNum(ifmBean.getRowNum());
                dataBean.setFormId(ifmBean.getFormId());
                dataBean.setTargetId(ifmBean.getTargetId());
                dataBean.setFillId(fillId);
                dataBean.setTabId(tabBean.getTabId());
                dataBean.setModelId(modelId);
                dataBean.setData(ifmBean.getValue());
                String uuid=UUID.randomUUID().toString().replaceAll("-","");
                dataBean.setFallInFormId(uuid);
                dataList.add(dataBean);
            }
            //数据存储
            targetDao.saveData(dataList);

        }

        //修改改任务的状态为已填报
        String userName = user.getName();

        String filler = user.getAccount();
        String fillerTel = user.getPhone();
        //检测改批次的任务是否已经全部填报完成，

            //全部填报完成后，进行短信的提醒 todo 给指定人发送短信

        return 1;
    }

    @Override
    @ServiceLog(doAction = "企业历史填报任务详情")
    public ModelDataVO getCompanyFormedStruct(String fileId,User user) {

        return getModelStructByHistoryFillId(fileId,user,DataUploadConstants.COMPANY_TYPE);
    }

    @Override
    @ServiceLog(doAction = "园区历史填报任务详情")
    public ModelDataVO getGardenFormStruct(String fileId,User user) {
        return getModelStructByHistoryFillId(fileId,user,DataUploadConstants.COMPANY_TYPE);
    }

    /**
     * 历史填报任务详情
     * @param fileId
     * @param user
     * @param fillType
     * @return
     */
    private ModelDataVO getModelStructByHistoryFillId(String fileId,User user,String fillType){
        ModelDataVO result = null;
        Map<String,String> companyInfo = getCompanyInfoByAccount(user);
        List<String> fillInFormId = getFillId(companyInfo,user);

        TbDataReportingTaskCriteria task = new TbDataReportingTaskCriteria();
        task.or().andFillIdEqualTo(fileId).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID))
                .andFillInFormIdIn(fillInFormId).andFileTypeEqualTo(new Byte(fillType));

        List<TbDataReportingTask> taskList =tbDataReportingTaskMapper.selectByExample(task);
        if(taskList ==null || taskList.size()==0){
            logger.warn("任务ID不存在！！");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_NOT_EXIST);
        }
        TbDataReportingTask concretTask = taskList.get(0);
        //未填报
        if(concretTask.getStatus().toString().equals(DataUploadConstants.NOT_FILL)){
            result = getFormStruct(fileId,user);
        }else{
        //已填报
            result = getModelDataByType(fileId,user,concretTask.getStatus().toString());
        }
        return result;
    }

    /**
     * 通过user获取企业信息
     * @param user
     * @return
     */
    private Map<String,String> getCompanyInfoByAccount(User user){
        Map<String,String> companyInfo = new HashMap<>();
        //获取企业账号
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension==null || userExtension.getData()==null){
            companyInfo=null;
        }else{
            logger.info(userExtension.toString());
            companyInfo.put("companyName",userExtension.getData().getCompanyName());
            companyInfo.put("companyCode",userExtension.getData().getCompanyCode());
        }

        return companyInfo;
    }





    @Override
    @ServiceLog(doAction = "企业数据统计")
    public PaginationData<List<CompanyDataStatisticsModel>> getFormView(CompanyDataStatisticsParamModel param) {

        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());
        List<CompanyDataStatisticsModel> list = targetDao.getStatisticsModel(param,DataUploadConstants.COMPANY_TYPE);
        PaginationData<List<CompanyDataStatisticsModel>> data = new PaginationData(list, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "园区数据统计")
    public PaginationData<List<CompanyDataStatisticsModel>> getStatisticsList(CompanyDataStatisticsParamModel param) {

        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());
        List<CompanyDataStatisticsModel> list = targetDao.getStatisticsModel(param,DataUploadConstants.GARDEN_TYPE);
        PaginationData<List<CompanyDataStatisticsModel>> data = new PaginationData(list, objects.getTotal());
        return data;
    }


    @Override
    @ServiceLog(doAction = "获取企业数据统计信息的详细数据列")
    public PaginationData<List<CompanyDataModel>> getFormList(CompanyDataParamModel param) {
        return getStatisticsListInfo(param,DataUploadConstants.COMPANY_TYPE);
    }


    @Override
    @ServiceLog(doAction = "获取园区数据统计信息的详细数据列")
    public PaginationData<List<CompanyDataModel>> getStatisticsListInfo(CompanyDataParamModel param) {
        return getStatisticsListInfo(param,DataUploadConstants.GARDEN_TYPE);
    }

    /**
     * 获取企业/园区 数据统计列中的详细列表
     * @param param
     * @param fileType
     * @return
     */
    private PaginationData<List<CompanyDataModel>> getStatisticsListInfo(CompanyDataParamModel param,String fileType){
        //  task_batch 模板ID
        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());
        TbDataReportingTaskCriteria example =new TbDataReportingTaskCriteria();
        TbDataReportingTaskCriteria.Criteria c =example.or().andTaskBatchEqualTo(param.getTaskBatch()).andModelIdEqualTo(param.getModelId()).andFileTypeEqualTo(new Byte(fileType));

        //添加状态条件
        if(StringUtils.isNotBlank(param.getStatus())){
            c.andStatusEqualTo(new Byte(param.getStatus().getBytes()[0]));
        }
        //添加企业名称条件
        if(StringUtils.isNotBlank(param.getFillInFormName())){
            c.andFillInFormNameLike(param.getFillInFormName());
        }

        List<TbDataReportingTask> taskList =  tbDataReportingTaskMapper.selectByExample(example);
        List<CompanyDataModel>  list = new ArrayList<>();
        CompanyDataModel dmBean = null;
        for(TbDataReportingTask taskBean :taskList){
            dmBean =new CompanyDataModel();
            BeanUtils.copyProperties(taskBean,dmBean);
            list.add(dmBean);
        }

        PaginationData<List<CompanyDataModel>> result = new PaginationData<>(list,objects.getTotal());
        return result;
    }

    /**
     * 修改截至时间
     * @param taskBatch
     * @param newDeadLine
     * @param modelId
     * @return
     */
    @ServiceLog(doAction = "企业修改截至日期")
    @Override
    public int setDeadlineCompany(String taskBatch,String newDeadLine,String modelId){
        int result=0;
        targetDao.updateDeadline(taskBatch,newDeadLine,modelId,DataUploadConstants.COMPANY_TYPE);
        return result+=1;
    }

    /**
     * 修改截至时间
     * @param taskBatch
     * @param newDeadLine
     * @param modelId
     * @return
     */
    @ServiceLog(doAction = "园区修改截至日期")
    @Override
    public int setDeadline(String taskBatch,String newDeadLine,String modelId){
        int result=0;
        targetDao.updateDeadline(taskBatch,newDeadLine,modelId,DataUploadConstants.GARDEN_TYPE);
        return result+=1;
    }

    /**
     * 企业催报
     * @param taskBatch
     * @param modelId
     * @return
     */
    @ServiceLog(doAction = "企业催报")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int setStatisticsListUrgeCompany(String taskBatch,String modelId){
        int result=0;
        //修改催报次数，最后催报时间，未填报的数据
        targetDao.updateCalling(taskBatch,modelId,DataUploadConstants.COMPANY_TYPE);
        //调用服务发起通知 todo 发送短信，邮件，app
        return result+=1 ;
    }

    /**
     * 园区催报
     * @param taskBatch
     * @param modelId
     * @return
     */
    @ServiceLog(doAction = "园区催报")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int setStatisticsListUrge(String taskBatch,String modelId){
        int result=0;
        //修改催报次数，最后催报时间，未填报的数据
        targetDao.updateCalling(taskBatch,modelId,DataUploadConstants.GARDEN_TYPE);
        //调用服务发起通知 todo 发送短信，邮件，app
        return result+=1 ;
    }

    @Override
    @ServiceLog(doAction = "企业数据统计-填报任务详细信息获取")
    public ModelDataVO getFormedStruct(User user,String fillId){

        return getModelStructByHistoryFillId(fillId,user,DataUploadConstants.COMPANY_TYPE);
    }

    @Override
    @ServiceLog(doAction = "园区数据统计-填报任务详细信息获取")
    public ModelDataVO getStruct(User user,String fillId){

        return getModelStructByHistoryFillId(fillId,user,DataUploadConstants.GARDEN_TYPE);
    }

    //几个导出方法 todo

    //科技园数据导入方法



    /**园区上报数据审核**/

    @ServiceLog(doAction = "数据上报-园区数据上报统计-审核列表")
    public PaginationData<List<GardenCheckModel>> getGardenCheckList(GardenCheckParamModel param){
        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());

        //审核列表：已经填报，有效
        List<GardenCheckModel> dataList = targetDao.getGardenCheckList(param);
        PaginationData<List<GardenCheckModel>> data = new  PaginationData<>(dataList,objects.getTotal());
        return data;
    }


    @ServiceLog(doAction = "数据上报-园区数据上报统计-审核/详情")
    public ModelDataVO getCheckOrLookInfo(String fileId,User user){
        return getModelStructByHistoryFillId(fileId,user,DataUploadConstants.GARDEN_TYPE);
    }



}
