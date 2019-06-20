package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.api.CareClient;
import com.jn.park.care.model.CareParam;
import com.jn.park.care.model.ServiceEnterpriseCompany;
import com.jn.park.gamtopic.model.CareUserDetails;
import com.jn.park.gamtopic.service.CareService;
import com.jn.system.log.annotation.ControllerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 评论API接口
 * @author： jiangyl
 * @date： Created on 2019/4/25 15:29
 * @version： v1.0
 * @modified By:
 */
@RestController
public class CareServerController extends BaseController implements CareClient {
    private static Logger logger = LoggerFactory.getLogger(CareServerController.class);

    @Autowired
    private CareService careService;


    @ControllerLog(doAction = "获取评论信息")
    @Override
    public Result findCompanyCareInfo(@RequestBody CareParam careParam){
        CareUserDetails companyCareInfo = careService.findCompanyCareInfo(careParam.getAccount(), careParam.getCurrentAccount());
        return new Result<>(companyCareInfo);
    }

    @Override
    @ControllerLog(doAction = "查询关注的企业")
    public Result<List<String>> findCareCompanyList(@RequestBody CareParam careParam) {
        List<String> careCompanyList = careService.findCareCompanyList(careParam.getCurrentAccount());
        return new Result(careCompanyList);
    }

    @Override
    @ControllerLog(doAction = "查询关注的企业")
    public List<ServiceEnterpriseCompany> getCompanyNewList(@RequestBody List<ServiceEnterpriseCompany> serviceEnterpriseCompany,String account) {
        List<ServiceEnterpriseCompany> getCompanyNewList = careService.getCompanyNewList(serviceEnterpriseCompany,account);
        return getCompanyNewList;
    }

}
