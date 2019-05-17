package com.jn.park.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.park.customer.dao.TbClientServiceCenterMapper;
import com.jn.park.customer.entity.TbClientServiceCenter;
import com.jn.park.customer.entity.TbClientServiceCenterCriteria;
import com.jn.park.customer.model.*;
import com.jn.park.customer.service.CustomerServiceCenterService;
import com.jn.park.enums.CustomerCenterExceptionEnum;
import com.jn.park.parkcode.dao.TbParkCodeMapper;
import com.jn.park.parkcode.entity.TbParkCode;
import com.jn.park.parkcode.entity.TbParkCodeCriteria;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/5/14 9:42
 * @Version v1.0
 * @modified By:
 */
@Service
public class CustomerServiceCenterServiceImpl implements CustomerServiceCenterService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceCenterServiceImpl.class);

    @Autowired
    private TbClientServiceCenterMapper tbClientServiceCenterMapper;

    @Autowired
    private TbParkCodeMapper tbParkCodeMapper;

    @Autowired
    private UserExtensionClient userExtensionClient;


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
     * 园区用户咨询客服
     * @param param         分页信息
     * @param loginAccount  用户账号
     * @return
     */
    @ServiceLog(doAction = "园区用户咨询客服")
    @Override
    public PaginationData consultationCustomerList(ConsultationCustomerListParam param, String loginAccount) {
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(param.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<ConsultationCustomerListShow> customerCenterList = getCustomerCenterList(loginAccount);
            return new PaginationData(customerCenterList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(param.getNeedPage())){
            objects = PageHelper.startPage(param.getPage(),
                    param.getRows() == 0 ? 15 : param.getRows(), true);
        }
        List<ConsultationCustomerListShow> customerCenterList = getCustomerCenterList(loginAccount);
        return new PaginationData(customerCenterList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 根据任务id获取问题详情
     * @param account 用户账号
     * @param processId 流程实例id
     * @return
     */
    @ServiceLog(doAction = "根据任务id获取问题详情")
    @Override
    public Object customerQuesDetail(String account,String processId){
        JSONObject opinions = IBPSUtils.opinions(account, processId, null);
        return opinions;
    }

    /**
     * 服务模块信息
     * @return
     */
    @ServiceLog(doAction = "服务模块信息")
    @Override
    public List<ServiceModuleShow> serviceModules() {
        TbParkCodeCriteria example=new TbParkCodeCriteria();
        example.createCriteria().andGroupIdEqualTo(SERVICE_MODULE).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbParkCode> tbParkCodes = tbParkCodeMapper.selectByExample(example);
        if(tbParkCodes.isEmpty()){
            logger.warn("园区字典表中服务模块信息不存在，请添加");
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
        }
        List<ServiceModuleShow>result=new ArrayList<>(16);
        for(TbParkCode tbParkCode:tbParkCodes){
            ServiceModuleShow serviceModuleShow=new ServiceModuleShow();
            serviceModuleShow.setServiceModule(tbParkCode.getCodeValue());
            serviceModuleShow.setServiceModuleName(tbParkCode.getCodeName());
            result.add(serviceModuleShow);
        }
        return result;
    }

    /**
     * 在线客服
     * @param param
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "在线客服")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int onlineCustomerService(OnlineCustomerParam param, String loginAccount) {
        //校验上传的问题图片数量不能超过三张
        int maxPictureSize=3;
        if(param.getQuesUrl()!=null && param.getQuesUrl().length>maxPictureSize){
            logger.warn("当前问题描述图片为：{}张，问题描述图片不能超过3张",param.getQuesUrl().length);
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.QUES_PICTURE_NUM_MORE_THAN_MAX);
        }
        String quesCode=getQuesCode();
        IBPSOnlineCustomerParam ibpsOnlineCustomerParam = setIBPSOnlineCustomerParam(param, loginAccount,quesCode);
        //启动工作流
        IBPSResult ibpsResult = IBPSUtils.startWorkFlow(onlineCustomerProcessId, loginAccount, ibpsOnlineCustomerParam);
        String okStatus="200";
        //启动工作流成功
        if(okStatus.equals(ibpsResult.getState())){
            logger.info("在线客服提交成功，审批流程启动成功,流程实例id为：[{}]",ibpsResult.getData());
            //将工作流返回的流程实例id更新到新增的数据中
            int resNum = updateProcessInstanceId(loginAccount, quesCode, ibpsResult.getData());
            return resNum;
        }else{
            logger.warn("在线客服启动工作流异常，{}",ibpsResult.getMessage());
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
        }
    }

    /**
     * 更新流程实例id
     * @param loginAccount 用户账号
     * @param quesCode    问题编号
     * @param processInstanceId  流程实例id
     * @return
     */
    private int updateProcessInstanceId(String loginAccount, String quesCode, String processInstanceId) {
        TbClientServiceCenterCriteria example=new TbClientServiceCenterCriteria();
        example.createCriteria().andQuesCodeEqualTo(quesCode).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        TbClientServiceCenter tbClientServiceCenter=new TbClientServiceCenter();
        //流程实例ID
        tbClientServiceCenter.setProcessInsId(processInstanceId);
        //修改时间
        tbClientServiceCenter.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //修改人
        tbClientServiceCenter.setModifierAccount(loginAccount);
        return tbClientServiceCenterMapper.updateByExampleSelective(tbClientServiceCenter, example);
    }

    /**
     * 设置在线客服ibps启动流工作流表单数据
     * @param param
     * @param loginAccount
     * @param quesCode      问题编码
     */
    private IBPSOnlineCustomerParam setIBPSOnlineCustomerParam(OnlineCustomerParam param, String loginAccount,String quesCode) {
        IBPSOnlineCustomerParam ibpsParam=new IBPSOnlineCustomerParam();
        BeanUtils.copyProperties(param, ibpsParam);
        //问题编码
        ibpsParam.setQuesCode(quesCode);
        if(param.getQuesUrl()!=null){
            //把数组转为字符串，用";"分隔
            ibpsParam.setQuesUrl(StringUtils.join(param.getQuesUrl(),";"));
        }
        //服务模块名称设置
        List<ServiceModuleShow> serviceModuleShows = serviceModules();
        if(!serviceModuleShows.isEmpty()){
            for(ServiceModuleShow serviceModuleShow:serviceModuleShows){
                if(StringUtils.equals(param.getServiceModule(), serviceModuleShow.getServiceModule())){
                    ibpsParam.setServiceModuleName(serviceModuleShow.getServiceModuleName());
                    break;
                }
            }
        }
        //创建人
        ibpsParam.setCreatorAccount(loginAccount);
        //创建时间
        ibpsParam.setCreatedTime(DateUtils.getDate(PATTERN));
        //处理状态(0：待处理  1:处理中 2：已处理)
        ibpsParam.setStatus("0");
        //是否删除
        ibpsParam.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        //设置用户的基本信息
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(loginAccount);
        if(userExtension==null || userExtension.getData()==null){
            logger.warn("设置在线客服ibps启动流工作流表单数据获取用户信息失败");
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.NETWORK_ANOMALY);
        }
        UserExtensionInfo userInfo = userExtension.getData();
        //当前来电  若联系方式是邮箱，设置用户的手机号，反之设置用户填写的手机号
        ibpsParam.setCurrentCaller(ibpsParam.getContactWay().contains("@")?userInfo.getPhone():ibpsParam.getContactWay());
        //客户姓名
        ibpsParam.setCustName(userInfo.getName());
        //客户性别
        ibpsParam.setCustSex(userInfo.getSex());
        return ibpsParam;
    }

    /**
     * 获取问题编码
     * @return
     */
    private String getQuesCode() {
        return "QE-"+DateUtils.getDate("yyyyMMddHHmmss");
    }

    /**
     * 根据用户账号获取客服中心问题列表
     * @param loginAccount
     * @return
     */
    private List<ConsultationCustomerListShow> getCustomerCenterList(String loginAccount) {
        TbClientServiceCenterCriteria example=new TbClientServiceCenterCriteria();
        example.createCriteria().andCreatorAccountEqualTo(loginAccount)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        example.setOrderByClause("created_time desc");
        List<TbClientServiceCenter> tbClientServiceCenterList = tbClientServiceCenterMapper.selectByExample(example);
        if(tbClientServiceCenterList.isEmpty()){
            return null;
        }else{
            List<ConsultationCustomerListShow> resultList=new ArrayList<>();
            for(TbClientServiceCenter tbClientServiceCenter:tbClientServiceCenterList){
                ConsultationCustomerListShow customerListShow=new ConsultationCustomerListShow();
                BeanUtils.copyProperties(tbClientServiceCenter, customerListShow);
                resultList.add(customerListShow);
            }
            return resultList;
        }
    }
}
