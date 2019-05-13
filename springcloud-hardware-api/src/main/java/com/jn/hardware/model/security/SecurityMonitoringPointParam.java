package com.jn.hardware.model.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/5/9 10:13
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SecurityMonitoringPointParam",description = "监控点列表查询入参实体")
public class SecurityMonitoringPointParam implements Serializable {

    private static final long serialVersionUID = 3202511223983594561L;
    @ApiModelProperty(value ="页码,范围 ( 0 , ~ )",required = true,example = "1")
    @NotBlank(message = "页码不能为空")
    private Integer  pageNo;
    @ApiModelProperty(value ="页面分页大小,范围 ( 0 , ~ )",required = true,example = "10")
    @NotBlank(message = "页面分页大小 不能为空")
    private Integer  pageSize;
    @ApiModelProperty(value = "级联关系 0：非级联 1：级联 2：不限（包括级联和非级联） 默认取值：2",example = "2")
    private Integer  isCascade;
    @ApiModelProperty(value = "监控点唯一标识集 多个值使用英文逗号分隔",example = "a8f74dcf14f846bb95c8dff6684f897e, ...")
    private String   cameraIndexCodes;
    @ApiModelProperty(value = "监控点名称（最大长度32） 支持中英文字符，不能包含 ' / \\ : * ? \" < > |，支持模糊搜索",example = "193GB_IPCamera")
    private String   cameraName;
    @ApiModelProperty(value = "所属编码设备唯一标识 （最大长度64） 若指定编码设备的值，则只查询本级监控点；",example = "73c2e4903a4547f8812a26d329802cd0")
    private String   encodeDevIndexCode;
    @ApiModelProperty(value = "   区域唯一标识（64）",example = "645f0a62-05ff-4396-a687-944c3f0406d6")
    private String   regionIndexCode;
    @ApiModelProperty(value = "树编号。综合安防平台当前未使用该字段。该字段预留")
    private String   treeCode;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getIsCascade() {
        return isCascade;
    }

    public void setIsCascade(Integer isCascade) {
        this.isCascade = isCascade;
    }

    public String getCameraIndexCodes() {
        return cameraIndexCodes;
    }

    public void setCameraIndexCodes(String cameraIndexCodes) {
        this.cameraIndexCodes = cameraIndexCodes;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getEncodeDevIndexCode() {
        return encodeDevIndexCode;
    }

    public void setEncodeDevIndexCode(String encodeDevIndexCode) {
        this.encodeDevIndexCode = encodeDevIndexCode;
    }

    public String getRegionIndexCode() {
        return regionIndexCode;
    }

    public void setRegionIndexCode(String regionIndexCode) {
        this.regionIndexCode = regionIndexCode;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    @Override
    public String toString() {
        return "SecurityMonitoringPointParam{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", isCascade=" + isCascade +
                ", cameraIndexCodes='" + cameraIndexCodes + '\'' +
                ", cameraName='" + cameraName + '\'' +
                ", encodeDevIndexCode='" + encodeDevIndexCode + '\'' +
                ", regionIndexCode='" + regionIndexCode + '\'' +
                ", treeCode='" + treeCode + '\'' +
                '}';
    }
}
