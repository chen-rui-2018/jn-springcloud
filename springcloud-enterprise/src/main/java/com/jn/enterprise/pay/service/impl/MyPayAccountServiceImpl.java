package com.jn.enterprise.pay.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.LoadBalancerUtil;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.pay.dao.PayAccountAndAccountBookDao;
import com.jn.enterprise.pay.dao.TbPayAccountBookMoneyRecordMapper;
import com.jn.enterprise.pay.entity.TbPayAccountBookMoneyRecordCriteria;
import com.jn.enterprise.pay.service.MyPayAccountService;
import com.jn.enterprise.pd.declaration.enums.PdStatusEnums;
import com.jn.pay.model.PayAccountBook;
import com.jn.pay.model.PayAccountBookMoneyRecord;
import com.jn.pay.vo.PayAccountAndAccountBookVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.model.User;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * 获取系统的服务ID
     */
    private final static String ENT_CLIENT = "springcloud-app-system";
    /**
     * 获取查询字典信息的服务地址
     */
    private final static String ENT_CLIENT__SERVICE = "/api/system/selectDictValueByCondition";

    @Autowired
    private PayAccountAndAccountBookDao payAccountAndAccountBookDao;

    @Autowired
    private TbPayAccountBookMoneyRecordMapper tbPayAccountBookMoneyRecordMapper;

    @Autowired
    private LoadBalancerUtil loadBalancerUtils;

    @ServiceLog(doAction = "我的账户-查询当前账户下所有账本信息")
    @Override
    public PayAccountAndAccountBookVo queryPayAccountBook(String userId) {
        //通过用户ID获取该用户账户并汇总余额查询
        PayAccountAndAccountBookVo abv = payAccountAndAccountBookDao.selectPayAccountId(userId);
        List<PayAccountBook> list = payAccountAndAccountBookDao.selectPayAccountBookList(abv.getAccountId());
        abv.setAccountBooksList(list);
        return abv;
    }

    @ServiceLog(doAction = "我的账本-查询当前账本下所有明细信息")
    @Override
    public PaginationData<List<PayAccountBookMoneyRecord>> queryPayAccountDetails(User user, String acBookId, String startDate, String endDate, int page, int rows) {
        Page<Object> objects = PageHelper.startPage(page, rows);
        TbPayAccountBookMoneyRecordCriteria payCriteria = new TbPayAccountBookMoneyRecordCriteria();
        payCriteria.setOrderByClause("created_time desc");
        TbPayAccountBookMoneyRecordCriteria.Criteria criteria = payCriteria.createCriteria();
        criteria.andRecordStatusEqualTo(PdStatusEnums.EFFECTIVE.getCode());
        criteria.andAcBookIdEqualTo(acBookId);
        if (StringUtils.isNotEmpty(startDate) && StringUtils.isNotEmpty(endDate)) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ParsePosition pos = new ParsePosition(0);
            ParsePosition pos2 = new ParsePosition(0);
            Date strtodate = formatter.parse(startDate, pos);
            Date strtodate2 = formatter.parse(endDate, pos2);
            criteria.andCreatedTimeGreaterThanOrEqualTo(strtodate);
            criteria.andCreatedTimeLessThanOrEqualTo(strtodate2);
        }
        return new PaginationData(tbPayAccountBookMoneyRecordMapper.selectByExample(payCriteria), objects.getTotal());
    }

   
}
