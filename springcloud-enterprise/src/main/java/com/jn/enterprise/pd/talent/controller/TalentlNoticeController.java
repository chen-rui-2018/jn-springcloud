package com.jn.enterprise.pd.talent.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.pd.declaration.enums.ExceptionStatusEnums;
import com.jn.enterprise.pd.declaration.model.DeclarationPlatformModel;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceNotice;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceRange;
import com.jn.enterprise.pd.talent.model.TalentNoticePlatformParam;
import com.jn.enterprise.pd.talent.service.TalentNoticeService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/guest/pd/talentNotice")
public class TalentlNoticeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(TalentlNoticeController.class);
    @Autowired
    private TalentNoticeService talentNoticeService;

    @ControllerLog(doAction = "人才服务-公告列表")
    @ApiOperation(value = "人才服务公告列表", notes = "人才服务公告列表")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public Result<List<TbPdTalentServiceNotice>> list(@ApiParam(value = "所属类型(1：人才工作动态，2：人才服务指南，3：人才企业培训，4:人才扶持计划,5:常见问题)",example = "1")  @RequestParam(name = "rangeId", required = false)  String rangeId,
                                                      @ApiParam(value = "排序（1：发布时间排序，2：时间节点排序，3：热度排序）",required = true,example = "1") @RequestParam String sortType,
                                                      @ApiParam(value = "公告标题",example = "优惠") @RequestParam(name = "noticeTitle", required = false) String noticeTitle,
                                                      @ApiParam(value = "当前页",required = true,example = "1") @RequestParam int page,
                                                      @ApiParam(value = "每页总数",required = true,example = "8") @RequestParam int rows) {

        PaginationData<List<TbPdTalentServiceNotice>> data = talentNoticeService.selectByTalentNoticeList(rangeId,sortType,noticeTitle,page,rows);
        return new Result(data);
    }

    @ControllerLog(doAction = "人才服务-查询公告详情")
    @ApiOperation(value = "人才服务-查询公告详情", notes = "人才服务-查询公告详情")
    @RequestMapping(value = "/selectByTalentNotice" ,method = RequestMethod.GET)
    public Result<TbPdTalentServiceNotice> selectByTalentNotice(@ApiParam(value = "公告ID",required = true ,example = "563047933902061568") @RequestParam String id){
        Assert.notNull(id, ExceptionStatusEnums.NOTICE_ID_NOT_NULL.getMessage());
        TbPdTalentServiceNotice notice = talentNoticeService.selectByTalentNotice(id);
        return new Result(notice);
    }

    @ControllerLog(doAction = "人才服务公告所属类型列表")
    @ApiOperation(value = "人才服务公告所属类型列表", notes = "人才服务公告所属类型列表")
    @RequestMapping(value = "/typeList" ,method = RequestMethod.GET)
    public Result<List<TbPdTalentServiceRange>> typeList(){
        List<TbPdTalentServiceRange> data = talentNoticeService.selectByTalentRangeList();
        return new Result(data);
    }

    @ControllerLog(doAction = "人才服务公告访问量")
    @ApiOperation(value = "人才服务公告访问量", notes = "人才服务公告访问量")
    @RequestMapping(value = "/trafficVolume" ,method = RequestMethod.GET)
    public Result trafficVolume(@ApiParam(value = "公告ID",required = true ,example = "563047933902061568") @RequestParam String id){
        Assert.notNull(id, ExceptionStatusEnums.NOTICE_ID_NOT_NULL.getMessage());
        talentNoticeService.updateTrafficVolume(id);
        return new Result();
    }

    @ControllerLog(doAction = "人才服务-首页申报平台查询")
    @ApiOperation(value = "人才服务-首页申报平台查询", notes = "人才服务-首页申报平台查询")
    @RequestMapping(value = "/queryPlatformInfo" ,method = RequestMethod.POST)
    public Result<List<DeclarationPlatformModel>> queryPlatformInfo(@RequestBody @Validated TalentNoticePlatformParam talentNoticePlatformParam) {
        Assert.notNull(talentNoticePlatformParam.getIsTalentService(),"是否属于人才服务入參不能为空！");
        PaginationData<List<DeclarationPlatformModel>> data = talentNoticeService.queryPlatformInfo(talentNoticePlatformParam);
        return new Result(data);
    }
}
