package org.xxpay.service.mq;

import com.alibaba.fastjson.JSONObject;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.LoadBalancerUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xxpay.common.constant.PayConstant;
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

    @Autowired
    private LoadBalancerUtil loadBalancerUtil;

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
     * 回调通知
     *根据回调地址进行通知业务系统，如果存在http方式回调 则不用springCloud方式
     * @param msgObj 通知消息
    * */
    public String callbackNotice(JSONObject msgObj) {
        //回调通知接收的结果（success 成功 ，非success 如：fail 则会继续隔段时间回调）
        String noticeResult = "";

        //http回调通知地址
        String respUrl = msgObj.getString("url");
        //springCloud 回调通知
        String serviceId = msgObj.getString("serviceId");
        String serviceUrl = msgObj.getString("serviceUrl");

        //根据回调地址进行通知业务系统，如果存在http方式回调 则不用springCloud方式
        if(StringUtils.isNotBlank(respUrl)){
            //http 回调通知
            noticeResult = httpPost(respUrl, (10 * 1000),(5 * 1000));
            _log.info("======MQ http方式回调 通知url:{},返回结果：{}",respUrl,noticeResult);
        }else {
            //springCloud 回调通知
            String payOrderJson = msgObj.getString("payOrderJson");
            Result<String> apiResult = loadBalancerUtil.getClientPostForEntity(serviceId, serviceUrl, payOrderJson);
            if(GlobalConstants.SUCCESS_CODE.equals(apiResult.getCode())){
                noticeResult = PayConstant.MCH_NOTICE_REQUEST_SUCCESS;
            }

            _log.info("======MQ springCloud方式回调 serviceId:{},serviceUrl:{},返回结果code：{}",serviceId,serviceUrl,apiResult.getCode());
        }

        return noticeResult;
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
