package com.jn.park.asset.service.impl;

import com.jn.park.asset.dao.MaintainManageDao;
import com.jn.park.asset.dao.TbAssetMaintainManageMapper;
import com.jn.park.asset.dao.TbAssetMaintainRecordMapper;
import com.jn.park.asset.entity.TbAssetMaintainRecord;
import com.jn.park.asset.enums.AssetStatusEnums;
import com.jn.park.asset.model.MaintainManageModel;
import com.jn.park.asset.service.MaintainRecordService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
* 维保记录impl
* @author： zhuyz
* @date： Created on 2019/5/5 20:22
* @version： v1.0
* @modified By:
*/
@Service
public class MaintainRecordServiceImpl implements MaintainRecordService {

    @Autowired
    private MaintainManageDao maintainManageDao;
    @Autowired
    private TbAssetMaintainRecordMapper tbAssetMaintainRecordMapper;

    /**
     * 新增维保记录
     * @param maintainId
     * @param message
     * @param imgUrl
     * @return
     */
    @Override
    @ServiceLog(doAction = "新增维保记录")
    public Integer addRecord(User user,String assetNumber, String message, String imgUrl) {
        MaintainManageModel maintain = maintainManageDao.getMaintain(assetNumber);
        if (maintain != null){
            TbAssetMaintainRecord tbAssetMaintainRecord = new TbAssetMaintainRecord();
            tbAssetMaintainRecord.setId(UUID.randomUUID().toString());
            tbAssetMaintainRecord.setAssetNumber(maintain.getAssetNumber());
            tbAssetMaintainRecord.setMaintainId(maintain.getId());
            tbAssetMaintainRecord.setMaintainName(maintain.getName());
            tbAssetMaintainRecord.setTypeId(maintain.getTypeId());
            tbAssetMaintainRecord.setAssetType(maintain.getAssetType());
            tbAssetMaintainRecord.setMaintenanceTime(maintain.getMaintenanceTime());
            tbAssetMaintainRecord.setMessage(message);
            tbAssetMaintainRecord.setImgUrl(imgUrl);
            tbAssetMaintainRecord.setRecordStatus(Byte.parseByte(AssetStatusEnums.EFFECTIVE.getCode()));
            tbAssetMaintainRecord.setCreatorAccount(user.getAccount());
            tbAssetMaintainRecord.setCreateTime(new Date());
            int insert = tbAssetMaintainRecordMapper.insert(tbAssetMaintainRecord);
            return insert;
        }
        return -1;
    }
}
