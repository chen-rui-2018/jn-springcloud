package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorInquiryInfo;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorListInfo;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * @Author: yangph
 * @Date: 2019/2/14 11:57
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class AdvisorServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(AdvisorServiceImplTest.class);

    @Autowired
    private AdvisorService advisorService;

    private String domain;
    private String sortTypes;
    private String keyWords;

    private AdvisorInquiryInfo advisorInquiryInfo=new AdvisorInquiryInfo();

    @Before
    public void setUp() throws Exception {
        domain="";
        sortTypes="";
        keyWords="";
        advisorInquiryInfo.setDomain(domain);
        advisorInquiryInfo.setKeyWords(keyWords);
        advisorInquiryInfo.setSortTypes(sortTypes);

    }

    @Test
    public void getServiceConsultantList() {
        PaginationData paginationData = advisorService.getServiceConsultantList(advisorInquiryInfo, Boolean.TRUE);
        List<AdvisorListInfo> list= (List<AdvisorListInfo>)paginationData.getRows();
        if(list!=null){
            for(AdvisorListInfo advisorListInfo:list){
                logger.info(advisorListInfo.toString());
            }
        }
        assertThat(list.size(),greaterThanOrEqualTo(0));

    }
}