package com.jn.enterprise.company.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.StringUtils;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.dao.StaffMapper;
import com.jn.enterprise.company.dao.TbServiceCompanyStaffMapper;
import com.jn.enterprise.company.entity.TbServiceCompanyStaff;
import com.jn.enterprise.company.entity.TbServiceCompanyStaffCriteria;
import com.jn.enterprise.company.enums.CompanyDataEnum;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.model.*;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.service.StaffService;
import com.jn.enterprise.company.vo.StaffAuditVO;
import com.jn.enterprise.company.vo.StaffListVO;
import com.jn.enterprise.company.vo.UserExtensionInfoVO;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.servicemarket.org.model.UserRoleInfo;
import com.jn.enterprise.servicemarket.org.service.OrgColleagueService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import com.jn.system.vo.SysUserRoleVO;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.SearchFiledParam;
import com.jn.user.model.UserCompanyInfo;
import com.jn.user.model.UserExtensionInfo;
import com.jn.user.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 企业员工Service
 * @author： huxw
 * @date： Created on 2019-4-9 11:10:20
 * @version： v1.0
 * @modified By:
 */
@Service
public class StaffServiceImpl implements StaffService {

    private static Logger logger = LoggerFactory.getLogger(StaffServiceImpl.class);

    @Autowired
    private TbServiceCompanyStaffMapper tbServiceCompanyStaffMapper;

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private OrgColleagueService orgColleagueService;

    @Autowired
    private CompanyService companyService;

    /**
     * 查询员工列表
     * @param staffListParam 列表查询入参
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询员工列表")
    public PaginationData getStaffList(StaffListParam staffListParam, String curAccount) {
        // 判断当前角色为企业管理员
        String comId = checkAccountIsCompanyAdmin(curAccount).getId();

        // 分页相关
        com.github.pagehelper.Page<Object> objects = null;
        boolean needPage = false;
        if(staffListParam != null && staffListParam.getNeedPage() != null && "1".equals(staffListParam.getNeedPage())) {
            needPage = true;
        }

        List<StaffListVO> dataList = new ArrayList<>(16);
        List<String> accountList = new ArrayList<>(16);
        Map<String,UserExtensionInfo> tempMap = new HashMap<>();

        // 查询所有用户表信息
        SearchFiledParam searchFiledParam = new SearchFiledParam();
        BeanUtils.copyProperties(staffListParam, searchFiledParam);
        searchFiledParam.setNeedPage("0");
        List<UserExtensionInfo> userExtensionInfoList = (List<UserExtensionInfo>) getUserExtensionInfoList(searchFiledParam, staffListParam).get("data");

        if (null != userExtensionInfoList && userExtensionInfoList.size() > 0) {
            for (UserExtensionInfo uei : userExtensionInfoList) {
                accountList.add(uei.getAccount());
                tempMap.put(uei.getAccount(), uei);
            }

            // 查询状态
            StaffListInParam staffListInParam = new StaffListInParam();
            BeanUtils.copyProperties(staffListParam,staffListInParam);
            staffListInParam.setComId(comId);
            staffListInParam.setAccountList(accountList);

            // 分页
            if (needPage) {
                objects = PageHelper.startPage(staffListInParam.getPage(), staffListInParam.getRows() == 0 ? 15 : staffListInParam.getRows(), true);
                staffListInParam.setRows(staffListInParam.getRows() == 0 ? 15 : staffListInParam.getRows());
                staffListInParam.setPage(staffListInParam.getPage());
                staffListInParam.setNeedPage(staffListInParam.getNeedPage());
            }
            List<StaffStatusList> staffStatusList = staffMapper.getStaffStatusList(staffListInParam);

            if (staffStatusList != null && !staffStatusList.isEmpty()) {
                // 组合对象
                if (staffStatusList.size() > 0) {
                    for (StaffStatusList ssl : staffStatusList) {
                        StaffListVO staff = new StaffListVO();
                        BeanUtils.copyProperties(tempMap.get(ssl.getAccount()), staff);
                        BeanUtils.copyProperties(ssl, staff);
                        dataList.add(staff);
                    }
                }
            }
        }
        return new PaginationData(dataList, objects == null ? dataList.size() : objects.getTotal());
    }

    /**
     * 查询同事列表
     * @param staffListParam 列表查询入参
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询同事列表")
    public Map<String, Object> getColleagueList(StaffListParam staffListParam, String curAccount) {
        Map<String, Object> map = new HashMap<>();

        // 企业ID
        String comId = "";

        // 如果入参企业ID不为空，则不判断权限，反之判断当前用户是否企业用户
        if (StringUtils.isNotBlank(staffListParam.getComId())) {
            comId = staffListParam.getComId();
        } else {
            // 获取当前用户扩展信息
            Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(curAccount);
            if (userExtension == null || userExtension.getData() == null) {
                throw new JnSpringCloudException(OrgExceptionEnum.USER_EXTENSION_IS_NULL);
            }
            // 判断当前用户是否为企业用户并获取企业ID
            comId = userExtension.getData().getCompanyCode();
            if (StringUtils.isBlank(comId)) {
                throw new JnSpringCloudException(CompanyExceptionEnum.USER_NO_STAFF);
            }
        }

        // 判断当前用户是否企业管理员
        String isShowFlag = "0";
        ServiceCompany company = companyService.getCompanyDetailByAccountOrId(comId);
        if (company != null && company.getComAdmin().equals(curAccount)) {
            isShowFlag = "1";
        }
        map.put("isShow", isShowFlag);

        List<StaffListVO> dataList = new ArrayList<>(16);
        List<String> accountList = new ArrayList<>(16);

        // 企业管理员对象，返回时排在第一
        StaffListVO companyAdmin = null;

        // 查询用户表员工信息
        SearchFiledParam searchFiledParam = new SearchFiledParam();
        searchFiledParam.setComId(comId);
        BeanUtils.copyProperties(staffListParam, searchFiledParam);

        Map<String, Object> maps = getUserExtensionInfoList(searchFiledParam, staffListParam);
        List<UserExtensionInfo> userExtensionInfoList = (List<UserExtensionInfo>) maps.get("data");

        if (null != userExtensionInfoList && userExtensionInfoList.size() > 0) {
            // 获取权限列表
            for (UserExtensionInfo uei : userExtensionInfoList) {
                accountList.add(uei.getAccount());
            }
            List<UserRoleInfo> userRoleList = orgColleagueService.getUserRoleInfoList(accountList, "企业");

            // 封装角色权限
            for (UserExtensionInfo uei : userExtensionInfoList) {
                StaffListVO staff = new StaffListVO();
                BeanUtils.copyProperties(uei, staff);
                staff.setStaffId(uei.getId());
                staff.setCheckTime(uei.getModifiedTime());

                staff = setRoleName(userRoleList, staff);
                if (StringUtils.isNotEmpty(staff.getRoleName()) && staff.getRoleName().equals(CompanyDataEnum.COMPANY_ADMIN.getCode())) {
                    companyAdmin = staff;
                } else {
                    dataList.add(staff);
                }
            }

            // 排序,企业管理员第一位
            if (companyAdmin != null) {
                dataList.add(0, companyAdmin);
            }

        }
        PaginationData paginationData = new PaginationData(dataList, staffListParam.getNeedPage().equals("1") ? (Integer) maps.get("total") : dataList.size());
        map.put("data", paginationData);
        return map;
    }

    /**
     * 邀请新成员列表
     * @param staffListParam 入参
     * @return
     */
    @Override
    @ServiceLog(doAction = "邀请新成员列表")
    public PaginationData getInviteStaffList(StaffListParam staffListParam, String curAccount) {
        String comId = checkAccountIsCompanyAdmin(curAccount).getId();

        // 返回数据集合
        List<UserExtensionInfoVO> dataList = new ArrayList<>(16);

        // 账号集合
        List<String> accountList = new ArrayList<>(16);

        // 企管理员账号集合
        List<String> comAdminAccountList = new ArrayList<>(5);

        // 根据企业ID查询已邀请的账号列表
        StaffListInParam staffListInParam = new StaffListInParam();
        staffListInParam.setComId(comId);
        List<StaffStatusList> staffStatusList = staffMapper.getStaffStatusList(staffListInParam);
        for (StaffStatusList usl : staffStatusList) {
            accountList.add(usl.getAccount());
        }

        // 查询所有用户表信息
        SearchFiledParam searchFiledParam = new SearchFiledParam();
        BeanUtils.copyProperties(staffListParam, searchFiledParam);
        searchFiledParam.setAccountList(accountList);
        searchFiledParam.setNeedPage("0");

        try {
            List<UserExtensionInfo> userExtensionInfoList = (List<UserExtensionInfo>) getUserExtensionInfoList(searchFiledParam, staffListParam).get("data");
            // 清空账号集合并获取权限
            accountList.clear();
            for (UserExtensionInfo uei : userExtensionInfoList) {
                accountList.add(uei.getAccount());
            }

            // 获取企业管理员账号并加入过滤
            List<UserRoleInfo> userRoleInfoList = orgColleagueService.getUserRoleInfoList(accountList, CompanyDataEnum.COMPANY_ADMIN.getCode());
            for (UserRoleInfo userRole : userRoleInfoList) {
                if (StringUtils.isNotEmpty(userRole.getRoleName())) {
                    comAdminAccountList.add(userRole.getAccount());
                }
            }

            for (UserExtensionInfo uei : userExtensionInfoList) {
                // 如果是企业管理员，不返回
                boolean isFlag = true;
                for (String companyAccount : comAdminAccountList) {
                    if (companyAccount.equals(uei.getAccount())) {
                        isFlag = false;
                        break;
                    }
                }
                if (isFlag) {
                    UserExtensionInfoVO userExtensionInfoVO = new UserExtensionInfoVO();
                    BeanUtils.copyProperties(uei, userExtensionInfoVO);
                    dataList.add(userExtensionInfoVO);
                }
            }
        } catch (JnSpringCloudException e) {
            return new PaginationData(dataList, dataList.size());
        }
        return new PaginationData(dataList, dataList.size());
    }

    /**
     * 邀请员工
     * @param accounts 受邀请账号数组
     * @return
     */
    @Override
    @ServiceLog(doAction = "邀请员工")
    @Transactional(rollbackFor = Exception.class)
    public Integer inviteStaff(String[] accounts, User user) {
        if (accounts.length == 0) {
            throw new JnSpringCloudException(CompanyExceptionEnum.ACCOUNT_LIST_IS_NULL);
        }
        // 判断用户是否为企业管理员
        ServiceCompany company = checkAccountIsCompanyAdmin(user.getAccount());

        // 公共字段
        List<TbServiceCompanyStaff> list = new ArrayList<>(accounts.length + 1);
        TbServiceCompanyStaff staff = new TbServiceCompanyStaff();
        staff.setComId(company.getId());
        staff.setComName(company.getComName());
        staff.setInviteStatus(CompanyDataEnum.STAFF_INVITE_STATUS_SEND.getCode());
        staff.setInviterAccount(user.getAccount());
        staff.setInviteTime(new Date());
        staff.setCreatedTime(new Date());
        staff.setCreatorAccount(user.getAccount());
        staff.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());

        // 组合集合
        List<String> accountList = Arrays.asList(accounts);
        for (String account : accountList) {
            TbServiceCompanyStaff tempStaff = new TbServiceCompanyStaff();
            BeanUtils.copyProperties(staff, tempStaff);
            tempStaff.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            tempStaff.setAccount(account);
            list.add(tempStaff);
        }

        // 插入数据
        Integer responseNums = staffMapper.inviteStaffs(list);
        logger.info("[企业邀请] 邀请员工成功 预计邀请:{},实际邀请:{}", accounts.length, responseNums);
        return responseNums;
    }


    /**
     * 再次邀请员工
     * @param staffId 员工ID
     * @return
     */
    @Override
    @ServiceLog(doAction = "再次邀请员工")
    @Transactional(rollbackFor = Exception.class)
    public Integer inviteStaffAgain(String staffId, String curAccount) {
        // 判断用户是否为企业管理员
        checkAccountIsCompanyAdmin(curAccount);

        TbServiceCompanyStaffCriteria staffCriteria = new TbServiceCompanyStaffCriteria();
        staffCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andInviteStatusEqualTo(CompanyDataEnum.STAFF_INVITE_STATUS_REFUSE.getCode()).andIdEqualTo(staffId);

        List<TbServiceCompanyStaff> companyStaffs = tbServiceCompanyStaffMapper.selectByExample(staffCriteria);
        if (companyStaffs == null || companyStaffs.size() == 0) {
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_NOT_INVITE_AGAIN);
        }
        TbServiceCompanyStaff companyStaff = companyStaffs.get(0);
        companyStaff.setInviteStatus(CompanyDataEnum.STAFF_INVITE_STATUS_SEND.getCode());
        int responseNums = tbServiceCompanyStaffMapper.updateByPrimaryKeySelective(companyStaff);
        logger.info("[企业邀请] 再次邀请员工成功 响应条数:{}", responseNums);
        return responseNums;
    }

    /**
     * 审核员工邀请
     * @param reviewStaffParam 入参
     * @return
     */
    @Override
    @ServiceLog(doAction = "审核员工申请")
    @Transactional(rollbackFor = Exception.class)
    public Integer reviewStaff(ReviewStaffParam reviewStaffParam, String curAccount) {
        // 判断当前角色为企业管理员
        ServiceCompany company = checkAccountIsCompanyAdmin(curAccount);

        // 核实员工身份
        TbServiceCompanyStaffCriteria staffCriteria = new TbServiceCompanyStaffCriteria();
        staffCriteria.createCriteria().andIdEqualTo(reviewStaffParam.getStaffId()).andComIdEqualTo(company.getId())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andCheckStatusEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_WAIT.getCode());

        List<TbServiceCompanyStaff> companyStaffs = tbServiceCompanyStaffMapper.selectByExample(staffCriteria);
        if (null == companyStaffs || companyStaffs.size() == 0) {
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_NO_STAFF);
        }
        TbServiceCompanyStaff companyStaff = companyStaffs.get(0);

        companyStaff.setCheckStatus(reviewStaffParam.getCheckStatus());
        companyStaff.setCheckAccount(curAccount);
        companyStaff.setModifierAccount(curAccount);
        companyStaff.setCheckTime(new Date());
        companyStaff.setModifiedTime(new Date());
        int responseNums = tbServiceCompanyStaffMapper.updateByPrimaryKeySelective(companyStaff);
        logger.info("[审核员工] 成功审核员工信息 staffId:{}, 响应条数:{}", reviewStaffParam.getStaffId(), responseNums);

        // 审核通过，增加角色，修改用户信息
        if (reviewStaffParam.getCheckStatus().equals(CompanyDataEnum.STAFF_CHECK_STATUS_PASS.getCode())) {
            List<String> addRoleIds = new ArrayList<>();
            addRoleIds.add(CompanyDataEnum.COMPANY_STAFF.getCode());
            boolean addRoleResult = updateRoleByAccount(companyStaff.getAccount(), addRoleIds, null);
            if (addRoleResult) {
                logger.info("[审核员工] {}增加角色{}成功", companyStaff.getAccount(), CompanyDataEnum.COMPANY_STAFF.getCode());
            }

            String[] accountList = new String[] {companyStaff.getAccount()};
            UserCompanyInfo userCompanyInfo = new UserCompanyInfo();
            userCompanyInfo.setAccountList(Arrays.asList(accountList));
            userCompanyInfo.setCompanyCode(company.getId());
            userCompanyInfo.setCompanyName(company.getComName());
            Result result = userExtensionClient.updateCompanyInfo(userCompanyInfo);
            checkCallServiceSuccess(result);
            logger.info("[审核员工] 更新用户扩展信息返回:{}", result.getData());
        }

        return responseNums;
    }

    /**
     * 接受企业邀请
     * @param acceptInviteParam 入参
     * @return
     */
    @Override
    @ServiceLog(doAction = "接受企业邀请")
    @Transactional(rollbackFor = Exception.class)
    public Integer acceptInvite(AcceptInviteParam acceptInviteParam) {
        TbServiceCompanyStaffCriteria staffCriteria = new TbServiceCompanyStaffCriteria();
        staffCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andInviteStatusEqualTo(CompanyDataEnum.STAFF_INVITE_STATUS_SEND.getCode())
                .andAccountEqualTo(acceptInviteParam.getAccount()).andComIdEqualTo(acceptInviteParam.getComId());

        List<TbServiceCompanyStaff> staffList = tbServiceCompanyStaffMapper.selectByExample(staffCriteria);
        if (staffList == null || staffList.size() == 0) {
            logger.warn("[企业邀请] 该账号未收到企业邀请,comId:{}", acceptInviteParam.getComId());
            throw new JnSpringCloudException(CompanyExceptionEnum.ACCOUNT_NOT_GET_INVITE);
        }
        TbServiceCompanyStaff staff = staffList.get(0);

        // 调用修改用户扩展信息服务接口
        Integer responseNums = 0;

        UserInfo userInfo = new UserInfo();
        userInfo.setAccount(staff.getAccount());
        BeanUtils.copyProperties(acceptInviteParam, userInfo);
        Result result = userExtensionClient.saveOrUpdateUserInfo(userInfo);
        checkCallServiceSuccess(result);

        // 修改信息成功之后接收邀请
        if ((Integer) result.getData() == 1) {
            TbServiceCompanyStaff tscs = new TbServiceCompanyStaff();
            tscs.setId(staff.getId());
            tscs.setInviteStatus(CompanyDataEnum.STAFF_INVITE_STATUS_AGREE.getCode());
            tscs.setCheckStatus(CompanyDataEnum.STAFF_CHECK_STATUS_WAIT.getCode());
            tscs.setInviteTime(new Date());
            tscs.setInviterAccount(staff.getAccount());
            responseNums = tbServiceCompanyStaffMapper.updateByPrimaryKeySelective(tscs);
            logger.info("[企业邀请] 接受邀请成功,staffId:{},响应条数:{}", staff.getId(), responseNums);
        } else {
            logger.info("[企业邀请] 接受企业邀请失败,修改用户信息失败");
        }
        return responseNums;
    }

    /**
     * 拒绝企业邀请
     * @param staffId 员工ID
     * @return
     */
    @Override
    @ServiceLog(doAction = "拒绝企业邀请")
    @Transactional(rollbackFor = Exception.class)
    public Integer refuseInvite(String staffId) {
        TbServiceCompanyStaff tscs = new TbServiceCompanyStaff();
        tscs.setId(staffId);
        tscs.setInviteStatus(CompanyDataEnum.STAFF_INVITE_STATUS_REFUSE.getCode());
        Integer responseNums = tbServiceCompanyStaffMapper.updateByPrimaryKeySelective(tscs);
        logger.info("[企业邀请] 拒绝邀请成功,staffId:{},响应条数:{}", staffId, responseNums);
        return responseNums;
    }

    @Override
    @ServiceLog(doAction = "获取待审核列表")
    public List<StaffAuditVO> getAuditStatus(String curAccount) {
        return staffMapper.getAuditStatus(curAccount);
    }

    /**
     * 批量删除企业成员
     * @param accountList 账号集合
     * @return
     */
    @Override
    @ServiceLog(doAction = "企业成员-批量删除成员")
    @Transactional(rollbackFor = Exception.class)
    public Integer delMoreStaffs(String[] accountList, String curAccount) {
        String comId = checkAccountIsCompanyAdmin(curAccount).getId();
        if (accountList.length == 0) {
            throw new JnSpringCloudException(CompanyExceptionEnum.ACCOUNT_LIST_IS_NULL);
        }
        logger.info("[批量删除成员] 身份验证成功,{}有权限执行批量删除操作", curAccount);

        // 逻辑删除员工表
        List<String> delStaffsList = Arrays.asList(accountList);
        TbServiceCompanyStaffCriteria staffCriteria = new TbServiceCompanyStaffCriteria();
        staffCriteria.createCriteria().andAccountIn(delStaffsList).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());

        TbServiceCompanyStaff tbServiceCompanyStaff = new TbServiceCompanyStaff();
        tbServiceCompanyStaff.setModifierAccount(curAccount);
        tbServiceCompanyStaff.setModifiedTime(new Date());
        tbServiceCompanyStaff.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        tbServiceCompanyStaff.setComId(comId);

        Integer responseNums = tbServiceCompanyStaffMapper.updateByExampleSelective(tbServiceCompanyStaff, staffCriteria);
        logger.info("[企业成员] 批量删除企业成员成功,计划删除:{},实际删除:{}", delStaffsList.size(), responseNums);


        // 修改用户扩展表信息
        UserCompanyInfo userCompanyInfo = new UserCompanyInfo();
        userCompanyInfo.setCompanyName("");
        userCompanyInfo.setCompanyCode("");
        userCompanyInfo.setAccountList(Arrays.asList(accountList));
        Result result1 = userExtensionClient.updateCompanyInfo(userCompanyInfo);
        checkCallServiceSuccess(result1);
        logger.info("[企业成员] 批量修改用户扩展信息成功,计划删除:{},实际删除:{}", delStaffsList.size(), result1.getData());


        // 删除角色
        for (String account : accountList) {
            List<String> roleLit = new ArrayList<>(2);
            roleLit.add(CompanyDataEnum.COMPANY_CONTACTS.getCode());
            roleLit.add(CompanyDataEnum.COMPANY_STAFF.getCode());
            boolean roleResult = updateRoleByAccount(account, null, roleLit);
            if (roleResult) {
                logger.info("[企业成员-批量删除] 删除{}角色信息成功", account);
            } else {
                logger.warn("[企业成员-批量删除] 删除{}角色信息失败", account);
            }
        }
        return responseNums;
    }

    /**
     * 设为/取消联系人
     * @param account 联系人账号
     * @param isSet 是否设为联系人
     * @return
     */
    @Override
    @ServiceLog(doAction = "企业同事-设为/取消联系人")
    public Integer setOrCancelContact(String account, String curAccount, boolean isSet) {
        // 判断是否为企业管理员
        String comId = checkAccountIsCompanyAdmin(curAccount).getId();
        // 判断联系人账号有效性
        checkCompanyAndStaff(account, comId);

        // 获取企业联系人角色名称
        String companyContactsRoleName = CompanyDataEnum.COMPANY_CONTACTS.getCode();

        List<String> addRoleIds = new ArrayList<>(2);
        List<String> delRoleIds = new ArrayList<>(2);

        if (isSet) {
            addRoleIds.add(companyContactsRoleName);
            delRoleIds.add(CompanyDataEnum.COMPANY_STAFF.getCode());
        } else {
            addRoleIds.add(CompanyDataEnum.COMPANY_STAFF.getCode());
            delRoleIds.add(companyContactsRoleName);
        }
        boolean setOrCancelRoleResult = updateRoleByAccount(account, addRoleIds, delRoleIds);
        if (setOrCancelRoleResult) {
            logger.info("[企业同事] " + (isSet ? "设为" : "取消") +"{}为企业联系人成功", account);
        }
        return setOrCancelRoleResult ? 1 : 0;
    }

    /**
     * 判断账号是否是当前企业员工
     * @param account 账号
     * @param comId 企业ID
     * @return
     */
    @ServiceLog(doAction = "判断账号是否是当前企业员工")
    public TbServiceCompanyStaff checkCompanyAndStaff(String account, String comId) {
        TbServiceCompanyStaffCriteria staffCriteria = new TbServiceCompanyStaffCriteria();
        staffCriteria.createCriteria().andAccountEqualTo(account).andComIdEqualTo(comId)
                .andCheckStatusEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_PASS.getCode())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbServiceCompanyStaff> staffList = tbServiceCompanyStaffMapper.selectByExample(staffCriteria);
        if (staffList == null || staffList.size() == 0) {
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_NO_STAFF);
        }
        return staffList.get(0);
    }

    /**
     * 判断调用其他服务结果
     * @param result
     * @return
     */
    @ServiceLog(doAction = "调用内部服务")
    public void checkCallServiceSuccess(Result result) {
        if (result == null || result.getData() == null) {
            logger.warn("[服务调用] 调用内部服务出现未知错误");
            throw new JnSpringCloudException(CompanyExceptionEnum.CALL_SERVICE_ERROR);
        }
    }

    /**
     * 判断当前账号是否为企业管理员并返回企业对象
     * @return
     */
    @ServiceLog(doAction = "判断当前账号是否为企业管理员并返回企业对象")
    public ServiceCompany checkAccountIsCompanyAdmin(String account) {
        ServiceCompany company = companyService.getCompanyDetailByAccountOrId(account);
        Assert.notNull(company, CompanyExceptionEnum.USER_IS_NOT_COMPANY_ADMIN.getMessage());
        return company;
    }

    /**
     * 判断当前账号是否为企业员工
     * @return
     */
    @ServiceLog(doAction = "判断当前账号是否为企业员工")
    public UserExtensionInfo getUserExtensionByAccount(String account) {
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(account);
        if (userExtension == null || userExtension.getData() == null || StringUtils.isEmpty(userExtension.getData().getCompanyCode())) {
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_NO_STAFF);
        }
        return userExtension.getData();
    }

    /**
     * 根据账号修改联系人角色
     * @param account 账号
     * @param addRoleNames 添加角色名称列表
     * @param delRoleNames 删除角色名称列表
     * @return
     */
    @ServiceLog(doAction = "根据角色名称获取角色ID")
    public boolean updateRoleByAccount(String account, List<String> addRoleNames, List<String> delRoleNames) {
        if ((addRoleNames == null || addRoleNames.isEmpty()) && (delRoleNames == null || delRoleNames.isEmpty())) {
            logger.warn("没有需要删除或增加的角色");
            return false;
        }

        Set<String> addRoleIds = new HashSet<>();
        Set<String> delRoleIds = new HashSet<>();
        SysUserRoleVO sysUserRoleVO = new SysUserRoleVO();

        if (addRoleNames != null && !addRoleNames.isEmpty()) {
            for (String role : addRoleNames) {
                Result<SysRole> addRoleResult = systemClient.getRoleByName(role);
                checkCallServiceSuccess(addRoleResult);
                String addRoleId = addRoleResult.getData().getId();
                addRoleIds.add(addRoleId);
            }
            sysUserRoleVO.setAddRoleId(addRoleIds);
        }

        if (delRoleNames != null && !delRoleNames.isEmpty()) {
            for (String role : delRoleNames) {
                Result<SysRole> delRoleResult = systemClient.getRoleByName(role);
                checkCallServiceSuccess(delRoleResult);
                String delRoleId = delRoleResult.getData().getId();
                delRoleIds.add(delRoleId);
            }
            sysUserRoleVO.setDeleRoleIds(delRoleIds);
        }

        // 需要修改的用户
        User modifyUser = new User();
        modifyUser.setAccount(account);

        // 封装入参
        sysUserRoleVO.setUser(modifyUser);
        Result<Boolean> updateRoleResult = systemClient.updateUserRole(sysUserRoleVO);
        checkCallServiceSuccess(updateRoleResult);
        return updateRoleResult.getData();
    }

    /**
     * 封装查询字段获取用户列表
     * @param searchFiledParam
     * @param staffListParam
     * @return
     */
    public Map<String, Object> getUserExtensionInfoList(SearchFiledParam searchFiledParam, StaffListParam staffListParam){
        // 判断查询是姓名还是手机 分别赋值
        if (StringUtils.isNotEmpty(staffListParam.getSearchFiled())) {
            String reg = "^\\d{11}$";
            boolean matches = Pattern.matches(reg, staffListParam.getSearchFiled());
            if (matches) {
                searchFiledParam.setPhone(staffListParam.getSearchFiled());
            } else {
                searchFiledParam.setName(staffListParam.getSearchFiled());
            }
        }

        // 批量获取用户信息
        Result userExtensionInfo = userExtensionClient.getUserExtensionBySearchFiled(searchFiledParam);
        checkCallServiceSuccess(userExtensionInfo);

        Map<String, Object> map = new HashMap<>();
        // 获取用户列表
        HashMap<String, Object> data = (HashMap<String, Object>) userExtensionInfo.getData();
        List<Object> rows = (List<Object>) data.get("rows");
        ObjectMapper objectMapper = new ObjectMapper();
        List<UserExtensionInfo> userExtensionInfoList = new ArrayList<>();
        for (Object obj : rows) {
            userExtensionInfoList.add(objectMapper.convertValue(obj, UserExtensionInfo.class));
        }
        map.put("total", data.get("total"));
        map.put("data", userExtensionInfoList);
        return map;
    }

    /**
     * 封装员工角色信息
     * @param userRoleList
     * @param staff
     * @return
     */
    public StaffListVO setRoleName(List<UserRoleInfo> userRoleList, StaffListVO staff){
        for (UserRoleInfo uri : userRoleList) {
            if (uri.getAccount().equals(staff.getAccount())) {
                staff.setRoleName(uri.getRoleName());
                break;
            }
        }
        return staff;
    }
}
