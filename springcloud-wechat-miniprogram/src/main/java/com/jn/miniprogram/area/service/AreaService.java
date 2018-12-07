package com.jn.miniprogram.area.service;


import com.jn.miniprogram.area.entity.TbMiniProgramArea;

import java.util.List;

/**
 * 小程序 area
 *
 * @author： shenph
 * @date： Created on 2018/11/24 11:13
 * @version： v1.0
 * @modified By: shenph
 */
public interface AreaService {

    boolean deleteByPrimaryKey(String areaId);

    boolean insert(TbMiniProgramArea record);

    TbMiniProgramArea selectByPrimaryKey(String areaId);

    boolean updateByPrimaryKeySelective(TbMiniProgramArea record);

    List<TbMiniProgramArea> queryArea();
}
