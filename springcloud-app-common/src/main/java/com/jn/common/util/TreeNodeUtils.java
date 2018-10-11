package com.jn.common.util;

import java.util.ArrayList;
import java.util.List;

import com.jn.common.model.JsonTreeData;

/**
 * 树子节点工具类
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By:
 */
public class TreeNodeUtils {

    /**
     * 转变成父子结构数据
     * 需要注意，最顶级的父亲必须为0
     *
     * @param treeDataList  没加工的DataList列表
     * @return
     */
    public final static List<JsonTreeData> changeToTreeStructure(List<JsonTreeData> treeDataList) {
        List<JsonTreeData> newTreeDataList = new ArrayList<>();
        for (JsonTreeData jsonTreeData : treeDataList) {
            if(jsonTreeData.getPid() .equals("0")) {
                //获取父节点下的子节点
                jsonTreeData.setChildren(getChildrenNode(jsonTreeData.getId(),treeDataList));
                jsonTreeData.setState("open");
                newTreeDataList.add(jsonTreeData);
            }
        }
        return newTreeDataList;
    }

    /**
     * 递归完成儿子的赋值
     * @param pid
     * @param treeDataList
     * @return
     */
    private final static List<JsonTreeData> getChildrenNode(String pid , List<JsonTreeData> treeDataList) {
        List<JsonTreeData> newTreeDataList = new ArrayList<>();
        for (JsonTreeData jsonTreeData : treeDataList) {
            if (jsonTreeData.getPid() == null)  {
                continue;
            }
            //这是一个子节点
            if(jsonTreeData.getPid().equals(pid)){
                //递归获取子节点下的子节点
                jsonTreeData.setChildren(getChildrenNode(jsonTreeData.getId() , treeDataList));
                newTreeDataList.add(jsonTreeData);
            }
        }
        return newTreeDataList;
    }
}