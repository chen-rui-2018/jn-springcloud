package com.jn.enterprise.recruit.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.recruit.dao.ServiceRecruitMapper;
import com.jn.enterprise.recruit.dao.TbServiceRecruitMapper;
import com.jn.enterprise.recruit.entity.TbServiceRecruit;
import com.jn.enterprise.recruit.entity.TbServiceRecruitCriteria;
import com.jn.enterprise.recruit.enums.RecruitDataTypeEnum;
import com.jn.enterprise.recruit.enums.RecruitExceptionEnum;
import com.jn.enterprise.recruit.model.*;
import com.jn.enterprise.recruit.service.RecruitService;
import com.jn.enterprise.recruit.vo.RecruitDetailsVO;
import com.jn.enterprise.recruit.vo.RecruitVO;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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
     * 数据状态 1有效
     */
    private final static String RECORD_STATUS_VALID = "1";

    @Override
    @ServiceLog(doAction = "根据招聘ID获取招聘详情")
    public RecruitDetailsVO getRecruitDetailsById(String id) {
        RecruitDetailsVO recruitDetails = checkRecruitExist(id);
        if (1 == serviceRecruitMapper.addRecruitClickById(id)) {
            logger.info("招聘信息ID【{}】浏览量增加",id);
        }
        return recruitDetails;
    }

    @Override
    @ServiceLog(doAction = "根据招聘编号获取招聘详情")
    public TbServiceRecruit getRecruitByNo(String no) {
        if(StringUtils.isEmpty(no)){
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_NO_IS_NULL);
        }
        TbServiceRecruitCriteria recruitCriteria = new TbServiceRecruitCriteria();
        recruitCriteria.createCriteria().andRecruitNoEqualTo(no);
        List<TbServiceRecruit> recruitList = tbServiceRecruitMapper.selectByExample(recruitCriteria);

        if (null == recruitList || recruitList.size() == 0) {
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_INFO_IS_NOT_EXIST);
        }
        return recruitList.get(0);
    }

    @Override
    @ServiceLog(doAction = "查询招聘信息列表")
    public PaginationData<List<RecruitVO>> getRecruitList(ServiceRecruitParam recruitParam) {
        // 过滤错误入参
        if (StringUtils.isNotEmpty(recruitParam.getWhereTypes())) {
            recruitParam.setWhereTypes(recruitParam.getWhereTypes().toLowerCase());
            if (!recruitParam.getWhereTypes().equals(RecruitDataTypeEnum.MONTH.getCode())
                    && !recruitParam.getWhereTypes().equals(RecruitDataTypeEnum.WEEK.getCode())){
                throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_WHERE_TYPE_ERROR);
            }
        }

        if (StringUtils.isNotEmpty(recruitParam.getSortTypes())) {
            recruitParam.setSortTypes(recruitParam.getSortTypes().toLowerCase());
            if (!recruitParam.getSortTypes().equals(RecruitDataTypeEnum.TIME.getCode())
                    && !recruitParam.getSortTypes().equals(RecruitDataTypeEnum.HOT.getCode())){
                throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_SORT_TYPE_ERROR);
            }
        }

        // 过滤无效状态
        if (StringUtils.isNotEmpty(recruitParam.getStatus())) {
            if (!recruitParam.getStatus().equals(RecruitDataTypeEnum.ON_SHELVES.getCode())
                    && !recruitParam.getStatus().equals(RecruitDataTypeEnum.OFF_SHELVES.getCode())
                    && !recruitParam.getStatus().equals(RecruitDataTypeEnum.ALL_SHELVES.getCode())) {
                throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_STATUS_ERROR);
            }
        } else {
            // 默认查询已上架
            recruitParam.setStatus(RecruitDataTypeEnum.ON_SHELVES.getCode());
        }

        ServiceRecruitSearchParam rp = new ServiceRecruitSearchParam();
        BeanUtils.copyProperties(recruitParam,rp);

        if (StringUtils.isNotEmpty(recruitParam.getBeginDate()) && StringUtils.isNotEmpty(recruitParam.getEndDate())) {
            try {
                rp.setBeginDate(DateUtils.parseDate(recruitParam.getBeginDate(),"yyyy-MM-dd"));
                rp.setEndDate(DateUtils.parseDate(recruitParam.getEndDate(),"yyyy-MM-dd"));
            } catch (ParseException e) {
                throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_SEARCH_DATE_FORMAT_ERROR);
            }
        }

        Page<Object> objects = PageHelper.startPage(recruitParam.getPage(), recruitParam.getRows() == 0 ? 15 : recruitParam.getRows());
        List<RecruitVO> recruitList = serviceRecruitMapper.getRecruitList(rp);
        PaginationData<List<RecruitVO>> data = new PaginationData(recruitList, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "发布招聘信息")
    public Integer publishRecruitInfo(ServiceRecruitPublishParam serviceRecruitPublishParam, String comId,User user) {
        TbServiceRecruit sr = new TbServiceRecruit();
        BeanUtils.copyProperties(serviceRecruitPublishParam,sr);

        sr.setCreatedTime(new Date());
        sr.setCreatorAccount(user.getAccount());
        sr.setComId(comId);
        sr.setRecordStatus(new Byte(RECORD_STATUS_VALID));
        sr.setStatus(new Byte(RECORD_STATUS_VALID));
        sr.setViewCount(0);
        sr.setId(UUID.randomUUID().toString().replaceAll("-",""));
        int i = tbServiceRecruitMapper.insertSelective(sr);

        if (1 == i) {
            logger.info("用户【{}】发布招聘成功",user.getAccount());
        }
        return i;
    }

    @Override
    @ServiceLog(doAction = "编辑招聘信息")
    public Integer editRecruitInfo(ServiceRecruitEditParam serviceRecruitEditParam, User user) {
        checkRecruitExist(serviceRecruitEditParam.getId());
        TbServiceRecruit sr = new TbServiceRecruit();
        BeanUtils.copyProperties(serviceRecruitEditParam,sr);

        sr.setModifierAccount(user.getAccount());
        sr.setModifiedTime(new Date());
        return tbServiceRecruitMapper.updateByPrimaryKeySelective(sr);
    }

    @Override
    @ServiceLog(doAction = "上/下架招聘信息")
    public Integer underRecruit(ServiceRecruitUnderParam serviceRecruitUnderParam, User user) {
        // 过滤无效状态
        if (!serviceRecruitUnderParam.getStatus().equals(RecruitDataTypeEnum.ON_SHELVES.getCode())
                && !serviceRecruitUnderParam.getStatus().equals(RecruitDataTypeEnum.OFF_SHELVES.getCode())){
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_STATUS_ERROR);
        }

        checkRecruitExist(serviceRecruitUnderParam.getId());

        TbServiceRecruit sr = new TbServiceRecruit();
        BeanUtils.copyProperties(serviceRecruitUnderParam,sr);

        if (serviceRecruitUnderParam.getStatus().equals(RecruitDataTypeEnum.ON_SHELVES.getCode())) {
            sr.setStatus(new Byte(RecruitDataTypeEnum.OFF_SHELVES.getCode()));
        } else {
            sr.setStatus(new Byte(RecruitDataTypeEnum.ON_SHELVES.getCode()));
        }

        sr.setModifierAccount(user.getAccount());
        sr.setModifiedTime(new Date());
        return tbServiceRecruitMapper.updateByPrimaryKeySelective(sr);
    }

    @Override
    @ServiceLog(doAction = "删除招聘")
    public Integer delRecruitById(String id, User user) {
        checkRecruitExist(id);
        return serviceRecruitMapper.delRecruitById(id, user.getAccount(), new Date());
    }

    public RecruitDetailsVO checkRecruitExist (String id) {
        RecruitDetailsVO recruitDetails = serviceRecruitMapper.getRecruitDetailsById(id);
        if (null == recruitDetails) {
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_INFO_IS_NOT_EXIST);
        }
        return recruitDetails;
    }

}
