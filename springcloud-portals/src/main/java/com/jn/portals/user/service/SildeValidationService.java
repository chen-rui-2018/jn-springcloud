package com.jn.portals.user.service;

import com.jn.common.model.Result;

/**
 * 滑动验证
 * @Author: yangph
 * @Date: 2018/11/30 17:02
 * @Version v1.0
 * @modified By:
 */
public interface SildeValidationService {
    /**
     * 滑动验证图片生成
     * @param oriWidth  源文件宽度
     * @param oriHeight 源文件高度
     * @return
     */
    Result slideValidation(String oriWidth,String oriHeight);

    /***
     * 校验前端滑动操作结果
     * @param verifyKey  后端传递的校验key
     * @param xCoord     抠图坐标x
     * @return
     */
    Result verificationOption(String verifyKey,String xCoord);
}
