package com.jn.hardware.model.dingtalk.attendance;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName：钉钉：获取打卡结果入参实体类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/18 11:09
 * @Version： v1.0
 * @Modified By:
 */
public class ClockInListParam implements Serializable {

    private static final long serialVersionUID = -5558485922095812172L;

    /**
     * 查询考勤打卡记录的起始工作日。格式为“yyyy-MM-dd HH:mm:ss” "
     * HH:mm:ss可以使用00:00:00，具体查询的时候不会起作用 ,最后将返回此日期从0点到24点的结果
    * */
    @NotBlank(message = "起始工作日不能为空! ,格式为“yyyy-MM-dd HH:mm:ss” ")
    private String workDateFrom;

    /**
     * 查询考勤打卡记录的结束工作日。格式为“yyyy-MM-dd HH:mm:ss”
     *  HH:mm:ss可以使用00:00:00，具体查询的时候不会起作用,最后将返回此日期从0点到24点的结果。注意，起始与结束工作日最多相隔7天
     * */
    @NotBlank(message = "结束工作日不能为空! ,格式为“yyyy-MM-dd HH:mm:ss” ")
    private String workDateTo;

    /**
     * 员工在企业内的UserID列表，企业用来唯一标识用户的字段。最多不能超过50个
    * */
    @NotEmpty(message = "员工在企业内的UserID列表不能为空 ! ,最多不能超过50个")
    private List<String> userIdList ;

    /**
     * 表示获取考勤数据的起始点，第一次传0，如果还有多余数据
     * 下次获取传的offset值为之前的offset+limit，0、1、2...依次递增
    * */
    @NotNull(message = "考勤数据的起始点不能为空 !")
    private Long offset ;

    /**
     * 表示获取考勤数据的条数，最大不能超过50条
    * */
    @NotNull(message = "考勤数据的条数不能为空")
    private Long limit ;

    /**
     * 不必填：	取值为true和false，表示是否为海外企业使用，默认为false。
     * 其中，true：海外平台使用，false：国内平台使用
     */
    private String isI18n  = "false";


    public String getWorkDateFrom() {
        return workDateFrom;
    }

    public void setWorkDateFrom(String workDateFrom) {
        this.workDateFrom = workDateFrom;
    }

    public String getWorkDateTo() {
        return workDateTo;
    }

    public void setWorkDateTo(String workDateTo) {
        this.workDateTo = workDateTo;
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public String getIsI18n() {
        return isI18n;
    }

    public void setIsI18n(String isI18n) {
        this.isI18n = isI18n;
    }

    @Override
    public String toString() {
        return "ClockInListParam{" +
                "workDateFrom='" + workDateFrom + '\'' +
                ", workDateTo='" + workDateTo + '\'' +
                ", userIdList=" + userIdList +
                ", offset=" + offset +
                ", limit=" + limit +
                ", isI18n='" + isI18n + '\'' +
                '}';
    }
}
