package com.jn.enterprise.propaganda.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import com.jn.company.model.IBPSResult;
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
import com.jn.enterprise.propaganda.enums.IsPayEnum;
import com.jn.enterprise.propaganda.enums.PromotionAreaEnum;
import com.jn.enterprise.propaganda.enums.PropagandaTypeEnum;
import com.jn.enterprise.propaganda.model.*;
import com.jn.enterprise.propaganda.service.BusinessPromotionService;
import com.jn.enterprise.servicemarket.org.model.UserRoleInfo;
import com.jn.enterprise.servicemarket.org.service.OrgColleagueService;
import com.jn.enterprise.utils.IBPSFileUtils;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.park.utils.HtmlUtils;
import com.jn.paybill.api.PayBillClient;
import com.jn.paybill.model.PaymentBillModel;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xxpay.common.util.DateUtil;

import java.math.BigDecimal;
import java.util.*;

/**
 * ????????????--????????????
 * @Author: yangph
 * @Date: 2019/4/18 9:44
 * @Version v1.0
 * @modified By:
 */
@Service
public class BusinessPromotionServiceImpl implements BusinessPromotionService {
    /**
     * ????????????
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
     * ????????????  1?????????  0?????????
     */
    private static final String STATUS="1";
    /**
     * ????????????  1?????????  0?????????
     */
    private static final String INVALID="0";
    /**
     * ????????????
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     * ??????????????????
     */
    private static final String PROPAGANDA_TYPE="propaganda_type";

    /**
     * ??????????????????
     */
    private static final String PROPAGANDA_AREA="propagandaArea";
    /**
     * ???????????????????????????
     */
    private static final String BILL_TYPE="ad_free";

    /**
     * ??????????????????id
     */
    @Value(value = "${businessPromotionProcessId}")
    private String businessPromotionProcessId;

    /**
     * ????????????????????????
     * @param businessPromotionListParam
     * @param loginAccount ??????????????????
     * @return
     */
    @ServiceLog(doAction = "????????????????????????")
    @Override
    public PaginationData getBusinessPromotionList(BusinessPromotionListParam businessPromotionListParam,String loginAccount) {
        //???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        String creator=loginAccount;
        if(StringUtils.isNotBlank(loginAccount)&& isSuperAdmin(loginAccount)){
            //??????????????????????????????
            creator="";
        }
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(businessPromotionListParam.getNeedPage())){
            //???????????????1??????15?????????
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<BusinessPromotionListShow> resultList = businessPromotionMapper.getBusinessPromotionList(businessPromotionListParam,creator);
            return  new PaginationData(resultList, objects == null ? 0 : objects.getTotal());

        }
        //??????????????????
        String isPage="1";
        if(isPage.equals(businessPromotionListParam.getNeedPage())){
            objects = PageHelper.startPage(businessPromotionListParam.getPage(),
                    businessPromotionListParam.getRows() == 0 ? 15 : businessPromotionListParam.getRows(), true);
        }
        List<BusinessPromotionListShow> resultList = businessPromotionMapper.getBusinessPromotionList(businessPromotionListParam,creator);
        for(BusinessPromotionListShow pShow:resultList){
            //??????????????????
            String replaceDetails= HtmlUtils.getBriefIntroduction(pShow.getPropagandaDetails());
            if(StringUtils.isNotBlank(replaceDetails)){
                String propagandaSummaries=replaceDetails.substring(0,replaceDetails.length()>100?100:replaceDetails.length());
                propagandaSummaries=replaceDetails.length()>100?propagandaSummaries+"......":propagandaSummaries;
                pShow.setPropagandaSummaries(propagandaSummaries);
            }

            // ??????????????????
            pShow.setPosterUrl(IBPSFileUtils.getFilePath(pShow.getPosterUrl()));
        }
        return  new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * ??????????????????????????????????????????
     * @param loginAccount
     * @return
     */
    private boolean isSuperAdmin(String loginAccount) {
        List<String> accountList=new ArrayList<>(16);
        accountList.add(loginAccount);
        String roleName="????????????";
        List<UserRoleInfo> roleInfoList = orgColleagueService.getUserRoleInfoList(accountList, roleName);
        if(roleInfoList.isEmpty()|| StringUtils.isBlank(roleInfoList.get(0).getRoleName())){
            //????????????????????? ??????false
            return false;
        }
        //?????????????????????????????????????????????????????????????????????false???????????????true
        return roleInfoList.get(0).getRoleName().contains(roleName);

    }

    /**
     * ??????????????????
     * @param propagandaId ??????id
     * @return
     */
    @ServiceLog(doAction = "??????????????????")
    @Override
    public BusinessPromotionDetailsShow getBusinessPromotionDetails(String propagandaId) {
        businessPromotionMapper.addClickNumById(propagandaId);
        BusinessPromotionDetailsShow businessPromotionDetails = businessPromotionMapper.getBusinessPromotionDetails(propagandaId);

        // ??????????????????
        if (businessPromotionDetails != null) {
            businessPromotionDetails.setPosterUrl(IBPSFileUtils.getFilePath(businessPromotionDetails.getPosterUrl()));
        }
        return businessPromotionDetails;
    }

    /**
     * ????????????
     * @param businessPromotionDetailsParam
     * @param loginAccount ??????????????????
     * @return
     */
    @ServiceLog(doAction = "????????????")
    @Override
    public int saveBusinessPromotion(BusinessPromotionDetailsParam businessPromotionDetailsParam, String loginAccount) {
        //1.????????????
        checkBusinessPromotionData(businessPromotionDetailsParam,loginAccount);
        //2.????????????????????????
        return savePropagandaInfo(businessPromotionDetailsParam, loginAccount);
    }

    /**
     * ??????????????????
     * @param bpd
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "??????????????????")
    private int savePropagandaInfo(BusinessPromotionDetailsParam bpd, String loginAccount) {
        TbPropaganda tbPropaganda=new TbPropaganda();
        BeanUtils.copyProperties(bpd, tbPropaganda);
        //??????id
        tbPropaganda.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //????????????
        tbPropaganda.setPropagandaCode(getPropagandaCode());
        //????????????
        Date now=DateUtils.parseDate(bpd.getEffectiveDate());
        tbPropaganda.setEffectiveDate(now);
        //????????????
        tbPropaganda.setInvalidDate(getCurrentTimeSpecifiedDate(now, Integer.parseInt(bpd.getPropagandaTime())));
        //????????????
        tbPropaganda.setPropagandaFee(Double.valueOf(bpd.getPropagandaFee()));
        //????????????
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(loginAccount);
        tbPropaganda.setOrgId(userExtension.getData().getAffiliateCode());
        tbPropaganda.setOrgName(userExtension.getData().getAffiliateName());
        //???????????? (-1????????????  0????????????  1????????????   2???????????????/?????????   3??????????????????)
        tbPropaganda.setApprovalStatus("0");
        //??????
        tbPropaganda.setSort(1);
        //???????????? 0:?????????   1????????????
        tbPropaganda.setIsPay("0");
        //?????? 1:??????/??????   0?????????/??????
        tbPropaganda.setStatus(INVALID);
        //????????????
        tbPropaganda.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //?????????
        tbPropaganda.setCreatorAccount(loginAccount);
        //????????????
        tbPropaganda.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        return tbPropagandaMapper.insert(tbPropaganda);
    }

    /**
     * ??????????????????????????????????????????
     * @param now  ????????????
     * @param month ????????????  month=6?????????????????????6??????????????????
     * @return
     */
    private Date getCurrentTimeSpecifiedDate(Date now,int month) {
        Calendar lastedDate=Calendar.getInstance();
        lastedDate.setTime(now);
        lastedDate.add(Calendar.MONTH, month);
        return lastedDate.getTime();
    }

    /**
     * ??????????????????
     * @return
     */
    @ServiceLog(doAction = "??????????????????")
    private String getPropagandaCode() {
        return "GDNJ-"+ DateUtils.getDate("yyyyMMddHHmmss");
    }

    /**
     * ???????????????????????????
     * @param bpd
     */
    @ServiceLog(doAction = "???????????????????????????")
    private void checkBusinessPromotionData(BusinessPromotionDetailsParam bpd,String loginAccount) {
        //??????????????????
        checkPropagandaType(bpd, loginAccount);
        //??????????????????
        List<String> areaList=new ArrayList<>(16);
        areaList.add(PromotionAreaEnum.AREA_TOP.getCode());
        areaList.add(PromotionAreaEnum.AREA_CENTRAL.getCode());
        areaList.add(PromotionAreaEnum.AREA_BOTTOM.getCode());
        if(!areaList.contains(bpd.getPropagandaArea())){
            logger.warn("???????????????????????????,??????????????????[{}]???????????????????????????",bpd.getPropagandaArea());
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROMOTION_AREA_ERROR) ;
        }
        //?????????????????????????????????????????????
        List<PropagandaFeeRulesShow> propagandaFeeRulesList = getPropagandaFeeRulesList();
        //??????????????????????????????
        boolean feeCode=true;
        //??????????????????????????????
        boolean feeValue=true;
        //????????????
        String propagandaFee="";
        String totalAmount="";
        //???????????????????????????????????????
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
                //????????? ????????????????????????bigDecimal????????????
                BigDecimal totalFee = new BigDecimal(propagandaFee);
                //????????????
                BigDecimal selectTime=new BigDecimal(bpd.getPropagandaTime());
                //?????????=????????????*????????????+??????????????????
                totalFee=totalFee.multiply(selectTime).add(areaAmount);
                totalAmount=totalFee.toString();
                if(Double.valueOf(bpd.getPropagandaFee())==Double.parseDouble(totalFee.toString())){
                    feeValue=false;
                }
                break;
            }
        }
        if(feeCode){
            logger.warn("???????????????????????????,????????????????????????[{}]?????????????????????",bpd.getProFeeRuleCode());
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROMOTION_FEE_RULES_ERROR);
        }
        if(feeValue){
            logger.warn("???????????????????????????,?????????????????????[{}]??????????????????????????????[{}]???????????????{{}}?????????",bpd.getPropagandaFee(),bpd.getProFeeRuleCode(),totalAmount);
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROMOTION_FEE_NOT_RIGHT);
        }
    }

    /**
     * ??????????????????
     * @param bpd
     * @param loginAccount
     */
    @ServiceLog(doAction = "??????????????????")
    private void checkPropagandaType(BusinessPromotionDetailsParam bpd, String loginAccount) {
        List<PropagandaTypeShow> propagandaTypeList = getPropagandaTypeList(loginAccount);
        //????????????????????????????????????????????????????????????
        boolean isNotExist=true;
        for(PropagandaTypeShow propagandaTypeShow:propagandaTypeList){
            if(propagandaTypeShow.getPropagandaTypeCode().equals(bpd.getPropagandaType())){
                isNotExist=false;
                break;
            }
        }
        if(isNotExist){
            logger.warn("???????????????????????????,??????????????????[{}]?????????????????????",bpd.getPropagandaType());
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.CURRENT_PROPAGANDA_TYPE_NOT_EXIST);
        }
        //?????????????????????APP?????????????????????????????????????????????????????????APP????????????
        String proType="app_start_promotion";
        if(proType.equals(bpd.getPropagandaType())){
            //???????????????????????????????????????APP????????????
            TbPropagandaCriteria example=new TbPropagandaCriteria();
            example.createCriteria().andPropagandaTypeEqualTo(proType).andStatusEqualTo(STATUS)
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
            long responseNum = tbPropagandaMapper.countByExample(example);
            if(responseNum>0){
                logger.warn("???????????????????????????,??????????????????[{}]?????????????????????????????????????????????????????????????????????",bpd.getPropagandaType());
                throw new JnSpringCloudException(BusinessPromotionExceptionEnum.CURRENT_PROPAGANDA_TYPE_IS_EXIST);
            }
        }
    }

    /**
     * ????????????????????????
     * @return
     */
    @ServiceLog(doAction = "????????????????????????")
    @Override
    public List<PropagandaFeeRulesShow> getPropagandaFeeRulesList(){
        TbPropagandaFeeRulesCriteria example=new TbPropagandaFeeRulesCriteria();
        example.createCriteria().andProFeeRuleCodeIsNotNull().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbPropagandaFeeRules> tbPropagandaFeeRulesList = tbPropagandaFeeRulesMapper.selectByExample(example);
        if(tbPropagandaFeeRulesList.isEmpty()){
            logger.warn("?????????????????????????????????????????????????????????????????????");
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
     * ??????????????????
     * @param loginAccount ??????????????????
     * @return
     */
    @ServiceLog(doAction = "?????????????????? ")
    @Override
    public List<PropagandaTypeShow> getPropagandaTypeList(String loginAccount) {
        //???redis???????????????????????????
        Cache<Object> cache = redisCacheFactory.getCache(PROPAGANDA_TYPE, expire);
        List<PropagandaTypeShow> result=(List<PropagandaTypeShow> )cache.get(loginAccount);
        if(result==null){
            result=new ArrayList<>(16);
        }else{
            return  result;
        }
        //redis????????????????????????????????????
        List<TbServiceCode> tbServiceCodeList = getTbServiceCodeList();
        //??????????????????????????????
        result=setPropagandaTypeShowInfo(tbServiceCodeList);
        //????????????????????????redis???
        cache.put(loginAccount, result);
        return result;
    }

    /**
     * ????????????
     * @param propagandaId    ??????id
     * @param loginAccount   ??????????????????
     * @return
     */
    @ServiceLog(doAction = "????????????")
    @Override
    public int cancelApprove(String propagandaId, String loginAccount) {
        //????????????id??????????????????????????????value="-1"??????????????????value="0"???????????????????????????????????????
        List<String>statusList=Arrays.asList("-1","0");
        TbPropagandaCriteria example=new TbPropagandaCriteria();
        example.createCriteria().andIdEqualTo(propagandaId).andApprovalStatusIn(statusList)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        long responseNum = tbPropagandaMapper.countByExample(example);
        if(responseNum==0){
            logger.warn("??????????????????,??????????????????id[{}],???????????????????????????????????????????????????????????????",propagandaId);
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROPAGANDA_INFO_NOT_EXIST);
        }
        TbPropaganda tbPropaganda=new TbPropaganda();
        //????????????????????????
        tbPropaganda.setRecordStatus(Byte.parseByte(INVALID));
        //????????????
        tbPropaganda.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //?????????
        tbPropaganda.setModifierAccount(loginAccount);
        return tbPropagandaMapper.updateByExampleSelective(tbPropaganda, example);
    }

    /**
     * ??????????????????
     * @param businessPromotionDetailsParam
     * @param loginAccount ??????????????????
     * @return
     */
    @ServiceLog(doAction = "??????????????????")
    @Override
    public int updateBusinessPromotion(BusinessPromotionDetailsParam businessPromotionDetailsParam, String loginAccount) {
        //1.??????????????????????????????????????????
        propagandaIsAllowUpdate(businessPromotionDetailsParam.getId());
        //2.????????????
        checkBusinessPromotionData(businessPromotionDetailsParam,loginAccount);
        //3.?????????????????????
        return updatePropagandaInfo(businessPromotionDetailsParam, loginAccount);
    }

    /**
     * ??????????????????????????????????????????
     * @param propagandaId ??????id
     */
    @ServiceLog(doAction = "??????????????????????????????????????????")
    private void propagandaIsAllowUpdate(String propagandaId) {
        TbPropagandaCriteria example=new TbPropagandaCriteria();
        //????????????(-1????????????  0????????????  1????????????   2???????????????/?????????   3??????????????????)
        List<String> approvalStatus=new ArrayList<>();
        approvalStatus.add("-1");
        approvalStatus.add("0");
        approvalStatus.add("3");
        example.createCriteria().andIdEqualTo(propagandaId).andApprovalStatusIn(approvalStatus)
        .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        long existNum = tbPropagandaMapper.countByExample(example);
        if(existNum==0){
            logger.warn("????????????????????????????????????????????????????????????????????????");
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.UPDATE_NOT_ALLOWED);
        }
    }

    /***
     * ??????????????????
     * @param bpd
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "??????????????????")
    private int updatePropagandaInfo(BusinessPromotionDetailsParam bpd, String loginAccount) {
        TbPropagandaCriteria example=new TbPropagandaCriteria();
        example.createCriteria().andIdEqualTo(bpd.getId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        TbPropaganda tbPropaganda=new TbPropaganda();
        BeanUtils.copyProperties(bpd,tbPropaganda);
        //????????????
        Date now=DateUtils.parseDate(bpd.getEffectiveDate());
        tbPropaganda.setEffectiveDate(now);
        //????????????
        tbPropaganda.setInvalidDate(getCurrentTimeSpecifiedDate(now, Integer.parseInt(bpd.getPropagandaTime())));
        //??????
        tbPropaganda.setPropagandaFee(Double.valueOf(bpd.getPropagandaFee()));
        //???????????? (-1????????????  0????????????  1????????????   2???????????????/?????????   3??????????????????)
        tbPropaganda.setStatus("0");
        //????????????
        tbPropaganda.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //?????????
        tbPropaganda.setModifierAccount(loginAccount);
        return tbPropagandaMapper.updateByExampleSelective(tbPropaganda,example);
    }

    /**
     * ????????????????????????
     * @param tbServiceCodeList
     * @param business
     * @param result
     * @return
     */
    @ServiceLog(doAction = "????????????????????????")
    private List<PropagandaTypeShow> setPropagandaShowInfo(List<TbServiceCode> tbServiceCodeList, String business, List<PropagandaTypeShow> result) {
        for(TbServiceCode tbServiceCode:tbServiceCodeList){
            if(tbServiceCode.getCodeName().contains(business)
                    || StringUtils.equals(tbServiceCode.getCodeName(), "APP????????????")){
                PropagandaTypeShow propagandaTypeShow=new PropagandaTypeShow();
                propagandaTypeShow.setPropagandaTypeName(tbServiceCode.getCodeName());
                propagandaTypeShow.setPropagandaTypeCode(tbServiceCode.getCodeValue());
                result.add(propagandaTypeShow);
            }
        }
        return result;
    }

    /**
     * ????????????????????????????????????
     * @return
     */
    @ServiceLog(doAction = "????????????????????????????????????")
    private List<TbServiceCode> getTbServiceCodeList() {
        TbServiceCodeCriteria example=new TbServiceCodeCriteria();
        //??????????????????????????????
        example.createCriteria().andGroupIdEqualTo(PropagandaTypeEnum.PROPAGANDA_TYPE.getCode())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceCode> tbServiceCodeList = tbServiceCodeMapper.selectByExample(example);
        if(tbServiceCodeList.isEmpty()){
            logger.warn("?????????????????????????????????????????????????????????");
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROPAGANDA_TYPE_NOT_EXIST);
        }
        return tbServiceCodeList;
    }

    /**
     * ????????????????????????
     * @param tbServiceCodeList ????????????????????????????????????
     * @return
     */
    @ServiceLog(doAction = "????????????????????????")
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
     * ???????????????
     * @return
     */
    @ServiceLog(doAction = "???????????????")
    @Override
    public String getOrderNumber() {
        //AD-(??????)+??????????????????????????????+3????????????
        return "AD-"+ DateUtils.getDate("yyyyMMddHHmmss")+ RandomUtils.nextInt(999);
    }

    /**
     * ??????????????????
     * @param propagandaId  ??????id
     * @param approvalStatus        ???????????? (0????????????  1????????????   2???????????????/?????????   3??????????????????)
     * @param loginAccount ??????????????????
     * @return
     */
    @ServiceLog(doAction = "??????????????????")
    @Override
    public int updateApprovalStatus(String propagandaId, String approvalStatus,String loginAccount) {
        //????????????id,??????????????????????????????????????????
        TbPropagandaCriteria example=new TbPropagandaCriteria();
        example.createCriteria().andIdEqualTo(propagandaId)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        long existNum = tbPropagandaMapper.countByExample(example);
        if(existNum==0){
            logger.warn("?????????????????????????????????????????????[id:{}]?????????????????????????????????",propagandaId);
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.PROPAGANDA_INFO_NOT_EXIST);
        }
        //???????????????????????????????????????
        List<String>statusList= Arrays.asList(ApprovalStatusEnum.NOT_APPROVED.getValue(),ApprovalStatusEnum.APPROVAL.getValue(),
                ApprovalStatusEnum.APPROVED.getValue(),ApprovalStatusEnum.APPROVAL_NOT_PASSED.getValue());
        if(!statusList.contains(approvalStatus)){
            logger.warn("???????????????????????????status:[{}]?????????????????????",approvalStatus);
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.STATUS_NOT_SUPPORT);
        }
        TbPropaganda tbPropaganda=new TbPropaganda();
        tbPropaganda.setApprovalStatus(approvalStatus);
        tbPropaganda.setModifierAccount(loginAccount);
        tbPropaganda.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        return tbPropagandaMapper.updateByExampleSelective(tbPropaganda, example);
    }

    /**
     * ????????????
     * @param createBillParam      ?????????,??????id
     * @param loginAccount  ??????????????????
     * @param userName ?????????
     * @return
     */
    @ServiceLog(doAction = "????????????")
    @Override
    public String createBill(CreateBillParam createBillParam,String loginAccount,String userName){
        if(createBillParam==null ||createBillParam.getPropagandaId()==null){
            logger.warn("???????????????????????????????????????");
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.NETWORK_ANOMALY);
        }
        //???????????????????????????????????????????????????????????????"AD-"???????????????????????????????????????
        if(StringUtils.isBlank(createBillParam.getOrderNum()) || !createBillParam.getOrderNum().contains("AD-")){
            createBillParam.setOrderNum(getOrderNumber());
        }
        //????????????id??????????????????
        TbPropagandaCriteria example=new TbPropagandaCriteria();
        example.createCriteria().andIdEqualTo(createBillParam.getPropagandaId())
                .andApprovalStatusEqualTo(ApprovalStatusEnum.APPROVED.getValue())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbPropaganda> propagandaList = tbPropagandaMapper.selectByExample(example);
        if(propagandaList.isEmpty()){
            logger.warn("?????????????????????????????????[id:{}]????????????????????????????????????????????????????????????",createBillParam.getPropagandaId());
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.SUBMIT_AUDIT_NOT_ALLOW);
        }
        TbPropaganda tbPropaganda = propagandaList.get(0);
        if(StringUtils.equals(tbPropaganda.getIsPay(),IsPayEnum.HAVE_PAID.getCode())){
            logger.warn("?????????????????????????????????[id:{}]?????????????????????",createBillParam.getPropagandaId());
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.CURRENT_PROPAGANDA_HAVE_PAID);
        }
        //?????????????????????????????????????????????
        if(StringUtils.isNotBlank(tbPropaganda.getOrderCode())){
            return tbPropaganda.getOrderCode();
        }
        Result<String> bill = getBillNum(createBillParam, loginAccount, userName, tbPropaganda.getPropagandaFee());
        if(bill==null || bill.getData()==null){
            logger.warn("???????????????????????????????????????????????????null");
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.NETWORK_ANOMALY);
        }
        //?????????
        tbPropaganda.setOrderCode(bill.getData());
        //????????????
        tbPropaganda.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //?????????
        tbPropaganda.setModifierAccount(loginAccount);
        int resNum = tbPropagandaMapper.updateByExampleSelective(tbPropaganda, example);
        if(resNum==1){
            return bill.getData();
        }else{
            logger.warn("??????????????????????????????????????????????????????");
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.NETWORK_ANOMALY);
        }
    }

    /**
     * ?????????????????????????????????
     * @param createBillParam ??????????????????id
     * @param loginAccount ??????????????????
     * @param userName   ??????????????????
     * @param billAmount ????????????
     * @return
     */
    @ServiceLog(doAction = "?????????????????????????????????")
    private Result<String> getBillNum(CreateBillParam createBillParam, String loginAccount, String userName, double billAmount) {
        PaymentBillModel paymentBillModel=new PaymentBillModel();
        //????????????
        paymentBillModel.setBillNum(createBillParam.getOrderNum());
        //????????????
        paymentBillModel.setBillName(loginAccount+"???????????????");
        //????????????
        paymentBillModel.setBillType(BILL_TYPE);
        //????????????id
        paymentBillModel.setBillObjId(loginAccount);
        //???????????????
        paymentBillModel.setBillObjName(userName);
        //????????????
        paymentBillModel.setBillAmount(billAmount);
        //??????????????????
        paymentBillModel.setPayEndTime(DateUtils.getDate(PATTERN));
        //???????????????
        paymentBillModel.setBillCreateAccount(loginAccount);
        //????????????
        paymentBillModel.setBillRemark("??????????????????");
        return payBillClient.createBill(paymentBillModel);
    }

    /**
     * ????????????
     * @param propagandaId ??????id
     * @param loginAccount ??????????????????
     */
    @ServiceLog(doAction = "????????????")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public IBPSResult submitAudit(String propagandaId, String loginAccount) {
        //????????????id,?????????value="0"?????????????????????value="0"???,???????????????value="1"?????????????????????
        TbPropagandaCriteria example=new TbPropagandaCriteria();
        example.createCriteria().andIdEqualTo(propagandaId).andStatusEqualTo(INVALID)
                .andApprovalStatusEqualTo(ApprovalStatusEnum.NOT_APPROVED.getValue())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbPropaganda> tbPropagandaList = tbPropagandaMapper.selectByExample(example);
        if(tbPropagandaList.isEmpty()){
            logger.warn("?????????????????????????????????[propagandaId:{}]?????????????????????????????????????????????",propagandaId);
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.SUBMIT_AUDIT_NOT_ALLOW);
        }
        TbPropaganda tbPropaganda = tbPropagandaList.get(0);
        BusinessPromotionWorkFlow bpw=new BusinessPromotionWorkFlow();
        BeanUtils.copyProperties(tbPropaganda, bpw);
        //????????????????????????
        if(tbPropaganda.getEffectiveDate()!=null){
            //????????????
            bpw.setEffectiveDate(DateUtils.formatDate(tbPropaganda.getEffectiveDate(), PATTERN));
        }
        if(tbPropaganda.getInvalidDate()!=null){
            //????????????
            bpw.setInvalidDate(DateUtils.formatDate(tbPropaganda.getInvalidDate(), PATTERN));
        }
        if(tbPropaganda.getCreatedTime()!=null){
            //????????????
            bpw.setCreatedTime(DateUtils.formatDate(tbPropaganda.getCreatedTime(), PATTERN));
        }
        if(tbPropaganda.getModifiedTime()!=null){
            //????????????
            bpw.setModifiedTime(DateUtils.formatDate(tbPropaganda.getModifiedTime(), PATTERN));
        }

        // ??????????????????
        bpw.setPosterUrl(IBPSFileUtils.uploadFile2Json(loginAccount, bpw.getPosterUrl()));

        //???????????????
        IBPSResult ibpsResult = IBPSUtils.startWorkFlow(businessPromotionProcessId, loginAccount, bpw);
        String okStatus="200";
        //?????????????????????
        if(okStatus.equals(ibpsResult.getState())){
            logger.info("??????????????????[{}]???????????????????????????????????????,????????????id??????[{}]",tbPropaganda.getPropagandaCode(),ibpsResult.getData());
            //????????????????????????????????????????????????
            int resNum = tbPropagandaMapper.deleteByExample(example);
            logger.info("????????????????????????????????????????????????????????????????????????{}",resNum);
        }
        return ibpsResult;
    }

    /**
     * ????????????????????????
     * @return
     */
    @ServiceLog(doAction = "????????????????????????")
    @Override
    public List<PropagandaAreaShow> getPropagandaAreaList() {
        TbPropagandaAreaInfoCriteria example=new TbPropagandaAreaInfoCriteria();
        example.createCriteria().andGroupIdEqualTo(PROPAGANDA_AREA).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbPropagandaAreaInfo> tbPropagandaAreaInfoList = tbPropagandaAreaInfoMapper.selectByExample(example);
        if(tbPropagandaAreaInfoList.isEmpty()){
            logger.warn("?????????????????????????????????????????????????????????????????????");
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
        //??????????????????
        return  new UnmodifiableList<>(resultList);
    }

    /**
     * ???????????????????????????????????????
     * @param businessHomePageParam
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "???????????????????????????????????????")
    @Override
    public PaginationData getBusinessPromotionList(BusinessHomePageParam businessHomePageParam, String loginAccount) {
        BusinessPromotionListParam bpb=new BusinessPromotionListParam();
        BeanUtils.copyProperties(businessHomePageParam, bpb);
        //???????????????0????????????  1????????????   2???????????????   3?????????????????????4????????????  5????????????  6????????????)???
        //????????????????????????????????????????????????
        String hasBeenPublish="6";
        bpb.setApprovalStatus(hasBeenPublish);
        return getBusinessPromotionList(bpb,loginAccount);
    }

    /**
     * ?????????????????????????????????
     * @param orderCode
     * @return
     */
    @Override
    public int updatePayStatus(String orderCode) {
        if(StringUtils.isBlank(orderCode)){
            logger.warn("????????????????????????????????????????????????id????????????");
            throw new JnSpringCloudException(BusinessPromotionExceptionEnum.NETWORK_ANOMALY);
        }
        TbPropagandaCriteria example=new TbPropagandaCriteria();
        example.createCriteria().andOrderCodeEqualTo(orderCode)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        TbPropaganda tbPropaganda=new TbPropaganda();
        //????????????  0????????????   1????????????
        tbPropaganda.setIsPay(IsPayEnum.HAVE_PAID.getCode());
        return tbPropagandaMapper.updateByExampleSelective(tbPropaganda, example);
    }
}
