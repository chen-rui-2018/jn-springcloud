package com.jn.enterprise.technologyfinancial.investors.dao;

import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorEduExp;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorMainArea;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorMainRound;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestorWorkExp;
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
     * @param mainCode 主投领域
     * @param keyWords 关键字
     * @return
     */
    List<InvestorInfoListShow> getInvestorInfoList(@Param("mainCode") String mainCode, @Param("keyWords")String keyWords);

    /**
     * 批量新增投资人主投领域信息
     * @param mainAreaList
     */
    void insertInvestorMainAreaBatch(@Param("list")List<TbServiceInvestorMainArea> mainAreaList);

    /**
     * 批量新增投资人主投轮次信息
     * @param mainRoundList
     */
    void insertInvestorMainRoundBatch(@Param("list")List<TbServiceInvestorMainRound> mainRoundList);

    /**
     * 批量新增投资人工作经历信息
     * @param workExpList
     */
    void insertInvestorWorkExperienceBatch(@Param("list")List<TbServiceInvestorWorkExp> workExpList);

    /**
     * 批量新增投资人教育经历信息
     * @param eduExpList
     */
    void insertInvestorEduExperienceBatch(@Param("list")List<TbServiceInvestorEduExp> eduExpList);
}
