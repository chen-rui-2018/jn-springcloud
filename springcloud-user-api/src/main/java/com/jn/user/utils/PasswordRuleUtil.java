package com.jn.user.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jn.common.util.CallOtherSwaggerUtils;
import com.jn.common.util.encryption.CustomValidUtil;
import com.jn.user.model.SecurityInfo;
import com.jn.user.model.SecurityInfoResult;
import com.jn.user.vo.PasswordValidVO;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;

/**
 * 密码规则工具类
 * @author： huxw
 * @date： Created on 2019-7-1 14:08:07
 * @version： v1.0
 * @modified By:
 */
public class PasswordRuleUtil {

    private static Logger logger = LoggerFactory.getLogger(PasswordRuleUtil.class);

    /**
     * 是否通过校验
     * @param validStr 校验字符串
     * @return
     */
    public static PasswordValidVO isValid(String validStr) {
        PasswordValidVO passwordValidVO = new PasswordValidVO();
        JSONObject jsonObject = CustomValidUtil.securityInfo();
        SecurityInfoResult securityInfoResult = new Gson().fromJson(jsonObject.toString(), SecurityInfoResult.class);
        if (securityInfoResult == null || !securityInfoResult.getState().equals("200")) {
            logger.warn("[密码规则工具类] 密码规则获取失败");
            return passwordValidVO;
        }

        Object data = securityInfoResult.getData();
        ObjectMapper objectMapper = new ObjectMapper();
        SecurityInfo securityInfo = objectMapper.convertValue(data, SecurityInfo.class);
        if (securityInfo == null) {
            logger.warn("[密码规则工具类] 密码规则获取失败");
            return passwordValidVO;
        }
        boolean isValid = CustomValidUtil.valid(validStr, securityInfo.getIsUseComp(), securityInfo.getMinLength(), securityInfo.getMaxLength(), securityInfo.getComplexity());
        passwordValidVO.setValid(isValid);
        passwordValidVO.setMessage(securityInfoResult.getMessage());
        return passwordValidVO;
    }
}
