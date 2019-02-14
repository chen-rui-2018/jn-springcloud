package com.jn.enterprise.servicemarket.org.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.model.ServiceOrg;
import com.jn.enterprise.servicemarket.model.ServiceOrgDetail;
import com.jn.enterprise.servicemarket.model.ServiceOrgParment;
import com.jn.enterprise.servicemarket.org.dao.ServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.service.ServiceOrgService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务机构
 * @author： jiangyl
 * @date： 2019/2/13 10:49
 * @version： v1.0
 * @modified By:
 */
@Service
public class ServiceOrgServiceImpl implements ServiceOrgService {

    private static Logger logger = LoggerFactory.getLogger(ServiceOrgServiceImpl.class);

    @Autowired
    private ServiceOrgMapper serviceOrgMapper;

    @ServiceLog(doAction = "查询服务机构列表")
    @Override
    public PaginationData selectServiceOrgList(ServiceOrgParment orgParment){
        Page<Object> objects = PageHelper.startPage(orgParment.getPage(), orgParment.getRows() == 0 ? 15 : orgParment.getRows());
        List<ServiceOrg> serviceOrg = serviceOrgMapper.selectServiceOrgList(orgParment);
        PaginationData data = new PaginationData(serviceOrg, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "根据机构ID查询机构详情")
    @Override
    public ServiceOrgDetail getServiceOrgDetail(String orgId){
        return serviceOrgMapper.getServiceOrgDetail(orgId);
    }

}
