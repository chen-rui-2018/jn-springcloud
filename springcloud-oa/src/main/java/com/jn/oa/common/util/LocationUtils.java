package com.jn.oa.common.util;

/**
 * 经纬度计算两个点的之间的距离
 *
 * @author： yuanyy
 * @date： Created on 2019/5/27 9:37
 * @version： v1.0
 * @modified By:
 */
public class LocationUtils {
    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return 距离
     */
    public static double getDistance(String lat1, String lng1, String lat2,
                                     String lng2) {
        double radLat1 = rad(Double.valueOf(lat1));
        double radLat2 = rad(Double.valueOf(lat2));
        double a = radLat1 - radLat2;
        double b = rad(Double.valueOf(lng1)) - rad(Double.valueOf(lng2));
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }


}
