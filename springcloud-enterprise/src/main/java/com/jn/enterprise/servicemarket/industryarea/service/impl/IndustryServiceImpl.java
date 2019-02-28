package com.jn.enterprise.servicemarket.industryarea.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.servicemarket.industryarea.dao.IndustryMapper;
import com.jn.enterprise.servicemarket.industryarea.dao.TbServicePreferMapper;
import com.jn.enterprise.servicemarket.industryarea.entity.TbServicePrefer;
import com.jn.enterprise.servicemarket.industryarea.model.Industry;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryData;
import com.jn.enterprise.servicemarket.industryarea.model.IndustryParameter;
import com.jn.enterprise.servicemarket.industryarea.service.IndustryService;
import com.jn.enterprise.servicemarket.org.service.impl.OrgApproveServiceImpl;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 行业领域管理
 * @author： jiangyl
 * @date： Created on 2019/2/27 11:19
 * @version： v1.0
 * @modified By:
 */
@Service
public class IndustryServiceImpl implements IndustryService {
    private static Logger logger = LoggerFactory.getLogger(IndustryServiceImpl.class);
    @Autowired
    private IndustryMapper industryMapper;
    @Autowired
    private TbServicePreferMapper tbServicePreferMapper;

    /**
     * 字典数据类型 0业务领域
     */
    private final static String PRE_VALUE_BUSINESS_AREA  = "0";

    @Override
    @ServiceLog(doAction = "查询行业类型数据")
    public PaginationData selectIndustryList(IndustryParameter industryParameter){
        Page<Object> objects = PageHelper.startPage(industryParameter.getPage(), industryParameter.getRows() == 0 ? 15 : industryParameter.getRows());
        List<Industry> industries = industryMapper.selectIndustryList(industryParameter);
        PaginationData data = new PaginationData(industries, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "保存/修改行业领域")
    public Boolean saveOrUpdateIndustry(IndustryData industryData, String account){
        int i ;
        TbServicePrefer tbServicePrefer = new TbServicePrefer();
        BeanUtils.copyProperties(industryData,tbServicePrefer);
        tbServicePrefer.setPreType(PRE_VALUE_BUSINESS_AREA);
        if(StringUtils.isNotEmpty(industryData.getId())){
            //存在id，则为修改
            tbServicePrefer.setModifiedTime(new Date());
            tbServicePrefer.setModifierAccount(account);
            i = tbServicePreferMapper.updateByPrimaryKeySelective(tbServicePrefer);
            logger.info("修改行业数据成功，响应条数{}",i);
        }else{
            tbServicePrefer.setId(UUID.randomUUID().toString().replaceAll("-",""));
            tbServicePrefer.setCreatedTime(new Date());
            tbServicePrefer.setCreatorAccount(account);
            tbServicePrefer.setRecordStatus(new Byte(""));
            i = tbServicePreferMapper.insert(tbServicePrefer);
            logger.info("插入行业数据成功，响应条数{}",i);
        }
        return i==1?true:false;
    }

    @Override
    @ServiceLog(doAction = "获取行业领域详情")
    public Industry getIndustryDetail(String id){
        Industry industryDetail = industryMapper.getIndustryDetail(id);
        return industryDetail;
    }

}
