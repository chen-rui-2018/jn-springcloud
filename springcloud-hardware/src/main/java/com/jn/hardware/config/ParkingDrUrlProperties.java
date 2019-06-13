package com.jn.hardware.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 道尔道闸接口地址
 *
 * @Author： cm
 * @Date： Created on 2019/6/12 21:33
 * @Version： v1.0
 * @Modified By:
 */
@Component
@ConfigurationProperties(prefix = "jn.parking.dr")
@RefreshScope
public class ParkingDrUrlProperties {

    /**
     * 道尔的临停预缴费信息(场内缴费)
     */
    private String doorTemporarycarParkingfeeUrl;
    /**
     * 保存道尔的临停预缴费信息(场内缴费)
     */
    private String doorSavePaymentCarparkingfeeUrl;
    /**
     * 保存道尔的月租卡开户信息
     */
    private String doorSaveMonthlyRentCardUrl;
    /**
     * 查询道尔的月租卡开户信息
     */
    private String doorFindMonthlyRentCardUrl;
    /**
     * 保存道尔的月租卡续费信息
     */
    private String doorSaveMonthlyRentalCardRenewalfeeUrl;
    /**
     * 查询道尔的月租卡续费信息
     */
    private String doorFindMonthlyrentcardRateinfoUrl;
    /**
     * 道尔 注销月租卡
     */
    private String doorCancelMonthlyrentAccountUrl;
    /**
     * 道尔 车场车位查询
     */
    private String doorParkingspaceAmountUrl;

    public String getDoorTemporarycarParkingfeeUrl() {
        return doorTemporarycarParkingfeeUrl;
    }

    public void setDoorTemporarycarParkingfeeUrl(String doorTemporarycarParkingfeeUrl) {
        this.doorTemporarycarParkingfeeUrl = doorTemporarycarParkingfeeUrl;
    }

    public String getDoorSavePaymentCarparkingfeeUrl() {
        return doorSavePaymentCarparkingfeeUrl;
    }

    public void setDoorSavePaymentCarparkingfeeUrl(String doorSavePaymentCarparkingfeeUrl) {
        this.doorSavePaymentCarparkingfeeUrl = doorSavePaymentCarparkingfeeUrl;
    }

    public String getDoorSaveMonthlyRentCardUrl() {
        return doorSaveMonthlyRentCardUrl;
    }

    public void setDoorSaveMonthlyRentCardUrl(String doorSaveMonthlyRentCardUrl) {
        this.doorSaveMonthlyRentCardUrl = doorSaveMonthlyRentCardUrl;
    }

    public String getDoorFindMonthlyRentCardUrl() {
        return doorFindMonthlyRentCardUrl;
    }

    public void setDoorFindMonthlyRentCardUrl(String doorFindMonthlyRentCardUrl) {
        this.doorFindMonthlyRentCardUrl = doorFindMonthlyRentCardUrl;
    }

    public String getDoorSaveMonthlyRentalCardRenewalfeeUrl() {
        return doorSaveMonthlyRentalCardRenewalfeeUrl;
    }

    public void setDoorSaveMonthlyRentalCardRenewalfeeUrl(String doorSaveMonthlyRentalCardRenewalfeeUrl) {
        this.doorSaveMonthlyRentalCardRenewalfeeUrl = doorSaveMonthlyRentalCardRenewalfeeUrl;
    }

    public String getDoorFindMonthlyrentcardRateinfoUrl() {
        return doorFindMonthlyrentcardRateinfoUrl;
    }

    public void setDoorFindMonthlyrentcardRateinfoUrl(String doorFindMonthlyrentcardRateinfoUrl) {
        this.doorFindMonthlyrentcardRateinfoUrl = doorFindMonthlyrentcardRateinfoUrl;
    }

    public String getDoorCancelMonthlyrentAccountUrl() {
        return doorCancelMonthlyrentAccountUrl;
    }

    public void setDoorCancelMonthlyrentAccountUrl(String doorCancelMonthlyrentAccountUrl) {
        this.doorCancelMonthlyrentAccountUrl = doorCancelMonthlyrentAccountUrl;
    }

    public String getDoorParkingspaceAmountUrl() {
        return doorParkingspaceAmountUrl;
    }

    public void setDoorParkingspaceAmountUrl(String doorParkingspaceAmountUrl) {
        this.doorParkingspaceAmountUrl = doorParkingspaceAmountUrl;
    }
}
