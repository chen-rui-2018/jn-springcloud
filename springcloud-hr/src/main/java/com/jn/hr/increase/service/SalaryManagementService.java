package com.jn.hr.increase.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jn.common.model.PaginationData;
import com.jn.hr.increase.model.SalaryAnalysis;
import com.jn.hr.increase.model.SalaryInfo;
import com.jn.hr.increase.model.SalaryInfoAdd;
import com.jn.hr.increase.model.SalaryInfoPage;
import com.jn.hr.increase.model.SalaryPayrollPage;
import com.jn.hr.increase.model.SalaryPayrollVo;
import com.jn.system.model.User;

/**
 * 薪资管理
 * 
 *
 */
@Service
public interface SalaryManagementService {
	//发放工资的分页查询/刷新
	public PaginationData<List<SalaryPayrollVo>> paginationInquirePayroll(SalaryPayrollPage salaryPayrollPage);
	//修改工资条
	public void updatePayroll(SalaryPayrollPage salaryPayrollPage);
	//导出工资条
	public PaginationData<List<SalaryPayrollVo>> exportPayroll(SalaryPayrollPage salaryPayrollPage);
	//导入工资条
	public String importPayroll(MultipartFile file, User user);
	//分页查询薪资表信息
	public PaginationData<List<SalaryInfo>> paginationInquireSalaryInfo(SalaryInfoPage salaryInfoPage);
	//新增薪资表信息
	public void addSalary(SalaryInfoAdd salaryInfoAdd,User user);
	//修改薪资表信息
	public void updateSalary(SalaryInfoAdd salaryInfoAdd,User user);
	//导入薪资表信息
	public String importSalary(MultipartFile file, User user);
	//导出薪资表信息
	public PaginationData<List<SalaryInfo>> exportSalary(SalaryInfoPage salaryInfoPage);
	//查询详情薪资表信息
	public SalaryInfo inquireSalaryInfo(String id);	
	//薪酬分析查询
	public SalaryAnalysis salaryAnalysis(SalaryPayrollPage salaryPayrollPage);
}
