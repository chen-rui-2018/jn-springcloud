package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import com.jn.enterprise.pd.personnel.model.FlowButtonModel;
import com.jn.enterprise.pd.personnel.model.FlowHistoryModel;
import com.jn.enterprise.pd.personnel.model.FlowNodeModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/18 12:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PersonnelFlowNodeBaseAbstractVo",description = "各节点表单内容对象的抽象父类")
public abstract class PersonnelFlowNodeBaseAbstractVo {

    /**
     * 设置本vo对应的节点
     * @return
     */
    public abstract PersonnelFlowNodeEnum getFlowNodeEnum();

    public PersonnelFlowNodeBaseAbstractVo() {
        initFlowNode(this.getFlowNodeEnum().getNodeNo());

    }

    @ApiModelProperty("数据库中当前流程所在的审批节点")
    private PersonnelFlowNodeEnum flowNodeEnum;

    @ApiModelProperty("节点编码(共4位，前2位代表大的阶段节点，后2位代表当前阶段的明细节点)")
    private String nodeNo;

    @ApiModelProperty("节点编码")
    private String nodeName;

    @ApiModelProperty("左侧审批阶段列表(0未开始，1进行中，2已完成)")
    private List<FlowNodeModel>leftNodeModelList=new ArrayList<>();

    @ApiModelProperty("当前阶段的审批明细列表(0未开始，1进行中，2已完成)")
    private List<FlowNodeModel>subNodeModelList=new ArrayList<>();

    @ApiModelProperty("审批按钮列表")
    private List<FlowButtonModel> buttonModelList=new ArrayList<>();

    @ApiModelProperty("审批历史记录列表")
    private List<FlowHistoryModel>historyModelList=new ArrayList<>();


    /**
     * 初始化流程节点
     * 1、左侧审批阶段列表
     * 2、当前阶段的审批明细列表
     * 3、审批按钮
     * 4、审批历史记录
     * @param nodeNo 数据库中当前流程所在的审批节点编码
     */
    protected void initFlowNode(String nodeNo) {
        String bigNode=nodeNo.substring(0,2);

        //
        for(PersonnelFlowNodeEnum nodeEnum:PersonnelFlowNodeEnum.values()){
            //遍历出 左侧审批阶段列表，节点编码是2位的才是阶段节点
            if(nodeEnum.getNodeNo().length()==2){
                int resutl=nodeEnum.getNodeNo().compareTo(bigNode);
                Integer nodeStatus=null;
                if(resutl>0){
                    nodeStatus=0;
                }else if(resutl==0){
                    nodeStatus=1;
                }else{
                    nodeStatus=2;
                }
                leftNodeModelList.add(new FlowNodeModel(nodeEnum.getNodeNo(),nodeEnum.getNodeName(),nodeStatus));
            }

            //遍历出 当前阶段的审批明细列表，节点编码是4位的才是阶段明细节点
            if(nodeEnum.getNodeNo().length()==4&&nodeEnum.getNodeNo().substring(0,2).equals(bigNode)){
                int resutl=nodeEnum.getNodeNo().compareTo(nodeNo);
                Integer nodeStatus=null;
                if(resutl>0){
                    nodeStatus=0;
                }else if(resutl==0){
                    nodeStatus=1;
                }else{
                    nodeStatus=2;
                }
                subNodeModelList.add(new FlowNodeModel(nodeEnum.getNodeNo(),nodeEnum.getNodeName(),nodeStatus));
            }
        }

    }


    public List<FlowNodeModel> getLeftNodeModelList() {
        return leftNodeModelList;
    }

    public List<FlowNodeModel> getSubNodeModelList() {
        return subNodeModelList;
    }

    public List<FlowButtonModel> getButtonModelList() {
        return buttonModelList;
    }

    public List<FlowHistoryModel> getHistoryModelList() {
        return historyModelList;
    }

    public String getNodeNo() {
        return this.getFlowNodeEnum().getNodeNo();
    }

    public String getNodeName() {
        return this.getFlowNodeEnum().getNodeName();
    }
}
