package com.jn.enterprise.data.tool;

import com.jn.enterprise.data.entity.TbDataReportingModelStruct;
import com.jn.enterprise.data.entity.TbDataReportingSnapshotTarget;
import com.jn.enterprise.data.entity.TbDataReportingTarget;
import com.jn.enterprise.data.vo.TargetModelVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author： yangh
 * @date： Created on 2019/4/12 16:13
 * @version： v1.0
 * @modified By:
 */
public class GetTargetTree {


    /**
     * 递归树-专门指标
     *
     * @param treeDataList
     * @return
     */
    public static List<TargetModelVO> changeToTreeStructureForTarget(List<TbDataReportingTarget> treeDataList) {
        List<TargetModelVO> newTreeDataList = new ArrayList<>();
        TargetModelVO tmVO = null;
        for (TbDataReportingTarget target : treeDataList) {
            if (target.getParentId().equals("0")) {
                tmVO = new TargetModelVO();
                BeanUtils.copyProperties(target, tmVO);

                tmVO.setIsMuiltRow(target.getIsMuiltRow().toString());
                tmVO.setTargetType(target.getTargetType().toString());
                tmVO.setRecordStatus(target.getRecordStatus().toString());

                tmVO.setId(target.getTargetId());
                tmVO.setPid(target.getParentId());
                tmVO.setText(target.getTargetName());
                //获取父节点下的子节点
                tmVO.setChildren(getChildrenNodeForTarget(target.getTargetId(), treeDataList));
                tmVO.setState("open");
                newTreeDataList.add(tmVO);
            }
        }
        return newTreeDataList;
    }

    /**
     * 递归完成儿子的赋值-专门指标
     *
     * @param pid
     * @param treeDataList
     * @return
     */
    private static List<TargetModelVO> getChildrenNodeForTarget(String pid, List<TbDataReportingTarget> treeDataList) {
        List<TargetModelVO> newTreeDataList = new ArrayList<>();
        TargetModelVO tmVO = null;
        for (TbDataReportingTarget t : treeDataList) {
            if (t.getParentId() == null) {
                continue;
            }
            //这是一个子节点
            if (t.getParentId().equals(pid)) {
                tmVO = new TargetModelVO();
                BeanUtils.copyProperties(t, tmVO);
                tmVO.setIsMuiltRow(t.getIsMuiltRow().toString());
                tmVO.setTargetType(t.getTargetType().toString());
                tmVO.setRecordStatus(t.getRecordStatus().toString());


                tmVO.setId(t.getTargetId());
                tmVO.setPid(t.getParentId());
                tmVO.setText(t.getTargetName());
                //递归获取子节点下的子节点
                tmVO.setChildren(getChildrenNodeForTarget(t.getTargetId(), treeDataList));
                newTreeDataList.add(tmVO);
            }
        }
        return newTreeDataList;
    }


    /**
     * 递归树-生成表单
     *
     * @param treeDataList
     * @return
     */
    public static List<TargetModelVO> changeToTreeStructure(List<TbDataReportingSnapshotTarget> treeDataList) {
        List<TargetModelVO> newTreeDataList = new ArrayList<>();
        TargetModelVO tmVO = null;
        for (TbDataReportingSnapshotTarget target : treeDataList) {
            if (target.getParentId().equals("0")) {
                tmVO = new TargetModelVO();
                BeanUtils.copyProperties(target, tmVO);
                tmVO.setIsMuiltRow(target.getIsMuiltRow().toString());
                tmVO.setTargetType(target.getTargetType().toString());
                tmVO.setRecordStatus(target.getRecordStatus().toString());


                tmVO.setId(target.getTargetId());
                tmVO.setPid(target.getParentId());
                tmVO.setText(target.getTargetName());
                //获取父节点下的子节点
                tmVO.setChildren(getChildrenNode(target.getTargetId(), treeDataList));
                tmVO.setState("open");
                newTreeDataList.add(tmVO);
            }
        }
        return newTreeDataList;
    }

    /**
     * 递归完成儿子的赋值-生成表单
     *
     * @param pid
     * @param treeDataList
     * @return
     */
    private static List<TargetModelVO> getChildrenNode(String pid, List<TbDataReportingSnapshotTarget> treeDataList) {
        List<TargetModelVO> newTreeDataList = new ArrayList<>();
        TargetModelVO tmVO = null;
        for (TbDataReportingSnapshotTarget t : treeDataList) {
            if (t.getParentId() == null) {
                continue;
            }
            //这是一个子节点
            if (t.getParentId().equals(pid)) {
                tmVO = new TargetModelVO();
                BeanUtils.copyProperties(t, tmVO);

                tmVO.setIsMuiltRow(t.getIsMuiltRow().toString());
                tmVO.setTargetType(t.getTargetType().toString());
                tmVO.setRecordStatus(t.getRecordStatus().toString());

                tmVO.setId(t.getTargetId());
                tmVO.setPid(t.getParentId());
                tmVO.setText(t.getTargetName());
                //递归获取子节点下的子节点
                tmVO.setChildren(getChildrenNode(t.getTargetId(), treeDataList));
                newTreeDataList.add(tmVO);
            }
        }
        return newTreeDataList;
    }

    //将树形指标转换为List
    public static List<TbDataReportingModelStruct> treeToList(List<TbDataReportingModelStruct> result,List<TargetModelVO> treeList,String modelId,String tabId) {
        if(treeList !=null && treeList.size()>0 ){
            for(TargetModelVO tmVo : treeList){
                TbDataReportingModelStruct modelStruct = new TbDataReportingModelStruct();
                modelStruct.setId(UUID.randomUUID().toString().replaceAll("-",""));
                modelStruct.setModelId(modelId);
                modelStruct.setTabId(tabId);
                modelStruct.setTargetId(tmVo.getId());
                if(tmVo.getChildren() !=null && tmVo.getChildren().size()>0){
                    childToList(tmVo.getChildren(),result,modelId,tabId);
                }
                result.add(modelStruct);
            }


        }

        return result;
    }

    private static void childToList(List<TargetModelVO> treeList,List<TbDataReportingModelStruct> result,String modelId,String tabId) {
        for(TargetModelVO tmVo : treeList){
            TbDataReportingModelStruct modelStruct = new TbDataReportingModelStruct();
            modelStruct.setId(UUID.randomUUID().toString().replaceAll("-",""));
            modelStruct.setModelId(modelId);
            modelStruct.setTabId(tabId);
            modelStruct.setTargetId(tmVo.getId());
            result.add(modelStruct);
            if(tmVo.getChildren() !=null && tmVo.getChildren().size()>0){
                childToList(tmVo.getChildren(),result,modelId,tabId);
            }

        }
    }
}