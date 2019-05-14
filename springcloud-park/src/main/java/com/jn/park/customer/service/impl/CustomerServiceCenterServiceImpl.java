package com.jn.park.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.park.customer.dao.TbClientServiceCenterMapper;
import com.jn.park.customer.entity.TbClientServiceCenter;
import com.jn.park.customer.entity.TbClientServiceCenterCriteria;
import com.jn.park.customer.model.ConsultationCustomerListParam;
import com.jn.park.customer.model.ConsultationCustomerListShow;
import com.jn.park.customer.service.CustomerServiceCenterService;
import com.jn.system.log.annotation.ServiceLog;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/5/14 9:42
 * @Version v1.0
 * @modified By:
 */
@Service
public class CustomerServiceCenterServiceImpl implements CustomerServiceCenterService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceCenterServiceImpl.class);

    @Autowired
    private TbClientServiceCenterMapper tbClientServiceCenterMapper;


    /**
     * 园区用户咨询客服
     * @param param         分页信息
     * @param loginAccount  用户账号
     * @return
     */
    @ServiceLog(doAction = "园区用户咨询客服")
    @Override
    public PaginationData consultationCustomerList(ConsultationCustomerListParam param, String loginAccount) {
        com.github.pagehelper.Page<Object> objects = null;
        if(StringUtils.isBlank(param.getNeedPage())){
            //默认查询第1页的15条数据
            int pageNum=1;
            int pageSize=15;
            objects = PageHelper.startPage(pageNum,pageSize, true);
            List<ConsultationCustomerListShow> customerCenterList = getCustomerCenterList(loginAccount);
            return new PaginationData(customerCenterList, objects == null ? 0 : objects.getTotal());
        }
        //需要分页标识
        String isPage="1";
        if(isPage.equals(param.getNeedPage())){
            objects = PageHelper.startPage(param.getPage(),
                    param.getRows() == 0 ? 15 : param.getRows(), true);
        }
        List<ConsultationCustomerListShow> customerCenterList = getCustomerCenterList(loginAccount);
        return new PaginationData(customerCenterList, objects == null ? 0 : objects.getTotal());
    }

    /**
     * 根据任务id获取问题详情
     * @param account 用户账号
     * @param taskId 任务id
     * @return
     */
    @ServiceLog(doAction = "根据任务id获取问题详情")
    @Override
    public Object customerQuesDetail(String account,String taskId){
        JSONObject formData = IBPSUtils.getFormData(account, taskId);
        return formData;
    }

    /**
     * 根据用户账号获取客服中心问题列表
     * @param loginAccount
     * @return
     */
    private List<ConsultationCustomerListShow> getCustomerCenterList(String loginAccount) {
        TbClientServiceCenterCriteria example=new TbClientServiceCenterCriteria();
        example.createCriteria().andCreatorAccountEqualTo(loginAccount)
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        example.setOrderByClause("created_time desc");
        List<TbClientServiceCenter> tbClientServiceCenterList = tbClientServiceCenterMapper.selectByExample(example);
        if(tbClientServiceCenterList.isEmpty()){
            return null;
        }else{
            List<ConsultationCustomerListShow> resultList=new ArrayList<>();
            for(TbClientServiceCenter tbClientServiceCenter:tbClientServiceCenterList){
                ConsultationCustomerListShow customerListShow=new ConsultationCustomerListShow();
                BeanUtils.copyProperties(tbClientServiceCenter, customerListShow);
                resultList.add(customerListShow);
            }
            return resultList;
        }
    }
}
