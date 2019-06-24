package com.jn.enterprise.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * IBPS文件存储对象
 * @Author: huxw
 * @Date: 2019-5-22 19:56:08
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "IBPSFile",description = "IBPS文件格式展示")
public class IBPSFile implements Serializable {
    @ApiModelProperty(value = "文件id")
    private String id;
    @ApiModelProperty(value = "文件名称")
    private String fileName;
    @ApiModelProperty(value = "文件路径")
    private String filePath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "IBPSFile{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
