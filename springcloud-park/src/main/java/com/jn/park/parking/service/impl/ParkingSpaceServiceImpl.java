package com.jn.park.parking.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.park.enums.ParkingExceptionEnum;
import com.jn.park.parking.dao.*;
import com.jn.park.parking.entity.*;
import com.jn.park.parking.enums.ParkingEnums;
import com.jn.park.parking.model.*;
import com.jn.park.parking.service.ParkingAreaService;
import com.jn.park.parking.service.ParkingCarInfoService;
import com.jn.park.parking.service.ParkingSpaceRentalService;
import com.jn.park.parking.service.ParkingSpaceService;
import com.jn.park.parking.vo.*;
import com.jn.paybill.api.PayBillClient;
import com.jn.paybill.model.PayBillVO;
import com.jn.paybill.model.PaymentBillModel;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * 停车位
 *
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:41
 * @version： v1.0
 * @modified By:
 */
@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {
    private static Logger logger = LoggerFactory.getLogger(ParkingSpaceServiceImpl.class);
    @Autowired
    private TbParkingSpaceMapper tbParkingSpaceMapper;
    @Autowired
    private TbParkingPreferentialMapper tbParkingPreferentialMapper;
    @Autowired
    private ParkingSpaceRentalService parkingSpaceRentalService;
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;
    @Autowired
    private ParkingAreaService parkingAreaService;
    @Autowired
    private TbParkingSpaceRentalMapper tbParkingSpaceRentalMapper;
    @Autowired
    private TbParkingCarInfoMapper tbParkingCarInfoMapper;
    @Autowired
    private ParkingCarInfoService parkingCarInfoService;
    @Autowired
    private PayBillClient payBillClient;
    @Autowired
    private TbParkingPreferentialAreaMapper tbParkingPreferentialAreaMapper;
    @Autowired
    private UserExtensionClient userExtensionClient;

    private static final String IBPS_ID = "578176874434265088";

    @ServiceLog(doAction = "查询停车位列表")
    @Override
    public PaginationData<List<ParkingSpaceVo>> getParkingSpaceList(ParkingSpaceParam parkingSpaceParam) {
        Page<Object> objects = PageHelper.startPage(parkingSpaceParam.getPage(), parkingSpaceParam.getRows() == 0 ? 15 : parkingSpaceParam.getRows());
        List<ParkingSpaceVo> parkingSpaceList = parkingSpaceMapper.getParkingSpaceList(parkingSpaceParam);
        PaginationData<List<ParkingSpaceVo>> data = new PaginationData(parkingSpaceList, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "查询停车位详情[已租车位关联出租户信息]")
    @Override
    public ParkingSpaceDetailVo getParkingSpaceDetailById(String spaceId) {
        ParkingSpaceParam parkingSpaceParam = new ParkingSpaceParam();
        parkingSpaceParam.setSpaceId(spaceId);
        List<ParkingSpaceVo> parkingSpaceList = parkingSpaceMapper.getParkingSpaceList(parkingSpaceParam);
        if (null == parkingSpaceList || parkingSpaceList.size() == 0) {
            logger.info("查询停车位详情[已租车位关联出租户信息]:未查询到相关车位数据，spaceId：{}", spaceId);
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_AREA_IS_NOT_EXIST);
        }
        ParkingSpaceDetailVo spaceVo = new ParkingSpaceDetailVo();
        BeanUtils.copyProperties(parkingSpaceList.get(0), spaceVo);
        if (StringUtils.isNotEmpty(parkingSpaceList.get(0).getRentId())) {
            ParkingSpaceRentalVo parkingSpaceDetail = parkingSpaceRentalService.getParkingSpaceDetailById(parkingSpaceList.get(0).getRentId());
            BeanUtils.copyProperties(parkingSpaceDetail, spaceVo);
        }
        return spaceVo;
    }

    @ServiceLog(doAction = "新增/修改车位")
    @Override
    public String saveOrUpdateParkingSpace(ParkingSpaceModel parkingSpaceModel, String userAccount) {
        TbParkingSpace parkingSpace = new TbParkingSpace();
        BeanUtils.copyProperties(parkingSpaceModel, parkingSpace);
        int i = 0;
        if (StringUtils.isNotEmpty(parkingSpaceModel.getSpaceId())) {
            parkingSpace.setModifiedTime(new Date());
            parkingSpace.setModifierAccount(userAccount);
            i = tbParkingSpaceMapper.updateByPrimaryKeySelective(parkingSpace);
        } else {
            parkingSpace.setSpaceId(UUID.randomUUID().toString().replace("-", ""));
            parkingSpace.setSpaceStatus(ParkingEnums.PARKING_SPACE_NOT_RENTED.getCode());
            parkingSpace.setRecordStatus(new Byte(ParkingEnums.EFFECTIVE.getCode()));
            parkingSpace.setCreatedTime(new Date());
            parkingSpace.setCreatorAccount(userAccount);
            i = tbParkingSpaceMapper.insert(parkingSpace);
        }
        return i + "";
    }

    @ServiceLog(doAction = "删除车位")
    @Override
    public String deleteParkingSpace(String spaceId, String userAccount) {
        TbParkingSpace tbParkingSpace = new TbParkingSpace();
        tbParkingSpace.setSpaceId(spaceId);
        tbParkingSpace.setSpaceStatus(ParkingEnums.PARKING_SPACE_DELETED.getCode());
        tbParkingSpace.setModifierAccount(userAccount);
        tbParkingSpace.setModifiedTime(new Date());
        int i = tbParkingSpaceMapper.updateByPrimaryKeySelective(tbParkingSpace);
        return i + "";
    }

    @ServiceLog(doAction = "查询当前用户车位租赁记录")
    @Override
    public PaginationData<List<ParkingUserSpaceRentalVo>> getParKingSpaceRentalListByUser(String account, com.jn.common.model.Page page) {
        Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows() == 0 ? 15 : page.getRows());
        List<ParkingUserSpaceRentalVo> parKingSpaceRentalListByUser = parkingSpaceMapper.getParKingSpaceRentalListByUser(account);
        PaginationData<List<ParkingUserSpaceRentalVo>> data = new PaginationData(parKingSpaceRentalListByUser, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "查询当前用户车位统计数据")
    @Override
    public ParkingSpaceUserCountVo getParkingSpaceUserCount(String userAccount) {
        if (StringUtils.isEmpty(userAccount)) {
            throw new JnSpringCloudException(ParkingExceptionEnum.USER_LOGIN_INVALID);
        }
        return parkingSpaceMapper.getParkingSpaceUserCount(userAccount);
    }

    @ServiceLog(doAction = "车位申请")
    @Override
    public String applyParkingSpace(ParkingSpaceApplyModel parkingSpaceApplyModel, User user) {
        ParkingSpaceAmountModel parkingSpaceAmountModel = new ParkingSpaceAmountModel();
        BeanUtils.copyProperties(parkingSpaceApplyModel, parkingSpaceAmountModel);

        ParkingSpaceAmountVo parkingSpaceAmountVo = this.applyParkingSpaceAmount(parkingSpaceAmountModel, user == null ? null : user.getAccount());
        TbParkingSpaceRentalIbps tbParkingSpaceRental = new TbParkingSpaceRentalIbps();
        BeanUtils.copyProperties(parkingSpaceApplyModel, tbParkingSpaceRental);
        BeanUtils.copyProperties(parkingSpaceAmountVo, tbParkingSpaceRental);
        tbParkingSpaceRental.setAccount(user.getAccount());
        if (StringUtils.isEmpty(parkingSpaceApplyModel.getName())) {
            tbParkingSpaceRental.setName(user.getName() == null ? user.getAccount() : user.getName());
        }
        if (StringUtils.isEmpty(parkingSpaceApplyModel.getPhone())) {
            tbParkingSpaceRental.setPhone(user.getPhone() == null ? user.getAccount() : user.getPhone());
        }
        ParkingSpaceDetailVo parkingSpaceDetailById = getParkingSpaceDetailById(parkingSpaceApplyModel.getSpaceId());
        if (StringUtils.equals(parkingSpaceDetailById.getSpaceStatus(), ParkingEnums.PARKING_BILL_IS_RENT.getCode())) {
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_BILL_IS_RENT);
        }
        tbParkingSpaceRental.setStartTime(parkingSpaceApplyModel.getStartTime() + " 00:00:00");
        tbParkingSpaceRental.setEndTime(parkingSpaceApplyModel.getEndTime() + " 23:59:59");
        tbParkingSpaceRental.setApprovalStatus(ParkingEnums.PARKING_USER_APPLY_WAIT_CHECK.getCode());
        tbParkingSpaceRental.setCreatedTime(DateUtils.formatDate(new Date(), ParkingEnums.DATE_TIME_FORMAT.getCode()));
        tbParkingSpaceRental.setCreatorAccount(user.getAccount());
        tbParkingSpaceRental.setRecordStatus(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        tbParkingSpaceRental.setDeductionMoney(null == parkingSpaceAmountVo.getDeductionMoney()?new Double(0):parkingSpaceAmountVo.getDeductionMoney());
        tbParkingSpaceRental.setActualMoney(null == parkingSpaceAmountVo.getActualMoney()?parkingSpaceAmountVo.getDueMoney():parkingSpaceAmountVo.getActualMoney());
        //处理用户绑定车辆数据
        TbParkingCarInfoCriteria carInfoCriteria = new TbParkingCarInfoCriteria();
        carInfoCriteria.createCriteria().andCarLicenseEqualTo(parkingSpaceApplyModel.getCarLicense()).andCarStatusEqualTo(ParkingEnums.PARKING_USER_CAR_INFO_EFFECTIVE.getCode()).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        List<TbParkingCarInfo> tbParkingCarInfos = tbParkingCarInfoMapper.selectByExample(carInfoCriteria);
        if (null == tbParkingCarInfos || tbParkingCarInfos.size() == 0) {
            ParkingCarInfoModel parkingCarInfoModel = new ParkingCarInfoModel();
            parkingCarInfoModel.setCarLicense(parkingSpaceApplyModel.getCarLicense());
            parkingCarInfoModel.setName(tbParkingSpaceRental.getName());
            parkingCarInfoModel.setPhone(tbParkingSpaceRental.getPhone());
            String s = parkingCarInfoService.saveCarInfo(parkingCarInfoModel, user);
            logger.info("用户车位申请绑定车辆响应结果：{}", s);
        }
        TbParkingPreferential tbParkingPreferential = tbParkingPreferentialMapper.selectByPrimaryKey(parkingSpaceApplyModel.getPolicyId());

        tbParkingSpaceRental.setTb_parking_preferential(tbParkingPreferential);

        IBPSResult ibpsResult = IBPSUtils.startWorkFlow(IBPS_ID, user.getAccount(), tbParkingSpaceRental);

        // ibps启动流程失败
        if (ibpsResult == null || !ibpsResult.getState().equals("200")) {
            logger.warn("[提交车位租赁申请] 启动ibps流程出错，错误信息：" + ibpsResult.getMessage());
            throw new JnSpringCloudException(ParkingExceptionEnum.SPACE_RENTAL_PUBLISH_IBPS_ERROR);
        }
        logger.info("[提交车位租赁申请] " + ibpsResult.getMessage());
        return "1";
    }

    @ServiceLog(doAction = "租车位费用计算接口")
    @Override
    public ParkingSpaceAmountVo applyParkingSpaceAmount(ParkingSpaceAmountModel parkingSpaceAmountModel, String account) {

        String companyId = null;
        if (StringUtils.isNotEmpty(account)) {
            Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(account);
            if (userExtension != null && userExtension.getData() != null && StringUtils.isNotEmpty(userExtension.getData().getCompanyCode())) {
                companyId = userExtension.getData().getCompanyCode();
            }
        } else {
            throw new JnSpringCloudException(ParkingExceptionEnum.USER_LOGIN_INVALID);
        }

        ParkingAreaDetailVo parkingAreaDetailById = parkingAreaService.getParkingAreaDetailById(parkingSpaceAmountModel.getAreaId());
        if (null == parkingAreaDetailById) {
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_AREA_IS_NOT_EXIST);
        }
        ParkingSpaceAmountVo parkingSpaceAmountVo = new ParkingSpaceAmountVo();
        BeanUtils.copyProperties(parkingSpaceAmountModel, parkingSpaceAmountVo);
        parkingSpaceAmountVo.setRentPrice(Double.toString(parkingAreaDetailById.getRentPrice()));
        int dayInterval = 0;
        try {
            dayInterval = getDayInterval(DateUtils.parseDate(parkingSpaceAmountModel.getStartTime(), ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()), DateUtils.parseDate(parkingSpaceAmountModel.getEndTime(), ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()));
        } catch (ParseException e) {
            logger.info("时间转换异常：", e);
            throw new JnSpringCloudException(ParkingExceptionEnum.DAY_INTERVAL_ERROR);
        }
        //计算应缴金额
        double dueMoney = new BigDecimal(dayInterval).multiply(new BigDecimal(Double.toString(parkingAreaDetailById.getRentPrice()))).divide(new BigDecimal(365), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        parkingSpaceAmountVo.setDueMoney(dueMoney);

        if (StringUtils.isNotEmpty(parkingSpaceAmountModel.getPolicyId())) {
            //校验当前停车场是否具有某个优惠数据
            TbParkingPreferentialAreaCriteria areaCriteria = new TbParkingPreferentialAreaCriteria();
            areaCriteria.createCriteria().andAreaIdEqualTo(parkingSpaceAmountModel.getAreaId()).andPolicyIdEqualTo(parkingSpaceAmountModel.getPolicyId()).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
            List<TbParkingPreferentialArea> tbParkingPreferentialAreas = tbParkingPreferentialAreaMapper.selectByExample(areaCriteria);
            if (null == tbParkingPreferentialAreas || tbParkingPreferentialAreas.size() == 0) {
                throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_PREFERENTIAL_IS_NOT_EXIST);
            }
            //获取选择的优惠内容
            TbParkingPreferential tbParkingPreferential = tbParkingPreferentialMapper.selectByPrimaryKey(parkingSpaceAmountModel.getPolicyId());
            if (null == tbParkingPreferential) {
                throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_PREFERENTIAL_IS_NOT_EXIST);
            }
            //获取用户已租天数
            TbParkingSpaceRentalCriteria parkingSpaceRentalCriteria = new TbParkingSpaceRentalCriteria();
            parkingSpaceRentalCriteria.createCriteria().andApprovalStatusEqualTo(ParkingEnums.PARKING_SPACE_RENTAL_IS_PAYED.getCode()).andAccountEqualTo(account).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
            List<TbParkingSpaceRental> tbParkingSpaceRentals = tbParkingSpaceRentalMapper.selectByExample(parkingSpaceRentalCriteria);
            int applyDay = 0;
            for (TbParkingSpaceRental parkingSpaceRental : tbParkingSpaceRentals) {
                applyDay += getDayInterval(parkingSpaceRental.getStartTime(), parkingSpaceRental.getEndTime());
            }
            Boolean fag = true;
            //查询该企业已租赁该优惠车位数
            List<TbParkingSpaceRental> tbParkingSpaceRentals1 = new ArrayList<>(16);
            if (StringUtils.isNotEmpty(companyId)) {
                List<String> status = new ArrayList<>(16);
                status.add(ParkingEnums.PARKING_STATUS_IS_INVALID.getCode());
                status.add(ParkingEnums.PARKING_STATUS_IS_UNCHECKED.getCode());
                TbParkingSpaceRentalCriteria spaceRentalCriteria = new TbParkingSpaceRentalCriteria();
                spaceRentalCriteria.createCriteria().andPolicyIdEqualTo(tbParkingPreferential.getPolicyId()).andApprovalStatusNotIn(status).andEndTimeGreaterThanOrEqualTo(new Date()).andCompanyIdEqualTo(companyId);
                tbParkingSpaceRentals1 = tbParkingSpaceRentalMapper.selectByExample(spaceRentalCriteria);
                parkingSpaceAmountVo.setCompanyId(companyId);
            }
            if (StringUtils.equals(tbParkingPreferential.getPolicyType(), ParkingEnums.PARKING_YEAR_FIXED_DISCOUNT.getCode())) {
                //固定优惠
                if (StringUtils.equals(tbParkingPreferential.getPolicyUserType(), ParkingEnums.PARKING_USER_TYPE_USER.getCode())) {
                    if (null == tbParkingPreferential.getDayConditions() || (applyDay + dayInterval) > tbParkingPreferential.getDayConditions()) {
                        logger.info("固定优惠--满足优惠条件，开始计算优惠金额，优惠政策{}，用户已租天数{}，本次租赁天数{}。", tbParkingPreferential.getPolicyCode(), applyDay, dayInterval);
                        fixedAmountRelief(parkingSpaceAmountVo, tbParkingPreferential, dueMoney);
                    }
                } else if (StringUtils.equals(tbParkingPreferential.getPolicyUserType(), ParkingEnums.PARKING_USER_TYPE_COMPANY.getCode())) {
                    if(tbParkingPreferential.getPolicyCarNum() > tbParkingSpaceRentals1.size()){
                        fixedAmountRelief(parkingSpaceAmountVo,tbParkingPreferential,dueMoney);
                    }else{
                        logger.info("固定优惠--企业优惠指标已使用完毕，不能再次申请。");
                        throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_APPLY_COMPANY_IS_USERED);
                    }
                }
            } else if (StringUtils.equals(tbParkingPreferential.getPolicyType(), ParkingEnums.PARKING_YEAR_PROPORTIONAL_DISCOUNT.getCode())) {
                //比列优惠
                if (StringUtils.equals(tbParkingPreferential.getPolicyUserType(), ParkingEnums.PARKING_USER_TYPE_USER.getCode())) {
                    if (null == tbParkingPreferential.getDayConditions() || (applyDay + dayInterval) > tbParkingPreferential.getDayConditions()) {
                        logger.info("比例优惠--满足优惠条件，开始计算优惠金额，优惠政策{}，用户已租天数{}，本次租赁天数{}。", tbParkingPreferential.getPolicyCode(), applyDay, dayInterval);
                        ratioAmountRelief(parkingSpaceAmountVo, tbParkingPreferential, dueMoney);
                    }
                } else if (StringUtils.equals(tbParkingPreferential.getPolicyUserType(), ParkingEnums.PARKING_USER_TYPE_COMPANY.getCode())) {
                    if(tbParkingPreferential.getPolicyCarNum() > tbParkingSpaceRentals1.size()){
                        ratioAmountRelief(parkingSpaceAmountVo, tbParkingPreferential, dueMoney);
                    }else{
                        logger.info("比例优惠--企业优惠指标已使用完毕，不能再次申请。");
                        throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_APPLY_COMPANY_IS_USERED);
                    }
                }
            } else if (StringUtils.equals(tbParkingPreferential.getPolicyType(), ParkingEnums.PARKING_YEAR_PROPORTIONAL_TAXI.getCode())) {
                //税收优惠，需查询企业税收，得到企业税收金额，判断能优惠几个车位
                if (StringUtils.isEmpty(companyId)) {
                    throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_APPLY_USER_IS_NOT_COMPANY);
                }
                logger.info("车位申请----优惠政策类型为企业，校验企业税费等内容");
                String companyTax = "100";
                //TODO jiangyl 企业税收金额掉用丙权的接口获取。获取后复制给companyTax即可。单位为万元
                if ((new BigDecimal(companyTax).compareTo(tbParkingPreferential.getTaxtBasis()) == 0) || (new BigDecimal(companyTax).compareTo(tbParkingPreferential.getTaxtBasis()) == 1)) {
                    // carsNum 渠道优惠车位个数
                    int carsNum = (int) new BigDecimal(companyTax).divide(tbParkingPreferential.getTaxtBasis()).doubleValue();
                    if (null != tbParkingPreferential.getPolicyCarMax() && carsNum > tbParkingPreferential.getPolicyCarMax()) {
                        carsNum = tbParkingPreferential.getPolicyCarMax();
                    }
                    if (null == tbParkingSpaceRentals1 || carsNum > tbParkingSpaceRentals1.size()) {
                        fixedAmountRelief(parkingSpaceAmountVo, tbParkingPreferential, dueMoney);
                    } else {
                        logger.info("企业优惠指标已使用完毕，不能再次申请。");
                        throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_APPLY_COMPANY_IS_USERED);
                    }
                } else {
                    logger.info("企业税收不符合减免基数");
                    throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_APPLY_TAX_LESS);
                }
            }
        } else {
            logger.info("无对应优惠数据，优惠金额为0，按原价计算");
            parkingSpaceAmountVo.setDeductionMoney(new Double(0));
            parkingSpaceAmountVo.setActualMoney(dueMoney);
        }
        return parkingSpaceAmountVo;
    }


    /**
     * 固定金额减免
     *
     * @return
     */
    public ParkingSpaceAmountVo fixedAmountRelief(ParkingSpaceAmountVo parkingSpaceAmountVo, TbParkingPreferential tbParkingPreferential, Double dueMoney) {
        parkingSpaceAmountVo.setDeductionMoney(tbParkingPreferential.getOfferPrice());
        parkingSpaceAmountVo.setActualMoney(new BigDecimal(Double.toString(dueMoney)).subtract(new BigDecimal(Double.toString(tbParkingPreferential.getOfferPrice()))).doubleValue());
        return parkingSpaceAmountVo;
    }

    /**
     * 比列减免
     *
     * @return
     */
    public ParkingSpaceAmountVo ratioAmountRelief(ParkingSpaceAmountVo parkingSpaceAmountVo, TbParkingPreferential tbParkingPreferential, Double dueMoney) {
        BigDecimal divide = new BigDecimal(dueMoney).multiply(new BigDecimal(Double.toString(tbParkingPreferential.getOfferRatio()))).divide(new BigDecimal("10"), 2, BigDecimal.ROUND_HALF_UP);
        parkingSpaceAmountVo.setDeductionMoney(divide.doubleValue());
        parkingSpaceAmountVo.setActualMoney(new BigDecimal(Double.toString(dueMoney)).subtract(divide).doubleValue());
        return parkingSpaceAmountVo;
    }

    /**
     * 计算两时间间隔天数 [开始时间不能少于结束时间]
     *
     * @param startTime 开始时间 yyyy-MM-dd
     * @param endTime   结束时间 yyyy-MM-dd
     * @return
     */
    @ServiceLog(doAction = "计算两时间间隔天数")
    @Override
    public int getDayInterval(Date startTime, Date endTime) {
        int days = 0;
        Calendar can1 = Calendar.getInstance();
        can1.setTime(startTime);
        Calendar can2 = Calendar.getInstance();
        can2.setTime(endTime);
        int year1 = can1.get(Calendar.YEAR);
        int year2 = can2.get(Calendar.YEAR);
        //天数
        Calendar can = null;
        if (can1.before(can2)) {
            days -= can1.get(Calendar.DAY_OF_YEAR);
            days += can2.get(Calendar.DAY_OF_YEAR);
            can = can1;
        } else {
            throw new JnSpringCloudException(ParkingExceptionEnum.START_TIME_NOT_AFTER_END_TIME);
        }
        for (int i = 0; i < Math.abs(year2 - year1); i++) {
            //获取小的时间当前年的总天数
            days += can.getActualMaximum(Calendar.DAY_OF_YEAR);
            //再计算下一年。
            can.add(Calendar.YEAR, 1);
        }
        logger.info("时间查计算结果{}", days);
        return days;
    }


    @ServiceLog(doAction = "创建停车月卡缴费账单")
    @Override
    public String createParkingSpaceBill(String rentId, User user) {
        TbParkingSpaceRental tbParkingSpaceRental = tbParkingSpaceRentalMapper.selectByPrimaryKey(rentId);
        if (null == tbParkingSpaceRental) {
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_REND_IS_NOT_EXIST);
        }
        if (StringUtils.isNotEmpty(tbParkingSpaceRental.getOrderBillNum())) {
            Result<PayBillVO> payBillDetailByIdOrNum = payBillClient.getPayBillDetailByIdOrNum(tbParkingSpaceRental.getOrderBillNum());
            PayBillVO data = payBillDetailByIdOrNum.getData();
            if (null != data && StringUtils.isNotEmpty(data.getBillId())) {
                return data.getBillId();
            }
        }
        PaymentBillModel paymentBillModel = new PaymentBillModel();
        paymentBillModel.setBillNum("PK-" + DateUtils.getDate(ParkingEnums.DATE_TIME_FORMAT_DATE_NUM.getCode()) + RandomUtils.nextInt(999));
        paymentBillModel.setBillName(tbParkingSpaceRental.getCarLicense() + "[" + DateUtils.formatDate(tbParkingSpaceRental.getStartTime(), ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()) + "至" + DateUtils.formatDate(tbParkingSpaceRental.getEndTime(), ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()) + "月租卡");
        paymentBillModel.setBillType(ParkingEnums.PARKING_MONTH_BILL_TYPE.getCode());
        paymentBillModel.setBillObjId(user.getAccount());
        paymentBillModel.setBillObjName(user.getName());
        paymentBillModel.setBillAmount(tbParkingSpaceRental.getActualMoney());
        paymentBillModel.setPayEndTime(DateUtils.formatDate(DateUtils.addDays(new Date(), 1), ParkingEnums.DATE_TIME_FORMAT.getCode()));
        paymentBillModel.setBillCreateAccount(user.getAccount());
        paymentBillModel.setBillRemark(ParkingEnums.PARKING_MONTH_BILL_TYPE_NAME.getCode());
        Result<String> bill = payBillClient.createBill(paymentBillModel);
        //支付发起成功，将支付账单id写入停车记录，方便下次发起支付删除原有缴费记录。

        if (StringUtils.equals(bill.getCode(), ParkingEnums.PARKING_RESPONSE_SUCCESS.getCode())) {
            tbParkingSpaceRental.setOrderBillNum(paymentBillModel.getBillNum());
            tbParkingSpaceRental.setModifiedTime(new Date());
            int i = tbParkingSpaceRentalMapper.updateByPrimaryKeySelective(tbParkingSpaceRental);
            logger.info("租车位支付发起成功，处理租赁记录数据账单号响应条数：{}", i);
            return bill.getData();
        } else {
            logger.info("租车位支付发起失败");
            return bill.getResult();
        }
    }


}
