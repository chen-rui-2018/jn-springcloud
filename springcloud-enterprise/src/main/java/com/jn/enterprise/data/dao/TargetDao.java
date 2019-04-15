package com.jn.enterprise.data.dao;


import com.jn.enterprise.data.entity.*;
import com.jn.enterprise.data.model.InputFormatModel;
import com.jn.enterprise.data.model.RelationModel;
import com.jn.enterprise.data.model.TreeData;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TabVO;
import com.jn.enterprise.data.vo.TargetVO;
import org.apache.ibatis.annotations.Param;
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
    List<TbDataReportingTarget> getTargetFromTab(String tabId);

    void createTab(List<TbDataReportingModelTab> tabVOList);

    void createRelation(List<TbDataReportingModelStruct> relationModels);

    void createInputFormater(@Param("inputFormatModelList") List<TbDataReportingTargetGroup> inputFormatModelList);
}
