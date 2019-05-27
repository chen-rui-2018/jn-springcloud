package com.jn.oa.overTime.service;


import com.jn.common.model.Result;
import com.jn.hr.model.VacationManagement;
import com.jn.oa.model.Leave;
import com.jn.oa.vo.LeaveApiVo;

import java.util.List;

/**
 * 加班管理service
 * @author： yuanyy
 * @date： Created on 2019/4/16 15:32
 * @version： v1.0
 * @modified By:
 **/
public interface OverTimeService {


    /**
     * 加班结束，记录加班小时到人力资源子系统
     * @param overTime
     * @return
     */
    Result insertOverTime(VacationManagement overTime);

}
