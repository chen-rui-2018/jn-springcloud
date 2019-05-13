package com.jn.park.park.dao;

import com.jn.park.park.model.ParkGeneral;
import com.jn.park.park.model.ParkName;
import com.jn.park.park.vo.ParkDetailsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkMapper {

    /**
     * 得到所有园区名
     *
     * @param
     * @return
     */

    List<ParkName> getParkName();

    /**
     * 根据ID获取对应园区详情
     *
     * @param
     * @return
     */

    List<ParkDetailsVo> getParkdetails(@Param("id") String id);

    /**
     * 获取园区介绍
     *
     * @param
     * @return
     */

    ParkGeneral getParkGeneral();


}