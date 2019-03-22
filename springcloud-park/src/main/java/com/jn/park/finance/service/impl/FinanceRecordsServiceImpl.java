package com.jn.park.finance.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.park.finance.dao.FinanceRecordsDao;
import com.jn.park.finance.model.FinanceRecordsFindAllModel;
import com.jn.park.finance.model.FinanceRecordsFindDetailModel;
import com.jn.park.finance.service.FinanceRecordsService;
import com.jn.park.finance.vo.FinanceDocumentsFindAllVo;
import com.jn.park.finance.vo.FinanceRecordsFindAllVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 财务备案
 * @author： tangry
 * @date： Created on 2019/3/20
 * @version： v1.0
 * @modified By:
 */
@Service
@Transactional
public class FinanceRecordsServiceImpl implements FinanceRecordsService {

    @Autowired
    private FinanceRecordsDao financeRecordsDao;

    @Override
    public FinanceRecordsFindDetailModel findDetail() {
        FinanceRecordsFindDetailModel findDetail= financeRecordsDao.findDetail();
        return findDetail;
    }

    @Override
    public PaginationData findAll(FinanceRecordsFindAllModel financeRecordsFindAllModel) {
        Page<Object> objects = PageHelper.startPage(financeRecordsFindAllModel.getPage(), financeRecordsFindAllModel.getRows());
        List<FinanceRecordsFindAllVo> findAll= financeRecordsDao.findAll(financeRecordsFindAllModel);
        return new  PaginationData(findAll,objects.getTotal());
    }
}
