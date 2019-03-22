package com.jn.oa.item.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.item.dao.TbOaWorkPlanHistoryMapper;
import com.jn.oa.item.dao.TbOaWorkPlanMapper;
import com.jn.oa.item.dao.TbOaWorkPlanRecordMapper;
import com.jn.oa.item.dao.WorkPlanRecordMapper;
import com.jn.oa.item.enmus.WorkPlanOperateEnmus;
import com.jn.oa.item.entity.TbOaWorkPlan;
import com.jn.oa.item.entity.TbOaWorkPlanRecord;
import com.jn.oa.item.entity.TbOaWorkPlanRecordCriteria;
import com.jn.oa.item.model.WorkPlanRecord;
import com.jn.oa.item.service.WorkPlanRecordService;
import com.jn.oa.item.service.WorkPlanService;
import com.jn.oa.item.util.BeanDiffUtil;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 工作计划工作记录service接口实现
 *
 * @author： shaobao
 * @date： Created on 2019/3/20 14:23
 * @version： v1.0
 * @modified By:
 **/
@Service
public class WorkPlanRecordServiceImpl implements WorkPlanRecordService {
    /**
     * 日志组件
     */
    private static final Logger logger = LoggerFactory.getLogger(WorkPlanServiceImpl.class);

    @Autowired
    private TbOaWorkPlanRecordMapper tbOaWorkPlanRecordMapper;

    @Autowired
    private WorkPlanRecordMapper workPlanRecordMapper;

    @Autowired
    private TbOaWorkPlanHistoryMapper tbOaWorkPlanHistoryMapper;

    @Autowired
    private TbOaWorkPlanMapper tbOaWorkPlanMapper;

    @Autowired
    private WorkPlanService workPlanService;

    /**
     * 批量记录工时
     *
     * @param workPlanRecordList
     * @param user
     */
    @Override
    @ServiceLog(doAction = "批量记录工时")
    @Transactional(rollbackFor = Exception.class)
    public void addBatch(List<WorkPlanRecord> workPlanRecordList, User user) {
        String workPlanId = null;
        //将数据记录进数据库
        if (workPlanRecordList != null && workPlanRecordList.size() > 0) {
            workPlanRecordMapper.addBatch(workPlanRecordList);

            for (int i = 0; i < workPlanRecordList.size(); i++) {
                StringBuffer buffer = new StringBuffer();
                WorkPlanRecord workPlanRecord = workPlanRecordList.get(i);
                workPlanId = workPlanRecord.getWorkPlanId();
                String remark = workPlanRecord.getRemark();
                Integer consumeTime = workPlanRecord.getConsumeTime();
                Integer remainTime = workPlanRecord.getRemainTime();

                //拼接操作记录
                String date = DateUtils.formatDate(workPlanRecord.getRecordDate(), "yyyy-MM-dd HH:mm:ss");
                buffer.append("日期:").append(date).append(",消耗总工时:").append(consumeTime)
                        .append(",剩余总工时:").append(remainTime).append("。");

                //添加历史记录
                workPlanService.inserWorkPlanHistory(user, workPlanId,
                        WorkPlanOperateEnmus.ADD_RECORD.getMessage(), remark, buffer.toString());

                //更新工作计划总剩余工时及总消耗工时
                if (i == workPlanRecordList.size() - 1) {
                    TbOaWorkPlan tbOaWorkPlan = tbOaWorkPlanMapper.selectByPrimaryKey(workPlanId);
                    if (tbOaWorkPlan != null){
                        tbOaWorkPlan.setTotalRemainTime(remainTime);
                        tbOaWorkPlan.setTotalConsumeTime(consumeTime);
                        tbOaWorkPlan.setModifierAccount(user.getAccount());
                        tbOaWorkPlan.setModifiedTime(new Date());
                        tbOaWorkPlanMapper.updateByPrimaryKeySelective(tbOaWorkPlan);
                        logger.info("[工作计划工作记录] 更新工作计划成功,workPlanId:{}", workPlanId);
                    }
                }
            }
        }
        logger.info("[工作计划工作记录] 记录工时成功,workPlanId:{}", workPlanId);
    }

    /**
     * 修改工作记录信息
     *
     * @param workPlanRecord
     * @param user
     */
    @Override
    @ServiceLog(doAction = "修改工作记录信息")
    @Transactional(rollbackFor = Exception.class)
    public void update(WorkPlanRecord workPlanRecord, User user) {
        String workPlanRecordId = workPlanRecord.getId();
        String workPlanId = workPlanRecord.getWorkPlanId();
        TbOaWorkPlanRecord tbOaWorkPlanRecord = tbOaWorkPlanRecordMapper.selectByPrimaryKey(workPlanRecordId);
        TbOaWorkPlanRecord oldTbOaWorkPlanRecord = new TbOaWorkPlanRecord();
        BeanUtils.copyProperties(tbOaWorkPlanRecord, oldTbOaWorkPlanRecord);

        //1.信息是否存在校验
        if (tbOaWorkPlanRecord == null ||
                new Byte(OaStatusEnums.DELETED.getCode()).equals(tbOaWorkPlanRecord.getRecordStatus())) {
            logger.warn("[工作计划工作记录] 修改工作计划失败,workPlanRecordId:{}", workPlanRecordId);
            throw new JnSpringCloudException(OaExceptionEnums.UPDATEDATA_NOT_EXIST);
        }

        //2.记录历史记录
        BeanUtils.copyProperties(workPlanRecord, tbOaWorkPlanRecord);
        String operateDetails = BeanDiffUtil.diff(tbOaWorkPlanRecord, oldTbOaWorkPlanRecord);
        workPlanService.inserWorkPlanHistory(user, workPlanId,
                WorkPlanOperateEnmus.UPDATE_RECODE.getMessage(), null, operateDetails);

        //3.修改工作记录
        tbOaWorkPlanRecord.setModifiedTime(new Date());
        tbOaWorkPlanRecord.setModifierAccount(user.getAccount());
        tbOaWorkPlanRecordMapper.updateByPrimaryKeySelective(tbOaWorkPlanRecord);
        logger.info("[工作计划工作记录] 编辑工作记录成功,workPlanRecordId:{}", workPlanRecordId);
    }

    /**
     * 删除工作记录
     *
     * @param workPlanRecordId
     * @param user
     */
    @Override
    @ServiceLog(doAction = "删除工作记录")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String workPlanRecordId, User user) {
        TbOaWorkPlanRecord tbOaWorkPlanRecord = tbOaWorkPlanRecordMapper.selectByPrimaryKey(workPlanRecordId);

        if (tbOaWorkPlanRecord != null &&
                new Byte(OaStatusEnums.EFFECTIVE.getCode()).equals(tbOaWorkPlanRecord.getRecordStatus())) {
            StringBuffer buffer = new StringBuffer();

            //逻辑删除信息
            tbOaWorkPlanRecord.setRecordStatus(new Byte(OaStatusEnums.DELETED.getCode()));
            tbOaWorkPlanRecord.setModifiedTime(new Date());
            tbOaWorkPlanRecord.setModifierAccount(user.getAccount());
            tbOaWorkPlanRecordMapper.updateByPrimaryKeySelective(tbOaWorkPlanRecord);
            logger.info("[工作计划工作记录] 删除工作记录成功,workPlanRecordId:{}", workPlanRecordId);

            //拼接操作细节信息
            String date = DateUtils.formatDate(tbOaWorkPlanRecord.getRecordDate(), "yyyy-MM-dd HH:mm:ss");
            buffer.append("删除数据:日期:").append(date).append(",消耗总时间:").append(tbOaWorkPlanRecord.getConsumeTime())
                    .append(",剩余总时间:").append(tbOaWorkPlanRecord.getRemainTime());

            //添加历史记录
            workPlanService.inserWorkPlanHistory(user, tbOaWorkPlanRecord.getWorkPlanId(),
                    WorkPlanOperateEnmus.DELETE_RECODE.getMessage(), null, buffer.toString());
        }
    }

    /**
     * 查看工作记录信息
     *
     * @param workPlanId
     * @return
     */
    @Override
    @ServiceLog(doAction = "查看工作记录信息")
    public List<TbOaWorkPlanRecord> list(String workPlanId) {
        TbOaWorkPlanRecordCriteria tbOaWorkPlanRecordCriteria = new TbOaWorkPlanRecordCriteria();
        tbOaWorkPlanRecordCriteria.setOrderByClause("created_time asc,sort asc");
        TbOaWorkPlanRecordCriteria.Criteria criteria = tbOaWorkPlanRecordCriteria.createCriteria();
        criteria.andWorkPlanIdEqualTo(workPlanId);
        criteria.andRecordStatusEqualTo(new Byte(OaStatusEnums.EFFECTIVE.getCode()));
        List<TbOaWorkPlanRecord> tbOaWorkPlanRecordList =
                tbOaWorkPlanRecordMapper.selectByExample(tbOaWorkPlanRecordCriteria);
        return tbOaWorkPlanRecordList;
    }
}
