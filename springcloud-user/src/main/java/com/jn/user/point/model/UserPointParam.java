package com.jn.user.point.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户积分
 * @author： jiangyl
 * @date： Created on 2019/4/3 19:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserPointParam",description = "用户积分")
public class UserPointParam extends Page implements Serializable {
    @ApiModelProperty(value = "积分标识",example = "aea8167ff8c24b28a24c900dcfad334b")
    private String pointId;
    @ApiModelProperty(value = "用户账号",example = "wangsong")
    private String userAccount;
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
}