package com.jn.enterprise.company.vo;

import com.jn.enterprise.company.model.CompanyInfoShow;
import com.jn.park.activity.model.Comment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/5/27 9:49
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyDetailsVo",description = "企业详情实体")
public class CompanyDetailsVo implements Serializable {

    @ApiModelProperty(value = "企业基本信息")
    private CompanyInfoShow companyInfoShow;

    @ApiModelProperty(value = "评论列表")
    private List<Comment>  comments;

    public CompanyInfoShow getCompanyInfoShow() {
        return companyInfoShow;
    }

    public void setCompanyInfoShow(CompanyInfoShow companyInfoShow) {
        this.companyInfoShow = companyInfoShow;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
