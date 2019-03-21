package com.jn.enterprise.technologyfinancial.investors.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.technologyfinancial.investors.dao.InvestorMapper;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorInfoListParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorInfoShow;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 投资人列表查询
     * @param investorInfoListParam  投资人列表查询入参
     * @return
     */
    @ServiceLog(doAction = "投资人列表查询")
    @Override
    public PaginationData getInvestorInfoList(InvestorInfoListParam investorInfoListParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(investorInfoListParam==null){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<InvestorInfoShow> investorInfoList = investorMapper.getInvestorInfoList(investorInfoListParam.getMainCode(), investorInfoListParam.getKeyWords());
            return new PaginationData(investorInfoList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(investorInfoListParam.getNeedPage())){
            objects = PageHelper.startPage(investorInfoListParam.getPage(),
                    investorInfoListParam.getRows() == 0 ? 15 : investorInfoListParam.getRows(), true);
        }
        List<InvestorInfoShow> investorInfoList = investorMapper.getInvestorInfoList(investorInfoListParam.getMainCode(), investorInfoListParam.getKeyWords());
        return new PaginationData(investorInfoList, objects == null ? 0 : objects.getTotal());
    }
}
