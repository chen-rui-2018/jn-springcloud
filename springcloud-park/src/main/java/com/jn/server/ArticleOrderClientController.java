package com.jn.server;

import com.jn.common.model.Result;
import com.jn.park.api.ArticleOrderClient;
import com.jn.park.asset.service.AssetArticleLeaseOrdersService;
import com.jn.pay.model.PayOrderNotify;
import com.jn.system.log.annotation.ControllerLog;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
*
* @author： zhuyz
* @date： Created on 2019/5/20 17:37
* @version： v1.0
* @modified By:
*/
@RestController
public class ArticleOrderClientController implements ArticleOrderClient {

    @Resource
    private AssetArticleLeaseOrdersService assetArticleLeaseOrdersService;

    @Override
    @ControllerLog(doAction = "物品支付回调")
    public Result articlePayCallBack(@RequestBody PayOrderNotify payOrderNotify) {
        return assetArticleLeaseOrdersService.articlePayCallBack(payOrderNotify);
    }
}
