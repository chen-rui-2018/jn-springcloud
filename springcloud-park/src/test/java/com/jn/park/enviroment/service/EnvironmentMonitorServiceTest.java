package com.jn.park.enviroment.service;

import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.RestTemplateUtil;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnvironmentMonitorServiceTest {

    @Autowired
    private EnvironmentMonitorService environmentMonitorService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void getEnvironmentMonitorRealTimeDate() {
        environmentMonitorService.getEnvironmentMonitorRealTimeDate(-1);
    }
}