package com.jn.hr.assessment.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jn.common.model.Result;
import com.jn.hr.assessment.dao.AssessManageMapper;
import com.jn.hr.assessment.dao.AssessmentSubsidiaryMapper;
import com.jn.hr.assessment.model.AssessmentManagePage;
import com.jn.hr.assessment.model.AssessmentManageVo;
import com.jn.hr.assessment.service.AssessmentTaskService;

@Service
public class AssessmentTaskServiceImpl implements AssessmentTaskService {

	private static final Logger logger = LoggerFactory.getLogger(AssessmentTaskServiceImpl.class);
	@Autowired
	AssessManageMapper assessManageMapper;
	@Autowired
	AssessmentSubsidiaryMapper assessmentSubsidiaryMapper;
	
	
	@Override
	public Result<Map<String,String>> assessmentEndScanning() {
		Result<Map<String,String>> result=new Result<Map<String,String>>();
		AssessmentManagePage assessmentManagePage = new AssessmentManagePage();
		List<AssessmentManageVo> assessmentNameList = assessManageMapper.selectGroupByAssessmentName(assessmentManagePage);
		for(AssessmentManageVo record : assessmentNameList){
			if(record.getAssessmentEndTime().before(new Date())){
				assessmentManagePage = new AssessmentManagePage();
				assessmentManagePage.setAssessmentId(record.getAssessmentId());
				assessManageMapper.updateByStatus(assessmentManagePage);
				assessmentSubsidiaryMapper.updateByAssessmentStatus(null,record.getAssessmentId());
				logger.info("[考核定时任务]考核截止日期已到，结束考核!考核项目id:" + record.getAssessmentId());
			}
		}
		
		return result;
	}

}
