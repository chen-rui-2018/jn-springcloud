package com.jn.test.controller;

import com.jn.client.DownLoadClient;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import com.jn.domain.DownLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

/**
 * 1,配置更新测试，如果需要动态更新的配置文件，需要加入@RefreshScope注解
 *2,redis缓存测试
 * 3,hystrix 的使用
 * 4,服务间的文件的下载
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By: shenph
 */
@RestController
public class TestController extends BaseController {

    

    @Autowired
    private RedisCacheFactory redisCacheFactory;
    
    @Autowired
    private TestDomain testDomain;

    @RequestMapping(value = "/guest/test")
    public Result<String> test() {
        return new Result(testDomain.getTest());
    }

    @RequestMapping(value = "/guest/test1")
    public Result<Integer> test1() {
        Cache<Integer> cache =redisCacheFactory.getCache("yanzhengma");
        if (cache==null) {
            return new Result(testDomain.getMis());
        }
        HashMap<String,Integer> hashMap = new HashMap();
        hashMap.put("yanzhengma1",cache.get("yanzhengma1"));
        hashMap.put("size",cache.size());
        return new Result(hashMap);
    }



    @RequestMapping(value = "/guest/test2")
    public Result<Integer> test2() {
        Cache<Integer> cache =redisCacheFactory.initCache("yanzhengma",testDomain.getMis());
        cache.put("yanzhengma1",testDomain.getMis());
        cache.put("yanzhengma2",testDomain.getMis());
        return new Result(GlobalConstants.SUCCESS_CODE);
    }


    @Autowired
    private TestService testService;

    @RequestMapping(value = "/guest/test3")
    public Result<String> hiService() {
        return new Result(testService.hiService());
    }

    @Autowired
    private DownLoadClient downLoadClient;
    @RequestMapping(value = "/guest/test4")
    public Result<String> heapOutOfMemory() {
        DownLoad downLoad = new DownLoad("http://192.168.10.45:2020/group1/M00/00/00/wKgKLVwJHT2Abtp3AAQdy_tf4s4411.png",Boolean.TRUE);
        ResponseEntity<byte[]> responseEntity = this.downLoadClient.downLoad(downLoad);
        byte[] bytes = responseEntity.getBody();
        File dir = new File("D:\\test");
        if (!dir.exists()&&dir.isDirectory()){
            dir.mkdirs();
        }
        File file = new File("D:\\test\\test.png");
        try(FileOutputStream fileOutputStream = new FileOutputStream(file); BufferedOutputStream buffer= new BufferedOutputStream(fileOutputStream)){
            buffer.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result<>();


    }

}
