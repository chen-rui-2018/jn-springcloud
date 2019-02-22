package com.jn.enterprise.servicemarket.org.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.model.OrgApply;
import com.jn.enterprise.servicemarket.model.OrgApplyCount;
import com.jn.enterprise.servicemarket.model.OrgApplyDetail;
import com.jn.enterprise.servicemarket.model.OrgApplyParameter;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrg;
import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgCriteria;
import com.jn.enterprise.servicemarket.org.service.OrgApproveService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 服务机构认证审核接口实现类
 * @author： jiangyl
 * @date： Created on 2019/2/21 15:45
 * @version： v1.0
 * @modified By:
 */
@Service
public class OrgApproveServiceImpl implements OrgApproveService {
    private static Logger logger = LoggerFactory.getLogger(OrgApproveServiceImpl.class);

    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;
    @Autowired
    private UserExtensionClient userExtensionClient;

    @Override
    @ServiceLog(doAction = "查询机构审核认证列表")
    public PaginationData getOrgApplyList(OrgApplyParameter orgApplyParameter){
        List<OrgApply> orgApplyList = new ArrayList<>(8);
        Page<Object> objects = PageHelper.startPage(orgApplyParameter.getPage(), orgApplyParameter.getRows() == 0 ? 15 : orgApplyParameter.getRows());
        TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
        orgCriteria.createCriteria().andOrgNameLike("%"+orgApplyParameter.getOrgName()+"%").andOrgStatusEqualTo(orgApplyParameter.getOrgStatus());
        List<TbServiceOrg> tbServiceOrgs = tbServiceOrgMapper.selectByExample(orgCriteria);
        List<String> accountList = new ArrayList<>();
        for (TbServiceOrg serviceOrg:tbServiceOrgs) {
            OrgApply orgApply = new OrgApply();
            BeanUtils.copyProperties(serviceOrg,orgApply);
            orgApplyList.add(orgApply);
            accountList.add(serviceOrg.getOrgAccount());
        }
        Result<List<UserExtension>> moreUserExtension = userExtensionClient.getMoreUserExtension(accountList);
        List<UserExtension> userExtensions = moreUserExtension.getData();
        for (OrgApply orgApply:orgApplyList) {
            for (UserExtension userExtesion:userExtensions) {
                if(StringUtils.equals(orgApply.getOrgAccount(),userExtesion.getUserPersonInfo().getAccount())){
                    BeanUtils.copyProperties(userExtesion.getUserPersonInfo(),orgApply);
                }
            }
        }
        PaginationData data = new PaginationData(orgApplyList, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "查询机构入驻数据")
    public OrgApplyCount getOrgCount(){
        OrgApplyCount orgApplyCount = new OrgApplyCount();
        // 入驻机构总数（已审核通过数）
        TbServiceOrgCriteria orgCriteria = new TbServiceOrgCriteria();
        orgCriteria.createCriteria().andOrgStatusEqualTo("1").andRecordStatusEqualTo(new Byte("1"));
        long orgCount = tbServiceOrgMapper.countByExample(orgCriteria);
        orgApplyCount.setOrgCount(orgCount+"");
        logger.info("入驻机构总数（已审核通过数）{}",orgCount);
        // 待审核机构数
        orgCriteria.createCriteria().andOrgStatusEqualTo("0").andRecordStatusEqualTo(new Byte("1"));
        long waitApplyCount = tbServiceOrgMapper.countByExample(orgCriteria);
        orgApplyCount.setWaitApplyCount(waitApplyCount+"");
        logger.info("待审核机构数{}",waitApplyCount);
        // 本月入驻机构数
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        cale.set(Calendar.MILLISECOND, 0);
        orgCriteria.createCriteria().andOrgStatusEqualTo("1").andRecordStatusEqualTo(new Byte("1")).andCheckTimeBetween(cale.getTime(),new Date());
        long monthJoinOrgCount = tbServiceOrgMapper.countByExample(orgCriteria);
        orgApplyCount.setMonthJoinOrgCount(monthJoinOrgCount+"");
        logger.info("本月入驻机构数{}",monthJoinOrgCount);
        //上月入驻机构数
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.add(Calendar.MONTH, -1);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        startCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startCalendar.set(Calendar.MINUTE, 0);
        startCalendar.set(Calendar.SECOND, 0);
        startCalendar.set(Calendar.MILLISECOND, 0);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.add(Calendar.MONTH, -1);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        endCalendar.set(Calendar.HOUR_OF_DAY, endCalendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        endCalendar.set(Calendar.MINUTE, endCalendar.getActualMaximum(Calendar.MINUTE));
        endCalendar.set(Calendar.SECOND, endCalendar.getActualMaximum(Calendar.SECOND));
        endCalendar.set(Calendar.MILLISECOND, endCalendar.getActualMaximum(Calendar.MILLISECOND));
        orgCriteria.createCriteria().andOrgStatusEqualTo("1").andRecordStatusEqualTo(new Byte("1")).andCheckTimeBetween(startCalendar.getTime(),endCalendar.getTime());
        long lastMonthJoinOrgCount = tbServiceOrgMapper.countByExample(orgCriteria);
        orgApplyCount.setLastMonthJoinOrgCount(lastMonthJoinOrgCount+"");
        logger.info("上月入驻机构数{}",lastMonthJoinOrgCount);
        //本月入驻环比
        DecimalFormat df = new DecimalFormat("0.00");
        String format = df.format(monthJoinOrgCount / (double) lastMonthJoinOrgCount * 100);
        orgApplyCount.setMonthJoinOrgRatio(format);
        return orgApplyCount;
    }

    @Override
    @ServiceLog(doAction = "查询机构申请详细信息")
    public OrgApplyDetail getOrgApplyDetail(String orgId){


        return null;
    }



}
