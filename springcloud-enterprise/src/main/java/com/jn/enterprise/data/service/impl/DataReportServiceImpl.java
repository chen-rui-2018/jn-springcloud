package com.jn.enterprise.data.service.impl;

import com.jn.common.model.Result;
import com.jn.enterprise.data.service.DataReportService;
import com.jn.enterprise.model.DataTargetModel;
import com.jn.enterprise.model.LoadCompanyDataTargetReq;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/5/30 14:57
 * @version： v1.0
 * @modified By:
 */
@Service
public class DataReportServiceImpl implements DataReportService {
    @Override
    public Result<List<DataTargetModel>> loadCompanyDataTarget(LoadCompanyDataTargetReq loadCompanyDataTargetReq) {
        return null;
    }

    @Override
    public Result<Boolean> loadCompanyByRevenue(String enterpriseId) {
        return null;
    }
}
