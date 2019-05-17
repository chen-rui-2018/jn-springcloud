package com.jn.park.asset.controller;/**
 * @author： huangbq
 * @date： Created on 2019/5/15 21:11
 * @version： v1.0
 * @modified By:
 */

import com.jn.common.model.Result;
import com.jn.park.api.RoomOrderClient;
import com.jn.park.asset.service.RoomInformationService;
import com.jn.pay.model.PayOrderNotify;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/15
 *</pre>
 */
@RestController
public class RoomOrderClientController implements RoomOrderClient {
    @Resource
    private RoomInformationService roomInformationService;
    @Override
    public Result payCallBack(PayOrderNotify payOrderNotify) {
        return roomInformationService.payCallBack(payOrderNotify);
    }
}
