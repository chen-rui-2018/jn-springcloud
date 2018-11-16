package com.jn.system.vo;

import com.jn.system.entity.TbSysFileGroup;
import com.jn.system.model.SysFileGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用于权限界面返回权限已经具有的文件组及所有文件组
 * @author： shaobao
 * @date： Created on 2018/11/15 10:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionFileGroupVO",description = "用于权限界面返回权限已经具有的文件组及所有文件组")
public class SysPermissionFileGroupVO implements Serializable {
    private static final long serialVersionUID = 3682263800524170374L;
    @ApiModelProperty("权限已经具有的文件组集合")
    private List<SysFileGroup> sysFileGroupList;
    @ApiModelProperty("所有文件组集合")
    private List<TbSysFileGroup> tbSysFileGroupAll;

    public SysPermissionFileGroupVO() {
    }

    public SysPermissionFileGroupVO(List<SysFileGroup> sysFileGroupList, List<TbSysFileGroup> tbSysFileGroupAll) {
        this.sysFileGroupList = sysFileGroupList;
        this.tbSysFileGroupAll = tbSysFileGroupAll;
    }

    public List<SysFileGroup> getSysFileGroupList() {
        return sysFileGroupList;
    }

    public void setSysFileGroupList(List<SysFileGroup> sysFileGroupList) {
        this.sysFileGroupList = sysFileGroupList;
    }

    public List<TbSysFileGroup> getTbSysFileGroupAll() {
        return tbSysFileGroupAll;
    }

    public void setTbSysFileGroupAll(List<TbSysFileGroup> tbSysFileGroupAll) {
        this.tbSysFileGroupAll = tbSysFileGroupAll;
    }

    @Override
    public String toString() {
        return "SysPermissionFileGroupVO{" +
                "sysFileGroupList=" + sysFileGroupList +
                ", tbSysFileGroupAll=" + tbSysFileGroupAll +
                '}';
    }
}
