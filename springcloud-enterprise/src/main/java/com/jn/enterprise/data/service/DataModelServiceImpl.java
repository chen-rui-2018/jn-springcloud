package com.jn.enterprise.data.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.data.dao.TargetDao;
import com.jn.enterprise.data.dao.TbDataReportingTargetMapper;
import com.jn.enterprise.data.entity.*;
import com.jn.enterprise.data.enums.DataUploadExceptionEnum;
import com.jn.enterprise.data.model.InputFormatModel;
import com.jn.enterprise.data.model.RelationModel;
import com.jn.enterprise.data.model.TreeData;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TabVO;
import com.jn.enterprise.data.vo.TargetVO;
import com.jn.system.log.annotation.ServiceLog;
import org.apache.commons.collections.ArrayStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/10 9:51
 * @version： v1.0
 * @modified By:
 */
@Service
public class DataModelServiceImpl implements DataModelService {

    private static Logger logger = LoggerFactory.getLogger(DataModelServiceImpl.class);
    @Autowired
    private TargetDao targetDao;

    @Override
    @ServiceLog(doAction = "返回指标的详细信息")
    public TargetVO getTargetInfo(String targetId) {
        if(StringUtils.isBlank(targetId)){
            logger.warn("[指标管理-指标详细信息获取]，指标id不能为空!");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TARGET_IS_BLANK);
        }
        //查询指标基本信息
        TbDataReportingTarget targetPO = targetDao.getTargetInfo();
        //查询填报格式
        if(targetPO == null){
            logger.warn("[指标管理-指标详细信息获取]，指标不存在");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TARGET_IS_NOT_EXIST);
        }
        List<TbDataReportingTargetGroup> inputFormatModelList = targetDao.getTargetInputFormat(targetId);

        TargetVO  targetVO = new TargetVO();
        BeanUtils.copyProperties(targetPO,targetVO);
        List<InputFormatModel> listVO = new ArrayList<>();
        InputFormatModel inputFormatModel =null;

        for(TbDataReportingTargetGroup t:inputFormatModelList){
            inputFormatModel = new InputFormatModel();
            BeanUtils.copyProperties(t,inputFormatModel);
            listVO.add(inputFormatModel);
        }
        targetVO.setInputFormatModels(listVO);
        return targetVO;
    }

    @Override
    @ServiceLog(doAction = "查询指标树")
    public List<TreeData> getTargetTree() {
        return null;
    }

    @Override
    @ServiceLog(doAction = "作废指标")
    public int invalidTarget(String targetId) {
        /*
        TbDataReportingTarget  target  = new TbDataReportingTarget();
        target.setTargetId(targetId);
        target.setRecordStatus(new Byte("1"));
        tbDataReportingTargetMapper.updateByPrimaryKeySelective(target);
        */

        if(StringUtils.isEmpty(targetId)){
            logger.warn("[指标管理-作废指标]，指标ID不存在");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TARGET_IS_BLANK);
        }
        return targetDao.invalidTarget(targetId);
    }

    @Override
    @ServiceLog(doAction = "指标")
    @Transactional(rollbackFor = Exception.class)
    public int updateTarget(TargetVO target) {

        TbDataReportingTarget targetPO = new TbDataReportingTarget();
        BeanUtils.copyProperties(target,targetPO);
        List<TbDataReportingTargetGroup>  listInput =new ArrayList<>();
        List<InputFormatModel> inputFormatModelList  = target.getInputFormatModels();
        TbDataReportingTargetGroup tbDataReportingTargetGroup=null;
        for(InputFormatModel inputFormatModel :inputFormatModelList){
            tbDataReportingTargetGroup = new TbDataReportingTargetGroup();
            BeanUtils.copyProperties(inputFormatModel,tbDataReportingTargetGroup);
            listInput.add(tbDataReportingTargetGroup);
        }

        Integer result = 0;

        if(StringUtils.isEmpty(targetPO.getTargetId())){
            String targetId="";
            targetPO.setTargetId(targetId);
            result = targetDao.insertTargt(targetPO);
        }else{
            invalidTargetInputFormat(targetPO.getTargetId());
            result = targetDao.updateTarget(targetPO);
        }
        targetDao.createInputFormater(targetPO.getTargetId(),listInput);
        return result;
    }


    /**
     * 作废指标填报格式
     * @param targetId
     * @return
     */
    private void invalidTargetInputFormat(String targetId) {
        targetDao.invalidTargetInputFormat(targetId);
    }

    @Override
    @ServiceLog(doAction = "获取模板树")
    public List<TreeData> getModelTree() {
        List<TreeData> treeData = targetDao.getModelTree();
        return treeData;
    }

    @Override
    @ServiceLog(doAction = "更新/插入模板信息")
    public int updateModel(ModelDataVO modelDataVO) {
        Integer result = 0;
        String modleId = modelDataVO.getModelId();

        if(StringUtils.isBlank(modleId)){
            //创建model_id
            //插入模板基本信息
            result = targetDao.insertModel(modelDataVO);

        }else{
            //作废Tabs
            invalidTabs(modleId);
            //更新模板的基本信息
            result = targetDao.updateModel(modelDataVO);
            //创建模板对应的Tab，保存tab信息
            List<TabVO> tabVOList = modelDataVO.getTabs();
            createTab(modelDataVO.getModelId(), modelDataVO.getTabs());
            //建立Tab和指标之间的关系
            createRelation(modelDataVO.getModelId(),modelDataVO.getTabs());

        }
        return result;
    }

    /**
     * 创建tab信息
     * @param tabVOList
     */
    private void createTab(String modelId,List<TabVO> tabVOList){
        targetDao.createTab(modelId,tabVOList);
    }

    /**
     * 创建tab和指标的关系信息
     * @param tabVOList
     */
    private void createRelation(String modelId,List<TabVO> tabVOList){
        List<RelationModel> relationModels = new ArrayList<>();
        for(int tabIndex=0,tabSize=tabVOList.size();tabIndex<tabSize;tabIndex++){
            RelationModel relationModel = new RelationModel();
            relationModel.getModelId();
            relationModels.add(relationModel);
        }
        targetDao.createRelation(modelId,relationModels);
    }

    /**
     * 作废关联至modelId的tab
      * @param modelId
     */
    private void invalidTabs(String modelId){
        targetDao.invalidTabs(modelId);
    }
    @Override
    @ServiceLog(doAction = "获取模板信息")
    @Transactional(rollbackFor = Exception.class)
    public ModelDataVO getModel(String modelId) {

        if(StringUtils.isBlank(modelId)){
            logger.warn("[指标管理-获取模板信息]，模板ID不存在");
            throw new JnSpringCloudException(DataUploadExceptionEnum.MODEL_IS_BLANK);
        }
        ModelDataVO modelData = new ModelDataVO();
        TbDataReportingModel modelDataPO = targetDao.getModelInfo();
        BeanUtils.copyProperties(modelDataPO,modelData);
        if(modelDataPO == null){
            logger.warn("[指标管理-获取模板信息]，模板不存在");
            throw new JnSpringCloudException(DataUploadExceptionEnum.MODEL_IS_NOT_EXIST);
        }

        List<TbDataReportingModelTab> tabPOList = targetDao.getTabs(modelDataPO.getModelId());
        List<TabVO> tabVOList = new ArrayList<>();
        TabVO tabVO =null;
        TargetVO targetVO = null;
        InputFormatModel inputFormatModel =null;
        List<TargetVO> listTargetVO =null;
        List<InputFormatModel>  inputFormatModelListVO =null;
        for (int tabIndex=0 ,tabSize =tabPOList.size();tabIndex<tabSize;tabIndex++) {
            tabVO = new TabVO();
            BeanUtils.copyProperties(tabPOList.get(tabIndex),tabVO);
            listTargetVO = new ArrayList<>();
            List<TbDataReportingTarget> targetList = targetDao.getTargetFromTab(tabPOList.get(tabIndex).getTabId());

            for(int targetIndex=0 ,targetSize =targetList.size();targetIndex<targetSize;targetIndex++){
                inputFormatModelListVO = new ArrayList<>();
                targetVO = new TargetVO();
                BeanUtils.copyProperties(targetList.get(targetIndex),targetVO);
                List<TbDataReportingTargetGroup> inputFormatModelList = targetDao.getTargetInputFormat(targetList.get(targetIndex).getTargetId());

                for(TbDataReportingTargetGroup t : inputFormatModelList){
                    inputFormatModel = new InputFormatModel();
                    BeanUtils.copyProperties(t,inputFormatModel);
                    inputFormatModelListVO.add(inputFormatModel);
                }
                targetVO.setInputFormatModels(inputFormatModelListVO);
                listTargetVO.add(targetVO);
            }
            tabVO.setTargetList(listTargetVO);
            tabVOList.add(tabVO);
        }
        modelData.setTabs(tabVOList);
        return modelData;
    }




}
