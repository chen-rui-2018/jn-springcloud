package com.jn.enterprise.model;

import java.io.Serializable;

/**
 * IBPS上传文件数据返回
 * @author： huxw
 * @date： Created on 2019-5-22 11:40:30
 * @version： v1.0
 * @modified By:
 */
public class IBPSUploadData implements Serializable {

    private String pk;
    private String ip;
    private String createBy;
    private String createTime;
    private String id;
    private String typeId;
    private String fileName;
    private String fileType;
    private String storeType;
    private String filePath;
    private String totalBytes;
    private String ext;
    private String note;
    private String creator;
    private String creatorName;
    private String isDel;
    private String md5;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTotalBytes() {
        return totalBytes;
    }

    public void setTotalBytes(String totalBytes) {
        this.totalBytes = totalBytes;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "IBPSUploadData{" +
                "pk='" + pk + '\'' +
                ", ip='" + ip + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", id='" + id + '\'' +
                ", typeId='" + typeId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", storeType='" + storeType + '\'' +
                ", filePath='" + filePath + '\'' +
                ", totalBytes='" + totalBytes + '\'' +
                ", ext='" + ext + '\'' +
                ", note='" + note + '\'' +
                ", creator='" + creator + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", isDel='" + isDel + '\'' +
                ", md5='" + md5 + '\'' +
                '}';
    }

    public String toJsonString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ",\"fileName\":\"" + fileName + "\"" +
                ",\"filePath\":\"" + filePath + "\"" +
                "}";
    }

    public String toSingleJsonString() {
        return "[{" +
                "\"id\":\"" + id + "\"" +
                ",\"fileName\":\"" + fileName + "\"" +
                ",\"filePath\":\"" + filePath + "\"" +
                "}]";
    }
}
