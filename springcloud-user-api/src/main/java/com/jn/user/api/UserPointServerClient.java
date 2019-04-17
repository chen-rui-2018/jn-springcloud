package com.jn.user.api;

import com.jn.common.model.Result;
import com.jn.user.model.PointDeductionParam;
import com.jn.user.model.PointDeductionVO;
import com.jn.user.model.PointIncomeParam;
import com.jn.user.model.PointOrderPayParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: jiangyl
 * @Date: 2019/4/10 14:40
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-user")
public interface UserPointServerClient {
    /**
     * 用户积分收入
     * @param pointIncomeParam
     * @return
     */
    @RequestMapping(value = "/api/user/point/userPointIncome", method = RequestMethod.POST)
    Result<Boolean> userPointIncome(@RequestBody PointIncomeParam pointIncomeParam);

    /**
     * 查询账单所能抵扣积分数
     * @param pointDeductionParam
     * @return
     */
    @RequestMapping(value = "/api/user/point/orderPointDeduction", method = RequestMethod.POST)
    Result<PointDeductionVO> orderPointDeduction(@RequestBody PointDeductionParam pointDeductionParam);

    /**
     * 账单发起支付，积分预扣除接口
     * @param pointOrderPayParam
     * @return
     */
    @RequestMapping(value = "/api/user/point/pointPreDeduction", method = RequestMethod.POST)
    Result<Boolean> pointPreDeduction(@RequestBody PointOrderPayParam pointOrderPayParam);

    /**
     * 支付成功，积分扣除接口
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/api/user/point/orderPaySuccessPointDeduction", method = RequestMethod.POST)
    Result<Boolean> orderPaySuccessPointDeduction(@RequestBody String orderId);

    /**
     * 支付失败/取消支付，积分退回（回滚）接口
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/api/user/point/orderPayErrorPointReturn", method = RequestMethod.POST)
    Result<Boolean> orderPayErrorPointReturn(@RequestBody String orderId);
}
