package com.jn.enterprise.pd.declaration.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationOnlineReservationManageMapper;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationOnlineReservationManage;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationOnlineReservationManageCriteria;
import com.jn.enterprise.pd.declaration.enums.ExceptionStatusEnums;
import com.jn.enterprise.pd.declaration.model.DeclarationOnlineModel;
import com.jn.enterprise.pd.declaration.model.DeclarationOnlineReservationManageModel;
import com.jn.enterprise.pd.declaration.service.DeclarationOnlinkService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 预约申报
 *
 * @author： wzy
 * @date： Created on 2019/4/17 19:26
 * @version： v1.0
 * @modified By:
 */
@Service
public class DeclarationOnlinkServiceImpl implements DeclarationOnlinkService {

    private static Logger logger = LoggerFactory.getLogger(DeclarationOnlinkServiceImpl.class);

    @Autowired
    private TbPdDeclarationOnlineReservationManageMapper tbPdDeclarationOnlineReservationManageMapper;

    /**
     * 申报中心预约申报
     *
     * @param
     * @return
     */
    @Override
    @ServiceLog(doAction = "申报中心预约申报")
    public Result onlineBooking(DeclarationOnlineReservationManageModel declarationOnline, User user) {
        TbPdDeclarationOnlineReservationManageCriteria criterion = new TbPdDeclarationOnlineReservationManageCriteria();
        criterion.createCriteria().andAppointmentItemIdEqualTo(declarationOnline.getAppointmentItemId()).andCreatorAccountEqualTo(user.getAccount());
        List<TbPdDeclarationOnlineReservationManage> list = tbPdDeclarationOnlineReservationManageMapper.selectByExample(criterion);
        if(list.size() > 0){
            throw new JnSpringCloudException(ExceptionStatusEnums.DECLAREITEM_IS_SHEN);
        }
        TbPdDeclarationOnlineReservationManage tbOnline = new TbPdDeclarationOnlineReservationManage();
        BeanUtils.copyProperties(declarationOnline, tbOnline);
        tbOnline.setId(UUID.randomUUID().toString());
        tbOnline.setTimeAppointment(new Date());
        tbOnline.setCreatorAccount(user.getAccount());
        tbOnline.setCreatedTime(new Date());
        tbPdDeclarationOnlineReservationManageMapper.insertSelective(tbOnline);
        logger.info("[申报中心预约申报] 申请成功，预约id:{}", tbOnline.getId());
        return new Result("预约申报成功！");
    }

    @Override
    @ServiceLog(doAction = "通过公告ID和登录人查询预约信息")
    public Result<DeclarationOnlineModel> queryOnlineInfo(String appointmentItemId, User user) {
        DeclarationOnlineModel declarationOnlineModel = new DeclarationOnlineModel();
        Result result = new Result();
        TbPdDeclarationOnlineReservationManageCriteria criterion = new TbPdDeclarationOnlineReservationManageCriteria();
        criterion.createCriteria().andAppointmentItemIdEqualTo(appointmentItemId).andCreatorAccountEqualTo(user.getAccount());
        List<TbPdDeclarationOnlineReservationManage> list = tbPdDeclarationOnlineReservationManageMapper.selectByExample(criterion);
        if(list.size() == 0){
            result.setCode(ExceptionStatusEnums.DECLAREITEM_IS_NULL.getCode());
            result.setData(ExceptionStatusEnums.DECLAREITEM_IS_NULL.getMessage());
            return result;
        }
        if(list.size() > 1){
            result.setCode(ExceptionStatusEnums.DECLAREITEM_IS_SUM_NULL.getCode());
            result.setData(ExceptionStatusEnums.DECLAREITEM_IS_SUM_NULL.getMessage());
            return result;
        }
        BeanUtils.copyProperties(list.get(0),declarationOnlineModel);
        return new Result<>(declarationOnlineModel);
    }
}
