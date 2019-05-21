package com.jn.park.park.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.park.dao.TbParkMapper;
import com.jn.park.park.entity.TbPark;
import com.jn.park.park.entity.TbParkCriteria;
import com.jn.park.park.model.ParkGeneral;
import com.jn.park.park.model.ParkName;
import com.jn.park.park.service.ParkService;
import com.jn.park.park.vo.ParkDetailsVo;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkServiceImpl implements ParkService {


    @Autowired
    private TbParkMapper tbParkMapper;


    /**
     * 园区管理-根据ID获取详情
     */
    @Override
    @ServiceLog(doAction = "园区管理-根据ID获取详情")
    public ParkDetailsVo getParkDetails(String id) {

        TbPark tbPark=tbParkMapper.selectByPrimaryKey(id);

        if(!StringUtils.equals(tbPark.getRecordStatus(),"1")){
            throw new JnSpringCloudException(new Result("-1","数据不存在"));
        }
        ParkDetailsVo parkDetailsVo=new ParkDetailsVo();
        BeanUtils.copyProperties(tbPark,parkDetailsVo);

        String enter = parkDetailsVo.getIsEnter();
        String state = parkDetailsVo.getParkState();

        //转换显示 enter内容
        switch (enter){
            case "0":
                enter="未入住";
                break;
            case "1":
                enter="已入住";
                break;
            case "2":
                enter="正在走流程";
                break;
        }
        //转换显示 state内容
        switch (state){
            case "0":
                state="未发布";
                break;
            case "1":
                state="已发布";
                break;
            case "2":
                state="失效";
                break;
        }
        parkDetailsVo.setIsEnter(enter);
        parkDetailsVo.setParkState(state);
        return parkDetailsVo;
    }


    /**
     * 园区管理-获取园区名
     */
    @Override
    @ServiceLog(doAction = " 园区管理-获取园区名")
    public List<ParkName> getParkName() {
        TbParkCriteria tbParkCriteria = new TbParkCriteria();
        List<TbPark> list = tbParkMapper.selectByExample(tbParkCriteria);
        List<ParkName> parkList = new ArrayList<>();
        for (TbPark vo:list
             ) {
            ParkName parkName = new ParkName();
            BeanUtils.copyProperties(tbParkCriteria,parkName);
            parkName.setId(vo.getId());
            parkName.setParkName(vo.getParkName());
            parkName.setMainPicture(vo.getMainPicture());
            parkList.add(parkName);
        }
        return parkList;
    }


    /**
     * 园区管理-获取园区概况
     */
    @Override
    @ServiceLog(doAction = " 园区管理-获取园区概况")
    public ParkGeneral getParkGeneral() {
        TbParkCriteria tbParkCriteria = new TbParkCriteria();
        TbParkCriteria.Criteria criteria = tbParkCriteria.createCriteria();
        criteria.andParentIdEqualTo("-1");
        criteria.andRecordStatusEqualTo("1");
        List<TbPark> list = tbParkMapper.selectByExampleWithBLOBs(tbParkCriteria);
        ParkGeneral parkGeneral = new ParkGeneral();
        for (TbPark general:list) {
            parkGeneral.setParkIntroduce(general.getParkIntroduce());
        }
        return parkGeneral;
    }
}

