package com.jn.park.asset.vo;

import com.jn.park.asset.model.AssetArticleLeaseModel;
import com.jn.park.asset.model.RoomInformationModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 搜索model
 *
 * @author： zhuyz
 * @date： Created on 2019/5/14 16:43
 * @version： v1.0
 * @modified By:
 */
public class AssetVo implements Serializable {
    private static final long serialVersionUID = -1792783098477683402L;

    @ApiModelProperty(value = "物品集合")
    private List<AssetArticleLeaseModel> assetArticleLeaseModelList;

    @ApiModelProperty(value = "房间集合")
    private List<RoomInformationModel> roomInformationModelList;

    public List<AssetArticleLeaseModel> getAssetArticleLeaseModelList() {
        return assetArticleLeaseModelList;
    }

    public void setAssetArticleLeaseModelList(List<AssetArticleLeaseModel> assetArticleLeaseModelList) {
        this.assetArticleLeaseModelList = assetArticleLeaseModelList;
    }

    public List<RoomInformationModel> getRoomInformationModelList() {
        return roomInformationModelList;
    }

    public void setRoomInformationModelList(List<RoomInformationModel> roomInformationModelList) {
        this.roomInformationModelList = roomInformationModelList;
    }
}
