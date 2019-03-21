package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTrait;

import java.util.List;
import java.util.Map;

/**
 * 服务机构特性Mapper
 * @author： jiangyl
 * @date： Created on 2019/2/18 10:53
 * @version： v1.0
 * @modified By:
 */
public interface OrgTraitMapper {

    /**
     * 批量插入服务机构特性值
     * @param map
     * @return
     */
    int insertTraitList(Map<String, Object> map);
}
