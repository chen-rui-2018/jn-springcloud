package com.jn.hardware.parking.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.RestTemplateUtil;
import com.jn.common.util.StringUtils;
import com.jn.hardware.config.ParkingDrUrlProperties;
import com.jn.hardware.enums.ParkingCompanyEnum;
import com.jn.hardware.enums.ParkingExceptionEnum;
import com.jn.hardware.model.parking.*;
import com.jn.hardware.model.parking.door.*;
import com.jn.hardware.parking.service.ParkingService;
import com.jn.hardware.util.JsonStringToObjectUtil;
import com.jn.park.api.ParkingClient;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



/**
 * 导致接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 17:22
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class ParkingServiceImpl implements ParkingService {

    private final Logger logger = LoggerFactory.getLogger(ParkingServiceImpl.class);
    @Autowired
    private ParkingDrUrlProperties parkingDrUrlProperties;
    @Autowired
    private ParkingClient parkingClient;

     private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 临停预缴费信息(场内缴费)查询
     * @param temporaryCarParkingFeeRequest
     * @return
     */
    @Override
    public Result getTemporaryCarParkingFee(TemporaryCarParkingFeeRequest temporaryCarParkingFeeRequest) {
        logger.info("\n临停预缴费信息(场内缴费)查询接口入参【{}】",temporaryCarParkingFeeRequest);
        Result result=new Result();
        String url = "";
        if(ParkingCompanyEnum.ALL_COMPANY.getCode().equals(temporaryCarParkingFeeRequest.getParkingCompanyId())) {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult("\n临停预缴费信息查询必须明确哪个硬件公司(parkingCompanyId).");
        }else if(ParkingCompanyEnum.DOOR_COMPANY.getCode().equals(temporaryCarParkingFeeRequest.getParkingCompanyId())) {
            //调用道尔硬件接口
            url = String.format(parkingDrUrlProperties.getDoorTemporarycarParkingfeeUrl(),temporaryCarParkingFeeRequest.getDoorTemporaryCarParkingFeeRequest().getParkid()
            ,temporaryCarParkingFeeRequest.getDoorTemporaryCarParkingFeeRequest().getParkid(),temporaryCarParkingFeeRequest.getDoorTemporaryCarParkingFeeRequest().getCarNo());
            String responseString = RestTemplateUtil.get(url);
            logger.info("\n临停预缴费信息(场内缴费)查询，道尔接口地址：【{}】,响应：【{}】",url,responseString);
            DoorResult<DoorTemporaryCarParkingFeeResponse> doorResult = JsonStringToObjectUtil.jsonToObject(responseString,new TypeReference<DoorResult<DoorTemporaryCarParkingFeeResponse>>(){});
            if(DoorResult.SUCCESS_CODE.equals(doorResult.getHead().getStatus())) {
                result.setData(doorResult.getBody());
            }else {
                result.setCode(ParkingExceptionEnum.DOOR_COMPANY_EXCEPTION.getCode());
                result.setResult(doorResult.getHead().getMessage());
            }
        }else {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult(ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
            logger.info("\n道尔的临停预缴费信息(场内缴费)查询失败，原因：{}",ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
        }
        logger.info("\n临停预缴费信息(场内缴费),返回结果【{}】",result);
        return result;
    }

    /**
     * 保存停车场缴费信息
     * @param paymentCarParkingFeeRequest
     * @return
     */
    @Override
    public Result savePaymentCarParkingFee(PaymentCarParkingFeeRequest paymentCarParkingFeeRequest) {
        logger.info("\n保存停车场缴费信息入参【{}】",paymentCarParkingFeeRequest);
        Result result=new Result();
        String url = "";
        String jsonData = "";
        if(ParkingCompanyEnum.ALL_COMPANY.getCode().equals(paymentCarParkingFeeRequest.getParkingCompanyId())) {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult("保存临停预缴费信息必须明确哪个硬件公司(parkingCompanyId).");
        }else if(ParkingCompanyEnum.DOOR_COMPANY.getCode().equals(paymentCarParkingFeeRequest.getParkingCompanyId())) {
            //调用道尔硬件接口路径
            url = String.format(parkingDrUrlProperties.getDoorSavePaymentCarparkingfeeUrl(),paymentCarParkingFeeRequest.getDoorPaymentCarParkingFeeRequest().getParkid());
            //接口调用的入参
            DoorPaymentCarParkingFeeRequest  doorpayment = paymentCarParkingFeeRequest.getDoorPaymentCarParkingFeeRequest();
            if(doorpayment!= null){
                jsonData = JsonStringToObjectUtil.objectToJson(doorpayment);
            }
            String responseString = RestTemplateUtil.post(url,jsonData);
            logger.info("\n保存停车场缴费信息,调用道尔接口入参：【{}】,响应结果{}",jsonData,responseString);
            DoorResult doorResult = JsonStringToObjectUtil.jsonToObject(responseString,new TypeReference<DoorResult>(){});
            if(DoorResult.SUCCESS_CODE.equals(doorResult.getHead().getStatus())) {
                result.setData(doorResult.getBody());
            }else {
                result.setCode(ParkingExceptionEnum.DOOR_COMPANY_EXCEPTION.getCode());
                result.setResult(doorResult.getHead().getMessage());
            }
        }else {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult(ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
            logger.info("\n保存停车场缴费信息失败，原因：{}",ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
        }
        logger.info("\n保存停车场缴费信息失败,返回结果【{}】",result);
        return result;
    }

    /**
     * 月租卡开户信息保存
     * @param parkingMonthlyRentCardUnite
     * @return
     */
    @Override
    public Result saveParkingMonthlyRentCard(ParkingMonthlyRentCardUnite parkingMonthlyRentCardUnite) {
        logger.info("\n月租卡开户信息保存入参:【{}】",parkingMonthlyRentCardUnite);
        Result result=new Result();
        String url = "";
        String jsonData = "";
        if(ParkingCompanyEnum.ALL_COMPANY.getCode().equals(parkingMonthlyRentCardUnite.getParkingCompanyId())) {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult("月租卡开户信息保存必须明确哪个硬件公司(parkingCompanyId).");
        }else if(ParkingCompanyEnum.DOOR_COMPANY.getCode().equals(parkingMonthlyRentCardUnite.getParkingCompanyId())) {
            //调用道尔硬件接口路径
            url = String.format(parkingDrUrlProperties.getDoorSaveMonthlyRentCardUrl(),parkingMonthlyRentCardUnite.getAreaId());
            //接口调用的入参
            DoorParkingMonthlyRentCardParam doorRentCard = new DoorParkingMonthlyRentCardParam();
            doorRentCard.setParkid(parkingMonthlyRentCardUnite.getAreaId());
            doorRentCard.setCarNo(parkingMonthlyRentCardUnite.getCarLicense());
            doorRentCard.setCardTypeId(parkingMonthlyRentCardUnite.getCardTypeId());
            doorRentCard.setStartDate(parkingMonthlyRentCardUnite.getStartTime());
            doorRentCard.setEndDate(parkingMonthlyRentCardUnite.getEndTime());
            doorRentCard.setAmount(parkingMonthlyRentCardUnite.getActualMoney());
            doorRentCard.setPayType(parkingMonthlyRentCardUnite.getPayType());
            doorRentCard.setPaymentNumber(parkingMonthlyRentCardUnite.getOrderBillNum());
            doorRentCard.setPayDate(parkingMonthlyRentCardUnite.getPayDate());
            doorRentCard.setPayDate(parkingMonthlyRentCardUnite.getPayDate());
            doorRentCard.setContactName(parkingMonthlyRentCardUnite.getAccount());
            doorRentCard.setContactPhone(parkingMonthlyRentCardUnite.getPhone());
            doorRentCard.setOperaterName(parkingMonthlyRentCardUnite.getOperaterName());
            if(doorRentCard!= null){
                jsonData = JsonStringToObjectUtil.objectToJson(doorRentCard);
            }
            String responseString = RestTemplateUtil.post(url,jsonData);
            logger.info("\n月租卡开户信息保存,调用道尔接口入参：【{}】,出参:【{}】",jsonData,responseString);
            DoorResult<DoorParkingMonthlyRentCardShow> doorResult = JsonStringToObjectUtil.jsonToObject(responseString,new TypeReference<DoorResult<DoorParkingMonthlyRentCardShow>>(){});
            if(DoorResult.SUCCESS_CODE.equals(doorResult.getHead().getStatus())) {
                result.setData(doorResult.getBody());
            }else {
                result.setCode(ParkingExceptionEnum.DOOR_COMPANY_EXCEPTION.getCode());
                result.setResult(doorResult.getHead().getMessage());
            }
            logger.info("\n月租卡开户信息保存 保存结果{}",doorResult);
        }else {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult(ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
            logger.info("\n月租卡开户信息保存 保存失败，原因：{}",ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
        }
        logger.info("\n月租卡开户信息保存,返回结果【{}】",result);
        return result;
    }

    /**
     * 月租卡信息查询
     * @param parkingMonthlyCardInfoRequest
     * @return
     */
    @Override
    public Result findParkingMonthlyRentCard(ParkingMonthlyCardInfoRequest parkingMonthlyCardInfoRequest) {
        logger.info("\n月租卡信息查询入参:【{}】",parkingMonthlyCardInfoRequest);
        Result result=new Result();
        String url = "";
        if(ParkingCompanyEnum.ALL_COMPANY.getCode().equals(parkingMonthlyCardInfoRequest.getParkingCompanyId())) {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult("月租卡信息查询必须明确哪个硬件公司(parkingCompanyId).");
        }else if(ParkingCompanyEnum.DOOR_COMPANY.getCode().equals(parkingMonthlyCardInfoRequest.getParkingCompanyId())) {
            //调用道尔硬件接口
            url = String.format(parkingDrUrlProperties.getDoorFindMonthlyRentCardUrl()
                    ,parkingMonthlyCardInfoRequest.getDoorParkingMonthlyCardParam().getParkid()
                    ,parkingMonthlyCardInfoRequest.getDoorParkingMonthlyCardParam().getParkid()
                    ,parkingMonthlyCardInfoRequest.getDoorParkingMonthlyCardParam().getCarNo()
                    ,parkingMonthlyCardInfoRequest.getDoorParkingMonthlyCardParam().getUserDate()
                    ,parkingMonthlyCardInfoRequest.getDoorParkingMonthlyCardParam().getPageNo()
                    ,parkingMonthlyCardInfoRequest.getDoorParkingMonthlyCardParam().getPageSize());
            String responseString = RestTemplateUtil.get(url);
            logger.info("\n月租卡信息查询,道尔接口地址：【{}】,响应【{}】",url,responseString);
            DoorResult<List<DoorParkingMonthlyCardInfo>> doorResult = JsonStringToObjectUtil.jsonToObject(responseString,new TypeReference<DoorResult<List<DoorParkingMonthlyCardInfo>>>(){});
           if(doorResult==null ){
               doorResult = JsonStringToObjectUtil.jsonToObject(responseString,new TypeReference<DoorResult>(){});
           }
            if(DoorResult.SUCCESS_CODE.equals(doorResult.getHead().getStatus())) {
                DoorParkingMonthlyCardShow  carShow = new  DoorParkingMonthlyCardShow();
                carShow.setPageNo(doorResult.getHead().getPageNo());
                carShow.setPageSize(doorResult.getHead().getPageSize());
                carShow.setRows(doorResult.getHead().getRows());
                carShow.setCardInfo(doorResult.getBody());
                result.setData(carShow);
            }else {
                result.setCode(ParkingExceptionEnum.DOOR_COMPANY_EXCEPTION.getCode());
                result.setResult(doorResult.getHead().getMessage());
            }
            logger.info("\n月租卡信息,返回结果【{}】",doorResult);
        }else {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult(ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
            logger.info("\n月租卡信息查询  查询失败，原因：{}",ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
        }
        return result;
    }

    /**
     * 月租卡续费信息保存
     * @param monthlyRentalCardRenewalFeeRequset
     * @return
     */
    @Override
    public Result saveMonthlyRentalCardRenewalFee(MonthlyRentalCardRenewalFeeRequset monthlyRentalCardRenewalFeeRequset) {
        logger.info("\n月租卡续费信息保存入参:【{}】",monthlyRentalCardRenewalFeeRequset);
        Result result=new Result();
        String url = "";
        String jsonData = "";
        if(ParkingCompanyEnum.ALL_COMPANY.getCode().equals(monthlyRentalCardRenewalFeeRequset.getParkingCompanyId())) {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult("月租卡续费信息保存必须明确哪个硬件公司(parkingCompanyId).");
        }else if(ParkingCompanyEnum.DOOR_COMPANY.getCode().equals(monthlyRentalCardRenewalFeeRequset.getParkingCompanyId())) {
            //调用道尔硬件接口路径
            url = String.format(parkingDrUrlProperties.getDoorSaveMonthlyRentalCardRenewalfeeUrl(),monthlyRentalCardRenewalFeeRequset.getDoorMonthlyRentalCardRenewalFeeParam().getParkid());
            //接口调用的入参
            DoorMonthlyRentalCardRenewalFeeParam doorRentCard = monthlyRentalCardRenewalFeeRequset.getDoorMonthlyRentalCardRenewalFeeParam();
            if(doorRentCard!= null){
                jsonData = JsonStringToObjectUtil.objectToJson(doorRentCard);
            }
            String responseString = RestTemplateUtil.post(url,jsonData);
            logger.info("\n月租卡续费信息保存，道尔接口入参：【{}】,响应结果{}",jsonData,responseString);
            DoorResult  doorResult = JsonStringToObjectUtil.jsonToObject(responseString,new TypeReference<DoorResult>(){});
            if(DoorResult.SUCCESS_CODE.equals(doorResult.getHead().getStatus())) {
                result.setData(doorResult.getBody());
            }else {
                result.setCode(ParkingExceptionEnum.DOOR_COMPANY_EXCEPTION.getCode());
                result.setResult(doorResult.getHead().getMessage());
            }
        }else {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult(ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
            logger.info("\n月租卡续费信息保存 保存失败，原因：{}",ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
        }
        return result;
    }

    /**
     * 月租信息获取(含费率)
     * @param monthyRentalCardRateRequest
     * @return
     */
    @Override
    public Result  findMonthlyRentCardRateInfo(MonthyRentalCardRateRequest monthyRentalCardRateRequest) {
        logger.info("\n月租信息获取(含费率)入参:【{}】",monthyRentalCardRateRequest);
        Result result=new Result();
        String url = "";
        if(ParkingCompanyEnum.ALL_COMPANY.getCode().equals(monthyRentalCardRateRequest.getParkingCompanyId())) {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult("月租信息获取(含费率)查询必须明确哪个硬件公司(parkingCompanyId).");
        }else if(ParkingCompanyEnum.DOOR_COMPANY.getCode().equals(monthyRentalCardRateRequest.getParkingCompanyId())) {
            //调用道尔硬件接口
            url = String.format(parkingDrUrlProperties.getDoorFindMonthlyrentcardRateinfoUrl(),monthyRentalCardRateRequest.getDoorMonthlyRentCardRateParam().getParkid()
                    ,monthyRentalCardRateRequest.getDoorMonthlyRentCardRateParam().getParkid(),monthyRentalCardRateRequest.getDoorMonthlyRentCardRateParam().getCarNo());
            String responseString = RestTemplateUtil.get(url);
            logger.info("\n月租信息获取(含费率)信息(场内缴费)，道尔接口地址：【{}】,响应结果{}",url,responseString);
            DoorResult<DoorMonthlyRentCardRateInfo> doorResult = JsonStringToObjectUtil.jsonToObject(responseString,new TypeReference<DoorResult<DoorMonthlyRentCardRateInfo>>(){});
            if(DoorResult.SUCCESS_CODE.equals(doorResult.getHead().getStatus())) {
                result.setData(doorResult.getBody());
            }else {
                result.setCode(ParkingExceptionEnum.DOOR_COMPANY_EXCEPTION.getCode());
                result.setResult(doorResult.getHead().getMessage());
            }
        }else {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult(ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
            logger.info("\n月租信息获取(含费率)信息(场内缴费)查询失败，原因：{}",ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
        }
        return result;
    }

    /**
     * 月租卡销户操作
     * @param cancelMonthlyRentAccountRequest
     * @return
     */
    @Override
    public Result cancelMonthlyRentAccount(CancelMonthlyRentAccountRequest cancelMonthlyRentAccountRequest) {
        logger.info("\n月租卡销户操作入参:【{}】",cancelMonthlyRentAccountRequest);
        Result result=new Result();
        String url = "";
        String jsonData = "";
        if(ParkingCompanyEnum.ALL_COMPANY.getCode().equals(cancelMonthlyRentAccountRequest.getParkingCompanyId())) {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult("注销月租卡存必须明确哪个硬件公司(parkingCompanyId).");
        }else if(ParkingCompanyEnum.DOOR_COMPANY.getCode().equals(cancelMonthlyRentAccountRequest.getParkingCompanyId())) {
            //调用道尔硬件接口路径
            url = String.format(parkingDrUrlProperties.getDoorCancelMonthlyrentAccountUrl(), cancelMonthlyRentAccountRequest.getDoorCancelMonthlyRentAccountParam().getParkid());
            //接口调用的入参
            DoorCancelMonthlyRentAccountParam doorRentCard = cancelMonthlyRentAccountRequest.getDoorCancelMonthlyRentAccountParam();
            if(doorRentCard!= null){
                jsonData = JsonStringToObjectUtil.objectToJson(doorRentCard);
            }
            String responseString = RestTemplateUtil.post(url,jsonData);
            logger.info("\n注销月租卡，道尔接口入参：【{}】,返回结果{}",jsonData,responseString);
            DoorResult  doorResult = JsonStringToObjectUtil.jsonToObject(responseString,new TypeReference<DoorResult>(){});
            if(DoorResult.SUCCESS_CODE.equals(doorResult.getHead().getStatus())) {
                result.setData(doorResult.getBody());
            }else {
                result.setCode(ParkingExceptionEnum.DOOR_COMPANY_EXCEPTION.getCode());
                result.setResult(doorResult.getHead().getMessage());
            }
        }else {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult(ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
            logger.info("\n注销月租卡 注销失败，原因：{}",ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
        }
        return result;
    }

    /**
     * 车场车位查询
     * @param parkingSpaceAmountRequest
     * @return
     */
    @Override
    public Result findParkingSpaceAmount(ParkingSpaceAmountRequest parkingSpaceAmountRequest) {
        logger.info("\n车场车位查询入参:【{}】",parkingSpaceAmountRequest);
        Result result=new Result();
        String url = "";
        if(ParkingCompanyEnum.ALL_COMPANY.getCode().equals(parkingSpaceAmountRequest.getParkingCompanyId())) {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult("车场车位查询 必须明确哪个硬件公司(parkingCompanyId).");
        }else if(ParkingCompanyEnum.DOOR_COMPANY.getCode().equals(parkingSpaceAmountRequest.getParkingCompanyId())) {
            //调用道尔硬件接口
            url = String.format(parkingDrUrlProperties.getDoorParkingspaceAmountUrl(),parkingSpaceAmountRequest.getParkid()
                    ,parkingSpaceAmountRequest.getParkid());
            String responseString = RestTemplateUtil.get(url);
            logger.info("\n车场车位查询,道尔接口地址:【{}】,响应结果{}",url,responseString);
            DoorResult<DoorParkingSpaceAmountShow> doorResult = JsonStringToObjectUtil.jsonToObject(responseString,new TypeReference<DoorResult<DoorParkingSpaceAmountShow>>(){});
            if(DoorResult.SUCCESS_CODE.equals(doorResult.getHead().getStatus())) {
                result.setData(doorResult.getBody());
            }else {
                result.setCode(ParkingExceptionEnum.DOOR_COMPANY_EXCEPTION.getCode());
                result.setResult(doorResult.getHead().getMessage());
            }
        }else {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult(ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
            logger.info("\n车场车位查询失败，原因：{}",ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
        }
        return result;

    }

    /**
     * 道尔: 车辆入场信息保存
     * @param doorCarInParkingParam
     * @return
     */
    @Override
    public DoorResult saveDoorCarInParkingInfo(DoorCarInParkingParam doorCarInParkingParam ,String requestUrl,String parkId) {
        String signatureKey =  ParkingCompanyEnum.SIGNATURE_KEY.getMessage();
        String secretString = String.format("%s@#%s@#%s", requestUrl, doorCarInParkingParam.getT(), signatureKey);

        DoorResult doorResult = new DoorResult();
        try {
            secretString = traditionMd5(secretString);
            //secretString.equals(doorCarInParkingParam.getSignature())
            if(StringUtils.isNotBlank(secretString)){
                DoorCarInParkingInfo info = new DoorCarInParkingInfo();
                List<DoorCarInParkingShow> list= new ArrayList<DoorCarInParkingShow>();
                if(doorCarInParkingParam.getCarinlist()!=null) {
                    String  inString = doorCarInParkingParam.getCarinlist().replaceAll(ParkingCompanyEnum.REPLACE_ALL.getCode(),"\"");
                    inString = inString.replaceAll(ParkingCompanyEnum.REPLACE_PAY_DATE_U.getCode(),ParkingCompanyEnum.REPLACE_PAY_DATE_L.getCode());
                    inString = inString.replaceAll(ParkingCompanyEnum.REPLACE_ALL_SLASH.getCode(),"\\\\\\\\");
                    logger.info("\n转换完成后的入场信息字符串inString:"+inString);
                    list = JsonStringToObjectUtil.jsonToObject(inString, new TypeReference<List<DoorCarInParkingShow>>() {});
                }
                info.setCarinlist(list);
                info.setParkId(parkId);
                Result<String> result  = parkingClient.carJoinParking(info);
                if(!result.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                    doorResult.getHead().setStatus(result.getCode());
                    doorResult.getHead().setMessage(result.getResult());
                    throw new JnSpringCloudException(ParkingExceptionEnum.DOOR_CAR_PARKING_IN,result.getResult());
                }else{
                    doorResult.getHead().setStatus(DoorResult.SUCCESS_CODE);
                    String ids = result.getData() != null ? result.getData() : "";
                    DoorInOutParkingShow show = new DoorInOutParkingShow();
                    show.setIds(ids);
                    doorResult.setBody(show);
                }
            }else {
                DoorHeadResult headResult = new DoorHeadResult();
                headResult.setStatus(ParkingExceptionEnum.DOOR_CAR_PARKING_SIGNNATURE.getCode());
                headResult.setMessage(ParkingExceptionEnum.DOOR_CAR_PARKING_SIGNNATURE.getMessage());
                doorResult.setHead(headResult);
                logger.info("\n车场入场信息录入失败，失败原因：{}",ParkingExceptionEnum.DOOR_CAR_PARKING_SIGNNATURE.getMessage());
            }
        }catch (Exception e){
            doorResult.getHead().setStatus(e.getMessage());
            doorResult.getHead().setMessage(e.getMessage());
            logger.info("车场入场信息录入失败，失败原因：{}"+e.getMessage());
            e.printStackTrace();
        }
        return doorResult;
    }

    /**
     * 道尔: 车辆出场信息保存
     * @param doorCarOutParkingParam
     * @return
     */
    @Override
    public DoorResult saveDoorCarOutParkingInfo(DoorCarOutParkingParam doorCarOutParkingParam,String requestUrl,String parkId) {
        String signatureKey =  ParkingCompanyEnum.SIGNATURE_KEY.getMessage();
        String secretString = String.format("%s@#%s@#%s", requestUrl, doorCarOutParkingParam.getT(), signatureKey);

        DoorResult doorResult = new DoorResult();
        try {
            secretString = traditionMd5(secretString);
            //secretString.equals(doorCarInParkingParam.getSignature())
            if(StringUtils.isNotBlank(secretString)){
                DoorCarOutParkingInfo info = new DoorCarOutParkingInfo();
                List<DoorCarOutParkingShow> list= new ArrayList<DoorCarOutParkingShow>();
                if(doorCarOutParkingParam.getCaroutlist()!=null) {

                    String  outString = doorCarOutParkingParam.getCaroutlist().replaceAll(ParkingCompanyEnum.REPLACE_ALL.getCode(),"\"");
                    outString = outString.replaceAll(ParkingCompanyEnum.REPLACE_PAY_DATE_U.getCode(),ParkingCompanyEnum.REPLACE_PAY_DATE_L.getCode());
                    outString = outString.replaceAll(ParkingCompanyEnum.REPLACE_ALL_SLASH.getCode(),"\\\\\\\\");
                    logger.info("\n转换完成后的出场信息字符串inString:"+outString);
                    list = JsonStringToObjectUtil.jsonToObject(outString, new TypeReference<List<DoorCarOutParkingShow>>() {});
                }
                info.setParkId(parkId);
                info.setCaroutlist(list);
                Result<String> result  = parkingClient.carOutParking(info);
                if(!result.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                    doorResult.getHead().setStatus(result.getCode());
                    doorResult.getHead().setMessage(result.getResult());
                    throw new JnSpringCloudException(ParkingExceptionEnum.DOOR_CAR_PARKING_OUT,result.getResult());
                }else {
                    doorResult.getHead().setStatus(DoorResult.SUCCESS_CODE);
                    String ids = result.getData()!=null?result.getData():"";
                    DoorInOutParkingShow show = new DoorInOutParkingShow();
                    show.setIds(ids);
                    doorResult.setBody(show);
                }

            }else {
                DoorHeadResult headResult = new DoorHeadResult();
                headResult.setStatus(ParkingExceptionEnum.DOOR_CAR_PARKING_SIGNNATURE.getCode());
                headResult.setMessage(ParkingExceptionEnum.DOOR_CAR_PARKING_SIGNNATURE.getMessage());
                doorResult.setHead(headResult);
                logger.info("\n车场出场信息录入失败，失败原因：{}",ParkingExceptionEnum.DOOR_CAR_PARKING_SIGNNATURE.getMessage());
            }
        }catch (Exception e){
            doorResult.getHead().setStatus(e.getMessage());
            doorResult.getHead().setMessage(e.getMessage());
            logger.info("车场出场信息录入失败，失败原因：{}"+e.getMessage());
            e.printStackTrace();
        }

        return doorResult;
    }


    /**
     * @param text
     * @return 传统的MD5加密方式，与客户端加密方法相同
     * @throws Exception
     */
    public  String traditionMd5(String text) throws Exception {
        try
        {
            //加密后的字符串
            byte[] bytes=text.getBytes("utf-8");
            byte[] encodeStrByte=DigestUtils.md5(bytes);
            String re=bytesToHexFun1(encodeStrByte);
            return re.toUpperCase();
        }
        catch (Exception e){
            logger.info("MD5加密失败!");
            e.printStackTrace();
        }
        return "";
    }
    /**
     * byte[]数组转16进制字符串
     * @param bytes
     * @return
     */
    private  String bytesToHexFun1(byte[] bytes) {
        // 一个byte为8位，可用两个十六进制位标识
        char[] buf = new char[bytes.length * 2];
        int a = 0;
        int index = 0;
        // 使用除与取余进行转换
        for(byte b : bytes) {
            if(b < 0) {
                a = 256 + b;
            } else {
                a = b;
            }
            buf[index++] = HEX_CHAR[a / 16];
            buf[index++] = HEX_CHAR[a % 16];
        }

        return new String(buf);
    }
}
