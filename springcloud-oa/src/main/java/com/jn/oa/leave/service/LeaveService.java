package com.jn.oa.leave.service;


import com.jn.oa.model.Leave ;
import com.jn.oa.vo.LeaveApiVo ;

import java.util.List;

/**
 * @author： yuanyy
 * @date： Created on 2019/4/16 15:32
 * @version： v1.0
 * @modified By:
 **/
public interface LeaveService {

    /**
     * 根据条件查询请假列表
     * @param leave
     * @return
     */
    List<LeaveApiVo> searchLeaveListByCondition(Leave leave);

}
