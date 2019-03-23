package com.jn.user.usertag.dao;

import com.jn.user.usertag.entity.TbUserTag;

import java.util.List;

/**
 * 用户标签
 * @author： jiangyl
 * @date： Created on 2019/3/6 17:02
 * @version： v1.0
 * @modified By:
 */
public interface UserTagMapper {

    /**
     * 批量插入用户标注信息
     * @param list
     * @return
     */
    int insertUserTag(List<TbUserTag> list);

}
