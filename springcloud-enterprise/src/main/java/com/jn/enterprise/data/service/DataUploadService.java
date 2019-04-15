package com.jn.enterprise.data.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.data.model.CompanyDataModel;
import com.jn.enterprise.data.model.CompanyDataParamModel;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.system.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

/**
 * @author： yangh
 * @date： Created on 2019/4/11 11:50
 * @version： v1.0
 * @modified By:
 */
public interface DataUploadService {
    /**
     * 获取广告
     * @return
     */
    Map<String,Object> getAd(User user);

    /**
     * 获取待填报的表格列表
     * @param param
     * @return
     */
    PaginationData<List<CompanyDataModel>> getNeedFormList(CompanyDataParamModel param);

    /**
     * 获取表单结构
     * @param fillId
     * @param user
     * @return
     */
    ModelDataVO getFormStruct(String fillId,User user);

    /**
     * 保存填报结果
     * @param data
     * @return
     */
    int saveCompanyFormData(ModelDataVO data);

    /**
     * 获取表单结构和值
     * @param fileId
     * @return
     */
    ModelDataVO getCompanyFormedStruct(String fileId,User user);
}
