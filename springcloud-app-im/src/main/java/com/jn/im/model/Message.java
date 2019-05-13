package com.jn.im.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;

import java.io.Serializable;
import java.util.Date;

/**
 * Message
 *
 * @author： shenph
 * @date： Created on 2019/5/9 19:53
 * @version： v1.0
 * @modified By:
 */
public class Message extends Page implements Serializable {

    /**
     * 发送人
     */
    private String fromUser;

    /**
     * 发送人昵称
     */
    private String nickName;

    /**
     * 接收人
     */
    private String toUser;

    /**
     * 发送消息
     */
    private String msg;

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
