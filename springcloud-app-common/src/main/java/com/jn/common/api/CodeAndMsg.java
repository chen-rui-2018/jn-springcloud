package com.jn.common.api;

/**
 * 编码与信息的获取接口
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 12:07
 * @version： v1.0
 * @modified By:
 */
public interface CodeAndMsg {
    /**
     * 获取code
     * @return
     */
    String getCode();
    /**
     * 获取信息
     * @return
     */
    String getMessage();
}
