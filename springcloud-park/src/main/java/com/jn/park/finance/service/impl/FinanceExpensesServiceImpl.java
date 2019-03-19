package com.jn.park.finance.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.park.finance.dao.FinanceExpensesDao;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.enums.FinanceExceptionEnums;
import com.jn.park.finance.model.FinanceExpensesHistoryPageModel;
import com.jn.park.finance.model.FinanceExpensesPageModel;
import com.jn.park.finance.model.FinanceExpensesTypeNameModel;
import com.jn.park.finance.service.FinanceExpensesService;
import com.jn.park.finance.vo.*;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 支出录入
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
@Service
public class FinanceExpensesServiceImpl implements FinanceExpensesService {

    @Autowired
    private FinanceExpensesDao financeExpensesDao;

    @ServiceLog(doAction="支出录入分页查询")
    @Override
    public PaginationData findAll(FinanceExpensesPageModel financeExpensesPageModel) {
        Page<Object> objects = PageHelper.startPage(financeExpensesPageModel.getPage(), financeExpensesPageModel.getRows());
        List<FinanceExpendVo> findAll = financeExpensesDao.findAll(financeExpensesPageModel);
        return new PaginationData(findAll,objects.getTotal());
    }

    @ServiceLog(doAction="支出录入历史分页查询")
    @Override
    public PaginationData findHistoryAll(FinanceExpensesHistoryPageModel financeExpensesHistoryPageModel) {
        Page<Object> objects = PageHelper.startPage(financeExpensesHistoryPageModel.getPage(), financeExpensesHistoryPageModel.getRows());
        List<FinanceExpendHistoryVo> findHistoryAll = financeExpensesDao.findHistoryAll(financeExpensesHistoryPageModel);
        return new PaginationData(findHistoryAll,objects.getTotal());
    }

    @ServiceLog(doAction="支出录入导入")
    @Override
    public List<FinanceExpendImportDataVo> importData(MultipartFile file,User User) {
        //读出excel中的所有行数据
        List<Object>rows= ExcelUtil.readExcel(file,null);
        if(null==rows||rows.size()<2){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"至少要导入一行数据");
        }
        //第二行开始为数据行
        //多少行
        int rowsSize=rows.size();
        List<FinanceExpendImportDataVo> financeExpendImportDataVos=new ArrayList<>();
        //生成一个批次号  取分秒毫秒+三位随机数，避免重复
        //获取分秒毫秒
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("mmssSSS");
        String msm=df.format(day);
        //三位随机数
        int rd = (int)(Math.random()*900 + 100);
        String random = Integer.toString(rd);
        String excelId=msm+random;
        Map<String,Object> map=new HashMap();
        for(int i=1;i<rowsSize;i++){
            FinanceExpendImportDataVo financeExpendImportDataVo=new FinanceExpendImportDataVo();
            List<String>data=(List<String>)rows.get(i);
            //设置本次的批次号
            financeExpendImportDataVo.setExcelId(excelId);
            //获取时间
            String costHappendTime=data.get(0);
            financeExpendImportDataVo.setCostHappendTime(costHappendTime);
            //获取流水编号
            String costId=data.get(1);
            financeExpendImportDataVo.setCostId(costId);
            //金额
            String cost=data.get(2);
            financeExpendImportDataVo.setCost(cost);
            //类型
            String costBeforeTypeName=data.get(3);
            //通过类型名称查询是否有该类型，有就改变“打标后的费用类型ID及打标后的费用类型名称“，没有就不做处理
            List<FinanceExpensesTypeNameModel> typeName= this.selectAfterTypeName(costBeforeTypeName);
            if(typeName.size()>0){
                financeExpendImportDataVo.setCostAfterTypeId(typeName.get(0).getCostAfterTypeId()+"");
                financeExpendImportDataVo.setCostAfterTypeName(typeName.get(0).getCostAfterTypeName());
            }
            //设置打标前的类型名称
            financeExpendImportDataVo.setCostBeforeTypeName(costBeforeTypeName);
            //判断是否有相同的类型，如果相同，就设置类型及类型ID，如果没有就不做处理
            // TODO: 2019/3/12
            //部门
            String departmentName=data.get(4);
            financeExpendImportDataVo.setDepartmentName(departmentName);
            //通过部门名称获取部门标号
            // TODO: 2019/3/12
            //暂定都是财务部，通过部门名称查询部门名称和部门ID的接口还没有.
            financeExpendImportDataVo.setDepartmentId("a794452f-fad6-4697-afe1-e62542bd753a");
            financeExpendImportDataVos.add(financeExpendImportDataVo);
        }
        map.put("excelId",excelId);
        map.put("list",financeExpendImportDataVos);
        map.put("account",User.getAccount());
        financeExpensesDao.importData(map);
        return financeExpendImportDataVos;
    }

    @ServiceLog(doAction="查询本次导入的支出录入")
    @Override
    public List<FinanceExpendFindImportDataVo> findImportData(String excelId) {
        return financeExpensesDao.findImportData(excelId);
    }

    @ServiceLog(doAction="保存打标数据")
    @Override
    public Result saveMarkData(List<FinanceExpendFindImportDataVo> feList,User User) {

        Map<String,Object> map=new HashMap();
        boolean flag=true;
        //遍历list 获取每一条数据
        //如果有为空的,返回提示第几行为空,请重新重新操作
        List<Integer>  row=new ArrayList<>();
        //出现空数据是就不再遍历判断了，直接return出去
        if(flag){
            for (int i=0;i<feList.size();i++){
                FinanceExpendFindImportDataVo data=feList.get(i);
                if(data.getCostHappendTime()==null || data.getCostHappendTime()==""){
                    flag=false;
                    row.add(i);
                }
                if( data.getCost()==null || data.getCost() ==""){
                    flag=false;
                    row.add(i);
                }
                if( data.getCostAfterTypeId()==null || data.getCostAfterTypeId() ==""){
                    flag=false;
                    row.add(i);
                }
                if( data.getCostAfterTypeName()==null || data.getCostAfterTypeName()==""){
                    flag=false;
                    row.add(i);
                }
                if( data.getDepartmentId()==null || data.getDepartmentId()==""){
                    flag=false;
                    row.add(i);
                }
                if( data.getDepartmentName()==null || data.getDepartmentName() ==""){
                    flag=false;
                    row.add(i);
                }if( data.getCostAfterTypeId()==null || data.getCostAfterTypeId() ==""){
                    flag=false;
                    row.add(i);
                }
            }
        }
        if(flag){
            try {
                map.put("list",feList);
                map.put("account",User.getAccount());
                financeExpensesDao.saveMarkData(map);
            }catch (Exception e){
                throw new JnSpringCloudException(FinanceExceptionEnums.UN_KNOW,"保存数据失败");
            }
            return new Result("操作完成");
        }else{
            //提示错误信息
            return new Result("第"+row+"条数据不完整,请重新操作");
        }

    }

    @ServiceLog(doAction="查询财务类型")
    @Override
    public List<FinanceExpendFinanceTypeVo> selectFinanceType() {
        return financeExpensesDao.selectFinanceType();
    }

    @ServiceLog(doAction="根据导入的费用类型对比，看是否有相同的费用类型")
    @Override
    public List<FinanceExpensesTypeNameModel> selectAfterTypeName(String costBeforeTypeName) {
        return financeExpensesDao.selectAfterTypeName(costBeforeTypeName);
    }
}
