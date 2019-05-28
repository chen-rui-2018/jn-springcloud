package com.jn.hr.employee.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.archives.model.TreeModel;
import com.jn.hr.common.enums.HrConstants;
import com.jn.hr.common.enums.HrExceptionEnums;
import com.jn.hr.common.enums.HrStatusEnums;
import com.jn.hr.common.service.CommonService;
import com.jn.hr.common.util.*;
import com.jn.hr.employee.dao.*;
import com.jn.hr.employee.entity.*;
import com.jn.hr.employee.enums.*;
import com.jn.hr.employee.model.*;
import com.jn.hr.employee.service.EmployeeBasicInfoService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.model.SysPost;
import com.jn.system.model.User;
import com.jn.system.vo.SysDictKeyValue;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @author dt
 * @create 2019-04-19 上午 9:24
 */
@Service
public class EmployeeBasicInfoServiceImpl implements EmployeeBasicInfoService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeBasicInfoServiceImpl.class);
    public static final long ONE_YEAR=31536000;
    @Autowired
    private TbManpowerEmployeeBasicInfoMapper tbManpowerEmployeeBasicInfoMapper;
    @Autowired
    private EmployeeBasicInfoMapper employeeBasicInfoMapper;
    @Autowired
    private TbManpowerDepartmentMapper tbManpowerDepartmentMapper;
    @Autowired
    private EducationExperienceMapper educationExperienceMapper;
    @Autowired
    private HonorWallMapper honorWallMapper;
    @Autowired
    private WorkExperienceMapper workExperienceMapper;
    @Autowired
    private HolidayRuleMapper holidayRuleMapper;
    @Autowired
    private TbManpowerDirectlyLeaderMapper tbManpowerDirectlyLeaderMapper;
    @Autowired
    private DirectlyLeaderMapper directlyLeaderMapper;
    @Autowired
    private TbManpowerSocialSecurityMapper tbManpowerSocialSecurityMapper;
    @Autowired
    private SocialSecurityMapper socialSecurityMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private CommonService commonService;

    @Autowired
    private SystemClient systemClient;

    @Value("${spring.application.name}")
    private String applicationName;

    public static final String prefix="NJ";

    @Override
    @ServiceLog(doAction = "添加员工花名册")
    @Transactional(rollbackFor = Exception.class)
    public void addEmployeeBasicInfo(EmployeeBasicInfoAdd employeeBasicInfoAdd, User user) {
       /* if(!checkDepartment(employeeBasicInfoAdd.getDepartmentId())){
            throw new JnSpringCloudException(EmployeeExceptionEnums.EmployeeDEPARTMENT_NOT_EXISTS);
        }*/
        //用户接口
        User  adduser=new User();
        adduser.setAccount(employeeBasicInfoAdd.getUserAccount());
        adduser.setName(employeeBasicInfoAdd.getName());
        adduser.setPhone(employeeBasicInfoAdd.getPhone());
        adduser.setEmail(employeeBasicInfoAdd.getMailbox());
        adduser.setWechatAccount(employeeBasicInfoAdd.getWechat());
        adduser.setRecordStatus(Byte.parseByte("1"));
        adduser.setPassword("123456");
        adduser.setCreatedTime(new Date());
        adduser.setCreatorAccount(user.getAccount());
        Result result= systemClient.addSysUser(adduser);
        if(result==null || result.getData()==null || !"0000".equals(result.getCode())){
            logger.error("新增用户接口addSysUser调用失败,用户账号{},错误码{},错误原因{}",
                    employeeBasicInfoAdd.getUserAccount(),
                    result!=null?result.getCode():"",result!=null?result.getResult():"");
            throw new JnSpringCloudException(EmployeeExceptionEnums.ADD_USER_ERROR,
                    result!=null?result.getResult():"新增用户接口调用错误");
        }

        if(result.getData()!=null){
            String userId=((Map<String,String>)result.getData()).get("id");
            employeeBasicInfoAdd.setUserId(userId);
        }
        TbManpowerEmployeeBasicInfo tbEmployeeBasicInfo=new TbManpowerEmployeeBasicInfo();
        BeanUtils.copyProperties(employeeBasicInfoAdd,tbEmployeeBasicInfo);

        String jobNumber = getJobNumber();
        tbEmployeeBasicInfo.setJobNumber(jobNumber);
        tbEmployeeBasicInfo.setId(UUID.randomUUID().toString());
        tbEmployeeBasicInfo.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
        tbEmployeeBasicInfo.setCreatedTime(new Date());
        tbEmployeeBasicInfo.setCreatorAccount(user.getAccount());
        tbEmployeeBasicInfo.setModifierAccount(user.getAccount());
        tbEmployeeBasicInfo.setModifiedTime(new Date());
        tbManpowerEmployeeBasicInfoMapper.insert(tbEmployeeBasicInfo);
        if(!CollectionUtils.isEmpty(employeeBasicInfoAdd.getEducationExperienceList())){
            List<TbManpowerEducationExperience> educationList= BeanCopyUtil.copyList(employeeBasicInfoAdd.getEducationExperienceList(),
                    TbManpowerEducationExperience.class);
            educationList.forEach(e->{
                e.setId(UUID.randomUUID().toString());
                e.setJobNumber(tbEmployeeBasicInfo.getJobNumber());
            });
            educationExperienceMapper.insertBatch(educationList);
        }
        if(!CollectionUtils.isEmpty(employeeBasicInfoAdd.getWorkExperienceList())){
            List<TbManpowerWorkExperience> workList= BeanCopyUtil.copyList(employeeBasicInfoAdd.getWorkExperienceList(),
                    TbManpowerWorkExperience.class);
            workList.forEach(e->{
                e.setId(UUID.randomUUID().toString());
                e.setJobNumber(tbEmployeeBasicInfo.getJobNumber());
            });
            workExperienceMapper.insertBatch(workList);
        }
        if(!CollectionUtils.isEmpty(employeeBasicInfoAdd.getHonorWallList())){
            List<TbManpowerHonorWall> wallList= BeanCopyUtil.copyList(employeeBasicInfoAdd.getHonorWallList(),
                    TbManpowerHonorWall.class);
            wallList.forEach(e->{
                e.setId(UUID.randomUUID().toString());
                e.setJobNumber(tbEmployeeBasicInfo.getJobNumber());
            });
            honorWallMapper.insertBatch(wallList);
        }
        DirectlyLeader leader=employeeBasicInfoAdd.getDirectlyLeader();
        if(leader!=null && !StringUtils.isBlank(leader.getDirectLeaderName())){
            leader.setJobNumber(tbEmployeeBasicInfo.getJobNumber());
            leader.setId(UUID.randomUUID().toString());
            TbManpowerDirectlyLeader tbLeader=BeanCopyUtil.copyObject(leader,TbManpowerDirectlyLeader.class);
            tbManpowerDirectlyLeaderMapper.insert(tbLeader);
        }
        SocialSecurity socialSecurity= employeeBasicInfoAdd.getSocialSecurity();
        if(socialSecurity!=null){
            TbManpowerSocialSecurity tbManpowerSocialSecurity=BeanCopyUtil.copyObject(socialSecurity,
                    TbManpowerSocialSecurity.class);
            tbManpowerSocialSecurity.setJobNumber(tbEmployeeBasicInfo.getJobNumber());
            tbManpowerSocialSecurity.setId(UUID.randomUUID().toString());
            tbManpowerSocialSecurityMapper.insert(tbManpowerSocialSecurity);
        }



        logger.info("[员工花名册管理] 新增员工花名册成功,id:{}", tbEmployeeBasicInfo.getId());
    }

    @Override
    @ServiceLog(doAction = "修改员工花名册")
    @Transactional(rollbackFor = Exception.class)
    public void updateEmployeeBasicInfo(EmployeeBasicInfoAdd employeeBasicInfoAdd, User user) {
        TbManpowerEmployeeBasicInfo tbFile=tbManpowerEmployeeBasicInfoMapper.selectByPrimaryKey(employeeBasicInfoAdd.getId());
        if(tbFile==null){
            logger.warn("[员工花名册管理] 修改员工花名册失败,修改信息不存在,id:{}", employeeBasicInfoAdd.getId());
            throw new JnSpringCloudException(HrExceptionEnums.UPDATEDATA_NOT_EXIST);
        }
        /*if(!checkDepartment(employeeBasicInfoAdd.getDepartmentId())){
            throw new JnSpringCloudException(EmployeeExceptionEnums.EmployeeDEPARTMENT_NOT_EXISTS);
        }*/

        //用户接口
        if(StringUtils.isEmpty(tbFile.getUserId())){
            User  adduser=new User();
            adduser.setAccount(employeeBasicInfoAdd.getUserAccount());
            adduser.setName(employeeBasicInfoAdd.getName());
            adduser.setPhone(employeeBasicInfoAdd.getPhone());
            adduser.setEmail(employeeBasicInfoAdd.getMailbox());
            adduser.setWechatAccount(employeeBasicInfoAdd.getWechat());
            adduser.setRecordStatus(Byte.parseByte("1"));
            adduser.setPassword("123456");
            adduser.setCreatedTime(new Date());
            adduser.setCreatorAccount(user.getAccount());
            Result result= systemClient.addSysUser(adduser);
            if(result==null || result.getData()==null || !"0000".equals(result.getCode())){
                logger.error("新增用户接口addSysUser调用失败,用户账号{},错误码{},错误原因{}",
                        employeeBasicInfoAdd.getUserAccount(),
                        result!=null?result.getCode():"",result!=null?result.getResult():"");
                throw new JnSpringCloudException(EmployeeExceptionEnums.ADD_USER_ERROR,
                        result!=null?result.getResult():"新增用户接口调用错误");
            }

            if(result.getData()!=null){
                String userId=((Map<String,String>)result.getData()).get("id");
                employeeBasicInfoAdd.setUserId(userId);
            }
        }


        employeeBasicInfoAdd.setJobNumber(tbFile.getJobNumber());
        TbManpowerEmployeeBasicInfo database=new TbManpowerEmployeeBasicInfo();
        BeanUtils.copyProperties(employeeBasicInfoAdd,database);
        database.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
        database.setModifiedTime(new Date());
        database.setModifierAccount(user.getAccount());
        tbManpowerEmployeeBasicInfoMapper.updateByPrimaryKeySelective(database);


        educationExperienceMapper.deleteByJobNumber(employeeBasicInfoAdd.getJobNumber());
        if(!CollectionUtils.isEmpty(employeeBasicInfoAdd.getEducationExperienceList())){
            List<TbManpowerEducationExperience> educationList= BeanCopyUtil.copyList(employeeBasicInfoAdd.getEducationExperienceList(),
                    TbManpowerEducationExperience.class);
            educationList.forEach(e->{
                e.setId(UUID.randomUUID().toString());
                e.setJobNumber(tbFile.getJobNumber());
            });
            educationExperienceMapper.insertBatch(educationList);
        }

        workExperienceMapper.deleteByJobNumber(employeeBasicInfoAdd.getJobNumber());
        if(!CollectionUtils.isEmpty(employeeBasicInfoAdd.getWorkExperienceList())){
            List<TbManpowerWorkExperience> workList= BeanCopyUtil.copyList(employeeBasicInfoAdd.getWorkExperienceList(),
                    TbManpowerWorkExperience.class);
            workList.forEach(e->{
                e.setId(UUID.randomUUID().toString());
                e.setJobNumber(tbFile.getJobNumber());
            });
            workExperienceMapper.insertBatch(workList);
        }

        honorWallMapper.deleteByJobNumber(employeeBasicInfoAdd.getJobNumber());
        if(!CollectionUtils.isEmpty(employeeBasicInfoAdd.getHonorWallList())){
            List<TbManpowerHonorWall> wallList= BeanCopyUtil.copyList(employeeBasicInfoAdd.getHonorWallList(),
                    TbManpowerHonorWall.class);
            wallList.forEach(e->{
                e.setId(UUID.randomUUID().toString());
                e.setJobNumber(tbFile.getJobNumber());
            });
            honorWallMapper.insertBatch(wallList);
        }
        DirectlyLeader leader=employeeBasicInfoAdd.getDirectlyLeader();
        if(leader!=null && !StringUtils.isEmpty(leader.getJobNumber())){
            if(StringUtils.isBlank(leader.getId())){
                leader.setJobNumber(employeeBasicInfoAdd.getJobNumber());
                leader.setId(UUID.randomUUID().toString());
                TbManpowerDirectlyLeader tbLeader=BeanCopyUtil.copyObject(leader,TbManpowerDirectlyLeader.class);
                tbManpowerDirectlyLeaderMapper.insert(tbLeader);
            }else{
                TbManpowerDirectlyLeader tbLeader=BeanCopyUtil.copyObject(leader,TbManpowerDirectlyLeader.class);
                tbLeader.setJobNumber(employeeBasicInfoAdd.getJobNumber());
                tbManpowerDirectlyLeaderMapper.updateByPrimaryKey(tbLeader);
            }
        }
        SocialSecurity socialSecurity=employeeBasicInfoAdd.getSocialSecurity();
        if(socialSecurity!=null && !StringUtils.isEmpty(socialSecurity.getJobNumber())){
            if(StringUtils.isBlank(socialSecurity.getId())){
                socialSecurity.setJobNumber(employeeBasicInfoAdd.getJobNumber());
                socialSecurity.setId(UUID.randomUUID().toString());
                TbManpowerSocialSecurity tbManpowerSocialSecurity=BeanCopyUtil.copyObject(socialSecurity,
                        TbManpowerSocialSecurity.class);
                tbManpowerSocialSecurityMapper.insert(tbManpowerSocialSecurity);
            }else{
                TbManpowerSocialSecurity tbManpowerSocialSecurity=BeanCopyUtil.copyObject(socialSecurity,
                        TbManpowerSocialSecurity.class);
                tbManpowerSocialSecurity.setJobNumber(employeeBasicInfoAdd.getJobNumber());
                tbManpowerSocialSecurityMapper.updateByPrimaryKey(tbManpowerSocialSecurity);
            }
        }


        logger.info("[员工花名册管理] 修改员工花名册成功,id:{}", database.getId());
    }

    private String getJobNumber() {
        RedisAtomicLong counter = new RedisAtomicLong(applicationName+":"+
                "employee:"+"employeeBasicInfo:jobNumber",
                redisTemplate.getConnectionFactory());
        long count=counter.getAndAdd(1);
        return prefix+String.format("%06d",count);
    }

    @Override
    @ServiceLog(doAction = "(逻辑)删除员工花名册")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id, User user) {
        TbManpowerEmployeeBasicInfo tbFile = tbManpowerEmployeeBasicInfoMapper.selectByPrimaryKey(id);
        if (tbFile != null) {
            //设置状态为删除状态
            tbFile.setRecordStatus(new Byte(HrStatusEnums.DELETED.getCode()));
            //设置最新更新人及更新时间
            tbFile.setModifiedTime(new Date());
            tbFile.setModifierAccount(user.getAccount());
            tbManpowerEmployeeBasicInfoMapper.updateByPrimaryKeySelective(tbFile);
        }
        logger.info("[员工花名册管理] (逻辑)删除员工花名册成功,id:{}", id);
    }

    @Override
    @ServiceLog(doAction = "查询员工花名册详情")
    public EmployeeBasicInfo getEmployeeBasicInfoById(String id) {
        TbManpowerEmployeeBasicInfo tbFile=tbManpowerEmployeeBasicInfoMapper.selectByPrimaryKey(id);
        if(tbFile==null || new Byte(HrStatusEnums.DELETED.getCode()).equals(tbFile.getRecordStatus())){
            logger.warn("[员工花名册管理] 查询员工花名册详情失败,id:{}", id);
            throw new JnSpringCloudException(EmployeeExceptionEnums.EmployeeBasicInfo_NOT_EXISTS);
        }
        EmployeeBasicInfo employeeBasicInfo=new EmployeeBasicInfo();
        BeanUtils.copyProperties(tbFile,employeeBasicInfo);
        List<EducationExperience> educationExperiences = educationExperienceMapper.
                selectByJobNumber(employeeBasicInfo.getJobNumber());
        employeeBasicInfo.setEducationExperienceList(educationExperiences);
        List<WorkExperience> workExperiences = workExperienceMapper.selectByJobNumber(employeeBasicInfo.getJobNumber());
        employeeBasicInfo.setWorkExperienceList(workExperiences);
        List<HonorWall> honorWalls = honorWallMapper.selectByJobNumber(employeeBasicInfo.getJobNumber());
        employeeBasicInfo.setHonorWallList(honorWalls);
        DirectlyLeader sLeader=directlyLeaderMapper.selectByJobNumber(employeeBasicInfo.getJobNumber());
        employeeBasicInfo.setDirectlyLeader(sLeader);
        SocialSecurity socialSecurity=socialSecurityMapper.selectByJobNumber(employeeBasicInfo.getJobNumber());
        employeeBasicInfo.setSocialSecurity(socialSecurity);

        employeeBasicInfo.setSexStr(CodeAndMsgUtil.getMsgByCode(EmploySexEnum.class,employeeBasicInfo.getSex()));
        employeeBasicInfo.setCreatedTimeStr(DateUtils.formatDate(employeeBasicInfo.getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
        employeeBasicInfo.setEntryDateStr(DateUtils.formatDate(employeeBasicInfo.getEntryDate(),"yyyy-MM-dd HH:mm:ss"));
        employeeBasicInfo.setBirthDateStr(DateUtils.formatDate(employeeBasicInfo.getBirthDate(),"yyyy-MM-dd HH:mm:ss"));
        employeeBasicInfo.setStartCurrentStr(DateUtils.formatDate(employeeBasicInfo.getStartCurrent(),"yyyy-MM-dd HH:mm:ss"));
        employeeBasicInfo.setEndCurrentStr(DateUtils.formatDate(employeeBasicInfo.getEndCurrent(),"yyyy-MM-dd HH:mm:ss"));
        employeeBasicInfo.setExpirationDateStr(DateUtils.formatDate(employeeBasicInfo.getExpirationDate(),"yyyy-MM-dd HH:mm:ss"));
        employeeBasicInfo.setEmployeeTypeStr(CodeAndMsgUtil.getMsgByCode(EmployeeTypeEnum.class,employeeBasicInfo.getEmployeeType()));
        employeeBasicInfo.setRegisteredTypeStr(CodeAndMsgUtil.getMsgByCode(RegisteredTypeEnum.class,employeeBasicInfo.getRegisteredType()));
        employeeBasicInfo.setPoliticalOutlookStr(CodeAndMsgUtil.getMsgByCode(PoliticalOutlookEnum.class,employeeBasicInfo.getPoliticalOutlook()));
        employeeBasicInfo.setMaritalStatusStr(CodeAndMsgUtil.getMsgByCode(MaritalStatusEnum.class,employeeBasicInfo.getMaritalStatus()));
        employeeBasicInfo.setEmployStatusStr(CodeAndMsgUtil.getMsgByCode(EmployStatusEnum.class,String.valueOf(employeeBasicInfo.getEmployStatus())));
        return employeeBasicInfo;
    }

    @Override
    @ServiceLog(doAction = "分页查询员工花名册信息")
    public PaginationData<List<EmployeeBasicInfo>> list(EmployeeBasicInfoPage employeeBasicInfoPage,boolean calcHoliday) {
        Page<Object> objects = PageHelper.startPage(employeeBasicInfoPage.getPage(), employeeBasicInfoPage.getRows());
        List<EmployeeBasicInfo> noticeList = employeeBasicInfoMapper.list(employeeBasicInfoPage);
        PaginationData<List<EmployeeBasicInfo>> data = new PaginationData(noticeList, objects.getTotal());
        if(objects.getTotal()>0L){
            List<HolidayRule> rules=null;
            if(calcHoliday){
                rules=holidayRuleMapper.list();
            }
            for (EmployeeBasicInfo e : noticeList) {
                e.setSexStr(CodeAndMsgUtil.getMsgByCode(EmploySexEnum.class,e.getSex()));
                e.setCreatedTimeStr(DateUtils.formatDate(e.getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
                e.setEntryDateStr(DateUtils.formatDate(e.getEntryDate(),"yyyy-MM-dd HH:mm:ss"));
                e.setBirthDateStr(DateUtils.formatDate(e.getBirthDate(),"yyyy-MM-dd HH:mm:ss"));
                e.setStartCurrentStr(DateUtils.formatDate(e.getStartCurrent(),"yyyy-MM-dd HH:mm:ss"));
                e.setEndCurrentStr(DateUtils.formatDate(e.getEndCurrent(),"yyyy-MM-dd HH:mm:ss"));
                e.setExpirationDateStr(DateUtils.formatDate(e.getExpirationDate(),"yyyy-MM-dd HH:mm:ss"));
                e.setEmployeeTypeStr(CodeAndMsgUtil.getMsgByCode(EmployeeTypeEnum.class,e.getEmployeeType()));
                e.setRegisteredTypeStr(CodeAndMsgUtil.getMsgByCode(RegisteredTypeEnum.class,e.getRegisteredType()));
                e.setPoliticalOutlookStr(CodeAndMsgUtil.getMsgByCode(PoliticalOutlookEnum.class,e.getPoliticalOutlook()));
                e.setMaritalStatusStr(CodeAndMsgUtil.getMsgByCode(MaritalStatusEnum.class,e.getMaritalStatus()));
                e.setEmployStatusStr(CodeAndMsgUtil.getMsgByCode(EmployStatusEnum.class,String.valueOf(e.getEmployStatus())));
                if(calcHoliday){
                    long diff=0;
                    List<WorkExperience> workExperiences = workExperienceMapper.selectByJobNumber(e.getJobNumber());
                    if(!CollectionUtils.isEmpty(workExperiences)){
                        //计算工龄 用系统时间-最早参加工作时间
                        diff=(System.currentTimeMillis()-workExperiences.get(0).getEntryDate().getTime())/1000;
                    }

                    if(diff<=0){
                        e.setWorkingAge(0);
                        e.setAnnualLeave(0);
                        continue;
                    }else{
                        Long age=diff/ONE_YEAR;
                        e.setWorkingAge(age.intValue());
                    }
                    //设置年休假为0天
                    if(CollectionUtils.isEmpty(rules)){
                        e.setAnnualLeave(0);
                        continue;
                    }
                    //计算工龄落在哪个区间
                    boolean flag=false;
                    for (HolidayRule rule : rules) {
                        if(e.getWorkingAge()>=rule.getReachedYear() && e.getWorkingAge()<=rule.getNotFullYear()){
                            e.setAnnualLeave(rule.getAnnualLeave());
                            flag=true;
                        }
                    }
                    if(!flag){
                        //规则表未找到，默认年休假为0天
                        e.setAnnualLeave(0);
                    }

                }
            }
        }
        return data;
    }

    @Override
    @ServiceLog(doAction = "员工花名册导入")
    public String importEmployeeBasicInfo(MultipartFile file, User user) {
        if (file.isEmpty()) {
            logger.warn("[员工基本信息] 导入失败,导入文件为空");
            throw new JnSpringCloudException(EmployeeExceptionEnums.FILE_NOT_EMPTY);
        }

        //2.使用工具类,解析导入文件
        EmployeeBasicInfo employeeBasicInfo = new EmployeeBasicInfo();
        List<Object> resultList= ExcelUtil.readExcel(file, employeeBasicInfo, 1, 1);
        if(CollectionUtils.isEmpty(resultList)){
            return "没有数据，导入失败";
        }
        int i=0;
        StringBuffer sb=new StringBuffer();
        List<TbManpowerEmployeeBasicInfo> batchResult=new ArrayList<TbManpowerEmployeeBasicInfo>();


        Result deptResult= systemClient.selectDeptByParentId("",true);
        if(deptResult==null || !"0000".equals(deptResult.getCode()) || deptResult.getData()==null){
            throw new JnSpringCloudException(HrExceptionEnums.DEPARTMENT_QUERY_ERRPR);
        }
        Map<String,String>  departMap= DepartMentUtil.convertDepartList((List<HashMap<String, Object>>)deptResult.getData());
        Result<List<SysPost>> postResult=systemClient.getPostAll();
        if(postResult==null || !"0000".equals(postResult.getCode()) || CollectionUtils.isEmpty(postResult.getData())){
            throw new JnSpringCloudException(HrExceptionEnums.POST_QUERY_ERRPR);
        }
        List<SysPost>  postList=postResult.getData();
        List<SysDictKeyValue>  certificateTypeList= commonService.queryDictList
                ("employee","certificate_type");
        List<SysDictKeyValue>  educationList= commonService.queryDictList
                ("employee","education");
        List<SysDictKeyValue>  jobList= commonService.queryDictList
                ("employee","job");
        List<SysDictKeyValue>  contractList= commonService.queryDictList
                ("employee","contract");
        List<SysDictKeyValue>  nationalityList= commonService.queryDictList
                ("employee","nationality");


        for(Object result:resultList){
            i++;
            EmployeeBasicInfo database= (EmployeeBasicInfo) result;
            String str=checkImportValue(database,departMap,postList,certificateTypeList,educationList,
                    jobList,contractList,nationalityList);
            if(!StringUtils.isBlank(str)){
                sb.append("第"+i+"行:"+str+";");
                continue;
            }
            TbManpowerEmployeeBasicInfo tbFile =new TbManpowerEmployeeBasicInfo();
            BeanUtils.copyProperties(database,tbFile);
            tbFile.setId(UUID.randomUUID().toString());
            tbFile.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
            tbFile.setCreatedTime(new Date());
            tbFile.setCreatorAccount(user.getAccount());
            tbFile.setModifierAccount(user.getAccount());
            tbFile.setModifiedTime(new Date());
            batchResult.add(tbFile);
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            logger.warn("[员工基本信息] 导入失败:{}",sb.toString());
            return sb.toString();
        }else{
            if(!CollectionUtils.isEmpty(batchResult)){
                List<TbManpowerEmployeeBasicInfo> finalResult=new ArrayList<TbManpowerEmployeeBasicInfo>();
                batchResult.forEach(e->{
                    e.setUserAccount(e.getPhone());
                    e.setJobNumber(getJobNumber());
                    User  adduser=new User();
                    adduser.setAccount(e.getPhone());
                    adduser.setName(e.getName());
                    adduser.setPhone(e.getPhone());
                    adduser.setEmail(e.getMailbox());
                    adduser.setWechatAccount(e.getWechat());
                    adduser.setRecordStatus(Byte.parseByte("1"));
                    adduser.setPassword("123456");
                    adduser.setCreatedTime(new Date());
                    adduser.setCreatorAccount(user.getAccount());
                    Result addUserResult= systemClient.addSysUser(adduser);
                    if(addUserResult==null || addUserResult.getData()==null || !"0000".equals(addUserResult.getCode())){
                        logger.error("新增用户接口addSysUser调用失败,用户账号{},错误码{},错误原因{}",
                                e.getUserAccount(),
                                addUserResult!=null?addUserResult.getCode():"",
                                addUserResult!=null?addUserResult.getResult():"");
                    }
                    if(addUserResult.getData()!=null){
                        String userId=((Map<String,String>)addUserResult.getData()).get("id");
                        e.setUserId(userId);
                        finalResult.add(e);
                    }
                });
                if(!CollectionUtils.isEmpty(finalResult)){
                    employeeBasicInfoMapper.insertBatch(finalResult);
                    logger.info("[员工基本信息] 成功导入{}条数据",finalResult.size());
                }else{
                    return "新增用户接口调用失败,导入失败";
                }
            }
            return "导入成功";
        }
    }

    @Override
    @ServiceLog(doAction = "直属领导导入")
    public String importDirectlyLeader(MultipartFile file, User user) {
        if (file.isEmpty()) {
            logger.warn("[直属领导] 导入失败,导入文件为空");
            throw new JnSpringCloudException(EmployeeExceptionEnums.FILE_NOT_EMPTY);
        }

        //2.使用工具类,解析导入文件
        DirectlyLeader directlyLeader = new DirectlyLeader();
        List<Object> resultList= ExcelUtil.readExcel(file, directlyLeader, 1, 1);
        if(CollectionUtils.isEmpty(resultList)){
            return "没有数据，导入失败";
        }
        int i=0;
        StringBuffer sb=new StringBuffer();
        List<TbManpowerDirectlyLeader> batchResult=new ArrayList<TbManpowerDirectlyLeader>();


        Result<List<SysPost>> postResult=systemClient.getPostAll();
        if(postResult==null || !"0000".equals(postResult.getCode()) || CollectionUtils.isEmpty(postResult.getData())){
            logger.error("导入直属领导，查询岗位出错");
            throw new JnSpringCloudException(HrExceptionEnums.POST_QUERY_ERRPR);
        }
        List<SysPost>  postList=postResult.getData();
        List<SysDictKeyValue>  jobList= commonService.queryDictList
                ("employee","job");

        for(Object result:resultList){
            i++;
            DirectlyLeader database= (DirectlyLeader) result;
            String str=checkImportDirectlyLeader(database,postList,jobList);
            if(!StringUtils.isBlank(str)){
                sb.append("第"+i+"行:"+str+";");
                continue;
            }
            TbManpowerDirectlyLeader tbFile =new TbManpowerDirectlyLeader();
            BeanUtils.copyProperties(database,tbFile);
            tbFile.setId(UUID.randomUUID().toString());
            batchResult.add(tbFile);
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            logger.warn("[直属领导] 导入失败:{}",sb.toString());
            return sb.toString();
        }else{
            if(!CollectionUtils.isEmpty(batchResult)){
                directlyLeaderMapper.insertBatch(batchResult);
                logger.info("[直属领导] 成功导入{}条数据",batchResult.size());
            }
            return "导入成功";
        }
    }

    @Override
    @ServiceLog(doAction = "社保福利导入")
    public String importSocialSecurity(MultipartFile file, User user) {
        if (file.isEmpty()) {
            logger.warn("[社保福利] 导入失败,导入文件为空");
            throw new JnSpringCloudException(EmployeeExceptionEnums.FILE_NOT_EMPTY);
        }

        //2.使用工具类,解析导入文件
        SocialSecurity socialSecurity = new SocialSecurity();
        List<Object> resultList= ExcelUtil.readExcel(file, socialSecurity, 1, 1);
        if(CollectionUtils.isEmpty(resultList)){
            return "没有数据，导入失败";
        }
        int i=0;
        StringBuffer sb=new StringBuffer();
        List<TbManpowerSocialSecurity> batchResult=new ArrayList<TbManpowerSocialSecurity>();
        for(Object result:resultList){
            i++;
            SocialSecurity database= (SocialSecurity) result;
            String str=checkImportDirectlyLeader(database);
            if(!StringUtils.isBlank(str)){
                sb.append("第"+i+"行:"+str+";");
                continue;
            }
            TbManpowerSocialSecurity tbFile =new TbManpowerSocialSecurity();
            BeanUtils.copyProperties(database,tbFile);
            tbFile.setId(UUID.randomUUID().toString());
            batchResult.add(tbFile);
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            logger.warn("[社保福利] 导入失败:{}",sb.toString());
            return sb.toString();
        }else{
            if(!CollectionUtils.isEmpty(batchResult)){
                socialSecurityMapper.insertBatch(batchResult);
                logger.info("[社保福利] 成功导入{}条数据",batchResult.size());
            }
            return "导入成功";
        }
    }

    @Override
    @ServiceLog(doAction = "教育经历导入")
    public String importEducationExperience(MultipartFile file, User user) {
        if (file.isEmpty()) {
            logger.warn("[教育经历] 导入失败,导入文件为空");
            throw new JnSpringCloudException(EmployeeExceptionEnums.FILE_NOT_EMPTY);
        }

        //2.使用工具类,解析导入文件
        EducationExperience educationExperience = new EducationExperience();
        List<Object> resultList= ExcelUtil.readExcel(file, educationExperience, 1, 1);
        if(CollectionUtils.isEmpty(resultList)){
            return "没有数据，导入失败";
        }
        int i=0;
        StringBuffer sb=new StringBuffer();
        List<TbManpowerEducationExperience> batchResult=new ArrayList<TbManpowerEducationExperience>();

        List<SysDictKeyValue>  educationList= commonService.queryDictList
                ("employee","education");

        for(Object result:resultList){
            i++;
            EducationExperience database= (EducationExperience) result;
            String str=checkImportEducation(database,educationList);
            if(!StringUtils.isBlank(str)){
                sb.append("第"+i+"行:"+str+";");
                continue;
            }
            TbManpowerEducationExperience tbFile =new TbManpowerEducationExperience();
            BeanUtils.copyProperties(database,tbFile);
            tbFile.setId(UUID.randomUUID().toString());
            batchResult.add(tbFile);
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            logger.warn("[教育经历] 导入失败:{}",sb.toString());
            return sb.toString();
        }else{
            if(!CollectionUtils.isEmpty(batchResult)){
                educationExperienceMapper.insertBatch(batchResult);
                logger.info("[教育经历] 成功导入{}条数据",batchResult.size());
            }
            return "导入成功";
        }
    }

    @Override
    @ServiceLog(doAction = "工作经历导入")
    public String importWorkExperience(MultipartFile file, User user) {
        if (file.isEmpty()) {
            logger.warn("[工作经历] 导入失败,导入文件为空");
            throw new JnSpringCloudException(EmployeeExceptionEnums.FILE_NOT_EMPTY);
        }

        //2.使用工具类,解析导入文件
        WorkExperience workExperience = new WorkExperience();
        List<Object> resultList= ExcelUtil.readExcel(file, workExperience, 1, 1);
        if(CollectionUtils.isEmpty(resultList)){
            return "没有数据，导入失败";
        }
        int i=0;
        StringBuffer sb=new StringBuffer();
        List<TbManpowerWorkExperience> batchResult=new ArrayList<TbManpowerWorkExperience>();
        for(Object result:resultList){
            i++;
            WorkExperience database= (WorkExperience) result;
            String str=checkImportWork(database);
            if(!StringUtils.isBlank(str)){
                sb.append("第"+i+"行:"+str+";");
                continue;
            }
            TbManpowerWorkExperience tbFile =new TbManpowerWorkExperience();
            BeanUtils.copyProperties(database,tbFile);
            tbFile.setId(UUID.randomUUID().toString());
            batchResult.add(tbFile);
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            logger.warn("[工作经历] 导入失败:{}",sb.toString());
            return sb.toString();
        }else{
            if(!CollectionUtils.isEmpty(batchResult)){
                workExperienceMapper.insertBatch(batchResult);
                logger.info("[工作经历] 成功导入{}条数据",batchResult.size());
            }
            return "导入成功";
        }
    }

    private String checkImportValue(EmployeeBasicInfo database,Map<String,String> departMap,List<SysPost> postList,
                                    List<SysDictKeyValue> certificateTypeList,List<SysDictKeyValue> educationList,
                                    List<SysDictKeyValue> jobList,List<SysDictKeyValue> contractList,
                                    List<SysDictKeyValue> nationalityList){
        if(StringUtils.isBlank(database.getName())){
            return "姓名不能为空";
        }

        if(StringUtils.isBlank(database.getSexStr())){
            return "性别不能为空";
        }
        if(!"男".equals(database.getSexStr()) && !"女".equals(database.getSexStr())){
            return "性别错误";
        }
        if("男".equals(database.getSexStr())){
            database.setSex("1");
        }else{
            database.setSex("2");
        }
        if(StringUtils.isBlank(database.getPhone())){
            return "手机号码不能为空";
        }
        if(!ValidateUtil.isMobile(database.getPhone())){
            return "手机号码格式不正确";
        }
        if(StringUtils.isBlank(database.getMailbox())){
            return "个人邮箱不能为空";
        }
        if(!ValidateUtil.isEmail(database.getMailbox())){
            return "邮箱格式不正确";
        }
        if(StringUtils.isBlank(database.getDepartmentName())){
            return "部门名称不能为空";
        }

        database.setDepartmentId(departMap.get(database.getDepartmentName()));
        if(StringUtils.isEmpty(database.getDepartmentId())){
            return "部门名称错误";
        }


        if(StringUtils.isBlank(database.getJobName())){
            return "职级名称不能为空";
        }
        database.setJobId(SysDictKeyValueUtil.getKeyByLabel(jobList,database.getJobName()));
        if(StringUtils.isBlank(database.getJobId())){
            return "职级名称错误";
        }

        if(StringUtils.isBlank(database.getCertificateType())){
            return "证件类型不能为空";
        }
        database.setCertificateId(SysDictKeyValueUtil.getKeyByLabel(certificateTypeList,database.getCertificateType()));
        if(StringUtils.isBlank(database.getCertificateId())){
            return "证件类型错误";
        }

        if(StringUtils.isBlank(database.getCertificateNumber())){
            return "证件号码不能为空";
        }

        if(StringUtils.isBlank(database.getPostName())){
            return "岗位名称不能为空";
        }
        database.setPostId(SysDictKeyValueUtil.getPostIdByName(postList,database.getPostName()));
        if(StringUtils.isBlank(database.getPostId())){
            return "岗位名称错误";
        }


        if(StringUtils.isBlank(database.getContractName())){
            return "合同类型名称不能为空";
        }
        database.setContractId(SysDictKeyValueUtil.getKeyByLabel(contractList,database.getContractName()));
        if(StringUtils.isBlank(database.getContractId())){
            return "合同类型名称错误";
        }

        if(database.getEmployeeTypeStr()==null){
            return "员工类型不能为空";
        }
        if(!"正式".equals(database.getEmployeeTypeStr()) && !"实习生".equals(database.getEmployeeTypeStr())){
            return "员工类型错误";
        }
        if("正式".equals(database.getEmployeeTypeStr())){
            database.setEmployeeType("1");
        }else{
            database.setEmployeeType("2");
        }
        if(StringUtils.isBlank(database.getEntryDateStr())){
            return "入职日期不能为空";
        }
        database.setEntryDate(HrDataUtil.getPOIDate(false,Double.parseDouble(database.getEntryDateStr())));

        if(StringUtils.isBlank(database.getBirthDateStr())){
            return "出生日期不能为空";
        }
        database.setBirthDate(HrDataUtil.getPOIDate(false,Double.parseDouble(database.getBirthDateStr())));

        if(StringUtils.isBlank(database.getNationalityName())){
            return "国籍名称不能为空";
        }
        database.setNationalityId(SysDictKeyValueUtil.getKeyByLabel(nationalityList,database.getNationalityName()));

        if(StringUtils.isBlank(database.getNationalityId())){
            return "国籍名称错误";
        }
        if(StringUtils.isBlank(database.getWorkAddress())){
            return "工作地址不能为空";
        }
        if(StringUtils.isBlank(database.getContactAddress())){
            return "联系地址不能为空";
        }

        if(StringUtils.isBlank(database.getStartCurrentStr())){
            return "当前合同起始日不能为空";
        }
        database.setStartCurrent(HrDataUtil.getPOIDate(false,
                Double.parseDouble(database.getStartCurrentStr())));

        if(StringUtils.isBlank(database.getEndCurrentStr())){
            return "当前合同终止日不能为空";
        }
        database.setEndCurrent(HrDataUtil.getPOIDate(false,
                Double.parseDouble(database.getEndCurrentStr())));

        if(database.getExpirationDateStr()==null){
            return "试用期到期日不能为空";
        }
        database.setExpirationDate(HrDataUtil.getPOIDate(false,
                Double.parseDouble(database.getExpirationDateStr())));

        if(StringUtils.isBlank(database.getEmployStatusStr())){
            return "员工状态不能为空";
        }
        if(!"在职".equals(database.getEmployStatusStr()) && !"医疗期".equals(database.getEmployStatusStr())){
            return "员工状态错误";
        }
        if("在职".equals(database.getEmployStatusStr())){
            database.setEmployStatus(Byte.parseByte("1"));
        }else{
            database.setEmployStatus(Byte.parseByte("2"));
        }
        return "";
    }

    private String checkImportDirectlyLeader(DirectlyLeader database,List<SysPost> postList,List<SysDictKeyValue> jobList) {
        if(StringUtils.isBlank(database.getJobNumber())){
            return "工号不能为空";
        }
        if(StringUtils.isBlank(database.getDirectLeaderName()) && StringUtils.isBlank(database.getDirectLeaderLevelName())
        && StringUtils.isBlank(database.getDirectLeadershipName())){
            return "必填字段不能都为空";
        }
        //查询工号是否存在
        TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo=new TbManpowerEmployeeBasicInfo();
        tbManpowerEmployeeBasicInfo.setJobNumber(database.getJobNumber());
        List<TbManpowerEmployeeBasicInfo> basicInfos= employeeBasicInfoMapper.getList(tbManpowerEmployeeBasicInfo);
        if(CollectionUtils.isEmpty(basicInfos)){
            return "工号不存在";
        }
        //查询直属领导表判断是否存在
        DirectlyLeader directlyLeader=directlyLeaderMapper.selectByJobNumber(database.getJobNumber());
        if(directlyLeader!=null){
            return "直属领导表已经存在当前工号的记录";
        }

        if(!StringUtils.isBlank(database.getDirectLeaderLevelName())){
            database.setDirectLeaderLevel(SysDictKeyValueUtil.getKeyByLabel(jobList,database.getDirectLeaderLevelName()));
            if(StringUtils.isBlank(database.getDirectLeaderLevel())){
                return "直属领导职级错误";
            }
        }

        if(!StringUtils.isBlank(database.getDirectLeadershipName())){
            database.setDirectLeadership(SysDictKeyValueUtil.getPostIdByName(postList,database.getDirectLeadershipName()));
            if(StringUtils.isBlank(database.getDirectLeadership())){
                return "直属领导岗位错误";
            }
        }
        return "";
    }

    private String checkImportEducation(EducationExperience database,List<SysDictKeyValue> educationList) {
        if(StringUtils.isBlank(database.getJobNumber())){
            return "工号不能为空";
        }

        if(StringUtils.isBlank(database.getSchool())){
            return "学校不能为空";
        }

        if(StringUtils.isBlank(database.getAdmissionTimeStr())){
            return "入校时间不能为空";
        }
        database.setAdmissionTime(HrDataUtil.getPOIDate(false,
                Double.parseDouble(database.getAdmissionTimeStr())));

        if(StringUtils.isBlank(database.getCompletionTimeStr())){
            return "结业时间不能为空";
        }
        database.setCompletionTime(HrDataUtil.getPOIDate(false,
                Double.parseDouble(database.getCompletionTimeStr())));

        if(!StringUtils.isBlank(database.getIsAcademicDegreeStr())){
            if(!"是".equals(database.getIsAcademicDegreeStr()) && !"否".equals(database.getIsAcademicDegreeStr())){
                return "是否取得学位字段错误";
            }
            if("是".equals(database.getIsAcademicDegreeStr())){
                database.setIsAcademicDegree(Byte.parseByte("1"));
            }else{
                database.setIsAcademicDegree(Byte.parseByte("2"));
            }
        }
        if(!StringUtils.isBlank(database.getEducationName())){
            database.setEducationCode(SysDictKeyValueUtil.getKeyByLabel(educationList,database.getEducationName()));
            if(StringUtils.isBlank(database.getEducationCode())){
                return "学历错误";
            }
        }

        //查询工号是否存在
        TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo=new TbManpowerEmployeeBasicInfo();
        tbManpowerEmployeeBasicInfo.setJobNumber(database.getJobNumber());
        List<TbManpowerEmployeeBasicInfo> basicInfos= employeeBasicInfoMapper.getList(tbManpowerEmployeeBasicInfo);
        if(CollectionUtils.isEmpty(basicInfos)){
            return "工号不存在";
        }
        //查询直属领导表判断是否存在
        List<EducationExperience> educationExpList=educationExperienceMapper.selectByJobNumber(database.getJobNumber());
        if(!CollectionUtils.isEmpty(educationExpList)){
            return "教育经历表已经存在当前工号的记录";
        }
        return "";
    }

    private String checkImportWork(WorkExperience database) {
        if(StringUtils.isBlank(database.getJobNumber())){
            return "工号不能为空";
        }

        if(StringUtils.isBlank(database.getCorporateName())){
            return "公司名称不能为空";
        }

        if(StringUtils.isBlank(database.getEntryDateStr())){
            return "入职日期不能为空";
        }
        database.setLeaveDate(HrDataUtil.getPOIDate(false,
                Double.parseDouble(database.getLeaveDateStr())));

        if(StringUtils.isBlank(database.getLeaveDateStr())){
            return "离职日期不能为空";
        }
        database.setEntryDate(HrDataUtil.getPOIDate(false,
                Double.parseDouble(database.getEntryDateStr())));

        if(StringUtils.isBlank(database.getWorkTypeStr())){
            return "工作类型不能为空";
        }
        if(!"社会实践".equals(database.getWorkTypeStr()) && !"工作经历".equals(database.getWorkTypeStr())){
            return "是否取得学位字段错误";
        }
        if("社会实践".equals(database.getWorkTypeStr())){
            database.setWorkType(Byte.parseByte("1"));
        }else{
            database.setWorkType(Byte.parseByte("2"));
        }

        //查询工号是否存在
        TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo=new TbManpowerEmployeeBasicInfo();
        tbManpowerEmployeeBasicInfo.setJobNumber(database.getJobNumber());
        List<TbManpowerEmployeeBasicInfo> basicInfos= employeeBasicInfoMapper.getList(tbManpowerEmployeeBasicInfo);
        if(CollectionUtils.isEmpty(basicInfos)){
            return "工号不存在";
        }
        //查询直属领导表判断是否存在
        List<WorkExperience> educationList=workExperienceMapper.selectByJobNumber(database.getJobNumber());
        if(!CollectionUtils.isEmpty(educationList)){
            return "工作经历表已经存在当前工号的记录";
        }
        return "";
    }


    private String checkImportDirectlyLeader(SocialSecurity database) {
        if(StringUtils.isBlank(database.getJobNumber())){
            return "工号不能为空";
        }

        //查询工号是否存在
        TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo=new TbManpowerEmployeeBasicInfo();
        tbManpowerEmployeeBasicInfo.setJobNumber(database.getJobNumber());
        List<TbManpowerEmployeeBasicInfo> basicInfos= employeeBasicInfoMapper.getList(tbManpowerEmployeeBasicInfo);
        if(CollectionUtils.isEmpty(basicInfos)){
            return "工号不存在";
        }
        //查询直属领导表判断是否存在
        SocialSecurity socialSecurity=socialSecurityMapper.selectByJobNumber(database.getJobNumber());
        if(socialSecurity!=null){
            return "社保福利表已经存在当前工号的记录";
        }
        return "";
    }

    public boolean checkDepartment(String departmentId){
        TbManpowerDepartment depart=tbManpowerDepartmentMapper.selectByPrimaryKey(departmentId);
        return depart!=null ? true : false;
    }

    @Override
    public void updateEmployStatus(String id, String employStatus, User user) {
        TbManpowerEmployeeBasicInfo record=new TbManpowerEmployeeBasicInfo();
        record.setId(id);
        record.setEmployStatus(Byte.parseByte(employStatus));
        record.setModifierAccount(user.getAccount());
        record.setModifiedTime(new Date());
        tbManpowerEmployeeBasicInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<TreeModel> selectDepartEmployee() {
        Result result= systemClient.selectDeptByParentId("",true);
        if(result==null || !"0000".equals(result.getCode()) || result.getData()==null){
            throw new JnSpringCloudException(HrExceptionEnums.DEPARTMENT_QUERY_ERRPR);
        }
        List<TreeModel> rootList=new ArrayList<TreeModel>();
        List<HashMap<String,Object>> list= (List<HashMap<String, Object>>) result.getData();

        for (HashMap<String, Object> stringObjectHashMap : list) {
            TreeModel treeModel = getTreeModel(stringObjectHashMap);
            rootList.add(treeModel);
        }

        return rootList;
    }

    private void setTreeChildren(TreeModel rootModel,List<HashMap<String,Object>> children){
        if(children==null || children.size()==0){
            return;
        }
        List<TreeModel> childList=null;
        if(rootModel.getChildren()==null){
            childList=new ArrayList<TreeModel>();
        }else{
            childList=rootModel.getChildren();
        }

        for (HashMap<String, Object> childMap : children) {
            TreeModel treeModel = getTreeModel(childMap);
            childList.add(treeModel);
        }
        rootModel.setChildren(childList);
    }

    private void setTreeEmployeeChildren(TreeModel rootModel,List<TbManpowerEmployeeBasicInfo> children){
        if(children==null || children.size()==0){
            return;
        }
        List<TreeModel> childList=null;
        if(rootModel.getChildren()==null){
            childList=new ArrayList<TreeModel>();
        }else{
            childList=rootModel.getChildren();
        }

        for (TbManpowerEmployeeBasicInfo child : children) {
            TreeModel treeModel = new TreeModel();
            treeModel.setFlag(false);//表示员工
            treeModel.setId(child.getId());
            treeModel.setValue(child.getId());
            treeModel.setLabel(child.getName());
            treeModel.setLevel("");
            treeModel.setParentId("");
            treeModel.setJobNumber(child.getJobNumber());
            treeModel.setMailbox(child.getMailbox());
            treeModel.setChildren(new ArrayList<TreeModel>());
            childList.add(treeModel);
        }
        rootModel.setChildren(childList);
    }

    private TreeModel getTreeModel(HashMap<String, Object> childMap) {
        TreeModel treeModel = new TreeModel();
        treeModel.setFlag(true);//表示部门
        treeModel.setId((String) childMap.get("id"));
        treeModel.setValue((String) childMap.get("value"));
        treeModel.setLabel((String) childMap.get("departmentName"));
        treeModel.setLevel((String) childMap.get("level"));
        treeModel.setParentId((String) childMap.get("parentId"));
        treeModel.setJobNumber("");
        treeModel.setMailbox("");

        List<TbManpowerEmployeeBasicInfo> employees=employeeBasicInfoMapper.selectByDepartment(treeModel.getId());
        if(!CollectionUtils.isEmpty(employees)){
            setTreeEmployeeChildren(treeModel,employees);
        }
        if (childMap.get("children") != null) {
            List<HashMap<String, Object>> childrenSub = (List<HashMap<String, Object>>) childMap.get("children");
            setTreeChildren(treeModel, childrenSub);

        }
        if(treeModel.getChildren()==null){
            treeModel.setChildren(new ArrayList<TreeModel>());
        }
        return treeModel;
    }
}
