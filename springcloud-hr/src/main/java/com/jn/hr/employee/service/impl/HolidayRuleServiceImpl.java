package com.jn.hr.employee.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.jn.common.model.Result;
import com.jn.system.api.SystemClient;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.hr.attendance.dao.TbManpowerVacationManageMapper;
import com.jn.hr.attendance.dao.VacationManageAttanceMapper;
import com.jn.hr.attendance.entity.TbManpowerVacationManage;
import com.jn.hr.attendance.model.VacationManagePage;
import com.jn.hr.attendance.model.VacationManageVo;
import com.jn.hr.common.enums.HrExceptionEnums;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.dao.HolidayRuleMapper;
import com.jn.hr.employee.dao.TbManpowerHolidayRuleMapper;
import com.jn.hr.employee.entity.TbManpowerHolidayRule;
import com.jn.hr.employee.enums.EmployeeExceptionEnums;
import com.jn.hr.employee.model.HolidayRule;
import com.jn.hr.employee.model.HolidayRuleAdd;
import com.jn.hr.employee.service.HolidayRuleService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;

/**
 * @author dt
 * @create 2019-04-23 下午 2:56
 */
@Service
public class HolidayRuleServiceImpl implements HolidayRuleService {
    private static final Logger logger = LoggerFactory.getLogger(HolidayRuleServiceImpl.class);
    @Autowired
    private TbManpowerHolidayRuleMapper tbManpowerHolidayRuleMapper;
    @Autowired
    private HolidayRuleMapper holidayRuleMapper;
    @Autowired
    VacationManageAttanceMapper vacationManageAttanceMapper;
    @Autowired
    EmployeeBasicInfoMapper employeeBasicInfoMapper;
    @Autowired
    TbManpowerVacationManageMapper tbManpowerVacationManageMapper;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Value("${spring.application.name}")
    private String applicationName;
    @Autowired
    private SystemClient systemClient;

    @Override
    @ServiceLog(doAction = "添加假期规则")
    @Transactional(rollbackFor = Exception.class)
    public String addHolidayRule(HolidayRuleAdd holidayRuleAdd, User user) {
        if(holidayRuleAdd.getReachedYear()==null){
            holidayRuleAdd.setReachedYear(0);
        }
        if(holidayRuleAdd.getNotFullYear()==null){
            holidayRuleAdd.setNotFullYear(999);
        }
        if(!checkRule(holidayRuleAdd)){
            throw new JnSpringCloudException(EmployeeExceptionEnums.HOLIDAY_RULE_ERROR);
        }
        TbManpowerHolidayRule tbHolidayRule=new TbManpowerHolidayRule();
        BeanUtils.copyProperties(holidayRuleAdd,tbHolidayRule);
        tbHolidayRule.setRuleId(UUID.randomUUID().toString());
        tbHolidayRule.setSerialNumber(getSeqNo().intValue());
        tbManpowerHolidayRuleMapper.insert(tbHolidayRule);
        logger.info("[假期规则管理] 新增假期规则成功,id:{}", tbHolidayRule.getRuleId());
        return tbHolidayRule.getRuleId();
    }

    @Override
    @ServiceLog(doAction = "修改假期规则")
    @Transactional(rollbackFor = Exception.class)
    public void updateHolidayRule(HolidayRuleAdd holidayRuleAdd, User user) {
        if(holidayRuleAdd.getReachedYear()==null){
            holidayRuleAdd.setReachedYear(0);
        }
        if(holidayRuleAdd.getNotFullYear()==null){
            holidayRuleAdd.setReachedYear(999);
        }
        if(!checkRule(holidayRuleAdd)){
            throw new JnSpringCloudException(EmployeeExceptionEnums.HOLIDAY_RULE_ERROR);
        }
        TbManpowerHolidayRule tbRule=tbManpowerHolidayRuleMapper.selectByPrimaryKey
                (holidayRuleAdd.getRuleId());
        if(tbRule==null){
            logger.warn("[假期规则管理] 修改假期规则失败,修改信息不存在,ruleId:{}",
                    holidayRuleAdd.getRuleId());
            throw new JnSpringCloudException(HrExceptionEnums.UPDATEDATA_NOT_EXIST);
        }
        TbManpowerHolidayRule updateRule=new TbManpowerHolidayRule();
        BeanUtils.copyProperties(holidayRuleAdd,updateRule);
        tbManpowerHolidayRuleMapper.updateByPrimaryKeySelective(updateRule);
        logger.info("[假期规则管理] 修改员工档案成功,departmentId:{}", updateRule.getRuleId());
    }

    @Override
    @ServiceLog(doAction = "删除假期规则")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id, User user) {
        TbManpowerHolidayRule tbRule = tbManpowerHolidayRuleMapper.selectByPrimaryKey(id);
        if (tbRule != null) {
            tbManpowerHolidayRuleMapper.deleteByPrimaryKey(id);
        }
        logger.info("[假期规则管理] 删除假期规则成功,ruleId:{}", id);
    }

    @Override
    @ServiceLog(doAction = "查询假期规则")
    public List<HolidayRule> getHolidayRules() {
        List<HolidayRule> rules=holidayRuleMapper.list();
        return rules;
    }
    private Long getSeqNo() {
        RedisAtomicLong counter = new RedisAtomicLong(applicationName+":"+
                "employee:"+"holidayRule:ruleId",
                redisTemplate.getConnectionFactory());
        long count=counter.getAndAdd(1);
        return count;
    }
    private boolean checkRule(HolidayRuleAdd holidayRuleAdd){
        List<HolidayRule> holidayRules = holidayRuleMapper.list();
        if(CollectionUtils.isEmpty(holidayRules)){
            return true;
        }
        //校验规则是否符合，计算每个区间，判断规则是否落在某个区间
        //1、结束时间大于开始时间
        if(holidayRuleAdd.getNotFullYear()<holidayRuleAdd.getReachedYear()){
            return false;
        }

        for (HolidayRule holidayRule : holidayRules) {
            if(!StringUtils.isBlank(holidayRuleAdd.getRuleId())
                    && holidayRuleAdd.getRuleId().equals(holidayRule.getRuleId())){
                continue;
            }
            //2、开始时间大于 开始时间且小于结束时间 ；
            if(holidayRuleAdd.getReachedYear()>holidayRule.getReachedYear() &&
                    holidayRuleAdd.getReachedYear()<holidayRule.getNotFullYear()){
                return false;
            }
            //3、结束时间大于 开始时间且小于结束时间
            if(holidayRuleAdd.getNotFullYear()>holidayRule.getReachedYear() &&
                    holidayRuleAdd.getNotFullYear()<holidayRule.getNotFullYear()){
                return false;
            }
            //4、开始时间小于 开始时间且结束时间大于结束时间
            if(holidayRuleAdd.getReachedYear()<holidayRule.getReachedYear() &&
                    holidayRuleAdd.getNotFullYear()>holidayRule.getNotFullYear()){
                return false;
            }
            //5、开始时间大于 开始时间且结束时间小于结束时间
            if(holidayRuleAdd.getReachedYear()>holidayRule.getReachedYear() &&
                    holidayRuleAdd.getNotFullYear()<
                            holidayRule.getNotFullYear()){
                return false;
            }
        }
        return true;
    }

	@Override
	@ServiceLog(doAction = "查询假期")
	public PaginationData<List<VacationManageVo>> inquireVacationManage(VacationManagePage vacationManagePage) {
		// TODO Auto-generated method stub
		Page<Object> objects = PageHelper.startPage(vacationManagePage.getPage(),vacationManagePage.getRows());
		List<VacationManageVo> vacationList = new ArrayList<VacationManageVo>();
        if (!StringUtils.isEmpty(vacationManagePage.getDepartmentId())) {
            List<String> rootList = new ArrayList<String>();
            Result result = systemClient.selectDeptByParentId(vacationManagePage.getDepartmentId(), true);
            if (result == null || !"0000".equals(result.getCode()) || result.getData() == null) {
                throw new JnSpringCloudException(HrExceptionEnums.DEPARTMENT_QUERY_ERRPR);
            }
            HashMap<String, Object> childMap = (HashMap<String, Object>) result.getData();
            rootList.add((String) childMap.get("id"));
            if (childMap.get("children") != null) {
                List<HashMap<String, Object>> childrenSub = (List<HashMap<String, Object>>) childMap.get("children");
                getChildrenDepartment(rootList, childrenSub);
            }
            vacationManagePage.setDepartmentIds(rootList);
        }
		vacationList = vacationManageAttanceMapper.selectByJobNumber(vacationManagePage);
		PaginationData <List<VacationManageVo>> pageList = new PaginationData(vacationList,objects.getTotal());
		return pageList;
	}
    private void getChildrenDepartment(List<String> rootList, List<HashMap<String, Object>> children) {
        for (HashMap<String, Object> childMap : children) {
            rootList.add((String) childMap.get("id"));
            if (childMap.get("children") != null) {
                List<HashMap<String, Object>> childrenSub = (List<HashMap<String, Object>>) childMap.get("children");
                getChildrenDepartment(rootList, childrenSub);
            }
        }
    }

	@Override
	@ServiceLog(doAction = "修改假期")
	public void updateVacationManage(VacationManagePage vacationManagePage) {
		// TODO Auto-generated method stub
		TbManpowerVacationManage tbManpowerVacationManage = new TbManpowerVacationManage();
		tbManpowerVacationManage.setId(vacationManagePage.getId());
		tbManpowerVacationManage.setJobNumber(vacationManagePage.getJobNumber());
		tbManpowerVacationManage.setVacationType(vacationManagePage.getVacationType());
		tbManpowerVacationManage.setVacationTime(vacationManagePage.getVacationTime());
		tbManpowerVacationManageMapper.updateByPrimaryKeySelective(tbManpowerVacationManage);
	}
}
