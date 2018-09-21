package com.jn.system.service;

import com.jn.common.model.JsonTreeData;
import com.jn.system.model.Resources;

import java.util.List;

public interface ResourcesService {

    void deleteResources(String[] id);

    void insertResources(Resources resources);

    List<JsonTreeData> findResources();

    List<JsonTreeData> findResourcesEMUByResources();

    void updateResources(Resources resources);

    List<Resources> findTByT(Resources resources);

    Resources selectByPrimaryKey(String id);

}
