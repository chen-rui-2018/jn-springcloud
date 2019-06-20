package com.jn.enterprise.data.tool;

import com.jn.common.util.StringUtils;
import com.jn.enterprise.data.entity.TbDataReportingModelStruct;
import com.jn.enterprise.data.model.CompanyTree;
import com.jn.enterprise.data.vo.TargetModelVO;

import java.util.*;

public class GetCompanyTree {

    //传入list 转化成树形
    public List<CompanyTree> listToTree(List<CompanyTree> treeNodes) {
        List<CompanyTree> trees = new ArrayList<CompanyTree>();
        //首先 放进来的集合有父节点和子节点
        for(CompanyTree treeNode:treeNodes){
            if("0".equals(treeNode.getParentid())){
                trees.add(treeNode);
            }
            for(CompanyTree child:treeNodes){
                if(child.getParentid()!=null&&child.getParentid().equals(treeNode.getTargetid())){
                    List<CompanyTree> children = treeNode.getChildren();
                    if(children==null){
                        treeNode.setChildren(new ArrayList<CompanyTree>());
                    }
                    treeNode.getChildren().add(child);
                }
            }
        }
        return trees;
    }

    //封装
    public List<Map> buildPackage(List<CompanyTree> treeNodes){
        List<CompanyTree> treelist = listToTree(treeNodes);//将普通集合转换成树形
        List<Map> list = new ArrayList<>();
        for (CompanyTree companytree:treelist) {
            GetCompanyTree getCompanyTree = new GetCompanyTree();
            Map map = new HashMap();
            String key = companytree.getTargetname();
            List<CompanyTree> newList = getCompanyTree.treeToList(companytree.getChildren());
            map.put(key,newList);
            list.add(map);
        }
        return list;
    }

    //将树形指标转换为List
    public  List<CompanyTree> treeToList(List<CompanyTree> treeList) {
        List<CompanyTree> result = new ArrayList<>();
        if(treeList !=null && treeList.size()>0 ){
            for(CompanyTree tmVo : treeList){
                if(tmVo.getChildren() !=null && tmVo.getChildren().size()>0){
                    childToList(tmVo.getChildren(),result);
                }
                result.add(tmVo);
            }
        }
        return result;
    }

    private static void childToList(List<CompanyTree> treeList,List<CompanyTree> result) {
        for(CompanyTree tmVo : treeList){
            result.add(tmVo);
            if(tmVo.getChildren() !=null && tmVo.getChildren().size()>0){
                childToList(tmVo.getChildren(),result);
            }
        }
    }

}



