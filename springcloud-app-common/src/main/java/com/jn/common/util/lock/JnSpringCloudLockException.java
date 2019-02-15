package com.jn.common.util.lock;


import com.jn.common.api.CodeAndMsg;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;

/**
 * 对lock的异常
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By:
 */
public class JnSpringCloudLockException extends JnSpringCloudException {

    public JnSpringCloudLockException(CodeAndMsg codeAndMsg) {
        super(codeAndMsg);
    }

    public JnSpringCloudLockException(CodeAndMsg codeAndMsg, String msg) {
        super(codeAndMsg, msg);
    }

    public JnSpringCloudLockException(Result result) {
        super(result);
    }
}
