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
}
