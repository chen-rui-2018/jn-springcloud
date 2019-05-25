package com.jn.park.attractinvest.dao;

/**
 * 项目管理dao
 *
 * @author： shaobao
 * @date： Created on 2019/4/29 9:48
 * @version： v1.0
 * @modified By:
 **/
public interface ProjectInfoMapper {
    /**
     * 更新拟制合同超出3个工作日的项目状态
     */
    void updateProjectStatus1();

    /**
     * 更新拟制合同超出5个工作日的项目状态
     */
    void updateProjectStatus2();
}
