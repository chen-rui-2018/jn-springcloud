package com.jn.unionpay.paycode.service.impl;

import com.jn.paycode.model.PaymentCode;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.unionpay.paybill.enums.PayBillEnum;
import com.jn.unionpay.paycode.dao.TbPaymentCodeMapper;
import com.jn.unionpay.paycode.entity.TbPaymentCode;
import com.jn.unionpay.paycode.entity.TbPaymentCodeCriteria;
import com.jn.unionpay.paycode.service.PayCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/12 17:29
 * @version： v1.0
 * @modified By:
 */
@Service
public class PayCodeServiceImpl implements PayCodeService {
    private static Logger logger = LoggerFactory.getLogger(PayCodeServiceImpl.class);

    @Autowired
    private TbPaymentCodeMapper tbPaymentCodeMapper;

    @Override
    @ServiceLog(doAction = "查找账单类型值")
    public List<PaymentCode> getBillTypeList() {
        TbPaymentCodeCriteria codeCriteria = new TbPaymentCodeCriteria();
        codeCriteria.createCriteria().andCodeTypeEqualTo(PayBillEnum.PAYMENT_CODE_TYPE_BILL.getCode()).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        List<TbPaymentCode> tbPaymentCodes = tbPaymentCodeMapper.selectByExample(codeCriteria);
        List<PaymentCode> codes = new ArrayList<>(16);
        for (TbPaymentCode paymentCode:tbPaymentCodes) {
            PaymentCode code = new PaymentCode();
            BeanUtils.copyProperties(paymentCode,code);
            codes.add(code);
        }
        logger.info("查找账单类型值,响应条数{}",codes.size());
        return codes;
    }


}
