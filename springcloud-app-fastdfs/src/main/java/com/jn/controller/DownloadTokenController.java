package com.jn.controller;

import com.github.tobato.fastdfs.token.GetToken;
import com.jn.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * 下载token
 *
 * @author： fengxh
 * @date： Created on 2018/10/25 19:21
 * @version： v1.0
 * @modified By:
 */
@RestController
public class DownloadTokenController {

    @Autowired
    private GetToken getToken;


    /**
     * 获取文件下载的权限
     * @param filePath  文件链接地址 eg.http://192.168.10.45:2020/group1/M00/00/00/wKgKLVvazSeAGLAxAAMmpEcA_IM580.png
     * @return  token  然后在文件链接地址后面加上token=XXXXXXX&ts=XXXXXXX
     * @throws IOException
     */
    @RequestMapping("/download/getToken")
    public Result getToken(String filePath) throws IOException, NoSuchAlgorithmException {
        // TODO: 2018/11/29 请炮哥补充权限校验
        return new Result(getToken.getToken(filePath));
    }

}
