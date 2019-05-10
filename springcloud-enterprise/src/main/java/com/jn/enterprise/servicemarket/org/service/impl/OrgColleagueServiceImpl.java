package com.jn.enterprise.servicemarket.org.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.dao.TbServiceAdvisorMapper;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisor;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceAdvisorCriteria;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrg;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import com.jn.enterprise.servicemarket.org.model.OrgColleagueInfo;
import com.jn.enterprise.servicemarket.org.model.OrgColleagueParam;
import com.jn.enterprise.servicemarket.org.model.UserRoleInfo;
import com.jn.enterprise.servicemarket.org.service.OrgColleagueService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import com.jn.system.vo.SysGroupVO;
import com.jn.system.vo.SysUserRoleVO;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.AffiliateParam;
import com.jn.user.model.UserAffiliateInfo;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 机构同事
 * @Author: yangph
 * @Date: 2019/2/26 10:12
 * @Version v1.0
 * @modified By:
 */
@Service
public class OrgColleagueServiceImpl implements OrgColleagueService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(OrgColleagueServiceImpl.class);

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private TbServiceAdvisorMapper tbServiceAdvisorMapper;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;

    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     * 是否删除 0：删除  1：有效
     */
    private static final byte RECORD_STATUS=1;

    /**
     * 机构同事列表查询
     * @param account  当前登录用户账号
     * @param orgColleagueParam 机构同事列表查询入参（是否分页）
     * @return
     */
    @ServiceLog(doAction = "机构同事列表查询")
    @Override
    public PaginationData getOrgColleagueList(String account, OrgColleagueParam orgColleagueParam) {
        //根据用户账号获取用户所属机构编码
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(account);
        if(userExtension==null || userExtension.getData()==null){
            throw new JnSpringCloudException(OrgExceptionEnum.USER_EXTENSION_IS_NULL);
        }
        String affiliateCode = userExtension.getData().getAffiliateCode();
        if(StringUtils.isBlank(affiliateCode)){
            throw new JnSpringCloudException(OrgExceptionEnum.NON_OGR_USER);
        }
        //所属机构入参
        AffiliateParam affiliateParam=new AffiliateParam();
        affiliateParam.setAffiliateCode(affiliateCode);
        com.github.pagehelper.Page<Object> objects = null;
        //分页标识
        String isPage="1";
        //是否分页标识
        boolean needPage=false;
        if(orgColleagueParam != null && orgColleagueParam.getNeedPage()!=null
                && isPage.equals(orgColleagueParam.getNeedPage())){
            needPage=true;
        }
        if(needPage) {
            objects = PageHelper.startPage(orgColleagueParam.getPage(),
                    orgColleagueParam.getRows() == 0 ? 15 : orgColleagueParam.getRows(), true);
            affiliateParam.setPage(orgColleagueParam.getPage());
            affiliateParam.setRows(orgColleagueParam.getRows() == 0 ? 15 : orgColleagueParam.getRows());
            affiliateParam.setNeedPage(orgColleagueParam.getNeedPage());
        }
        //跨服务根据所属机构编码批量获取用户信息
        Result userExtensionByAffiliateCode = userExtensionClient.getUserExtensionByAffiliateCode(affiliateParam);
        logger.info("---根据所属机构编码批量获取用户信息成功---");
        if(userExtensionByAffiliateCode==null || userExtensionByAffiliateCode.getData()==null){
            return new PaginationData(userExtension.getData(), objects == null ? 0 : objects.getTotal());
        }
        //得到查询出的用户信息
        Map<String,Object> pageData = (Map<String,Object>)userExtensionByAffiliateCode.getData();
        List<UserExtensionInfo> userExtensionInfoList=new ArrayList<>(16);
        List userList=(List)pageData.get("rows");
        Integer total=(Integer) pageData.get("total");
        ObjectMapper objectMapper = new ObjectMapper();
        for(int i=0;i<userList.size();i++){
            UserExtensionInfo userExtensionInfo = objectMapper.convertValue(userList.get(i), UserExtensionInfo.class);
            userExtensionInfoList.add(userExtensionInfo);
        }
        //取出查询出的所有账号
        List<String>accountList=new ArrayList<>(16);
        for(UserExtensionInfo userExtensionInfo:userExtensionInfoList){
            accountList.add(userExtensionInfo.getAccount());
        }
        //通过用户账号获取用户信息,传多账号,返回多个用户信息
        String roleName="机构";
        List<UserRoleInfo> userRoleInfoList = getUserRoleInfoList(accountList,roleName);
        logger.info("---获取用户角色信息成功---");
        //从顾问信息表获取用户毕业学校，担任职务，入驻时间
        List<TbServiceAdvisor> tbServiceAdvisorList = getTbServiceAdvisorList(accountList);
        List<OrgColleagueInfo> orgColleagueInfoList=new ArrayList<>();
        for(UserExtensionInfo extensionInfo:userExtensionInfoList){
            OrgColleagueInfo orgColleagueInfo=new OrgColleagueInfo();
            BeanUtils.copyProperties(extensionInfo, orgColleagueInfo);
            //遍历机构身份表，设置用户机构身份，
            setUserRoleName(userRoleInfoList, extensionInfo, orgColleagueInfo);
            //设置用户教育信息（毕业学校，担任职务，入驻时间）
            setUserEducationInfo(tbServiceAdvisorList, extensionInfo, orgColleagueInfo);
            orgColleagueInfoList.add(orgColleagueInfo);
        }
        return new PaginationData(orgColleagueInfoList,total==null ? 0 :total.intValue());
    }

    /**
     * 设置用户教育信息（毕业学校，担任职务，入驻时间）
     * @param tbServiceAdvisorList
     * @param extensionInfo
     * @param orgColleagueInfo
     */
    @ServiceLog(doAction = "设置用户教育信息")
    private void setUserEducationInfo(List<TbServiceAdvisor> tbServiceAdvisorList, UserExtensionInfo extensionInfo, OrgColleagueInfo orgColleagueInfo) {
        for(TbServiceAdvisor tbServiceAdvisor:tbServiceAdvisorList){
            //账号相同,设置毕业学校，担任职务，入驻日期
            if(StringUtils.equals(extensionInfo.getAccount(),tbServiceAdvisor.getAdvisorAccount() )){
                //毕业学校
                orgColleagueInfo.setGraduatedSchool(tbServiceAdvisor.getGraduatedSchool());
                //担任职务
                orgColleagueInfo.setPosition(tbServiceAdvisor.getPosition());
                //入驻日期
                if(tbServiceAdvisor.getCreatedTime()!=null){
                    orgColleagueInfo.setEntryDate(DateUtils.formatDate(tbServiceAdvisor.getCreatedTime(), PATTERN));
                }else{
                    orgColleagueInfo.setEntryDate(DateUtils.formatDate(extensionInfo.getCreatedTime(), PATTERN));
                }
                break;
            }
        }
    }

    /**
     * 设置用户的角色名称
     * @param userRoleInfoList
     * @param extensionInfo
     * @param orgColleagueInfo
     */
    @ServiceLog(doAction = "设置用户的角色名称")
    private void setUserRoleName(List<UserRoleInfo> userRoleInfoList, UserExtensionInfo extensionInfo, OrgColleagueInfo orgColleagueInfo) {
        for(UserRoleInfo userRoleInfo: userRoleInfoList){
            if(extensionInfo.getAccount().equals(userRoleInfo.getAccount())){
                orgColleagueInfo.setOrgIdentity(userRoleInfo.getRoleName());
                String orgMangeRole="机构管理员";
                //判断是否为机构管理员，若是从机构表获取入驻日期
                if(orgMangeRole.equals(userRoleInfo.getRoleName())){
                    //用户基本信息（手机，邮箱，职位，学历，毕业学校）
                    Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(userRoleInfo.getAccount());
                    UserExtensionInfo userInfo = userExtension.getData();
                    BeanUtils.copyProperties(userInfo, orgColleagueInfo);
                    String entryDate = getOrgManageEntryTime(userRoleInfo.getAccount());
                    orgColleagueInfo.setEntryDate(entryDate);
                }
                break;
            }
        }
    }

    /**
     * 根据账号从顾问信息表获取用户信息
     * @param accountList
     * @return
     */
    private List<TbServiceAdvisor> getTbServiceAdvisorList(List<String> accountList) {
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountIn(accountList).andRecordStatusEqualTo(RECORD_STATUS);
        return tbServiceAdvisorMapper.selectByExample(example);
    }

    /**
     * 获取机构管理员入驻日期
     * @param account  机构管理员账号
     * @return
     */
    @ServiceLog(doAction = "获取机构管理员入驻日期")
    private String getOrgManageEntryTime(String account) {
        TbServiceOrgCriteria example=new TbServiceOrgCriteria();
        example.createCriteria().andOrgAccountEqualTo(account).andOrgStatusEqualTo("1")
                .andRecordStatusEqualTo(RECORD_STATUS);
        List<TbServiceOrg> tbServiceOrgList = tbServiceOrgMapper.selectByExample(example);
        if(tbServiceOrgList.isEmpty()){
            return null;
        }
        return DateUtils.formatDate(tbServiceOrgList.get(0).getCreatedTime(), PATTERN);
    }

    /**
     * 根据指定角色获取用户的角色信息（角色id,角色名称，角色所属用户组id,角色所属用户组名称）
     * @param accountList 账号集合
     * @param roleName    指定角色名称（可以是部分名称）
     * @return
     */
    @ServiceLog(doAction = "据指定角色获取用户的角色信息")
    @Override
    public List<UserRoleInfo> getUserRoleInfoList(List<String> accountList,String roleName) {
        Result<List<User>> resultData = systemClient.getUserInfoByAccount(accountList);
        List<User> userInfoList = resultData.getData()==null?Collections.EMPTY_LIST:resultData.getData();
        List<UserRoleInfo> userRoleInfoList=new ArrayList<>(16);
        for(User user:userInfoList){
            UserRoleInfo userRoleInfo=new UserRoleInfo();
            userRoleInfo.setAccount(user.getAccount());
            for(SysRole sysRole:user.getSysRole()){
                if(sysRole.getRoleName().contains(roleName)){
                    userRoleInfo.setRoleId(sysRole.getId());
                    userRoleInfo.setRoleName(sysRole.getRoleName());
                    break;
                }
            }
            //是否结束循环标志
            boolean flag=false;
            for(SysGroupVO sysGroupVO:user.getSysGroupVO()){
                for(SysRole sysRole:sysGroupVO.getSysRoleList()){
                    if(sysRole.getRoleName().contains(roleName)){
                        userRoleInfo.setGroupId(sysGroupVO.getId());
                        userRoleInfo.setGroupName(sysGroupVO.getGroupName());
                        flag=true;
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }
            userRoleInfoList.add(userRoleInfo);
        }
        return userRoleInfoList;
    }

    /**
     * 设置为联系人
     * @param loginAccount  当前登录用户
     * @param account 设置为联系人的账号
     * @return
     */
    @ServiceLog(doAction = "设置为联系人")
    @Override
    public int setAsContact(String loginAccount,String account) {
        //判断当前登录用户角色是否为机构管理员
        judgeRoleIsOrgManage(loginAccount);
        List<String> accountList =new ArrayList<>(16);
        accountList.add(account);
        String roleName="机构顾问";
        List<UserRoleInfo> userRoleInfoList = getUserRoleInfoList(accountList, roleName);
        if(userRoleInfoList.isEmpty() || !roleName.equals(userRoleInfoList.get(0).getRoleName())){
            logger.warn("设置为联系人的账号：[{}]，不是机构顾问",account);
            throw new JnSpringCloudException(OrgExceptionEnum.ACCOUNT_NOT_ORG_ADVISOR);
        }
        //获取机构联系人角色id
        roleName="机构联系人";
        Result<SysRole> sysRoleData = systemClient.getRoleByName(roleName);
        if(sysRoleData==null || sysRoleData.getData()==null){
            logger.warn("设置为联系人,获取机构联系人角色id失败");
            throw new JnSpringCloudException(OrgExceptionEnum.NETWORK_ANOMALY);
        }
        Boolean isSuccess = updateOrgUserRole(account, userRoleInfoList.get(0).getRoleId(), sysRoleData.getData().getId());
        //成功返回1，失败返回0
        return isSuccess?1:0;
    }

    /**
     * 取消联系人
     * @param loginAccount 当前登录用户
     * @param account 取消联系人的账号
     * @return
     */
    @ServiceLog(doAction = "取消联系人")
    @Override
    public int cancelAsContact(String loginAccount,String account) {
        //判断当前登录用户角色是否为机构管理员
        judgeRoleIsOrgManage(loginAccount);
        List<String> accountList =new ArrayList<>(16);
        accountList.add(account);
        String roleName="机构联系人";
        List<UserRoleInfo> userRoleInfoList = getUserRoleInfoList(accountList, roleName);
        if(userRoleInfoList.isEmpty() || !roleName.equals(userRoleInfoList.get(0).getRoleName())){
            logger.warn("取消联系人的账号：[{}]，不是机构联系人",account);
            throw new JnSpringCloudException(OrgExceptionEnum.ACCOUNT_NOT_ORG_CONTACT);
        }
        //获取机构顾问角色id
        roleName="机构顾问";
        Result<SysRole> sysRoleData = systemClient.getRoleByName(roleName);
        if(sysRoleData==null || sysRoleData.getData()==null){
            logger.warn("取消联系人,获取机构顾问角色id失败");
            throw new JnSpringCloudException(OrgExceptionEnum.NETWORK_ANOMALY);
        }
        Boolean isSuccess = updateOrgUserRole(account, userRoleInfoList.get(0).getRoleId(), sysRoleData.getData().getId());
        //成功返回1，失败返回0
        return isSuccess?1:0;
    }


    /**
     * 判断当前登录用户角色是否为机构管理员
     * @param loginAccount
     * @return
     */
    @ServiceLog(doAction = "判断当前登录用户角色是否为机构管理员")
    private void judgeRoleIsOrgManage(String loginAccount) {
        List<String> accountList=new ArrayList<>(16);
        accountList.add(loginAccount);
        String roleName="机构管理员";
        List<UserRoleInfo> userRoleInfoList = getUserRoleInfoList(accountList, roleName);
        if(userRoleInfoList.isEmpty() || !roleName.equals(userRoleInfoList.get(0).getRoleName())){
            logger.warn("当前登录用户不是{}，不能进行当前操作",roleName);
            throw new JnSpringCloudException(OrgExceptionEnum.LOGIN_ACCOUNT_NOT_ORG_MANAGE);
        }
    }

    /**
     * 修改机构下用户角色
     * @param account    用户账号
     * @param delRoleId  要删除的角色
     * @param addRoleId  要修改的角色
     */
    @ServiceLog(doAction = "修改机构下用户角色")
    @Override
    public Boolean updateOrgUserRole(String account, String delRoleId, String addRoleId) {
        SysUserRoleVO sysUserRoleVO=new SysUserRoleVO();
        User user=new User();
        user.setAccount(account);
        Set<String> delRoleIds=new TreeSet<>();
        delRoleIds.add(delRoleId);
        Set<String>addRoleIds=new TreeSet<>();
        addRoleIds.add(addRoleId);
        sysUserRoleVO.setUser(user);
        sysUserRoleVO.setAddRoleId(addRoleIds);
        sysUserRoleVO.setDeleRoleIds(delRoleIds);
        Result<Boolean> booleanResult = systemClient.updateUserRole(sysUserRoleVO);
        return booleanResult.getData();
    }

    /**
     * 删除联系人或顾问
     * @param loginAccount 登录用户账号
     * @param accountList 删除联系人或顾问的账号
     * @return
     */
    @ServiceLog(doAction = "删除联系人或顾问")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteContactOrAdvisor(String loginAccount,String[] accountList) {
        //获取登录用户的角色，若是机构管理员，可以删除，否则不可以删除
        judgeRoleIsOrgManage(loginAccount);
        if(accountList.length==0){
            throw new JnSpringCloudException(OrgExceptionEnum.ACCOUNT_NOT_NULL);
        }
        List<String> delAccountList = Arrays.asList(accountList);
        //把顾问信息表中的数据状态值为删除
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountIn(delAccountList);
        TbServiceAdvisor tbServiceAdvisor=new TbServiceAdvisor();
        //数据状态  0：删除   1：有效
        byte recordStatus=0;
        tbServiceAdvisor.setRecordStatus(recordStatus);
        tbServiceAdvisorMapper.updateByExampleSelective(tbServiceAdvisor, example);
        //清空用户信息表中的所属机构编码和机构名称
        UserAffiliateInfo userAffiliateInfo=new UserAffiliateInfo();
        userAffiliateInfo.setAccountList(Arrays.asList(accountList));
        userAffiliateInfo.setAffiliateCode("");
        userAffiliateInfo.setAffiliateName("");
        userExtensionClient.updateAffiliateInfo(userAffiliateInfo);
        //删除用户角色信息
        List<String> accounts = Arrays.asList(accountList);
        String roleName="机构";
        List<UserRoleInfo> userRoleInfoList = getUserRoleInfoList(accounts, roleName);
        int responseNum=0;
        for(UserRoleInfo userRoleInfo:userRoleInfoList){
            Boolean isSuccess = updateOrgUserRole(userRoleInfo.getAccount(), userRoleInfo.getRoleId(), "");
            if(isSuccess){
                logger.info("删除[{}]角色信息成功",userRoleInfo.getAccount());
                responseNum++;
            }else{
                logger.info("删除[{}]角色信息失败",userRoleInfo.getAccount());
            }
        }
        return responseNum;
    }
}
