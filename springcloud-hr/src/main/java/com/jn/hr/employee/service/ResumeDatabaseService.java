package com.jn.hr.employee.service;

import com.jn.common.model.PaginationData;
import com.jn.hr.employee.model.BackgroundInvestAdd;
import com.jn.hr.employee.model.ResumeDatabase;
import com.jn.hr.employee.model.ResumeDatabaseAdd;
import com.jn.hr.employee.model.ResumeDatabasePage;
import com.jn.system.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-15 上午 10:32
 */
public interface ResumeDatabaseService {
    //新增简历库
    public void addResumeDatabase(ResumeDatabaseAdd resumeDatabaseAdd, User user);

    //修改简历库
    public void updateResumeDatabase(ResumeDatabaseAdd resumeDatabaseAdd, User user);
    //删除简历库
    public void delete(String id, User user);

    //查询简历详情
    public ResumeDatabase getResumeDatabaseById(String id);
    //分页查询
    public PaginationData<List<ResumeDatabase>> list(ResumeDatabasePage resumeDatabasePage);
    //通过简历
    public void passResumeDatabase(String id,User user);
    //淘汰简历
    public void notPassResumeDatabase(String id,User user);
    //完成背景调查
    public void finishBackgroundInvest(BackgroundInvestAdd backgroundInvestAdd,User user);
    //导入excel
    public String importResumeDatabase(MultipartFile file,User user);

    public boolean checkPhoneExist(String phone,String id);
    public boolean checkMailboxExist(String mailBox,String id);
    public boolean checkCertificateNumberExist(String certificateNumber,String id);
}
