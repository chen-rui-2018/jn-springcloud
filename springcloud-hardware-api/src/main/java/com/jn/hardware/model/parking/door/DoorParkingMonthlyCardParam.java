package com.jn.hardware.model.parking.door;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/18 19:43
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorParkingMonthlyCardParam" ,description = "获取月租卡信息入参实体")
public class DoorParkingMonthlyCardParam  implements Serializable {
    @ApiModelProperty(value = "车场编号",required = true ,example = "100010_0004")
    private String parkid;
    @ApiModelProperty(value = "车牌号码 车牌号码 为空查询所有记录",example = "粤B7PU23")
    private String carNo;
    @ApiModelProperty(value = "最后操作时间 查询最后操作时间>=该时间的记录，无则返回所有",example = "2019-04-18")
    private String userDate;
    @ApiModelProperty(value = "页码 页码 默认值1" ,example = "1")
    private String pageNo;
    @ApiModelProperty(value = "每页条数 页面大小 默认值10",example = "10")
    private String pageSize;

    public String getParkid() {
        return parkid;
    }

    public void setParkid(String parkid) {
        this.parkid = parkid;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "DoorParkingMonthlyCardParam{" +
                "parkid='" + parkid + '\'' +
                ", carNo='" + carNo + '\'' +
                ", userDate='" + userDate + '\'' +
                ", pageNo='" + pageNo + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }
}
