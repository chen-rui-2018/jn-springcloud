package com.jn.park.attractinvest.aspect;

import com.jn.company.api.CompanyClient;
import com.jn.company.model.UpdateCompanyInfoParam;
import com.jn.park.asset.entity.TbTowerInformation;
import com.jn.park.asset.service.TowerManageService;
import com.jn.park.attractinvest.dao.ProjectEnterDetailsMapper;
import com.jn.park.attractinvest.dao.TbProjectInfoMapper;
import com.jn.park.attractinvest.enmus.ProjectStatusEnums;
import com.jn.park.attractinvest.entity.TbProjectEnterDetails;
import com.jn.park.attractinvest.entity.TbProjectInfoCriteria;
import com.jn.park.attractinvest.entity.TbProjectInfoWithBLOBs;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.park.repair.enums.PaymentBillEnum;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 房间订单缴费单回调切面
 *
 * @author： shaobao
 * @date： Created on 2019/6/11 20:35
 * @version： v1.0
 * @modified By:
 **/
@Aspect
@Component
public class RoomBillCallBackAspect {

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(RoomBillCallBackAspect.class);

    @Autowired
    private TbProjectInfoMapper tbProjectInfoMapper;

    @Autowired
    private ProjectEnterDetailsMapper projectEnterDetailsMapper;

    @Autowired
    private CompanyClient companyClient;

    @Autowired
    private TowerManageService towerManageService;

    @Pointcut("execution(public * com.jn.park.asset.service.impl.RoomInformationServiceImpl.updateBill(..))")
    public void roomBillCut() {
    }

    @Before("roomBillCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            PayCallBackNotify payCallBackNotify = (PayCallBackNotify) args[0];
            //获取订单id
            String billId = payCallBackNotify.getBillId();
            //获取账单状态
            String paymentState = payCallBackNotify.getPaymentState();
            //如果账单状态是支付成功状态
            if (PaymentBillEnum.BILL_ORDER_IS_PAY.getCode().equals(paymentState)) {
                TbProjectInfoCriteria tbProjectInfoCriteria = new TbProjectInfoCriteria();
                TbProjectInfoCriteria.Criteria criteria = tbProjectInfoCriteria.createCriteria();
                criteria.andRoomBillIdEqualTo(billId);
                List<TbProjectInfoWithBLOBs> tbProjectInfoWithBLOBs = tbProjectInfoMapper.selectByExampleWithBLOBs(tbProjectInfoCriteria);
                //如果订单id对应数据不存在,则不作操作
                if (tbProjectInfoWithBLOBs == null && tbProjectInfoWithBLOBs.size() > 0) {
                    logger.info("[房间订单] 房间订单支付回调 项目管理中无对应订单数据");
                } else {
                    TbProjectInfoWithBLOBs tbProjectInfoWithBLOBs1 = tbProjectInfoWithBLOBs.get(0);
                    String projectId = tbProjectInfoWithBLOBs1.getId();
                    //1.更新项目入驻状态为项目入驻
                    tbProjectInfoWithBLOBs1.setStatus(new Byte(ProjectStatusEnums.ENTERED.getCode()));
                    tbProjectInfoMapper.updateByPrimaryKeyWithBLOBs(tbProjectInfoWithBLOBs1);
                    logger.info("[房间订单] 更新项目管理,企业入驻状态为入驻成功状态,项目id:{}", projectId);

                    //2.获取租赁房租信息
                    List<TbProjectEnterDetails> projectEnterDetails = projectEnterDetailsMapper.getEnterDeatilsGroupByRTower(projectId);

                    if (projectEnterDetails != null && projectEnterDetails.size() > 0) {
                        StringBuffer buffer = new StringBuffer();
                        buffer.append("江苏省南京市秦淮区白下智慧园");
                        for (TbProjectEnterDetails projectEnterDetail : projectEnterDetails) {
                            String enterTower = projectEnterDetail.getEnterTower();
                            String roomName = projectEnterDetail.getRoomName();
                            buffer.append(enterTower).append(roomName).append(",");
                        }

                        //获取所属园区id
                        TbTowerInformation towerInfo = towerManageService.getTowerInfoById(projectEnterDetails.get(0).getTowerId());
                        String parkId = towerInfo.getParkId();

                        UpdateCompanyInfoParam updateCompanyInfoParam = new UpdateCompanyInfoParam();
                        updateCompanyInfoParam.setComId(tbProjectInfoWithBLOBs1.getCompanyId());
                        updateCompanyInfoParam.setAffiliatedPark(parkId);
                        updateCompanyInfoParam.setAddrPark(buffer.substring(0, buffer.length() - 1));
                        //缴费成功后,更新企业所属园区及企业园区地址
                        companyClient.updateCompanyInfoAfterPay(updateCompanyInfoParam);
                        logger.info("[房间订单] 更新企业实际经营地址,所属园区信息成功,企业id:{}",
                                tbProjectInfoWithBLOBs1.getCompanyId());
                    }
                }
            }
        }
    }

}
