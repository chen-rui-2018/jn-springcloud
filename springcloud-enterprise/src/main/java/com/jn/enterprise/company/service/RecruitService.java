package com.jn.enterprise.company.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.company.model.ServiceRecruitEditParam;
import com.jn.enterprise.company.vo.RecruitDetailsVO;
import com.jn.enterprise.company.entity.TbServiceRecruit;
import com.jn.enterprise.company.model.ServiceRecruitParam;
import com.jn.enterprise.company.model.ServiceRecruitPublishParam;
import com.jn.enterprise.company.model.ServiceRecruitUnderParam;
import com.jn.enterprise.company.vo.RecruitVO;
import com.jn.system.model.User;

import java.util.List;

/**
 * 企业招聘Service
 * @author： huxw
 * @date： Created on 2019-3-29 15:22:54
 * @version： v1.0
 * @modified By:
 */
public interface RecruitService {

    /**
     * 根据ID获取招聘详情
     * @param id
     * @return
     */
    RecruitDetailsVO getRecruitDetailsById(String id);

    /**
     * 根据编号获取招聘详情
     * @param no
     * @return
     */
    TbServiceRecruit getRecruitByNo(String no);

    /**
     * 查询企业招聘信息列表
     * @param recruitParam
     * @return
     */
    PaginationData<List<RecruitVO>> getRecruitList(ServiceRecruitParam recruitParam);

    /**
     * 发布企业招聘信息
     * @param serviceRecruitPublishParam
     * @param comId 企业ID
     * @return
     */
    Integer publishRecruitInfo(ServiceRecruitPublishParam serviceRecruitPublishParam, String comId, User user);

    /**
     * 编辑企业招聘信息
     * @param serviceRecruitEditParam
     * @return
     */
    Integer editRecruitInfo(ServiceRecruitEditParam serviceRecruitEditParam, User user);

    /**
     * 上/下架企业招聘信息
     * @param serviceRecruitUnderParam
     * @return
     */
    Integer underRecruit(ServiceRecruitUnderParam serviceRecruitUnderParam, User user);

    /**
     * 根据ID删除企业招聘信息
     * @param id
     * @return
     */
    Integer delRecruitById(String id, User user);

}
