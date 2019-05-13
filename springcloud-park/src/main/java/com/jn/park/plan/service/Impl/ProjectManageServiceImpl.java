package com.jn.park.plan.service.Impl;

import com.jn.park.plan.dao.ProjectManageDao;
import com.jn.park.plan.model.*;
import com.jn.park.plan.service.ProjectManageService;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: tangry
 * @Date: 2019/5/11
 * @Version 1.0
 */
@Transactional
@Service
public class ProjectManageServiceImpl implements ProjectManageService {

    @Autowired
    private ProjectManageDao projectManageDao;

    @ServiceLog(doAction = "工程项目管理")
    @Override
    public List<ProjectManageModel> findAll(String projectState, String progress, String projectName, String orderByClause) {
        if(orderByClause == "" || orderByClause == null){
            orderByClause="project_no desc";
        }
        List<ProjectManageModel> projectManageModelsList= projectManageDao.findAll(projectState,progress,projectName,orderByClause);
        //获取每一条工程项目信息
        for(int i=0 ; i < projectManageModelsList.size() ; i++){
            //获取到每一个项目的进度记录信息
            List<ProjectProgressRecordModel> projectProgressRecordModelsList=projectManageModelsList.get(i).getProjectProgressRecordModels();
            //循环获取每个项目进度记录中的每一条
            for(int j=0 ; j<projectProgressRecordModelsList.size() ; j++){
                ProjectProgressRecordModel projectProgressRecordModel=projectProgressRecordModelsList.get(j);
                //判断记录月份是1-9月还是10-12月,1-9月去0加月.10-12在后面加月
                String ct=projectProgressRecordModel.getCreatedTime();
                if(Integer.parseInt(ct)<10){
                    ct=String.format("%s月",ct.substring(1));
                }else{
                    ct=String.format("%s月",ct);
                }
                projectProgressRecordModel.setCreatedTime(ct);
                projectProgressRecordModel.setProgress(projectProgressRecordModel.getProgress()+"%");
            }

        }
        return projectManageModelsList;
    }


    @ServiceLog(doAction = "工程项目查看-任务信息")
    @Override
    public List<ProjectTaskModel> findProjectTask(String projectNo) {

        return projectManageDao.findProjectTask(projectNo);
    }


    @ServiceLog(doAction = "工程项目查看-任务进展")
    @Override
    public ProjectPlanModel findTaskPlan(String projectNo) {
        return projectManageDao.findTaskPlan(projectNo);
    }

    @ServiceLog(doAction = "工程项目查看-完成及时率")
    @Override
    public ProjectCompleteRatioModel findCompleteRatio(String projectNo) {
        return projectManageDao.findCompleteRatio(projectNo);
    }
}
