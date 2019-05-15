package com.jn.park.customer.service;

import com.jn.common.model.PaginationData;
import com.jn.park.customer.model.ConsultationCustomerListParam;

/**
 * @Author: yangph
 * @Date: 2019/5/14 9:42
 * @Version v1.0
 * @modified By:
 */
public interface CustomerServiceCenterService {
    /**
     * 园区用户咨询客服
     * @param param         分页信息
     * @param loginAccount  用户账号
     * @return
     */
    PaginationData consultationCustomerList(ConsultationCustomerListParam param,String loginAccount);

    /**
     * 根据任务id获取问题详情
     * @param account 用户账号
     * @param taskId 任务id
     * @return
     */
    Object customerQuesDetail(String account,String taskId);
}
