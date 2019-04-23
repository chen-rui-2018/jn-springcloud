package com.jn.user.point.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.enums.UserPointExceptionEnum;
import com.jn.user.point.dao.TbPointRuleMapper;
import com.jn.user.point.entity.TbPointRule;
import com.jn.user.point.entity.TbPointRuleCriteria;
import com.jn.user.point.model.PointRuleModel;
import com.jn.user.point.model.PointRuleVO;
import com.jn.user.point.model.PointRuleParam;
import com.jn.user.point.service.PointRuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 积分规则管理实现类
 * @author： jiangyl
 * @date： Created on 2019/4/3 16:34
 * @version： v1.0
 * @modified By:
 */
@Service
public class PointRuleServiceImpl implements PointRuleService {
    private static Logger logger = LoggerFactory.getLogger(PointRuleServiceImpl.class);

    @Autowired
    private TbPointRuleMapper tbPointRuleMapper;

    /**
     * 数据状态 1:有效
     */
    private final static String RECORD_STATUS_VALID = "1";

    /**
     * 积分规则： 2支出规则
     */
    private final static String POINT_RULE_INCOME_VALID_PAY = "2";

    @Override
    @ServiceLog(doAction = "查询积分规则列表")
    public PaginationData<List<PointRuleVO>>  getPointRuleList(PointRuleParam pointRuleParam){
        TbPointRuleCriteria ruleCriteria = new TbPointRuleCriteria();
        TbPointRuleCriteria.Criteria criteria = ruleCriteria.createCriteria();
        criteria.andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        if(StringUtils.isNotEmpty(pointRuleParam.getRuleCode())){
            criteria.andRuleCodeEqualTo(pointRuleParam.getRuleCode());
        }
        if(StringUtils.isNotEmpty(pointRuleParam.getRuleName())){
            criteria.andRuleNameEqualTo(pointRuleParam.getRuleName());
        }
        if(StringUtils.isNotEmpty(pointRuleParam.getRuleType())){
            criteria.andRuleTypeEqualTo(pointRuleParam.getRuleType());
        }
        Page<Object> objects = PageHelper.startPage(pointRuleParam.getPage(), pointRuleParam.getRows() == 0 ? 15 : pointRuleParam.getRows());
        List<TbPointRule> tbPointRules = tbPointRuleMapper.selectByExample(ruleCriteria);

        List<PointRuleVO> models = new ArrayList<>(16);
        for (TbPointRule rule :tbPointRules) {
            PointRuleVO ruleVO = new PointRuleVO();
            BeanUtils.copyProperties(rule,ruleVO);
            if(null != rule.getCreatedTime()){
                ruleVO.setCreatedTime(DateUtils.formatDate(rule.getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(null != rule.getModifiedTime()){
                ruleVO.setModifiedTime(DateUtils.formatDate(rule.getModifiedTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            models.add(ruleVO);
        }

        PaginationData<List<PointRuleVO>> data = new PaginationData(models, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "查询积分规则列表[前端]")
    public List<PointRuleVO> getFrontPointRuleList(String ruleType){
        TbPointRuleCriteria ruleCriteria = new TbPointRuleCriteria();
        ruleCriteria.createCriteria().andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID)).andRuleTypeEqualTo(ruleType);
        List<TbPointRule> tbPointRules = tbPointRuleMapper.selectByExample(ruleCriteria);

        List<PointRuleVO> models = new ArrayList<>(16);
        for (TbPointRule rule :tbPointRules) {
            PointRuleVO ruleVO = new PointRuleVO();
            BeanUtils.copyProperties(rule,ruleVO);
            models.add(ruleVO);
        }
        return models;
    }

    @Override
    @ServiceLog(doAction = "获取积分规则详情")
    public PointRuleVO getPointRuleDetail(String ruleId){
        TbPointRule rule = tbPointRuleMapper.selectByPrimaryKey(ruleId);
        if(null == rule){
            throw new JnSpringCloudException(UserPointExceptionEnum.POINT_RULE_IS_NOT_EXIST);
        }
        PointRuleVO pointRuleVO = new PointRuleVO();
        BeanUtils.copyProperties(rule,pointRuleVO);
        if(null != rule.getCreatedTime()){
            pointRuleVO.setCreatedTime(DateUtils.formatDate(rule.getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
        }
        if(null != rule.getModifiedTime()){
            pointRuleVO.setModifiedTime(DateUtils.formatDate(rule.getModifiedTime(),"yyyy-MM-dd HH:mm:ss"));
        }
        return pointRuleVO;
    }

    @Override
    @ServiceLog(doAction = "修改积分规则信息")
    public Integer updatePointRuleInfo(PointRuleModel pointRuleModel, String account){
        TbPointRule tbPointRule = new TbPointRule();
        BeanUtils.copyProperties(pointRuleModel,tbPointRule);
        tbPointRule.setModifiedTime(new Date());
        tbPointRule.setModifierAccount(account);
        return tbPointRuleMapper.updateByPrimaryKeySelective(tbPointRule);
    }

    @Override
    @ServiceLog(doAction = "查询所有积分支出规则")
    public List<TbPointRule>  getPointRuleAllPayList(){
        TbPointRuleCriteria ruleCriteria = new TbPointRuleCriteria();
        ruleCriteria.createCriteria().andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID)).andRuleTypeEqualTo(POINT_RULE_INCOME_VALID_PAY);
        return tbPointRuleMapper.selectByExample(ruleCriteria);
    }

}
