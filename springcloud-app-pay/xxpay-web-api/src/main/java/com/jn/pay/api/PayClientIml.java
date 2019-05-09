package com.jn.pay.api;

import com.jn.common.model.Result;
import com.jn.pay.model.*;
import com.jn.pay.model.alipay.AlipayWapPayRsp;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName：支付接口实现类(后期将不用)
 * @Descript：后期将会删除,目前只是为了让业务系统测试
 * @Author： hey
 * @Date： Created on 2019/5/7 16:45
 * @Version： v1.0
 * @Modified By:
 */
//TODO 后期将会删除,目前只是为了让业务系统测试
@Service
public class PayClientIml  implements PayClient{


    @Override
    public Result createPayOrder(@RequestBody @Validated PayOrderReq payOrderReq) {
        AlipayWapPayRsp alipayWapPayRsp = new AlipayWapPayRsp();
        Result result = new Result<AlipayWapPayRsp>();
        result.setData(alipayWapPayRsp);
        return  result ;
    }

    @Override
    public Result<PayOrderQueryRsp> payOrderQuery(@RequestBody @Validated PayOrderQueryReq PayOrderQueryReq) {
        PayOrderQueryRsp payOrderQueryRsp = new PayOrderQueryRsp();
        Result result = new Result<PayOrderQueryRsp>();
        result.setData(payOrderQueryRsp);
        return  result ;
    }

}
