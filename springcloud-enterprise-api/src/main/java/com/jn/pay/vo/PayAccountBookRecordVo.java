package com.jn.pay.vo;

import com.jn.pay.model.PayAccountBookMoneyRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * 账本明细实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/18 11:16
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccountBookRecordVo" ,description = "账本明细实体类")
public class PayAccountBookRecordVo extends PayAccountBookMoneyRecord implements Serializable {
    private static final long serialVersionUID = 7360103002257889188L;

    @ApiModelProperty(value="月份")
    private String month;

    @ApiModelProperty(value="账本类型")
    private String acBookType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getAcBookType() {
        return acBookType;
    }

    public void setAcBookType(String acBookType) {
        this.acBookType = acBookType;
    }
}
