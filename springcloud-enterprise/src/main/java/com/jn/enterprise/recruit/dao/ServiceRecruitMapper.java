package com.jn.enterprise.recruit.dao;

import com.jn.enterprise.recruit.model.ServiceRecruitParam;
import com.jn.enterprise.recruit.model.ServiceRecruitSearchParam;
import com.jn.enterprise.recruit.vo.RecruitDetailsVO;
import com.jn.enterprise.recruit.vo.RecruitVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author： huxw
 * @date： Created on 2019-4-1 17:30:05
 * @version： v1.0
 * @modified By:
 */
public interface ServiceRecruitMapper {

    /**
     * 根据ID获取招聘详情
     * @param id
     * @return
     */
    RecruitDetailsVO getRecruitDetailsById(@Param("id") String id);

    /**
     * 查询企业招聘信息列表
     * @param recruitParam
     * @return
     */
    List<RecruitVO> getRecruitList(ServiceRecruitSearchParam recruitParam);

    /**
     * 企业招聘信息浏览量
     * @param id
     * @return
     */
    Integer addRecruitClickById(@Param("id") String id);


    /**
     * 根据ID删除企业招聘信息条目
     * @param id
     * @return
     */
    Integer delRecruitById(@Param("id") String id,@Param("account") String account,@Param("modifiedTime") Date modifiedTime);

}