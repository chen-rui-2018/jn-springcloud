package com.jn.enterprise.data.service;

import com.jn.common.model.Result;
import com.jn.enterprise.data.model.TreeData;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TargetVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/10 9:26
 * @version： v1.0
 * @modified By:
 */

public interface DataModelService {
    /**
     * 返回指标的详细信息
     * @param targetId
     * @return
     */
    TargetVO getTargetInfo(String targetId);

    /**
     * 获取指标树
     * @return
     */
    List<TreeData> getTargetTree();


    /**
     * 作废指标
     * @param targetId
     * @return
     */
    int invalidTarget(String targetId);

    /**
     * 更新/插入指标
     * @param targetVO
     * @return
     */
    int updateTarget(TargetVO targetVO);


    /**
     * 获取模板树
     * @return
     */
    List<TreeData> getModelTree();

    /**
     * 更新/插入模板
     * @param modelDataVO
     */
    int updateModel(ModelDataVO modelDataVO);

    /**
     * 获取模板信息
     * @return
     */
    ModelDataVO getModel(String modelId);
}
