package com.jn.park.finance.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.finance.dao.FinanceBudgetMapper;
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
import com.jn.system.log.annotation.ServiceLog;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 16:35
 * @version： v1.0
 * @modified By:
 */
@Service
public class FinanceBudgetServiceImpl implements FinanceBudgetService {
    private static Logger logger = LoggerFactory.getLogger(FinanceBudgetServiceImpl.class);

    @Autowired
    private TbFinanceBudgetHistoryMapper tbFinanceBudgetHistoryMapper;
    @Autowired
    private TbFinanceTotalBudgetMapper tbFinanceTotalBudgetMapper;
    @Autowired
    private FinanceBudgetMapper financeBudgetMapper;

    @ServiceLog(doAction = "总预算查询")
    @Override
    public Result totalList(FinanceBudgetQueryModel financeBudgetQueryModel, String userAccount) {
        return null;
    }

    @ServiceLog(doAction = "预算录入历史查询")
    @Override
    public PaginationData<List<FinanceBudgetHistoryVo>> historyList(FinanceBudgetHistoryQueryModel financeBudgetHistoryQueryModel, String userAccount) {
        TbFinanceBudgetHistoryExample example=new TbFinanceBudgetHistoryExample();
        TbFinanceBudgetHistoryExample.Criteria criteria=example.createCriteria();
        //费用类型查询条件
        if(null!= financeBudgetHistoryQueryModel.getCostTypeId()){
            criteria.andCostTypeIdEqualTo(financeBudgetHistoryQueryModel.getCostTypeId());
        }
        //部门查询条件
        if(null!= financeBudgetHistoryQueryModel.getDepartmentId()){
            criteria.andDepartmentIdEqualTo(financeBudgetHistoryQueryModel.getDepartmentId());
        }
        //录入类型查询条件
        if(null!= financeBudgetHistoryQueryModel.getBudgetType()){
            criteria.andBudgetTypeEqualTo(financeBudgetHistoryQueryModel.getBudgetType());
        }
        //数据月份-开始
        if(null!= financeBudgetHistoryQueryModel.getStartMonth()){
            criteria.andBudgetMonthGreaterThanOrEqualTo(financeBudgetHistoryQueryModel.getStartMonth());
        }
        //数据月份-结束
        if(null!= financeBudgetHistoryQueryModel.getEndMonth()){
            criteria.andBudgetMonthLessThanOrEqualTo(financeBudgetHistoryQueryModel.getEndMonth());
        }
        //过滤已删除的数据
        criteria.andRecordStatusEqualTo(new Byte("1"));
        //设置排序条件
        if(StringUtils.isNotBlank(financeBudgetHistoryQueryModel.getOrderByClause())){
            example.setOrderByClause(financeBudgetHistoryQueryModel.getOrderByClause());
        }else{
            //默认排序
            example.setOrderByClause("created_time desc");
        }

        Page<FinanceBudgetHistoryVo> page=PageHelper.startPage(financeBudgetHistoryQueryModel.getPage(), financeBudgetHistoryQueryModel.getRows());
        List<TbFinanceBudgetHistory>list= tbFinanceBudgetHistoryMapper.selectByExample(example);
        List<FinanceBudgetHistoryVo>voList=new ArrayList<>();
        for (TbFinanceBudgetHistory history:list){
            FinanceBudgetHistoryVo vo=new FinanceBudgetHistoryVo();
            BeanUtils.copyProperties(history,vo);
            voList.add(vo);
        }
        PaginationData<List<FinanceBudgetHistoryVo>>paginationData=new PaginationData<List<FinanceBudgetHistoryVo>>(voList,page.getTotal());
        return paginationData;
    }

    @ServiceLog(doAction = "预算录入")
    @Override
    public Result add(FinanceBudgetHistoryVo financeBudgetHistoryVo, String userAccount) {
        this.checkBudgetType0(financeBudgetHistoryVo.getDepartmentId(),financeBudgetHistoryVo.getCostTypeId(),financeBudgetHistoryVo.getCostTypeName(),financeBudgetHistoryVo.getBudgetMoneyModels());

        for(FinanceBudgetMoneyModel moneyModel:financeBudgetHistoryVo.getBudgetMoneyModels()){
            TbFinanceBudgetHistory tbFinanceBudgetHistory=new TbFinanceBudgetHistory();
            BeanUtils.copyProperties(financeBudgetHistoryVo,tbFinanceBudgetHistory);
            tbFinanceBudgetHistory.setBudgetMonth(moneyModel.getMonth());
            tbFinanceBudgetHistory.setBudgetMoney(moneyModel.getMoney());
            tbFinanceBudgetHistory.setCreatedTime(new Date());
            tbFinanceBudgetHistory.setCreatorAccount(userAccount);
            //1、导入预算历史表
            tbFinanceBudgetHistoryMapper.insertSelective(tbFinanceBudgetHistory);
            //2、更新总预算表数据
            this.updateTotal(financeBudgetHistoryVo.getCostTypeId(),financeBudgetHistoryVo.getCostTypeName(),financeBudgetHistoryVo.getDepartmentId(),financeBudgetHistoryVo.getDepartmentName(),moneyModel.getMonth(),userAccount);
        }
        return new Result();
    }

    //是否已经导入过年初预算了
    private void checkBudgetType0(String departmentId,Integer costTypeId,String costTypeName,List<FinanceBudgetMoneyModel> financeBudgetMoneyModelList){
        TbFinanceBudgetHistoryExample historyExample=new TbFinanceBudgetHistoryExample();
        TbFinanceBudgetHistoryExample.Criteria historyExampleCriteria=historyExample.createCriteria();
        historyExampleCriteria.andRecordStatusEqualTo(new Byte("1"));
        historyExampleCriteria.andBudgetTypeEqualTo(new Byte("0"));
        historyExampleCriteria.andCostTypeIdEqualTo(costTypeId);
        historyExampleCriteria.andDepartmentIdEqualTo(departmentId);
        List<String>monthList=new ArrayList<>();
        for(FinanceBudgetMoneyModel moneyModel:financeBudgetMoneyModelList){
            monthList.add(moneyModel.getMonth());
        }
        historyExampleCriteria.andBudgetMonthIn(monthList);
        List<TbFinanceBudgetHistory> historyList=tbFinanceBudgetHistoryMapper.selectByExample(historyExample);
        if(null!=historyList&&historyList.size()>0){

            String[] years=new String[historyList.size()];
            StringBuffer msg=new StringBuffer();
            msg.append("【年初预算】只能录入一次，你已经录入过【").append(StringUtils.join(years,",")).append("】的【").append(costTypeName).append("】预算了，不能再录入。");
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
        FinanceBudgetHistoryModel historyModel=financeBudgetMapper.calcHistoryMoney(departmentId,costTypeId,budgetMonth);
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
