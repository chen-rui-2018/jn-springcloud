package com.jn.enterprise.data.dao;


import com.jn.enterprise.data.entity.TbDataReportingModel;
import com.jn.enterprise.data.entity.TbDataReportingModelTab;
import com.jn.enterprise.data.entity.TbDataReportingTarget;
import com.jn.enterprise.data.entity.TbDataReportingTargetGroup;
import com.jn.enterprise.data.model.InputFormatModel;
import com.jn.enterprise.data.model.RelationModel;
import com.jn.enterprise.data.model.TreeData;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TabVO;
import com.jn.enterprise.data.vo.TargetVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/10 10:38
 * @version： v1.0
 * @modified By:
 */
@Repository
public interface TargetDao {

    int invalidTarget(String targetId);

    int insertTargt(TbDataReportingTarget targetPO);

    void invalidTargetInputFormat(String targetId);

    int updateTarget(TbDataReportingTarget targetPO);

    List<TreeData> getModelTree();

    TbDataReportingTarget getTargetInfo();

    List<TbDataReportingTargetGroup> getTargetInputFormat(String targetId);

    int insertModel(ModelDataVO modelDataVO);

    void invalidTabs(String modelId);

    int updateModel(ModelDataVO modelDataVO);

    TbDataReportingModel getModelInfo();

    List<TbDataReportingModelTab> getTabs(String modelId);

    List<TbDataReportingTarget> getTargetFromTab(String tabId);

    void createTab(String modelId,List<TabVO> tabVOList);

    void createRelation(String modelId,List<RelationModel> relationModels);

    void createInputFormater(String targetId,List<TbDataReportingTargetGroup> inputFormatModelList);
}
