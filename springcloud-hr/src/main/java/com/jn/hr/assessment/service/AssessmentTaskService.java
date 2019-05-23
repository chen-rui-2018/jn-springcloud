package com.jn.hr.assessment.service;

import java.util.Map;

import com.jn.common.model.Result;

public interface AssessmentTaskService {

	public Result<Map<String,String>> assessmentEndScanning();
}
