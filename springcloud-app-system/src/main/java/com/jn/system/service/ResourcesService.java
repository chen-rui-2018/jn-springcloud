package com.jn.system.service;

import com.jn.common.model.JsonTreeData;
import com.jn.system.model.Resources;

import java.util.List;
/**
 * 资源
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public interface ResourcesService {

    void deleteResources(String[] id);

    void insertResources(Resources resources);

    List<JsonTreeData> findResources();

    List<JsonTreeData> findResourcesEMUByResources();

    void updateResources(Resources resources);

    List<Resources> findTByT(Resources resources);

    Resources selectByPrimaryKey(String id);

}
