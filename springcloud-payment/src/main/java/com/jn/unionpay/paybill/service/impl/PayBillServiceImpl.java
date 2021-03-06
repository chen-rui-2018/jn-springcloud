package com.jn.unionpay.paybill.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.park.api.ParkingClient;
import com.jn.pay.api.PayOrderClient;
import com.jn.pay.api.PropagandaClient;
import com.jn.pay.enums.ChannelIdEnum;
import com.jn.pay.enums.MchIdEnum;
import com.jn.pay.model.*;
import com.jn.pay.utils.BeanToMap;
import com.jn.pay.utils.PayDigestUtil;
import com.jn.pay.utils.XXPayUtil;
import com.jn.paybill.enums.PayBillExceptionEnum;
import com.jn.paybill.model.*;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.unionpay.paybill.dao.PaymentBillMapper;
import com.jn.unionpay.paybill.dao.TbPaymentBillMapper;
import com.jn.unionpay.paybill.dao.TbPaymentOrderMapper;
import com.jn.unionpay.paybill.dao.TbPaymentPayLogMapper;
import com.jn.unionpay.paybill.entity.*;
import com.jn.unionpay.paybill.enums.PayBillEnum;
import com.jn.paybill.enums.PayTypeEnum;
import com.jn.unionpay.paybill.service.PayBillService;
import com.jn.user.api.MiniProgramRegisterClient;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.api.UserPointServerClient;
import com.jn.user.model.PointDeductionParam;
import com.jn.user.model.PointDeductionVO;
import com.jn.user.model.PointOrderPayParam;
import com.jn.user.model.UserExtensionInfo;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.xxpay.common.util.JsonUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * ???????????????service
 * @author??? jiangyl
 * @date??? Created on 2019/3/12 11:22
 * @version??? v1.0
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
    @Autowired
    private PayOrderClient payOrderClient;
    @Autowired
    private TbPaymentPayLogMapper tbPaymentPayLogMapper;
    @Autowired
    private ParkingClient parkingClient;
    @Autowired
    private SystemClient systemClient;
    @Autowired
    private PropagandaClient propagandaClient;
    @Autowired
    private MiniProgramRegisterClient miniProgramRegisterClient;

    private final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * ????????????????????????????????????????????????????????????????????????0?????????????????????????????? ??????????????????   jiangyl
     */
    private final static String NOT_USER_POINT = "0";

    /**
     * ????????????
     */
    private final static String USE_POINT = "1";
    /**
     * 2 ???????????? 1????????????[?????????]
     */
    private final static String ORDER_PAY_SUCCESS = "2";
    private final static String ORDER_PAY_WAIT = "1";

    @Override
    @ServiceLog(doAction = "??????????????????????????????")
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
            logger.error("????????????????????????????????????????????????????????????????????????{}",e.getMessage(),e);
            throw new JnSpringCloudException(PayBillExceptionEnum.TIME_CONVERSION_ERROR);
        }
        if(null!=billCreateTimeBegin && null!=billCreateTimeEnd && billCreateTimeBegin.after(billCreateTimeEnd)){
            logger.error("??????????????????????????????????????????????????????????????????");
            throw new JnSpringCloudException(PayBillExceptionEnum.START_TIME_NOT_AFTER_END_TIME);
        }
        if(null!=payEndTimeBegin && null!=payEndTimeEnd && payEndTimeBegin.after(payEndTimeEnd)){
            logger.error("????????????????????????????????????????????????????????????");
            throw new JnSpringCloudException(PayBillExceptionEnum.START_TIME_NOT_AFTER_END_TIME);
        }
        Page<Object> objects = PageHelper.startPage(paymentBillParam.getPage(), paymentBillParam.getRows() == 0 ? 15 : paymentBillParam.getRows(), true);
        List<PaymentBill> tbPaymentBills = paymentBillMapper.getPaymentBillList(paymentBillParam);
        return new PaginationData(tbPaymentBills, objects == null ? 0 : objects.getTotal());
    }

    @ServiceLog(doAction = "??????????????????????????????[???????????????]")
    @Override
    public List<PaymentBill> getPaymentBillListByIds(String[] billIds){
        PaymentBillParam paymentBillParam = new PaymentBillParam();
        paymentBillParam.setBillIds(billIds);
        return  paymentBillMapper.getPaymentBillList(paymentBillParam);
    }

    @ServiceLog(doAction = "??????????????????")
    @Override
    @Transactional(rollbackFor = JnSpringCloudException.class)
    public String createBill(@RequestBody PaymentBillModel paymentBillModel){
        logger.info("????????????????????????????????????{}",paymentBillModel.toString());
        TbPaymentBill tbPaymentBill = new TbPaymentBill();
        BeanUtils.copyProperties(paymentBillModel,tbPaymentBill);
        tbPaymentBill.setBillId(UUID.randomUUID().toString().replaceAll("-",""));
        try{
            tbPaymentBill.setBillCreateTime(new Date());
            tbPaymentBill.setPayEndTime(DateUtils.parseDate(paymentBillModel.getPayEndTime(),TIME_FORMAT));
        }catch (ParseException e){
            logger.error("????????????????????????????????????????????????{}",e.getMessage(),e);
            throw new JnSpringCloudException(PayBillExceptionEnum.TIME_CONVERSION_ERROR);
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

    @ServiceLog(doAction = "????????????ID?????????????????????????????????")
    @Override
    public PayBillVO getPayBillDetailByIdOrNum(String idOrNum){
        if(StringUtils.isEmpty(idOrNum)){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_ID_OR_NUM_IS_NOT_NULL);
        }
        return paymentBillMapper.getPayBillDetailByIdOrNum(idOrNum);
    }

    @ServiceLog(doAction = "???????????????????????????????????????????????????")
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
            logger.error("??????????????????????????????????????????{}",e.getMessage(),e);
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

    @ServiceLog(doAction = "?????????????????????")
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Result<PayOrderRsp> createPayOrder(CreatePayReqModel createPayReqModel){
        if(StringUtils.isEmpty(createPayReqModel.getUserAccount())){
            throw new JnSpringCloudException(PayBillExceptionEnum.PAY_ORDER_USER_IS_NOT);
        }
        List<String> account = new ArrayList<>(16);
        account.add(createPayReqModel.getUserAccount());
        Result<List<User>> userInfoByAccount = systemClient.getUserInfoByAccount(account);
        if(null == userInfoByAccount || userInfoByAccount.getData() == null || userInfoByAccount.getData().size() == 0){
            throw new JnSpringCloudException(PayBillExceptionEnum.PAY_ORDER_USER_IS_NOT_EXIST);
        }
        User user = userInfoByAccount.getData().get(0);

        TbPaymentBillCriteria billCriteria = new TbPaymentBillCriteria();
        billCriteria.createCriteria().andBillIdEqualTo(createPayReqModel.getOrderId()).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        List<TbPaymentBill> tbPaymentBills = tbPaymentBillMapper.selectByExample(billCriteria);
        if(null == tbPaymentBills || tbPaymentBills.size() == 0){
            logger.error("???????????????");
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_IS_NOT_EXIT);
        }

        BigDecimal totalAmount = new BigDecimal(0);
        StringBuilder orderName = new StringBuilder();
        StringBuilder ids = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (TbPaymentBill bill:tbPaymentBills) {
            if(StringUtils.equals(bill.getBillStatus(),PayBillEnum.BILL_ORDER_PAY_CHECKED.getCode())){
                throw new JnSpringCloudException(PayBillExceptionEnum.PAYMENT_STATUS_IS_PAY,"?????????"+bill.getBillNum()+"??????????????????????????????????????????");
            }
            if(StringUtils.equals(bill.getBillStatus(),PayBillEnum.BILL_ORDER_IS_PAY.getCode())){
                throw new JnSpringCloudException(PayBillExceptionEnum.PAYMENT_STATUS_IS_PAY,"?????????"+bill.getBillNum()+"????????????????????????????????????");
            }
            if(StringUtils.equals(bill.getBillStatus(),PayBillEnum.REMIND_IS_NOT_CHECK.getCode())){
                throw new JnSpringCloudException(PayBillExceptionEnum.PAY_ORDER_POINT_IS_NOT_CHECK,"?????????"+bill.getBillNum()+"??????????????????????????????????????????????????????");
            }
            BigDecimal decimal = new BigDecimal(bill.getBillAmount());
            totalAmount = totalAmount.add(decimal);
            orderName.append(bill.getBillName()+"???");
            ids.append(bill.getBillId()+",");
            set.add(bill.getOrderId());
        }

        if(createPayReqModel.getPaySum().compareTo(totalAmount.setScale(2, BigDecimal.ROUND_HALF_UP))!=0){
            throw new JnSpringCloudException(PayBillExceptionEnum.PAY_ORDER_AMOUNT_IS_ERROR);
        }

        String billId = ids.substring(0,ids.length()-1);
        //???????????????????????????????????????????????????????????????????????????????????????????????????????????????
            TbPaymentPayLogCriteria payLogCriteria = new TbPaymentPayLogCriteria();
            payLogCriteria.createCriteria().andChannelIdEqualTo(createPayReqModel.getChannelId()) .andBillIdEqualTo(billId).andPayStatusEqualTo(PayBillEnum.PAYMENT_ORDER_IS_PAYING.getCode());
            List<TbPaymentPayLog> tbPaymentPayLogs = tbPaymentPayLogMapper.selectByExample(payLogCriteria);
            if(null != tbPaymentPayLogs && tbPaymentPayLogs.size()>0){
                for (TbPaymentPayLog payLog:tbPaymentPayLogs) {
                    Date date = DateUtils.addHours(payLog.getStartTime(), 1);
                    if(new Date().before(date)){
                        //??????????????????????????????????????????????????????
                        String responseXml = payLog.getResponseXml();
                        logger.info("??????????????????????????????????????????????????????{}",responseXml);
                        Object parse = JSON.parse(responseXml);
                        return new Result(parse);
                    }
                }
            }
        //????????????????????????????????????????????????????????????????????????????????????????????????????????????
        List<String> orders = new ArrayList<>(set);
        TbPaymentOrderCriteria orderCriteria = new TbPaymentOrderCriteria();
        orderCriteria.createCriteria().andIdIn(orders).andOrderStatusEqualTo(PayBillEnum.BILL_ORDER_IS_NOT_PAY.getCode()).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        List<TbPaymentOrder> tbPaymentOrders = tbPaymentOrderMapper.selectByExample(orderCriteria);
        if(null != tbPaymentOrders && tbPaymentOrders.size()>1){
            StringBuffer sb = new StringBuffer();
            for (TbPaymentBill bill:tbPaymentBills) {
                for (TbPaymentOrder oder :tbPaymentOrders) {
                    if(StringUtils.equals(bill.getOrderId(),oder.getId())){
                        sb.append(bill.getBillNum()+",");
                    }
                }
            }
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_IS_NOT_COMPLETE,"?????????"+sb.toString()+"???????????????????????????????????????");
        }

               //??????????????????
        PointDeductionVO pointDeductionVO = new PointDeductionVO();
        if(StringUtils.equals(USE_POINT,NOT_USER_POINT)){
            PointDeductionParam pointDeductionParam = new PointDeductionParam();
            pointDeductionParam.setBillIds(new String[]{createPayReqModel.getOrderId()});
            pointDeductionParam.setAccount(user.getAccount());
            Result<PointDeductionVO> pointDeductionVOResult = userPointServerClient.orderPointDeduction(pointDeductionParam);
            pointDeductionVO = pointDeductionVOResult.getData();
        }

        String orderId = UUID.randomUUID().toString().replaceAll("-", "");
        TbPaymentBill paymentBill = new TbPaymentBill();
        paymentBill.setOrderId(orderId);
        paymentBill.setModifiedTime(new Date());
        paymentBill.setModifierAccount(user.getAccount());
        int i = tbPaymentBillMapper.updateByExampleSelective(paymentBill, billCriteria);
        logger.info("?????????????????????????????????????????????????????????{}",i);
        String name = orderName.substring(0,orderName.length()-1);
        TbPaymentOrder paymentOrder = new TbPaymentOrder();
        paymentOrder.setId(orderId);
        paymentOrder.setOrderName(name);
        paymentOrder.setOrderObjType(tbPaymentBills.get(0).getBillObjType());
        paymentOrder.setOrderObjId(user.getId());
        paymentOrder.setOrderObjName(user.getAccount());
        paymentOrder.setBillIds(billId);
        paymentOrder.setOrderNum(DateUtils.formatDate(new Date(),"yyyyMMdd")+(new Random().nextInt(899999)+100000));
        paymentOrder.setOrderAmount(totalAmount.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
        paymentOrder.setOrderStatus(PayBillEnum.BILL_ORDER_IS_NOT_PAY.getCode());
        paymentOrder.setPayType(createPayReqModel.getChannelId());
        paymentOrder.setCreatedTime(new Date());
        paymentOrder.setCreatorAccount(user.getAccount());
        paymentOrder.setPayAmount((StringUtils.equals(USE_POINT,NOT_USER_POINT)&&pointDeductionVO.getDeductionTotalAmount()!=null)?(totalAmount.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()-pointDeductionVO.getDeductionTotalAmount()):totalAmount.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
        paymentOrder.setIntegralAmount((StringUtils.equals(USE_POINT,NOT_USER_POINT)&&pointDeductionVO.getDeductionTotalAmount()!=null)?pointDeductionVO.getDeductionTotalAmount():0);
        paymentOrder.setRecordStatus(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        logger.info("????????????????????????????????????????????????");

        if(StringUtils.equals(createPayReqModel.getChannelId(), ChannelIdEnum.WX_PROGRAM.getCode())){
            Map<String,String> map = new HashMap<>(16);

            Result openIdByAccount = miniProgramRegisterClient.getOpenIdByAccount(user.getAccount());
            if(openIdByAccount == null || openIdByAccount.getData() == null){
                throw new JnSpringCloudException(PayBillExceptionEnum.PAY_ORDER_OPEN_ID_IS_NULL);
            }
            map.put("openId",(String)openIdByAccount.getData());
            createPayReqModel.setExtra(JsonUtil.object2Json(map));
        }

        Map<String, Object> map = createPayOrder(createPayReqModel.getChannelId(),createPayReqModel.getExtra(), paymentOrder);
        Result payOrder = (Result<PayOrderRsp>)map.get("result");
        boolean verifyFlag = XXPayUtil.verifyPaySign(BeanToMap.toMap(payOrder.getData()), MchIdEnum.MCH_BASE.getRspKey());
        if(!verifyFlag) {
            logger.error("??????????????????????????????????????????????????????---???---???---???---???---verifyFlag={}",verifyFlag);
            throw new JnSpringCloudException(PayBillExceptionEnum.PAY_ORDER_SIGN_CHECK_ERROR);
        }
        int insert = tbPaymentOrderMapper.insert(paymentOrder);
        if(insert != 1){
            logger.error("???????????????????????????????????????????????????{}",insert);
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_CREATE_ERROR);
        }

        //?????????????????????????????????????????????
        if(StringUtils.equals(USE_POINT,NOT_USER_POINT)){
            PointOrderPayParam pointOrderPayParam = new PointOrderPayParam();
            BeanUtils.copyProperties(pointDeductionVO,pointOrderPayParam);
            pointOrderPayParam.setOrderId(orderId);
            pointOrderPayParam.setAccount(user.getAccount());
            pointOrderPayParam.setDeductionDetails(pointDeductionVO.getDeductionDetails());
            Result<Boolean> booleanResult = userPointServerClient.pointPreDeduction(pointOrderPayParam);
            if(null == booleanResult || !booleanResult.getData()){
                throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_POINT_IS_ERROR);
            }
        }
        TbPaymentPayLog tbPaymentPayLog = new TbPaymentPayLog();
        tbPaymentPayLog.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        tbPaymentPayLog.setOrderId(orderId);
        tbPaymentPayLog.setOrderNum(paymentOrder.getOrderNum());
        tbPaymentPayLog.setBillId(billId);
        tbPaymentPayLog.setChannelId(createPayReqModel.getChannelId());
        tbPaymentPayLog.setPayStatus(PayBillEnum.PAYMENT_ORDER_IS_PAYING.getCode());
        tbPaymentPayLog.setStartTime(new Date());
        tbPaymentPayLog.setRequestXml((String)map.get("request"));
        tbPaymentPayLog.setResponseXml(JSON.toJSONString(payOrder.getData()));
        tbPaymentPayLog.setRecordStatus(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        tbPaymentPayLog.setCreatedTime(new Date());
        tbPaymentPayLog.setCreatorAccount(user.getAccount());
        int insert1 = tbPaymentPayLogMapper.insert(tbPaymentPayLog);
        logger.info("????????????????????????????????????{}",insert1);
        return payOrder;
    }

    /**
     * ?????????????????????????????????
     * @param channelId
     * @param paymentOrder
     * @return
     */
    public Map<String,Object> createPayOrder(String channelId,String extra,TbPaymentOrder paymentOrder){
        Map<String,Object> map = new HashMap<>(16);
        PayOrderReq payOrderReq = new PayOrderReq();
        payOrderReq.setMchId(MchIdEnum.MCH_BASE.getCode());
        payOrderReq.setMchOrderNo(paymentOrder.getId());
        Double payAmount = paymentOrder.getPayAmount()*100;
        payOrderReq.setChannelId(channelId);
        payOrderReq.setAmount(payAmount.longValue());
        payOrderReq.setDevice("APP");
        payOrderReq.setServiceId(PayBillEnum.PAYMENT_ORDER_PAYMENT_NAME.getCode());
        payOrderReq.setServiceUrl(PayBillEnum.PAYMENT_ORDER_PAYMENT_URL_NAME.getCode());
        payOrderReq.setSubject(paymentOrder.getOrderName());
        payOrderReq.setBody(paymentOrder.getOrderName());
        payOrderReq.setExtra(extra);
        payOrderReq.setSign(PayDigestUtil.getSign(BeanToMap.toMap(payOrderReq),MchIdEnum.MCH_BASE.getReqKey()));
        Result<PayOrderRsp> payOrder = payOrderClient.createPayOrder(payOrderReq);
        map.put("result",payOrder);
        map.put("request",JSON.toJSONString(payOrderReq));
        return map;
    }

    @ServiceLog(doAction = "????????????-????????????")
    @Override
    public Result payCallBack(PayOrderNotify payOrderNotify){
        if(payOrderNotify.getStatus()==null&&payOrderNotify.getStatus()!=2){
            logger.info("???????????????????????????????????????????????????????????????{}",payOrderNotify);
            return new Result("-1","????????????????????????????????????????????????????????????");
        }
        TbPaymentOrderCriteria orderCriteria = new TbPaymentOrderCriteria();
        orderCriteria.createCriteria().andIdEqualTo(payOrderNotify.getMchOrderNo()).andOrderStatusEqualTo(ORDER_PAY_WAIT);
        List<TbPaymentOrder> tbPaymentOrders = tbPaymentOrderMapper.selectByExample(orderCriteria);
        if(null == tbPaymentOrders || tbPaymentOrders.size() == 0){
            throw new JnSpringCloudException(PayBillExceptionEnum.PAY_ORDER_POINT_IS_NOT_PAYING);
        }
        TbPaymentOrder paymentOrder = tbPaymentOrders.get(0);

        paymentOrder.setOrderStatus(PayBillEnum.BILL_ORDER_IS_PAY.getCode());
        paymentOrder.setPayTime(new Date(payOrderNotify.getPaySuccTime()));
        paymentOrder.setPayId(payOrderNotify.getPayOrderId());
        paymentOrder.setPayType(payOrderNotify.getChannelId());
        paymentOrder.setModifiedTime(new Date());
        int i = tbPaymentOrderMapper.updateByPrimaryKeySelective(paymentOrder);
        logger.info("????????????????????????????????????:{}",i);

        TbPaymentBill paymentBill = new TbPaymentBill();
        paymentBill.setBillStatus(PayBillEnum.BILL_ORDER_IS_PAY.getCode());
        paymentBill.setModifiedTime(new Date());
        paymentBill.setBillPayType(PayBillEnum.PAY_METHOD_ONLINE.getCode());
        TbPaymentBillCriteria billCriteria = new TbPaymentBillCriteria();
        billCriteria.createCriteria().andBillIdIn(Arrays.asList(paymentOrder.getBillIds().split(","))).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        List<TbPaymentBill> tbPaymentBills = tbPaymentBillMapper.selectByExample(billCriteria);
        int i1 = tbPaymentBillMapper.updateByExampleSelective(paymentBill, billCriteria);
        logger.info("????????????-????????????????????????:{}",i1);

        for(TbPaymentBill bill:tbPaymentBills){
            //???????????????????????????????????????
            bill.setBillStatus(PayBillEnum.BILL_ORDER_IS_PAY.getCode());
            Boolean aBoolean = this.callBackBusiness(bill,payOrderNotify);
            logger.info("??????ID:{} ?????????:{}??????????????????????????????{}",bill.getBillId(),bill.getBillNum(),aBoolean);
        }
        //??????????????????????????????
        Double integralAmount = paymentOrder.getIntegralAmount();
        if(null!=integralAmount && 0!=integralAmount) {
            Result<Boolean> booleanResult = null ;
            if(StringUtils.equals(ORDER_PAY_SUCCESS,payOrderNotify.getStatus()+"")){
                booleanResult = userPointServerClient.orderPaySuccessPointDeduction(payOrderNotify.getMchOrderNo());
            }else{
                booleanResult = userPointServerClient.orderPayErrorPointReturn(payOrderNotify.getMchOrderNo());
            }
            if (!booleanResult.getData()) {
                throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_POINT_IS_ERROR);
            }
        }
        logger.info("????????????????????????????????????????????????");
        return new Result("????????????????????????????????????????????????");
    }


    public Boolean callBackBusiness(TbPaymentBill bill,PayOrderNotify payOrderNotify){
        String billType = bill.getBillType();
        if(StringUtils.equals(billType,PayTypeEnum.PAYMENT_ORDER_TYPE_PARKING_FEE.getCode())||StringUtils.equals(billType, PayTypeEnum.PAYMENT_ORDER_TYPE_PARKING_MONTH.getCode())){
            PaymentBillCallBack paymentBillCallBack = new PaymentBillCallBack();
            paymentBillCallBack.setBillId(bill.getBillId());
            paymentBillCallBack.setBillType(billType);
            BeanUtils.copyProperties(payOrderNotify,paymentBillCallBack);
            Result result = parkingClient.parkingPayCallBack(paymentBillCallBack);
            logger.info("????????????????????????????????????????????????????????????{}",result.getCode());
            return (Boolean) result.getData();
        }else if(StringUtils.equals(billType,PayTypeEnum.PAYMENT_ORDER_TYPE_AD_FREE.getCode())){
            Result<Integer> integerResult = propagandaClient.updatePayStatus(bill.getBillId());
            logger.info("?????????????????????????????????????????????????????????{}",integerResult==null?"":integerResult.getData());
        }
        return true;
    }

    @Override
    @ServiceLog(doAction = "??????????????????")
    public Integer cancelPayOrderById(String orderId,String account){
        TbPaymentOrderCriteria orderCriteria = new TbPaymentOrderCriteria();
        orderCriteria.createCriteria().andIdEqualTo(orderId).andOrderStatusEqualTo(ORDER_PAY_WAIT);

        List<TbPaymentOrder> tbPaymentOrders = tbPaymentOrderMapper.selectByExample(orderCriteria);
        if(null == tbPaymentOrders || tbPaymentOrders.size() == 0){
            throw new JnSpringCloudException(PayBillExceptionEnum.PAY_ORDER_POINT_IS_NOT_PAYING);
        }

        TbPaymentOrder paymentOrder = tbPaymentOrders.get(0);
        if(!StringUtils.equals(paymentOrder.getCreatorAccount(),account)){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_IS_NOT_NOW_USER);
        }
        if(!StringUtils.equals(paymentOrder.getOrderStatus(),PayBillEnum.BILL_ORDER_IS_NOT_PAY.getCode())){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_IS_NOT_PAYING);
        }
        paymentOrder.setOrderStatus(PayBillEnum.BILL_ORDER_CANCEL_PAY.getCode());
        paymentOrder.setModifiedTime(new Date());
        paymentOrder.setModifierAccount(account);
        logger.info("?????????????????????????????????ID:{},?????????{}",orderId,account);
        //??????????????????/??????????????????
        Double integralAmount = paymentOrder.getIntegralAmount();
        if(null!=integralAmount && 0!=integralAmount){
            Result<Boolean> booleanResult = userPointServerClient.orderPayErrorPointReturn(orderId);
            if(null == booleanResult || !booleanResult.getData()){
                throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_POINT_IS_ERROR);
            }
        }
        return tbPaymentOrderMapper.updateByPrimaryKeySelective(paymentOrder);
    }

    @Override
    @ServiceLog(doAction = "????????????????????????????????????")
    public PaginationData<List<PayOrderModel>> getPayOrderForUser(com.jn.common.model.Page page, String account){
        Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows() == 0 ? 15 : page.getRows(), true);
        TbPaymentOrderCriteria orderCriteria = new TbPaymentOrderCriteria();
        orderCriteria.createCriteria().andCreatorAccountEqualTo(account).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode())).andOrderStatusNotEqualTo(PayBillEnum.PAYMENT_ORDER_IS_DELETE.getCode());
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
    @ServiceLog(doAction = "????????????ID??????????????????????????????????????????")
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

    @ServiceLog(doAction = "?????????????????????????????????????????????")
    @Override
    public Boolean cancelPayBillByBillNum(PayBillCancelParam payBillCancelParam){

        TbPaymentBillCriteria billCriteria = new TbPaymentBillCriteria();
        billCriteria.createCriteria().andBillNumEqualTo(payBillCancelParam.getBillId()).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        List<TbPaymentBill> tbPaymentBills = tbPaymentBillMapper.selectByExample(billCriteria);
        if(null == tbPaymentBills && tbPaymentBills.size() != 0){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_PAY_ORDER_IS_NOT_EXIT);
        }
        TbPaymentBill tbPaymentBill = tbPaymentBills.get(0);
        tbPaymentBill.setBillStatus(PayBillEnum.PAYMENT_BILL_IS_DELETE.getCode());
        tbPaymentBill.setModifiedTime(new Date());
        tbPaymentBill.setModifierAccount(payBillCancelParam.getAccount());
        int i = tbPaymentBillMapper.updateByExampleSelective(tbPaymentBill, billCriteria);
        logger.info("??????????????????{}",payBillCancelParam.getBillId());

        TbPaymentOrder tbPaymentOrder = new TbPaymentOrder();
        tbPaymentOrder.setOrderStatus(PayBillEnum.PAYMENT_ORDER_IS_DELETE.getCode());
        tbPaymentOrder.setModifierAccount(payBillCancelParam.getAccount());
        tbPaymentOrder.setModifiedTime(new Date());
        tbPaymentOrder.setId(tbPaymentBill.getOrderId());
        int i1 = tbPaymentOrderMapper.updateByPrimaryKeySelective(tbPaymentOrder);
        return i1==1?true:false;
    }

    @ServiceLog(doAction = "????????????????????????????????????")
    @Override
    public Boolean cancelPayBillByBillId(String billId){
        TbPaymentBillCriteria billCriteria = new TbPaymentBillCriteria();
        billCriteria.createCriteria().andBillNumEqualTo(billId).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        List<TbPaymentBill> tbPaymentBills = tbPaymentBillMapper.selectByExample(billCriteria);
        if(null == tbPaymentBills || tbPaymentBills.size() == 0){
            return true;
        }
        TbPaymentBill tbPaymentBill = tbPaymentBills.get(0);
        tbPaymentBill.setBillStatus(PayBillEnum.PAYMENT_BILL_IS_DELETE.getCode());
        tbPaymentBill.setModifiedTime(new Date());
        int i = tbPaymentBillMapper.updateByExampleSelective(tbPaymentBill, billCriteria);
        logger.info("??????????????????{}",billId);

        if(StringUtils.isNotEmpty(tbPaymentBill.getOrderId())){
            TbPaymentOrder tbPaymentOrder = new TbPaymentOrder();
            tbPaymentOrder.setOrderStatus(PayBillEnum.PAYMENT_ORDER_IS_DELETE.getCode());
            tbPaymentOrder.setModifiedTime(new Date());
            tbPaymentOrder.setId(tbPaymentBill.getOrderId());
            int i1 = tbPaymentOrderMapper.updateByPrimaryKeySelective(tbPaymentOrder);
            logger.info("?????????????????????????????????????????????????????????{}",i1);
        }
        return i==1?true:false;
    }

}
