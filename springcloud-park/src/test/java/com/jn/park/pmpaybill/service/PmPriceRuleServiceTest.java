package com.jn.park.pmpaybill.service;

import com.jn.SpringCloudParkApplication;
import com.jn.park.pmpaybill.entity.TbPmPriceRuleDeatils;
import com.jn.park.pmpaybill.enums.PmPayBillStatusEnums;
import com.jn.park.pmpaybill.vo.PmPriceRuleVo;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudParkApplication.class})
@FixMethodOrder(MethodSorters.JVM)
public class PmPriceRuleServiceTest {

    @Autowired
    private PmPriceRuleService pmPriceRuleService;

    @Test
    public void createPmPriceRule() {
        PmPriceRuleVo pmPriceRuleVo = new PmPriceRuleVo();
        pmPriceRuleVo.setId(UUID.randomUUID().toString());
        pmPriceRuleVo.setCompanyId("wangsong");
        pmPriceRuleVo.setCompanyName("测试公司");
        pmPriceRuleVo.setRecordStatus(new Byte(PmPayBillStatusEnums.EFFECTIVE.getCode()));
        pmPriceRuleVo.setCreatorAccount("wangsong");
        pmPriceRuleVo.setRemark("备注测试");
        pmPriceRuleVo.setPricingWay(PmPayBillStatusEnums.EFFECTIVE.getCode());
        pmPriceRuleVo.setCreatedTime(new Date());

        List<TbPmPriceRuleDeatils> pmPriceRuleDeatilsList = new ArrayList<>(16);
        TbPmPriceRuleDeatils tbPmPriceRuleDeatils = new TbPmPriceRuleDeatils();
        tbPmPriceRuleDeatils.setId(UUID.randomUUID().toString());
        tbPmPriceRuleDeatils.setRuleId(pmPriceRuleVo.getId());
        tbPmPriceRuleDeatils.setTowerId("001");
        tbPmPriceRuleDeatils.setTowerName("楼宇1");
        tbPmPriceRuleDeatils.setRoomId("001");
        tbPmPriceRuleDeatils.setRoomName("002");
        tbPmPriceRuleDeatils.setRecordStatus(new Byte(PmPayBillStatusEnums.EFFECTIVE.getCode()));
        tbPmPriceRuleDeatils.setCreatorAccount("wangsong");

        pmPriceRuleDeatilsList.add(tbPmPriceRuleDeatils);

        pmPriceRuleVo.setTbPmPriceRuleDeatilsList(pmPriceRuleDeatilsList);

        pmPriceRuleService.createPmPriceRule(pmPriceRuleVo);
    }
}