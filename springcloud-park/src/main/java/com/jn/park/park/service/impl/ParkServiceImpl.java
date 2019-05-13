package com.jn.park.park.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.park.dao.ParkMapper;
import com.jn.park.park.dao.TbParkMapper;
import com.jn.park.park.entity.TbPark;
import com.jn.park.park.model.ParkGeneral;
import com.jn.park.park.model.ParkName;
import com.jn.park.park.service.ParkService;
import com.jn.park.park.vo.ParkDetailsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkServiceImpl implements ParkService {

    @Autowired
    private ParkMapper mapper;
    @Autowired
    private TbParkMapper tbParkMapper;

    /**
     * 园区管理-根据ID获取详情
     */
    @Override
    public ParkDetailsVo getParkdetails(String id) {

        TbPark tbPark=tbParkMapper.selectByPrimaryKey(id);
        if(null==tbPark || !(new Byte("1").equals(tbPark.getRecordStatus()))){
            throw new JnSpringCloudException(new Result("-1","数据不存在"));
        }
        ParkDetailsVo parkDetailsVo=new ParkDetailsVo();
        BeanUtils.copyProperties(tbPark,parkDetailsVo);

        String enter = parkDetailsVo.getIsenter();
        String state = parkDetailsVo.getParkstate();

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
        return parkDetailsVo;
    }

    @Override
    public List<ParkName> getParkName() {
        return mapper.getParkName();
    }


    @Override
    public ParkGeneral getParkGeneral() {
        return mapper.getParkGeneral();
    }
}

