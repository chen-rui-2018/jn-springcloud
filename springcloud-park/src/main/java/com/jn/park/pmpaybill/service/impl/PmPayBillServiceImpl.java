package com.jn.park.pmpaybill.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.company.model.ServiceCompanyParam;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.park.asset.model.RoomEnterpriseModel;
import com.jn.park.asset.model.RoomPayOrdersItemModel;
import com.jn.park.asset.service.RoomInformationService;
import com.jn.park.parking.service.impl.ParkingAreaServiceImpl;
import com.jn.park.pmpaybill.dao.*;
import com.jn.park.pmpaybill.entity.*;
import com.jn.park.pmpaybill.enums.*;
import com.jn.park.pmpaybill.service.PmPayBillService;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.park.repair.enums.PaymentBillEnum;
import com.jn.pay.api.PayClient;
import com.jn.pay.model.PayBillDetails;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.system.log.annotation.ServiceLog;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 缴费单-类型条目管理service实现
 *
 * @author： shaobao
 * @date： Created on 2019/5/24 16:57
 * @version： v1.0
 * @modified By:
 **/
@Service
public class PmPayBillServiceImpl implements PmPayBillService {

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ParkingAreaServiceImpl.class);

    @Autowired
    private CompanyClient companyClient;

    @Autowired
    private PmPayRuleMapper pmPayRuleMapper;

    @Autowired
    private RoomInformationService roomInformationService;

    @Autowired
    private PmPayBillMapper pmPayBillMapper;

    @Autowired
    private PmPayBillItemMapper pmPayBillItemMapper;

    @Autowired
    private PmPayBillItemPmListMapper pmPayBillItemPmListMapper;

    @Autowired
    private TbPmPayBillItemMapper tbPmPayBillItemMapper;

    @Autowired
    private PayClient payClient;

    @Autowired
    private TbPmPriceRulesMapper tbPmPriceRulesMapper;

    @Autowired
    private TbPmPriceRuleDeatilsMapper tbPmPriceRuleDeatilsMapper;

    /**
     * 账本类型 1：电费，2：物业费
     */
    public static String acBookType = "PROPERTY";

    /**
     * 对象类型【1：企业，2：个人】
     */
    private static String objType = "1";

    /**
     * 支付回调ID
     */
    private static String callbackId = "springcloud-park";

    /**
     * 支付回调路径
     */
    private static String callbackUrl = "/api/pm/pmPayBillCallBack";

    /**
     * 每月16号凌晨更新缴费单条目是否逾期状态
     */
    @Override
    @ServiceLog(doAction = "每月16号凌晨更新缴费单条目是否逾期状态")
    @Transactional(rollbackFor = Exception.class)
    public void updatePmPayBillItemExpireStatus() {
        pmPayBillItemMapper.updatePmPayBillItemExpireStatus();
        logger.info("[物业管理] 每月16号凌晨更新缴费单条目是否逾期状态");
    }

    /**
     * 批量生成缴费单
     *
     * @param pmPayBillItems
     */
    @Override
    @ServiceLog(doAction = "批量生成缴费单")
    @Transactional(rollbackFor = Exception.class)
    public void generatePmBill(List<TbPmPayBillItem> pmPayBillItems) {
        for (TbPmPayBillItem tbPmPayBillItem : pmPayBillItems) {
            //获取当前物业费缴费单生成状态
            Byte generateStatus = tbPmPayBillItem.getGenerateStatus();
            if (StringUtils.equals(GenerateStatusEnums.EXPIRED.getCode(), generateStatus.toString())) {
                //如果是已生成状态,则直接跳过
                continue;
            }else if (tbPmPayBillItem.getTotalAmount().compareTo(BigDecimal.ZERO) == 0){
                //如果缴费单的实缴金额为0,则也会直接跳过
                continue;
            }

            //调用支付接口,创建账单
            Result result = createBill(tbPmPayBillItem);
            if (result != null && StringUtils.equals("0000", result.getCode())) {
                //设置账单发送状态为已发送
                tbPmPayBillItem.setSendPayBill(new Byte(SendPayBillEnums.SENTED.getCode()));
                //设置减免状态为已减免状态
                tbPmPayBillItem.setDerateState(new Byte(DerateStateEnums.RELIEFED.getCode()));
                //设置缴费单为已生成状态
                tbPmPayBillItem.setGenerateStatus(new Byte(GenerateStatusEnums.EXPIRED.getCode()));
                logger.info("[物业费管理] 为企业推送物业费账单成功,企业id:{},账单编号:{}",
                        tbPmPayBillItem.getCompanyId(), tbPmPayBillItem.getId());
            } else {
                logger.error("[物业费管理] 为企业推送物业费账单失败,企业id:{},账单编号:{}",
                        tbPmPayBillItem.getCompanyId(), tbPmPayBillItem.getId());
                throw new JnSpringCloudException(PmPayBillExcetionEnums.GENERATOR_ERROR);
            }
        }

        //如缴费单集合信息不为空,批量更新缴费单为已发送状态
        if (pmPayBillItems != null && pmPayBillItems.size() > 0) {
            pmPayBillItemMapper.updateBatchItemSendStatus(pmPayBillItems);
            logger.info("[物业费管理] 物业费批量更新发送状态成功");
        }

        logger.info("[物业费管理] 为企业推送物业费账单信息成功");
    }

    /**
     * 物业费账单支付成功,回调接口
     */
    @Override
    @ServiceLog(doAction = "物业费账单支付成功,回调接口")
    @Transactional(rollbackFor = Exception.class)
    public void pmPayBillCallBack(PayCallBackNotify payCallBackNotify) {
        //获取账单编号
        String billId = payCallBackNotify.getBillId();
        //获取支付状态
        String paymentState = payCallBackNotify.getPaymentState();

        //如果支付状态成功
        if (PaymentBillEnum.BILL_ORDER_IS_PAY.getCode().equals(paymentState)) {
            TbPmPayBillItem tbPmPayBillItem = tbPmPayBillItemMapper.selectByPrimaryKey(billId);
            if (tbPmPayBillItem != null) {
                //设置状态为已缴状态
                tbPmPayBillItem.setPayStatus(new Byte(PayStatusEnums.PAYED.getCode()));

                //更新数据库
                tbPmPayBillItemMapper.updateByPrimaryKeySelective(tbPmPayBillItem);
                logger.info("[物业费管理] 物业费账单支付成功,账单id:{}", billId);
            }
        }
        logger.warn("[物业费管理] 物业费账单支付失败,账单id:{}", billId);
    }

    /**
     * 为企业生成物业费账单并推送给企业
     *
     * @param companyId 企业id
     */
    @Override
    @ServiceLog(doAction = "为企业生成物业费账单")
    @Transactional(rollbackFor = Exception.class)
    public void createPmBill(String companyId, Date rentStartTime) {
        //1.查询企业信息物业费规则信息
        TbPmPriceRulesCriteria tbPmPayBillItemCriteria = new TbPmPriceRulesCriteria();
        TbPmPriceRulesCriteria.Criteria criteria = tbPmPayBillItemCriteria.createCriteria();
        criteria.andCompanyIdEqualTo(companyId);
        criteria.andRecordStatusEqualTo(new Byte(PmPayBillStatusEnums.EFFECTIVE.getCode()));
        List<TbPmPriceRules> tbPmPriceRules = tbPmPriceRulesMapper.selectByExample(tbPmPayBillItemCriteria);
        //判断是否查询到物业费规则信息
        if (tbPmPriceRules == null || tbPmPriceRules.size() == 0) {
            logger.warn("[物业费管理] 获取企业物业单价规则信息失败 企业id:{}", companyId);
            throw new JnSpringCloudException(PmPayBillExcetionEnums.GET_PM_PRICE_FAIL);
        }
        TbPmPriceRules tbPmPriceRules1 = tbPmPriceRules.get(0);
        String ruleId = tbPmPriceRules1.getId();

        //设置缴费单id
        String pmBillId = getOrderIdByTime();
        //设置缴费账期
        String payPeriod = getPayPeriod(rentStartTime);

        //获取公司信息
        Result<ServiceCompany> result = companyClient.getCompanyDetailByAccountOrCompanyId(companyId);
        if (!StringUtils.equals("0000", result.getCode())) {
            logger.warn("[物业费管理] 获取企业信息失败,企业id:{}", companyId);
            throw new JnSpringCloudException(PmPayBillExcetionEnums.GET_COMPANY_INFO_FAIL);
        }
        ServiceCompany companyInfo = result.getData();

        //2.获取规则详细信息
        TbPmPriceRuleDeatilsCriteria tbPmPriceRuleDeatilsCriteria = new TbPmPriceRuleDeatilsCriteria();
        TbPmPriceRuleDeatilsCriteria.Criteria criteria1 = tbPmPriceRuleDeatilsCriteria.createCriteria();
        criteria1.andRuleIdEqualTo(ruleId);
        List<TbPmPriceRuleDeatils> pmPriceRuleDeatilsList = tbPmPriceRuleDeatilsMapper.selectByExample(tbPmPriceRuleDeatilsCriteria);
        List<TbPmPayBillItemPmList> pmPriceRuleDeatilsLists = new ArrayList<TbPmPayBillItemPmList>(16);
        BigDecimal BillAccount = new BigDecimal(0);
        //3.生成缴费单信息
        if (pmPriceRuleDeatilsList != null && pmPriceRuleDeatilsList.size() > 0) {
            BillAccount = getPayBillDetails(pmBillId, payPeriod, BillAccount, pmPriceRuleDeatilsList, pmPriceRuleDeatilsLists);
        }

        //4.设置缴费单信息
        TbPmPayBillItem tbPmPayBillItem = getTbPmPayBillItem(companyId, pmBillId, payPeriod, companyInfo, BillAccount, Boolean.FALSE);

        //将数据插入
        tbPmPayBillItemMapper.insertSelective(tbPmPayBillItem);
        logger.info("[物业费管理] 为企业生成缴费单信息成功,企业id:{}", companyId);
        if (pmPriceRuleDeatilsLists != null && pmPriceRuleDeatilsLists.size() > 0) {
            pmPayBillItemPmListMapper.insertBatch(pmPriceRuleDeatilsLists);
            logger.info("[物业费管理] 为企业生成缴费单详情信息成功,企业id:{}", companyId);
        }
    }

    /**
     * 设置物业费缴费单账单信息
     *
     * @param companyId   公司id
     * @param pmBillId    缴费单id
     * @param payPeriod   账期
     * @param companyInfo 公司信息
     * @param billAccount 账单金额
     * @param isQuarter   是否是季度账单
     * @return
     */
    private TbPmPayBillItem getTbPmPayBillItem(String companyId, String pmBillId, String payPeriod,
                                               ServiceCompany companyInfo, BigDecimal billAccount, Boolean isQuarter) {
        TbPmPayBillItem tbPmPayBillItem = new TbPmPayBillItem();
        tbPmPayBillItem.setId(pmBillId);
        tbPmPayBillItem.setCompanyId(companyId);
        tbPmPayBillItem.setCompanyName(companyInfo.getComName());
        //设置企业地址
        if (StringUtils.isNotBlank(companyInfo.getAddrPark())) {
            tbPmPayBillItem.setCompanyAddress(companyInfo.getAddrPark());
        } else {
            tbPmPayBillItem.setCompanyAddress(companyInfo.getComAddress());
        }
        //设置计费方式
        tbPmPayBillItem.setCalcMode(new Byte(CalcmodeEnums.COMMON.getCode()));
        //账期
        tbPmPayBillItem.setPayPeriod(payPeriod);
        //设置最迟应缴时间
        tbPmPayBillItem.setLastPayTime(getLastPayTime(isQuarter));
        //设置为物业费管理
        tbPmPayBillItem.setPayType(new Byte(PayTypeEnums.PM_BILL.getCode()));
        //设置减免金额
        tbPmPayBillItem.setFeeAmount(new BigDecimal(0));
        //4.设置企业物业费账单总金额
        tbPmPayBillItem.setBillAcount(billAccount);
        //设置实际金额
        tbPmPayBillItem.setTotalAmount(tbPmPayBillItem.getBillAcount());
        //判断物业费实际金额,若为零,则设置没已缴
        if (tbPmPayBillItem.getBillAcount().compareTo(BigDecimal.ZERO) == 0) {
            //设置状态
            setStatus(tbPmPayBillItem, PayStatusEnums.PAYED, GenerateStatusEnums.EXPIRED, DerateStateEnums.NOT_RELIEF, SendPayBillEnums.SENTED);
        } else {
            //设置状态
            setStatus(tbPmPayBillItem, PayStatusEnums.NOT_PAY, GenerateStatusEnums.NOT_GENERATE, DerateStateEnums.NO_RELIEF, SendPayBillEnums.NO_SEND);
        }
        return tbPmPayBillItem;
    }

    /**
     * 每季度第一天凌晨,为企业生成物业费账单
     */
    @Override
    @ServiceLog(doAction = "每季度第一天凌晨,为企业生成物业费账单")
    @Transactional(rollbackFor = Exception.class)
    public void createPmPayBillByQuarter() {
        //1.获取所有企业有效物业费规则信息
        TbPmPriceRulesCriteria tbPmPayBillItemCriteria = new TbPmPriceRulesCriteria();
        TbPmPriceRulesCriteria.Criteria criteria = tbPmPayBillItemCriteria.createCriteria();
        criteria.andRecordStatusEqualTo(new Byte(PmPayBillStatusEnums.EFFECTIVE.getCode()));
        List<TbPmPriceRules> tbPmPriceRules = tbPmPriceRulesMapper.selectByExample(tbPmPayBillItemCriteria);

        //如果集合不为空,为集合中企业信息生成缴费账单信息
        if (tbPmPriceRules != null && tbPmPriceRules.size() > 0) {
            //缴费单条目限制
            List<TbPmPayBillItem> tbPmPayBillItemList = new ArrayList<TbPmPayBillItem>(1024);
            //缴费单条目物业费明细集合
            List<TbPmPayBillItemPmList> tbPmPayBillItemPmList = new ArrayList<TbPmPayBillItemPmList>(1024);

            for (TbPmPriceRules tbPmPriceRule : tbPmPriceRules) {
                String ruleId = tbPmPriceRule.getId();

                //获取企业信息
                String companyId = tbPmPriceRule.getCompanyId();
                Result<ServiceCompany> result = companyClient.getCompanyDetailByAccountOrCompanyId(companyId);
                if (!StringUtils.equals("0000", result.getCode())) {
                    logger.warn("[物业费管理] 获取企业信息失败,企业id:{}", companyId);
                    throw new JnSpringCloudException(PmPayBillExcetionEnums.GET_COMPANY_INFO_FAIL);
                }
                ServiceCompany companyInfo = result.getData();

                //设置缴费单id
                String pmBillId = getOrderIdByTime();
                //设置缴费账期
                String payPeriod = getPayPeriod(new Date());
                //账单金额
                BigDecimal BillAccount = new BigDecimal(0);

                //2.获取单价规则详情信息
                TbPmPriceRuleDeatilsCriteria tbPmPriceRuleDeatilsCriteria = new TbPmPriceRuleDeatilsCriteria();
                TbPmPriceRuleDeatilsCriteria.Criteria criteria1 = tbPmPriceRuleDeatilsCriteria.createCriteria();
                criteria1.andRuleIdEqualTo(ruleId);
                List<TbPmPriceRuleDeatils> pmPriceRuleDeatilsList = tbPmPriceRuleDeatilsMapper.selectByExample(tbPmPriceRuleDeatilsCriteria);

                //3.设置物业费账单信息详情
                BillAccount = getPayBillDetails(pmBillId, payPeriod, BillAccount, pmPriceRuleDeatilsList, tbPmPayBillItemPmList);

                //4.设置物业费账单缴费信息
                TbPmPayBillItem tbPmPayBillItem = getTbPmPayBillItem(companyId, pmBillId, payPeriod,
                        companyInfo, BillAccount, Boolean.TRUE);
                tbPmPayBillItemList.add(tbPmPayBillItem);

                //当集合数据超过1000条时,执行信息插入
                if (tbPmPayBillItemList.size() >= 1000 || tbPmPayBillItemPmList.size() > 1000) {
                    insertBatch(tbPmPayBillItemList, tbPmPayBillItemPmList);
                    tbPmPayBillItemList.clear();
                    tbPmPayBillItemPmList.clear();
                }
            }

            //插入物业费消费单信息
            insertBatch(tbPmPayBillItemList, tbPmPayBillItemPmList);
            logger.info("[物业管理] 企业缴费单数据生成成功");
        }
    }

    /**
     * 设置物业费账单明细信息
     *
     * @param pmBillId                账单主表id
     * @param payPeriod               账期
     * @param billAccount             账单金额
     * @param pmPriceRuleDeatilsList
     * @param pmPriceRuleDeatilsLists
     * @return
     */
    private BigDecimal getPayBillDetails(String pmBillId, String payPeriod, BigDecimal billAccount,
                                         List<TbPmPriceRuleDeatils> pmPriceRuleDeatilsList,
                                         List<TbPmPayBillItemPmList> pmPriceRuleDeatilsLists) {
        for (TbPmPriceRuleDeatils tbPmPriceRuleDeatils : pmPriceRuleDeatilsList) {
            TbPmPayBillItemPmList tbPmPayBillItemPm = new TbPmPayBillItemPmList();
            //设置id
            tbPmPayBillItemPm.setId(UUID.randomUUID().toString());
            //设置缴费条目id
            tbPmPayBillItemPm.setItemId(pmBillId);
            //设置物业费名称
            tbPmPayBillItemPm.setPmName("物业费");
            //设置房间地址
            tbPmPayBillItemPm.setRoomAddress(tbPmPriceRuleDeatils.getTowerName() + tbPmPriceRuleDeatils.getRoomName());
            //设置房间面积
            tbPmPayBillItemPm.setRentalArea(tbPmPriceRuleDeatils.getRoomArea());
            //设置物业费单价
            tbPmPayBillItemPm.setPmUnitPrice(tbPmPriceRuleDeatils.getPmUnitPrice());
            //计算本季度缴费金额
            tbPmPayBillItemPm.setTotalAmount(getRoomPmPayAccount(tbPmPriceRuleDeatils.getPmUnitPrice(),
                    payPeriod, tbPmPriceRuleDeatils.getRoomArea()));
            billAccount = billAccount.add(tbPmPayBillItemPm.getTotalAmount());
            pmPriceRuleDeatilsLists.add(tbPmPayBillItemPm);
        }
        return billAccount;
    }

    /**
     * 获取房间当前季度物业费金额
     *
     * @param pmUnitPrice
     * @param payPeriod
     * @return
     */
    private BigDecimal getRoomPmPayAccount(BigDecimal pmUnitPrice, String payPeriod, BigDecimal roomArea) {
        String[] split = payPeriod.split("~");
        Date startTime = new Date();
        Date endTime = new Date();
        try {
            startTime = DateUtils.parseDate(split[0], "yyyy-MM-dd");
            endTime = DateUtils.parseDate(split[1], "yyyy-MM-dd");

        } catch (ParseException e) {
            logger.error("账期时间转换出错,{}", e);
        }
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(startTime);
        c2.setTime(endTime);

        //获取月份差值
        int monthNum = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        //天数差
        int dayNum = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
        //获取当月天数
        int actualMaximum = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
        BigDecimal dayMax = new BigDecimal(actualMaximum);
        BigDecimal dayN = new BigDecimal(dayNum);
        if (monthNum == 0) {

            BigDecimal divide = dayN.divide(dayMax, 2, BigDecimal.ROUND_HALF_UP);
            BigDecimal bigDecimal = pmUnitPrice.multiply(roomArea).multiply(divide).setScale(2, BigDecimal.ROUND_DOWN);
            return bigDecimal;
        } else if (monthNum == 1) {
            //获取季度最后一个月天数
            int actualMaximum3 = c2.getActualMaximum(Calendar.DAY_OF_MONTH);
            BigDecimal dayMax3 = new BigDecimal(actualMaximum3);
            //计算第一个月比例
            BigDecimal divide = dayN.subtract(dayMax3).divide(dayMax, 2, BigDecimal.ROUND_HALF_UP);
            BigDecimal bigDecimal = pmUnitPrice.multiply(roomArea).multiply(divide.add(new BigDecimal(1))).setScale(2, BigDecimal.ROUND_DOWN);
            return bigDecimal;
        } else if (monthNum == 2) {
            //获取季度最后一个月天数
            int actualMaximum3 = c2.getActualMaximum(Calendar.DAY_OF_MONTH);
            BigDecimal dayMax3 = new BigDecimal(actualMaximum3);
            //获取季度中间一个月天数
            c2.add(Calendar.MONTH, -1);
            int actMaximum = c2.getActualMaximum(Calendar.DAY_OF_MONTH);
            BigDecimal dayMax2 = new BigDecimal(actMaximum);
            //计算第一个月比例
            BigDecimal divide = dayN.subtract(dayMax3).subtract(dayMax2).divide(dayMax, 2, BigDecimal.ROUND_HALF_UP);
            BigDecimal bigDecimal = pmUnitPrice.multiply(roomArea).multiply(divide.add(new BigDecimal(2))).setScale(2, BigDecimal.ROUND_DOWN);
            return bigDecimal;
        } else if (monthNum == 3) {
            BigDecimal bigDecimal = pmUnitPrice.multiply(roomArea).multiply(new BigDecimal(3)).setScale(2, BigDecimal.ROUND_DOWN);
            ;
            return bigDecimal;
        }
        return new BigDecimal(0);
    }

    /**
     * 获取账单金额
     *
     * @param payPeriod 账期
     * @return
     */
    private BigDecimal getBillAccount(String payPeriod) {
        String[] split = payPeriod.split("~");

        return null;
    }

    /**
     * 设置状态
     *
     * @param tbPmPayBillItem
     * @param payed           是否支付
     * @param expired         是否逾期
     * @param notRelief       是否生成缴费单
     * @param sented          是否发送
     */
    private void setStatus(TbPmPayBillItem tbPmPayBillItem, PayStatusEnums payed, GenerateStatusEnums expired, DerateStateEnums notRelief, SendPayBillEnums sented) {
        tbPmPayBillItem.setPayStatus(new Byte(payed.getCode()));
        tbPmPayBillItem.setIsExpire(new Byte(PayIsExpireEnums.NOT_EXPIRE.getCode()));
        tbPmPayBillItem.setGenerateStatus(new Byte(expired.getCode()));
        tbPmPayBillItem.setDerateState(new Byte(notRelief.getCode()));
        tbPmPayBillItem.setSendPayBill(new Byte(sented.getCode()));
    }

    /**
     * 获取当前日期推后三天的最迟缴费时间
     *
     * @return
     */
    private Date getLastPayTime(Boolean isQuarter) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 00);
        if (isQuarter) {
            //如果是季度定时自动生成缴费单,设置最后缴费时间
            calendar.set(Calendar.DAY_OF_MONTH, 15);
        } else {
            //如果是企业入驻,设置缴费时间为3天之后
            calendar.add(Calendar.DATE, 3);
        }
        return calendar.getTime();
    }

    /**
     * 获取账期
     *
     * @param rentStartTime
     * @return
     */
    private String getPayPeriod(Date rentStartTime) {
        //1.获取当前信息
        String currTime = DateUtils.formatDate(rentStartTime, "yyyy-MM-dd");
        //2.判断当前季度及季度结束时间
        Calendar c = Calendar.getInstance();
        c.setTime(rentStartTime);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;

        if (currentMonth >= 1 && currentMonth <= 3) {
            c.set(Calendar.MONTH, 2);
            c.set(Calendar.DATE, 31);
        } else if (currentMonth >= 4 && currentMonth <= 6) {
            c.set(Calendar.MONTH, 5);
            c.set(Calendar.DATE, 30);
        } else if (currentMonth >= 7 && currentMonth <= 9) {
            c.set(Calendar.MONTH, 8);
            c.set(Calendar.DATE, 30);
        } else if (currentMonth >= 10 && currentMonth <= 12) {
            c.set(Calendar.MONTH, 11);
            c.set(Calendar.DATE, 31);
        }
        String endTime = DateUtils.formatDate(c.getTime(), "yyyy-MM-dd");

        return currTime + "~" + endTime;
    }

    /**
     * 生成订单编号
     *
     * @return
     */
    public String getOrderIdByTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderId = DateUtils.formatDate(new Date(), "yyyyMMddHHmmss");
        return orderId + RandomStringUtils.randomNumeric(8);
    }

    /**
     * 为企业发送物业账单信息
     *
     * @param tbPmPayBillItem
     */
    private Result createBill(TbPmPayBillItem tbPmPayBillItem) {
        PayBillCreateParamVo payBillCreateParamVo = new PayBillCreateParamVo();
        payBillCreateParamVo.setBillId(tbPmPayBillItem.getId());
        payBillCreateParamVo.setBillName(tbPmPayBillItem.getCompanyName() + "物业费");
        payBillCreateParamVo.setBillSource("物业费");
        payBillCreateParamVo.setBillExpense(tbPmPayBillItem.getTotalAmount());
        payBillCreateParamVo.setObjType(objType);
        payBillCreateParamVo.setObjId(tbPmPayBillItem.getCompanyId());
        payBillCreateParamVo.setObjName(tbPmPayBillItem.getCompanyName());
        payBillCreateParamVo.setAcBookType(acBookType);
        payBillCreateParamVo.setCallbackId(callbackId);
        payBillCreateParamVo.setCallbackUrl(callbackUrl);
        payBillCreateParamVo.setCreatedTime(new Date());
        payBillCreateParamVo.setLatePayment(tbPmPayBillItem.getLastPayTime());

        //设置缴费详情信息
        List<PayBillDetails> payBillDetails = new ArrayList<>(16);
        PayBillDetails payBillDetail = new PayBillDetails();
        payBillDetail.setCostName("物业费");
        payBillDetail.setCostValue(tbPmPayBillItem.getTotalAmount().toString());
        payBillDetail.setSort(1);
        payBillDetails.add(payBillDetail);
        payBillCreateParamVo.setPayBillDetails(payBillDetails);

        //调用创建账单接口
        Result result = payClient.billCreate(payBillCreateParamVo);
        return result;
    }

    /**
     * 设置缴费单条目物业费信息
     *
     * @param tbPmPayBillItemList
     * @param tbPmPayBillItemPmList
     * @param serviceCompany
     * @param companyId
     * @param tbPmPayBill
     * @return
     */
    private TbPmPayBillItem getTbPmPayBillItem(List<TbPmPayBillItem> tbPmPayBillItemList, List<TbPmPayBillItemPmList> tbPmPayBillItemPmList, ServiceCompany serviceCompany, String companyId, TbPmPayBill tbPmPayBill) {
        //2.根据企业id,获取企业所有物业收费项
        List<TbPmPayRule> tbPmPayRuleList = pmPayRuleMapper.getPmRuleByCompanyId(companyId);

        //如果企业要收取的物业项不为空,查询企业房间的租赁信息
        List<RoomPayOrdersItemModel> rentRoomInfoList = getRoomInfos(companyId, tbPmPayRuleList);

        //设置缴费单条目信息
        TbPmPayBillItem tbPmPayBillItem = new TbPmPayBillItem();
        //设置id
        tbPmPayBillItem.setId(UUID.randomUUID().toString());
        BigDecimal totalAccount = new BigDecimal(0);

        //5.如果企业的物业收费项不为空,也企业租赁房间信息不为空,计算祖业费用
        if (tbPmPayRuleList != null && tbPmPayRuleList.size() > 0
                && rentRoomInfoList != null && rentRoomInfoList.size() > 0) {
            for (TbPmPayRule tbPmPayRule : tbPmPayRuleList) {
                for (RoomPayOrdersItemModel roomPayOrdersItemModel : rentRoomInfoList) {
                    //获取租赁房间面积
                    BigDecimal roomArea = new BigDecimal(roomPayOrdersItemModel.getRoomArea());
                    //设置缴费单条目物业费缴费信息
                    TbPmPayBillItemPmList tbPmPayBillItemPm = new TbPmPayBillItemPmList();
                    BigDecimal account = setTbPmPayBillItemPmList(tbPmPayRule, tbPmPayBillItem, roomPayOrdersItemModel, tbPmPayBillItemPm);
                    totalAccount = account.add(totalAccount);

                    tbPmPayBillItemPmList.add(tbPmPayBillItemPm);
                }
            }
        }
        tbPmPayBillItem.setBillAcount(totalAccount);
        setTbPmPayBillItem(serviceCompany, tbPmPayBill, tbPmPayBillItem);
        tbPmPayBillItemList.add(tbPmPayBillItem);
        return tbPmPayBillItem;
    }

    /**
     * 获取企业房租租赁信息
     *
     * @param companyId
     * @param tbPmPayRuleList
     * @return
     */
    private List<RoomPayOrdersItemModel> getRoomInfos(String companyId, List<TbPmPayRule> tbPmPayRuleList) {
        List<RoomPayOrdersItemModel> rentRoomInfoList = null;
        if (tbPmPayRuleList != null && tbPmPayRuleList.size() > 0) {
            //3.根据企业id,获取企业的租房信息
            List<String> companyIds = new ArrayList<String>(16);
            companyIds.add(companyId);
            List<RoomEnterpriseModel> roomEnterpriseModels =
                    roomInformationService.selectRoomEnterprise(companyIds);
            if (roomEnterpriseModels != null && roomEnterpriseModels.size() > 0) {
                //获取企业租房信息
                RoomEnterpriseModel roomEnterpriseModel = roomEnterpriseModels.get(0);
                rentRoomInfoList = roomEnterpriseModel.getChildren();
            }
        }
        return rentRoomInfoList;
    }

    /**
     * 批量插入数据
     *
     * @param tbPmPayBillItemList
     * @param tbPmPayBillItemPmList
     */
    private void insertBatch(List<TbPmPayBillItem> tbPmPayBillItemList, List<TbPmPayBillItemPmList> tbPmPayBillItemPmList) {
        if (tbPmPayBillItemList.size() > 0) {
            pmPayBillItemMapper.insertBatch(tbPmPayBillItemList);
            logger.info("[物业管理] 企业缴费单物业费条目信息批量插入成功");
        }
        if (tbPmPayBillItemPmList.size() > 0) {
            pmPayBillItemPmListMapper.insertBatch(tbPmPayBillItemPmList);
            logger.info("[物业管理] 企业缴费单物业费详情信息批量插入成功");
        }
    }

    /**
     * 设置物业费条目详情信息
     *
     * @param tbPmPayRule
     * @param tbPmPayBillItem
     * @param roomPayOrdersItemModel
     * @param tbPmPayBillItemPm
     * @return
     */
    private BigDecimal setTbPmPayBillItemPmList(TbPmPayRule tbPmPayRule, TbPmPayBillItem tbPmPayBillItem,
                                                RoomPayOrdersItemModel roomPayOrdersItemModel,
                                                TbPmPayBillItemPmList tbPmPayBillItemPm) {
        //获取物业收费项单价
        BigDecimal price = tbPmPayRule.getPrice();
        //获取租赁房间面积
        BigDecimal roomArea = new BigDecimal(roomPayOrdersItemModel.getRoomArea());
        //设置id
        tbPmPayBillItemPm.setId(UUID.randomUUID().toString());
        //设置缴费条目id
        tbPmPayBillItemPm.setItemId(tbPmPayBillItem.getId());
        //设置物业费名称
        tbPmPayBillItemPm.setPmName(tbPmPayRule.getName());
        //设置房间地址
        tbPmPayBillItemPm.setRoomAddress(roomPayOrdersItemModel.getTowerName()
                + roomPayOrdersItemModel.getFloor() + roomPayOrdersItemModel.getRoomName());
        //设置租赁面积
        //tbPmPayBillItemPm.setRentalArea(roomArea);
        //设置本月缴费金额
        //BigDecimal account = price.multiply(roomArea).setScale(2, BigDecimal.ROUND_DOWN);
        //tbPmPayBillItemPm.setTotalAmount(account, tbPmPriceRuleDeatils.getRoomArea());
        //TODO
        return null;
    }

    /**
     * 设置缴费单条目信息
     *
     * @param serviceCompany
     * @param tbPmPayBill
     * @param tbPmPayBillItem
     */
    private void setTbPmPayBillItem(ServiceCompany serviceCompany, TbPmPayBill tbPmPayBill, TbPmPayBillItem tbPmPayBillItem) {
        String comName = serviceCompany.getComName();
        String addrPark = serviceCompany.getAddrPark();
        //设置缴费单id
        tbPmPayBillItem.setBillId(tbPmPayBill.getId());
        //设置企业id
        tbPmPayBillItem.setCompanyId(serviceCompany.getId());
        //设置公司名称
        tbPmPayBillItem.setCompanyName(comName);
        //设置公司地址
        tbPmPayBillItem.setCompanyAddress(addrPark);
        //设置计费方式
        tbPmPayBillItem.setCalcMode(new Byte(CalcmodeEnums.COMMON.getCode()));
        //账期
        tbPmPayBillItem.setPayPeriod(tbPmPayBill.getDealDate());
        //设置最迟应缴时间
        tbPmPayBillItem.setLastPayTime(tbPmPayBill.getLastPayTime());
        //设置为物业费管理
        tbPmPayBillItem.setPayType(new Byte(PayTypeEnums.PM_BILL.getCode()));
        //设置减免金额
        tbPmPayBillItem.setFeeAmount(new BigDecimal(0));
        //设置实际金额
        tbPmPayBillItem.setTotalAmount(tbPmPayBillItem.getBillAcount());
        //判断物业费实际金额,若为零,则设置没已缴
        if (tbPmPayBillItem.getBillAcount().equals(BigDecimal.ZERO)) {
            //设置状态
            setStatus(tbPmPayBillItem, PayStatusEnums.PAYED, GenerateStatusEnums.EXPIRED, DerateStateEnums.NOT_RELIEF, SendPayBillEnums.SENTED);
        } else {
            //设置状态
            setStatus(tbPmPayBillItem, PayStatusEnums.NOT_PAY, GenerateStatusEnums.NOT_GENERATE, DerateStateEnums.NO_RELIEF, SendPayBillEnums.NO_SEND);
        }

    }


}
