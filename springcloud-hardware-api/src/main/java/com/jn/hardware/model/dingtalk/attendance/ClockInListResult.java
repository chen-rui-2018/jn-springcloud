package com.jn.hardware.model.dingtalk.attendance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jn.hardware.model.dingtalk.BaseResult;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName：钉钉：获取打卡结果出参实体类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/18 11:55
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClockInListResult extends BaseResult implements Serializable {

    private static final long serialVersionUID = 5813106425650071418L;

    /**
     * 在分页查询时返回，代表是否还有下一页更多数据
     */
    private Boolean hasMore;
    /**
     * 打卡信息列表
    * */
    private List<ClockInInfo> recordresult;

    public List<ClockInInfo> getRecordresult() {
        return recordresult;
    }

    public void setRecordresult(List<ClockInInfo> recordresult) {
        this.recordresult = recordresult;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    @Override
    public String toString() {
        return "ClockInListResult{" +
                "hasMore=" + hasMore +
                ", recordresult=" + recordresult +
                '}';
    }
}
