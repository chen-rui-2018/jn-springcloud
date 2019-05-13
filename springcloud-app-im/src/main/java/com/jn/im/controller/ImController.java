package com.jn.im.controller;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.im.entity.TbImMessage;
import com.jn.im.model.Message;
import com.jn.im.service.ImService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * IM Controller
 *
 * @author： shenph
 * @date： Created on 2019/5/10 21:34
 * @version： v1.0
 * @modified By:
 */
@RestController
@RequestMapping("/im")
public class ImController {

    @Autowired
    private ImService imService;

    /**
     * 查询聊天记录
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/selectMsg", method = RequestMethod.POST)
    public Result<PaginationData<List<TbImMessage>>> selectMsg(@RequestBody Message message) {
        PaginationData<List<TbImMessage>> result = imService.selectMsg(message);
        return new Result(result);
    }

    /**
     * 消息设置已读
     *
     * @param tbImMessage
     * @return
     */
    @RequestMapping(value = "/isSended", method = RequestMethod.POST)
    public Result isSended(@RequestBody TbImMessage tbImMessage) {
        imService.isSended(tbImMessage);
        return new Result();
    }


}
