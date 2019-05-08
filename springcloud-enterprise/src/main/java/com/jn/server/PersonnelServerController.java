package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.api.PersonnelClient;
import com.jn.enterprise.model.PersonnelProject;
import com.jn.enterprise.pd.personnel.service.PersonnelService;
import com.jn.enterprise.pd.talent.entity.TbPdPerennialDeclaration;
import com.jn.system.log.annotation.ControllerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供内部使用的API接口
 *
 * @author： wzy
 * @date： Created on 2019/4/28 14:59
 * @version： v1.0
 * @modified By:
 */
@RestController
public class PersonnelServerController extends BaseController implements PersonnelClient {

    private static Logger logger = LoggerFactory.getLogger(PersonnelServerController.class);

    @Autowired
    private PersonnelService personnelService;

    @ControllerLog(doAction = "查询人才申报列表")
    @Override
    public Result<List<PersonnelProject>> selectByPersonnelProjectList(PersonnelProject personnelProject) {
        PaginationData<List<PersonnelProject>> data = personnelService.selectByPersonnelProjectList(personnelProject);
        return new Result(data);
    }
}
