package com.jn.enterprise.data.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.data.dao.*;
import com.jn.enterprise.data.entity.*;
import com.jn.enterprise.data.enums.DataUploadConstants;
import com.jn.enterprise.data.enums.DataUploadExceptionEnum;
import com.jn.enterprise.data.enums.TabColumnTypeEnum;
import com.jn.enterprise.data.model.CompanyDataModel;
import com.jn.enterprise.data.model.CompanyDataParamModel;
import com.jn.enterprise.data.model.InputFormatModel;
import com.jn.enterprise.data.service.DataUploadService;
import com.jn.enterprise.data.tool.GetTargetTree;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TabVO;
import com.jn.enterprise.data.vo.TargetModelVO;
import com.jn.enterprise.enums.RequireExceptionEnum;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.upload.api.UploadClient;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private TbDataReportingSnapshotTarget tbDataReportingSnapshotTarget;
    @Autowired(required = false)
    private TbDataReportingSnapshotModelStructMapper tbDataReportingSnapshotModelStructMapper;
    @Autowired(required = false)
    private TbDataReportingSnapshotTargetMapper tbDataReportingSnapshotTargetMapper;
    @Autowired(required = false)
    private TbDataReportingSnapshotTargetGroupMapper tbDataReportingSnapshotTargetGroupMapper;
    @Autowired(required = false)
    private TbDataReportingModelDataMapper tbDataReportingModelDataMapper;

    @Autowired
    private UploadClient uploadClient;



    @Override
    public Map<String, Object> getAd(User user) {
        Map<String,String> companyInfo = getCompanyInfoByAccount(user);
        TbDataReportingTaskCriteria tbDataReportingTaskCriteria = new TbDataReportingTaskCriteria();
        tbDataReportingTaskCriteria.or().andFillInFormIdEqualTo(companyInfo.get("companyCode")).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        tbDataReportingTaskMapper.selectByExample(tbDataReportingTaskCriteria);
        return null;
    }

    //获取最新需要填报的信息，这个信息，未逾期，未填报，账期最大（年/月）；
    //如果全部到已经填报

    @Override
    public PaginationData<List<CompanyDataModel>> getNeedFormList(CompanyDataParamModel param) {
        return null;
    }

    @Override
    @ServiceLog(doAction = "获取未填的任务，未填报")
    public ModelDataVO getFormStruct(String fileId,User user) {
        String type=DataUploadConstants.NOT_FILL;
        //未填报的不用获取值
        return getModelDataByType(fileId,user,type);
    }

    /**
     * 通过信息获取模板
     * @param fillId
     * @param user
     * @param type 已填报/未填报
     * @return
     */
    private ModelDataVO getModelDataByType(String fillId,User user,String type){
        Map<String,String> companyInfo = getCompanyInfoByAccount(user);
        TbDataReportingTaskCriteria task = new TbDataReportingTaskCriteria();
        task.or().andFillIdEqualTo(fillId).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andStatusEqualTo(new Byte(type));
        List<TbDataReportingTask> taskList =  tbDataReportingTaskMapper.selectByExample(task);
        if(taskList ==null || taskList.size()==0){
            logger.warn("填报任务未找到！！");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_NOT_EXIST);
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
                //已填报//逾期填报
                String modelCycle=model.getModelCycle();
                String formTime=tbDataReportingTask.getFormTime();
                String[] tabColumnType=tab.getTabClumnTargetShow().split(DataUploadConstants.TAB_COLUMN_SEPARTOR);

                //获取本期值，并设置值到填报格式中
                TbDataReportingModelDataCriteria tabData = new TbDataReportingModelDataCriteria();
                tabData.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tab.getTabId()).andFillIdEqualTo(tbDataReportingTask.getFillId());
                List<TbDataReportingModelData> data =  tbDataReportingModelDataMapper.selectByExample(tabData);
                for(InputFormatModel bean :inputFormatModelList){
                    for(TbDataReportingModelData dataBean:data){
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
        String formTimeBefore=getLastFormTime(modelCycle,formTime,tabColumnType);


        TbDataReportingTaskCriteria example = new TbDataReportingTaskCriteria();
        example.or().andFillInFormIdEqualTo(companyId).andModelIdEqualTo(modelId).andFormTimeEqualTo(formTimeBefore).andStatusNotEqualTo(new Byte(DataUploadConstants.NOT_FILL));
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
                TbDataReportingModelDataCriteria tabData = new TbDataReportingModelDataCriteria();
                tabData.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tab.getTabId()).andFillIdEqualTo(concertTask.getFillId());
                List<TbDataReportingModelData> data =  tbDataReportingModelDataMapper.selectByExample(tabData);
                //获取formId从data中
                List<String> formIdList = new ArrayList<>();
                for(TbDataReportingModelData dataBean:data){
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
                    //如果是需要的是增幅列
                    for(TbDataReportingModelData tdrmBean:data){
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

                                            }else{
                                                value = "";
                                            }
                                            break;
                                        }
                                    }
                                }else{
                                    value = "";
                                }
                            }else{
                                value = tdrmBean.getData();
                            }

                            break;
                        }

                    }
                    im.setValue(value);
                    resultList.add(im);
                }
            }
        }

        return resultList;
    }

    /**
     * 通过formId查询出本月的账期值
     * @return
     */
    private String getThisDataByFormId(){
        return null;
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
    public int saveCompanyFormData(ModelDataVO data) {
        data.getTaskInfo().getFillId();
        //通过fillId,查询task_Batch;

        //获取出所有的
        //data.getTabs().get(0).getInputList();

        //6种控件，根据控件类型来进行存储

        return 1;
    }

    @Override
    public ModelDataVO getCompanyFormedStruct(String fileId,User user) {
        ModelDataVO result = null;
        Map<String,String> companyInfo = getCompanyInfoByAccount(user);
        TbDataReportingTaskCriteria task = new TbDataReportingTaskCriteria();
        task.or().andFillIdEqualTo(fileId).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andFillInFormIdEqualTo(companyInfo.get("companyCode"));
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
            logger.warn("企业信息不存在");
            throw new JnSpringCloudException(RequireExceptionEnum.NETWORK_ANOMALY);
        }
        companyInfo.put("companyName",userExtension.getData().getCompanyName());
        companyInfo.put("companyCode",userExtension.getData().getCompanyCode());
        return companyInfo;
    }

}
