package com.jn.enterprise.usercenterindex.service.impl;

import com.jn.enterprise.usercenterindex.dao.UserCenterIndexDao;
import com.jn.enterprise.usercenterindex.service.UserCenterIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: tangry
 * @Date: 2019/5/13
 * @Version 1.0
 */
@Transactional
@Service
public class UserCenterIndexServiceImpl implements UserCenterIndexService {

    @Autowired
    private UserCenterIndexDao userCenterIndexDao;


}
