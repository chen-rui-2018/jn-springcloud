package com.jn.news.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 邮件信息VO
 *
 * @Author： cm
 * @Date： Created on 2018/11/15 15:56
 * @Version： v1.0
 * @Modified By:
 */
public class EmailVo implements Serializable {
    private static final long serialVersionUID = 6112087263463382255L;

    /*****************邮件基础信息开始*************/

    /**
     * 收件箱,多个邮箱以英文逗号隔开
     * java的RFC822规范中规定多个邮件分隔符是逗号","，outlook的分号";"不是规范的多邮件地址分隔符。
     */
    private String email;

    /**
     * 邮件主题
     */
    private String emailSubject;

    /**
     * 邮件内容，如果是模板邮件不用赋值
     */
    private String emailContent;

    /**
     * 附件
     */
    private String[] files;

    /*****************邮件基础信息结束*************/

    /**
     * 内嵌图片（Map中的key需与邮件内容中的cid的值一致）
     * 现在一般不会做内嵌图片，因为这样邮件会很大，容易对服务器造成压力，一般做法是使用图片链接
     * 另外，如果要做内嵌或发送图片，应该使用信用较高的邮箱帐户
     */
    private List<EmailInlayImageVo> emailInlayImageVoList;

    /**
     * 邮件模板名称
     */
    private String templatesName;

    /**
     * 用于存储模板渲染所需要的数据
     */
    private Map templatesDataMap;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String[] getFiles() {
        return files;
    }

    public void setFiles(String[] files) {
        this.files = files;
    }

    public List<EmailInlayImageVo> getEmailInlayImageVoList() {
        return emailInlayImageVoList;
    }

    public void setEmailInlayImageVoList(List<EmailInlayImageVo> emailInlayImageVoList) {
        this.emailInlayImageVoList = emailInlayImageVoList;
    }

    public String getTemplatesName() {
        return templatesName;
    }

    public void setTemplatesName(String templatesName) {
        this.templatesName = templatesName;
    }

    public Map getTemplatesDataMap() {
        return templatesDataMap;
    }

    public void setTemplatesDataMap(Map templatesDataMap) {
        this.templatesDataMap = templatesDataMap;
    }

    @Override
    public String toString() {
        return "EmailVo{" +
                "email='" + email + '\'' +
                ", emailSubject='" + emailSubject + '\'' +
                ", emailContent='" + emailContent + '\'' +
                ", files=" + Arrays.toString(files) +
                ", emailInlayImageVoList=" + emailInlayImageVoList +
                ", templatesName='" + templatesName + '\'' +
                ", templatesDataMap=" + templatesDataMap +
                '}';
    }
}
