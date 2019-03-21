package com.jn.park.finance.service.impl;

import com.jn.common.model.PaginationData;
import com.jn.park.finance.model.FinanceExpensesPageModel;
import com.jn.park.finance.model.FinanceExpensesTypeNameModel;
import com.jn.park.finance.service.FinanceExpensesService;
import com.jn.park.finance.vo.FinanceExpendFinanceTypeVo;
import com.jn.park.finance.vo.FinanceExpendFindImportDataVo;
import com.jn.system.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支出录入
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FinanceExpensesServiceImplTest {

    @Autowired
    private FinanceExpensesService financeExpensesService;

    @Test
    public void findAll() {
        FinanceExpensesPageModel financeExpensesPageModel =new FinanceExpensesPageModel();

        financeExpensesPageModel.setDepartmentId("a794452f-fad6-4697-afe1-e62542bd753a");
        financeExpensesPageModel.setStartTime("201901");
        financeExpensesPageModel.setEndTime("201912");

        PaginationData findAll= financeExpensesService.findAll(financeExpensesPageModel);

    }

    @Test
    public void saveMarkData(){
       // User user=(User) SecurityUtils.getSubject().getPrincipal();
        Map<String,Object> map=new HashMap();
        List<FinanceExpendFindImportDataVo> feList = new ArrayList<>();
        for (int i=0 ; i<5 ; i++){
            FinanceExpendFindImportDataVo fi= new FinanceExpendFindImportDataVo();
            fi.setCostHappendTime("20199"+i);
            fi.setCost("10"+i);
            fi.setCostAfterTypeId("4");
            fi.setCostAfterTypeName("差旅支出");
            fi.setDepartmentId("a794452f-fad6-4697-afe1-e62542bd753a");
            fi.setDepartmentName("财务部");
            feList.add(fi);
        }
        map.put("account","tangry");
        map.put("list",feList);
        User user=new User();
        user.setAccount("tangry");
        financeExpensesService.saveMarkData(feList,user);

    }


    @Test
    public void selectFinanceType(){
        List<FinanceExpendFinanceTypeVo> selectFinanceType= financeExpensesService.selectFinanceType();
        //System.out.println(selectFinanceType);
    }
    @Test
    public void selectAfterTypeName(){
        List<FinanceExpensesTypeNameModel> selectAfterTypeName= financeExpensesService.selectAfterTypeName("办公支出");
        //System.out.println(selectAfterTypeName);
    }
}