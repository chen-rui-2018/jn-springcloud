package com.jn.news.vo;

/**
 * 邮件内嵌图片VO
 *
 * @Author： cm
 * @Date： Created on 2018/11/19 14:24
 * @Version： v1.0
 * @Modified By:
 */
public class EmailInlayImageVo {

    /**
     * 指非模板邮件内嵌图片cid名称
     * 如非模板邮件中的cid名称weixin：<img src="cid:weixin" ></body></html>
     * 如模板邮件中的cid参数名imageResourceName：<img th:src="|cid:${imageResourceName}|" />
     */
    String imageCid;

    /**
     * 邮件内嵌图片绝对路径
     */
    String imageUrl;

    public String getImageCid() {
        return imageCid;
    }

    public void setImageCid(String imageCid) {
        this.imageCid = imageCid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "EmailInlayImageVo{" +
                "imageCid='" + imageCid + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
