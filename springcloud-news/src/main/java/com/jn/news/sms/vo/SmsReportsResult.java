package com.jn.news.sms.vo;

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
public class SmsReportsResult extends SmsErrorStatusResult implements Serializable {

    private static final long serialVersionUID = 6629136097126001836L;

    @XStreamImplicit(itemFieldName = "report")
    private List<SmsReportResult> report;

    public List<SmsReportResult> getReport() {
        return report;
    }

    public void setReport(List<SmsReportResult> report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "SmsReportsResult{" +
                "report=" + report +
                '}';
    }

    public String toXml() {
        return XStreamTransformer.toXml((Class<SmsReportsResult>) this.getClass(), this);
    }
}
