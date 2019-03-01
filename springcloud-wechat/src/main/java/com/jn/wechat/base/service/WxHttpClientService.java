package com.jn.wechat.base.service;


/**
 * 统一处理调用微信接口
 *
 * @Author： cm
 * @Date： Created on 2019/1/17 10:33
 * @Version： v1.0
 * @Modified By:
 */
public interface WxHttpClientService {

    /**
     * get请求调用微信接口返回报文字符串
     * 该接口会自动在url后拼接access_token值并将queryParam参数追加在最后
     * @param url 微信接口地址
     * @param queryParam 实体类参数，没有可不用传值，或则已拼接到url地址上也可以不用传值
     * @return
     */
    String get(String url, String queryParam);

    /**
     * get请求调用微信接口返回报文字符串
     * @param url 微信接口地址
     * @return
     */
    String get(String url);

    /**
     * post请求调用微信接口返回报文字符串
     * @param url 微信接口地址
     * @param postParam 实体类参数
     * @return
     */
    String post(String url,Object postParam);

    /**
     * post请求调用微信接口返回报文字符串
     * @param url 微信接口地址
     * @param postParam 字符串参数
     * @return
     */
    String post(String url,String postParam);

}
