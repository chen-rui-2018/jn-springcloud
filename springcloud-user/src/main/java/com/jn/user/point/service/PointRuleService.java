package com.jn.user.point.service;

import com.jn.common.model.PaginationData;
import com.jn.user.point.entity.TbPointRule;
import com.jn.user.point.model.PointRuleModel;
import com.jn.user.point.model.PointRuleVO;
import com.jn.user.point.model.PointRuleParam;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * 积分规则
 * @author： jiangyl
 * @date： Created on 2019/4/3 16:33
 * @version： v1.0
 * @modified By:
 */
public interface PointRuleService {

    /**
     * 查询积分规则列表
     * @param pointRuleParam
     * @return
     */
    PaginationData<List<PointRuleVO>> getPointRuleList(PointRuleParam pointRuleParam);

    /**
     * 获取积分规则详细信息
     * @param ruleId
     * @return
     */
    PointRuleVO getPointRuleDetail(String ruleId);

    /**
     * 修改积分规则信息
     * @param pointRuleModel
     * @param account
     * @return
     */
    Integer updatePointRuleInfo(PointRuleModel pointRuleModel,String account);

    /**
     * 查询所有支出积分规则
     * @return
     */
    List<TbPointRule>  getPointRuleAllPayList();

}
