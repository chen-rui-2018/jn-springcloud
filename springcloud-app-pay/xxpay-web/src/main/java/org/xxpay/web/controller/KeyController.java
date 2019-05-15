package org.xxpay.web.controller;

import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.pay.api.KeyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.xxpay.common.constant.PayEnum;
import org.xxpay.common.util.MyLog;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.web.service.MchInfoService;

/**
 * @ClassName：密钥获取类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/11 14:18
 * @Version： v1.0
 * @Modified By:
 */
@RestController
public class KeyController extends BaseController implements KeyClient {

    /**
     * 日志
    * */
    private final MyLog _log = MyLog.getLog(KeyController.class);

    @Autowired
    private MchInfoService mchInfoService;

    /**
     * 根据商户ID获取请求对应商户的请求密钥
     * @param mchId 商户ID
     * @return
     */
    @Override
    public Result<String> getRequestKey(String mchId) {
        if(StringUtils.isBlank(mchId)){
            return new Result(PayEnum.ERR_0014.getCode(),"params mchId is null");
        }
        _log.info("根据商户ID获取请求对应商户的请求密钥  mchId={}",mchId);

        MchInfo mchInfo = mchInfoService.getMchInfoById(mchId);
        if(null == mchInfo){
            return new Result(PayEnum.ERR_0014.getCode(),"Can't found mchInfo[mchId="+mchId+"] record in db.");
        }
        if(mchInfo.getState() != 1){
            return new Result(PayEnum.ERR_0010.getCode(),"mchInfo not available [mchId="+mchId+"] record in db.");
        }
        if(StringUtils.isBlank(mchInfo.getReqKey())){
            return new Result(PayEnum.ERR_0010.getCode(),"reqKey is null[mchId="+mchId+"] record in db.");
        }

        return new Result(mchInfo.getReqKey());

    }

    /**
     * 根据商户ID获取请求对应商户的响应密钥
     * @param mchId 商户ID
     * @return
     */
    @Override
    public Result<String> getResponseKey(String mchId) {

        if(StringUtils.isBlank(mchId)){
            return new Result(PayEnum.ERR_0014.getCode(),"params mchId is null");
        }
        _log.info("根据商户ID获取请求对应商户的响应密钥  mchId={}",mchId);

        MchInfo mchInfo = mchInfoService.getMchInfoById(mchId);
        if(null == mchInfo){
            return new Result(PayEnum.ERR_0014.getCode(),"Can't found mchInfo[mchId="+mchId+"] record in db.");
        }
        if(mchInfo.getState() != 1){
            return new Result(PayEnum.ERR_0010.getCode(),"mchInfo not available [mchId="+mchId+"] record in db.");
        }
        if(StringUtils.isBlank(mchInfo.getResKey())){
            return new Result(PayEnum.ERR_0010.getCode(),"resKey is null[mchId="+mchId+"] record in db.");
        }

        return new Result(mchInfo.getResKey());
    }
}
