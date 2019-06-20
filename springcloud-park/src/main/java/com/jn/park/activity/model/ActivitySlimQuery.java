package com.jn.park.activity.model;

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
    @ApiModelProperty(value = "活动类型Id",example = "3bfe2b488e6e442c9bbf36c3d035c182")
    private String typeId;
    @ApiModelProperty(value = "活动关键字:活动标题/活动地点/活动内容",example = "***活动")
    private String keyWord;
    @ApiModelProperty(value = "开始时间(活动开始时间大于此时间 格式:'yyyy-MM-dd')",example = "2018-01-01")
    private String startTime;
    @ApiModelProperty(value = "结束时间(活动开始时间小于此时间 格式:'yyyy-MM-dd')",example = "2018-01-01")
    private String endTime;
    @ApiModelProperty(value = "排序字段名称(若要按感兴趣人数排序则传入'acti_Like',浏览数（acti_views）,报名人数（apply_num）,点赞人数（partic_num）,开始时间（acti_start_time)",example = "apply_num")
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

    @Override
    public String toString() {
        return "ActivitySlimQuery{" +
                "typeId='" + typeId + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", orderBy='" + orderBy + '\'' +
                '}';
    }
}
