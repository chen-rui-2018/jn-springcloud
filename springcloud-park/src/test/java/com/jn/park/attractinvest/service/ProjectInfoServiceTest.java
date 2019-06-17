package com.jn.park.attractinvest.service;

import com.jn.common.util.DateUtils;
import com.jn.park.attractinvest.entity.TbProjectEnterDetails;
import com.jn.park.attractinvest.vo.ProjectInfoVo;
import com.jn.park.pmpaybill.entity.TbPmPriceRuleDeatils;
import com.jn.park.pmpaybill.enums.PmPayBillStatusEnums;
import com.jn.system.model.User;
import com.netflix.discovery.converters.Auto;
import org.junit.FixMethodOrder;
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
    public void t003_enterpriseEnterHandle() throws ParseException {
        User user = new User();
        user.setAccount("wangsong");

        ProjectInfoVo projectInfoVo = new ProjectInfoVo();
        projectInfoVo.setId("586229588661633024");
        projectInfoVo.setCompanyId("586141980900196352");
        projectInfoVo.setLinker("李四");
        projectInfoVo.setLinkerPhone("15567899876");
        projectInfoVo.setLegalPersoner("胡恨三");
        projectInfoVo.setLegalPhone("18620297197");
        projectInfoVo.setRentStartTime(DateUtils.parseDate("2019-04-04","yyyy-MM-dd"));
        projectInfoVo.setRentMonthNum(12);
        projectInfoVo.setComAdmin("17316234376");

        List<TbProjectEnterDetails> tbProjectEnterDetailsList = new ArrayList<>(16);
//        TbProjectEnterDetails tbProjectEnterDetails = new TbProjectEnterDetails();
//        tbProjectEnterDetails.setEnterTower("金融中心");
//        tbProjectEnterDetails.setRoomId("586137438523490304");
//        tbProjectEnterDetails.setRoomArea("1000");
//        tbProjectEnterDetails.setRoomName("00004");
//        tbProjectEnterDetails.setRoomUnitPrice(new BigDecimal(30));
//        tbProjectEnterDetails.setPmUnitPrice(new BigDecimal(0.66));
//        tbProjectEnterDetailsList.add(tbProjectEnterDetails);

        TbProjectEnterDetails tbProjectEnterDetails1 = new TbProjectEnterDetails();
        tbProjectEnterDetails1.setEnterTower("金融中心");
        tbProjectEnterDetails1.setRoomId("586137236341260288");
        tbProjectEnterDetails1.setRoomArea("100");
        tbProjectEnterDetails1.setRoomName("00003");
        tbProjectEnterDetails1.setRoomUnitPrice(new BigDecimal(30));
        tbProjectEnterDetails1.setPmUnitPrice(new BigDecimal(0.88));
        tbProjectEnterDetailsList.add(tbProjectEnterDetails1);

        projectInfoVo.setTb_project_enter_details(tbProjectEnterDetailsList);

        projectInfoService.enterpriseEnterHandle(projectInfoVo,user);
    }
}