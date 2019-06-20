package com.jn.park.activity.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 用户中心-报名活动列表 查询条件
 * @author： chenr
 * @date： Created on 2019/3/21 20:20
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityApplyListParam",description = "用户中心-报名活动列表 查询条件")
public class ActivityApplyListParam extends Page implements Serializable {
    @ApiModelProperty(value = "活动名称",example = "重阳登高")
    private String actiName;
    @ApiModelProperty(value = "用户账号",required = true ,example = "wangsong")
    @NotBlank(message = "用户账号不能为空")
    private String account;
    @ApiModelProperty(value = "报名转态 1:报名成功-2报名待审核",required = true ,example = "1")
    @Pattern(regexp = "^[1-2]$",message = "状态值只能为 1或 2, 1:报名成功-2报名待审核")
    @NotBlank(message = "报名转态不能为空")
    private String applyStatus;

    public String getActiName() {
        return actiName;
    }

    public void setActiName(String actiName) {
        this.actiName = actiName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Override
    public String toString() {
        return "ActivityApplyListParam{" +
                "actiName='" + actiName + '\'' +
                ", account='" + account + '\'' +
                ", applyStatus='" + applyStatus + '\'' +
                '}';
    }
}
