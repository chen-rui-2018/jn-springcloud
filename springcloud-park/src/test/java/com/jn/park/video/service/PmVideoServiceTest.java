package com.jn.park.video.service;

import com.jn.park.video.model.PmVideoItem;
import com.jn.park.video.vo.PmVideoVo;
import com.jn.system.model.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 物业-安防录像设备测试类
 *
 * @author： shaobao
 * @date： Created on 2019/5/17 9:47
 * @version： v1.0
 * @modified By:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PmVideoServiceTest {

    @Autowired
    private PmVideoService pmVideoService;

    @Test
    @Ignore
    public void insertVideoInfos() {
        pmVideoService.insertVideoInfos();
    }

    @Test
    public void updateVideoInfo(){
        pmVideoService.updateVideoInfo();
    }

}