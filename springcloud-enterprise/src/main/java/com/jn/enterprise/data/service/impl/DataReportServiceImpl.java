package com.jn.enterprise.data.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.enterprise.data.dao.TargetDao;
import com.jn.enterprise.data.model.InMoneyModel;
import com.jn.enterprise.data.model.TargetAndFormModel;
import com.jn.enterprise.data.service.DataReportService;
import com.jn.enterprise.model.DataTargetModel;
import com.jn.enterprise.model.LoadCompanyDataTargetReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/5/30 14:57
 * @version： v1.0
 * @modified By:
 */
@Service
public class DataReportServiceImpl implements DataReportService {
    @Autowired
    private TargetDao targetDao;
    @Override
    public Result<List<DataTargetModel>> loadCompanyDataTarget(LoadCompanyDataTargetReq loadCompanyDataTargetReq) {
        Result result = new Result();
        List<DataTargetModel> dataList = targetDao.loadCompanyDataTarget(loadCompanyDataTargetReq);
        result.setData(dataList);
        return result;
    }

    @Override
    public Result<Boolean> loadCompanyByRevenue(String enterpriseId) {
        Result result = new Result();
        boolean flag = false;
        //获取处
        String targetName="营业收入";
        List<String> targetIds = targetDao.getTargetIdByName(targetName);
        if(targetIds !=null && targetIds.size()>0){
            List<TargetAndFormModel> targetAndFormModels = targetDao.getFormIdByTargetIds(targetIds);
            if(targetAndFormModels !=null && targetAndFormModels.size()>0){
                List<InMoneyModel> inMoneyModels =  targetDao.getValueAndYear(targetAndFormModels);
                if(inMoneyModels !=null && inMoneyModels.size()>0){
                    List<Integer> index = new ArrayList<>();
                    for(int i=0,len=inMoneyModels.size();i<len;i++){
                        if(inMoneyModels.get(i).getValue()>=500){
                            index.add(i);
                        }
                    }
                    if(index !=null && index.size()>0){
                        for(int i=0,len=index.size();i<len;i++){
                            int nextIndex = i+1;
                            if(nextIndex<len && index.get(i+1)==nextIndex){
                                flag =true;
                                break;
                            }
                        }
                    }
                }
            }

        }
        result.setData(flag);
        return result;
    }
}
