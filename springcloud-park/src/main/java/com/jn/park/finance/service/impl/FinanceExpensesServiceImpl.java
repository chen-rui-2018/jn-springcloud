package com.jn.park.finance.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.park.finance.dao.FinanceExpensesDao;
import com.jn.park.finance.entity.TbFinanceExpensesExample;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.enums.FinanceExceptionEnums;
import com.jn.park.finance.model.*;
import com.jn.park.finance.service.FinanceExpensesService;
import com.jn.park.finance.vo.*;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * 支出录入
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
@Service
@Transactional
public class FinanceExpensesServiceImpl implements FinanceExpensesService {

    @Autowired
    private FinanceExpensesDao financeExpensesDao;

    @Autowired
    private SystemClient systemClient;


    @ServiceLog(doAction="支出录入分页查询")
    @Override
    public PaginationData findAll(FinanceExpensesPageModel financeExpensesPageModel) {


        if(StringUtils.isBlank(financeExpensesPageModel.getOrderByClause())){
            financeExpensesPageModel.setOrderByClause("cost_happend_time desc");
        }

        Page<Object> objects = PageHelper.startPage(financeExpensesPageModel.getPage(), financeExpensesPageModel.getRows());
        List<FinanceExpendVo> findAll = financeExpensesDao.findAll(financeExpensesPageModel);
        return new PaginationData(findAll,objects.getTotal());
    }

    @ServiceLog(doAction="支出录入历史分页查询")
    @Override
    public PaginationData findHistoryAll(FinanceExpensesHistoryPageModel financeExpensesHistoryPageModel) {

        if(StringUtils.isBlank(financeExpensesHistoryPageModel.getOrderByClause())){
            financeExpensesHistoryPageModel.setOrderByClause("cost_happend_time desc");
        }

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
        String msm=DateUtils.formatDate(day,"Hmmss");
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
            if(costHappendTime.length()>6||costHappendTime.length()<6){
                throw new JnSpringCloudException(FinanceExceptionEnums.UN_KNOW,String.format("上传文件中【 %s 】不符合规则,日期格式如【 201901 】",costHappendTime));
            }
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
            //部门名称
            //判断是否有相同的类型，如果相同，就设置类型及类型ID，如果没有就提示没有部门
            String departmentName=data.get(4);
            //通过部门名称获取部门ID
            Result dept = systemClient.getDept(departmentName);
            Map<String,Object> data1 = (Map<String,Object>)dept.getData();
            //如果找不到部门，就不再进行下面的操作
            if(data1==null){
                throw new JnSpringCloudException(FinanceExceptionEnums.UN_KNOW,String.format("上传文件中【 %s 】在系统中不存在,请确认后再次操作",departmentName));
            }
            String departmentName1= (String) data1.get("departmentName");
            String departmentId1= (String) data1.get("id");
            //设置部门名称和部门ID
            financeExpendImportDataVo.setDepartmentName(departmentName1);
            financeExpendImportDataVo.setDepartmentId(departmentId1);
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
                //保存打标数据到tb_finance_expenses表之后，立马将保存的数据按照月份计算出总和
                // 更新tb_finance_expenses_month表，
                //先把保存到记录表中的数据按照时间，类型分组，计算出每个月不同类型的支出，这次打标的的批次号作为条件
                String excelId=feList.get(0).getExcelId();
                List<FinanceSaveExpensesMonthModel> financeSaveExpensesMonthModelList=financeExpensesDao.selectSaveExpensesMonth(excelId);
                //将数据更新到tb_finance_expenses_month表
                Map<String,Object> map1=new HashMap<>();
                map1.put("list",financeSaveExpensesMonthModelList);
                map1.put("account",User.getAccount());
                financeExpensesDao.saveExpensesMonth(map1);

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

    @ServiceLog(doAction="查询部门信息")
    @Override
    public List<FinanceSelectDepartmentModel> selectDepartment() {
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
        if(StringUtils.isBlank(rootDepartmentId)){
            throw new JnSpringCloudException(FinanceExceptionEnums.UN_KNOW,"获取根节点失败");
        }
        //再通过拿到的根节点作为条件再调用一次，childflag为true时表示查询它下面的所有子节点（下一级）
        Result firstLevelResult = systemClient.selectDeptByParentId(rootDepartmentId, true);
        Map<String,Object> data1 = (Map<String,Object>) firstLevelResult.getData();
        List<Map<String,Object>> data2 = (List<Map<String,Object>>) data1.get("children");
        int k=data2.size();
        Map<String,Object> map =new HashMap<>();
        List<FinanceSelectDepartmentModel> financeSelectDepartmentModels =new ArrayList<>();
        //遍历获取到里面所有的部门ID及部门名称
        for (int i=0;i<k;i++){
            FinanceSelectDepartmentModel fedm=new FinanceSelectDepartmentModel();
            fedm.setDepartmentId(data2.get(i).get("id").toString());
            fedm.setDepartmentName(data2.get(i).get("departmentName").toString());
            financeSelectDepartmentModels.add(fedm);
        }
        return financeSelectDepartmentModels;
    }

    @ServiceLog(doAction="根据导入的费用类型对比，看是否有相同的费用类型")
    @Override
    public List<FinanceExpensesTypeNameModel> selectAfterTypeName(String costBeforeTypeName) {
        return financeExpensesDao.selectAfterTypeName(costBeforeTypeName);
    }
}
