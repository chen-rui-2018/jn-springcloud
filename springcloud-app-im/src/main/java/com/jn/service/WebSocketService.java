package com.jn.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.jn.im.dao.ImMapper;
import com.jn.im.dao.TbImMessageMapper;
import com.jn.im.entity.TbImMessage;
import com.jn.im.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * IM websocket
 *
 * @author： shenph
 * @date： Created on 2019/05/09 18:36
 * @version： v1.0
 * @modified By:
 */
@ServerEndpoint("/websocket/{userId}")
@Component
@Slf4j
public class WebSocketService {

    private static Logger logger = LoggerFactory.getLogger(WebSocketService.class);

    private static TbImMessageMapper tbImMessageMapper;

    private static ImMapper imMapper;

    @Autowired
    public void setWebSocketService(TbImMessageMapper tbImMessageMapper, ImMapper imMapper) {
        WebSocketService.tbImMessageMapper = tbImMessageMapper;
        WebSocketService.imMapper = imMapper;
    }

    private static Map<String, Session> sessionMap = new ConcurrentHashMap<String, Session>();


    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        logger.info("WebSocketService onOpen: " + userId);
        if (sessionMap == null) {
            sessionMap = new ConcurrentHashMap<String, Session>();
        }
        sessionMap.put(userId, session);

        //TODO 发送离线消息
        Session session_ = sessionMap.get(userId);
        List<Map<String, String>> userList = imMapper.selectOffLineUser(userId);
        for (Map<String, String> userMap : userList) {
            logger.info("WebSocketService sendUser:{},count:{}", userId, userMap.get("count"));
            List<TbImMessage> userSendMsg = imMapper.selectOffLineMsg(userId, userMap.get("sendId"));
            for (TbImMessage message : userSendMsg) {
                sendMsg(session_, JSONObject.toJSONString(message));
            }
        }

    }

    @OnMessage
    public void OnMessage(@PathParam("userId") String userId, Session session, String message) {
        logger.info("WebSocketService OnMessage: " + userId + "<>" + message);

        Message msg = JSONObject.parseObject(message, Message.class);

        Session session_ = sessionMap.get(msg.getToUser());

        TbImMessage tbImMessage = new TbImMessage();
        tbImMessage.setId(UUID.randomUUID().toString());
        tbImMessage.setContent(message);
        tbImMessage.setSendId(msg.getFromUser());
        tbImMessage.setCreateTime(new Date());
        tbImMessage.setReceiveId(msg.getToUser());

        if (session_ == null) {
            tbImMessage.setIsSended("N");
            logger.info("WebSocketService 无连接:" + msg.getToUser());
        } else {
            tbImMessage.setIsSended("Y");
            tbImMessage.setSendTime(new Date());
            logger.info("WebSocketService 有连接:" + msg.getToUser());
            session_.getAsyncRemote().sendText(JSONObject.toJSONString(tbImMessage));
        }
        try {
            tbImMessageMapper.insertSelective(tbImMessage);
        } catch (Exception e) {
            logger.error("WebSocketService 保存发送数据出错", e);
        }

        //群发
        /*for (Session session_ : sessionMap.values()) {
            session_.getAsyncRemote().sendText(message);
        }*/
    }

    @OnError
    public void onError(Session session, Throwable throwable, @PathParam("userId") String userId) {
        logger.error("WebSocketService Connection Exception:" + userId);
        logger.error(throwable.getMessage(), throwable);
        sessionMap.remove(userId);
    }

    @OnClose
    public void onClose(Session session, @PathParam("userId") String userId) {
        logger.info("Websocket Close Connection:" + userId);
        sessionMap.remove(userId);
    }


    protected void sendMsg(Session session, String message) {
        try {
            //synchronized (session) {
            /*session.getAsyncRemote().sendText(message);*/
            session.getBasicRemote().sendText(message);
            //}
        } catch (IOException e) {
            logger.error("WebSocketService send msg error:", e);
        }
    }

}

