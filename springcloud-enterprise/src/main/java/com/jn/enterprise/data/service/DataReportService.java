package com.jn.enterprise.data.service;

import com.jn.common.model.Result;
import com.jn.enterprise.model.DataTargetModel;
import com.jn.enterprise.model.LoadCompanyDataTargetReq;

import java.util.List;

/**
 *数据上报查询报表相关interface
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/24
 *</pre>
 */
public interface DataReportService {

    /**
     * 查询企业的上报数据
     * @param  loadCompanyDataTargetReq
     * @return
     */
    Result<List<DataTargetModel>> loadCompanyDataTarget(LoadCompanyDataTargetReq loadCompanyDataTargetReq);

    /**
     * 企业的营收额达是否连续两年达到500万
     * @param enterpriseId 企业ID （必传）
     * @return
     */
    Result<Boolean> loadCompanyByRevenue(String enterpriseId);
}
