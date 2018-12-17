package com.jn.park.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 园区字典
 *
 * @author： jiangyl
 * @date： Created on 2018/12/17 10:52
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkCode", description = "园区字典")
public class ParkCode extends Page implements Serializable {
    private String id;

    private String groupId;

    private String groupName;

    private String codeValue;

    private String codeName;

    private String state;

    private String createAccount;

    private Date createTime;

    private String updateAccount;

    private Date updateTime;
}
