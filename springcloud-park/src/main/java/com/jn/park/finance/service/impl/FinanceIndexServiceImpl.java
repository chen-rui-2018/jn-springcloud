package com.jn.park.finance.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.park.finance.dao.FinanceIndexDao;
import com.jn.park.finance.enums.FinanceExceptionEnums;
import com.jn.park.finance.model.*;
import com.jn.park.finance.service.FinanceIndexService;
import com.jn.park.finance.vo.*;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 监控首页
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@Service
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
        List<FinanceExpendDepartmentModel> financeExpendDepartmentModels=new ArrayList<>();
        //遍历获取到里面所有的部门ID及部门名称
        for (int i=0;i<k;i++){
            FinanceExpendDepartmentModel fedm=new FinanceExpendDepartmentModel();
            fedm.setDepartmentId(data2.get(i).get("id").toString());
            fedm.setDepartmentName(data2.get(i).get("departmentName").toString());
            //将时间塞进去
            fedm.setStartTime(begin);
            fedm.setEndTime(end);
            financeExpendDepartmentModels.add(fedm);
        }
        map.put("startTime",begin);
        map.put("endTime",end);
        map.put("list",financeExpendDepartmentModels);
        //查询所有部门的支出占比
        List<FinanceIndexBudgetExpendRatioVo> budgetExpendRatio=financeIndexDao.budgetExpendRatio(map);

        return budgetExpendRatio;
    }

    @ServiceLog(doAction = "全年支出/预算 统计柱状图")
    @Override
    public List<FinanceIndexExpendBudgetStatisticsVo> expendBudget(String year) {
        //拼接年月
        String startTime=year+"01";
        String endTime=year+"12";
        return financeIndexDao.expendBudget(startTime,endTime);
    }

    @ServiceLog(doAction = "监控明细部门支出预算统计（柱状图）")
    @Override
    public List<FinanceIndexSectionBudgetExpendVo> sectionBudgetExpend(String year, String departmentId, int typeId) {
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
    public List<FinanceIndexSectionExpendFormsVo> sectionExpendForms(String year, String departmentId) {

        String begin=year+"01";
        String end=year+"12";
        List<FinanceIndexSectionExpendFormsVo> financeIndexSectionExpendFormsVos=financeIndexDao.sectionExpendForms(begin,end,departmentId);
        //查询合计
        List<FinanceIndexSectionExpendFormsModel> list=financeIndexDao.total(begin,end,departmentId);
        FinanceIndexSectionExpendFormsVo vo=new FinanceIndexSectionExpendFormsVo();
        vo.setCostTypeName("合计");
        vo.setFinanceIndexSectionExpendFormsModels(list);
        financeIndexSectionExpendFormsVos.add(vo);

        return financeIndexSectionExpendFormsVos;
    }

    @ServiceLog(doAction = "类型下拉框")
    @Override
    public List<FinanceIndexDownTypeModel> downType() {

        return financeIndexDao.downType();
    }
}
