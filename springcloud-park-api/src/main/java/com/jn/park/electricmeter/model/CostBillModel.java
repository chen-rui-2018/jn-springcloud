package com.jn.park.electricmeter.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author： yangh
 * @date： Created on 2019/6/29 16:49
 * @version： v1.0
 * @modified By:
 */

public class CostBillModel implements Serializable {

    private String acBookId;

    public String getAcBookId() {
        return acBookId;
    }

    public void setAcBookId(String acBookId) {
        this.acBookId = acBookId;
    }
}
