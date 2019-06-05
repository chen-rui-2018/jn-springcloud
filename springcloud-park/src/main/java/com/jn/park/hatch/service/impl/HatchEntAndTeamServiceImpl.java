package com.jn.park.hatch.service.impl;

import com.jn.common.model.Result;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.api.DataReportClient;
import com.jn.enterprise.api.PersonnelClient;
import com.jn.enterprise.model.DataTargetModel;
import com.jn.enterprise.model.LoadCompanyDataTargetReq;
import com.jn.enterprise.model.PersonnelProject;
import com.jn.park.activity.model.CompanyActivityApplyParam;
import com.jn.park.activity.model.CompanyActivityApplyShow;
import com.jn.park.api.ActivityClient;
import com.jn.park.hatch.dao.TbHatchIncubatorEnterpriseAndTeamMapper;
import com.jn.park.hatch.entity.TbHatchIncubatorEnterpriseAndTeam;
import com.jn.park.hatch.entity.TbHatchIncubatorEnterpriseAndTeamCriteria;
import com.jn.park.hatch.enums.HatchStatusEnums;
import com.jn.park.hatch.model.HatchUpdateRevenueParamModel;
import com.jn.park.hatch.service.HatchEntAndTeamService;
import com.jn.system.log.annotation.ServiceLog;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.xxpay.common.util.JsonUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 在孵企业（团队）管理(业务实现层)
 *
 * @author： wzy
 * @date： Created on 2019/5/15 17:15
 * @version： v1.0
 * @modified By:
 */
@Service
public class HatchEntAndTeamServiceImpl implements HatchEntAndTeamService {

    private static final Logger logger = LoggerFactory.getLogger(HatchEntAndTeamServiceImpl.class);

    @Autowired
    private TbHatchIncubatorEnterpriseAndTeamMapper tbHatchIncubatorEnterpriseAndTeamMapper;

    @Autowired
    private DataReportClient dataReportClient;

    @Autowired
    private CompanyClient companyClient;

    @Autowired
    private ActivityClient activityClient;

    @Autowired
    private PersonnelClient personnelClient;

    @Override
    @ServiceLog(doAction = "孵化企业-更新企业税收-营收-投资额")
    public Result updateRevenue(HatchUpdateRevenueParamModel hatchUpdateRevenueParamModel) {
        logger.info("进入孵化企业-更新企业税收-营收-投资额方法");
        TbHatchIncubatorEnterpriseAndTeam tbHatch = tbHatchIncubatorEnterpriseAndTeamMapper.selectByPrimaryKey(hatchUpdateRevenueParamModel.getEntAndTeamId());
        logger.info("查询企业信息返回数据【{}】",JsonUtil.object2Json(tbHatch));
        /** 1.判断该企业是否在孵化企业当中*/
        if(ObjectUtils.isNotEmpty(tbHatch)){
             /** 2.通过企业id，指标id，账期等条件调用查询数据上报接口*/
            LoadCompanyDataTargetReq loadReq = new LoadCompanyDataTargetReq();
            String [] str = new String[]{HatchStatusEnums.HATCH_TARGET_TAX_REVENUE.getCode(),HatchStatusEnums.HATCH_TARGET_REVENUE.getCode(),HatchStatusEnums.HATCH_TARGET_INVESTMENT_AMOUNT.getCode()};
            loadReq.setEnterpriseId(tbHatch.getId());
            loadReq.setTargetIds(str);
            logger.info("进入孵化企业-更新企业税收-营收-投资额方法,调用企业数据上报接口入參【{}】",JsonUtil.object2Json(loadReq));
           Result<List<DataTargetModel>> listResult = dataReportClient.loadCompanyDataTarget(loadReq);
            logger.info("进入孵化企业-更新企业税收-营收-投资额方法,调用企业数据上报接口返回参数【{}】",JsonUtil.object2Json(listResult));
            if(listResult.getData().size() > 0){
                BigDecimal str1 = new BigDecimal(0);
                BigDecimal str2 = new BigDecimal(0);
                BigDecimal str3 = new BigDecimal(0);
                for (int i = 0; i < listResult.getData().size(); i++) {
                    if(listResult.getData().get(i).getTargetId().equals(HatchStatusEnums.HATCH_TARGET_TAX_REVENUE.getCode())){
                        logger.info("进入孵化企业-更新企业税收-营收-投资额方法,统计缴纳税收总额");
                        if(StringUtils.isNotBlank(listResult.getData().get(i).getTargetData())){
                            str1 = str1.add(new BigDecimal(listResult.getData().get(i).getTargetData()));
                        }
                    }else if(listResult.getData().get(i).getTargetId().equals(HatchStatusEnums.HATCH_TARGET_REVENUE.getCode())){
                        logger.info("进入孵化企业-更新企业税收-营收-投资额方法,统计营业收入");
                        if(StringUtils.isNotBlank(listResult.getData().get(i).getTargetData())){
                            str2 = str2.add(new BigDecimal(listResult.getData().get(i).getTargetData()));
                        }
                    }else if(listResult.getData().get(i).getTargetId().equals(HatchStatusEnums.HATCH_TARGET_INVESTMENT_AMOUNT.getCode())){
                        logger.info("进入孵化企业-更新企业税收-营收-投资额方法,统计固定资产投资额");
                        if(StringUtils.isNotBlank(listResult.getData().get(i).getTargetData())){
                            str3 = str3.add(new BigDecimal(listResult.getData().get(i).getTargetData()));
                        }
                    }
                }
                tbHatch.setTaxValue(str1);
                tbHatch.setRevenueValue(str2);
                tbHatch.setFinancValue(str3);
                /** 3.根据查询接口返回的明细汇总该指标数据，并更新到在孵企业（团队）管理表*/
                logger.info("进入孵化企业-更新企业税收-营收-投资额方法,开始更新数据");
                tbHatchIncubatorEnterpriseAndTeamMapper.updateByPrimaryKeySelective(tbHatch);
                logger.info("进入孵化企业-更新企业税收-营收-投资额方法,结束更新数据");
            }
        }
        logger.info("结束孵化企业-更新企业税收-营收-投资额方法");
        return new Result();
    }

    @Override
    @ServiceLog(doAction = "孵化企业-更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】")
    public Result updateGraduateegister() {
        /**1.先查询在孵企业（团队）管理表在孵企业信息*/
        logger.info("开始进入孵化企业-更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】方法");
        TbHatchIncubatorEnterpriseAndTeamCriteria criteria = new TbHatchIncubatorEnterpriseAndTeamCriteria();
        criteria.createCriteria().andGraduateStatusEqualTo(HatchStatusEnums.HATCH_GRADUATE_STATUS_3.getCode());
        List<TbHatchIncubatorEnterpriseAndTeam> tbHatchIncubatorEnterpriseAndTeams = tbHatchIncubatorEnterpriseAndTeamMapper.selectByExample(criteria);
        logger.info("进入孵化企业-更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】方法，查询在孵企业结果【{}】",JsonUtil.object2Json(tbHatchIncubatorEnterpriseAndTeams));
        if(tbHatchIncubatorEnterpriseAndTeams.size() > 0){
            for (TbHatchIncubatorEnterpriseAndTeam tb: tbHatchIncubatorEnterpriseAndTeams) {
                if(StringUtils.isNotBlank(tb.getId())){
                    logger.info("进入孵化企业-更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】方法，调用查询企业接口入參【{}】",tb.getId());
                    Result<ServiceCompany> serviceCompany =  companyClient.getCompanyDetailByAccountOrCompanyId(tb.getId());
                    logger.info("进入孵化企业-更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】方法，调用查询企业接口返回参数【{}】",JsonUtil.object2Json(serviceCompany));
                    /**获取当前时间并减去6年时间*/
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date());
                    calendar.add(Calendar.YEAR, -6);
                    //比较当前时间和企业成立时间
                    SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = null;
                    try {
                        date = sDateFormat.parse(serviceCompany.getData().getFoundingTime());
                        Date date2 = calendar.getTime();
                        logger.info("进入孵化企业-更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】方法，计算是否满足注册时间超过6年");
                        /**2.通过孵化表里的企业id去查询企业表成立时间，满足即更新毕业条件状态*/
                        /**表示date晚于date2*/
                        if(date.after(date2)){
                            tb.setGraduateStatus(HatchStatusEnums.HATCH_GRADUATE_STATUS_1.getCode());
                            tb.setGraduateRequirements(HatchStatusEnums.HATCH_GRADUATE_COND_1.getCode());
                            logger.info("进入孵化企业-更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】方法，更新毕业条件入參【{}】",JsonUtil.object2Json(tb));
                            tbHatchIncubatorEnterpriseAndTeamMapper.updateByPrimaryKeySelective(tb);

                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        logger.info("结束孵化企业-更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】方法");
        return new Result();
    }

    @Override
    @ServiceLog(doAction = "孵化企业-更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】")
    public Result updateGraduateRevenue() {
        /**1.先查询在孵企业（团队）管理表在孵企业信息*/
        logger.info("开始进入孵化企业-更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】方法");
        TbHatchIncubatorEnterpriseAndTeamCriteria criteria = new TbHatchIncubatorEnterpriseAndTeamCriteria();
        criteria.createCriteria().andGraduateStatusEqualTo(HatchStatusEnums.HATCH_GRADUATE_STATUS_3.getCode());
        List<TbHatchIncubatorEnterpriseAndTeam> tbHatchIncubatorEnterpriseAndTeams = tbHatchIncubatorEnterpriseAndTeamMapper.selectByExample(criteria);
        logger.info("进入孵化企业-更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】方法，查询在孵企业且满足条件的结果【{}】",JsonUtil.object2Json(tbHatchIncubatorEnterpriseAndTeams));
        if(tbHatchIncubatorEnterpriseAndTeams.size() > 0){
            for (TbHatchIncubatorEnterpriseAndTeam tb: tbHatchIncubatorEnterpriseAndTeams) {
                if(StringUtils.isNotBlank(tb.getId())) {
                    logger.info("进入孵化企业-更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】方法，调用企业数据上报接口入參【{}】",tb.getId());
                    Result<Boolean> booleanResult =  dataReportClient.loadCompanyByRevenue(tb.getId());
                    logger.info("进入孵化企业-更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】方法，调用企业数据上报接口返回参数【{}】",JsonUtil.object2Json(booleanResult));
                    if(booleanResult.getData()){
                        /**2.通过孵化表里的企业id去查询企业表成立时间，满足即更新毕业条件状态*/
                            tb.setGraduateStatus(HatchStatusEnums.HATCH_GRADUATE_STATUS_1.getCode());
                            tb.setGraduateRequirements(HatchStatusEnums.HATCH_GRADUATE_COND_2.getCode());
                        logger.info("进入孵化企业-更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】方法，更新毕业条件入參【{}】",JsonUtil.object2Json(tb));
                        tbHatchIncubatorEnterpriseAndTeamMapper.updateByPrimaryKeySelective(tb);
                    }
                }
            }
        }
        logger.info("结束孵化企业-更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】方法");
        return new Result();
    }

    @Override
    @ServiceLog(doAction = "孵化企业-更新在孵企业（团队）报名活动项")
    public Result updateEnrolmentActivit() {
        /**1.查询在孵化企业所有信息*/
        logger.info("开始孵化企业-更新在孵企业（团队）报名活动项方法");
        TbHatchIncubatorEnterpriseAndTeamCriteria criteria = new TbHatchIncubatorEnterpriseAndTeamCriteria();
        criteria.createCriteria().andGraduateStatusEqualTo(HatchStatusEnums.HATCH_GRADUATE_STATUS_3.getCode());
        List<TbHatchIncubatorEnterpriseAndTeam> tbHatchIncubatorEnterpriseAndTeams = tbHatchIncubatorEnterpriseAndTeamMapper.selectByExample(criteria);
        logger.info("进入孵化企业-更新在孵企业（团队）报名活动项方法，查询满足条件的在孵企业结果【{}】",JsonUtil.object2Json(tbHatchIncubatorEnterpriseAndTeams));
        if(tbHatchIncubatorEnterpriseAndTeams.size() > 0){
            for (TbHatchIncubatorEnterpriseAndTeam tb: tbHatchIncubatorEnterpriseAndTeams) {
                if(StringUtils.isNotBlank(tb.getId())) {
                    /**2.通过企业ID去查询报名活动项*/
                    CompanyActivityApplyParam companyActivityApplyParam = new CompanyActivityApplyParam();
                    companyActivityApplyParam.setCompanyId(tb.getId());
                    logger.info("进入孵化企业-更新在孵企业（团队）报名活动项方法，调用查询企业报名活动的接口入參【{}】",JsonUtil.object2Json(companyActivityApplyParam));
                    Result<List<CompanyActivityApplyShow>> listResult = activityClient.getCompanyActivityApplyInfo(companyActivityApplyParam);
                    logger.info("进入孵化企业-更新在孵企业（团队）报名活动项方法，调用查询企业报名活动的接口返回参数【{}】",JsonUtil.object2Json(listResult));
                    if(listResult.getData().size() > 0){
                        /**3.更新表数据，记录企业参加了几类活动*/
                        LinkedHashSet<CompanyActivityApplyShow> set = new LinkedHashSet<>(listResult.getData().size());
                        set.addAll(listResult.getData());
                        listResult.getData().clear();
                        listResult.getData().addAll(set);
                        tb.setEnrolmentActivities(listResult.getData().size()+"");
                        logger.info("进入孵化企业-更新在孵企业（团队）报名活动项方法，更新数据入參【{}】",JsonUtil.object2Json(tb));
                        tbHatchIncubatorEnterpriseAndTeamMapper.updateByPrimaryKeySelective(tb);
                    }
                }
            }
        }
        logger.info("结束孵化企业-更新在孵企业（团队）报名活动项方法");
        return new Result("更新在孵企业（团队）报名活动项成功！");
    }

    @Override
    @ServiceLog(doAction = "孵化企业-更新在孵企业（团队）政策申报项")
    public Result updatePolicyDeclarate() {
        /**1.查询在孵化企业所有信息*/
        logger.info("开始孵化企业-更新在孵企业（团队）政策申报项方法");
        TbHatchIncubatorEnterpriseAndTeamCriteria criteria = new TbHatchIncubatorEnterpriseAndTeamCriteria();
        criteria.createCriteria().andGraduateStatusEqualTo(HatchStatusEnums.HATCH_GRADUATE_STATUS_3.getCode());
        List<TbHatchIncubatorEnterpriseAndTeam> tbHatchIncubatorEnterpriseAndTeams = tbHatchIncubatorEnterpriseAndTeamMapper.selectByExample(criteria);
        logger.info("进入孵化企业-更新在孵企业（团队）政策申报项方法，查询满足条件的在孵企业结果【{}】",JsonUtil.object2Json(tbHatchIncubatorEnterpriseAndTeams));
        if(tbHatchIncubatorEnterpriseAndTeams.size() > 0){
            for (TbHatchIncubatorEnterpriseAndTeam tb: tbHatchIncubatorEnterpriseAndTeams) {
                if(StringUtils.isNotBlank(tb.getId())) {
                    /**2.通过企业统一去查询政策申报项*/
                    PersonnelProject param = new PersonnelProject();
                    /**2.暂使用企业统一信用编码去查询*/
                    param.setCreditCode(tb.getCreditCode());
                    logger.info("进入孵化企业-更新在孵企业（团队）政策申报项方法，调用查询人才申报的接口入參【{}】",JsonUtil.object2Json(param));
                    Result<List<PersonnelProject>> listResult = personnelClient.selectByPersonnelProjectList(param);
                    logger.info("进入孵化企业-更新在孵企业（团队）政策申报项方法，调用查询人才申报的接口返回参数【{}】",JsonUtil.object2Json(listResult));
                    if(listResult.getData().size() > 0){
                        /**3.更新表数据，记录企业参加了人才申报政策项*/
                        tb.setPolicyDeclarat("申报人才企业");
                        logger.info("进入孵化企业-更新在孵企业（团队）政策申报项方法，更新数据入參【{}】",JsonUtil.object2Json(tb));
                        tbHatchIncubatorEnterpriseAndTeamMapper.updateByPrimaryKeySelective(tb);
                    }
                }
            }
        }
        logger.info("结束孵化企业-更新在孵企业（团队）政策申报项方法");
        return new Result("更新在孵企业（团队）政策申报项成功！");
    }
}
