package com.jn.enterprise.pd.declaration.service;

import com.jn.common.model.Result;
import com.jn.enterprise.pd.declaration.model.DeclarationOnlineModel;
import com.jn.enterprise.pd.declaration.model.DeclarationOnlineReservationManageModel;
import com.jn.system.model.User;

/**
 * 预约申报
 *
 * @author： wzy
 * @date： Created on 2019/4/17 19:25
 * @version： v1.0
 * @modified By:
 */
public interface DeclarationOnlinkService {

    Result onlineBooking(DeclarationOnlineReservationManageModel declarationOnline, User user);

    Result<DeclarationOnlineModel> queryOnlineInfo(String appointmentItemId,User user);
}
