package com.jn.park.parking.entity;

import java.io.Serializable;

public class TbParkingService implements Serializable {
    /*@ApiModelProperty("停车场id")*/
    private String parkingId;

    /*@ApiModelProperty("停车场服务id")*/
    private String serverTypeId;

    private static final long serialVersionUID = 1L;

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId == null ? null : parkingId.trim();
    }

    public String getServerTypeId() {
        return serverTypeId;
    }

    public void setServerTypeId(String serverTypeId) {
        this.serverTypeId = serverTypeId == null ? null : serverTypeId.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbParkingService other = (TbParkingService) that;
        return (this.getParkingId() == null ? other.getParkingId() == null : this.getParkingId().equals(other.getParkingId()))
            && (this.getServerTypeId() == null ? other.getServerTypeId() == null : this.getServerTypeId().equals(other.getServerTypeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getParkingId() == null) ? 0 : getParkingId().hashCode());
        result = prime * result + ((getServerTypeId() == null) ? 0 : getServerTypeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", parkingId=").append(parkingId);
        sb.append(", serverTypeId=").append(serverTypeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}