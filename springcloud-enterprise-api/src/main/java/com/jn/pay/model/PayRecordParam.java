package com.jn.pay.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 缴费明细入參实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/18 11:28
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayRecordParam" ,description = "缴费明细入參实体类")
public class PayRecordParam extends Page implements Serializable {
    private static final long serialVersionUID = 366952774908071264L;
}
