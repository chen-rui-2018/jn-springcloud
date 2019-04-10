package com.jn.park.fileimg.service.impl;

import com.jn.park.feedback.service.impl.FeedbackServiceImpl;
import com.jn.park.fileimg.dao.FileImgMapper;
import com.jn.park.fileimg.entity.TbFileImg;
import com.jn.park.fileimg.model.FileImg;
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
 * @author： jiangyl
 * @date： Created on 2019/3/27 19:23
 * @version： v1.0
 * @modified By:
 */
@Service
public class FileImgServiceImpl implements FileImgService {
    private static Logger logger = LoggerFactory.getLogger(FileImgServiceImpl.class);

    @Autowired
    private FileImgMapper fileImgMapper;

    /**
     * 数据状态 有效
     */
    private final static String RECORD_STATUS_VALID = "1";

    @Override
    @ServiceLog(doAction = "保存图片信息")
    public int saveFileImgList(List<FileImg> fileImgs,String account,String topicId){
        List<TbFileImg> tbFileImgs = new ArrayList<>(16);
        for (FileImg fileImg : fileImgs
        ) {
            TbFileImg tbFileImg = new TbFileImg();
            BeanUtils.copyProperties(fileImg,tbFileImg);
            tbFileImg.setImgId(UUID.randomUUID().toString().replace("-",""));
            tbFileImg.setCreatedTime(new Date());
            tbFileImg.setCreatorAccount(account);
            tbFileImg.setTopicType("feedback");
            tbFileImg.setTopicId(topicId);
            tbFileImg.setRecordStatus(new Byte(RECORD_STATUS_VALID));
            tbFileImgs.add(tbFileImg);
        }
        int i = fileImgMapper.insertFileList(tbFileImgs);
        logger.info("插入问题反馈数据信息，响应结果条数 {}",i);
        return i;
    }
}
