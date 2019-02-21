package com.jn.wechat.base.model.message;

import com.jn.wechat.base.utils.xml.XStreamDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.io.Serializable;
import java.util.Map;

/**
 * 微信推送过来的消息，xml格式.
 *
 * @Author： cm
 * @Date： Created on 2019/1/7 16:07
 * @Version： v1.0
 * @Modified By:
 */

@XStreamAlias("xml")
public class WxXmlMessage implements Serializable {
    private static final long serialVersionUID = -5850913447559988392L;

    /**
     * 使用dom4j解析的存放所有xml属性和值的map.
     */
    private Map<String, Object> allFieldsMap;

    @XStreamAlias("ToUserName")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String toUser;

    @XStreamAlias("FromUserName")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String fromUser;

    @XStreamAlias("CreateTime")
    private Long createTime;

    @XStreamAlias("MsgType")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String msgType;

    @XStreamAlias("Content")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String content;

    @XStreamAlias("MenuId")
    private Long menuId;

    @XStreamAlias("MsgId")
    private Long msgId;

    @XStreamAlias("PicUrl")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String picUrl;

    @XStreamAlias("MediaId")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String mediaId;

    @XStreamAlias("Format")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String format;

    @XStreamAlias("ThumbMediaId")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String thumbMediaId;

    @XStreamAlias("Location_X")
    private Double locationX;

    @XStreamAlias("Location_Y")
    private Double locationY;

    @XStreamAlias("Scale")
    private Double scale;

    @XStreamAlias("Label")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String label;

    @XStreamAlias("Title")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String title;

    @XStreamAlias("Description")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String description;

    @XStreamAlias("Url")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String url;

    @XStreamAlias("Event")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String event;

    @XStreamAlias("EventKey")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String eventKey;

    @XStreamAlias("Ticket")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String ticket;

    @XStreamAlias("Latitude")
    private Double latitude;

    @XStreamAlias("Longitude")
    private Double longitude;

    @XStreamAlias("Precision")
    private Double precision;

    @XStreamAlias("Recognition")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String recognition;

    @XStreamAlias("UnionId")
    @XStreamConverter(value = XStreamDataConverter.class)
    private String unionId;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public Double getLocationX() {
        return locationX;
    }

    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    public Double getLocationY() {
        return locationY;
    }

    public void setLocationY(Double locationY) {
        this.locationY = locationY;
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Map<String, Object> getAllFieldsMap() {
        return allFieldsMap;
    }

    public void setAllFieldsMap(Map<String, Object> allFieldsMap) {
        this.allFieldsMap = allFieldsMap;
    }

    @Override
    public String toString() {
        return "WxXmlMessage{" +
                "allFieldsMap=" + allFieldsMap +
                ", toUser='" + toUser + '\'' +
                ", fromUser='" + fromUser + '\'' +
                ", createTime=" + createTime +
                ", msgType='" + msgType + '\'' +
                ", content='" + content + '\'' +
                ", menuId=" + menuId +
                ", msgId=" + msgId +
                ", picUrl='" + picUrl + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", format='" + format + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", locationX=" + locationX +
                ", locationY=" + locationY +
                ", scale=" + scale +
                ", label='" + label + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", event='" + event + '\'' +
                ", eventKey='" + eventKey + '\'' +
                ", ticket='" + ticket + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", precision=" + precision +
                ", recognition='" + recognition + '\'' +
                ", unionId='" + unionId + '\'' +
                '}';
    }
}
