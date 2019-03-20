package com.jn.park.finance.dao;

import com.jn.park.finance.model.FinanceDocumentsFindAllModel;
import com.jn.park.finance.model.FinanceDocumentsUploadingModel;
import com.jn.park.finance.vo.FinanceDocumentsFindAllVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 财务文档
 * @author： tangry
 * @date： Created on 2019/3/18
 * @version： v1.0
 * @modified By:
 */
@Component("FinanceDocumentsDao")
public interface FinanceDocumentsDao {

    /**
     * 财务文档
     * @param financeDocumentsFindAllModel
     * @return
     */
    List<FinanceDocumentsFindAllVo> findAll(FinanceDocumentsFindAllModel financeDocumentsFindAllModel);


    /**
     * 文档上传保存数据
     * @param financeDocumentsUploadingModel
     */
    void uploading(FinanceDocumentsUploadingModel financeDocumentsUploadingModel);
}
