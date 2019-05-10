package org.xxpay.common.enumm;

/**
 * @ClassName：商户缴费类型和商户ID的对应枚举
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/4/28 17:34
 * @Version： v1.0
 * @Modified By:
 */
public enum MchPayTypeEnum {
    //房租
    RENT("01", "10000000")
    //物品租赁费
    ,GOODS_RENTAL_FEE("02", "10000000")
    //电费
    ,ELECTRICITY_FEE("03", "10000000")
    //物业维修费
    ,PROPERTY_REPAIR_FEE("04", "10000000")
    //水费
    ,WATER_FEE("05", "10000000")
    //物业费
    ,PROPERTY_FEE("06", "10000000")
    //停车费
    ,PARKING_FEE("07", "10000000")
    //车位费
    ,PARKING_LOT_FEE("08", "10000000")
    //宣传费
    ,PROPAGANDA_FEE("09", "10000000")
    //商品收费
    ,GOODS_FEE("10", "10000000")
    //体检收费
    ,PHYSICAL_EXAMINATION_FEE("11", "10000000");


    private String code;
    private String mchId;

    private MchPayTypeEnum(String code, String mchId) { this.code = code;
        this.mchId = mchId; }


    public String getCode() { return code; }

    public String getMchId() { return mchId; }

    public static MchPayTypeEnum getMchPayTypeEnum(String code) {
        if (code == null) {
            return null;
        }

        MchPayTypeEnum[] values = MchPayTypeEnum.values();
        for (MchPayTypeEnum e : values) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }

}
