package com.jn.park.connect.service.Impl;

import com.jn.park.connect.dao.ServiceConnectDao;
import com.jn.park.connect.model.ServiceConnectModel;
import com.jn.park.connect.service.ServiceConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: tangry
 * @Date: 2019/4/26
 * @Version 1.0
 */
@Service
@Transactional
public class ServiceConnectServiceImpl implements ServiceConnectService {

    @Autowired
    private ServiceConnectDao serviceConnectDao;


    @Override
    public ServiceConnectModel getImgAndAddress(String entranceNameCode) {
        return serviceConnectDao.getImgAndAddress(entranceNameCode);
    }
}
