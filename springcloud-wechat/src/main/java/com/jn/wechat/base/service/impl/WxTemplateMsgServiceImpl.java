package com.jn.wechat.base.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.wechat.base.enums.WxExceptionEnums;
import com.jn.wechat.base.model.template.WxTemplateData;
import com.jn.wechat.base.model.template.WxTemplateIndustrySet;
import com.jn.wechat.base.model.template.WxTemplateMessage;
import com.jn.wechat.base.service.WxHttpClientService;
import com.jn.wechat.base.service.WxTemplateMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板消息实现
 *
 * @Author： cm
 * @Date： Created on 2019/1/24 14:48
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class WxTemplateMsgServiceImpl implements WxTemplateMsgService {

    @Autowired
    private WxHttpClientService wxHttpClientService;

    @Override
    @ServiceLog(doAction = "设置所属行业")
    public boolean setIndustry(WxTemplateIndustrySet wxTemplateIndustrySet) {
        if (null == wxTemplateIndustrySet.getIndustry_id1() || null == wxTemplateIndustrySet.getIndustry_id2()) {
            throw new IllegalArgumentException("行业Id不能为空，请核实");
        }
        wxHttpClientService.post(SET_TEMPLATE_INDUSTRY,wxTemplateIndustrySet);
        return true;
    }

    @Override
    @ServiceLog(doAction = "发送模板消息")
    public String sendTemplateMsg(WxTemplateMessage wxTemplateMessage) {
        String templateMsgString = FormatWxTemplateMessage(wxTemplateMessage);
        return wxHttpClientService.post(SEND_TEMPLATE_MSG_URL,templateMsgString);
    }

    /**
     * 模板参数特殊处理
     * @param wxTemplateMessage
     * @return
     */
    public String FormatWxTemplateMessage(WxTemplateMessage wxTemplateMessage) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("touser",wxTemplateMessage.getTouser());
        objectNode.put("template_id",wxTemplateMessage.getTemplate_id());
        if (null != wxTemplateMessage.getUrl()) {
            objectNode.put("url", wxTemplateMessage.getUrl());
        }
        List<WxTemplateData> wxTemplateDataList = wxTemplateMessage.getData();
        if(null != wxTemplateDataList && wxTemplateDataList.size()>0) {
            ObjectNode objectNode2 = mapper.createObjectNode();
            for(WxTemplateData wxTemplateData : wxTemplateDataList) {
                Map map = new HashMap<>(2);
                map.put("value",wxTemplateData.getValue());
                map.put("color",wxTemplateData.getColor());
                objectNode2.putPOJO(wxTemplateData.getName(),map);
            }
            objectNode.putPOJO("data",objectNode2);
        }
        try {
            return mapper.writeValueAsString(objectNode);
        } catch (JsonProcessingException e) {
            throw new JnSpringCloudException(WxExceptionEnums.JSON_PROCESS_FAL);
        }
    }

}
