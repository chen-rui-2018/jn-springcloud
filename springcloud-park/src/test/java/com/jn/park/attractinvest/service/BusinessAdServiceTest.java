package com.jn.park.attractinvest.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.park.attractinvest.model.BusinessAdContent;
import com.jn.park.attractinvest.model.BusinessAdDynamic;
import com.jn.park.attractinvest.model.BusinessAdPage;
import com.jn.park.attractinvest.model.BusinessAdPolicy;
import com.jn.park.attractinvest.service.BusinessAdService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BusinessAdServiceTest {

    @Autowired
    private BusinessAdService businessAdService;

    @Test
    public void getBusinessAdContent() {
        BusinessAdPage page = new BusinessAdPage();
        page.setPage(1);
        page.setRows(10);
        page.setParkId("568531381404041216");
        PaginationData<List<BusinessAdContent>> data = businessAdService.getBusinessAdContent(page);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void getBusinessAdDynamic() {
        List<BusinessAdDynamic> data = businessAdService.getBusinessAdDynamic();
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void getBusinessAdPolicy() {
        List<BusinessAdPolicy> data = businessAdService.getBusinessAdPolicy();
        Assert.assertThat(data, Matchers.anything());

    }

    @Test
    public void getBusinessAdContentInfo() {
        try {
            BusinessAdContent data = businessAdService.getBusinessAdContentInfo("570295002484178944");
            Assert.assertThat(data, Matchers.anything());
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void getBusinessAdDynamicInfo() {
        try {
            BusinessAdDynamic data = businessAdService.getBusinessAdDynamicInfo("570295002484178944");
            Assert.assertThat(data, Matchers.anything());
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void getBusinessAdPolicyInfo() {
        try {
            BusinessAdPolicy data = businessAdService.getBusinessAdPolicyInfo("570295002484178944");
            Assert.assertThat(data, Matchers.anything());
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void updateBusinessAdStatus() {
        businessAdService.updateBusinessAdStatus();
    }
}