package com.jn.hr.employee.task;

import com.jn.hr.employee.service.EmployeeTaskService;
import com.jn.hr.employee.service.impl.EmployeeBasicInfoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author dt
 * @create 2019-05-08 下午 4:50
 */
@Component
@Configuration
@EnableScheduling
public class EmployeeTask {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeBasicInfoServiceImpl.class);
    @Autowired
    private EmployeeTaskService employeeTaskService;
    //3.添加定时任务
    @Scheduled(cron = "0 0 3 * * ?")
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        long start=System.currentTimeMillis();
        logger.info("假期管理定时任务开始执行");
        try{
            employeeTaskService.generateVacation();
            long end=System.currentTimeMillis();
            logger.info("假期管理定时任务执行结束,共耗时:{}",(end-start));
        }catch(Exception e){
            logger.error("假期管理定时任务执行出现异常:"+e.getMessage(),e);
        }
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
