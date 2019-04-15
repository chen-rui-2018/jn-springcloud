package com.jn.user.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: huxw
 * @Date: 2019-4-13 17:56:49
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "SearchFiledParam", description = "查询字段入参")
public class SearchFiledParam extends Page implements Serializable {
    @ApiModelProperty("企业ID")
    private String comId;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "默认值只允许为0,1")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "NOT IN 账号集合")
    private List<String> accountList;

    public List<String> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<String> accountList) {
        this.accountList = accountList;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
