package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerDirectlyLeader;
import com.jn.hr.employee.model.DirectlyLeader;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author dt
 * @create 2019-04-30 下午 4:22
 */
public interface DirectlyLeaderMapper {
    DirectlyLeader selectByJobNumber(@Param("jobNumber") String jobNumber);
    int insertBatch(List<TbManpowerDirectlyLeader> list);
    @MapKey("jobNumber")
    Map<String,DirectlyLeader> selectAllDirectlyLeaderToMap();


}
