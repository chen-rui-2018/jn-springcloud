package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerSocialSecurity;
import com.jn.hr.employee.model.DirectlyLeader;
import com.jn.hr.employee.model.SocialSecurity;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author dt
 * @create 2019-05-05 下午 4:31
 */
public interface SocialSecurityMapper {
    SocialSecurity selectByJobNumber(@Param("jobNumber") String jobNumber);
    int insertBatch(List<TbManpowerSocialSecurity> list);
    @MapKey("jobNumber")
    Map<String,SocialSecurity> selectAllSocialSecurityToMap();
}
