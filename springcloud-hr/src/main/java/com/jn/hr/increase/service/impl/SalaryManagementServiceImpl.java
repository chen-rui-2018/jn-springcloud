package com.jn.hr.increase.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
	@ServiceLog(doAction = "??????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String importSalary(MultipartFile file, User user) {
		
		if(file.isEmpty()){
			logger.warn("[????????????]???????????????????????????");
			throw new JnSpringCloudException(SalaryManagementExceptionEnums.FILE_EMPTY);
		}
		
		SalaryInfo salaryInfo = new SalaryInfo();
		List<Object> resultList=ExcelUtil.readExcel(file, salaryInfo, 1, 2);
		if(CollectionUtils.isEmpty(resultList)){
            return "???????????????????????????";
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
				sb.append("???"+i+"???:"+str+";");
                continue;
			}
			TbManpowerEmployeeBasicInfo basic = basicMap.get(salary.getJobNumber());
			if(basic == null){
				logger.info("[???????????????]???????????????????????????" + salary.getJobNumber());
				sb.append("???"+i+"???" + "|?????????????????????,??????:" + salary.getJobNumber() + ";");
				continue;
			}
			
			SalaryInfo info = salaryMap.get(salary.getJobNumber());
			if(info != null){
				logger.info("[?????????]?????????????????????????????????" + salary.getJobNumber());
				sb.append("???"+i+"???" + "|?????????????????????,??????:" + salary.getJobNumber() + ";");
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
            logger.warn("[????????????] ????????????:{}",sb.toString());
            return sb.toString();
        }else{
        	if(!CollectionUtils.isEmpty(salaryInfoList)){
                logger.info("[????????????] ????????????{}?????????",salaryInfoList.size());
                salaryInfoMapper.insertBatch(salaryInfoList);
            }
            return "????????????";
        }
	}



	@Override
	@ServiceLog(doAction = "??????????????????")
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
		logger.info("[?????????]????????????????????????");
		return data;
	}

	@Override
	@ServiceLog(doAction = "???????????????????????????")
	public SalaryInfo inquireSalaryInfo(String jobNumber) {

		TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = employeeBasicInfoMapper.selectByJobNumber(jobNumber);
		TbManpowerMobilizationManagement mobilization = mobilizationManagementMapper.selectByJobNumber(jobNumber);
		SalaryInfo info = salaryInfoMapper.selectByJobNumber(jobNumber);
		if(info == null || tbManpowerEmployeeBasicInfo == null ){
			logger.warn("[????????????]??????????????????????????????id{}",jobNumber);
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
	@ServiceLog(doAction = "??????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String addSalary(SalaryInfoAdd salaryInfoAdd, User user) {
		
		SalaryInfo salaryInfo = salaryInfoMapper.selectByJobNumber(salaryInfoAdd.getJobNumber());
		if(salaryInfo != null){
			logger.info("[????????????]?????????????????????!");
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
		logger.info("[????????????]????????????????????????id{}",tbManpowerSalaryInfo.getId());
		return "????????????";
	}



	@Override
	@ServiceLog(doAction = "??????????????????")
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
			logger.info("[????????????]????????????????????????id{}",tbManpowerSalaryInfo.getId());
			return "????????????";
		}else{
			TbManpowerSalaryInfo SalaryInfo = tbManpowerSalaryInfoMapper.selectByPrimaryKey(salaryInfoAdd.getId());
			//TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = tbManpowerEmployeeBasicInfoMapper.selectByPrimaryKey(salaryInfoAdd.getId());
			if(SalaryInfo == null){
				logger.warn("[????????????]??????????????????????????????????????????id????????????id{}",salaryInfoAdd.getId());
				throw new JnSpringCloudException(SalaryManagementExceptionEnums.NOT_EXIST_ERROR);
			}

			//??????????????????
			TbManpowerSalaryInfo tbManpowerSalaryInfo = new TbManpowerSalaryInfo();
			BeanUtils.copyProperties(salaryInfoAdd,tbManpowerSalaryInfo);
			tbManpowerSalaryInfo.setId(salaryInfoAdd.getId());
			tbManpowerSalaryInfo.setModifiedTime(new Date());
			tbManpowerSalaryInfo.setModifierAccount(user.getAccount());
			tbManpowerSalaryInfoMapper.updateByPrimaryKeySelective(tbManpowerSalaryInfo);
			logger.info("[????????????]????????????????????????id{}",tbManpowerSalaryInfo.getId());
			return "????????????";
		}
	}
	
	//??????????????????
	private String checkField(SalaryInfo salary){
		if(StringUtils.isBlank(salary.getJobNumber())){
			return "?????????????????????????????????";
		}
		
		if(salary.getProbationBasicWage() == null){
			return "???????????????????????????????????????";
		}
		
		if(salary.getProbationDutyAllowance() == null){
			return "???????????????????????????????????????";
		}
		
		if(salary.getProbationProfessionalTitleAllowance() == null){
			return "???????????????????????????????????????";
		}
		
		if(salary.getProbationWorkSubsidy() == null){
			return "??????????????????????????????????????????";
		}
		
		if(salary.getProbationEducationAllowance() == null){
			return "???????????????????????????????????????";
		}
	    
//		if(salary.getProbationSeniorityWage() != null){
//			
//		}
		

		/*@ApiModelProperty(value = "????????????(?????????)")
		@ExcelProperty(value = "????????????(?????????)", index = 8)
	    private Double probationAchievementBonus;

		@ApiModelProperty(value = "????????????(?????????)")
		@ExcelProperty(value = "????????????(?????????)", index = 9)
	    private Double probationSingleReward;*/
		return "";
	}
	
	/**
	 * 
	 * ??????????????????????????????
	 */
	public boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}

	@Override
	@ServiceLog(doAction = "????????????")
	public SalaryAnalysis salaryAnalysis(SalaryPayrollPage salaryPayrollPage) {
		SalaryAnalysis salaryAnalysis = new SalaryAnalysis();
		//????????????-????????????
		SalaryPayrollVo payRoll = salaryPayrollMapper.selectByWage(salaryPayrollPage.getAccountEntryTime());
		
		if(payRoll != null){
			setSalaryComposition(payRoll,salaryAnalysis);
		}else{
			salaryAnalysis.setBasicWageProportion(new ArrayList<SalaryKeyValue>());
			salaryAnalysis.setDeductionProportion(new ArrayList<SalaryKeyValue>());
			salaryAnalysis.setSocialSecurityProportion(new ArrayList<SalaryKeyValue>());
			salaryAnalysis.setSubsidyProportion(new ArrayList<SalaryKeyValue>());
			payRoll = new SalaryPayrollVo();
		}
		
		//salaryAnalysis.setSalaryComposition(valueList);
		//????????????-??????????????????
		List<SalaryKeyValue> salaryList = new ArrayList<SalaryKeyValue>();
		List<SalaryKeyValue> salarySevenList = salaryPayrollMapper.selectByDepartmentWage(salaryPayrollPage.getAccountEntryTime());
		if(salarySevenList != null && salarySevenList.size() > 7){
			//??????
			attendanceSort(salarySevenList);
			for(int i = 0; i < 7; i++){
				salaryList.add(salarySevenList.get(i));
			}
		}else{
			salaryList.addAll(salarySevenList);
		}
		salaryAnalysis.setLaborCosts(salaryList);
		
		//????????????-????????????
		List<SalaryKeyValue> departmentNumber = salaryPayrollMapper.selectByPeople(salaryPayrollPage.getAccountEntryTime());
		salaryAnalysis.setDepartmentNumber(departmentNumber);
		//????????????-??????????????????
		List<SalaryKeyValue> perpleCapita = new ArrayList<SalaryKeyValue>();
		List<SalaryKeyValue> perpleCapitaNine = salaryPayrollMapper.selectByDepartmentCost(salaryPayrollPage.getAccountEntryTime());
		if(perpleCapitaNine != null){
			for(SalaryKeyValue keyValue : perpleCapitaNine){
				for(SalaryKeyValue key : departmentNumber){
					Integer i = Integer.valueOf(key.getValue());
					if(keyValue.getName().equals(key.getName())){
						String value = keyValue.getValue() == null ? "0.0":keyValue.getValue();
						Double wage = Double.valueOf(value);
						keyValue.setValue(String.format("%.2f",wage/(1000 * i)));
					}
				}
			}
			//??????
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
		//????????????????????????
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
		logger.info("[????????????]??????????????????????????????");
		return salaryAnalysis;
	}

	/**
	 * ??????????????????
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
	@ServiceLog(doAction = "????????????????????????")
	public PaginationData<List<SalaryInfo>> paginationInquireSalaryInfo(SalaryInfoPage salaryInfoPage) {
		
		Page<Object> objects = PageHelper.startPage(salaryInfoPage.getPage(),salaryInfoPage.getRows());
		TbManpowerEmployeeBasicInfo employeeBasicInfo = new TbManpowerEmployeeBasicInfo();
		BeanUtils.copyProperties(salaryInfoPage,employeeBasicInfo);
		List<TbManpowerEmployeeBasicInfo> basicInfoList = employeeBasicInfoMapper.getList(employeeBasicInfo);
		Map<String,SalaryInfo> salaryMap = salaryInfoMapper.getMap(salaryInfoPage);
		//?????????????????????tb_manpower_mobilization_management ????????????
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
				info.setRankName("?????????");
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
					mobilization.setRankName("?????????");
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
		
		logger.info("[????????????]??????????????????!");
		PaginationData<List<SalaryInfo>> date = new PaginationData(salaryInfoList,objects.getTotal());
		return date;
	}

	//????????????????????????????????????????????????
	private Double checkString(String str){
		if(str == null || str.trim().equals("")){
			return 0.0;
		}
		
		return Double.parseDouble(str);
	}
	//????????????
	private Double checkIsEmpty(Double dl){
		
		if(dl == null){
			return 0.0;
		}
		return dl;
	}



	@Override
	@ServiceLog(doAction = "?????????????????????")
	public PaginationData<List<SalaryPayrollVo>> paginationInquirePayroll(SalaryPayrollPage salaryPayrollPage) {
		// TODO Auto-generated method stub
		Page<Object> objects = PageHelper.startPage(salaryPayrollPage.getPage(),salaryPayrollPage.getRows());
		List<SalaryPayrollVo> payrollList = salaryPayrollMapper.list(salaryPayrollPage);
		PaginationData<List<SalaryPayrollVo>> pageList = new PaginationData(payrollList,objects.getTotal());
		return pageList;
	}



	@Override
	@ServiceLog(doAction = "?????????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String updatePayroll(SalaryPayrollPage salaryPayrollPage,User user) {
		// TODO Auto-generated method stub
		TbManpowerSalaryPayroll tbManpowerSalaryPayroll = new TbManpowerSalaryPayroll();
		BeanUtils.copyProperties(salaryPayrollPage,tbManpowerSalaryPayroll);
		tbManpowerSalaryPayroll.setModifiedTime(new Date());
		tbManpowerSalaryPayroll.setModifierAccount(user.getAccount());;
		tbManpowerSalaryPayrollMapper.updateByPrimaryKeySelective(tbManpowerSalaryPayroll);
		logger.info("[?????????]?????????????????????");
		return "????????????";
	}



	@Override
	@ServiceLog(doAction = "?????????????????????")
	public PaginationData<List<SalaryPayrollVo>> exportPayroll(SalaryPayrollPage salaryPayrollPage) {
		Page<Object> objects = PageHelper.startPage(salaryPayrollPage.getPage(),salaryPayrollPage.getRows());
		List<SalaryPayrollVo> payrollList = salaryPayrollMapper.list(salaryPayrollPage);
		PaginationData<List<SalaryPayrollVo>> pageList = new PaginationData(payrollList,objects.getTotal());
		return pageList;
	}
	
	@Override
	@ServiceLog(doAction = "?????????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String importPayroll(MultipartFile file, User user) {
		if(file.isEmpty()){
			logger.warn("[?????????]???????????????????????????");
			throw new JnSpringCloudException(SalaryManagementExceptionEnums.FILE_EMPTY);
		}
		
		SalaryPayrollAdd salaryPayrollAdd = new SalaryPayrollAdd();
		List<Object> resultList=ExcelUtil.readExcel(file, salaryPayrollAdd, 1, 4);
		if(CollectionUtils.isEmpty(resultList)){
            return "???????????????????????????";
        }
		TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = new TbManpowerEmployeeBasicInfo();
		Map<String,TbManpowerEmployeeBasicInfo> map = employeeBasicInfoMapper.selectByIdCard(tbManpowerEmployeeBasicInfo);
		
		int i = 0;
		//Double realWage = 0.0;
		StringBuffer sb=new StringBuffer();
		List<SalaryPayrollAdd> salaryPayrollAddList = new ArrayList<SalaryPayrollAdd>();
		for(Object result : resultList){
			i++;
			SalaryPayrollAdd payrall = (SalaryPayrollAdd)result;
			String str = checkPayrall(payrall);
			if(!StringUtils.isBlank(str)){
				sb.append("???"+i+"???:"+str+";");
                continue;
			}
			
			TbManpowerEmployeeBasicInfo basic = map.get(payrall.getIdCard());
			if(basic == null){
				logger.info("[???????????????]??????????????????????????????" + payrall.getIdCard());
				sb.append("???"+i+"???" + "|?????????????????????,??????:" + payrall.getIdCard() + ";");
				continue;
			}
			
			SalaryPayrollVo payrallVo = salaryPayrollMapper.selectByJobNumberAndMonth(payrall);
			if(payrallVo != null){
				logger.info("[?????????]????????????????????????????????????,????????????" + payrall.getIdCard() + ",?????????" + payrallVo.getAccountEntryTime());
				sb.append("???"+i+"???" + "|???????????????????????????????????????????????????" + payrall.getIdCard() + ",?????????" + payrallVo.getAccountEntryTime() + ";");
				continue;	
			}
			/*realWage = payrall.getBasicWage() + payrall.getSeniorityWage() + payrall.getProfessionalTitleAllowance() + payrall.getTechnicalAllowance() + payrall.getEducationAllowance() + 
					payrall.getWorkAllowance() + payrall.getDutyAllowance() + payrall.getSpecialSubsidy() + payrall.getJobAllowance() + payrall.getCompositeSubsidy() + payrall.getSeasonBonus() +
					payrall.getYearEndBonus() + payrall.getWorkExcitation() + payrall.getOvertimeCost() + payrall.getOnDutyCost() + payrall.getBusinessCarSubsidy() + payrall.getDelayCost() + 
					payrall.getRewardWage() + payrall.getOtherWage() - payrall.getPensionWage() - payrall.getProvidentFund() - payrall.getLeaveFee() - payrall.getSickLeaveFee() -
					payrall.getPenaltyFee() - payrall.getDeductionOne() - payrall.getDeductionTwo() - payrall.getPendingPersonalTax() - payrall.getUnionFee() - payrall.getUnemploymentWage() -
					payrall.getMedicalWage() - payrall.getMajorIllnessWage() - payrall.getMealFee() + payrall.getSiteOvertimeSubsidy() + payrall.getWalkDoorBouns() + payrall.getDemolitionSubsidy();*/
			payrall.setDepartment(basic.getDepartmentName());
			payrall.setId(UUID.randomUUID().toString());
			payrall.setCreatorAccount(user.getAccount());
			payrall.setCreatedTime(new Date());
			payrall.setModifiedTime(new Date());
			payrall.setModifierAccount(user.getAccount());
			salaryPayrollAddList.add(payrall);
			i++;
		}
		
        if(sb.length()>0){
            logger.warn("[?????????] ????????????:{}",sb.toString());
            return sb.toString();
        }else{
        	if(!CollectionUtils.isEmpty(salaryPayrollAddList)){
                logger.info("[?????????] ????????????{}?????????",salaryPayrollAddList.size());
                salaryPayrollMapper.insertBatch(salaryPayrollAddList);
            }
            return "????????????";
        }
	}

	//???????????????
    private String checkPayrall(SalaryPayrollAdd payrall){
    	
    	if(StringUtils.isBlank(payrall.getName())){
			return "??????????????????";
		}
    	
    	if(StringUtils.isBlank(payrall.getAccountEntryTime())){
			return "????????????????????????";
		}
    	
    	if(StringUtils.isBlank(payrall.getIssuingUnit())){
			return "????????????????????????";
		}
    	
    	if(StringUtils.isBlank(payrall.getIdCard())){
			return "?????????????????????";
		}
    	
    	return "";
    }

    //??????????????????
	private void setSalaryComposition(SalaryPayrollVo payRoll,SalaryAnalysis salaryAnalysis){
		//??????????????????
		List<SalaryKeyValue> valueList = new ArrayList<SalaryKeyValue>();
		SalaryKeyValue value = new SalaryKeyValue();
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getBasicWage()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("?????????????????????");
		value.setValue(checkDouble(payRoll.getSeniorityWage()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getProfessionalTitleAllowance()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("??????????????????");
		value.setValue(checkDouble(payRoll.getTechnicalAllowance()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getEducationAllowance()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("???????????????");
		value.setValue(checkDouble(payRoll.getWorkAllowance()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getDutyAllowance()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getSpecialSubsidy()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getJobAllowance()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getCompositeSubsidy()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("?????????");
		value.setValue(checkDouble(payRoll.getSeasonBonus()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("?????????");
		value.setValue(checkDouble(payRoll.getYearEndBonus()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getWorkExcitation()));
		valueList.add(value);
		salaryAnalysis.setBasicWageProportion(valueList);

		//??????????????????
		value = new SalaryKeyValue();
		valueList = new ArrayList<SalaryKeyValue>();
		value.setName("?????????");
		value.setValue(checkDouble(payRoll.getOvertimeCost()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("?????????");
		value.setValue(checkDouble(payRoll.getOnDutyCost()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("??????????????????");
		value.setValue(checkDouble(payRoll.getBusinessCarSubsidy()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("?????????");
		value.setValue(checkDouble(payRoll.getDelayCost()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("?????????");
		value.setValue(checkDouble(payRoll.getRewardWage()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getOtherWage()));
		valueList.add(value);
		salaryAnalysis.setSubsidyProportion(valueList);

		//???????????????????????????
		value = new SalaryKeyValue();
		valueList = new ArrayList<SalaryKeyValue>();
		value.setName("?????????");
		value.setValue(checkDouble(payRoll.getPensionWage()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("???????????????");
		value.setValue(checkDouble(payRoll.getUnemploymentWage()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("???????????????");
		value.setValue(checkDouble(payRoll.getMedicalWage()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getMajorIllnessWage()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("??????????????????");
		value.setValue(checkDouble(payRoll.getUnitSocietyWage()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("?????????");
		value.setValue(checkDouble(payRoll.getProvidentFund()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("???????????????");
		value.setValue(checkDouble(payRoll.getUnitProvidentFund()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getUnionFee()));
		valueList.add(value);
		salaryAnalysis.setSocialSecurityProportion(valueList);
		
		//????????????
		value = new SalaryKeyValue();
		valueList = new ArrayList<SalaryKeyValue>();
		value.setName("??????");
		value.setValue(checkDouble(payRoll.getMealFee()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getLeaveFee()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("????????????");
		value.setValue(checkDouble(payRoll.getSickLeaveFee()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("?????????");
		value.setValue(checkDouble(payRoll.getPenaltyFee()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("??????2-1");
		value.setValue(checkDouble(payRoll.getDeductionOne()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("??????2-2");
		value.setValue(checkDouble(payRoll.getDeductionTwo()));
		valueList.add(value);
		value = new SalaryKeyValue();
		
		value.setName("???????????????");
		value.setValue(checkDouble(payRoll.getPendingPersonalTax()));
		valueList.add(value);
		salaryAnalysis.setDeductionProportion(valueList);
		
	}
	
	private String checkDouble(Double dl){
		if(dl == null){
		    dl = 0.0;
		}
		String str = String.valueOf(dl);
		return str;
	}
}
