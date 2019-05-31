package com.jn.hr.attendance.task;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jn.hr.attendance.model.AttendanceManagementAdd;
import com.jn.hr.attendance.service.AttendanceTaskService;
import com.jn.hr.attendance.service.impl.AttendanceTaskServiceImpl;

@Component
@Configuration
@EnableScheduling
public class AttendanceTask {

	private static final Logger logger = LoggerFactory.getLogger(AttendanceTaskServiceImpl.class);
   
    @Autowired
    private AttendanceTaskService attendanceTaskService;
    //3.添加定时任务
    @Scheduled(cron = "0 0 3 * * ?")
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        long start=System.currentTimeMillis();
        logger.info("考勤管理定时任务开始执行");
        try{
        	attendanceTaskService.summaryAttendanceInfo();
            long end=System.currentTimeMillis();
            logger.info("考勤管理定时任务执行结束,共耗时:{}",(end-start));
        }catch(Exception e){
            logger.error("考勤管理定时任务执行出现异常:"+e.getMessage(),e);
        }
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
