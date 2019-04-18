package com.jn.enterprise.propaganda.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.BusinessPromotionExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.propaganda.dao.BusinessPromotionMapper;
import com.jn.enterprise.propaganda.dao.TbPropagandaFeeRulesMapper;
import com.jn.enterprise.propaganda.dao.TbPropagandaMapper;
import com.jn.enterprise.propaganda.entity.TbPropaganda;
import com.jn.enterprise.propaganda.entity.TbPropagandaFeeRules;
import com.jn.enterprise.propaganda.entity.TbPropagandaFeeRulesCriteria;
import com.jn.enterprise.propaganda.enums.PromotionAreaEnum;
import com.jn.enterprise.propaganda.model.*;
import com.jn.enterprise.propaganda.service.BusinessPromotionService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 用户中心--企业宣传
 * @Author: yangph
 * @Date: 2019/4/18 9:44
 * @Version v1.0
 * @modified By:
 */
@Service
public class BusinessPromotionServiceImpl implements BusinessPromotionService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(BusinessPromotionServiceImpl.class);

    @Autowired
    private TbPropagandaMapper tbPropagandaMapper;

    @Autowired
    private TbPropagandaFeeRulesMapper tbPropagandaFeeRulesMapper;

    @Autowired
    private BusinessPromotionMapper businessPromotionMapper;

    @Autowired
    private UserExtensionClient userExtensionClient;

    /**
     * 数据状态  1：有效  0：无效
     */
    private static final String STATUS="1";
    /**
     * 日期格式
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     * 企业宣传列表查询
     * @param businessPromotionListParam
     * @return
     */
    @ServiceLog(doAction = "企业宣传列表查询")
    @Override
    public PaginationData getBusinessPromotionList(BusinessPromotionListParam businessPromotionListParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(businessPromotionListParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<BusinessPromotionListShow> resultList = businessPromotionMapper.getBusinessPromotionList(businessPromotionListParam);
            return  new PaginationData(resultList, objects == null ? 0 : objects.getTotal());

        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(businessPromotionListParam.getNeedPage())){
            objects = PageHelper.startPage(businessPromotionListParam.getPage(),
                    businessPromotionListParam.getRows() == 0 ? 15 : businessPromotionListParam.getRows(), true);
        }
        List<BusinessPromotionListShow> resultList = businessPromotionMapper.getBusinessPromotionList(businessPromotionListParam);
        return  new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 企业宣传详情
     * @param propagandaId 宣传id
     * @return
     */
    @ServiceLog(doAction = "企业宣传详情")
    @Override
    public BusinessPromotionDetailsShow getBusinessPromotionDetails(String propagandaId) {
        return businessPromotionMapper.getBusinessPromotionDetails(propagandaId);
    }

    /**
     * 发布宣传
     * @param businessPromotionDetailsParam
     * @param loginAccount 登录用户账号
     * @return
     */
    @ServiceLog(doAction = "发布宣传")
    @Override
    public int saveBusinessPromotion(BusinessPromotionDetailsParam businessPromotionDetailsParam, String loginAccount) {
        //1.校验参数
        checkBusinessPromotionData(businessPromotionDetailsParam);
        //2.往数据库插入数据
        return savePropagandaInfo(businessPromotionDetailsParam, loginAccount);
    }

    /**
     * 保存宣传信息
     * @param businessPromotionDetailsParam
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "保存宣传信息")
    private int savePropagandaInfo(BusinessPromotionDetailsParam businessPromotionDetailsParam, String loginAccount) {
        TbPropaganda tbPropaganda=new TbPropaganda();
        BeanUtils.copyProperties(businessPromotionDetailsParam, tbPropaganda);
        //主键id
        tbPropaganda.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //宣传编码
        tbPropaganda.setPropagandaCode(getPropagandaCode());
        //生效日期
        tbPropaganda.setEffectiveDate(DateUtils.parseDate(businessPromotionDetailsParam.getEffectiveDate()));
        //失效日期
        tbPropaganda.setInvalidDate(DateUtils.parseDate(businessPromotionDetailsParam.getEffectiveDate()));
        //状态
        tbPropaganda.setStatus(STATUS);
        //服务机构
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(loginAccount);
        tbPropaganda.setOrgId(userExtension.getData().getAffiliateCode());
        tbPropaganda.setOrgName(userExtension.getData().getAffiliateName());
        //审批状态 (-1：未付款  0：未审批  1：审批中   2：审批通过/已发布   3：审批不通过)
        tbPropaganda.setApprovalStatus("-1");
        //创建时间
        tbPropaganda.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //创建人
        tbPropaganda.setCreatorAccount(loginAccount);
        //是否删除
        tbPropaganda.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        return tbPropagandaMapper.insert(tbPropaganda);
    }

    /**
     * 获取宣传编码
     * @return
     */
    private String getPropagandaCode() {
        return "GDNJ-"+ DateUtils.getDate("yyyyMMddHHmmss");
    }

    /**
     * 校验发布宣传的参数
     * @param bpd
     */
    @ServiceLog(doAction = "校验发布宣传的参数")
    private void checkBusinessPromotionData(BusinessPromotionDetailsParam bpd) {
        //TODO：校验宣传类型,需要加入角色判断 yangph
        //校验生效日期和失效日期
        if(StringUtils.isNotBlank(bpd.getEffectiveDate()) && StringUtils.isNotBlank(bpd.getInvalidDate())){
            int effectiveDate=Integer.parseInt(bpd.getEffectiveDate().replaceAll("-", ""));
            int invalidDate=Integer.parseInt(bpd.getInvalidDate().replaceAll("-", ""));
            if(effectiveDate>invalidDate){
                logger.warn("校验发布宣传的参数,生效时间[{}]晚于失效时间[{}]",bpd.getEffectiveDate(),bpd.getInvalidDate());
                throw new JnSpringCloudException(BusinessPromotionExceptionEnum.EFFECTIVE_MORE_THAN_INVALID);
            }
        }
        //校验宣传区域
        List<String> areaList=new ArrayList<>(16);
        areaList.add(PromotionAreaEnum.AREA_TOP.getCode());
        areaList.add(PromotionAreaEnum.AREA_CENTRAL.getCode());
        areaList.add(PromotionAreaEnum.AREA_BOTTOM.getCode());
        if(!areaList.contains(bpd.getPropagandaArea())){
            logger.warn("校验发布宣传的参数,宣传区域的值[{}]与系统中的值不匹配",bpd.getPropagandaArea());
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROMOTION_AREA_ERROR) ;
        }
        //校验宣传费用规则编码和宣传费用
        List<PropagandaFeeRulesShow> propagandaFeeRulesList = getPropagandaFeeRulesList();
        //宣传规则编码校验标志
        boolean feeCode=true;
        //宣传费用校验标志
        boolean feeValue=true;
        String propagandaFee="";
        for (PropagandaFeeRulesShow pro:propagandaFeeRulesList) {
            if(StringUtils.equals(pro.getProFeeRuleCode(), bpd.getProFeeRuleCode())){
                feeCode=false;
                propagandaFee = pro.getPropagandaFee();
                if(StringUtils.equals(pro.getPropagandaFee(), bpd.getPropagandaFee())){
                    feeValue=false;
                }
                break;
            }
        }
        if(feeCode){
            logger.warn("校验发布宣传的参数,宣传费用规则编码[{}]与系统中不存在",bpd.getProFeeRuleCode());
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROMOTION_FEE_RULES_ERROR);
        }
        if(feeValue){
            logger.warn("校验发布宣传的参数,传递的宣传费用[{}]与系统中当前费用规则[{}]对应的费用{{}}不匹配",bpd.getPropagandaFee(),bpd.getProFeeRuleCode(),propagandaFee);
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROMOTION_FEE_RULES_ERROR);
        }
    }

    /**
     * 获取宣传费用规则
     * @return
     */
    @ServiceLog(doAction = "获取宣传费用规则")
    @Override
    public List<PropagandaFeeRulesShow> getPropagandaFeeRulesList(){
        TbPropagandaFeeRulesCriteria example=new TbPropagandaFeeRulesCriteria();
        example.createCriteria().andProFeeRuleCodeIsNotNull().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbPropagandaFeeRules> tbPropagandaFeeRulesList = tbPropagandaFeeRulesMapper.selectByExample(example);
        if(tbPropagandaFeeRulesList.isEmpty()){
            logger.warn("获取宣传费用规则失败，系统中不传在宣传费用规则");
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROMOTION_FEE_RULES_NOT_EXIST);
        }
        List<PropagandaFeeRulesShow> resultList=new ArrayList<>(16);
        for(TbPropagandaFeeRules tbPropagandaFeeRules:tbPropagandaFeeRulesList){
            PropagandaFeeRulesShow propagandaFeeRulesShow=new PropagandaFeeRulesShow();
            propagandaFeeRulesShow.setProFeeRuleCode(tbPropagandaFeeRules.getProFeeRuleCode());
            propagandaFeeRulesShow.setProFeeRuleDetails(tbPropagandaFeeRules.getProFeeRuleDetails());
            propagandaFeeRulesShow.setPropagandaFee(tbPropagandaFeeRules.getPropagandaFee().toString());
            resultList.add(propagandaFeeRulesShow);
        }
        return resultList;
    }
}
