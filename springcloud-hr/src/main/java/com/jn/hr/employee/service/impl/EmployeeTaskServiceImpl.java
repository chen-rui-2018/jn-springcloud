package com.jn.hr.employee.service.impl;

import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.hr.attendance.dao.TbManpowerVacationManageMapper;
import com.jn.hr.attendance.entity.TbManpowerVacationManage;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.dao.HolidayRuleMapper;
import com.jn.hr.employee.dao.VacationManageMapper;
import com.jn.hr.employee.dao.WorkExperienceMapper;
import com.jn.hr.employee.enums.HolidayRuleEnum;
import com.jn.hr.employee.model.EmployeeBasicInfo;
import com.jn.hr.employee.model.HolidayRule;
import com.jn.hr.employee.model.VacationManage;
import com.jn.hr.employee.model.WorkExperience;
import com.jn.hr.employee.service.EmployeeTaskService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author dt
 * @create 2019-05-08 下午 3:45
 */
@Service
public class EmployeeTaskServiceImpl implements EmployeeTaskService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeBasicInfoServiceImpl.class);
    public static final long ONE_YEAR=31536000;
    @Autowired
    private EmployeeBasicInfoMapper employeeBasicInfoMapper;
    @Autowired
    private TbManpowerVacationManageMapper tbManpowerVacationManageMapper;
    @Autowired
    private HolidayRuleMapper holidayRuleMapper;
    @Autowired
    private WorkExperienceMapper workExperienceMapper;
    @Autowired
    private VacationManageMapper vacationManageMapper;


    @Override
    public Result<Map<String,String>> generateVacation() {
        Result<Map<String,String>> result=new Result<Map<String,String>>();
        String currDate= DateUtils.formatDate(new Date(),"MM-dd");
        List<EmployeeBasicInfo> employeeBasicInfos = employeeBasicInfoMapper.selectByEntryDate(currDate);
        if(CollectionUtils.isEmpty(employeeBasicInfos)){
            logger.info("当天{},花名册表中没有入职人员",currDate);
            return result;
        }

        List<HolidayRule> rules=holidayRuleMapper.list();
        List<VacationManage> vocationList=null;
        for (EmployeeBasicInfo employeeBasicInfo : employeeBasicInfos) {
            vacationManageMapper.deleteByJobNumber(employeeBasicInfo.getJobNumber());
            //新增9种类型假期数据到假期管理表
            //年假
             vocationList=new ArrayList<VacationManage>();
            String vacationTime=getAnnualDay(rules,employeeBasicInfo.getJobNumber());
            vocationList.add(addVacation(employeeBasicInfo.getJobNumber(),HolidayRuleEnum.ANNUAL_LEAVE.getVacationType(),
                    vacationTime));
            //补休
            vocationList.add(addVacation(employeeBasicInfo.getJobNumber(),HolidayRuleEnum.COMPENSATED_LEAVE.getVacationType(),
                    HolidayRuleEnum.COMPENSATED_LEAVE.getVacationTime()));
            //事假
            vocationList.add(addVacation(employeeBasicInfo.getJobNumber(),HolidayRuleEnum.CASUAL_LEAVE.getVacationType(),
                    HolidayRuleEnum.CASUAL_LEAVE.getVacationTime()));
            //病假
            vocationList.add(addVacation(employeeBasicInfo.getJobNumber(),HolidayRuleEnum.SICK_LEAVE.getVacationType(),
                    HolidayRuleEnum.SICK_LEAVE.getVacationTime()));
            //婚假
            vocationList.add(addVacation(employeeBasicInfo.getJobNumber(),HolidayRuleEnum.MARRIAGE_LEAVE.getVacationType(),
                    HolidayRuleEnum.MARRIAGE_LEAVE.getVacationTime()));
            if("1".equals(employeeBasicInfo.getSex())){
                //男 陪产假
                vocationList.add(addVacation(employeeBasicInfo.getJobNumber(),HolidayRuleEnum.PATERNITY_LEAVE.getVacationType(),
                        HolidayRuleEnum.PATERNITY_LEAVE.getVacationTime()));
            }
            if("2".equals(employeeBasicInfo.getSex())){
                //女 产假
                vocationList.add(addVacation(employeeBasicInfo.getJobNumber(),HolidayRuleEnum.MATERNITY_LEAVE.getVacationType(),
                        HolidayRuleEnum.MATERNITY_LEAVE.getVacationTime()));
            }

            //工伤假
            vocationList.add(addVacation(employeeBasicInfo.getJobNumber(),HolidayRuleEnum.WORKRELATED_INJURY_LEAVE.getVacationType(),
                    HolidayRuleEnum.WORKRELATED_INJURY_LEAVE.getVacationTime()));
            //丧假
            vocationList.add(addVacation(employeeBasicInfo.getJobNumber(),HolidayRuleEnum.BEREAVEMENT_LEAVE.getVacationType(),
                    HolidayRuleEnum.BEREAVEMENT_LEAVE.getVacationTime()));

            try{
                vacationManageMapper.insertBatch(vocationList);
            }catch(DuplicateKeyException e){

            }


        }
        return result;
    }

    private VacationManage addVacation(String jobNumber,String vacationType,String vacationTime){
        VacationManage vacationManage=new VacationManage();
        vacationManage.setId(UUID.randomUUID().toString());
        vacationManage.setJobNumber(jobNumber);
        vacationManage.setVacationTime(vacationTime);
        vacationManage.setVacationType(vacationType);
        return vacationManage;
    }
    private String getAnnualDay(List<HolidayRule> rules,String jobNumber){

        long diff=0;
        List<WorkExperience> workExperiences = workExperienceMapper.selectByJobNumber(jobNumber);
        if(!CollectionUtils.isEmpty(workExperiences)){
            //计算工龄 用系统时间-最早参加工作时间
            diff=(System.currentTimeMillis()-workExperiences.get(0).getEntryDate().getTime())/1000;
        }

        if(diff<=0){
            return "0";
        }
        Long age=diff/ONE_YEAR;
        Integer ageInt=age.intValue();
        //设置年休假为0天
        if(CollectionUtils.isEmpty(rules)){
            return "0";
        }
        //计算工龄落在哪个区间
        for (HolidayRule rule : rules) {
            if(ageInt>=rule.getReachedYear() && ageInt<rule.getNotFullYear()){
                return rule.getAnnualLeave()+"";
            }
        }
        //未查到,按国家规定 满1年不瞒10年5天，满10年不满20年10天，满20年15天
        if(ageInt<1){
            return "0";
        }
        if(ageInt>=1 && ageInt<10){
            return "5";
        }
        if(ageInt>=10 && ageInt<20){
            return "10";
        }
        return "15";
    }
}
