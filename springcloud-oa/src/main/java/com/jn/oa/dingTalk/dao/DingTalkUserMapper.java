package com.jn.oa.dingTalk.dao;

import com.jn.oa.model.Leave;
import com.jn.oa.vo.LeaveApiVo;

import java.util.List;

/**
 * 请假mapper
 *
 * @author： yuanyy
 * @date： Created on 2019/4/17 11:41
 * @version： v1.0
 * @modified By:
 */
public interface DingTalkUserMapper {

    List<String> selectAllDingTalkUserId(String mobile);
}
