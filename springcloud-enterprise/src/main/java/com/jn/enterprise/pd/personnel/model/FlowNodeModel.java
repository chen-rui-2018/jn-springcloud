package com.jn.enterprise.pd.personnel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author： huangbq
 * @date： Created on 2019/3/18 12:33
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FlowNodeModel",description = "审批节点")
public class FlowNodeModel {

    @ApiModelProperty("节点编码")
    private String nodeNo;
    @ApiModelProperty("节点名称")
    private String nodeName;
    @ApiModelProperty("节点的状态(0未开始，1进行中，2已完成)")
    private Integer nodeStatus;


    public String getNodeNo() {
        return nodeNo;
    }

    public void setNodeNo(String nodeNo) {
        this.nodeNo = nodeNo;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Integer getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(Integer nodeStatus) {
        this.nodeStatus = nodeStatus;
    }

    public FlowNodeModel(String nodeNo, String nodeName, Integer nodeStatus) {
        this.nodeNo = nodeNo;
        this.nodeName = nodeName;
        this.nodeStatus = nodeStatus;
    }
}
