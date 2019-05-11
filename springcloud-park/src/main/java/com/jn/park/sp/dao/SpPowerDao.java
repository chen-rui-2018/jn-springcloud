package com.jn.park.sp.dao;

import com.jn.park.sp.entity.TbSpPower;
import com.jn.park.sp.vo.SpPowerVo;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author： zhuyz
 * @date： Created on 2019/3/27 11:56
 * @version： v1.0
 * @modified By:
 */
public interface SpPowerDao {

    /**
     * 返回全部的权力清单(包含孩子)
     *
     * @param map
     * @return
     */
    List<SpPowerVo> findByPage(Map<String, Object> map);

    /**
     * 通过主键查询权力清单
     *
     * @param id
     * @return
     */
    TbSpPower selectPowerByKey(String id);

    /**
     * 根据父id查询子集合
     *
     * @param id
     * @return
     */
    List<SpPowerVo> selectChilds(String id);
}
