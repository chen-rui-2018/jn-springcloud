package com.jn.park.attractinvest.service;

import com.jn.common.util.DateUtils;
import com.jn.park.attractinvest.entity.TbProjectEnterDetails;
import com.jn.park.attractinvest.vo.ProjectInfoVo;
import com.jn.park.pmpaybill.entity.TbPmPriceRuleDeatils;
import com.jn.park.pmpaybill.enums.PmPayBillStatusEnums;
import com.jn.system.model.User;
import com.netflix.discovery.converters.Auto;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectInfoServiceTest {

    @Autowired
    private ProjectInfoService projectInfoService;

    @Test
    public void t001_updateProjectInfoStatus() {
        projectInfoService.updateProjectInfoStatus();
    }

    @Test
    public void t002_projectRemind() {
        projectInfoService.projectRemind();
    }

    @Test
    @Ignore
    public void t003_enterpriseEnterHandle() throws ParseException {
        User user = new User();
        user.setAccount("wangsong");

        ProjectInfoVo projectInfoVo = new ProjectInfoVo();
        projectInfoVo.setId("593546789865390080");
        projectInfoVo.setCompanyId("9ee2a3d4c79e4caa82060417967cdf31");
        projectInfoVo.setCompanyName("江苏华星税务师事务所有限公司");
        projectInfoVo.setLinker("沈学君");
        projectInfoVo.setLinkerPhone("15367881712");
        projectInfoVo.setRentStartTime(DateUtils.parseDate("2019-06-26","yyyy-MM-dd"));
        projectInfoVo.setRentMonthNum(12);
        projectInfoVo.setComAdmin("15367881712");
        projectInfoVo.setMainTowerId("590188353895268352");

        List<TbProjectEnterDetails> tbProjectEnterDetailsList = new ArrayList<>(16);
        TbProjectEnterDetails tbProjectEnterDetails = new TbProjectEnterDetails();
        tbProjectEnterDetails.setEnterTower("住建集团");
        tbProjectEnterDetails.setRoomId("585880831726190606");
        tbProjectEnterDetails.setRoomArea("53.34");
        tbProjectEnterDetails.setRoomName("2F2014室");
        tbProjectEnterDetails.setRoomUnitPrice(new BigDecimal(45));
        tbProjectEnterDetails.setPmUnitPrice(new BigDecimal(1));
        tbProjectEnterDetails.setTowerId("590188211473481728");
        tbProjectEnterDetailsList.add(tbProjectEnterDetails);

        TbProjectEnterDetails tbProjectEnterDetails1 = new TbProjectEnterDetails();
        tbProjectEnterDetails1.setEnterTower("五号楼C");
        tbProjectEnterDetails1.setRoomId("585880831726190593");
        tbProjectEnterDetails1.setRoomArea("117");
        tbProjectEnterDetails1.setRoomName("816");
        tbProjectEnterDetails1.setRoomUnitPrice(new BigDecimal(50));
        tbProjectEnterDetails1.setPmUnitPrice(new BigDecimal(1));
        tbProjectEnterDetails1.setTowerId("590183128086085632");
        tbProjectEnterDetailsList.add(tbProjectEnterDetails1);

        TbProjectEnterDetails tbProjectEnterDetails2= new TbProjectEnterDetails();
        tbProjectEnterDetails2.setEnterTower("撇洪沟");
        tbProjectEnterDetails2.setRoomId("585880831726190608");
        tbProjectEnterDetails2.setRoomArea("93");
        tbProjectEnterDetails2.setRoomName("运粮河西侧环境整治项目2栋-2号楼");
        tbProjectEnterDetails2.setRoomUnitPrice(new BigDecimal(2850));
        tbProjectEnterDetails2.setPmUnitPrice(new BigDecimal(1));
        tbProjectEnterDetails2.setTowerId("590188353895268352");
        tbProjectEnterDetailsList.add(tbProjectEnterDetails2);

        projectInfoVo.setTb_project_enter_details(tbProjectEnterDetailsList);

        projectInfoService.enterpriseEnterHandle(projectInfoVo,user);
    }
}