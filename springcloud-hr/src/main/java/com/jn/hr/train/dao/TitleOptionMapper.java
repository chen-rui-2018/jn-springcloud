package com.jn.hr.train.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.train.entity.TbManpowerTrainQuestTitleOption;
import com.jn.hr.train.entity.TbManpowerTrainTitleOption;

/**
 * 选项
 *
 * @author： wangtt
 * @date：Created on  2019/04/16 06:43 
 * @version： v1.0
 * @modified By:
 **/
public interface TitleOptionMapper {
	/** 
	 * 跟据题目id，查询 调研项目 问题选项列表
	 * @param titleId
	 * @return 调研分析问题选项列表
	 */
	List<TbManpowerTrainTitleOption> list(@Param("titleId") String titleId);

	/**
	 * 删除调研题目选项
	 * @param titleId
	 * @return
	 */
	int deleteByTitleId(@Param("titleId") String titleId);

	/** 
	 * 跟据题目id，查询  问卷调查  问题选项列表
	 * @param titleId
	 * @return 问卷调查问题选项列表
	 */
	List<TbManpowerTrainQuestTitleOption> listQuest(@Param("titleId") String titleId);

	/**删除问卷题目
	 * @param titleId
	 * @return
	 */
	int deleteQuestByTitleId(@Param("titleId") String titleId);
}
