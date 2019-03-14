package com.jn.paybill.api;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.paybill.model.PayBillVO;
import com.jn.paybill.model.PaymentBill;
import com.jn.paybill.model.PaymentBillModel;
import com.jn.paybill.model.PaymentBillParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 统一缴费账单客户端
 * @author： jiangyl
 * @date： Created on 2019/3/12 10:09
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-payment")
public interface PayBillClient {
    /**
     * 获取账单列表
     * @param paymentBillParam
     * @return
     */
    @RequestMapping(value = "/api/pay/bill/getUserExtension", method = RequestMethod.POST)
    Result<PaginationData<List<PaymentBill>>> getPaymentBillList(@RequestBody PaymentBillParam paymentBillParam);


    /**
     * 创建账单
     * @param paymentBillModel
     * @return
     */
    @RequestMapping(value = "/api/pay/bill/createBill", method = RequestMethod.POST)
    Result<String> createBill(@RequestBody PaymentBillModel paymentBillModel);

    /**
     * 获取账单详情
     * @param idOrNum
     * @return
     */
    @RequestMapping(value = "/api/pay/bill/getPayBillDetailByIdOrNum", method = RequestMethod.POST)
    Result<PayBillVO> getPayBillDetailByIdOrNum(@RequestParam String idOrNum);


}
