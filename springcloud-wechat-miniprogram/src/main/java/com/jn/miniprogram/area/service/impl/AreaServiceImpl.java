package com.jn.miniprogram.area.service.impl;


import com.jn.miniprogram.area.dao.MiniAreaMapper;
import com.jn.miniprogram.area.dao.TbMiniProgramAreaMapper;
import com.jn.miniprogram.area.entity.TbMiniProgramArea;
import com.jn.miniprogram.area.service.AreaService;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 小程序 area
 *
 * @author： shenph
 * @date： Created on 2018/11/24 11:13
 * @version： v1.0
 * @modified By: shenph
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private TbMiniProgramAreaMapper areaMapper;

    @Autowired
    private MiniAreaMapper miniAreaMapper;

    @ServiceLog(doAction = "删除area")
    @Override
    public boolean deleteByPrimaryKey(String areaId) {
        int deleteCount = areaMapper.deleteByPrimaryKey(areaId);
        if (deleteCount > 0) {
            return true;
        } else {
            return false;
        }
    }

    @ServiceLog(doAction = "添加area")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(TbMiniProgramArea area) {
        int insertCount = areaMapper.insert(area);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    @ServiceLog(doAction = "areaid查询")
    @Override
    public TbMiniProgramArea selectByPrimaryKey(String areaId) {
        return areaMapper.selectByPrimaryKey(areaId);
    }

    @ServiceLog(doAction = "修改area")
    @Override
    public boolean updateByPrimaryKeySelective(TbMiniProgramArea record) {
        int updateCount = areaMapper.updateByPrimaryKeySelective(record);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    @ServiceLog(doAction = "查询area")
    @Override
    public List<TbMiniProgramArea> queryArea() {
        return miniAreaMapper.queryArea();
    }
}
