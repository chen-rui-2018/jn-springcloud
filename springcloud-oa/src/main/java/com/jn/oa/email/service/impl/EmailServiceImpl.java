package com.jn.oa.email.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import com.jn.down.api.DownLoadClient;
import com.jn.down.model.DownLoad;
import com.jn.news.vo.EmailVo;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.email.dao.EmailMapper;
import com.jn.oa.email.dao.EmailUserMapper;
import com.jn.oa.email.dao.TbOaEmailMapper;
import com.jn.oa.email.entity.TbOaEmail;
import com.jn.oa.email.entity.TbOaEmailUser;
import com.jn.oa.email.enums.EmailExceptionEnmus;
import com.jn.oa.email.enums.EmailIsDelayEnums;
import com.jn.oa.email.enums.EmailSendStatusEnums;
import com.jn.oa.email.model.DownAttachment;
import com.jn.oa.email.model.EmailAdd;
import com.jn.oa.email.model.EmailPage;
import com.jn.oa.email.service.EmailService;
import com.jn.oa.email.vo.EmailVO;
import com.jn.oa.model.Email;
import com.jn.oa.notice.service.impl.NoticeServiceImpl;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.upload.api.UploadClient;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * 一键EmailService层实现
 *
 * @author： shaobao
 * @date： Created on 2019/3/9 11:27
 * @version： v1.0
 * @modified By:
 **/
@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

    /**
     * 获取OA的服务ID
     */
    private final static String OA_CLIENT = "springcloud-oa";
    /**
     * 获取定时发送的服务地址
     */
    private final static String OA_CLIENT_EMAIL_SERVICE = "/api/oa/regularSendEmail";

    @Autowired
    private TbOaEmailMapper tbOaEmailMapper;

    @Autowired
    private EmailUserMapper emailUserMapper;

    @Autowired
    private DelaySendMessageClient delaySendMessageClient;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private EmailMapper emailMapper;

    @Autowired
    private UploadClient uploadClient;

    @Autowired
    private DownLoadClient downLoadClient;

    /**
     * 查看邮件任务详情功能
     *
     * @param emailId 邮件任务id
     * @return
     */
    @Override
    @ServiceLog(doAction = "查看邮件任务详情功能")
    public EmailVO getEmailDetails(String emailId) {
        EmailVO emailVO = emailMapper.getEmailDetails(emailId);
        return emailVO;
    }

    /**
     * 一键Email添加/编辑功能
     *
     * @param emailAdd 一键Email增加实体
     * @param user     当前登录用户
     * @param isAdd    是否是添加操作
     */
    @Override
    @ServiceLog(doAction = "一键Email添加/编辑功能")
    @Transactional(rollbackFor = Exception.class)
    public void addOrUpdate(EmailAdd emailAdd, User user, Boolean isAdd) {
        TbOaEmail tbOaEmail = new TbOaEmail();
        BeanUtils.copyProperties(emailAdd, tbOaEmail);
        //判断是添加操作
        if (isAdd) {

            //添加一键Email
            addEmail(emailAdd, user, tbOaEmail);

        } else {

            //修改一键Email信息
            updateEmail(emailAdd, user, tbOaEmail);
        }
    }

    /**
     * 一键Email的定时发送回调接口
     *
     * @param email
     */
    @Override
    @ServiceLog(doAction = "一键Email的定时发送回调接口")
    @Transactional(rollbackFor = Exception.class)
    public Boolean regularSendEmail(Email email) {
        String emailId = email.getId();

        TbOaEmail tbOaEmail = tbOaEmailMapper.selectByPrimaryKey(emailId);

        //1.判断邮件发送任务是否存在或已被删除
        if (tbOaEmail == null ||
                StringUtils.equals(OaStatusEnums.DELETED.getCode(), tbOaEmail.getRecordStatus().toString())) {
            logger.warn("[一键Email] 邮件发送失败,邮件任务不存在或已被删除,emailId:{}", emailId);
            return false;
        }

        //2.判断邮件任务状态是否是未发送状态
        if (!StringUtils.equals(EmailSendStatusEnums.NOT_SEND.getCode(), tbOaEmail.getSendStatus())) {
            logger.warn("[一键Email] 邮件发送失败,邮件任务状态不处于未发送状态,emailId:{}", emailId);
            return false;
        }

        //3.判断是否是定时状态
        if (StringUtils.equals(EmailIsDelayEnums.NO.getCode(), tbOaEmail.getIsDelay())) {
            logger.warn("[一键Email] 邮件发送失败,邮件任务不是定时发送任务,emailId:{}", emailId);
            return false;
        }

        //4.判断定时时间是否被修改
        String timeStr1 = DateUtils.formatDate(email.getDelaySendTime(), "yyyy-MM-dd HH:mm");
        String timeStr2 = DateUtils.formatDate(tbOaEmail.getDelaySendTime(), "yyyy-MM-dd HH:mm");
        if (!StringUtils.equals(timeStr1, timeStr2)) {
            logger.warn("[一键Email] 邮件发送失败,邮件任务发送时间不是任务定时时间,emailId:{}", emailId);
            return false;
        }


        //5.获取所有用户邮箱,发送邮件
        sendEmail(tbOaEmail, null);
        return true;
    }

    /**
     * 发送邮件
     *
     * @param tbOaEmail
     * @param user      当前登录用户
     */
    private void sendEmail(TbOaEmail tbOaEmail, User user) {
        //文件路径集合
        List<String> fileList = new ArrayList<String>(16);
        try {
            String emailId = tbOaEmail.getId();
            //获取邮件任务接收人邮箱
            String userEmailInfo = emailUserMapper.getUserEmailInfo(emailId);
            if (userEmailInfo == null) {
                return;
            }

            EmailVo emailVo = new EmailVo();
            emailVo.setEmail(userEmailInfo);
            emailVo.setEmailSubject(tbOaEmail.getTitle());
            emailVo.setEmailContent(tbOaEmail.getEmailContent());

            //获取附件信息
            String attachment = tbOaEmail.getAttachment();
            //从文件服务器上下载附件
            downlownAttachment(fileList, emailVo, attachment);

            boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
            //更新邮件发送时间
            tbOaEmail.setSendTime(new Date());
            if (user != null) {
                //设置最新更新人及更新时间
                tbOaEmail.setModifierAccount(user.getAccount());
                tbOaEmail.setModifiedTime(new Date());
            }
            if (sendStatus) {
                tbOaEmail.setSendStatus(EmailSendStatusEnums.SEND_SUCCESSFULLY.getCode());
                tbOaEmailMapper.updateByPrimaryKeySelective(tbOaEmail);
                logger.info("[一键Email] 更新邮件发送时间成功,emailId:{}", emailId);
            } else {
                //发送失败
                sendFailure(tbOaEmail);
            }
        } catch (Exception e) {
            //发送失败
            sendFailure(tbOaEmail);
        }

    }

    /**
     * 从文件服务器上现在附件
     *
     * @param fileList   文件路径集合
     * @param emailVo    邮件实体
     * @param attachment 附件信息
     * @throws IOException
     */
    private void downlownAttachment(List<String> fileList, EmailVo emailVo, String attachment) throws IOException {
        if (attachment != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, String>> list = objectMapper.readValue(attachment, List.class);
            for (Map<String, String> map : list) {
                String title = map.get("title");
                String url = map.get("url");
                DownLoad downLoad = new DownLoad();
                downLoad.setUrl(url);
                downLoad.setToken(false);
                ResponseEntity<byte[]> responseEntity = downLoadClient.downLoad(downLoad);
                //获取文件
                byte[] body = responseEntity.getBody();

                File tempPath = new File(ResourceUtils.getURL("classpath:").getPath());
                if (!tempPath.exists()) {
                    tempPath = new File("");
                }
                File tempUpload = new File(tempPath.getAbsolutePath(), "email/download/");
                if (!tempUpload.exists()) {
                    tempUpload.mkdirs();
                }

                String filePath = tempUpload.getAbsolutePath() + File.separator + title;
                fileList.add(filePath);
                IOUtils.write(body, new FileOutputStream(filePath));
            }
            String[] filePath = fileList.toArray(new String[fileList.size()]);
            emailVo.setFiles(filePath);
        }
    }

    /**
     * 发送失败异常处理
     *
     * @param tbOaEmail
     */
    private void sendFailure(TbOaEmail tbOaEmail) {
        tbOaEmail.setSendStatus(EmailSendStatusEnums.SEND_FAILURE.getCode());
        tbOaEmailMapper.updateByPrimaryKeySelective(tbOaEmail);
        logger.error("[一键Email] 邮件定时发送失败,emailId:{}", tbOaEmail.getId());
        throw new JnSpringCloudException(EmailExceptionEnmus.EMAIL_SEND_FAIL);
    }

    /**
     * 用户手动一键发送功能
     *
     * @param emailId 邮件任务id
     * @param user    当前登录用户
     */
    @Override
    @ServiceLog(doAction = "用户手动一键发送功能")
    @Transactional(rollbackFor = Exception.class)
    public void sendEmailManual(String emailId, User user) {
        //1.校验邮件任务是否存在或则一删除
        TbOaEmail tbOaEmail = tbOaEmailMapper.selectByPrimaryKey(emailId);
        if (tbOaEmail == null ||
                StringUtils.equals(OaStatusEnums.DELETED.getCode(), tbOaEmail.getRecordStatus().toString())) {
            logger.warn("[一键Email] 一键发送失败,邮件任务不存在或已被删除,emailId:{}", tbOaEmail.getId());
            throw new JnSpringCloudException(EmailExceptionEnmus.EMAIL_NOT_EXIST);
        }

        //2.发送邮件
        sendEmail(tbOaEmail, user);
    }

    /**
     * 一键Email列表功能
     *
     * @param emailPage 分页条件
     * @return
     */
    @Override
    @ServiceLog(doAction = "一键Email列表功能")
    public PaginationData list(EmailPage emailPage) {
        Page<Object> objects = PageHelper.startPage(emailPage.getPage(), emailPage.getRows());
        List<EmailVO> emailVOList = emailMapper.list(emailPage);
        PaginationData data = new PaginationData(emailVOList, objects.getTotal());
        return data;
    }

    /**
     * (逻辑)批量删除邮件任务
     *
     * @param emailIds 邮件任务Id数组
     * @param user     当前登录用户
     */
    @Override
    @ServiceLog(doAction = "(逻辑)批量删除邮件任务")
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(String[] emailIds, User user) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("ids", emailIds);
        map.put("account", user.getAccount());

        //批量删除一键Email
        emailMapper.deleteBatch(map);
        logger.info("[一键Email] 一键Email删除成功！,emailIds: {}", Arrays.toString(emailIds));

        //批量删除一键Email的接收人
        emailUserMapper.deleteBatch(map);
        logger.info("[一键Email] 一键Email邮件接收人删除成功！,emailIds: {}", Arrays.toString(emailIds));
    }

    /**
     * 附件批量上传
     *
     * @param files
     */
    @Override
    @ServiceLog(doAction = "附件批量上传")
    public String uploadAttachment(List<MultipartFile> files) {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                logger.warn("[一键Email] 附件上传失败");
                throw new JnSpringCloudException(EmailExceptionEnmus.FILE_IS_NULL);
            } else {
                //获取文件名称
                try {
                    Map<String, String> map = new HashMap<String, String>(16);
                    String title = file.getOriginalFilename();
                    //为了防止下载时名称重复，对文件名称做处理
                    String[] split = title.split("\\.");
                    String str = DateUtils.formatDate(new Date(), "yyyyMMddHHmmssSSS");
                    String fileName = split[0] + str + RandomStringUtils.random(4) + "." + split[1];

                    Result<String> result = uploadClient.uploadFile(file, false);
                    map.put("title", fileName);
                    map.put("url", result.getData());
                    list.add(map);
                } catch (IOException e) {
                    throw new JnSpringCloudException(EmailExceptionEnmus.UPLOAD_FILE_ERRPR);
                }
            }
        }

        //将集合转成json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String attachment = objectMapper.writeValueAsString(list);
            logger.info("[一键Email] 附件上传成功");
            return attachment;
        } catch (JsonProcessingException e) {
            logger.error("JsonProcessingException转换异常，附件上传失败失败。", e);
            throw new JnSpringCloudException(EmailExceptionEnmus.UPLOAD_FILE_ERRPR);
        }

    }

    /**
     * 附件下载
     *
     * @param downAttachment 附件下载实体
     * @param response
     * @return
     */
    @Override
    @ServiceLog(doAction = "附件下载")
    public ResponseEntity<byte[]> downLoadAttachment(DownAttachment downAttachment, HttpServletResponse response) {
        DownLoad downLoad = new DownLoad();
        downLoad.setUrl(downAttachment.getUrl());
        downLoad.setToken(false);
        response.setHeader("Content-Disposition", "attchement;filename=" + downAttachment.getTitle());
        ResponseEntity<byte[]> responseEntity = downLoadClient.downLoad(downLoad);
        return responseEntity;
    }

    /**
     * 修改一键Email信息
     *
     * @param emailAdd
     * @param user
     * @param tbOaEmail
     */
    private void updateEmail(EmailAdd emailAdd, User user, TbOaEmail tbOaEmail) {
        String emailId = tbOaEmail.getId();
        String userAccount = user.getAccount();
        //编辑操作
        String sendStatus = tbOaEmail.getSendStatus();

        Assert.notNull(emailId, OaExceptionEnums.ID_NOT_NULL.getMessage());
        Assert.notNull(sendStatus, EmailExceptionEnmus.SEND_STATUS_NOT_NULL.getMessage());

        //1.判断更新信息是否存在
        TbOaEmail tbOaEmail1 = tbOaEmailMapper.selectByPrimaryKey(emailId);
        if (tbOaEmail1 == null ||
                StringUtils.equals(OaStatusEnums.DELETED.getCode(), tbOaEmail1.getRecordStatus().toString())) {
            logger.warn("[一键Email] 修改失败,修改信息不存在,emailId:{}", tbOaEmail.getId());
            throw new JnSpringCloudException(OaExceptionEnums.UPDATEDATA_NOT_EXIST);
        }

        //2.保存修改数据
        tbOaEmail.setModifiedTime(new Date());
        tbOaEmail.setModifierAccount(userAccount);
        tbOaEmailMapper.updateByPrimaryKeySelective(tbOaEmail);
        logger.info("[一键Email] 修改成功,emailId:{}", emailId);

        //3.校验是否修改发送状态及定时操作
        checkDelay(tbOaEmail, tbOaEmail1);

        //4.删除一键Email接收人
        emailUserMapper.deleteBatchByEmaiilId(emailId, userAccount);

        //5.将编辑后的邮件接收人添加进数据库
        String[] userAccounts = emailAdd.getUserAccounts();
        insertEmailUser(emailId, userAccount, userAccounts);
    }

    /**
     * 校验是否修改发送状态及定时操作
     *
     * @param newTbOaEmail
     * @param oldTbOaEmail
     */
    private void checkDelay(TbOaEmail newTbOaEmail, TbOaEmail oldTbOaEmail) {
        String sendStatus = newTbOaEmail.getSendStatus();
        String isDelay = newTbOaEmail.getIsDelay();
        //判断是否将状态修改为未发送状态
        if (!StringUtils.equals(sendStatus, oldTbOaEmail.getSendStatus()) ||
                StringUtils.equals(sendStatus, EmailSendStatusEnums.NOT_SEND.getCode())) {
            //判断是否是定时发送
            if (StringUtils.equals(EmailIsDelayEnums.YES.getCode(), isDelay)) {
                //设置定时
                setDelay(newTbOaEmail);
            }
        } else if (StringUtils.equals(sendStatus, EmailSendStatusEnums.NOT_SEND.getCode())) {
            //判断是否修改定时
            if (!StringUtils.equals(isDelay, oldTbOaEmail.getIsDelay()) ||
                    StringUtils.equals(isDelay, EmailIsDelayEnums.YES.getCode())) {
                //设置定时
                setDelay(newTbOaEmail);
            } else if (StringUtils.equals(isDelay, EmailIsDelayEnums.YES.getCode())) {
                //判断是否修改发送时间
                Date sendTime = newTbOaEmail.getSendTime();
                if (sendTime != oldTbOaEmail.getSendTime()) {
                    setDelay(newTbOaEmail);
                }
            }
        }
    }

    /**
     * 添加一键Email
     *
     * @param emailAdd
     * @param user      当前用户
     * @param tbOaEmail
     */
    private void addEmail(EmailAdd emailAdd, User user, TbOaEmail tbOaEmail) {
        String emailId = emailAdd.getId();
        String isDelay = emailAdd.getIsDelay();
        String userAccount = user.getAccount();

        //设置发送状态为未发送,设置创建人,创建时间
        tbOaEmail.setSendStatus(EmailSendStatusEnums.NOT_SEND.getCode());
        tbOaEmail.setCreatorAccount(userAccount);
        tbOaEmail.setCreatedTime(new Date());
        tbOaEmail.setRecordStatus(new Byte(OaStatusEnums.EFFECTIVE.getCode()));

        //1.判断是否是定时发送
        if (StringUtils.equals(EmailIsDelayEnums.YES.getCode(), isDelay)) {
            //设置定时
            setDelay(tbOaEmail);
        } else {
            tbOaEmail.setDelaySendTime(null);
        }

        //2.将数保存至数据库
        tbOaEmailMapper.insertSelective(tbOaEmail);
        logger.info("[一键Email] 新增成功,emailId:{}", emailId);


        //3.保存邮件接收人数据
        String[] userAccounts = emailAdd.getUserAccounts();
        insertEmailUser(emailId, userAccount, userAccounts);


    }

    /**
     * 保存邮件接受人信息
     *
     * @param emailId      邮件任务id
     * @param userAccount  用户账号
     * @param userAccounts 接收人账号
     */
    private void insertEmailUser(String emailId, String userAccount, String[] userAccounts) {
        if (userAccounts.length > 0) {
            List<TbOaEmailUser> emailUserList = new ArrayList<>(16);
            for (String account : userAccounts) {
                TbOaEmailUser tbOaEmailUser = new TbOaEmailUser();
                tbOaEmailUser.setId(UUID.randomUUID().toString());
                tbOaEmailUser.setEmailId(emailId);
                tbOaEmailUser.setUserAccount(account);
                tbOaEmailUser.setCreatorAccount(userAccount);
                tbOaEmailUser.setRecordStatus(new Byte(OaStatusEnums.EFFECTIVE.getCode()));
                emailUserList.add(tbOaEmailUser);
            }
            emailUserMapper.insertBatch(emailUserList);
            logger.info("[一键Email] 邮件接收人信息新增成功,emailId:{}", emailId);
        } else {
            logger.warn("[一键Email] 添加失败,邮件收件人不能为空,emailId:{}", emailId);
            throw new JnSpringCloudException(EmailExceptionEnmus.RECIPIENTS_NOT_EMPTY);
        }
    }

    /**
     * 设置定时
     *
     * @param tbOaEmail
     */
    private void setDelay(TbOaEmail tbOaEmail) {
        String emailId = tbOaEmail.getId();
        Date delaySendTime = tbOaEmail.getDelaySendTime();
        Assert.notNull(delaySendTime, EmailExceptionEnmus.DELAY_SEND_TIME_NOT_NULL.getMessage());

        if (delaySendTime.before(new Date())) {
            logger.warn("[一键Email] 定时时间需要大于当前时间,emailId:{}", emailId);
            throw new JnSpringCloudException(EmailExceptionEnmus.DELAY_SEND_TIME_ERROR);
        }

        //调用延时接口,设置定时发送;
        Delay delay = new Delay();
        delay.setServiceId(OA_CLIENT);
        delay.setServiceUrl(OA_CLIENT_EMAIL_SERVICE);
        String delayTime = DateUtils.formatDate(delaySendTime, "yyyy-MM-dd HH:mm:ss");
        delay.setDateString(delayTime);

        //将参数转成字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String dataString = objectMapper.writeValueAsString(tbOaEmail);
            delay.setDataString(dataString);
        } catch (JsonProcessingException e) {
            logger.error("JsonProcessingException转换异常，定时任务调用失败。", e);
            throw new JnSpringCloudException(EmailExceptionEnmus.TIMING_FAILURE);
        }
        Result<Boolean> result = delaySendMessageClient.delaySend(delay);
        if (result.getData() != null && result.getData()) {
            logger.info("[一键Email] 为邮件设置定时发送,emailId:{},发送时间为delaySendendTime:{}", emailId, delayTime);
        } else {
            logger.error("[一键Email] 邮件任务定时设置失败,emailId:{}", emailId);
            throw new JnSpringCloudException(EmailExceptionEnmus.TIMING_FAILURE);
        }
    }
}
