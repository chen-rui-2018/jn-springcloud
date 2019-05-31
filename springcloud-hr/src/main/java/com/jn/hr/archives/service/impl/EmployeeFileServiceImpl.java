package com.jn.hr.archives.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.archives.dao.TbManpowerEmployeeFileClassMapper;
import com.jn.hr.archives.dao.TbManpowerEmployeeFileMapper;
import com.jn.hr.archives.dao.TbManpowerFileAttachmentMapper;
import com.jn.hr.archives.entity.TbManpowerEmployeeFile;
import com.jn.hr.archives.entity.TbManpowerEmployeeFileClass;
import com.jn.hr.archives.entity.TbManpowerEmployeeFileClassCriteria;
import com.jn.hr.archives.entity.TbManpowerFileAttachment;
import com.jn.hr.archives.model.*;
import com.jn.hr.archives.service.EmployeeFileService;
import com.jn.hr.common.enums.HrExceptionEnums;
import com.jn.hr.common.enums.HrStatusEnums;
import com.jn.hr.employee.dao.EmployeeFileClassMapper;
import com.jn.hr.employee.dao.EmployeeFileMapper;
import com.jn.hr.employee.dao.FileAttachmentMapper;
import com.jn.hr.employee.enums.EmployeeExceptionEnums;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.model.User;
import com.jn.system.vo.SysDictKeyValue;
import com.jn.upload.api.UploadClient;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.RandomStringUtils;
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

import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;

/**
 * @author dt
 * @create 2019-04-16 下午 7:08
 */
@Service
public class EmployeeFileServiceImpl implements EmployeeFileService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeFileServiceImpl.class);
    @Autowired
    private TbManpowerEmployeeFileMapper tbManpowerEmployeeFileMapper;

    @Autowired
    private EmployeeFileMapper employeeFileMapper;
    @Autowired
    private TbManpowerEmployeeFileClassMapper tbManpowerEmployeeFileClassMapper;
    @Autowired
    private TbManpowerFileAttachmentMapper tbManpowerFileAttachmentMapper;
    @Autowired
    private UploadClient uploadClient;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private EmployeeFileClassMapper employeeFileClassMapper;
    @Autowired
    private FileAttachmentMapper fileAttachmentMapper;
    @Value("${spring.application.name}")
    private String applicationName;
    public static final String prefix="NJ";

    @Autowired
    private SystemClient systemClient;

    @Override
    @ServiceLog(doAction = "添加员工档案")
    @Transactional(rollbackFor = Exception.class)
    public void addEmployeeFile(EmployeeFileAdd employeeFileAdd, User user) {
        TbManpowerEmployeeFile tbEmployeeFile=new TbManpowerEmployeeFile();
        BeanUtils.copyProperties(employeeFileAdd,tbEmployeeFile);
        long id = getFileId();
        tbEmployeeFile.setFileId(prefix+id);
        tbEmployeeFile.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
        tbEmployeeFile.setCreatedTime(new Date());
        tbEmployeeFile.setCreatorAccount(user.getAccount());
        tbEmployeeFile.setModifierAccount(user.getAccount());
        tbEmployeeFile.setModifiedTime(new Date());
        tbManpowerEmployeeFileMapper.insert(tbEmployeeFile);
        logger.info("[员工档案管理] 新增员工档案成功,id:{}", tbEmployeeFile.getFileId());
    }

    private long getFileId() {
        RedisAtomicLong counter = new RedisAtomicLong(applicationName+":"+
                "employee:"+"employeeFile:fileId",
                redisTemplate.getConnectionFactory());
        return counter.getAndAdd(1);
    }

    @Override
    @ServiceLog(doAction = "修改员工档案")
    @Transactional(rollbackFor = Exception.class)
    public void updateEmployeeFile(EmployeeFileAdd employeeFileAdd, User user) {
        TbManpowerEmployeeFile tbFile=tbManpowerEmployeeFileMapper.selectByPrimaryKey(employeeFileAdd.getFileId());
        if(tbFile==null){
            logger.warn("[员工档案管理] 修改员工档案失败,修改信息不存在,fileId:{}", employeeFileAdd.getFileId());
            throw new JnSpringCloudException(EmployeeExceptionEnums.EmployeeFile_NOT_EXISTS);
        }
        TbManpowerEmployeeFile database=new TbManpowerEmployeeFile();
        BeanUtils.copyProperties(employeeFileAdd,database);
        database.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
        database.setModifiedTime(new Date());
        database.setModifierAccount(user.getAccount());
        tbManpowerEmployeeFileMapper.updateByPrimaryKeySelective(database);
        logger.info("[员工档案管理] 修改员工档案成功,fileId:{}", database.getFileId());

    }

    @Override
    @ServiceLog(doAction = "(逻辑)删除员工档案")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id, User user) {
        TbManpowerEmployeeFile tbFile = tbManpowerEmployeeFileMapper.selectByPrimaryKey(id);
        if (tbFile != null) {
            //设置状态为删除状态
            tbFile.setRecordStatus(new Byte(HrStatusEnums.DELETED.getCode()));
            //设置最新更新人及更新时间
            tbFile.setModifiedTime(new Date());
            tbFile.setModifierAccount(user.getAccount());
            tbManpowerEmployeeFileMapper.updateByPrimaryKeySelective(tbFile);
        }
        logger.info("[员工档案管理] (逻辑)删除员工档案成功,fileId:{}", id);
    }

    @Override
    @ServiceLog(doAction = "查询员工档案详情")
    public EmployeeFile getEmployeeFileById(String id) {
        TbManpowerEmployeeFile tbFile=tbManpowerEmployeeFileMapper.selectByPrimaryKey(id);
        if(tbFile==null || new Byte(HrStatusEnums.DELETED.getCode()).equals(tbFile.getRecordStatus())){
            logger.warn("[员工档案管理] 查询员工档案详情失败,id:{}", id);
            throw new JnSpringCloudException(EmployeeExceptionEnums.EmployeeFile_NOT_EXISTS);
        }
        EmployeeFile employeeFile=new EmployeeFile();
        BeanUtils.copyProperties(tbFile,employeeFile);
        /* TbManpowerFileAttachmentCriteria example=new TbManpowerFileAttachmentCriteria();
        TbManpowerFileAttachmentCriteria.Criteria criteria=example.createCriteria();
        criteria.andFileIdEqualTo(tbFile.getFileId());
       List<TbManpowerFileAttachment> attachments=tbManpowerFileAttachmentMapper.selectByExample(example);
        List<FileAttachment>  fileAttachmentList=BeanCopyUtil.copyList(attachments, FileAttachment.class);
        employeeFile.setFileAttachmentList(fileAttachmentList);*/
        return employeeFile;
    }

    @Override
    @ServiceLog(doAction = "分页查询员工档案信息")
    public PaginationData<List<EmployeeFile>> list(EmployeeFilePage employeeFilePage) {
        Page<Object> objects = PageHelper.startPage(employeeFilePage.getPage(), employeeFilePage.getRows());
        if(!StringUtils.isEmpty(employeeFilePage.getClassId())){
            List<String> classIds=getEmployeeFileClassByParentId(employeeFilePage.getClassId());
            employeeFilePage.setClassIds(classIds);
        }
        List<EmployeeFile> noticeList = employeeFileMapper.list(employeeFilePage);
        PaginationData<List<EmployeeFile>> data = new PaginationData(noticeList, objects.getTotal());
        if(objects.getTotal()>0L){
            noticeList.forEach(e -> {
                e.setCreatedTimeStr(DateUtils.formatDate(e.getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
                EmployeeFilePage filePage=new EmployeeFilePage();
                filePage.setFileId(e.getFileId());
                List<FileAttachment> files= fileAttachmentMapper.list(filePage);
                if(!CollectionUtils.isEmpty(files)){
                    e.setAccessoryManagement("1");
                }else{
                    e.setAccessoryManagement("0");
                }
            });
        }
        return data;
    }



    private List<String> getEmployeeFileClassByParentId(String parentId) {
        List<String> rootList=new ArrayList<String>();
        if(StringUtils.isEmpty(parentId)){
            return rootList;
        }
        getTreeList(rootList,parentId);
        return rootList;
    }
    private void getTreeList(List<String> rootList,String parentId){
        rootList.add(parentId);
        TbManpowerEmployeeFileClassCriteria example=new TbManpowerEmployeeFileClassCriteria();
        TbManpowerEmployeeFileClassCriteria.Criteria criteria=example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbManpowerEmployeeFileClass> tbFileClass=tbManpowerEmployeeFileClassMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(tbFileClass)){
            for (TbManpowerEmployeeFileClass fileClass : tbFileClass) {
                getTreeList(rootList,fileClass.getClassId());
            }
        }
    }

    @Override
    @ServiceLog(doAction = "员工档案导入")
    public String importEmployeeFile(MultipartFile file, User user) {
        if (file.isEmpty()) {
            logger.warn("[员工档案管理] 导入失败,导入文件为空");
            throw new JnSpringCloudException(EmployeeExceptionEnums.FILE_NOT_EMPTY);
        }

        //2.使用工具类,解析导入文件
        EmployeeFile employeeFile = new EmployeeFile();
        List<Object> resultList= ExcelUtil.readExcel(file, employeeFile, 1, 1);
        if(CollectionUtils.isEmpty(resultList)){
            return "没有数据，导入失败";
        }
        int i=0;
        StringBuffer sb=new StringBuffer();
        List<TbManpowerEmployeeFile> batchResult=new ArrayList<TbManpowerEmployeeFile>();
        for(Object result:resultList){
            i++;
            EmployeeFile database= (EmployeeFile) result;
            String str=checkImportValue(database);
            if(!StringUtils.isBlank(str)){
                sb.append("第"+i+"行:"+str+";");
                continue;
            }

            TbManpowerEmployeeFile tbFile =new TbManpowerEmployeeFile();
            BeanUtils.copyProperties(database,tbFile);
            long id = getFileId();
            tbFile.setFileId(prefix+id);
            tbFile.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
            tbFile.setCreatedTime(new Date());
            tbFile.setCreatorAccount(user.getAccount());
            tbFile.setModifierAccount(user.getAccount());
            tbFile.setModifiedTime(new Date());
            batchResult.add(tbFile);

        }

        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            logger.warn("[员工档案管理] 导入失败:{}",sb.toString());
            return sb.toString();
        }else{
            if(!CollectionUtils.isEmpty(batchResult)){
                logger.info("[员工档案管理] 成功导入{}条数据",batchResult.size());
                employeeFileMapper.insertBatch(batchResult);
            }
            return "导入成功";
        }

    }

    private String checkImportValue(EmployeeFile database){
        if(StringUtils.isBlank(database.getNodeName())){
            return "分类名称不能为空";
        }

        if(StringUtils.isBlank(database.getSymbol())){
            return "文号不能为空";
        }
        if(StringUtils.isBlank(database.getTitleName())){
            return "题名不能为空";
        }
        if(StringUtils.isBlank(database.getRemark())){
            return "备注不能为空";
        }
        if(StringUtils.isBlank(database.getPersonLiable())){
            return "责任人不能为空";
        }
        if(StringUtils.isBlank(database.getRegDepartment())){
            return "登记部门不能为空";
        }
        //根据分类名称查询分类id
        List<EmployeeFileClass> fileCls=employeeFileClassMapper.selectByNodeName(database.getNodeName());
        if(CollectionUtils.isEmpty(fileCls)){
            return "分类名称填写错误";
        }
        Collections.sort(fileCls, new Comparator<EmployeeFileClass>() {
            @Override
            public int compare(EmployeeFileClass o1, EmployeeFileClass o2) {
                return Integer.parseInt(o2.getLevel())-Integer.parseInt(o1.getLevel());
            }
        });
        database.setClassId(fileCls.get(0).getClassId());
        return "";
    }

    /**
     * 附件批量上传
     *
     * @param files
     */
    @Override
    @ServiceLog(doAction = "员工档案附件批量上传")
    public List<FileAttachment> uploadAttachment(List<MultipartFile> files,String fileId,User user) {
        SysDictInvoke sysDictInvoke=new SysDictInvoke();
        sysDictInvoke.setGroupCode("hr_file_group");
        sysDictInvoke.setModuleCode("springcloud_hr");
        sysDictInvoke.setParentGroupCode("springcloud_hr");
        sysDictInvoke.setKey("hr_file_group_id");
        Result dictResult=systemClient.getDict(sysDictInvoke);
        String fileGroup="";
        if(dictResult!=null && "0000".equals(dictResult.getCode()) && dictResult.getData()!=null) {
            List<SysDictKeyValue> certificateTypeList = (List<SysDictKeyValue>) dictResult.getData();
            if(!CollectionUtils.isEmpty(certificateTypeList)){
                fileGroup=certificateTypeList.get(0).getLable();
            }
        }else{
            logger.error("上传文件，查询文件组失败");
            throw new JnSpringCloudException(EmployeeExceptionEnums.QUERYDICT_ERROR);
        }
        List<FileAttachment> fileAttachmentList=new ArrayList<FileAttachment>();
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                logger.warn("[员工档案管理] 附件上传失败");
                throw new JnSpringCloudException(HrExceptionEnums.FILE_IS_NULL);
            } else {
                try {
                    FileAttachment fileObj=new FileAttachment();
                    TbManpowerFileAttachment fileAttachment=new TbManpowerFileAttachment();
                    String title = file.getOriginalFilename();
                    String[] split = title.split("\\.");
                    String str = DateUtils.formatDate(new Date(), "yyyyMMdd");
                    String fileName = split[0] + str + RandomStringUtils.randomNumeric(4) + "." + split[1];
                    Result<String> result = uploadClient.uploadFile(file, false,fileGroup);
                    if(!"0000".equals(result.getCode())){
                        logger.error("档案附件上传失败,code={},message={}",result.getCode(),result.getResult());
                        throw new JnSpringCloudException(HrExceptionEnums.UPLOAD_FILE_ERRPR);
                    }
                    fileAttachment.setFileId(fileId);
                    fileAttachment.setCreateTime(new Date());
                    fileAttachment.setFileName(split[0]);
                    fileAttachment.setFilePath(result.getData());
                    fileAttachment.setFileSize(String.valueOf(file.getSize()));
                    fileAttachment.setFileType(split[1]);
                    fileAttachment.setFounder(user.getAccount());
                    fileAttachment.setId(UUID.randomUUID().toString());
                    tbManpowerFileAttachmentMapper.insert(fileAttachment);
                    BeanUtils.copyProperties(fileAttachment,fileObj);
                    fileAttachmentList.add(fileObj);
                } catch (Exception e) {
                    logger.error("员工档案附件上传失败:"+e.getMessage(),e);
                    throw new JnSpringCloudException(HrExceptionEnums.UPLOAD_FILE_ERRPR);
                }
            }
        }
        return fileAttachmentList;
    }

    @Override
    @ServiceLog(doAction = "员工档案附件删除")
    public void deleteAttachment(String id, User user) {
        TbManpowerFileAttachment tbFile=tbManpowerFileAttachmentMapper.selectByPrimaryKey(id);
        if(tbFile==null){
            logger.warn("[员工档案管理] 附件删除失败,id:{}", id);
            throw new JnSpringCloudException(EmployeeExceptionEnums.File_NOT_EXISTS);
        }
        tbManpowerFileAttachmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    @ServiceLog(doAction = "分页查询档案附件")
    public EmployeeFile getEmployeeFileAttachmentById(EmployeeFilePage employeeFilePage) {
        TbManpowerEmployeeFile tbFile=tbManpowerEmployeeFileMapper.selectByPrimaryKey(employeeFilePage.getFileId());
        if(tbFile==null || new Byte(HrStatusEnums.DELETED.getCode()).equals(tbFile.getRecordStatus())){
            logger.warn("[员工档案管理] 分页查询员工附件失败,id:{}", employeeFilePage.getFileId());
            throw new JnSpringCloudException(EmployeeExceptionEnums.EmployeeFile_NOT_EXISTS);
        }
        EmployeeFile employeeFile=new EmployeeFile();
        BeanUtils.copyProperties(tbFile,employeeFile);
        Page<Object> objects = PageHelper.startPage(employeeFilePage.getPage(), employeeFilePage.getRows());
        List<FileAttachment> noticeList = fileAttachmentMapper.list(employeeFilePage);
        PaginationData<List<FileAttachment>> files = new PaginationData(noticeList, objects.getTotal());
        employeeFile.setFileAttachmentList(files);
        return employeeFile;
    }

    @Override
    @ServiceLog(doAction = "修改员工档案附件名称")
    public void updateEmployeeFileAttachmentById(FileAttachment fileAttachment) {
        TbManpowerFileAttachment tbfileAttachment=tbManpowerFileAttachmentMapper.selectByPrimaryKey(fileAttachment.getId());
        if(tbfileAttachment==null){
            logger.warn("[员工档案管理] 附件修改失败,id:{}", fileAttachment.getId());
            throw new JnSpringCloudException(HrExceptionEnums.UPDATEDATA_NOT_EXIST);
        }
        TbManpowerFileAttachment record=new TbManpowerFileAttachment();
        record.setId(fileAttachment.getId());
        record.setFileName(fileAttachment.getFileName());
        tbManpowerFileAttachmentMapper.updateByPrimaryKeySelective(record);
    }
}
