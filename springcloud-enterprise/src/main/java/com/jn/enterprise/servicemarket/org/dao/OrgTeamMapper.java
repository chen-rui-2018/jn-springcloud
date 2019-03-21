package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTeam;

import java.util.List;

/**
 * 机构团队信息Mapper
 * @author： jiangyl
 * @date： Created on 2019/2/20 14:47
 * @version： v1.0
 * @modified By:
 */
public interface OrgTeamMapper {

    /**
     * 批量插入机构服务团队数据
     * @param list
     * @return
     */
    int insertTeamList(List<TbServiceOrgTeam> list);

}
