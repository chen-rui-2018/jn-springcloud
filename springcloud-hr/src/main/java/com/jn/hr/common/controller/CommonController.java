package com.jn.hr.common.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.hr.common.model.DownAttachment;
import com.jn.hr.common.service.CommonService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 协同办公,oa公共controller
 *
 * @author： shaobao
 * @date： Created on 2019/3/19 10:29
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "人力资源管理公共控制层")
@RestController
@RequestMapping("/hr/common")
public class CommonController extends BaseController {

    @Autowired
    private CommonService commonService;

    @ControllerLog(doAction = "附件上传")
    @RequiresPermissions("/hr/common/uploadAttachment")
    @ApiOperation(value = "附件上传", httpMethod = "POST", response = Result.class)
    @RequestMapping("/uploadAttachment")
    public Result uploadAttachment(HttpServletRequest request) {
        //获取上传文件
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

        String attachment = commonService.uploadAttachment(files);
        return new Result(attachment);
    }

    @ControllerLog(doAction = "附件下载")
    @RequiresPermissions("/hr/common/downLoadAttachment")
    @ApiOperation(value = "附件下载", httpMethod = "POST", response = Result.class)
    @RequestMapping("/downLoadAttachment")
    public ResponseEntity<byte[]> downLoadAttachment(DownAttachment downAttachment, HttpServletResponse response) {
        ResponseEntity<byte[]> attachment = commonService.downLoadAttachment(downAttachment, response);
        return attachment;
    }
}
