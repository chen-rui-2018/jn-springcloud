package com.jn.enterprise.technologyfinancial.investors.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.InvestorExceptionEnum;
import com.jn.enterprise.technologyfinancial.investors.dao.InvestorManagementMapper;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListShow;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorManagementService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 科技金融管理投资人管理
 * @Author: yangph
 * @Date: 2019/3/21 15:27
 * @Version v1.0
 * @modified By:
 */
@Service
public class InvestorManagementServiceImpl implements InvestorManagementService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(InvestorManagementServiceImpl.class);

    @Autowired
    private InvestorManagementMapper investorManagementMapper;

    /**
     * 投资人管理列表查询
     * @param investorManagementListParam 投资人管理列表查询入参
     * @return
     */
    @ServiceLog(doAction = "投资人管理列表查询")
    @Override
    public PaginationData getInvestorManagementList(InvestorManagementListParam investorManagementListParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if (StringUtils.isBlank(investorManagementListParam.getNeedPage())) {
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<InvestorManagementListShow> investorManagementList = investorManagementMapper.getInvestorManagementList(investorManagementListParam);
            return new PaginationData(investorManagementList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(investorManagementListParam.getNeedPage())){
            objects = PageHelper.startPage(investorManagementListParam.getPage(),
                    investorManagementListParam.getRows() == 0 ? 15 : investorManagementListParam.getRows(), true);
        }
        if(StringUtils.isNotBlank(investorManagementListParam.getApplyStartTime())
                && StringUtils.isNotBlank(investorManagementListParam.getApplyEndTime())){
            int startTime= Integer.parseInt(investorManagementListParam.getApplyStartTime());
            int endTime= Integer.parseInt(investorManagementListParam.getApplyEndTime());
            if(startTime>endTime){
                logger.warn("投资人管理列表查询的投资日期开始时间晚于投资日期结束时间");
                throw new JnSpringCloudException(InvestorExceptionEnum.START_TIME_MORE_THAN_END_TIME);
            }
        }
        List<InvestorManagementListShow> investorManagementList = investorManagementMapper.getInvestorManagementList(investorManagementListParam);
        return new PaginationData(investorManagementList, objects == null ? 0 : objects.getTotal());
    }
}
