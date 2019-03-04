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
import com.jn.enterprise.servicemarket.product.dao.TbServiceProductMapper;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProduct;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProductCriteria;
import com.jn.enterprise.servicemarket.require.dao.RequireManagementMapper;
import com.jn.enterprise.servicemarket.require.dao.TbServiceRequireMapper;
import com.jn.enterprise.servicemarket.require.entity.TbServiceRequire;
import com.jn.enterprise.servicemarket.require.model.RequireInfoList;
import com.jn.enterprise.servicemarket.require.model.RequireOtherParam;
import com.jn.enterprise.servicemarket.require.model.RequireParam;
import com.jn.enterprise.servicemarket.require.model.RequireTechnologyParam;
import com.jn.enterprise.servicemarket.require.service.RequireManagementService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    private RequireManagementMapper requireManagementMapper;

    @Autowired
    private UserExtensionClient userExtensionClient;



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
        return DateUtils.getDate("yyyyMMdd HH:mm:ss")+RandomUtils.nextInt(10);
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
            logger.warn("用户提需求(科技金融)的产品id：[{}]在系统中不存在",requireTechnologyParam.getProductId());
            throw new JnSpringCloudException(RequireExceptionEnum.PRODUCT_ID_NOT_EXIST);
        }
        //根据机构id查询机构地址信息表（tb_service_org_info），获取机构联系人电话和邮箱
        List<TbServiceOrgInfo> tbServiceOrgInfoList = getTbServiceOrgInfoList(tbServiceProductList.get(0).getOrgId());
        if(tbServiceOrgInfoList.isEmpty()){
            logger.warn("用户提需求(科技金融)的产品id：[{}]所对应的的机构在系统中不存在",requireTechnologyParam.getProductId());
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
     * @return
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
}
