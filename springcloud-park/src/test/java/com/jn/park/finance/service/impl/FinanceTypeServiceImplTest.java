package com.jn.park.finance.service.impl;

import com.jn.common.util.Assert;
import com.jn.park.finance.dao.TbFinanceDepartmentToTypeMapper;
import com.jn.park.finance.dao.TbFinanceTypeMapper;
import com.jn.park.finance.model.FinanceTypeModel;
import com.jn.park.finance.service.FinanceTypeService;
import com.netflix.discovery.converters.Auto;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/7 2:26
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.JVM)
public class FinanceTypeServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(FinanceTypeServiceImplTest.class);
    @Autowired
    private FinanceTypeService financeTypeService;
    @Autowired
    private TbFinanceTypeMapper tbFinanceTypeMapper;
    @Autowired
    private TbFinanceDepartmentToTypeMapper tbFinanceDepartmentToTypeMapper;


    private List<Integer>typeIdList=new ArrayList<>();
    private List<Integer>documentTypeIdList=new ArrayList<>();

    @Before
    public void setUp() throws Exception {

        logger.info("Before====================>");
    }

    @Test
    public void saveOrUpdate() {

        FinanceTypeModel financeTypeModel=new FinanceTypeModel();
        financeTypeModel.setFinanceName("交通费3");
        financeTypeModel.setIsPublic(new Byte("1"));
        int id1=financeTypeService.saveOrUpdate(financeTypeModel,"huangbq");
        logger.info("id1====>{}",id1);

        typeIdList.add(id1);

        FinanceTypeModel financeTypeModel2=new FinanceTypeModel();
        financeTypeModel2.setFinanceName("团建费3");
        financeTypeModel2.setIsPublic(new Byte("0"));
        int id2=financeTypeService.saveOrUpdate(financeTypeModel2,"huangbq");
        logger.info("id1====>{}",id2);
        typeIdList.add(id2);

        financeTypeModel2.setFinanceName("团建费33");
        financeTypeModel2.setId(id2);
        financeTypeService.saveOrUpdate(financeTypeModel2,"huangbq2");

        Assert.isTrue(typeIdList.size()==2);

    }

    @Test
    public void updateDepartmentByType() {
    }

    @Test
    public void updateTypeByDepartment() {
    }

    @Test
    public void selectByDepart() {
        List<FinanceTypeModel>financeTypeModelList=financeTypeService.selectByDepart(null);
        logger.info("financeTypeModelList===>{}",financeTypeModelList);
    }

    @After
    public void after(){
        logger.info("After====================>");
        typeIdList.forEach(typeId->{
            tbFinanceTypeMapper.deleteByPrimaryKey(typeId);
        });

        documentTypeIdList.forEach(typeId->{
            tbFinanceTypeMapper.deleteByPrimaryKey(typeId);
        });
    }


}