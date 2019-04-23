package com.jn.park.gamtopic.service.impl;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.gamtopic.model.CareAddParam;
import com.jn.park.gamtopic.model.CareDetailsQueryParam;
import com.jn.park.gamtopic.model.CareUserDetails;
import com.jn.park.gamtopic.model.CareUserShow;
import com.jn.park.gamtopic.service.CareService;
import com.jn.park.gamtopic.vo.CareDetailsVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CareServiceImplTest {
    @Autowired
    private CareService careService;

    private CareAddParam careAddParam;
    /**
     * 关注者账号
     */
    private String careAccount;
    /**
     * 被关注者账号
     */
    private String serviceAccount;

    private  String careId;

    private Page  page;
    /**
     * 关注详情查看入参
     */
    private  CareDetailsQueryParam  careDetailsQueryParam;
    @Before
    public void setUp() throws Exception {
        //进行关注入参
        careAccount = "zhaoliu";
        serviceAccount = "qianqi";
        careAddParam = new CareAddParam();
        careAddParam.setAccount(serviceAccount);
        careAddParam.setReceiveType("0");
        careId = UUID.randomUUID().toString().replaceAll("-","");

        //page
        page = new Page();
        page.setPage(1);
        page.setRows(10);

        careDetailsQueryParam.setParamAccount(serviceAccount);
        careDetailsQueryParam.setPage(1);
        careDetailsQueryParam.setRows(10);


    }

    @Test
    public void addCareOperate() {
      int i =   careService.addCareOperate(careId,careAddParam,careAccount);
      assertThat(i,is(1));
    }

    @Test
    public void cancelCareOperate() {
        int i =   careService.cancelCareOperate(serviceAccount,careAccount);
        assertThat(i,is(1));
    }

    @Test
    public void findCareList() {
        PaginationData<List<CareUserShow>> date =  careService.findCareList(page,careAccount);
        assertThat((int )date.getTotal(),greaterThanOrEqualTo(0));
    }

    @Test
    public void findFansList() {
        PaginationData<List<CareUserShow>> date =  careService.findFansList(page,careAccount);
        assertThat((int )date.getTotal(),greaterThanOrEqualTo(0));
    }

    @Test
    public void findCareDetails() {
        CareDetailsVo date =  careService.findCareDetails(careDetailsQueryParam,careAccount);
        assertThat(anything(),anything());
    }

    @Test
    public void findCompanyCareInfo() {
        CareUserDetails details=  careService.findCompanyCareInfo(serviceAccount,careAccount);
        assertThat(anything(),anything());
    }
}