package com.jn.hr.increase.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.excel.annotation.ExcelProperty;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.common.enums.HrStatusEnums;
import com.jn.hr.common.util.HrDataUtil;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.dao.MobilizationManagementMapper;
import com.jn.hr.employee.dao.TbManpowerEmployeeBasicInfoMapper;
import com.jn.hr.employee.dao.TbManpowerMobilizationManagementMapper;
import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfo;
import com.jn.hr.employee.entity.TbManpowerMobilizationManagement;
import com.jn.hr.increase.dao.SalaryInfoMapper;
import com.jn.hr.increase.dao.SalaryPayrollMapper;
import com.jn.hr.increase.dao.TbManpowerSalaryInfoMapper;
import com.jn.hr.increase.dao.TbManpowerSalaryPayrollMapper;
import com.jn.hr.increase.entity.TbManpowerSalaryInfo;
import com.jn.hr.increase.entity.TbManpowerSalaryPayroll;
import com.jn.hr.increase.enums.SalaryManagementExceptionEnums;
import com.jn.hr.increase.model.SalaryAnalysis;
import com.jn.hr.increase.model.SalaryInfo;
import com.jn.hr.increase.model.SalaryInfoAdd;
import com.jn.hr.increase.model.SalaryInfoPage;
import com.jn.hr.increase.model.SalaryKeyValue;
import com.jn.hr.increase.model.SalaryPayrollAdd;
import com.jn.hr.increase.model.SalaryPayrollPage;
import com.jn.hr.increase.model.SalaryPayrollVo;
import com.jn.hr.increase.service.SalaryManagementService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;

import io.swagger.annotations.ApiModelProperty;
@Service
public class SalaryManagementServiceImpl implements SalaryManagementService {
	private static final Logger logger = LoggerFactory.getLogger(SalaryManagementServiceImpl.class);
	@Autowired
	TbManpowerSalaryInfoMapper tbManpowerSalaryInfoMapper;
	@Autowired
	SalaryInfoMapper salaryInfoMapper;
	@Autowired
	TbManpowerEmployeeBasicInfoMapper tbManpowerEmployeeBasicInfoMapper;
	@Autowired
	EmployeeBasicInfoMapper employeeBasicInfoMapper;
	@Autowired
	TbManpowerMobilizationManagementMapper tbManpowerMobilizationManagementMapper;
	@Autowired
	SalaryPayrollMapper salaryPayrollMapper;
	@Autowired
	TbManpowerSalaryPayrollMapper tbManpowerSalaryPayrollMapper;
	@Autowired
	MobilizationManagementMapper mobilizationManagementMapper;
	
	@Override
	@ServiceLog(doAction = "导入薪资信息")
	@Transactional(rollbackFor = Exception.class)
	public String importSalary(MultipartFile file, User user) {
		
		if(file.isEmpty()){
			logger.warn("[薪资管理]文件为空，导入失败");
			throw new JnSpringCloudException(SalaryManagementExceptionEnums.FILE_EMPTY);
		}
		
		SalaryInfo salaryInfo = new SalaryInfo();
		List<Object> resultList=ExcelUtil.readExcel(file, salaryInfo, 1, 1);
		if(CollectionUtils.isEmpty(resultList)){
            return "没有数据，导入失败";
        }
		
		TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = new TbManpowerEmployeeBasicInfo();
		Map<String,TbManpowerEmployeeBasicInfo> basicMap = employeeBasicInfoMapper.map(tbManpowerEmployeeBasicInfo);
		SalaryInfoPage salaryInfoPage = new SalaryInfoPage();
		Map<String,SalaryInfo> salaryMap = salaryInfoMapper.getMap(salaryInfoPage);
		int i = 0;
		StringBuffer sb=new StringBuffer();
		List<SalaryInfo> salaryInfoList = new ArrayList<SalaryInfo>();
		for(Object result : resultList){
			i++;
			SalaryInfo salary = (SalaryInfo)result;
			String str = checkField(salary);
			if(!StringUtils.isBlank(str)){
				sb.append("第"+i+"行:"+str+";");
                continue;
			}
			TbManpowerEmployeeBasicInfo basic = basicMap.get(salary.getJobNumber());
			if(basic == null){
				logger.info("[员工花名册]没有该员工，工号：" + salary.getJobNumber());
				sb.append("第"+i+"行" + "|员工信息不存在,工号:" + salary.getJobNumber() + ";");
				continue;
			}
			
			SalaryInfo info = salaryMap.get(salary.getJobNumber());
			if(info != null){
				logger.info("[薪资表]员工记录已存在，工号：" + salary.getJobNumber());
				sb.append("第"+i+"行" + "|员工薪资已存在,工号:" + salary.getJobNumber() + ";");
				continue;
			}
			salary.setRecordStatus(Byte.parseByte(HrStatusEnums.NOTDELETED.getCode()));
			salary.setId(UUID.randomUUID().toString());
			salary.setCreatedTime(new Date());
			salary.setCreatorAccount(user.getAccount());
			salary.setModifiedTime(new Date());
			salary.setModifierAccount(user.getAccount());
			salaryInfoList.add(salary);			
		}
		
        if(sb.length()>0){
            logger.warn("[薪资管理] 导入失败:{}",sb.toString());
            return sb.toString();
        }else{
        	if(!CollectionUtils.isEmpty(salaryInfoList)){
                logger.info("[薪资管理] 成功导入{}条数据",salaryInfoList.size());
                salaryInfoMapper.insertBatch(salaryInfoList);
            }
            return "导入成功";
        }
	}



	@Override
	@ServiceLog(doAction = "导出薪资信息")
	public PaginationData<List<SalaryInfo>> exportSalary(SalaryInfoPage salaryInfoPage) {
		
		Page<Object> objects = PageHelper.startPage(salaryInfoPage.getPage(),salaryInfoPage.getRows());
		TbManpowerEmployeeBasicInfo employeeBasicInfo = new TbManpowerEmployeeBasicInfo();
		BeanUtils.copyProperties(salaryInfoPage,employeeBasicInfo);
		List<TbManpowerEmployeeBasicInfo> basicInfoList = employeeBasicInfoMapper.getList(employeeBasicInfo);
		Map<String,SalaryInfo> salaryMap = salaryInfoMapper.getMap(salaryInfoPage);
		List<SalaryInfo> list = new ArrayList<SalaryInfo>();
		for(TbManpowerEmployeeBasicInfo basic : basicInfoList){
			SalaryInfo salaryInfo = salaryMap.get(basic.getJobNumber());
			if(salaryInfo == null){
				salaryInfo = new SalaryInfo();
				salaryInfo.setProbationBasicWage(0.0);
				salaryInfo.setProbationDutyAllowance(0.0);
				salaryInfo.setProbationProfessionalTitleAllowance(0.0);
				salaryInfo.setProbationSeniorityWage(0.0);
				salaryInfo.setProbationEducationAllowance(0.0);
				salaryInfo.setProbationWorkSubsidy(0.0);
				salaryInfo.setProbationAchievementBonus(0.0);
				salaryInfo.setProbationSingleReward(0.0);
				salaryInfo.setConversionBasicWage(0.0);
				salaryInfo.setConversionDutyAllowance(0.0);
				salaryInfo.setConversionProfessionalTitleAllowance(0.0);
				salaryInfo.setConversionSeniorityWage(0.0);
				salaryInfo.setConversionEducationAllowance(0.0);
				salaryInfo.setConversionWorkSubsidy(0.0);
				salaryInfo.setConversionAchievementBonus(0.0);
				salaryInfo.setConversionSingleReward(0.0);
				salaryInfo.setCurrentBasicWage("0");
				salaryInfo.setCurrentDutyAllowance("0");
				salaryInfo.setCurrentProfessionalTitleAllowance("0");
				salaryInfo.setCurrentSeniorityWage("0");
				salaryInfo.setCurrentEducationAllowance("0");
				salaryInfo.setCurrentWorkSubsidy("0");
				salaryInfo.setCurrentAchievementBonus("0");
				salaryInfo.setCurrentSingleReward("0");
				salaryInfo.setJobNumber(basic.getJobNumber());
			}
			salaryInfo.setName(basic.getName());
			list.add(salaryInfo);
		}
		PaginationData<List<SalaryInfo>> data = new PaginationData(list,objects.getTotal());
		logger.info("[薪资表]薪资信息导出成功");
		return data;
	}

	@Override
	@ServiceLog(doAction = "薪资管理信息的详情")
	public SalaryInfo inquireSalaryInfo(String jobNumber) {

		TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = employeeBasicInfoMapper.selectByJobNumber(jobNumber);
		TbManpowerMobilizationManagement mobilization = mobilizationManagementMapper.selectByJobNumber(jobNumber);
		SalaryInfo info = salaryInfoMapper.selectByJobNumber(jobNumber);
		if(info == null || tbManpowerEmployeeBasicInfo == null ){
			logger.warn("[薪资管理]查询薪资信息不存在，id{}",jobNumber);
			throw new JnSpringCloudException(SalaryManagementExceptionEnums.NOT_EXIST_ERROR);
		}
		info.setName(tbManpowerEmployeeBasicInfo.getName());
		info.setDepartmentName(tbManpowerEmployeeBasicInfo.getDepartmentName());
		info.setJobName(tbManpowerEmployeeBasicInfo.getJobNumber());
		info.setRankName(mobilization.getRankName());
		info.setPhone(tbManpowerEmployeeBasicInfo.getPhone());
		info.setCertificateType(tbManpowerEmployeeBasicInfo.getCertificateType());
		info.setCertificateNumber(tbManpowerEmployeeBasicInfo.getCertificateNumber());
		info.setEntryDate(tbManpowerEmployeeBasicInfo.getEntryDate());
		Double currentWage = checkString(info.getCurrentBasicWage()) + checkString(info.getCurrentDutyAllowance()) + 
				checkString(info.getCurrentProfessionalTitleAllowance()) + checkString(info.getCurrentSeniorityWage()) +
				checkString(info.getCurrentEducationAllowance()) + checkString(info.getCurrentWorkSubsidy()) + 
				checkString(info.getCurrentAchievementBonus()) + checkString(info.getCurrentSingleReward());
		Double conversionWage = checkIsEmpty(info.getConversionBasicWage()) + checkIsEmpty(info.getConversionDutyAllowance()) + 
				checkIsEmpty(info.getConversionProfessionalTitleAllowance()) + checkIsEmpty(info.getConversionSeniorityWage()) + 
				checkIsEmpty(info.getConversionEducationAllowance()) + checkIsEmpty(info.getConversionWorkSubsidy()) + 
				checkIsEmpty(info.getConversionAchievementBonus()) + checkIsEmpty(info.getConversionSingleReward());
		Double probationWage = checkIsEmpty(info.getProbationBasicWage()) + checkIsEmpty(info.getProbationDutyAllowance()) + 
				checkIsEmpty(info.getProbationProfessionalTitleAllowance()) + checkIsEmpty(info.getProbationSeniorityWage()) + 
				checkIsEmpty(info.getProbationEducationAllowance()) + checkIsEmpty(info.getProbationWorkSubsidy()) + 
				checkIsEmpty(info.getProbationAchievementBonus()) + checkIsEmpty(info.getProbationSingleReward());
		info.setProbationWage(probationWage);
		info.setConversionWage(conversionWage);
		info.setCurrentWage(currentWage);
		
		return info;
	}



	@Override
	@ServiceLog(doAction = "添加薪资信息")
	@Transactional(rollbackFor = Exception.class)
	public String addSalary(SalaryInfoAdd salaryInfoAdd, User user) {
		
		SalaryInfo salaryInfo = salaryInfoMapper.selectByJobNumber(salaryInfoAdd.getJobNumber());
		if(salaryInfo != null){
			logger.info("[薪资管理]薪资信息已存在!");
			throw new JnSpringCloudException(SalaryManagementExceptionEnums.EXIST_SALARYINFO);
		}
		
		TbManpowerSalaryInfo tbManpowerSalaryInfo = new TbManpowerSalaryInfo();
		BeanUtils.copyProperties(salaryInfoAdd,tbManpowerSalaryInfo);
		tbManpowerSalaryInfo.setId(UUID.randomUUID().toString());
		tbManpowerSalaryInfo.setCreatedTime(new Date());
		tbManpowerSalaryInfo.setModifiedTime(new Date());
		tbManpowerSalaryInfo.setCreatorAccount(user.getAccount());
		tbManpowerSalaryInfo.setModifierAccount(user.getAccount());
		tbManpowerSalaryInfo.setRecordStatus(Byte.parseByte(HrStatusEnums.NOTDELETED.getCode()));
		tbManpowerSalaryInfoMapper.insert(tbManpowerSalaryInfo);
		logger.info("[薪资管理]新增薪资表成功，id{}",tbManpowerSalaryInfo.getId());
		return "添加成功";
	}



	@Override
	@ServiceLog(doAction = "修改薪资信息")
	@Transactional(rollbackFor = Exception.class)
	public String updateSalary(SalaryInfoAdd salaryInfoAdd, User user) {
		
		if(salaryInfoAdd.getId() == null){
			TbManpowerSalaryInfo tbManpowerSalaryInfo = new TbManpowerSalaryInfo();
			BeanUtils.copyProperties(salaryInfoAdd,tbManpowerSalaryInfo);
			tbManpowerSalaryInfo.setId(UUID.randomUUID().toString());
			tbManpowerSalaryInfo.setCreatedTime(new Date());
			tbManpowerSalaryInfo.setModifiedTime(new Date());
			tbManpowerSalaryInfo.setCreatorAccount(user.getAccount());
			tbManpowerSalaryInfo.setModifierAccount(user.getAccount());
			tbManpowerSalaryInfo.setRecordStatus(Byte.parseByte(HrStatusEnums.NOTDELETED.getCode()));
			tbManpowerSalaryInfoMapper.insert(tbManpowerSalaryInfo);
			logger.info("[薪资管理]新增薪资表成功，id{}",tbManpowerSalaryInfo.getId());
			return "添加成功";
		}else{
			TbManpowerSalaryInfo SalaryInfo = tbManpowerSalaryInfoMapper.selectByPrimaryKey(salaryInfoAdd.getId());
			//TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = tbManpowerEmployeeBasicInfoMapper.selectByPrimaryKey(salaryInfoAdd.getId());
			if(SalaryInfo == null){
				logger.warn("[薪资管理]修改薪资信息失败，修改的薪资id不存在，id{}",salaryInfoAdd.getId());
				throw new JnSpringCloudException(SalaryManagementExceptionEnums.NOT_EXIST_ERROR);
			}

			//薪资管理修改
			TbManpowerSalaryInfo tbManpowerSalaryInfo = new TbManpowerSalaryInfo();
			BeanUtils.copyProperties(salaryInfoAdd,tbManpowerSalaryInfo);
			tbManpowerSalaryInfo.setId(salaryInfoAdd.getId());
			tbManpowerSalaryInfo.setModifiedTime(new Date());
			tbManpowerSalaryInfo.setModifierAccount(user.getAccount());
			tbManpowerSalaryInfoMapper.updateByPrimaryKeySelective(tbManpowerSalaryInfo);
			logger.info("[薪资管理]修改薪资表成功，id{}",tbManpowerSalaryInfo.getId());
			return "修改成功";
		}
	}
	
	//检查薪资信息
	private String checkField(SalaryInfo salary){
		if(StringUtils.isBlank(salary.getJobNumber())){
			return "工号不能为空（试用期）";
		}
		
		if(salary.getProbationBasicWage() == null){
			return "基本工资不能为空（试用期）";
		}
		
		if(salary.getProbationDutyAllowance() == null){
			return "职务津贴不能为空（试用期）";
		}
		
		if(salary.getProbationProfessionalTitleAllowance() == null){
			return "职称津贴不能为空（试用期）";
		}
		
		if(salary.getProbationWorkSubsidy() == null){
			return "工作性补贴不能为空（试用期）";
		}
		
		if(salary.getProbationEducationAllowance() == null){
			return "学历津贴不能为空（试用期）";
		}
	    
//		if(salary.getProbationSeniorityWage() != null){
//			
//		}
		

		/*@ApiModelProperty(value = "绩效奖金(试用期)")
		@ExcelProperty(value = "绩效奖金(试用期)", index = 8)
	    private Double probationAchievementBonus;

		@ApiModelProperty(value = "单项奖励(试用期)")
		@ExcelProperty(value = "单项奖励(试用期)", index = 9)
	    private Double probationSingleReward;*/
		return "";
	}
	
	/**
	 * 
	 * 校验字符串是否是数字
	 */
	public boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}

	@Override
	@ServiceLog(doAction = "薪酬分析")
	public SalaryAnalysis salaryAnalysis(SalaryPayrollPage salaryPayrollPage) {
		SalaryAnalysis salaryAnalysis = new SalaryAnalysis();
		//薪酬分析-工资组成
		SalaryPayrollVo payRoll = salaryPayrollMapper.selectByWage(salaryPayrollPage.getAccountEntryTime());
		if(payRoll == null){
			payRoll = new SalaryPayrollVo();
		}
		List<SalaryKeyValue> valueList = setSalaryComposition(payRoll);
		salaryAnalysis.setSalaryComposition(valueList);
		//薪酬分析-部门人力成本
		List<SalaryKeyValue> salaryList = new ArrayList<SalaryKeyValue>();
		List<SalaryKeyValue> salarySevenList = salaryPayrollMapper.selectByDepartmentWage(salaryPayrollPage.getAccountEntryTime());
		if(salarySevenList != null && salarySevenList.size() > 7){
			//排序
			attendanceSort(salarySevenList);
			for(int i = 0; i < 7; i++){
				salarySevenList.add(salarySevenList.get(i));
			}
		}else{
			salaryList.addAll(salarySevenList);
		}
		salaryAnalysis.setLaborCosts(salaryList);
		
		//薪酬分析-部门人数
		List<SalaryKeyValue> departmentNumber = salaryPayrollMapper.selectByPeople(salaryPayrollPage.getAccountEntryTime());
		salaryAnalysis.setDepartmentNumber(departmentNumber);
		//薪酬分析-部门人均工资
		List<SalaryKeyValue> perpleCapita = new ArrayList<SalaryKeyValue>();
		List<SalaryKeyValue> perpleCapitaNine = salaryPayrollMapper.selectByDepartmentCost(salaryPayrollPage.getAccountEntryTime());
		if(perpleCapitaNine != null){
			for(SalaryKeyValue keyValue : perpleCapitaNine){
				for(SalaryKeyValue key : departmentNumber){
					Integer i = Integer.valueOf(key.getValue());
					if(keyValue.getName().equals(key.getName())){
						Double wage = Double.valueOf(keyValue.getValue());
						keyValue.setValue(String.format("%.2f",wage/(1000 * i)));
					}
				}
			}
			//排序
			attendanceSort(perpleCapitaNine);
			if(perpleCapitaNine.size() > 9){
				for(int i = 0; i < 9;i++){
					perpleCapita.add(perpleCapitaNine.get(i));
				}
			}else{
				perpleCapita.addAll(perpleCapitaNine);
			}
		}
		
		
		Integer number = 0;
		Date date = HrDataUtil.getLastdayMonth(salaryPayrollPage.getAccountEntryTime());
		//上个月的薪资信息
		SalaryPayrollVo lastPayRoll = salaryPayrollMapper.selectByWage(DateUtils.formatDate(date,"yyyy-MM"));
		if(lastPayRoll != null){
			if(payRoll.getDeserveWage() >= lastPayRoll.getDeserveWage()){
				Double deserveWage = payRoll.getDeserveWage() - lastPayRoll.getDeserveWage();
				String str = "+" + HrDataUtil.getDoublePercentStr(deserveWage, payRoll.getDeserveWage()) + "%";
				if(deserveWage == 0){
					salaryAnalysis.setLastDeserveWage("0");
				}else{
					salaryAnalysis.setLastDeserveWage(str);
				}
			}else{
				Double deserveWage =  lastPayRoll.getDeserveWage() - payRoll.getDeserveWage();
				String str = "-" + HrDataUtil.getDoublePercentStr(deserveWage, payRoll.getDeserveWage()) + "%";
				salaryAnalysis.setLastDeserveWage(str);
			}
			
			if(payRoll.getRealWage() >= lastPayRoll.getRealWage()){
				Double realWage = payRoll.getRealWage() - lastPayRoll.getRealWage();
				String str = "+" + HrDataUtil.getDoublePercentStr(realWage, payRoll.getRealWage()) + "%";
				if(realWage == 0){
					salaryAnalysis.setLastRealWage("0");
				}else{
					salaryAnalysis.setLastRealWage(str);
				}
			}else{
				Double realWage =lastPayRoll.getRealWage() - payRoll.getRealWage();
				String str = "-" + HrDataUtil.getDoublePercentStr(realWage, payRoll.getRealWage()) + "%";
				salaryAnalysis.setLastRealWage(str);
			}
			number = payRoll.getNumber() - lastPayRoll.getNumber();
		}else{
			salaryAnalysis.setLastRealWage("0");
			salaryAnalysis.setLastDeserveWage("0");
		}
		
		
		salaryAnalysis.setPerpleCapita(perpleCapita);
		salaryAnalysis.setRealWage(payRoll.getRealWage() == null?0.0:payRoll.getRealWage());
		//salaryAnalysis.setLastRealWage();
		salaryAnalysis.setDeserveWage(payRoll.getDeserveWage()==null?0.0:payRoll.getDeserveWage());
		//salaryAnalysis.setLastDeserveWage();
		salaryAnalysis.setNumber(payRoll.getNumber()== null ?0:payRoll.getNumber());
		String lastNumber = "0";
		if(number > 0){
			lastNumber ="+" + String.valueOf(number);
		}else if(number < 0){
			lastNumber = String.valueOf(number);
		}
		salaryAnalysis.setLastNumber(lastNumber);
		logger.info("[薪酬分析]通过薪资表计算完成！");
		return salaryAnalysis;
	}

	/**
	 * 根据金额排序
	 *
	 */
	private void attendanceSort(List<SalaryKeyValue> list){
		Collections.sort(list,new Comparator<SalaryKeyValue>(){
			public int compare(SalaryKeyValue value1,SalaryKeyValue value2){
				int flag = value2.getValue().compareTo(value1.getValue());
				if(flag > 0){
					return flag;
				}else{
					return flag;
				}
			}
		});
	}
	
	@Override
	@ServiceLog(doAction = "分页查询薪资信息")
	public PaginationData<List<SalaryInfo>> paginationInquireSalaryInfo(SalaryInfoPage salaryInfoPage) {
		
		Page<Object> objects = PageHelper.startPage(salaryInfoPage.getPage(),salaryInfoPage.getRows());
		TbManpowerEmployeeBasicInfo employeeBasicInfo = new TbManpowerEmployeeBasicInfo();
		BeanUtils.copyProperties(salaryInfoPage,employeeBasicInfo);
		List<TbManpowerEmployeeBasicInfo> basicInfoList = employeeBasicInfoMapper.getList(employeeBasicInfo);
		Map<String,SalaryInfo> salaryMap = salaryInfoMapper.getMap(salaryInfoPage);
		//查询调动管理表tb_manpower_mobilization_management 获取职级
		TbManpowerMobilizationManagement tbManpowerMobilizationManagement = new TbManpowerMobilizationManagement();
		Map<String,TbManpowerMobilizationManagement> mobilizationMap = mobilizationManagementMapper.list(tbManpowerMobilizationManagement);
		List<SalaryInfo> salaryInfoList = new ArrayList<SalaryInfo>();
		for(TbManpowerEmployeeBasicInfo basicInfo:basicInfoList){
			//SalaryInfo info = new SalaryInfo();
			SalaryInfo info = salaryMap.get(basicInfo.getJobNumber());
			if(info == null){
				info = new SalaryInfo();
				info.setName(basicInfo.getName());
				info.setDepartmentName(basicInfo.getDepartmentName());
				info.setJobName(basicInfo.getJobName());
				info.setJobNumber(basicInfo.getJobNumber());
				info.setRankName("实习生");
				info.setPhone(basicInfo.getPhone());
				info.setCertificateType(basicInfo.getCertificateType());
				info.setCertificateNumber(basicInfo.getCertificateNumber());
				info.setEntryDate(basicInfo.getEntryDate());
				info.setProbationWage(0.0);
				info.setConversionWage(0.0);
				info.setCurrentWage(0.0);
			}else{
				info.setName(basicInfo.getName());
				info.setDepartmentName(basicInfo.getDepartmentName());
				info.setJobName(basicInfo.getJobName());
				TbManpowerMobilizationManagement mobilization = mobilizationMap.get(basicInfo.getJobNumber());
				if(mobilization == null){
					mobilization = new TbManpowerMobilizationManagement();
					mobilization.setRankName("实习生");
				}
				info.setJobNumber(basicInfo.getJobNumber());
				info.setRankName(mobilization.getRankName());
				info.setPhone(basicInfo.getPhone());
				info.setCertificateType(basicInfo.getCertificateType());
				info.setCertificateNumber(basicInfo.getCertificateNumber());
				info.setEntryDate(basicInfo.getEntryDate());
				Double currentWage = checkString(info.getCurrentBasicWage()) + checkString(info.getCurrentDutyAllowance()) + 
						checkString(info.getCurrentProfessionalTitleAllowance()) + checkString(info.getCurrentSeniorityWage()) +
						checkString(info.getCurrentEducationAllowance()) + checkString(info.getCurrentWorkSubsidy()) + 
						checkString(info.getCurrentAchievementBonus()) + checkString(info.getCurrentSingleReward());
				Double conversionWage = checkIsEmpty(info.getConversionBasicWage()) + checkIsEmpty(info.getConversionDutyAllowance()) + 
						checkIsEmpty(info.getConversionProfessionalTitleAllowance()) + checkIsEmpty(info.getConversionSeniorityWage()) + 
						checkIsEmpty(info.getConversionEducationAllowance()) + checkIsEmpty(info.getConversionWorkSubsidy()) + 
						checkIsEmpty(info.getConversionAchievementBonus()) + checkIsEmpty(info.getConversionSingleReward());
				Double probationWage = checkIsEmpty(info.getProbationBasicWage()) + checkIsEmpty(info.getProbationDutyAllowance()) + 
						checkIsEmpty(info.getProbationProfessionalTitleAllowance()) + checkIsEmpty(info.getProbationSeniorityWage()) + 
						checkIsEmpty(info.getProbationEducationAllowance()) + checkIsEmpty(info.getProbationWorkSubsidy()) + 
						checkIsEmpty(info.getProbationAchievementBonus()) + checkIsEmpty(info.getProbationSingleReward());
				info.setProbationWage(probationWage);
				info.setConversionWage(conversionWage);
				info.setCurrentWage(currentWage);
			}
			
			salaryInfoList.add(info);
		}
		
		logger.info("[薪资管理]信息查询成功!");
		PaginationData<List<SalaryInfo>> date = new PaginationData(salaryInfoList,objects.getTotal());
		return date;
	}

	//检查字符串是否为空并进行类型转换
	private Double checkString(String str){
		if(str == null || str.trim().equals("")){
			return 0.0;
		}
		
		return Double.parseDouble(str);
	}
	//非空判断
	private Double checkIsEmpty(Double dl){
		
		if(dl == null){
			return 0.0;
		}
		return dl;
	}



	@Override
	@ServiceLog(doAction = "查询工资条信息")
	public PaginationData<List<SalaryPayrollVo>> paginationInquirePayroll(SalaryPayrollPage salaryPayrollPage) {
		// TODO Auto-generated method stub
		Page<Object> objects = PageHelper.startPage(salaryPayrollPage.getPage(),salaryPayrollPage.getRows());
		List<SalaryPayrollVo> payrollList = salaryPayrollMapper.list(salaryPayrollPage);
		PaginationData<List<SalaryPayrollVo>> pageList = new PaginationData(payrollList,objects.getTotal());
		return pageList;
	}



	@Override
	@ServiceLog(doAction = "更新工资条信息")
	@Transactional(rollbackFor = Exception.class)
	public String updatePayroll(SalaryPayrollPage salaryPayrollPage) {
		// TODO Auto-generated method stub
		TbManpowerSalaryPayroll tbManpowerSalaryPayroll = new TbManpowerSalaryPayroll();
		BeanUtils.copyProperties(salaryPayrollPage,tbManpowerSalaryPayroll);
		tbManpowerSalaryPayrollMapper.updateByPrimaryKeySelective(tbManpowerSalaryPayroll);
		logger.info("[工资条]数据更新成功！");
		return "更新成功";
	}



	@Override
	@ServiceLog(doAction = "导出工资条信息")
	public PaginationData<List<SalaryPayrollVo>> exportPayroll(SalaryPayrollPage salaryPayrollPage) {
		Page<Object> objects = PageHelper.startPage(salaryPayrollPage.getPage(),salaryPayrollPage.getRows());
		List<SalaryPayrollVo> payrollList = salaryPayrollMapper.list(salaryPayrollPage);
		for(SalaryPayrollVo salaryPayroll : payrollList){
			salaryPayroll.setEntryTime(salaryPayroll.getAccountEntryTime());
		}
		PaginationData<List<SalaryPayrollVo>> pageList = new PaginationData(payrollList,objects.getTotal());
		return pageList;
	}
	
	@Override
	@ServiceLog(doAction = "导入工资条信息")
	@Transactional(rollbackFor = Exception.class)
	public String importPayroll(MultipartFile file, User user) {
		if(file.isEmpty()){
			logger.warn("[工资条]文件为空，导入失败");
			throw new JnSpringCloudException(SalaryManagementExceptionEnums.FILE_EMPTY);
		}
		
		SalaryPayrollAdd salaryPayrollAdd = new SalaryPayrollAdd();
		List<Object> resultList=ExcelUtil.readExcel(file, salaryPayrollAdd, 1, 1);
		if(CollectionUtils.isEmpty(resultList)){
            return "没有数据，导入失败";
        }
		TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = new TbManpowerEmployeeBasicInfo();
		Map<String,TbManpowerEmployeeBasicInfo> map = employeeBasicInfoMapper.map(tbManpowerEmployeeBasicInfo);
		
		int i = 0;
		StringBuffer sb=new StringBuffer();
		List<SalaryPayrollAdd> salaryPayrollAddList = new ArrayList<SalaryPayrollAdd>();
		for(Object result : resultList){
			i++;
			SalaryPayrollAdd payrall = (SalaryPayrollAdd)result;
			String str = checkPayrall(payrall);
			if(!StringUtils.isBlank(str)){
				sb.append("第"+i+"行:"+str+";");
                continue;
			}
			
			TbManpowerEmployeeBasicInfo basic = map.get(payrall.getJobNumber());
			if(basic == null){
				logger.info("[员工花名册]没有该员工，工号：" + payrall.getJobNumber());
				sb.append("第"+i+"行" + "|员工信息不存在,工号:" + payrall.getJobNumber() + ";");
				continue;
			}
			
			SalaryPayrollVo payrallVo = salaryPayrollMapper.selectByJobNumberAndMonth(payrall);
			if(payrallVo != null){
				logger.info("[工资表]该用户当月的工资条已存在,工号：" + payrall.getJobNumber() + ",月份：" + payrallVo.getAccountEntryTime());
				sb.append("第"+i+"行" + "|该员工当月工资信息已存在，工号：" + payrall.getJobNumber() + ",月份：" + payrallVo.getAccountEntryTime() + ";");
				continue;	
			}
			
			payrall.setDepartment(basic.getDepartmentName());
			payrall.setId(UUID.randomUUID().toString());
			salaryPayrollAddList.add(payrall);
			i++;
		}
		
        if(sb.length()>0){
            logger.warn("[工资条] 导入失败:{}",sb.toString());
            return sb.toString();
        }else{
        	if(!CollectionUtils.isEmpty(salaryPayrollAddList)){
                logger.info("[工资条] 成功导入{}条数据",salaryPayrollAddList.size());
                salaryPayrollMapper.insertBatch(salaryPayrollAddList);
            }
            return "导入成功";
        }
	}

	//工资条判空
    private String checkPayrall(SalaryPayrollAdd payrall){
    	if(StringUtils.isBlank(payrall.getJobNumber())){
			return "工号不能为空";
		}
    	
    	if(StringUtils.isBlank(payrall.getName())){
			return "姓名不能为空";
		}
    	
    	if(payrall.getAccountEntryTime() == null){
			return "入账日期不能为空";
		}
    	
    	if(payrall.getSeniorityWage() == null){
    		return "基础工资不能为空";
    	}
    	
    	return "";
    }

    //获取薪资组成
	private List<SalaryKeyValue> setSalaryComposition(SalaryPayrollVo payRoll){
		List<SalaryKeyValue> valueList = new ArrayList<SalaryKeyValue>();
		SalaryKeyValue value = new SalaryKeyValue();
		value.setName("基本工资");
		value.setValue(checkDouble(payRoll.getBasicWage()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("园区工龄工资");
		value.setValue(checkDouble(payRoll.getSeniorityWage()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("技术岗位津贴");
		value.setValue(checkDouble(payRoll.getTechnicalAllowance()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("职务津贴");
		value.setValue(checkDouble(payRoll.getDutyAllowance()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("工作性补贴");
		value.setValue(checkDouble(payRoll.getWorkSubsidy()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("学历津贴");
		value.setValue(checkDouble(payRoll.getEducationAllowance()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("职称津贴");
		value.setValue(checkDouble(payRoll.getProfessionalTitleAllowance()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("专项补贴");
		value.setValue(checkDouble(payRoll.getSpecialSubsidy()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("餐补");
		value.setValue(checkDouble(payRoll.getMealSubsidy()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("代扣社会统筹保险");
		value.setValue(checkDouble(payRoll.getPendingSocialpoolingInsurance()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("代扣公积金");
		value.setValue(checkDouble(payRoll.getPendingProvidentfund()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("扣个税");
		value.setValue(checkDouble(payRoll.getPendingPersonalTax()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("食堂餐费");
		value.setValue(checkDouble(payRoll.getCanteenMealFee()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("工会会费");
		value.setValue(checkDouble(payRoll.getUnionFee()));
		valueList.add(value);
		value = new SalaryKeyValue();	
		
		return valueList;
	}
	
	private String checkDouble(Double dl){
		if(dl == null){
		    dl = 0.0;
		}
		String str = String.valueOf(dl);
		return str;
	}
}
