package com.jn.enterprise.joinpark.usermanage.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 升级企业入参Bean
 * @author： jiangyl
 * @date： Created on 2019/3/5 10:40
 * @version： v1.0
 * @modified By: huxw
 */
@ApiModel(value = "StaffCheckParam",description = "升级员工入参")
public class StaffCheckParam implements Serializable {
    @NotNull(message = "企业ID不能为空")
    @ApiModelProperty(value = "企业ID",required = true,example = "8afabb60045d40e485e1d4ac04666e8a")
    private String comId;
    @NotNull(message = "企业名称不能为空")
    @ApiModelProperty(value = "企业名称",required = true,example = "左元有限公司")
    private String comName;
    @NotNull(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码",required = true,example = "1234")
    private String checkCode;

    @ApiModelProperty(value = "真实姓名")
    private String name;

    @Pattern(regexp = "^(?:(?!([\\-\\/\\%])).)*$", message = "昵称校验失败，不能包含‘%/-’")
    @ApiModelProperty(value = "昵称", notes = "不能包含特殊字符‘%/-’")
    private String nickName;

    @Pattern(regexp = "^1\\d{10}|\\s*$", message = "手机号校验失败")
    @ApiModelProperty(value = "手机")
    private String phone;

    @Pattern(regexp = "^([12]\\d{3}\\-(0[1-9]|1[0-2])\\-(0[1-9]|[1-2]\\d|3[01]))|\\s*$", message = "出生年月校验失败")
    @ApiModelProperty(value = "出生年月", example = "1990-05-24")
    private String birthday;

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "StaffCheckParam{" +
                "comId='" + comId + '\'' +
                ", comName='" + comName + '\'' +
                ", checkCode='" + checkCode + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
