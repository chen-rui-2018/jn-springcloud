package com.jn.enterprise.data.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.data.dao.*;
import com.jn.enterprise.data.entity.*;
import com.jn.enterprise.data.enums.DataUploadConstants;
import com.jn.enterprise.data.enums.DataUploadExceptionEnum;
import com.jn.enterprise.data.model.GroupModel;
import com.jn.enterprise.data.model.InputFormatModel;
import com.jn.enterprise.data.model.TreeData;
import com.jn.enterprise.data.service.DataModelService;
import com.jn.enterprise.data.tool.GetTargetTree;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TabVO;
import com.jn.enterprise.data.vo.TargetModelVO;
import com.jn.enterprise.data.vo.TargetVO;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

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

    @Autowired(required = false)
    private TbDataReportingModelTabMapper tbDataReportingModelTabMapper;
    @Autowired(required = false)
    private TbDataReportingModelMapper tbDataReportingModelMapper;

    @Autowired(required = false)
    private TbDataReportingTargetGroupMapper tbDataReportingTargetGroupMapper;

    @Autowired(required = false)
    private TbDataReportingTargetMapper tbDataReportingTargetMapper;

    @Autowired(required = false)
    private TbDataReportingGroupStructMapper tbDataReportingGroupStructMapper;
    @Autowired(required = false)
    private TbDataReportingGardenLinkerMapper tbDataReportingGardenLinkerMapper;
    @Override
    @ServiceLog(doAction = "返回指标的详细信息")
    public TargetVO getTargetInfo(String targetId) {
        if(StringUtils.isBlank(targetId)){
            logger.warn("[指标管理-指标详细信息获取]，指标id不能为空!");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TARGET_IS_BLANK);
        }
        //查询指标基本信息
        TbDataReportingTarget targetPO = tbDataReportingTargetMapper.selectByPrimaryKey(targetId);

        //查询填报格式
        if(targetPO == null){
            logger.warn("[指标管理-指标详细信息获取]，指标不存在");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TARGET_IS_NOT_EXIST);
        }
        TbDataReportingTargetGroupCriteria exampleGroup =new TbDataReportingTargetGroupCriteria();
        exampleGroup.or().andTargetIdEqualTo(targetId).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        List<TbDataReportingTargetGroup> inputFormatModelList = tbDataReportingTargetGroupMapper.selectByExample(exampleGroup);

        TargetVO  targetVO = new TargetVO();
        BeanUtils.copyProperties(targetPO,targetVO);

        targetVO.setIsMuiltRow(Integer.parseInt(targetPO.getIsMuiltRow().toString()));
        targetVO.setTargetType(Integer.parseInt(targetPO.getTargetType().toString()));
        targetVO.setRecordStatus(Integer.parseInt(targetPO.getRecordStatus().toString()));


        List<InputFormatModel> listVO = new ArrayList<>();
        InputFormatModel inputFormatModel =null;

        for(TbDataReportingTargetGroup t:inputFormatModelList){
            inputFormatModel = new InputFormatModel();
            BeanUtils.copyProperties(t,inputFormatModel);
            getInputFormatData(inputFormatModel,t);
            listVO.add(inputFormatModel);
        }
        targetVO.setInputFormatModels(listVO);
        return targetVO;
    }

    /**
     * 进行类型转换
     * @param inputFormatModel
     * @param t
     */
    private void getInputFormatData(InputFormatModel inputFormatModel,TbDataReportingTargetGroup t){
        inputFormatModel.setRequired(t.getRequired().toString());
        inputFormatModel.setRecordStatus(t.getRecordStatus().toString());
        inputFormatModel.setOrderNumber(t.getOrderNumber());
    }

    @Override
    @ServiceLog(doAction = "查询指标树")
    public List<TargetModelVO> getTargetTree() {
        //活动所有指标
        TbDataReportingTargetCriteria example =new TbDataReportingTargetCriteria();
        example.or().andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        List<TbDataReportingTarget> targetList =tbDataReportingTargetMapper.selectByExample(example);
        List<TargetModelVO> tmVOList =  GetTargetTree.changeToTreeStructureForTarget(targetList);
        //获取指标
        return tmVOList;
    }


    @Override
    @ServiceLog(doAction = "作废指标")
    public int invalidTarget(String targetId,User user) {
        if(StringUtils.isEmpty(targetId)){
            logger.warn("[指标管理-作废指标]，指标ID不存在");
            throw new JnSpringCloudException(DataUploadExceptionEnum.TARGET_IS_BLANK);
        }
        TbDataReportingTarget tbDataReportingTarget =new TbDataReportingTarget();
        tbDataReportingTarget.setTargetId(targetId);
        tbDataReportingTarget.setRecordStatus(new Byte(DataUploadConstants.INVALID));
        tbDataReportingTarget.setModifiedTime(new Date());
        tbDataReportingTarget.setModifierAccount(user.getAccount());
        return tbDataReportingTargetMapper.updateByPrimaryKeySelective(tbDataReportingTarget);
    }

    @Override
    @ServiceLog(doAction = "指标")
    @Transactional(rollbackFor = Exception.class)
    public int updateTarget(TargetVO target,User user) {
        Integer result = 0;
        logger.info(target.toString());
        TbDataReportingTarget targetPO = new TbDataReportingTarget();
        BeanUtils.copyProperties(target,targetPO);
        if(StringUtils.isBlank(String.valueOf(target.getIsMuiltRow()))){
            throw new JnSpringCloudException(DataUploadExceptionEnum.TARGET_ISMUILTROW_IS_NOT_EXIST);
        }
        if(StringUtils.isBlank(String.valueOf(target.getTargetType()))){
            throw new JnSpringCloudException(DataUploadExceptionEnum.TARGET_TYPE_IS_NOT_EXIST);
        }
        if(StringUtils.isBlank(String.valueOf(target.getRecordStatus()))){
            target.setRecordStatus(Integer.parseInt(DataUploadConstants.VALID));
        }
        targetPO.setIsMuiltRow(new Byte(target.getIsMuiltRow().toString()));
        targetPO.setTargetType(new Byte(target.getTargetType().toString()));
        targetPO.setRecordStatus(new Byte(target.getRecordStatus().toString()));

        logger.info(targetPO.toString());
        targetPO.setModifiedTime(new Date());
        targetPO.setModifierAccount(user.getAccount());
        List<TbDataReportingTargetGroup>  listInput =new ArrayList<>();
        List<InputFormatModel> inputFormatModelList  = target.getInputFormatModels();
        TbDataReportingTargetGroup tbDataReportingTargetGroup=null;


        if(StringUtils.isEmpty(target.getTargetId())){
            String targetId= UUID.randomUUID().toString().replaceAll("-","");
            targetPO.setTargetId(targetId);
            targetPO.setCreatorAccount(user.getAccount());
            targetPO.setCreatedTime(new Date());
            result = tbDataReportingTargetMapper.insertSelective(targetPO);
        }else{
            invalidTargetInputFormat(targetPO.getTargetId());
            targetPO.setModifierAccount(user.getAccount());
            targetPO.setModifiedTime(new Date());
            result = tbDataReportingTargetMapper.updateByPrimaryKeySelective(targetPO);
        }

        for(InputFormatModel inputFormatModel :inputFormatModelList){
            String formId= UUID.randomUUID().toString().replaceAll("-","");

            tbDataReportingTargetGroup = new TbDataReportingTargetGroup();
            BeanUtils.copyProperties(inputFormatModel,tbDataReportingTargetGroup);
            tbDataReportingTargetGroup.setTargetId(targetPO.getTargetId());
            tbDataReportingTargetGroup.setRequired(new Byte(inputFormatModel.getRequired()));
            tbDataReportingTargetGroup.setRecordStatus(new Byte(inputFormatModel.getRecordStatus()));
            tbDataReportingTargetGroup.setOrderNumber(inputFormatModel.getOrderNumber());
            tbDataReportingTargetGroup.setFormId(formId);
            logger.info(tbDataReportingTargetGroup.toString());
            listInput.add(tbDataReportingTargetGroup);
        }

        targetDao.createInputFormater(listInput);
        return result;
    }


    /**
     * 作废指标填报格式
     * @param targetId
     * @return
     */
    private void invalidTargetInputFormat(String targetId) {
        TbDataReportingTargetGroup tbDataReportingTargetGroup =new TbDataReportingTargetGroup();
        tbDataReportingTargetGroup.setRecordStatus(new Byte(DataUploadConstants.INVALID));
        TbDataReportingTargetGroupCriteria tbDataReportingTargetGroupCriteria= new TbDataReportingTargetGroupCriteria();
        tbDataReportingTargetGroupCriteria.or().andTargetIdEqualTo(targetId);
        tbDataReportingTargetGroupMapper.updateByExampleSelective(tbDataReportingTargetGroup,tbDataReportingTargetGroupCriteria);
    }

    @Override
    @ServiceLog(doAction = "获取模板树")
    public List<TreeData> getModelTree() {
        List<TreeData> treeData = new ArrayList<>();
        TbDataReportingModelCriteria tbDataReportingModelCriteria =new TbDataReportingModelCriteria();
        //0：企业，1：园管委会
        tbDataReportingModelCriteria.setOrderByClause("`order_number` asc");
        List<TbDataReportingModel> tbDataReportingModelList = tbDataReportingModelMapper.selectByExample(tbDataReportingModelCriteria);
        TreeData treeDataCompany = new TreeData();
        treeDataCompany.setId("001");
        treeDataCompany.setText("0");
        treeDataCompany.setText("企业信息上报");
        treeDataCompany.setChildren(getTreeData(tbDataReportingModelList,DataUploadConstants.COMPANY_TYPE));
        TreeData treeDataGarden = new TreeData();
        treeDataGarden.setId("002");
        treeDataGarden.setText("0");
        treeDataGarden.setText("园区内部信息上报");
        treeDataGarden.setChildren(getTreeData(tbDataReportingModelList,DataUploadConstants.GARDEN_TYPE));
        treeData.add(treeDataCompany);
        treeData.add(treeDataGarden);
        return treeData;
    }

    /**
     * 按类型获取模板
     * @param tbDataReportingModelList
     * @param type
     * @return
     */
    private List<TreeData> getTreeData(List<TbDataReportingModel> tbDataReportingModelList,String type){
        TreeData treeData =null;
        List<TreeData> treeDataList = new ArrayList<>();
        for(TbDataReportingModel tbDataReportingModel : tbDataReportingModelList){
            if(tbDataReportingModel.getModelType().toString().equals(type)){
                treeData = new TreeData();
                treeData.setId(tbDataReportingModel.getModelId());
                treeData.setText(tbDataReportingModel.getModelName());
                treeData.setOrderNumber(tbDataReportingModel.getOrderNumber());
                treeDataList.add(treeData);
            }
        }
        return treeDataList;
    }

    @Override
    @ServiceLog(doAction = "更新/插入模板信息")
    @Transactional(rollbackFor = Exception.class)
    public int updateModel(ModelDataVO modelDataVO,User user) {
        Integer result = 0;
        String modleId = modelDataVO.getModelId();
        TbDataReportingModel tbDataReportingModel = new TbDataReportingModel();
        BeanUtils.copyProperties(modelDataVO,tbDataReportingModel);
        tbDataReportingModel.setModelType(modelDataVO.getModelType());
        tbDataReportingModel.setModelCycle(modelDataVO.getModelCycle());
        tbDataReportingModel.setRecordStatus(modelDataVO.getRecordStatus());
        tbDataReportingModel.setOrderNumber(modelDataVO.getOrderNumber());
        List<TabVO> tabVOList =  modelDataVO.getTabs();
        TbDataReportingModelTab tbDataReportingModelTab=null;
        tbDataReportingModel.setModifiedTime(new Date());
        tbDataReportingModel.setModifierAccount(user.getAccount());
        if(StringUtils.isBlank(modleId)){
            //创建model_id;插入模板基本信息
            String modelId=UUID.randomUUID().toString().replaceAll("-","");
            tbDataReportingModel.setModelId(modelId);
            tbDataReportingModel.setCreatedTime(new Date());
            tbDataReportingModel.setCreatorAccount(user.getAccount());
            tbDataReportingModelMapper.insertSelective(tbDataReportingModel);

        }else{
            //作废Tabs
            invalidTabs(modleId);
            tbDataReportingModelMapper.updateByPrimaryKeySelective(tbDataReportingModel);
        }

        List<TbDataReportingModelTab> tbDataReportingModelTabList = new ArrayList<>();
        List<TbDataReportingModelStruct> tbDataReportingModelStructList = new ArrayList<>();
        if(tabVOList !=null && tabVOList.size()>0){

            TbDataReportingModelStruct tbDataReportingModelStruct =null;
            for(TabVO tabVO: tabVOList){
                tbDataReportingModelTab = new TbDataReportingModelTab();
                BeanUtils.copyProperties(tabVO,tbDataReportingModelTab);
                if(tabVO.getTabCreateType().toString().equals(DataUploadConstants.IS_SCIENT_MODEL)){
                    //科技园模板单独处理
                    tbDataReportingModelTab.setTabClumnType(null);
                    tbDataReportingModelTab.setTabClumnTargetShow("");

                }else{
                    tbDataReportingModelTab.setTabClumnType(new Byte(tabVO.getTabClumnType()));
                }

                if(StringUtils.isNotBlank(tabVO.getStatus())){
                    tbDataReportingModelTab.setStatus(new Byte(tabVO.getStatus()));
                }else{
                    tbDataReportingModelTab.setStatus(new Byte(DataUploadConstants.VALID));
                }
                tbDataReportingModelTab.setTabCreateType(new Byte(tabVO.getTabCreateType()));
                tbDataReportingModelTab.setOrderNumber(tabVO.getOrderNumber());
                //tabId是空的
                String tabId =UUID.randomUUID().toString().replaceAll("-","");
                tbDataReportingModelTab.setTabId(tabId);
                tbDataReportingModelTab.setModelId(tbDataReportingModel.getModelId());
                tbDataReportingModelTabList.add(tbDataReportingModelTab);

                List<TargetModelVO>  tgList =tabVO.getTargetList();

                if(tgList !=null && tgList.size()>0){
                    for(TargetModelVO tg : tgList){
                        tbDataReportingModelStruct = new TbDataReportingModelStruct();
                        String uuid =UUID.randomUUID().toString().replaceAll("-","");
                        tbDataReportingModelStruct.setId(uuid);
                        tbDataReportingModelStruct.setTargetId(tg.getId());
                        tbDataReportingModelStruct.setTabId(tabId);
                        tbDataReportingModelStruct.setModelId(tbDataReportingModel.getModelId());
                        tbDataReportingModelStructList.add(tbDataReportingModelStruct);
                    }
                }


            }

            //创建模板对应的Tab，保存tab信息
            if(tbDataReportingModelTabList != null &&tbDataReportingModelTabList.size()>0){
                targetDao.createTab(tbDataReportingModelTabList);
                if(tbDataReportingModelStructList !=null && tbDataReportingModelStructList.size()>0){
                    //建立Tab和指标之间的关系
                    targetDao.createRelation(tbDataReportingModelStructList);
                }
            }

        }
        result=1;
        return result;
    }


    /**
     * 作废关联至modelId的tab
      * @param modelId
     */
    private void invalidTabs(String modelId){
        TbDataReportingModelTab tbDataReportingModelTab =new TbDataReportingModelTab();
        tbDataReportingModelTab.setStatus(new Byte(DataUploadConstants.INVALID));
        TbDataReportingModelTabCriteria tbDataReportingModelTabCriteria =new TbDataReportingModelTabCriteria();
        tbDataReportingModelTabCriteria.or().andModelIdEqualTo(modelId);
        tbDataReportingModelTabMapper.updateByExampleSelective(tbDataReportingModelTab,tbDataReportingModelTabCriteria);
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
        TbDataReportingModel modelDataPO =tbDataReportingModelMapper.selectByPrimaryKey(modelId);
        BeanUtils.copyProperties(modelDataPO,modelData);
        modelData.setModelType(modelDataPO.getModelType());
        modelData.setModelCycle(modelDataPO.getModelCycle());
        modelData.setRecordStatus(modelDataPO.getRecordStatus());
        modelData.setOrderNumber(modelDataPO.getOrderNumber());

        if(modelDataPO == null){
            logger.warn("[指标管理-获取模板信息]，模板不存在");
            throw new JnSpringCloudException(DataUploadExceptionEnum.MODEL_IS_NOT_EXIST);
        }

        TbDataReportingModelTabCriteria exampleTab =  new TbDataReportingModelTabCriteria();
        exampleTab.or().andModelIdEqualTo(modelDataPO.getModelId()).andStatusEqualTo(new Byte(DataUploadConstants.VALID));
        List<TbDataReportingModelTab> tabPOList = tbDataReportingModelTabMapper.selectByExample(exampleTab);

        List<TabVO> tabVOList = new ArrayList<>();
        TabVO tabVO =null;
        TargetModelVO targetVO = null;
        InputFormatModel inputFormatModel =null;
        List<TargetModelVO> listTargetVO =null;
        //List<InputFormatModel>  inputFormatModelListVO =null;
        for (int tabIndex=0 ,tabSize =tabPOList.size();tabIndex<tabSize;tabIndex++) {
            tabVO = new TabVO();
            BeanUtils.copyProperties(tabPOList.get(tabIndex),tabVO);
            if(tabPOList.get(tabIndex).getTabCreateType().toString().equals(DataUploadConstants.IS_SCIENT_MODEL)){
                tabVO.setTabClumnType(null);
            }else{
                tabVO.setTabClumnType(tabPOList.get(tabIndex).getTabClumnType().toString());
            }
            tabVO.setTabCreateType(tabPOList.get(tabIndex).getTabCreateType().toString());

            tabVO.setStatus(tabPOList.get(tabIndex).getStatus().toString());

            tabVO.setOrderNumber(tabPOList.get(tabIndex).getOrderNumber());


            listTargetVO = new ArrayList<>();
            //自己写语句
            List<TbDataReportingTarget> targetList = targetDao.getTargetFromTab(tabPOList.get(tabIndex).getTabId());

            if(targetList !=null || targetList.size()>0){
                for(int targetIndex=0 ,targetSize =targetList.size();targetIndex<targetSize;targetIndex++){
                    //inputFormatModelListVO = new ArrayList<>();
                    targetVO = new TargetModelVO();
                    BeanUtils.copyProperties(targetList.get(targetIndex),targetVO);
                    targetVO.setIsMuiltRow(targetList.get(targetIndex).getIsMuiltRow().toString());
                    targetVO.setTargetType(targetList.get(targetIndex).getTargetType().toString());
                    targetVO.setRecordStatus(targetList.get(targetIndex).getRecordStatus().toString());

                    targetVO.setId(targetList.get(targetIndex).getTargetId());
                    targetVO.setPid(targetList.get(targetIndex).getParentId());
                    targetVO.setText(targetList.get(targetIndex).getTargetName());
                    listTargetVO.add(targetVO);
                }
            }

            tabVO.setTargetList(listTargetVO);
            tabVOList.add(tabVO);
        }
        modelData.setTabs(tabVOList);


        return modelData;
    }

    @Override
    @ServiceLog(doAction = "获取群组条件")
    public List<GroupModel> getGroupList() {
        TbDataReportingGroupStructCriteria tbDataReportingGroupStructCriteria =new TbDataReportingGroupStructCriteria();
        tbDataReportingGroupStructCriteria.or().andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        tbDataReportingGroupStructCriteria.setOrderByClause(" `create_time` asc ");
        List<TbDataReportingGroupStruct> tbDataReportingGroupStructList = tbDataReportingGroupStructMapper.selectByExample(tbDataReportingGroupStructCriteria);
        List<GroupModel> list = new ArrayList<>();
        GroupModel groupModel =null;

        for(TbDataReportingGroupStruct tbDataReportingGroupStruct:tbDataReportingGroupStructList){
            groupModel = new GroupModel();
            BeanUtils.copyProperties(tbDataReportingGroupStruct,groupModel);
            list.add(groupModel);
        }

        return list;
    }


    @Override
    @ServiceLog(doAction = "通过指标集合查询填报格式信息")
    public List<InputFormatModel> getInputFormatByTargetIds(List<String> tList) {
        List<InputFormatModel> imlist = new ArrayList<>();
        if(tList !=null && tList.size()>0){
            TbDataReportingTargetGroupCriteria example =new TbDataReportingTargetGroupCriteria();
            example.or().andTargetIdIn(tList).andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
            List<TbDataReportingTargetGroup> tgList = tbDataReportingTargetGroupMapper.selectByExample(example);
            InputFormatModel im =null;
            for(TbDataReportingTargetGroup tgBean:tgList){
                im = new InputFormatModel();
                BeanUtils.copyProperties(tgBean,im);
                getInputFormatData(im,tgBean);
                imlist.add(im);
            }
        }
        return imlist;
    }

    @Override
    @ServiceLog(doAction = "获取模板生成的任务全部填报完成后的预警人条件")
    public List<TbDataReportingGardenLinker> getWarner() {
        TbDataReportingGardenLinkerCriteria c = new TbDataReportingGardenLinkerCriteria();
        c.or().andRecordStatusEqualTo(new Byte(DataUploadConstants.VALID));
        List<TbDataReportingGardenLinker> list =tbDataReportingGardenLinkerMapper.selectByExample(c);
        return list;
    }
}
