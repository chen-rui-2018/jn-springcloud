package com.jn.enterprise.company.vo;

import com.jn.enterprise.company.enums.UpgradeStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 邀请认证状态返回
 * @author： huxw
 * @date： Created on 2019-6-19 16:41:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "InviteUpgradeStatusVO",description = "认证状态返回")
public class InviteUpgradeStatusVO extends UpgradeStatusVO {

    @ApiModelProperty(value = "发送邀请抛出的消息")
    private String inviteMessage;

    public InviteUpgradeStatusVO(UpgradeStatusEnum upgradeStatusEnum) {
        super(upgradeStatusEnum);
        this.inviteMessage = upgradeStatusEnum.getInviteMessage();
    }

    public String getInviteMessage() {
        return inviteMessage;
    }

    public void setInviteMessage(String inviteMessage) {
        this.inviteMessage = inviteMessage;
    }
}
