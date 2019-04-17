package com.jn.user.point.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户积分
 * @author： jiangyl
 * @date： Created on 2019/4/3 19:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserPointVO",description = "用户积分")
public class UserPointVO implements Serializable {
    @ApiModelProperty(value = "积分标识",example = "aea8167ff8c24b28a24c900dcfad334b")
    private String pointId;
    @ApiModelProperty(value = "用户账号",example = "wangsong")
    private String userAccount;
    @ApiModelProperty(value = "积分余额",example = "500.00")
    private Double pointNum;
    @ApiModelProperty(value = "冻结积分[发起支付会扣除积分，当支付成功后再真正扣除]",example = "100")
    private Double freezeNum;
    @ApiModelProperty(value = "用户姓名",example = "王松")
    private String name;
    @ApiModelProperty(value = "用户昵称",example = "小小酥")
    private String nickName;

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Double getPointNum() {
        return pointNum;
    }

    public void setPointNum(Double pointNum) {
        this.pointNum = pointNum;
    }

    public Double getFreezeNum() {
        return freezeNum;
    }

    public void setFreezeNum(Double freezeNum) {
        this.freezeNum = freezeNum;
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

    @Override
    public String toString() {
        return "UserPointVO{" +
                "pointId='" + pointId + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", pointNum=" + pointNum +
                ", freezeNum=" + freezeNum +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}