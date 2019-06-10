package com.jn.wechat.base.service.impl;

import com.jn.wechat.base.service.WxTemplateMsgService;
import com.jn.wechat.model.WxTemplateData;
import com.jn.wechat.model.WxTemplateMessage;
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
    public void sendTemplateMsg() {
        WxTemplateMessage wxTemplateMessage = new WxTemplateMessage();
        wxTemplateMessage.setTouser("oxpUm1maR7G_PDi8HEMs5-mPk4WM");
        wxTemplateMessage.setTemplate_id("UCGSWEqVYaMMC-_vyYFdLZn5qRexjEWywiptywHEhnk");

        WxTemplateData wxTemplateData = new WxTemplateData();
        wxTemplateData.setName("first");
        wxTemplateData.setValue("欢迎");

        WxTemplateData wxTemplateData1 = new WxTemplateData();
        wxTemplateData1.setName("address");
        wxTemplateData1.setValue("南京白下高新");

        WxTemplateData wxTemplateData2 = new WxTemplateData();
        wxTemplateData2.setName("period");
        wxTemplateData2.setValue("2019-06-03");

        WxTemplateData wxTemplateData3 = new WxTemplateData();
        wxTemplateData3.setName("electricity");
        wxTemplateData3.setValue("123");

        WxTemplateData wxTemplateData4 = new WxTemplateData();
        wxTemplateData4.setName("charge");
        wxTemplateData4.setValue("100元");

        WxTemplateData wxTemplateData5 = new WxTemplateData();
        wxTemplateData5.setName("date");
        wxTemplateData5.setValue("2019-06-04");

        WxTemplateData wxTemplateData6 = new WxTemplateData();
        wxTemplateData6.setName("remark");
        wxTemplateData6.setValue("感谢您的使用!");

        wxTemplateMessage.addData(wxTemplateData).addData(wxTemplateData1)
                .addData(wxTemplateData2).addData(wxTemplateData3)
                .addData(wxTemplateData4).addData(wxTemplateData5)
                .addData(wxTemplateData6);
        wxTemplateMsgService.sendTemplateMsg(wxTemplateMessage);
    }
}