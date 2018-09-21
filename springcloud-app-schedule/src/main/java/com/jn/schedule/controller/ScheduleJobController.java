package com.jn.schedule.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/schedule")
public class ScheduleJobController {

    @RequestMapping("/list")
    public Object getAllJobs() {
        return "test";
    }


}
