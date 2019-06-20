package com.jn.park.pmpaybill.service.impl;

import com.jn.park.parking.service.impl.ParkingAreaServiceImpl;
import com.jn.park.pmpaybill.dao.PmPriceRuleDeatilsMapper;
import com.jn.park.pmpaybill.dao.TbPmPriceRulesMapper;
import com.jn.park.pmpaybill.entity.TbPmPriceRuleDeatils;
import com.jn.park.pmpaybill.entity.TbPmPriceRules;
import com.jn.park.pmpaybill.service.PmPriceRuleService;
import com.jn.park.pmpaybill.vo.PmPriceRuleVo;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 物业费单价管理服务层实现
 *
 * @author： shaobao
 * @date： Created on 2019/6/10 15:36
 * @version： v1.0
 * @modified By:
 **/
@Service
public class PmPriceRuleServiceImpl implements PmPriceRuleService {

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ParkingAreaServiceImpl.class);

    @Autowired
    private TbPmPriceRulesMapper tbPmPriceRulesMapper;

    @Autowired
    private PmPriceRuleDeatilsMapper pmPriceRuleDeatilsMapper;

    /**
     * 为企业生成物业费单价规则
     *
     * @param pmPriceRuleVo
     */
    @Override
    @ServiceLog(doAction = "为企业生成物业费单价规则")
    @Transactional(rollbackFor = Exception.class)
    public void createPmPriceRule(PmPriceRuleVo pmPriceRuleVo) {
        String companyId = pmPriceRuleVo.getCompanyId();
        //1.为物业费规则实体复值并插入数据库
        TbPmPriceRules tbPmPriceRules = new TbPmPriceRules();
        BeanUtils.copyProperties(pmPriceRuleVo, tbPmPriceRules);

        tbPmPriceRulesMapper.insertSelective(tbPmPriceRules);

        List<TbPmPriceRuleDeatils> tbPmPriceRuleDeatilsList = pmPriceRuleVo.getTbPmPriceRuleDeatilsList();
        if (tbPmPriceRuleDeatilsList != null && tbPmPriceRuleDeatilsList.size() > 0) {
            //批量更新
            pmPriceRuleDeatilsMapper.insertBatch(tbPmPriceRuleDeatilsList);
        }

        logger.info("[物业费单价管理] 为企业添加物业费单价信息成功,企业id,{}", companyId);
    }
}
