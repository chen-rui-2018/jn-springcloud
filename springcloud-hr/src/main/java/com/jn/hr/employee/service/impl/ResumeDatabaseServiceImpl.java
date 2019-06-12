package com.jn.hr.employee.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.common.enums.HrExceptionEnums;
import com.jn.hr.common.enums.HrStatusEnums;
import com.jn.hr.common.service.CommonService;
import com.jn.hr.common.util.DepartMentUtil;
import com.jn.hr.common.util.IDCardUtil;
import com.jn.hr.common.util.SysDictKeyValueUtil;
import com.jn.hr.common.util.ValidateUtil;
import com.jn.hr.employee.dao.ResumeDatabaseMapper;
import com.jn.hr.employee.dao.TbManpowerBackgroundInvestMapper;
import com.jn.hr.employee.dao.TbManpowerDepartmentMapper;
import com.jn.hr.employee.dao.TbManpowerResumeDatabaseMapper;
import com.jn.hr.employee.entity.*;
import com.jn.hr.employee.enums.ApplicationResultEnum;
import com.jn.hr.employee.enums.BackgroundInvestEnum;
import com.jn.hr.employee.enums.EmployeeExceptionEnums;
import com.jn.hr.employee.model.*;
import com.jn.hr.employee.service.ResumeDatabaseService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysPost;
import com.jn.system.model.User;
import com.jn.system.vo.SysDepartmentPostVO;
import com.jn.system.vo.SysDictKeyValue;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @author dt
 * @create 2019-04-15 上午 10:36
 */
@Service
public class ResumeDatabaseServiceImpl implements ResumeDatabaseService {
    private static final Logger logger = LoggerFactory.getLogger(ResumeDatabaseServiceImpl.class);
    @Autowired
    private TbManpowerResumeDatabaseMapper tbManpowerResumeDatabaseMapper;

    @Autowired
    private ResumeDatabaseMapper resumeDatabaseMapper;
    @Autowired
    private TbManpowerBackgroundInvestMapper tbManpowerBackgroundInvestMapper;
    @Autowired
    private SystemClient systemClient;
    @Autowired
    private TbManpowerDepartmentMapper tbManpowerDepartmentMapper;
    @Autowired
    private CommonService commonService;


    @Override
    @ServiceLog(doAction = "添加改简历库")
    @Transactional(rollbackFor = Exception.class)
    public void addResumeDatabase(ResumeDatabaseAdd resumeDatabaseAdd, User user) {
        TbManpowerResumeDatabase database=new TbManpowerResumeDatabase();
        BeanUtils.copyProperties(resumeDatabaseAdd,database);
        database.setId(UUID.randomUUID().toString());
        database.setIsBackgroundInvest(Byte.parseByte(BackgroundInvestEnum.NO.getCode()));
        database.setApplicationResult(Byte.parseByte(ApplicationResultEnum.WAIT.getCode()));
        database.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
        database.setCreatedTime(new Date());
        database.setCreatorAccount(user.getAccount());
        database.setModifierAccount(user.getAccount());
        database.setModifiedTime(new Date());
        tbManpowerResumeDatabaseMapper.insert(database);
        logger.info("[简历库管理] 新增简历库成功,id:{}", database.getId());
    }

    @Override
    @ServiceLog(doAction = "修改简历库")
    @Transactional(rollbackFor = Exception.class)
    public void updateResumeDatabase(ResumeDatabaseAdd resumeDatabaseAdd, User user) {
        TbManpowerResumeDatabase sDatabase=tbManpowerResumeDatabaseMapper.selectByPrimaryKey(resumeDatabaseAdd.getId());
        if(sDatabase==null){
            logger.warn("[简历库管理] 修改简历失败,修改信息不存在,id:{}", resumeDatabaseAdd.getId());
            throw new JnSpringCloudException(EmployeeExceptionEnums.ResumeDatabase_NOT_EXISTS);
        }
        TbManpowerResumeDatabase database=new TbManpowerResumeDatabase();
        BeanUtils.copyProperties(resumeDatabaseAdd,database);
        database.setId(resumeDatabaseAdd.getId());
        //database.setIsBackgroundInvest(Byte.parseByte(BackgroundInvestEnum.NO.getCode()));
        //database.setApplicationResult(Byte.parseByte(ApplicationResultEnum.WAIT.getCode()));
        database.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
        database.setModifiedTime(new Date());
        database.setModifierAccount(user.getAccount());
        tbManpowerResumeDatabaseMapper.updateByPrimaryKeySelective(database);
        logger.info("[简历库管理] 修改简历库成功,id:{}", database.getId());
    }

    @Override
    @ServiceLog(doAction = "(逻辑)删除简历库")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id, User user) {
        TbManpowerResumeDatabase database = tbManpowerResumeDatabaseMapper.selectByPrimaryKey(id);
        if (database != null) {
            //设置状态为删除状态
            database.setRecordStatus(new Byte(HrStatusEnums.DELETED.getCode()));
            //设置最新更新人及更新时间
            database.setModifiedTime(new Date());
            database.setModifierAccount(user.getAccount());
            tbManpowerResumeDatabaseMapper.updateByPrimaryKeySelective(database);
        }
        logger.info("[简历库管理] (逻辑)删除简历库成功,id:{}", id);
    }

    @Override
    @ServiceLog(doAction = "查询简历库详情")
    public ResumeDatabase getResumeDatabaseById(String id) {
        TbManpowerResumeDatabase sDatabase=tbManpowerResumeDatabaseMapper.selectByPrimaryKey(id);
        if(sDatabase==null || new Byte(HrStatusEnums.DELETED.getCode()).equals(sDatabase.getRecordStatus())){
            logger.warn("[简历库管理] 查询简历详情失败,id:{}", id);
            throw new JnSpringCloudException(EmployeeExceptionEnums.GET_ResumeDatabase_ERROR);
        }
        ResumeDatabase resumeDatabase=new ResumeDatabase();
        BeanUtils.copyProperties(sDatabase,resumeDatabase);
        if(new Byte(BackgroundInvestEnum.YES.getCode()).equals(resumeDatabase.getIsBackgroundInvest())){
            //通过背景调查，查询详情
            TbManpowerBackgroundInvest tbBackgroundInvest=tbManpowerBackgroundInvestMapper.selectByPrimaryKey(id);
            BackgroundInvest backgroundInvest=new BackgroundInvest();
            BeanUtils.copyProperties(tbBackgroundInvest,backgroundInvest);
            resumeDatabase.setBackgroundInvest(backgroundInvest);
        }
        return resumeDatabase;
    }

    @Override
    @ServiceLog(doAction = "分页查询简历库信息")
    public PaginationData<List<ResumeDatabase>> list(ResumeDatabasePage resumeDatabasePage) {
        Page<Object> objects = PageHelper.startPage(resumeDatabasePage.getPage(), resumeDatabasePage.getRows());
        List<ResumeDatabase> noticeList = resumeDatabaseMapper.list(resumeDatabasePage);
        noticeList.stream().forEach(e -> {
            byte isInvest = e.getIsBackgroundInvest();
            if (new Byte(isInvest).toString() .equals( BackgroundInvestEnum.YES.getCode())) {
                e.setIsBackgroundInvestStr("是");
            } else {
                e.setIsBackgroundInvestStr("否");
            }
            byte applicationResult = e.getApplicationResult();
            if (new Byte(applicationResult).toString() .equals( ApplicationResultEnum.PASS.getCode())) {
                e.setApplicationResultStr("通过");
            } else if (new Byte(applicationResult).toString() .equals( ApplicationResultEnum.NOT_PASS.getCode())) {
                e.setApplicationResultStr("淘汰");
            } else {
                e.setApplicationResultStr("等待结果");
            }
            String sex=e.getSex();
            if("1".equals(sex)){
                e.setSexStr("男");
            }else{
                e.setSexStr("女");
            }
        });
        PaginationData<List<ResumeDatabase>> data = new PaginationData(noticeList, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "通过简历")
    public void passResumeDatabase(String id,User user) {
        TbManpowerResumeDatabase database=new TbManpowerResumeDatabase();
        database.setId(id);
        database.setModifiedTime(new Date());
        database.setModifierAccount(user.getAccount());
        database.setApplicationResult(new Byte(ApplicationResultEnum.PASS.getCode()));
        tbManpowerResumeDatabaseMapper.updateByPrimaryKeySelective(database);
        logger.info("[简历库管理] 通过简历,id:{}", id);
    }

    @Override
    @ServiceLog(doAction = "淘汰简历")
    public void notPassResumeDatabase(String id,User user) {
        TbManpowerResumeDatabase database=new TbManpowerResumeDatabase();
        database.setId(id);
        database.setModifiedTime(new Date());
        database.setModifierAccount(user.getAccount());
        database.setApplicationResult(new Byte(ApplicationResultEnum.NOT_PASS.getCode()));
        tbManpowerResumeDatabaseMapper.updateByPrimaryKeySelective(database);
        logger.info("[简历库管理] 淘汰简历,id:{}", id);
    }

    @Override
    @ServiceLog(doAction = "完成简历背景调查")
    public void finishBackgroundInvest(BackgroundInvestAdd backgroundInvestAdd,User user) {
        tbManpowerBackgroundInvestMapper.deleteByPrimaryKey(backgroundInvestAdd.getId());
        TbManpowerBackgroundInvest record=new TbManpowerBackgroundInvest();
        backgroundInvestAdd.setInspectors(user.getName());
        backgroundInvestAdd.setInspectorsPhone(user.getPhone());
        BeanUtils.copyProperties(backgroundInvestAdd,record);
        tbManpowerBackgroundInvestMapper.insert(record);
        TbManpowerResumeDatabase database=new TbManpowerResumeDatabase();
        database.setId(backgroundInvestAdd.getId());
        database.setModifiedTime(new Date());
        database.setModifierAccount(user.getAccount());
        database.setIsBackgroundInvest(new Byte(BackgroundInvestEnum.YES.getCode()));
        tbManpowerResumeDatabaseMapper.updateByPrimaryKeySelective(database);
        logger.info("[简历库管理] 完成简历背景调查,id:{}", backgroundInvestAdd.getId());
    }

    @Override
    @ServiceLog(doAction = "导入简历库")
    public String importResumeDatabase(MultipartFile file, User user) {
        if (file.isEmpty()) {
            logger.warn("[简历库管理] 导入失败,导入文件为空");
            throw new JnSpringCloudException(EmployeeExceptionEnums.FILE_NOT_EMPTY);
        }

        //2.使用工具类,解析导入文件
        ResumeDatabase resumeDatabase = new ResumeDatabase();
        List<Object> resultList=ExcelUtil.readExcel(file, resumeDatabase, 1, 1);
        if(CollectionUtils.isEmpty(resultList)){
            return "没有数据，导入失败";
        }
        int i=0;
        StringBuffer sb=new StringBuffer();
        List<TbManpowerResumeDatabase> batchResult=new ArrayList<TbManpowerResumeDatabase>();
        Result deptResult= systemClient.selectDeptByParentId("",true);
        if(deptResult==null || !"0000".equals(deptResult.getCode()) || deptResult.getData()==null){
            throw new JnSpringCloudException(HrExceptionEnums.DEPARTMENT_QUERY_ERRPR);
        }
        Map<String,String>  departMap=DepartMentUtil.convertDepartList((List<HashMap<String, Object>>)deptResult.getData());
        Result<List<SysPost>> postResult=systemClient.getPostAll();
        if(postResult==null || !"0000".equals(postResult.getCode()) || CollectionUtils.isEmpty(postResult.getData())){
            throw new JnSpringCloudException(HrExceptionEnums.POST_QUERY_ERRPR);
        }
        List<SysPost>  postList=postResult.getData();
        List<SysDictKeyValue>  certificateTypeList= commonService.queryDictList
                ("employee","certificate_type");
        List<SysDictKeyValue>  educationList= commonService.queryDictList
                ("employee","education");
        Set<String> phoneSet=new HashSet<String>();
        Set<String> mailboxSet=new HashSet<String>();
        Set<String> certificateNumberSet=new HashSet<String>();

        Map<String,ResumeDatabase> phoneMap=new HashMap<String,ResumeDatabase>();
        Map<String,ResumeDatabase> mailboxMap=new HashMap<String,ResumeDatabase>();
        Map<String,ResumeDatabase> certificateNumberMap=new HashMap<String,ResumeDatabase>();

        List<ResumeDatabase> databaseList= resumeDatabaseMapper.list(new ResumeDatabasePage());
        databaseList.forEach(e->{
            phoneMap.put(e.getPhone(),e);
            mailboxMap.put(e.getMailbox(),e);
            certificateNumberMap.put(e.getCertificateNumber(),e);
        });
        for(Object result:resultList){
            i++;
            ResumeDatabase database= (ResumeDatabase) result;
            String str=checkImportValue(database,departMap,postList,certificateTypeList,educationList);
            if(!StringUtils.isBlank(str)){
                sb.append("第"+i+"行:"+str+";");
                continue;
            }

            if(phoneSet.contains(database.getPhone())){
                sb.append("第"+i+"行:"+database.getPhone()+"号码在当前EXCEL中重复;");
                continue;
            }
            if(phoneMap.containsKey(database.getPhone())){
                sb.append("第"+i+"行:"+database.getPhone()+"号码在简历库中已经存在记录;");
                continue;
            }
            phoneSet.add(database.getPhone());

            if(mailboxSet.contains(database.getMailbox())){
                sb.append("第"+i+"行:"+database.getMailbox()+"邮箱在当前EXCEL中重复;");
                continue;
            }
            if(mailboxMap.containsKey(database.getMailbox())){
                sb.append("第"+i+"行:"+database.getMailbox()+"邮箱在简历库中已经存在记录;");
                continue;
            }

            mailboxSet.add(database.getMailbox());
            if(certificateNumberSet.contains(database.getCertificateNumber())){
                sb.append("第"+i+"行:"+database.getCertificateNumber()+"证件号码在当前EXCEL中重复;");
                continue;
            }
            if(certificateNumberMap.containsKey(database.getCertificateNumber())){
                sb.append("第"+i+"行:"+database.getCertificateNumber()+"证件号码在简历库中已经存在记录;");
                continue;
            }
            certificateNumberSet.add(database.getCertificateNumber());

            TbManpowerResumeDatabase tbdatabase=new TbManpowerResumeDatabase();
            BeanUtils.copyProperties(database,tbdatabase);
            tbdatabase.setId(UUID.randomUUID().toString());
            tbdatabase.setIsBackgroundInvest(Byte.parseByte(BackgroundInvestEnum.NO.getCode()));
            tbdatabase.setApplicationResult(Byte.parseByte(ApplicationResultEnum.WAIT.getCode()));
            tbdatabase.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
            tbdatabase.setCreatedTime(new Date());
            tbdatabase.setCreatorAccount(user.getAccount());
            tbdatabase.setModifierAccount(user.getAccount());
            tbdatabase.setModifiedTime(new Date());
            batchResult.add(tbdatabase);

        }

        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            logger.warn("[简历库管理] 导入失败:{}",sb.toString());
            return sb.toString();
        }else{
            if(!CollectionUtils.isEmpty(batchResult)){
                resumeDatabaseMapper.insertBatch(batchResult);
                logger.info("[简历库管理] 成功导入{}条数据",batchResult.size());
            }
            return "导入成功";
        }

    }
    private String checkImportValue(ResumeDatabase database,Map<String,String> departMap,List<SysPost> postList,
                                    List<SysDictKeyValue> certificateTypeList,List<SysDictKeyValue> educationList){
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
        if(StringUtils.isBlank(database.getMailbox())){
            return "邮箱不能为空";
        }
        if(StringUtils.isBlank(database.getDepartmentName())){
            return "部门名称不能为空";
        }
        if(StringUtils.isBlank(database.getJobName())){
            return "岗位名称不能为空";
        }
        if(StringUtils.isBlank(database.getCertificateType())){
            return "证件类型不能为空";
        }
        if(StringUtils.isBlank(database.getCertificateNumber())){
            return "证件号不能为空";
        }

        if("身份证".equals(database.getCertificateType())){
            if(!IDCardUtil.validateIdCard(database.getCertificateNumber())){
                return "证件号码错误";
            }
        }else{
            if(!ValidateUtil.validCommonZjhm(database.getCertificateNumber())){
                return "证件号码错误";
            }
        }

        if(StringUtils.isBlank(database.getEducationName())){
            return "学历名称不能为空";
        }
        if(StringUtils.isBlank(database.getGraduaAcademy())){
            return "毕业院校不能为空";
        }
        if(StringUtils.isBlank(database.getGraduaAcademy())){
            return "毕业院校不能为空";
        }
        if(!ValidateUtil.isMobile(database.getPhone())){
            return "手机号码格式不正确";
        }
        if(!ValidateUtil.isEmail(database.getMailbox())){
            return "邮箱格式不正确";
        }


        database.setJobId(SysDictKeyValueUtil.getPostIdByName(postList,database.getJobName()));
        if(StringUtils.isBlank(database.getJobId())){
            return "岗位名称错误";
        }

        database.setCertificateId(SysDictKeyValueUtil.getKeyByLabel(certificateTypeList,database.getCertificateType()));

        if(StringUtils.isBlank(database.getCertificateId())){
            return "证件类型错误";
        }

        database.setEducationId(SysDictKeyValueUtil.getKeyByLabel(educationList,database.getEducationName()));

        if(StringUtils.isBlank(database.getEducationId())){
            return "学历名称错误";
        }
        database.setDepartmentId(departMap.get(database.getDepartmentName()));
        if(StringUtils.isEmpty(database.getDepartmentId())){
            return "部门名称错误";
        }
        return "";
    }

    @Override
    public boolean checkPhoneExist(String phone,String id) {
        ResumeDatabase info=resumeDatabaseMapper.selectByPhone(phone,id);
        return info==null ? true:false;
    }

    @Override
    public boolean checkMailboxExist(String mailBox,String id) {
        ResumeDatabase info=resumeDatabaseMapper.selectByMailbox(mailBox,id);
        return info==null ? true:false;
    }

    @Override
    public boolean checkCertificateNumberExist(String certificateNumber,String id) {
        ResumeDatabase info=resumeDatabaseMapper.selectByCertificateNumber(certificateNumber,id);
        return info==null ? true:false;
    }

}
