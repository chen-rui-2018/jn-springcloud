package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.model.PersonnelAppointmentCounselModel;

import java.util.List;

/**
 * 预约辅导dao
 *
 * @author： wzy
 * @date： Created on 2019/3/18 19:51
 * @version： v1.0
 * @modified By:
 */
public interface AppointmentCounselMapper {

    List<PersonnelAppointmentCounselModel> selectAppointmentCounselListBySearchKey(PersonnelAppointmentCounselModel pdCounselModel);
}
