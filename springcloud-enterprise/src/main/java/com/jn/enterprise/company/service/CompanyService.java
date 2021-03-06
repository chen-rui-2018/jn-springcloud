package com.jn.enterprise.company.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.company.model.*;
import com.jn.enterprise.company.model.CompanyUpdateParam;
import com.jn.enterprise.company.vo.CompanyContactVO;
import com.jn.enterprise.company.vo.CompanyDetailsVo;
import com.jn.enterprise.company.vo.InviteUpgradeStatusVO;
import com.jn.enterprise.model.CompanyInfoModel;
import com.jn.park.activity.model.ActivityPagingParam;
import com.jn.park.activity.model.Comment;
import com.jn.park.activity.model.CommentAddParam;
import com.jn.park.care.model.ServiceEnterpriseCompany;

import java.util.List;

/**
 * 企业信息Service
 * @author： jiangyl
 * @date： Created on 2019/3/14 16:50
 * @version： v1.0
 * @modified By:
 */
public interface CompanyService {

    /**
     * 查询企业列表
     * @param serviceCompanyParam
     * @return
     */
    PaginationData<List<ServiceCompany>> getCompanyList(ServiceCompanyParam serviceCompanyParam);

    /**
     * 查询企业列表New
     * @param serviceEnterpriseParam
     * @return
     */
    PaginationData<List<ServiceEnterpriseCompany>> getCompanyNewList(ServiceEnterpriseParam serviceEnterpriseParam,String account);


    /**
     * 根据用户账号或企业ID查询企业信息（用户为企业管理员）
     * @param account
     * @return
     */
    ServiceCompany getCompanyDetailByAccountOrId(String account);

    /**
     * 根据用户账号查询企业信息（用户为企业管理员）,携带当前登录用户
     * @param account
     * @param currentAccount
     * @return
     */
    ServiceCompany getCompanyDetailByAccountOrId(String account,String currentAccount);

    /**
     * 编辑企业信息
     * @param companyUpdateParam 企业信息入参
     * @param account 当前用户账号
     * @param phone 当前用户手机
     * @return
     */
    Integer updateCompanyInfo(CompanyUpdateParam companyUpdateParam, String account, String phone);

    /**
     * 获取评论信息
     * @param activityPagingParam
     * @return
     */
    Result<PaginationData<List<Comment>>> getCommentInfo(ActivityPagingParam activityPagingParam);

    /**
     * 保存评论
     * @param commentAddParam
     * @return
     */
    Result<Boolean> saveComment(CommentAddParam commentAddParam);

    /**
     * 获取企业详情
     * @param companyId
     * @param account
     * @return
     */
    CompanyDetailsVo  getCompanyDetails(String companyId,String account);

    /**
     * 修改企业信用分
     * @param creditUpdateParam
     * @return
     */
    Result<Boolean> updateCreditPoints(CreditUpdateParam creditUpdateParam);

    /**
     * 获取企业联系人账号
     * @param comId 企业ID
     * @return
     */
    CompanyContactVO getCompanyContactAccount(String comId);

    /**
     * 获取企业信息(关注企业列表展示)
     * @param companyId
     * @param account
     * @return
     */
    CompanyInfoModel getCompanyInfo(String companyId,String account);

    /**
     * 企业缴费成功修改企业信息
     * @param updateCompanyInfoParam
     * @return
     */
    Boolean updateCompanyInfoAfterPay(UpdateCompanyInfoParam updateCompanyInfoParam);

    /**
     * 查询当前企业信息
     * @param account
     * @return
     */
    ServiceCompany getCurCompanyInfo(String account);

    /**
     * 查询当前账号是否允许认证
     * @param account
     * @return
     */
    InviteUpgradeStatusVO getJoinParkStatus(String account);

    /**
     * 保存/修改企业信息
     * @param company
     * @return
     */
    int saveOrUpdateCompanyInfo(com.jn.enterprise.company.model.ServiceCompany company);

}
