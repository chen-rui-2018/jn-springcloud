package com.jn.park.finance.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.Assert;
import com.jn.park.finance.dao.TbFinanceDepartmentToTypeMapper;
import com.jn.park.finance.dao.TbFinanceTypeMapper;
import com.jn.park.finance.entity.*;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.enums.FinanceTypeExceptionEnums;
import com.jn.park.finance.model.FinanceDepartmentToTypeModel;
import com.jn.park.finance.model.FinanceTypeModel;
import com.jn.park.finance.service.FinanceTypeService;
import com.jn.system.log.annotation.ServiceLog;
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
import java.util.Date;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/7 2:26
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FinanceTypeServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(FinanceTypeServiceImplTest.class);
    @Autowired
    private FinanceTypeService financeTypeService;
    @Autowired
    private TbFinanceTypeMapper tbFinanceTypeMapper;
    @Autowired
    private TbFinanceDepartmentToTypeMapper tbFinanceDepartmentToTypeMapper;


    /**
     * 初始化数据
     * 差旅支出、办公支出、车辆支出、宣传支出、培训支出
     */
    @Test
    public void t000_initData(){
        String[] typeArr={"差旅支出","办公支出","车辆支出","宣传支出","培训支出"};
        List<TbFinanceType>typeList=new ArrayList<>();
        //添加10个类型（5个公共类型的）
        for(int i=0;i<typeArr.length;i++){
            TbFinanceType type=new TbFinanceType();
            type.setId(1);
            type.setFinanceName(typeArr[i]);
            type.setCreatorAccount("admin");
            type.setCreatedTime(new Date());
            tbFinanceTypeMapper.insertSelective(type);
            typeList.add(type);
        }

    }



    /**
     * 初始化测试数据
     * 类型表tb_finance_type：
     *      添加10个类型，分别是：交通费0-交通费9
     * 关系表tb_finance_department_to_type：
     *      行政综合部(281f4005-0363-4528-92a3-60a730532e53)，关联交通费0
     *      投资管理部(2e2ca5b1-9293-44bb-a061-12085a348d17)，关联交通费0，交通费2
     *      规划建设部(7f73787e-7cea-4b47-991d-a5a67465f272)，不关联任何类型
     */
    @Test
    public void t001_initTest(){
        List<TbFinanceType>typeList=new ArrayList<>();

        //添加10个类型（5个公共类型的）
        for(int i=0;i<10;i++){
            TbFinanceType type=new TbFinanceType();
            type.setId(1);
            type.setFinanceName("交通费"+i);
            //奇数的公用的类型
            type.setCreatorAccount("huangbq");
            type.setCreatedTime(new Date());
            tbFinanceTypeMapper.insertSelective(type);
            typeList.add(type);
            logger.info("插入成功====》{}",type.getId());
        }

        //行政综合部(281f4005-0363-4528-92a3-60a730532e53)，关联交通费0
        TbFinanceDepartmentToType tech0=new TbFinanceDepartmentToType();
        tech0.setFinanceTypeId(typeList.get(0).getId());
        tech0.setDepartmentId("281f4005-0363-4528-92a3-60a730532e53");
        tech0.setDepartmentName("行政综合部");
        tech0.setCreatorAccount("huangbq");
        tech0.setCreatedTime(new Date());
        tbFinanceDepartmentToTypeMapper.insertSelective(tech0);

        //投资管理部(2e2ca5b1-9293-44bb-a061-12085a348d17)，关联交通费0，交通费2
        TbFinanceDepartmentToType finance0=new TbFinanceDepartmentToType();
        finance0.setFinanceTypeId(typeList.get(0).getId());
        finance0.setDepartmentId("2e2ca5b1-9293-44bb-a061-12085a348d17");
        finance0.setDepartmentName("投资管理部");
        finance0.setCreatorAccount("huangbq");
        finance0.setCreatedTime(new Date());
        tbFinanceDepartmentToTypeMapper.insertSelective(finance0);
        TbFinanceDepartmentToType finance1=new TbFinanceDepartmentToType();
        finance1.setFinanceTypeId(typeList.get(2).getId());
        finance1.setDepartmentId("2e2ca5b1-9293-44bb-a061-12085a348d17");
        finance1.setDepartmentName("投资管理部");
        finance1.setCreatorAccount("huangbq");
        finance1.setCreatedTime(new Date());
        tbFinanceDepartmentToTypeMapper.insertSelective(finance1);

        //规划建设部(7f73787e-7cea-4b47-991d-a5a67465f272)

    }

    /**
     * 添加修改财务项目类型-用例0
     * 1、添加1条正常数据=》结果：添加成功1条
     * 2、修改 类型名称为 已经重复的=》结果：修改失败
     * 3、修改 显示顺序=1 =》结果：修改成功1条
     * 4、删除 =》结果：删除成功
     */
    @Test
    public void t100_SaveOrUpdate() {

        //1、
        FinanceTypeModel financeTypeModel=new FinanceTypeModel();
        financeTypeModel.setFinanceName("团建费0");
        int id=financeTypeService.saveOrUpdate(financeTypeModel,"huangbq");
        Assert.isTrue(tbFinanceTypeMapper.selectByPrimaryKey(id)!=null);

        //2、
        FinanceTypeModel update=new FinanceTypeModel();
        update.setId(id);
        update.setFinanceName("差旅支出");
        try {
            int updateCount=financeTypeService.saveOrUpdate(update,"huangbq");
            Assert.isTrue(updateCount==0);
        }catch (JnSpringCloudException e){
            Assert.isTrue(e.getMsg().equals(FinanceTypeExceptionEnums.TYPE_NAME_EXIST.getMessage()));
        }

        //3、
        update.setFinanceName(null);
        update.setShowOrder(1);
        int updateCount=financeTypeService.saveOrUpdate(update,"huangbq");
        Assert.isTrue(updateCount==1);
        Assert.isTrue(tbFinanceTypeMapper.selectByPrimaryKey(id).getShowOrder().equals(1));

        //4、
        Assert.isTrue(tbFinanceTypeMapper.deleteByPrimaryKey(id)==1);
    }

    /**
     * 添加修改财务项目类型-用例1
     * 1、添加 名称已存在的数据 =》结果：名称已存在
     * 2、添加 名称为null的数据=》结果：名称不能为空
     */
    @Test
    public void t101_SaveOrUpdate() {

        //1、
        FinanceTypeModel financeTypeModel=new FinanceTypeModel();
        financeTypeModel.setFinanceName("差旅支出");
        try {
            int updateCount=financeTypeService.saveOrUpdate(financeTypeModel,"huangbq");
            Assert.isTrue(updateCount==0);
        }catch (JnSpringCloudException e){
            Assert.isTrue(e.getMsg().equals(FinanceTypeExceptionEnums.TYPE_NAME_EXIST.getMessage()));
        }


        //2、
        financeTypeModel.setFinanceName(null);
        try {
            int updateCount=financeTypeService.saveOrUpdate(financeTypeModel,"huangbq");
            Assert.isTrue(updateCount==0);
        }catch (JnSpringCloudException e){
            Assert.isTrue(e.getMsg().equals(FinanceTypeExceptionEnums.TYPE_NAME_NOT_NULL.getMessage()));
        }
    }

    /**
     * 查看所有财务项目类型-用例0
     * 1、不存在的部门ID =》结果：0条数据
     * 2、查行政综合部(281f4005-0363-4528-92a3-60a730532e53)=》结果：关联交通费0  +  10个公共的类型
     * 3、查投资管理部(2e2ca5b1-9293-44bb-a061-12085a348d17)=》结果：关联交通费0，交通费2  +  10个公共的类型
     * 4、查规划建设部(7f73787e-7cea-4b47-991d-a5a67465f272)=>结果：10个公共的类型
     */
    @Test
    public void t200_selectTypeByDepartmentId() {
        //1、
        try {
            List<FinanceTypeModel>xxxxxx=financeTypeService.selectTypeByDepartmentIds("xxxxxx",null);
            Assert.isTrue(xxxxxx.size()==0);
        }catch (JnSpringCloudException e){
            Assert.isTrue(e.getMsg().equals(FinanceTypeExceptionEnums.TYPE_DEPT_NOT_EXIST.getMessage()));
        }

        //2、
        List<FinanceTypeModel>tech0=financeTypeService.selectTypeByDepartmentIds("281f4005-0363-4528-92a3-60a730532e53",null);
        Assert.isTrue(tech0.size()==11);

        //3、
        List<FinanceTypeModel>finance0=financeTypeService.selectTypeByDepartmentIds("2e2ca5b1-9293-44bb-a061-12085a348d17",null);
        Assert.isTrue(finance0.size()==12);

        //4、
        List<FinanceTypeModel>zonghe=financeTypeService.selectTypeByDepartmentIds("7f73787e-7cea-4b47-991d-a5a67465f272",null);
        Assert.isTrue(zonghe.size()==10);
    }

    @Test
    public void test30_selectDepartmentByTypeId(){
        List<FinanceDepartmentToTypeModel> financeDepartmentToTypeModelList=financeTypeService.selectDepartmentByTypeId(5);
        logger.info("selectDepartmentByTypeId====>{}",financeDepartmentToTypeModelList);
    }

    @Test
    public void t400_updateDepartmentByType() {


    }

    @Test
    public void t999_clean(){
        logger.info("清理测试数据");
        TbFinanceDepartmentToTypeExample tbFinanceDepartmentToTypeExample=new TbFinanceDepartmentToTypeExample();
        tbFinanceDepartmentToTypeExample.createCriteria().andCreatorAccountEqualTo("huangbq");
        int count1=tbFinanceDepartmentToTypeMapper.deleteByExample(tbFinanceDepartmentToTypeExample);
        Assert.isTrue(count1==3);

        TbFinanceTypeExample example=new TbFinanceTypeExample();
        example.createCriteria().andCreatorAccountEqualTo("huangbq");
        int count2=tbFinanceTypeMapper.deleteByExample(example);
        Assert.isTrue(count2==10);

    }


}