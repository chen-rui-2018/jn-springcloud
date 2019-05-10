package com.jn.enterprise.pay.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.pay.dao.PayAccountAndAccountBookDao;
import com.jn.enterprise.pay.dao.TbPayAccountBookMoneyRecordMapper;
import com.jn.enterprise.pay.entity.TbPayAccountBookMoneyRecord;
import com.jn.enterprise.pay.entity.TbPayAccountBookMoneyRecordCriteria;
import com.jn.enterprise.pay.model.PayAccountBook;
import com.jn.enterprise.pay.model.PayAccountBookMoneyRecord;
import com.jn.enterprise.pay.service.MyPayAccountService;
import com.jn.enterprise.pay.vo.PayAccountAndAccountBookVo;
import com.jn.enterprise.pd.declaration.enums.PdStatusEnums;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 我的账户(业务实现层)
 *
 * @author： wzy
 * @date： Created on 2019/5/5 11:50
 * @version： v1.0
 * @modified By:
 */
@Service
public class MyPayAccountServiceImpl implements MyPayAccountService {

    private static final Logger logger = LoggerFactory.getLogger(MyPayAccountServiceImpl.class);

    @Autowired
    private PayAccountAndAccountBookDao payAccountAndAccountBookDao;

    @Autowired
    private TbPayAccountBookMoneyRecordMapper tbPayAccountBookMoneyRecordMapper;

    @Override
    public PayAccountAndAccountBookVo queryPayAccountBook(User user) {
        //通过用户ID获取该用户账户并汇总余额查询
        PayAccountAndAccountBookVo abv = payAccountAndAccountBookDao.selectPayAccountId(user.getAccount());
        List<PayAccountBook> list = payAccountAndAccountBookDao.selectPayAccountBookList(abv.getAccountId());
        abv.setAccountBooksList(list);
        return abv;
    }

    @Override
    public PaginationData<List<PayAccountBookMoneyRecord>> queryPayAccountDetails(User user, PayAccountBookMoneyRecord payAccountBookMoneyRecord) {
        Page<Object> objects = PageHelper.startPage(payAccountBookMoneyRecord.getPage(), payAccountBookMoneyRecord.getRows());
        TbPayAccountBookMoneyRecordCriteria payCriteria = new TbPayAccountBookMoneyRecordCriteria();
        payCriteria.setOrderByClause("created_time desc");
        TbPayAccountBookMoneyRecordCriteria.Criteria criteria = payCriteria.createCriteria();
        criteria.andRecordStatusEqualTo(PdStatusEnums.EFFECTIVE.getCode());
        criteria.andAcBookIdEqualTo(payAccountBookMoneyRecord.getAcBookId());
        if (StringUtils.isNotEmpty(payAccountBookMoneyRecord.getNatureCode())) {
            criteria.andNatureCodeEqualTo(payAccountBookMoneyRecord.getNatureCode());
        }
        if (null != payAccountBookMoneyRecord.getCreatedTime()) {
            criteria.andCreatedTimeBetween(payAccountBookMoneyRecord.getCreatedTime(),payAccountBookMoneyRecord.getCreatedTime());
        }
        TbPayAccountBookMoneyRecord newRecord = new TbPayAccountBookMoneyRecord();
        BeanUtils.copyProperties(payAccountBookMoneyRecord,newRecord);
        return new PaginationData(tbPayAccountBookMoneyRecordMapper.selectByExample(payCriteria), objects.getTotal());
    }
}
