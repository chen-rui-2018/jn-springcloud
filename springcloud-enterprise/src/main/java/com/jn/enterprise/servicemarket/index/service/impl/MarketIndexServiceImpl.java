package com.jn.enterprise.servicemarket.index.service.impl;

import com.jn.common.model.Result;
import com.jn.enterprise.company.dao.TbServiceCompanyMapper;
import com.jn.enterprise.company.entity.TbServiceCompanyCriteria;
import com.jn.enterprise.company.enums.CompanyDataEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceAdvisorMapper;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisorCriteria;
import com.jn.enterprise.servicemarket.index.service.MarketIndexService;
import com.jn.enterprise.servicemarket.index.vo.DataStatisticsVO;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import com.jn.park.api.ActivityClient;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： huxw
 * @date： Created on 2019-6-10 16:01:35
 * @version： v1.0
 * @modified By:
 */
@Service
public class MarketIndexServiceImpl implements MarketIndexService {

    @Autowired
    private TbServiceCompanyMapper tbServiceCompanyMapper;

    @Autowired
    private TbServiceAdvisorMapper tbServiceAdvisorMapper;

    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;

    @Autowired
    private ActivityClient activityClient;

    private static Logger logger = LoggerFactory.getLogger(MarketIndexServiceImpl.class);

    @Override
    @ServiceLog(doAction = "获取企业，机构，活动，服务专员数量")
    public DataStatisticsVO getDataStatistics() {
        DataStatisticsVO dataStatistics = new DataStatisticsVO();
        dataStatistics.setComNum(getCompanyNum());
        dataStatistics.setOrgNum(getOrgNum());
        dataStatistics.setAdvisorNum(getAdvisorNum());

        Result<Integer> activityResult = activityClient.getActivityHistoryNum();
        if (activityResult != null && activityResult.getData() != null) {
            dataStatistics.setActivityNum(activityResult.getData().toString());
        }
        logger.info("[服务超市-数据统计] {}", dataStatistics.toString());
        return dataStatistics;
    }

    /**
     * 获取入驻企业数
     * @return
     */
    private String getCompanyNum() {
        TbServiceCompanyCriteria example = new TbServiceCompanyCriteria();
        example.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andCheckStatusEqualTo(CompanyDataEnum.COMPANY_CHECK_STATUS_PASS.getCode());
        long l = tbServiceCompanyMapper.countByExample(example);
        return l + "";
    }

    /**
     * 获取服务超市入驻机构数
     * @return
     */
    private String getOrgNum() {
        TbServiceOrgCriteria example = new TbServiceOrgCriteria();
        example.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andOrgStatusEqualTo(CompanyDataEnum.ORG_APPROVAL_STATUS.getCode())
                .andBusinessTypeNotEqualTo("technology_finance");
        long l = tbServiceOrgMapper.countByExample(example);
        return l + "";
    }

    /**
     * 获取服务专员数
     * @return
     */
    private String getAdvisorNum() {
        TbServiceAdvisorCriteria example = new TbServiceAdvisorCriteria();
        example.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andApprovalStatusEqualTo(CompanyDataEnum.ADVISOR_APPROVAL_STATUS.getCode());
        long l = tbServiceAdvisorMapper.countByExample(example);
        return l + "";
    }

}
