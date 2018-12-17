package com.jn.park.parkCode.service.impl;

import com.jn.park.parkCode.dao.TbParkCodeMapper;
import com.jn.park.parkCode.entity.TbParkCode;
import com.jn.park.parkCode.entity.TbParkCodeCriteria;
import com.jn.park.parkCode.service.ParkCodeService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 园区字典
 *
 * @author： jiangyl
 * @date： Created on 2018/12/17 10:18
 * @version： v1.0
 * @modified By:
 */
@Service
public class ParkCodeServiceImpl implements ParkCodeService {
    private static Logger logger = LoggerFactory.getLogger(ParkCodeServiceImpl.class);
    @Autowired
    private TbParkCodeMapper tbParkCodeMapper;

    @Override
    @ServiceLog(doAction = "查询园区字典编码")
    public List<TbParkCode> getParkCodeByType(String codeType){
        TbParkCodeCriteria tbParkCodeCriteria = new TbParkCodeCriteria();
        tbParkCodeCriteria.createCriteria().andGroupIdEqualTo(codeType).andStateEqualTo("1");
        return tbParkCodeMapper.selectByExample(tbParkCodeCriteria);
    }

}
