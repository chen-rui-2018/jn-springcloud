package com.jn.park.notice.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.notice.model.NoticeDetailShow;
import com.jn.park.notice.service.NoticeWebService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/2 16:06
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "对外公告-前端展示(app/门户)")
@RestController
@RequestMapping(value = "park/notice/web")
public class NoticeWebController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(NoticeWebController.class);
    @Autowired
    private NoticeWebService noticeWebService;

    @ControllerLog(doAction = "app首页弹出公告列表")
    @ApiOperation(value = "app首页弹出公告列表",notes = "首页弹出不超过三条,且当前时间处于生效时间和失效时间内,状态为有效")
    @RequestMapping(value = "/popupNoticeListForApp",method = RequestMethod.GET)
    public Result<List<NoticeDetailShow>> popupNoticeListForApp(){
        List<NoticeDetailShow> noticeList =noticeWebService.popupNoticeListForApp();
        return new Result(noticeList);
    }
    @ControllerLog(doAction = "门户首页弹出公告列表")
    @ApiOperation(value = "门户首页弹出公告列表",notes = "首页弹出不超过三条,且当前时间处于生效时间和失效时间内,状态为有效")
    @RequestMapping(value = "/popupNoticeListForPortal",method = RequestMethod.GET)
    public Result<List<NoticeDetailShow>> popupNoticeListForPortal(){
        List<NoticeDetailShow> noticeList =noticeWebService.popupNoticeListForPortal();
        return new Result(noticeList);
    }

    @ControllerLog(doAction = "门户首页展示(轮播)公告列表")
    @ApiOperation(value = "门户首页展示(轮播)公告列表")
    @RequestMapping(value = "/showNoticeListForPortal",method = RequestMethod.GET)
    public Result<PaginationData<List<NoticeDetailShow>>> showNoticeListForPortal(Page page){
        PaginationData<List<NoticeDetailShow>> noticeList =noticeWebService.showNoticeListForPortal(page);
        return new Result(noticeList);
    }
    @ControllerLog(doAction = "app首页展示(轮播)公告列表")
    @ApiOperation(value = "app首页展示(轮播)公告列表")
    @RequestMapping(value = "/showNoticeListForApp",method = RequestMethod.GET)
    public Result<PaginationData<List<NoticeDetailShow>>> showNoticeListForApp(Page page){
        PaginationData<List<NoticeDetailShow>> noticeList =noticeWebService.showNoticeListForApp(page);
        return new Result(noticeList);
    }
    @ControllerLog(doAction = "门户公告列表")
    @ApiOperation(value = "门户公告列表")
    @RequestMapping(value = "/noticeListPortal",method = RequestMethod.GET)
    public Result<PaginationData<List<NoticeDetailShow>>> noticeListPortal(Page page){
        PaginationData<List<NoticeDetailShow>> noticeList =noticeWebService.noticeListPortal(page);
        return new Result(noticeList);
    }
    @ControllerLog(doAction = "app公告列表")
    @ApiOperation(value = "app公告列表")
    @RequestMapping(value = "/noticeListApp",method = RequestMethod.GET)
    public Result<PaginationData<List<NoticeDetailShow>>> noticeListApp(Page page){
        PaginationData<List<NoticeDetailShow>> noticeList =noticeWebService.noticeListApp(page);
        return new Result(noticeList);
    }
    @ControllerLog(doAction = "公告详情")
    @ApiOperation(value = "公告详情",notes = "通过公告id,查询公告详情(app/门户共用)")
    @RequestMapping(value = "/findNoticeDetailsByNoticeId",method = RequestMethod.GET)
    public Result<NoticeDetailShow> findNoticeDetailsByNoticeId(@ApiParam(value = "公告id",name="noticeId", required = true, example = "1063bdd13de64123abaecdd96b3269dc")  @RequestParam(value = "noticeId") String noticeId){
        NoticeDetailShow notice =noticeWebService.findNoticeDetailsByNoticeId(noticeId);
        return new Result(notice);
    }
}
