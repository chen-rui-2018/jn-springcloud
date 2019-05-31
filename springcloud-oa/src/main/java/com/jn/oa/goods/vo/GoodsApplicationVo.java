package com.jn.oa.goods.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.oa.goods.entity.TbOaGoodsApplicationDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 物品管理实体Vo
 * @author： shaobao
 * @date： Created on 2019/5/29 19:37
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "GoodsApplicationVo", description = "物品管理实体")
public class GoodsApplicationVo implements Serializable {
    private static final long serialVersionUID = 1435568363417448846L;

    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "申请总数量")
    private Integer total;

    @ApiModelProperty(value = "部门id")
    private String deptId;

    @ApiModelProperty(value = "创建账号")
    private String creatorAccount;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "审批状态")
    private String approvalStatus;

    List<TbOaGoodsApplicationDetails> tb_oa_goods_application_details;

    public GoodsApplicationVo() {
    }

    public GoodsApplicationVo(String id, Integer total, String deptId, String creatorAccount, Date createdTime,
                              String remark, String approvalStatus, List<TbOaGoodsApplicationDetails> tb_oa_goods_application_details) {
        this.id = id;
        this.total = total;
        this.deptId = deptId;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.remark = remark;
        this.approvalStatus = approvalStatus;
        this.tb_oa_goods_application_details = tb_oa_goods_application_details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public List<TbOaGoodsApplicationDetails> getTb_oa_goods_application_details() {
        return tb_oa_goods_application_details;
    }

    public void setTb_oa_goods_application_details(List<TbOaGoodsApplicationDetails> tb_oa_goods_application_details) {
        this.tb_oa_goods_application_details = tb_oa_goods_application_details;
    }


    @Override
    public String toString() {
        return "GoodsApplicationVo{" +
                "id='" + id + '\'' +
                ", total=" + total +
                ", deptId='" + deptId + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", remark='" + remark + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", tb_oa_goods_application_details=" + tb_oa_goods_application_details +
                '}';
    }
}
