package com.jn.park.attractinvest.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.park.attractinvest.dao.*;
import com.jn.park.attractinvest.enmus.BusinessAdExceptionEnmus;
import com.jn.park.attractinvest.enmus.RecordStatusEnums;
import com.jn.park.attractinvest.entity.TbBusinessAdContent;
import com.jn.park.attractinvest.entity.TbBusinessAdDynamic;
import com.jn.park.attractinvest.entity.TbBusinessAdPolicy;
import com.jn.park.attractinvest.model.BusinessAdContent;
import com.jn.park.attractinvest.model.BusinessAdDynamic;
import com.jn.park.attractinvest.model.BusinessAdPage;
import com.jn.park.attractinvest.model.BusinessAdPolicy;
import com.jn.park.attractinvest.service.BusinessAdService;
import com.jn.system.log.annotation.ServiceLog;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 招商信息服务层
 *
 * @author： shaobao
 * @date： Created on 2019/4/24 16:32
 * @version： v1.0
 * @modified By:
 **/
@Service
public class BusinessAdServiceImpl implements BusinessAdService {

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(BusinessAdServiceImpl.class);

    @Autowired
    private TbBusinessAdContentMapper tbBusinessAdContentMapper;

    @Autowired
    private BusinessAdContentMapper businessAdContentMapper;

    @Autowired
    private TbBusinessAdDynamicMapper tbBusinessAdDynamicMapper;

    @Autowired
    private BusinessAdDynamicMapper businessAdDynamicMapper;

    @Autowired
    private TbBusinessAdPolicyMapper tbBusinessAdPolicyMapper;

    @Autowired
    private BusinessAdPolicyMapper businessAdPolicyMapper;


    /**
     * 获取招商信息
     *
     * @param page
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取招商信息")
    public PaginationData<List<BusinessAdContent>> getBusinessAdContent(BusinessAdPage page) {
        Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        List<BusinessAdContent> businessAdContents = businessAdContentMapper.getBusinessAdContent(page);
        if (businessAdContents != null) {
            //对图片路径进行处理
            for (BusinessAdContent businessAdContent : businessAdContents) {
                String cover = businessAdContent.getAdCover();

                //拼接附件下载链接
                Object parse = JSONValue.parse(cover);
                JSONArray array = (JSONArray) parse;
                JSONObject obj2 = (JSONObject) array.get(0);
                String spring = (String) obj2.get("id");
                String fileName = (String) obj2.get("fileName");
                String url = "/components/upload/preview.htm?downloadId=" + spring;
                businessAdContent.setCoverName(fileName);
                businessAdContent.setCoverUrl(url);
            }
        }
        return new PaginationData(businessAdContents, objects.getTotal());
    }

    /**
     * 获取招商动态信息
     *
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取招商动态信息")
    public List<BusinessAdDynamic> getBusinessAdDynamic() {
        List<BusinessAdDynamic> businessAdDynamics = businessAdDynamicMapper.getBusinessAdDynamic();

        if (businessAdDynamics != null) {
            //对图片路径进行处理
            for (BusinessAdDynamic businessAdDynamic : businessAdDynamics) {
                String cover = businessAdDynamic.getAdCover();

                //拼接附件下载链接
                Object parse = JSONValue.parse(cover);
                JSONArray array = (JSONArray) parse;
                JSONObject obj2 = (JSONObject) array.get(0);
                String spring = (String) obj2.get("id");
                String fileName = (String) obj2.get("fileName");
                String url = "/components/upload/preview.htm?downloadId=" + spring;
                businessAdDynamic.setCoverName(fileName);
                businessAdDynamic.setCoverUrl(url);
            }
        }
        return businessAdDynamics;
    }

    /**
     * 获取招商政策信息
     *
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取招商政策信息")
    public List<BusinessAdPolicy> getBusinessAdPolicy() {
        List<BusinessAdPolicy> businessAdPolicies = businessAdPolicyMapper.getBusinessAdPolicy();
        if (businessAdPolicies != null) {
            //对图片路径进行处理
            for (BusinessAdPolicy businessAdPolicy : businessAdPolicies) {
                String cover = businessAdPolicy.getAdCover();

                //拼接附件下载链接
                Object parse = JSONValue.parse(cover);
                JSONArray array = (JSONArray) parse;
                JSONObject obj2 = (JSONObject) array.get(0);
                String spring = (String) obj2.get("id");
                String fileName = (String) obj2.get("fileName");
                String url = "/components/upload/preview.htm?downloadId=" + spring;
                businessAdPolicy.setCoverName(fileName);
                businessAdPolicy.setCoverUrl(url);
            }
        }
        return businessAdPolicies;
    }

    /**
     * 获取招商信息详情
     *
     * @param id 招商信息id
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取招商信息详情")
    public BusinessAdContent getBusinessAdContentInfo(String id) {
        TbBusinessAdContent tbBusinessAdContent = tbBusinessAdContentMapper.selectByPrimaryKey(id);
        if (tbBusinessAdContent == null ||
                StringUtils.equals(RecordStatusEnums.STOP_DISPLAY.getCode(), tbBusinessAdContent.getRecordStatus().toString())) {
            logger.warn("[招商信息] 招商信息查询失败,查询信息不存在或已下架,id:{}", id);
            throw new JnSpringCloudException(BusinessAdExceptionEnmus.BUSSINESS_AD_NOT_EXIST);
        }
        BusinessAdContent businessAdContent = new BusinessAdContent();
        BeanUtils.copyProperties(tbBusinessAdContent, businessAdContent);
        return businessAdContent;
    }

    /**
     * 根据招商动态id获取招商动态信息详情
     *
     * @param id 招商动态信息id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据招商动态id获取招商动态信息详情")
    public BusinessAdDynamic getBusinessAdDynamicInfo(String id) {
        TbBusinessAdDynamic tbBusinessAdDynamic = tbBusinessAdDynamicMapper.selectByPrimaryKey(id);
        if (tbBusinessAdDynamic == null ||
                StringUtils.equals(RecordStatusEnums.STOP_DISPLAY.getCode(), tbBusinessAdDynamic.getRecordStatus().toString())) {
            logger.warn("[招商动态] 招商动态查询失败,查询信息不存在或已下架,id:{}", id);
            throw new JnSpringCloudException(BusinessAdExceptionEnmus.BUSSINESS_AD_NOT_EXIST);
        }
        BusinessAdDynamic businessAdDynamic = new BusinessAdDynamic();
        BeanUtils.copyProperties(tbBusinessAdDynamic, businessAdDynamic);
        return businessAdDynamic;
    }

    /**
     * 根据招商政策id获取招商政策信息详情
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据招商政策id获取招商政策信息详情")
    public BusinessAdPolicy getBusinessAdPolicyInfo(String id) {
        TbBusinessAdPolicy tbBusinessAdPolicy = tbBusinessAdPolicyMapper.selectByPrimaryKey(id);
        if (tbBusinessAdPolicy == null ||
                StringUtils.equals(RecordStatusEnums.STOP_DISPLAY.getCode(), tbBusinessAdPolicy.getRecordStatus().toString())) {
            logger.warn("[招商政策] 招商政策查询失败,查询信息不存在或已下架,id:{}", id);
            throw new JnSpringCloudException(BusinessAdExceptionEnmus.BUSSINESS_AD_NOT_EXIST);
        }
        BusinessAdPolicy businessAdPolicy = new BusinessAdPolicy();
        BeanUtils.copyProperties(tbBusinessAdPolicy, businessAdPolicy);

        //增加浏览次数
        tbBusinessAdPolicy.setViewCount(tbBusinessAdPolicy.getViewCount() + 1);
        tbBusinessAdPolicyMapper.updateByPrimaryKeySelective(tbBusinessAdPolicy);
        return businessAdPolicy;
    }

    /**
     * 定时更新招商信息,招商动态,招商政策状态
     */
    @Override
    @ServiceLog(doAction = "定时更新招商信息,招商动态,招商政策状态")
    @Transactional(rollbackFor = Exception.class)
    public void updateBusinessAdStatus() {
        businessAdContentMapper.updateBusinessAdStatus();
        logger.info("[招商信息] 招商信息状态更新成功");
        businessAdDynamicMapper.updateBusinessAdStatus();
        logger.info("[招商动态] 招商动态状态更新成功");
        businessAdPolicyMapper.updateBusinessAdStatus();
        logger.info("[招商政策] 招商政策状态更新成功");
    }
}
