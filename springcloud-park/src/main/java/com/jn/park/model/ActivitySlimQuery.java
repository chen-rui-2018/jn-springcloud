package com.jn.park.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 根据活动id,编辑当前活动类型
 *
 * @Author: chenr
 * @Date: 2018/12/24 09:35
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivitySlimQuery", description = "前台活动列表查询条件")
public class ActivitySlimQuery extends Page implements Serializable {
    @ApiModelProperty(value = "活动类型Id")
    private String typeId;
    @ApiModelProperty(value = "活动关键字:活动标题/活动地点/活动内容")
    private String keyWord;
    @ApiModelProperty(value = "开始时间(活动开始时间大于此时间 格式:'yyyy-MM-dd')")
    private String startTime;
    @ApiModelProperty(value = "结束时间(活动开始时间小于此时间 格式:'yyyy-MM-dd')")
    private String endTime;
    @ApiModelProperty(value = "排序字段名称(若要按感兴趣人数排序则传入'acti_Like',浏览数（acti_views）,报名人数（apply_num）,点赞人数（partic_num）,开始时间（acti_start_time)")
    private String orderBy;


    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
