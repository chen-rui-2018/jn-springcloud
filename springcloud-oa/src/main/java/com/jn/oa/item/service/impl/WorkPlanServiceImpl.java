package com.jn.oa.item.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.channel.MessageSource;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.news.vo.EmailVo;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.item.dao.*;
import com.jn.oa.item.enmus.WorkPlanExceptionEnmus;
import com.jn.oa.item.enmus.WorkPlanOperateEnmus;
import com.jn.oa.item.enmus.WorkPlanStatusEnums;
import com.jn.oa.item.enmus.WorkPlanTemplateEnums;
import com.jn.oa.item.entity.*;
import com.jn.oa.item.model.*;
import com.jn.oa.item.service.WorkPlanService;
import com.jn.oa.item.util.BeanDiffUtil;
import com.jn.oa.item.vo.WorkPlanRemindUserVO;
import com.jn.oa.item.vo.WorkPlanVO;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;

/**
 * 工作计划服务层
 *
 * @author： shaobao
 * @date： Created on 2019/2/20 oa:44
 * @version： v1.0
 * @modified By:
 **/
@Service
@EnableBinding(value = {MessageSource.class})
public class WorkPlanServiceImpl implements WorkPlanService {
    /**
     * 日志组件
     */
    private static final Logger logger = LoggerFactory.getLogger(WorkPlanServiceImpl.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private TbOaWorkPlanMapper tbOaWorkPlanMapper;

    @Autowired
    private WorkPlanMapper workPlanMapper;

    @Autowired
    private TbOaWorkPlanHistoryMapper tbOaWorkPlanHistoryMapper;

    @Autowired
    private TbOaWorkPlanUserMapper tbOaWorkPlanUserMapper;

    @Autowired
    private WorkPlanUserMapper workPlanUserMapper;

    @Autowired
    private WorkPlanHistoryMapper workPlanHistoryMapper;

    @Autowired
    private WorkPlanRecordMapper workPlanRecordMapper;

    @Autowired
    private TbOaItemMapper tbOaItemMapper;

    /**
     * 工作计划列表
     *
     * @param workPlanPage 分页查询条件
     * @return
     */
    @Override
    @ServiceLog(doAction = "工作计划列表")
    public PaginationData<List<WorkPlanVO>> list(WorkPlanPage workPlanPage) {
        Page<Object> objects = PageHelper.startPage(workPlanPage.getPage(), workPlanPage.getRows());
        List<WorkPlanVO> workPlanVOList = workPlanMapper.list(workPlanPage);
        return new PaginationData(workPlanVOList, objects.getTotal());
    }

    /**
     * 添加工作计划
     *
     * @param workPlanAdd 工作计划添加实体
     * @param user        当前用户
     */
    @Override
    @ServiceLog(doAction = "添加工作计划")
    @Transactional(rollbackFor = Exception.class)
    public void add(WorkPlanAdd workPlanAdd, User user) {
        //工作几乎id
        String workPlanId = workPlanAdd.getId();
        //预计开始时间
        Date planStartTime = workPlanAdd.getPlanStartTime();
        //预计结束时间
        Date planEndTime = workPlanAdd.getPlanEndTime();
        //当前用户账号
        String account = user.getAccount();
        //用户邮箱,用于给用户发送邮件
        StringBuffer userEmails = new StringBuffer();

        //1.对时间进行判断，结束时间需要大于开始时间
        if (planEndTime.before(planStartTime)) {
            logger.warn("[工作计划] 添加失败，结束时间需要大于开始时间,workPlanId:{}", workPlanId);
            throw new JnSpringCloudException(WorkPlanExceptionEnmus.WORK_PLAM_TIME_ERROR);
        }

        //2.添加工作计划数据至数据库
        TbOaWorkPlan tbOaWorkPlan = new TbOaWorkPlan();
        BeanUtils.copyProperties(workPlanAdd, tbOaWorkPlan);
        insertTbWorkPlan(tbOaWorkPlan, user);

        //3.添加工作计划负责人
        insertWorkPlanUser(workPlanId, workPlanAdd.getResponsibleUserAccount(), user, userEmails);

        //4.对附件的历史记录进行处理
        String remark = null;
        remark = setAttachmentToRemark(workPlanAdd.getAttachment(), remark);

        //4.往工作计划历史记录表中添加历史记录
        inserWorkPlanHistory(user, workPlanId, WorkPlanOperateEnmus.CREATE.getMessage(), remark, null);

        //5.为用户发送邮件任务提醒
        if (userEmails.length() > 0) {
            String userEmailInfo = userEmails.substring(0, userEmails.length() - 1);
            //为了防止邮件发送失败，导致任务添加失败，使用tryCatch
            try {
                sendEmail(workPlanAdd, userEmailInfo, user);
            } catch (Exception e) {
                logger.error("[工作计划] 任务提醒发送失败,workPlanId:{}", workPlanId);
            }
        }
        logger.info("[工作计划] 添加成功,workPlanId:{}", workPlanId);
    }

    /**
     * 发送任务提醒邮件
     *
     * @param workPlanAdd   工作计划添加实体
     * @param userEmailInfo 用户邮箱
     */
    private void sendEmail(WorkPlanAdd workPlanAdd, String userEmailInfo, User user) {
        String workPlanId = workPlanAdd.getId();
        EmailVo emailVo = new EmailVo();
        emailVo.setEmail(userEmailInfo);
        emailVo.setEmailSubject("[白下智慧园区]工作计划任务提醒");
        emailVo.setTemplatesName(WorkPlanTemplateEnums.REMIND_TEMPLATE.getCode());

        //对模板数据进行封装
        Map map = new HashMap();
        map.put("title", workPlanAdd.getWorkPlanName());
        map.put("time", DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        if (StringUtils.isNotBlank(user.getName())) {
            map.put("username", user.getName());
        } else {
            map.put("username", user.getAccount());
        }
        map.put("content", workPlanAdd.getContent());
        emailVo.setTemplatesDataMap(map);
        emailVo.setTemplateFlag(true);

        //发送邮件
        boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
        if (sendStatus) {
            logger.info("[工作计划] 任务提醒发送成功,workPlanId:{}", workPlanId);
        } else {
            logger.error("[工作计划] 任务提醒发送失败,workPlanId:{}", workPlanId);
        }
    }

    /**
     * 添加工作计划的历史记录
     *
     * @param user       当前用户
     * @param workPlanId 工作计划id
     * @param operate    操作名称
     * @param remark     备注
     */
    @Override
    @ServiceLog(doAction = "添加工作计划的历史记录")
    @Transactional(rollbackFor = Exception.class)
    public void inserWorkPlanHistory(User user, String workPlanId, String operate, String remark, String operateDetails) {
        TbOaWorkPlanHistory tbOaWorkPlanHistory = new TbOaWorkPlanHistory();
        //设置工作计划历史记录表属性值
        tbOaWorkPlanHistory.setId(UUID.randomUUID().toString());
        tbOaWorkPlanHistory.setWorkPlanId(workPlanId);
        tbOaWorkPlanHistory.setCreatedTime(new Date());
        tbOaWorkPlanHistory.setCreatorAccount(user.getAccount());
        tbOaWorkPlanHistory.setRecordStatus(new Byte(OaStatusEnums.EFFECTIVE.getCode()));
        String currentTime = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
        tbOaWorkPlanHistory.setOperateRecode(currentTime + ",由 <strong style=\"color:black\">" + user.getName() + "</strong> " + operate + "。");
        if (StringUtils.isNotBlank(operateDetails)) {
            tbOaWorkPlanHistory.setOperateDetails(operateDetails);
        }
        if (StringUtils.isNotBlank(remark)) {
            tbOaWorkPlanHistory.setRemark(remark);
        }
        //添加数据只数据库
        tbOaWorkPlanHistoryMapper.insertSelective(tbOaWorkPlanHistory);
        logger.info("[工作计划] 添加历史记录成功,workPlanId:{}", workPlanId);
    }

    /**
     * 工作计划提醒功能
     *
     * @return
     */
    @Override
    @ServiceLog(doAction = "工作计划提醒功能")
    public Boolean workPlanRemindEveryDay() {
        //1.查询所有未完成任务信息
        List<WorkPlanRemindUserVO> workPlanRemindUserVOS = workPlanUserMapper.getRemindWorkPlan();
        for (WorkPlanRemindUserVO workPlanRemindUserVO : workPlanRemindUserVOS) {
            String email = workPlanRemindUserVO.getEmail();
            if (email != null) {
                String userId = workPlanRemindUserVO.getUserId();
                EmailVo emailVo = new EmailVo();
                emailVo.setEmail(email);
                emailVo.setEmailSubject("[白下智慧园区]工作计划任务提醒");
                emailVo.setTemplatesName(WorkPlanTemplateEnums.BATCH_REMIND_TEMPLATE.getCode());

                //封装数据
                Map map = new HashMap();
                map.put("currentTime", DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
                map.put("time", DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));

                List<WorkPlanRemain> workPlanRemainList = workPlanRemindUserVO.getWorkPlanRemainList();
                map.put("taskCount", workPlanRemainList.size());
                map.put("workPlans", workPlanRemainList);
                emailVo.setTemplatesDataMap(map);
                emailVo.setTemplateFlag(true);

                boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
                if (sendStatus) {
                    logger.info("[工作计划] 任务提醒发送成功,userId:{}", userId);
                } else {
                    logger.error("[工作计划] 任务提醒发送失败,userId:{}", userId);
                }
            }
        }
        return true;
    }

    /**
     * 自动更新工作计划是否延期
     */
    @Override
    @ServiceLog(doAction = "自动更新工作计划是否延期")
    @Transactional(rollbackFor = Exception.class)
    public void updateWorkPlanIsExpire() {
        TbOaWorkPlanCriteria tbOaWorkPlanCriteria = new TbOaWorkPlanCriteria();
        TbOaWorkPlanCriteria.Criteria criteria = tbOaWorkPlanCriteria.createCriteria();
        criteria.andRecordStatusEqualTo(new Byte(OaStatusEnums.EFFECTIVE.getCode()));
        criteria.andWorkPlanStatusNotEqualTo(WorkPlanStatusEnums.COMPLETED.getCode());
        criteria.andIsExpireEqualTo(OaStatusEnums.DELETED.getCode());
        criteria.andPlanEndTimeLessThan(new Date());
        List<TbOaWorkPlan> tbOaWorkPlans = tbOaWorkPlanMapper.selectByExample(tbOaWorkPlanCriteria);

        //更新延期状态
        if (tbOaWorkPlans != null && tbOaWorkPlans.size() > 0) {
            workPlanMapper.updateWorkPlanIsExpire(tbOaWorkPlans);
        }
        logger.info("[工作计划]更新工作计划成功");
    }

    /**
     * 报表导入工作计划
     *
     * @param file 报表文件
     * @param user 当前用户
     */
    @Override
    @ServiceLog(doAction = "报表导入工作计划")
    @Transactional(rollbackFor = Exception.class)
    public String importExcelWorkPlanInfo(MultipartFile file, User user) {
        String account = user.getAccount();
        //1.对文件是非为空进行判断
        List<Object> objects = importExcel(file);

        List<TbOaWorkPlan> tbOaWorkPlanList = new ArrayList<TbOaWorkPlan>();
        List<TbOaWorkPlanUser> tbOaWorkPlanUserList = new ArrayList<TbOaWorkPlanUser>();
        List<TbOaWorkPlanHistory> tbOaWorkPlanHistoryList = new ArrayList<TbOaWorkPlanHistory>();
        //字符串,用于拼接导入失败数据
        StringBuffer buffer = new StringBuffer();
        buffer.append("序号:");
        Integer i = 1;
        //3.对导入数据进行解析
        for (Object object : objects) {
            i++;
            if (object instanceof WorkPlanImport) {
                TbOaWorkPlan tbOaWorkPlan = new TbOaWorkPlan();
                WorkPlanImport workPlanImport1 = (WorkPlanImport) object;

                //空值判断
                Boolean flag = checkImportValue(workPlanImport1);
                if (flag) {
                    buffer.append(i).append(",");
                    continue;
                }
                //1.根个项目名称获取项目id
                List<TbOaItem> tbOaItems = getTbOaItems(workPlanImport1);
                if (tbOaItems != null && tbOaItems.size() > 0) {
                    tbOaWorkPlan.setItemId(tbOaItems.get(0).getId());
                } else {
                    //获取不到对应id,则跳过当前数据
                    buffer.append(i).append(",");
                    continue;
                }

                //2.获取对应用户
                List<String> accountList = workPlanMapper.getUser(workPlanImport1.getUserName(), workPlanImport1.getEmail());
                String userAccount = null;
                if (accountList != null && accountList.size() > 0) {
                    userAccount = accountList.get(0);
                } else {
                    buffer.append(i).append(",");
                    continue;
                }

                //3.为工作计划其他属性进行复值
                BeanUtils.copyProperties(workPlanImport1, tbOaWorkPlan);
                //格式化时间
                if (workPlanImport1.getPlanEndTime().before(workPlanImport1.getPlanStartTime())) {
                    buffer.append(i).append(",");
                    continue;
                }
                getTbOaWorkPlan(account, tbOaWorkPlanList, tbOaWorkPlan);
                //设置对应对象
                getTbOaWorkPlanUser(account, tbOaWorkPlanUserList, tbOaWorkPlan, userAccount);
                //设置工作计划历史记录信息
                getTbWorkPlanHistory(user, account, tbOaWorkPlanHistoryList, tbOaWorkPlan);

            }
        }

        //4.往数据库中批量导入数据
        return insetImportData(tbOaWorkPlanList, tbOaWorkPlanUserList, tbOaWorkPlanHistoryList, buffer);

    }

    /**
     * 获取所有项目信息
     *
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取所有项目信息")
    public List<TbOaItem> getItemAll() {
        TbOaItemCriteria tbOaItemCriteria = new TbOaItemCriteria();
        tbOaItemCriteria.setOrderByClause("id_ desc");
        List<TbOaItem> itemList = tbOaItemMapper.selectByExample(tbOaItemCriteria);
        return itemList;
    }

    /**
     * 获取工作计划历史记录
     *
     * @param user
     * @param account
     * @param tbOaWorkPlanHistoryList
     * @param tbOaWorkPlan
     */
    private void getTbWorkPlanHistory(User user, String account,
                                      List<TbOaWorkPlanHistory> tbOaWorkPlanHistoryList, TbOaWorkPlan tbOaWorkPlan) {
        TbOaWorkPlanHistory tbOaWorkPlanHistory = new TbOaWorkPlanHistory();
        tbOaWorkPlanHistory.setId(UUID.randomUUID().toString());
        tbOaWorkPlanHistory.setWorkPlanId(tbOaWorkPlan.getId());
        String currentTime = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
        tbOaWorkPlanHistory.setOperateRecode(currentTime + ",由" + user.getName()
                + WorkPlanOperateEnmus.CREATE.getMessage() + "。");
        tbOaWorkPlanHistory.setRecordStatus(new Byte(OaStatusEnums.EFFECTIVE.getCode()));
        tbOaWorkPlanHistory.setCreatorAccount(account);
        tbOaWorkPlanHistoryList.add(tbOaWorkPlanHistory);
    }

    /**
     * 将导入的数据保存到数据库
     *
     * @param tbOaWorkPlanList
     * @param tbOaWorkPlanUserList
     * @param tbOaWorkPlanHistoryList
     * @param buffer
     * @return
     */
    private String insetImportData(List<TbOaWorkPlan> tbOaWorkPlanList, List<TbOaWorkPlanUser> tbOaWorkPlanUserList,
                                   List<TbOaWorkPlanHistory> tbOaWorkPlanHistoryList, StringBuffer buffer) {
        if (tbOaWorkPlanList.size() > 0) {
            workPlanMapper.insertBatch(tbOaWorkPlanList);
            logger.info("[工作计划] 导入工作计划,保存工作计划数据成功");
            workPlanUserMapper.insertBatch(tbOaWorkPlanUserList);
            logger.info("[工作计划] 导入工作计划,保存工作计划负责人信息成功");
            workPlanHistoryMapper.insertBatch(tbOaWorkPlanHistoryList);
            logger.info("[工作计划] 导入工作计划,保存工作计划历史记录信息成功");
        }

        if (buffer.length() > 3) {
            buffer.append("行数据导入失败,请检查数据后再导入");
            return buffer.toString();
        } else {
            return "导入成功";
        }
    }

    /**
     * 导入数据
     *
     * @param file 导入文件
     * @return
     */
    private List<Object> importExcel(MultipartFile file) {
        if (file.isEmpty()) {
            logger.warn("[工作计划] 导入失败,导入文件为空");
            throw new JnSpringCloudException(WorkPlanExceptionEnmus.FILE_NOT_EMPTY);
        }

        //2.使用工具类,解析导入文件
        WorkPlanImport workPlanImport = new WorkPlanImport();
        return ExcelUtil.readExcel(file, workPlanImport, 1, 1);
    }

    /**
     * 对导入数据控制判断
     *
     * @param workPlanImport1
     * @return
     */
    private Boolean checkImportValue(WorkPlanImport workPlanImport1) {
        return (StringUtils.isBlank(workPlanImport1.getItemName())
                || StringUtils.isBlank(workPlanImport1.getWorkPlanName())
                || StringUtils.isBlank(workPlanImport1.getUserName())
                || StringUtils.isBlank(workPlanImport1.getEmail())
                || workPlanImport1.getPlanStartTime() == null
                || workPlanImport1.getPlanEndTime() == null);
    }

    /**
     * 获取导入工作计划的负责人对象信息
     *
     * @param account
     * @param tbOaWorkPlanUserList
     * @param tbOaWorkPlan
     * @param userAccount
     */
    private void getTbOaWorkPlanUser(String account, List<TbOaWorkPlanUser> tbOaWorkPlanUserList,
                                     TbOaWorkPlan tbOaWorkPlan, String userAccount) {
        TbOaWorkPlanUser tbOaWorkPlanUser = new TbOaWorkPlanUser();
        tbOaWorkPlanUser.setId(UUID.randomUUID().toString());
        tbOaWorkPlanUser.setWorkPlanId(tbOaWorkPlan.getId());
        tbOaWorkPlanUser.setResponsibleUserAccount(userAccount);
        tbOaWorkPlanUser.setRecordStatus(new Byte(OaStatusEnums.EFFECTIVE.getCode()));
        tbOaWorkPlanUser.setCreatorAccount(account);
        tbOaWorkPlanUserList.add(tbOaWorkPlanUser);
    }

    /**
     * 获取导入工作计划对象
     *
     * @param account
     * @param tbOaWorkPlanList
     * @param tbOaWorkPlan
     */
    private void getTbOaWorkPlan(String account, List<TbOaWorkPlan> tbOaWorkPlanList, TbOaWorkPlan tbOaWorkPlan) {
        tbOaWorkPlan.setId(UUID.randomUUID().toString());
        tbOaWorkPlan.setCreatorAccount(account);
        tbOaWorkPlan.setIsExpire(OaStatusEnums.DELETED.getCode());
        tbOaWorkPlan.setRecordStatus(new Byte(OaStatusEnums.EFFECTIVE.getCode()));
        tbOaWorkPlan.setWorkPlanStatus(WorkPlanStatusEnums.TO_BEGIN.getCode());
        tbOaWorkPlanList.add(tbOaWorkPlan);
    }

    /**
     * 获取导入数据
     *
     * @param workPlanImport1
     * @return
     */
    private List<TbOaItem> getTbOaItems(WorkPlanImport workPlanImport1) {
        String itemName = workPlanImport1.getItemName();
        TbOaItemCriteria tbOaItemCriteria = new TbOaItemCriteria();
        TbOaItemCriteria.Criteria criteria = tbOaItemCriteria.createCriteria();
        criteria.andItemNameEqualTo(itemName);
        criteria.andRecordStatusEqualTo(new Byte(OaStatusEnums.EFFECTIVE.getCode()));
        return tbOaItemMapper.selectByExample(tbOaItemCriteria);
    }

    /**
     * 添加用户负责人信息
     *
     * @param workPlanId
     * @param responsibleUserAccount
     * @param user
     * @param userEmails
     */
    private void insertWorkPlanUser(String workPlanId, String responsibleUserAccount,
                                    User user, StringBuffer userEmails) {
        String account = user.getAccount();
        if (responsibleUserAccount != null) {
            String[] userAccounts = responsibleUserAccount.split(",");
            for (String userAccount : userAccounts) {
                //设置工作计划负责人表的属性
                TbOaWorkPlanUser tbOaWorkPlanUser = new TbOaWorkPlanUser();
                tbOaWorkPlanUser.setId(UUID.randomUUID().toString());
                tbOaWorkPlanUser.setWorkPlanId(workPlanId);
                tbOaWorkPlanUser.setResponsibleUserAccount(userAccount);
                tbOaWorkPlanUser.setRecordStatus(new Byte(OaStatusEnums.EFFECTIVE.getCode()));
                tbOaWorkPlanUser.setCreatedTime(new Date());
                tbOaWorkPlanUser.setCreatorAccount(account);
                //添加数据
                tbOaWorkPlanUserMapper.insert(tbOaWorkPlanUser);

                //获取用户账号邮箱
                if (userEmails != null) {
                    User user1 = new User();
                    user1.setAccount(userAccount);
                    Result<User> result = systemClient.getUser(user1);
                    if (result.getData() != null) {
                        userEmails.append(result.getData().getEmail()).append(",");
                    }
                }
            }

        }
    }

    /**
     * 添加工作计划
     *
     * @param tbOaWorkPlan
     * @param user
     */
    private void insertTbWorkPlan(TbOaWorkPlan tbOaWorkPlan, User user) {
        String account = user.getAccount();
        //设置创建人及创建时间
        tbOaWorkPlan.setCreatedTime(new Date());
        tbOaWorkPlan.setCreatorAccount(account);
        tbOaWorkPlan.setRecordStatus(new Byte(OaStatusEnums.EFFECTIVE.getCode()));

        //设置工作计划开始状态
        tbOaWorkPlan.setWorkPlanStatus(WorkPlanStatusEnums.TO_BEGIN.getCode());

        tbOaWorkPlanMapper.insertSelective(tbOaWorkPlan);
    }


    /**
     * 查询工作计划详情
     *
     * @param workPlanId 工作计划id
     */
    @Override
    @ServiceLog(doAction = "查询工作计划详情")
    public WorkPlanVO getWorkPlanById(String workPlanId) {
        //1.判断公告信息是否存在
        checkWorkPlanExist(workPlanId);

        //2.获取工作计划详细信息及历史记录集合
        WorkPlanVO workPlanVO = workPlanMapper.getResponsibleAndHistoryById(workPlanId);
        return workPlanVO;

    }

    /**
     * 根据工作计划id判断工作计划是否存在
     *
     * @param workPlanId 工作计划id
     */
    private TbOaWorkPlan checkWorkPlanExist(String workPlanId) {
        TbOaWorkPlan tbOaWorkPlan = tbOaWorkPlanMapper.selectByPrimaryKey(workPlanId);
        if (tbOaWorkPlan == null ||
                new Byte(OaStatusEnums.DELETED.getCode()).equals(tbOaWorkPlan.getRecordStatus())) {
            logger.warn("[工作计划] 查询工作计划失败,workPlanId:{}", workPlanId);
            throw new JnSpringCloudException(OaExceptionEnums.UPDATEDATA_NOT_EXIST);
        } else {
            return tbOaWorkPlan;
        }
    }

    /**
     * 更新工作计划
     *
     * @param workPlanEdit
     * @param user
     */
    @Override
    @ServiceLog(doAction = "更新工作计划")
    @Transactional(rollbackFor = Exception.class)
    public void update(WorkPlanEdit workPlanEdit, User user) {
        String workPlanId = workPlanEdit.getId();
        String remark = workPlanEdit.getRemark();
        StringBuffer buffer = new StringBuffer();
        //用户原负责人
        String oldResponsibleName = null;

        //1.查询更新信息是否存在你
        TbOaWorkPlan oldTbOaWorkPlan = checkWorkPlanExist(workPlanId);
        TbOaWorkPlan tbOaWorkPlan = new TbOaWorkPlan();
        BeanUtils.copyProperties(oldTbOaWorkPlan, tbOaWorkPlan);

        //2.判断是否修改项目名称
        String oldItemId = oldTbOaWorkPlan.getItemId();
        String newItemId = workPlanEdit.getItemId();
        if (!StringUtils.equals(oldItemId, newItemId)) {
            TbOaItem oldTbOaItem = tbOaItemMapper.selectByPrimaryKey(oldItemId);
            TbOaItem newTbOaItem = tbOaItemMapper.selectByPrimaryKey(newItemId);
            buffer.append("<p>修改了&nbsp;&nbsp;<i style=\"color:black;font-weight:600\">").append("工作计划所属项目")
                    .append(" </i>,&nbsp;&nbsp;旧值为:&nbsp;&nbsp;\"").append(oldTbOaItem.getItemName())
                    .append("\",&nbsp;&nbsp;新值为: &nbsp;&nbsp;\"").append(newTbOaItem.getItemName()).append("\"。</p>");
        }

        //3.判断是否修改任务负责人
        List<String> reponsible = workPlanMapper.getResponsibleById(workPlanId);
        String responsibleUserAccount = workPlanEdit.getResponsibleUserAccount();
        String[] split = responsibleUserAccount.split(",");
        if (split.length == reponsible.size()) {
            for (String userAccount : split) {
                for (int i = reponsible.size() - 1; i >= 0; i--) {
                    if (StringUtils.equals(userAccount, reponsible.get(i))) {
                        reponsible.remove(i);
                    }
                }
            }
            //如果集合长度不为空,说明改变了用户负责人
            if (reponsible.size() != 0) {
                oldResponsibleName = updateResponsible(user, workPlanId, responsibleUserAccount);
            }
        } else {
            oldResponsibleName = updateResponsible(user, workPlanId, responsibleUserAccount);
        }

        //4.更新工作计划值至数据库
        BeanUtils.copyProperties(workPlanEdit, tbOaWorkPlan);
        String operateDetails = BeanDiffUtil.diff(tbOaWorkPlan, oldTbOaWorkPlan);
        String attachment = workPlanEdit.getAttachment();
        if (attachment != null) {
            tbOaWorkPlan.setAttachment(oldTbOaWorkPlan.getAttachment());
            setAttachment(attachment, tbOaWorkPlan);
        }
        tbOaWorkPlan.setModifiedTime(new Date());
        tbOaWorkPlan.setModifierAccount(user.getAccount());
        tbOaWorkPlanMapper.updateByPrimaryKeySelective(tbOaWorkPlan);

        //5.添加负责人历史记录信息
        if (oldResponsibleName != null) {
            String newResponsibleName = workPlanMapper.getResponsibleName(workPlanId);
            buffer.append("<p>修改了&nbsp;&nbsp;<i style=\"color:black;font-weight:600\">").append("工作计划负责人")
                    .append(" </i>,&nbsp;&nbsp;旧值为:&nbsp;&nbsp;\"").append(oldResponsibleName)
                    .append("\",&nbsp;&nbsp;新值为: &nbsp;&nbsp;\"").append(newResponsibleName).append("\"。</p>");
        }

        //6.添加历史记录信息
        String operateRecode = buffer.append(operateDetails).toString();
        //操作备注信息
        remark = setAttachmentToRemark(attachment, remark);
        //往历史记录表中添加数据
        inserWorkPlanHistory(user, workPlanId, WorkPlanOperateEnmus.UPDATE.getMessage(), remark, operateRecode);
    }

    /**
     * 更新用户负责人
     *
     * @param user                   当前用户
     * @param workPlanId             工作计划id
     * @param responsibleUserAccount
     */
    private String updateResponsible(User user, String workPlanId, String responsibleUserAccount) {
        String account = user.getAccount();
        //获取原负责人名称
        String oldResponsibleName = workPlanMapper.getResponsibleName(workPlanId);

        workPlanUserMapper.delete(workPlanId, account);
        insertWorkPlanUser(workPlanId, responsibleUserAccount, user, null);
        return oldResponsibleName;
    }

    /**
     * 修改工作计划状态
     *
     * @param workPlanUpdateStatus 状态信息
     * @param user                 当前用户
     */
    @Override
    @ServiceLog(doAction = "修改工作计划状态")
    @Transactional(rollbackFor = Exception.class)
    public void updateWorkPlanStatus(WorkPlanUpdateStatus workPlanUpdateStatus, User user) {
        //工作计划id
        String workPlanId = workPlanUpdateStatus.getId();
        //工作计划状态
        String workPlanStatus = workPlanUpdateStatus.getWorkPlanStatus();
        //工作计划附件
        String attachment = workPlanUpdateStatus.getAttachment();
        //备注
        String remark = workPlanUpdateStatus.getRemark();

        //1.判断被修改信息是否存在
        TbOaWorkPlan tbOaWorkPlan = checkWorkPlanExist(workPlanId);

        //修改状态值
        tbOaWorkPlan.setWorkPlanStatus(workPlanStatus);
        //2.判断是否修改为开始状态
        if (WorkPlanStatusEnums.DOING.getCode().equals(workPlanStatus)) {
            setDoingStatus(workPlanUpdateStatus, user, tbOaWorkPlan);
        }

        //3.判断是否修改为完成态
        if (WorkPlanStatusEnums.COMPLETED.getCode().equals(workPlanStatus)) {
            setCompletedStatus(workPlanUpdateStatus, user, tbOaWorkPlan);
        }

        //4.判断是否修改为已挂起状态
        if (WorkPlanStatusEnums.PAUSED.getCode().equals(workPlanStatus)) {
            //往历史记录表中添加数据
            inserWorkPlanHistory(user, workPlanId, WorkPlanOperateEnmus.PAUSED.getMessage(), remark, null);
        }

        //5.判断是否是暂停状态重新开始
        if (WorkPlanStatusEnums.RESTART.getCode().equals(workPlanStatus)) {
            setRestartStatus(workPlanUpdateStatus, user, tbOaWorkPlan);
        }

        //6.修改工作计划状态属性值
        if (WorkPlanStatusEnums.RESTART.getCode().equals(workPlanStatus)) {
            tbOaWorkPlan.setWorkPlanStatus(WorkPlanStatusEnums.DOING.getCode());
        } else {
            tbOaWorkPlan.setWorkPlanStatus(workPlanStatus);
        }

        if (StringUtils.isNotBlank(attachment)) {
            //设置附件
            setAttachment(attachment, tbOaWorkPlan);
        }

        //7.更新数据库信息
        tbOaWorkPlan.setModifiedTime(new Date());
        tbOaWorkPlan.setModifierAccount(user.getAccount());
        tbOaWorkPlanMapper.updateByPrimaryKeySelective(tbOaWorkPlan);
        logger.info("[工作计划] 修改状态成功,workPlanId:{}", workPlanId);
    }

    /**
     * 添加工作计划备注
     *
     * @param workPlanAddRemark
     * @param user
     */
    @Override
    @ServiceLog(doAction = "添加工作计划备注")
    @Transactional(rollbackFor = Exception.class)
    public void addRemark(WorkPlanAddRemark workPlanAddRemark, User user) {
        String workPlanId = workPlanAddRemark.getId();
        //1.判断被修改信息是否存在
        TbOaWorkPlan tbOaWorkPlan = checkWorkPlanExist(workPlanId);

        //2.添加备注
        inserWorkPlanHistory(user, workPlanId, WorkPlanOperateEnmus.ADD_REMARK.getMessage(),
                workPlanAddRemark.getRemark(), null);
        logger.info("[工作计划] 添加备注信息成功,workPlanId:{}", workPlanId);
    }

    /**
     * (逻辑)删除工作计划
     *
     * @param workPlanId
     * @param user
     */
    @Override
    @ServiceLog(doAction = "(逻辑)删除工作计划")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String workPlanId, User user) {
        TbOaWorkPlan tbOaWorkPlan = tbOaWorkPlanMapper.selectByPrimaryKey(workPlanId);
        if (tbOaWorkPlan != null) {
            String account = user.getAccount();

            //删除工作计划负责人信息
            workPlanUserMapper.delete(workPlanId, account);
            logger.info("[工作计划] 删除工作计划负责人成功,workPlanId:{}", workPlanId);

            //删除工作计划历史记录信息
            workPlanHistoryMapper.delete(workPlanId, account);
            logger.info("[工作计划] 删除工作计划历史记录信息成功,workPlanId:{}", workPlanId);

            //删除工作计划历史记录信息
            workPlanRecordMapper.delete(workPlanId, account);
            logger.info("[工作计划] 删除工作计划工作记录信息成功,workPlanId:{}", workPlanId);

            //删除工作计划
            tbOaWorkPlan.setRecordStatus(new Byte(OaStatusEnums.DELETED.getCode()));
            tbOaWorkPlan.setModifierAccount(account);
            tbOaWorkPlan.setModifiedTime(new Date());
            tbOaWorkPlanMapper.updateByPrimaryKeySelective(tbOaWorkPlan);
            logger.info("[工作计划] 删除工作计划信息成功,workPlanId:{}", workPlanId);
        }
    }

    /**
     * 由暂停状态,进入重新开始状态,设置信息及历史记录
     *
     * @param workPlanUpdateStatus
     * @param user
     */
    private void setRestartStatus(WorkPlanUpdateStatus workPlanUpdateStatus, User user, TbOaWorkPlan tbOaWorkPlan) {
        //工作计划id
        String workPlanId = workPlanUpdateStatus.getId();
        //总消耗时间
        Integer totalConsumeTime = workPlanUpdateStatus.getTotalConsumeTime();
        //总剩余时间
        Integer totalRemainTime = workPlanUpdateStatus.getTotalRemainTime();
        //备注
        String remark = workPlanUpdateStatus.getRemark();

        TbOaWorkPlan oldtboaWorkPlan = new TbOaWorkPlan();
        BeanUtils.copyProperties(tbOaWorkPlan, oldtboaWorkPlan);

        tbOaWorkPlan.setWorkPlanStatus(WorkPlanStatusEnums.DOING.getCode());
        //对属性质值行断言
        Assert.notNull(totalConsumeTime, WorkPlanExceptionEnmus.CONSUME_TIME_NOT_NULL.getMessage());
        Assert.notNull(totalRemainTime, WorkPlanExceptionEnmus.REMAIN_TIME_NOT_NULL.getMessage());

        tbOaWorkPlan.setTotalConsumeTime(totalConsumeTime);
        tbOaWorkPlan.setTotalRemainTime(totalRemainTime);

        //添加操作记录,判断修改的字段及值的变化
        String operateDetails = BeanDiffUtil.diff(tbOaWorkPlan, oldtboaWorkPlan);
        //往历史记录表中添加数据
        inserWorkPlanHistory(user, workPlanId, WorkPlanOperateEnmus.RESTART.getMessage(), remark, operateDetails);
    }

    /**
     * 设值已完成状态信息及历史记录
     *
     * @param workPlanUpdateStatus
     * @param user
     * @param tbOaWorkPlan
     */
    private void setCompletedStatus(WorkPlanUpdateStatus workPlanUpdateStatus, User user, TbOaWorkPlan tbOaWorkPlan) {
        //工作计划id
        String workPlanId = workPlanUpdateStatus.getId();
        //工作计划附件
        String attachment = workPlanUpdateStatus.getAttachment();
        //总消耗时间
        Integer totalConsumeTime = workPlanUpdateStatus.getTotalConsumeTime();
        //备注
        String remark = workPlanUpdateStatus.getRemark();
        //实际结束时间
        Date endTime = workPlanUpdateStatus.getEndTime();

        TbOaWorkPlan oldtboaWorkPlan = new TbOaWorkPlan();
        BeanUtils.copyProperties(tbOaWorkPlan, oldtboaWorkPlan);


        //对属性质进行断言
        Assert.notNull(totalConsumeTime, WorkPlanExceptionEnmus.CONSUME_TIME_NOT_NULL.getMessage());
        Assert.notNull(endTime, WorkPlanExceptionEnmus.END_TIME_NOT_NULL.getMessage());

        tbOaWorkPlan.setTotalConsumeTime(totalConsumeTime);
        tbOaWorkPlan.setEndTime(endTime);

        //对附件名称进行处理
        remark = setAttachmentToRemark(attachment, remark);
        //添加操作记录,判断修改的字段及值的变化
        String operateDetails = BeanDiffUtil.diff(tbOaWorkPlan, oldtboaWorkPlan);
        //设置工作计划延迟状态为否
        tbOaWorkPlan.setIsExpire(OaStatusEnums.DELETED.getCode());
        //往历史记录表中添加数据
        inserWorkPlanHistory(user, workPlanId, WorkPlanOperateEnmus.FINISH.getMessage(), remark, operateDetails);

        //修改项目管理进度
        updateItemProgress(tbOaWorkPlan, totalConsumeTime);
    }

    /**
     * 更新工作计划进度
     *
     * @param tbOaWorkPlan     工作计划
     * @param totalConsumeTime 消耗时间
     */
    private void updateItemProgress(TbOaWorkPlan tbOaWorkPlan, Integer totalConsumeTime) {
        TbOaItem tbOaItem = tbOaItemMapper.selectByPrimaryKey(tbOaWorkPlan.getItemId());
        if (tbOaItem == null) {
            logger.warn("[工作计划] 导入失败,导入文件为空");
            throw new JnSpringCloudException(WorkPlanExceptionEnmus.ITEM_IS_EXIST);
        }
        Double consumeTime = tbOaItem.getTotalConsumeTime();
        Double remainTime = tbOaItem.getTotalRemainTime();
        Double totalPlanTime = tbOaItem.getTotalPlanTime();
        consumeTime = consumeTime + totalConsumeTime;
        remainTime = remainTime - totalConsumeTime;
        if (remainTime < 0) {
            remainTime = 0D;
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String progress = numberFormat.format((Double) consumeTime / (Double) totalPlanTime * 100);
        Double pro = Double.parseDouble(progress.replace(",", ""));
        if (pro > 100) {
            progress = "100";
        }
        tbOaItem.setItemProgress(progress + "%");
        tbOaItem.setTotalConsumeTime(consumeTime);
        tbOaItem.setTotalRemainTime(remainTime);
        //将数据保存值数据库
        tbOaItemMapper.updateByPrimaryKeySelective(tbOaItem);
        logger.info("[工作计划] 更新项目进度成功,itemId:{}", tbOaItem.getId());
    }

    /**
     * 设置开始状态属性及历史记录信息
     *
     * @param workPlanUpdateStatus
     * @param user
     * @param tbOaWorkPlan
     */
    private void setDoingStatus(WorkPlanUpdateStatus workPlanUpdateStatus, User user, TbOaWorkPlan tbOaWorkPlan) {
        //备注
        String remark = workPlanUpdateStatus.getRemark();
        //工作计划id
        String workPlanId = workPlanUpdateStatus.getId();
        //实际开始时间
        Date startTime = workPlanUpdateStatus.getStartTime();
        //总消耗时间
        Integer totalConsumeTime = workPlanUpdateStatus.getTotalConsumeTime();
        //总剩余时间
        Integer totalRemainTime = workPlanUpdateStatus.getTotalRemainTime();

        TbOaWorkPlan oldtboaWorkPlan = new TbOaWorkPlan();
        BeanUtils.copyProperties(tbOaWorkPlan, oldtboaWorkPlan);

        //对属性质值行断言
        Assert.notNull(totalConsumeTime, WorkPlanExceptionEnmus.CONSUME_TIME_NOT_NULL.getMessage());
        Assert.notNull(totalRemainTime, WorkPlanExceptionEnmus.REMAIN_TIME_NOT_NULL.getMessage());
        Assert.notNull(startTime, WorkPlanExceptionEnmus.START_TIME_NOT_NULL.getMessage());

        tbOaWorkPlan.setTotalConsumeTime(totalConsumeTime);
        tbOaWorkPlan.setTotalRemainTime(totalRemainTime);
        tbOaWorkPlan.setStartTime(startTime);

        //添加操作记录,判断修改的字段及值的变化
        String operateDetails = BeanDiffUtil.diff(tbOaWorkPlan, oldtboaWorkPlan);
        //往历史记录表中添加数据
        inserWorkPlanHistory(user, workPlanId, WorkPlanOperateEnmus.START.getMessage(), remark, operateDetails);
    }

    /**
     * 设置附件上传的历史记录
     *
     * @param attachment 附件
     * @param remark     备注
     * @return
     */
    private String setAttachmentToRemark(String attachment, String remark) {
        StringBuffer titleBuffer = new StringBuffer();
        if (StringUtils.isNotBlank(attachment)) {
            //将json数据装成数组
            try {
                ObjectMapper mapper = new ObjectMapper();
                List<Map<String, String>> list = mapper.readValue(attachment, List.class);
                titleBuffer.append("上传了附件:");
                for (Map<String, String> map : list) {
                    titleBuffer.append(map.get("title")).append(",");
                }
            } catch (IOException e) {
                logger.error("[工作计划] 附件信息,json数据转换格式异常", e);
            }
        }

        if (titleBuffer.length() != 0) {
            String substring = titleBuffer.substring(0, titleBuffer.length() - 1);
            if (StringUtils.isBlank(remark)) {
                remark = substring;
            } else {
                remark = substring + ";" + remark;
            }

        }
        return remark;
    }

    /**
     * 设置附件路径
     *
     * @param attachment   新添加附件
     * @param tbOaWorkPlan 工作计划实体
     */
    private void setAttachment(String attachment, TbOaWorkPlan tbOaWorkPlan) {
        String attachment1 = tbOaWorkPlan.getAttachment();
        if (attachment1 != null) {
            //操作原附件字符串
            String subAtt1 = attachment1.substring(0, attachment1.length() - 1);
            //操作信息字符串
            String subAtt2 = attachment.substring(1);
            tbOaWorkPlan.setAttachment(subAtt1 + "," + subAtt2);
        } else {
            tbOaWorkPlan.setAttachment(attachment);
        }
    }
}
