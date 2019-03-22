package com.jn.enterprise.technologyfinancial.investors.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.InvestorExceptionEnum;
import com.jn.enterprise.technologyfinancial.investors.dao.InvestorManagementMapper;
import com.jn.enterprise.technologyfinancial.investors.dao.TbServiceInvestorMapper;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestor;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorCriteria;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListShow;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementNameParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementUpOrDownParam;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorManagementService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 科技金融管理投资人管理
 * @Author: yangph
 * @Date: 2019/3/21 15:27
 * @Version v1.0
 * @modified By:
 */
@Service
public class InvestorManagementServiceImpl implements InvestorManagementService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(InvestorManagementServiceImpl.class);

    @Autowired
    private InvestorManagementMapper investorManagementMapper;

    @Autowired
    private TbServiceInvestorMapper tbServiceInvestorMapper;

    /**
     * 数据状态  0：已删除   1：有效
     */
    private static final byte RECORD_STATUS=1;

    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    /**
     * 投资人管理列表查询
     * @param investorManagementListParam 投资人管理列表查询入参
     * @return
     */
    @ServiceLog(doAction = "投资人管理列表查询")
    @Override
    public PaginationData getInvestorManagementList(InvestorManagementListParam investorManagementListParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if (StringUtils.isBlank(investorManagementListParam.getNeedPage())) {
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<InvestorManagementListShow> investorManagementList = investorManagementMapper.getInvestorManagementList(investorManagementListParam);
            return new PaginationData(investorManagementList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(investorManagementListParam.getNeedPage())){
            objects = PageHelper.startPage(investorManagementListParam.getPage(),
                    investorManagementListParam.getRows() == 0 ? 15 : investorManagementListParam.getRows(), true);
        }
        if(StringUtils.isNotBlank(investorManagementListParam.getApplyStartTime())
                && StringUtils.isNotBlank(investorManagementListParam.getApplyEndTime())){
            int startTime= Integer.parseInt(investorManagementListParam.getApplyStartTime());
            int endTime= Integer.parseInt(investorManagementListParam.getApplyEndTime());
            if(startTime>endTime){
                logger.warn("投资人管理列表查询的投资日期开始时间晚于投资日期结束时间");
                throw new JnSpringCloudException(InvestorExceptionEnum.START_TIME_MORE_THAN_END_TIME);
            }
        }
        List<InvestorManagementListShow> investorManagementList = investorManagementMapper.getInvestorManagementList(investorManagementListParam);
        return new PaginationData(investorManagementList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 投资人管理姓名查询
     * @param investorManagementNameParam
     * @return
     */
    @ServiceLog(doAction = "投资人管理姓名查询")
    @Override
    public PaginationData getInvestorManagementNames(InvestorManagementNameParam investorManagementNameParam) {
        com.github.pagehelper.Page<Object> objects = null;
        //需要分页标识
        String isPage="1";
        if(isPage.equals(investorManagementNameParam.getNeedPage())){
            objects = PageHelper.startPage(investorManagementNameParam.getPage(),
                    investorManagementNameParam.getRows() == 0 ? 15 : investorManagementNameParam.getRows(), true);
        }
        List<String> investorManagementNameList= investorManagementMapper.getInvestorManagementNames(investorManagementNameParam);
        return new PaginationData(investorManagementNameList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 投资人上架/下架
     * @param investorManagementUpOrDownPara
     * @param account  用户账号
     * @return
     */
    @ServiceLog(doAction = "投资人上架/下架")
    @Override
    public int investorUpOrDown(InvestorManagementUpOrDownParam investorManagementUpOrDownPara,String account) {
        investorIsExist(investorManagementUpOrDownPara);
        TbServiceInvestorCriteria example=new TbServiceInvestorCriteria();
        //审批通过
        String approvalStatus="1";
        example.createCriteria().andInvestorAccountEqualTo(investorManagementUpOrDownPara.getInvestorAccount())
        .andApprovalStatusEqualTo(approvalStatus).andRecordStatusEqualTo(RECORD_STATUS);
        TbServiceInvestor tbServiceInvestor=new TbServiceInvestor();
        tbServiceInvestor.setStatus(investorManagementUpOrDownPara.getOperatingStatus());
        //修改时间
        tbServiceInvestor.setModifiedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        //修改人
        tbServiceInvestor.setModifierAccount(account);
        return tbServiceInvestorMapper.updateByExample(tbServiceInvestor, example);
    }

    /**
     * 判断投资人是否存在，对投资人当前操作是否允许
     * @param investorManagementUpOrDownPara
     */
    @ServiceLog(doAction = "断投资人是否存在，对投资人当前操作是否允许")
    private void investorIsExist(InvestorManagementUpOrDownParam investorManagementUpOrDownPara) {
        //判断投资人是否存在
        TbServiceInvestorCriteria exampleExist=new TbServiceInvestorCriteria();
        exampleExist.createCriteria().andInvestorAccountEqualTo(investorManagementUpOrDownPara.getInvestorAccount())
                .andRecordStatusEqualTo(RECORD_STATUS);

        long investorExist = tbServiceInvestorMapper.countByExample(exampleExist);
        if(investorExist==0){
            logger.warn("当前投资人账号[{}]在系统中不存在或已失效",investorManagementUpOrDownPara.getInvestorAccount());
            throw new JnSpringCloudException(InvestorExceptionEnum.INVESTOR_ACCOUNT_NOT_EXIST);
        }

        TbServiceInvestorCriteria example=new TbServiceInvestorCriteria();
        //审批通过
        String approvalStatus="1";
        example.createCriteria().andInvestorAccountEqualTo(investorManagementUpOrDownPara.getInvestorAccount())
                .andStatusEqualTo(investorManagementUpOrDownPara.getOperatingStatus())
                .andApprovalStatusEqualTo(approvalStatus).andRecordStatusEqualTo(RECORD_STATUS);
        long exist = tbServiceInvestorMapper.countByExample(example);
        if(exist>0){
            //上架标志
            String flag="1";
            if(flag.equals(investorManagementUpOrDownPara.getOperatingStatus())){
                logger.warn("当前投资人已上架,请勿重复操作");
                throw new JnSpringCloudException(InvestorExceptionEnum.CURRENT_INVESTOR_HAVE_UP);
            }else{
                logger.warn("当前投资人已下架,请勿重复操作");
                throw new JnSpringCloudException(InvestorExceptionEnum.CURRENT_INVESTOR_HAVE_DOWN);
            }
        }
    }
}
