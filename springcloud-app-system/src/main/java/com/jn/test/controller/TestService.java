package com.jn.test.controller;

import com.jn.common.util.GlobalConstants;
import com.jn.common.util.lock.LockAnnotation;
import com.jn.system.log.annotation.ServiceLog;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * 断路器测试
 *
 * @author： fengxh
 * @date： Created on 2018/12/3 17:36
 * @version： v1.0
 * @modified By:
 */
@Service
public class TestService {


    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService() {
        return  GlobalConstants.SUCCESS_CODE.toString();
    }

    public String hiError() {
        return "hi,sorry,error!";
    }



    //说明：key,account,对应的是方法体里面的参数名子
    @LockAnnotation(lockPrefix = "id",account = "account",timeOut = 30,tryCount = 3,tryTime = 500L)
    @ServiceLog(doAction = "dkdkd")
    //如果没有用户操作的key，可以不写,----@LockAnnotation(lockPrefix = "key",timeOut = 30)
    //关键参数是lockPrefix，是这个业务的唯一主键，如果确定是谁操作的，必须给account，对应的这两个参数必须是String类型
    // timeOut按照你这个业务需要运行的时间来估算，设置幅度大约为业务运行时间的5倍。trycount，trytime用于设置获取锁的重试次数和重试间隔。
    public void doService(String id,String account,Double d,long c){
        System.out.println("..........开始业务代码id:"+id+"     account:"+account);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
