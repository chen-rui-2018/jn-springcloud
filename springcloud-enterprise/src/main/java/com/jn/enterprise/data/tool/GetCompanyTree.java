package com.jn.enterprise.data.tool;

import com.jn.enterprise.data.model.CompanyTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetCompanyTree {


    //传入list 转化成树形
    public static List<Map> bulid(List<CompanyTree> treeNodes) {
        List<Map> list = new ArrayList<>();
        for (CompanyTree treeNode : treeNodes) {
            if ("0".equals(treeNode.getParent_id())) {
                Map<String, List> map = new HashMap<>();
                ArrayList<CompanyTree> companyTrees = new ArrayList<>();
                for (CompanyTree it : treeNodes) {
                    if (it.getParent_id().equals(treeNode.getTarget_id())) {
                        if (treeNode.getChildren() == null) {
                            companyTrees.add(it);
                        }
                    }
                }
                treeNode.setChildren(companyTrees);
                map.put(treeNode.getTarget_name(), companyTrees);
                list.add(map);
            }
        }
        return list;


    }


}
