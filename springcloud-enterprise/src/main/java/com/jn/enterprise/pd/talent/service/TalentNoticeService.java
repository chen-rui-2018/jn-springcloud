package com.jn.enterprise.pd.talent.service;

import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceNotice;
import java.util.List;

/**
 * 人才服务公告管理service
 *
 * @author： wzy
 * @date： Created on 2019/4/10 9:54
 * @version： v1.0
 * @modified By:
 */
public interface TalentNoticeService {

    /**
     * 查询公告列表
     *
     * @param
     * @return
     */
    List<TbPdTalentServiceNotice> selectByTalentNoticeList(String rangeName,String sortType);

}
