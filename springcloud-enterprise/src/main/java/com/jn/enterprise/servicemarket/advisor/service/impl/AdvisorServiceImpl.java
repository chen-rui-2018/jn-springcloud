package com.jn.enterprise.servicemarket.advisor.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.ServiceSortTypeEnum;
import com.jn.enterprise.servicemarket.advisor.dao.AdvisorMapper;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorInquiryInfo;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorListInfo;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorQueryConditions;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务顾问
 * @Author: yangph
 * @Date: 2019/2/12 16:40
 * @Version v1.0
 * @modified By:
 */
@Service
public class AdvisorServiceImpl implements AdvisorService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorServiceImpl.class);

    @Autowired
    private AdvisorMapper advisorMapper;

    /**
     * 服务顾问列表查询
     * @param advisorInquiryInfo 查询条件
     * @param needPage           是否需要分页
     * @return
     */
    @Override
    @ServiceLog(doAction = "服务顾问列表查询")
    public PaginationData getServiceConsultantList(AdvisorInquiryInfo advisorInquiryInfo, Boolean needPage) {
        com.github.pagehelper.Page<Object> objects = null;
        if(needPage){
            objects = PageHelper.startPage(advisorInquiryInfo.getPage(), advisorInquiryInfo.getRows() == 0 ? 15 : advisorInquiryInfo.getRows(), true);
        }
        AdvisorQueryConditions queryConditions=new AdvisorQueryConditions();
        BeanUtils.copyProperties(advisorInquiryInfo, queryConditions);
        if(StringUtils.isBlank(queryConditions.getSortTypes()) ){
            //默认综合排序
            queryConditions.setSortTypes(ServiceSortTypeEnum.INTEGRATE.getCode());
        }
        if(ServiceSortTypeEnum.INTEGRATE.getCode().equals(queryConditions.getSortTypes())) {
            //todo：从数据字典表获取综合排序各个因素的权重并给相应元素赋值  yangph
        }
        List<AdvisorListInfo> advisorListInfoList=advisorMapper.getServiceConsultantList(queryConditions);
        return new PaginationData(advisorListInfoList, objects == null ? 0 : objects.getTotal());
    }
}
