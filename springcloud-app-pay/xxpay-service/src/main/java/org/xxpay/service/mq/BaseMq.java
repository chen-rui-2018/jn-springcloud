package org.xxpay.service.mq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xxpay.common.util.MyLog;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


@Component
public class BaseMq  {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;
    /**
     * 日志
    * */
    private static final MyLog _log = MyLog.getLog(BaseMq.class);


    /**
     * 消息队列发送
     * @param queueName 队列名称
     * @param msg 消息内容
     * */
    public void send(String queueName,String msg) {
        _log.info("发送MQ消息:msg={}", msg);
        this.rabbitmqTemplate.convertAndSend(queueName , msg);
    }


    /**
     * 发送延迟消息
     * @param queueName 队列名称
     * @param msg 消息内容
     * @param delay 延迟时间(毫秒)
     */
    public void send(String queueName,String msg,final long delay) {
        _log.info("发送MQ延时消息:msg={},delay={}", msg, delay);
        this.rabbitmqTemplate.convertAndSend(queueName , (Object) msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDelay((int) delay);
                return message;
            }
        });
    }



    public static class TrustAnyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }
    }

    /**
     * HTTP(post)请求回调业务系统
     * @param url 请求地址
     * @param connectTimeout 连接超时(毫秒)
     * @param readTimeout 读取超时(毫秒)
    * */
    public String httpPost(String url,int connectTimeout,int readTimeout) {
        StringBuffer sb = new StringBuffer();
        try {
            URL console = new URL(url);
            if("https".equals(console.getProtocol())) {
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
                        new java.security.SecureRandom());
                HttpsURLConnection con = (HttpsURLConnection) console.openConnection();
                con.setSSLSocketFactory(sc.getSocketFactory());
                con.setRequestMethod("POST");
                con.setDoInput(true);
                con.setDoOutput(true);
                con.setUseCaches(false);
                con.setConnectTimeout(connectTimeout);
                con.setReadTimeout(readTimeout);
                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()), 1024*1024);
                while (true) {
                    String line = in.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                }
                in.close();
            }else if("http".equals(console.getProtocol())) {
                HttpURLConnection con = (HttpURLConnection) console.openConnection();
                con.setRequestMethod("POST");
                con.setDoInput(true);
                con.setDoOutput(true);
                con.setUseCaches(false);
                con.setConnectTimeout(connectTimeout);
                con.setReadTimeout(readTimeout);
                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()), 1024*1024);
                while (true) {
                    String line = in.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                }
                in.close();
            }else {
                _log.error("not do protocol. protocol=%s", console.getProtocol());
            }
        } catch(Exception e) {
            _log.error(e, "httpPost exception. url:%s", url);
        }
        return sb.toString().trim();
    }



}
