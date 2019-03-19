package com.jn.unionpay.paybill.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.paybill.enums.PayBillExceptionEnum;
import com.jn.paybill.model.*;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.unionpay.paybill.dao.PaymentBillMapper;
import com.jn.unionpay.paybill.dao.TbPaymentBillMapper;
import com.jn.unionpay.paybill.dao.TbPaymentOrderMapper;
import com.jn.unionpay.paybill.entity.TbPaymentBill;
import com.jn.unionpay.paybill.entity.TbPaymentBillCriteria;
import com.jn.unionpay.paybill.entity.TbPaymentOrder;
import com.jn.unionpay.paybill.service.PayBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * 统一缴费单service
 * @author： jiangyl
 * @date： Created on 2019/3/12 11:22
 * @version： v1.0
 * @modified By:
 */
@Service
public class PayBillServiceImpl implements PayBillService {
    private static Logger logger = LoggerFactory.getLogger(PayBillServiceImpl.class);

    @Autowired
    private TbPaymentBillMapper tbPaymentBillMapper;
    @Autowired
    private PaymentBillMapper paymentBillMapper;
    @Autowired
    private CompanyClient companyClient;
    @Autowired
    private TbPaymentOrderMapper tbPaymentOrderMapper;

    private final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 数据有效状态 1有效0删除数据
     */
    private static final String BILL_STATE_NOT_DELETE = "1";
    /**
     * 账单/订单状态 1待支付2已支付
     */
    private static final String BILL_ORDER_IS_NOT_PAY = "1";
    private static final String BILL_ORDER_IS_PAY = "2";

    /**
     * 缴费对象类型 1企业2个人
     */
    private static final String BILL_OBJ_TYPE_IS_COMPANY = "1";
    private static final String BILL_OBJ_TYPE_IS_INDIVIDUAL = "2";
    /**
     * 支付方式 10线上11线下
     */
    private static final String PAY_METHOD_ONLINE = "10";

    @Override
    @ServiceLog(doAction = "根据条件查询账单数据")
    public PaginationData<List<PaymentBill>> getPaymentBillList(PaymentBillParam paymentBillParam){
        Date billCreateTimeBegin = null;
        Date billCreateTimeEnd = null;
        Date payEndTimeBegin = null;
        Date payEndTimeEnd = null;
        try{
            if(StringUtils.isNotEmpty(paymentBillParam.getBillCreateTimeBegin())){
                billCreateTimeBegin = DateUtils.parseDate(paymentBillParam.getBillCreateTimeBegin(),TIME_FORMAT);
            }
            if(StringUtils.isNotEmpty(paymentBillParam.getBillCreateTimeEnd())){
                billCreateTimeEnd = DateUtils.parseDate(paymentBillParam.getBillCreateTimeEnd(),TIME_FORMAT);
            }
            if(StringUtils.isNotEmpty(paymentBillParam.getPayEndTimeBegin())){
                payEndTimeBegin = DateUtils.parseDate(paymentBillParam.getPayEndTimeBegin(),TIME_FORMAT);
            }
            if(StringUtils.isNotEmpty(paymentBillParam.getPayEndTimeEnd())){
                payEndTimeEnd = DateUtils.parseDate(paymentBillParam.getPayEndTimeEnd(),TIME_FORMAT);
            }
        }catch (ParseException e){
            logger.error("根据条件查询某个用户账单数据：参数时间转换错误。{}",e.getMessage(),e);
            throw new JnSpringCloudException(PayBillExceptionEnum.TIME_CONVERSION_ERROR);
        }
        if(null!=billCreateTimeBegin && null!=billCreateTimeEnd && billCreateTimeBegin.after(billCreateTimeEnd)){
            logger.error("账单创建时间时间，开始时间不能少于结束时间。");
            throw new JnSpringCloudException(PayBillExceptionEnum.START_TIME_NOT_AFTER_END_TIME);
        }
        if(null!=payEndTimeBegin && null!=payEndTimeEnd && payEndTimeBegin.after(payEndTimeEnd)){
            logger.error("支付截止时间，开始时间不能少于结束时间。");
            throw new JnSpringCloudException(PayBillExceptionEnum.START_TIME_NOT_AFTER_END_TIME);
        }
        Page<Object> objects = PageHelper.startPage(paymentBillParam.getPage(), paymentBillParam.getRows() == 0 ? 15 : paymentBillParam.getRows(), true);
        List<PaymentBill> tbPaymentBills = paymentBillMapper.getPaymentBillList(paymentBillParam);
        return new PaginationData(tbPaymentBills, objects == null ? 0 : objects.getTotal());
    }

    @ServiceLog(doAction = "创建缴费账单")
    @Override
    @Transactional(rollbackFor = JnSpringCloudException.class)
    public String createBill(@RequestBody PaymentBillModel paymentBillModel){
        logger.info("创建缴费账单，接收参数：{}",paymentBillModel.toString());
        TbPaymentBill tbPaymentBill = new TbPaymentBill();
        BeanUtils.copyProperties(paymentBillModel,tbPaymentBill);
        tbPaymentBill.setBillId(UUID.randomUUID().toString().replaceAll("-",""));
        try{
            tbPaymentBill.setBillCreateTime(DateUtils.parseDate(paymentBillModel.getBillCreateTime(),TIME_FORMAT));
            tbPaymentBill.setPayEndTime(DateUtils.parseDate(paymentBillModel.getPayEndTime(),TIME_FORMAT));
        }catch (ParseException e){
            logger.error("创建缴费账单：参数时间转换错误。{}",e.getMessage(),e);
            throw new JnSpringCloudException(PayBillExceptionEnum.TIME_CONVERSION_ERROR);
        }
        Result<ServiceCompany> companyDetailByAccount = companyClient.getCompanyDetailByAccount(paymentBillModel.getBillObjId());
        if(companyDetailByAccount.getData()!=null){
            tbPaymentBill.setBillObjType(BILL_OBJ_TYPE_IS_COMPANY);
        }else{
            tbPaymentBill.setBillObjType(BILL_OBJ_TYPE_IS_INDIVIDUAL);
        }
        tbPaymentBill.setBillStatus(BILL_ORDER_IS_NOT_PAY);
        tbPaymentBill.setCreatorAccount(paymentBillModel.getBillCreateAccount());
        tbPaymentBill.setCreatedTime(new Date());
        tbPaymentBill.setRecordStatus(new Byte(BILL_STATE_NOT_DELETE));
        int insert = tbPaymentBillMapper.insert(tbPaymentBill);
        if(insert != 1){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_CREATE_REPLY_ERROR);
        }
        return tbPaymentBill.getBillId();
    }

    @ServiceLog(doAction = "根据账单ID或账单编号查询账单详情")
    @Override
    public PayBillVO getPayBillDetailByIdOrNum(String idOrNum){
        if(StringUtils.isEmpty(idOrNum)){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_ID_OR_NUM_IS_NOT_NULL);
        }
        return paymentBillMapper.getPayBillDetailByIdOrNum(idOrNum);
    }

    @ServiceLog(doAction = "按天查询缴费系统中各分类的收入情况")
    @Override
    public PayBillCountVO statisticsBillAmount(PayBillCountParam payBillCountParam){
        Date startTime = null;
        Date endTime = null;
        try{
            if(StringUtils.isNotEmpty(payBillCountParam.getBillStartTime())){
                startTime = DateUtils.parseDate(payBillCountParam.getBillStartTime(),TIME_FORMAT);
            }
            if(StringUtils.isNotEmpty(payBillCountParam.getBillEndTime())){
                endTime = DateUtils.parseDate(payBillCountParam.getBillEndTime(),TIME_FORMAT);
            }
        }catch (ParseException e){
            logger.error("收入统计：参数时间转换错误。{}",e.getMessage(),e);
            throw new JnSpringCloudException(PayBillExceptionEnum.TIME_CONVERSION_ERROR);
        }
        if(null!=startTime && null!=endTime && startTime.after(endTime)){
            throw new JnSpringCloudException(PayBillExceptionEnum.START_TIME_NOT_AFTER_END_TIME);
        }
        PayBillCountVO payBillCountVO = paymentBillMapper.statisticsBillAmount(payBillCountParam);

        List<PayBillSubCount> payBillSubCounts = paymentBillMapper.statisticsBillAmountSubCount(payBillCountParam);
        payBillCountVO.setSubCounts(payBillSubCounts);
        return payBillCountVO;
    }

    @ServiceLog(doAction = "缴费单支付发起")
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public PayResponseVO startPayment(PayInitiateParam payInitiateParam, User user){
        String[] billIds = payInitiateParam.getBillIds();
        if(null == billIds || billIds.length == 0 ){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_ID_IS_NOT_NULL);
        }
        TbPaymentBillCriteria billCriteria = new TbPaymentBillCriteria();
        List<String> strings = Arrays.asList(payInitiateParam.getBillIds());
        billCriteria.createCriteria().andBillIdIn(strings).andRecordStatusEqualTo(new Byte(BILL_STATE_NOT_DELETE));
        List<TbPaymentBill> tbPaymentBills = tbPaymentBillMapper.selectByExample(billCriteria);
        if(null == tbPaymentBills || tbPaymentBills.size() == 0){
            logger.error("");
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_IS_NOT_EXIT);
        }
        if(tbPaymentBills.size()!=payInitiateParam.getBillIds().length){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_IS_NOT_EXIT,"选择账单数: "+payInitiateParam.getBillIds().length
                    +" 与实际有效账单数: "+tbPaymentBills.size()+" 不匹配，请刷新页面再试。");
        }
        BigDecimal totleAmount = new BigDecimal(0);
        StringBuilder orderName = new StringBuilder();
        for (TbPaymentBill bill:tbPaymentBills) {
            totleAmount.add(new BigDecimal(bill.getBillAmount()));
            orderName.append(bill.getBillName()+"、");
        }
        String orderId = UUID.randomUUID().toString().replaceAll("-", "");
        TbPaymentBill paymentBill = new TbPaymentBill();
        paymentBill.setOrderId(orderId);
        paymentBill.setModifiedTime(new Date());
        paymentBill.setModifierAccount(user.getAccount());
        int i = tbPaymentBillMapper.updateByExampleSelective(paymentBill, billCriteria);
        logger.info("处理账单数据支付订单标识成功，响应条数{}",i);
        String name = orderName.substring(0,orderName.length()-1);
        TbPaymentOrder paymentOrder = new TbPaymentOrder();
        paymentOrder.setId(orderId);
        paymentOrder.setOrderName(name);
        paymentOrder.setOrderObjType(tbPaymentBills.get(0).getBillObjType());
        paymentOrder.setOrderObjId(user.getId());
        paymentOrder.setOrderName(user.getName());
        paymentOrder.setOrderAmount(totleAmount.setScale(2).doubleValue());
        paymentOrder.setOrderStatus(BILL_ORDER_IS_NOT_PAY);
        paymentOrder.setPayType(payInitiateParam.getPayMenthed());
        paymentOrder.setCreatedTime(new Date());
        paymentOrder.setCreatorAccount(user.getAccount());
        paymentOrder.setRecordStatus(new Byte(BILL_STATE_NOT_DELETE));
        int insert = tbPaymentOrderMapper.insert(paymentOrder);
        if(insert != 1){
            logger.error("支付订单数据插入异常，响应条数为：{}",insert);
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_CREATE_ERROR);
        }
        //TODO 调用支付接口发起支付

        return null;
    }

    @ServiceLog(doAction = "统一缴费-支付回调")
    @Override
    public PayCallBackVO payCallBack(PayCallBackParam callBackParam){
        TbPaymentOrder paymentOrder = tbPaymentOrderMapper.selectByPrimaryKey(callBackParam.getOrderId());
        if(paymentOrder == null){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_ORDER_IS_NOT_EXIT);
        }

        paymentOrder.setOrderStatus(BILL_ORDER_IS_PAY);
        paymentOrder.setPayTime(callBackParam.getPayTime());
        paymentOrder.setPayId(callBackParam.getPayOrderId());
        paymentOrder.setPayType(callBackParam.getPayType());
        paymentOrder.setModifiedTime(new Date());
        int i = tbPaymentOrderMapper.updateByPrimaryKeySelective(paymentOrder);
        logger.info("支付回调订单处理响应条数:{}",i);

        TbPaymentBill paymentBill = new TbPaymentBill();
        paymentBill.setBillStatus(BILL_ORDER_IS_PAY);
        paymentBill.setModifiedTime(new Date());
        paymentBill.setPayType(PAY_METHOD_ONLINE);
        TbPaymentBillCriteria billCriteria = new TbPaymentBillCriteria();
        billCriteria.createCriteria().andOrderIdEqualTo(callBackParam.getOrderId()).andRecordStatusEqualTo(new Byte(BILL_STATE_NOT_DELETE));
        List<TbPaymentBill> tbPaymentBills = tbPaymentBillMapper.selectByExample(billCriteria);
        int i1 = tbPaymentBillMapper.updateByExampleSelective(paymentBill, billCriteria);
        logger.info("支付回调-账单处理响应条数:{}",i1);

        for(TbPaymentBill bill:tbPaymentBills){
            //回调各业务侧，通知支付成功
            Boolean aBoolean = this.callBackBusiness(bill);
            logger.info("账单ID:{} 账单号:{}回调处理，响应接口：{}",bill.getBillId(),bill.getBillNum(),aBoolean);
        }
        PayCallBackVO callBackVO = new PayCallBackVO();
        callBackVO.setOrderId(callBackParam.getPayOrderId());
        callBackVO.setRespStatus("处理成功");
        callBackVO.setRespTime(DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        return callBackVO;
    }


    public Boolean callBackBusiness(TbPaymentBill bill){
        //TODO jiangyl 判断账单类型，并回调各业务侧接口处理业务数据。

        return false;
    }

}
