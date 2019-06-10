package com.jn.user.address.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.address.dao.TbUserAddressMapper;
import com.jn.user.address.entity.TbUserAddress;
import com.jn.user.address.entity.TbUserAddressCriteria;
import com.jn.user.address.model.UserAddressParam;
import com.jn.user.address.model.UserAddressVO;
import com.jn.user.address.model.UserDefaultAddressParam;
import com.jn.user.address.service.UserAddressService;
import com.jn.user.enums.UserAddressExceptionEnum;
import com.jn.user.usertag.dao.TbTagCodeMapper;
import com.jn.user.usertag.entity.TbTagCode;
import com.jn.user.usertag.entity.TbTagCodeCriteria;
import com.jn.user.usertag.model.TagCode;
import com.jn.user.usertag.service.UserTagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 前端用户地址
 * @author： jiangyl
 * @date： Created on 2019/3/6 16:48
 * @version： v1.0
 * @modified By:
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {
    private static Logger logger = LoggerFactory.getLogger(UserAddressServiceImpl.class);

    @Autowired
    private TbUserAddressMapper tbUserAddressMapper;

    /**
     * 数据状态 1:有效
     */
    private final static String RECORD_STATUS_VALID = "1";

    /**
     * 收货地址  1默认 0非默认
     */
    private final static String USER_ADDRESS_IS_DEFAULT = "1";
    private final static String USER_ADDRESS_IS_NOT_DEFAULT = "0";
    /**
     * 收货地址状态1有效0无效
     */
    private final static String USER_ADDRESS_IS_EFFECTIVE = "1";
    private final static String USER_ADDRESS_IS_NOT_EFFECTIVE = "0";

    @Override
    @ServiceLog(doAction = "获取当前用户地址列表")
    public PaginationData<List<UserAddressVO>> getUserAddressList(com.jn.common.model.Page page,String account){
        Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows() == 0 ? 15 : page.getRows());
        TbUserAddressCriteria addressCriteria = new TbUserAddressCriteria();
        addressCriteria.createCriteria().andUserAccountEqualTo(account).andAddressStatusEqualTo(USER_ADDRESS_IS_EFFECTIVE).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbUserAddress> tbUserAddresses = tbUserAddressMapper.selectByExample(addressCriteria);
        List<UserAddressVO> userAddressList = new ArrayList<>(16);
        for (TbUserAddress address:tbUserAddresses
             ) {
            UserAddressVO userAddress = new UserAddressVO();
            BeanUtils.copyProperties(address,userAddress);
            userAddressList.add(userAddress);
        }
        PaginationData<List<UserAddressVO>> data = new PaginationData(userAddressList, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "获取用户字典标签列表")
    public UserAddressVO getUserDefaultAddress(String account){
        TbUserAddressCriteria addressCriteria = new TbUserAddressCriteria();
        addressCriteria.createCriteria().andUserAccountEqualTo(account).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID)).andIsDefaultEqualTo(USER_ADDRESS_IS_DEFAULT);
        addressCriteria.setOrderByClause("modified_time desc");
        List<TbUserAddress> tbUserAddresses = tbUserAddressMapper.selectByExample(addressCriteria);
        UserAddressVO userAddressVO = new UserAddressVO();
        if(null==tbUserAddresses || tbUserAddresses.size() == 0 ){
            //无默认地址
            TbUserAddressCriteria addressCriteria1 = new TbUserAddressCriteria();
            addressCriteria1.createCriteria().andUserAccountEqualTo(account).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
            addressCriteria1.setOrderByClause("modified_time  desc");
            List<TbUserAddress> tbUserAddressesList = tbUserAddressMapper.selectByExample(addressCriteria1);
            if(tbUserAddressesList!=null && tbUserAddressesList.size()>0){
                BeanUtils.copyProperties(tbUserAddressesList.get(0),userAddressVO);
            }else{
                throw new JnSpringCloudException(UserAddressExceptionEnum.USER_ADDRESS_IS_NOT_EXIST);
            }
        }else{
            BeanUtils.copyProperties(tbUserAddresses.get(0),userAddressVO);
        }
        return userAddressVO;
    }

    @Override
    @ServiceLog(doAction = "根据地址ID查询地址详情")
    public UserAddressVO getUserAddressById(String addressId){
        TbUserAddress tbUserAddress = tbUserAddressMapper.selectByPrimaryKey(addressId);
        if(null == tbUserAddress){
            throw new JnSpringCloudException(UserAddressExceptionEnum.ADDRESS_IS_NOT_EXIST);
        }
        UserAddressVO userAddressVO = new UserAddressVO();
        BeanUtils.copyProperties(tbUserAddress,userAddressVO);
        return userAddressVO;
    }

    @Override
    @ServiceLog(doAction = "保存/修改用户地址")
    public String saveOrUpdateUserAddressInfo(UserAddressParam userAddressParam,String account){
        TbUserAddress tbUserAddress = new TbUserAddress();
        BeanUtils.copyProperties(userAddressParam,tbUserAddress);
        if(StringUtils.isNotEmpty(userAddressParam.getAddressId())){
            tbUserAddress.setModifiedTime(new Date());
            tbUserAddress.setModifierAccount(account);
            tbUserAddressMapper.updateByPrimaryKeySelective(tbUserAddress);
        }else{
            tbUserAddress.setAddressId(UUID.randomUUID().toString().replace("-",""));
            tbUserAddress.setUserAccount(account);
            tbUserAddress.setCreatorAccount(account);
            tbUserAddress.setCreatedTime(new Date());
            //新增时插入修改时间，方便后续用户获取默认地址不存在时取最新修改地址。
            tbUserAddress.setModifiedTime(new Date());
            tbUserAddress.setRecordStatus(new Byte(RECORD_STATUS_VALID));
            tbUserAddress.setAddressStatus(USER_ADDRESS_IS_EFFECTIVE);
            tbUserAddressMapper.insert(tbUserAddress);
        }
        if(StringUtils.equals(userAddressParam.getIsDefault(),USER_ADDRESS_IS_DEFAULT)){
            UserDefaultAddressParam userDefaultAddressParam = new UserDefaultAddressParam();
            BeanUtils.copyProperties(tbUserAddress,userDefaultAddressParam);
            this.saveUserDefaultAddress(userDefaultAddressParam,account);
        }
        return tbUserAddress.getAddressId();
    }

    @Override
    @ServiceLog(doAction = "处理用户默认地址")
    public int saveUserDefaultAddress(UserDefaultAddressParam userDefaultAddressParam,String account){
        logger.info("处理用户默认地址,接收的参数：{}",userDefaultAddressParam.toString());
        if(StringUtils.equals(userDefaultAddressParam.getIsDefault(),USER_ADDRESS_IS_DEFAULT)){
            //设为默认地址，将其他地址都设为非默认 account
            TbUserAddressCriteria tbUserAddressCriteria = new TbUserAddressCriteria();
            tbUserAddressCriteria.createCriteria().andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID)).andUserAccountEqualTo(account);
            TbUserAddress tbUserAddress = new TbUserAddress();
            tbUserAddress.setIsDefault(USER_ADDRESS_IS_NOT_DEFAULT);
            int i = tbUserAddressMapper.updateByExampleSelective(tbUserAddress, tbUserAddressCriteria);
            logger.info("将用户收 {} 货地址设置为非默认，响应条数 {}。",account,i);
        }
        TbUserAddress tbUserAddress = new TbUserAddress();
        BeanUtils.copyProperties(userDefaultAddressParam,tbUserAddress);
        return tbUserAddressMapper.updateByPrimaryKeySelective(tbUserAddress);
    }

    @Override
    @ServiceLog(doAction = "删除用户地址")
    public int deleteUserAddress(String addressId,String account){
        TbUserAddress tbUserAddress = new TbUserAddress();
        tbUserAddress.setAddressId(addressId);
        tbUserAddress.setAddressStatus(USER_ADDRESS_IS_NOT_EFFECTIVE);
        tbUserAddress.setModifierAccount(account);
        tbUserAddress.setModifiedTime(new Date());
        return tbUserAddressMapper.updateByPrimaryKeySelective(tbUserAddress);
    }
}
