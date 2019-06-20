package com.jn.park.attractinvest.dao;

import com.jn.park.attractinvest.entity.TbProjectEnterDetails;

import java.util.List;

/**
 * 项目管理企业入驻明细dao
 *
 * @author： shaobao
 * @date： Created on 2019/4/29 9:48
 * @version： v1.0
 * @modified By:
 **/
public interface ProjectEnterDetailsMapper {

    /**
     * 获取企业入驻详情信息
     *
     * @param projectId 项目id
     * @return
     */
    List<TbProjectEnterDetails> getEnterDeatilsGroupByRTower(String projectId);
}
