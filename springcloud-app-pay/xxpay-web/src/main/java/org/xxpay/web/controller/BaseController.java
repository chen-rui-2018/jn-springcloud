package org.xxpay.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.xxpay.common.util.MyLog;
import org.xxpay.web.service.MchInfoServiceClient;

/**
 * @ClassName：基础类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/11 14:29
 * @Version： v1.0
 * @Modified By:
 */
public class BaseController {
    /**
     * 日志
    * */
    private final MyLog _log = MyLog.getLog(RefundOrderController.class);

    @Autowired
    private MchInfoServiceClient mchInfoServiceClient;


    /**
     * 组装JSON参数(数组)
     * @param names
     * @param values
     * @return
    * */
    String getJsonParam(String[] names, Object[] values) {
        JSONObject jsonParam = new JSONObject();
        for (int i = 0; i < names.length; i++) {
            jsonParam.put(names[i], values[i]);
        }
        return jsonParam.toJSONString();
    }

    /**
     * 组装JSON参数(单个参数)
     * @param name
     * @param value
     * @return
     * */
    String getJsonParam(String name, Object value) {
        JSONObject jsonParam = new JSONObject();
        jsonParam.put(name, value);
        return jsonParam.toJSONString();
    }

    /**
     * 获取商户信息
     * 返回boolean 类型  并且返回提示对应的错误信息
     * @param mchId 商户ID
     * @param mchInfo JSON类型
     * @param errorMessage 错误信息
     * @return  Boolean
    * */
    Boolean getMchInfo(String mchId,JSONObject mchInfo,String errorMessage) {
        String retStr = mchInfoServiceClient.selectMchInfo(getJsonParam("mchId", mchId));

        JSONObject retObj = JSON.parseObject(retStr);
        if("0000".equals(retObj.getString("code"))) {
            mchInfo = retObj.getJSONObject("result");
            if (mchInfo == null) {
                errorMessage = "Can't found mchInfo[mchId="+mchId+"] record in db.";
                return false;
            }
            if(mchInfo.getByte("state") != 1) {
                errorMessage = "mchInfo not available [mchId="+mchId+"] record in db. ";
                return false;
            }
        }else {
            _log.info("查询商户没有正常返回数据,code={},msg={}", retObj.getString("code"), retObj.getString("msg"));
            errorMessage = "Can't found mchInfo[mchId="+mchId+"] record in db.";
            return false;
        }
        return true;
    }

}
