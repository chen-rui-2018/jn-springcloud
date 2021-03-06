package com.jn.enterprise.data.service.impl;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
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
import com.jn.news.vo.AppSinkVo;
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
 * @author??? yangh
 * @date??? Created on 2019/4/11 11:50
 * @version??? v1.0
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
     * ?????????????????????
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
     * ?????????????????????????????????
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
    @ServiceLog(doAction = "??????????????????????????????????????????")
    public Map<String, Set<String>> getCompanyAd(User user) {
        Map<String,Set<String>> result = null;
        if(getUserType(user).equals(DataUploadConstants.COMPANY_TYPE)){
            //??????
            result = getAdsFromTask(user,DataUploadConstants.AD_DISPLAY_CLIENT_PC,DataUploadConstants.COMPANY_TYPE);
        }else{
            //??????
            result = getGardenAd(user);
        }
        return result;
    }


    @Override
    @ServiceLog(doAction = "??????????????????????????????????????????")
    public Map<String, Set<String>> getGardenAd(User user) {
        return getAdsFromTask(user,DataUploadConstants.AD_DISPLAY_CLIENT_PC,DataUploadConstants.COMPANY_TYPE);
    }

    /**
     * ??????????????????????????????????????????????????????
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
     * ??????????????????????????????????????????????????????
     * @return
     */
    private List<String> getGardenTaskBatches(String lastMon,String lastYear,List<String> fillInFormId){
        List<String> taskbatch= targetDao.getGardenTaskBatch(lastMon,lastYear,fillInFormId);
        return taskbatch;
    }


    /**????????????????????????*/
    /**
     * ????????????????????????????????????????????????PC???APP
     */
    private Map<String,Set<String>> getAdsFromTask(User user,String type,String fileType){
        Map<String,String> companyInfo  = getCompanyInfoByAccount(user);
        Map<String ,Set<String>> result = new HashMap<>();
        //????????????????????????????????????????????????????????????
        List<String> fillInFormId =getFillId(companyInfo , user);
        //?????????????????????????????????
        String year = DateUtils.getDate("yyyy-MM-dd").split("-")[0];
        String lastYear = String.valueOf(Integer.parseInt(year)-1);

        String  lastMon=getLastMonth();
        String lastMonthFormTime = year+lastMon;
        List<String> taskbatch=new ArrayList<>();

        //???????????????????????????
        if(companyInfo !=null && companyInfo.size()>0){
            taskbatch = getCompanyTaskBatches(lastMonthFormTime,lastYear,fillInFormId);
        }else{
        //??????????????????????????? ?????????????????????
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



    //?????????????????????????????????????????????????????????????????????????????????????????????/?????????
    //???????????????????????????
    @Override
    @ServiceLog(doAction = "???????????????????????????")
    public List<CompanyDataModel> getNeedFormList(User user) {
        List<CompanyDataModel> result;
        if(getUserType(user).equals(DataUploadConstants.COMPANY_TYPE)){
            //??????
            result = getThisMonthTask(user,DataUploadConstants.COMPANY_TYPE);
        }else{
            //??????
            result = getThisMonthTask(user,DataUploadConstants.GARDEN_TYPE);
        }
        //return getThisMonthTask(user,DataUploadConstants.COMPANY_TYPE);
        return result;
    }

    @Override
    @ServiceLog(doAction = "???????????????????????????")
    public List<CompanyDataModel> getCurrentMonthTasks(User user) {
        return getThisMonthTask(user,DataUploadConstants.GARDEN_TYPE);
    }



    /**
     * ??????/???????????????????????????
     * @param user
     * @param type
     * @return
     */
    private List<CompanyDataModel> getThisMonthTask(User user,String type){
        //???????????????????????????????????????,?????????
        String lastMon = getLastMonth();
        String year = DateUtils.getDate("yyyy-MM-dd").split("-")[0];
        String lastyear = String.valueOf(Integer.parseInt(year)-1);

        //????????????????????????????????????
        List<String> formTimeList = new ArrayList<>();
        String lastMonth =  year+lastMon;
        formTimeList.add(year+lastMon);
        formTimeList.add(lastyear);
        //??????????????????
        Map<String,String> companyInfo = getCompanyInfoByAccount(user);
        List<String> fillInFormId =getFillId(companyInfo , user);

        List<CompanyDataModel> taskList =null;
        //??????
        if(companyInfo !=null && companyInfo.size()>0){
            taskList = targetDao.getThisMonthTask(formTimeList,fillInFormId,new Byte(type));
        }else{
        //??????
            List<String>  taskBatch = getGardenTaskBatches(lastMonth,lastyear,fillInFormId);
            //
            if(taskBatch !=null &&  taskBatch.size() >0){
                taskList = targetDao.getGardenTask(taskBatch);
            }

        }

        return taskList;
    }


    /**
     * ????????????????????????
     * @return
     */
    @ServiceLog(doAction = "????????????????????????")
    @Override
    public PaginationData<List<CompanyDataModel>> getFormedHistory(CompanyDataParamModel param,User user){

        PaginationData<List<CompanyDataModel>> result;
        if(getUserType(user).equals(DataUploadConstants.COMPANY_TYPE)){
            //??????
            result = getHistoryList(param,user,DataUploadConstants.COMPANY_TYPE);;
        }else{
            //??????
            result = getHistoryList(param,user,DataUploadConstants.GARDEN_TYPE);
        }
        //return getHistoryList(param,user,DataUploadConstants.COMPANY_TYPE);
        return result;
    }


    /**
     * ????????????????????????
     * @return
     */
    @ServiceLog(doAction = "????????????????????????")
    @Override
    public PaginationData<List<CompanyDataModel>> getHostoryTask(CompanyDataParamModel param,User user){

        return getHistoryList(param,user,DataUploadConstants.GARDEN_TYPE);
    }


    /**
     * ????????????????????????????????????
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
     * ??????/????????????????????????
     * @param param
     * @param user
     * @param type
     * @return
     */
    private PaginationData<List<CompanyDataModel>> getHistoryList(CompanyDataParamModel param,User user,String type){
        //??????????????? ?????????

        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());

        //?????????????????????????????????????????????
        Map<String,String> companyInfo  = getCompanyInfoByAccount(user);
        List<String> fillInFormId =getFillId(companyInfo , user);
        //????????????????????????????????????
        List<CompanyDataModel> historyList =null;
        //??????
        if(companyInfo!=null && companyInfo.size()>0){
            historyList = targetDao.getHistoryTaskList(param,fillInFormId,new Byte(type));
        }else{
        //??????
            //?????????????????????????????????
            historyList = targetDao.getHistoryGardenTaskList(param,new Byte(type));
        }

        PaginationData<List<CompanyDataModel>> data = new PaginationData(historyList, objects.getTotal());
        return data;
    }

    /**
     * ???????????????????????????
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
    @ServiceLog(doAction = "????????????????????????????????????")
    public ModelDataVO getFormStruct(String fileId,User user) {


        String type=DataUploadConstants.NOT_FILL;


        ModelDataVO result;
        if(getUserType(user).equals(DataUploadConstants.COMPANY_TYPE)){
            //??????
            result = getModelDataByType(fileId,user,type);
        }else{
            //??????
            result = getCurrentMonthForm(fileId,user);
        }


        //???????????????????????????
        return result;
    }

    @Override
    @ServiceLog(doAction = "????????????????????????????????????")
    public ModelDataVO getCurrentMonthForm(String fileId,User user) {

        String type=DataUploadConstants.NOT_FILL;
        //???????????????????????????
        ModelDataVO result =  getModelDataByType(fileId,user,type);

        //?????????????????????
        List<GardenFillerAccessModel>  access = new ArrayList<>();
        access = getAccess(fileId, user);
        //todo ???????????????????????????????????????
        TbDataReportingGardenLinkerCriteria linkerCriteria = new TbDataReportingGardenLinkerCriteria();
        List<SysDepartmentPostVO> departmentPostVOs = user.getSysDepartmentPostVO();
        if( departmentPostVOs!=null && departmentPostVOs.size()>0){
            List<String> departs = new ArrayList<>();
            for(SysDepartmentPostVO departmentPostVOBean:departmentPostVOs){
                departs.add(departmentPostVOBean.getDepartmentId());
            }
            linkerCriteria.or().andLinkAccountNotEqualTo(user.getAccount()).andDepartmentNameIn(departs).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
            List<TbDataReportingGardenLinker> linkers = tbDataReportingGardenLinkerMapper.selectByExample(linkerCriteria);
            if(linkers !=null && linkers.size()>0){
                result.setGardenFiller(access);
            }

        }


        return result;
    }

    /**
     * ??????????????????
     */

    private List<GardenFillerAccessModel> getAccess(String fileId,User user){
        //?????????????????????
        TbDataReportingGardenFillerCriteria example = new TbDataReportingGardenFillerCriteria();
        example.or().andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andFillIdEqualTo(fileId);
        List<TbDataReportingGardenFiller> taskAccess = tbDataReportingGardenFillerMapper.selectByExample(example);

        //???????????????????????????
        List<String> userAccess = getFillId(null,user);

        //?????????
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



        //???????????????????????????
        if(dataUploadCheckAccess==null || dataUploadCheckAccess.size()==0){
            for(TbDataReportingGardenFiller gardenFiller : taskAccess){
                //??????????????????
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
            //??????????????????
            for(TbDataReportingGardenFiller gardenFiller : taskAccess){
                BeanUtils.copyProperties(gardenFiller,gardenFillerAccessModel);
                access.add(gardenFillerAccessModel);
            }
        }

        return access;
    }

    /**
     * ?????????????????????????????????????????????????????????
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
     * ????????????????????????
     * @param fillId
     * @param user
     * @param type ?????????/?????????
     * @return
     */
    private ModelDataVO getModelDataByType(String fillId,User user,String type){
        //??????????????????
        Map<String,String> companyInfo = getCompanyInfoByAccount(user);
        //????????????
        TbDataReportingTaskCriteria task = new TbDataReportingTaskCriteria();
        task.or().andFillIdEqualTo(fillId).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                //.andStatusEqualTo(new Byte(type));
        List<TbDataReportingTask> taskList =  tbDataReportingTaskMapper.selectByExample(task);
        if(taskList ==null || taskList.size()==0){
            logger.warn("???????????????????????????");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_NOT_EXIST);
        }

        TbDataReportingTask tbDataReportingTask = taskList.get(0);



        //??????????????? ??? ??????????????????--????????????
        TbDataReportingSnapshotModelCriteria snapshotModelCriteria =new TbDataReportingSnapshotModelCriteria();
        snapshotModelCriteria.or().andTaskBatchEqualTo(tbDataReportingTask.getTaskBatch());
        List<TbDataReportingSnapshotModel>  snapshotModelList = tbDataReportingSnapshotModelMapper.selectByExample(snapshotModelCriteria);
        if(snapshotModelList ==null || snapshotModelList.size()==0){
            logger.warn("????????????????????????????????????");
            throw new JnSpringCloudException(DataUploadExceptionEnum.MODEL_IS_NOT_EXIST);
        }
        TbDataReportingSnapshotModel model = snapshotModelList.get(0);
        //??????????????? ??? ??????????????????--tab??????
        TbDataReportingSnapshotModelTabCriteria modelTab =new TbDataReportingSnapshotModelTabCriteria();
        modelTab.or().andTaskBatchEqualTo(tbDataReportingTask.getTaskBatch()).andStatusEqualTo(new Byte(DataUploadConstants.VALID));
        List<TbDataReportingSnapshotModelTab> modelTabList = tbDataReportingSnapshotModelTabMapper.selectByExample(modelTab);

        if(modelTabList ==null || modelTabList.size()==0){
            logger.warn("??????????????????????????????????????????");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TAB_IS_NOT_EXIST);
        }
        //??????????????????
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

            //???????????????????????????????????????--?????????????????????,????????????
            targetCriteria.clear();
            targetCriteria.or().andTargetIdIn(targetListFormTab).andTaskBatchEqualTo(tbDataReportingTask.getTaskBatch())
                    .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
            List<TbDataReportingSnapshotTarget> tList = tbDataReportingSnapshotTargetMapper.selectByExample(targetCriteria);
            List<TargetModelVO>  targetModelVOList=GetTargetTree.changeToTreeStructure(tList);

            //???????????????????????????--tab?????????
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
            //???????????????,??????????????????
            if(type.equals(DataUploadConstants.NOT_FILL) && tbDataReportingTask.getFileType().toString().equals(DataUploadConstants.GARDEN_TYPE)){
                //if(tbDataReportingTask.getFileType().toString().equals(DataUploadConstants.GARDEN_TYPE)){
                //??????????????????????????????????????????????????????????????????????????????????????????
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
                //?????????,??????
                    //??????
                    //????????????????????????????????????????????????
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

            //?????????tab????????????
            String modelCycle=model.getModelCycle();
            String formTime=tbDataReportingTask.getFormTime();
            String[] tabColumnType=tab.getTabClumnTargetShow().split(DataUploadConstants.TAB_COLUMN_SEPARTOR);
            //???????????????????????????????????????????????????????????????????????????

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

            //tab??????????????????
            Map<String,List<InputFormatModel>> otherColumn = new HashMap<>();

            for(int index=0,size=tabColumnType.length;index<size;index++){
                List<InputFormatModel> history =  getLastValue(fillInId,modelId,tabId,formTime,modelCycle,tabColumnType[index],inputFormatModelList);
                if(tabColumnType[index].equals(DataUploadConstants.AMPLIFICATION)){
                    otherColumn.put("??????",history);
                }else if(tabColumnType[index].equals(DataUploadConstants.LAST_MONTH_LAST_YEAR)){
                    otherColumn.put(getLastFormTime(modelCycle,formTime,tabColumnType[index]),history);
                }else if(tabColumnType[index].equals(DataUploadConstants.LAST_MONTH)){
                    otherColumn.put(getLastFormTime(modelCycle,formTime,tabColumnType[index]),history);
                }else{
                    otherColumn.put(getLastFormTime(modelCycle,formTime,tabColumnType[index]),history);
                }
            }
            //?????????????????????
            tabVO.setOtherColumn(otherColumn);

            //??????????????????
            tabVO.setTargetList(targetModelVOList);
            //???????????????????????????????????????

            tabVOList.add(tabVO);
        }
        ModelDataVO modelDataVO = new ModelDataVO();
        CompanyDataModel taskInfo = new CompanyDataModel();

        //??????????????????
        BeanUtils.copyProperties(snapshotModelList.get(0),modelDataVO);
        modelDataVO.setTabs(tabVOList);
        //??????????????????
        BeanUtils.copyProperties(tbDataReportingTask,taskInfo);
        modelDataVO.setTaskInfo(taskInfo);
        return modelDataVO;
    }

    /**
     * ?????????????????????????????????
     * @param modelCycle
     * @param formTime
     * @param tabColumnType
     * @return
     */
    private String getLastFormTime(String modelCycle,String formTime,String tabColumnType){
        //????????????????????????????????????/???????????????????????????
        String formTimeBefore="";

        if(modelCycle.equals(DataUploadConstants.MODEL_CYCLE_MONTH)){
            Integer month = StringUtils.toInteger(formTime.substring(4));

            //?????????//??????????????????????????????????????????
            if(tabColumnType.equals(DataUploadConstants.LAST_MONTH) ||tabColumnType.equals(DataUploadConstants.AMPLIFICATION) ){
                if(month.equals(DataUploadConstants.ONE_MONTH)){
                    formTimeBefore="12";
                    Integer year = StringUtils.toInteger(formTime.substring(0,4))-1;
                    formTimeBefore = String.valueOf(year)+formTimeBefore;
                }else{
                    formTimeBefore=String.valueOf(StringUtils.toInteger(formTime)-1);
                }
            }

            //???????????????
            if(tabColumnType.equals(DataUploadConstants.THIS_MONTH_LAST_YEAR)){
                //???
                String mon=formTime.substring(4);
                //??????
                Integer year = StringUtils.toInteger(formTime.substring(0,4))-1;
                //????????????
                formTimeBefore = String.valueOf(year)+mon;

            }

            //?????????????????????
            if(tabColumnType.equals(DataUploadConstants.LAST_MONTH_LAST_YEAR)){
                if(month.equals(DataUploadConstants.ONE_MONTH)){
                    //?????????
                    formTimeBefore="12";
                    Integer year = StringUtils.toInteger(formTime.substring(0,4))-1;
                    formTimeBefore = String.valueOf(year)+formTimeBefore;
                    //????????????


                }else{
                    //??????
                    formTimeBefore=String.valueOf(StringUtils.toInteger(formTime)-1);
                    String mon = formTimeBefore.substring(4);
                    //??????
                    String year = String.valueOf(Integer.parseInt(formTimeBefore.substring(0,4))-1);
                    formTimeBefore=year+mon;
                }
            }
        }else{
            //???
            formTimeBefore=String.valueOf(StringUtils.toInteger(formTime)-1);
        }

        return formTimeBefore;

    }

    /**
     * ?????????????????????
     * @param companyId ??????ID
     * @param modelId ??????ID
     * @param tabId ?????????TabId
     * @param formTime ???????????????
     * @param modelCycle ??????????????????
     * @param tabColumnType TAB????????????????????????
     * @return
     */
    private List<InputFormatModel> getLastValue(String companyId,String modelId,String tabId,String formTime,String modelCycle,String tabColumnType,List<InputFormatModel> thisMonthData){
        //??????Tab???????????????????????????
        List<InputFormatModel> resultList = null;
        //??????????????????
        String formTimeBefore=getLastFormTime(modelCycle,formTime,tabColumnType);

        //
        TbDataReportingTaskCriteria example = new TbDataReportingTaskCriteria();
        if(StringUtils.isNotBlank(companyId)){
            //????????????ID???????????????
            example.or().andFillInFormIdEqualTo(companyId).andModelIdEqualTo(modelId).andFormTimeEqualTo(formTimeBefore).andStatusEqualTo(new Byte(DataUploadConstants.FILLED))
                    .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        }else{
            //????????????
            example.or().andFillInFormIdIsNull().andModelIdEqualTo(modelId).andFormTimeEqualTo(formTimeBefore).andStatusEqualTo(new Byte(DataUploadConstants.FILLED))
                    .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        }

        //??????????????????????????????????????????????????????
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
                //????????????Tab??????
                TbDataReportingTaskDataCriteria tabData = new TbDataReportingTaskDataCriteria();
                tabData.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tab.getTabId()).andFillIdEqualTo(concertTask.getFillId());
                List<TbDataReportingTaskData> data =  tbDataReportingTaskDataMapper.selectByExample(tabData);
                //??????formId???data???
                List<String> formIdList = new ArrayList<>();
                for(TbDataReportingTaskData dataBean:data){
                    formIdList.add(dataBean.getFormId());
                }
                //???????????????????????????????????????
                TbDataReportingSnapshotTargetGroupCriteria targetGroupEx = new TbDataReportingSnapshotTargetGroupCriteria();
                targetGroupEx.or().andFormIdIn(formIdList).andTaskBatchEqualTo(concertTask.getTaskBatch())
                        .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                List<TbDataReportingSnapshotTargetGroup> inputList = tbDataReportingSnapshotTargetGroupMapper.selectByExample(targetGroupEx);

                //??????????????????????????????VO??????
                resultList = new ArrayList<>();
                InputFormatModel im=null;



                for(TbDataReportingSnapshotTargetGroup tgBean:inputList){

                    String value="";
                    Integer rowNum=0;
                    //???????????????
                    for(TbDataReportingTaskData tdrmBean:data){
                        //??????????????????????????????
                        if(tdrmBean.getFormId().equals(tgBean.getFormId())){
                            //?????????(???????????????,???????????????)
                            if(tabColumnType.equals(DataUploadConstants.AMPLIFICATION) && StringUtils.isNotBlank(tdrmBean.getData())  && StringUtils.isNumeric(tdrmBean.getData())){
                                //???????????????????????????
                                if(thisMonthData !=null ||thisMonthData.size() !=0){
                                    //?????????????????????
                                    for(InputFormatModel ifmBean:thisMonthData){

                                        if(ifmBean.getFormId().equals(tdrmBean.getFormId())){
                                            if(StringUtils.isNumeric(ifmBean.getValue()) &&  StringUtils.isNotBlank(ifmBean.getValue())){
                                                Double dValue = (Double.parseDouble(ifmBean.getValue()) - Double.parseDouble(tdrmBean.getData()))/Double.parseDouble(tdrmBean.getData());
                                                if(dValue>0){
                                                    //???????????????
                                                    dValue = dValue * 100;
                                                    value = String.valueOf(dValue).substring(0,3)+"%";
                                                }else if(dValue==0){
                                                    value="0%";
                                                }else{
                                                    //?????????
                                                    dValue = dValue * 100;
                                                    value = String.valueOf(dValue).substring(0,5)+"%";
                                                }
                                                rowNum = tdrmBean.getRowNum();
                                            }else{
                                                value = "";
                                                rowNum = tdrmBean.getRowNum();
                                            }
                                            //????????????
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
                                    //????????????
                                    im = new InputFormatModel();
                                    BeanUtils.copyProperties(tgBean,im);
                                    im.setValue(value);
                                    im.setRowNum(rowNum);
                                    resultList.add(im);
                                }
                            }else{
                                value = tdrmBean.getData();
                                rowNum = tdrmBean.getRowNum();
                                //????????????
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
     * ????????????????????????
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
    @ServiceLog(doAction = "????????????????????????????????????")
    @Transactional(rollbackFor = Exception.class)
    public int saveTaskData(ModelDataVO data,User user){
        int result = 0;
        //?????????????????????????????????????????????
        String taskBatch = data.getTaskInfo().getTaskBatch();
        //?????????????????????????????????????????????Tab
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
     * ???????????????
     * @param multipartFile
     */
    @Override
    @ServiceLog(doAction = "???????????????")
    @Transactional(rollbackFor = Exception.class)
    public int importData(MultipartFile multipartFile,String formTime,String fillId,String modelId,User user){
        int result=0;

//        String formTime=dataVO.getTaskInfo().getFormTime();
//        String fillId=dataVO.getTaskInfo().getFillId();
//        String modelId=dataVO.getTaskInfo().getModelId();
        //????????????????????????????????????????????????{'????????????'???0??????????????????1}
        List<Object> dataList = ExcelUtil.readExcel(multipartFile,null);

        //???????????????
        Object oTitle = dataList.get(0);
        String[] title = formatString(oTitle.toString());
        Map<String,String> companyTaxi =  getTaxi(formTime);


        //???????????????????????????????????????????????????
        List<TbDataReportingSnapshotTarget>  targetList  = targetDao.getTargetByFillId(fillId);
        List<TbDataReportingSnapshotTargetGroup>  targetGroupsList  =targetDao.getTargetGroupByFillId(fillId);


        //????????????
        List<TbDataReportingTaskData> saveData = new ArrayList<>();
        TbDataReportingTaskData taskData=null;

        //?????????????????????????????????????????????
        Integer taxiPersionPos=null;
        for(int pos=0,length=title.length;pos<length;pos++){
            if(title[pos].equals(DataUploadConstants.IS_TAXI_PERSON_COLUMN)){
                taxiPersionPos = pos;
                break;
            }
        }

        if(taxiPersionPos == null ){
            //??????????????????????????????????????????????????????
            throw new JnSpringCloudException(DataUploadExceptionEnum.NO_TAXI_PERSON_TARGET);
        }

        //????????????????????????????????????????????????????????????Id???????????????Id
        List<TbDataReportingSnapshotTargetGroup> sicentTarget = getScientTaxiTargetByFillId(fillId);
        if(sicentTarget == null || sicentTarget.size()==0){
            //????????????????????????????????????????????????????????????
            throw new JnSpringCloudException(DataUploadExceptionEnum.NO_TAXI_TARGET);
        }

        for(int index=1,len =dataList.size();index<len;index++){
            //tabId?????????????????????????????????

            String content = "";
            String[] currentData = formatString(dataList.get(index).toString());
            //???????????????????????????tabId
            String companyName=currentData[taxiPersionPos];

            for(int pos=0,length=currentData.length;pos<length;pos++){
                //????????????????????????????????????
                String targetName = title[pos].trim();
                //????????????
                content=currentData[pos];

                if("null".equals(content)){
                    content = "";
                }

                //???????????????????????????????????????????????????Id???????????????Id
                TbDataReportingSnapshotTarget currentTarget  = findTarget(targetName,targetList);

                TbDataReportingSnapshotTargetGroup currentTargetGroups =null;
                //????????????????????????????????????????????????
                if(currentTarget ==null){

                    if(targetGroupsList ==null ){
                        //??????????????????????????????
                        throw new JnSpringCloudException(DataUploadExceptionEnum.EXCEL_TARGET_ISNOT_EXIST);
                    }

                    currentTargetGroups = findTargetGroups(targetName,targetGroupsList);
                    if(currentTargetGroups==null){
                        //????????????????????????????????????????????????
                        throw new JnSpringCloudException(DataUploadExceptionEnum.NO_TARGET_LIKE_IN_EXCEL);
                    }
                }else{
                    //?????????????????????????????????ID,???????????????????????????????????????????????????????????????????????????????????????????????????
                    currentTargetGroups = findTargetGroupsByTargetId(currentTarget.getTargetId(),targetGroupsList);

                }

                //??????????????????????????????
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
                    //?????????????????????????????????
                    targetDao.saveData(saveData);
                    saveData = new ArrayList<>();
                }
            }

            //???????????????????????????????????????

            //??????????????????????????????????????????????????????
            //????????????,?????????????????????,????????????????????????????????????????????????
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

        //?????????????????????
        if(saveData.size()>0){
            targetDao.saveData(saveData);
        }

        //?????????????????????

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

        targetDao.insertDataUploadResultSet(fillId);

        return result+1;
    }

    /**
     * ???????????????
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
     * ?????????????????????
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
     * ??????????????????????????????????????????????????????????????????????????????
     */
    private Map<String,String> getTaxi(String formTime){

        //?????????taskBatch
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
        String targetName ="??????????????????";

        //????????????????????????????????????????????????????????????ID
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

        //????????????????????????????????????
        TbDataReportingSnapshotTarget taxiTarget = null;
        TbDataReportingSnapshotTargetGroup taxiTargetGroup =null;

        TbDataReportingSnapshotTargetCriteria targetCriteria = new TbDataReportingSnapshotTargetCriteria();
        targetCriteria.or().andTargetIdIn(targets).andTaskBatchEqualTo(taskBatch).andTargetNameEqualTo(targetName)
                .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        List<TbDataReportingSnapshotTarget> snapshotTargets = tbDataReportingSnapshotTargetMapper.selectByExample(targetCriteria);

        //???????????????????????????????????????????????????????????????????????????
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

            //??????????????????????????????????????????????????????????????????
            TbDataReportingTaskDataCriteria taskDataCriteria =new TbDataReportingTaskDataCriteria();
            taskDataCriteria.or().andFillIdIn(fillId).andFormIdEqualTo(taxiTargetGroup.getFormId());
            taskDataList = tbDataReportingTaskDataMapper.selectByExample(taskDataCriteria);

        }else{
            taxiTarget = snapshotTargets.get(0);

            //??????????????????????????????????????????????????????????????????
            TbDataReportingTaskDataCriteria taskDataCriteria =new TbDataReportingTaskDataCriteria();
            taskDataCriteria.or().andFillIdIn(fillId).andTargetIdEqualTo(taxiTarget.getTargetId());
            taskDataList = tbDataReportingTaskDataMapper.selectByExample(taskDataCriteria);
        }

        //????????????Map<????????????????????????>
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
     * ?????????????????????????????????
     * @param oTitle
     * @return
     */
    private String[] formatString(String oTitle){
        //['xxx','xxx','xxx']
        String title = oTitle.toString();
        //?????????????????????
        title = title.substring(1,title.length()-1);
        //???????????????
        String[] titles = title.split(",");
        for(int i=0;i<titles.length;i++){
            titles[i] = titles[i].trim();
        }
        return titles;
    }


    @Override
    @ServiceLog(doAction = "????????????????????????????????????")
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
    @ServiceLog(doAction = "????????????????????????????????????")
    @Transactional(rollbackFor = Exception.class)
    public int saveTaskDataAsDraft(ModelDataVO data,User user){
        return saveDataAsDraft(data,DataUploadConstants.GARDEN_TYPE,user);
    }

    @Override
    @ServiceLog(doAction = "????????????????????????????????????")
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
        //?????????
        String fillId = data.getTaskInfo().getFillId();
        String modelId = data.getTaskInfo().getModelId();
        String taskBatch = data.getTaskInfo().getTaskBatch();
        String departmentId=data.getDepartmentId();
        //??????????????????
        List<TbDataReportingTaskData> dataList =null;
        TbDataReportingTaskData dataBean =null;


        if(data.getTabs() ==null || data.getTabs().size()==0){
            throw new JnSpringCloudException(DataUploadExceptionEnum.VALUE_NOT_EXIST);
        }
        TbDataReportingSnapshotModelStructCriteria sexamp  =new TbDataReportingSnapshotModelStructCriteria();
        TbDataReportingSnapshotTargetGroupCriteria targetGroupExample = new  TbDataReportingSnapshotTargetGroupCriteria();

        for(TabVO tabBean: data.getTabs()){
            dataList = new ArrayList<>();
            //??????????????????,??????Tab???????????????????????????
            sexamp.clear();
            sexamp.or().andModelIdEqualTo(modelId).andTaskBatchEqualTo(taskBatch).andTabIdEqualTo(tabBean.getTabId());

            List<TbDataReportingSnapshotModelStruct>   modelStructList = tbDataReportingSnapshotModelStructMapper.selectByExample(sexamp);

            if(modelStructList ==null || modelStructList.size()==0){
                //????????????????????????????????????
                throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_ERROR);
            }

            List<String> tgList = new ArrayList<>();
            for(TbDataReportingSnapshotModelStruct structBean : modelStructList){
                tgList.add(structBean.getTargetId());
            }

            List<TbDataReportingSnapshotTargetGroup> snapshotTargetGroupList ;
            //????????????
            if(DataUploadConstants.COMPANY_TYPE.equals(fillType)){
                targetGroupExample.clear();
                targetGroupExample.or().andTargetIdIn(tgList).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andTaskBatchEqualTo(taskBatch)
                        .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                snapshotTargetGroupList = tbDataReportingSnapshotTargetGroupMapper.selectByExample(targetGroupExample);


                //????????????????????????????????????????????????????????????????????????,???????????????????????????ID????????????????????????????????????????????????????????????????????????????????????????????????
                List<TbDataReportingTask> isImport = checkThisFormTimeScientIsImport(data.getTaskInfo().getFormTime());
                if(isImport !=null && isImport.size()>0){
                    //???????????????????????????????????????????????????????????????????????????,???????????????ID???formId
                    List<TbDataReportingSnapshotTargetGroup> haveTaxi = checkIsHaveTaxiProperty(data.getTaskInfo().getFillId());

                    //????????????????????????????????????????????????????????????Id???????????????Id
                    List<TbDataReportingSnapshotTargetGroup> sicentTarget = getScientTaxiTargetByFillId(isImport.get(0).getFillId());

                    if(sicentTarget == null || sicentTarget.size() <0){
                        // ????????????????????????????????????????????????????????? ????????????????????????
                        throw new JnSpringCloudException(DataUploadExceptionEnum.NO_TAXI_TARGET);
                    }
                    //?????????????????????????????????
                    if(haveTaxi !=null && haveTaxi.size()>0 && tabBean.getInputList() !=null && tabBean.getInputList().size()>0){
                        List<InputFormatModel> inputFormatModelList = tabBean.getInputList();
                        for(int index=0,len =inputFormatModelList.size();index<len;index++){
                            if(inputFormatModelList.get(index).getFormId().equals(haveTaxi.get(0).getFormId()) && inputFormatModelList.get(index).getTargetId().equals(haveTaxi.get(0).getTargetId())){
                                //????????????????????????
                                if(StringUtils.isNotBlank(inputFormatModelList.get(index).getValue())){
                                    updateTaxiToScientTarget(inputFormatModelList.get(index).getValue(),isImport.get(0).getFillId(),sicentTarget.get(0).getFormId(),sicentTarget.get(0).getTargetId(),data.getTaskInfo().getFillInFormName());
                                    break;
                                }
                            }
                        }
                    }
                }

            }else{
                //????????????
                //????????????????????????
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
                //????????????????????????????????????
                throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_ERROR);
            }

            for(TbDataReportingSnapshotTargetGroup snapshotTargetGroup : snapshotTargetGroupList){

                boolean result = checkValue(modelId,tabBean.getTabId(),fillId, snapshotTargetGroup, tabBean.getInputList(),dataList);

                if(result){
                    //?????????????????????/??????????????????,??????????????????????????????????????????????????????
                    throw new JnSpringCloudException(DataUploadExceptionEnum.INPUT_IS_ERROR);
                }
            }

            //????????????
            if(dataList !=null && dataList.size()>0){
                if(DataUploadConstants.COMPANY_TYPE.equals(data.getTaskInfo().getFileType().toString())){
                    //?????????????????????
                    TbDataReportingTaskDataCriteria taskDataCriteria = new TbDataReportingTaskDataCriteria();
                    taskDataCriteria.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tabBean.getTabId()).andTargetIdIn(tgList)
                            .andFillIdEqualTo(data.getTaskInfo().getFillId());
                    tbDataReportingTaskDataMapper.deleteByExample(taskDataCriteria);

                    //????????????????????????????????????
                    targetDao.saveData(dataList);
                }else {

                    TbDataReportingTaskDataCriteria taskDataCriteria = new TbDataReportingTaskDataCriteria();
                    taskDataCriteria.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tabBean.getTabId()).andTargetIdIn(tgList);
                    List<TbDataReportingTaskData> dataset = tbDataReportingTaskDataMapper.selectByExample(taskDataCriteria);
                    //??????
                    if (dataset != null && dataset.size() > 0) {
                        List<TbDataReportingTaskData> dbList = new ArrayList<>();
                        TbDataReportingTaskDataCriteria taskDataCriteriaBean = new TbDataReportingTaskDataCriteria();
                        TbDataReportingSnapshotTargetCriteria taretInfoCriteriaBean = new TbDataReportingSnapshotTargetCriteria();

                        //?????? ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
                        taskDataCriteriaBean.or().andFillIdEqualTo(fillId).andTabIdEqualTo(tabBean.getTabId()).andModelIdEqualTo(modelId);
                        List<TbDataReportingTaskData>  beforeValue = tbDataReportingTaskDataMapper.selectByExample(taskDataCriteriaBean);
                        List<String>  fallInFormIds = new ArrayList<>();
                        for(TbDataReportingTaskData beforeBean : beforeValue){
                            //???????????????true
                            boolean isNotExist = true;
                            for(TbDataReportingTaskData  nowData : dataList){
                                //??????????????????????????????false
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
                            //???????????????????????????
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
                        //??????
                        targetDao.saveData(dataList);
                    }
                }
            }

        }

        //??????????????????????????????
        //??????
        if(fillType.equals(DataUploadConstants.COMPANY_TYPE)){
            TbDataReportingTask  record = new TbDataReportingTask();
            record.setStatus(new Byte(DataUploadConstants.IS_DRAFT));
            record.setFiller(user.getAccount());
            record.setFillerTel(user.getPhone());
            TbDataReportingTaskCriteria examp = new TbDataReportingTaskCriteria();
            examp.or().andFillIdEqualTo(fillId);
            tbDataReportingTaskMapper.updateByExampleSelective(record,examp);
        }else{
        //??????
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
     * ??????????????????
     * @param data
     * @param fillType
     * @param user
     * @return
     */
    private int saveData(ModelDataVO data,String fillType,User user) {

        int saveDataResult=1;
        String departmentId=data.getDepartmentId();
        //??????????????????
        List<TbDataReportingTaskData> dataList =null;
        TbDataReportingTaskData dataBean =null;
        data.getTabs().get(0).getInputList();
        //??????????????????
        String fillId = data.getTaskInfo().getFillId();
        String taskBatch = data.getTaskInfo().getTaskBatch();
        String modelId = data.getTaskInfo().getModelId();
        //??????????????????
        TbDataReportingSnapshotModelStructCriteria examp  =new TbDataReportingSnapshotModelStructCriteria();
        TbDataReportingSnapshotTargetGroupCriteria targetGroupExample = new  TbDataReportingSnapshotTargetGroupCriteria();

        for(TabVO tabBean: data.getTabs()){
            dataList = new ArrayList<>();
            //??????????????????,??????Tab???????????????????????????
            examp.clear();
            examp.or().andModelIdEqualTo(modelId).andTaskBatchEqualTo(taskBatch).andTabIdEqualTo(tabBean.getTabId());
            List<TbDataReportingSnapshotModelStruct>   modelStructList = tbDataReportingSnapshotModelStructMapper.selectByExample(examp);

            if(modelStructList ==null || modelStructList.size()==0){
                //????????????????????????????????????
                throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_ERROR);
            }

            List<String> tgList = new ArrayList<>();
            for(TbDataReportingSnapshotModelStruct structBean : modelStructList){
                tgList.add(structBean.getTargetId());
            }

            List<TbDataReportingSnapshotTargetGroup> snapshotTargetGroupList ;
            //????????????
            if(DataUploadConstants.COMPANY_TYPE.equals(fillType)){
                targetGroupExample.clear();
                targetGroupExample.or().andTargetIdIn(tgList).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andTaskBatchEqualTo(taskBatch)
                .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                snapshotTargetGroupList = tbDataReportingSnapshotTargetGroupMapper.selectByExample(targetGroupExample);


                //????????????????????????????????????????????????????????????????????????,???????????????????????????ID????????????????????????????????????????????????????????????????????????????????????????????????
                List<TbDataReportingTask> isImport = checkThisFormTimeScientIsImport(data.getTaskInfo().getFormTime());
                if(isImport !=null && isImport.size()>0){
                    //???????????????????????????????????????????????????????????????????????????,???????????????ID???formId
                    List<TbDataReportingSnapshotTargetGroup> haveTaxi = checkIsHaveTaxiProperty(data.getTaskInfo().getFillId());

                    //????????????????????????????????????????????????????????????Id???????????????Id
                    List<TbDataReportingSnapshotTargetGroup> sicentTarget = getScientTaxiTargetByFillId(isImport.get(0).getFillId());

                    if(sicentTarget == null || sicentTarget.size() <0){
                        // ????????????????????????????????????????????????????????? ????????????????????????
                        throw new JnSpringCloudException(DataUploadExceptionEnum.NO_TAXI_TARGET);
                    }
                    //?????????????????????????????????
                    if(haveTaxi !=null && haveTaxi.size()>0 && tabBean.getInputList() !=null && tabBean.getInputList().size()>0){
                        List<InputFormatModel> inputFormatModelList = tabBean.getInputList();
                        for(int index=0,len =inputFormatModelList.size();index<len;index++){
                            if(inputFormatModelList.get(index).getFormId().equals(haveTaxi.get(0).getFormId()) && inputFormatModelList.get(index).getTargetId().equals(haveTaxi.get(0).getTargetId())){
                                //????????????????????????
                                if(StringUtils.isNotBlank(inputFormatModelList.get(index).getValue())){
                                    updateTaxiToScientTarget(inputFormatModelList.get(index).getValue(),isImport.get(0).getFillId(),sicentTarget.get(0).getFormId(),sicentTarget.get(0).getTargetId(),data.getTaskInfo().getFillInFormName());
                                    break;
                                }
                            }
                        }
                    }
                }

            }else{
            //????????????
                //????????????????????????
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
                //????????????????????????????????????
                throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_ERROR);
            }

            for(TbDataReportingSnapshotTargetGroup snapshotTargetGroup : snapshotTargetGroupList){

                boolean result = checkValue(modelId,tabBean.getTabId(),fillId, snapshotTargetGroup, tabBean.getInputList(),dataList);

                if(result){
                    //?????????????????????/??????????????????,??????????????????????????????????????????????????????
                    throw new JnSpringCloudException(DataUploadExceptionEnum.INPUT_IS_ERROR);
                }
            }

            //????????????

            //???????????????????????????
            TbDataReportingTask needToSavetask =  tbDataReportingTaskMapper.selectByPrimaryKey(fillId);
            if(needToSavetask ==null){
                throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_NOT_EXIST);

            }

            //????????????????????????
            if(DataUploadConstants.IS_DRAFT.equals(needToSavetask.getStatus().toString())){
                //???????????????????????????
                TbDataReportingTaskDataCriteria taskDataCriteria = new TbDataReportingTaskDataCriteria();
                taskDataCriteria.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tabBean.getTabId()).andTargetIdIn(tgList)
                        .andFillIdEqualTo(data.getTaskInfo().getFillId());
                tbDataReportingTaskDataMapper.deleteByExample(taskDataCriteria);
                //???????????????
                targetDao.saveData(dataList);


            }else if(DataUploadConstants.NOT_FILL.equals(needToSavetask.getStatus().toString())){
                if(DataUploadConstants.COMPANY_TYPE.equals(data.getTaskInfo().getFileType().toString())){
                    //????????????????????????????????????
                    targetDao.saveData(dataList);
                }else{

                    TbDataReportingTaskDataCriteria taskDataCriteria = new TbDataReportingTaskDataCriteria();
                    taskDataCriteria.or().andModelIdEqualTo(modelId).andTabIdEqualTo(tabBean.getTabId()).andTargetIdIn(tgList);
                    List<TbDataReportingTaskData> dataset = tbDataReportingTaskDataMapper.selectByExample(taskDataCriteria);
                    //??????
                    if(dataset !=null && dataset.size()>0){
                        List<TbDataReportingTaskData> dbList = new ArrayList<>();
                        TbDataReportingTaskDataCriteria taskDataCriteriaBean = new TbDataReportingTaskDataCriteria();
                        TbDataReportingSnapshotTargetCriteria taretInfoCriteriaBean = new TbDataReportingSnapshotTargetCriteria();

                        //?????? ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
                        taskDataCriteriaBean.or().andFillIdEqualTo(fillId).andTabIdEqualTo(tabBean.getTabId()).andModelIdEqualTo(modelId);
                        List<TbDataReportingTaskData>  beforeValue = tbDataReportingTaskDataMapper.selectByExample(taskDataCriteriaBean);
                        List<String>  fallInFormIds = new ArrayList<>();
                        for(TbDataReportingTaskData beforeBean : beforeValue){
                            //???????????????true
                            boolean isNotExist = true;
                            for(TbDataReportingTaskData  nowData : dataList){
                                //??????????????????????????????false
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
                            //???????????????????????????
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
                        //??????
                        targetDao.saveData(dataList);
                    }

                    //??????Id??????model????????????

                }

            }
        }

        //????????????????????????????????????

        //??????
        if(DataUploadConstants.COMPANY_TYPE.equals(fillType)){

            //????????????
            TbDataReportingTask taskUpdate = new TbDataReportingTask();
            taskUpdate.setStatus(new Byte(DataUploadConstants.FILLED));
            taskUpdate.setFiller(user.getAccount());
            taskUpdate.setFillerTel(user.getPhone());
            taskUpdate.setUpTime(new Date());
            TbDataReportingTaskCriteria taskUpdateExamp = new TbDataReportingTaskCriteria();
            taskUpdateExamp.or().andFillIdEqualTo(fillId);
            tbDataReportingTaskMapper.updateByExampleSelective(taskUpdate,taskUpdateExamp);

            //?????????????????????????????????????????????????????? ????????????????????????
            TbDataReportingSnapshotModel modelBean  = tbDataReportingSnapshotModelMapper.selectByPrimaryKey(taskBatch);
            modelBean.getReminder();
            if(StringUtils.isNotBlank(modelBean.getReminder())){
                TbDataReportingGardenLinkerCriteria liker = new TbDataReportingGardenLinkerCriteria();
                liker.or().andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID)).andIdEqualTo(modelBean.getReminder());
                List<TbDataReportingGardenLinker> linkers = tbDataReportingGardenLinkerMapper.selectByExample(liker);
                if(linkers !=null && linkers.size()>0){
                    String message="[??????????????????] ??????????????????"+data.getTaskInfo().getFillInFormName()+" ;????????????"+data.getTaskInfo().getFormTime()+";??????????????? ???"+data.getTaskInfo().getModelName()+";??????????????????????????????????????????";
                    User linkUser = getUserInfo(linkers.get(0).getLinkAccount());
                    if(linkUser !=null ){
                        String phone=linkUser.getPhone();
                        sendSMS(phone,message.toString());
                    }
                }
            }

            logger.info("??????????????????");
            Delay delay = new Delay();
            delay.setServiceId(DataUploadConstants.PARK_ID);
            delay.setServiceUrl(DataUploadConstants.METHOD_ID);
            delay.setTtl("30");
            CompanyIdModel companyIdModel = new CompanyIdModel();
            companyIdModel.setCompanyId(data.getTaskInfo().getFillInFormId());
            delay.setDataString(JSONObject.toJSONString(companyIdModel));
            Result<Boolean>  dealyResult = delaySendMessageClient.delaySend(delay);
            logger.info("????????????,??????????????????{}???", dealyResult.toString());

            //?????????????????????
            targetDao.insertDataUploadResultSet(fillId);

        }else{

            // ??????
            // ??????????????????????????????????????????????????????????????????,????????????????????????????????????????????????????????????
            TbDataReportingGardenFiller gardenFiller = new TbDataReportingGardenFiller();
            gardenFiller.setStatus(new Byte(DataUploadConstants.FILLED));
            gardenFiller.setFiller(user.getAccount());
            gardenFiller.setFillerTel(user.getPhone());
            TbDataReportingGardenFillerCriteria gardenFillerCriteria =new TbDataReportingGardenFillerCriteria();
            gardenFillerCriteria.or().andDepartmentIdEqualTo(departmentId).andFillIdEqualTo(fillId);
            tbDataReportingGardenFillerMapper.updateByExampleSelective(gardenFiller,gardenFillerCriteria);

            // ??????????????????????????????????????????
            gardenFillerCriteria.clear();
            gardenFillerCriteria.or().andFillIdEqualTo(fillId).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID))
                    .andStatusNotEqualTo(new Byte(DataUploadConstants.FILLED));
            List<TbDataReportingGardenFiller> notFillList = tbDataReportingGardenFillerMapper.selectByExample(gardenFillerCriteria);

            // ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????

            if(notFillList == null || notFillList.size()==0){
                TbDataReportingTask taskUpdate = new TbDataReportingTask();
                taskUpdate.setStatus(new Byte(DataUploadConstants.FILLED));
                taskUpdate.setUpTime(new Date());
                TbDataReportingTaskCriteria taskUpdateExamp = new TbDataReportingTaskCriteria();
                taskUpdateExamp.or().andFillIdEqualTo(fillId);
                tbDataReportingTaskMapper.updateByExampleSelective(taskUpdate,taskUpdateExamp);

                //?????????????????????
                targetDao.insertDataUploadResultSet(fillId);
            }
        }

        return saveDataResult;
    }

    /**
     * ???????????????????????????????????????
     * @param formTime
     * @return
     */
    private List<TbDataReportingTask>  checkThisFormTimeScientIsImport(String formTime){
        List<TbDataReportingTask> isImport = targetDao.checkThisFormTimeScientIsImport(formTime);
        return isImport;
    }

    /**
     * ?????????????????????????????????????????????????????????
     * @param fillId
     * @return
     */
    private List<TbDataReportingSnapshotTargetGroup>  checkIsHaveTaxiProperty(String fillId){
        List<TbDataReportingSnapshotTargetGroup> haveTaxi = targetDao.checkIsHaveTaxiProperty(fillId);
        return haveTaxi;
    }

    /**
     * ????????????????????????????????????????????????
     * @param data ???
     * @param fillId ?????????????????????Id
     * @param formId ????????????Id
     * @param targetId ??????Id
     * @param companyName ????????????
     */
    private void  updateTaxiToScientTarget(String data,String fillId,String formId,String targetId,String companyName){
        targetDao.updateTaxiToScientTarget(data,fillId,formId,targetId,companyName);
    }

    /**
     * ?????????????????????Id,??????????????????????????????Id,???????????????Id
     * @return
     */
    private List<TbDataReportingSnapshotTargetGroup>  getScientTaxiTargetByFillId(String fillId){
        List<TbDataReportingSnapshotTargetGroup> sicentTarget =targetDao.getScientTaxiTargetByFillId(fillId);
        return sicentTarget;
    }


    /**
     * ??????true;?????????????????????????????????????????????????????????????????????
     * @return
     */
    private boolean checkValue(String modelId,String tabId,String fillId,TbDataReportingSnapshotTargetGroup snapshotTargetGroup, List<InputFormatModel> list,List<TbDataReportingTaskData> dataList){
        boolean result =true;
        TbDataReportingTaskData dataBean;
        //????????????
        for(InputFormatModel ifmBean : list){
            if(snapshotTargetGroup.getFormId().equals(ifmBean.getFormId())){

                if(DataUploadConstants.REQUIRED.equals(snapshotTargetGroup.getRequired().toString()) ){
                    //?????????
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
    @ServiceLog(doAction = "??????????????????????????????")
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
    @ServiceLog(doAction = "??????????????????????????????")
    public ModelDataVO getGardenFormStruct(String fileId,User user) {
        return getModelStructByHistoryFillId(fileId,user,DataUploadConstants.GARDEN_TYPE);
    }

    /**
     * ????????????????????????
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
            //????????????????????????????????????????????????ibps????????????????????????????????????????????????
            //.andFileTypeEqualTo(new Byte(DataUploadConstants.GARDEN_TYPE));
        }

        List<TbDataReportingTask> taskList =tbDataReportingTaskMapper.selectByExample(task);
        if(taskList ==null || taskList.size()==0){
            logger.warn("??????ID???????????????");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TASK_IS_NOT_EXIST);
        }
        TbDataReportingTask concretTask = taskList.get(0);
        //?????????
        if(concretTask.getStatus().toString().equals(DataUploadConstants.NOT_FILL)){
            result = getFormStruct(fileId,user);

        }else{
        //?????????
            result = getModelDataByType(fileId,user,concretTask.getStatus().toString());
            //?????????????????????
            List<GardenFillerAccessModel>  access = new ArrayList<>();
            access = getAccess(fileId, user);
            TbDataReportingGardenLinkerCriteria linkerCriteria = new TbDataReportingGardenLinkerCriteria();
            List<SysDepartmentPostVO> departmentPostVOs = user.getSysDepartmentPostVO();
            if( departmentPostVOs!=null && departmentPostVOs.size()>0){
                List<String> departs = new ArrayList<>();
                for(SysDepartmentPostVO departmentPostVOBean:departmentPostVOs){
                    departs.add(departmentPostVOBean.getDepartmentId());
                }
                linkerCriteria.or().andLinkAccountNotEqualTo(user.getAccount()).andDepartmentNameIn(departs).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                List<TbDataReportingGardenLinker> linkers = tbDataReportingGardenLinkerMapper.selectByExample(linkerCriteria);
                if(linkers !=null && linkers.size()>0){
                    result.setGardenFiller(access);
                }

            }

            //result.setGardenFiller(access);

        }
        return result;
    }

    /**
     * ??????user??????????????????
     * @param user
     * @return
     */
    private Map<String,String> getCompanyInfoByAccount(User user){
        Map<String,String> companyInfo = new HashMap<>();
        //??????????????????
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
    @ServiceLog(doAction = "??????????????????")
    public PaginationData<List<CompanyDataStatisticsModel>> getFormView(CompanyDataStatisticsParamModel param) {

        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());
        List<CompanyDataStatisticsModel> list = targetDao.getStatisticsModel(param,DataUploadConstants.COMPANY_TYPE);
        PaginationData<List<CompanyDataStatisticsModel>> data = new PaginationData(list, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "??????????????????")
    public PaginationData<List<CompanyDataStatisticsModel>> getStatisticsList(CompanyDataStatisticsParamModel param) {

        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());
        List<CompanyDataStatisticsModel> list = targetDao.getStatisticsModel(param,DataUploadConstants.GARDEN_TYPE);
        PaginationData<List<CompanyDataStatisticsModel>> data = new PaginationData(list, objects.getTotal());
        return data;
    }


    @Override
    @ServiceLog(doAction = "????????????????????????????????????????????????")
    public PaginationData<List<CompanyDataModel>> getFormList(CompanyDataParamModel param) {
        return getStatisticsListInfo(param,DataUploadConstants.COMPANY_TYPE);
    }


    @Override
    @ServiceLog(doAction = "????????????????????????????????????????????????")
    public PaginationData<List<CompanyDataModel>> getStatisticsListInfo(CompanyDataParamModel param) {
        return getStatisticsListInfo(param,DataUploadConstants.GARDEN_TYPE);
    }

    /**
     * ????????????/?????? ?????????????????????????????????
     * @param param
     * @param fileType
     * @return
     */
    private PaginationData<List<CompanyDataModel>> getStatisticsListInfo(CompanyDataParamModel param,String fileType){
        //  task_batch ??????ID
        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());
        TbDataReportingTaskCriteria example =new TbDataReportingTaskCriteria();
        TbDataReportingTaskCriteria.Criteria c =example.or().andTaskBatchEqualTo(param.getTaskBatch()).andModelIdEqualTo(param.getModelId()).andFileTypeEqualTo(new Byte(fileType))
                .andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));

        //??????????????????
        if(StringUtils.isNotBlank(param.getStatus())){
            c.andStatusEqualTo(new Byte(param.getStatus().getBytes()[0]));
        }
        //????????????????????????
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
     * ??????????????????
     * @param taskBatch
     * @param newDeadLine
     * @param modelId
     * @return
     */
    @ServiceLog(doAction = "????????????????????????")
    @Override
    public int setDeadlineCompany(String taskBatch,String newDeadLine,String modelId){
        int result=0;
        targetDao.updateDeadline(taskBatch,newDeadLine,modelId,DataUploadConstants.COMPANY_TYPE);
        return result+=1;
    }

    /**
     * ??????????????????
     * @param taskBatch
     * @param newDeadLine
     * @param modelId
     * @return
     */
    @ServiceLog(doAction = "????????????????????????")
    @Override
    public int setDeadline(String taskBatch,String newDeadLine,String modelId){
        int result=0;
        targetDao.updateDeadline(taskBatch,newDeadLine,modelId,DataUploadConstants.GARDEN_TYPE);
        return result+=1;
    }

    /**
     * ????????????
     * @param taskBatch
     * @param fillId
     * @return
     */
    @ServiceLog(doAction = "????????????")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int setStatisticsListUrgeCompany(String taskBatch,String fillId,User currentUser){
        int result=0;
        //????????????????????????????????????????????????????????????
//        if(getUserType(currentUser).equals(DataUploadConstants.COMPANY_TYPE)){
//            //??????
//            targetDao.updateCalling(taskBatch,fillId,DataUploadConstants.COMPANY_TYPE);
//        }else{
//            //??????
//            targetDao.updateCalling(taskBatch,fillId,DataUploadConstants.GARDEN_TYPE);
//        }
        //???????????????????????????????????????????????????????????????
        targetDao.updateCalling(taskBatch,fillId,"");

        //???????????????????????? ????????????????????????app
        List<WarningTaskModel> taskList = targetDao.getWarningTask(fillId,taskBatch);
        if(taskList != null && taskList.size()>0){

            for(WarningTaskModel taskBean : taskList){

                String[] warningBy=null;
                if(StringUtils.isNotBlank(taskBean.getWarningBy())){
                    warningBy = taskBean.getWarningBy().split(",");
                }

                for(String menthod :warningBy){
                    StringBuilder message=null;
                    //????????????
                    if(DataUploadConstants.WARNING_BY_APP.equals(menthod)){

                        if(taskBean.getFileType().equals(DataUploadConstants.GARDEN_TYPE)){
                            //?????????????????????
                            TbDataReportingGardenFillerCriteria fillerCriteria = new TbDataReportingGardenFillerCriteria();
                            fillerCriteria.or().andFillIdEqualTo(taskBean.getFillId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                            List<TbDataReportingGardenFiller> fillers = tbDataReportingGardenFillerMapper.selectByExample(fillerCriteria);
                            if(fillers !=null && fillers.size()>0){
                                for(TbDataReportingGardenFiller fillerBean : fillers){
                                    //????????????
                                    TbDataReportingGardenLinkerCriteria  gardenLinkerCriteria = new TbDataReportingGardenLinkerCriteria();
                                    gardenLinkerCriteria.or().andDepartmentIdEqualTo(fillerBean.getDepartmentId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                                    List<TbDataReportingGardenLinker> linkers =  tbDataReportingGardenLinkerMapper.selectByExample(gardenLinkerCriteria);
                                    if(linkers !=null && linkers.size()>0){
                                        User user;
                                        String  title="??????????????????????????????";
                                        for(TbDataReportingGardenLinker linkerBean :  linkers){
                                            //??????????????????????????????????????????email
                                            String userId = linkerBean.getLinkAccount();
                                            user = getUserInfo(userId);
                                            if(user == null ){
                                                continue;
                                            }
                                            if(StringUtils.isNotBlank(user.getEmail())){
                                                message =new StringBuilder();
                                                message.append("[??????????????????] ???????????? ???").append(taskBean.getTaskName());
                                                if(taskBean.getInLine() !=0){
                                                    message.append(",??????").append(taskBean.getInLine()) .append("???????????????????????????!");
                                                }else if(taskBean.getOutLine() !=0){
                                                    message.append(",????????????").append(taskBean.getOutLine()) .append("?????????????????????!");
                                                }
                                                sendApp(message.toString(),user.getId());
                                                targetDao.updateCalling("",fillId,DataUploadConstants.GARDEN_TYPE);
                                            }
                                        }
                                    }
                                }
                            }
                        }else{
                            TbServiceCompanyCriteria exp = new  TbServiceCompanyCriteria();
                            exp.or().andIdEqualTo(taskBean.getFillInFormId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                            List<TbServiceCompany> list =  tbServiceCompanyMapper.selectByExample(exp);
                            if(list !=null && list.size()>0){
                                String  title="??????????????????????????????";
                                for(TbServiceCompany  tbServiceCompanyBean : list){
                                    //String email =tbServiceCompanyBean.getOwnerEmail();
                                    String userId = tbServiceCompanyBean.getId();
                                    User user = getUserInfo(userId);
                                    String email = user.getEmail();
                                    if(user == null ){
                                        continue;
                                    }

                                    if(StringUtils.isNotBlank(user.getEmail())){
                                        message =new StringBuilder();
                                        message.append("[??????????????????] ???????????? ???").append(taskBean.getTaskName());
                                        if(taskBean.getInLine() !=0){
                                            message.append(",??????").append(taskBean.getInLine()) .append("???????????????????????????!");
                                        }else if(taskBean.getOutLine() !=0){
                                            message.append(",????????????").append(taskBean.getOutLine()) .append("?????????????????????!");
                                        }
                                        sendApp(message.toString(),user.getId());
                                        targetDao.updateCalling("",fillId,DataUploadConstants.COMPANY_TYPE);
                                    }
                                }
                            }

                        }
                    }

                    if(DataUploadConstants.WARNING_BY_WEIXIN.equals(menthod)){
                        //todo
                    }
                    if(DataUploadConstants.WARNING_BY_EMAIL.equals(menthod)){
                        //??????
                        if(taskBean.getFileType().equals(DataUploadConstants.GARDEN_TYPE)){
                            //?????????????????????
                            TbDataReportingGardenFillerCriteria fillerCriteria = new TbDataReportingGardenFillerCriteria();
                            fillerCriteria.or().andFillIdEqualTo(taskBean.getFillId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                            List<TbDataReportingGardenFiller> fillers = tbDataReportingGardenFillerMapper.selectByExample(fillerCriteria);

                            if(fillers !=null && fillers.size()>0){
                                for(TbDataReportingGardenFiller fillerBean : fillers){

                                    //????????????
                                    TbDataReportingGardenLinkerCriteria  gardenLinkerCriteria = new TbDataReportingGardenLinkerCriteria();
                                    gardenLinkerCriteria.or().andDepartmentIdEqualTo(fillerBean.getDepartmentId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));

                                    List<TbDataReportingGardenLinker> linkers =  tbDataReportingGardenLinkerMapper.selectByExample(gardenLinkerCriteria);
                                    if(linkers !=null && linkers.size()>0){
                                        String  title="??????????????????????????????";
                                        for(TbDataReportingGardenLinker linkerBean :  linkers){
                                            //??????????????????????????????????????????email
                                            String userId = linkerBean.getLinkAccount();
                                            User user = getUserInfo(userId);
                                            if(user == null ){
                                                continue;
                                            }
                                            if(StringUtils.isNotBlank(user.getEmail())){
                                                message =new StringBuilder();
                                                String email=user.getEmail();
                                                message.append("[??????????????????] ???????????? ???").append(taskBean.getTaskName());
                                                if(taskBean.getInLine() !=0){
                                                    message.append(",??????").append(taskBean.getInLine()) .append("???????????????????????????!");
                                                }else if(taskBean.getOutLine() !=0){
                                                    message.append(",????????????").append(taskBean.getOutLine()) .append("?????????????????????!");
                                                }
                                                sendEmail(email, message.toString(),title);
                                            }

                                        }
                                    }
                                }
                            }

                        }else{
                            //??????
                            TbServiceCompanyCriteria exp = new  TbServiceCompanyCriteria();
                            exp.or().andIdEqualTo(taskBean.getFillInFormId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                            List<TbServiceCompany> list =  tbServiceCompanyMapper.selectByExample(exp);
                            if(list !=null && list.size()>0){
                                String  title="??????????????????????????????";

                                for(TbServiceCompany  tbServiceCompanyBean : list){
                                    //????????????????????????email??????
                                    //String email =tbServiceCompanyBean.getOwnerEmail();
                                    String userId = tbServiceCompanyBean.getId();
                                    User user = getUserInfo(userId);
                                    if(user == null ){
                                        continue;
                                    }
                                    if(StringUtils.isNotBlank(user.getEmail())){
                                        message =new StringBuilder();
                                        String email=user.getEmail();
                                        message.append("[??????????????????] ???????????? ???").append(taskBean.getTaskName());
                                        if(taskBean.getInLine() !=0){
                                            message.append(",??????").append(taskBean.getInLine()) .append("???????????????????????????!");
                                        }else if(taskBean.getOutLine() !=0){
                                            message.append(",????????????").append(taskBean.getOutLine()) .append("?????????????????????!");
                                        }
                                        sendEmail(email, message.toString(),title);
                                    }
                                }
                            }

                        }

                    }

                    if(DataUploadConstants.WARNING_BY_SMSTEXT.equals(menthod)){
                        //??????
                        if(taskBean.getFileType().equals(DataUploadConstants.GARDEN_TYPE)){
                            //?????????????????????
                            TbDataReportingGardenFillerCriteria fillerCriteria = new TbDataReportingGardenFillerCriteria();
                            fillerCriteria.or().andFillIdEqualTo(taskBean.getFillId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                            List<TbDataReportingGardenFiller> fillers = tbDataReportingGardenFillerMapper.selectByExample(fillerCriteria);
                            if(fillers !=null && fillers.size()>0){
                                for(TbDataReportingGardenFiller fillerBean : fillers){
                                    //????????????
                                    TbDataReportingGardenLinkerCriteria  gardenLinkerCriteria = new TbDataReportingGardenLinkerCriteria();
                                    gardenLinkerCriteria.or().andDepartmentIdEqualTo(fillerBean.getDepartmentId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                                    List<TbDataReportingGardenLinker> linkers =  tbDataReportingGardenLinkerMapper.selectByExample(gardenLinkerCriteria);
                                    if(linkers !=null && linkers.size()>0){
                                        User user;
                                        for(TbDataReportingGardenLinker linkerBean :  linkers){

                                            //??????????????????????????????????????????????????????
                                            String userId = linkerBean.getLinkAccount();
                                            user = getUserInfo(userId);
                                            if(user == null ){
                                                continue;
                                            }
                                            if(StringUtils.isNotBlank(user.getPhone())){
                                                String phone  =user.getPhone();
                                                message =new StringBuilder();
                                                message.append("[??????????????????]???????????? ???").append(taskBean.getTaskName());
                                                if(taskBean.getInLine() !=0){
                                                    message.append(",??????").append(taskBean.getInLine()) .append("???????????????????????????!");
                                                }else if(taskBean.getOutLine() !=0){
                                                    message.append(",????????????").append(taskBean.getOutLine()) .append("?????????????????????!");
                                                }
                                                sendSMS(phone,message.toString());
                                            }

                                        }
                                    }
                                }
                            }

                        }else{
                            //??????,????????????ID,?????????????????????
                            TbServiceCompanyCriteria exp = new  TbServiceCompanyCriteria();
                            exp.or().andIdEqualTo(taskBean.getFillInFormId()).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
                            List<TbServiceCompany> list =  tbServiceCompanyMapper.selectByExample(exp);
                            if(list !=null && list.size()>0){
                                for(TbServiceCompany  tbServiceCompanyBean : list){
                                    if(StringUtils.isNotBlank(tbServiceCompanyBean.getOwnerPhone())){
                                        String phone  = tbServiceCompanyBean.getOwnerPhone();
                                        message =new StringBuilder();
                                        message.append("[??????????????????]???????????? ???").append(taskBean.getTaskName());
                                        if(taskBean.getInLine() !=0){
                                            message.append(",??????").append(taskBean.getInLine()) .append("???????????????????????????!");
                                        }else if(taskBean.getOutLine() !=0){
                                            message.append(",????????????").append(taskBean.getOutLine()) .append("?????????????????????!");
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
     * ????????????
     * @param taskBatch
     * @param fillId
     * @return
     */
    @ServiceLog(doAction = "????????????")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int setStatisticsListUrge(String taskBatch,String fillId){
        int result=0;
        //????????????????????????????????????????????????????????????
        targetDao.updateCalling(taskBatch,fillId,DataUploadConstants.GARDEN_TYPE);
        return result+=1 ;
    }


    @Override
    @ServiceLog(doAction = "??????????????????-??????????????????????????????")
    public ModelDataVO getFormedStruct(User user,String fillId){

        return getModelStructByHistoryFillId(fillId,user,DataUploadConstants.COMPANY_TYPE);
    }

    @Override
    @ServiceLog(doAction = "??????????????????-??????????????????????????????")
    public ModelDataVO getStruct(User user,String fillId){

        return getModelStructByHistoryFillId(fillId,user,DataUploadConstants.GARDEN_TYPE);
    }

    /**????????????????????????**/

    @ServiceLog(doAction = "????????????-????????????????????????-????????????")
    public PaginationData<List<GardenCheckModel>> getGardenCheckList(GardenCheckParamModel param){
        Page<Object> objects = PageHelper.startPage(param.getPage(), param.getRows() == 0 ? 15 : param.getRows());

        //????????????????????????????????????
        List<GardenCheckModel> dataList = targetDao.getGardenCheckList(param);
        PaginationData<List<GardenCheckModel>> data = new  PaginationData<>(dataList,objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "????????????-????????????????????????-??????/??????")
    public ModelDataVO getCheckOrLookInfo(String fillId,User user){
        return getModelStructByHistoryFillId(fillId,user,DataUploadConstants.GARDEN_TYPE);
    }




    /**
     * ????????????????????????????????????
     * @param userId
     * @return
     */
    private User getUserInfo(String userId){
        //??????????????????????????????????????????????????????
        User user = new User();
        user.setId(userId);
        Result<User> concurentUser = systemClient.getUser(user);
        return concurentUser.getData();
    }

    /**
     * ????????????
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
        logger.info("????????????????????????????????????{},????????????{}",phone,message);
        boolean sendStatus = messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
        if (sendStatus) {
            logger.info("[??????????????????]???????????????????????????????????????,{}",message);
        } else {
            logger.error("[??????????????????]???????????????????????????????????????,{}", message);
        }

    }



    /**
     * ???????????? String address
     */
    private void sendEmail(String emailAddress,String message,String title){
        EmailVo emailVo = new EmailVo();
        emailVo.setEmail(emailAddress);
        emailVo.setEmailSubject("[??????????????????]????????????????????????");
        //emailVo.setTemplatesName("");

        //???????????????????????????
        Map map = new HashMap<>();
        //????????????????????????
        map.put("title", title);
        map.put("time", DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        //????????????+????????????????????????
        map.put("content", message);
        emailVo.setTemplatesDataMap(map);
        emailVo.setTemplateFlag(true);

        //????????????
        boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
        if (sendStatus) {
            logger.info("[??????????????????]???????????????????????????????????????,{}",message);
        } else {
            logger.error("[??????????????????]???????????????????????????????????????,{}", message);
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

    /**
     * APP??????
     * @param monitorContent
     * @param getId
     */
    private void sendApp(String monitorContent,String getId){
        AppSinkVo appSinkVo=new AppSinkVo();
        appSinkVo.setTitle("????????????????????????");
        appSinkVo.setContent(monitorContent);
        appSinkVo.setIds(Lists.newArrayList(getId));
        appSinkVo.setPushType("DEVICE");
        appSinkVo.setNoticeType("NOTICE");
        logger.info("APP??????{}",appSinkVo);
        messageSource.outputApp().send(MessageBuilder.withPayload(appSinkVo).build());

    }
}
