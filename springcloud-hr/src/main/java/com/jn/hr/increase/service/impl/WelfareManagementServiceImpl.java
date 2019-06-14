package com.jn.hr.increase.service.impl;

import java.text.NumberFormat;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.common.util.HrDataUtil;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfo;
import com.jn.hr.increase.dao.IncreaseDetailedMapper;
import com.jn.hr.increase.dao.IncreaseStaffMapper;
import com.jn.hr.increase.dao.InsuredDetailMapper;
import com.jn.hr.increase.dao.InsuredSchemeDetailedMapper;
import com.jn.hr.increase.dao.InsuredSchemeMapper;
import com.jn.hr.increase.dao.TbManpowerIncreaseStaffMapper;
import com.jn.hr.increase.dao.TbManpowerInsuredDetailMapper;
import com.jn.hr.increase.dao.TbManpowerInsuredSchemeDetailedMapper;
import com.jn.hr.increase.dao.TbManpowerInsuredSchemeMapper;
import com.jn.hr.increase.entity.TbManpowerIncreaseStaff;
import com.jn.hr.increase.entity.TbManpowerInsuredDetail;
import com.jn.hr.increase.entity.TbManpowerInsuredScheme;
import com.jn.hr.increase.entity.TbManpowerInsuredSchemeDetailed;
import com.jn.hr.increase.enums.SalaryManagementExceptionEnums;
import com.jn.hr.increase.enums.SalaryWelfareManagementStatus;
import com.jn.hr.increase.model.IncreaseDetailed;
import com.jn.hr.increase.model.IncreaseStaff;
import com.jn.hr.increase.model.IncreaseStaffAdd;
import com.jn.hr.increase.model.IncreaseStaffPage;
import com.jn.hr.increase.model.InsureManagement;
import com.jn.hr.increase.model.InsureManagementPage;
import com.jn.hr.increase.model.InsuredDetaild;
import com.jn.hr.increase.model.InsuredDetaildPage;
import com.jn.hr.increase.model.InsuredScheme;
import com.jn.hr.increase.model.InsuredSchemeAdd;
import com.jn.hr.increase.model.InsuredSchemeDetailed;
import com.jn.hr.increase.model.InsuredSchemePage;
import com.jn.hr.increase.model.SalaryKeyValue;
import com.jn.hr.increase.service.WelfareManagrmentService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;

@Service
public class WelfareManagementServiceImpl implements WelfareManagrmentService {
	private static final Logger logger = LoggerFactory.getLogger(WelfareManagementServiceImpl.class);
	// 增员计划表
	@Autowired
	TbManpowerIncreaseStaffMapper tbManpowerIncreaseStaffMapper;
	// 参保明细表
	@Autowired
	InsuredDetailMapper insuredDetailMapper;
	// 参保明细表
	@Autowired
	TbManpowerInsuredDetailMapper tbManpowerInsuredDetailMapper;
	// 参保方案表
	@Autowired
	TbManpowerInsuredSchemeMapper tbManpowerInsuredSchemeMapper;
	// 参保方案表
	@Autowired
	InsuredSchemeMapper insuredSchemeMapper;
	// 参保方案明细查询
	@Autowired
	InsuredSchemeDetailedMapper insuredSchemeDetailedMapper;
	// 增减员计划-参保明细表
	@Autowired
	IncreaseDetailedMapper increaseDetailedMapper;
	// 增员计划表
	@Autowired
	IncreaseStaffMapper increaseStaffMapper;
	@Autowired
	EmployeeBasicInfoMapper employeeBasicInfoMapper;
	@Autowired
	SystemClient systemClient;
	// 参保方案明细表
	@Autowired
	TbManpowerInsuredSchemeDetailedMapper tbManpowerInsuredSchemeDetailedMapper;

	@Override
	@ServiceLog(doAction = "分页查询参保管理信息")
	public PaginationData<List<InsureManagement>> inquireInsuredManagement(InsureManagementPage insureManagementPage) {

		Page<Object> objects = PageHelper.startPage(insureManagementPage.getPage(), insureManagementPage.getRows());
		List<InsureManagement> insureManagementList = new ArrayList<InsureManagement>();
		IncreaseStaffPage increaseStaffPage = new IncreaseStaffPage();
		List<IncreaseStaff> increaseList = increaseStaffMapper.selectByMonth(increaseStaffPage);
		for (IncreaseStaff staff : increaseList) {
			InsureManagement insureManagement = new InsureManagement();
			IncreaseStaff increaseStaff = new IncreaseStaff();
			InsuredDetaild insuredDetail = new InsuredDetaild();
			increaseStaff.setInsuredMonth(staff.getInsuredMonth());
			// 获取增员人数
			int increaseNumber = increaseStaffMapper.increaseSelectByMonth(increaseStaff);
			// 获取减员人数
			int reduceNumber = increaseStaffMapper.reduceSelectByMonth(increaseStaff);
			insuredDetail.setInsuredMonth(staff.getInsuredMonth());
			InsuredDetaild insured = new InsuredDetaild();
			insured = insuredDetailMapper.selectSumByMonth(insuredDetail);
			insureManagement.setInsuredMonth(staff.getInsuredMonth());
			insureManagement.setInsuredNumber(insured.getNumber());
			insureManagement.setIncreaseInsuranceNumber(increaseNumber);
			insureManagement.setStopInsuranceNumber(reduceNumber);
			insureManagement.setSocialSecurity(insured.getSocialSecurity());
			insureManagement.setAccumulationFund(insured.getAccumulationFund());
			insureManagementList.add(insureManagement);
		}

		logger.info("[参保管理]数据查询成功!");
		PaginationData<List<InsureManagement>> data = new PaginationData(insureManagementList, objects.getTotal());

		return data;
	}

	@Override
	@ServiceLog(doAction = "添加次月账单")
	public void addNextMonthBill() {
		// TODO Auto-generated method stub

	}

	@Override
	@ServiceLog(doAction = "导入历史参保记录")
	@Transactional(rollbackFor = Exception.class)
	public String importHistoryInsuranceRecord(MultipartFile file, User user) {
		// TODO Auto-generated method stub
		if (file.isEmpty()) {
			logger.warn("[参保明细]文件为空，导入失败");
			throw new JnSpringCloudException(SalaryManagementExceptionEnums.FILE_EMPTY);
		}

		InsuredDetaild insuredDetaild = new InsuredDetaild();
		List<Object> resultList = ExcelUtil.readExcel(file, insuredDetaild, 1, 1);
		if (CollectionUtils.isEmpty(resultList)) {
			return "没有数据，导入失败";
		}

		TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = new TbManpowerEmployeeBasicInfo();
		Map<String, TbManpowerEmployeeBasicInfo> map = employeeBasicInfoMapper.map(tbManpowerEmployeeBasicInfo);
		int i = 0;
		StringBuffer sb = new StringBuffer();
		List<InsuredDetaild> list = new ArrayList<InsuredDetaild>();
		for (Object result : resultList) {
			i++;
			InsuredDetaild insured = (InsuredDetaild) result;
			String str = checkField(insured);
			if (!StringUtils.isBlank(str)) {
				sb.append("第" + i + "行:" + str + ";");
				continue;
			}

			TbManpowerEmployeeBasicInfo basic = map.get(insured.getJobNumber());
			if (basic == null) {
				logger.info("[员工花名册]没有该员工，工号：" + insured.getJobNumber());
				sb.append("第" + i + "行" + "|员工信息不存在,工号:" + insured.getJobNumber() + ";");
				continue;
			}

			if (!basic.getDepartmentName().equals(insured.getDepartment())) {
				logger.info("[员工花名册]员工部门不一致，工号：" + insured.getJobNumber());
				sb.append("第" + i + "行" + "|员工部门错误,工号:" + insured.getJobNumber() + ";");
				continue;
			}
			// insured.setInsuredMonth(DateUtils.formatDate(insured.getYearMonth(),"yyyy-MM"));
			InsuredDetaild detaild = insuredDetailMapper.selectByJobNumberAndMonth(insured);
			if (detaild != null) {
				logger.info("[参保明细表]用户该月参保信息已存在");
				sb.append("第" + i + "行" + "|员工该月的参保信息已存在,工号:" + insured.getJobNumber() + ";");
				continue;
			}

			conversionString(insured);
			insured.setDepartmentId(basic.getDepartmentId());
			insured.setName(basic.getName());
			insured.setId(UUID.randomUUID().toString());
			insured.setDepartmentId(basic.getDepartmentId());
			insured.setDepartment(basic.getDepartmentName());
			insured.setCreatDate(DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
			insured.setIsEffective(Byte.parseByte(SalaryWelfareManagementStatus.EFFECTIVE.getCode()));
			list.add(insured);
		}

		if (sb.length() > 0) {
			logger.warn("[参保明细] 导入失败:{}", sb.toString());
			return sb.toString();
		} else {
			if (!CollectionUtils.isEmpty(list)) {
				logger.info("[参保明细] 成功导入{}条数据", list.size());
				insuredDetailMapper.insertBatch(list);
			}
			return "导入成功";
		}
	}

	/*
	 * 字符串转换
	 */
	private void conversionString(InsuredDetaild insured) {
		String str = insured.getCityName();
		str = str.replace("(", ",");
		String[] str1 = str.split(",");
		insured.setCityName(str1[0]);
		insured.setCityId(str1[1].replace(")", ""));
	}

	@Override
	@ServiceLog(doAction = "添加增员计划")
	@Transactional(rollbackFor = Exception.class)
	public String addAttritionPlan(IncreaseStaffAdd increaseStaffAdd, User user) {
		// TODO Auto-generated method stub
		String[] str = increaseStaffAdd.getJobNumber().split(",");
		List<IncreaseStaff> increaseList = new ArrayList<IncreaseStaff>();
		List<InsuredDetaild> insuredetaildList = new ArrayList<InsuredDetaild>();
		List<IncreaseDetailed> increaseDetailedList = new ArrayList<IncreaseDetailed>();
		List<InsuredSchemeDetailed> schemeDetailedList = increaseStaffAdd.getInsuredSchemeDetailedList();
		if(schemeDetailedList == null || schemeDetailedList.size() == 0){
			logger.info("[参保方案明细表]添加的参保方案有误!");
			throw new JnSpringCloudException(SalaryManagementExceptionEnums.SCHEME_DETAILD_NOT_EXIST);
		}
		for (String jobNumber : str) {
			TbManpowerEmployeeBasicInfo basicInfo = employeeBasicInfoMapper.selectByJobNumber(jobNumber);
			TbManpowerInsuredScheme tbManpowerInsuredScheme = tbManpowerInsuredSchemeMapper
					.selectByPrimaryKey(increaseStaffAdd.getInsuredProgrammeId());
			/*添加参保管理-增员计划表*/
			IncreaseStaff increaseStaff = increaseStaffMapper.selectByJobNumberAndMonth(jobNumber,DateUtils.formatDate(increaseStaffAdd.getInsuredMonth(), "yyyy-MM"));
			if(increaseStaff != null){
				logger.info("[增员计划表]参保记录已存在!工号:" + jobNumber);
				throw new JnSpringCloudException(SalaryManagementExceptionEnums.INSURED_RECORD_EXISTS);
			}
			increaseStaff = new IncreaseStaff();
			BeanUtils.copyProperties(increaseStaffAdd, increaseStaff);
			increaseStaff.setId(UUID.randomUUID().toString());
			increaseStaff.setInsuredMonth(DateUtils.formatDate(increaseStaffAdd.getInsuredMonth(), "yyyy-MM"));
			increaseStaff.setIsEffective(Byte.parseByte(SalaryWelfareManagementStatus.EFFECTIVE.getCode()));
			increaseStaff.setRecordStatus(Byte.parseByte(SalaryWelfareManagementStatus.NORMAL.getCode()));
			increaseStaff.setCreatedTime(new Date());
			increaseStaff.setCreatorAccount(user.getAccount());
			increaseStaff.setModifiedTime(new Date());
			increaseStaff.setModifierAccount(user.getAccount());
			increaseStaff.setName(basicInfo.getName());
			increaseStaff.setJobNumber(jobNumber);
			increaseStaff.setPlanType("增员");
			increaseStaff.setDepartment(basicInfo.getDepartmentName());
			increaseStaff.setInsuredCityId(tbManpowerInsuredScheme.getInsuredCityId());
			increaseStaff.setInsuredCityName(tbManpowerInsuredScheme.getInsuredCityName());
			increaseStaff.setInsuredProgrammeId(increaseStaffAdd.getInsuredProgrammeId());
			increaseStaff.setInsuredProgrammeName(tbManpowerInsuredScheme.getSchemeName());
			increaseList.add(increaseStaff);

			Double personalSocialSecurity = 0.0;
			Double companySocialSecurity = 0.0;
			Double personalAccumulationFund = 0.0;
			Double companyAccumulationFund = 0.0;
			/*添加增减员计划-员工参保明细表*/
			//List<InsuredSchemeDetailed> schemeDetailedList = insuredSchemeDetailedMapper.selectBySchemeId(tbManpowerInsuredScheme.getSchemeId()); 
			for(InsuredSchemeDetailed detailed: schemeDetailedList){ 
				  IncreaseDetailed IncreaseDetailed = new IncreaseDetailed();
			      IncreaseDetailed.setId(UUID.randomUUID().toString());
			      IncreaseDetailed.setInsuredMonth(DateUtils.formatDate(increaseStaffAdd.getInsuredMonth(), "yyyy-MM"));
			      IncreaseDetailed.setJobNumber(jobNumber);
			      IncreaseDetailed.setProjectId(detailed.getProjectId());
			      IncreaseDetailed.setDefaultCardinalNumber(detailed.getDefaultCardinalNumber());
			      IncreaseDetailed.setCorporateContributionRatio(detailed.getCorporateContributionRatio());
			      IncreaseDetailed.setIndividualContributionRatio(detailed.getIndividualContributionRatio());
			      IncreaseDetailed.setProjectType(detailed.getProjectType());
			      if (detailed.getProjectType() == 1) {
						personalSocialSecurity += Double.valueOf(
								IncreaseDetailed.getDefaultCardinalNumber() * IncreaseDetailed.getIndividualContributionRatio())
								/ 100;
						companySocialSecurity += Double.valueOf(
								IncreaseDetailed.getDefaultCardinalNumber() * IncreaseDetailed.getCorporateContributionRatio())
								/ 100;
					} else {
						personalAccumulationFund += Double.valueOf(
								IncreaseDetailed.getDefaultCardinalNumber() * IncreaseDetailed.getIndividualContributionRatio())
								/ 100;
						companyAccumulationFund += Double.valueOf(
								IncreaseDetailed.getDefaultCardinalNumber() * IncreaseDetailed.getCorporateContributionRatio())
								/ 100;
					}
			      increaseDetailedList.add(IncreaseDetailed);
			  }
			  
			/*添加薪资福利-参保明细表*/
			InsuredDetaild insuredDetaild = new InsuredDetaild();
			insuredDetaild.setId(UUID.randomUUID().toString());
			insuredDetaild.setCreatDate(DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
			insuredDetaild.setInsuredMonth(DateUtils.formatDate(increaseStaffAdd.getInsuredMonth(), "yyyy-MM"));
			insuredDetaild.setJobNumber(jobNumber);
			insuredDetaild.setName(basicInfo.getName());
			insuredDetaild.setDepartmentId(basicInfo.getDepartmentId());
			insuredDetaild.setDepartment(basicInfo.getDepartmentName());
			insuredDetaild.setCityId(tbManpowerInsuredScheme.getInsuredCityId());
			insuredDetaild.setCityName(tbManpowerInsuredScheme.getInsuredCityName());
			insuredDetaild.setPersonalSocialSecurity(personalSocialSecurity);
			insuredDetaild.setCompanySocialSecurity(companySocialSecurity);
			insuredDetaild.setPersonalAccumulationFund(personalAccumulationFund);
			insuredDetaild.setCompanyAccumulationFund(companyAccumulationFund);
			insuredDetaild.setSchemeId(increaseStaffAdd.getInsuredProgrammeId());
			insuredDetaild.setIsEffective(Byte.parseByte(SalaryWelfareManagementStatus.EFFECTIVE.getCode()));
			insuredetaildList.add(insuredDetaild);  
		}
		increaseDetailedMapper.insertBatch(increaseDetailedList);
		increaseStaffMapper.insertBatch(increaseList);
		insuredDetailMapper.insertBatch(insuredetaildList);
		logger.info("[参保管理]添加增员计划表成功!");
		return "增员计划添加成功";
	}

	/*
	 * 添加增员计划明细
	 */
	private void addIncreaseDetaile(TbManpowerInsuredScheme tbManpowerInsuredScheme) {
		List<InsuredSchemeDetailed> schemeDetailedList = insuredSchemeDetailedMapper
				.selectBySchemeId(tbManpowerInsuredScheme.getSchemeId());
	}

	@Override
	@ServiceLog(doAction = "取消增员计划")
	@Transactional(rollbackFor = Exception.class)
	public String deleteAttritionPlan(IncreaseStaffPage increaseStaffPage) {
		TbManpowerIncreaseStaff tbManpowerIncreaseStaff = new TbManpowerIncreaseStaff();
		tbManpowerIncreaseStaff.setId(increaseStaffPage.getId());
		tbManpowerIncreaseStaff.setRecordStatus(Byte.parseByte(SalaryWelfareManagementStatus.DELETE.getCode()));
		tbManpowerIncreaseStaffMapper.updateByPrimaryKeySelective(tbManpowerIncreaseStaff);
		logger.info("[增员计划表]成员参保方案失效成功！");

		TbManpowerInsuredDetail tbManpowerInsuredDetail = new TbManpowerInsuredDetail();
		tbManpowerInsuredDetail.setId(increaseStaffPage.getDetailId());
		tbManpowerInsuredDetail.setIsEffective(Byte.parseByte(SalaryWelfareManagementStatus.INVALID.getCode()));
		tbManpowerInsuredDetailMapper.updateByPrimaryKeySelective(tbManpowerInsuredDetail);
		logger.info("[参保明细表]参保明细失效成功");
		return "取消增员计划成功";
	}

	@Override
	@ServiceLog(doAction = "修改各项目基数")
	@Transactional(rollbackFor = Exception.class)
	public String updateInsuredCardinalNumber(InsuredSchemeAdd insuredSchemeAdd, User user) {
		TbManpowerInsuredScheme tbManpowerInsuredScheme = new TbManpowerInsuredScheme();
		tbManpowerInsuredScheme.setSchemeId(insuredSchemeAdd.getSchemeId());
		tbManpowerInsuredScheme.setInsuredCityName(insuredSchemeAdd.getInsuredCityName());
		tbManpowerInsuredScheme.setInsuredCityId(insuredSchemeAdd.getInsuredCityId());
		tbManpowerInsuredScheme.setSchemeName(insuredSchemeAdd.getSchemeName());
		tbManpowerInsuredScheme.setModifiedTime(new Date());
		tbManpowerInsuredScheme.setModifierAccount(user.getAccount());
		tbManpowerInsuredSchemeMapper.updateByPrimaryKeySelective(tbManpowerInsuredScheme);

		List<InsuredSchemeDetailed> detailedList = insuredSchemeAdd.getInsuredSchemeDetailedList();
		for (InsuredSchemeDetailed scheme : detailedList) {
			TbManpowerInsuredSchemeDetailed tbManpowerInsuredSchemeDetailed = new TbManpowerInsuredSchemeDetailed();
			tbManpowerInsuredSchemeDetailed.setModifiedTime(new Date());
			tbManpowerInsuredSchemeDetailed.setModifierAccount(user.getAccount());
			BeanUtils.copyProperties(scheme, tbManpowerInsuredSchemeDetailed);
			tbManpowerInsuredSchemeDetailedMapper.updateByPrimaryKeySelective(tbManpowerInsuredSchemeDetailed);
		}

		logger.info("[参保方案]参保方案修改成功");
		return "基数修改成功";
	}

	@Override
	@ServiceLog(doAction = "分页查询增减员计划信息")
	public PaginationData<List<IncreaseStaff>> inquireAttritionPlan(IncreaseStaffPage increaseStaffPage) {

		Page<Object> objects = PageHelper.startPage(increaseStaffPage.getPage(), increaseStaffPage.getRows());
		List<IncreaseStaff> increaseStaffPageList = increaseStaffMapper.list(increaseStaffPage);
		for (IncreaseStaff staff : increaseStaffPageList) {
			staff.setCompanyPayment(staff.getCompanyAccumulationFund() + staff.getCompanySocialSecurity());
			staff.setPersonalPayment(staff.getPersonalAccumulationFund() + staff.getPersonalSocialSecurity());
		}
		PaginationData<List<IncreaseStaff>> data = new PaginationData(increaseStaffPageList, objects.getTotal());
		return data;
	}

	@Override
	@ServiceLog(doAction = "导出参保记录")
	public PaginationData<List<InsuredDetaild>> exportInsuranceRecord(InsuredDetaildPage insuredDetaildPage) {
		// TODO Auto-generated method stub
		Page<Object> objects = PageHelper.startPage(insuredDetaildPage.getPage(), insuredDetaildPage.getRows());
		List<InsuredDetaild> insuredDetaildList = insuredDetailMapper.list(insuredDetaildPage);
		PaginationData<List<InsuredDetaild>> date = new PaginationData(insuredDetaildList, objects.getTotal());
		return date;
	}

	@Override
	@ServiceLog(doAction = "参保明细页面")
	public PaginationData<List<InsuredDetaild>> paginationInquireInsuranceRecord(
			InsuredDetaildPage insuredDetaildPage) {

		Page<Object> objects = PageHelper.startPage(insuredDetaildPage.getPage(), insuredDetaildPage.getRows());
		List<InsuredDetaild> insuredDetaildList = insuredDetailMapper.list(insuredDetaildPage);
		PaginationData<List<InsuredDetaild>> date = new PaginationData(insuredDetaildList, objects.getTotal());
		return date;
	}

	@Override
	@ServiceLog(doAction = "参保明细附属页面")
	public InsureManagement insuredDetailedSubsidiary(InsuredDetaildPage insuredDetaildPage) {
		IncreaseStaff increaseStaff = new IncreaseStaff();
		InsureManagement insureManagement = new InsureManagement();
		// 获取增员人数
		increaseStaff.setInsuredMonth(insuredDetaildPage.getInsuredMonth());
		int increaseNumber = increaseStaffMapper.increaseSelectByMonth(increaseStaff);
		// 获取减员人数
		int reduceNumber = increaseStaffMapper.reduceSelectByMonth(increaseStaff);
		InsuredDetaild insuredDetaild = new InsuredDetaild();
		insuredDetaild.setInsuredMonth(insuredDetaildPage.getInsuredMonth());
		InsuredDetaild detaild = insuredDetailMapper.selectSumByMonth(insuredDetaild);
		insureManagement.setIncreaseInsuranceNumber(increaseNumber);
		insureManagement.setStopInsuranceNumber(reduceNumber);
		insureManagement.setInsuredNumber(detaild.getNumber());
		insureManagement.setPersonalAccumulationFund(detaild.getPersonalAccumulationFund());
		insureManagement.setCompanyAccumulationFund(detaild.getCompanyAccumulationFund());
		insureManagement.setPersonalSocialSecurity(detaild.getPersonalSocialSecurity());
		insureManagement.setCompanySocialSecurity(detaild.getCompanySocialSecurity());
		return insureManagement;
	}

	@Override
	@ServiceLog(doAction = "参保概况")
	public InsuredDetaild insuredOverview(InsuredDetaildPage insuredDetaildPage) {
		// 当月参保概况
		InsuredDetaild insuredDetaild = insuredDetailMapper.selectByCountNumber(insuredDetaildPage.getInsuredMonth());
		if (insuredDetaild == null) {
			insuredDetaild = new InsuredDetaild();
			insuredDetaild.setSocialSecurity(0.0);
			insuredDetaild.setAccumulationFund(0.0);
		}
		insuredDetaild.setNumber(insuredDetaild.getNumber() == null ? 0 : insuredDetaild.getNumber());
		List<SalaryKeyValue> departmentNumber = insuredDetailMapper
				.selectByDepartmentNumber(insuredDetaildPage.getInsuredMonth());
		Map<String, SalaryKeyValue> departmentNumberMap = new HashMap<String, SalaryKeyValue>();
		if (departmentNumber == null) {
			departmentNumber = new ArrayList<SalaryKeyValue>();
		}

		for (SalaryKeyValue value : departmentNumber) {
			departmentNumberMap.put(value.getName(), value);
		}

		List<InsuredDetaild> list = insuredDetailMapper.selectByMonthAndType(insuredDetaildPage.getInsuredMonth());
		insuredDetaild.setTotalCost(insuredDetaild.getSocialSecurity() + insuredDetaild.getAccumulationFund());
		// 数值格式化对象
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		if (insuredDetaildPage.getType().equals("1")) {
			Map<String, SalaryKeyValue> companyMap = new HashMap<String, SalaryKeyValue>();
			Map<String, SalaryKeyValue> personalMap = new HashMap<String, SalaryKeyValue>();
			List<SalaryKeyValue> totalCost = new ArrayList<SalaryKeyValue>();
			for (InsuredDetaild detaild : list) {
				SalaryKeyValue value = new SalaryKeyValue();
				value.setName(detaild.getDepartment());
				value.setValue(numberFormat.format(detaild.getSocialSecurity() / 100));
				totalCost.add(value);
				value = new SalaryKeyValue();
				value.setName(detaild.getDepartment());
				value.setValue(numberFormat.format(detaild.getCompanySocialSecurity() / 100));
				companyMap.put(detaild.getDepartment(), value);
				value = new SalaryKeyValue();
				value.setName(detaild.getDepartment());
				value.setValue(numberFormat.format(detaild.getPersonalSocialSecurity() / 100));
				personalMap.put(detaild.getDepartment(), value);
			}
			obtainInsuredDetaild(insuredDetaild, totalCost, companyMap, personalMap, departmentNumberMap);

		} else if (insuredDetaildPage.getType().equals("2")) {
			Map<String, SalaryKeyValue> companyMap = new HashMap<String, SalaryKeyValue>();
			Map<String, SalaryKeyValue> personalMap = new HashMap<String, SalaryKeyValue>();
			List<SalaryKeyValue> totalCost = new ArrayList<SalaryKeyValue>();
			for (InsuredDetaild detaild : list) {
				SalaryKeyValue value = new SalaryKeyValue();
				value.setName(detaild.getDepartment());
				value.setValue(numberFormat.format(detaild.getAccumulationFund() / 100));
				totalCost.add(value);
				value = new SalaryKeyValue();
				value.setName(detaild.getDepartment());
				value.setValue(numberFormat.format(detaild.getCompanyAccumulationFund() / 100));
				companyMap.put(detaild.getDepartment(), value);
				value = new SalaryKeyValue();
				value.setName(detaild.getDepartment());
				value.setValue(numberFormat.format(detaild.getPersonalAccumulationFund() / 100));
				personalMap.put(detaild.getDepartment(), value);
			}
			obtainInsuredDetaild(insuredDetaild, totalCost, companyMap, personalMap, departmentNumberMap);
		} else {
			Map<String, SalaryKeyValue> companyMap = new HashMap<String, SalaryKeyValue>();
			Map<String, SalaryKeyValue> personalMap = new HashMap<String, SalaryKeyValue>();
			List<SalaryKeyValue> totalCost = insuredDetailMapper
					.selectByDepartmentTotalCost(insuredDetaildPage.getInsuredMonth());
			if (totalCost == null) {
				totalCost = new ArrayList<SalaryKeyValue>();
			}
			for (SalaryKeyValue value : totalCost) {
				Double wage = Double.valueOf(value.getValue());
				value.setValue(numberFormat.format(wage / 100));
			}
			List<SalaryKeyValue> companyCost = insuredDetailMapper
					.selectByDepartmentCompanyCost(insuredDetaildPage.getInsuredMonth());
			if (companyCost == null) {
				companyCost = new ArrayList<SalaryKeyValue>();
			}
			for (SalaryKeyValue value : companyCost) {
				Double wage = Double.valueOf(value.getValue());
				value.setValue(numberFormat.format(wage / 100));
				companyMap.put(value.getName(), value);
			}
			List<SalaryKeyValue> personalCost = insuredDetailMapper
					.selectByDepartmentPersonalCost(insuredDetaildPage.getInsuredMonth());
			if (personalCost == null) {
				personalCost = new ArrayList<SalaryKeyValue>();
			}
			for (SalaryKeyValue value : personalCost) {
				Double wage = Double.valueOf(value.getValue());
				value.setValue(numberFormat.format(wage / 100));
				personalMap.put(value.getName(), value);
			}
			logger.info("total:" + totalCost.size() + "|company:" + companyCost.size() + "|personal:"
					+ personalCost.size());
			obtainInsuredDetaild(insuredDetaild, totalCost, companyMap, personalMap, departmentNumberMap);
		}

		// 与上个月的数据对比
		dataComparison(insuredDetaild, insuredDetaildPage.getInsuredMonth());

		return insuredDetaild;
	}

	/*
	 * 获取各部门参保费用
	 */
	private void obtainInsuredDetaild(InsuredDetaild insuredDetaild, List<SalaryKeyValue> totalCost,
			Map<String, SalaryKeyValue> companyMap, Map<String, SalaryKeyValue> personalMap,
			Map<String, SalaryKeyValue> departmentNumberMap) {
		List<SalaryKeyValue> departmentNumberNine = new ArrayList<SalaryKeyValue>();
		List<SalaryKeyValue> totalCostNine = new ArrayList<SalaryKeyValue>();
		List<SalaryKeyValue> companyCostNine = new ArrayList<SalaryKeyValue>();
		List<SalaryKeyValue> personalCostNine = new ArrayList<SalaryKeyValue>();
		attendanceSort(totalCost);
		if (totalCost.size() > 9) {
			for (int i = 0; i < 9; i++) {
				totalCostNine.add(totalCost.get(i));
				companyCostNine.add(companyMap.get(totalCost.get(i).getName()));
				personalCostNine.add(personalMap.get(totalCost.get(i).getName()));
				departmentNumberNine.add(departmentNumberMap.get(totalCost.get(i).getName()));
			}
		} else {
			totalCostNine.addAll(totalCost);
			for (SalaryKeyValue value : totalCost) {
				companyCostNine.add(companyMap.get(value.getName()));
				personalCostNine.add(personalMap.get(value.getName()));
				departmentNumberNine.add(departmentNumberMap.get(value.getName()));
			}
		}
		insuredDetaild.setDepartmentNumber(departmentNumberNine);
		insuredDetaild.setDepartmentTotalCost(totalCostNine);
		insuredDetaild.setDepartmentCompanyCost(companyCostNine);
		insuredDetaild.setDepartmentPersonalCost(personalCostNine);
	}

	// 参保概况--当月与上个月的数据对比
	private InsuredDetaild dataComparison(InsuredDetaild insuredDetaild, String insuredMonth) {
		// 上个月的参保概况
		Date date = HrDataUtil.getLastdayMonth(insuredMonth);
		InsuredDetaild lastDetaild = insuredDetailMapper.selectByCountNumber(DateUtils.formatDate(date, "yyyy-MM"));
		if (lastDetaild != null) {
			lastDetaild.setTotalCost(lastDetaild.getSocialSecurity() + lastDetaild.getAccumulationFund());
			Integer number = 0;
			if (insuredDetaild.getNumber() > lastDetaild.getNumber()) {
				number = insuredDetaild.getNumber() - lastDetaild.getNumber();
				insuredDetaild.setLastNumber("+" + number);
			} else {
				number = insuredDetaild.getNumber() - lastDetaild.getNumber();
				insuredDetaild.setLastNumber(String.valueOf(number));
			}

			if (insuredDetaild.getSocialSecurity() > lastDetaild.getSocialSecurity()) {
				Double security = insuredDetaild.getSocialSecurity() - lastDetaild.getSocialSecurity();
				insuredDetaild.setLastSocialSecurity("+" + String.format("%.2f", security));
			} else {
				Double security = insuredDetaild.getSocialSecurity() - lastDetaild.getSocialSecurity();
				insuredDetaild.setLastSocialSecurity(String.format("%.2f", security));
			}

			if (insuredDetaild.getAccumulationFund() > lastDetaild.getAccumulationFund()) {
				Double fund = insuredDetaild.getAccumulationFund() - lastDetaild.getAccumulationFund();
				insuredDetaild.setLastAccumulationFund("+" + String.format("%.2f", fund));
			} else {
				Double fund = insuredDetaild.getAccumulationFund() - lastDetaild.getAccumulationFund();
				insuredDetaild.setLastAccumulationFund(String.format("%.2f", fund));
			}

			if (insuredDetaild.getTotalCost() > lastDetaild.getTotalCost()) {
				Double cost = insuredDetaild.getTotalCost() - lastDetaild.getTotalCost();
				insuredDetaild.setLastTotalCost("+" + String.format("%.2f", cost));
			} else {
				Double cost = insuredDetaild.getTotalCost() - lastDetaild.getTotalCost();
				insuredDetaild.setLastTotalCost(String.format("%.2f", cost));
			}
		} else {
			insuredDetaild.setLastAccumulationFund("0");
			insuredDetaild.setLastNumber("0");
			insuredDetaild.setLastTotalCost("0");
			insuredDetaild.setLastSocialSecurity("0");
		}

		return insuredDetaild;
	}

	/**
	 * 根据金额排序
	 *
	 */
	private void attendanceSort(List<SalaryKeyValue> list) {
		Collections.sort(list, new Comparator<SalaryKeyValue>() {
			public int compare(SalaryKeyValue value1, SalaryKeyValue value2) {
				int flag = value2.getValue().compareTo(value1.getValue());
				if (flag > 0) {
					return flag;
				} else {
					return flag;
				}
			}
		});
	}

	@Override
	@ServiceLog(doAction = "停止参保")
	@Transactional(rollbackFor = Exception.class)
	public String stopInsurance(@Validated @RequestBody IncreaseStaffAdd increaseStaffAdd, User user) {
		// TODO Auto-generated method stub
		List<IncreaseStaff> increaseList = new ArrayList<IncreaseStaff>();
		TbManpowerEmployeeBasicInfo basicInfo = employeeBasicInfoMapper
				.selectByJobNumber(increaseStaffAdd.getJobNumber());
		TbManpowerInsuredScheme tbManpowerInsuredScheme = tbManpowerInsuredSchemeMapper
				.selectByPrimaryKey(increaseStaffAdd.getInsuredProgrammeId());
		IncreaseStaff increaseStaff = increaseStaffMapper.selectByJobNumberAndMonth(increaseStaffAdd.getJobNumber(),DateUtils.formatDate(increaseStaffAdd.getInsuredMonth(), "yyyy-MM"));
		if(increaseStaff != null){
			logger.info("[增员计划表]参保记录已存在!工号:" + increaseStaffAdd.getJobNumber());
			throw new JnSpringCloudException(SalaryManagementExceptionEnums.INSURED_RECORD_EXISTS);
		}
		increaseStaff = new IncreaseStaff();
		BeanUtils.copyProperties(increaseStaffAdd, increaseStaff);
		increaseStaff.setId(UUID.randomUUID().toString());
		increaseStaff.setInsuredMonth(DateUtils.formatDate(increaseStaffAdd.getInsuredMonth(), "yyyy-MM"));
		increaseStaff.setIsEffective(Byte.parseByte(SalaryWelfareManagementStatus.INVALID.getCode()));
		increaseStaff.setRecordStatus(Byte.parseByte(SalaryWelfareManagementStatus.NORMAL.getCode()));
		increaseStaff.setCreatedTime(new Date());
		increaseStaff.setCreatorAccount(user.getAccount());
		increaseStaff.setModifiedTime(new Date());
		increaseStaff.setModifierAccount(user.getAccount());
		increaseStaff.setName(basicInfo.getName());
		increaseStaff.setPlanType("减员");
		increaseStaff.setDepartment(basicInfo.getDepartmentName());
		// increaseStaff.setJobNumber(increaseStaffAdd.getJobNumber());
		increaseStaff.setInsuredCityId(tbManpowerInsuredScheme.getInsuredCityId());
		increaseStaff.setInsuredCityName(tbManpowerInsuredScheme.getInsuredCityName());
		increaseStaff.setInsuredProgrammeName(tbManpowerInsuredScheme.getSchemeName());
		increaseStaff.setInsuredProgrammeId(increaseStaffAdd.getInsuredProgrammeId());
		increaseList.add(increaseStaff);
		increaseStaffMapper.insertBatch(increaseList);
		return "减员成功";
	}

	@Override
	@ServiceLog(doAction = "分页查询参保方案")
	public PaginationData<List<InsuredScheme>> paginationInquireInsurance(InsuredSchemePage insuredSchemePage) {
		Page<Object> objests = PageHelper.startPage(insuredSchemePage.getPage(), insuredSchemePage.getRows());

		InsuredDetaildPage insuredDetaildPage = new InsuredDetaildPage();
		Map<String, InsuredDetaild> insureMap = insuredDetailMapper.selectBySchemeId(insuredDetaildPage);
		List<InsuredScheme> insureSchemeList = insuredSchemeMapper.list(insuredSchemePage);
		for (InsuredScheme scheme : insureSchemeList) {
			InsuredDetaild insuredDetaild = new InsuredDetaild();
			insuredDetaild = insureMap.get(scheme.getSchemeId());
			if (insuredDetaild == null) {
				scheme.setNumber(0);
				scheme.setPersonalSocialSecurity(0.0);
				scheme.setPersonalAccumulationFund(0.0);
				scheme.setCompanySocialSecurity(0.0);
				scheme.setCompanyAccumulationFund(0.0);
			} else {
				scheme.setNumber(insuredDetaild.getNumber());
				scheme.setPersonalSocialSecurity(insuredDetaild.getPersonalSocialSecurity() == null ? 0.0
						: insuredDetaild.getPersonalSocialSecurity());
				scheme.setPersonalAccumulationFund(insuredDetaild.getPersonalAccumulationFund() == null ? 0.0
						: insuredDetaild.getPersonalAccumulationFund());
				scheme.setCompanySocialSecurity(insuredDetaild.getCompanySocialSecurity() == null ? 0.0
						: insuredDetaild.getCompanySocialSecurity());
				scheme.setCompanyAccumulationFund(insuredDetaild.getCompanyAccumulationFund() == null ? 0.0
						: insuredDetaild.getCompanyAccumulationFund());
			}
		}

		PaginationData<List<InsuredScheme>> data = new PaginationData(insureSchemeList, objests.getTotal());
		return data;
	}

	@Override
	@ServiceLog(doAction = "修改参保方案")
	@Transactional(rollbackFor = Exception.class)
	public String updateInsurancescheme(InsuredSchemeAdd insuredSchemeAdd, User user) {
		// TODO Auto-generated method stub
		TbManpowerInsuredScheme tbManpowerInsuredScheme = new TbManpowerInsuredScheme();
		tbManpowerInsuredScheme.setSchemeId(insuredSchemeAdd.getSchemeId());
		tbManpowerInsuredScheme.setInsuredCityName(insuredSchemeAdd.getInsuredCityName());
		tbManpowerInsuredScheme.setInsuredCityId(insuredSchemeAdd.getInsuredCityId());
		tbManpowerInsuredScheme.setSchemeName(insuredSchemeAdd.getSchemeName());
		tbManpowerInsuredScheme.setModifiedTime(new Date());
		tbManpowerInsuredScheme.setModifierAccount(user.getAccount());
		tbManpowerInsuredSchemeMapper.updateByPrimaryKeySelective(tbManpowerInsuredScheme);

		insuredSchemeDetailedMapper.deleteBySchemeId(insuredSchemeAdd.getSchemeId());

		List<InsuredSchemeDetailed> detailedList = insuredSchemeAdd.getInsuredSchemeDetailedList();
		if (detailedList.size() > 0) {
			// 插入方案明细表
			for (InsuredSchemeDetailed insuredSchemeDetailed : detailedList) {
				insuredSchemeDetailed.setSchemeId(insuredSchemeAdd.getSchemeId());
				insuredSchemeDetailed.setRecordStatus(Byte.parseByte(SalaryWelfareManagementStatus.NORMAL.getCode()));
				insuredSchemeDetailed.setProjectId(UUID.randomUUID().toString());
				insuredSchemeDetailed.setSocialSecurityId(insuredSchemeAdd.getSocialSecurityId());
				insuredSchemeDetailed.setProvidentFundId(insuredSchemeAdd.getAccumulationFundId());
				insuredSchemeDetailed.setCreatedTime(new Date());
				insuredSchemeDetailed.setCreatorAccount(user.getAccount());
				insuredSchemeDetailed.setModifiedTime(new Date());
				insuredSchemeDetailed.setModifierAccount(user.getAccount());
			}
			insuredSchemeDetailedMapper.insertBatch(detailedList);
		}

		logger.info("[参保方案]参保方案修改成功");
		return "修改成功";
	}

	@Override
	@ServiceLog(doAction = "删除参保方案")
	@Transactional(rollbackFor = Exception.class)
	public String deleteInsurancescheme(InsuredSchemePage insuredSchemePage) {

		// 根据方案Id修改tb_manpower_insured_scheme（参保管理-参保方案表）状态为失效
		// 根据项目id修改tb_manpower_insured_scheme_detailed（参保方案-明细表） 状态为标记删除
		int number = insuredDetailMapper.selectBySchemeIdNumber(insuredSchemePage.getSchemeId());
		if (number != 0) {
			logger.info("方案正在使用，禁止删除");
			throw new JnSpringCloudException(SalaryManagementExceptionEnums.SCHEME_USING);
		}
		TbManpowerInsuredScheme tbManpowerInsuredScheme = new TbManpowerInsuredScheme();
		tbManpowerInsuredScheme.setSchemeId(insuredSchemePage.getSchemeId());
		tbManpowerInsuredScheme.setRecordStatus(Byte.parseByte(SalaryWelfareManagementStatus.DELETE.getCode()));
		tbManpowerInsuredSchemeMapper.updateByPrimaryKeySelective(tbManpowerInsuredScheme);
		logger.info("[参保方案表]数据删除成功");
		return "删除成功";
	}

	@Override
	@ServiceLog(doAction = "参保方案页面明细")
	public InsuredScheme insuranceSchemeDetailed(InsuredSchemePage insuredSchemePage) {
		// TODO Auto-generated method stub
		TbManpowerInsuredScheme tbManpowerInsuredScheme = tbManpowerInsuredSchemeMapper
				.selectByPrimaryKey(insuredSchemePage.getSchemeId());
		InsuredScheme insuredScheme = new InsuredScheme();
		BeanUtils.copyProperties(tbManpowerInsuredScheme, insuredScheme);
		List<InsuredSchemeDetailed> detailedList = insuredSchemeDetailedMapper
				.selectBySchemeId(insuredSchemePage.getSchemeId());
		insuredScheme.setInsuredSchemeDetailedList(detailedList);
		return insuredScheme;
	}

	@Override
	@ServiceLog(doAction = "添加参保方案")
	@Transactional(rollbackFor = Exception.class)
	public String addInsurancescheme(InsuredSchemeAdd insuredSchemeAdd, User user) {
		// TODO Auto-generated method stub
		TbManpowerInsuredScheme InsuredScheme = new TbManpowerInsuredScheme();
		BeanUtils.copyProperties(insuredSchemeAdd, InsuredScheme);
		InsuredScheme.setSchemeId(UUID.randomUUID().toString());
		InsuredScheme.setSchemeName(insuredSchemeAdd.getSchemeName());
		InsuredScheme.setInsuredCityId(insuredSchemeAdd.getInsuredCityId());
		InsuredScheme.setSocialSecurityId(UUID.randomUUID().toString());
		InsuredScheme.setAccumulationFundId(UUID.randomUUID().toString());
		InsuredScheme.setRecordStatus(Byte.parseByte(SalaryWelfareManagementStatus.EFFECTIVE.getCode()));
		InsuredScheme.setCreatedTime(new Date());
		InsuredScheme.setCreatorAccount(user.getAccount());
		InsuredScheme.setModifiedTime(new Date());
		InsuredScheme.setModifierAccount(user.getAccount());
		tbManpowerInsuredSchemeMapper.insert(InsuredScheme);

		List<InsuredSchemeDetailed> detailedList = insuredSchemeAdd.getInsuredSchemeDetailedList();
		if (detailedList.size() > 0) {
			// 插入方案明细表
			for (InsuredSchemeDetailed insuredSchemeDetailed : detailedList) {
				insuredSchemeDetailed.setSchemeId(InsuredScheme.getSchemeId());
				insuredSchemeDetailed.setRecordStatus(Byte.parseByte(SalaryWelfareManagementStatus.NORMAL.getCode()));
				insuredSchemeDetailed.setProjectId(UUID.randomUUID().toString());
				insuredSchemeDetailed.setSocialSecurityId(InsuredScheme.getSocialSecurityId());
				insuredSchemeDetailed.setProvidentFundId(InsuredScheme.getAccumulationFundId());
				insuredSchemeDetailed.setCreatedTime(new Date());
				insuredSchemeDetailed.setCreatorAccount(user.getAccount());
				insuredSchemeDetailed.setModifiedTime(new Date());
				insuredSchemeDetailed.setModifierAccount(user.getAccount());
			}
			insuredSchemeDetailedMapper.insertBatch(detailedList);
		}

		logger.info("[参保方案]参保方案数据添加成功，scheme{}", insuredSchemeAdd.getSchemeId());
		return "添加成功";
	}

	// 参保明细对象检测
	private String checkField(InsuredDetaild insured) {
		if (StringUtils.isBlank(insured.getJobNumber())) {
			return "工号不能为空";
		}

		if (StringUtils.isBlank(insured.getCityName())) {
			return "参保城市不能为空";
		}

		if (StringUtils.isBlank(insured.getSchemeId())) {
			return "方案Id不能为空";
		}

		if (insured.getPersonalAccumulationFund() == null) {
			return "个人公积金不能为空";
		}

		if (insured.getPersonalSocialSecurity() == null) {
			return "个人社保费不能为空";
		}

		if (insured.getCompanyAccumulationFund() == null) {
			return "公司公积金不能为空";
		}

		if (insured.getCompanySocialSecurity() == null) {
			return "公司社保费不能为空";
		}
		return "";
	}
}
