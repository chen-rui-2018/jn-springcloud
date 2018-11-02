package com.jn.controller;

import com.jn.common.model.Result;
import com.jn.model.Token;
import com.jn.service.GetToken;
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
public class DownloadController {

    @Autowired
    private GetToken getToken;

    /**
     * 上传文件的地址
     * @param fileName
     * @return
     * @throws IOException
     */
    @RequestMapping("/guest/download/getToken")
    public Result<Token> getToken(String fileName) throws IOException, NoSuchAlgorithmException {
        return new Result(getToken.getToken(fileName));
    }

}
