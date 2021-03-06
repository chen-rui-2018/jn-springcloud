package com.jn.enterprise.company.model;

import com.jn.common.model.Page;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： huxw
 * @date： Created on 2019-3-29 15:35:41
 * @version： v1.0
 * @modified By:
 */
public class ServiceRecruitSearchParam extends Page implements Serializable {
    private String comId;
    private String searchFiled;
    private String type;
    private String status;
    private String sortTypes;
    private String whereTypes;
    private String approvalStatus;
    private Date beginDate;
    private Date endDate;

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSearchFiled() {
        return searchFiled;
    }

    public void setSearchFiled(String searchFiled) {
        this.searchFiled = searchFiled;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSortTypes() {
        return sortTypes;
    }

    public void setSortTypes(String sortTypes) {
        this.sortTypes = sortTypes;
    }

    public String getWhereTypes() {
        return whereTypes;
    }

    public void setWhereTypes(String whereTypes) {
        this.whereTypes = whereTypes;
    }

    @Override
    public String toString() {
        return "ServiceRecruitSearchParam{" +
                "comId='" + comId + '\'' +
                ", searchFiled='" + searchFiled + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", sortTypes='" + sortTypes + '\'' +
                ", whereTypes='" + whereTypes + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
