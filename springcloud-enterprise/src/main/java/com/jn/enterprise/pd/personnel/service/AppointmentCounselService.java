package com.jn.enterprise.pd.personnel.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.pd.personnel.model.PersonnelAppointmentCounselModel;
import com.jn.system.model.User;

/**
 * 预约辅导service
 *
 * @author： wzy
 * @date： Created on 2019/3/18 19:38
 * @version： v1.0
 * @modified By:
 */
public interface AppointmentCounselService {

    /**
     * 根据关键字分页查询预约辅导列表
     *
     * @param pdCounselModel
     * @return
     */
    PaginationData selectAppointmentCounselListBySearchKey(PersonnelAppointmentCounselModel pdCounselModel, User user);
}
