package com.jn.hr.train.dao;

import java.util.List;

import com.jn.hr.train.model.Management;
import com.jn.hr.train.model.ManagementPage;

/**
 * 
 *
 * @author： wangtt
 * @date：Created on  2019/04/16 06:43 
 * @version： v1.0
 * @modified By:
 **/
public interface ManagementMapper {

	/**获取培训列表
	 * @param managementPage
	 * @return
	 */
	List<Management> listManagement(ManagementPage managementPage);

	List<Management> list(ManagementPage managementPage);
}
