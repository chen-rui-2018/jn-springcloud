package com.jn.oa.notice.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.oa.notice.model.Notice;
import com.jn.oa.notice.model.NoticeAdd;
import com.jn.oa.notice.model.NoticePage;
import com.jn.oa.notice.service.NoticeService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * 公告管理控制层
 *
 * @author： shaobao
 * @date： Created on 2019/2/12 15:30
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "公告管理")
@RestController
@RequestMapping("/oa/notice")
public class NoticeController extends BaseController {

    @Autowired
    private NoticeService noticeService;

    @ControllerLog(doAction = "添加/修改公告")
    @RequiresPermissions("/oa/notice/addOrUpdateNotice")
    @ApiOperation(value = "添加/修改公告", httpMethod = "POST", response = Result.class)
    @RequestMapping("/addOrUpdateNotice")
    public Result addOrUpdateNotice(@Validated @RequestBody NoticeAdd noticeAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //判断是添加还是修改操作
        Boolean flag = StringUtils.isBlank(noticeAdd.getId()) ? true : false;
        if (flag) {
            noticeAdd.setId(UUID.randomUUID().toString());
        }
        noticeService.addOrUpdateNotice(noticeAdd, user, flag);
        return new Result();
    }

    @ControllerLog(doAction = "公告列表")
    @RequiresPermissions("/oa/notice/list")
    @ApiOperation(value = "公告列表", httpMethod = "POST", response = Result.class)
    @RequestMapping("/list")
    public Result list(@Validated @RequestBody NoticePage noticePage) {
        PaginationData data = noticeService.list(noticePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "查询公告详情")
    @RequiresPermissions("/oa/notice/getNoticeById")
    @ApiOperation(value = "查询公告详情", httpMethod = "POST", response = Result.class)
    @RequestMapping("/getNoticeById")
    public Result getNoticeById(String noticeId) {
        Notice notice = noticeService.getNoticeById(noticeId);
        return new Result(notice);
    }

    @ControllerLog(doAction = "发布公告")
    @RequiresPermissions("/oa/notice/publishNotice")
    @ApiOperation(value = "发布公告", httpMethod = "POST", response = Result.class)
    @RequestMapping("/publishNotice")
    public Result publishNotice(String platformType) {
        List<Notice> noticeList = noticeService.publishNotice(platformType);
        return new Result(noticeList);
    }

    @ControllerLog(doAction = "(逻辑)删除公告")
    @RequiresPermissions("/oa/notice/delete")
    @ApiOperation(value = "(逻辑)删除公告", httpMethod = "POST", response = Result.class)
    @RequestMapping("/delete")
    public Result delete(String noticeId) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        noticeService.delete(noticeId, user);
        return new Result();
    }
}
