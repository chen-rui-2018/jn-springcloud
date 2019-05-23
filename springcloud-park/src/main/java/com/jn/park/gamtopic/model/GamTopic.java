package com.jn.park.gamtopic.model;

import com.jn.park.fileimg.model.FileImg;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/27 17:46
 * @version： v1.0
 * @modified By:
 */
public class GamTopic {

    @ApiModelProperty(value = "话题类容",required = true,example = "人生就有许多这样的奇迹，看似比登天还难的事...")
    @NotNull(message="话题类容不能为空")
    private String topicContent;
    @ApiModelProperty(value = "话题类型 1公开2关注可看3私密",example = "1")
    private String topicType;
    @ApiModelProperty(value = "文件",required = true)
    private List<FileImg> imgs;

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

    public List<FileImg> getImgs() {
        return imgs;
    }

    public void setImgs(List<FileImg> imgs) {
        this.imgs = imgs;
    }

    @Override
    public String toString() {
        return "GamTopic{" +
                "topicContent='" + topicContent + '\'' +
                ", topicType='" + topicType + '\'' +
                ", imgs=" + imgs +
                '}';
    }
}
