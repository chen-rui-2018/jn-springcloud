package com.jn.miniprogram.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 导出 Excel 时使用的映射实体类，Excel 模型
 *
 * @author： shenph
 * @date： Created on 2018/11/24 11:13
 * @version： v1.0
 * @modified By: shenph
 */
@ApiModel(value = "ExportInfo", description = "Excel导出")
public class ExportInfo extends BaseRowModel implements Serializable {

    @ApiModelProperty("姓名")
    @ExcelProperty(value = "姓名" ,index = 0)
    private String name;

    @ApiModelProperty("年龄")
    @ExcelProperty(value = "年龄",index = 1)
    private String age;

    @ApiModelProperty("邮箱")
    @ExcelProperty(value = "邮箱",index = 2)
    private String email;

    @ApiModelProperty("地址")
    @ExcelProperty(value = "地址",index = 3)
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
