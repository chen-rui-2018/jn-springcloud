package com.jn.enterprise.pd.personnel.vo;

import com.jn.common.util.StringUtils;
import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import com.jn.enterprise.pd.personnel.model.PersonnelFlowFormBaseAbstractModel;
import com.jn.enterprise.pd.personnel.model.PersonnelFlowNodeModel;
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

    @ApiModelProperty("当前所在的审批节点编码")
    private String nodeNo;

    @ApiModelProperty("左侧审批阶段列表(0未开始，1进行中，2已完成)")
    private List<PersonnelFlowNodeModel>leftNodeModelList=new ArrayList<>();

    @ApiModelProperty("当前阶段的审批明细列表(0未开始，1进行中，2已完成)")
    private List<PersonnelFlowNodeModel>subNodeModelList=new ArrayList<>();

    @ApiModelProperty("下一步提交表单的地址")
    private String nextFormAction;

    public PersonnelFlowNodeBaseAbstractVo(String nodeNo) {
        this.nodeNo = nodeNo;
        String bigNode=nodeNo.substring(0,2);

        //遍历出 左侧审批阶段列表
        for(PersonnelFlowNodeEnum nodeEnum:PersonnelFlowNodeEnum.values()){
            //节点编码是2位的才是阶段节点
            if(nodeEnum.getNodeNo().length()!=2){
                continue;
            }

            int resutl=nodeEnum.getNodeNo().compareTo(bigNode);
            Integer nodeStatus=null;
            if(resutl>0){
                nodeStatus=0;
            }else if(resutl==0){
                nodeStatus=1;
            }else{
                nodeStatus=2;
            }
            leftNodeModelList.add(new PersonnelFlowNodeModel(nodeEnum.getNodeNo(),nodeEnum.getNodeName(),nodeStatus));
        }


        //遍历出 当前阶段的审批明细列表
        for(PersonnelFlowNodeEnum nodeEnum:PersonnelFlowNodeEnum.values()){
            //节点编码是4位的才是阶段明细节点
            if(nodeEnum.getNodeNo().length()!=4||!nodeEnum.getNodeNo().substring(0,2).equals(bigNode)){
                continue;
            }

            int resutl=nodeEnum.getNodeNo().compareTo(nodeNo);

            Integer nodeStatus=null;
            if(resutl>0){
                nodeStatus=0;
            }else if(resutl==0){
                nodeStatus=1;
            }else{
                nodeStatus=2;
            }
            leftNodeModelList.add(new PersonnelFlowNodeModel(nodeEnum.getNodeNo(),nodeEnum.getNodeName(),nodeStatus));



        }
    }

    public  String getNodeNo(){
        return this.nodeNo;
    }

    public List<PersonnelFlowNodeModel> getLeftNodeModelList() {
        return leftNodeModelList;
    }

    public List<PersonnelFlowNodeModel> getSubNodeModelList() {
        return subNodeModelList;
    }

    public abstract String getNextFormAction();
}
