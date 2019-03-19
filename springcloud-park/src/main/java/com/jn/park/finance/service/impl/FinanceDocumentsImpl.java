package com.jn.park.finance.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.finance.dao.FinanceDocumentsDao;
import com.jn.park.finance.model.FinanceDocumentsFindAllModel;
import com.jn.park.finance.model.FinanceDocumentsUploadingModel;
import com.jn.park.finance.service.FinanceDocumentsService;
import com.jn.park.finance.vo.FinanceDocumentsFindAllVo;
import com.jn.upload.api.UploadClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 财务文档
 * @author： tangry
 * @date： Created on 2019/3/18
 * @version： v1.0
 * @modified By:
 */
@Service
@Transactional
public class FinanceDocumentsImpl implements FinanceDocumentsService {
    @Autowired
    private FinanceDocumentsDao financeDocumentsDao;
    @Autowired
    private UploadClient uploadClient;

    @Override
    public PaginationData findAll(FinanceDocumentsFindAllModel documentsModel) {
        Page<Object> objects = PageHelper.startPage(documentsModel.getPage(), documentsModel.getRows());
        List<FinanceDocumentsFindAllVo> findAll=financeDocumentsDao.findAll(documentsModel);
        return new  PaginationData(findAll,objects.getTotal());
    }

    @Override
    public String uploading(MultipartFile file, String docId, String docName, String comment,String departmentId,String departmentName,String Account) {
        FinanceDocumentsUploadingModel financeDocumentsUploadingModel=new FinanceDocumentsUploadingModel();
        //获取原文件名
        financeDocumentsUploadingModel.setDocFileName(file.getOriginalFilename());
        //上传文件到服务器得到返回结果
        Result filepath=null;
        try {
            //不需要token的下载文件的上次方法，为true时则需要token才能下载
            filepath= uploadClient.uploadFile(file,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取返回的路径
        String url =(String)filepath.getData();
        financeDocumentsUploadingModel.setDocFileUrl(url);
        //文件上传人
        financeDocumentsUploadingModel.setDocUploader(Account);
        //文档编号
        financeDocumentsUploadingModel.setDocId(docId);
        //文档名称
        financeDocumentsUploadingModel.setDocName(docName);
        //部门ID
        financeDocumentsUploadingModel.setDepartmentId(departmentId);
        //部门名称
        financeDocumentsUploadingModel.setDepartmentName(departmentName);
        //文档说明
        financeDocumentsUploadingModel.setComment(comment);

        financeDocumentsDao.uploading(financeDocumentsUploadingModel);

        return "上传成功";
    }
}
