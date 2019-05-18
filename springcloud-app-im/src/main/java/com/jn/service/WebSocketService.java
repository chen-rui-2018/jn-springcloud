package com.jn.service;

import com.alibaba.fastjson.JSONObject;
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
@ServerEndpoint("/websocket/{userId}/{token}")
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
    private static String WEBSOCKET_TOKEN = "IM_123_qwe**_X_Q";

    @OnOpen
    public void onOpen(@PathParam("userId") String userId, @PathParam("token") String token, Session session) {
        logger.info("WebSocketService OnOpen: userId>{},token>{}", userId, token);

        if (WEBSOCKET_TOKEN.equals(token)) {
            if (sessionMap == null) {
                sessionMap = new ConcurrentHashMap<String, Session>();
            }
            sessionMap.put(userId, session);

            //推送离线消息
            Session session_ = sessionMap.get(userId);
            List<Map<String, String>> userList = imMapper.selectOffLineUser(userId);
            for (Map<String, String> userMap : userList) {
                logger.info("WebSocketService sendUser:{},count:{}", userId, userMap.get("count"));
                List<TbImMessage> userSendMsg = imMapper.selectOffLineMsg(userId, userMap.get("sendId"));
                for (TbImMessage message : userSendMsg) {

                    //sendMsg(session_, JSONObject.toJSONString(message));

                    //更新消息未已读
                    TbImMessage tbImMessage = new TbImMessage();
                    tbImMessage.setId(message.getId());
                    tbImMessage.setSendId(null);
                    tbImMessage.setMsgType(null);
                    tbImMessage.setContent(null);
                    tbImMessage.setReceiveId(null);
                    tbImMessage.setCreateTime(null);
                    tbImMessage.setSendTime(new Date());
                    tbImMessage.setIsSended("Y");
                    tbImMessageMapper.updateByPrimaryKeySelective(tbImMessage);
                }
            }
        } else {
            logger.error("WebSocketService token error");
        }
    }

    @OnMessage
    public void OnMessage(@PathParam("userId") String userId, @PathParam("token") String token, Session session, String message) {
        logger.info("WebSocketService OnMessage: userId>{},token>{},message>{}", userId, token, message);

        if (WEBSOCKET_TOKEN.equals(token)) {
            Message msg = JSONObject.parseObject(message, Message.class);

            //获取接收人session
            Session session_ = sessionMap.get(msg.getToUser());

            TbImMessage tbImMessage = new TbImMessage();
            tbImMessage.setId(UUID.randomUUID().toString());
            tbImMessage.setContent(message);
            tbImMessage.setSendId(msg.getFromUser());
            tbImMessage.setCreateTime(new Date());
            tbImMessage.setReceiveId(msg.getToUser());

            if (session_ == null) {
                tbImMessage.setIsSended("N");
                logger.info("WebSocketService 无连接:userId>{}", msg.getToUser());
            } else {
                tbImMessage.setIsSended("Y");
                tbImMessage.setSendTime(new Date());
                logger.info("WebSocketService 有连接:userId>{}", msg.getToUser());
                session_.getAsyncRemote().sendText(JSONObject.toJSONString(tbImMessage));
            }

            //获取发送人session
            Session mySession_ = sessionMap.get(msg.getFromUser());
            try {
                tbImMessageMapper.insertSelective(tbImMessage);
                tbImMessage.setMsgType("0000");
            } catch (Exception e) {
                logger.error("WebSocketService 保存发送数据出错", e);
                tbImMessage.setMsgType("9999");
            }
            mySession_.getAsyncRemote().sendText(JSONObject.toJSONString(tbImMessage));
        } else {
            logger.error("WebSocketService token error");
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable, @PathParam("userId") String userId, @PathParam("token") String token) {
        logger.error("WebSocketService OnError: userId>{},token>{}", userId, token);
        logger.error(throwable.getMessage(), throwable);
        sessionMap.remove(userId);
    }

    @OnClose
    public void onClose(Session session, @PathParam("userId") String userId, @PathParam("token") String token) {
        logger.info("WebSocketService OnClose: userId>{},token>{}", userId, token);
        sessionMap.remove(userId);
    }

    /**
     * 同步发送消息
     *
     * @param session
     * @param message
     */
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

