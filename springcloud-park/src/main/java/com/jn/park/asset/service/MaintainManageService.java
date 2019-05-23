package com.jn.park.asset.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.asset.model.AssetArticleLeaseModel;
import com.jn.park.asset.model.MaintainManageModel;

import java.util.List;

/**
* 维保管理service
* @author： zhuyz
* @date： Created on 2019/5/5 16:33
* @version： v1.0
* @modified By:
*/
public interface MaintainManageService {
    /**
     * 根据资产编号获取维保信息
     * @param assetNumber
     * @return
     */
    MaintainManageModel getMaintain(String assetNumber);

    /**
     * 分页获取维保设备列表
     * @param page
     * @return
     */
    PaginationData<List<MaintainManageModel>> getMaintainList(Page page);



}
