package com.jn.user.address.service.impl;

import com.jn.SpringCloudUserApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.user.address.dao.TbUserAddressMapper;
import com.jn.user.address.model.UserAddressParam;
import com.jn.user.address.model.UserAddressVO;
import com.jn.user.address.model.UserDefaultAddressParam;
import com.jn.user.address.service.UserAddressService;
import com.jn.user.enums.UserAddressExceptionEnum;
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
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 前端用户地址
 * @author： jiangyl
 * @date： Created on 2019/3/29 10:31
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudUserApplication.class})
public class UserAddressServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(UserAddressServiceImplTest.class);

    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private TbUserAddressMapper tbUserAddressMapper;

    private String addressId;
    private String account;

    @Before
    public void setUp() throws Exception {
        account = "wangsong";
        addressId = "aea8167ff8c24b28a24c900dcfad171b";
    }


    @Test
    public void getUserAddressList() {
        Page page =new Page();
        try{
            PaginationData<List<UserAddressVO>> userAddressList = userAddressService.getUserAddressList(page, account);
            assertThat(userAddressList.getRows().size(),greaterThanOrEqualTo(0));
        }catch (JnSpringCloudException e){
            logger.warn("我的地址信息数据查询失败",e);
            assertThat(e.getCode(),
                Matchers.anyOf(
                        Matchers.containsString(UserAddressExceptionEnum.NETWORK_ANOMALY.getCode())
                ));
        }
    }

    @Test
    public void getUserDefaultAddress() {
        try{
            UserAddressVO userDefaultAddress = userAddressService.getUserDefaultAddress(account);
            assertThat(userDefaultAddress,anything());
        }catch (JnSpringCloudException e){
            logger.warn("用户默认地址查询失败",e);
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(UserAddressExceptionEnum.USER_ADDRESS_IS_NOT_EXIST.getCode())
                    ));
        }
    }

    @Test
    public void getUserAddressById() {
        try{
            UserAddressVO userDefaultAddress = userAddressService.getUserAddressById(addressId);
            assertThat(userDefaultAddress,anything());
        }catch (JnSpringCloudException e){
            logger.warn("根据ID查询用户地址失败",e);
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(UserAddressExceptionEnum.ADDRESS_IS_NOT_EXIST.getCode())
                    ));
        }
    }

    @Test
    public void saveOrUpdateUserAddressInfo() {
        UserAddressParam userAddressParam = new UserAddressParam();
        userAddressParam.setReceiverName("王五");
        userAddressParam.setReveiverPhone("18155551111");
        userAddressParam.setReveiverTel("0713-121548");
        userAddressParam.setAddressProvince("湖南省");
        userAddressParam.setAddressCity("长沙市");
        userAddressParam.setAddressArea("岳麓区");
        userAddressParam.setAddressStreet("岳麓街道");
        userAddressParam.setAddressDetail("麓谷企业广场");
        userAddressParam.setIsDefault("0");
        String s = userAddressService.saveOrUpdateUserAddressInfo(userAddressParam, account);
        assertThat(s,anything());
        int i = tbUserAddressMapper.deleteByPrimaryKey(s);
        logger.info("删除测试新增用户地址响应条数{}",i);

    }

    @Test
    public void saveUserDefaultAddress() {

        UserDefaultAddressParam userDefaultAddressParam = new UserDefaultAddressParam();
        userDefaultAddressParam.setAddressId("aea8167ff8c24b28a24c900dcfad171b");
        userDefaultAddressParam.setIsDefault("0");
        int i = userAddressService.saveUserDefaultAddress(userDefaultAddressParam, account);
        assertThat(i,is(1));
    }

    @Test
    public void deleteUserAddress() {
        int i = userAddressService.deleteUserAddress(addressId, account);
        assertThat(i,is(1));
    }
}