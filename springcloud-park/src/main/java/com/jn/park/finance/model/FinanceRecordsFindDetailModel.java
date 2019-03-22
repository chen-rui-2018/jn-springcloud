package com.jn.park.finance.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**备案项,需录入项等查询
 * @author： tangry
 * @date： Created on 2019/3/18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceRecordsFindDetailModel",description = "备案项,需录入项等查询")
public class FinanceRecordsFindDetailModel implements Serializable {


    private static final long serialVersionUID = -7311773469380355947L;
    @ApiModelProperty(value = "财务备案项")
    private String  total;

    @ApiModelProperty(value = "完成备案录入资料")
    private String  complete;

    @ApiModelProperty(value = "需要录入备案资料")
    private String  uncomplete;

    @ApiModelProperty(value = "资料完整度")
    private String integrity;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getUncomplete() {
        return uncomplete;
    }

    public void setUncomplete(String uncomplete) {
        this.uncomplete = uncomplete;
    }

    public String getIntegrity() {
        return integrity;
    }

    public void setIntegrity(String integrity) {
        this.integrity = integrity;
    }


    @Override
    public String toString() {
        return "FinanceRecordsFindDetailModel{" +
                "total='" + total + '\'' +
                ", complete='" + complete + '\'' +
                ", uncomplete='" + uncomplete + '\'' +
                ", integrity='" + integrity + '\'' +
                '}';
    }
}
