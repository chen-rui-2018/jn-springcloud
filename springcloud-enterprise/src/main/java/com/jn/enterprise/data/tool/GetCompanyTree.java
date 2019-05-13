package com.jn.enterprise.data.tool;

import com.jn.enterprise.data.model.CompanyTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetCompanyTree {


    //传入list 转化成树形
    public  List<Map> bulid(List<CompanyTree> treeNodes) {
        List<Map> list = new ArrayList<>();
        for (CompanyTree treeNode : treeNodes) {
            if ("0".equals(treeNode.getParentid())) {
                Map<String, List> map = new HashMap<>();
                ArrayList<CompanyTree> companyTrees = new ArrayList<>();
                for (CompanyTree it : treeNodes) {
                    if (it.getParentid().equals(treeNode.getTargetid())) {
                        if (treeNode.getChildren() == null) {
                            companyTrees.add(it);
                        }
                    }
                }
                treeNode.setChildren(companyTrees);
                map.put(treeNode.getTargetname(), companyTrees);
                list.add(map);
            }
        }
        return list;
    }


    //传入list 转化成树形
    public List<CompanyTree> bulidscience(List<CompanyTree> treeNodes) {
        List<CompanyTree> trees = new ArrayList<CompanyTree>();

        for (CompanyTree treeNode : treeNodes) {

            if ("0".equals(treeNode.getParentid())) {
                trees.add(treeNode);
            }

            for (CompanyTree it : treeNodes) {
                if (it.getParentid() == treeNode.getTargetid()) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<CompanyTree>());
                    }
                    treeNode.getChildren().add(it);
                }
            }
        }
        return trees;


    }


    //将树形转换成集合

    public List<CompanyTree> bulidlist(List<CompanyTree> treeNodes) {

        ArrayList<CompanyTree> nlist = new ArrayList();

        for (int i=0;i<treeNodes.size();i++){

            nlist.add(treeNodes.get(i));

            if (treeNodes.get(i).getChildren()!=null){
                List<CompanyTree> child = treeNodes.get(i).getChildren();

                for (int j=0;j<child.size();j++){
                    nlist.add(child.get(j));
                }

                bulidlist(treeNodes.get(i).getChildren());

            }else {
                break;
            }
        }

        return nlist;
    }


}
