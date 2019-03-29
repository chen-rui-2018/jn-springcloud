package com.jn.enterprise.servicemarket.org.service.impl;

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
import com.jn.enterprise.servicemarket.org.model.OrgColleagueInfo;
import com.jn.enterprise.servicemarket.org.model.OrgColleagueParam;
import com.jn.enterprise.servicemarket.org.service.OrgColleagueService;
import com.jn.system.log.annotation.ServiceLog;
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

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 机构同事列表查询
     * @param account  当前登录用户账号
     * @param orgColleagueParam 机构同事列表查询入参（是否分页）
     * @return
     */
    @ServiceLog(doAction = "机构同事列表查询")
    @Override
    public PaginationData getOrgColleagueList(String account, OrgColleagueParam orgColleagueParam) {
        com.github.pagehelper.Page<Object> objects = null;
        //分页标识
        String isPage="1";
        //是否分页标识
        boolean needPage=false;
        if(orgColleagueParam != null && orgColleagueParam.getNeedPage()!=null
                && isPage.equals(orgColleagueParam.getNeedPage())){
            needPage=true;
        }
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
        if(needPage) {
            objects = PageHelper.startPage(orgColleagueParam.getPage(),
                    orgColleagueParam.getRows() == 0 ? 15 : orgColleagueParam.getRows(), true);
            affiliateParam.setPage(orgColleagueParam.getPage());
            affiliateParam.setRows(orgColleagueParam.getRows() == 0 ? 15 : orgColleagueParam.getRows());
            affiliateParam.setNeedPage(orgColleagueParam.getNeedPage());
        }
        Result userExtensionByAffiliateCode = userExtensionClient.getUserExtensionByAffiliateCode(affiliateParam);
        if(userExtensionByAffiliateCode==null || userExtensionByAffiliateCode.getData()==null){
            return new PaginationData(userExtension.getData(), objects == null ? 0 : objects.getTotal());
        }
        PaginationData pageData = (PaginationData)userExtensionByAffiliateCode.getData();
        List<UserExtensionInfo> userExtensionInfoList=(List<UserExtensionInfo> ) pageData.getRows();
        //取出查询出的所有账号
        List<String>accountList=new ArrayList<>(16);
        for(UserExtensionInfo userExtensionInfo:userExtensionInfoList){
            accountList.add(userExtensionInfo.getAccount());
        }
        //todo：调用豹哥提供的获取账号角色接口，得到机构身份 yangph

        //从顾问信息表获取用户毕业学校，担任职务，入驻时间
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountIn(accountList);
        List<TbServiceAdvisor> tbServiceAdvisorList = tbServiceAdvisorMapper.selectByExample(example);
        List<OrgColleagueInfo> orgColleagueInfoList=new ArrayList<>();
        for(UserExtensionInfo extensionInfo:userExtensionInfoList){
            OrgColleagueInfo orgColleagueInfo=new OrgColleagueInfo();
            BeanUtils.copyProperties(extensionInfo, orgColleagueInfo);
            //todo:遍历机构身份表，设置用户机构身份，判断是否为机构管理员，若是从机构表获取入驻日期 yangph


            for(TbServiceAdvisor tbServiceAdvisor:tbServiceAdvisorList){
                //账号相同,设置毕业学校，担任职务，入驻日期
                if(StringUtils.equals(extensionInfo.getAccount(),tbServiceAdvisor.getAdvisorAccount() )){
                    //毕业学校
                    orgColleagueInfo.setGraduatedSchool(tbServiceAdvisor.getGraduatedSchool());
                    //担任职务
                    orgColleagueInfo.setPosition(tbServiceAdvisor.getPosition());
                    //入驻日期
                    if(tbServiceAdvisor.getCreatedTime()!=null){
                        orgColleagueInfo.setEntryDate(DateUtils.formatDate(tbServiceAdvisor.getCreatedTime(), "yyyy-MM-dd HH:mm:ss"));
                    }else{
                        orgColleagueInfo.setEntryDate(DateUtils.formatDate(extensionInfo.getCreatedTime(), "yyyy-MM-dd HH:mm:ss"));
                    }
                }
            }
            orgColleagueInfoList.add(orgColleagueInfo);
        }
        return new PaginationData(orgColleagueInfoList,objects == null ? 0 : objects.getTotal());
    }

    /**
     * 设置为联系人
     * @param account 设置为联系人的账号
     */
    @ServiceLog(doAction = "设置为联系人")
    @Override
    public int setAsContact(String account) {
        //todo：调用豹哥提供的修改用户角色接口 yangph
        return 1;
    }

    /**
     * 取消联系人
     * @param account 取消联系人的账号
     */
    @ServiceLog(doAction = "取消联系人")
    @Override
    public int cancelAsContact(String account) {
        //todo：调用豹哥提供的修改用户角色接口 yangph
        return 1;
    }

    /**
     * 删除联系人或顾问
     * @param loginAccount 登录用户账号
     * @param account 删除联系人或顾问的账号
     */
    @ServiceLog(doAction = "取消联系人")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteContactOrAdvisor(String loginAccount,String account) {
        //todo：获取登录用户的角色，若是机构管理员，可以删除，否则不可以删除  yangph

        //把顾问信息表中的数据状态值为删除
        TbServiceAdvisorCriteria example=new TbServiceAdvisorCriteria();
        example.createCriteria().andAdvisorAccountEqualTo(account);
        TbServiceAdvisor tbServiceAdvisor=new TbServiceAdvisor();
        //数据状态  0：删除   1：有效
        byte recordStatus=0;
        tbServiceAdvisor.setRecordStatus(recordStatus);
        tbServiceAdvisorMapper.updateByExampleSelective(tbServiceAdvisor, example);
        //清空用户信息表中的所属机构编码和机构名称
        UserAffiliateInfo userAffiliateInfo=new UserAffiliateInfo();
        userAffiliateInfo.setAffiliateCode(null);
        userAffiliateInfo.setAffiliateName(null);
        userExtensionClient.updateAffiliateInfo(userAffiliateInfo);
        //todo：调用豹哥提供的修改用户角色接口删除用户角色 yangph
        return 0;
    }
}
