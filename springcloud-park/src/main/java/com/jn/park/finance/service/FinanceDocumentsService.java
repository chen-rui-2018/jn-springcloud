package com.jn.park.finance.service;

import com.jn.common.model.PaginationData;
import com.jn.park.finance.model.FinanceDocumentsFindAllModel;
import com.jn.system.vo.SysDepartmentPostVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 财务文档
 * @author： tangry
 * @date： Created on 2019/3/18
 * @version： v1.0
 * @modified By:
 */
public interface FinanceDocumentsService {

    /**
     * 财务文档查询
     * @param financeDocumentsFindAllModel
     * @return
     */
    PaginationData findAll(FinanceDocumentsFindAllModel financeDocumentsFindAllModel);


    /**
     * 文档上传
     * @param file 文件
     * @param docId 文件编码
     * @param docName 文件名称
     * @param comment 文件说明
     * @param departmentId 部门ID
     * @param departmentName 部门名称
     * @param account 上传人
     * @return
     */
    String uploading(MultipartFile file, String docId, String docName, String comment, String departmentId,String departmentName,String account);


}
