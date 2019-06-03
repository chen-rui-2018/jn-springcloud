package com.jn.reconciliation.service.impl;

import com.jn.reconciliation.enums.MistakeHandleStatusEnum;
import com.jn.reconciliation.service.PayReconciliationMistakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistake;
import org.xxpay.dal.dao.entity.reconciliation.TbPayReconciliationMistakeCriteria;
import org.xxpay.dal.dao.mapper.generator.reconciliation.TbPayReconciliationMistakeMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @ClassName：对账差错接口实现类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/20 15:54
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class PayReconciliationMistakeServiceImpl implements PayReconciliationMistakeService {

    @Autowired
    private TbPayReconciliationMistakeMapper tbPayReconciliationMistakeMapper;

    /**
     * 批量保存差错记录
     *
     * @param mistakeList
     */
    @Override
    public void saveListDate(List<TbPayReconciliationMistake> mistakeList) {
        Date createTime = new Date();
        for (TbPayReconciliationMistake mistake : mistakeList) {
            mistake.setCreateTime(createTime);
            tbPayReconciliationMistakeMapper.insert(mistake);
        }
    }

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    @Override
    public TbPayReconciliationMistake getDataById(Integer id) {
        return tbPayReconciliationMistakeMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新
     * @param reconciliationMistake
     */
    @Override
    public void updateData(TbPayReconciliationMistake reconciliationMistake) {
        tbPayReconciliationMistakeMapper.updateByPrimaryKeySelective(reconciliationMistake);
    }

    /**
     * 根据创建时间获取未处理差错记录数
     * @param date（yyyy-mm-dd）
     */
    @Override
    public Long getMistakeNumByDate(String date) {

        Long num = null;
        try {
            String startDateStr = date + " 00:00:00";
            String endDateStr = date + " 23:59:59";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            TbPayReconciliationMistakeCriteria example = new TbPayReconciliationMistakeCriteria();
            //限制创建时间为当天
            example.createCriteria().andCreateTimeBetween(sdf.parse(startDateStr),sdf.parse(endDateStr));
            //差错未处理的状态
            example.createCriteria().andHandleStatusEqualTo(MistakeHandleStatusEnum.NOHANDLE.getCode());
            num = tbPayReconciliationMistakeMapper.countByExample(example);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return num;
    }


}
