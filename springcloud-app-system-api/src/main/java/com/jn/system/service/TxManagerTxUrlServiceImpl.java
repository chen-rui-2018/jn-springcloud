package com.jn.system.service;

import com.codingapi.tx.config.service.TxManagerTxUrlService;
import com.jn.common.util.GlobalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

/**
 * 获取事务框架链接
 *
 * @author： fengxh
 * @date： Created on 2019/5/01 15:31
 * @version： v1.0
 * @modified By:
 */
@Service
public class TxManagerTxUrlServiceImpl implements TxManagerTxUrlService{

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    /**
     * 事务框架ID
     */
    private final static String TX_MANAGER = "tx-manager";
    /**
     *  事务链接
     */
    private final static String Tx_Manager_URL = "/tx/manager/";

    @Override
    public String getTxUrl() {
        ServiceInstance si = this.loadBalancerClient.choose(TX_MANAGER);
        StringBuffer sb = new StringBuffer();
        sb.append(GlobalConstants.HTTP_PRODOCOL).append(si.getHost()).append(":").append(si.getPort()).append(Tx_Manager_URL);
        return sb.toString();
    }
}
