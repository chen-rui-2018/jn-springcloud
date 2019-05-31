package com.jn.park.customer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.RestTemplateUtil;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.model.IBPSCompleteParam;
import com.jn.enterprise.model.IBPSMyTasksParam;
import com.jn.enterprise.model.MyTasksResult;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.park.customer.dao.TbClientExecuteImgMapper;
import com.jn.park.customer.dao.TbClientServiceCenterMapper;
import com.jn.park.customer.entity.TbClientExecuteImg;
import com.jn.park.customer.entity.TbClientServiceCenter;
import com.jn.park.customer.entity.TbClientServiceCenterCriteria;
import com.jn.park.customer.enums.IBPSExecuteTypeEnum;
import com.jn.enterprise.enums.IBPSMyTaskParamEnum;
import com.jn.park.customer.enums.IBPSOptionsStatusEnum;
import com.jn.park.customer.model.*;
import com.jn.park.customer.service.CustomerServiceCenterManageService;
import com.jn.park.customer.service.CustomerServiceCenterService;
import com.jn.park.enums.CustomerCenterExceptionEnum;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.apache.http.client.HttpClient;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 客服中心--园区客服中心
 * @Author: yangph
 * @Date: 2019/5/19 16:05
 * @Version v1.0
 * @modified By:
 */
@Service
public class CustomerServiceCenterManageServiceImpl implements CustomerServiceCenterManageService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceCenterManageServiceImpl.class);

    @Autowired
    private TbClientServiceCenterMapper centerMapper;

    @Autowired
    private TbClientExecuteImgMapper executeImgMapper;

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private CustomerServiceCenterService centerService;
    /**
     * 字典表服务模块分组id
     */
    private static final String SERVICE_MODULE="serviceModule";
    /**
     * 日期格式
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";
    /**
     * 在线客服流程id
     */
    @Value(value = "${onlineCustomerProcessId}")
    private String onlineCustomerProcessId;

    /**
     * 在线客服流程定义key
     */
    @Value(value = "${procDefKey}")
    private String procDefKey;

    /**
     * 我的待办事项
     * @param myTasksParam
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "我的待办事项")
    @Override
    public PaginationData myTasks(MyTasksParam myTasksParam, String loginAccount) {
        //设置待办事项的动态参数
        IBPSMyTasksParam ibpsMyTasksParam = setIBPSMyTaskParamIfo(myTasksParam,IBPSExecuteTypeEnum.TASKS.getCode());
        //查询我的待办事项
        JSONObject jsonObject = IBPSUtils.myTasks(loginAccount, ibpsMyTasksParam);
        IBPSResult ibpsResult = new Gson().fromJson(jsonObject.toString(), IBPSResult.class);
        //请求响应码
        String okStatus="200";
        //获取我的待办事项
        if(okStatus.equals(ibpsResult.getState())){
            logger.info("----------------根据查询条件获取我的待办事项成功------------");
            //解析封装数据
            return processResultData(myTasksParam, ibpsResult,IBPSExecuteTypeEnum.TASKS.getCode());

        }else{
            logger.warn("获取我的待办事项失败，{}",ibpsResult.getMessage());
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
        }
    }

    /**
     * 解析并封装返回数据
     * @param myTasksParam
     * @param ibpsResult
     * @param type  task:待办   handled:已办
     * @return
     */
    @ServiceLog(doAction = "解析并封装返回数据")
    private PaginationData processResultData(MyTasksParam myTasksParam, IBPSResult ibpsResult,String type) {
        List<MyTasksResult> resultList = getMyTasksResults(ibpsResult);
        if (resultList.isEmpty()) {
            return new PaginationData(resultList, 0);
        }
        //流程实例id列表
        List<String> processInsIdList = new ArrayList<>();
        //流程实例id和任务id列表
        List<Map<String, String>> procInsIdAndTaskIdList = new ArrayList<>();
        if(StringUtils.equals(IBPSExecuteTypeEnum.TASKS.getCode(), type)){
            for (MyTasksResult myTasksResult : resultList) {
                processInsIdList.add(myTasksResult.getProcInstId());
                Map<String, String> map = new HashMap<>();
                map.put(myTasksResult.getProcInstId(), myTasksResult.getTaskId());
                procInsIdAndTaskIdList.add(map);
            }
        }else if(StringUtils.equals(IBPSExecuteTypeEnum.HANDLED.getCode(), type)){
            for (MyTasksResult myTasksResult : resultList) {
                processInsIdList.add(myTasksResult.getId());
                Map<String, String> map = new HashMap<>();
                map.put(myTasksResult.getId(), myTasksResult.getTaskId());
                procInsIdAndTaskIdList.add(map);
            }
        }
        //根据流程实例id从客服问题表查询需要处理的事项
        return getPaginationDataQuesTaskList(myTasksParam,processInsIdList, procInsIdAndTaskIdList);
    }

    /**
     * 分页封装待处理问题数据
     * @param myTasksParam
     * @param processInsIdList
     * @param procInsIdAndTaskIdList
     * @return
     */
    @ServiceLog(doAction = "分页封装待处理问题数据")
    private PaginationData getPaginationDataQuesTaskList(MyTasksParam myTasksParam,List<String> processInsIdList, List<Map<String, String>> procInsIdAndTaskIdList) {
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(myTasksParam.getPage(), myTasksParam.getRows());
        TbClientServiceCenterCriteria example=new TbClientServiceCenterCriteria();
        example.createCriteria().andProcessInsIdIn(processInsIdList).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbClientServiceCenter> serviceCenterList = centerMapper.selectByExample(example);
        List<ConsultationCustomerListShow> resultTask=new ArrayList<>();
        if(serviceCenterList==null || serviceCenterList.isEmpty()){
            return new PaginationData(serviceCenterList, 0);
        }else{
            for(TbClientServiceCenter serviceCenter:serviceCenterList){
                ConsultationCustomerListShow customerListShow=new ConsultationCustomerListShow();
                BeanUtils.copyProperties(serviceCenter, customerListShow);
                customerListShow.setCreatedTime(DateUtils.formatDate(serviceCenter.getCreatedTime(), PATTERN));
                for(Map<String,String> map:procInsIdAndTaskIdList){
                   if(map.containsKey(customerListShow.getProcessInsId())){
                       customerListShow.setTaskId(map.get(customerListShow.getProcessInsId()));
                       break;
                   }
                }
                resultTask.add(customerListShow);
            }
            return new PaginationData(resultTask, objects==null?0:objects.getTotal());
        }
    }

    /**
     * 我的已办事项
     * @param myTasksParam
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "我的已办事项")
    @Override
    public PaginationData myHandled(MyTasksParam myTasksParam, String loginAccount) {
        //设置已办办事项的动态参数
        IBPSMyTasksParam ibpsMyTasksParam = setIBPSMyTaskParamIfo(myTasksParam,IBPSExecuteTypeEnum.HANDLED.getCode());
        //查询我的已办办事项
        JSONObject jsonObject = IBPSUtils.myHandled(loginAccount, ibpsMyTasksParam);
        IBPSResult ibpsResult = new Gson().fromJson(jsonObject.toString(), IBPSResult.class);
        //请求响应码
        String okStatus="200";
        //获取我的已办事项
        if(okStatus.equals(ibpsResult.getState())){
            logger.info("----------------根据查询条件获取我的已办事项成功------------");
            //解析数据
          return processResultData(myTasksParam, ibpsResult,IBPSExecuteTypeEnum.HANDLED.getCode());
        }else{
            logger.warn("获取我的已办事项失败，{}",ibpsResult.getMessage());
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
        }
    }

    /**
     * 解析待办/已办事项数据
     * @param ibpsResult
     * @return
     */
    @ServiceLog(doAction = "解析待办/已办事项数据")
    private List<MyTasksResult> getMyTasksResults(IBPSResult ibpsResult) {
        Object data = ibpsResult.getData();
        LinkedTreeMap dataMap=(LinkedTreeMap)data;
        List<LinkedTreeMap> dataResult = (List<LinkedTreeMap> )dataMap.get("dataResult");
        List<MyTasksResult> resultList=new ArrayList<>(16);
        for(LinkedTreeMap linkedTreeMap:dataResult){
            ObjectMapper objectMapper = new ObjectMapper();
            MyTasksResult myTasksResult = objectMapper.convertValue(linkedTreeMap, MyTasksResult.class);
            resultList.add(myTasksResult);
        }
        return resultList;
    }

    /**
     * 设置待办/已办事项的动态参数
     * @param myTasksParam
     * @param type    task:待办   handled:已办
     */
    @ServiceLog(doAction = "设置待办/已办事项的动态参数")
    private IBPSMyTasksParam setIBPSMyTaskParamIfo(MyTasksParam myTasksParam, String type) {
        List<Map<String,String>> dynamicParams=new ArrayList<>(16);
        Map<String,String>dynamicMap=new HashMap<>();
        if(StringUtils.isNotBlank(myTasksParam.getProcInstId())){
            dynamicMap.put(IBPSMyTaskParamEnum.PROC_INST_ID.getCode(),myTasksParam.getProcInstId());
        }
        if(StringUtils.isNotBlank(myTasksParam.getTaskId())){
            dynamicMap.put(IBPSMyTaskParamEnum.TASK_ID.getCode(),myTasksParam.getTaskId());
        }
        if(StringUtils.isNotBlank(myTasksParam.getProcDefId())){
            dynamicMap.put(IBPSMyTaskParamEnum.PROC_DEF_ID.getCode(),myTasksParam.getProcDefId());
        }
        if(StringUtils.isNotBlank(myTasksParam.getProcDefKey())){
            dynamicMap.put(IBPSMyTaskParamEnum.PROC_DEF_KEY.getCode(),myTasksParam.getProcDefKey());
        }
        if(StringUtils.isNotBlank(myTasksParam.getProcDefName())){
            dynamicMap.put(IBPSMyTaskParamEnum.PROC_DEF_NAME.getCode(),myTasksParam.getProcDefName());
        }
        if(!dynamicMap.isEmpty()){
            dynamicParams.add(dynamicMap);
        }
        //设置分页参数，默认查询第一页的20条数据
        int pageNo=1;
        int limit=20;
        //需要分页
        String needPage="1";
        if(myTasksParam.getNeedPage()!=null && needPage.equals(myTasksParam.getNeedPage())){
            pageNo=myTasksParam.getPage();
            limit=myTasksParam.getRows();
        }
        //设置排序字段
        List<Map<String,String>>sortsParam=null;
        if(StringUtils.equals(IBPSExecuteTypeEnum.TASKS.getCode(),type)){
            //设置排序参数 默认按照创建时间倒序排序
            sortsParam=new ArrayList<>();
            Map<String,String>sortMap=new HashMap<>(16);
            sortMap.put("createTime","desc");
            sortsParam.add(sortMap);
        }
        return new IBPSMyTasksParam(dynamicParams,limit,pageNo,sortsParam);
    }

    /**
     * 获取流程表单
     * @param processInsId
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "获取流程表单")
    @Override
    public IBPSOnlineCustomerForm getInstForm(String processInsId, String loginAccount) {
        JSONObject jsonObject = IBPSUtils.getInstForm(loginAccount, processInsId);
        IBPSResult ibpsResult = new Gson().fromJson(jsonObject.toString(), IBPSResult.class);
        //请求响应码
        String okStatus="200";
        //获取获取流程表单
        if(okStatus.equals(ibpsResult.getState())){
            logger.info("----------------根据查询条件获取获取流程表单成功------------");
            Object data = ibpsResult.getData();
            LinkedTreeMap dataMap=(LinkedTreeMap)data;
            String  boData = (String)dataMap.get("boData");
            Gson gson=new Gson();
            return gson.fromJson(boData, IBPSOnlineCustomerForm.class);
        }else{
            logger.warn("获取获取流程表单失败，{}",ibpsResult.getMessage());
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
        }
    }

    /**
     * 处理任务
     * @param customerParam
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "处理任务")
    @Override
    public int complete(IBPSCompleteCustomerParam customerParam, String loginAccount) {
        //1.参数校验
        checkCompleteParam(customerParam.getActionName(), customerParam.getProcInstId(),customerParam.getOpinionUrl());
        //2.获取流程表单
        IBPSOnlineCustomerForm instForm = getInstForm(customerParam.getProcInstId(), loginAccount);
        //3.ibps处理任务
        IBPSCompleteParam ibpsCompleteParam=new IBPSCompleteParam();
        BeanUtils.copyProperties(customerParam, ibpsCompleteParam);
        ibpsCompleteParam.setData(instForm);
        JSONObject jsonObject = IBPSUtils.complete(loginAccount, ibpsCompleteParam);
        IBPSResult ibpsResult = new Gson().fromJson(jsonObject.toString(), IBPSResult.class);
        //请求响应码
        String okStatus="200";
        //处理任务是否正常执行
        if(okStatus.equals(ibpsResult.getState())){
            logger.info("----------------处理任务执行成功------------");
            //4.保存处理描述url
            if(customerParam.getOpinionUrl()==null || customerParam.getOpinionUrl().length==0){
                return 1;
            }else{
                return addCustomerExecuteImgInfo(customerParam, loginAccount);
            }
        }else{
            logger.warn("处理任务失败，{}",ibpsResult.getMessage());
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
        }
    }

    /**
     * 园区客服中心
     * @param param
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "园区客服中心")
    @Override
    public PaginationData myTasksOrMyHandled(MyTasksOrMyHandledParam param, String loginAccount) {
        //判断流程类型是我的待办，已办还是全部
        if(StringUtils.equals(IBPSExecuteTypeEnum.TASKS.getCode(),param.getProcType())){
            //待处理
            MyTasksParam myTasksParam=new MyTasksParam();
            BeanUtils.copyProperties(param, myTasksParam);
            myTasksParam.setProcDefKey(procDefKey);
            return  myTasks(myTasksParam,loginAccount);
        }else if(StringUtils.equals(IBPSExecuteTypeEnum.HANDLED.getCode(),param.getProcType())){
            //已处理
            MyTasksParam myTasksParam=new MyTasksParam();
            BeanUtils.copyProperties(param, myTasksParam);
            myTasksParam.setProcDefKey(procDefKey);
            return myHandled(myTasksParam,loginAccount);
        }else{
            logger.warn("园区客服中心获取失败，流程类型：[{}]无法识别",param.getProcType());
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.PROCESS_TYPE_NOT_ALLOW);
        }
    }

    /**
     * 添加客服中心问题处理描述图片信息
     * @param customerParam
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "添加客服中心问题处理描述图片信息")
    private int addCustomerExecuteImgInfo(IBPSCompleteCustomerParam customerParam, String loginAccount) {
        TbClientExecuteImg tbClientExecuteImg=new TbClientExecuteImg();
        //id
        tbClientExecuteImg.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //流程实例id
        tbClientExecuteImg.setProcInstId(customerParam.getProcInstId());
        //任务id
        tbClientExecuteImg.setTaskId(customerParam.getTaskId());
        //图片url
        tbClientExecuteImg.setPictureUrl(StringUtils.join(customerParam.getOpinionUrl(),";"));
        //创建人
        tbClientExecuteImg.setCreatorAccount(loginAccount);
        //创建时间
        tbClientExecuteImg.setCreatedTime(DateUtils.parseDate(DateUtils.getDate()));
        //是否删除
        tbClientExecuteImg.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        return executeImgMapper.insert(tbClientExecuteImg);
    }

    /**
     * 校验处理任务入参数据
     * @param actionName  操作名称
     * @param procInstId  流程实例id
     * @param pictureUrl  图片url
     */
    private void checkCompleteParam(String actionName, String procInstId,String[]pictureUrl) {
        //判断流程实例id是否存在
        TbClientServiceCenterCriteria example=new TbClientServiceCenterCriteria();
        example.createCriteria().andProcessInsIdEqualTo(procInstId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbClientServiceCenter> tbClientServiceCenters = centerMapper.selectByExample(example);
        if(tbClientServiceCenters.isEmpty()){
            logger.warn("流程实例id：[{}]在系统中不传在",procInstId);
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.PROCESS_INS_ID_NOT_NULL);
        }
        //判断当前操作，系统是否支持
        List<String>actionNameList= Arrays.asList(IBPSOptionsStatusEnum.AGREE.getCode(),IBPSOptionsStatusEnum.OPPOSE.getCode()
                ,IBPSOptionsStatusEnum.REJECT_TO_PREVIOUS.getCode());
        if(!actionNameList.contains(actionName)){
            logger.warn("当前操作名称：[{}]不是系统所支持的",actionName);
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.PROCESS_INS_ID_NOT_NULL);
        }
        if(pictureUrl!=null && pictureUrl.length>3){
            logger.warn("处理问题时，问题描述最多允许上传3张图片");
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.PICTURE_URL_MORE_THAN_ALLOW);
        }
    }

    /**
     * 根据手机号获取用户信息
     * @param phone
     * @return
     */
    @ServiceLog(doAction = "根据手机号获取用户信息")
    @Override
    public UserIntroInfo getUserInfo(String phone) {
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(phone);
        if(userExtension==null || userExtension.getData()==null){
            return null;
        }
        UserExtensionInfo data = userExtension.getData();
        UserIntroInfo userIntroInfo=new UserIntroInfo();
        BeanUtils.copyProperties(data,userIntroInfo);
        if(StringUtils.equals("1",userIntroInfo.getSex())){
            userIntroInfo.setSex("男");
        }else if(StringUtils.equals("0",userIntroInfo.getSex())){
            userIntroInfo.setSex("女");
        }else{
            userIntroInfo.setSex("--");
        }
        if(userIntroInfo.getEmail()==null){
            userIntroInfo.setEmail("");
        }
        return userIntroInfo;
    }

    /**
     * 获取服务模块信息
     * @param phone
     * @return
     */
    @ServiceLog(doAction = "获取服务模块信息")
    @Override
    public PaginationData getCalledHistory(String phone) {
        ConsultationCustomerListParam param=new ConsultationCustomerListParam();
        param.setNeedPage("1");
        param.setPage(1);
        param.setRows(10);
        return centerService.consultationCustomerList(param, phone);
    }

    /**
     * 保存来电录入信息
     * @param calledInfoParam
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "保存来电录入信息")
    @Override
    public int saveCalledInfo(CalledInfoParam calledInfoParam,String loginAccount) {
        //问题编码
        String quesCode=centerService.getQuesCode();
        IBPSOnlineCustomerParam ibpsOnlineCustomerParam = setIBPSCallInfoParam(calledInfoParam,quesCode);
        //启动工作流
        IBPSResult ibpsResult = IBPSUtils.startWorkFlow(onlineCustomerProcessId, loginAccount, ibpsOnlineCustomerParam);
        String okStatus="200";
        //启动工作流成功
        if(okStatus.equals(ibpsResult.getState())){
            logger.info("在线客服提交成功，审批流程启动成功,流程实例id为：[{}]",ibpsResult.getData());
            //将工作流返回的流程实例id更新到新增的数据中
            return centerService.updateProcessInstanceId(calledInfoParam.getContactWay(), quesCode, (String)ibpsResult.getData());
        }else{
            logger.warn("在线客服启动工作流异常，{}",ibpsResult.getMessage());
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
        }
    }



    /**
     * 设置在线客服ibps启动流工作流表单数据
     * @param param
     * @param quesCode
     * @return
     */
    @ServiceLog(doAction = "设置在线客服ibps启动流工作流表单数据")
    private IBPSOnlineCustomerParam setIBPSCallInfoParam(CalledInfoParam param, String quesCode) {
        IBPSOnlineCustomerParam ibpsParam=new IBPSOnlineCustomerParam();
        BeanUtils.copyProperties(param, ibpsParam);
        //问题编码
        ibpsParam.setQuesCode(quesCode);
        //服务模块名称设置
        List<ServiceModuleShow> serviceModuleShows = centerService.serviceModules();
        if(!serviceModuleShows.isEmpty()){
            for(ServiceModuleShow serviceModuleShow:serviceModuleShows){
                if(StringUtils.equals(param.getServiceModule(), serviceModuleShow.getServiceModule())){
                    ibpsParam.setServiceModuleName(serviceModuleShow.getServiceModuleName());
                    break;
                }
            }
        }
        //创建人
        if(StringUtils.isNotBlank(param.getCalledPhone())){

            ibpsParam.setCreatorAccount(param.getCalledPhone());
        }else{
            ibpsParam.setCreatorAccount(param.getContactWay());
        }
        //创建时间
        ibpsParam.setCreatedTime(DateUtils.getDate(PATTERN));
        //处理状态(0：待处理  1:处理中 2：已处理)
        ibpsParam.setStatus("0");
        //是否删除
        ibpsParam.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        //当前来电
        ibpsParam.setCurrentCaller(param.getContactWay());
        //获取用户信息
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(param.getContactWay());
        if(userExtension!=null && userExtension.getData()!=null){
            UserExtensionInfo userInfo = userExtension.getData();
            //客户性别
            ibpsParam.setCustSex(userInfo.getSex());
        }
        return ibpsParam;
    }

    /**
     * 来电归属地查询
     * @param phone
     * @return
     */
    @ServiceLog(doAction = "来电归属地查询")
    @Override
    public String getPhoneCalledOwen(String phone) {
        String url="http://mobsec-dianhua.baidu.com/dianhua_api/open/location?tel="+phone;
        String queryString = RestTemplateUtil.get(url);
        if(queryString.contains("location")){
            queryString=queryString.substring(queryString.indexOf("location"),queryString.length()-1);
            queryString=queryString.substring(0,queryString.indexOf("}}"));
            String[] split = queryString.split(":");
            return split[1].replaceAll("\"","");
        }else{
            return "";
        }
    }
}
