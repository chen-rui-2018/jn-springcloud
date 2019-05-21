package com.jn.park.attractinvest.service;

import com.netflix.discovery.converters.Auto;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}