package com.jn.hr.train.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.train.entity.TbManpowerTrainRecord;
import com.jn.hr.train.model.Management;
import com.jn.hr.train.model.ManagementPage;
import com.jn.hr.train.model.ManagementTrainRecord;

/**
 * 
 * 培训记录
 * @author： wangtt
 * @date：Created on  2019/04/16 06:43 
 * @version： v1.0
 * @modified By:
 **/
public interface TrainRecordMapper {
	/** 
	 * 跟据培训id查询接受培训的员工列表
	 * @param managementId
	 * @return 
	 */
	List<ManagementTrainRecord> listByMangementId(@Param("managementId") String managementId);

	/**跟据培训id和培训人，查询培训记录
	 * @param record
	 * @return
	 */
	int listByMangementIdAndJobNumber(TbManpowerTrainRecord record);

	/**
	 * 跟据培训id查询接受培训的员工个数
	 * @param managementId
	 * @return
	 */
	int selectCountByMangementId(@Param("managementId") String managementId);

	/**培训记录
	 * @param page
	 * @return
	 */
	List<Management> listMangementAndRecord(ManagementPage page);

}
