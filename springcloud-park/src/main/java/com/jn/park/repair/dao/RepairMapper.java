package com.jn.park.repair.dao;

import com.jn.park.repair.model.Repair;

/**
 * 物业服务-企业报修
 *
 * @author： yuanyy
 * @date： Created on 2019/5/22 16:52
 * @version： v1.0
 * @modified By:
 */
public interface RepairMapper {

    Repair selectRepairById(String id);

}
