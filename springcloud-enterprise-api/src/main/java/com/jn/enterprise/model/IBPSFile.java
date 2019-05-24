package com.jn.enterprise.model;

import java.io.Serializable;

/**
 * IBPS文件存储对象
 * @Author: huxw
 * @Date: 2019-5-22 19:56:08
 * @Version v1.0
 * @modified By:
 */
public class IBPSFile implements Serializable {

    private String id;

    private String fileName;

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
