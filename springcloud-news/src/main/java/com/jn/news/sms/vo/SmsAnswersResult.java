package com.jn.news.sms.vo;

import com.jn.news.sms.model.SmsAnswerResult;
import com.jn.news.sms.model.SmsErrorStatusResult;
import com.jn.news.sms.model.SmsReportResult;
import com.jn.news.utils.xml.XStreamTransformer;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.List;

/**
 * 短信回复信息
 *
 * @Author： cm
 * @Date： Created on 2019/2/25 11:40
 * @Version： v1.0
 * @Modified By:
 */
@XStreamAlias("returnsms")
public class SmsAnswersResult extends SmsErrorStatusResult implements Serializable {

    private static final long serialVersionUID = -6221719268088673966L;

    @XStreamImplicit(itemFieldName = "deliver")
    private List<SmsAnswerResult> deliver;

    public List<SmsAnswerResult> getDeliver() {
        return deliver;
    }

    public void setDeliver(List<SmsAnswerResult> deliver) {
        this.deliver = deliver;
    }

    public String toXml() {
        return XStreamTransformer.toXml((Class<SmsAnswersResult>) this.getClass(), this);
    }
}
