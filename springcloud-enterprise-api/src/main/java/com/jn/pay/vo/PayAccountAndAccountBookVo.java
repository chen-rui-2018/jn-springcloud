package com.jn.pay.vo;

import com.jn.common.model.Page;
import com.jn.pay.model.PayAccountBook;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 账户账本查询VO
 *
 * @author： wzy
 * @date： Created on 2019/5/5 14:48
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccountAndAccountBookVo" ,description = "账户账本查询VO")
public class PayAccountAndAccountBookVo implements Serializable {
    private static final long serialVersionUID = 1250820710541049549L;

    @ApiModelProperty(value="用户ID")
    private String accountId;

    @ApiModelProperty(value="账户ID")
    private String userId;

    @ApiModelProperty(value="余额（该账户下所有账本总金额）")
    private BigDecimal balance;

    private List<PayAccountBook> accountBooksList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<PayAccountBook> getAccountBooksList() {
        return accountBooksList;
    }

    public void setAccountBooksList(List<PayAccountBook> accountBooksList) {
        this.accountBooksList = accountBooksList;
    }
}
