package com.jn.park.finance.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.park.finance.dao.FinanceBudgetDao;
import com.jn.park.finance.dao.TbFinanceBudgetHistoryMapper;
import com.jn.park.finance.dao.TbFinanceTotalBudgetMapper;
import com.jn.park.finance.entity.TbFinanceBudgetHistory;
import com.jn.park.finance.entity.TbFinanceBudgetHistoryExample;
import com.jn.park.finance.entity.TbFinanceTotalBudget;
import com.jn.park.finance.entity.TbFinanceTotalBudgetExample;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.model.FinanceBudgetHistoryModel;
import com.jn.park.finance.model.FinanceBudgetHistoryQueryModel;
import com.jn.park.finance.model.FinanceBudgetMoneyModel;
import com.jn.park.finance.model.FinanceBudgetQueryModel;
import com.jn.park.finance.service.FinanceBudgetService;
import com.jn.park.finance.vo.FinanceBudgetHistoryVo;
import com.jn.park.finance.vo.FinanceTotalBudgetVo;
import com.jn.system.log.annotation.ServiceLog;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 16:35
 * @version： v1.0
 * @modified By:
 */
@Service
@Transactional
public class FinanceBudgetServiceImpl implements FinanceBudgetService {
    private static Logger logger = LoggerFactory.getLogger(FinanceBudgetServiceImpl.class);

    @Autowired
    private TbFinanceBudgetHistoryMapper tbFinanceBudgetHistoryMapper;
    @Autowired
    private TbFinanceTotalBudgetMapper tbFinanceTotalBudgetMapper;
    @Autowired
    private FinanceBudgetDao financeBudgetDao;

    @ServiceLog(doAction = "总预算查询")
    @Override
    public List<FinanceTotalBudgetVo> selectTotalBudget(FinanceBudgetQueryModel financeBudgetQueryModel, String userAccount) {
        List<FinanceTotalBudgetVo> financeTotalBudgetVoList=financeBudgetDao.selectTotalBudget(financeBudgetQueryModel);
        return financeTotalBudgetVoList;
    }

    @ServiceLog(doAction = "预算录入历史查询")
    @Override
    public List<FinanceBudgetHistoryVo> selectBudgetHistory(FinanceBudgetHistoryQueryModel financeBudgetHistoryQueryModel, String userAccount) {
        return financeBudgetDao.selectBudgetHistory(financeBudgetHistoryQueryModel);
    }

    @ServiceLog(doAction = "预算录入")
    @Override
    public Result add(FinanceBudgetHistoryVo financeBudgetHistoryVo, String userAccount) {

        int insertCount=0;
        for(FinanceBudgetMoneyModel moneyModel:financeBudgetHistoryVo.getBudgetMoneyModels()){
            //1、校验 是否已经录入过初年预算了

            if((new Byte("0")).equals(financeBudgetHistoryVo.getBudgetType())){
                this.checkBudgetType0(financeBudgetHistoryVo.getDepartmentId(),financeBudgetHistoryVo.getCostTypeId(),financeBudgetHistoryVo.getCostTypeName(),moneyModel.getMonth());
            }

            //2、保存到历史表
            TbFinanceBudgetHistory tbFinanceBudgetHistory=new TbFinanceBudgetHistory();
            BeanUtils.copyProperties(financeBudgetHistoryVo,tbFinanceBudgetHistory);
            tbFinanceBudgetHistory.setBudgetMonth(moneyModel.getMonth());
            tbFinanceBudgetHistory.setBudgetMoney(moneyModel.getMoney());
            tbFinanceBudgetHistory.setCreatedTime(new Date());
            tbFinanceBudgetHistory.setCreatorAccount(userAccount);
            tbFinanceBudgetHistoryMapper.insertSelective(tbFinanceBudgetHistory);
            insertCount++;

            //3、更新总预算表数据
            this.updateTotal(financeBudgetHistoryVo.getCostTypeId(),financeBudgetHistoryVo.getCostTypeName(),financeBudgetHistoryVo.getDepartmentId(),financeBudgetHistoryVo.getDepartmentName(),moneyModel.getMonth(),userAccount);
        }
        return new Result(String.format("成功录入【%s】条数据",insertCount));
    }

    //是否已经导入过年初预算了
    private void checkBudgetType0(String departmentId,Integer costTypeId,String costTypeName,String budgetMonth ){
        TbFinanceBudgetHistoryExample historyExample=new TbFinanceBudgetHistoryExample();
        TbFinanceBudgetHistoryExample.Criteria historyExampleCriteria=historyExample.createCriteria();
        historyExampleCriteria.andRecordStatusEqualTo(new Byte("1"));
        historyExampleCriteria.andBudgetTypeEqualTo(new Byte("0"));
        historyExampleCriteria.andCostTypeIdEqualTo(costTypeId);
        historyExampleCriteria.andDepartmentIdEqualTo(departmentId);
        historyExampleCriteria.andBudgetMonthEqualTo(budgetMonth);
        List<TbFinanceBudgetHistory> historyList=tbFinanceBudgetHistoryMapper.selectByExample(historyExample);
        if(null!=historyList&&historyList.size()>0){

            String[] years=new String[historyList.size()];
            for(int i=0;i<historyList.size();i++){
                years[i]=historyList.get(i).getBudgetMonth();
            }
            StringBuffer msg=new StringBuffer();
            msg.append("【年初预算】只能录入一次，你已经录入过【").append(StringUtils.join(years,",")).append("】的【").append(costTypeName).append("】年初预算了，不能再录入。");
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,msg.toString());
        }


    }

    private TbFinanceTotalBudget selectByPrimaryKey(Integer costTypeId,String departmentId,String budgetMonth){
        TbFinanceTotalBudgetExample totalBudgetExample=new TbFinanceTotalBudgetExample();
        TbFinanceTotalBudgetExample.Criteria totalBudgetExampleCriteria=totalBudgetExample.createCriteria();
        totalBudgetExampleCriteria.andRecordStatusEqualTo(new Byte("1"));
        totalBudgetExampleCriteria.andCostTypeIdEqualTo(costTypeId);
        totalBudgetExampleCriteria.andDepartmentIdEqualTo(departmentId);
        totalBudgetExampleCriteria.andBudgetMonthEqualTo(budgetMonth);
        List<TbFinanceTotalBudget> totalBudgetList=tbFinanceTotalBudgetMapper.selectByExample(totalBudgetExample);
        if(null==totalBudgetList){
            return null;
        }else if(totalBudgetList.size()==1){
            return totalBudgetList.get(0);
        }
        return null;
    }

    private void updateTotal(Integer costTypeId, String costTypeName, String departmentId, String departmentName,String budgetMonth, String userAccount){
        //查询预算历史中的总预算（按月统计）
        FinanceBudgetHistoryModel historyModel= financeBudgetDao.calcHistoryMoney(departmentId,costTypeId,budgetMonth);
        //
        TbFinanceTotalBudget tbFinanceTotalBudget= this.selectByPrimaryKey(costTypeId,departmentId,budgetMonth);
        if(null!=tbFinanceTotalBudget){
            tbFinanceTotalBudget.setModifiedTime(new Date());
            tbFinanceTotalBudget.setModifierAccount(userAccount);
            tbFinanceTotalBudget.setBudgetMonth(historyModel.getBudgetMonth());
            tbFinanceTotalBudget.setBudgetNumber(historyModel.getBudgetMoney());
            tbFinanceTotalBudgetMapper.updateByPrimaryKeySelective(tbFinanceTotalBudget);
        }else{
            tbFinanceTotalBudget=new TbFinanceTotalBudget();
            tbFinanceTotalBudget.setDepartmentId(departmentId);
            tbFinanceTotalBudget.setDepartmentName(departmentName);
            tbFinanceTotalBudget.setCostTypeId(costTypeId);
            tbFinanceTotalBudget.setCostTypeName(costTypeName);
            tbFinanceTotalBudget.setBudgetMonth(historyModel.getBudgetMonth());
            tbFinanceTotalBudget.setBudgetNumber(historyModel.getBudgetMoney());
            tbFinanceTotalBudget.setCreatorAccount(userAccount);
            tbFinanceTotalBudget.setCreatedTime(new Date());
            tbFinanceTotalBudgetMapper.insertSelective(tbFinanceTotalBudget);
        }

    }


}
