package com.jn.enterprise.workflow.task.dao;

import com.jn.enterprise.workflow.task.entity.TbWorkflowTask;
import com.jn.enterprise.workflow.task.entity.TbWorkflowTaskCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbWorkflowTaskMapper {
    long countByExample(TbWorkflowTaskCriteria example);

    int deleteByExample(TbWorkflowTaskCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbWorkflowTask record);

    int insertSelective(TbWorkflowTask record);

    List<TbWorkflowTask> selectByExample(TbWorkflowTaskCriteria example);

    TbWorkflowTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbWorkflowTask record, @Param("example") TbWorkflowTaskCriteria example);

    int updateByExample(@Param("record") TbWorkflowTask record, @Param("example") TbWorkflowTaskCriteria example);

    int updateByPrimaryKeySelective(TbWorkflowTask record);

    int updateByPrimaryKey(TbWorkflowTask record);
}