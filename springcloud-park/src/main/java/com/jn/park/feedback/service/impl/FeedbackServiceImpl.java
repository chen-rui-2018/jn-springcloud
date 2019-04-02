package com.jn.park.feedback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.park.feedback.dao.FeedbackMapper;
import com.jn.park.feedback.dao.TbUserFeedbackMapper;
import com.jn.park.feedback.entity.TbUserFeedback;
import com.jn.park.feedback.model.Feedback;
import com.jn.park.feedback.model.FeedbackParam;
import com.jn.park.feedback.model.FeedbackVO;
import com.jn.park.fileimg.model.FileImg;
import com.jn.park.feedback.service.FeedbackService;
import com.jn.park.fileimg.dao.FileImgMapper;
import com.jn.park.fileimg.entity.TbFileImg;
import com.jn.park.fileimg.service.FileImgService;
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
 * 用户反馈信息
 * @author： jiangyl
 * @date： Created on 2019/3/27 14:30
 * @version： v1.0
 * @modified By:
 */

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private static Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);
    /**
     * 数据状态 有效
     */
    private final static String RECORD_STATUS_VALID = "1";

    @Autowired
    private TbUserFeedbackMapper tbUserFeedbackMapper;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private FileImgService fileImgService;

    @Override
    @ServiceLog(doAction = "保存用户反馈信息")
    public int saveFeedback(Feedback feedback, String account){
        TbUserFeedback tbUserFeedback = new TbUserFeedback();
        BeanUtils.copyProperties(feedback,tbUserFeedback);
        tbUserFeedback.setFeedId(UUID.randomUUID().toString().replace("-",""));
        tbUserFeedback.setCreatedTime(new Date());
        tbUserFeedback.setCreatorAccount(account);
        tbUserFeedback.setRecordStatus(new Byte(RECORD_STATUS_VALID));
        List<FileImg> fileImgs = feedback.getFileImgs();
        fileImgService.saveFileImgList(fileImgs, account, tbUserFeedback.getFeedId());
        return tbUserFeedbackMapper.insert(tbUserFeedback);
    }

    @Override
    @ServiceLog(doAction = "获取反馈问题列表[后台管理接口]")
    public PaginationData<List<FeedbackVO>> getUserFeedbackList(FeedbackParam feedbackParam){
        Page<Object> objects = PageHelper.startPage(feedbackParam.getPage(), feedbackParam.getRows() == 0 ? 15 : feedbackParam.getRows());
        List<FeedbackVO> userFeedbackList = feedbackMapper.getUserFeedbackList(feedbackParam);
        PaginationData<List<FeedbackVO>> data = new PaginationData(userFeedbackList, objects.getTotal());
        return data;
    }

}
