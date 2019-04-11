package com.jn.enterprise.pd.talent.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceNotice;
import com.jn.enterprise.pd.talent.service.TalentNoticeService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 人才服务公告管理
 *
 * @author： wzy
 * @date： Created on 2019/4/10 9:50
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "人才服务-公告管理")
@RestController
@RequestMapping("/pd/talentNotice")
public class TalentlNoticeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(TalentlNoticeController.class);
    @Autowired
    private TalentNoticeService talentNoticeService;

    @ControllerLog(doAction = "人才服务公告列表")
    @ApiOperation(value = "人才服务公告列表", notes = "人才服务公告列表")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    @RequiresPermissions("/pd/talentNotice/list")
    public Result<List<TbPdTalentServiceNotice>> list(@ApiParam(value = "所属类型",example = "人才工作动态") @RequestParam String rangeName,
                                                      @ApiParam(value = "排序（1：发布时间排序，2：时间节点排序，3：热度排序）",required = true,example = "1") @RequestParam String sortType) {
        List<TbPdTalentServiceNotice> data = talentNoticeService.selectByTalentNoticeList(rangeName,sortType);
        return new Result(data);
    }
}
