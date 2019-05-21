package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerHonorWall;
import com.jn.hr.employee.model.HonorWall;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-23 上午 9:11
 */
public interface HonorWallMapper {
    int insertBatch(List<TbManpowerHonorWall> list);
    int deleteByJobNumber(@Param("jobNumber") String jobNumber);
    List<HonorWall> selectByJobNumber(@Param("jobNumber") String jobNumber);
}
