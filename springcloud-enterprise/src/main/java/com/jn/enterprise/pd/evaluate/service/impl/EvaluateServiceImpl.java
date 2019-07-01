package com.jn.enterprise.pd.evaluate.service.impl;

import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.api.DataReportClient;
import com.jn.enterprise.model.DataTargetModel;
import com.jn.enterprise.model.LoadCompanyDataTargetReq;
import com.jn.enterprise.pd.evaluate.dao.TbPdEvaluateKeyMapper;
import com.jn.enterprise.pd.evaluate.entity.TbPdEvaluateKey;
import com.jn.enterprise.pd.evaluate.entity.TbPdEvaluateKeyCriteria;
import com.jn.enterprise.pd.evaluate.model.EvaluateTargetModel;
import com.jn.enterprise.pd.evaluate.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/6/20
 * </pre>
 */
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private TbPdEvaluateKeyMapper tbPdEvaluateKeyMapper;
    @Autowired
    private DataReportClient dataReportClient;

    @Override
    public Result<List<EvaluateTargetModel>> getTarget(String companyId, String dealTimeStart, String dealTimeEnd) {
        TbPdEvaluateKeyCriteria criteria=new TbPdEvaluateKeyCriteria();
        criteria.createCriteria().andTargetIdIsNotNull().andTargetIdNotEqualTo("");
        List<TbPdEvaluateKey>tbPdEvaluateKeyList=tbPdEvaluateKeyMapper.selectByExample(criteria);
        if(tbPdEvaluateKeyList.size()<1){
            return new Result<>("-1","没有匹配到可查询指标数据");
        }
        String[] targetIds=new String[tbPdEvaluateKeyList.size()];
        for(int i=0;i<tbPdEvaluateKeyList.size();i++){
            targetIds[i]=tbPdEvaluateKeyList.get(0).getTargetId();
        }
        LoadCompanyDataTargetReq loadCompanyDataTargetReq=new LoadCompanyDataTargetReq();
        loadCompanyDataTargetReq.setEnterpriseId(companyId);
        loadCompanyDataTargetReq.setDealTimeStart(dealTimeStart);
        loadCompanyDataTargetReq.setDealTimeEnd(dealTimeEnd);
        loadCompanyDataTargetReq.setTargetIds(targetIds);
        Result<List<DataTargetModel>> dataTarget=dataReportClient.loadCompanyDataTarget(loadCompanyDataTargetReq);
        if(!StringUtils.equals(dataTarget.getCode(),"0000")){
            return new Result<>("-1","指标没有数据");
        }
        List<EvaluateTargetModel> evaluateTargetModelList=new ArrayList<>();
        for(DataTargetModel e:dataTarget.getData()){
            EvaluateTargetModel model=new EvaluateTargetModel();
            TbPdEvaluateKey tbPdEvaluateKey=this.getByTargetId(tbPdEvaluateKeyList,e.getTargetId());
            model.setId(tbPdEvaluateKey.getKeyId());
            model.setName(tbPdEvaluateKey.getKeyName());
            model.setValue(e.getTargetData());
            model.setUnit(e.getTargetUnit());
            evaluateTargetModelList.add(model);
        }
        return new Result<>(evaluateTargetModelList);

    }

    private TbPdEvaluateKey getByTargetId(List<TbPdEvaluateKey> tbPdEvaluateKeyList,String targetId){
        TbPdEvaluateKey tbPdEvaluateKey=null;
        for(TbPdEvaluateKey key:tbPdEvaluateKeyList){
            if(StringUtils.equals(key.getTargetId(),targetId)){
                tbPdEvaluateKey=key;
                break;
            }
        }
        return tbPdEvaluateKey;
    }
}
