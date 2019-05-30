package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.company.model.ServiceCompanyParam;
import com.jn.enterprise.api.DataReportClient;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.data.service.DataReportService;
import com.jn.enterprise.model.DataTargetModel;
import com.jn.enterprise.model.LoadCompanyDataTargetReq;
import com.jn.system.log.annotation.ControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据上报查询报表相关controller
 *<pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：${DATE}
 *</pre>
 */
@RestController
public class DataReportServerController extends BaseController implements DataReportClient {

    @Autowired
    private DataReportService dataReportService;


    @ControllerLog(doAction = "查询企业的上报数据")
    @Override
    public Result<List<DataTargetModel>> loadCompanyDataTarget(@Validated @RequestBody LoadCompanyDataTargetReq loadCompanyDataTargetReq) {
        return dataReportService.loadCompanyDataTarget(loadCompanyDataTargetReq);
    }

    @ControllerLog(doAction = "企业的营收额达是否连续两年达到500万")
    @Override
    public Result<Boolean> loadCompanyByRevenue(String enterpriseId) {
        return dataReportService.loadCompanyByRevenue(enterpriseId);
    }
}
