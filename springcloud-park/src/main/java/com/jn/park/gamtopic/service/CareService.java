package com.jn.park.gamtopic.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.care.model.ServiceEnterpriseCompany;
import com.jn.park.gamtopic.model.*;
import com.jn.park.gamtopic.vo.CareDetailsVo;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/15 17:35
 * @version： v1.0
 * @modified By:
 */
public interface CareService {
    /**
     * 用户添加关注操作
     * @param careId
     * @param careAddParam
     * @param currentAccount
     * @return
     */
     int addCareOperate(String careId, CareAddParam careAddParam, String currentAccount);

    /**
     * 用户取消关注操作
     * @param account
     * @param currentAccount
     * @return
     */
     int cancelCareOperate(String account,String currentAccount);

    /**
     * 关注人列表查询
     * @param page
     * @param account
     * @return
     */
     PaginationData<List<CareUserShow>> findCareList(Page page, String account);
     /**
     * f粉丝列表查询
     * @param page
     * @param account
     * @return
     */
     PaginationData<List<CareUserShow>> findFansList(Page page, String account);

    /**
     * 关注详情(目标为个人)
     * @param param
     * @param account
     * @return
     */
     CareDetailsVo findCareDetails(CareDetailsQueryParam param,String account);

    /**
     * 公司粉丝数(被关注数)
     * @param account
     * @param currentAccount 当前登录账号
     * @return
     */
    CareUserDetails findCompanyCareInfo(String account,String currentAccount);

    /**
     * 查询关注的企业
     * @param account
     * @return
     */
    List<String> findCareCompanyList(String account);

    /**
     * 企业简介
     * @param serviceEnterpriseCompany
     * @return
     */
    List<ServiceEnterpriseCompany> getCompanyNewList(List<ServiceEnterpriseCompany> serviceEnterpriseCompany,String account);
}
