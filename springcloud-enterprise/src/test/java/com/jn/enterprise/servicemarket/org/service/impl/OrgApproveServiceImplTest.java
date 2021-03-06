package com.jn.enterprise.servicemarket.org.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.service.OrgApproveService;
import com.jn.enterprise.servicemarket.org.vo.OrgApplyCountVo;
import com.jn.enterprise.servicemarket.org.vo.OrgApplyDetailVo;
import com.jn.enterprise.servicemarket.org.vo.OrgApplyVo;
import com.jn.system.model.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/28 14:22
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudEnterpriseApplication.class})
public class OrgApproveServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(OrgApproveServiceImplTest.class);

    @Autowired
    private OrgApproveService orgApproveService;

    private String orgId;
    private String account;

    @Before
    public void setUp() throws Exception {
        orgId = "1001211";
        account = "wangsong";
    }

    @Test
    public void getOrgApplyList() {
        OrgApplyParameter parameter = new OrgApplyParameter();
        PaginationData orgApplyList = orgApproveService.getOrgApplyList(parameter);
        List<OrgApplyVo> orgApplies = (List<OrgApplyVo>)orgApplyList.getRows();
        assertThat(orgApplies.size(),greaterThanOrEqualTo(0));
    }

    @Test
    public void getOrgCount() {
        OrgApplyCountVo orgCount = orgApproveService.getOrgCount();
        assertThat(orgCount,notNullValue());
    }

    @Test
    public void getOrgApplyDetail() {
        OrgApplyDetailVo orgApplyDetailVo = orgApproveService.getOrgApplyDetail(orgId);
        assertThat(orgApplyDetailVo,notNullValue());
    }


}
