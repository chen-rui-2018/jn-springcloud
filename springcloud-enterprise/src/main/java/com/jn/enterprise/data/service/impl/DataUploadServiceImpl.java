package com.jn.enterprise.data.service.impl;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.channel.MessageSource;
import com.jn.common.enums.CommonExcelExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelListener;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.down.api.DownLoadClient;
import com.jn.enterprise.company.dao.TbServiceCompanyMapper;
import com.jn.enterprise.company.entity.TbServiceCompany;
import com.jn.enterprise.company.entity.TbServiceCompanyCriteria;
import com.jn.enterprise.data.dao.*;
import com.jn.enterprise.data.entity.*;
import com.jn.enterprise.data.enums.DataUploadConstants;
import com.jn.enterprise.data.enums.DataUploadExceptionEnum;
import com.jn.enterprise.data.enums.TabColumnTypeEnum;
import com.jn.enterprise.data.model.*;
import com.jn.enterprise.data.service.DataUploadService;
import com.jn.enterprise.data.tool.GetTargetTree;
import com.jn.enterprise.data.tool.ScientExcelListener;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TabVO;
import com.jn.enterprise.data.vo.TargetModelVO;
import com.jn.news.vo.EmailVo;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.pay.model.PayCallBackNotify;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import com.jn.system.vo.SysDepartmentPostVO;
import com.jn.upload.api.UploadClient;
import com.jn.user.api.UserExtensionClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;

/**
 * @author： yangh
 * @date： Created on 2019/4/11 11:50
 * @version： v1.0
 * @modified By:
 */
@Service
@EnableBinding(value = MessageSource.class)
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
    private TbDataReportingTaskDataMapper tbDataReportingTaskDataMapper;
    @Autowired(required = false)
    private TbServiceCompanyMapper tbServiceCompanyMapper;

    @Autowired(required = false)
    private TbDataReportingGardenFillerMapper tbDataReportingGardenFillerMapper;

    @Autowired(required = false)
    private TbDataReportingGardenCheckAccessMapper tbDataReportingGardenCheckAccessMapper;
    @Autowired(required = false)
    private DelaySendMessageClient delaySendMessageClient;

    @Autowired
    private DownLoadClient downLoadClient;

    @Autowired
    private UploadClient uploadClient;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private TargetDao targetDao;
    @Autowired(required = false)
    private TbDataReportingGardenLinkerMapper tbDataReportingGardenLinkerMapper;
    @Autowired(required = false)
    private MessageSource messageSource;

    /**
     * 检测任务的类型
     * @param fillId
     * @return
     */
    private String getTaskType(String fillId){
        TbDataReportingTask taskBean =  tbDataReportingTaskMapper.selectByPrimaryKey(fillId);
        if(taskBean == null){
            throw  new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_NOT_EXIST);
        }
        return taskBean.getFileType().toString();
    }

    /**
     * 检测用户是否是企业用户
     * @param user
     * @return
     */
    private String getUserType(User user){
        String result="";
        Map<String,String> info =  getCompanyInfoByAccount(user);
        if(info==null){
            result=DataUploadConstants.GARDEN_TYPE;
        }else{
            result=DataUploadConstants.COMPANY_TYPE;
        }
        return result;
    }



    @Override
    @ServiceLog(doAction = "企业本月数据上报页面广告获取")
    public Map<String, Set<String>> getCompanyAd(User user) {
        Map<String,Set<String>> result = null;
        if(getUserType(user).equals(DataUploadConstants.COMPANY_TYPE)){
            //企业
            result = getAdsFromTask(user,DataUploadConstants.AD_DISPLAY_CLIENT_PC,DataUploadConstants.COMPANY_TYPE);
        }else{
            //园区
            result = getGardenAd(user);
        }
        return result;
    }


    @Override
    @ServiceLog(doAction = "园区本月数据上报页面广告获取")
    public Map<String, Set<String>> getGardenAd(User user) {
        return getAdsFromTask(user,DataUploadConstants.AD_DISPLAY_CLIENT_PC,DataUploadConstants.COMPANY_TYPE);
    }

    /**
     * 获取企业的任务批次，归属于当前任务的
     * @return
     */
    private List<String> getCompanyTaskBatches(String lastMon,String lastYear,List<String> fillInFormId){
        List<String> taskbatch=new ArrayList<>();
        TbDataReportingTaskCriteria tExample = new TbDataReportingTaskCriteria();
        tExample.or().andFormTimeEqualTo(lastMon).andFillInFormIdIn(fillInFormId).andFileTypeEqualTo(new Byte(DataUploadConstants.COMPANY_TYPE))
        .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        List<TbDataReportingTask> taskList = tbDataReportingTaskMapper.selectByExample(tExample);


        tExample.clear();
        tExample.or().andFormTimeEqualTo(lastYear).andFileTypeEqualTo(new Byte(DataUploadConstants.COMPANY_TYPE))
        .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        List<TbDataReportingTask> yeartask =tbDataReportingTaskMapper.selectByExample(tExample);
        taskList.addAll(yeartask);

        for(TbDataReportingTask taskBean: taskList){
            taskbatch.add(taskBean.getTaskBatch());
        }
        return taskbatch;

    }




    /**
     * 获取园区的任务批次，归属于当前任务的
     * @return
     */
    private List<String> getGardenTaskBatches(String lastMon,String lastYear,List<String> fillInFormId){
        List<String> taskbatch= targetDao.getGardenTaskBatch(lastMon,lastYear,fillInFormId);
        return taskbatch;
    }


    /**广告页面获取方法*/
    /**
     * 园区广告图片，企业广告图片，分为PC和APP
     */
    private Map<String,Set<String>> getAdsFromTask(User user,String type,String fileType){
        Map<String,String> companyInfo  = getCompanyInfoByAccount(user);
        Map<String ,Set<String>> result = new HashMap<>();
        //账期为上月的任务，所对应的模板的广告连接
        List<String> fillInFormId =getFillId(companyInfo , user);
        //查询去年的未填报的任务
        String year = DateUtils.getDate("yyyy-MM-dd").split("-")[0];
        String lastYear = String.valueOf(Integer.parseInt(year)-1);

        String  lastMon=getLastMonth();
        String lastMonthFormTime = year+lastMon;
        List<String> taskbatch=new ArrayList<>();

        //企业对应的任务批次
        if(companyInfo !=null && companyInfo.size()>0){
            taskbatch = getCompanyTaskBatches(lastMonthFormTime,lastYear,fillInFormId);
        }else{
        //园区对应的任务批次 整个园区的广告
            taskbatch = targetDao.getAllGardenBatch(lastMonthFormTime,lastYear);

        }

        if(taskbatch!= null && taskbatch.size()>0){
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
            result.put("adUrls",urlSet);
        }
        return result;
    }



    //获取最新需要填报的信息，这个信息，未逾期，未填报，账期最大（年/月）；
    //如果全部到已经填报
    @Override
    @ServiceLog(doAction = "企业待填报数据获取")
    public List<CompanyDataModel> getNeedFormList(User user) {
        List<CompanyDataModel> result;
        if(getUserType(user).equals(DataUploadConstants.COMPANY_TYPE)){
            //企业
            result = getThisMonthTask(user,DataUploadConstants.COMPANY_TYPE);
        }else{
            //园区
            result = getThisMonthTask(user,DataUploadConstants.GARDEN_TYPE);
        }
        //return getThisMonthTask(user,DataUploadConstants.COMPANY_TYPE);
        return result;
    }

    @Override
    @ServiceLog(doAction = "园区待填报数据获取")
    public List<CompanyDataModel> getCurrentMonthTasks(User user) {
        return getThisMonthTask(user,DataUploadConstants.GARDEN_TYPE);
    }



    /**
     * 园区/企业待上报任务获取
     * @param user
     * @param type
     * @return
     */
    private List<CompanyDataModel> getThisMonthTask(User user,String type){
        //账期是上月的，未填报的任务,月任务
        String lastMon = getLastMonth();
        String year = DateUtils.getDate("yyyy-MM-dd").split("-")[0];
        String lastyear = String.valueOf(Integer.parseInt(year)-1);

        //计算本月生成的上月的账期
        List<String> formTimeList = new ArrayList<>();
        String lastMonth =  year+lastMon;
        formTimeList.add(year+lastMon);
        formTimeList.add(lastyear);
        //获取用户信息
        Map<String,String> companyInfo = getCompanyInfoByAccount(user);
        List<String> fillInFormId =getFillId(companyInfo , user);

        List<CompanyDataModel> taskList =null;
        //企业
        if(companyInfo !=null && companyInfo.size()>0){
            taskList = targetDao.getThisMonthTask(formTimeList,fillInFormId,new Byte(type));
        }else{
        //园区
            List<String>  taskBatch = getGardenTaskBatches(lastMonth,lastyear,fillInFormId);
            //
            if(taskBatch !=null &&  taskBatch.size() >0){
                taskList = targetDao.getGardenTask(taskBatch);
            }

        }

        return taskList;
    }


    /**
     * 企业获取填报历史
     * @return
     */
    @ServiceLog(doAction = "获取企业填报历史")
    @Override
    public PaginationData<List<CompanyDataModel>> getFormedHistory(CompanyDataParamModel param,User user){

        PaginationData<List<CompanyDataModel>> result;
        if(getUserType(user).equals(DataUploadConstants.COMPANY_TYPE)){
            //企业
            result = getHistoryList(param,user,DataUploadConstants.COMPANY_TYPE);;
        }else{
            //园区
            result = getHistoryList(param,user,DataUploadConstants.GARDEN_TYPE);
        }
        //return getHistoryList(param,user,DataUploadConstants.COMPANY_TYPE);
        return result;
    }


    /**
     * 园区获取填报历史
     * @return
     */
    @ServiceLog(doAction = "获取园区填报历史")
    @Override
    public PaginationData<List<CompanyDataModel>> getHostoryTask(CompanyDataParamModel param,User user){

        return getHistoryList(param,user,DataUploadConstants.GARDEN_TYPE);
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

        if(Integer.valueOf(lastMonthStr)<9){
            lastMonthStr="0"+lastMonthStr;
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
    private PaginationData<List<CompanyDataModel>> getHistoryList(CompanyDataParamModel param,User user,String type){
        //已填报或者 已逾期

        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());

        //获取当前用户信息，确认填报对象
        Map<String,String> companyInfo  = getCompanyInfoByAccount(user);
        List<String> fillInFormId =getFillId(companyInfo , user);
        //园区或者企业类型获取历史
        List<CompanyDataModel> historyList =null;
        //企业
        if(companyInfo!=null && companyInfo.size()>0){
            historyList = targetDao.getHistoryTaskList(param,fillInFormId,new Byte(type));
        }else{
        //园区
            //查询所有园区的填报历史
            historyList = targetDao.getHistoryGardenTaskList(param,new Byte(type));
        }

        PaginationData<List<CompanyDataModel>> data = new PaginationData(historyList, objects.getTotal());
        return data;
    }

    /**
     * 获取用户的部门信息
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


        ModelDataVO result;
        if(getUserType(user).equals(DataUploadConstants.COMPANY_TYPE)){
            //企业
            result = getModelDataByType(fileId,user,type);
        }else{
            //园区
            result = getCurrentMonthForm(fileId,user);
        }


        //未填报的不用获取值
        return result;
    }

    @Override
    @ServiceLog(doAction = "园区获取未填的任务的表单")
    public ModelDataVO getCurrentMonthForm(String fileId,User user) {

        String type=DataUploadConstants.NOT_FILL;
        //未填报的不用获取值
        ModelDataVO result =  getModelDataByType(fileId,user,type);

        //任务的部门权限
        List<GardenFillerAccessModel>  access = new ArrayList<>();
        access = getAccess(fileId, user);

        result.setGardenFiller(access);

        return result;
    }

    /**
     * 获取部门权限
     */

    private List<GardenFillerAccessModel> getAccess(String fileId,User user){
        //任务的部门权限
        TbDataReportingGardenFillerCriteria example = new TbDataReportingGardenFillerCriteria();
        example.or().andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andFillIdEqualTo(fileId);
        List<TbDataReportingGardenFiller> taskAccess = tbDataReportingGardenFillerMapper.selectByExample(example);

        //园区用户的部门集合
        List<String> userAccess = getFillId(null,user);

        //权限集
        List<GardenFillerAccessModel> access = new ArrayList<>();
        GardenFillerAccessModel gardenFillerAccessModel =null;



        List<SysRole> sysRoles =  user.getSysRole();
        List<String> sysRoleIds = new ArrayList<>();
        TbDataReportingGardenCheckAccessCriteria accessCriteria = new TbDataReportingGardenCheckAccessCriteria();
        List<TbDataReportingGardenCheckAccess> dataUploadCheckAccess = null;
        if(sysRoles !=null && sysRoles.size()>0){
            for(SysRole sysRole : sysRoles){
                sysRoleIds.add(sysRole.getId());
            }

            if(sysRoleIds !=null && sysRoleIds.size()>0){
                accessCriteria.or().andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andIdIn(sysRoleIds);
                dataUploadCheckAccess = tbDataReportingGardenCheckAccessMapper.selectByExample(accessCriteria);
            }
        }



        //如果不具备审核权限
        if(dataUploadCheckAccess==null || dataUploadCheckAccess.size()==0){
            for(TbDataReportingGardenFiller gardenFiller : taskAccess){
                //默认没有权限
                boolean hasAccess = false;
                for(String departmentId : userAccess){
                    if(gardenFiller.getDepartmentId().equals(departmentId)){
                        hasAccess = true;
                        break;
                    }
                }
                if(hasAccess){
                    gardenFillerAccessModel = new GardenFillerAccessModel();
                    BeanUtils.copyProperties(gardenFiller,gardenFillerAccessModel);

                    access.add(gardenFillerAccessModel);
                }
            }
        }else{
            //具备审核权限
            for(TbDataReportingGardenFiller gardenFiller : taskAccess){
                BeanUtils.copyProperties(gardenFiller,gardenFillerAccessModel);
                access.add(gardenFillerAccessModel);
            }
        }

        return access;
    }

    /**
     * 检测任务的部门权限不在用户的部门权限中
     * @return
     */
    private boolean notExistDepartment(List<String> userDepartments,String taskTepartment){
        boolean result=true;
        for(int index=0,len=userDepartments.size();index<len;index++){
            if(userDepartments.get(index).equals(taskTepartment)){
                result =false;
            }
        }
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
        modelTab.or().andTaskBatchEqualTo(tbDataReportingTask.getTaskBatch()).andStatusEqualTo(new Byte(DataUploadConstants.VALID));
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
            targetCriteria.or().andTargetIdIn(targetListFormTab).andTaskBatchEqualTo(tbDataReportingTask.getTaskBatch())
                    .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
            List<TbDataReportingSnapshotTarget> tList = tbDataReportingSnapshotTargetMapper.selectByExample(targetCriteria);
            List<TargetModelVO>  targetModelVOList=GetTargetTree.changeToTreeStructure(tList);

            //查询所有的填报格式--tab包含的
            inputFormat.clear();
            inputFormat.or().andTargetIdIn(targetListFormTab).andTaskBatchEqualTo(tbDataReportingTask.getTaskBatch())
                    .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
            iList = tbDataReportingSnapshotTargetGroupMapper.selectByExample(inputFormat);
            List<InputFormatModel> inputFormatModelList = getInputFormatModelList(iList);

            BeanUtils.copyProperties(tab,tabVO);
            if(! tab.getTabCreateType().toString().equals(DataUploadConstants.IS_SCIENT_MODEL)){
                tabVO.setTabClumnType(tab.getTabClumnType().toString());
                tabVO.setTabCreateType(tab.getTabCreateType().toString());
            }
            tabVO.setStatus(tab.getStatus().toString());

            String fillInId=tbDataReportingTask.getFillInFormId();
            String modelId =tbDataReportingTask.getModelId();
            String tabId =tab.getTabId();
            List<InputFormatModel> rows = new ArrayList<>();
            //本期值未填,那增幅列为空
            if(type.equals(DataUploadConstants.NOT_FILL) && tbDataReportingTask.getFileType().toString().equals(DataUploadConstants.GARDEN_TYPE)){
                //if(tbDataReportingTask.getFileType().toString().equals(DataUploadConstants.GARDEN_TYPE)){
                //园区任务未填报时，可能只是有些部门没有填报，有的部门已经填报
                TbDataReportingTaskDataCriteria tabData = new TbDataReportingTaskDataCriteria();
                tabData.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tab.getTabId()).andFillIdEqualTo(tbDataReportingTask.getFillId());
                List<TbDataReportingTaskData> data =  tbDataReportingTaskDataMapper.selectByExample(tabData);
                if(data !=null && data.size()>0){
                    for(InputFormatModel bean :inputFormatModelList){
                        for(TbDataReportingTaskData dataBean:data){
                            if(bean.getFormId().equals(dataBean.getFormId())){
                                bean.setValue(dataBean.getData());
                                bean.setRowNum(dataBean.getRowNum());
                            }
                        }
                    }
                    tabVO.setInputList(inputFormatModelList);
                }else{
                    tabVO.setInputList(inputFormatModelList);
                }
            }else{
                //已填报,草稿
                    //企业
                    //获取本期值，并设置值到填报格式中
                    TbDataReportingTaskDataCriteria tabData = new TbDataReportingTaskDataCriteria();
                    tabData.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tab.getTabId()).andFillIdEqualTo(tbDataReportingTask.getFillId());
                    List<TbDataReportingTaskData> data =  tbDataReportingTaskDataMapper.selectByExample(tabData);

                    for(InputFormatModel bean :inputFormatModelList){
                        for(TbDataReportingTaskData dataBean:data){
                            if(bean.getFormId().equals(dataBean.getFormId())){
                                bean.setValue(dataBean.getData());
                                bean.setRowNum(dataBean.getRowNum());
                            }
                        }
                    }
                    tabVO.setInputList(inputFormatModelList);
            }

            //计算该tab的上期值
            String modelCycle=model.getModelCycle();
            String formTime=tbDataReportingTask.getFormTime();
            String[] tabColumnType=tab.getTabClumnTargetShow().split(DataUploadConstants.TAB_COLUMN_SEPARTOR);
            //如果任务类型为企业的未填报或草稿类型；不能够查看到

            if(tbDataReportingTask.getFileType().toString().equals(DataUploadConstants.COMPANY_TYPE) && tabColumnType !=null && tabColumnType.length>0){
                if(! tbDataReportingTask.getStatus().toString().equals(DataUploadConstants.FILLED)){
                    List<String> tabColumn =new ArrayList<>();
                    String[] tabColumnTypenew ={};
                    for(String tabtype : tabColumnType){
                        if(tabtype.equals(DataUploadConstants.LAST_MONTH_LAST_YEAR) || tabtype.equals(DataUploadConstants.THIS_MONTH_LAST_YEAR) ){
                            continue;
                        }else{
                            tabColumn.add(tabtype);
                        }
                    }
                    tabColumn.toArray(tabColumnTypenew);
                    tabColumnType =tabColumnTypenew;
                }
            }

            //tab的其他列数据
            Map<String,List<InputFormatModel>> otherColumn = new HashMap<>();

            for(int index=0,size=tabColumnType.length;index<size;index++){
                List<InputFormatModel> history =  getLastValue(fillInId,modelId,tabId,formTime,modelCycle,tabColumnType[index],inputFormatModelList);
                if(tabColumnType[index].equals(DataUploadConstants.AMPLIFICATION)){
                    otherColumn.put("增幅",history);
                }else if(tabColumnType[index].equals(DataUploadConstants.LAST_MONTH_LAST_YEAR)){
                    otherColumn.put(getLastFormTime(modelCycle,formTime,tabColumnType[index]),history);
                }else if(tabColumnType[index].equals(DataUploadConstants.LAST_MONTH)){
                    otherColumn.put(getLastFormTime(modelCycle,formTime,tabColumnType[index]),history);
                }else{
                    otherColumn.put(getLastFormTime(modelCycle,formTime,tabColumnType[index]),history);
                }
            }
            //设置其他列数据
            tabVO.setOtherColumn(otherColumn);

            //设置指标信息
            tabVO.setTargetList(targetModelVOList);
            //设置指标对应的填报格式信息

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
        if(StringUtils.isNotBlank(companyId)){
            //有公司的ID为企业任务
            example.or().andFillInFormIdEqualTo(companyId).andModelIdEqualTo(modelId).andFormTimeEqualTo(formTimeBefore).andStatusEqualTo(new Byte(DataUploadConstants.FILLED))
                    .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        }else{
            //园区任务
            example.or().andFillInFormIdIsNull().andModelIdEqualTo(modelId).andFormTimeEqualTo(formTimeBefore).andStatusEqualTo(new Byte(DataUploadConstants.FILLED))
                    .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        }

        //获取上期任务填报的账期，已填报的任务
        List<TbDataReportingTask> taskList =  tbDataReportingTaskMapper.selectByExample(example);
        if(taskList !=null && taskList.size()!=0){
            TbDataReportingTask concertTask =taskList.get(0);
            //value
            TbDataReportingSnapshotModelTabCriteria exampleTab=new TbDataReportingSnapshotModelTabCriteria();
            exampleTab.or().andTaskBatchEqualTo(concertTask.getTaskBatch()).andModelIdEqualTo(modelId).andTabIdEqualTo(tabId)
                    .andStatusEqualTo(new Byte(DataUploadConstants.VALID));
            List<TbDataReportingSnapshotModelTab> tabList = tbDataReportingSnapshotModelTabMapper.selectByExample(exampleTab);
            if(tabList !=null && tabList.size() >0){
                TbDataReportingSnapshotModelTab tab = tabList.get(0);
                //获取一个Tab的值
                TbDataReportingTaskDataCriteria tabData = new TbDataReportingTaskDataCriteria();
                tabData.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tab.getTabId()).andFillIdEqualTo(concertTask.getFillId());
                List<TbDataReportingTaskData> data =  tbDataReportingTaskDataMapper.selectByExample(tabData);
                //获取formId从data中
                List<String> formIdList = new ArrayList<>();
                for(TbDataReportingTaskData dataBean:data){
                    formIdList.add(dataBean.getFormId());
                }
                //获取一个指标的填报格式信息
                TbDataReportingSnapshotTargetGroupCriteria targetGroupEx = new TbDataReportingSnapshotTargetGroupCriteria();
                targetGroupEx.or().andFormIdIn(formIdList).andTaskBatchEqualTo(concertTask.getTaskBatch())
                        .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                List<TbDataReportingSnapshotTargetGroup> inputList = tbDataReportingSnapshotTargetGroupMapper.selectByExample(targetGroupEx);

                //数据类型转换。转换成VO对象
                resultList = new ArrayList<>();
                InputFormatModel im=null;



                for(TbDataReportingSnapshotTargetGroup tgBean:inputList){

                    String value="";
                    Integer rowNum=0;
                    //查询每个值
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
                                                    value = String.valueOf(dValue).substring(0,3)+"%";
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
                                            //拷贝数据
                                            im = new InputFormatModel();
                                            BeanUtils.copyProperties(tgBean,im);
                                            im.setValue(value);
                                            im.setRowNum(rowNum);
                                            resultList.add(im);
                                        }
                                    }
                                }else{
                                    value = "";
                                    rowNum = tdrmBean.getRowNum();
                                    //拷贝数据
                                    im = new InputFormatModel();
                                    BeanUtils.copyProperties(tgBean,im);
                                    im.setValue(value);
                                    im.setRowNum(rowNum);
                                    resultList.add(im);
                                }
                            }else{
                                value = tdrmBean.getData();
                                rowNum = tdrmBean.getRowNum();
                                //拷贝数据
                                im = new InputFormatModel();
                                BeanUtils.copyProperties(tgBean,im);
                                im.setValue(value);
                                im.setRowNum(rowNum);
                                resultList.add(im);
                            }

                            //break;
                        }


                    }

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
            inputFormatModel.setRequired(bean.getRequired().toString());
            inputFormatModel.setRecordStatus(bean.getRecordStatus().toString());
            result.add(inputFormatModel);
        }
        return result;
    }

    @Override
    @ServiceLog(doAction = "园区填报任务数据进行保存")
    @Transactional(rollbackFor = Exception.class)
    public int saveTaskData(ModelDataVO data,User user){
        int result = 0;
        //检测任务的类型是否为科技园模板
        String taskBatch = data.getTaskInfo().getTaskBatch();
        //通过任务的批次查询出镜像的模板Tab
        TbDataReportingSnapshotModelTabCriteria modelTabCriteria =new TbDataReportingSnapshotModelTabCriteria();
        modelTabCriteria.or().andTaskBatchEqualTo(taskBatch).andStatusEqualTo(new Byte(DataUploadConstants.VALID));
        List<TbDataReportingSnapshotModelTab> modelTabs = tbDataReportingSnapshotModelTabMapper.selectByExample(modelTabCriteria);
        if(modelTabs == null ||modelTabs.size()==0){
            throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_ERROR);
        }
        result = saveData(data,DataUploadConstants.GARDEN_TYPE,user);
        return result;
    }


    /**
     * 科技园导入
     * @param multipartFile
     */
    @Override
    @ServiceLog(doAction = "科技园导入")
    @Transactional(rollbackFor = Exception.class)
    public int importData(MultipartFile multipartFile,String formTime,String fillId,String modelId,User user){
        int result=0;

//        String formTime=dataVO.getTaskInfo().getFormTime();
//        String fillId=dataVO.getTaskInfo().getFillId();
//        String modelId=dataVO.getTaskInfo().getModelId();
        //读取表头，并生成一种标识集合数据{'企业名称'：0，‘名称’，1}
        List<Object> dataList = ExcelUtil.readExcel(multipartFile,null);

        //获取标题头
        Object oTitle = dataList.get(0);
        String[] title = formatString(oTitle.toString());
        Map<String,String> companyTaxi =  getTaxi(formTime);


        //获取科技园模板的所有指标和填报格式
        List<TbDataReportingSnapshotTarget>  targetList  = targetDao.getTargetByFillId(fillId);
        List<TbDataReportingSnapshotTargetGroup>  targetGroupsList  =targetDao.getTargetGroupByFillId(fillId);


        //处理数据
        List<TbDataReportingTaskData> saveData = new ArrayList<>();
        TbDataReportingTaskData taskData=null;

        //找到存储纳税人名称的字段的位置
        Integer taxiPersionPos=null;
        for(int pos=0,length=title.length;pos<length;pos++){
            if(title[pos].equals(DataUploadConstants.IS_TAXI_PERSON_COLUMN)){
                taxiPersionPos = pos;
                break;
            }
        }

        if(taxiPersionPos == null ){
            //抛出异常，提示文件中没有纳税人名称列
            throw new JnSpringCloudException(DataUploadExceptionEnum.NO_TAXI_PERSON_TARGET);
        }

        //获取出科技园模板的‘缴纳税收总额’的指标Id和填报格式Id
        List<TbDataReportingSnapshotTargetGroup> sicentTarget = getScientTaxiTargetByFillId(fillId);
        if(sicentTarget == null || sicentTarget.size()==0){
            //抛出异常，提示模板中没有缴纳税收总额指标
            throw new JnSpringCloudException(DataUploadExceptionEnum.NO_TAXI_TARGET);
        }

        for(int index=1,len =dataList.size();index<len;index++){
            //tabId为每个任务的纳税人名称

            String content = "";
            String[] currentData = formatString(dataList.get(index).toString());
            //获取出纳税人名称为tabId
            String companyName=currentData[taxiPersionPos];

            for(int pos=0,length=currentData.length;pos<length;pos++){
                //当前正在处理的指标的名称
                String targetName = title[pos].trim();
                //当前的值
                content=currentData[pos];

                if("null".equals(content)){
                    content = "";
                }

                //通过名称来查找，其在数据库中的指标Id和填报格式Id
                TbDataReportingSnapshotTarget currentTarget  = findTarget(targetName,targetList);

                TbDataReportingSnapshotTargetGroup currentTargetGroups =null;
                //如果不是指标，就在填报格式中查找
                if(currentTarget ==null){

                    if(targetGroupsList ==null ){
                        //该指标不存在填报格式
                        throw new JnSpringCloudException(DataUploadExceptionEnum.EXCEL_TARGET_ISNOT_EXIST);
                    }

                    currentTargetGroups = findTargetGroups(targetName,targetGroupsList);
                    if(currentTargetGroups==null){
                        //传了一个，模板中没有维护的指标。
                        throw new JnSpringCloudException(DataUploadExceptionEnum.NO_TARGET_LIKE_IN_EXCEL);
                    }
                }else{
                    //查询出该指标的填报格式ID,一个指标只有一个填报格式的时候，指标的名称和填报格式的名称是同一个
                    currentTargetGroups = findTargetGroupsByTargetId(currentTarget.getTargetId(),targetGroupsList);

                }

                //以指标的的内容组合值
                taskData = new TbDataReportingTaskData();
                taskData.setTabId(companyName);
                taskData.setFillId(fillId);
                taskData.setTargetId(currentTargetGroups.getTargetId());
                taskData.setFallInFormId(UUID.randomUUID().toString().replaceAll("-",""));
                taskData.setData(content);
                taskData.setRowNum(0);
                taskData.setModelId(modelId);
                taskData.setFormId(currentTargetGroups.getFormId());
                saveData.add(taskData);
                if(saveData.size()>500){
                    //调用数据库接口保存数据
                    targetDao.saveData(saveData);
                    saveData = new ArrayList<>();
                }
            }

            //最后处理本条数据的缴纳税额

            //在企业先导入纳税总额的情况下进行更新
            //通过账期,企业名称来查询,查询出，该企业的纳税总额指标的值
            content = companyTaxi.get(companyName);
            taskData = new TbDataReportingTaskData();
            taskData.setTabId(companyName);
            taskData.setFillId(fillId);
            taskData.setTargetId(sicentTarget.get(0).getTargetId());
            taskData.setFallInFormId(UUID.randomUUID().toString().replaceAll("-",""));
            taskData.setData(content);
            taskData.setRowNum(0);
            taskData.setModelId(modelId);
            taskData.setFormId(sicentTarget.get(0).getFormId());
            if(taskData !=null){
                saveData.add(taskData);
            }
        }

        //写入最后的数据
        if(saveData.size()>0){
            targetDao.saveData(saveData);
        }

        //更新任务的状态

        //fillId
        TbDataReportingTaskCriteria  taskCriteria= new TbDataReportingTaskCriteria();
        taskCriteria.or().andFillIdEqualTo(fillId);
        TbDataReportingTask taskRecord =new TbDataReportingTask();
        taskRecord.setStatus(new Byte(DataUploadConstants.FILLED));
        taskRecord.setUpTime(new Date());
        tbDataReportingTaskMapper.updateByExampleSelective(taskRecord,taskCriteria);

        TbDataReportingGardenFiller gardenFiller = new TbDataReportingGardenFiller();
        gardenFiller.setStatus(new Byte(DataUploadConstants.FILLED));
        gardenFiller.setFiller(user.getAccount());
        gardenFiller.setFillerTel(user.getPhone());
        TbDataReportingGardenFillerCriteria gardenFillerCriteria =new TbDataReportingGardenFillerCriteria();
        gardenFillerCriteria.or().andFillIdEqualTo(fillId);
        tbDataReportingGardenFillerMapper.updateByExampleSelective(gardenFiller,gardenFillerCriteria);


        return result+1;
    }

    /**
     * 查询出指标
     * @param targetName
     * @param targetList
     * @return
     */
    private TbDataReportingSnapshotTarget findTarget(String targetName,List<TbDataReportingSnapshotTarget> targetList){
        TbDataReportingSnapshotTarget result = null;
        for(TbDataReportingSnapshotTarget target :  targetList){
            if(targetName.equals(target.getTargetName())){
                result=target;
                break;
            }
        }
        return result;
    }

    /**
     * 查询出填报格式
     * @param targetName`
     * @param targetList
     * @return
     */
    private TbDataReportingSnapshotTargetGroup findTargetGroups(String targetName,List<TbDataReportingSnapshotTargetGroup> targetList){
        TbDataReportingSnapshotTargetGroup result = null;
        for(TbDataReportingSnapshotTargetGroup targetGroup :  targetList){
            if(targetName.equals(targetGroup.getFormName())){
                result=targetGroup;
                break;
            }
        }
        return result;
    }

    /**
     *
     * @param targetId
     * @param targetList
     * @return
     */
    private TbDataReportingSnapshotTargetGroup findTargetGroupsByTargetId(String targetId,List<TbDataReportingSnapshotTargetGroup> targetList){
        TbDataReportingSnapshotTargetGroup result = null;
        for(TbDataReportingSnapshotTargetGroup targetGroup :  targetList){
            if(targetId.equals(targetGroup.getTargetId())){
                result=targetGroup;
                break;
            }
        }
        return result;
    }






    /**
     * 通过企业名称，账期查询出科技园模板的‘缴纳税收总额’
     */
    private Map<String,String> getTaxi(String formTime){

        //获取出taskBatch
        TbDataReportingTaskCriteria taskCriteria = new TbDataReportingTaskCriteria();
        taskCriteria.or().andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andFormTimeEqualTo(formTime)
                .andFileTypeEqualTo(new Byte(DataUploadConstants.COMPANY_TYPE));
        List<TbDataReportingTask> taskBatches = tbDataReportingTaskMapper.selectByExample(taskCriteria);

        if(taskBatches ==null && taskBatches.size()==0){
            return new HashMap<>();
        }

        List<String> fillId =new ArrayList<>();
        for(TbDataReportingTask taskBean : taskBatches){
            fillId.add(taskBean.getFillId());
        }

        String taskBatch =taskBatches.get(0).getTaskBatch();
        String targetName ="缴纳税收总额";

        //通过关系表，查找出‘缴纳税收总额’指标的ID
        TbDataReportingSnapshotModelStructCriteria structCriteria = new TbDataReportingSnapshotModelStructCriteria();
        structCriteria.or().andTaskBatchEqualTo(taskBatch);
        List<TbDataReportingSnapshotModelStruct> structs = tbDataReportingSnapshotModelStructMapper.selectByExample(structCriteria);
        if(structs ==null && structs.size()==0){
            return new HashMap<>();
        }
        List<String> targets = new ArrayList<>();
        for(TbDataReportingSnapshotModelStruct struct :structs){
            targets.add(struct.getTargetId());
        }

        //存储‘缴纳税总额’的信息
        TbDataReportingSnapshotTarget taxiTarget = null;
        TbDataReportingSnapshotTargetGroup taxiTargetGroup =null;

        TbDataReportingSnapshotTargetCriteria targetCriteria = new TbDataReportingSnapshotTargetCriteria();
        targetCriteria.or().andTargetIdIn(targets).andTaskBatchEqualTo(taskBatch).andTargetNameEqualTo(targetName)
                .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        List<TbDataReportingSnapshotTarget> snapshotTargets = tbDataReportingSnapshotTargetMapper.selectByExample(targetCriteria);

        //如果‘缴纳税收总额’不是指标，那就去填报格式中寻找
        List<TbDataReportingTaskData> taskDataList;
        if(snapshotTargets ==null || snapshotTargets.size()==0 ){
            TbDataReportingSnapshotTargetGroupCriteria targetGroupCriteriaCriteria = new TbDataReportingSnapshotTargetGroupCriteria();
            targetGroupCriteriaCriteria.or().andTargetIdIn(targets).andTaskBatchEqualTo(taskBatch).andFormNameEqualTo(targetName)
                    .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
            List<TbDataReportingSnapshotTargetGroup> snapshotTargetGroups = tbDataReportingSnapshotTargetGroupMapper.selectByExample(targetGroupCriteriaCriteria);

            if(snapshotTargetGroups ==null || snapshotTargetGroups.size()==0){
                return new HashMap<>();
            }
            taxiTargetGroup =snapshotTargetGroups.get(0);

            //批量查询，当前账期，所有企业的‘缴纳税总额’
            TbDataReportingTaskDataCriteria taskDataCriteria =new TbDataReportingTaskDataCriteria();
            taskDataCriteria.or().andFillIdIn(fillId).andFormIdEqualTo(taxiTargetGroup.getFormId());
            taskDataList = tbDataReportingTaskDataMapper.selectByExample(taskDataCriteria);

        }else{
            taxiTarget = snapshotTargets.get(0);

            //批量查询，当前账期，所有企业的‘缴纳税总额’
            TbDataReportingTaskDataCriteria taskDataCriteria =new TbDataReportingTaskDataCriteria();
            taskDataCriteria.or().andFillIdIn(fillId).andTargetIdEqualTo(taxiTarget.getTargetId());
            taskDataList = tbDataReportingTaskDataMapper.selectByExample(taskDataCriteria);
        }

        //整合数据Map<企业名称，纳税值>
        Map<String,String> result = new HashMap<>();

        for(TbDataReportingTask taskBean : taskBatches){
            for(TbDataReportingTaskData taskData :taskDataList){
                if(taskBean.getFillId().equals(taskData.getFillId())){
                    result.put(taskBean.getFillInFormName(),taskData.getData());
                    break;
                }
            }
        }

        return result;
    }


    /**
     * 将字符串转换成数组格式
     * @param oTitle
     * @return
     */
    private String[] formatString(String oTitle){
        //['xxx','xxx','xxx']
        String title = oTitle.toString();
        //去掉左右的框号
        title = title.substring(1,title.length()-1);
        //标题的集合
        String[] titles = title.split(",");
        for(int i=0;i<titles.length;i++){
            titles[i] = titles[i].trim();
        }
        return titles;
    }


    @Override
    @ServiceLog(doAction = "企业填报任务数据进行保存")
    @Transactional(rollbackFor = Exception.class)
    public int saveCompanyFormData(ModelDataVO data,User user){
        int result=0;
        if(getUserType(user).equals(DataUploadConstants.COMPANY_TYPE)){
            result= saveData(data,DataUploadConstants.COMPANY_TYPE,user);
        }else{
            result = saveTaskData(data,user);
        }
        //return saveData(data,DataUploadConstants.COMPANY_TYPE,user);
        return result;
    }



    @Override
    @ServiceLog(doAction = "园区填报任务数据进行保存")
    @Transactional(rollbackFor = Exception.class)
    public int saveTaskDataAsDraft(ModelDataVO data,User user){
        return saveDataAsDraft(data,DataUploadConstants.GARDEN_TYPE,user);
    }

    @Override
    @ServiceLog(doAction = "企业填报任务数据进行保存")
    @Transactional(rollbackFor = Exception.class)
    public int saveCompanyFormDataAsDraft(ModelDataVO data,User user){
        int result =0;
        if(getUserType(user).equals(DataUploadConstants.COMPANY_TYPE)){
            result = saveDataAsDraft(data,DataUploadConstants.COMPANY_TYPE,user);
        }else{
            result = saveTaskDataAsDraft(data,user);
        }
        //return saveDataAsDraft(data,DataUploadConstants.COMPANY_TYPE,user);
        return result;
    }

    /**
     *
     * @param data
     * @param fillType
     * @param user
     * @return
     */
    private int saveDataAsDraft(ModelDataVO data,String fillType,User user){
        int resultData=0;
        //保存值
        String fillId = data.getTaskInfo().getFillId();
        String modelId = data.getTaskInfo().getModelId();
        String taskBatch = data.getTaskInfo().getTaskBatch();
        String departmentId=data.getDepartmentId();
        //获取出所有的
        List<TbDataReportingTaskData> dataList =null;
        TbDataReportingTaskData dataBean =null;


        if(data.getTabs() ==null || data.getTabs().size()==0){
            throw new JnSpringCloudException(DataUploadExceptionEnum.VALUE_NOT_EXIST);
        }
        TbDataReportingSnapshotModelStructCriteria sexamp  =new TbDataReportingSnapshotModelStructCriteria();
        TbDataReportingSnapshotTargetGroupCriteria targetGroupExample = new  TbDataReportingSnapshotTargetGroupCriteria();

        for(TabVO tabBean: data.getTabs()){
            dataList = new ArrayList<>();
            //获取出模板中,指标Tab标准的填写格式列表
            sexamp.clear();
            sexamp.or().andModelIdEqualTo(modelId).andTaskBatchEqualTo(taskBatch).andTabIdEqualTo(tabBean.getTabId());

            List<TbDataReportingSnapshotModelStruct>   modelStructList = tbDataReportingSnapshotModelStructMapper.selectByExample(sexamp);

            if(modelStructList ==null || modelStructList.size()==0){
                //抛出异常，传入的信息错误
                throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_ERROR);
            }

            List<String> tgList = new ArrayList<>();
            for(TbDataReportingSnapshotModelStruct structBean : modelStructList){
                tgList.add(structBean.getTargetId());
            }

            List<TbDataReportingSnapshotTargetGroup> snapshotTargetGroupList ;
            //企业指标
            if(DataUploadConstants.COMPANY_TYPE.equals(fillType)){
                targetGroupExample.clear();
                targetGroupExample.or().andTargetIdIn(tgList).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andTaskBatchEqualTo(taskBatch)
                        .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                snapshotTargetGroupList = tbDataReportingSnapshotTargetGroupMapper.selectByExample(targetGroupExample);


                //检测当前账期的科技园任务是否已经导入，如果导入了,则返回科技园的任务ID和批次号，在将税收总额更新进行，本期的科技园没有导入，则不做操作
                List<TbDataReportingTask> isImport = checkThisFormTimeScientIsImport(data.getTaskInfo().getFormTime());
                if(isImport !=null && isImport.size()>0){
                    //检测本次任务中是否存在，缴纳税收总额字段，且不为空,且返回指标ID和formId
                    List<TbDataReportingSnapshotTargetGroup> haveTaxi = checkIsHaveTaxiProperty(data.getTaskInfo().getFillId());

                    //获取出科技园模板的‘缴纳税收总额’的指标Id和填报格式Id
                    List<TbDataReportingSnapshotTargetGroup> sicentTarget = getScientTaxiTargetByFillId(isImport.get(0).getFillId());

                    if(sicentTarget == null || sicentTarget.size() <0){
                        // 科技园模板没有维护‘缴纳税收总额’指标 （无处可插入值）
                        throw new JnSpringCloudException(DataUploadExceptionEnum.NO_TAXI_TARGET);
                    }
                    //如果是‘缴纳税收总额’
                    if(haveTaxi !=null && haveTaxi.size()>0 && tabBean.getInputList() !=null && tabBean.getInputList().size()>0){
                        List<InputFormatModel> inputFormatModelList = tabBean.getInputList();
                        for(int index=0,len =inputFormatModelList.size();index<len;index++){
                            if(inputFormatModelList.get(index).getFormId().equals(haveTaxi.get(0).getFormId()) && inputFormatModelList.get(index).getTargetId().equals(haveTaxi.get(0).getTargetId())){
                                //不为空时进行更新
                                if(StringUtils.isNotBlank(inputFormatModelList.get(index).getValue())){
                                    updateTaxiToScientTarget(inputFormatModelList.get(index).getValue(),isImport.get(0).getFillId(),sicentTarget.get(0).getFormId(),sicentTarget.get(0).getTargetId(),data.getTaskInfo().getFillInFormName());
                                    break;
                                }
                            }
                        }
                    }
                }

            }else{
                //园区指标
                //查询出部门的指标
                TbDataReportingSnapshotTargetCriteria targetExample = new  TbDataReportingSnapshotTargetCriteria();
                targetExample.or().andTaskBatchEqualTo(taskBatch).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID))
                        .andTargetIdIn(tgList).andTargetTypeEqualTo(new Byte(DataUploadConstants.GARDEN_TYPE))
                        .andDepartmentIdEqualTo(departmentId).andTargetTypeEqualTo(new Byte(DataUploadConstants.GARDEN_TYPE));

                List<TbDataReportingSnapshotTarget>  snapshotTargetList= tbDataReportingSnapshotTargetMapper.selectByExample(targetExample);


                for(TbDataReportingSnapshotTarget targetBean : snapshotTargetList){
                    tgList.add(targetBean.getTargetId());
                }

                targetGroupExample.clear();
                targetGroupExample.or().andTargetIdIn(tgList).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andTaskBatchEqualTo(taskBatch);
                snapshotTargetGroupList = tbDataReportingSnapshotTargetGroupMapper.selectByExample(targetGroupExample);

            }

            if(snapshotTargetGroupList ==null || snapshotTargetGroupList.size()==0){
                //抛出异常，传入的信息错误
                throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_ERROR);
            }

            for(TbDataReportingSnapshotTargetGroup snapshotTargetGroup : snapshotTargetGroupList){

                boolean result = checkValue(modelId,tabBean.getTabId(),fillId, snapshotTargetGroup, tabBean.getInputList(),dataList);

                if(result){
                    //没有找到；前端/或数据被篡改,某些指标填写格式没有被上传。不予保存
                    throw new JnSpringCloudException(DataUploadExceptionEnum.INPUT_IS_ERROR);
                }
            }

            //数据存储
            if(dataList !=null && dataList.size()>0){
                if(DataUploadConstants.COMPANY_TYPE.equals(data.getTaskInfo().getFileType().toString())){
                    //删除之前的草稿
                    TbDataReportingTaskDataCriteria taskDataCriteria = new TbDataReportingTaskDataCriteria();
                    taskDataCriteria.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tabBean.getTabId()).andTargetIdIn(tgList)
                            .andFillIdEqualTo(data.getTaskInfo().getFillId());
                    tbDataReportingTaskDataMapper.deleteByExample(taskDataCriteria);

                    //未填报状态；直接写入数据
                    targetDao.saveData(dataList);
                }else {

                    TbDataReportingTaskDataCriteria taskDataCriteria = new TbDataReportingTaskDataCriteria();
                    taskDataCriteria.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tabBean.getTabId()).andTargetIdIn(tgList);
                    List<TbDataReportingTaskData> dataset = tbDataReportingTaskDataMapper.selectByExample(taskDataCriteria);
                    //更新
                    if (dataset != null && dataset.size() > 0) {
                        List<TbDataReportingTaskData> dbList = new ArrayList<>();
                        TbDataReportingTaskDataCriteria taskDataCriteriaBean = new TbDataReportingTaskDataCriteria();
                        TbDataReportingSnapshotTargetCriteria taretInfoCriteriaBean = new TbDataReportingSnapshotTargetCriteria();

                        //检测 获取出该任务填报过的所有值，然后和，用户传上来的值进行比较；如果不存在则从数据库中删除该数据，防止出现用户删不掉
                        taskDataCriteriaBean.or().andFillIdEqualTo(fillId).andTabIdEqualTo(tabBean.getTabId()).andModelIdEqualTo(modelId);
                        List<TbDataReportingTaskData>  beforeValue = tbDataReportingTaskDataMapper.selectByExample(taskDataCriteriaBean);
                        List<String>  fallInFormIds = new ArrayList<>();
                        for(TbDataReportingTaskData beforeBean : beforeValue){
                            //不存在时为true
                            boolean isNotExist = true;
                            for(TbDataReportingTaskData  nowData : dataList){
                                //存在时将标志位修改为false
                                if(nowData.getFormId().equals(beforeBean.getFormId())  && nowData.getRowNum().equals(beforeBean.getRowNum()) && nowData.getTargetId().equals(beforeBean.getTargetId())){
                                    isNotExist =false;
                                    break;
                                }
                            }
                            if(isNotExist){
                                fallInFormIds.add(beforeBean.getFallInFormId());
                            }
                        }
                        if(fallInFormIds !=null && fallInFormIds.size()>0){
                            taskDataCriteriaBean.clear();
                            taskDataCriteriaBean.or().andFallInFormIdIn(fallInFormIds).andFillIdEqualTo(data.getTaskInfo().getFillId());
                            //删除掉用户删除的值
                            tbDataReportingTaskDataMapper.deleteByExample(taskDataCriteriaBean);
                        }

                        TbDataReportingTaskData updateRecord = null;
                        for (TbDataReportingTaskData dbean : dataList) {
                            taskDataCriteriaBean.clear();
                            updateRecord = new TbDataReportingTaskData();
                            updateRecord.setData(dbean.getData());
                            updateRecord.setFillId(fillId);
                            taskDataCriteriaBean.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tabBean.getTabId()).andTargetIdEqualTo(dbean.getTargetId()).andFillIdEqualTo(fillId)
                                    .andFormIdEqualTo(dbean.getFormId()) .andRowNumEqualTo(dbean.getRowNum());
                            taretInfoCriteriaBean.clear();
                            taretInfoCriteriaBean.or().andTargetIdEqualTo(dbean.getTargetId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID))
                                    .andTaskBatchEqualTo(taskBatch).andDepartmentIdEqualTo(data.getDepartmentId());
                            List<TbDataReportingSnapshotTarget> targetList = tbDataReportingSnapshotTargetMapper.selectByExample(taretInfoCriteriaBean);
                            if(targetList !=null && targetList.size()>0){


                                List<TbDataReportingTaskData> resultSize =  tbDataReportingTaskDataMapper.selectByExample(taskDataCriteriaBean);
                                tbDataReportingTaskDataMapper.updateByExampleSelective(updateRecord,taskDataCriteriaBean);

                                if(resultSize ==null || resultSize.size() ==0){
                                    dbList.add(dbean);
                                }
                            }

                        }

                        if (dbList != null && dbList.size() > 0) {
                            targetDao.saveData(dbList);
                        }
                    }else{
                        //保存
                        targetDao.saveData(dataList);
                    }
                }
            }

        }

        //修改任务的状态为草稿
        //企业
        if(fillType.equals(DataUploadConstants.COMPANY_TYPE)){
            TbDataReportingTask  record = new TbDataReportingTask();
            record.setStatus(new Byte(DataUploadConstants.IS_DRAFT));
            record.setFiller(user.getAccount());
            record.setFillerTel(user.getPhone());
            TbDataReportingTaskCriteria examp = new TbDataReportingTaskCriteria();
            examp.or().andFillIdEqualTo(fillId);
            tbDataReportingTaskMapper.updateByExampleSelective(record,examp);
        }else{
        //园区
            TbDataReportingGardenFiller gardenFiller = new TbDataReportingGardenFiller();
            gardenFiller.setStatus(new Byte(DataUploadConstants.IS_DRAFT));
            gardenFiller.setFiller(user.getAccount());
            gardenFiller.setFillerTel(user.getPhone());
            TbDataReportingGardenFillerCriteria gardenFillerCriteria =new TbDataReportingGardenFillerCriteria();
            gardenFillerCriteria.or().andDepartmentIdEqualTo(data.getDepartmentId()).andFillIdEqualTo(fillId);
            tbDataReportingGardenFillerMapper.updateByExampleSelective(gardenFiller,gardenFillerCriteria);
        }
        return resultData++;

    }


    /**
     * 保存数据逻辑
     * @param data
     * @param fillType
     * @param user
     * @return
     */
    private int saveData(ModelDataVO data,String fillType,User user) {

        int saveDataResult=1;
        String departmentId=data.getDepartmentId();
        //获取出所有的
        List<TbDataReportingTaskData> dataList =null;
        TbDataReportingTaskData dataBean =null;
        data.getTabs().get(0).getInputList();
        //任务信息准备
        String fillId = data.getTaskInfo().getFillId();
        String taskBatch = data.getTaskInfo().getTaskBatch();
        String modelId = data.getTaskInfo().getModelId();
        //查询条件准备
        TbDataReportingSnapshotModelStructCriteria examp  =new TbDataReportingSnapshotModelStructCriteria();
        TbDataReportingSnapshotTargetGroupCriteria targetGroupExample = new  TbDataReportingSnapshotTargetGroupCriteria();

        for(TabVO tabBean: data.getTabs()){
            dataList = new ArrayList<>();
            //获取出模板中,指标Tab标准的填写格式列表
            examp.clear();
            examp.or().andModelIdEqualTo(modelId).andTaskBatchEqualTo(taskBatch).andTabIdEqualTo(tabBean.getTabId());
            List<TbDataReportingSnapshotModelStruct>   modelStructList = tbDataReportingSnapshotModelStructMapper.selectByExample(examp);

            if(modelStructList ==null || modelStructList.size()==0){
                //抛出异常，传入的信息错误
                throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_ERROR);
            }

            List<String> tgList = new ArrayList<>();
            for(TbDataReportingSnapshotModelStruct structBean : modelStructList){
                tgList.add(structBean.getTargetId());
            }

            List<TbDataReportingSnapshotTargetGroup> snapshotTargetGroupList ;
            //企业指标
            if(DataUploadConstants.COMPANY_TYPE.equals(fillType)){
                targetGroupExample.clear();
                targetGroupExample.or().andTargetIdIn(tgList).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andTaskBatchEqualTo(taskBatch)
                .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                snapshotTargetGroupList = tbDataReportingSnapshotTargetGroupMapper.selectByExample(targetGroupExample);


                //检测当前账期的科技园任务是否已经导入，如果导入了,则返回科技园的任务ID和批次号，在将税收总额更新进行，本期的科技园没有导入，则不做操作
                List<TbDataReportingTask> isImport = checkThisFormTimeScientIsImport(data.getTaskInfo().getFormTime());
                if(isImport !=null && isImport.size()>0){
                    //检测本次任务中是否存在，缴纳税收总额字段，且不为空,且返回指标ID和formId
                    List<TbDataReportingSnapshotTargetGroup> haveTaxi = checkIsHaveTaxiProperty(data.getTaskInfo().getFillId());

                    //获取出科技园模板的‘缴纳税收总额’的指标Id和填报格式Id
                    List<TbDataReportingSnapshotTargetGroup> sicentTarget = getScientTaxiTargetByFillId(isImport.get(0).getFillId());

                    if(sicentTarget == null || sicentTarget.size() <0){
                        // 科技园模板没有维护‘缴纳税收总额’指标 （无处可插入值）
                        throw new JnSpringCloudException(DataUploadExceptionEnum.NO_TAXI_TARGET);
                    }
                    //如果是‘缴纳税收总额’
                    if(haveTaxi !=null && haveTaxi.size()>0 && tabBean.getInputList() !=null && tabBean.getInputList().size()>0){
                        List<InputFormatModel> inputFormatModelList = tabBean.getInputList();
                        for(int index=0,len =inputFormatModelList.size();index<len;index++){
                            if(inputFormatModelList.get(index).getFormId().equals(haveTaxi.get(0).getFormId()) && inputFormatModelList.get(index).getTargetId().equals(haveTaxi.get(0).getTargetId())){
                                //不为空时进行更新
                                if(StringUtils.isNotBlank(inputFormatModelList.get(index).getValue())){
                                    updateTaxiToScientTarget(inputFormatModelList.get(index).getValue(),isImport.get(0).getFillId(),sicentTarget.get(0).getFormId(),sicentTarget.get(0).getTargetId(),data.getTaskInfo().getFillInFormName());
                                    break;
                                }
                            }
                        }
                    }
                }

            }else{
            //园区指标
                //查询出部门的指标
                TbDataReportingSnapshotTargetCriteria targetExample = new  TbDataReportingSnapshotTargetCriteria();
                targetExample.or().andTaskBatchEqualTo(taskBatch).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID))
                        .andTargetIdIn(tgList).andTargetTypeEqualTo(new Byte(DataUploadConstants.GARDEN_TYPE))
                        .andDepartmentIdEqualTo(departmentId).andTargetTypeEqualTo(new Byte(DataUploadConstants.GARDEN_TYPE));

                List<TbDataReportingSnapshotTarget>  snapshotTargetList= tbDataReportingSnapshotTargetMapper.selectByExample(targetExample);


                for(TbDataReportingSnapshotTarget targetBean : snapshotTargetList){
                    tgList.add(targetBean.getTargetId());
                }


                targetGroupExample.clear();
                targetGroupExample.or().andTargetIdIn(tgList).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andTaskBatchEqualTo(taskBatch);
                snapshotTargetGroupList = tbDataReportingSnapshotTargetGroupMapper.selectByExample(targetGroupExample);

            }

            if(snapshotTargetGroupList ==null || snapshotTargetGroupList.size()==0){
                //抛出异常，传入的信息错误
                throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_ERROR);
            }

            for(TbDataReportingSnapshotTargetGroup snapshotTargetGroup : snapshotTargetGroupList){

                boolean result = checkValue(modelId,tabBean.getTabId(),fillId, snapshotTargetGroup, tabBean.getInputList(),dataList);

                if(result){
                    //没有找到；前端/或数据被篡改,某些指标填写格式没有被上传。不予保存
                    throw new JnSpringCloudException(DataUploadExceptionEnum.INPUT_IS_ERROR);
                }
            }

            //数据存储

            //是否已经存储了草稿
            TbDataReportingTask needToSavetask =  tbDataReportingTaskMapper.selectByPrimaryKey(fillId);
            if(needToSavetask ==null){
                throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_NOT_EXIST);

            }

            //任务处于草稿状态
            if(DataUploadConstants.IS_DRAFT.equals(needToSavetask.getStatus().toString())){
                //删除这些草稿数据，
                TbDataReportingTaskDataCriteria taskDataCriteria = new TbDataReportingTaskDataCriteria();
                taskDataCriteria.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tabBean.getTabId()).andTargetIdIn(tgList)
                        .andFillIdEqualTo(data.getTaskInfo().getFillId());
                tbDataReportingTaskDataMapper.deleteByExample(taskDataCriteria);
                //保存新数据
                targetDao.saveData(dataList);


            }else if(DataUploadConstants.NOT_FILL.equals(needToSavetask.getStatus().toString())){
                if(DataUploadConstants.COMPANY_TYPE.equals(data.getTaskInfo().getFileType().toString())){
                    //未填报状态；直接写入数据
                    targetDao.saveData(dataList);
                }else{

                    TbDataReportingTaskDataCriteria taskDataCriteria = new TbDataReportingTaskDataCriteria();
                    taskDataCriteria.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tabBean.getTabId()).andTargetIdIn(tgList);
                    List<TbDataReportingTaskData> dataset = tbDataReportingTaskDataMapper.selectByExample(taskDataCriteria);
                    //更新
                    if(dataset !=null && dataset.size()>0){
                        List<TbDataReportingTaskData> dbList = new ArrayList<>();
                        TbDataReportingTaskDataCriteria taskDataCriteriaBean = new TbDataReportingTaskDataCriteria();
                        TbDataReportingSnapshotTargetCriteria taretInfoCriteriaBean = new TbDataReportingSnapshotTargetCriteria();

                        //检测 获取出该任务填报过的所有值，然后和，用户传上来的值进行比较；如果不存在则从数据库中删除该数据，防止出现用户删不掉
                        taskDataCriteriaBean.or().andFillIdEqualTo(fillId).andTabIdEqualTo(tabBean.getTabId()).andModelIdEqualTo(modelId);
                        List<TbDataReportingTaskData>  beforeValue = tbDataReportingTaskDataMapper.selectByExample(taskDataCriteriaBean);
                        List<String>  fallInFormIds = new ArrayList<>();
                        for(TbDataReportingTaskData beforeBean : beforeValue){
                            //不存在时为true
                            boolean isNotExist = true;
                            for(TbDataReportingTaskData  nowData : dataList){
                                //存在时将标志位修改为false
                                if(nowData.getFormId().equals(beforeBean.getFormId())  && nowData.getRowNum().equals(beforeBean.getRowNum()) && nowData.getTargetId().equals(beforeBean.getTargetId())){
                                    isNotExist =false;
                                    break;
                                }
                            }
                            if(isNotExist){
                                fallInFormIds.add(beforeBean.getFallInFormId());
                            }
                        }
                        if(fallInFormIds !=null && fallInFormIds.size()>0){
                            taskDataCriteriaBean.clear();
                            taskDataCriteriaBean.or().andFallInFormIdIn(fallInFormIds).andFillIdEqualTo(data.getTaskInfo().getFillId());
                            //删除掉用户删除的值
                            tbDataReportingTaskDataMapper.deleteByExample(taskDataCriteriaBean);
                        }


                        TbDataReportingTaskData updateRecord=null;
                        for(TbDataReportingTaskData dbean : dataList){
                            taskDataCriteriaBean.clear();
                            updateRecord = new TbDataReportingTaskData();
                            updateRecord.setData(dbean.getData());
                            updateRecord.setFillId(fillId);
                            taskDataCriteriaBean.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tabBean.getTabId()).andTargetIdEqualTo(dbean.getTargetId()).andFillIdEqualTo(fillId)
                                    .andFormIdEqualTo(dbean.getFormId()) .andRowNumEqualTo(dbean.getRowNum());
                            taretInfoCriteriaBean.clear();
                            taretInfoCriteriaBean.or().andTargetIdEqualTo(dbean.getTargetId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID))
                                    .andTaskBatchEqualTo(taskBatch).andDepartmentIdEqualTo(data.getDepartmentId());
                            List<TbDataReportingSnapshotTarget> targetList = tbDataReportingSnapshotTargetMapper.selectByExample(taretInfoCriteriaBean);
                            if(targetList !=null && targetList.size()>0){
                                List<TbDataReportingTaskData> resultSize =  tbDataReportingTaskDataMapper.selectByExample(taskDataCriteriaBean);
                                tbDataReportingTaskDataMapper.updateByExampleSelective(updateRecord,taskDataCriteriaBean);

                                if(resultSize ==null || resultSize.size() ==0){
                                    dbList.add(dbean);
                                }
                            }

                        }

                        if(dbList !=null && dbList.size()>0){
                            targetDao.saveData(dbList);
                        }
                    }else{
                        //保存
                        targetDao.saveData(dataList);
                    }

                    //部门Id，在model的最外层

                }

            }
        }

        //修改改任务的状态为已填报

        //企业
        if(DataUploadConstants.COMPANY_TYPE.equals(fillType)){

            //状态修改
            TbDataReportingTask taskUpdate = new TbDataReportingTask();
            taskUpdate.setStatus(new Byte(DataUploadConstants.FILLED));
            taskUpdate.setFiller(user.getAccount());
            taskUpdate.setFillerTel(user.getPhone());
            taskUpdate.setUpTime(new Date());
            TbDataReportingTaskCriteria taskUpdateExamp = new TbDataReportingTaskCriteria();
            taskUpdateExamp.or().andFillIdEqualTo(fillId);
            tbDataReportingTaskMapper.updateByExampleSelective(taskUpdate,taskUpdateExamp);

            //企业的全部填报完成后，进行短信的提醒 给指定人发送短信
            TbDataReportingSnapshotModel modelBean  = tbDataReportingSnapshotModelMapper.selectByPrimaryKey(taskBatch);
            modelBean.getReminder();
            if(StringUtils.isNotBlank(modelBean.getReminder())){
                TbDataReportingGardenLinkerCriteria liker = new TbDataReportingGardenLinkerCriteria();
                liker.or().andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andIdEqualTo(modelBean.getReminder());
                List<TbDataReportingGardenLinker> linkers = tbDataReportingGardenLinkerMapper.selectByExample(liker);
                if(linkers !=null && linkers.size()>0){
                    String message="[数据上报系统] 企业名称为："+data.getTaskInfo().getFillInFormName()+" ;账期为："+data.getTaskInfo().getFormTime()+";任务名称为 ："+data.getTaskInfo().getModelName()+";已经填报完毕，详细请查看任务";
                    User linkUser = getUserInfo(linkers.get(0).getLinkAccount());
                    if(linkUser !=null ){
                        String phone=linkUser.getPhone();
                        sendSMS(phone,message.toString());
                    }
                }
            }

            logger.info("开始推送消息");
            Delay delay = new Delay();
            delay.setServiceId(DataUploadConstants.PARK_ID);
            delay.setServiceUrl(DataUploadConstants.METHOD_ID);
            delay.setTtl("30");
            CompanyIdModel companyIdModel = new CompanyIdModel();
            companyIdModel.setCompanyId(data.getTaskInfo().getFillInFormId());
            delay.setDataString(JSONObject.toJSONString(companyIdModel));
            Result<Boolean>  dealyResult = delaySendMessageClient.delaySend(delay);
            logger.info("结束回调,返回结果，【{}】", dealyResult.toString());

            //插入朱成的逻辑
            //targetDao.insertDataUploadResultSet(fillId);

        }else{

            // 园区
            // 当前传入的部门，已经填报完毕；按照部门来进行,将本部门的填报信息写入到填报人的信息表中
            TbDataReportingGardenFiller gardenFiller = new TbDataReportingGardenFiller();
            gardenFiller.setStatus(new Byte(DataUploadConstants.FILLED));
            gardenFiller.setFiller(user.getAccount());
            gardenFiller.setFillerTel(user.getPhone());
            TbDataReportingGardenFillerCriteria gardenFillerCriteria =new TbDataReportingGardenFillerCriteria();
            gardenFillerCriteria.or().andDepartmentIdEqualTo(departmentId).andFillIdEqualTo(fillId);
            tbDataReportingGardenFillerMapper.updateByExampleSelective(gardenFiller,gardenFillerCriteria);

            // 检测其他部门是否已经填报完毕
            gardenFillerCriteria.clear();
            gardenFillerCriteria.or().andFillIdEqualTo(fillId).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID))
                    .andStatusNotEqualTo(new Byte(DataUploadConstants.FILLED));
            List<TbDataReportingGardenFiller> notFillList = tbDataReportingGardenFillerMapper.selectByExample(gardenFillerCriteria);

            // 任务状态修改，只有该任务的所有部门都是已填报的状态，任务的整体状态才能是已完成

            if(notFillList == null || notFillList.size()==0){
                TbDataReportingTask taskUpdate = new TbDataReportingTask();
                taskUpdate.setStatus(new Byte(DataUploadConstants.FILLED));
                taskUpdate.setUpTime(new Date());
                TbDataReportingTaskCriteria taskUpdateExamp = new TbDataReportingTaskCriteria();
                taskUpdateExamp.or().andFillIdEqualTo(fillId);
                tbDataReportingTaskMapper.updateByExampleSelective(taskUpdate,taskUpdateExamp);

                //插入朱成的逻辑
                //targetDao.insertDataUploadResultSet(fillId);
            }
        }

        return saveDataResult;
    }

    /**
     * 检测科技园任务是否已经导入
     * @param formTime
     * @return
     */
    private List<TbDataReportingTask>  checkThisFormTimeScientIsImport(String formTime){
        List<TbDataReportingTask> isImport = targetDao.checkThisFormTimeScientIsImport(formTime);
        return isImport;
    }

    /**
     * 检测本次任务中是否存在缴纳税收总额字段
     * @param fillId
     * @return
     */
    private List<TbDataReportingSnapshotTargetGroup>  checkIsHaveTaxiProperty(String fillId){
        List<TbDataReportingSnapshotTargetGroup> haveTaxi = targetDao.checkIsHaveTaxiProperty(fillId);
        return haveTaxi;
    }

    /**
     * 将缴纳税收总额更新到科技园任务中
     * @param data 值
     * @param fillId 科技园模板任务Id
     * @param formId 填报格式Id
     * @param targetId 指标Id
     * @param companyName 企业名称
     */
    private void  updateTaxiToScientTarget(String data,String fillId,String formId,String targetId,String companyName){
        targetDao.updateTaxiToScientTarget(data,fillId,formId,targetId,companyName);
    }

    /**
     * 通过科技园任务Id,查询出纳税总额的指标Id,和填报格式Id
     * @return
     */
    private List<TbDataReportingSnapshotTargetGroup>  getScientTaxiTargetByFillId(String fillId){
        List<TbDataReportingSnapshotTargetGroup> sicentTarget =targetDao.getScientTaxiTargetByFillId(fillId);
        return sicentTarget;
    }


    /**
     * 返回true;代表有前端传入的指标填写格式在标准中没有找到；
     * @return
     */
    private boolean checkValue(String modelId,String tabId,String fillId,TbDataReportingSnapshotTargetGroup snapshotTargetGroup, List<InputFormatModel> list,List<TbDataReportingTaskData> dataList){
        boolean result =true;
        TbDataReportingTaskData dataBean;
        //循环校验
        for(InputFormatModel ifmBean : list){
            if(snapshotTargetGroup.getFormId().equals(ifmBean.getFormId())){

                if(DataUploadConstants.REQUIRED.equals(snapshotTargetGroup.getRequired().toString()) ){
                    //是必填
                    /*
                    if(StringUtils.isBlank(ifmBean.getValue())){
                        throw new JnSpringCloudException(DataUploadExceptionEnum.VALUE_NOT_EXIST);
                    }
                    */
                }

                if(snapshotTargetGroup.getFormType().equals(DataUploadConstants.FORM_TYPE_TEXTNUMBER)){
                    if(! StringUtils.isNumeric(ifmBean.getValue())){
                        throw new JnSpringCloudException(DataUploadExceptionEnum.VALUE_IS_NUMBER);
                    }
                }

                dataBean = new TbDataReportingTaskData();
                dataBean.setRowNum(ifmBean.getRowNum());
                dataBean.setFormId(ifmBean.getFormId());
                dataBean.setTargetId(ifmBean.getTargetId());
                dataBean.setFillId(fillId);
                dataBean.setTabId(tabId);
                dataBean.setModelId(modelId);
                dataBean.setData(ifmBean.getValue());
                String uuid=UUID.randomUUID().toString().replaceAll("-","");
                dataBean.setFallInFormId(uuid);
                dataList.add(dataBean);
                result = false;
            }
        }

        return result;
    }


    @Override
    @ServiceLog(doAction = "企业历史填报任务详情")
    public ModelDataVO getCompanyFormedStruct(String fileId,User user) {
        ModelDataVO result =null;
        if(getUserType(user).equals(DataUploadConstants.COMPANY_TYPE)){
            result = getModelStructByHistoryFillId(fileId,user,DataUploadConstants.COMPANY_TYPE);
        }else{
            result = getGardenFormStruct(fileId,user);
        }
        //return getModelStructByHistoryFillId(fileId,user,DataUploadConstants.COMPANY_TYPE);
        return result;
    }

    @Override
    @ServiceLog(doAction = "园区历史填报任务详情")
    public ModelDataVO getGardenFormStruct(String fileId,User user) {
        return getModelStructByHistoryFillId(fileId,user,DataUploadConstants.GARDEN_TYPE);
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

        if(getUserType(user).equals(DataUploadConstants.COMPANY_TYPE)){
            task.or().andFillIdEqualTo(fileId).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID))
                    .andFillInFormIdIn(fillInFormId).andFileTypeEqualTo(new Byte(DataUploadConstants.COMPANY_TYPE));
        }else{
            task.or().andFillIdEqualTo(fileId).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
            //园区账号时，不校验权限问题；防止ibps中的园区账号看不见企业录入的任务
            //.andFileTypeEqualTo(new Byte(DataUploadConstants.GARDEN_TYPE));
        }

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
            //任务的部门权限
            List<GardenFillerAccessModel>  access = new ArrayList<>();
            access = getAccess(fileId, user);
            result.setGardenFiller(access);

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
        TbServiceCompanyCriteria exp = new  TbServiceCompanyCriteria();
        exp.or().andComAdminEqualTo(user.getAccount()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        List<TbServiceCompany> userExtension =  tbServiceCompanyMapper.selectByExample(exp);

        if(userExtension==null || userExtension.size()==0){
            companyInfo=null;
        }else{
            logger.info(userExtension.toString());
            companyInfo.put("companyName",userExtension.get(0).getComName());
            companyInfo.put("companyCode",userExtension.get(0).getId());
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
        TbDataReportingTaskCriteria.Criteria c =example.or().andTaskBatchEqualTo(param.getTaskBatch()).andModelIdEqualTo(param.getModelId()).andFileTypeEqualTo(new Byte(fileType))
                .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));

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
     * @param fillId
     * @return
     */
    @ServiceLog(doAction = "企业催报")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int setStatisticsListUrgeCompany(String taskBatch,String fillId,User currentUser){
        int result=0;
        //修改催报次数，最后催报时间，未填报的数据
//        if(getUserType(currentUser).equals(DataUploadConstants.COMPANY_TYPE)){
//            //企业
//            targetDao.updateCalling(taskBatch,fillId,DataUploadConstants.COMPANY_TYPE);
//        }else{
//            //园区
//            targetDao.updateCalling(taskBatch,fillId,DataUploadConstants.GARDEN_TYPE);
//        }
        //催报接口不分权限；园区账号也可催报企业任务
        targetDao.updateCalling(taskBatch,fillId,"");

        //调用服务发起通知 发送短信，邮件，app
        List<WarningTaskModel> taskList = targetDao.getWarningTask(fillId,taskBatch);
        if(taskList != null && taskList.size()>0){

            for(WarningTaskModel taskBean : taskList){

                String[] warningBy=null;
                if(StringUtils.isNotBlank(taskBean.getWarningBy())){
                    warningBy = taskBean.getWarningBy().split(",");
                }

                for(String menthod :warningBy){
                    StringBuilder message=null;
                    //进行提醒
                    if(DataUploadConstants.WARNING_BY_APP.equals(menthod)){
                        //todo

                    }
                    if(DataUploadConstants.WARNING_BY_EMAIL.equals(menthod)){
                        String email="";

                        //园区
                        if(taskBean.getFileType().equals(DataUploadConstants.GARDEN_TYPE)){
                            //查询任务的部门
                            TbDataReportingGardenFillerCriteria fillerCriteria = new TbDataReportingGardenFillerCriteria();
                            fillerCriteria.or().andFillIdEqualTo(taskBean.getFillId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                            List<TbDataReportingGardenFiller> fillers = tbDataReportingGardenFillerMapper.selectByExample(fillerCriteria);

                            if(fillers !=null && fillers.size()>0){
                                for(TbDataReportingGardenFiller fillerBean : fillers){

                                    //查询电话
                                    TbDataReportingGardenLinkerCriteria  gardenLinkerCriteria = new TbDataReportingGardenLinkerCriteria();
                                    gardenLinkerCriteria.or().andDepartmentIdEqualTo(fillerBean.getDepartmentId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));

                                    List<TbDataReportingGardenLinker> linkers =  tbDataReportingGardenLinkerMapper.selectByExample(gardenLinkerCriteria);
                                    if(linkers !=null && linkers.size()>0){
                                        String  title="数据上报系统任务预警";
                                        for(TbDataReportingGardenLinker linkerBean :  linkers){
                                            //通过预警人账号查询，预警人的email
                                            String userId = linkerBean.getLinkAccount();
                                            User user = getUserInfo(userId);
                                            if(user == null ){
                                                continue;
                                            }
                                            if(StringUtils.isNotBlank(user.getEmail())){
                                                message =new StringBuilder();
                                                message.append("[数据上报系统] 任务名称 ：").append(taskBean.getTaskName());
                                                if(taskBean.getInLine() !=0){
                                                    message.append(",还有").append(taskBean.getInLine()) .append("天逾期！请尽快填报!");
                                                }else if(taskBean.getOutLine() !=0){
                                                    message.append(",已经逾期").append(taskBean.getOutLine()) .append("天！请尽快填报!");
                                                }
                                                sendEmail(email, message.toString(),title);
                                            }

                                        }
                                    }
                                }
                            }

                        }else{
                            //企业
                            TbServiceCompanyCriteria exp = new  TbServiceCompanyCriteria();
                            exp.or().andIdEqualTo(taskBean.getFillInFormId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                            List<TbServiceCompany> list =  tbServiceCompanyMapper.selectByExample(exp);
                            if(list !=null && list.size()>0){
                                String  title="数据上报系统任务预警";

                                for(TbServiceCompany  tbServiceCompanyBean : list){
                                    //具有园区联系人的email号码
                                    //String email =tbServiceCompanyBean.getOwnerEmail();
                                    String userId = tbServiceCompanyBean.getId();
                                    User user = getUserInfo(userId);
                                    if(user == null ){
                                        continue;
                                    }
                                    if(StringUtils.isNotBlank(user.getEmail())){
                                        message =new StringBuilder();
                                        message.append("[数据上报系统] 任务名称 ：").append(taskBean.getTaskName());
                                        if(taskBean.getInLine() !=0){
                                            message.append(",还有").append(taskBean.getInLine()) .append("天逾期！请尽快填报!");
                                        }else if(taskBean.getOutLine() !=0){
                                            message.append(",已经逾期").append(taskBean.getOutLine()) .append("天！请尽快填报!");
                                        }
                                        sendEmail(email, message.toString(),title);
                                    }
                                }
                            }

                        }

                    }

                    if(DataUploadConstants.WARNING_BY_SMSTEXT.equals(menthod)){
                        String phone="";
                        //园区
                        if(taskBean.getFileType().equals(DataUploadConstants.GARDEN_TYPE)){
                            //查询任务的部门
                            TbDataReportingGardenFillerCriteria fillerCriteria = new TbDataReportingGardenFillerCriteria();
                            fillerCriteria.or().andFillIdEqualTo(taskBean.getFillId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                            List<TbDataReportingGardenFiller> fillers = tbDataReportingGardenFillerMapper.selectByExample(fillerCriteria);
                            if(fillers !=null && fillers.size()>0){
                                for(TbDataReportingGardenFiller fillerBean : fillers){
                                    //查询电话
                                    TbDataReportingGardenLinkerCriteria  gardenLinkerCriteria = new TbDataReportingGardenLinkerCriteria();
                                    gardenLinkerCriteria.or().andDepartmentIdEqualTo(fillerBean.getDepartmentId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                                    List<TbDataReportingGardenLinker> linkers =  tbDataReportingGardenLinkerMapper.selectByExample(gardenLinkerCriteria);
                                    if(linkers !=null && linkers.size()>0){
                                        User user;
                                        for(TbDataReportingGardenLinker linkerBean :  linkers){

                                            //通过预警人账号查询，预警人的手机号码
                                            String userId = linkerBean.getLinkAccount();
                                            user = getUserInfo(userId);
                                            if(user == null ){
                                                continue;
                                            }
                                            if(StringUtils.isNotBlank(user.getPhone())){
                                                phone  =user.getPhone();
                                                message =new StringBuilder();
                                                message.append("[数据上报系统]任务名称 ：").append(taskBean.getTaskName());
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

                        }else{
                            //企业,通过企业ID,查询预警人电话
                            TbServiceCompanyCriteria exp = new  TbServiceCompanyCriteria();
                            exp.or().andIdEqualTo(taskBean.getFillInFormId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                            List<TbServiceCompany> list =  tbServiceCompanyMapper.selectByExample(exp);
                            if(list !=null && list.size()>0){
                                for(TbServiceCompany  tbServiceCompanyBean : list){
                                    if(StringUtils.isNotBlank(tbServiceCompanyBean.getOwnerPhone())){
                                        phone  = tbServiceCompanyBean.getOwnerPhone();
                                        message =new StringBuilder();
                                        message.append("[数据上报系统]任务名称 ：").append(taskBean.getTaskName());
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
                }

            }
        }





        return result+=1 ;
    }


    /**
     * 园区催报
     * @param taskBatch
     * @param fillId
     * @return
     */
    @ServiceLog(doAction = "园区催报")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int setStatisticsListUrge(String taskBatch,String fillId){
        int result=0;
        //修改催报次数，最后催报时间，未填报的数据
        targetDao.updateCalling(taskBatch,fillId,DataUploadConstants.GARDEN_TYPE);
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
    public ModelDataVO getCheckOrLookInfo(String fillId,User user){
        return getModelStructByHistoryFillId(fillId,user,DataUploadConstants.GARDEN_TYPE);
    }




    /**
     * 通过用户账号查询用户信息
     * @param userId
     * @return
     */
    private User getUserInfo(String userId){
        //通过预警人账号查询，预警人的手机号码
        User user = new User();
        user.setId(userId);
        Result<User> concurentUser = systemClient.getUser(user);
        return concurentUser.getData();
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
        smsTemplateVo.setTemplateId("999");
        String[] m = {phone};
        smsTemplateVo.setMobiles(m);
        String[] t = {message};
        smsTemplateVo.setContents(t);
        logger.info("短信发送成功：接收号码：{},验证码：{}",phone,message);
        boolean sendStatus = messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
        if (sendStatus) {
            logger.info("[白下智慧园区]数据填报任务提醒短信送成功,{}",message);
        } else {
            logger.error("[白下智慧园区]数据填报任务提醒短信送失败,{}", message);
        }

    }



    /**
     * 邮件预警 String address
     */
    private void sendEmail(String emailAddress,String message,String title){
        EmailVo emailVo = new EmailVo();
        emailVo.setEmail(emailAddress);
        emailVo.setEmailSubject("[白下智慧园区]数据填报任务提醒");
        //emailVo.setTemplatesName("");

        //对模板数据进行封装
        Map map = new HashMap<>();
        //数据填报任务提醒
        map.put("title", title);
        map.put("time", DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        //任务名称+账期还有几天逾期
        map.put("content", message);
        emailVo.setTemplatesDataMap(map);
        emailVo.setTemplateFlag(true);

        //发送邮件
        boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
        if (sendStatus) {
            logger.info("[白下智慧园区]数据填报任务提醒邮件送成功,{}",message);
        } else {
            logger.error("[白下智慧园区]数据填报任务提醒邮件送失败,{}", message);
        }
    }


    @Override
    public PaginationData<Map<String, List<ScientModel>>> getImportData(ScientLookupParamModel param) {

        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());
        List<String> companyList=null;
        Map<String, List<ScientModel>> result = new HashMap<>();
        companyList = targetDao.getCompanyList(param.getCompanyName(),param.getFillId());
        PaginationData<List<String>> data = new PaginationData(companyList, objects.getTotal());
        companyList = data.getRows();
        if(companyList!=null && companyList.size()>0){
            for(int index=0,len=companyList.size();index<len;index++  ){
                List<ScientModel> dataset =  targetDao.getValues(companyList.get(index),param.getFillId());
                result.put(companyList.get(index),dataset);
            }
        }
        PaginationData<Map<String, List<ScientModel>>> resu = new PaginationData(result, objects.getTotal());
        return resu;
    }

    @Override
    public Map<String,Object> getScientTabHeader(String fillId){
        Map<String,Object> result = new HashMap<>();
        List<TbDataReportingSnapshotTarget> tList = targetDao.getScientTabHeaderTarget(fillId);
        List<TargetModelVO>  targetModelVOList=GetTargetTree.changeToTreeStructure(tList);
        result.put("targets",targetModelVOList);
        List<TbDataReportingSnapshotTargetGroup> tgList = targetDao.getScientTabHeaderTargetGroup(fillId);
        result.put("inputFormats",tgList);
        return result;
    }
}
