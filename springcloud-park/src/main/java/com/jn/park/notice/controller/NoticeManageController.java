package com.jn.park.notice.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.notice.model.NoticeAddParam;
import com.jn.park.notice.model.NoticeModifyParam;
import com.jn.park.notice.service.NoticeService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private NoticeService noticeService;

    @ControllerLog(doAction = "发布(新增)公告")
    @ApiOperation(value="发布(新增)公告",notes = "返回的结果为新增公告条数,正常返回 1")
    @RequestMapping(value = "/addNotice",method = RequestMethod.POST)
//    @RequiresPermissions(value ="/park/notice/addNotice")
    public Result addNotice(@Validated @RequestBody  NoticeAddParam noticeAddParam){
        NoticeModifyParam modifyParam = new NoticeModifyParam();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String noticeId= UUID.randomUUID().toString().replaceAll("-","");
        BeanUtils.copyProperties(noticeAddParam,modifyParam);
        modifyParam.setNoticeId(noticeId);
        int i = noticeService.addNotice(modifyParam,user==null?"":user.getAccount());
        return new Result<>(i);
    }
}
