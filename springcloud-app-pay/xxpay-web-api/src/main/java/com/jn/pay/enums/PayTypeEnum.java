package com.jn.pay.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @ClassName：缴费类型枚举类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/7 11:15
 * @Version： v1.0
 * @Modified By:
 */
public enum PayTypeEnum implements CodeAndMsg {

    RENT("01", "房租")
    ,GOODS_RENTAL_FEE("02", "物品租赁费")
    ,ELECTRICITY_FEE("03", "电费")
    ,PROPERTY_REPAIR_FEE("04", "物业维修费")
    ,WATER_FEE("05", "水费")
    ,PROPERTY_FEE("06", "物业费")
    ,PARKING_FEE("07", "停车费")
    ,PARKING_LOT_FEE("08", "车位费")
    ,PROPAGANDA_FEE("09", "宣传费")
    ,GOODS_FEE("10", "商品收费")
    ,PHYSICAL_EXAMINATION_FEE("11", "体检收费");

    private String code;
    private String message;

    PayTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }


    public static PayTypeEnum getCode(String channelId) {
        PayTypeEnum channelIdEnum = null;
        for (PayTypeEnum channelType : values()) {
            if (channelType.getCode() == channelId) {
                //获取指定的枚举
                channelIdEnum = channelType;
                break;
            }
        }

        return channelIdEnum;
    }
}
