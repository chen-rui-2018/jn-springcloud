package com.jn.enterprise.technologyfinancial.investors.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.InvestorExceptionEnum;
import com.jn.enterprise.technologyfinancial.investors.dao.InvestorMapper;
import com.jn.enterprise.technologyfinancial.investors.dao.TbServiceInvestorMapper;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestor;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorCriteria;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorInfoListParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorInfoListShow;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorService;
import com.jn.enterprise.technologyfinancial.investors.vo.InvestorInfoDetailsVo;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 科技金融投资人
 * @Author: yangph
 * @Date: 2019/3/9 16:40
 * @Version v1.0
 * @modified By:
 */
@Service
public class InvestorServiceImpl implements InvestorService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(InvestorServiceImpl.class);

    @Autowired
    private InvestorMapper investorMapper;

    @Autowired
    private TbServiceInvestorMapper tbServiceInvestorMapper;

    /**
     * 投资人列表查询
     * @param investorInfoListParam  投资人列表查询入参
     * @return
     */
    @ServiceLog(doAction = "投资人列表查询")
    @Override
    public PaginationData getInvestorInfoList(InvestorInfoListParam investorInfoListParam) {
        com.github.pagehelper.Page<Object> objects = null;
        if(investorInfoListParam==null){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<InvestorInfoListShow> investorInfoList = investorMapper.getInvestorInfoList(investorInfoListParam.getMainCode(), investorInfoListParam.getKeyWords());
            return new PaginationData(investorInfoList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(investorInfoListParam.getNeedPage())){
            objects = PageHelper.startPage(investorInfoListParam.getPage(),
                    investorInfoListParam.getRows() == 0 ? 15 : investorInfoListParam.getRows(), true);
        }
        List<InvestorInfoListShow> investorInfoList = investorMapper.getInvestorInfoList(investorInfoListParam.getMainCode(), investorInfoListParam.getKeyWords());
        return new PaginationData(investorInfoList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 投资人详情
     * @param investorAccount 投资人账号
     * @return
     */
    @ServiceLog(doAction = "投资人详情")
    @Override
    public InvestorInfoDetailsVo getInvestorInfoDetails(String investorAccount) {
        InvestorInfoDetailsVo investorInfoDetailsVo=new InvestorInfoDetailsVo();
        //获取投资人基本信息
        List<TbServiceInvestor> tbServiceInvestorList = getTbServiceInvestors(investorAccount);
        if(tbServiceInvestorList.isEmpty()){
            throw new JnSpringCloudException(InvestorExceptionEnum.INVESTOR_INFO_NOT_EXIST);
        }
        //设置投资人基本信息
        investorInfoDetailsVo.setTbServiceInvestor(tbServiceInvestorList.get(0));
        //投资人主投领域

        //投资人主投轮次

        //投资人工作经历

        //投资人教育经历
        return null;
    }

    /**
     * 根据投资人账号获取投资人信息
     * @param investorAccount
     * @return
     */
    @ServiceLog(doAction = "根据投资人账号获取投资人信息")
    private List<TbServiceInvestor> getTbServiceInvestors(String investorAccount) {
        TbServiceInvestorCriteria example=new TbServiceInvestorCriteria();
        //数据状态  0：已删除  1：有效
        byte recordStatus=1;
        example.createCriteria().andInvestorAccountEqualTo(investorAccount).andRecordStatusEqualTo(recordStatus);
        List<TbServiceInvestor> tbServiceInvestorList = tbServiceInvestorMapper.selectByExample(example);
        return tbServiceInvestorList;
    }
}
