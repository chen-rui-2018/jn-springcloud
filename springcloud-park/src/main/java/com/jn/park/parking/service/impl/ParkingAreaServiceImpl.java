package com.jn.park.parking.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.park.parking.dao.ParkingAreaMapper;
import com.jn.park.parking.dao.TbParkingAreaMapper;
import com.jn.park.parking.dao.TbParkingServiceTypeMapper;
import com.jn.park.parking.entity.TbParkingArea;
import com.jn.park.parking.entity.TbParkingAreaCriteria;
import com.jn.park.parking.entity.TbParkingServiceType;
import com.jn.park.parking.entity.TbParkingServiceTypeCriteria;
import com.jn.park.parking.enums.ParkingEnums;
import com.jn.park.parking.model.ParkingAreaModel;
import com.jn.park.parking.model.ParkingAreaParam;
import com.jn.park.parking.service.ParkingAreaService;
import com.jn.park.parking.vo.ParkingAreaDetailVo;
import com.jn.park.parking.vo.ParkingAreaVo;
import com.jn.park.parking.vo.ParkingServiceTypeVo;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:42
 * @version： v1.0
 * @modified By:
 */
@Service
public class ParkingAreaServiceImpl implements ParkingAreaService {
    private static Logger logger = LoggerFactory.getLogger(ParkingAreaServiceImpl.class);

    @Autowired
    private TbParkingAreaMapper tbParkingAreaMapper;
    @Autowired
    private ParkingAreaMapper parkingAreaMapper;
    @Autowired
    private TbParkingServiceTypeMapper tbParkingServiceTypeMapper;

    @Override
    @ServiceLog(doAction = "查询停车场列表")
    public PaginationData<List<ParkingAreaVo>> getParkingAreaList(ParkingAreaParam parkingAreaParam) {
        Page<Object> objects = null;
        if (StringUtils.isNotEmpty(parkingAreaParam.getNeedPage()) && StringUtils.equals(ParkingEnums.NEED_PAGE.getCode(), parkingAreaParam.getNeedPage())) {
            objects = PageHelper.startPage(parkingAreaParam.getPage(), parkingAreaParam.getRows() == 0 ? 15 : parkingAreaParam.getRows());
        }
        TbParkingAreaCriteria tbParkingAreaCriteria = new TbParkingAreaCriteria();
        TbParkingAreaCriteria.Criteria criteria = tbParkingAreaCriteria.createCriteria().andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode())).andAreaStatusEqualTo(ParkingEnums.PARKING_AREA_EFFECTIVE.getCode());
        if (StringUtils.isNotEmpty(parkingAreaParam.getAreaAddress())) {
            criteria.andAreaAddressLike("%" + parkingAreaParam.getAreaAddress() + "%");
        }
        if (StringUtils.isNotEmpty(parkingAreaParam.getAreaName())) {
            criteria.andAreaNameLike("%" + parkingAreaParam.getAreaName() + "%");
        }
        List<TbParkingArea> tbParkingAreas = tbParkingAreaMapper.selectByExample(tbParkingAreaCriteria);
        List<ParkingAreaVo> areaVos = new ArrayList<>(16);
        for (TbParkingArea area : tbParkingAreas) {
            ParkingAreaVo areaVo = new ParkingAreaVo();
            BeanUtils.copyProperties(area, areaVo);
            areaVos.add(areaVo);
        }
        PaginationData<List<ParkingAreaVo>> data = new PaginationData(areaVos, null == objects ? tbParkingAreas.size() : objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "根据ID获取停车场详情")
    @Override
    public ParkingAreaDetailVo getParkingAreaDetailById(String areaId) {
        return parkingAreaMapper.getParkingAreaDetailById(areaId);
    }

    @ServiceLog(doAction = "查询停车场服务数据列表")
    @Override
    public List<ParkingServiceTypeVo> getParkingServiceTypeList() {
        TbParkingServiceTypeCriteria tbParkingServiceTypeCriteria = new TbParkingServiceTypeCriteria();
        tbParkingServiceTypeCriteria.createCriteria().andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        List<TbParkingServiceType> tbParkingServiceTypes = tbParkingServiceTypeMapper.selectByExample(tbParkingServiceTypeCriteria);

        List<ParkingServiceTypeVo> typeVos = new ArrayList<>(16);
        for (TbParkingServiceType serviceType : tbParkingServiceTypes
        ) {
            ParkingServiceTypeVo typeVo = new ParkingServiceTypeVo();
            BeanUtils.copyProperties(serviceType, typeVo);
            typeVos.add(typeVo);
        }
        return typeVos;
    }

    @ServiceLog(doAction = "新增/修改停车场信息")
    @Override
    public String saveOrUpdateCarPark(ParkingAreaModel parkingAreaModel,String userAccount){
        TbParkingArea tbParkingArea = new TbParkingArea();
        BeanUtils.copyProperties(parkingAreaModel,tbParkingArea);
        int i = 0;
        if(StringUtils.isEmpty(parkingAreaModel.getAreaId())){
            logger.info("新增停车场数据");
            tbParkingArea.setAreaId(UUID.randomUUID().toString().replace("-",""));
            tbParkingArea.setCreatedTime(new Date());
            tbParkingArea.setCreatorAccount(userAccount);
            tbParkingArea.setRecordStatus(new Byte(ParkingEnums.EFFECTIVE.getCode()));
            tbParkingArea.setAreaStatus(ParkingEnums.PARKING_AREA_EFFECTIVE.getCode());
            i = tbParkingAreaMapper.insert(tbParkingArea);
        }else{
            logger.info("修改停车场数据");
            tbParkingArea.setModifiedTime(new Date());
            tbParkingArea.setModifierAccount(userAccount);
            i = tbParkingAreaMapper.updateByPrimaryKeySelective(tbParkingArea);
        }
        return i+"";
    }

    @ServiceLog(doAction = "删除停车场")
    @Override
    public String deleteCarPark(String areaId,String userAccount){
        TbParkingArea tbParkingArea = new TbParkingArea();
        tbParkingArea.setAreaId(areaId);
        tbParkingArea.setModifierAccount(userAccount);
        tbParkingArea.setModifiedTime(new Date());
        tbParkingArea.setAreaStatus(ParkingEnums.PARKING_AREA_DELETED.getCode());
        int i = tbParkingAreaMapper.updateByPrimaryKeySelective(tbParkingArea);
        return i+"";
    }

}
