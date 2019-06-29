package com.jn.hardware.ding.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptException;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptor;
import com.jn.common.util.enums.EnumUtil;
import com.jn.hardware.config.DingTalkProperties;
import com.jn.hardware.ding.model.AddressBookCallback;
import com.jn.oa.api.OaClient;
import com.jn.oa.enums.AddressBookEventTypeEnum;
import com.jn.oa.model.AddressBookNotice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName：钉钉 : 回调事件
 * @Descript：
 * 每个事件回调都需要去调用钉钉接口去注册,如果已经注册过的接口需要修改地址,也可以通过钉钉接口去修改
 * 钉钉文档地址：https://open-doc.dingtalk.com/microapp/serverapi2/pwz3r5
 * @Author： hey
 * @Date： Created on 2019/6/20 9:53
 * @Version： v1.0
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/hardware/dingTalk/callback")
public class DingTalkCallbackController {

    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(DingTalkCallbackController.class);

    @Autowired
    private DingTalkProperties dingTalkProperties;

    @Autowired
    private OaClient oaClient;

    /**
     * 钉钉通讯录事件回调
     * https://open-doc.dingtalk.com/microapp/serverapi2/lo5n6i
     * @param addressBookCallback 回调消息实体类
     * @param encryptJson 回调消息加密体 (JSON格式   如：{ "encrypt":"1ojQf0N..." })
    * */
    @RequestMapping(value = "/addressBookCallback",method = RequestMethod.POST)
    public void addressBookCallback(HttpServletRequest request
            , HttpServletResponse response
            ,AddressBookCallback addressBookCallback
            , @RequestBody String encryptJson){
        logger.info("====== 开始接收钉钉通讯录事件回调通知 ======");
        logger.info("钉钉通讯录事件回调 入参 addressBookCallback：【{}】 encryptJson : 【{}】 ",addressBookCallback,encryptJson);


        /** step 1  对encrypt进行解密**/
        DingTalkEncryptor dingTalkEncryptor = null;
        String plainText = null;
        try {
            dingTalkEncryptor = new DingTalkEncryptor(dingTalkProperties.getAddressBookToken(),dingTalkProperties.getAddressBookAeskey(), dingTalkProperties.getCorpId());
            String encrypt = JSON.parseObject(encryptJson).getString("encrypt");
            plainText = dingTalkEncryptor.getDecryptMsg(addressBookCallback.getSignature(), addressBookCallback.getTimestamp(), addressBookCallback.getNonce(), encrypt);
            logger.info("钉钉通讯录事件回调 解密encryptJson：【{}】 ",plainText);
        } catch (DingTalkEncryptException e) {
            logger.error("setp1 对encrypt进行解密失败 ",e);
            logger.info("======结束钉钉通讯录事件回调通知 ======");
            return;
        }


        /**  step 2 对从encrypt解密出来的明文进行处理**/
        JSONObject plainTextJson = JSONObject.parseObject(plainText);
        //获取事件类型 把其转成对应的枚举类
        String eventType = plainTextJson.getString("EventType");
        AddressBookNotice addressBookNotice = plainTextJson.toJavaObject(AddressBookNotice.class);
        addressBookNotice.setEventType(EnumUtil.getByCode(eventType, AddressBookEventTypeEnum.class));
        logger.info("钉钉通讯录事件回调 JSON转对象addressBookNotice：【{}】 ",addressBookNotice);

        //调用业务系统接口
        try{
            oaClient.updateOrInsertDingTalkUser(addressBookNotice);
        }catch (Exception e) {
            logger.error("钉钉通讯录事件回调--》 调用业务系统接口失败！",e);
        }


        /** step 3 对返回信息进行加密 **/
        //时间截
        long timeStampLong = System.currentTimeMillis();
        //随机数
        String  nonce = String.valueOf(timeStampLong);
        Map<String,String> jsonMap = null;
        try {
            jsonMap = dingTalkEncryptor.getEncryptedMap("success", timeStampLong,nonce);
        } catch (DingTalkEncryptException e) {
            logger.error("setp3 对返回信息进行加密失败 ",e);
            logger.info("======结束钉钉通讯录事件回调通知 ======");
            return;
        }
        JSONObject json = new JSONObject();
        json.putAll(jsonMap);
        try {
            response.getWriter().append(json.toString());
            logger.info("钉钉通讯录事件回调 响应钉钉的信息：【{}】 ",json.toString());
        } catch (IOException e) {
            logger.error(" 返回信息给钉钉失败",e);
            logger.info("======结束钉钉通讯录事件回调通知 ======");
            return;
        }

        logger.info("======完成处理钉钉通讯录事件回调通知 ======");
    }

}
