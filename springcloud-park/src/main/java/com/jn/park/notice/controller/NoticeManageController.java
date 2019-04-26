package com.jn.park.notice.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.model.ParkCode;
import com.jn.park.notice.model.*;
import com.jn.park.notice.service.NoticeManageService;
import com.jn.park.parkcode.service.ParkCodeService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author： chenr
 * @date： Created on 2019/3/29 14:24
 * @version： v1.0
 * @modified By:
 */

@Api(tags = "对外公告-后台公告管理")
@RestController
@RequestMapping(value = "/park/notice")
public class NoticeManageController  extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(NoticeManageController.class);
    @Autowired
    private NoticeManageService noticeManageService;


    @ControllerLog(doAction = "发布(新增)公告")
    @ApiOperation(value="发布(新增)公告",notes = "返回的结果为新增公告条数,正常返回 1")
    @RequestMapping(value = "/addNotice",method = RequestMethod.POST)
    @RequiresPermissions(value ="/park/notice/addNotice")
    public Result addNotice(@Validated @RequestBody  NoticeAddParam noticeAddParam){
        NoticeModifyParam modifyParam = new NoticeModifyParam();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String noticeId= UUID.randomUUID().toString().replaceAll("-","");
        BeanUtils.copyProperties(noticeAddParam,modifyParam);
        modifyParam.setNoticeId(noticeId);
        int i = noticeManageService.addNotice(modifyParam,user==null?"":user.getAccount());
        return new Result<>(i);
    }
    @ControllerLog(doAction = "后台管理公告列表")
    @ApiOperation(value="后台管理公告列表")
    @RequestMapping(value = "/findNoticeList",method = RequestMethod.GET)
    @RequiresPermissions(value ="/park/notice/findNoticeList")
    public Result<PaginationData<List<NoticeManageShow>>> findNoticeList(@Validated NoticeQueryParam queryParam){
        PaginationData<List<NoticeManageShow>> noticeList =  noticeManageService.findNoticeList(queryParam);
        return new Result<>(noticeList);
    }
    @ControllerLog(doAction = "后台编辑公告")
    @ApiOperation(value="后台编辑公告",notes = "返回的结果为新增公告条数,正常返回 1")
    @RequestMapping(value = "/modifyNoticeList",method = RequestMethod.POST)
    @RequiresPermissions(value ="/park/notice/modifyNoticeList")
    public Result modifyNoticeList(@Validated @RequestBody NoticeModifyParam modifyParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        int i  =  noticeManageService.modifyNotice(modifyParam,user==null?"":user.getAccount());
        return new Result<>(i);
    }
    @ControllerLog(doAction = "后台公告详情(可用于编辑时回显)")
    @ApiOperation(value="后台公告详情(可用于编辑时回显)")
    @RequestMapping(value = "/findNoticeDetails",method = RequestMethod.GET)
    @RequiresPermissions(value ="/park/notice/findNoticeDetails")
    public Result<NoticeManageShow> findNoticeDetails(@ApiParam(value="公告id",name = "noticeId",required = true,example = "1063bdd13de64123abaecdd96b3269dc")  @RequestParam(value = "noticeId") String  noticeId){
        NoticeManageShow  noticeDetails  =  noticeManageService.findNoticeDetails(noticeId);
        return new Result<>(noticeDetails);
    }
    @ControllerLog(doAction = "公告上下架操作")
    @ApiOperation(value="公告上下架操作(下架等于逻辑删除)",notes = "返回的结果为新增公告条数,正常返回 1")
    @RequestMapping(value = "/noticeShelfOperate",method = RequestMethod.POST)
    @RequiresPermissions(value ="/park/notice/noticeShelfOperate")
    public Result noticeShelfOperate(@Validated @RequestBody NoticeShelfParam shelfParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        int i  =  noticeManageService.noticeShelfOperate(shelfParam,user==null?"":user.getAccount());
        return new Result<>(i);
    }
    @ControllerLog(doAction = "平台列表")
    @ApiOperation(value="平台列表(新增/修改 公告时 所选平台列表)")
    @RequestMapping(value = "/findPlatformList",method = RequestMethod.GET)
    @RequiresPermissions(value ="/park/notice/findPlatformList")
    public Result<List<NoticePlatformShow>> findPlatformList(){
        String codeType="noticePlatform";
       List<NoticePlatformShow>  parkCodes = noticeManageService.findPlatformList(codeType);
        return new Result<>(parkCodes);
    }


}
