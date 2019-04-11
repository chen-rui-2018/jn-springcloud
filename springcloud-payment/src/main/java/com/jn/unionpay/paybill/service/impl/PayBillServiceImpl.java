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
import com.jn.unionpay.paybill.entity.TbPaymentOrderCriteria;
import com.jn.unionpay.paybill.enums.PayBillEnum;
import com.jn.unionpay.paybill.service.PayBillService;
import com.jn.user.api.UserPointServerClient;
import com.jn.user.model.PointDeductionParam;
import com.jn.user.model.PointDeductionVO;
import com.jn.user.model.PointOrderPayParam;
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
    @Autowired
    private UserPointServerClient userPointServerClient;

    private final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


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

    @ServiceLog(doAction = "根据条件查询账单数据[不分页查询]")
    @Override
    public List<PaymentBill> getPaymentBillListByIds(String[] billIds){
        PaymentBillParam paymentBillParam = new PaymentBillParam();
        paymentBillParam.setBillIds(billIds);
        return  paymentBillMapper.getPaymentBillList(paymentBillParam);
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
        Result<ServiceCompany> companyDetailByAccount = companyClient.getCompanyDetailByAccountOrCompanyId(paymentBillModel.getBillObjId());
        if(companyDetailByAccount.getData()!=null){
            tbPaymentBill.setBillObjType(PayBillEnum.BILL_OBJ_TYPE_IS_COMPANY.getCode());
        }else{
            tbPaymentBill.setBillObjType(PayBillEnum.BILL_OBJ_TYPE_IS_INDIVIDUAL.getCode());
        }
        tbPaymentBill.setBillStatus(PayBillEnum.BILL_ORDER_IS_NOT_PAY.getCode());
        tbPaymentBill.setCreatorAccount(paymentBillModel.getBillCreateAccount());
        tbPaymentBill.setCreatedTime(new Date());
        tbPaymentBill.setRecordStatus(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
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
        billCriteria.createCriteria().andBillIdIn(strings).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
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
        StringBuilder ids = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (TbPaymentBill bill:tbPaymentBills) {
            if(StringUtils.equals(bill.getBillStatus(),PayBillEnum.BILL_ORDER_PAY_CHECKED.getCode())){
                throw new JnSpringCloudException(PayBillExceptionEnum.PAYMENT_STATUS_IS_PAY,"订单："+bill.getBillNum()+"已确认支付，请刷新页面重试。");
            }
            if(StringUtils.equals(bill.getBillStatus(),PayBillEnum.BILL_ORDER_IS_PAY.getCode())){
                throw new JnSpringCloudException(PayBillExceptionEnum.PAYMENT_STATUS_IS_PAY,"订单："+bill.getBillNum()+"已支付，请刷新页面重试。");
            }
            BigDecimal decimal = new BigDecimal(bill.getBillAmount());
            totleAmount.add(decimal);
            orderName.append(bill.getBillName()+"、");
            ids.append(bill.getBillId()+",");
            set.add(bill.getOrderId());
        }

        //查询订单状态，未支付成功且未取消支付的账单不能再次发起支付
        List<String> orders = new ArrayList<>(set);
        TbPaymentOrderCriteria orderCriteria = new TbPaymentOrderCriteria();
        orderCriteria.createCriteria().andIdIn(orders).andOrderStatusEqualTo(PayBillEnum.BILL_ORDER_IS_NOT_PAY.getCode()).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        List<TbPaymentOrder> tbPaymentOrders = tbPaymentOrderMapper.selectByExample(orderCriteria);
        if(null != tbPaymentOrders && tbPaymentOrders.size()>0){
            StringBuffer sb = new StringBuffer();
            for (TbPaymentBill bill:tbPaymentBills) {
                for (TbPaymentOrder oder :tbPaymentOrders) {
                    if(StringUtils.equals(bill.getOrderId(),oder.getId())){
                        sb.append(bill.getBillNum()+",");
                    }
                }
            }
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_IS_NOT_COMPLETE,"账单："+sb.toString()+"已发起支付，请先取消订单再进行支付。");
        }

        //积分抵扣金额
        PointDeductionParam pointDeductionParam = new PointDeductionParam();
        pointDeductionParam.setBillIds(billIds);
        pointDeductionParam.setAccount(user.getAccount());
        Result<PointDeductionVO> pointDeductionVOResult = userPointServerClient.orderPointDeduction(pointDeductionParam);
        PointDeductionVO pointDeductionVO = pointDeductionVOResult.getData();

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
        paymentOrder.setOrderObjName(user.getAccount());
        String id = ids.substring(0,ids.length()-1);
        paymentOrder.setBillIds(id);
        paymentOrder.setOrderNum(DateUtils.formatDate(new Date(),"yyyyMMdd")+((Math.random()*9+1)*100000));
        paymentOrder.setOrderAmount(totleAmount.setScale(2).doubleValue());
        paymentOrder.setOrderStatus(PayBillEnum.BILL_ORDER_IS_NOT_PAY.getCode());
        paymentOrder.setPayType(payInitiateParam.getPayMenthed());
        paymentOrder.setCreatedTime(new Date());
        paymentOrder.setCreatorAccount(user.getAccount());
        paymentOrder.setPayAmount(pointDeductionVO.getDeductionTotalAmount()!=null?(totleAmount.setScale(2).doubleValue()-pointDeductionVO.getDeductionTotalAmount()):totleAmount.setScale(2).doubleValue());
        paymentOrder.setIntegralAmount(pointDeductionVO.getDeductionTotalAmount()!=null?pointDeductionVO.getDeductionTotalAmount():0);
        paymentOrder.setRecordStatus(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        int insert = tbPaymentOrderMapper.insert(paymentOrder);
        if(insert != 1){
            logger.error("支付订单数据插入异常，响应条数为：{}",insert);
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_CREATE_ERROR);
        }
        //TODO 调用支付接口发起支付  实际支付金额为“pay_amount”


        //支付接口调用成功，处理用户积分
        PointOrderPayParam pointOrderPayParam = new PointOrderPayParam();
        BeanUtils.copyProperties(pointDeductionVO,pointOrderPayParam);
        pointOrderPayParam.setOrderId(orderId);
        pointOrderPayParam.setAccount(user.getAccount());
        pointOrderPayParam.setDeductionDetails(pointDeductionVO.getDeductionDetails());
        Result<Boolean> booleanResult = userPointServerClient.pointPreDeduction(pointOrderPayParam);
        if(!booleanResult.getData()){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_POINT_IS_ERROR);
        }
        return null;
    }

    @ServiceLog(doAction = "统一缴费-支付回调")
    @Override
    public PayCallBackVO payCallBack(PayCallBackParam callBackParam){
        TbPaymentOrder paymentOrder = tbPaymentOrderMapper.selectByPrimaryKey(callBackParam.getOrderId());
        if(paymentOrder == null){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_ORDER_IS_NOT_EXIT);
        }

        paymentOrder.setOrderStatus(PayBillEnum.BILL_ORDER_IS_PAY.getCode());
        paymentOrder.setPayTime(callBackParam.getPayTime());
        paymentOrder.setPayId(callBackParam.getPayOrderId());
        paymentOrder.setPayType(callBackParam.getPayType());
        paymentOrder.setModifiedTime(new Date());
        int i = tbPaymentOrderMapper.updateByPrimaryKeySelective(paymentOrder);
        logger.info("支付回调订单处理响应条数:{}",i);

        TbPaymentBill paymentBill = new TbPaymentBill();
        paymentBill.setBillStatus(PayBillEnum.BILL_ORDER_IS_PAY.getCode());
        paymentBill.setModifiedTime(new Date());
        paymentBill.setBillPayType(PayBillEnum.PAY_METHOD_ONLINE.getCode());
        TbPaymentBillCriteria billCriteria = new TbPaymentBillCriteria();
        billCriteria.createCriteria().andBillIdIn(Arrays.asList(paymentOrder.getBillIds().split(","))).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        List<TbPaymentBill> tbPaymentBills = tbPaymentBillMapper.selectByExample(billCriteria);
        int i1 = tbPaymentBillMapper.updateByExampleSelective(paymentBill, billCriteria);
        logger.info("支付回调-账单处理响应条数:{}",i1);

        for(TbPaymentBill bill:tbPaymentBills){
            //回调各业务侧，通知支付成功
            Boolean aBoolean = this.callBackBusiness(bill);
            logger.info("账单ID:{} 账单号:{}回调处理，响应接口：{}",bill.getBillId(),bill.getBillNum(),aBoolean);
        }
        //处理支付成功积分抵扣
        Result<Boolean> booleanResult = userPointServerClient.orderPaySuccessPointDeduction(callBackParam.getOrderId());
        if(!booleanResult.getData()){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_POINT_IS_ERROR);
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

    @Override
    @ServiceLog(doAction = "取消支付订单")
    public Integer cancelPayOrderById(String orderId,String account){
        TbPaymentOrder paymentOrder = tbPaymentOrderMapper.selectByPrimaryKey(orderId);
        if(!StringUtils.equals(paymentOrder.getCreatorAccount(),account)){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_IS_NOT_NOW_USER);
        }
        if(!StringUtils.equals(paymentOrder.getOrderStatus(),PayBillEnum.BILL_ORDER_IS_NOT_PAY.getCode())){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_IS_NOT_PAYING);
        }
        paymentOrder.setOrderStatus(PayBillEnum.BILL_ORDER_CANCEL_PAY.getCode());
        paymentOrder.setModifiedTime(new Date());
        paymentOrder.setModifierAccount(account);
        logger.info("订单取消支付成功，订单ID:{},操作人{}",orderId,account);
        //
        //处理支付失败/取消积分退回
        Result<Boolean> booleanResult = userPointServerClient.orderPaySuccessPointDeduction(orderId);
        if(!booleanResult.getData()){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_POINT_IS_ERROR);
        }
        return tbPaymentOrderMapper.updateByPrimaryKeySelective(paymentOrder);
    }

    @Override
    @ServiceLog(doAction = "获取当前用户支付订单列表")
    public PaginationData<List<PayOrderModel>> getPayOrderForUser(com.jn.common.model.Page page, String account){
        Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows() == 0 ? 15 : page.getRows(), true);
        TbPaymentOrderCriteria orderCriteria = new TbPaymentOrderCriteria();
        orderCriteria.createCriteria().andCreatorAccountEqualTo(account).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        List<TbPaymentOrder> tbPaymentOrders = tbPaymentOrderMapper.selectByExample(orderCriteria);
        List<PayOrderModel> orderModels = new ArrayList<>(16);
        for (TbPaymentOrder order : tbPaymentOrders) {
            PayOrderModel model = new PayOrderModel();
            BeanUtils.copyProperties(objects,model);
            if(null != order.getPayTime()){
                model.setPayTime(DateUtils.formatDate(order.getPayTime(),"yyyy-MM-dd HH:mm:ss"));
            }
            model.setCreatedTime(DateUtils.formatDate(order.getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
            orderModels.add(model);
        }
        return new PaginationData(orderModels, objects == null ? 0 : objects.getTotal());
    }

    @Override
    @ServiceLog(doAction = "根据订单ID获取订单详情（包含订单明细）")
    public PayOrderVO getPayOrderDetail(String orderId){
        TbPaymentOrder paymentOrder = tbPaymentOrderMapper.selectByPrimaryKey(orderId);
        if(null == paymentOrder){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_IS_NOT_EXIT);
        }
        TbPaymentBillCriteria billCriteria = new TbPaymentBillCriteria();
        billCriteria.createCriteria().andOrderIdEqualTo(orderId).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        List<TbPaymentBill> tbPaymentBills = tbPaymentBillMapper.selectByExample(billCriteria);

        PayOrderVO payOrderVO = new PayOrderVO();
        BeanUtils.copyProperties(paymentOrder,payOrderVO);
        if(null != paymentOrder.getPayTime()){
            payOrderVO.setPayTime(DateUtils.formatDate(paymentOrder.getPayTime(),"yyyy-MM-dd HH:mm:ss"));
        }
        payOrderVO.setCreatedTime(DateUtils.formatDate(paymentOrder.getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
        List<PaymentBill> bills = new ArrayList<>(16);
        if(null != tbPaymentBills && tbPaymentBills.size() > 0 ){
            for (TbPaymentBill bill:tbPaymentBills) {
                PaymentBill paymentBill = new PaymentBill();
                BeanUtils.copyProperties(bill,paymentBill);
                if(null != bill.getBillCreateTime()){
                    paymentBill.setBillCreateTime(DateUtils.formatDate(bill.getBillCreateTime(),"yyyy-MM-dd HH:mm:ss"));
                }
                if(null != bill.getRemindTime()){
                    paymentBill.setRemindTime(DateUtils.formatDate(bill.getRemindTime(),"yyyy-MM-dd HH:mm:ss"));
                }
                if(null != bill.getPayEndTime()){
                    paymentBill.setPayEndTime(DateUtils.formatDate(bill.getPayEndTime(),"yyyy-MM-dd HH:mm:ss"));
                }
                if(null != bill.getRemindTime()){
                    paymentBill.setCreatedTime(DateUtils.formatDate(bill.getCreatedTime(),"yyyy-MM-dd HH:mm:ss"));
                }
                bills.add(paymentBill);
            }
        }
        payOrderVO.setBills(bills);
        return payOrderVO;
    }

}
