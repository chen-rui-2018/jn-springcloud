package com.jn.enterprise.technologyfinancial.investors.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.Assert;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.InvestorExceptionEnum;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrg;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import com.jn.enterprise.technologyfinancial.investors.dao.*;
import com.jn.enterprise.technologyfinancial.investors.entity.*;
import com.jn.enterprise.technologyfinancial.investors.model.*;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorService;
import com.jn.enterprise.technologyfinancial.investors.vo.InvestorInfoDetailsVo;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 科技金融投资人
 * @Author: yangph
 * @Date: 2019/3/9 16:40
 * @Version v1.0
 * @modified By:
 */
@Service
public class InvestorServiceImpl implements InvestorService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(InvestorServiceImpl.class);

    @Autowired
    private InvestorMapper investorMapper;

    @Autowired
    private TbServiceInvestorMapper tbServiceInvestorMapper;

    @Autowired
    private TbServiceInvestorMainAreaMapper tbServiceInvestorMainAreaMapper;

    @Autowired
    private TbServiceInvestorMainRoundMapper tbServiceInvestorMainRoundMapper;

    @Autowired
    private TbServiceInvestorWorkExpMapper tbServiceInvestorWorkExpMapper;

    @Autowired
    private TbServiceInvestorEduExpMapper tbServiceInvestorEduExpMapper;

    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;

    @Autowired
    private TbServiceMainAreaMapper tbServiceMainAreaMapper;

    @Autowired
    private TbServiceMainRoundMapper tbServiceMainRoundMapper;

    /**
     * 时间格式
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";
    /**
     * 数据状态  0：已删除   1：有效
     */
    private static final byte RECORD_STATUS=1;

    /**
     * 投资人列表查询
     * @param investorInfoListParam  投资人列表查询入参
     * @return
     */
    @ServiceLog(doAction = "投资人列表查询")
    @Override
    public PaginationData getInvestorInfoList(InvestorInfoListParam investorInfoListParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(investorInfoListParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<InvestorInfoListShow> investorInfoList = investorMapper.getInvestorInfoList("", "");
            return new PaginationData(investorInfoList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(investorInfoListParam.getNeedPage())){
            objects = PageHelper.startPage(investorInfoListParam.getPage(),
                    investorInfoListParam.getRows() == 0 ? 15 : investorInfoListParam.getRows(), true);
        }
        List<InvestorInfoListShow> investorInfoList = investorMapper.getInvestorInfoList(investorInfoListParam.getMainCode(), investorInfoListParam.getKeyWords());
        return new PaginationData(investorInfoList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 投资人详情
     * @param investorAccount 投资人账号
     * @return
     */
    @ServiceLog(doAction = "投资人详情")
    @Override
    public InvestorInfoDetailsVo getInvestorInfoDetails(String investorAccount) {
        InvestorInfoDetailsVo investorInfoDetailsVo=new InvestorInfoDetailsVo();
        //获取投资人基本信息
        List<TbServiceInvestor> tbServiceInvestorList = getTbServiceInvestors(investorAccount);
        if(tbServiceInvestorList.isEmpty()){
            logger.warn("<<----当前投资人[{}]信息不存在--->>",investorAccount);
            throw new JnSpringCloudException(InvestorExceptionEnum.INVESTOR_INFO_NOT_EXIST);
        }
        InvestorBaseInfoShow investorBaseInfoShow=new InvestorBaseInfoShow();
        BeanUtils.copyProperties(tbServiceInvestorList.get(0), investorBaseInfoShow);
        //设置投资人基本信息
        investorInfoDetailsVo.setInvestorBaseInfoShow(investorBaseInfoShow);
        //投资人主投领域
        List<InvestorMainArea> mainAreaList = getMainAreaList(investorAccount);
        investorInfoDetailsVo.setMainAreaList(mainAreaList);
        //投资人主投轮次
        List<InvestorMainRound> mainRoundList = getMainRoundList(investorAccount);
        investorInfoDetailsVo.setMainRoundList(mainRoundList);
        //投资人工作经历
        List<InvestorWorkExperienceShow> workExpList = getWorkExpList(investorAccount);
        investorInfoDetailsVo.setWorkExperienceList(workExpList);
        //投资人教育经历
        List<InvestorEduExperienceShow> eduExpList = getEduExpList(investorAccount);
        investorInfoDetailsVo.setEduExpList(eduExpList);
        return investorInfoDetailsVo;
    }

    /**
     * 根据投资人账号获取投资人教育经历
     * @param investorAccount  投资人账号
     * @return
     */
    @ServiceLog(doAction = "根据投资人账号获取投资人教育经历")
    private List<InvestorEduExperienceShow> getEduExpList(String investorAccount) {
        TbServiceInvestorEduExpCriteria example=new TbServiceInvestorEduExpCriteria();
        example.createCriteria().andInvestorAccountEqualTo(investorAccount).andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceInvestorEduExp> tbServiceInvestorEduExpList = tbServiceInvestorEduExpMapper.selectByExample(example);
        if(tbServiceInvestorEduExpList.isEmpty()){
            return null;
        }
        List<InvestorEduExperienceShow> resultList=new ArrayList<>(16);
        for(TbServiceInvestorEduExp tbServiceInvestorEduExp:tbServiceInvestorEduExpList){
            InvestorEduExperienceShow investorEduExperienceShow=new InvestorEduExperienceShow();
            BeanUtils.copyProperties(tbServiceInvestorEduExp, investorEduExperienceShow);
            resultList.add(investorEduExperienceShow);
        }
        return resultList;
    }

    /**
     * 根据投资人账号获取投资人工作经历
     * @param investorAccount  投资人账号
     * @return
     */
    @ServiceLog(doAction = "根据投资人账号获取投资人工作经历")
    private List<InvestorWorkExperienceShow> getWorkExpList(String investorAccount) {
        TbServiceInvestorWorkExpCriteria example=new TbServiceInvestorWorkExpCriteria();
        example.createCriteria().andInvestorAccountEqualTo(investorAccount).andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceInvestorWorkExp> workExpList = tbServiceInvestorWorkExpMapper.selectByExample(example);
        if(workExpList.isEmpty()){
            return null;
        }
        List<InvestorWorkExperienceShow> resultList=new ArrayList<>();
        for(TbServiceInvestorWorkExp tbServiceInvestorWorkExp:workExpList){
            InvestorWorkExperienceShow investorWorkExperienceShow=new InvestorWorkExperienceShow();
            BeanUtils.copyProperties(tbServiceInvestorWorkExp, investorWorkExperienceShow);
            resultList.add(investorWorkExperienceShow);
        }
        return resultList;
    }

    /**
     * 根据投资人账号获取投资人主投轮次
     * @param investorAccount  投资人账号
     * @return
     */
    @ServiceLog(doAction = "根据投资人账号获取投资人主投轮次")
    private List<InvestorMainRound> getMainRoundList(String investorAccount) {
        TbServiceInvestorMainRoundCriteria example=new TbServiceInvestorMainRoundCriteria();
        example.createCriteria().andInvestorAccountEqualTo(investorAccount).andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceInvestorMainRound> investorMainRoundList = tbServiceInvestorMainRoundMapper.selectByExample(example);
        if(investorMainRoundList.isEmpty()){
            return null;
        }
        List<InvestorMainRound> resultList=new ArrayList<>(16);
        for(TbServiceInvestorMainRound tbServiceInvestorMainRound:investorMainRoundList){
            InvestorMainRound investorMainRound=new InvestorMainRound();
            investorMainRound.setMainRoundCode(tbServiceInvestorMainRound.getMainRoundCode());
            investorMainRound.setMainRoundName(tbServiceInvestorMainRound.getMainRoundName());
            resultList.add(investorMainRound);

        }
        return resultList;
     }

    /**
     * 根据投资人账号获取投资人主投领域
     * @param investorAccount  投资人账号
     * @return
     */
    @ServiceLog(doAction = "根据投资人账号获取投资人主投领域")
    private List<InvestorMainArea> getMainAreaList(String investorAccount) {
        TbServiceInvestorMainAreaCriteria example=new TbServiceInvestorMainAreaCriteria();
        example.createCriteria().andInvestorAccountEqualTo(investorAccount).andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceInvestorMainArea> tbServiceInvestorMainAreaList = tbServiceInvestorMainAreaMapper.selectByExample(example);
        if(tbServiceInvestorMainAreaList.isEmpty()){
            return null;
        }
        List<InvestorMainArea> investorMainAreaList=new ArrayList<>(16);
        for(TbServiceInvestorMainArea tbServiceInvestorMainArea:tbServiceInvestorMainAreaList){
            InvestorMainArea investorMainArea=new InvestorMainArea();
            investorMainArea.setMainCode(tbServiceInvestorMainArea.getMainCode());
            investorMainArea.setMainName(tbServiceInvestorMainArea.getMainName());
            investorMainAreaList.add(investorMainArea);
        }
        return investorMainAreaList;
    }

    /**
     * 根据投资人账号获取投资人信息
     * @param investorAccount  投资人账号
     * @return
     */
    @ServiceLog(doAction = "根据投资人账号获取投资人信息")
    private List<TbServiceInvestor> getTbServiceInvestors(String investorAccount) {
        TbServiceInvestorCriteria example=new TbServiceInvestorCriteria();
        example.createCriteria().andInvestorAccountEqualTo(investorAccount).andRecordStatusEqualTo(RECORD_STATUS);
        return tbServiceInvestorMapper.selectByExample(example);
    }

    /**
     * 查询所属单位
     * @param affiliationUnitInfoParam
     * @return
     */
    @ServiceLog(doAction = "查询所属单位")
    @Override
    public PaginationData getAffiliationUnit(AffiliationUnitInfoParam affiliationUnitInfoParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(affiliationUnitInfoParam.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            //获取系统中机构信息
            List<TbServiceOrg> tbServiceOrgList = getTbServiceOrgList(affiliationUnitInfoParam.getOrgName());
            //转换封装机构信息，返回前端
            List<AffiliationUnitShow> resultList = getAffiliationUnitShows(tbServiceOrgList);
            return new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(affiliationUnitInfoParam.getNeedPage())){
            objects = PageHelper.startPage(affiliationUnitInfoParam.getPage(),
                    affiliationUnitInfoParam.getRows() == 0 ? 15 : affiliationUnitInfoParam.getRows(), true);
        }
        //获取系统中机构信息
        List<TbServiceOrg> tbServiceOrgList = getTbServiceOrgList(affiliationUnitInfoParam.getOrgName());
        //转换封装机构信息，返回前端
        List<AffiliationUnitShow> resultList = getAffiliationUnitShows(tbServiceOrgList);
        return new PaginationData(resultList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 机构数据转换封装
     * @param tbServiceOrgList
     * @return
     */
    @ServiceLog(doAction = "机构数据转换封装")
    private List<AffiliationUnitShow> getAffiliationUnitShows(List<TbServiceOrg> tbServiceOrgList) {
        List<AffiliationUnitShow> resultList=new ArrayList<>(16);
        for(TbServiceOrg serviceOrg:tbServiceOrgList){
            AffiliationUnitShow affiliationUnitShow =new AffiliationUnitShow();
            affiliationUnitShow.setOrgId(serviceOrg.getOrgId());
            affiliationUnitShow.setOrgName(serviceOrg.getOrgName());
            resultList.add(affiliationUnitShow);
        }
        return resultList;
    }

    /**
     * 获取机构信息
     * @param orgName 机构名称
     * @return
     */
    @ServiceLog(doAction = "获取机构信息")
    private List<TbServiceOrg> getTbServiceOrgList(String orgName) {
        //根据单位名称，从机构信息表（tb_service_org）中模糊查询所有机构
        TbServiceOrgCriteria example=new TbServiceOrgCriteria();
        //审核通过
        String status="1";
        if(StringUtils.isBlank(orgName)){
            example.createCriteria().andOrgStatusEqualTo(status).andRecordStatusEqualTo(RECORD_STATUS);
        }else{
            example.createCriteria().andOrgNameLike("%"+orgName+"%").andOrgStatusEqualTo(status).andRecordStatusEqualTo(RECORD_STATUS);
        }
        return tbServiceOrgMapper.selectByExample(example);
    }

    /**
     * 新增投资人认证信息
     * @param investorAuthenticateParam 投资人认证信息
     * @param investorAccount           投资人账号
     * @return
     */
    @ServiceLog(doAction = "新增投资人认证信息")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addInvestorInfo(InvestorAuthenticateParam investorAuthenticateParam, String investorAccount) {
        Assert.notNull(investorAccount, InvestorExceptionEnum.INVESTOR_ACCOUNT_NOT_NULL.getMessage());
        Assert.notNull(investorAuthenticateParam, InvestorExceptionEnum.INVESTOR_INFO_NOT_NULL.getMessage());
        Assert.notNull(investorAuthenticateParam.getInvestorMainAreaList(), InvestorExceptionEnum.INVESTOR_MAIN_AREA_NOT_NULL.getMessage());
        Assert.notNull(investorAuthenticateParam.getInvestorMainRoundList(), InvestorExceptionEnum.INVESTOR_MAIN_ROUND_NOT_NULL.getMessage());

        //判断条件  状态是有效(1)  审批状态不包含审批不通过（-1）
        String status="1";
        String approvalStatus="-1";
        //判断投资人是否已存在
        TbServiceInvestorCriteria example=new TbServiceInvestorCriteria();
        example.createCriteria().andInvestorAccountEqualTo(investorAccount).andStatusEqualTo(status).andApprovalStatusNotEqualTo(approvalStatus);
        long isExists = tbServiceInvestorMapper.countByExample(example);
        if(isExists>0){
            logger.warn("当前投资人[{}]认证信息已存在",investorAccount);
            throw new JnSpringCloudException(InvestorExceptionEnum.INVESTOR_INFO_EXIST);
        }

        //投资人基本信息
        TbServiceInvestor tbServiceInvestor=new TbServiceInvestor();
        BeanUtils.copyProperties(investorAuthenticateParam, tbServiceInvestor);
        int responseNum = addInvestorBaseInfo(investorAccount, tbServiceInvestor);
        //主投领域
        List<InvestorMainArea> investorMainAreaList = investorAuthenticateParam.getInvestorMainAreaList();
        addInvestorMainAreaBatch(investorAccount, investorMainAreaList);
        //主投轮次
        List<InvestorMainRound> investorMainRoundList = investorAuthenticateParam.getInvestorMainRoundList();
        addInvestorMainRoundBatch(investorAccount, investorMainRoundList);
        //工作经历
        List<InvestorWorkExperienceParam> investorWorkExperienceParamList = investorAuthenticateParam.getInvestorWorkExperienceParamList();
        if(investorWorkExperienceParamList !=null && !investorWorkExperienceParamList.isEmpty()){
            addInvestorWorkExperienceBatch(investorAccount, investorWorkExperienceParamList);
        }
        //教育经历
        List<InvestorEducationExperienceParam> investorEduExperienceParamList = investorAuthenticateParam.getInvestorEducationExperienceParamList();
        if(investorEduExperienceParamList !=null && !investorEduExperienceParamList.isEmpty()){
            addInvestorEduExperienceBatch(investorAccount, investorEduExperienceParamList);
        }
        return responseNum;
    }

    /**
     * 批量新增投资人教育经历信息
     * @param investorAccount
     * @param investorEduExperienceParamList
     */
    @ServiceLog(doAction = "批量新增投资人教育经历信息")
    private void addInvestorEduExperienceBatch(String investorAccount, List<InvestorEducationExperienceParam> investorEduExperienceParamList) {
        List<TbServiceInvestorEduExp> eduExpList=new ArrayList<>(16);
        if(!investorEduExperienceParamList.isEmpty()){
            for(InvestorEducationExperienceParam investorEduExperienceParam : investorEduExperienceParamList){
                if(StringUtils.isNotBlank(investorEduExperienceParam.getStartTime()) && StringUtils.isNotBlank(investorEduExperienceParam.getEndTime())){
                    int startTime = Integer.parseInt(investorEduExperienceParam.getStartTime().replaceAll("-", ""));
                    int endTime = Integer.parseInt(investorEduExperienceParam.getEndTime().replaceAll("-", ""));
                    if(startTime>endTime){
                        logger.warn("投资人认证教育经历中数据开始时间:[{}]晚于结束时间:[{}]", investorEduExperienceParam.getStartTime(), investorEduExperienceParam.getEndTime());
                        throw new JnSpringCloudException(InvestorExceptionEnum.INVESTOR_EDU_START_TIME_LATER_END_TIME);
                    }
                }
                TbServiceInvestorEduExp eduExp=new TbServiceInvestorEduExp();
                //主键id
                eduExp.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                //投资人账号
                eduExp.setInvestorAccount(investorAccount);
                //开始时间
                eduExp.setStartTime(DateUtils.parseDate(investorEduExperienceParam.getStartTime()));
                //结束时间
                eduExp.setEndTime(DateUtils.parseDate(investorEduExperienceParam.getEndTime()));
                //学校名称
                eduExp.setSchoolName(investorEduExperienceParam.getSchoolName());
                //专业名称
                eduExp.setProfessionTitle(investorEduExperienceParam.getProfessionTitle());
                //创建时间
                eduExp.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
                //创建人
                eduExp.setCreatorAccount(investorAccount);
                //数据状态
                eduExp.setRecordStatus(RECORD_STATUS);
                eduExpList.add(eduExp);
            }
            investorMapper.insertInvestorEduExperienceBatch(eduExpList);
        }
    }

    /**
     * 批量新增投资人工作经历信息
     * @param investorAccount
     * @param investorWorkExperienceParamList
     */
    @ServiceLog(doAction = "批量新增投资人工作经历信息")
    private void addInvestorWorkExperienceBatch(String investorAccount, List<InvestorWorkExperienceParam> investorWorkExperienceParamList) {
        List<TbServiceInvestorWorkExp> workExpList=new ArrayList<>(16);
        if(!investorWorkExperienceParamList.isEmpty()){
            for(InvestorWorkExperienceParam investorWorkExperienceParam : investorWorkExperienceParamList){
                if(StringUtils.isNotBlank(investorWorkExperienceParam.getStartTime()) && StringUtils.isNotBlank(investorWorkExperienceParam.getEndTime())){
                    int startTime = Integer.parseInt(investorWorkExperienceParam.getStartTime().replaceAll("-", ""));
                    int endTime = Integer.parseInt(investorWorkExperienceParam.getEndTime().replaceAll("-", ""));
                    if(startTime>endTime){
                        logger.warn("投资人认证工作经历中数据开始时间:[{}]晚于结束时间:[{}]", investorWorkExperienceParam.getStartTime(), investorWorkExperienceParam.getEndTime());
                        throw new JnSpringCloudException(InvestorExceptionEnum.INVESTOR_WORK_START_TIME_LATER_END_TIME);
                    }
                }
                TbServiceInvestorWorkExp workExp=new TbServiceInvestorWorkExp();
                //主键id
                workExp.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                //投资人账号
                workExp.setInvestorAccount(investorAccount);
                //开始时间
                workExp.setStartTime(DateUtils.parseDate(investorWorkExperienceParam.getStartTime()));
                //结束时间
                workExp.setEndTime(DateUtils.parseDate(investorWorkExperienceParam.getEndTime()));
                //单位名称
                workExp.setCompanyName(investorWorkExperienceParam.getCompanyName());
                //职务
                workExp.setPosition(investorWorkExperienceParam.getPosition());
                //创建时间
                workExp.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
                //创建人
                workExp.setCreatorAccount(investorAccount);
                //数据状态
                workExp.setRecordStatus(RECORD_STATUS);
                workExpList.add(workExp);
            }
            investorMapper.insertInvestorWorkExperienceBatch(workExpList);
        }
    }

    /**
     * 批量新增投资人主投轮次信息
     * @param investorAccount
     * @param investorMainRoundList
     */
    @ServiceLog(doAction = "批量新增投资人主投轮次信息")
    private void addInvestorMainRoundBatch(String investorAccount, List<InvestorMainRound> investorMainRoundList) {
        List<TbServiceInvestorMainRound> mainRoundList=new ArrayList<>(16);
        for(InvestorMainRound investorMainRound:investorMainRoundList){
            TbServiceInvestorMainRound mainRound=new TbServiceInvestorMainRound();
            //主键id
            mainRound.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            //投资人账号
            mainRound.setInvestorAccount(investorAccount);
            //主投轮次编码
            mainRound.setMainRoundCode(investorMainRound.getMainRoundCode());
            //主投轮次名称
            mainRound.setMainRoundName(investorMainRound.getMainRoundName());
            //创建时间
            mainRound.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //创建人
            mainRound.setCreatorAccount(investorAccount);
            //数据状态
            mainRound.setRecordStatus(RECORD_STATUS);
            mainRoundList.add(mainRound);
        }
        investorMapper.insertInvestorMainRoundBatch(mainRoundList);
    }

    /**
     * 批量新增投资人主投领域信息
     * @param investorAccount
     * @param investorMainAreaList
     */
    @ServiceLog(doAction = "批量新增投资人主投领域信息")
    private void addInvestorMainAreaBatch(String investorAccount, List<InvestorMainArea> investorMainAreaList) {
        List<TbServiceInvestorMainArea> mainAreaList=new ArrayList<>(16);
        for(InvestorMainArea investorMainArea:investorMainAreaList){
            TbServiceInvestorMainArea mainArea=new TbServiceInvestorMainArea();
            //主键id
            mainArea.setId(UUID.randomUUID().toString().replaceAll("-","" ));
            //投资人账号
            mainArea.setInvestorAccount(investorAccount);
            //主投领域编码
            mainArea.setMainCode(investorMainArea.getMainCode());
            //主投领域名称
            mainArea.setMainName(investorMainArea.getMainName());
            //创建时间
            mainArea.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
            //创建人
            mainArea.setCreatorAccount(investorAccount);
            //数据状态
            mainArea.setRecordStatus(RECORD_STATUS);
            mainAreaList.add(mainArea);
        }
        investorMapper.insertInvestorMainAreaBatch(mainAreaList);
    }

    /**
     * 新增投资人认证基本信息
     * @param investorAccount       投资人账号
     * @param tbServiceInvestor     投资人基本信息bean
     * @return
     */
    @ServiceLog(doAction = "新增投资人认证基本信息")
    private int addInvestorBaseInfo(String investorAccount, TbServiceInvestor tbServiceInvestor) {
        //主键id
        tbServiceInvestor.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //状态 (0：无效   1：有效)
        tbServiceInvestor.setStatus("1");
        //审批状态 ( - 1：不通过    0：待审批   1：审批通过  2：审批中 )
        tbServiceInvestor.setApprovalStatus("0");
        //投资人账号
        tbServiceInvestor.setInvestorAccount(investorAccount);
        //创建人
        tbServiceInvestor.setCreatorAccount(investorAccount);
        //创建时间
        tbServiceInvestor.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //数据状态
        tbServiceInvestor.setRecordStatus(RECORD_STATUS);
        return tbServiceInvestorMapper.insertSelective(tbServiceInvestor);
    }

    /**
     * 查询投资人主投领域
     * @return
     */
    @ServiceLog(doAction = "查询投资人主投领域")
    @Override
    public List<InvestorMainArea> getInvestorMainArea() {
        TbServiceMainAreaCriteria example=new TbServiceMainAreaCriteria();
        example.createCriteria().andMainCodeIsNotNull().andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceMainArea> tbServiceMainAreaList = tbServiceMainAreaMapper.selectByExample(example);
        if(tbServiceMainAreaList.isEmpty()){
            logger.warn("系统中主投领域信息不存在");
            throw new JnSpringCloudException(InvestorExceptionEnum.MAIN_AREA_INFO_NOT_EXIST);
        }
        List<InvestorMainArea>resultList=new ArrayList<>(16);
        for(TbServiceMainArea tbServiceMainArea:tbServiceMainAreaList){
            InvestorMainArea investorMainArea=new InvestorMainArea();
            investorMainArea.setMainCode(tbServiceMainArea.getMainCode());
            investorMainArea.setMainName(tbServiceMainArea.getMainName());
            resultList.add(investorMainArea);
        }
        return resultList;
    }

    /**
     * 查询投资人主投轮次
     * @return
     */
    @ServiceLog(doAction = "查询投资人主投轮次")
    @Override
    public List<InvestorMainRound> getInvestorMainRound() {
        TbServiceMainRoundCriteria example=new TbServiceMainRoundCriteria();
        example.createCriteria().andMainRoundCodeIsNotNull().andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceMainRound> tbServiceMainRoundList = tbServiceMainRoundMapper.selectByExample(example);
        if(tbServiceMainRoundList.isEmpty()){
            logger.warn("系统中主投轮次信息不存在");
            throw new JnSpringCloudException(InvestorExceptionEnum.MAIN_ROUND_INFO_NOT_EXIST);
        }
        List<InvestorMainRound>resultList=new ArrayList<>(16);
        for(TbServiceMainRound tbServiceMainRound:tbServiceMainRoundList){
            InvestorMainRound investorMainRound=new InvestorMainRound();
            investorMainRound.setMainRoundCode(tbServiceMainRound.getMainRoundCode());
            investorMainRound.setMainRoundName(tbServiceMainRound.getMainRoundName());
            resultList.add(investorMainRound);
        }
        return resultList;
    }
}
