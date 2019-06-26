package com.jn.hardware.model.dingtalk.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jn.hardware.model.dingtalk.BaseResult;

import java.io.Serializable;
import java.util.List;

/**
 * 钉钉：获取部门用户详细信息，接口响应实体
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 17:44
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentUserInfoResult extends BaseResult implements Serializable {
    private static final long serialVersionUID = 5324566662258611333L;

    /**
     * 在分页查询时返回，代表是否还有下一页更多数据
     */
    private Boolean hasMore;
    /**
     * 用户列表信息
     */
    private List<DingTalkUser> userlist;

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<DingTalkUser> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<DingTalkUser> userlist) {
        this.userlist = userlist;
    }

    @Override
    public String toString() {
        return "DepartmentUserInfoResult{" +
                "hasMore=" + hasMore +
                ", userlist=" + userlist +
                '}';
    }
}
