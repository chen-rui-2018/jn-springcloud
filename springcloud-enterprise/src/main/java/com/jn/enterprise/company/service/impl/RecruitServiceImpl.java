package com.jn.enterprise.company.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.common.config.IBPSDefIdConfig;
import com.jn.enterprise.company.dao.ServiceRecruitMapper;
import com.jn.enterprise.company.dao.TbServiceRecruitMapper;
import com.jn.enterprise.company.entity.TbServiceRecruit;
import com.jn.enterprise.company.entity.TbServiceRecruitCriteria;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.enums.RecruitDataTypeEnum;
import com.jn.enterprise.company.enums.RecruitExceptionEnum;
import com.jn.enterprise.company.model.*;
import com.jn.enterprise.company.service.RecruitService;
import com.jn.enterprise.company.vo.RecruitVO;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.park.api.CareClient;
import com.jn.park.care.model.CareParam;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 企业招聘Service
 * @author： huxw
 * @date： Created on 2019-3-29 15:23:33
 * @version： v1.0
 * @modified By:
 */
@Service
public class RecruitServiceImpl implements RecruitService {

    private static Logger logger = LoggerFactory.getLogger(RecruitServiceImpl.class);

    @Autowired
    private TbServiceRecruitMapper tbServiceRecruitMapper;

    @Autowired
    private ServiceRecruitMapper serviceRecruitMapper;

    @Autowired
    private IBPSDefIdConfig ibpsDefIdConfig;

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private CareClient careClient;

    @Override
    @ServiceLog(doAction = "根据招聘ID获取招聘详情")
    public RecruitVO getRecruitDetailsById(String id, String curAccount) {
        RecruitVO recruitDetails = checkRecruitExist(id);
        if (1 == serviceRecruitMapper.addRecruitClickById(id)) {
            logger.info("[招聘管理] 招聘信息浏览量增加,recruitId:{}",id);
        }
        // 如果已登录，查询关注列表
        if (StringUtils.isNotBlank(curAccount)) {
            List<String> companyList = getCareCompany(curAccount);
            if (companyList.contains(recruitDetails.getComId())) {
                recruitDetails.setCareStatus("1");
            }
        }
        return recruitDetails;
    }

    @Override
    @ServiceLog(doAction = "根据招聘编号获取招聘详情")
    public TbServiceRecruit getRecruitByNo(String no) {
        if(StringUtils.isEmpty(no)){
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_NO_IS_NULL);
        }
        TbServiceRecruitCriteria recruitCriteria = new TbServiceRecruitCriteria();
        recruitCriteria.createCriteria().andRecruitNoEqualTo(no);
        List<TbServiceRecruit> recruitList = tbServiceRecruitMapper.selectByExample(recruitCriteria);

        if (null == recruitList || recruitList.size() == 0) {
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_INFO_IS_NOT_EXIST);
        }
        return recruitList.get(0);
    }

    @Override
    @ServiceLog(doAction = "查询招聘信息列表")
    public PaginationData<List<RecruitVO>> getRecruitList(ServiceRecruitParam recruitParam, String approvalStatus) {
        // 过滤错误入参
        if (StringUtils.isNotEmpty(recruitParam.getWhereTypes())) {
            recruitParam.setWhereTypes(recruitParam.getWhereTypes().toLowerCase());
            if (!recruitParam.getWhereTypes().equals(RecruitDataTypeEnum.MONTH.getCode())
                    && !recruitParam.getWhereTypes().equals(RecruitDataTypeEnum.WEEK.getCode())){
                throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_WHERE_TYPE_ERROR);
            }
        }

        if (StringUtils.isNotEmpty(recruitParam.getSortTypes())) {
            recruitParam.setSortTypes(recruitParam.getSortTypes().toLowerCase());
            if (!recruitParam.getSortTypes().equals(RecruitDataTypeEnum.TIME.getCode())
                    && !recruitParam.getSortTypes().equals(RecruitDataTypeEnum.HOT.getCode())){
                throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_SORT_TYPE_ERROR);
            }
        }

        // 过滤无效状态
        if (StringUtils.isNotEmpty(recruitParam.getStatus())) {
            if (!recruitParam.getStatus().equals(RecruitDataTypeEnum.ON_SHELVES.getCode())
                    && !recruitParam.getStatus().equals(RecruitDataTypeEnum.OFF_SHELVES.getCode())
                    && !recruitParam.getStatus().equals(RecruitDataTypeEnum.ALL_SHELVES.getCode())) {
                throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_STATUS_ERROR);
            }
        } else {
            // 默认查询已上架
            recruitParam.setStatus(RecruitDataTypeEnum.ON_SHELVES.getCode());
        }

        // 用户中心列表查询当前企业招聘
        if (StringUtils.isNotBlank(recruitParam.getAccount()) && approvalStatus == null) {
            UserExtensionInfo userExtensionInfo = checkCompanyUser(recruitParam.getAccount());
            recruitParam.setComId(userExtensionInfo.getCompanyCode());
        }

        ServiceRecruitSearchParam rp = new ServiceRecruitSearchParam();
        BeanUtils.copyProperties(recruitParam,rp);

        // 如果审核字段不为空，查询指定审批列表
        if (StringUtils.isNotEmpty(approvalStatus)) {
            rp.setApprovalStatus(approvalStatus);
        }

        // 复合查询判断并赋值(忽略单一查询)
        if (StringUtils.isNotEmpty(recruitParam.getBeginDate()) && StringUtils.isNotEmpty(recruitParam.getEndDate())) {
            try {
                rp.setBeginDate(DateUtils.parseDate(recruitParam.getBeginDate(),"yyyy-MM-dd"));
                rp.setEndDate(DateUtils.parseDate(recruitParam.getEndDate(),"yyyy-MM-dd"));
            } catch (ParseException e) {
                throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_SEARCH_DATE_FORMAT_ERROR);
            }
        }

        Page<Object> objects = PageHelper.startPage(recruitParam.getPage(), recruitParam.getRows() == 0 ? 15 : recruitParam.getRows());
        List<RecruitVO> recruitList = serviceRecruitMapper.getRecruitList(rp);

        // 如果已登录，查询关注列表
        if (StringUtils.isNotBlank(recruitParam.getAccount())) {
            List<String> companyList = getCareCompany(recruitParam.getAccount());
            for (RecruitVO recruit : recruitList) {
                if (companyList.contains(recruit.getComId())) {
                    recruit.setCareStatus("1");
                }
            }
        }
        PaginationData<List<RecruitVO>> data = new PaginationData(recruitList, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "发布招聘信息")
    @Transactional(rollbackFor = Exception.class)
    public Integer publishRecruitInfo(ServiceRecruitPublishParam serviceRecruitPublishParam, String curAccount) {
        UserExtensionInfo userExtensionInfo = checkCompanyUser(curAccount);

        TbServiceRecruitPublishParam tbServiceRecruitPublishParam = new TbServiceRecruitPublishParam();
        BeanUtils.copyProperties(serviceRecruitPublishParam, tbServiceRecruitPublishParam);

        // 招聘编号
        Integer randomNo = (int)(Math.random() * 900 + 10000);
        String recruitNo = "QYZP-" + DateUtils.formatDate(new Date(), "yyyyMMddHHmmss") + randomNo;

        tbServiceRecruitPublishParam.setCreatedTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        tbServiceRecruitPublishParam.setCreatorAccount(curAccount);
        tbServiceRecruitPublishParam.setComId(userExtensionInfo.getCompanyCode());
        tbServiceRecruitPublishParam.setComName(userExtensionInfo.getCompanyName());
        tbServiceRecruitPublishParam.setRecordStatus(RecordStatusEnum.EFFECTIVE.getCode());
        tbServiceRecruitPublishParam.setNum(serviceRecruitPublishParam.getNum().toString());
        tbServiceRecruitPublishParam.setStatus(RecruitDataTypeEnum.OFF_SHELVES.getCode());
        tbServiceRecruitPublishParam.setApprovalStatus(RecruitDataTypeEnum.APPROVAL_STATUS_WAIT.getCode());
        tbServiceRecruitPublishParam.setRecruitNo(recruitNo);
        tbServiceRecruitPublishParam.setViewCount("0");
        tbServiceRecruitPublishParam.setId("");

        String bpmnDefId = ibpsDefIdConfig.getCompanyRecruit();
        IBPSResult ibpsResult = IBPSUtils.startWorkFlow(bpmnDefId, curAccount, tbServiceRecruitPublishParam);

        // ibps启动流程失败
        if (ibpsResult == null || !ibpsResult.getState().equals("200")) {
            logger.warn("[发布招聘信息] 启动ibps流程出错，错误信息：{}", ibpsResult != null ? ibpsResult.getMessage() : "");
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_PUBLISH_IBPS_ERROR);
        }
        logger.info("[发布招聘信息] " + ibpsResult.getMessage());
        return 1;
    }

    @Override
    @ServiceLog(doAction = "编辑招聘信息")
    @Transactional(rollbackFor = Exception.class)
    public Integer editRecruitInfo(ServiceRecruitEditParam serviceRecruitEditParam, String curAccount) {
        checkCompanyUser(curAccount);

        RecruitVO recruitVO = checkRecruitExist(serviceRecruitEditParam.getId());
        TbServiceRecruit tbServiceRecruit = tbServiceRecruitMapper.selectByPrimaryKey(serviceRecruitEditParam.getId());
        TbServiceRecruitPublishParam tbServiceRecruitPublishParam = new TbServiceRecruitPublishParam();
        BeanUtils.copyProperties(tbServiceRecruit, tbServiceRecruitPublishParam);
        BeanUtils.copyProperties(serviceRecruitEditParam, tbServiceRecruitPublishParam);

        tbServiceRecruitPublishParam.setStatus(RecruitDataTypeEnum.OFF_SHELVES.getCode());
        tbServiceRecruitPublishParam.setApprovalStatus(RecruitDataTypeEnum.APPROVAL_STATUS_WAIT.getCode());
        tbServiceRecruitPublishParam.setNum(serviceRecruitEditParam.getNum().toString());
        tbServiceRecruitPublishParam.setCreatedTime(DateUtils.formatDate(recruitVO.getCreatedTime(), "yyyy-MM-dd HH:mm:ss"));
        tbServiceRecruitPublishParam.setModifiedTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        tbServiceRecruitPublishParam.setModifierAccount(curAccount);
        tbServiceRecruitPublishParam.setViewCount(tbServiceRecruit.getViewCount().toString());
        tbServiceRecruitPublishParam.setRecordStatus(RecordStatusEnum.EFFECTIVE.getCode());
        tbServiceRecruitPublishParam.setId("");

        String bpmnDefId = ibpsDefIdConfig.getCompanyRecruit();
        IBPSResult ibpsResult = IBPSUtils.startWorkFlow(bpmnDefId, curAccount, tbServiceRecruitPublishParam);

        // ibps启动流程失败
        if (ibpsResult == null || !ibpsResult.getState().equals("200")) {
            logger.warn("[编辑招聘信息] 启动ibps流程出错，错误信息：{}", ibpsResult != null ? ibpsResult.getMessage() : "");
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_PUBLISH_IBPS_ERROR);
        }
        logger.info("[编辑招聘信息] " + ibpsResult.getMessage());

        // 流程启动成功删除之前的数据
        if (ibpsResult.getState().equals("200")) {
            tbServiceRecruit.setRecordStatus(RecordStatusEnum.DELETE.getValue());
            return tbServiceRecruitMapper.updateByPrimaryKeySelective(tbServiceRecruit);
        } else {
            return 0;
        }
    }

    @Override
    @ServiceLog(doAction = "上/下架招聘信息")
    @Transactional(rollbackFor = Exception.class)
    public Integer underRecruit(ServiceRecruitUnderParam serviceRecruitUnderParam, String curAccount) {
        // 过滤无效状态
        if (!serviceRecruitUnderParam.getStatus().equals(RecruitDataTypeEnum.ON_SHELVES.getCode())
                && !serviceRecruitUnderParam.getStatus().equals(RecruitDataTypeEnum.OFF_SHELVES.getCode())){
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_STATUS_ERROR);
        }

        checkRecruitExist(serviceRecruitUnderParam.getId());

        TbServiceRecruit sr = new TbServiceRecruit();
        BeanUtils.copyProperties(serviceRecruitUnderParam,sr);

        // 设置上/下架状态
        if (serviceRecruitUnderParam.getStatus().equals(RecruitDataTypeEnum.ON_SHELVES.getCode())) {
            sr.setStatus(RecruitDataTypeEnum.OFF_SHELVES.getValue());
        } else {
            sr.setStatus(RecruitDataTypeEnum.ON_SHELVES.getValue());
        }

        sr.setModifierAccount(curAccount);
        sr.setModifiedTime(new Date());

        Integer result = tbServiceRecruitMapper.updateByPrimaryKeySelective(sr);
        if (1 == result) {
            logger.info("[招聘管理] 上下架招聘成功,recruitId:{}",sr.getId());
        }
        return result;
    }

    @Override
    @ServiceLog(doAction = "删除招聘")
    @Transactional(rollbackFor = Exception.class)
    public Integer delRecruitById(String id, String curAccount) {
        checkRecruitExist(id);
        Integer result = serviceRecruitMapper.delRecruitById(id, curAccount, new Date());
        if (1 == result) {
            logger.info("[招聘管理] 删除招聘成功,recruitId:{}", id);
        }
        return result;
    }

    // 判断招聘ID是否存在
    public RecruitVO checkRecruitExist (String id) {
        RecruitVO recruitDetails = serviceRecruitMapper.getRecruitDetailsById(id);
        if (null == recruitDetails) {
            logger.warn("[招聘管理] 获取招聘信息失败,招聘信息不存在,recruitId:{}", id);
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_INFO_IS_NOT_EXIST);
        }
        return recruitDetails;
    }

    /**
     * 获取关注的企业ID列表
     * @param account 账号
     * @return
     */
    public List<String> getCareCompany(String account) {
        CareParam careParam = new CareParam();
        careParam.setCurrentAccount(account);
        Result<List<String>> result = careClient.findCareCompanyList(careParam);
        if (result == null || result.getData() == null) {
            throw new JnSpringCloudException(CompanyExceptionEnum.CALL_SERVICE_ERROR);
        }

        // 关注的企业ID列表
        return result.getData();
    }

    /**
     * 判断账号是否企业账号
     * @param account
     * @return
     */
    public UserExtensionInfo checkCompanyUser (String account) {
        Result<UserExtensionInfo> result = userExtensionClient.getUserExtension(account);
        if (result == null || result.getData() == null) {
            throw new JnSpringCloudException(RecruitExceptionEnum.CALL_SERVICE_ERROR);
        }
        UserExtensionInfo userExtensionInfo = result.getData();
        if (StringUtils.isBlank(userExtensionInfo.getCompanyCode()) || StringUtils.isBlank(userExtensionInfo.getCompanyName())) {
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_USER_NOT_COMPANY_USER);
        }
        return userExtensionInfo;
    }

}
