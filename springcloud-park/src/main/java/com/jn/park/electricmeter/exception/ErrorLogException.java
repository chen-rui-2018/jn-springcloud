package com.jn.park.electricmeter.exception;

import com.jn.park.electricmeter.entity.TbElectricErrorLog;

import java.util.HashMap;

/**
 * @author： yangh
 * @date： Created on 2019/5/24 9:29
 * @version： v1.0
 * @modified By:
 */

public class ErrorLogException extends RuntimeException {
    private TbElectricErrorLog  err;

    public ErrorLogException(TbElectricErrorLog   err){
        this.err =err;
    }
    public TbElectricErrorLog  getErr() {
        return err;
    }

    public void setErr(TbElectricErrorLog  err) {
        this.err = err;
    }
}
