package com.jn.park.asset.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.asset.dao.MaintainManageDao;
import com.jn.park.asset.dao.TbAssetMaintainCompanyMapper;
import com.jn.park.asset.dao.TbAssetMaintainManageMapper;
import com.jn.park.asset.dao.TbAssetMaintainRecordMapper;
import com.jn.park.asset.entity.*;
import com.jn.park.asset.enums.AssetStatusEnums;
import com.jn.park.asset.model.AssetMaintainCompanyModel;
import com.jn.park.asset.model.AssetMaintainRecordModel;
import com.jn.park.asset.model.MaintainManageModel;
import com.jn.park.asset.service.MaintainManageService;
import com.jn.system.log.annotation.ServiceLog;
import com.sun.org.apache.bcel.internal.generic.I2F;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private TbAssetMaintainRecordMapper tbAssetMaintainRecordMapper;
    @Autowired
    private TbAssetMaintainCompanyMapper tbAssetMaintainCompanyMapper;

    /**
     * 根据资产编号id获取维保信息
     * @param assetNumber
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取维保信息")
    public MaintainManageModel getMaintain(String assetNumber) {
        MaintainManageModel maintainManageModel = maintainManageDao.getMaintain(assetNumber);
        //创建维保厂家model
        AssetMaintainCompanyModel assetMaintainCompanyModel = new AssetMaintainCompanyModel();
        //通过厂家id查询对应的厂家
        TbAssetMaintainCompany tbAssetMaintainCompany = tbAssetMaintainCompanyMapper.selectByPrimaryKey(maintainManageModel.getCompanyId());
        if (tbAssetMaintainCompany != null){
            BeanUtils.copyProperties(tbAssetMaintainCompany,assetMaintainCompanyModel);
            maintainManageModel.setAssetMaintainCompanyModel(assetMaintainCompanyModel);
        }
        //维保厂家信息
        maintainManageModel.setAssetMaintainCompanyModel(assetMaintainCompanyModel);
        //创建维保记录集合
        List<AssetMaintainRecordModel> assetMaintainRecordModelList = new ArrayList<>();
        //通过资产编号查询维保记录
        TbAssetMaintainRecordCriteria tbAssetMaintainRecordCriteria = new TbAssetMaintainRecordCriteria();
        TbAssetMaintainRecordCriteria.Criteria criteria = tbAssetMaintainRecordCriteria.createCriteria();
        criteria.andAssetNumberEqualTo(maintainManageModel.getAssetNumber());
        criteria.andRecordStatusEqualTo(Byte.parseByte(AssetStatusEnums.EFFECTIVE.getCode()));
        List<TbAssetMaintainRecord> tbAssetMaintainRecords = tbAssetMaintainRecordMapper.selectByExample(tbAssetMaintainRecordCriteria);
        if (tbAssetMaintainRecords != null){
            for (TbAssetMaintainRecord tbAssetMaintainRecord : tbAssetMaintainRecords) {
                //创建维保记录model
                AssetMaintainRecordModel assetMaintainRecordModel = new AssetMaintainRecordModel();
                BeanUtils.copyProperties(tbAssetMaintainRecord,assetMaintainRecordModel);
                assetMaintainRecordModelList.add(assetMaintainRecordModel);
            }
            //维保记录集合
            maintainManageModel.setAssetMaintainRecordModels(assetMaintainRecordModelList);
        }
        return maintainManageModel;
    }

    /**
     * 分页获取维保设备列表
     * @param page
     * @return
     */
    @Override
    @ServiceLog(doAction = "分页获取维保设备列表")
    public PaginationData<List<MaintainManageModel>> getMaintainList(Page page) {
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        List<MaintainManageModel> maintainManageModelList = maintainManageDao.getMaintainList();
        PaginationData<List<MaintainManageModel>> data = new PaginationData<>(maintainManageModelList,objects.getTotal());
        return data;
    }



}
