package com.jn.park.finance.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.park.finance.dao.FinanceIncomeDao;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.model.FinanceIncomeLastYearContrastModel;
import com.jn.park.finance.service.FinanceIncomeService;
import com.jn.park.finance.vo.*;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 监控首页
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
@Service
@Transactional
public class FinanceIncomeServiceImpl implements FinanceIncomeService {
    @Autowired
    private FinanceIncomeDao financeIncomeDao;

    @ServiceLog(doAction = "明细,同期对比")
    @Override
    public List<FinanceIncomePeriodVo> periodContrast(String startTime, String endTime) {
        return financeIncomeDao.periodContrast(startTime,endTime);
    }

    @ServiceLog(doAction = "汇总占比")
    @Override
    public List<FinanceIncomeSummarizingProportionVo> summarizingProportion(String startTime, String endTime) {
        return financeIncomeDao.summarizingProportion(startTime,endTime);
    }

    @ServiceLog(doAction = "往年对比")
    @Override
    public FianceDynamicTableVo<List<FinanceIncomeLastYearContrastVo>> lastYearContrast(String startTime, String endTime) {
        //return financeIncomeDao.lastYearContrast(startTime,endTime);
        List<FinanceIncomeLastYearContrastVo> listFianceDynamicTableVo=financeIncomeDao.lastYearContrast(startTime,endTime);

        if(null==listFianceDynamicTableVo||listFianceDynamicTableVo.size()<1){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"无数据");
        }
        FianceDynamicTableVo<List<FinanceIncomeLastYearContrastVo>> vo=new FianceDynamicTableVo<>();
        List<String>dynamicHeadList=new ArrayList<>();
        listFianceDynamicTableVo.get(0).getFinanceIncomeLastYearContrastModels().stream().forEach(e->{
            //String yyyy=e.getMonth().substring(0,4);
            String mm=e.getMonth();
            dynamicHeadList.add(String.format("%s月",mm));
        });
        vo.setDynamicHeadList(dynamicHeadList);
        vo.setRows(listFianceDynamicTableVo);
        return vo;
    }

    @Override
    public List<FinanceIncomeExportContrastVo> exportContrast(String year) {
        String startTime=year+"01";
        String endTime=year+"12";

        //返回就过
        List<FinanceIncomeExportContrastVo> financeIncomeExportContrastVos=new ArrayList<>();
        //得到查询结果
        List<FinanceIncomeLastYearContrastVo> filycv=financeIncomeDao.lastYearContrast(startTime,endTime);
        //获取名称,遍历复制
        for (int i=0;i<filycv.size();i++){
            FinanceIncomeExportContrastVo fecv=new FinanceIncomeExportContrastVo();
            //设置收入类型
            fecv.setIncomeTypeName(filycv.get(i).getIncomeTypeName());
            List<FinanceIncomeLastYearContrastModel> filycm=filycv.get(i).getFinanceIncomeLastYearContrastModels();
            if(filycm.size() != 0){
                fecv.setIncome1(filycm.get(0).getIncome()); fecv.setLastYearIncome1(filycm.get(0).getLastYearIncome());
                fecv.setIncome2(filycm.get(1).getIncome()); fecv.setLastYearIncome2(filycm.get(1).getLastYearIncome());
                fecv.setIncome3(filycm.get(2).getIncome()); fecv.setLastYearIncome3(filycm.get(2).getLastYearIncome());
                fecv.setIncome4(filycm.get(3).getIncome()); fecv.setLastYearIncome4(filycm.get(3).getLastYearIncome());
                fecv.setIncome5(filycm.get(4).getIncome()); fecv.setLastYearIncome5(filycm.get(4).getLastYearIncome());
                fecv.setIncome6(filycm.get(5).getIncome()); fecv.setLastYearIncome6(filycm.get(5).getLastYearIncome());
                fecv.setIncome7(filycm.get(6).getIncome()); fecv.setLastYearIncome7(filycm.get(6).getLastYearIncome());
                fecv.setIncome8(filycm.get(7).getIncome()); fecv.setLastYearIncome8(filycm.get(7).getLastYearIncome());
                fecv.setIncome9(filycm.get(8).getIncome()); fecv.setLastYearIncome9(filycm.get(8).getLastYearIncome());
                fecv.setIncome10(filycm.get(9).getIncome()); fecv.setLastYearIncome10(filycm.get(9).getLastYearIncome());
                fecv.setIncome11(filycm.get(10).getIncome()); fecv.setLastYearIncome11(filycm.get(10).getLastYearIncome());
                fecv.setIncome12(filycm.get(11).getIncome()); fecv.setLastYearIncome12(filycm.get(11).getLastYearIncome());
            }
            financeIncomeExportContrastVos.add(fecv);
        }


        return financeIncomeExportContrastVos;
    }
}
