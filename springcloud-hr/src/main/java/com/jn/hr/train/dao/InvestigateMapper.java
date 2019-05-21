package com.jn.hr.train.dao;

import java.util.List;

import com.jn.hr.train.model.InvestigatePage;
import com.jn.hr.train.vo.InvestigatesVo;

/**
 * 
 * 项目
 * @author： wangtt
 * @date：Created on  2019/04/16 06:43 
 * @version： v1.0
 * @modified By:
 **/
public interface InvestigateMapper {

	List<InvestigatesVo> list(InvestigatePage investiagePage);

	List<InvestigatesVo> listQuest(InvestigatePage investiagePage);
}
