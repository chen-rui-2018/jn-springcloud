package com.jn.enterprise.joinpark.usermanage.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import com.jn.enterprise.enums.JoinParkExceptionEnum;
import com.jn.enterprise.joinpark.company.dao.TbServiceCompanyMapper;
import com.jn.enterprise.joinpark.company.dao.TbServiceCompanyStaffMapper;
import com.jn.enterprise.joinpark.company.entity.TbServiceCompany;
import com.jn.enterprise.joinpark.company.entity.TbServiceCompanyCriteria;
import com.jn.enterprise.joinpark.company.entity.TbServiceCompanyStaff;
import com.jn.enterprise.joinpark.company.entity.TbServiceCompanyStaffCriteria;
import com.jn.enterprise.joinpark.usermanage.model.*;
import com.jn.enterprise.joinpark.usermanage.service.UserUpgradeService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserCompanyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/5 11:56
 * @version： v1.0
 * @modified By:
 */
@Service
public class UserUpgradeServiceImpl implements UserUpgradeService {

    private static Logger logger = LoggerFactory.getLogger(UserUpgradeServiceImpl.class);

    @Autowired
    private RedisCacheFactory redisCacheFactory;
    @Autowired
    private TbServiceCompanyMapper tbServiceCompanyMapper;
    @Autowired
    private TbServiceCompanyStaffMapper tbServiceCompanyStaffMapper;
    @Autowired
    private UserExtensionClient userExtensionClient;

    @Value(value = "${message.code.expire}")
    private int expire;

    /**
     * 短信验证码组名
     */
    private static final String USER_MESSAGE_CODE="user_message_code";

    /**
     * 数据状态 1:有效
     */
    private final static String RECORD_STATUS_VALID = "1";
    /**
     * 机构状态 0:审核中 -1:无效
     */
    private final static String COMPANY_APPLY_IS_NOT_VALID = "-1";
    private final static String COMPANY_APPLY_IS_CHECKING = "0";



    @Override
    @ServiceLog(doAction = "升级企业")
    public int changeToCompany(CompanyCheckParam companyCheckParam,String phone,String account){
        //从redis中取出短信验证码
        Cache<Object> cache = redisCacheFactory.getCache(USER_MESSAGE_CODE, expire);
        String code = (String)cache.get(phone);
        if(!StringUtils.equals(code,companyCheckParam.getCheckCode())){
            //验证码有误
            throw new JnSpringCloudException(JoinParkExceptionEnum.MESSAGE_CODE_IS_WRONG);
        }
        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andComNameEqualTo(companyCheckParam.getComName()).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID)).andCheckStatusNotEqualTo(COMPANY_APPLY_IS_NOT_VALID);
        List<TbServiceCompany> tbServiceCompanies = tbServiceCompanyMapper.selectByExample(companyCriteria);
        if(null!=tbServiceCompanies&&tbServiceCompanies.size()>0){
            //企业已存在，不能再次认证
            throw new JnSpringCloudException(JoinParkExceptionEnum.COMPANY_IS_EXIST);
        }
        TbServiceCompany serviceCompany = new TbServiceCompany();
        BeanUtils.copyProperties(companyCheckParam,serviceCompany);
        serviceCompany.setId(UUID.randomUUID().toString().replaceAll("-",""));
        serviceCompany.setComAdmin(account);
        try {
            serviceCompany.setFoundingTime(DateUtils.parseDate(companyCheckParam.getFoundingTime(),"yyyy-MM-dd"));
        }catch (ParseException e){
            throw new JnSpringCloudException(JoinParkExceptionEnum.FOUND_TIME_IS_ERROR);
        }
        try {
            serviceCompany.setRunTime(DateUtils.parseDate(companyCheckParam.getRunTime(),"yyyy-MM-dd"));
        }catch (ParseException e){
            throw new JnSpringCloudException(JoinParkExceptionEnum.RUN_TIME_IS_ERROR);
        }
        serviceCompany.setCreatorAccount(account);
        serviceCompany.setCreatedTime(new Date());
        serviceCompany.setCheckStatus(COMPANY_APPLY_IS_CHECKING);
        serviceCompany.setRecordStatus(new Byte(RECORD_STATUS_VALID));

        //TODO 调用工作流审核 jiangyl

        return tbServiceCompanyMapper.insert(serviceCompany);
    }

    @Override
    @ServiceLog(doAction = "升级企业 审核流回调")
    public Boolean changeToCompanyCallBack(CompanyCheckCallBackParam param){
        TbServiceCompany serviceCompany1 = tbServiceCompanyMapper.selectByPrimaryKey(param.getId());
        if(null == serviceCompany1){
            return false;
        }
        TbServiceCompany serviceCompany = new TbServiceCompany();
        serviceCompany.setCheckStatus(param.getStatus());
        serviceCompany.setModifierAccount(param.getCheckAccount());
        serviceCompany.setModifiedTime(new Date());
        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andIdEqualTo(param.getId());
        int i = tbServiceCompanyMapper.updateByExampleSelective(serviceCompany, companyCriteria);
        UserCompanyInfo userCompanyInfo = new UserCompanyInfo();
        userCompanyInfo.setAccount(serviceCompany1.getComAdmin());
        userCompanyInfo.setCompanyCode(serviceCompany1.getId());
        userCompanyInfo.setCompanyName(serviceCompany1.getComName());
        userExtensionClient.updateCompanyInfo(userCompanyInfo);
        return i==1?true:false;
    }

    @Override
    @ServiceLog(doAction = "升级员工")
    public int changeToStaff(StaffCheckParam staffCheckParam, String phone, String account){

        TbServiceCompanyStaffCriteria companyStaffCriteria = new TbServiceCompanyStaffCriteria();
        companyStaffCriteria.createCriteria().andAccountEqualTo(account).andCheckStatusNotEqualTo(COMPANY_APPLY_IS_NOT_VALID).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbServiceCompanyStaff> tbServiceCompanyStaffs = tbServiceCompanyStaffMapper.selectByExample(companyStaffCriteria);
        if(null !=tbServiceCompanyStaffs && tbServiceCompanyStaffs.size()>0){
            throw new JnSpringCloudException(JoinParkExceptionEnum.USER_IS_COMPANY_EXIST);
        }
        TbServiceCompanyStaff tbServiceCompanyStaff = new TbServiceCompanyStaff();
        tbServiceCompanyStaff.setId(UUID.randomUUID().toString().replaceAll("-",""));
        tbServiceCompanyStaff.setComName(staffCheckParam.getComName());
        tbServiceCompanyStaff.setComId(staffCheckParam.getComId());
        tbServiceCompanyStaff.setAccount(account);
        tbServiceCompanyStaff.setCheckStatus(COMPANY_APPLY_IS_CHECKING);
        int insert = tbServiceCompanyStaffMapper.insert(tbServiceCompanyStaff);


        //TODO 调用工作流审核 jiangyl

        return insert;
    }

    @Override
    @ServiceLog(doAction = "升级员工 审核流回调")
    public Boolean changeToStaffCallBack(StaffCheckCallBackParam staffCheckCallBackParam){
        TbServiceCompanyStaff tbServiceCompanyStaff1 = tbServiceCompanyStaffMapper.selectByPrimaryKey(staffCheckCallBackParam.getId());
        if(null == tbServiceCompanyStaff1){
            return false;
        }
        UserCompanyInfo userCompanyInfo = new UserCompanyInfo();
        userCompanyInfo.setAccount(tbServiceCompanyStaff1.getAccount());
        userCompanyInfo.setCompanyCode(tbServiceCompanyStaff1.getComId());
        userCompanyInfo.setCompanyName(tbServiceCompanyStaff1.getComName());
        userExtensionClient.updateCompanyInfo(userCompanyInfo);
        TbServiceCompanyStaff tbServiceCompanyStaff = new TbServiceCompanyStaff();
        tbServiceCompanyStaff.setId(staffCheckCallBackParam.getId());
        tbServiceCompanyStaff.setCheckStatus(staffCheckCallBackParam.getCheckStatus());
        tbServiceCompanyStaff.setCheckAccount(staffCheckCallBackParam.getCheckAccount());
        tbServiceCompanyStaff.setCheckTime(new Date());
        tbServiceCompanyStaff.setModifiedTime(new Date());
        tbServiceCompanyStaff.setModifierAccount(staffCheckCallBackParam.getCheckAccount());
        int i = tbServiceCompanyStaffMapper.updateByPrimaryKeySelective(staffCheckCallBackParam);
        return i==1?true:false;
    }

    @Override
    @ServiceLog(doAction = "查询公司列表")
    public List<Conpany> selectCompany(String comName){
        TbServiceCompanyCriteria companyCriteria = new TbServiceCompanyCriteria();
        companyCriteria.createCriteria().andComNameLike("%"+comName+"%").andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID)).andCheckStatusNotEqualTo(COMPANY_APPLY_IS_NOT_VALID);
        List<TbServiceCompany> tbServiceCompanies = tbServiceCompanyMapper.selectByExample(companyCriteria);
        List<Conpany> conpanies = new ArrayList<>(8);
        for (TbServiceCompany serviceCompany: tbServiceCompanies) {
            Conpany conpany = new Conpany();
            BeanUtils.copyProperties(serviceCompany,conpany);
            conpanies.add(conpany);
        }
        return conpanies;
    }


}
