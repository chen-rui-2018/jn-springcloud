package com.jn.hardware.sdnware.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.util.RestTemplateUtil;
import com.jn.hardware.config.SdnwareApProperties;
import com.jn.hardware.model.sdnware.heat.HeatResult;
import com.jn.hardware.sdnware.service.SdnwareApService;
import com.jn.hardware.util.JsonStringToObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName：：Sdnware无线AP ：区域人数统计（热力）相关接口实现类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/26 11:47
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class SdnwareApServiceImpl implements SdnwareApService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SdnwareApProperties sdnwareApProperties;


    /**
     * 获取区域人数统计（热力）
     * @return
     */
    @Override
    public HeatResult getMapHeat() {

        //url 加上userId
        String url = String.format(SdnwareApService.GET_HEAT_URL,sdnwareApProperties.getUserId());
        logger.info("\n获取区域人数统计（热力）, 请求地址:【{}】      ",url);
        Map<String,String> dynamicHeaders = new HashMap<>(16);
        dynamicHeaders.put("Accept", "text/plain");
        String resultJson =  RestTemplateUtil.get(url,dynamicHeaders);
        logger.info("\n获取区域人数统计（热力）,接口响应:【{}】",resultJson);
        HeatResult heatResult = JsonStringToObjectUtil.jsonToObject(resultJson,new TypeReference<HeatResult>(){});
        logger.info("\n获取区域人数统计（热力）,响应结果heatResult:【{}】",heatResult);
        return heatResult;
    }
}
