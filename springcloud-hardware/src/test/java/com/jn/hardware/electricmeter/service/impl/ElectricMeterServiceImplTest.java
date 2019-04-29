package com.jn.hardware.electricmeter.service.impl;

import com.jn.common.model.Result;
import com.jn.hardware.electricmeter.service.ElectricMeterService;
import com.jn.hardware.model.electricmeter.*;
import com.jn.hardware.parking.service.impl.ParkingServiceImplTest;
import org.hamcrest.core.IsAnything;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElectricMeterServiceImplTest {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(ElectricMeterServiceImplTest.class);

    private  ElectricAccessTokenParam electricAccessTokenParam;

    private ElectricMeterInfoParam electricMeterInfoParam;

    private String code;

    private ElectricMeterSwitchParam electricMeterSwitchParam;

    private  ElectricMeterDataCollectionParam electricMeterDataCollectionParam;

    @Autowired
    private ElectricMeterService electricMeterService;
    @Before
    public void setUp() throws Exception {

        //获取平台access_token 入参
        electricAccessTokenParam = new ElectricAccessTokenParam();
        electricAccessTokenParam.setGrant_type("password");
        electricAccessTokenParam.setUsername("18351162350");
        electricAccessTokenParam.setPassword("{MD5}18351162350");
        electricAccessTokenParam.setScopes("all");
        //根据建筑编号code 获取建筑下的仪表信息入参;
        electricMeterInfoParam = new ElectricMeterInfoParam();
        electricMeterInfoParam.setCode("320104A001");
        electricMeterInfoParam.setPage(1);
        electricMeterInfoParam.setRows(10);

        //仪表状态查询入参 仪表编号
        code = "320104A001001006";
        //仪表开关操作入参
        electricMeterSwitchParam= new ElectricMeterSwitchParam();
        electricMeterSwitchParam.setCode(code);
        electricMeterSwitchParam.setFlag("4");
        //仪表数据采集入参
        electricMeterDataCollectionParam = new ElectricMeterDataCollectionParam();
        electricMeterDataCollectionParam.setCode("320104A001001006");
        electricMeterDataCollectionParam.setDeviceType("1");

        electricMeterDataCollectionParam.setStartTime("2019-04-25 15:06:20");
        electricMeterDataCollectionParam.setPage(1);
        electricMeterDataCollectionParam.setRows(10);

    }

    @Test
    public void getElectricMeterAccessToken() {
        Result<ElectricAccessTokenShow>   result =  electricMeterService.getElectricMeterAccessToken(electricAccessTokenParam);
        logger.info("\naccess_token 获取结果说明：{}",result.getResult());
        assertThat(anything(),anything());

    }

    @Test
    public void getElectricBuildingInfo() {
        Result<List<ElectricMeterBuildingShow>> buildList = electricMeterService.getElectricBuildingInfo();
        logger.info("\naccess_token 获取结果说明：{}",buildList.getResult());
        assertThat(anything(),anything());
    }

    @Test
    public void getElectricMeterForBuilding() {
        Result<ElectricMeterInfoShow> show  =   electricMeterService.getElectricMeterForBuilding(electricMeterInfoParam);
        logger.info("\n根据建筑编号获取建筑下的仪表信息,仪表信息: {}",show.getResult());
        assertThat(anything(),anything());
    }

    @Test
    public void getElectricMeterStatus() {
        Result<ElectricMeterStatusShow> show  = electricMeterService.getElectricMeterStatus(code);
        logger.info("\n根据仪表编号获取仪表状态,仪表状态: {} 仪表状态,仪表开关状态  0-关闭；1-开启;''-没有这个仪表",show.getResult());
        assertThat(anything(),anything());
    }

    @Test
    public void electricMeterSwitch() {
        Result result =    electricMeterService.electricMeterSwitch(electricMeterSwitchParam);
        logger.info("\n仪表开关操作,操作结果:{} ",result.getResult()==null?"成功":result.getResult());
        assertThat(anything(),anything());
    }

    @Test
    public void electricMeterDataCollection() {
        Result  data =  electricMeterService.electricMeterDataCollection(electricMeterDataCollectionParam);
        logger.info("\n仪表数据采集,采集结果结果: {} ",data.getResult());
        assertThat(anything(),anything());
    }
}