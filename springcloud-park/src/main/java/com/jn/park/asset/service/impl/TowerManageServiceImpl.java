package com.jn.park.asset.service.impl;

import com.jn.park.asset.dao.TbTowerInformationMapper;
import com.jn.park.asset.dao.TowerInformationDao;
import com.jn.park.asset.entity.TbTowerInformation;
import com.jn.park.asset.model.TowerInformationModel;
import com.jn.park.asset.service.TowerManageService;
import com.jn.system.log.annotation.ServiceLog;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： zhuyz
 * @date： Created on 2019/4/19 12:18
 * @version： v1.0
 * @modified By:
 */
@Service
public class TowerManageServiceImpl implements TowerManageService {

    @Autowired
    private TowerInformationDao towerInformationDao;

    @Autowired
    private TbTowerInformationMapper tbTowerInformationMapper;

    @Override
    @ServiceLog(doAction = "通过园区id获取楼宇列表")
    public List<TowerInformationModel> towerList(String parkId) {
        List<TowerInformationModel> towerInformationModelList = towerInformationDao.towerList(parkId);
        if (towerInformationModelList != null) {
            for (TowerInformationModel towerInformationModel : towerInformationModelList) {
                //拼接图片url地址
                String imgUrl = towerInformationModel.getImgUrl();
                Object parse = JSONValue.parse(imgUrl);
                JSONArray array = (JSONArray) parse;
                JSONObject object = (JSONObject) array.get(0);
                String id = (String) object.get("id");
                String img = "/components/upload/download.htm?downloadId=" + id;
                towerInformationModel.setImgUrl(img);
            }
        }
        return towerInformationModelList;
    }

    @Override
    @ServiceLog(doAction = "通过楼宇id获取楼宇信息")
    public TbTowerInformation getTowerInfoById(String towerId) {
        TbTowerInformation tbTowerInformation = tbTowerInformationMapper.selectByPrimaryKey(towerId);
        return tbTowerInformation;
    }
}
