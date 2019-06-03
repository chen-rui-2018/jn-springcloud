package com.jn.park.activity.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Arrays;

/**
 * 活动申请人查询/导出入参Bean
 * @author： jiangyl
 * @date： Created on 2018/12/21 17:40
 * @version： v1.0
 * @modified By:
 */

@ApiModel(value = "ActivityApplyParam",description = "活动申请人查询入参")
public class ActivityApplyParam extends Page implements Serializable {
    @ApiModelProperty(value = "活动ID",required = true,example = "92wefjw***")
    @NotBlank(message = "活动id不能为空！")
    private String activityId;

    @ApiModelProperty(value = "活动报名状态(1:报名成功   2:报名待审核，全部传空)",example = "1")
    @Pattern(regexp = "^[1-2]|(\\s*)$",message = "活动报名状态值只能为 1或 2, 1:报名成功-2报名待审核")
    private String applyStatus;

    @ApiModelProperty(value = "[查询时传空]导出excel导出的字段别名 比如：name,phone,sex ...多个字段以数组传递",example = "['name','phone']")
    private String[] exportColName;

    @ApiModelProperty(value = "[查询时传空]excel导出字段的标题 比如：姓名,手机,性别...多个字段以数组传递",example = "['姓名','手机']")
    private String[] exportTitle;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String[] getExportColName() {
        return exportColName;
    }

    public void setExportColName(String[] exportColName) {
        this.exportColName = exportColName;
    }

    public String[] getExportTitle() {
        return exportTitle;
    }

    public void setExportTitle(String[] exportTitle) {
        this.exportTitle = exportTitle;
    }

    @Override
    public String toString() {
        return "ActivityApplyParam{" +
                "activityId='" + activityId + '\'' +
                ", applyStatus='" + applyStatus + '\'' +
                ", exportColName=" + Arrays.toString(exportColName) +
                ", exportTitle=" + Arrays.toString(exportTitle) +
                '}';
    }
}
