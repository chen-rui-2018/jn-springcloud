package com.jn.enterprise.servicemarket.require.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.RequireExceptionEnum;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgInfoMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgInfo;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgInfoCriteria;
import com.jn.enterprise.servicemarket.product.dao.TbServiceAndAdvisorMapper;
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductMapper;
import com.jn.enterprise.servicemarket.product.entity.TbServiceAndAdvisor;
import com.jn.enterprise.servicemarket.product.entity.TbServiceAndAdvisorCriteria;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProduct;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProductCriteria;
import com.jn.enterprise.servicemarket.require.dao.RequireManagementMapper;
import com.jn.enterprise.servicemarket.require.dao.TbServiceRequireMapper;
import com.jn.enterprise.servicemarket.require.entity.TbServiceRequire;
import com.jn.enterprise.servicemarket.require.entity.TbServiceRequireCriteria;
import com.jn.enterprise.servicemarket.require.model.*;
import com.jn.enterprise.servicemarket.require.service.RequireManagementService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: yangph
 * @Date: 2019/3/4 9:31
 * @Version v1.0
 * @modified By:
 */
@Service
public class RequireManagementServiceImpl implements RequireManagementService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(RequireManagementServiceImpl.class);

    @Autowired
    private TbServiceProductMapper tbServiceProductMapper;

    @Autowired
    private TbServiceOrgInfoMapper tbServiceOrgInfoMapper;

    @Autowired
    private TbServiceRequireMapper tbServiceRequireMapper;

    @Autowired
    private TbServiceAndAdvisorMapper tbServiceAndAdvisorMapper;

    @Autowired
    private RequireManagementMapper requireManagementMapper;

    @Autowired
    private UserExtensionClient userExtensionClient;

    private final ReentrantLock lock = new ReentrantLock();

    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     * 用户提需求(非科技金融)
     * @param requireParam 用户提需求入参
     * @param account      用户账号
     */
    @ServiceLog(doAction = " 用户提需求(非科技金融)")
    @Override
    public void userDemand(RequireParam requireParam, String account) {
        //根据产品id查询服务产品表（tb_service_product），获得机构id和机构名称,领域id和领域名称,设置意向机构信息和领域信息
        List<TbServiceProduct> tbServiceProductList = getTbServiceProducts(requireParam.getProductId());
        if(tbServiceProductList.isEmpty()){
            logger.warn("用户提需求(非科技金融)的产品id：[{}]在系统中不存在",requireParam.getProductId());
            throw new JnSpringCloudException(RequireExceptionEnum.PRODUCT_ID_NOT_EXIST);
        }
        //根据机构id查询机构地址信息表（tb_service_org_info），获取机构联系人电话和邮箱
        List<TbServiceOrgInfo> tbServiceOrgInfoList = getTbServiceOrgInfoList(tbServiceProductList.get(0).getOrgId());
        if(tbServiceOrgInfoList.isEmpty()){
            logger.warn("用户提需求(非科技金融)的产品id：[{}]所对应的的机构在系统中不存在",requireParam.getProductId());
            throw new JnSpringCloudException(RequireExceptionEnum.ORG_ID_NOT_EXIST);
        }
        //根据登录用户账号获取用户姓名，职务，手机号，邮箱，并设置相应属性值
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(account);
        if(userExtension==null || userExtension.getData()==null){
            logger.warn("用户提需求(非科技金融)根据账号获取用户信息失败");
            throw new JnSpringCloudException(RequireExceptionEnum.NETWORK_ANOMALY);
        }
        UserExtensionInfo user = userExtension.getData();
        TbServiceRequire tbServiceRequire=new TbServiceRequire();
        insertRequireInfo(requireParam.getProductId(),requireParam.getProductName(),requireParam.getRequireDetail(),
                         tbServiceProductList.get(0).getOrgId(), tbServiceProductList.get(0).getOrgName(),tbServiceProductList.get(0).getSignoryId(),tbServiceProductList.get(0).getSignoryName(),
                         tbServiceOrgInfoList.get(0).getOrgPhone(),tbServiceOrgInfoList.get(0).getConEmail(), user, tbServiceRequire);
    }


    /**
     * 获取需求单号
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取需求单号")
    public String getRequireNum(){
        lock.lock();
        try {
            return DateUtils.getDate("yyyyMMddHHmmss")+RandomUtils.nextInt(10);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 用户提需求(科技金融)
     * @param requireTechnologyParam 用户提需求入参
     * @param account                用户账号
     */
    @Override
    @ServiceLog(doAction = "用户提需求(科技金融)")
    public void userDemandTechnology(RequireTechnologyParam requireTechnologyParam, String account) {
        //根据产品id查询服务产品表（tb_service_product），获得机构id和机构名称,领域id和领域名称,设置意向机构信息和领域信息
        List<TbServiceProduct> tbServiceProductList = getTbServiceProducts(requireTechnologyParam.getProductId());
        if(tbServiceProductList.isEmpty()){
            logger.warn("用户提需求(科技金融)的产品[id：{}]在系统中不存在",requireTechnologyParam.getProductId());
            throw new JnSpringCloudException(RequireExceptionEnum.PRODUCT_ID_NOT_EXIST);
        }
        //根据机构id查询机构地址信息表（tb_service_org_info），获取机构联系人电话和邮箱
        List<TbServiceOrgInfo> tbServiceOrgInfoList = getTbServiceOrgInfoList(tbServiceProductList.get(0).getOrgId());
        if(tbServiceOrgInfoList.isEmpty()){
            logger.warn("用户提需求(科技金融)的产品[id：{}]所对应的的机构在系统中不存在",requireTechnologyParam.getProductId());
            throw new JnSpringCloudException(RequireExceptionEnum.ORG_ID_NOT_EXIST);
        }
        //根据登录用户账号获取用户姓名，职务，手机号，邮箱，并设置相应属性值
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(account);
        if(userExtension==null || userExtension.getData()==null){
            logger.warn("用户提需求(科技金融)根据账号获取用户信息失败");
            throw new JnSpringCloudException(RequireExceptionEnum.NETWORK_ANOMALY);
        }
        UserExtensionInfo user = userExtension.getData();
        TbServiceRequire tbServiceRequire=new TbServiceRequire();
        //设置科技金融相关字段信息
        //融资金额
        tbServiceRequire.setFinancingAmount(requireTechnologyParam.getFinancingAmount());
        //实际贷款金额
        tbServiceRequire.setActualLoanAmount(requireTechnologyParam.getActualLoanAmount());
        //融资期限
        tbServiceRequire.setFinancingPeriod(requireTechnologyParam.getFinancingPeriod());
        //资金需求说明
        tbServiceRequire.setFundsReqDesc(requireTechnologyParam.getFundsReqDesc());
        //资金需求日期
        tbServiceRequire.setExpectedDate(DateUtils.parseDate(requireTechnologyParam.getExpectedDate()));
        insertRequireInfo(requireTechnologyParam.getProductId(),requireTechnologyParam.getProductName(),requireTechnologyParam.getRequireDetail(),
                tbServiceProductList.get(0).getOrgId(), tbServiceProductList.get(0).getOrgName(),tbServiceProductList.get(0).getSignoryId(),tbServiceProductList.get(0).getSignoryName(),
                tbServiceOrgInfoList.get(0).getOrgPhone(),tbServiceOrgInfoList.get(0).getConEmail(), user, tbServiceRequire);
    }


    /**
     * 设置提需求bean属性并保存
     * @param productId             产品id
     * @param productName           产品名称
     * @param requireDetail         需求描述
     * @param orgId                 机构id
     * @param orgName               机构名称
     * @param businessId            领域id
     * @param businessArea          领域名称
     * @param orgPhone              机构联系人电话
     * @param conEmail              机构联系人邮箱
     * @param user                  需求人账号，姓名，手机，邮箱，职位
     * @param tbServiceRequire      提需求bean  (科技金融提需求，科技金融相关字段不能空)
     */
    @ServiceLog(doAction = "设置提需求bean属性并保存")
    private void insertRequireInfo(String productId,String productName, String requireDetail,
                                   String orgId,String orgName,String businessId,String businessArea,
                                   String orgPhone,String conEmail,
                                   UserExtensionInfo user, TbServiceRequire tbServiceRequire) {
        //需求id
        tbServiceRequire.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //需求单号
        tbServiceRequire.setReqNum(getRequireNum());
        //领域id和领域名称
        tbServiceRequire.setBusinessId(businessId);
        tbServiceRequire.setBusinessArea(businessArea);
        //意向机构id和机构名称，
        tbServiceRequire.setOrgId(orgId);
        tbServiceRequire.setOrgName(orgName);
        //意向产品
        tbServiceRequire.setProductId(productId);
        tbServiceRequire.setProductName(productName);
        //根据产品id查询产品和顾问关联表（tb_service_and_advisor），获取账号
        List<TbServiceAndAdvisor> advisorByProductId = getAdvisorByProductId(productId);
        if(advisorByProductId.isEmpty()){
            List<String> accountList=new ArrayList<>(16);
            for(TbServiceAndAdvisor serviceAndAdvisor:advisorByProductId){
                accountList.add(serviceAndAdvisor.getAdvisorAccount());
            }
            Result<List<UserExtensionInfo>> moreUserExtension = userExtensionClient.getMoreUserExtension(accountList);
            List<UserExtensionInfo> data = moreUserExtension.getData();
            accountList.clear();
            List<String>advisorNameList=new ArrayList<>(16);
            for(UserExtensionInfo userExtensionInfo:data){
                accountList.add(userExtensionInfo.getAccount());
                advisorNameList.add(userExtensionInfo.getName());
            }
            String accounts = StringUtils.join(accountList, ",");
            String names=StringUtils.join(advisorNameList,",");
            //意向顾问账号，顾问姓名
            tbServiceRequire.setAdvisorAccount(accounts);
            tbServiceRequire.setAdvisorName(names);
        }
        //机构联系人电话和邮箱
        tbServiceRequire.setOrgTelephone(orgPhone);
        tbServiceRequire.setOrgEmail(conEmail);
        //需求描述
        tbServiceRequire.setReqDetail(requireDetail);
        //需求用户姓名，职务，手机号，邮箱
        tbServiceRequire.setReqName(user.getName());
        tbServiceRequire.setReqPost(user.getPost());
        tbServiceRequire.setReqPhone(user.getPhone());
        tbServiceRequire.setReqEmail(user.getEmail());
        //发布日期，发布人
        tbServiceRequire.setIssueTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        tbServiceRequire.setIssueAccount(user.getAccount());
        //需求状态 默认设置为待处理  1：待处理  2:已处理
        tbServiceRequire.setStatus("1");
        //点评装填  默认设置为未点评   0：未点评   1：已点评
        tbServiceRequire.setIsComment("0");
        //对接结果 (1对接成功2对接失败3企业需求撤销 4.未对接)    未对接：4
        tbServiceRequire.setHandleResult("4");
        //创建时间
        tbServiceRequire.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //创建人
        tbServiceRequire.setCreatorAccount(user.getAccount());
        //数据状态  0：删除  1：有效
        byte recordStatus=1;
        tbServiceRequire.setRecordStatus(recordStatus);
        tbServiceRequireMapper.insertSelective(tbServiceRequire);
    }

    /**
     * 根据产品id获取产品管理的顾问信息
     * @param productId  产品id
     * @return
     */
    @ServiceLog(doAction = "根据产品id获取产品管理的顾问信息")
    private List<TbServiceAndAdvisor> getAdvisorByProductId(String productId) {
        TbServiceAndAdvisorCriteria example=new TbServiceAndAdvisorCriteria();
        example.createCriteria().andProductIdEqualTo(productId);
        return tbServiceAndAdvisorMapper.selectByExample(example);
    }


    /**
     * 根据机构id获取机构地址信息
     * @param orgId
     * @return
     */
    @ServiceLog(doAction = "根据机构id获取机构地址信息")
    private List<TbServiceOrgInfo> getTbServiceOrgInfoList(String orgId) {
        //数据状态  0：删除  1：有效
        byte recordStatus=1;
        TbServiceOrgInfoCriteria example=new TbServiceOrgInfoCriteria();
        example.createCriteria().andOrgIdEqualTo(orgId).andRecordStatusEqualTo(recordStatus);
        return tbServiceOrgInfoMapper.selectByExample(example);
    }

    /**
     * 根据产品id获取产品信息
     * @param productId  产品id
     * @return
     */
    @ServiceLog(doAction = "根据产品id获取产品信息")
    private List<TbServiceProduct> getTbServiceProducts(String productId) {
        //数据状态  0：删除  1：有效
        byte recordStatus=1;
        TbServiceProductCriteria example=new TbServiceProductCriteria();
        example.createCriteria().andProductIdEqualTo(productId).andRecordStatusEqualTo(recordStatus);
        return tbServiceProductMapper.selectByExample(example);
    }


    /**
     * 对他人的需求列表查询
     * @param requireOtherParam  对他人的需求查询条件
     * @param account            用户账号
     * ;@return
     */
    @ServiceLog(doAction = "对他人的需求列表查询")
    @Override
    public PaginationData getRequireOtherList(RequireOtherParam requireOtherParam, String account) {
        com.github.pagehelper.Page<Object> objects = null;
        if(requireOtherParam==null || StringUtils.isBlank(requireOtherParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<RequireInfoList> requireOtherList = requireManagementMapper.getRequireOtherList(requireOtherParam, account);
            return new PaginationData(requireOtherList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(requireOtherParam.getNeedPage())){
            objects = PageHelper.startPage(requireOtherParam.getPage(),
                    requireOtherParam.getRows() == 0 ? 15 : requireOtherParam.getRows(), true);
        }
        List<RequireInfoList> requireOtherList = requireManagementMapper.getRequireOtherList(requireOtherParam, account);
        return new PaginationData(requireOtherList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 撤销对他人的需求
     * @param reqNum 需求单号
     * @return
     */
    @ServiceLog(doAction ="撤销对他人的需求")
    @Override
    public int cancelRequire(String reqNum) {
        TbServiceRequireCriteria example=new TbServiceRequireCriteria();
        //数据状态  0：删除  1：有效
        byte recordStatus=1;
        example.createCriteria().andReqNumEqualTo(reqNum).andRecordStatusEqualTo(recordStatus);
        TbServiceRequire tbServiceRequire=new TbServiceRequire();
        //对接结果 1:对接成功 2:对接失败  3:企业需求撤销 4:未对接
        tbServiceRequire.setHandleResult("3");
        //状态 -1:已撤销 1：待处理，2：已处理)
        tbServiceRequire.setStatus("-1");
        return tbServiceRequireMapper.updateByExampleSelective(tbServiceRequire, example);
    }

    /**
     * 需求详情（对他人需求）
     * @param reqNum 需求单号
     * @return
     */
    @ServiceLog(doAction = "需求详情（对他人需求）")
    @Override
    public RequireOtherDetails getOtherRequireDetails(String reqNum) {
        TbServiceRequireCriteria  example=new TbServiceRequireCriteria();
        //数据状态  0：删除  1：有效
        byte recordStatus=1;
        example.createCriteria().andReqNumEqualTo(reqNum).andRecordStatusEqualTo(recordStatus);
        List<TbServiceRequire> tbServiceRequireList = tbServiceRequireMapper.selectByExample(example);
        if(tbServiceRequireList.isEmpty()){
            logger.warn("需求单号为：{}的需求在系统中不存在或已失效",reqNum);
            throw new JnSpringCloudException(RequireExceptionEnum.REQUIRE_INFO_NOT_EXIST);
        }
        TbServiceRequire tbServiceRequire = tbServiceRequireList.get(0);
        RequireOtherDetails requireOtherDetails=new RequireOtherDetails();
        BeanUtils.copyProperties(tbServiceRequire, requireOtherDetails);
        //根据企业账号获取企业名称
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(tbServiceRequire.getIssueAccount());
        if(userExtension==null || userExtension.getData()==null){
            logger.warn("需求详情（对他人需求）根据账号获取用户信息失败");
            throw new JnSpringCloudException(RequireExceptionEnum.NETWORK_ANOMALY);
        }
        //设置企业名称
        requireOtherDetails.setCompanyName(userExtension.getData().getCompanyName());

        return requireOtherDetails;
    }

    /**
     * 我收到的需求列表查询
     * @param requireReceivedParam  我收到的需求查询条件
     * @param account               用户账号
     * @return
     */
    @ServiceLog(doAction = "我收到的需求列表查询")
    @Override
    public PaginationData getRequireReceivedList(RequireReceivedParam requireReceivedParam, String account) {
        com.github.pagehelper.Page<Object> objects = null;
        //判断当前账号是否为机构管理员或机构联系人
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(account);
        if(userExtension==null || userExtension.getData()==null){
            logger.warn("我收到的需求列表查询根据账号获取用户信息失败");
            throw new JnSpringCloudException(RequireExceptionEnum.NETWORK_ANOMALY);
        }
        String orgId="";
        if(StringUtils.isNotBlank(userExtension.getData().getAffiliateCode())){
            orgId=userExtension.getData().getAffiliateCode();
        }
        if(requireReceivedParam==null || StringUtils.isBlank(requireReceivedParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<RequireInfoList> requireOtherList = requireManagementMapper.getRequireReceivedList(requireReceivedParam, account,orgId);
            return new PaginationData(requireOtherList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(requireReceivedParam.getNeedPage())){
            objects = PageHelper.startPage(requireReceivedParam.getPage(),
                    requireReceivedParam.getRows() == 0 ? 15 : requireReceivedParam.getRows(), true);
        }
        List<RequireInfoList> requireOtherList = requireManagementMapper.getRequireReceivedList(requireReceivedParam, account,orgId);
        return new PaginationData(requireOtherList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 对接需求操作
     * @param reqNum        需求单号
     * @param account       用户账号
     * @param advisorName   用户姓名
     * @return
     */
    @ServiceLog(doAction = "对接需求操作")
    @Override
    public int handleOperating(String reqNum, String account,String advisorName) {
        //根据需求单号，修改当前数据的需求状态字段，修改对接结果字段，对接日期字段，意向顾问字段
        TbServiceRequireCriteria example=new TbServiceRequireCriteria();
        //数据状态  0：删除  1：有效
        byte recordStatus=1;
        example.createCriteria().andReqNumEqualTo(reqNum).andRecordStatusEqualTo(recordStatus);
        TbServiceRequire tbServiceRequire=new TbServiceRequire();
        //需求状态：-1:已撤销 1：待处理，2：已处理)
        tbServiceRequire.setStatus("2");
        //对接结果 1:对接成功  2:对接失败  3:企业需求撤销 4:未对接
        tbServiceRequire.setHandleResult("1");
        //对接日期
        tbServiceRequire.setHandleTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //顾问账号
        tbServiceRequire.setAdvisorAccount(account);
        //顾问名称
        tbServiceRequire.setAdvisorName(advisorName);
        return tbServiceRequireMapper.updateByExampleSelective(tbServiceRequire, example);
    }

    /**
     * 需求详情（我收到的需求）
     * @param reqNum 需求单号
     * @return
     */
    @ServiceLog(doAction = "需求详情（我收到的需求）")
    @Override
    public RequireReceivedDetails getReceivedRequireDetails(String reqNum) {
        TbServiceRequireCriteria  example=new TbServiceRequireCriteria();
        //数据状态  0：删除  1：有效
        byte recordStatus=1;
        example.createCriteria().andReqNumEqualTo(reqNum).andRecordStatusEqualTo(recordStatus);
        List<TbServiceRequire> tbServiceRequireList = tbServiceRequireMapper.selectByExample(example);
        if(tbServiceRequireList.isEmpty()){
            logger.warn("需求单号为：{}的需求在系统中不存在或已失效",reqNum);
            throw new JnSpringCloudException(RequireExceptionEnum.REQUIRE_INFO_NOT_EXIST);
        }
        TbServiceRequire tbServiceRequire = tbServiceRequireList.get(0);
        RequireReceivedDetails requireReceivedDetails=new RequireReceivedDetails();
        BeanUtils.copyProperties(tbServiceRequire, requireReceivedDetails);
        //根据企业账号获取企业名称
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(tbServiceRequire.getIssueAccount());
        if(userExtension==null || userExtension.getData()==null){
            logger.warn("需求详情（我收到的需求）根据账号获取用户信息失败");
            throw new JnSpringCloudException(RequireExceptionEnum.NETWORK_ANOMALY);
        }
        //设置企业名称
        requireReceivedDetails.setCompanyName(userExtension.getData().getCompanyName());
        return requireReceivedDetails;
    }

    /**
     * 对接需求（我收到的需求）
     * @param handleRequireParam   对接需求入参
     * @return
     */
    @ServiceLog(doAction = "对接需求（我收到的需求）")
    @Override
    public int handleRequire(HandleRequireParam handleRequireParam) {
        TbServiceRequire tbServiceRequire=new TbServiceRequire();
        //是否科技金融类
        String isTechnology="0";
        if(isTechnology.equals(handleRequireParam.getIsTechnology())){
            //非科技金融，合同总金额（万元）
            tbServiceRequire.setContractAmount(handleRequireParam.getContractAmount());
        }else{
            //科技金融，实际贷款金额（万元）
            tbServiceRequire.setActualLoanAmount(handleRequireParam.getActualLoanAmount());
        }
        //对接结果
        tbServiceRequire.setHandleResult(handleRequireParam.getHandleResult());
        //结果描述
        tbServiceRequire.setResultDetail(handleRequireParam.getResultDetail());
        //合同首页
        tbServiceRequire.setContractHomePage(handleRequireParam.getContractHomePage());
        //合同尾页
        tbServiceRequire.setContractEndPage(handleRequireParam.getContractEndPage());
        TbServiceRequireCriteria example=new TbServiceRequireCriteria();
        byte recordStatus=1;
        example.createCriteria().andReqNumEqualTo(handleRequireParam.getReqNum()).andRecordStatusEqualTo(recordStatus);
        return tbServiceRequireMapper.updateByExampleSelective(tbServiceRequire, example);
    }
}
