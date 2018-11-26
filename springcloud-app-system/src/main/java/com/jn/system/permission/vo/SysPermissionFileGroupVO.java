package com.jn.system.permission.vo;

import com.jn.system.file.model.SysFileGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用于权限界面返回权限已经具有的文件组及所有文件组
 *
 * @author： shaobao
 * @date： Created on 2018/11/15 10:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionFileGroupVO", description = "用于权限界面返回权限已经具有的文件组及所有文件组")
public class SysPermissionFileGroupVO implements Serializable {
    private static final long serialVersionUID = 3682263800524170374L;
    @ApiModelProperty("权限已经具有的文件组集合")
    private List<SysFileGroup> sysFileGroupOfPermissionList;
    @ApiModelProperty("所有文件组集合")
    private List<SysFileGroup> otherFileGroupList;

    public SysPermissionFileGroupVO() {
    }

    public SysPermissionFileGroupVO(List<SysFileGroup> sysFileGroupOfPermissionList, List<SysFileGroup> otherFileGroupList) {
        this.sysFileGroupOfPermissionList = sysFileGroupOfPermissionList;
        this.otherFileGroupList = otherFileGroupList;
    }

    public List<SysFileGroup> getSysFileGroupOfPermissionList() {
        return sysFileGroupOfPermissionList;
    }

    public void setSysFileGroupOfPermissionList(List<SysFileGroup> sysFileGroupOfPermissionList) {
        this.sysFileGroupOfPermissionList = sysFileGroupOfPermissionList;
    }

    public List<SysFileGroup> getOtherFileGroupList() {
        return otherFileGroupList;
    }

    public void setOtherFileGroupList(List<SysFileGroup> otherFileGroupList) {
        this.otherFileGroupList = otherFileGroupList;
    }

    @Override
    public String toString() {
        return "SysPermissionFileGroupVO{" +
                "sysFileGroupOfPermissionList=" + sysFileGroupOfPermissionList +
                ", otherFileGroupList=" + otherFileGroupList +
                '}';
    }
}
