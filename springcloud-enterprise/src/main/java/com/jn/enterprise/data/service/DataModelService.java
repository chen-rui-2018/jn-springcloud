package com.jn.enterprise.data.service;

import com.jn.common.model.Result;
import com.jn.enterprise.data.entity.TbDataReportingGardenLinker;
import com.jn.enterprise.data.model.GroupModel;
import com.jn.enterprise.data.model.InputFormatModel;
import com.jn.enterprise.data.model.TreeData;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TargetModelVO;
import com.jn.enterprise.data.vo.TargetVO;
import com.jn.system.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    List<TargetModelVO> getTargetTree();


    /**
     * 作废指标
     * @param targetId
     * @return
     */
    int invalidTarget(String targetId,User user);

    /**
     * 更新/插入指标
     * @param targetVO
     * @return
     */
    int updateTarget(TargetVO targetVO,User user);


    /**
     * 获取模板树
     * @return
     */
    List<TreeData> getModelTree();

    /**
     * 更新/插入模板
     * @param modelDataVO
     * @param user
     * @return
     */
    int updateModel(ModelDataVO modelDataVO,User user);

    /**
     * 获取模板信息
     * @return
     */
    ModelDataVO getModel(String modelId);

    /**
     * 获取群组条件
     * @return
     */
    List<GroupModel> getGroupList();

    /**
     * 通过指标查询填报格式
     * @param targetList
     * @return
     */
    List<InputFormatModel> getInputFormatByTargetIds(List<String> targetList);

    /**
     * 获取模板生成的任务全部填报完成后的预警人条件
     * @return
     */
    List<TbDataReportingGardenLinker> getWarner();
}
