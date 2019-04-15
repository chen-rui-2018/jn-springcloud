package com.jn.user.point.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.paybill.api.PayBillClient;
import com.jn.paybill.model.PayOrderVO;
import com.jn.paybill.model.PaymentBill;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.enums.UserPointExceptionEnum;
import com.jn.user.model.*;
import com.jn.user.point.dao.TbPointRuleMapper;
import com.jn.user.point.dao.TbUserPointDetailMapper;
import com.jn.user.point.dao.TbUserPointMapper;
import com.jn.user.point.dao.UserPointMapper;
import com.jn.user.point.entity.*;
import com.jn.user.point.model.*;
import com.jn.user.point.service.PointRuleService;
import com.jn.user.point.service.UserPointService;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * 用户积分
 * @author： jiangyl
 * @date： Created on 2019/4/3 19:11
 * @version： v1.0
 * @modified By:
 */
@Service
public class UserPointServiceImpl implements UserPointService {
    private static Logger logger = LoggerFactory.getLogger(UserPointServiceImpl.class);

    @Autowired
    private UserPointMapper userPointMapper;
    @Autowired
    private TbUserPointMapper tbUserPointMapper;
    @Autowired
    private TbUserPointDetailMapper tbUserPointDetailMapper;
    @Autowired
    private TbPointRuleMapper tbPointRuleMapper;
    @Autowired
    private PayBillClient payBillClient;
    @Autowired
    private PointRuleService pointRuleService;

    /**
     * 数据状态 1:有效
     */
    private final static String RECORD_STATUS_VALID = "1";

    /**
     * 积分周期状态 0无效1有效
     */
    private final static String POINT_RULE_CYCLE_STATUS_VALID = "1";
    /**
     * 积分状态 0无效1有效
     */
    private final static String POINT_RULE_STATUS_VALID = "1";
    /**
     * 规则类型 1收入规则 2支出规则
     */
    private final static String POINT_RULE_INCOME_VALID = "1";
    private final static String POINT_RULE_PAY_VALID = "2";
    /**
     * 积分详情 1正常0冻结-1积分无效
     */
    private final static String POINT_DETAIL_IS_VALID = "1";
    private final static String POINT_DETAIL_IS_INVALID = "-1";
    private final static String POINT_DETAIL_IS_FREEZE = "0";
    /**
     * 积分周期
     */
    private final static String POINT_RULE_UNIT_DAY = "day";
    private final static String POINT_RULE_UNIT_MONTH = "month";
    private final static String POINT_RULE_UNIT_YEAR = "year";
    private final static String POINT_RULE_UNIT_TOTAL = "total";

    @Override
    @ServiceLog(doAction = "根据用户账号查询用户积分")
    public UserPointVO getUserPoint(String account){
        UserPointParam userPointParam = new UserPointParam();
        userPointParam.setUserAccount(account);
        List<UserPointVO> userPoint = userPointMapper.getUserPoint(userPointParam);
        if(null == userPoint || userPoint.size() == 0 ){
            logger.info("用户缺少积分数据，进行用户积分初始化处理。userAccount==>{}",account);
            TbUserPoint tbUserPoint = new TbUserPoint();
            tbUserPoint.setCreatedTime(new Date());
            tbUserPoint.setUserAccount(account);
            tbUserPoint.setCreatorAccount(account);
            tbUserPoint.setPointNum(new Double("0"));
            tbUserPoint.setFreezeNum(new Double("0"));
            tbUserPoint.setRecordStatus(new Byte(RECORD_STATUS_VALID));
            int insert = tbUserPointMapper.insert(tbUserPoint);
            logger.info("用户{}初始数据插入，响应条数：{}",account,insert);
            UserPointVO vo = new UserPointVO();
            BeanUtils.copyProperties(tbUserPoint,vo);
            return vo;
        }
        if(userPoint.size()>1){
            throw new JnSpringCloudException(UserPointExceptionEnum.USER_POINT_EXIST_TOO_DATA);
        }
        return userPoint.get(0);
    }

    @Override
    @ServiceLog(doAction = "查询用户积分余额列表[后台管理员使用]")
    public PaginationData<List<UserPointVO>> getUserPointList(UserPointParam userPointParam){
        Page<Object> objects = PageHelper.startPage(userPointParam.getPage(), userPointParam.getRows() == 0 ? 15 : userPointParam.getRows());
        List<UserPointVO> userPoint = userPointMapper.getUserPoint(userPointParam);
        PaginationData<List<UserPointVO>> data = new PaginationData(userPoint, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "根据用户账号查询积分明细列表")
    public PaginationData<List<UserPointDetailVO>> getUserPointDetail(UserPointDetailParam userPointDetailParam){
        Page<Object> objects = PageHelper.startPage(userPointDetailParam.getPage(), userPointDetailParam.getRows() == 0 ? 15 : userPointDetailParam.getRows());
        TbUserPointDetailCriteria detailCriteria = new TbUserPointDetailCriteria();
        detailCriteria.createCriteria().andPointStatusNotEqualTo(POINT_DETAIL_IS_INVALID).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID)).andUserAccountEqualTo(userPointDetailParam.getUserAccount());
        List<TbUserPointDetail> tbUserPointDetails = tbUserPointDetailMapper.selectByExample(detailCriteria);
        List<UserPointDetailVO> detailVOS = new ArrayList<>(16);
        for (TbUserPointDetail pointDetail:tbUserPointDetails) {
            UserPointDetailVO userPointDetailVO = new UserPointDetailVO();
            BeanUtils.copyProperties(pointDetail,userPointDetailVO);
            detailVOS.add(userPointDetailVO);
        }
        PaginationData<List<UserPointDetailVO>> data = new PaginationData(detailVOS, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "获取用户某个功能周期内完成情况")
    public UserFunctionPointVO getFunctionPointState(String ruleCode, String account){
        TbPointRuleCriteria ruleCriteria = new TbPointRuleCriteria();
        ruleCriteria.createCriteria().andRuleCodeEqualTo(ruleCode).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbPointRule> tbPointRules = tbPointRuleMapper.selectByExample(ruleCriteria);
        if(null == tbPointRules || tbPointRules.size() == 0){
            throw new JnSpringCloudException(UserPointExceptionEnum.POINT_RULE_IS_NOT_EXIST);
        }
        TbPointRule tbPointRule = tbPointRules.get(0);
        TbUserPointDetailCriteria tbUserPointDetailCriteria = new TbUserPointDetailCriteria();
        TbUserPointDetailCriteria.Criteria criteria = tbUserPointDetailCriteria.createCriteria();
        criteria.andUserAccountEqualTo(account).andRuleTypeIdEqualTo(ruleCode).andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));

        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        cale.set(Calendar.MILLISECOND, 0);
        if(StringUtils.equals(POINT_RULE_UNIT_DAY,tbPointRule.getCycleUnit())){
            logger.info("积分周期为天，入参时间：{}",DateUtils.formatDate(cale.getTime(), "yyyy-MM-dd HH:mm:ss"));
        }else if(StringUtils.equals(POINT_RULE_UNIT_MONTH,tbPointRule.getCycleUnit())){
            cale.set(Calendar.DAY_OF_MONTH, 1);
            logger.info("积分周期为月，入参时间：{}",DateUtils.formatDate(cale.getTime(), "yyyy-MM-dd HH:mm:ss"));
        }else if(StringUtils.equals(POINT_RULE_UNIT_YEAR,tbPointRule.getCycleUnit())){
            cale.set(Calendar.MONTH, 0);
            cale.set(Calendar.DAY_OF_MONTH, 1);
            logger.info("积分周期为年，入参时间：{}",DateUtils.formatDate(cale.getTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        criteria.andCreatedTimeBetween(cale.getTime(),new Date());
        List<TbUserPointDetail> tbUserPointDetails = tbUserPointDetailMapper.selectByExample(tbUserPointDetailCriteria);
        UserFunctionPointVO userFunctionPointVO = new UserFunctionPointVO();
        userFunctionPointVO.setUserAccount(account);
        userFunctionPointVO.setRuleTypeName(tbPointRule.getRuleName());
        userFunctionPointVO.setRuleTypeId(tbPointRule.getRuleCode());
        userFunctionPointVO.setCycleUnit(tbPointRule.getCycleUnit());
        userFunctionPointVO.setCycleUnitNum(tbPointRule.getCycleUnitNum()+"");
        userFunctionPointVO.setRuleCompleteNum((null == tbUserPointDetails)?0+"":tbUserPointDetails.size()+"");
        return userFunctionPointVO;
    }

    @Override
    @ServiceLog(doAction = "积分收入")
    public Boolean userPointIncome(PointIncomeParam pointIncomeParam){
        TbPointRuleCriteria pointRuleCriteria = new TbPointRuleCriteria();
        pointRuleCriteria.createCriteria().andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbPointRule> tbPointRules = tbPointRuleMapper.selectByExample(pointRuleCriteria);
        Boolean b = true;
        for (TbPointRule pointRule:tbPointRules) {
            if(StringUtils.equals(pointIncomeParam.getRuleCode(),pointRule.getRuleCode())){
                if(!StringUtils.equals(pointRule.getIsStatus(),POINT_RULE_STATUS_VALID)){
                    throw new JnSpringCloudException(UserPointExceptionEnum.POINT_RULE_IS_INVALID);
                }
                if(!StringUtils.equals(pointRule.getRuleType(),POINT_RULE_INCOME_VALID)){
                    throw new JnSpringCloudException(UserPointExceptionEnum.POINT_RULE_IS_NOT_INCOME);
                }
                b = false;
                UserFunctionPointVO functionPointState = getFunctionPointState(pointIncomeParam.getRuleCode(), pointIncomeParam.getAccount());
                if(StringUtils.equals(POINT_RULE_CYCLE_STATUS_VALID,pointRule.getCycleStatus()) && (new Integer(functionPointState.getCycleUnitNum()))<=(new Integer(functionPointState.getRuleCompleteNum()))){
                    throw new JnSpringCloudException(UserPointExceptionEnum.POINT_RULE_NO_REMAINING_TIMES,"["+pointRule.getRuleName()+"]当前周期内获取积分已达上限，不能继续获取");
                }

                UserPointVO userPoint = getUserPoint(pointIncomeParam.getAccount());

                //插入积分明细
                TbUserPointDetail userPointDetail = new TbUserPointDetail();
                userPointDetail.setId(UUID.randomUUID().toString().replace("-",""));
                userPointDetail.setUserAccount(pointIncomeParam.getAccount());
                userPointDetail.setRuleTypeName(pointRule.getRuleName());
                userPointDetail.setRuleTypeId(pointRule.getRuleCode());
                userPointDetail.setPointType(POINT_RULE_INCOME_VALID);
                userPointDetail.setPointNum(pointRule.getIntegralNum());
                userPointDetail.setPointBalance(userPoint.getPointNum()+pointRule.getIntegralNum());
                userPointDetail.setCreatedTime(new Date());
                userPointDetail.setCreatorAccount(pointIncomeParam.getAccount());
                userPointDetail.setPointIncomeId(pointIncomeParam.getPoingIncomeId());
                userPointDetail.setPointStatus(POINT_DETAIL_IS_VALID);
                userPointDetail.setRecordStatus(new Byte(RECORD_STATUS_VALID));
                int insert = tbUserPointDetailMapper.insert(userPointDetail);
                logger.info("插入用户积分明细数据，响应条数：{}",insert);

                TbUserPoint tbUserPoint = new TbUserPoint();
                BeanUtils.copyProperties(userPoint,tbUserPoint);
                tbUserPoint.setPointNum(userPoint.getPointNum()+pointRule.getIntegralNum());
                tbUserPoint.setModifierAccount(pointIncomeParam.getAccount());
                tbUserPoint.setModifiedTime(new Date());
                int i = tbUserPointMapper.updateByPrimaryKeySelective(tbUserPoint);
                logger.info("修改用户积分余额数据，响应条数：{}",i);
                if(1!=i){
                    throw new JnSpringCloudException(UserPointExceptionEnum.USER_POINT_NUM_CHANGE_ERROR);
                }
            }
        }
        if(b){
            throw new JnSpringCloudException(UserPointExceptionEnum.POINT_RULE_IS_NOT_EXIST);
        }
        return true;
    }

    @ServiceLog(doAction = "获取订单抵扣积分数")
    @Override
    public PointDeductionVO orderPointDeduction(PointDeductionParam pointDeductionParam){
        String[] billIds = pointDeductionParam.getBillIds();
        if(null == billIds || billIds.length ==0){
            throw new JnSpringCloudException(UserPointExceptionEnum.PAY_BILLS_IS_NOT_NULL);
        }
        Result<List<PaymentBill>> paymentBillListByIds = payBillClient.getPaymentBillListByIds(pointDeductionParam.getBillIds());
        List<PaymentBill> paymentBillLists = paymentBillListByIds.getData();
        if(null == paymentBillLists || paymentBillLists.size() == 0){
            throw new JnSpringCloudException(UserPointExceptionEnum.PAY_BILLS_IS_NOT_EXIST);
        }
        //查询当前用户积分余额
        UserPointVO userPoint = this.getUserPoint(pointDeductionParam.getAccount());
        Double pointNum = userPoint.getPointNum();

        List<TbPointRule> pointRuleAllPayList = pointRuleService.getPointRuleAllPayList();

        PointDeductionVO pointDeductionVO = new PointDeductionVO();
        pointDeductionVO.setUserPointNum(pointNum);
        List<PointDeductionDetail> pointDeductionDetails = new ArrayList<>(16);
        for (PaymentBill paymentBill : paymentBillLists) {
            for (TbPointRule pointRule:pointRuleAllPayList) {
                if(StringUtils.equals(paymentBill.getBillType(),pointRule.getRuleCode())){
                    if(StringUtils.equals(pointRule.getIsStatus(),POINT_RULE_STATUS_VALID)){
                        PointDeductionDetail pointDeductionDetail = new PointDeductionDetail();
                        //计算某个账单能抵扣积分
                        Double billPoint = (new BigDecimal(Double.toString(paymentBill.getBillAmount())).multiply(new BigDecimal(Double.toString(pointRule.getIncomeScale()))).divide(new BigDecimal("100"))).doubleValue() ;
                        if(null != pointRule.getIncomeTotal() && billPoint>pointRule.getIncomeTotal()){
                            billPoint = pointRule.getIncomeTotal();
                        }
                        if(pointNum>billPoint){
                            pointNum = (new BigDecimal(Double.toString(pointNum)).subtract(new BigDecimal(Double.toString(billPoint)))).doubleValue() ;
                        }else if(pointNum == 0){
                            break;
                        } else{
                            billPoint = pointNum;
                            pointNum = new Double("0");
                        }
                        BigDecimal b1 = new BigDecimal(Double.toString(billPoint));
                        BigDecimal b2 = new BigDecimal("0.1");
                        pointDeductionDetail.setDeductionAmount(b1.multiply(b2).doubleValue());
                        pointDeductionDetail.setPointNum(billPoint);
                        pointDeductionDetail.setRuleTypeId(pointRule.getRuleCode());
                        pointDeductionDetail.setRuleTypeName(pointRule.getRuleName());
                        pointDeductionDetail.setPointRemainderNum(pointNum);
                        pointDeductionDetails.add(pointDeductionDetail);
                        double v = new BigDecimal(pointDeductionVO.getDeductionTotalAmount() == null ? "0" : Double.toString(pointDeductionVO.getDeductionTotalAmount())).add(b1.multiply(b2)).doubleValue();
                        pointDeductionVO.setDeductionTotalAmount(v);
                        double v1 = new BigDecimal(pointDeductionVO.getPointTotalNum() == null ? "0" : Double.toString(pointDeductionVO.getPointTotalNum())).add(new BigDecimal(Double.toString(billPoint))).doubleValue();
                        pointDeductionVO.setPointTotalNum(v1);
                    }else{
                        break;
                    }
                }
            }
        }
        pointDeductionVO.setDeductionDetails(pointDeductionDetails);
        pointDeductionVO.setUserPointRemainderNum(pointNum);
        return pointDeductionVO;
    }

    @ServiceLog(doAction = "账单发起支付，积分预扣除接口")
    @Override
    public Boolean pointPreDeduction(PointOrderPayParam pointOrderPayParam){
        TbUserPointCriteria tbUserPointCriteria = new TbUserPointCriteria();
        tbUserPointCriteria.createCriteria().andUserAccountEqualTo(pointOrderPayParam.getAccount());
        List<TbUserPoint> tbUserPoints = tbUserPointMapper.selectByExample(tbUserPointCriteria);
        if(null == tbUserPoints || tbUserPoints.size()==0){
            throw new JnSpringCloudException(UserPointExceptionEnum.USER_POINT_IS_NOT_EXIST);
        }
        TbUserPoint tbUserPoint = tbUserPoints.get(0);
        tbUserPoint.setModifiedTime(new Date());
        tbUserPoint.setModifierAccount(pointOrderPayParam.getAccount());
        // 发起积分扣除时，已在之前校验前处理积分余额，故不再进行二次校验。
        BigDecimal point = new BigDecimal(Double.toString(tbUserPoint.getPointNum()));
        BigDecimal pointTotal = new BigDecimal(Double.toString(pointOrderPayParam.getPointTotalNum()));
        BigDecimal userFreeze = new BigDecimal(Double.toString(tbUserPoint.getFreezeNum()));
        BigDecimal freeze = new BigDecimal(Double.toString(pointOrderPayParam.getPointTotalNum()));
        tbUserPoint.setPointNum(point.subtract(pointTotal).doubleValue());
        tbUserPoint.setFreezeNum(tbUserPoint.getFreezeNum()==null?pointOrderPayParam.getPointTotalNum():(userFreeze.add(freeze).doubleValue()));
        int i = tbUserPointMapper.updateByPrimaryKeySelective(tbUserPoint);
        logger.info("支付订单，扣除用户积分成功，扣除积分量{}，响应条数{}",pointOrderPayParam.getPointTotalNum(),i);

        List<PointDeductionDetail> deductionDetails = pointOrderPayParam.getDeductionDetails();
        List<TbUserPointDetail> detailList = new ArrayList<>(16);
        for (PointDeductionDetail deductionDetail:deductionDetails) {
            TbUserPointDetail tbUserPointDetail = new TbUserPointDetail();
            BeanUtils.copyProperties(deductionDetail,tbUserPointDetail);
            tbUserPointDetail.setId(UUID.randomUUID().toString().replace("-",""));
            tbUserPointDetail.setUserAccount(pointOrderPayParam.getAccount());
            tbUserPointDetail.setPointType(POINT_RULE_PAY_VALID);
            tbUserPointDetail.setPointBalance(deductionDetail.getPointRemainderNum());
            tbUserPointDetail.setPointOrderId(pointOrderPayParam.getOrderId());
            tbUserPointDetail.setCreatorAccount(pointOrderPayParam.getAccount());
            tbUserPointDetail.setPointStatus(POINT_DETAIL_IS_FREEZE);
            tbUserPointDetail.setCreatedTime(new Date());
            tbUserPointDetail.setRecordStatus(new Byte(RECORD_STATUS_VALID));
            detailList.add(tbUserPointDetail);
        }
        int i1 = userPointMapper.insertPointDetailList(detailList);
        logger.info("插入用户积分明细响应条数{}",i1);
        return i==1?true:false;
    }

    @ServiceLog(doAction = "支付成功，积分扣除接口")
    @Override
    public Boolean orderPaySuccessPointDeduction(String orderId){
        Result<PayOrderVO> payOrderDetail = payBillClient.getPayOrderDetailByOrderId(orderId);
        BigDecimal integralAmount = new BigDecimal(Double.toString(payOrderDetail.getData().getIntegralAmount())).multiply(new BigDecimal("10"));
        if(null !=integralAmount && integralAmount.doubleValue() != 0 ){
            TbUserPointCriteria pointCriteria = new TbUserPointCriteria();
            pointCriteria.createCriteria().andUserAccountEqualTo(payOrderDetail.getData().getCreatorAccount());
            List<TbUserPoint> tbUserPoints = tbUserPointMapper.selectByExample(pointCriteria);
            if(null == tbUserPoints || tbUserPoints.size()==0){
                throw new JnSpringCloudException(UserPointExceptionEnum.USER_POINT_IS_NOT_EXIST);
            }
            TbUserPoint userPoint = tbUserPoints.get(0);
            TbUserPoint tbUserPoint = new TbUserPoint();
            BigDecimal freezeNum = new BigDecimal(Double.toString(userPoint.getFreezeNum()));
            tbUserPoint.setFreezeNum(freezeNum.subtract(integralAmount).doubleValue());
            tbUserPoint.setModifiedTime(new Date());

            int i = tbUserPointMapper.updateByExampleSelective(tbUserPoint, pointCriteria);
            logger.info("支付失败/取消支付，积分退回（回滚）接口：处理用户积分数据响应条数{}",i);

            TbUserPointDetail tbUserPointDetail = new TbUserPointDetail();
            tbUserPointDetail.setPointStatus(POINT_DETAIL_IS_VALID);
            tbUserPointDetail.setModifiedTime(new Date());
            tbUserPointDetail.setModifierAccount(payOrderDetail.getData().getCreatorAccount());
            TbUserPointDetailCriteria pointDetailCriteria = new TbUserPointDetailCriteria();
            pointDetailCriteria.createCriteria().andPointOrderIdEqualTo(orderId);
            int i1 = tbUserPointDetailMapper.updateByExampleSelective(tbUserPointDetail, pointDetailCriteria);
            logger.info("支付失败/取消支付，积分退回（回滚）接口：处理用户积分明细数据响应条数{}",i1);
            return i==1?true:false;
        }else{
            return true;
        }
    }

    @ServiceLog(doAction = "支付失败/取消支付，积分退回（回滚）接口")
    @Override
    public Boolean orderPayErrorPointReturn(String orderId){
        Result<PayOrderVO> payOrderDetail = payBillClient.getPayOrderDetailByOrderId(orderId);
        BigDecimal integralAmount = new BigDecimal(Double.toString(payOrderDetail.getData().getIntegralAmount())).multiply(new BigDecimal("10"));
        if(null !=integralAmount && integralAmount.doubleValue() != 0 ){
            TbUserPointCriteria pointCriteria = new TbUserPointCriteria();
            pointCriteria.createCriteria().andUserAccountEqualTo(payOrderDetail.getData().getCreatorAccount());

            List<TbUserPoint> tbUserPoints = tbUserPointMapper.selectByExample(pointCriteria);
            if(null == tbUserPoints || tbUserPoints.size()==0){
                throw new JnSpringCloudException(UserPointExceptionEnum.USER_POINT_IS_NOT_EXIST);
            }
            TbUserPoint userPoint = tbUserPoints.get(0);
            TbUserPoint tbUserPoint = new TbUserPoint();
            tbUserPoint.setPointNum(new BigDecimal(Double.toString(userPoint.getPointNum())).add(integralAmount).doubleValue());
            tbUserPoint.setFreezeNum(new BigDecimal(Double.toString(userPoint.getFreezeNum())).subtract(integralAmount).doubleValue());
            tbUserPoint.setModifierAccount(payOrderDetail.getData().getCreatorAccount());
            tbUserPoint.setModifiedTime(new Date());

            int i = tbUserPointMapper.updateByExampleSelective(tbUserPoint, pointCriteria);
            logger.info("支付失败/取消支付，积分退回（回滚）接口：处理用户积分数据响应条数{}",i);

            TbUserPointDetail tbUserPointDetail = new TbUserPointDetail();
            tbUserPointDetail.setPointStatus(POINT_DETAIL_IS_INVALID);
            tbUserPointDetail.setModifiedTime(new Date());
            tbUserPointDetail.setModifierAccount(payOrderDetail.getData().getCreatorAccount());
            TbUserPointDetailCriteria pointDetailCriteria = new TbUserPointDetailCriteria();
            pointDetailCriteria.createCriteria().andPointOrderIdEqualTo(orderId);
            int i1 = tbUserPointDetailMapper.updateByExampleSelective(tbUserPointDetail, pointDetailCriteria);
            logger.info("支付失败/取消支付，积分退回（回滚）接口：处理用户积分明细数据响应条数{}",i1);
            return i==1?true:false;
        }else {
            return true;
        }
    }

}
