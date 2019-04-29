package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/29 10:54
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorParkingMonthlyCardShow",description = "月租卡信息获取,包含分页信息")
public class DoorParkingMonthlyCardShow implements Serializable {

    private static final long serialVersionUID = -6397123656605988126L;
    @ApiModelProperty(value="月租卡信息列表")
    List<DoorParkingMonthlyCardInfo> cardInfo;
    @ApiModelProperty(value = "当前页码")
    private String pageNo;
    @ApiModelProperty(value = "返回每页行数")
    private String pageSize;
    @ApiModelProperty(value = "记录总行数")
    private String rows;

    public List<DoorParkingMonthlyCardInfo> getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(List<DoorParkingMonthlyCardInfo> cardInfo) {
        this.cardInfo = cardInfo;
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

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DoorParkingMonthlyCardShow{" +
                "cardInfo=" + cardInfo +
                ", pageNo='" + pageNo + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", rows='" + rows + '\'' +
                '}';
    }
}
