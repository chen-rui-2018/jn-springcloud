package com.jn.park.parkcode.service.impl;

import com.jn.park.activity.model.ParkCode;
import com.jn.park.parkcode.dao.TbParkCodeMapper;
import com.jn.park.parkcode.entity.TbParkCode;
import com.jn.park.parkcode.entity.TbParkCodeCriteria;
import com.jn.park.parkcode.service.ParkCodeService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 园区字典:
 *
 * @author： jiangyl
 * @date： Created on 2018/12/17 15:25
 * @version： v1.0
 * @modified By:
 */
@Service
public class ParkCodeServiceImpl implements ParkCodeService {
    private static Logger logger = LoggerFactory.getLogger(ParkCodeServiceImpl.class);
    @Autowired
    private TbParkCodeMapper tbParkCodeMapper;
    /**
     * 数据未删除状态
     */
    private static final String PARK_CODE_DELETE = "1";

    @Override
    @ServiceLog(doAction = "查询园区字典编码")
    public List<ParkCode> getParkCodeByType(String codeType){
        TbParkCodeCriteria tbParkCodeCriteria = new TbParkCodeCriteria();
        tbParkCodeCriteria.createCriteria().andGroupIdEqualTo(codeType).andRecordStatusEqualTo(new Byte(PARK_CODE_DELETE));
        List<TbParkCode> tbParkCodes = tbParkCodeMapper.selectByExample(tbParkCodeCriteria);
        List<ParkCode> parkCodes = new ArrayList<>(16);
        for (TbParkCode tbParkCode:tbParkCodes
             ) {
            ParkCode parkCode = new ParkCode();
            BeanUtils.copyProperties(tbParkCode,parkCode);
            parkCodes.add(parkCode);
        }
        return parkCodes;
    }

}