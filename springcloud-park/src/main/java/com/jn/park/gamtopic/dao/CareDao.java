package com.jn.park.gamtopic.dao;

import com.jn.park.gamtopic.model.CareUserDetails;
import com.jn.park.gamtopic.model.CareUserShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/15 17:40
 * @version： v1.0
 * @modified By:
 */
public interface CareDao {
    /**
     * 用户关注列表
     * @param account
     * @return
     */
    List<CareUserShow> findCareList(@Param("account") String account);
    /**
     * 用户粉丝列表
     * @param account
     * @return
     */
    List<CareUserShow> findFansList(@Param("account") String account);

    /**
     * 查找关注人信息
     * @param account
     * @param currentAccount
     * @return
     */
    CareUserDetails findCareDetails(@Param("account") String account, @Param("currentAccount")String currentAccount);

}
