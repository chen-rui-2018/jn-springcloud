package com.jn.park.asset.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.asset.dao.*;
import com.jn.park.asset.entity.*;
import com.jn.park.asset.enums.OrdersTypeEnums;
import com.jn.park.asset.enums.RoomLeaseStatusEnums;
import com.jn.park.asset.model.RoomOrdersModle;
import com.jn.park.asset.model.RoomPayOrdersItemModel;
import com.jn.park.asset.model.RoomPayOrdersModel;
import com.jn.park.asset.service.RoomOrdersService;
import com.jn.system.log.annotation.ServiceLog;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
* 房间租借订单impl
* @author： zhuyz
* @date： Created on 2019/5/7 19:32
* @version： v1.0
* @modified By:
*/
@Service
public class RoomOrdersServiceImpl implements RoomOrdersService {
    private static Logger logger = LoggerFactory.getLogger(RoomOrdersServiceImpl.class);

    @Autowired
    private RoomOrdersDao roomOrdersDao;
    @Autowired
    private RoomInformationDao roomInformationDao;
    @Autowired
    private TbRoomOrdersMapper tbRoomOrdersMapper;
    @Autowired
    private TbRoomOrdersItemMapper tbRoomOrdersItemMapper;
    @Autowired
    private TbRoomInformationMapper tbRoomInformationMapper;

    /**
     * 返回支付订单
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "返回支付订单")
    public RoomPayOrdersModel getPayOrders(String id) {
        //查询订单表
        TbRoomOrders tbRoomOrders = tbRoomOrdersMapper.selectByPrimaryKey(id);
        RoomPayOrdersModel roomPayOrdersModel = new RoomPayOrdersModel();
        BeanUtils.copyProperties(tbRoomOrders,roomPayOrdersModel);
        //通过订单id查询订单字表
        TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria= new TbRoomOrdersItemCriteria();
        tbRoomOrdersItemCriteria.createCriteria().andOrderIdEqualTo(id);
        List<TbRoomOrdersItem> tbRoomOrdersItemList = tbRoomOrdersItemMapper.selectByExample(tbRoomOrdersItemCriteria);
        //创建子订单List集合
        List<RoomPayOrdersItemModel> roomPayOrdersItemModelList = new ArrayList<>();

        if (tbRoomOrdersItemList != null){
            for (TbRoomOrdersItem tbRoomOrdersItem : tbRoomOrdersItemList) {
                RoomPayOrdersItemModel roomPay = new RoomPayOrdersItemModel();
                BeanUtils.copyProperties(tbRoomOrdersItem,roomPay);
                roomPayOrdersItemModelList.add(roomPay);
            }
            roomPayOrdersModel.setRoomPayOrdersItemModels(roomPayOrdersItemModelList);
        }
        try {
            if (roomPayOrdersModel != null){
                //账单类型
                roomPayOrdersModel.setOrdersType(OrdersTypeEnums.ROOM.getMessage());
                //计算最迟缴费时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String createTime = sdf.format(roomPayOrdersModel.getCreateTime());
                roomPayOrdersModel.setTime(createTime);
                Calendar cal = Calendar.getInstance();
                cal.setTime(sdf.parse(createTime));
                cal.add(Calendar.HOUR_OF_DAY,1);
                String lastTime = sdf.format(cal.getTime());
                roomPayOrdersModel.setLastPayTime(lastTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return roomPayOrdersModel;
    }

    /**
     * 分页返回房间租借历史列表
     * @param account
     * @param page
     * @return
     */
    @Override
    @ServiceLog(doAction = "分页返回房间租借历史列表")
    public PaginationData<List<RoomPayOrdersItemModel>> getRoomOrdersList(String account,Page page) {
        //开始分页
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        //创建订单集合
        List<RoomPayOrdersItemModel> roomPayOrdersItemModelList = new ArrayList<>();
        //设置查询条件
        TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria = new TbRoomOrdersItemCriteria();
        //设置用户
        tbRoomOrdersItemCriteria.createCriteria().andCreatorAccountEqualTo(account);
        //按照创建时间倒序排序
        tbRoomOrdersItemCriteria.setOrderByClause("create_time DESC");
        List<TbRoomOrdersItem> tbRoomOrdersItems = tbRoomOrdersItemMapper.selectByExample(tbRoomOrdersItemCriteria);
        for (TbRoomOrdersItem tbRoomOrdersItem : tbRoomOrdersItems) {
            RoomPayOrdersItemModel roomPayOrdersItemModel = new RoomPayOrdersItemModel();
            BeanUtils.copyProperties(tbRoomOrdersItem,roomPayOrdersItemModel);
            roomPayOrdersItemModelList.add(roomPayOrdersItemModel);
        }
        PaginationData<List<RoomPayOrdersItemModel>> data = new PaginationData(tbRoomOrdersItems,objects.getTotal());
        return data;
    }

    /**
     * 获取房间租借详情信息
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction ="获取房间租借详情信息")
    public RoomPayOrdersItemModel getRoomOrders(String id) {
        TbRoomOrdersItem tbRoomOrdersItem = tbRoomOrdersItemMapper.selectByPrimaryKey(id);
        RoomPayOrdersItemModel roomPayOrdersItemModel = new RoomPayOrdersItemModel();
        BeanUtils.copyProperties(tbRoomOrdersItem,roomPayOrdersItemModel);
        return roomPayOrdersItemModel;
    }

    /**
     * 房间退租申请
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "房间退租申请")
    public RoomPayOrdersItemModel quitApply(String id) {
        //更新订单房间状态
        TbRoomOrdersItem tbRoomOrdersItem = tbRoomOrdersItemMapper.selectByPrimaryKey(id);
        tbRoomOrdersItem.setRecordStatus(Byte.parseByte(RoomLeaseStatusEnums.QUIT.getValue()));
        TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria = new TbRoomOrdersItemCriteria();
        tbRoomOrdersItemCriteria.createCriteria().andIdEqualTo(id);
        logger.info("更新订单房间状态,{}",tbRoomOrdersItem);
        tbRoomOrdersItemMapper.updateByExampleSelective(tbRoomOrdersItem,tbRoomOrdersItemCriteria);
        //更新房间信息房间状态
        TbRoomInformation tbRoomInformation = tbRoomInformationMapper.selectByPrimaryKey(tbRoomOrdersItem.getRoomId());
        tbRoomInformation.setState(Byte.parseByte(RoomLeaseStatusEnums.QUIT.getValue()));
        TbRoomInformationCriteria tbRoomInformationCriteria = new TbRoomInformationCriteria();
        tbRoomInformationCriteria.createCriteria().andIdEqualTo(tbRoomOrdersItem.getRoomId());
        logger.info("更新房间信息房间状态,{}",tbRoomInformation);
        tbRoomInformationMapper.updateByExampleSelective(tbRoomInformation,tbRoomInformationCriteria);
        //返回更新后的房间订单信息
        RoomPayOrdersItemModel roomPayOrdersItemModel = new RoomPayOrdersItemModel();
        BeanUtils.copyProperties(tbRoomOrdersItem,roomPayOrdersItemModel);
        return roomPayOrdersItemModel;
    }
}
