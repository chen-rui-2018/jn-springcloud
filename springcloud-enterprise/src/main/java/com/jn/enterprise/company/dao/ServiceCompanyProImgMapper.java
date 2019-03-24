package com.jn.enterprise.company.dao;

import com.jn.enterprise.company.entity.TbServiceCompanyProImg;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/20 20:46
 * @version： v1.0
 * @modified By:
 */
public interface ServiceCompanyProImgMapper {

    /**
     * 批量插入公司宣传图片
     * @param list
     * @return
     */
    int insertCompanyProImgs(List<TbServiceCompanyProImg> list);

}
