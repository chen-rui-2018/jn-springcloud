package com.jn.park.plan.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.park.message.model.FindAllMessageListVo;
import com.jn.park.plan.dao.ProjectManageDao;
import com.jn.park.plan.model.*;
import com.jn.park.plan.service.ProjectManageService;
import com.jn.park.plan.vo.ProjectPlanVo;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
    public PaginationData<PaginationData<List<ProjectManageModel>>> findAll(ProjectModel projectModel) {
        if(projectModel.getOrderByClause() == null){
            projectModel.setOrderByClause("project_no desc");
        }
        if(projectModel.getProgress() == null){
            projectModel.setProgress("");
        }
        if(projectModel.getProjectState() == null){
            projectModel.setProjectState("");
        }
        if(projectModel.getProjectName() == null){
            projectModel.setProjectName("");
        }
        Page<Object> objects = PageHelper.startPage(projectModel.getPage(), projectModel.getRows());
        List<ProjectManageModel> projectManageModelsList= projectManageDao.findAll(projectModel.getProjectState(),projectModel.getProgress(),projectModel.getProjectName(),projectModel.getOrderByClause());
        //获取每一条工程项目信息
        for(int i=0 ; i < projectManageModelsList.size() ; i++){
            //计算出剩余工期   不使用查询结果的剩余工期,拿到当前时间与查询的计划结束时间计算,得到剩余工期
            String surplusTime= getDatePoor(DateUtils.parseDate(projectManageModelsList.get(i).getPlanStopTime()));
            projectManageModelsList.get(i).setSurplusTime(surplusTime);
            //获取到每一个项目的进度记录信息
            List<ProjectProgressRecordModel> projectProgressRecordModelsList=projectManageModelsList.get(i).getProjectProgressRecordModels();
            //循环获取每个项目进度记录中的每一条
            List<String> createTime=new ArrayList<>();
            List<String> progress=new ArrayList<>();
            for(int j=0 ; j<projectProgressRecordModelsList.size() ; j++){
                ProjectProgressRecordModel projectProgressRecordModel=projectProgressRecordModelsList.get(j);
                //拼接出数组集合
                createTime.add(projectProgressRecordModel.getCreatedTime());
                progress.add(projectProgressRecordModel.getProgress());
                //
                ProjectProgressRecordArrayModel projectProgressRecordArrayModel=new ProjectProgressRecordArrayModel();
                projectProgressRecordArrayModel.setCreatedTime(createTime);
                projectProgressRecordArrayModel.setProgress(progress);
                projectProgressRecordArrayModel.setCurrentData(projectProgressRecordModel.getCurrentData());

                projectManageModelsList.get(i).setArrayModel(projectProgressRecordArrayModel);
            }

        }




        return new  PaginationData(projectManageModelsList,objects.getTotal());
    }


    @ServiceLog(doAction = "工程项目查看-任务信息")
    @Override
    public List<ProjectTaskModel> findProjectTask(String projectNo) {

        return projectManageDao.findProjectTask(projectNo);
    }


    @ServiceLog(doAction = "工程项目查看-任务进展")
    @Override
    public List<ProjectPlanVo>  findTaskPlan(String projectNo) {
        //ProjectPlanVo
        ProjectPlanModel projectPlanModelList= projectManageDao.findTaskPlan(projectNo);
        String key[]={"未开始","已完成","已开始"};
        List<ProjectPlanVo> projectPlanVos=new ArrayList<>();
        for(int i =0 ; i < 3 ; i++){
            ProjectPlanVo projectPlanVo=new ProjectPlanVo();
            projectPlanVo.setKey(key[i]);
            if(i == 0){
                projectPlanVo.setValue(projectPlanModelList.getNoStart());
            }
            if(i == 1){
                projectPlanVo.setValue(projectPlanModelList.getComplete());
            }
            if(i == 2){
                projectPlanVo.setValue(projectPlanModelList.getUnComplete());
            }
            projectPlanVos.add(projectPlanVo);
        }


        return projectPlanVos;
    }

    @ServiceLog(doAction = "工程项目查看-完成及时率")
    @Override
    public ProjectCompleteRatioArrayModel findCompleteRatio(String projectNo) {

        ProjectCompleteRatioModel projectCompleteRatioModel= projectManageDao.findCompleteRatio(projectNo);

        ProjectCompleteRatioArrayModel projectCompleteRatioArrayModel=new ProjectCompleteRatioArrayModel();
        //赋值月份
        List<String> month=new ArrayList<>();
        for (int i=1;i<13;i++){
            String m=i+"月";
            month.add(m);
        }
        projectCompleteRatioArrayModel.setMonth(month);
        //List<CompleteRatioModel> completeRatioModels=new ArrayList<>();

        CompleteRatioModel completeRatioModel=new CompleteRatioModel();

        List<String> plan=new ArrayList<>();
        List<String> autual=new ArrayList<>();
        List<String> completeRatio=new ArrayList<>();

        plan.add(projectCompleteRatioModel.getAutual1());
        plan.add(projectCompleteRatioModel.getAutual2());
        plan.add(projectCompleteRatioModel.getAutual3());
        plan.add(projectCompleteRatioModel.getAutual4());
        plan.add(projectCompleteRatioModel.getAutual5());
        plan.add(projectCompleteRatioModel.getAutual6());
        plan.add(projectCompleteRatioModel.getAutual7());
        plan.add(projectCompleteRatioModel.getAutual8());
        plan.add(projectCompleteRatioModel.getAutual9());
        plan.add(projectCompleteRatioModel.getAutuall0());
        plan.add(projectCompleteRatioModel.getAutual11());
        plan.add(projectCompleteRatioModel.getAutual12());

        autual.add(projectCompleteRatioModel.getAutual1());
        autual.add(projectCompleteRatioModel.getAutual2());
        autual.add(projectCompleteRatioModel.getAutual3());
        autual.add(projectCompleteRatioModel.getAutual4());
        autual.add(projectCompleteRatioModel.getAutual5());
        autual.add(projectCompleteRatioModel.getAutual6());
        autual.add(projectCompleteRatioModel.getAutual7());
        autual.add(projectCompleteRatioModel.getAutual8());
        autual.add(projectCompleteRatioModel.getAutual9());
        autual.add(projectCompleteRatioModel.getAutuall0());
        autual.add(projectCompleteRatioModel.getAutual11());
        autual.add(projectCompleteRatioModel.getAutual12());

        completeRatio.add(projectCompleteRatioModel.getCompleteRatio1());
        completeRatio.add(projectCompleteRatioModel.getCompleteRatio2());
        completeRatio.add(projectCompleteRatioModel.getCompleteRatio3());
        completeRatio.add(projectCompleteRatioModel.getCompleteRatio4());
        completeRatio.add(projectCompleteRatioModel.getCompleteRatio5());
        completeRatio.add(projectCompleteRatioModel.getCompleteRatio6());
        completeRatio.add(projectCompleteRatioModel.getCompleteRatio7());
        completeRatio.add(projectCompleteRatioModel.getCompleteRatio8());
        completeRatio.add(projectCompleteRatioModel.getCompleteRatio9());
        completeRatio.add(projectCompleteRatioModel.getCompleteRatio10());
        completeRatio.add(projectCompleteRatioModel.getCompleteRatio11());
        completeRatio.add(projectCompleteRatioModel.getCompleteRatio12());

        completeRatioModel.setPlan(plan);
        completeRatioModel.setAutual(autual);
        completeRatioModel.setCompleteRatio(completeRatio);

        projectCompleteRatioArrayModel.setCompleteRatioModels(completeRatioModel);

        return projectCompleteRatioArrayModel;
    }


    public static String getDatePoor(Date endDate) {

        Date nowDate=new Date();
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        //return day + "天" + hour + "小时" + min + "分钟";
        return day + "天" + hour + "小时" ;
    }
}
