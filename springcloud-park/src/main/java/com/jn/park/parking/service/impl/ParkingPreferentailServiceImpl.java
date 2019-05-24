package com.jn.park.parking.service.impl;

import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.parking.dao.TbParkingPreferentialAreaMapper;
import com.jn.park.parking.dao.TbParkingPreferentialMapper;
import com.jn.park.parking.entity.TbParkingPreferential;
import com.jn.park.parking.entity.TbParkingPreferentialArea;
import com.jn.park.parking.entity.TbParkingPreferentialAreaCriteria;
import com.jn.park.parking.entity.TbParkingPreferentialCriteria;
import com.jn.park.parking.enums.ParkingEnums;
import com.jn.park.parking.service.ParkingPreferentailService;
import com.jn.park.parking.vo.ParkingPreferentialVo;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/22 17:43
 * @version： v1.0
 * @modified By:
 */
@Service
public class ParkingPreferentailServiceImpl implements ParkingPreferentailService {

    @Autowired
    private TbParkingPreferentialMapper tbParkingPreferentialMapper;
    @Autowired
    private TbParkingPreferentialAreaMapper tbParkingPreferentialAreaMapper;
    @Autowired
    private SystemClient systemClient;

    @ServiceLog(doAction = "前端查询优惠政策列表")
    @Override
    public List<ParkingPreferentialVo> getParkingPreferentialList(String account){
        String userType = getUserRole(account);
        TbParkingPreferentialCriteria parkingPreferentialCriteria = new TbParkingPreferentialCriteria();
        parkingPreferentialCriteria.createCriteria().andPolicyUserTypeEqualTo(userType).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        List<TbParkingPreferential> tbParkingPreferentials = tbParkingPreferentialMapper.selectByExample(parkingPreferentialCriteria);
        List<ParkingPreferentialVo> parkingPreferentialVos = new ArrayList<>(16);
        for (TbParkingPreferential preFerential:
                tbParkingPreferentials) {
            ParkingPreferentialVo vo = new ParkingPreferentialVo();
            BeanUtils.copyProperties(preFerential,vo);
            parkingPreferentialVos.add(vo);
        }
        return parkingPreferentialVos;
    }

    @ServiceLog(doAction = "查询某个停车场优惠政策")
    @Override
    public List<ParkingPreferentialVo> getParkingPreferentialListForArea(String areaId,String account){
        String userType = getUserRole(account);
        TbParkingPreferentialAreaCriteria areaCriteria = new TbParkingPreferentialAreaCriteria();
        areaCriteria.createCriteria().andAreaIdEqualTo(areaId).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        List<TbParkingPreferentialArea> tbParkingPreferentialAreas = tbParkingPreferentialAreaMapper.selectByExample(areaCriteria);
        List<String> sList = new ArrayList<>(16);
        for (TbParkingPreferentialArea area:tbParkingPreferentialAreas
             ) {
            sList.add(area.getPolicyId());
        }
        List<ParkingPreferentialVo> parkingPreferentialVos = new ArrayList<>(16);
        if(null == tbParkingPreferentialAreas || tbParkingPreferentialAreas.size() == 0){
            return parkingPreferentialVos;
        }
        TbParkingPreferentialCriteria parkingPreferentialCriteria = new TbParkingPreferentialCriteria();
        parkingPreferentialCriteria.createCriteria().andPolicyIdIn(sList).andPolicyUserTypeEqualTo(userType).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        List<TbParkingPreferential> tbParkingPreferentials = tbParkingPreferentialMapper.selectByExample(parkingPreferentialCriteria);

        for (TbParkingPreferential preFerential:
                tbParkingPreferentials) {
            ParkingPreferentialVo vo = new ParkingPreferentialVo();
            BeanUtils.copyProperties(preFerential,vo);
            parkingPreferentialVos.add(vo);
        }
        return parkingPreferentialVos;
    }

    public String getUserRole(String account){
        List<String> accountList = new ArrayList<>(8);
        accountList.add(account);
        Result<List<User>> userInfo = systemClient.getUserInfoByAccount(accountList);
        String userType = ParkingEnums.PARKING_USER_TYPE_USER.getCode();
        if(userInfo!=null && userInfo.getData() !=null && userInfo.getData().size()>0 ){
            List<User> data = userInfo.getData();
            for (User user: data ) {
                List<SysRole> sysRole = user.getSysRole();
                for (SysRole role:sysRole ) {
                    if(StringUtils.equals(ParkingEnums.PARKING_USER_TYPE_ORG_ROLE.getCode(),role.getRoleName())|| StringUtils.equals(ParkingEnums.PARKING_USER_TYPE_COMPANY_ROLE.getCode(),role.getRoleName())){
                        userType = ParkingEnums.PARKING_USER_TYPE_COMPANY.getCode();
                        break;
                    }
                }
            }
        }
        return userType;
    }

}
