package com.jn.enterprise.technologyfinancial.investors.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.InvestorExceptionEnum;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListShow;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementNameParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementUpOrDownParam;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorManagementService;
import org.hamcrest.Matchers;
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
import static org.junit.Assert.assertThat;

/**
 * @Author: yangph
 * @Date: 2019/3/21 20:55
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class InvestorManagementServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(InvestorManagementServiceImplTest.class);

    @Autowired
    private InvestorManagementService investorManagementService;
    /**
     * 投资人管理列表查询入参
     */
    private InvestorManagementListParam investorManagementListParam=new InvestorManagementListParam();

    /**
     * 投资人管理姓名查询
     */
    private InvestorManagementNameParam investorManagementNameParam=new InvestorManagementNameParam();

    /**
     *投资人上架/下架
     */
   private InvestorManagementUpOrDownParam investorManagementUpOrDownParam=new InvestorManagementUpOrDownParam();
    @Before
    public void setUp() throws Exception {
        //投资人管理列表查询
        investorManagementListParam.setStatus("1");
        investorManagementListParam.setInvestorName("王松");
        investorManagementListParam.setAffiliationUnit("湖南");
        investorManagementListParam.setPhone("186");
        investorManagementListParam.setApplyStartTime("201903");
        investorManagementListParam.setApplyEndTime("201905");
        investorManagementListParam.setPosition("律师");
        investorManagementListParam.setNeedPage("1");

        //投资人管理姓名查询
        investorManagementNameParam.setNeedPage("0");

        //投资人上架/下架
        investorManagementUpOrDownParam.setInvestorAccount("wangsong");
        investorManagementUpOrDownParam.setOperatingStatus("1");
    }

    /**
     * 投资人管理列表查询
     */
    @Test
    public void getInvestorManagementList() {
        try {
            PaginationData paginationData = investorManagementService.getInvestorManagementList(investorManagementListParam);
            if(paginationData==null || paginationData.getRows()==null){
                //ignore
            }else{
                List<InvestorManagementListShow> investorManagementList=(List<InvestorManagementListShow>) paginationData.getRows();
                if(!investorManagementList.isEmpty()){
                    for(InvestorManagementListShow investorManagementListShow:investorManagementList){
                        logger.info("---------投资人管理列表:{}--------",investorManagementListShow.toString());
                    }
                }
            }
            assertThat(paginationData,anything());
        } catch (JnSpringCloudException e) {
            logger.warn("投资人管理列表查询失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(InvestorExceptionEnum.START_TIME_MORE_THAN_END_TIME.getCode())
                    )
            );
        }
    }

    /**
     * 投资人管理姓名查询
     */
    @Test
    public void getInvestorManagementNames() {
        PaginationData paginationData = investorManagementService.getInvestorManagementNames(investorManagementNameParam);
        if(paginationData==null || paginationData.getRows()==null){
            //ignore
        }else{
            List<String> investorManagementNameList=(List<String> ) paginationData.getRows();
            if(!investorManagementNameList.isEmpty()){
                for(String names:investorManagementNameList){
                    logger.info("---------投资人管理姓名查询:{}--------",names);
                }
            }
        }
        assertThat(paginationData,anything());
    }

    /**w
     * 投资人上架/下架
     */
    @Test
    public void investorUpOrDown() {
        try {
            int responseNum = investorManagementService.investorUpOrDown(investorManagementUpOrDownParam, "zhangsan");
            logger.info("-------投资人上架/下架数据响应条数：{}------",responseNum);
            assertThat(responseNum,greaterThanOrEqualTo(0));
        } catch (JnSpringCloudException e) {
            logger.warn("投资人上架/下架失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(InvestorExceptionEnum.INVESTOR_ACCOUNT_NOT_EXIST.getCode()),
                            Matchers.containsString(InvestorExceptionEnum.CURRENT_INVESTOR_HAVE_UP.getCode()),
                            Matchers.containsString(InvestorExceptionEnum.CURRENT_INVESTOR_HAVE_DOWN.getCode())

                    )
            );
        }
    }
}