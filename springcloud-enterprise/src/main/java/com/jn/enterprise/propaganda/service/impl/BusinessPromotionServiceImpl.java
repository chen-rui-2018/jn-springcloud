package com.jn.enterprise.propaganda.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import com.jn.enterprise.common.dao.TbServiceCodeMapper;
import com.jn.enterprise.common.entity.TbServiceCode;
import com.jn.enterprise.common.entity.TbServiceCodeCriteria;
import com.jn.enterprise.enums.BusinessPromotionExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.propaganda.dao.BusinessPromotionMapper;
import com.jn.enterprise.propaganda.dao.TbPropagandaAreaInfoMapper;
import com.jn.enterprise.propaganda.dao.TbPropagandaFeeRulesMapper;
import com.jn.enterprise.propaganda.dao.TbPropagandaMapper;
import com.jn.enterprise.propaganda.entity.*;
import com.jn.enterprise.propaganda.enums.ApprovalStatusEnum;
import com.jn.enterprise.propaganda.enums.PromotionAreaEnum;
import com.jn.enterprise.propaganda.enums.PropagandaTypeEnum;
import com.jn.enterprise.propaganda.model.*;
import com.jn.enterprise.propaganda.service.BusinessPromotionService;
import com.jn.enterprise.servicemarket.org.model.UserRoleInfo;
import com.jn.enterprise.servicemarket.org.service.OrgColleagueService;
import com.jn.paybill.api.PayBillClient;
import com.jn.paybill.model.PaymentBillModel;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import io.swagger.models.auth.In;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.apache.commons.lang.math.RandomUtils;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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

    @Autowired
    private TbPropagandaAreaInfoMapper tbPropagandaAreaInfoMapper;

    @Autowired
    private TbServiceCodeMapper tbServiceCodeMapper;

    @Autowired
    private OrgColleagueService orgColleagueService;

    @Autowired
    private RedisCacheFactory redisCacheFactory;

    @Autowired
    private PayBillClient payBillClient;


    @Value(value = "${propaganda.type.expire}")
    private int expire;
    /**
     * 数据状态  1：有效  0：无效
     */
    private static final String STATUS="1";
    /**
     * 数据状态  1：有效  0：无效
     */
    private static final String INVALID="0";
    /**
     * 日期格式
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     * 宣传类型组名
     */
    private static final String PROPAGANDA_TYPE="propaganda_type";

    /**
     * 宣传区域组名
     */
    private static final String PROPAGANDA_AREA="propagandaArea";

    /**
     * 企业宣传列表查询
     * @param businessPromotionListParam
     * @param loginAccount 登录用户账号
     * @return
     */
    @ServiceLog(doAction = "企业宣传列表查询")
    @Override
    public PaginationData getBusinessPromotionList(BusinessPromotionListParam businessPromotionListParam,String loginAccount) {
        //判断当前用户是否为超级管理员，超级管理员可查看全部，非超级管理员只能查看自己发布的宣传信息
        String creator=loginAccount;
        if(isSuperAdmin(loginAccount)){
            //超级管理员，查询全部
            creator="";
        }
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(businessPromotionListParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<BusinessPromotionListShow> resultList = businessPromotionMapper.getBusinessPromotionList(businessPromotionListParam,creator);
            return  new PaginationData(resultList, objects == null ? 0 : objects.getTotal());

        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(businessPromotionListParam.getNeedPage())){
            objects = PageHelper.startPage(businessPromotionListParam.getPage(),
                    businessPromotionListParam.getRows() == 0 ? 15 : businessPromotionListParam.getRows(), true);
        }
        List<BusinessPromotionListShow> resultList = businessPromotionMapper.getBusinessPromotionList(businessPromotionListParam,creator);
        return  new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 判断当前用户是否为超级管理员
     * @param loginAccount
     * @return
     */
    private boolean isSuperAdmin(String loginAccount) {
        List<String> accountList=new ArrayList<>(16);
        accountList.add(loginAccount);
        String roleName="超级管理";
        List<UserRoleInfo> roleInfoList = orgColleagueService.getUserRoleInfoList(accountList, roleName);
        if(roleInfoList.isEmpty()|| StringUtils.isBlank(roleInfoList.get(0).getRoleName())){
            //没有查询到数据 返回false
            return false;
        }
        //返回的数据没有角色或者角色不包含超级管理，返回false，否则返回true
        return roleInfoList.get(0).getRoleName().contains(roleName);

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
        checkBusinessPromotionData(businessPromotionDetailsParam,loginAccount);
        //2.往数据库插入数据
        return savePropagandaInfo(businessPromotionDetailsParam, loginAccount);
    }

    /**
     * 保存宣传信息
     * @param bpd
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "保存宣传信息")
    private int savePropagandaInfo(BusinessPromotionDetailsParam bpd, String loginAccount) {
        TbPropaganda tbPropaganda=new TbPropaganda();
        BeanUtils.copyProperties(bpd, tbPropaganda);
        //主键id
        tbPropaganda.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //宣传编码
        tbPropaganda.setPropagandaCode(getPropagandaCode());
        //生效日期
        Date now=DateUtils.parseDate(bpd.getEffectiveDate());
        tbPropaganda.setEffectiveDate(now);
        //失效日期
        tbPropaganda.setInvalidDate(getCurrentTimeSpecifiedDate(now, Integer.parseInt(bpd.getPropagandaTime())));
        //宣传费用
        tbPropaganda.setPropagandaFee(Double.valueOf(bpd.getPropagandaFee()));
        //服务机构
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(loginAccount);
        tbPropaganda.setOrgId(userExtension.getData().getAffiliateCode());
        tbPropaganda.setOrgName(userExtension.getData().getAffiliateName());
        //审批状态 (-1：未付款  0：未审批  1：审批中   2：审批通过/已发布   3：审批不通过)
        tbPropaganda.setApprovalStatus("0");
        //是否付款 0:未付款   1：已付款
        tbPropaganda.setIsPay("0");
        //状态 1:有效/上架   0：失效/下架
        tbPropaganda.setStatus(INVALID);
        //创建时间
        tbPropaganda.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //创建人
        tbPropaganda.setCreatorAccount(loginAccount);
        //是否删除
        tbPropaganda.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        return tbPropagandaMapper.insert(tbPropaganda);
    }

    /**
     * 获取当前时间指定月份后的日期
     * @param now  当前时间
     * @param month 指定月份  month=6，表示当前日期6个月后的日期
     * @return
     */
    private Date getCurrentTimeSpecifiedDate(Date now,int month) {
        Calendar lastedDate=Calendar.getInstance();
        lastedDate.setTime(now);
        lastedDate.add(Calendar.MONTH, month);
        return lastedDate.getTime();
    }

    /**
     * 生成宣传编码
     * @return
     */
    @ServiceLog(doAction = "生成宣传编码")
    private String getPropagandaCode() {
        return "GDNJ-"+ DateUtils.getDate("yyyyMMddHHmmss");
    }

    /**
     * 校验发布宣传的参数
     * @param bpd
     */
    @ServiceLog(doAction = "校验发布宣传的参数")
    private void checkBusinessPromotionData(BusinessPromotionDetailsParam bpd,String loginAccount) {
        //校验宣传类型
        checkPropagandaType(bpd, loginAccount);
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
        //基本宣传费用校验标志
        boolean feeValue=true;
        //基本金额
        String propagandaFee="";
        String totalAmount="";
        //获取区域信息，得到区域金额
        List<PropagandaAreaShow> propagandaAreaList = getPropagandaAreaList();
        BigDecimal areaAmount=BigDecimal.valueOf(0.0);
        for(PropagandaAreaShow propagandaAreaShow:propagandaAreaList){
            if(StringUtils.equals(bpd.getPropagandaArea(),propagandaAreaShow.getPropagandaArea())){
                areaAmount=new BigDecimal(propagandaAreaShow.getAreaAmount());
                break;
            }
        }
        for (PropagandaFeeRulesShow pro:propagandaFeeRulesList) {
            if(StringUtils.equals(pro.getProFeeRuleCode(), bpd.getProFeeRuleCode())){
                feeCode=false;
                propagandaFee = pro.getPropagandaFee();
                //总金额 把基本金额转换为bigDecimal进行运算
                BigDecimal totalFee = new BigDecimal(propagandaFee);
                //宣传时间
                BigDecimal selectTime=new BigDecimal(bpd.getPropagandaTime());
                //总金额=基本金额*宣传时间+宣传区域金额
                totalFee=totalFee.multiply(selectTime).add(areaAmount);
                totalAmount=totalFee.toString();
                if(Double.valueOf(bpd.getPropagandaFee())==Double.parseDouble(totalFee.toString())){
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
            logger.warn("校验发布宣传的参数,传递的宣传费用[{}]与系统计算前费用规则[{}]对应的费用{{}}不匹配",bpd.getPropagandaFee(),bpd.getProFeeRuleCode(),totalAmount);
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROMOTION_FEE_NOT_RIGHT);
        }
    }

    /**
     * 校验宣传类型
     * @param bpd
     * @param loginAccount
     */
    @ServiceLog(doAction = "校验宣传类型")
    private void checkPropagandaType(BusinessPromotionDetailsParam bpd, String loginAccount) {
        List<PropagandaTypeShow> propagandaTypeList = getPropagandaTypeList(loginAccount);
        //宣传类型在系统中是否存在标志，默认不存在
        boolean isNotExist=true;
        for(PropagandaTypeShow propagandaTypeShow:propagandaTypeList){
            if(propagandaTypeShow.getPropagandaTypeCode().equals(bpd.getPropagandaType())){
                isNotExist=false;
                break;
            }
        }
        if(isNotExist){
            logger.warn("校验发布宣传的参数,当前宣传类型[{}]在系统中不存在",bpd.getPropagandaType());
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.CURRENT_PROPAGANDA_TYPE_NOT_EXIST);
        }
        //宣传类型是否为APP启动宣传，系统中最多允许存在一个有效的APP启动宣传
        String proType="app_start_promotion";
        if(proType.equals(bpd.getPropagandaType())){
            //查询宣传表中是否存在有效的APP启动宣传
            TbPropagandaCriteria example=new TbPropagandaCriteria();
            example.createCriteria().andPropagandaTypeEqualTo(proType).andStatusEqualTo(STATUS)
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            long responseNum = tbPropagandaMapper.countByExample(example);
            if(responseNum>0){
                logger.warn("校验发布宣传的参数,当前宣传类型[{}]已经存在，系统中最多允许一个有效的当前宣传类型",bpd.getPropagandaType());
                throw new JnSpringCloudException(BusinessPromotionExceptionEnum.CURRENT_PROPAGANDA_TYPE_IS_EXIST);
            }
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
            logger.warn("获取宣传费用规则失败，系统中不存在宣传费用规则");
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

    /**
     * 获取宣传类型
     * @param loginAccount 登录用户账号
     * @return
     */
    @ServiceLog(doAction = "获取宣传类型 ")
    @Override
    public List<PropagandaTypeShow> getPropagandaTypeList(String loginAccount) {
        //从redis中取出宣传类型信息
        Cache<Object> cache = redisCacheFactory.getCache(PROPAGANDA_TYPE, expire);
        List<PropagandaTypeShow> result=(List<PropagandaTypeShow> )cache.get(loginAccount);
        if(result==null){
            result=new ArrayList<>(16);
        }else{
            return  result;
        }
        //redis中没有数据，从数据库获取
        List<TbServiceCode> tbServiceCodeList = getTbServiceCodeList();
        //判断当前用户是否为超级管理员
        if(isSuperAdmin(loginAccount)){
            //查询全部用户类型返回
            result=setPropagandaTypeShowInfo(tbServiceCodeList);
            //把查询出的值放到redis中
            cache.put(loginAccount, result);
            return result;
        }else{
            //获取当前用户与宣传相关的角色
            List<String>accountList=new ArrayList<>();
            accountList.add(loginAccount);
            List<UserRoleInfo> roleInfoList = orgColleagueService.getUserRoleInfoList(accountList, "宣传");
            if(roleInfoList.isEmpty()|| StringUtils.isBlank(roleInfoList.get(0).getRoleName())){
                logger.warn("获取宣传类型失败，当前用户[account:{}]没有企业宣传相关权限",loginAccount);
                throw new JnSpringCloudException(BusinessPromotionExceptionEnum.ACCOUNT_CAN_NOT_ALLOW_PROPAGANDA);
            }
            UserRoleInfo userRoleInfo = roleInfoList.get(0);
            //用户是企业相关角色，返回企业相关宣传类型和APP启动宣传类型
            String business="企业";
            if(!userRoleInfo.getRoleName().contains(business)){
                business=userRoleInfo.getRoleName();
            }
            setPropagandaShowInfo(tbServiceCodeList, business, result);
            //把查询出的值放到redis中
            cache.put(loginAccount, result);
            return result;
        }
    }

    /**
     * 撤销申请
     * @param propagandaId    宣传id
     * @param loginAccount   登录用户账号
     * @return
     */
    @ServiceLog(doAction = "撤销申请")
    @Override
    public int cancelApprove(String propagandaId, String loginAccount) {
        //根据宣传id，审批状态为未付款（value="-1"）和未审批（value="0"）查询系统中是否有当前数据
        List<String>statusList=Arrays.asList("-1","0");
        TbPropagandaCriteria example=new TbPropagandaCriteria();
        example.createCriteria().andIdEqualTo(propagandaId).andApprovalStatusIn(statusList)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        long responseNum = tbPropagandaMapper.countByExample(example);
        if(responseNum==0){
            logger.warn("撤销申请失败,系统中不存在id[{}],状态为有效，审批状态为未付款、未审批的数据",propagandaId);
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROPAGANDA_INFO_NOT_EXIST);
        }
        TbPropaganda tbPropaganda=new TbPropaganda();
        //删除当前数据
        tbPropaganda.setRecordStatus(Byte.parseByte(INVALID));
        //修改时间
        tbPropaganda.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //修改人
        tbPropaganda.setModifierAccount(loginAccount);
        return tbPropagandaMapper.updateByExampleSelective(tbPropaganda, example);
    }

    /**
     * 修改企业宣传
     * @param businessPromotionDetailsParam
     * @param loginAccount 登录用户账号
     * @return
     */
    @ServiceLog(doAction = "修改企业宣传")
    @Override
    public int updateBusinessPromotion(BusinessPromotionDetailsParam businessPromotionDetailsParam, String loginAccount) {
        //1.判断当前宣传信息是否允许修改
        propagandaIsAllowUpdate(businessPromotionDetailsParam.getId());
        //2.校验参数
        checkBusinessPromotionData(businessPromotionDetailsParam,loginAccount);
        //3.修改数据库数据
        return updatePropagandaInfo(businessPromotionDetailsParam, loginAccount);
    }

    /**
     * 判断当前宣传信息是否允许修改
     * @param propagandaId 宣传id
     */
    @ServiceLog(doAction = "判断当前宣传信息是否允许修改")
    private void propagandaIsAllowUpdate(String propagandaId) {
        TbPropagandaCriteria example=new TbPropagandaCriteria();
        //审批状态(-1：未付款  0：未审批  1：审批中   2：审批通过/已发布   3：审批不通过)
        List<String> approvalStatus=new ArrayList<>();
        approvalStatus.add("-1");
        approvalStatus.add("0");
        approvalStatus.add("3");
        example.createCriteria().andIdEqualTo(propagandaId).andApprovalStatusIn(approvalStatus)
        .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        long existNum = tbPropagandaMapper.countByExample(example);
        if(existNum==0){
            logger.warn("修改企业宣传失败，当前宣传信息审批状态不允许修改");
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.UPDATE_NOT_ALLOWED);
        }
    }

    /***
     * 修改宣传信息
     * @param bpd
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "修改宣传信息")
    private int updatePropagandaInfo(BusinessPromotionDetailsParam bpd, String loginAccount) {
        TbPropagandaCriteria example=new TbPropagandaCriteria();
        example.createCriteria().andIdEqualTo(bpd.getId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        TbPropaganda tbPropaganda=new TbPropaganda();
        BeanUtils.copyProperties(bpd,tbPropaganda);
        //生效日期
        Date now=DateUtils.parseDate(bpd.getEffectiveDate());
        tbPropaganda.setEffectiveDate(now);
        //失效日期
        tbPropaganda.setInvalidDate(getCurrentTimeSpecifiedDate(now, Integer.parseInt(bpd.getPropagandaTime())));
        //费用
        tbPropaganda.setPropagandaFee(Double.valueOf(bpd.getPropagandaFee()));
        //审批状态 (-1：未付款  0：未审批  1：审批中   2：审批通过/已发布   3：审批不通过)
        tbPropaganda.setStatus("0");
        //修改时间
        tbPropaganda.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //修改人
        tbPropaganda.setModifierAccount(loginAccount);
        return tbPropagandaMapper.updateByExampleSelective(tbPropaganda,example);
    }

    /**
     * 封装处理宣传类型
     * @param tbServiceCodeList
     * @param business
     * @param result
     * @return
     */
    @ServiceLog(doAction = "封装处理宣传类型")
    private List<PropagandaTypeShow> setPropagandaShowInfo(List<TbServiceCode> tbServiceCodeList, String business, List<PropagandaTypeShow> result) {
        for(TbServiceCode tbServiceCode:tbServiceCodeList){
            if(tbServiceCode.getCodeName().contains(business)
                    || StringUtils.equals(tbServiceCode.getCodeName(), "APP启动宣传")){
                PropagandaTypeShow propagandaTypeShow=new PropagandaTypeShow();
                propagandaTypeShow.setPropagandaTypeName(tbServiceCode.getCodeName());
                propagandaTypeShow.setPropagandaTypeCode(tbServiceCode.getCodeValue());
                result.add(propagandaTypeShow);
            }
        }
        return result;
    }

    /**
     * 获取字典表中宣传类型信息
     * @return
     */
    @ServiceLog(doAction = "获取字典表中宣传类型信息")
    private List<TbServiceCode> getTbServiceCodeList() {
        TbServiceCodeCriteria example=new TbServiceCodeCriteria();
        //查询宣传类型全部数据
        example.createCriteria().andGroupIdEqualTo(PropagandaTypeEnum.PROPAGANDA_TYPE.getCode())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceCode> tbServiceCodeList = tbServiceCodeMapper.selectByExample(example);
        if(tbServiceCodeList.isEmpty()){
            logger.warn("获取宣传类型失败，系统中不传在宣传类型");
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROPAGANDA_TYPE_NOT_EXIST);
        }
        return tbServiceCodeList;
    }

    /**
     * 封装处理宣传类型
     * @param tbServiceCodeList 字典表查询的宣传类型列表
     * @return
     */
    @ServiceLog(doAction = "封装处理宣传类型")
    private List<PropagandaTypeShow> setPropagandaTypeShowInfo(List<TbServiceCode> tbServiceCodeList) {
        List<PropagandaTypeShow>resultList=new ArrayList<>(16);
        for(TbServiceCode tbServiceCode:tbServiceCodeList){
            PropagandaTypeShow propagandaTypeShow=new PropagandaTypeShow();
            propagandaTypeShow.setPropagandaTypeCode(tbServiceCode.getCodeValue());
            propagandaTypeShow.setPropagandaTypeName(tbServiceCode.getCodeName());
            resultList.add(propagandaTypeShow);
        }
        return resultList;
    }

    /**
     * 生成订单号
     * @return
     */
    @ServiceLog(doAction = "生成订单号")
    @Override
    public String getOrderNumber() {
        //AD-(广告)+日期（年月日时分秒）+3位随机数
        return "AD-"+ DateUtils.getDate("yyyyMMddHHmmss")+ RandomUtils.nextInt(999);
    }

    /**
     * 修改审批状态
     * @param propagandaId  宣传id
     * @param approvalStatus        审批状态 (-1：未付款  0：未审批  1：审批中   2：审批通过/已发布   3：审批不通过)
     * @param loginAccount 登录用户账号
     * @return
     */
    @ServiceLog(doAction = "修改审批状态")
    @Override
    public int updateApprovalStatus(String propagandaId, String approvalStatus,String loginAccount) {
        //根据宣传id,是否删除判断宣传信息是否存在
        TbPropagandaCriteria example=new TbPropagandaCriteria();
        example.createCriteria().andIdEqualTo(propagandaId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        long existNum = tbPropagandaMapper.countByExample(example);
        if(existNum==0){
            logger.warn("修改审批状态失败，当前宣传信息[id:{}]在系统中不存在或已删除",propagandaId);
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROPAGANDA_INFO_NOT_EXIST);
        }
        //判断状态值是否为系统支持的
        List<String>statusList= Arrays.asList(ApprovalStatusEnum.UNPAID.getValue(),ApprovalStatusEnum.NOT_APPROVED.getValue()
                ,ApprovalStatusEnum.APPROVAL.getValue(),ApprovalStatusEnum.APPROVED.getValue(),ApprovalStatusEnum.APPROVAL_NOT_PASSED.getValue());
        if(!statusList.contains(approvalStatus)){
            logger.warn("修改审批状态失败，status:[{}]不是系统支持的",approvalStatus);
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.STATUS_NOT_SUPPORT);
        }
        TbPropaganda tbPropaganda=new TbPropaganda();
        tbPropaganda.setApprovalStatus(approvalStatus);
        tbPropaganda.setModifierAccount(loginAccount);
        tbPropaganda.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        return tbPropagandaMapper.updateByExampleSelective(tbPropaganda, example);
    }

    /**
     * 创建账单
     * @param orderNum      订单号
     * @param loginAccount  登录用户账号
     * @return
     */
    @ServiceLog(doAction = "创建账单")
    @Override
    public String createBill(String orderNum,String loginAccount){
        //需要修改，支付接口后期会改掉，当前支付会废弃掉
        PaymentBillModel paymentBillModel=new PaymentBillModel();
        paymentBillModel.setBillNum(orderNum);
        paymentBillModel.setBillName(loginAccount+"的宣传费用");
        paymentBillModel.setBillType("ad_free");
        paymentBillModel.setBillObjId(loginAccount);
        paymentBillModel.setBillObjName(loginAccount);
        paymentBillModel.setBillAmount(50.00);
        paymentBillModel.setBillCreateTime(DateUtils.getDate(PATTERN));
        paymentBillModel.setPayEndTime(DateUtils.getDate(PATTERN));
        paymentBillModel.setBillCreateAccount(loginAccount);
        paymentBillModel.setBillRemark("ad_free");
        Result<String> bill = payBillClient.createBill(paymentBillModel);
        if(bill==null || bill.getData()==null){
            logger.warn("创建账单失败，调用账单生成接口返回null");
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.NETWORK_ANOMALY);
        }
        return bill.getData();
    }

    /**
     * 提交审核
     * @param propagandaId 宣传id
     * @param loginAccount 登录用户账号
     */
    @ServiceLog(doAction = "提交审核")
    @Override
    public void submitAudit(String propagandaId, String loginAccount) {
        //根据宣传id,状态（value="0"），审批状态（value="0"）,是否删除（value="1"）查询宣传信息
        TbPropagandaCriteria example=new TbPropagandaCriteria();
        example.createCriteria().andIdEqualTo(propagandaId).andStatusEqualTo(INVALID)
                .andApprovalStatusEqualTo(ApprovalStatusEnum.NOT_APPROVED.getValue())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbPropaganda> tbPropagandaList = tbPropagandaMapper.selectByExample(example);
        if(tbPropagandaList.isEmpty()){
            logger.warn("提交审核失败，宣传信息[propagandaId:{}]在系统中不存在或不允许当前操作",propagandaId);
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.SUBMIT_AUDIT_NOT_ALLOW);
        }
        TbPropaganda tbPropaganda = tbPropagandaList.get(0);
        BusinessPromotionWorkFlow bpw=new BusinessPromotionWorkFlow();
        BeanUtils.copyProperties(tbPropaganda, bpw);
        List<BusinessPromotionWorkFlow> dataList=new ArrayList();
        dataList.add(bpw);
        //把bean转化为json
        String dataToJson = JSONArray.toJSONString(dataList);
        //流程id
        String workFlowId="Process_business_promotion";
        //todo:启动工作流

    }

    /**
     * 获取宣传区域信息
     * @return
     */
    @ServiceLog(doAction = "获取宣传区域信息")
    @Override
    public List<PropagandaAreaShow> getPropagandaAreaList() {
        TbPropagandaAreaInfoCriteria example=new TbPropagandaAreaInfoCriteria();
        example.createCriteria().andGroupIdEqualTo(PROPAGANDA_AREA).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbPropagandaAreaInfo> tbPropagandaAreaInfoList = tbPropagandaAreaInfoMapper.selectByExample(example);
        if(tbPropagandaAreaInfoList.isEmpty()){
            logger.warn("获取宣传区域信息失败，系统中不存在宣传区域信息");
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROPAGANDA_AREA_NOT_EXIST);
        }
        List<PropagandaAreaShow>resultList=new ArrayList<>(16);
        for(TbPropagandaAreaInfo tbServiceCode:tbPropagandaAreaInfoList){
            PropagandaAreaShow propagandaAreaShow=new PropagandaAreaShow();
            propagandaAreaShow.setPropagandaArea(tbServiceCode.getAreaName());
            propagandaAreaShow.setPropagandaAreaUrl(tbServiceCode.getAreaCode());
            propagandaAreaShow.setAreaAmount(tbServiceCode.getAreaAmount().toString());
            resultList.add(propagandaAreaShow);
        }
        //返回只读数据
        return  new UnmodifiableList<>(resultList);
    }

    /**
     * 门户各首页企业宣传列表查询
     * @param businessHomePageParam
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "门户各首页企业宣传列表查询")
    @Override
    public PaginationData getBusinessPromotionList(BusinessHomePageParam businessHomePageParam, String loginAccount) {
        BusinessPromotionListParam bpb=new BusinessPromotionListParam();
        BeanUtils.copyProperties(businessHomePageParam, bpb);
        //审批状态（0：未审批  1：审批中   2：审批通过   3：审批不通过，4：未付款  5：待发布  6：已发布)）
        //门户首页查询都是已发布的宣传信息
        String hasBeenPublish="6";
        bpb.setApprovalStatus(hasBeenPublish);
        return getBusinessPromotionList(bpb,loginAccount);
    }
}
