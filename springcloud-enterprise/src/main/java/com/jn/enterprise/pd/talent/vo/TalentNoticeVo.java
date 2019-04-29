package com.jn.enterprise.pd.talent.vo;

import com.jn.enterprise.pd.talent.model.TalentNoticeModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 人才服务公告vo
 *
 * @author： wzy
 * @date： Created on 2019/4/10 12:58
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TalentNoticeVo", description = "人才服务公告VO")
public class TalentNoticeVo implements Serializable {

    private static final long serialVersionUID = 8410257011153726973L;

    @ApiModelProperty(value = "人才服务公告管理集合")
    private List<TalentNoticeModel> talentNoticeList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<TalentNoticeModel> getTalentNoticeList() {
        return talentNoticeList;
    }

    public void setTalentNoticeList(List<TalentNoticeModel> talentNoticeList) {
        this.talentNoticeList = talentNoticeList;
    }

    public TalentNoticeVo(List<TalentNoticeModel> talentNoticeList) {
        this.talentNoticeList = talentNoticeList;
    }

    @Override
    public String toString() {
        return "TalentNoticeVo{" +
                "talentNoticeList=" + talentNoticeList +
                '}';
    }
}
