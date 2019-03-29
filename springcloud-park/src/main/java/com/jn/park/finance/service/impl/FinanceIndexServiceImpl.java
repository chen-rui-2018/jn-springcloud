package com.jn.park.finance.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.park.finance.dao.FinanceIndexDao;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.enums.FinanceExceptionEnums;
import com.jn.park.finance.model.*;
import com.jn.park.finance.service.FinanceIndexService;
import com.jn.park.finance.vo.*;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 监控首页
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@Service
@Transactional
public class FinanceIndexServiceImpl implements FinanceIndexService {
    private static Logger logger = LoggerFactory.getLogger(FinanceIndexServiceImpl.class);


    @Autowired
    private FinanceIndexDao financeIndexDao;

    @Autowired
    private SystemClient systemClient;

    @ServiceLog(doAction = "管委会支出/预算占比")
    @Override
    public FinanceIndexVo ratioAndState(String year) {
        ////先拼接时间 因为这个页面的时间格式是年份 ，SQL语句是有时间区间的，默认查全年的
        String begin=year+"01";
        String end=year+"12";

        FinanceIndexRatioStateModel financeIndexRatioStateModel=new FinanceIndexRatioStateModel();
        //设置起止时间
        financeIndexRatioStateModel.setBeginTime(begin);
        financeIndexRatioStateModel.setEndTime(end);
        //获取占比
        String ratioAndState= financeIndexDao.ratioAndState(financeIndexRatioStateModel);
        //设置返回对象
        FinanceIndexVo financeIndexVo=new FinanceIndexVo();
        if(ratioAndState != null){
            //设置状态
            String state="正常";
            int ratio=Integer.parseInt(ratioAndState);
            //判断是否正常
            int j=100;
            if(ratio>j){
                state="异常";
            }
            //拼接%号 没有选择在SQL中直接拼接%，因为这个对比判断有%不好比较，选择在比较之后再拼接
            String ratioAndState1=ratioAndState+"%";
            financeIndexVo.setRatio(ratioAndState1);
            financeIndexVo.setState(state);
        }else{
            financeIndexVo.setRatio("该年份暂无数据");
            financeIndexVo.setState("异常");
        }
        return financeIndexVo;
    }


    @ServiceLog(doAction = "首页-各部门预算支出占比模块")
    @Override
    public List<FinanceIndexBudgetExpendRatioVo> budgetExpendRatio(String year) {
        ////先拼接时间 因为这个页面的时间格式是年份 ，SQL语句是有时间区间的，默认查全年的
        String begin=year+"01";
        String end=year+"12";
        //查询所有的根节点 不传部门ID，childflag为false表示不查询下面的子节点
        Result result = systemClient.selectDeptByParentId(null, false);
        //定义变量接受根节点ID
        String rootDepartmentId=null;
        //返回的是一个封装的result，获取到里面的date
        List<Map<String,Object>> data = (List<Map<String,Object>>) result.getData();
        //遍历，获取到ID
        for(Map<String,Object> map:data){
            if(String.valueOf(map.get("departmentName")).indexOf("科创")>-1){
                rootDepartmentId=String.valueOf(map.get("id"));
                break;
            }
        }
        //判断是否拿到了根节点ID
        if(null==rootDepartmentId){
            throw new JnSpringCloudException(FinanceExceptionEnums.UN_KNOW,"获取根节点失败");
        }
        //再通过拿到的根节点作为条件再调用一次，childflag为true时表示查询它下面的所有子节点（下一级）
        Result firstLevelResult = systemClient.selectDeptByParentId(rootDepartmentId, true);
        Map<String,Object> data1 = (Map<String,Object>) firstLevelResult.getData();
        List<Map<String,Object>> data2 = (List<Map<String,Object>>) data1.get("children");
        int k=data2.size();
        Map<String,Object> map =new HashMap<>();
        List<FinanceExpensesDepartmentModel> financeExpensesDepartmentModels =new ArrayList<>();
        //遍历获取到里面所有的部门ID及部门名称
        for (int i=0;i<k;i++){
            FinanceExpensesDepartmentModel fedm=new FinanceExpensesDepartmentModel();
            fedm.setDepartmentId(data2.get(i).get("id").toString());
            fedm.setDepartmentName(data2.get(i).get("departmentName").toString());
            //将时间塞进去
            fedm.setStartTime(begin);
            fedm.setEndTime(end);
            financeExpensesDepartmentModels.add(fedm);
        }
        map.put("startTime",begin);
        map.put("endTime",end);
        map.put("list", financeExpensesDepartmentModels);
        //查询所有部门的支出占比
        List<FinanceIndexBudgetExpendRatioVo> budgetExpendRatio=financeIndexDao.budgetExpendRatio(map);


        return budgetExpendRatio;
    }

    @ServiceLog(doAction = "全年支出/预算 统计柱状图")
    @Override
    public FianceDynamicTableVo<List<FinanceIndexExpendBudgetStatisticsVo>>  expendBudget(String year) {
        //拼接年月
        String startTime=year+"01";
        String endTime=year+"12";

        List<FinanceIndexExpendBudgetStatisticsVo> expendBudgetList=financeIndexDao.expendBudget(startTime,endTime);

        if(null==expendBudgetList||expendBudgetList.size()<1){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"无数据");
        }
        FianceDynamicTableVo<List<FinanceIndexExpendBudgetStatisticsVo>> vo1=new FianceDynamicTableVo<>();
        List<String>dynamicHeadList=new ArrayList<>();
        for (int i=0;i<expendBudgetList.size();i++){
            String mm=expendBudgetList.get(i).getMonth().substring(4);
            //如果小于10，就截取后一位，把前面的0去掉
            if(Integer.parseInt(mm) <10){
                mm=mm.substring(1);
            }
            dynamicHeadList.add(String.format("%s月",mm));
        }
        vo1.setDynamicHeadList(dynamicHeadList);
        vo1.setRows(expendBudgetList);
        return vo1;
    }

    @ServiceLog(doAction = "监控明细部门支出预算统计（柱状图）")
    @Override
    public List<FinanceIndexSectionBudgetExpendVo> sectionBudgetExpend(String year, String departmentId, String typeId) {
        //拼接年月
        String startTime=year+"01";
        String endTime=year+"12";
        return financeIndexDao.sectionBudgetExpend(startTime,endTime,departmentId,typeId);
    }

    @ServiceLog(doAction = "监控明细各项支出占比（饼状图）")
    @Override
    public List<FinanceIndexExpendBudgetRatioVo> accumulativeExpendRatio(String year, String departmentId) {
        //拼接年月
        String startTime=year+"01";
        String endTime=year+"12";
        List<FinanceIndexExpendBudgetRatioVo> accumulativeExpendRatio1= financeIndexDao.accumulativeExpendRatio(startTime,endTime,departmentId);
        //定义一个double类型的变量，来保存返回的查询每条数据中支出的值的总和，
        //为什么不用String,之前用string了，但是那个是每次在后面拼接，比如110.00+103.00，结果是110.00103.00，
        double sumExpeng=0;
        for (int i=0;i<accumulativeExpendRatio1.size();i++){
            //将每一条数据的支出都拿出来相加，得到总支出
            sumExpeng=sumExpeng+Double.parseDouble(accumulativeExpendRatio1.get(i).getCost());
        }
        //再转成String，把它遍历加到每一条数据中
        String a = String.valueOf(sumExpeng);
        for (int i=0;i<accumulativeExpendRatio1.size();i++){
            accumulativeExpendRatio1.get(i).setSumExpeng(a);
        }
        return accumulativeExpendRatio1;
    }

    @ServiceLog(doAction = "监控明细各项支出预算报表")
    @Override
    public FianceDynamicTableVo<List<FinanceIndexSectionExpendFormsVo>> sectionExpendForms(String year, String departmentId) {

        String begin=year+"01";
        String end=year+"12";
        List<FinanceIndexSectionExpendFormsVo> financeIndexSectionExpendFormsVos=financeIndexDao.sectionExpendForms(begin,end,departmentId);
        //查询合计
        List<FinanceIndexSectionExpendFormsModel> list=financeIndexDao.total(begin,end,departmentId);
        FinanceIndexSectionExpendFormsVo vo=new FinanceIndexSectionExpendFormsVo();
        vo.setCostTypeName("合计");
        vo.setFinanceIndexSectionExpendFormsModels(list);
        financeIndexSectionExpendFormsVos.add(vo);

        if(null==financeIndexSectionExpendFormsVos||financeIndexSectionExpendFormsVos.size()<1){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"无数据");
        }
        FianceDynamicTableVo<List<FinanceIndexSectionExpendFormsVo>> vo1=new FianceDynamicTableVo<>();
        List<String>dynamicHeadList=new ArrayList<>();
        financeIndexSectionExpendFormsVos.get(0).getFinanceIndexSectionExpendFormsModels().stream().forEach(e->{
            //String yyyy=e.getMonth().substring(0,4);
            String mm=e.getMonth();
            //如果小于10，就截取后一位，把前面的0去掉
            if(Integer.parseInt(mm) <10){
                mm=mm.substring(1);
            }
            dynamicHeadList.add(String.format("%s月",mm));
        });
        vo1.setDynamicHeadList(dynamicHeadList);
        vo1.setRows(financeIndexSectionExpendFormsVos);
        return vo1;

        //return financeIndexSectionExpendFormsVos;
    }

    @ServiceLog(doAction = "导出")
    @Override
    public List<FinanceIndexExpendFormsExportVo> expendFormsExport(String year, String departmentId) {
        String begin=year+"01";
        String end=year+"12";
        //保存结果，返回
        List<FinanceIndexExpendFormsExportVo>  financeIndexExpendFormsExportVos=new ArrayList<>();
        //查询到结果
        List<FinanceIndexSectionExpendFormsVo> financeIndexSectionExpendFormsVos=financeIndexDao.sectionExpendForms(begin,end,departmentId);
        for(int i=0;i<financeIndexSectionExpendFormsVos .size();i++){
            FinanceIndexExpendFormsExportVo fvo=new FinanceIndexExpendFormsExportVo();
            //设置支出类型名称
            fvo.setCostTypeName(financeIndexSectionExpendFormsVos.get(i).getCostTypeName());
            //获取到支出预算的list
            List<FinanceIndexSectionExpendFormsModel> fm=financeIndexSectionExpendFormsVos.get(i).getFinanceIndexSectionExpendFormsModels();
            //赋值 将子查询的结果复制到 FinanceIndexExpendFormsExportVo 里面,因为在使用Excel工具类中的方法时
            //不方便遍历这个集合里面的值，所以只能这样遍历加到这个里面了,
            if(fm.size() != 0 ){
                 fvo.setBudgetNumber1(fm.get(0).getBudgetNumber()); fvo.setCost1(fm.get(0).getCost());
                 fvo.setBudgetNumber2(fm.get(1).getBudgetNumber()); fvo.setCost2(fm.get(1).getCost());
                 fvo.setBudgetNumber3(fm.get(2).getBudgetNumber()); fvo.setCost3(fm.get(2).getCost());
                 fvo.setBudgetNumber4(fm.get(3).getBudgetNumber()); fvo.setCost4(fm.get(3).getCost());
                 fvo.setBudgetNumber5(fm.get(4).getBudgetNumber()); fvo.setCost5(fm.get(4).getCost());
                 fvo.setBudgetNumber6(fm.get(5).getBudgetNumber()); fvo.setCost6(fm.get(5).getCost());
                 fvo.setBudgetNumber7(fm.get(6).getBudgetNumber()); fvo.setCost7(fm.get(6).getCost());
                 fvo.setBudgetNumber8(fm.get(7).getBudgetNumber()); fvo.setCost8(fm.get(7).getCost());
                 fvo.setBudgetNumber9(fm.get(8).getBudgetNumber()); fvo.setCost9(fm.get(8).getCost());
                 fvo.setBudgetNumber10(fm.get(9).getBudgetNumber()); fvo.setCost10(fm.get(9).getCost());
                 fvo.setBudgetNumber11(fm.get(10).getBudgetNumber()); fvo.setCost11(fm.get(10).getCost());
                 fvo.setBudgetNumber12(fm.get(11).getBudgetNumber()); fvo.setCost12(fm.get(11).getCost());
             }
            financeIndexExpendFormsExportVos.add(fvo);
        }
        //查询合计  将加过在添加到 FinanceIndexExpendFormsExportVo ,同上,
        List<FinanceIndexSectionExpendFormsModel> list=financeIndexDao.total(begin,end,departmentId);
        if (list.size() != 0){
            FinanceIndexExpendFormsExportVo fvo=new FinanceIndexExpendFormsExportVo();
            //设置支出类型名称
            fvo.setCostTypeName("合计");
            fvo.setBudgetNumber1(list.get(0).getBudgetNumber()); fvo.setCost1(list.get(0).getCost());
            fvo.setBudgetNumber2(list.get(1).getBudgetNumber()); fvo.setCost2(list.get(1).getCost());
            fvo.setBudgetNumber3(list.get(2).getBudgetNumber()); fvo.setCost3(list.get(2).getCost());
            fvo.setBudgetNumber4(list.get(3).getBudgetNumber()); fvo.setCost4(list.get(3).getCost());
            fvo.setBudgetNumber5(list.get(4).getBudgetNumber()); fvo.setCost5(list.get(4).getCost());
            fvo.setBudgetNumber6(list.get(5).getBudgetNumber()); fvo.setCost6(list.get(5).getCost());
            fvo.setBudgetNumber7(list.get(6).getBudgetNumber()); fvo.setCost7(list.get(6).getCost());
            fvo.setBudgetNumber8(list.get(7).getBudgetNumber()); fvo.setCost8(list.get(7).getCost());
            fvo.setBudgetNumber9(list.get(8).getBudgetNumber()); fvo.setCost9(list.get(8).getCost());
            fvo.setBudgetNumber10(list.get(9).getBudgetNumber()); fvo.setCost10(list.get(9).getCost());
            fvo.setBudgetNumber11(list.get(10).getBudgetNumber()); fvo.setCost11(list.get(10).getCost());
            fvo.setBudgetNumber12(list.get(11).getBudgetNumber()); fvo.setCost12(list.get(11).getCost());
        }
        return financeIndexExpendFormsExportVos;
    }

    @ServiceLog(doAction = "类型下拉框")
    @Override
    public List<FinanceIndexDownTypeModel> downType() {

        return financeIndexDao.downType();
    }
}
