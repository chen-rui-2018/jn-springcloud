package com.jn.enterprise.data.vo;

import com.jn.enterprise.data.model.InputFormatModel;
import com.jn.enterprise.data.model.TargetModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 18:02
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TabVO",description = "tab表单")
public class TabVO implements Serializable {

    @ApiModelProperty(value = "tabId",example = "001")
    private String tabId;

    @ApiModelProperty(value = "tab名称",example = "XXXX填报表")
    private String tabName;
    @ApiModelProperty(value = "表类型（0：上月填报值；1：上年同期值；2：上月上年同期值；3增幅）" ,example = "1")
    private String tabClumnTargetShow;
    @ApiModelProperty(value = "表填报列类型（0：累计值；1：本期值）",example = "0")
    private String tabClumnType;
    @ApiModelProperty(value = "状态（1：有效；0作废）",example = "1")
    private String status ;
    @ApiModelProperty(value = "表生成模式（0:普通模板1：科技园模板）" ,example = "1")
    private String tabCreateType;
    @ApiModelProperty(value = "tab表的显示顺序（因为可能会存在一组tabtab1tab2）",example = "23")
    private String order;
    @ApiModelProperty(value = "tab指标集合",example = "23")
    private List<TargetModelVO> targetList;

    @ApiModelProperty(value = "tab指标集合所有的指标填写格式",example = "23")
    private List<InputFormatModel> inputList;

    @ApiModelProperty(value = "tab表单的其他列",example = "23")
    private Map<String ,List<InputFormatModel>> otherColumn;

    public Map<String, List<InputFormatModel>> getOtherColumn() {
        return otherColumn;
    }

    public void setOtherColumn(Map<String, List<InputFormatModel>> otherColumn) {
        this.otherColumn = otherColumn;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getTabClumnTargetShow() {
        return tabClumnTargetShow;
    }

    public void setTabClumnTargetShow(String tabClumnTargetShow) {
        this.tabClumnTargetShow = tabClumnTargetShow;
    }

    public String getTabClumnType() {
        return tabClumnType;
    }

    public void setTabClumnType(String tabClumnType) {
        this.tabClumnType = tabClumnType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTabCreateType() {
        return tabCreateType;
    }

    public void setTabCreateType(String tabCreateType) {
        this.tabCreateType = tabCreateType;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<TargetModelVO> getTargetList() {
        return targetList;
    }

    public void setTargetList(List<TargetModelVO> targetList) {
        this.targetList = targetList;
    }



    public List<InputFormatModel> getInputList() {
        return inputList;
    }

    public void setInputList(List<InputFormatModel> inputList) {
        this.inputList = inputList;
    }
}
