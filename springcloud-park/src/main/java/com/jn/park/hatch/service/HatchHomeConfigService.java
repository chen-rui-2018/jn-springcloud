package com.jn.park.hatch.service;

import com.jn.common.model.PaginationData;
import com.jn.park.hatch.model.HatchHomeConfig;
import com.jn.park.hatch.model.HatchIncubatorEnterpriseParamModel;
import com.jn.park.hatch.model.HatchIncubatorTeamParamModel;

import java.util.List;

/**
 * 众创空间配置管理(业务层)
 *
 * @author： wzy
 * @date： Created on 2019/5/15 17:15
 * @version： v1.0
 * @modified By:
 */
public interface HatchHomeConfigService {

    /**
     * 众创空间-首页信息查询
     * @param incubatorAbb,page,rows
     * @return
     */
    PaginationData<List<HatchHomeConfig>> list(String incubatorAbb,int page,int rows);

    /**
     * 孵化企业-新增入孵企业信息
     * @param hatchIncubatorEnterpriseParamModel
     * @return
     */
    void insertEnterpriseInfo(HatchIncubatorEnterpriseParamModel hatchIncubatorEnterpriseParamModel);

    /**
     * 孵化企业-新增入孵团队信息
     * @param hatchIncubatorTeamParamModel
     * @return
     */
    void insertTeamInfo(HatchIncubatorTeamParamModel hatchIncubatorTeamParamModel);
}
