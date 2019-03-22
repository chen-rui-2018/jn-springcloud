package com.jn.park.finance.vo;

import com.jn.park.finance.model.FinanceIncomeLastYearContrastModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： tangry
 * @date： Created on 2019/3/21
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceIncomeExportContrastVo",description = "导出往年对比")
public class FinanceIncomeExportContrastVo implements Serializable {

    private static final long serialVersionUID = -6637836908130659429L;

    @ApiModelProperty(value = "收入名称")
    private String incomeTypeName;

    @ApiModelProperty(value = "今年1")
    private String income1;
    @ApiModelProperty(value = "去年1")
    private String lastYearIncome1;


    @ApiModelProperty(value = "今年2")
    private String income2;
    @ApiModelProperty(value = "去年2")
    private String lastYearIncome2;

    @ApiModelProperty(value = "今年3")
    private String income3;
    @ApiModelProperty(value = "去年3")
    private String lastYearIncome3;

    @ApiModelProperty(value = "今年4")
    private String income4;
    @ApiModelProperty(value = "去年4")
    private String lastYearIncome4;

    @ApiModelProperty(value = "今年5")
    private String income5;
    @ApiModelProperty(value = "去年5")
    private String lastYearIncome5;

    @ApiModelProperty(value = "今年6")
    private String income6;
    @ApiModelProperty(value = "去年6")
    private String lastYearIncome6;

    @ApiModelProperty(value = "今年7")
    private String income7;
    @ApiModelProperty(value = "去年7")
    private String lastYearIncome7;

    @ApiModelProperty(value = "今年8")
    private String income8;
    @ApiModelProperty(value = "去年8")
    private String lastYearIncome8;

    @ApiModelProperty(value = "今年9")
    private String income9;
    @ApiModelProperty(value = "去年9")
    private String lastYearIncome9;

    @ApiModelProperty(value = "今年10")
    private String income10;
    @ApiModelProperty(value = "去年10")
    private String lastYearIncome10;

    @ApiModelProperty(value = "今年11")
    private String income11;
    @ApiModelProperty(value = "去年11")
    private String lastYearIncome11;

    @ApiModelProperty(value = "今年12")
    private String income12;
    @ApiModelProperty(value = "去年12")
    private String lastYearIncome12;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    public String getIncomeTypeName() {
        return incomeTypeName;
    }

    public void setIncomeTypeName(String incomeTypeName) {
        this.incomeTypeName = incomeTypeName;
    }

    public String getIncome1() {
        return income1;
    }

    public void setIncome1(String income1) {
        this.income1 = income1;
    }

    public String getLastYearIncome1() {
        return lastYearIncome1;
    }

    public void setLastYearIncome1(String lastYearIncome1) {
        this.lastYearIncome1 = lastYearIncome1;
    }

    public String getIncome2() {
        return income2;
    }

    public void setIncome2(String income2) {
        this.income2 = income2;
    }

    public String getLastYearIncome2() {
        return lastYearIncome2;
    }

    public void setLastYearIncome2(String lastYearIncome2) {
        this.lastYearIncome2 = lastYearIncome2;
    }

    public String getIncome3() {
        return income3;
    }

    public void setIncome3(String income3) {
        this.income3 = income3;
    }

    public String getLastYearIncome3() {
        return lastYearIncome3;
    }

    public void setLastYearIncome3(String lastYearIncome3) {
        this.lastYearIncome3 = lastYearIncome3;
    }

    public String getIncome4() {
        return income4;
    }

    public void setIncome4(String income4) {
        this.income4 = income4;
    }

    public String getLastYearIncome4() {
        return lastYearIncome4;
    }

    public void setLastYearIncome4(String lastYearIncome4) {
        this.lastYearIncome4 = lastYearIncome4;
    }

    public String getIncome5() {
        return income5;
    }

    public void setIncome5(String income5) {
        this.income5 = income5;
    }

    public String getLastYearIncome5() {
        return lastYearIncome5;
    }

    public void setLastYearIncome5(String lastYearIncome5) {
        this.lastYearIncome5 = lastYearIncome5;
    }

    public String getIncome6() {
        return income6;
    }

    public void setIncome6(String income6) {
        this.income6 = income6;
    }

    public String getLastYearIncome6() {
        return lastYearIncome6;
    }

    public void setLastYearIncome6(String lastYearIncome6) {
        this.lastYearIncome6 = lastYearIncome6;
    }

    public String getIncome7() {
        return income7;
    }

    public void setIncome7(String income7) {
        this.income7 = income7;
    }

    public String getLastYearIncome7() {
        return lastYearIncome7;
    }

    public void setLastYearIncome7(String lastYearIncome7) {
        this.lastYearIncome7 = lastYearIncome7;
    }

    public String getIncome8() {
        return income8;
    }

    public void setIncome8(String income8) {
        this.income8 = income8;
    }

    public String getLastYearIncome8() {
        return lastYearIncome8;
    }

    public void setLastYearIncome8(String lastYearIncome8) {
        this.lastYearIncome8 = lastYearIncome8;
    }

    public String getIncome9() {
        return income9;
    }

    public void setIncome9(String income9) {
        this.income9 = income9;
    }

    public String getLastYearIncome9() {
        return lastYearIncome9;
    }

    public void setLastYearIncome9(String lastYearIncome9) {
        this.lastYearIncome9 = lastYearIncome9;
    }

    public String getIncome10() {
        return income10;
    }

    public void setIncome10(String income10) {
        this.income10 = income10;
    }

    public String getLastYearIncome10() {
        return lastYearIncome10;
    }

    public void setLastYearIncome10(String lastYearIncome10) {
        this.lastYearIncome10 = lastYearIncome10;
    }

    public String getIncome11() {
        return income11;
    }

    public void setIncome11(String income11) {
        this.income11 = income11;
    }

    public String getLastYearIncome11() {
        return lastYearIncome11;
    }

    public void setLastYearIncome11(String lastYearIncome11) {
        this.lastYearIncome11 = lastYearIncome11;
    }

    public String getIncome12() {
        return income12;
    }

    public void setIncome12(String income12) {
        this.income12 = income12;
    }

    public String getLastYearIncome12() {
        return lastYearIncome12;
    }

    public void setLastYearIncome12(String lastYearIncome12) {
        this.lastYearIncome12 = lastYearIncome12;
    }


    @Override
    public String toString() {
        return "FinanceIncomeExportContrastVo{" +
                ", incomeTypeName='" + incomeTypeName + '\'' +
                ", income1='" + income1 + '\'' +
                ", lastYearIncome1='" + lastYearIncome1 + '\'' +
                ", income2='" + income2 + '\'' +
                ", lastYearIncome2='" + lastYearIncome2 + '\'' +
                ", income3='" + income3 + '\'' +
                ", lastYearIncome3='" + lastYearIncome3 + '\'' +
                ", income4='" + income4 + '\'' +
                ", lastYearIncome4='" + lastYearIncome4 + '\'' +
                ", income5='" + income5 + '\'' +
                ", lastYearIncome5='" + lastYearIncome5 + '\'' +
                ", income6='" + income6 + '\'' +
                ", lastYearIncome6='" + lastYearIncome6 + '\'' +
                ", income7='" + income7 + '\'' +
                ", lastYearIncome7='" + lastYearIncome7 + '\'' +
                ", income8='" + income8 + '\'' +
                ", lastYearIncome8='" + lastYearIncome8 + '\'' +
                ", income9='" + income9 + '\'' +
                ", lastYearIncome9='" + lastYearIncome9 + '\'' +
                ", income10='" + income10 + '\'' +
                ", lastYearIncome10='" + lastYearIncome10 + '\'' +
                ", income11='" + income11 + '\'' +
                ", lastYearIncome11='" + lastYearIncome11 + '\'' +
                ", income12='" + income12 + '\'' +
                ", lastYearIncome12='" + lastYearIncome12 + '\'' +
                '}';
    }
}
