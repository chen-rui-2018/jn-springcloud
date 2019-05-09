package com.jn.pay.api;

import com.jn.common.model.Result;
import com.jn.pay.model.RefundOrderReq;
import com.jn.pay.model.RefundOrderRsp;
import org.springframework.stereotype.Service;

/**
 * @ClassName：退款接口实现类(后期将不用)
 * @Descript：后期将会删除,目前只是为了让业务系统测试
 * @Author： hey
 * @Date： Created on 2019/5/7 16:45
 * @Version： v1.0
 * @Modified By:
 */
//TODO 后期将会删除,目前只是为了让业务系统测试
@Service
public class RefundClientIml implements RefundClient {


    @Override
    public Result<RefundOrderRsp> createRefundOrder(RefundOrderReq refundOrderReq) {

        return new Result(new RefundOrderRsp());
    }
}
