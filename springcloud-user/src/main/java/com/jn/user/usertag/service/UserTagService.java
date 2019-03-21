package com.jn.user.usertag.service;

import com.jn.user.usertag.model.TagCode;

import java.util.List;

/**
 * 用户标签
 * @author： jiangyl
 * @date： Created on 2019/3/6 16:48
 * @version： v1.0
 * @modified By:
 */
public interface UserTagService {

    /**
     * 获取用户字典列表
     * @return
     */
    List<TagCode> getTagCodeList();

}
