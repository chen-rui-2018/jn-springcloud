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
import com.jn.enterprise.company.enums.RecruitExceptionEnum;
import com.jn.enterprise.company.model.*;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.service.StaffService;
import com.jn.enterprise.company.vo.ColleagueListVO;
import com.jn.enterprise.company.vo.StaffAuditVO;
import com.jn.enterprise.company.vo.StaffListVO;
import com.jn.enterprise.company.vo.UserExtensionInfoVO;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.servicemarket.org.model.UserRoleInfo;
import com.jn.enterprise.servicemarket.org.service.OrgColleagueService;
import com.jn.park.api.MessageClient;
import com.jn.park.message.model.AddMessageModel;
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

    @Autowired
    private MessageClient messageClient;

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
    public ColleagueListVO getColleagueList(StaffListParam staffListParam, String curAccount) {
        ColleagueListVO colleagueListVO = new ColleagueListVO();

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
        colleagueListVO.setIsShow(isShowFlag);

        List<StaffListVO> dataList = new ArrayList<>(16);
        List<String> accountList = new ArrayList<>(16);

        // 企业管理员对象，返回时排在第一
        StaffListVO companyAdmin = null;

        // 查询用户表员工信息
        SearchFiledParam searchFiledParam = new SearchFiledParam();
        BeanUtils.copyProperties(staffListParam, searchFiledParam);
        searchFiledParam.setComId(comId);

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
        colleagueListVO.setData(paginationData);
        return colleagueListVO;
    }

    /**
     * 根据手机号或账号查询用户信息
     * @param phone 手机号或账号
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据手机号或账号查询用户信息")
    public UserExtensionInfoVO getInviteStaffList(String phone) {
        if (StringUtils.isBlank(phone)) {
            throw new JnSpringCloudException(CompanyExceptionEnum.PARAM_IS_NULL);
        }

        Result result = userExtensionClient.getUserExtension(phone);
        UserExtensionInfoVO userExtensionInfoVO = new UserExtensionInfoVO();
        if (result == null || result.getData() == null) {
            logger.warn("[根据手机号或账号查询用户信息] 用户不存在，phone:{}", phone);
            return null;
        }
        UserExtensionInfo userExtensionInfo = (UserExtensionInfo) result.getData();
        BeanUtils.copyProperties(userExtensionInfo, userExtensionInfoVO);
        return userExtensionInfoVO;
    }

    /**
     * 邀请员工
     * @param inviteAccount 受邀请账号
     * @param curAccount 当前账号
     * @return
     */
    @Override
    @ServiceLog(doAction = "邀请员工")
    @Transactional(rollbackFor = Exception.class)
    public Integer inviteStaff(String inviteAccount, String curAccount) {
        if (StringUtils.isBlank(inviteAccount)) {
            throw new JnSpringCloudException(CompanyExceptionEnum.PARAM_IS_NULL);
        }
        // 判断当前用户为企业管理员
        ServiceCompany company = checkAccountIsCompanyAdmin(curAccount);

        // 判断邀请账号不是企业管理员
        List<String> accountList = new ArrayList<>();
        accountList.add(inviteAccount);
        List<UserRoleInfo> userRoleInfoList = orgColleagueService.getUserRoleInfoList(accountList, CompanyDataEnum.COMPANY_ADMIN.getCode());
        for (UserRoleInfo userRole : userRoleInfoList) {
            if (StringUtils.isNotEmpty(userRole.getRoleName()) && userRole.getAccount().equals(inviteAccount)) {
                throw new JnSpringCloudException(CompanyExceptionEnum.USER_IS_COMPANY_ADMIN);
            }
        }

        // 判断邀请账号不是企业员工
        TbServiceCompanyStaffCriteria staffCriteria = new TbServiceCompanyStaffCriteria();
        TbServiceCompanyStaffCriteria companyStaffCriteria = new TbServiceCompanyStaffCriteria();
        TbServiceCompanyStaffCriteria.Criteria criteria = companyStaffCriteria.createCriteria();

        staffCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andCheckStatusNotEqualTo(CompanyDataEnum.STAFF_CHECK_STATUS_NOT_PASS.getCode())
                .andInviteStatusNotEqualTo(CompanyDataEnum.STAFF_INVITE_STATUS_REFUSE.getCode())
                .andAccountEqualTo(inviteAccount);

        criteria.andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue()).andAccountEqualTo(inviteAccount)
                .andInviteStatusNotEqualTo(CompanyDataEnum.STAFF_INVITE_STATUS_REFUSE.getCode())
                .andCheckStatusIsNull();
        staffCriteria.or(criteria);

        List<TbServiceCompanyStaff> staffList = tbServiceCompanyStaffMapper.selectByExample(staffCriteria);
        if(staffList != null && !staffList.isEmpty()) {
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_IS_COMPANY_EXIST);
        }

        // 封装数据
        TbServiceCompanyStaff staff = new TbServiceCompanyStaff();
        staff.setComId(company.getId());
        staff.setComName(company.getComName());
        staff.setInviteStatus(CompanyDataEnum.STAFF_INVITE_STATUS_SEND.getCode());
        staff.setInviterAccount(curAccount);
        staff.setInviteTime(new Date());
        staff.setCreatedTime(new Date());
        staff.setCreatorAccount(curAccount);
        staff.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        staff.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        staff.setAccount(inviteAccount);

        // 插入数据
        Integer responseNums = tbServiceCompanyStaffMapper.insertSelective(staff);
        if (responseNums == 1) {
            AddMessageModel addMessageModel = new AddMessageModel();
            addMessageModel.setCreatorAccount(curAccount);
            addMessageModel.setMessageSender(curAccount);
            addMessageModel.setMessageRecipien(inviteAccount);
            addMessageModel.setMessageOneSort(1);
            addMessageModel.setMessageTowSort(8);
            addMessageModel.setMessageConnect("comId=" + company.getId() + "&comName=" + company.getComName());
            addMessageModel.setMessageConnectName("企业邀请");
            addMessageModel.setMessageTitle("企业邀请待处理通知");
            addMessageModel.setMessageContent(company.getComName());
            messageClient.addMessage(addMessageModel);

            logger.info("[企业邀请] 邀请员工成功,account:{}", inviteAccount);
        }
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
            if (result == null || result.getData() == null) {
                logger.warn("[审核员工] 更新用户信息发生错误");
                throw new JnSpringCloudException(CompanyExceptionEnum.UPDATE_USER_EXTENSION_INFO_ERROR);
            }
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
        if (result == null || result.getData() == null) {
            logger.warn("[接受企业邀请] 更新用户扩展信息错误");
            return responseNums;
        }

        // 修改信息成功之后接收邀请
        if ((Integer) result.getData() == 1) {
            TbServiceCompanyStaff tbServiceCompanyStaff = new TbServiceCompanyStaff();
            tbServiceCompanyStaff.setId(staff.getId());
            tbServiceCompanyStaff.setInviteStatus(CompanyDataEnum.STAFF_INVITE_STATUS_AGREE.getCode());
            tbServiceCompanyStaff.setCheckStatus(CompanyDataEnum.STAFF_CHECK_STATUS_WAIT.getCode());
            tbServiceCompanyStaff.setInviteTime(new Date());
            tbServiceCompanyStaff.setInviterAccount(staff.getAccount());
            responseNums = tbServiceCompanyStaffMapper.updateByPrimaryKeySelective(tbServiceCompanyStaff);
            logger.info("[企业邀请] 接受邀请成功,staffId:{},响应条数:{}", staff.getId(), responseNums);
        } else {
            logger.info("[企业邀请] 接受企业邀请失败,修改用户信息失败");
        }
        return responseNums;
    }

    /**
     * 拒绝企业邀请
     * @param comId 企业ID
     * @param account 账号
     * @return
     */
    @Override
    @ServiceLog(doAction = "拒绝企业邀请")
    @Transactional(rollbackFor = Exception.class)
    public Integer refuseInvite(String comId, String account) {
        TbServiceCompanyStaffCriteria staffCriteria = new TbServiceCompanyStaffCriteria();
        staffCriteria.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andInviteStatusEqualTo(CompanyDataEnum.STAFF_INVITE_STATUS_SEND.getCode())
                .andAccountEqualTo(account).andComIdEqualTo(comId);

        List<TbServiceCompanyStaff> staffList = tbServiceCompanyStaffMapper.selectByExample(staffCriteria);
        if (staffList == null || staffList.size() == 0) {
            logger.warn("[企业邀请] 该账号未收到企业邀请,企业ID:{}", comId);
            throw new JnSpringCloudException(CompanyExceptionEnum.ACCOUNT_NOT_GET_INVITE);
        }

        TbServiceCompanyStaff staff = staffList.get(0);
        staff.setInviteStatus(CompanyDataEnum.STAFF_INVITE_STATUS_REFUSE.getCode());
        int responseNums = tbServiceCompanyStaffMapper.updateByPrimaryKeySelective(staff);

        logger.info("[企业邀请] 拒绝邀请成功,account:{},响应条数:{}", account, responseNums);
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
        if (result1 == null || result1.getData() == null) {
            logger.warn("[企业成员] 更新用户扩展信息错误");
            throw new JnSpringCloudException(CompanyExceptionEnum.UPDATE_USER_EXTENSION_INFO_ERROR);
        }
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
//        String comId = checkAccountIsCompanyAdmin(curAccount).getId();
        String comId = checkCompanyUser(curAccount).getCompanyCode();
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
            logger.warn("[服务调用] 调用system服务出现未知错误");
            throw new JnSpringCloudException(CompanyExceptionEnum.CALL_SYSTEM_SERVICE_ERROR);
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

        Map<String, Object> map = new HashMap<>();

        // 批量获取用户信息
        Result userExtensionInfo = userExtensionClient.getUserExtensionBySearchFiled(searchFiledParam);
        if (userExtensionInfo == null || userExtensionInfo.getData() == null) {
            logger.warn("[封装查询字段获取用户列表] 批量获取用户信息失败");
        } else {
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
        }
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

    /**
     * 判断账号是否企业账号
     * @param account
     * @return
     */
    public UserExtensionInfo checkCompanyUser (String account) {
        Result<UserExtensionInfo> result = userExtensionClient.getUserExtension(account);
        if (result == null || result.getData() == null) {
            throw new JnSpringCloudException(CompanyExceptionEnum.GET_USER_EXTENSION_INFO_ERROR);
        }
        UserExtensionInfo userExtensionInfo = result.getData();
        if (StringUtils.isBlank(userExtensionInfo.getCompanyCode()) || StringUtils.isBlank(userExtensionInfo.getCompanyName())) {
            throw new JnSpringCloudException(RecruitExceptionEnum.RECRUIT_USER_NOT_COMPANY_USER);
        }
        return userExtensionInfo;
    }
}
