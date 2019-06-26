package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.servicemarket.advisor.controller.AdvisorApproveController;
import com.jn.enterprise.servicemarket.advisor.model.OrgInfoShow;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorApproveService;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrg;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import com.jn.enterprise.utils.IBPSFileUtils;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/4/9 9:52
 * @Version v1.0
 * @modified By:
 */
@Service
public class AdvisorApproveServiceImpl implements AdvisorApproveService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorApproveController.class);

    /**
     * 业务领域：科技金融
     */
    private static final String TECHNOLOGY_FINANCE="technology_finance";


    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;

    /**
     * 选择机构
     * @param orgName 机构名称
     * @return
     */
    @ServiceLog(doAction = "选择机构")
    @Override
    public List<OrgInfoShow> selectOrgInfo(String orgName) {
        TbServiceOrgCriteria example=new TbServiceOrgCriteria();
        if(StringUtils.isBlank(orgName)){
            //orgStatus:状态(0未审核[审核中]1审核通过2审核不通过)  机构名称为空查询全部
            example.createCriteria().andOrgStatusEqualTo("1").andBusinessTypeNotEqualTo(TECHNOLOGY_FINANCE)
                    .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        }else{
            //orgStatus:状态(0未审核[审核中]1审核通过2审核不通过)
            example.createCriteria().andOrgNameLike("%"+orgName+"%").andOrgStatusEqualTo("1")
                    .andBusinessTypeNotEqualTo(TECHNOLOGY_FINANCE).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        }
        List<TbServiceOrg> tbServiceOrgList = tbServiceOrgMapper.selectByExample(example);
        if(tbServiceOrgList.isEmpty()){
            return null;
        }
        List<OrgInfoShow> resultList=new ArrayList<>(16);
        for(TbServiceOrg tbServiceOrg:tbServiceOrgList){
            OrgInfoShow orgInfoShow=new OrgInfoShow();
            orgInfoShow.setOrgId(tbServiceOrg.getOrgId());
            orgInfoShow.setOrgName(tbServiceOrg.getOrgName());
            orgInfoShow.setBusinessArea(tbServiceOrg.getBusinessType());
            if(StringUtils.isNotBlank(tbServiceOrg.getOrgLogo())){
                orgInfoShow.setOrgLog(IBPSFileUtils.getFilePath(tbServiceOrg.getOrgLogo()));
            }
            resultList.add(orgInfoShow);
        }
        return resultList;
    }
}
