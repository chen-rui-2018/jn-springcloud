package com.jn.enterprise.recruit.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.Assert;
import com.jn.common.util.StringUtils;
import com.jn.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.recruit.dao.ServiceRecruitMapper;
import com.jn.enterprise.recruit.dao.TbServiceRecruitMapper;
import com.jn.enterprise.recruit.entity.TbServiceRecruit;
import com.jn.enterprise.recruit.enums.RecruitExceptionEnum;
import com.jn.enterprise.recruit.model.ServiceRecruitEditParam;
import com.jn.enterprise.recruit.model.ServiceRecruitParam;
import com.jn.enterprise.recruit.model.ServiceRecruitPublishParam;
import com.jn.enterprise.recruit.service.RecruitService;
import com.jn.enterprise.recruit.vo.RecruitDetailsVO;
import com.jn.enterprise.recruit.vo.RecruitVO;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 企业招聘Service
 * @author： huxw
 * @date： Created on 2019-3-29 15:23:33
 * @version： v1.0
 * @modified By:
 */
@Service
public class RecruitServiceImpl implements RecruitService {
    private static Logger logger = LoggerFactory.getLogger(RecruitServiceImpl.class);

    @Autowired
    private TbServiceRecruitMapper tbServiceRecruitMapper;

    @Autowired
    private ServiceRecruitMapper serviceRecruitMapper;

    /**
     * 数据状态/上架 1有效
     */
    private final static String RECORD_STATUS_VALID = "1";

    @Override
    @ServiceLog(doAction = "根据招聘ID获取招聘详情")
    public RecruitDetailsVO getRecruitDetailsById(String id) {
        RecruitDetailsVO recruitDetails = serviceRecruitMapper.getRecruitDetailsById(id);
        if(null == recruitDetails) {
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_INFO_IS_NOT_EXIST);
        }
        if(1 == serviceRecruitMapper.addRecruitClickById(id)) {
            logger.info("招聘信息ID【{}】浏览量增加",id);
        }
        return recruitDetails;
    }

    @Override
    @ServiceLog(doAction = "查询企业招聘信息列表")
    public PaginationData<List<RecruitVO>> getRecruitList(ServiceRecruitParam recruitParam) {
        if(StringUtils.isEmpty(recruitParam.getStatus())) {
            recruitParam.setStatus(RECORD_STATUS_VALID);
        }

        if(StringUtils.isEmpty(recruitParam.getWhereTypes())) {
            recruitParam.setWhereTypes(recruitParam.getWhereTypes().toLowerCase());
        }

        Page<Object> objects = PageHelper.startPage(recruitParam.getPage(), recruitParam.getRows() == 0 ? 15 : recruitParam.getRows());
        List<RecruitVO> recruitList = serviceRecruitMapper.getRecruitList(recruitParam);
        PaginationData<List<RecruitVO>> data = new PaginationData(recruitList, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "发布企业招聘信息")
    public Integer publishRecruitInfo(ServiceRecruitPublishParam serviceRecruitPublishParam, String comId) {
        TbServiceRecruit sr = new TbServiceRecruit();
        BeanUtils.copyProperties(serviceRecruitPublishParam,sr);
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        sr.setCreatedTime(new Date());
        sr.setCreatorAccount(user.getAccount());
        sr.setComId(comId);
        sr.setRecordStatus(new Byte(RECORD_STATUS_VALID));
        sr.setStatus(new Byte(RECORD_STATUS_VALID));
        sr.setViewCount(0);
        sr.setId(UUID.randomUUID().toString().replaceAll("-",""));
        int i = tbServiceRecruitMapper.insertSelective(sr);

        if(1 == i) {
            logger.info("用户【{}】发布招聘成功",user.getAccount());
        }
        return i;
    }

    @Override
    @ServiceLog(doAction = "编辑/下架 企业招聘信息")
    public Integer editRecruitInfo(ServiceRecruitEditParam serviceRecruitEditParam) {
        TbServiceRecruit sr = new TbServiceRecruit();
        BeanUtils.copyProperties(serviceRecruitEditParam,sr);
        if(StringUtils.isNotBlank(serviceRecruitEditParam.getStatus())) {
            sr.setStatus(new Byte(serviceRecruitEditParam.getStatus()));
        }

        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sr.setModifierAccount(user.getAccount());
        sr.setModifiedTime(new Date());
        return tbServiceRecruitMapper.updateByPrimaryKeySelective(sr);
    }

    @Override
    @ServiceLog(doAction = "根据ID删除企业招聘条目")
    public Integer delRecruitById(String id) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return serviceRecruitMapper.delRecruitById(id, user.getAccount(), new Date());
    }

}
