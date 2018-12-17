package com.jn.park.parkcode.service.impl;

import com.jn.park.parkcode.entity.TbParkCode;
import com.jn.park.parkcode.service.ParkCodeService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 园区字典:
 *
 * @author： jiangyl
 * @date： Created on 2018/12/17 15:25
 * @version： v1.0
 * @modified By:
 */
public class ParkCodeServiceImpl implements ParkCodeService {
    private static Logger logger = LoggerFactory.getLogger(ParkCodeServiceImpl.class);
    @Autowired
    private com.jn.park.parkCode.dao.TbParkCodeMapper tbParkCodeMapper;

    @Override
    @ServiceLog(doAction = "查询园区字典编码")
    public List<TbParkCode> getParkCodeByType(String codeType){
        com.jn.park.parkCode.entity.TbParkCodeCriteria tbParkCodeCriteria = new com.jn.park.parkCode.entity.TbParkCodeCriteria();
        tbParkCodeCriteria.createCriteria().andGroupIdEqualTo(codeType).andStateEqualTo("1");
        return tbParkCodeMapper.selectByExample(tbParkCodeCriteria);
    }

}