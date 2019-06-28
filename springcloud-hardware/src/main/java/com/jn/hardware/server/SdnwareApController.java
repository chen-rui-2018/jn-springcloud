package com.jn.hardware.server;

import com.jn.common.model.Result;
import com.jn.hardware.api.SdnwareApClient;
import com.jn.hardware.model.sdnware.BaseResult;
import com.jn.hardware.model.sdnware.heat.HeatResult;
import com.jn.hardware.sdnware.service.SdnwareApService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName： Sdnware无线AP  ：内部接口实现类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/26 11:32
 * @Version： v1.0
 * @Modified By:
 */
@RestController
public class SdnwareApController implements SdnwareApClient {

    @Autowired
    private SdnwareApService sdnwareApService;

    @Override
    public Result<HeatResult> getMapHeat() {
        Result<HeatResult> result = new Result<>();
        HeatResult heatResult = sdnwareApService.getMapHeat();

        if(!BaseResult.SUCCESS_CODE.equals(heatResult.getCode())) {
            result.setCode(heatResult.getCode());
            result.setResult("查询失败!");
        }
        result.setData(heatResult);
        return result;
    }
}
