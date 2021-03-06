package com.jn.enterprise.company.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.enums.CompanyExceptionEnum;
import com.jn.company.model.*;
import com.jn.enterprise.common.config.IBPSDefIdConfig;
import com.jn.enterprise.company.dao.CompanyMapper;
import com.jn.enterprise.company.dao.TbServiceCompanyMapper;
import com.jn.enterprise.company.dao.TbServiceCompanyModifyMapper;
import com.jn.enterprise.company.dao.TbServiceCompanyStaffMapper;
import com.jn.enterprise.company.entity.*;
import com.jn.enterprise.company.enums.CompanyDataEnum;
import com.jn.enterprise.company.enums.UpgradeStatusEnum;
import com.jn.enterprise.company.model.CompanyInfoShow;
import com.jn.enterprise.company.model.CompanyUpdateParam;
import com.jn.enterprise.company.model.StaffListParam;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.service.StaffService;
import com.jn.enterprise.company.vo.*;
import com.jn.enterprise.enums.JoinParkExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.model.CompanyInfoModel;
import com.jn.enterprise.propaganda.enums.ApprovalStatusEnum;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceAdvisorMapper;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisor;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisorCriteria;
import com.jn.enterprise.servicemarket.industryarea.dao.TbServicePreferMapper;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePrefer;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePreferCriteria;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgTempMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrg;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTemp;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTempCriteria;
import com.jn.enterprise.servicemarket.org.model.UserRoleInfo;
import com.jn.enterprise.servicemarket.org.service.OrgColleagueService;
import com.jn.enterprise.technologyfinancial.investors.dao.TbServiceInvestorMapper;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestor;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorCriteria;
import com.jn.enterprise.utils.IBPSFileUtils;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.park.activity.model.ActivityPagingParam;
import com.jn.park.activity.model.Comment;
import com.jn.park.activity.model.CommentAddParam;
import com.jn.park.api.CareClient;
import com.jn.park.api.CommentClient;
import com.jn.park.care.model.CareParam;
import com.jn.park.care.model.ServiceEnterpriseCompany;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ????????????Service
 * @author??? jiangyl
 * @date??? Created on 2019/3/14 16:52
 * @version??? v1.0
 * @modified By:
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    private static Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    private TbServiceCompanyStaffMapper tbServiceCompanyStaffMapper;
    @Autowired
    private TbServiceCompanyMapper tbServiceCompanyMapper;
    @Autowired
    private TbServiceCompanyModifyMapper tbServiceCompanyModifyMapper;
    @Autowired
    private TbServicePreferMapper tbServicePreferMapper;
    @Autowired
    private OrgColleagueService orgColleagueService;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserExtensionClient userExtensionClient;
    @Autowired
    private CommentClient commentClient;
    @Autowired
    private StaffService staffService;
    @Autowired
    private CareClient careClient;
    @Autowired
    private IBPSDefIdConfig ibpsDefIdConfig;
    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;
    @Autowired
    private TbServiceOrgTempMapper tbServiceOrgTempMapper;
    @Autowired
    private TbServiceAdvisorMapper tbServiceAdvisorMapper;
    @Autowired
    private TbServiceInvestorMapper tbServiceInvestorMapper;

    private static final String PATTERN="yyyy-MM-dd";
    private static final String PATTERN_DETAIL="yyyy-MM-dd HH:mm:ss";

    @Override
    @ServiceLog(doAction = "??????????????????New")
    public PaginationData<List<ServiceEnterpriseCompany>> getCompanyNewList(ServiceEnterpriseParam sepParam,String account) {
        /*if(StringUtils.isBlank(sepParam.getOrderByClause())){
            sepParam.setOrderByClause("browse_number DESC");
        }*/
        Page<Object> objects = PageHelper.startPage(sepParam.getPage(), sepParam.getRows() == 0 ? 15 : sepParam.getRows());
        List<ServiceEnterpriseCompany> getCompanyNewList=companyMapper.getCompanyNewList(sepParam);
        List<ServiceEnterpriseCompany> newCompanyNewList = new ArrayList<>();

        // ??????????????????
        for (ServiceEnterpriseCompany serviceEnterpriseCompany : getCompanyNewList) {
            List<String> filePathList = IBPSFileUtils.getFilePath2List(serviceEnterpriseCompany.getProImgs());
            if (filePathList != null && !filePathList.isEmpty()) {
                String[] strings = new String[filePathList.size()];
                serviceEnterpriseCompany.setPropagandaPicture(filePathList.toArray(strings));
                serviceEnterpriseCompany.setProImgs(null);
            }
            serviceEnterpriseCompany.setAvatar(IBPSFileUtils.getFilePath(serviceEnterpriseCompany.getAvatar()));
            serviceEnterpriseCompany.setBusinessLicense(IBPSFileUtils.getFilePath(serviceEnterpriseCompany.getBusinessLicense()));
            newCompanyNewList.add(serviceEnterpriseCompany);
        }

        //??????park,?????????????????? getCompanyNewList
        List<ServiceEnterpriseCompany> companyNewList = careClient.getCompanyNewList(newCompanyNewList,account);
        PaginationData<List<ServiceEnterpriseCompany>> data = new PaginationData(companyNewList, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "??????????????????")
    public PaginationData<List<ServiceCompany>> getCompanyList(ServiceCompanyParam companyParam){
        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        TbServiceCompanyCriteria.Criteria criteria = companyCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        if(StringUtils.isNotEmpty(companyParam.getComName())){
            criteria.andComNameLike("%"+companyParam.getComName()+"%");
        }
        if(StringUtils.isNotEmpty(companyParam.getParkBuildId())){
            criteria.andParkBuildIdLike("%"+companyParam.getParkBuildId()+"%");
        }
        if(StringUtils.isNotEmpty(companyParam.getParkBuildName())){
            criteria.andParkBuildNameLike("%"+companyParam.getParkBuildName()+"%");
        }
        if(StringUtils.isNotEmpty(companyParam.getIsJoinActivity())){
            criteria.andIsJoinActivityEqualTo(companyParam.getIsJoinActivity());
        }
        if(StringUtils.isNotEmpty(companyParam.getComSource())){
            criteria.andComSourceEqualTo(companyParam.getComSource());
        }
        if(StringUtils.isNotEmpty(companyParam.getCheckStatus())){
            criteria.andCheckStatusEqualTo(companyParam.getCheckStatus());
        }
        if(StringUtils.isNotEmpty(companyParam.getComAdmin())){
            criteria.andComAdminEqualTo(companyParam.getComAdmin());
        }
        if(StringUtils.isNotEmpty(companyParam.getComType())){
            criteria.andComTypeEqualTo(companyParam.getComType());
        }
        if(StringUtils.isNotEmpty(companyParam.getAffiliatedPark())){
            criteria.andAffiliatedParkEqualTo(companyParam.getAffiliatedPark());
        }
        Page<Object> objects = PageHelper.startPage(companyParam.getPage(), companyParam.getRows() == 0 ? 15 : companyParam.getRows());
        List<TbServiceCompany> tbServiceCompanies = tbServiceCompanyMapper.selectByExample(companyCriteria);
        List<ServiceCompany> companies = new ArrayList<>(16);
        for (TbServiceCompany t:tbServiceCompanies) {
            ServiceCompany company = new ServiceCompany();
            BeanUtils.copyProperties(t,company);
            company = setCompanyDataInfo(t, company);
            companies.add(company);
        }
        PaginationData<List<ServiceCompany>> data = new PaginationData(companies, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "??????????????????????????????????????????????????????????????????")
    public ServiceCompany getCompanyDetailByAccountOrId(String accountOrId){
        if(StringUtils.isEmpty(accountOrId)){
            logger.warn("[??????????????????????????????????????????????????????????????????] ??????ID??????");
            throw new JnSpringCloudException(CompanyExceptionEnum.COMPANY_ID_INFO_NOT_NULL);
        }
        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andComAdminEqualTo(accountOrId).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andCheckStatusNotEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_NOT_PASS.getCode());
        TbServiceCompanyCriteria companyCriteria1 = new TbServiceCompanyCriteria();
        TbServiceCompanyCriteria.Criteria criteria = companyCriteria1.createCriteria().andIdEqualTo(accountOrId)
                .andCheckStatusNotEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_NOT_PASS.getCode())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        companyCriteria.or(criteria);

        List<TbServiceCompany> tbServiceCompanies = tbServiceCompanyMapper.selectByExample(companyCriteria);
        if(null == tbServiceCompanies || tbServiceCompanies.size() == 0){
            logger.warn("[??????????????????????????????????????????????????????????????????] ????????????????????????companyId:{}", accountOrId);
            throw new JnSpringCloudException(CompanyExceptionEnum.COMPANY_INFO_NOT_EXIST);
        }
        TbServiceCompany tbServiceCompany = tbServiceCompanies.get(0);
        ServiceCompany company = new ServiceCompany();
        BeanUtils.copyProperties(tbServiceCompany, company);
        return setCompanyDataInfo(tbServiceCompany, company);
    }

    @ServiceLog(doAction = "??????????????????????????????????????????????????????????????????,????????????????????????")
    @Override
    public  ServiceCompany getCompanyDetailByAccountOrId(String account,String currentAccount){
        ServiceCompany companyDetailByAccountOrId = this.getCompanyDetailByAccountOrId(account);
        if (currentAccount != null) {
            CareParam careParam = new CareParam();
            careParam.setAccount(account);
            careParam.setCurrentAccount(currentAccount);
            Result companyCareInfo = careClient.findCompanyCareInfo(careParam);
            if(null != companyCareInfo && null != companyCareInfo.getData()){
                Object object = companyCareInfo.getData();
                ObjectMapper objectMapper = new ObjectMapper();
                CareUserDetails careUserDetails = objectMapper.convertValue(object, CareUserDetails.class);
                companyDetailByAccountOrId.setCareUserDetails(careUserDetails);
            }
        }
        companyDetailByAccountOrId = setCompanyInfo(companyDetailByAccountOrId);
        return companyDetailByAccountOrId;
    }

    @Override
    @ServiceLog(doAction = "??????????????????")
    public Integer updateCompanyInfo(CompanyUpdateParam companyUpdateParam, String account, String phone) {
        if (companyUpdateParam.getComPropertys().length == 0 || companyUpdateParam.getComPropertys().length > 3) {
            logger.warn("[??????????????????] ??????????????????3???");
            throw new JnSpringCloudException(com.jn.enterprise.company.enums.CompanyExceptionEnum.UPGRADE_COMPANY_PROPERTY_GT_THREE);
        }

        Result<UserExtensionInfo> userExtensionResult = userExtensionClient.getUserExtension(account);
        if (userExtensionResult == null || userExtensionResult.getData() == null) {
            logger.warn("[??????????????????] ???????????????????????????account???{}", account);
            throw new JnSpringCloudException(com.jn.enterprise.company.enums.CompanyExceptionEnum.GET_USER_EXTENSION_INFO_ERROR);
        }
        UserExtensionInfo userExtensionInfo = userExtensionResult.getData();
        if (StringUtils.isBlank(userExtensionInfo.getCompanyCode())) {
            logger.warn("[??????????????????] ??????????????????????????????account???{}", account);
            throw new JnSpringCloudException(com.jn.enterprise.company.enums.CompanyExceptionEnum.USER_NO_STAFF);
        }

        ServiceCompany company = getCompanyDetailByAccountOrId(userExtensionInfo.getCompanyCode());

        String code = (String)userExtensionClient.getSendCodeByPhone(phone).getData();
        if(!StringUtils.equals(code,companyUpdateParam.getCheckCode())){
            logger.warn("[??????????????????] ????????????????????????phone???{}", phone);
            throw new JnSpringCloudException(JoinParkExceptionEnum.MESSAGE_CODE_IS_WRONG);
        }

        // ?????????????????????????????????????????????
        TbServiceCompanyModify companyModify = companyMapper.getLastModify(company.getId());
        if (companyModify != null && companyModify.getCheckStatus().equals(CompanyDataEnum.STAFF_CHECK_STATUS_WAIT.getCode())) {
            logger.warn("[??????????????????] ????????????????????????????????????????????????");
            throw new JnSpringCloudException(com.jn.enterprise.company.enums.CompanyExceptionEnum.COMPANY_CHECK_ING);
        }

        // ??????ibps??????
        companyUpdateParam.setCheckStatus(CompanyDataEnum.STAFF_CHECK_STATUS_WAIT.getCode());
        companyUpdateParam.setComId(company.getId());
        companyUpdateParam.setCreatedTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        companyUpdateParam.setCreatorAccount(account);
        companyUpdateParam.setRecordStatus(CompanyDataEnum.RECORD_STATUS_VALID.getCode());
        companyUpdateParam.setComAdmin(account);

        // ?????????????????????????????????,?????????
        companyUpdateParam.setComProperty(StringUtils.join(companyUpdateParam.getComPropertys(),","));
        companyUpdateParam.setComPropertys(null);

        // ????????????
        companyUpdateParam.setAvatar(IBPSFileUtils.uploadFile2Json(account, companyUpdateParam.getAvatar()));
        companyUpdateParam.setBusinessLicense(IBPSFileUtils.uploadFile2Json(account, companyUpdateParam.getBusinessLicense()));
        List<String> picList = Arrays.asList(companyUpdateParam.getPropagandaPictureList());
        String ibpsUrl = IBPSFileUtils.uploadFiles(account, picList);
        if (StringUtils.isNotBlank(ibpsUrl)) {
            companyUpdateParam.setPropagandaPicture(ibpsUrl);
        }
        companyUpdateParam.setPropagandaPictureList(null);

        String bpmnDefId = ibpsDefIdConfig.getUpdateCompanyInfo();
        IBPSResult ibpsResult = IBPSUtils.startWorkFlow(bpmnDefId, account, companyUpdateParam);

        // ibps??????????????????
        if (ibpsResult == null || ibpsResult.getState().equals("-1")) {
            logger.warn("[??????????????????] ??????ibps??????????????????????????????{}", ibpsResult != null ? ibpsResult.getMessage() : "");
            throw new JnSpringCloudException(com.jn.enterprise.company.enums.CompanyExceptionEnum.COMPANY_CHECK_ERROR);
        }
        logger.info("[??????????????????] " + ibpsResult.getMessage());
        return 1;
    }

    @ServiceLog(doAction = "??????????????????")
    @Override
    public CompanyDetailsVo getCompanyDetails(String companyId,String account) {
        CompanyDetailsVo vo = new CompanyDetailsVo();
        //???????????????????????? ????????????+ ????????????+ ????????????+ ??????
        CompanyInfoShow show  = companyMapper.getCompanyDetails(companyId);

        if(show==null){
            logger.info("?????????????????????!");
            return vo;
        }

        TbServicePreferCriteria preferCriteria = new TbServicePreferCriteria();
        preferCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServicePrefer> tbServicePrefers = tbServicePreferMapper.selectByExample(preferCriteria);

        //????????????????????????
        if(StringUtils.isNotEmpty(show.getComProperty())){
            String[] comPropertys = show.getComProperty().split(",");
            List<String> comPropertyNameList = new ArrayList<>();
            for (String str : comPropertys) {
                for (TbServicePrefer prefer : tbServicePrefers) {
                    if (StringUtils.equals(prefer.getId(), str)) {
                        comPropertyNameList.add(prefer.getPreValue());
                    }
                }
            }
            show.setComPropertyName(StringUtils.join(comPropertyNameList, ","));
        }

        // ??????????????????
        show.setAvatar(IBPSFileUtils.getFilePath(show.getAvatar()));

        //?????? ?????????  ??? ???????????????
        List<ServiceEnterpriseCompany> getCompanyNewList= new ArrayList<>();
        ServiceEnterpriseCompany serviceEnterpriseCompany = new ServiceEnterpriseCompany();
        serviceEnterpriseCompany.setId(companyId);
        getCompanyNewList.add(serviceEnterpriseCompany);
        List<ServiceEnterpriseCompany> companyNewList = careClient.getCompanyNewList(getCompanyNewList,account);
        if(!companyNewList.isEmpty()){
            serviceEnterpriseCompany = companyNewList.get(0);
            if(serviceEnterpriseCompany != null){
                show.setCareNumber(serviceEnterpriseCompany.getCareUser());
                show.setCommentNumber(serviceEnterpriseCompany.getCommentNumber());
            }
        }
        //??????????????????
        ActivityPagingParam activityPagingParam = new ActivityPagingParam();
        activityPagingParam.setActivityId(companyId);
        Result<PaginationData<List<Comment>>> commentRedsult = getCommentInfo(activityPagingParam);
        if(commentRedsult.getData() != null){
            vo.setComments(commentRedsult.getData().getRows());
        }
        //?????????????????????????????????????????????
        StaffListParam param = new StaffListParam();
        param.setComId(companyId);
        param.setNeedPage("0");
        ColleagueListVO colleagueListVO =  staffService.getColleagueList(param,account);
        if(colleagueListVO.getData()!=null){
            List<String> avatarList = new ArrayList<>();
            show.setComPerSonNumber(Long.toString(colleagueListVO.getData().getTotal()));
            List<StaffListVO> staffListVOS = colleagueListVO.getData().getRows();
            for(StaffListVO staffListVO: staffListVOS){
                avatarList.add(staffListVO.getAvatar());
            }
            show.setPersonAvatar(avatarList);
        }
        //??????????????????????????????
        if(StringUtils.isNotBlank(show.getComAddress())){
            List<Map<String,String>> list = addressResolution(show.getComAddress());
            if(!list.isEmpty()){
              String province =   list.get(0).get("province");
              String cityKey = "???";
             if(cityKey.equals(province.substring(province.length()-1))){
                 show.setCity(province);
             }else {
                 show.setCity(list.get(0).get("city"));
             }
            }
        }
        // ???????????????????????????????????????, 0 ??? 1 ???
        if(StringUtils.isNotBlank(account)) {
           CareParam careParam = new CareParam();
           careParam.setCurrentAccount(account);
           Result<List<String>>  result =  careClient.findCareCompanyList(careParam);
           show.setIsCare("0");
           List<String> list = result.getData();
           for(String id : list){
               if(id.equals(companyId)){
                   show.setIsCare("1");
               }
           }
        }
        vo.setCompanyInfoShow(show);
        //??????????????? ????????????1
        String browseNumber = vo.getCompanyInfoShow().getBrowseNumber();
        if(StringUtils.isBlank(browseNumber)){
            browseNumber="0";
        }
        TbServiceCompany tbServiceCompany = new TbServiceCompany();
        tbServiceCompany.setId(companyId);
        tbServiceCompany.setBrowseNumber(String.valueOf((Integer.valueOf(browseNumber)+1)));
        tbServiceCompanyMapper.updateByPrimaryKeySelective(tbServiceCompany);
        return vo;
    }

    @ServiceLog(doAction = "??????????????????")
    @Override
    public Result<PaginationData<List<Comment>>> getCommentInfo(ActivityPagingParam activityPagingParam){
        return commentClient.getCommentInfo(activityPagingParam);
    }

    @ServiceLog(doAction = "????????????")
    @Override
    public Result<Boolean> saveComment(CommentAddParam commentAddParam){
        return commentClient.commentActivity(commentAddParam);
    }

    public static List<Map<String,String>> addressResolution(String address){
        String regex="(?<province>[^???]+?????????|.*????|.*??????????|.*????)(?<city>[^???]+?????????|.*???????|.*?????????????|.+???|?????????|.*????|.*????)(?<county>[^???]+???|.+???|.+???|.+???|.+??????|.+???)?(?<town>[^???]+???|.+???)?(?<village>.*)";
        Matcher m= Pattern.compile(regex).matcher(address);
        String province=null,city=null,county=null,town=null,village=null;
        List<Map<String,String>> table=new ArrayList<Map<String,String>>();
        Map<String,String> row=null;
        while(m.find()){
            row=new LinkedHashMap<String,String>();
            province=m.group("province");
            row.put("province", province==null?"":province.trim());
            city=m.group("city");
            row.put("city", city==null?"":city.trim());
            county=m.group("county");
            row.put("county", county==null?"":county.trim());
            town=m.group("town");
            row.put("town", town==null?"":town.trim());
            village=m.group("village");
            row.put("village", village==null?"":village.trim());
            table.add(row);
        }
        return table;
    }

    @ServiceLog(doAction = "?????????????????????")
    @Override
    public Result<Boolean> updateCreditPoints(CreditUpdateParam creditUpdateParam){

        TbServiceCompany tbServiceCompany = tbServiceCompanyMapper.selectByPrimaryKey(creditUpdateParam.getComId());
        if(null == tbServiceCompany){
            throw new JnSpringCloudException(CompanyExceptionEnum.COMPANY_INFO_NOT_EXIST);
        }
        tbServiceCompany.setCreditPoints(tbServiceCompany.getCreditPoints()==null?
                (new BigDecimal("100").subtract(new BigDecimal(creditUpdateParam.getPintNum()))):(tbServiceCompany.getCreditPoints().subtract(new BigDecimal(creditUpdateParam.getPintNum()))));
        tbServiceCompany.setCreditUpdateTime(new Date());

        int i = tbServiceCompanyMapper.updateByPrimaryKeySelective(tbServiceCompany);
        logger.info("?????????????????????????????????????????????????????????{} ",i);
        return new Result<>(i==1?true:false);

    }

    @Override
    @ServiceLog(doAction = "???????????????????????????")
    public CompanyContactVO getCompanyContactAccount(String comId) {
        // ?????????????????????????????????
        String companyContactAccount = companyService.getCompanyDetailByAccountOrId(comId).getComAdmin();

        TbServiceCompanyStaffCriteria example = new TbServiceCompanyStaffCriteria();
        example.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue()).andComIdEqualTo(comId)
                .andInviteStatusEqualTo(CompanyDataEnum.STAFF_INVITE_STATUS_AGREE.getCode())
                .andCheckStatusEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_PASS.getCode());
        List<TbServiceCompanyStaff> staffList = tbServiceCompanyStaffMapper.selectByExample(example);
        
        // ???????????????????????????????????????????????????????????????????????????????????????
        if (staffList != null && !staffList.isEmpty()) {
            List<String> accountList = new ArrayList<>();
            for (TbServiceCompanyStaff companyStaff : staffList) {
                accountList.add(companyStaff.getAccount());
            }

            String roleName = CompanyDataEnum.COMPANY_CONTACTS.getCode();
            List<UserRoleInfo> userRoleInfoList = orgColleagueService.getUserRoleInfoList(accountList, roleName);
            for (UserRoleInfo userRoleInfo : userRoleInfoList) {
                if (StringUtils.isNotBlank(userRoleInfo.getRoleName()) && userRoleInfo.getRoleName().equals(roleName)) {
                    companyContactAccount = userRoleInfo.getAccount();
                    break;
                }
            }
        }

        CompanyContactVO companyContact = new CompanyContactVO();
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(companyContactAccount);
        if (userExtension == null || userExtension.getData() == null) {
            logger.warn("[???????????????????????????] ??????[{}]??????????????????????????????account???{}", comId, companyContactAccount);
            throw new JnSpringCloudException(com.jn.enterprise.company.enums.CompanyExceptionEnum.GET_USER_EXTENSION_INFO_ERROR);
        }
        UserExtensionInfo data = userExtension.getData();
        BeanUtils.copyProperties(data, companyContact);
        return companyContact;
    }

    @ServiceLog(doAction = "??????????????????(????????????????????????)")
    @Override
    public CompanyInfoModel getCompanyInfo(String companyId,String account) {
        logger.info("??????????????????(????????????????????????)??????id:"+companyId+"????????????:"+account);
        CompanyInfoModel companyInfoModel = new CompanyInfoModel();
        CompanyDetailsVo vo = companyService.getCompanyDetails(companyId,account);
        if(vo != null && vo.getCompanyInfoShow()!=null){
            companyInfoModel.setCompanyId(companyId);
            companyInfoModel.setCompanyName(vo.getCompanyInfoShow().getComName());
            companyInfoModel.setCompanyAvatar( IBPSFileUtils.getFilePath(vo.getCompanyInfoShow().getAvatar()));
        }else{
            throw new JnSpringCloudException(CompanyExceptionEnum.COMPANY_INFO_NOT_EXIST);
        }
        return companyInfoModel;
    }

    @Override
    @ServiceLog(doAction = "????????????????????????????????????")
    public Boolean updateCompanyInfoAfterPay(UpdateCompanyInfoParam updateCompanyInfoParam) {
        TbServiceCompany tbServiceCompany = tbServiceCompanyMapper.selectByPrimaryKey(updateCompanyInfoParam.getComId());
        if(null == tbServiceCompany){
            logger.warn("[????????????????????????????????????] ????????????????????????comId???{}", updateCompanyInfoParam.getComId());
            throw new JnSpringCloudException(CompanyExceptionEnum.COMPANY_INFO_NOT_EXIST);
        }
        BeanUtils.copyProperties(updateCompanyInfoParam, tbServiceCompany);
        int i = tbServiceCompanyMapper.updateByPrimaryKeySelective(tbServiceCompany);
        return i == 1;
    }

    @Override
    @ServiceLog(doAction = "????????????????????????")
    public ServiceCompany getCurCompanyInfo(String account) {
        Result<UserExtensionInfo> userExtensionResult = userExtensionClient.getUserExtension(account);
        if (userExtensionResult == null || userExtensionResult.getData() == null) {
            logger.warn("[????????????????????????] ????????????????????????");
            return null;
        }

        UserExtensionInfo userExtensionInfo = userExtensionResult.getData();
        if (StringUtils.isBlank(userExtensionInfo.getCompanyCode())) {
            logger.warn("[????????????????????????] ???????????????????????????");
            return null;
        }

        ServiceCompany company = new ServiceCompany();
        String comId = userExtensionInfo.getCompanyCode();
        TbServiceCompany tbServiceCompany = tbServiceCompanyMapper.selectByPrimaryKey(comId);
        BeanUtils.copyProperties(tbServiceCompany, company);

        company = setCompanyDataInfo(tbServiceCompany, company);
        return company;
    }

    @Override
    @ServiceLog(doAction = "????????????????????????????????????")
    public InviteUpgradeStatusVO getJoinParkStatus(String account) {
        Result<UserExtensionInfo> userExtensionResult = userExtensionClient.getUserExtension(account);
        if (userExtensionResult == null || userExtensionResult.getData() == null) {
            logger.warn("[????????????????????????????????????] ????????????????????????");
            throw new JnSpringCloudException(com.jn.enterprise.company.enums.CompanyExceptionEnum.GET_USER_EXTENSION_INFO_ERROR);
        }

        // ???????????????????????????
        InviteUpgradeStatusVO inviteUpgradeStatusVO = new InviteUpgradeStatusVO(UpgradeStatusEnum.UPGRADE_OK);
        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andCheckStatusNotEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_NOT_PASS.getCode())
                .andComAdminEqualTo(account);
        List<TbServiceCompany> tbServiceCompanies = tbServiceCompanyMapper.selectByExample(companyCriteria);

        TbServiceCompanyModifyCriteria companyModifyCriteria = new TbServiceCompanyModifyCriteria();
        companyModifyCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andCheckStatusNotEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_NOT_PASS.getCode())
                .andComAdminEqualTo(account);
        List<TbServiceCompanyModify> tbServiceCompanyModifies = tbServiceCompanyModifyMapper.selectByExample(companyModifyCriteria);
        if ((tbServiceCompanies != null && !tbServiceCompanies.isEmpty()) || (tbServiceCompanyModifies != null && !tbServiceCompanyModifies.isEmpty())) {
            inviteUpgradeStatusVO = new InviteUpgradeStatusVO(UpgradeStatusEnum.UPGRADE_COMPANY);
        }

        // ???????????????????????????
        if (!staffService.checkUserIsCompanyStaff(account)) {
            inviteUpgradeStatusVO = new InviteUpgradeStatusVO(UpgradeStatusEnum.UPGRADE_STAFF);
        }

        // ???????????????????????????
        TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
        orgCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andOrgStatusNotEqualTo(CompanyDataEnum.ORG_APPROVAL_STATUS_NOT_PASS.getCode())
                .andOrgAccountEqualTo(account);
        List<TbServiceOrg> tbServiceOrgs = tbServiceOrgMapper.selectByExample(orgCriteria);

        TbServiceOrgTempCriteria orgTempCriteria = new TbServiceOrgTempCriteria();
        orgTempCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andOrgStatusNotEqualTo(CompanyDataEnum.ORG_APPROVAL_STATUS_NOT_PASS.getCode())
                .andOrgAccountEqualTo(account);
        List<TbServiceOrgTemp> tbServiceOrgTemps = tbServiceOrgTempMapper.selectByExample(orgTempCriteria);
        if ((tbServiceOrgs != null && !tbServiceOrgs.isEmpty()) || (tbServiceOrgTemps != null && !tbServiceOrgTemps.isEmpty())) {
            inviteUpgradeStatusVO = new InviteUpgradeStatusVO(UpgradeStatusEnum.UPGRADE_ORG);
        }

        // ??????????????????????????????
        TbServiceInvestorCriteria investorCriteria = new TbServiceInvestorCriteria();
        investorCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andApprovalStatusNotEqualTo(ApprovalStatusEnum.APPROVAL_NOT_PASSED.getValue())
                .andInvestorAccountEqualTo(account);
        List<TbServiceInvestor> tbServiceInvestors = tbServiceInvestorMapper.selectByExample(investorCriteria);
        if (tbServiceInvestors != null && !tbServiceInvestors.isEmpty()) {
            inviteUpgradeStatusVO = new InviteUpgradeStatusVO(UpgradeStatusEnum.UPGRADE_INVESTOR);
        }

        // ???????????????????????????
        List<String> approvalStatusList = new ArrayList<>();
        approvalStatusList.add(ApprovalStatusEnum.APPROVAL_NOT_PASSED.getValue());
        approvalStatusList.add(ApprovalStatusEnum.REFUSED.getValue());
        TbServiceAdvisorCriteria advisorCriteria = new TbServiceAdvisorCriteria();
        advisorCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andApprovalStatusNotIn(approvalStatusList)
                .andAdvisorAccountEqualTo(account);
        List<TbServiceAdvisor> tbServiceAdvisors = tbServiceAdvisorMapper.selectByExample(advisorCriteria);
        if (tbServiceAdvisors != null && !tbServiceAdvisors.isEmpty()) {
            inviteUpgradeStatusVO = new InviteUpgradeStatusVO(UpgradeStatusEnum.UPGRADE_ADVISOR);
        }
        return inviteUpgradeStatusVO;
    }

    @Override
    @ServiceLog(doAction = "??????/??????????????????")
    public int saveOrUpdateCompanyInfo(com.jn.enterprise.company.model.ServiceCompany company) {
        String comId = company.getComId();
        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue()).andIdEqualTo(comId);
        List<TbServiceCompany> companyList = tbServiceCompanyMapper.selectByExample(companyCriteria);

        int result = 0;
        try {
            TbServiceCompany tbServiceCompany = new TbServiceCompany();
            if (companyList != null && !companyList.isEmpty()) {
                TbServiceCompany tbServiceCompanyTemp = companyList.get(0);
                BeanUtils.copyProperties(tbServiceCompanyTemp, tbServiceCompany);
                BeanUtils.copyProperties(company, tbServiceCompany);
            } else {
                BeanUtils.copyProperties(company, tbServiceCompany);
                if (StringUtils.isNotBlank(company.getCreditPoints())) {
                    tbServiceCompany.setCreditPoints(new BigDecimal(company.getCreditPoints()));
                }
                if (StringUtils.isNotBlank(company.getCreditUpdateTime())) {
                    tbServiceCompany.setCreditUpdateTime(DateUtils.parseDate(company.getCreditUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
                }
            }
            tbServiceCompany.setId(company.getComId());
            tbServiceCompany.setRecordStatus(Byte.parseByte(company.getRecordStatus()));
            tbServiceCompany.setCheckStatus(CompanyDataEnum.COMPANY_CHECK_STATUS_PASS.getCode());
            if (StringUtils.isNotBlank(company.getRegCapital())) {
                tbServiceCompany.setRegCapital(new BigDecimal(company.getRegCapital()));
            }
            if (StringUtils.isNotBlank(company.getFoundingTime())) {
                tbServiceCompany.setFoundingTime(DateUtils.parseDate(company.getFoundingTime() + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(company.getRunTime())) {
                tbServiceCompany.setRunTime(DateUtils.parseDate(company.getRunTime() + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(company.getCheckTime())) {
                tbServiceCompany.setCheckTime(DateUtils.parseDate(company.getCheckTime(), "yyyy-MM-dd HH:mm:ss"));
            }

            // ???????????????????????????
            if (companyList != null && !companyList.isEmpty()) {
                tbServiceCompany.setModifiedTime(DateUtils.parseDate(company.getCreatedTime(), "yyyy-MM-dd HH:mm:ss"));
                result = tbServiceCompanyMapper.updateByPrimaryKeySelective(tbServiceCompany);
            } else {
                tbServiceCompany.setCreatedTime(DateUtils.parseDate(company.getCreatedTime(), "yyyy-MM-dd HH:mm:ss"));
                result = tbServiceCompanyMapper.insertSelective(tbServiceCompany);
            }
        } catch (ParseException e) {
            logger.warn("[??????/??????????????????] ??????????????????");
            throw new JnSpringCloudException(CompanyExceptionEnum.DATE_CONVERT_ERROR);
        }
        return result;
    }

    /**
     * ???????????????????????????????????????
     * @param company
     */
    private ServiceCompany setCompanyInfo (ServiceCompany company) {
        //????????????????????????
        TbServicePreferCriteria preferCriteria = new TbServicePreferCriteria();
        preferCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServicePrefer> tbServicePrefers = tbServicePreferMapper.selectByExample(preferCriteria);

        // ????????????
        if(StringUtils.isNotEmpty(company.getInduType())){
            for (TbServicePrefer prefer: tbServicePrefers) {
                if(StringUtils.equals(prefer.getId(), company.getInduType())){
                    company.setInduTypeName(prefer.getPreValue());
                }
            }
        }

        //????????????
        if(StringUtils.isNotEmpty(company.getComProperty())){
            String[] comPropertys = company.getComProperty().split(",");
            List<String> comPropertyNameList = new ArrayList<>();
            for (String str : comPropertys) {
                for (TbServicePrefer prefer : tbServicePrefers) {
                    if (StringUtils.equals(prefer.getId(), str)) {
                        comPropertyNameList.add(prefer.getPreValue());
                    }
                }
            }
            company.setComPropertyName(StringUtils.join(comPropertyNameList, ","));
            company.setComPropertys(company.getComProperty().split(","));
        }
        return company;
    }

    /**
     * ????????????
     * @param tbServiceCompany
     * @param company
     * @return
     */
    private ServiceCompany setCompanyDataInfo (TbServiceCompany tbServiceCompany, ServiceCompany company) {
        if(null != tbServiceCompany.getFoundingTime()){
            company.setFoundingTime(DateUtils.formatDate(tbServiceCompany.getFoundingTime(),PATTERN));
        }
        if(null != tbServiceCompany.getRunTime()){
            company.setRunTime(DateUtils.formatDate(tbServiceCompany.getRunTime(),PATTERN));
        }
        if(null != tbServiceCompany.getLicStarttime()){
            company.setLicStarttime(DateUtils.formatDate(tbServiceCompany.getLicStarttime(),PATTERN));
        }
        if(null != tbServiceCompany.getLicEndtime()){
            company.setLicEndtime(DateUtils.formatDate(tbServiceCompany.getLicEndtime(),PATTERN));
        }
        if(null != tbServiceCompany.getCheckTime()){
            company.setCheckTime(DateUtils.formatDate(tbServiceCompany.getCheckTime(),PATTERN_DETAIL));
        }
        if(null != tbServiceCompany.getCreatedTime()){
            company.setCreatedTime(DateUtils.formatDate(tbServiceCompany.getCreatedTime(),PATTERN_DETAIL));
        }
        if(null != tbServiceCompany.getModifiedTime()){
            company.setModifiedTime(DateUtils.formatDate(tbServiceCompany.getModifiedTime(),PATTERN_DETAIL));
        }
        List<String> filePathList = IBPSFileUtils.getFilePath2List(tbServiceCompany.getPropagandaPicture());
        if (filePathList != null && !filePathList.isEmpty()) {
            String[] strings = new String[filePathList.size()];
            company.setPropagandaPicture(filePathList.toArray(strings));
        }
        company.setBusinessLicense(IBPSFileUtils.getFilePath(tbServiceCompany.getBusinessLicense()));
        company.setAvatar(IBPSFileUtils.getFilePath(tbServiceCompany.getAvatar()));
        return setCompanyInfo(company);
    }

}
