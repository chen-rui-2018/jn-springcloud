package com.jn.nodify.send;

import com.jn.common.channel.MessageSource;
import com.jn.wechat.model.TemplateData;
import com.jn.wechat.model.TemplateMessage;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(value = {MessageSource.class})
public class WetChatSendTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    @Ignore
    public void sendMessage() {

        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.setToUser("oQgOO5sOQjlb8dUGsiLoeeInPIRk");
        templateMessage.setTemplateId("3LdK9s7ToSCeBW9dPfEiuXtYP-y_utRBL-cEbHA_xJc");

        TemplateData templateData = new TemplateData();
        templateData.setValue("欢迎");

        TemplateData templateData1 = new TemplateData();
        templateData1.setValue("value1");

        TemplateData templateData2 = new TemplateData();
        templateData2.setValue("value2");

        templateMessage.addData(templateData).addData(templateData1).addData(templateData2);
        messageSource.outputWetChat().send(MessageBuilder.withPayload(templateMessage).build());
    }
}