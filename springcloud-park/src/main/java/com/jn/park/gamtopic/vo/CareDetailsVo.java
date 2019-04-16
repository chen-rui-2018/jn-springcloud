package com.jn.park.gamtopic.vo;

import com.jn.common.model.PaginationData;
import com.jn.park.gamtopic.model.CareUserDetails;
import com.jn.park.gamtopic.model.DynamicWebShow;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/16 14:32
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="CareDetailsVo",description = "个人关注详情")
public class CareDetailsVo implements Serializable {
    @ApiModelProperty(value="此用户信息")
    private CareUserDetails userDetails;
    @ApiModelProperty(value="此用户动态列表")
    private PaginationData<List<DynamicWebShow>> dnmamicLixt;

    public CareUserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(CareUserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public PaginationData<List<DynamicWebShow>> getDnmamicLixt() {
        return dnmamicLixt;
    }

    public void setDnmamicLixt(PaginationData<List<DynamicWebShow>> dnmamicLixt) {
        this.dnmamicLixt = dnmamicLixt;
    }
}
