package com.jn.park.hatch.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.hatch.model.HatchHomeConfig;
import com.jn.park.hatch.model.HatchIncubatorEnterpriseParamModel;
import com.jn.park.hatch.model.HatchIncubatorTeamParamModel;
import com.jn.park.hatch.model.HatchUpdateRevenueParamModel;

import java.util.List;

/**
 * 在孵企业（团队）管理(业务层)
 *
 * @author： wzy
 * @date： Created on 2019/5/15 17:15
 * @version： v1.0
 * @modified By:
 */
public interface HatchEntAndTeamService {

     Result updateRevenue(HatchUpdateRevenueParamModel hatchUpdateRevenueParamModel);

     Result updateGraduateegister();

     Result updateGraduateRevenue();
}
