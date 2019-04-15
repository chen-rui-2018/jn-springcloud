package com.jn.enterprise.company.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.company.dao.ServiceRecruitMapper;
import com.jn.enterprise.company.dao.TbServiceRecruitMapper;
import com.jn.enterprise.company.entity.TbServiceRecruit;
import com.jn.enterprise.company.entity.TbServiceRecruitCriteria;
import com.jn.enterprise.company.enums.RecruitDataTypeEnum;
import com.jn.enterprise.company.enums.RecruitExceptionEnum;
import com.jn.enterprise.company.model.*;
import com.jn.enterprise.company.service.RecruitService;
import com.jn.enterprise.company.vo.RecruitDetailsVO;
import com.jn.enterprise.company.vo.RecruitVO;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            logger.info("[招聘管理] 招聘信息浏览量增加,recruitId:{}",id);
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

        // 复合查询判断并赋值(忽略单一查询)
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
    @Transactional(rollbackFor = Exception.class)
    public Integer publishRecruitInfo(ServiceRecruitPublishParam serviceRecruitPublishParam, String comId, User user) {
        TbServiceRecruit sr = new TbServiceRecruit();
        BeanUtils.copyProperties(serviceRecruitPublishParam,sr);

        sr.setCreatedTime(new Date());
        sr.setCreatorAccount(user.getAccount());
        sr.setComId(comId);
        sr.setRecordStatus(new Byte(RECORD_STATUS_VALID));
        sr.setStatus(new Byte(RECORD_STATUS_VALID));
        sr.setViewCount(0);
        sr.setId(UUID.randomUUID().toString().replaceAll("-",""));

        Integer result = tbServiceRecruitMapper.insertSelective(sr);
        if (1 == result) {
            logger.info("[招聘管理] {}发布招聘成功",user.getAccount());
        }
        return result;
    }

    @Override
    @ServiceLog(doAction = "编辑招聘信息")
    @Transactional(rollbackFor = Exception.class)
    public Integer editRecruitInfo(ServiceRecruitEditParam serviceRecruitEditParam, User user) {
        checkRecruitExist(serviceRecruitEditParam.getId());
        TbServiceRecruit sr = new TbServiceRecruit();
        BeanUtils.copyProperties(serviceRecruitEditParam,sr);

        sr.setModifierAccount(user.getAccount());
        sr.setModifiedTime(new Date());

        Integer result = tbServiceRecruitMapper.updateByPrimaryKeySelective(sr);
        if (1 == result) {
            logger.info("[招聘管理] 修改招聘信息成功,recruitId:{}",sr.getId());
        }
        return result;
    }

    @Override
    @ServiceLog(doAction = "上/下架招聘信息")
    @Transactional(rollbackFor = Exception.class)
    public Integer underRecruit(ServiceRecruitUnderParam serviceRecruitUnderParam, User user) {
        // 过滤无效状态
        if (!serviceRecruitUnderParam.getStatus().equals(RecruitDataTypeEnum.ON_SHELVES.getCode())
                && !serviceRecruitUnderParam.getStatus().equals(RecruitDataTypeEnum.OFF_SHELVES.getCode())){
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_STATUS_ERROR);
        }

        checkRecruitExist(serviceRecruitUnderParam.getId());

        TbServiceRecruit sr = new TbServiceRecruit();
        BeanUtils.copyProperties(serviceRecruitUnderParam,sr);

        // 设置上/下架状态
        if (serviceRecruitUnderParam.getStatus().equals(RecruitDataTypeEnum.ON_SHELVES.getCode())) {
            sr.setStatus(new Byte(RecruitDataTypeEnum.OFF_SHELVES.getCode()));
        } else {
            sr.setStatus(new Byte(RecruitDataTypeEnum.ON_SHELVES.getCode()));
        }

        sr.setModifierAccount(user.getAccount());
        sr.setModifiedTime(new Date());

        Integer result = tbServiceRecruitMapper.updateByPrimaryKeySelective(sr);
        if (1 == result) {
            logger.info("[招聘管理] 上下架招聘成功,recruitId:{}",sr.getId());
        }
        return result;
    }

    @Override
    @ServiceLog(doAction = "删除招聘")
    @Transactional(rollbackFor = Exception.class)
    public Integer delRecruitById(String id, User user) {
        checkRecruitExist(id);
        Integer result = serviceRecruitMapper.delRecruitById(id, user.getAccount(), new Date());
        if (1 == result) {
            logger.info("[招聘管理] 删除招聘成功,recruitId:{}", id);
        }
        return result;
    }

    // 判断招聘ID是否存在
    public RecruitDetailsVO checkRecruitExist (String id) {
        RecruitDetailsVO recruitDetails = serviceRecruitMapper.getRecruitDetailsById(id);
        if (null == recruitDetails) {
            logger.warn("[招聘管理] 获取招聘信息失败,招聘信息不存在,recruitId:{}", id);
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_INFO_IS_NOT_EXIST);
        }
        return recruitDetails;
    }

}
