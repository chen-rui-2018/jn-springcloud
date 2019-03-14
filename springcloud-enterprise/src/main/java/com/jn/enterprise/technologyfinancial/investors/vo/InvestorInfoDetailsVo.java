package com.jn.enterprise.technologyfinancial.investors.vo;

import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceInvestor;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/14 11:46
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorInfoDetailsVo", description = "科技金融投资人详情")
public class InvestorInfoDetailsVo implements Serializable {
    private TbServiceInvestor tbServiceInvestor;
}
