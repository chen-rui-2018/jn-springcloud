package com.jn.park.customer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.model.IBPSCompleteParam;
import com.jn.enterprise.model.IBPSMyTasksParam;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.park.customer.dao.TbClientExecuteImgMapper;
import com.jn.park.customer.dao.TbClientServiceCenterMapper;
import com.jn.park.customer.entity.TbClientExecuteImg;
import com.jn.park.customer.entity.TbClientServiceCenter;
import com.jn.park.customer.entity.TbClientServiceCenterCriteria;
import com.jn.park.customer.enums.IBPSMyTaskParamEnum;
import com.jn.park.customer.enums.IBPSOptionsStatusEnum;
import com.jn.park.customer.model.IBPSCompleteCustomerParam;
import com.jn.park.customer.model.IBPSOnlineCustomerForm;
import com.jn.park.customer.model.MyTasksParam;
import com.jn.park.customer.model.MyTasksResult;
import com.jn.park.customer.service.CustomerServiceCenterManageService;
import com.jn.park.enums.CustomerCenterExceptionEnum;
import com.jn.system.log.annotation.ServiceLog;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 我的待办事项
     * @param myTasksParam
     * @param loginAccount
     * @return
     */
    @Override
    public PaginationData myTasks(MyTasksParam myTasksParam, String loginAccount) {
        //设置待办事项的动态参数
        IBPSMyTasksParam ibpsMyTasksParam = setIBPSMyTaskParamIfo(myTasksParam, loginAccount);
        //查询我的待办事项
        JSONObject jsonObject = IBPSUtils.myTasks(loginAccount, ibpsMyTasksParam);
        IBPSResult ibpsResult = new Gson().fromJson(jsonObject.toString(), IBPSResult.class);
        //请求响应码
        String okStatus="200";
        //获取我的待办事项
        if(okStatus.equals(ibpsResult.getState())){
            logger.info("----------------根据查询条件获取我的待办事项成功------------");
            //解析数据
            List<MyTasksResult> resultList = getMyTasksResults(ibpsResult);
            Object pageResult = ((LinkedTreeMap) ibpsResult.getData()).get("pageResult");
            com.github.pagehelper.Page<Object> objects = PageHelper.startPage(myTasksParam.getPage(), myTasksParam.getRows());
            return new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
        }else{
            logger.warn("获取我的待办事项失败，{}",ibpsResult.getMessage());
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
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
        IBPSMyTasksParam ibpsMyTasksParam = setIBPSMyTaskParamIfo(myTasksParam, loginAccount);
        //查询我的已办办事项
        JSONObject jsonObject = IBPSUtils.myHandled(loginAccount, ibpsMyTasksParam);
        IBPSResult ibpsResult = new Gson().fromJson(jsonObject.toString(), IBPSResult.class);
        //请求响应码
        String okStatus="200";
        //获取我的已办事项
        if(okStatus.equals(ibpsResult.getState())){
            logger.info("----------------根据查询条件获取我的已办事项成功------------");
            //解析数据
            List<MyTasksResult> resultList = getMyTasksResults(ibpsResult);
            Object pageResult = ((LinkedTreeMap) ibpsResult.getData()).get("pageResult");
            com.github.pagehelper.Page<Object> objects = PageHelper.startPage(myTasksParam.getPage(), myTasksParam.getRows());
            return new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
        }else{
            logger.warn("获取我的已办事项失败，{}",ibpsResult.getMessage());
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
        }
    }

    /**
     * 解析待办事项数据
     * @param ibpsResult
     * @return
     */
    @ServiceLog(doAction = "解析待办事项数据")
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
     * @param loginAccount
     */
    @ServiceLog(doAction = "设置待办/已办事项的动态参数")
    private IBPSMyTasksParam setIBPSMyTaskParamIfo(MyTasksParam myTasksParam, String loginAccount) {
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
        //设置排序参数 默认按照创建时间倒序排序
        List<Map<String,String>>sortsParam=new ArrayList<>();
        Map<String,String>sortMap=new HashMap<>(16);
        sortMap.put("createTime","desc");
        sortsParam.add(sortMap);
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
            IBPSOnlineCustomerForm customerForm = gson.fromJson(boData, IBPSOnlineCustomerForm.class);
            return customerForm;
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
            logger.warn("获取获取流程表单失败，{}",ibpsResult.getMessage());
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
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
            logger.warn("流程实例id：{}在系统中不传在，{}",procInstId);
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.PROCESS_INS_ID_NOT_NULL);
        }
        //判断当前操作，系统是否支持
        List<String>actionNameList= Arrays.asList(IBPSOptionsStatusEnum.AGREE.getCode(),IBPSOptionsStatusEnum.OPPOSE.getCode()
                ,IBPSOptionsStatusEnum.REJECT_TO_PREVIOUS.getCode());
        if(!actionNameList.contains(actionName)){
            logger.warn("当前操作名称：[{}]不是系统所支持的",actionName);
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.PROCESS_INS_ID_NOT_NULL);
        }
        if(pictureUrl==null || pictureUrl.length>3){
            logger.warn("处理问题时，问题描述最多允许上传3张图片");
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.PICTURE_URL_MORE_THAN_ALLOW);
        }
    }
}
