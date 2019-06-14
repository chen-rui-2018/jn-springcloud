package com.jn.enterprise.data.model;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/5/30 21:27
 * @version： v1.0
 * @modified By:
 */

public class TargetAndFormModel implements Serializable {
    /**
     *指标
     */
    private String targetId;
    /**
     * 填报id
     */
    private String formId;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }
}
