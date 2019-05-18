package com.jn.news.app.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class JPushResult implements Serializable {

    @Expose public long msg_id;
    @Expose public int sendno;
    @Expose public int statusCode;
    @Expose public Error error;

    public class Error {
        @Expose String message;
        @Expose int code;

        public String getMessage() {
            return this.message;
        }

        public int getCode() {
            return this.code;
        }
    }

    public long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(long msg_id) {
        this.msg_id = msg_id;
    }

    public int getSendno() {
        return sendno;
    }

    public void setSendno(int sendno) {
        this.sendno = sendno;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
