package com.jn.system.vo;

import com.jn.system.model.SysTUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2018/11/8 17:09
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPostVO",description = "用于岗位分页信息返回")
public class SysPostVO implements Serializable {
    private static final long serialVersionUID = 6032780626084872278L;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("岗位名称")
    private String postName;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("岗位下具有的用户")
    private List<SysTUser> sysTUserList;

    public SysPostVO() {
    }

    public SysPostVO(String id, String postName, Date createTime, String status, List<SysTUser> sysTUserList) {
        this.id = id;
        this.postName = postName;
        this.createTime = createTime;
        this.status = status;
        this.sysTUserList = sysTUserList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SysTUser> getSysTUserList() {
        return sysTUserList;
    }

    public void setSysTUserList(List<SysTUser> sysTUserList) {
        this.sysTUserList = sysTUserList;
    }

    @Override
    public String toString() {
        return "SysPostVO{" +
                "id='" + id + '\'' +
                ", postName='" + postName + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", sysTUserList=" + sysTUserList +
                '}';
    }
}
