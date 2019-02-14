package com.jn.wechat.base.service.impl;

import com.jn.wechat.base.model.template.WxTemplateData;
import com.jn.wechat.base.model.template.WxTemplateMessage;
import com.jn.wechat.base.service.WxTemplateMsgService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WxTemplateMsgServiceImplTest {

    @Autowired
    private WxTemplateMsgService wxTemplateMsgService;

    @Test
    @Ignore
    public void sendTemplateMsg() {
        WxTemplateMessage wxTemplateMessage = new WxTemplateMessage();
        wxTemplateMessage.setTouser("oQgOO5sOQjlb8dUGsiLoeeInPIRk");
        wxTemplateMessage.setTemplate_id("3LdK9s7ToSCeBW9dPfEiuXtYP-y_utRBL-cEbHA_xJc");

        WxTemplateData wxTemplateData = new WxTemplateData();
        wxTemplateData.setName("first");
        wxTemplateData.setValue("欢迎");

        WxTemplateData wxTemplateData1 = new WxTemplateData();
        wxTemplateData1.setName("keyword1");
        wxTemplateData1.setValue("value1");

        WxTemplateData wxTemplateData2 = new WxTemplateData();
        wxTemplateData2.setName("keyword2");
        wxTemplateData2.setValue("value2");

        wxTemplateMessage.addData(wxTemplateData).addData(wxTemplateData1).addData(wxTemplateData2);
        wxTemplateMsgService.sendTemplateMsg(wxTemplateMessage);
    }
}