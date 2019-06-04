package com.jn.park.hatch.service.impl;

import com.jn.common.model.Result;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.api.DataReportClient;
import com.jn.enterprise.model.DataTargetModel;
import com.jn.enterprise.model.LoadCompanyDataTargetReq;
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
import org.xxpay.common.util.JsonUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    @Override
    @ServiceLog(doAction = "孵化企业-更新企业税收-营收-投资额")
    public Result updateRevenue(HatchUpdateRevenueParamModel hatchUpdateRevenueParamModel) {
        TbHatchIncubatorEnterpriseAndTeam tbHatch = tbHatchIncubatorEnterpriseAndTeamMapper.selectByPrimaryKey(hatchUpdateRevenueParamModel.getEntAndTeamId());
        logger.info("查询企业信息返回数据【{}】",JsonUtil.object2Json(tbHatch));
        /** 1.判断该企业是否在孵化企业当中*/
        if(ObjectUtils.isNotEmpty(tbHatch)){
             /** TODO 2.通过企业id，指标id，账期等条件调用查询数据上报接口*/
            LoadCompanyDataTargetReq loadReq = new LoadCompanyDataTargetReq();
            String [] str = new String[]{HatchStatusEnums.HATCH_TARGET_TAX_REVENUE.getCode(),HatchStatusEnums.HATCH_TARGET_REVENUE.getCode(),HatchStatusEnums.HATCH_TARGET_INVESTMENT_AMOUNT.getCode()};
            loadReq.setEnterpriseId(tbHatch.getId());
            loadReq.setTargetIds(str);
           Result<List<DataTargetModel>> listResult = dataReportClient.loadCompanyDataTarget(loadReq);
            if(listResult.getData().size() > 0){
                BigDecimal str1 = new BigDecimal(0);
                BigDecimal str2 = new BigDecimal(0);
                BigDecimal str3 = new BigDecimal(0);
                for (int i = 0; i < listResult.getData().size(); i++) {
                    if(listResult.getData().get(i).getTargetId().equals(HatchStatusEnums.HATCH_TARGET_TAX_REVENUE.getCode())){
                        if(StringUtils.isNotBlank(listResult.getData().get(i).getTargetData())){
                            str1 = str1.add(new BigDecimal(listResult.getData().get(i).getTargetData()));
                        }
                    }else if(listResult.getData().get(i).getTargetId().equals(HatchStatusEnums.HATCH_TARGET_REVENUE.getCode())){
                        if(StringUtils.isNotBlank(listResult.getData().get(i).getTargetData())){
                            str2 = str2.add(new BigDecimal(listResult.getData().get(i).getTargetData()));
                        }
                    }else if(listResult.getData().get(i).getTargetId().equals(HatchStatusEnums.HATCH_TARGET_INVESTMENT_AMOUNT.getCode())){
                        if(StringUtils.isNotBlank(listResult.getData().get(i).getTargetData())){
                            str3 = str3.add(new BigDecimal(listResult.getData().get(i).getTargetData()));
                        }
                    }
                }
                tbHatch.setTaxValue(str1);
                tbHatch.setRevenueValue(str2);
                tbHatch.setFinancValue(str3);
                /** 3.根据查询接口返回的明细汇总该指标数据，并更新到在孵企业（团队）管理表*/
                tbHatchIncubatorEnterpriseAndTeamMapper.updateByPrimaryKeySelective(tbHatch);
            }
        }
        return new Result();
    }

    @Override
    @ServiceLog(doAction = "孵化企业-更新在孵企业（团队）毕业条件【满足 企业注册时间超过6年】")
    public Result updateGraduateegister() {
        /**1.先查询在孵企业（团队）管理表在孵企业信息*/
        TbHatchIncubatorEnterpriseAndTeamCriteria criteria = new TbHatchIncubatorEnterpriseAndTeamCriteria();
        criteria.createCriteria().andGraduateStatusEqualTo(HatchStatusEnums.HATCH_GRADUATE_STATUS_3.getCode());
        List<TbHatchIncubatorEnterpriseAndTeam> tbHatchIncubatorEnterpriseAndTeams = tbHatchIncubatorEnterpriseAndTeamMapper.selectByExample(criteria);
        if(tbHatchIncubatorEnterpriseAndTeams.size() > 0){
            for (TbHatchIncubatorEnterpriseAndTeam tb: tbHatchIncubatorEnterpriseAndTeams) {
                if(StringUtils.isNotBlank(tb.getId())){
                    Result<ServiceCompany> serviceCompany =  companyClient.getCompanyDetailByAccountOrCompanyId(tb.getId());
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
                        /**2.通过孵化表里的企业id去查询企业表成立时间，满足即更新毕业条件状态*/
                        /**表示date晚于date2*/
                        if(date.after(date2)){
                            tb.setGraduateStatus(HatchStatusEnums.HATCH_GRADUATE_STATUS_1.getCode());
                            tb.setGraduateRequirements(HatchStatusEnums.HATCH_GRADUATE_COND_1.getCode());
                            tbHatchIncubatorEnterpriseAndTeamMapper.updateByPrimaryKeySelective(tb);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return new Result();
    }

    @Override
    @ServiceLog(doAction = "孵化企业-更新在孵企业（团队）毕业条件【满足 连续两年营收额达到500万】")
    public Result updateGraduateRevenue() {
        /**1.先查询在孵企业（团队）管理表在孵企业信息*/
        TbHatchIncubatorEnterpriseAndTeamCriteria criteria = new TbHatchIncubatorEnterpriseAndTeamCriteria();
        criteria.createCriteria().andGraduateStatusEqualTo(HatchStatusEnums.HATCH_GRADUATE_STATUS_3.getCode());
        List<TbHatchIncubatorEnterpriseAndTeam> tbHatchIncubatorEnterpriseAndTeams = tbHatchIncubatorEnterpriseAndTeamMapper.selectByExample(criteria);
        if(tbHatchIncubatorEnterpriseAndTeams.size() > 0){
            for (TbHatchIncubatorEnterpriseAndTeam tb: tbHatchIncubatorEnterpriseAndTeams) {
                if(StringUtils.isNotBlank(tb.getId())) {
                    Result<Boolean> booleanResult =  dataReportClient.loadCompanyByRevenue(tb.getId());
                    if(booleanResult.getData()){
                        /**2.通过孵化表里的企业id去查询企业表成立时间，满足即更新毕业条件状态*/
                            tb.setGraduateStatus(HatchStatusEnums.HATCH_GRADUATE_STATUS_1.getCode());
                            tb.setGraduateRequirements(HatchStatusEnums.HATCH_GRADUATE_COND_2.getCode());
                            tbHatchIncubatorEnterpriseAndTeamMapper.updateByPrimaryKeySelective(tb);
                    }
                }
            }
        }
        return new Result();
    }
}
