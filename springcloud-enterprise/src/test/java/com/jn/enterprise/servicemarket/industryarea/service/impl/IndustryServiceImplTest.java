package com.jn.enterprise.servicemarket.industryarea.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.industryarea.model.Industry;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryData;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryParameter;
import com.jn.enterprise.servicemarket.industryarea.service.IndustryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/28 17:37
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudEnterpriseApplication.class})
public class IndustryServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(IndustryServiceImplTest.class);

    @Autowired
    private IndustryService industryService;

    private String id;
    private String account;

    @Before
    public void setUp() throws Exception {
        id = "1241";
        account = "wangsong";
    }

    @Test
    public void selectIndustryList() {
        IndustryParameter industryParameter = new IndustryParameter();
        PaginationData paginationData = industryService.selectIndustryList(industryParameter);
        List<Industry> industries = (List<Industry>)paginationData.getRows();
        assertThat(industries.size(),greaterThanOrEqualTo(0));
    }

    @Test
    public void saveOrUpdateIndustry() {
        IndustryData industryData = new IndustryData();
        industryData.setPreValue("金融科技");
        industryData.setId(id);
        Boolean aBoolean = industryService.saveOrUpdateIndustry(industryData, account);
        assertThat(aBoolean,anything());
    }

    @Test
    public void getIndustryDetail() {
        Industry industryDetail = industryService.getIndustryDetail(id);
        assertThat(industryDetail,notNullValue());
    }


}
