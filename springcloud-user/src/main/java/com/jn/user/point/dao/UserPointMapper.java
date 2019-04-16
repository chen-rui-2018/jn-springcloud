package com.jn.user.point.dao;

import com.jn.user.point.entity.TbUserPointDetail;
import com.jn.user.point.model.UserPointParam;
import com.jn.user.point.model.UserPointVO;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/3 19:33
 * @version： v1.0
 * @modified By:
 */
public interface UserPointMapper {

    /**
     * 查询用户积分
     * @param userPointParam
     * @return
     */
    List<UserPointVO> getUserPoint(UserPointParam userPointParam);

    /**
     * 批量插入积分明细
     * @param list
     * @return
     */
    int insertPointDetailList(List<TbUserPointDetail> list);
}
