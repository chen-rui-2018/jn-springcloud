package com.jn.miniprogram.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 导入 Excel 时使用的映射实体类，Excel 模型
 *
 * @author： shenph
 * @date： Created on 2018/11/24 11:13
 * @version： v1.0
 * @modified By: shenph
 */
@ApiModel(value = "ExportInfo", description = "Excel导入")
public class ImportInfo extends BaseRowModel implements Serializable {

    @ApiModelProperty("姓名")
    @ExcelProperty(index = 0)
    private String name;

    @ApiModelProperty("年龄")
    @ExcelProperty(index = 1)
    private String age;

    @ApiModelProperty("邮箱")
    @ExcelProperty(index = 2)
    private String email;

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

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
