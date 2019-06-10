package com.jn.park.gamtopic.model;

import com.jn.common.model.Page;
import com.jn.park.fileimg.model.FileImg;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/27 17:46
 * @version： v1.0
 * @modified By:
 */
public class GamTopicParam extends Page implements Serializable {

    @ApiModelProperty(value = "话题类容",example = "人生就有许多这样的奇迹，看似比登天还难的事...")
    private String topicContent;
    @ApiModelProperty(value = "话题类型 1公开2关注可看3私密",example = "1")
    private String topicType;
    @ApiModelProperty(value = "话题创建人",example = "wangsong")
    private String creatorAcount;

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getCreatorAcount() {
        return creatorAcount;
    }

    public void setCreatorAcount(String creatorAcount) {
        this.creatorAcount = creatorAcount;
    }
}
