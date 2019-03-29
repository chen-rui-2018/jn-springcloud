package com.jn.park.sp.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.sp.model.SpDictDepartModel;
import com.jn.park.sp.model.SpMessageModel;
import com.jn.park.sp.vo.SpPowerBusiDetailVo;
import com.jn.park.sp.vo.SpPowerDetailVo;
import com.jn.system.model.User;

import java.util.List;

/**
 * 对外行政审批中心-门户service
 *
 * @author： zhuyz
 * @date： Created on 2019/3/25 16:11
 * @version： v1.0
 * @modified By:
 */
public interface SpPowerPortalService {

    /**
     * 通过业务id查询业务明细内容
     *
     * @param id
     * @return
     */
    SpPowerBusiDetailVo getBusi(String id);

    /**
     *通过权力id查询权力的明细内容
     *
     * @param id
     * @return
     */
    List<SpPowerDetailVo> get(String id);

    /**
     * 通过部门名称获取全部的实施部门(模糊查询)
     *
     * @param name
     * @return
     */
    List<SpDictDepartModel> departList(String name);

    /**
     * 返回全部的权力清单(包含孩子)
     *
     * @param name
     * @param parentId
     * @param departId
     * @param type
     * @param code
     * @param page
     * @return
     */
    PaginationData findByPage(String name, String parentId, String departId, String type, String code, Page page);

    /**
     * 我要留言
     *
     * @param spMessageModel
     */
    Integer SpMessage(SpMessageModel spMessageModel, User user);

}
