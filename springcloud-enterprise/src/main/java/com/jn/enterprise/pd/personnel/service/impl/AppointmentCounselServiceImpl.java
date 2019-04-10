package com.jn.enterprise.pd.personnel.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.channel.MessageSource;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.pd.personnel.dao.AppointmentCounselMapper;
import com.jn.enterprise.pd.personnel.dao.TbPdPersonnelAppointmentCounselMapper;
import com.jn.enterprise.pd.personnel.model.PersonnelAppointmentCounselModel;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Service;
import com.jn.enterprise.pd.personnel.service.AppointmentCounselService;

import javax.annotation.Resource;

/**
 * 预约辅导业务层实现类
 *
 * @author： wzy
 * @date： Created on 2019/3/18 19:39
 * @version： v1.0
 * @modified By:
 */
@Service
@EnableBinding(value = {MessageSource.class})
public class AppointmentCounselServiceImpl implements AppointmentCounselService {

    private static Logger logger = LoggerFactory.getLogger(AppointmentCounselServiceImpl.class);

    @Resource
    private AppointmentCounselMapper appointmentCounselMapper;

    @Resource
    private TbPdPersonnelAppointmentCounselMapper tbPdPersonnelAppointmentCounselMapper;

    /**
     * 根据关键字分页查询预约辅导列表
     *
     * @param pdCounselModel
     * @return
     */
    @Override
    @ServiceLog(doAction = "关键字分页查询预约辅导列表")
    public PaginationData selectAppointmentCounselListBySearchKey(PersonnelAppointmentCounselModel pdCounselModel, User user) {
        Page<Object> objects = PageHelper.startPage(pdCounselModel.getPage(), pdCounselModel.getRows());
        return new PaginationData(appointmentCounselMapper.selectAppointmentCounselListBySearchKey(pdCounselModel)
                , objects.getTotal());

    }
}
