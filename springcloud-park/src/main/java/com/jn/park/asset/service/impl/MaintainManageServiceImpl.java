package com.jn.park.asset.service.impl;

import com.jn.park.asset.dao.MaintainManageDao;
import com.jn.park.asset.dao.TbAssetMaintainManageMapper;
import com.jn.park.asset.entity.TbAssetMaintainManage;
import com.jn.park.asset.entity.TbAssetMaintainManageCriteria;
import com.jn.park.asset.model.MaintainManageModel;
import com.jn.park.asset.service.MaintainManageService;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 维保管理impl
* @author： zhuyz
* @date： Created on 2019/5/5 16:33
* @version： v1.0
* @modified By:
*/
@Service
public class MaintainManageServiceImpl implements MaintainManageService {

    @Autowired
    private MaintainManageDao maintainManageDao;
    @Autowired
    private TbAssetMaintainManageMapper tbAssetMaintainManageMapper;

    /**
     * 根据维保信息id获取维保信息
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取维保信息")
    public MaintainManageModel getMaintain(String id) {
        MaintainManageModel maintainManageModel = maintainManageDao.getMaintain(id);
        return maintainManageModel;
    }

    /**
     *  维保信息录入
     * @param maintainManageModel
     * @return
     */
    @Override
    @ServiceLog(doAction = "维保信息录入")
    public Integer updateMaintain(MaintainManageModel maintainManageModel) {
        TbAssetMaintainManage tbAssetMaintainManage = new TbAssetMaintainManage();
        BeanUtils.copyProperties(maintainManageModel,tbAssetMaintainManage);
        TbAssetMaintainManageCriteria example = new TbAssetMaintainManageCriteria();
        example.createCriteria().andIdEqualTo(maintainManageModel.getId());
        int update = tbAssetMaintainManageMapper.updateByExampleSelective(tbAssetMaintainManage, example);
        return update;
    }
}
