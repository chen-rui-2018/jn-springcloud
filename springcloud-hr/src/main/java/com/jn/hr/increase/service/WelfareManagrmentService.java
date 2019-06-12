package com.jn.hr.increase.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.jn.common.model.PaginationData;
import com.jn.hr.increase.model.IncreaseStaff;
import com.jn.hr.increase.model.IncreaseStaffAdd;
import com.jn.hr.increase.model.IncreaseStaffPage;
import com.jn.hr.increase.model.InsureManagement;
import com.jn.hr.increase.model.InsureManagementPage;
import com.jn.hr.increase.model.InsuredDetaild;
import com.jn.hr.increase.model.InsuredDetaildPage;
import com.jn.hr.increase.model.InsuredScheme;
import com.jn.hr.increase.model.InsuredSchemeAdd;
import com.jn.hr.increase.model.InsuredSchemeDetailedAdd;
import com.jn.hr.increase.model.InsuredSchemePage;
import com.jn.system.model.User;

@Service
public interface WelfareManagrmentService {
    //分页查询参保管理
	public PaginationData<List<InsureManagement>> inquireInsuredManagement(InsureManagementPage insureManagementPage);
	//添加次月账单
	public void addNextMonthBill();
	//导入历史参保记录
	public String importHistoryInsuranceRecord(MultipartFile file,User user);
	
	//添加增员计划
	public String addAttritionPlan(IncreaseStaffAdd increaseStaffAdd,User user);
	//分页查询增减员计划
	public PaginationData<List<IncreaseStaff>> inquireAttritionPlan(IncreaseStaffPage increaseStaffPage);	
	//修改参保基数
	public String updateInsuredCardinalNumber(InsuredSchemeAdd insuredSchemeAdd,User user);
	//取消 
	public String deleteAttritionPlan(IncreaseStaffPage increaseStaffPage);
	
	//导出参保记录
	public PaginationData<List<InsuredDetaild>> exportInsuranceRecord(InsuredDetaildPage insuredDetaildPage);
	//参保明细页面明细
	public PaginationData<List<InsuredDetaild>> paginationInquireInsuranceRecord(InsuredDetaildPage insuredDetaildPage);
	//参保明细页面-附属
	public InsureManagement insuredDetailedSubsidiary(InsuredDetaildPage insuredDetaildPage);
	//停止参保
	public String stopInsurance(IncreaseStaffAdd increaseStaffAdd,User user);
	
	
	//分页查询自主参保方案
	public PaginationData<List<InsuredScheme>> paginationInquireInsurance(InsuredSchemePage insuredSchemePage);
	//修改参保方案
	public String updateInsurancescheme(InsuredSchemeAdd insuredSchemeAdd,User user);
	//删除参保方案
	public String deleteInsurancescheme(InsuredSchemePage insuredSchemePage);
	//添加参保方案
	public String addInsurancescheme(InsuredSchemeAdd insuredSchemeAdd,User user);
	//查询参保方案页面
	public InsuredScheme insuranceSchemeDetailed(InsuredSchemePage insuredSchemePage);
	//参保概况
	public InsuredDetaild insuredOverview(InsuredDetaildPage insuredDetaildPage);
}
