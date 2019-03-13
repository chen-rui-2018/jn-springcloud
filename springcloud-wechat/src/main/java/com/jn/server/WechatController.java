package com.jn.server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.wechat.api.WechatClient;
import com.jn.wechat.base.enums.WxErrorMsgEnum;
import com.jn.wechat.base.enums.WxExceptionEnums;
import com.jn.wechat.base.model.result.WxError;
import com.jn.wechat.base.model.template.WxTemplateData;
import com.jn.wechat.base.model.template.WxTemplateMessage;
import com.jn.wechat.base.service.WxService;
import com.jn.wechat.base.service.WxTemplateMsgService;
import com.jn.wechat.base.utils.json.JsonStringToObjectUtil;
import com.jn.wechat.model.TemplateData;
import com.jn.wechat.model.TemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供内部调用的微信接口
 *
 * @Author： cm
 * @Date： Created on 2019/1/23 15:38
 * @Version： v1.0
 * @Modified By:
 */
@RestController
public class WechatController extends BaseController implements WechatClient {

    @Autowired
    private WxService wxService;

    @Autowired
    private WxTemplateMsgService wxTemplateMsgService;

    /**
     * 强制刷新access_token
     * <p>
     *  目前Access_token的有效期通过返回的expire_in来传达，目前是7200秒之内的值。
     *  中控服务器需要根据这个有效时间提前去刷新新access_token。在刷新过程中，
     *  中控服务器可对外继续输出的老access_token，此时公众平台后台会保证在5分钟内，
     *  新老access_token都可用，这保证了第三方业务的平滑过渡
     * </p>
     */
    @Override
    @ControllerLog(doAction = "强制获取access_token")
    public void refreshAccessToken() {
        wxService.getAccessToken();
    }

    /**
     * 推送模板消息
     * @param templateMessage
     * @return
     */

    @Override
    @ControllerLog(doAction = "发送模板消息")
    public Result<String> pushTemplateInfo(@RequestBody TemplateMessage templateMessage) {
        Result<String> result = new Result<>();
        WxTemplateMessage wxTemplateMessage = new WxTemplateMessage();
        wxTemplateMessage.setTouser(templateMessage.getToUser());
        wxTemplateMessage.setTemplate_id(templateMessage.getTemplateId());
        WxTemplateData wxTemplateData;
        List<TemplateData> data = templateMessage.getTemplateDataList();
        for(int i=0;i<data.size();i++) {
            wxTemplateData = new WxTemplateData();
            wxTemplateData.setName("keyword"+i);
            wxTemplateData.setValue(data.get(i).getValue());
            wxTemplateData.setColor(data.get(i).getColor());
            if(0==i) {
                wxTemplateData.setName("first");
            }
            wxTemplateMessage.addData(wxTemplateData);
        }
        String json = wxTemplateMsgService.sendTemplateMsg(wxTemplateMessage);
        WxError wxError = JsonStringToObjectUtil.jsonToObject(json,new TypeReference<WxError>(){});
        if(null == wxError) {
            result.setCode(WxExceptionEnums.SEND_TEMPLATE_MSG_FAIL.getCode());
            result.setResult(WxExceptionEnums.SEND_TEMPLATE_MSG_FAIL.getMessage());
        }else if(!WxErrorMsgEnum.CODE_0.getCode().equals(wxError.getErrcode())) {
            result.setCode(wxError.getErrcode());
            result.setResult(wxError.getErrmsg());
        }
        return result;
    }
}
