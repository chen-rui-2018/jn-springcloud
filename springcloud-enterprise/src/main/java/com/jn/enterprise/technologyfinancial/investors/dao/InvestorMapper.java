package com.jn.enterprise.technologyfinancial.investors.dao;

import com.jn.enterprise.technologyfinancial.investors.model.InvestorInfoListShow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 投资人列表查询
 * @Author: yangph
 * @Date: 2019/3/9 17:13
 * @Version v1.0
 * @modified By:
 */
@Repository
public interface InvestorMapper {
    /**
     * 投资人列表查询
     * @param mainArea 主投领域
     * @param keyWords 关键字
     * @return
     */
    List<InvestorInfoListShow> getInvestorInfoList(@Param("mainCode") String mainArea, @Param("keyWords")String keyWords);
}
