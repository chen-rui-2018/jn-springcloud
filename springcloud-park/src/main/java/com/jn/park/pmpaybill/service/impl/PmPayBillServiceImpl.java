package com.jn.park.pmpaybill.service.impl;

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
import com.jn.paycode.model.PaymentCode;
import com.jn.system.log.annotation.ServiceLog;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    /**
     * 账本类型 1：电费，2：物业费
     */
    public static String acBookType = "2";

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
     * 每月1号凌辰两点,自动生成物业费账单明细
     */
    @Override
    @ServiceLog(doAction = "每月1号凌辰两点,自动生成物业费账单明细")
    @Transactional(rollbackFor = Exception.class)
    public void autoGeneratePmPayBillDeatils() {
        //缴费单集合
        List<TbPmPayBill> tbPmPayBillList = new ArrayList<TbPmPayBill>(1024);
        //缴费单条目限制
        List<TbPmPayBillItem> tbPmPayBillItemList = new ArrayList<TbPmPayBillItem>(1024);
        //缴费单条目物业费明细集合
        List<TbPmPayBillItemPmList> tbPmPayBillItemPmList = new ArrayList<TbPmPayBillItemPmList>(1024);

        //1.获取所有企业信息
        PaginationData<List<ServiceCompany>> data = getCompanys();
        if (data != null) {
            List<ServiceCompany> companyList = data.getRows();
            for (ServiceCompany serviceCompany : companyList) {
                String companyId = serviceCompany.getId();

                //封装缴费单数据
                TbPmPayBill tbPmPayBill = new TbPmPayBill();
                getTbPmPayBill(serviceCompany, tbPmPayBill);

                //2.生成物业费
                TbPmPayBillItem tbPmPayBillItem = getTbPmPayBillItem(tbPmPayBillItemList, tbPmPayBillItemPmList, serviceCompany, companyId, tbPmPayBill);

                //设置缴费单账单金额
                tbPmPayBill.setBillAmount(tbPmPayBillItem.getBillAcount());
                tbPmPayBill.setFreeAmount(new BigDecimal(0));
                tbPmPayBill.setTotalAmount(tbPmPayBillItem.getBillAcount());

                setTbPmPayBill(serviceCompany, tbPmPayBill);
                tbPmPayBillList.add(tbPmPayBill);

                //3.为了防止List中数据量太大,到时插入时报错,进行分批插入
                if (tbPmPayBillList.size() >= 1000 ||
                        tbPmPayBillItemList.size() >= 1000 || tbPmPayBillItemPmList.size() > 1000) {
                    insertBatch(tbPmPayBillList, tbPmPayBillItemList, tbPmPayBillItemPmList);
                    tbPmPayBillList.clear();
                    tbPmPayBillItemList.clear();
                    tbPmPayBillItemPmList.clear();
                }
            }
        }

        //插入剩余数据

        insertBatch(tbPmPayBillList, tbPmPayBillItemList, tbPmPayBillItemPmList);

        logger.info("[物业管理] 企业缴费单数据生成成功");
    }

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
     * 定时自动生成账单信息
     */
    @Override
    @ServiceLog(doAction = "每月16号凌晨更新缴费单条目是否逾期状态")
    @Transactional(rollbackFor = Exception.class)
    public void generatePmBill() {
        //1.查询处于已生成,未发送状态的物业费数据
        TbPmPayBillItemCriteria tbPmPayBillItemCriteria = new TbPmPayBillItemCriteria();
        TbPmPayBillItemCriteria.Criteria criteria = tbPmPayBillItemCriteria.createCriteria();
        //设置只查询物业费
        criteria.andPayTypeEqualTo(new Byte(PayTypeEnums.PM_BILL.getCode()));
        //设置查询已生成状态
        criteria.andGenerateStatusEqualTo(new Byte(GenerateStatusEnums.EXPIRED.getCode()));
        //设置查询未发送状态数据
        criteria.andSendPayBillEqualTo(new Byte(SendPayBillEnums.NO_SEND.getCode()));
        List<TbPmPayBillItem> tbPmPayBillItemList = tbPmPayBillItemMapper.selectByExample(tbPmPayBillItemCriteria);
        for (TbPmPayBillItem tbPmPayBillItem : tbPmPayBillItemList) {
            //调用支付接口,创建账单
            Result result = createBill(tbPmPayBillItem);
            if (result != null && StringUtils.equals("0000",result.getCode())){
                //设置账单发送状态为已发送
                tbPmPayBillItem.setSendPayBill(new Byte(SendPayBillEnums.SENTED.getCode()));
                logger.info("[物业费管理] 为企业推送物业费账单成功,企业id:{},账单编号:{}",
                        tbPmPayBillItem.getCompanyId(), tbPmPayBillItem.getId());
            }else{
                logger.error("[物业费管理] 为企业推送物业费账单失败,企业id:{},账单编号:{}",
                        tbPmPayBillItem.getCompanyId(), tbPmPayBillItem.getId());
            }
        }

        //如缴费单集合信息不为空,批量更新缴费单为已发送状态
        if (tbPmPayBillItemList != null && tbPmPayBillItemList.size() > 0) {
            pmPayBillItemMapper.updateBatchItemSendStatus(tbPmPayBillItemList);
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
        if (PaymentBillEnum.BILL_ORDER_IS_PAY.getCode().equals(paymentState)){
            TbPmPayBillItem tbPmPayBillItem = tbPmPayBillItemMapper.selectByPrimaryKey(billId);
            if (tbPmPayBillItem != null){
                //设置状态为已缴状态
                tbPmPayBillItem.setPayStatus(new Byte(PayStatusEnums.PAYED.getCode()));

                //更新数据库
                tbPmPayBillItemMapper.updateByPrimaryKeySelective(tbPmPayBillItem);
                logger.info("[物业费管理] 物业费账单支付成功,账单id:{}",billId);
            }
        }
        logger.warn("[物业费管理] 物业费账单支付失败,账单id:{}",billId);
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
     * 设置缴费单信息
     *
     * @param serviceCompany
     * @param tbPmPayBill
     */
    private void getTbPmPayBill(ServiceCompany serviceCompany, TbPmPayBill tbPmPayBill) {
        String companyId = serviceCompany.getId();
        String comName = serviceCompany.getComName();
        String addrPark = serviceCompany.getAddrPark();
        String parkBuildId = serviceCompany.getParkBuildId();
        String parkBuildName = serviceCompany.getParkBuildName();
        //设置缴费单id
        tbPmPayBill.setId(UUID.randomUUID().toString());
        //设置企业id
        tbPmPayBill.setCompanyId(companyId);
        //设置企业名称
        tbPmPayBill.setCompanyName(comName);
        //设置公司地址
        tbPmPayBill.setCompanyAddress(addrPark);
        //设置楼宇id
        tbPmPayBill.setBuildingId(parkBuildId);
        //设置楼宇名称
        tbPmPayBill.setBuildingName(parkBuildName);
        //设置状态
        tbPmPayBill.setPayStatus(new Byte(PayStatusEnums.NOT_PAY.getCode()));
        tbPmPayBill.setIsExpire(new Byte(PayIsExpireEnums.NOT_EXPIRE.getCode()));
        tbPmPayBill.setGenerateSatus(new Byte(GenerateStatusEnums.NOT_GENERATE.getCode()));
        //设置最迟缴费时间
        Calendar calendar0 = Calendar.getInstance();
        calendar0.set(Calendar.DAY_OF_MONTH, 15);
        calendar0.set(Calendar.HOUR_OF_DAY, 23);
        calendar0.set(Calendar.MINUTE, 59);
        calendar0.set(Calendar.SECOND, 00);
        tbPmPayBill.setLastPayTime(calendar0.getTime());
        //获取前一个月第一天
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, -1);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        String firstDay = DateUtils.formatDate(calendar1.getTime(), "yyyy-MM-dd");
        //获取前一个月最后一天
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 0);
        String lastDay = DateUtils.formatDate(calendar2.getTime(), "yyyy-MM-dd");
        //设置账期
        tbPmPayBill.setDealDate(firstDay + "~" + lastDay);
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
     * 获取企业信息
     *
     * @return
     */
    private PaginationData<List<ServiceCompany>> getCompanys() {
        ServiceCompanyParam serviceCompanyParam = new ServiceCompanyParam();
        serviceCompanyParam.setPage(1);
        serviceCompanyParam.setRows(20000);
        serviceCompanyParam.setCheckStatus(RecordStatusEnum.EFFECTIVE.getCode());
        Result<PaginationData<List<ServiceCompany>>> result = companyClient.getCompanyList(serviceCompanyParam);
        return result.getData();
    }

    /**
     * 批量插入数据
     *
     * @param tbPmPayBillList
     * @param tbPmPayBillItemList
     * @param tbPmPayBillItemPmList
     */
    private void insertBatch(List<TbPmPayBill> tbPmPayBillList, List<TbPmPayBillItem> tbPmPayBillItemList, List<TbPmPayBillItemPmList> tbPmPayBillItemPmList) {
        if (tbPmPayBillList.size() > 0) {
            pmPayBillMapper.insertBatch(tbPmPayBillList);
            logger.info("[物业管理] 企业缴费单信息批量插入成功");
        }
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
    private BigDecimal setTbPmPayBillItemPmList(TbPmPayRule tbPmPayRule, TbPmPayBillItem tbPmPayBillItem, RoomPayOrdersItemModel roomPayOrdersItemModel, TbPmPayBillItemPmList tbPmPayBillItemPm) {
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
        tbPmPayBillItemPm.setRentalArea(roomArea);
        //设置本月缴费金额
        BigDecimal account = price.multiply(roomArea).setScale(2, BigDecimal.ROUND_DOWN);
        tbPmPayBillItemPm.setTotalAmount(account);
        return account;
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
            tbPmPayBillItem.setPayStatus(new Byte(PayStatusEnums.PAYED.getCode()));
            tbPmPayBillItem.setIsExpire(new Byte(PayIsExpireEnums.NOT_EXPIRE.getCode()));
            tbPmPayBillItem.setGenerateStatus(new Byte(GenerateStatusEnums.EXPIRED.getCode()));
            tbPmPayBillItem.setDerateState(new Byte(DerateStateEnums.NOT_RELIEF.getCode()));
            tbPmPayBillItem.setSendPayBill(new Byte(SendPayBillEnums.SENTED.getCode()));
        } else {
            //设置状态
            tbPmPayBillItem.setPayStatus(new Byte(PayStatusEnums.NOT_PAY.getCode()));
            tbPmPayBillItem.setIsExpire(new Byte(PayIsExpireEnums.NOT_EXPIRE.getCode()));
            tbPmPayBillItem.setGenerateStatus(new Byte(GenerateStatusEnums.NOT_GENERATE.getCode()));
            tbPmPayBillItem.setDerateState(new Byte(DerateStateEnums.NO_RELIEF.getCode()));
            tbPmPayBillItem.setSendPayBill(new Byte(SendPayBillEnums.NO_SEND.getCode()));
        }

    }

    /**
     * 设置缴费单属性信息
     *
     * @param serviceCompany
     * @param tbPmPayBill
     */
    private void setTbPmPayBill(ServiceCompany serviceCompany, TbPmPayBill tbPmPayBill) {
        //判断物业费实际金额,若为零,则设置没已缴
        if (tbPmPayBill.getBillAmount().equals(BigDecimal.ZERO)) {
            //设置状态
            tbPmPayBill.setPayStatus(new Byte(PayStatusEnums.PAYED.getCode()));
            tbPmPayBill.setIsExpire(new Byte(PayIsExpireEnums.NOT_EXPIRE.getCode()));
            tbPmPayBill.setGenerateSatus(new Byte(GenerateStatusEnums.EXPIRED.getCode()));
            tbPmPayBill.setDerateState(new Byte(DerateStateEnums.NOT_RELIEF.getCode()));
        } else {
            //设置状态
            tbPmPayBill.setPayStatus(new Byte(PayStatusEnums.NOT_PAY.getCode()));
            tbPmPayBill.setIsExpire(new Byte(PayIsExpireEnums.NOT_EXPIRE.getCode()));
            tbPmPayBill.setGenerateSatus(new Byte(GenerateStatusEnums.NOT_GENERATE.getCode()));
            tbPmPayBill.setDerateState(new Byte(DerateStateEnums.NO_RELIEF.getCode()));
        }
    }
}
