package com.jn.test.controller;

import com.jn.common.util.file.MultipartFileUtil;
import com.jn.common.util.lock.JnSpringCloudLockException;
import com.jn.common.util.lock.LockAnnotation;
import com.jn.down.api.DownLoadClient;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import com.jn.down.model.DownLoad;
import com.jn.upload.api.UploadClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * 1,配置更新测试，如果需要动态更新的配置文件，需要加入@RefreshScope注解
 *2,redis缓存测试
 * 3,hystrix 的使用
 * 4,服务间的文件的下载
 * 5,服务间的文件上传
 * 6，锁的使用
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
    public Result<String> downLoad() {
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


    @Autowired
    private UploadClient uploadClient;
    @RequestMapping(value = "/guest/test5")
    public Result<String> uploadFile() throws IOException {
        File file = new File("D:\\test\\test.png");
        MultipartFile multipartFile = MultipartFileUtil.from(file,null);
        return uploadClient.uploadFile(multipartFile,Boolean.FALSE);
    }


    @Autowired
    private Jedis jedis;


    @RequestMapping(value = "/guest/test6")
    public Result jedis11(String key,String account) {
        try{
            this.testService.doService(key,account,0.1,1L);
        }catch (JnSpringCloudLockException e){
            //对锁发生的异常行为，进行业务处理。。。
        }catch (Exception e){
            throw e;
        }

        return new Result() ;
    }

}
