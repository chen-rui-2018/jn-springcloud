package com.jn.pay.model;/**
 * @author： huangbq
 * @date： Created on 2019/5/22 14:08
 * @version： v1.0
 * @modified By:
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/22
 *</pre>
 */
@ApiModel(value = "CreateOrderAndPayReqModel",description ="创建订单并发起支付请求参数对象" )
public class CreateOrderAndPayReqModel extends CreatePayReqBaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID集合（数组）",required = true)
    @NotNull
    private String[] goodsIdArr;

    @ApiModelProperty(value = "商品数量集合（数组），可不传（默认全部商品都是1件），数组长度必需与goodsIdArr一致",required = false)
    private String[] goodsCountArr;


    public String[] getGoodsIdArr() {
        return goodsIdArr;
    }

    public void setGoodsIdArr(String[] goodsIdArr) {
        this.goodsIdArr = goodsIdArr;
    }

    public String[] getGoodsCountArr() {
        return goodsCountArr;
    }

    public void setGoodsCountArr(String[] goodsCountArr) {
        this.goodsCountArr = goodsCountArr;
    }

    @Override
    public String toString() {
        return "CreateOrderAndPayReqModel{" +
                "goodsIdArr=" + Arrays.toString(goodsIdArr) +
                ", goodsCountArr=" + Arrays.toString(goodsCountArr) +
                '}';
    }
}
