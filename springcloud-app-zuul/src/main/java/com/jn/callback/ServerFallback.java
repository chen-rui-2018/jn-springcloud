package com.jn.callback;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.config.CodeAndMsg;
import com.jn.config.ExceptionFactory;
import com.jn.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 向全部路由发起请求失败时的回复处理
 *
 * @author： fengxh
 * @date： Created on 2018/11/26 14:27
 * @version： v1.0
 * @modified By:
 */
@Component
public class ServerFallback implements FallbackProvider {


    @Autowired
    private ExceptionFactory factory;
    /**
     * 默认全部的路由
     */
    private final static String SERVER_ID = "*";


    @Override
    public String getRoute() {
        return SERVER_ID;
    }


    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        final CodeAndMsg codeAndMsg = this.factory.create(cause) ;
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode()  {
                return HttpStatus.OK;
            }
            @Override
            public int getRawStatusCode(){
                return HttpStatus.OK.value();
            }
            @Override
            public String getStatusText() {
                return HttpStatus.OK.getReasonPhrase();
            }
            @Override
            public void close() {
            }
            @Override
            public InputStream getBody() throws IOException {
                ObjectMapper mapper = new ObjectMapper();
                Result result = new Result(codeAndMsg.getMessage() , codeAndMsg.getCode());
                String json = mapper.writeValueAsString(result);
                return new ByteArrayInputStream(json.getBytes("UTF-8"));
            }
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return fallbackResponse(null);
    }
}
