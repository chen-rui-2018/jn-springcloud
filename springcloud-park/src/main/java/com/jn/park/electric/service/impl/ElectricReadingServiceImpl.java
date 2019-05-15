package com.jn.park.electric.service.impl;/**
 * @author： huangbq
 * @date： Created on 2019/5/15 12:55
 * @version： v1.0
 * @modified By:
 */

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.hardware.api.ElectricMeterClient;
import com.jn.hardware.model.electricmeter.ElectricMeterDataCollectionParam;
import com.jn.park.electric.service.ElectricReadingService;
import com.jn.system.api.SystemClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 *
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/15
 *</pre>
 */
@Service
public class ElectricReadingServiceImpl implements ElectricReadingService {
    @Resource
    private ElectricMeterClient electricMeterClient;
    @Resource
    private SystemClient systemClient;

    @Override
    public Result meterDataCollection(Date dealDate, Integer dealHour, String meterCode) {

        if(dealHour>23||dealHour<0){
            throw new JnSpringCloudException(new Result("-1","小时只能是0-23之间"));
        }
        ElectricMeterDataCollectionParam param=new ElectricMeterDataCollectionParam();
        if(StringUtils.isNotBlank(meterCode)){
            param.setCode(meterCode);
        }
        param.setDeviceType("2");
        //todo 时间参数需要改
        param.setStartTime("2019-05-15 14:00:00");
        Result result=electricMeterClient.electricMeterDataCollection(param);

        return result;
    }
}
