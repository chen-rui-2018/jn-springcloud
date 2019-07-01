package com.jn.enterprise.pd.evaluate.service;

import com.jn.common.model.Result;
import com.jn.enterprise.pd.evaluate.model.EvaluateTargetModel;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 项目申报-常年申报评测(外部)
 * <pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/6/20
 * </pre>
 */
public interface EvaluateService {

    /**
     * 评测指标查询
     * @param companyId
     * @param dealTimeStart
     * @param dealTimeEnd
     * @return
     */
    public Result<List<EvaluateTargetModel>> getTarget(  String companyId, String dealTimeStart, String dealTimeEnd );
}
