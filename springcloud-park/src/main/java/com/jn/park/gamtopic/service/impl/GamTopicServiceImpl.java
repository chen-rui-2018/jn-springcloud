package com.jn.park.gamtopic.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.enums.GamTopicExceptionEnum;
import com.jn.park.feedback.model.FeedbackVO;
import com.jn.park.fileimg.dao.FileImgMapper;
import com.jn.park.fileimg.dao.TbFileImgMapper;
import com.jn.park.fileimg.entity.TbFileImg;
import com.jn.park.fileimg.entity.TbFileImgCriteria;
import com.jn.park.fileimg.model.FileImg;
import com.jn.park.fileimg.service.FileImgService;
import com.jn.park.gamtopic.dao.GamTopicMapper;
import com.jn.park.gamtopic.dao.TbGamTopicMapper;
import com.jn.park.gamtopic.entity.TbGamTopic;
import com.jn.park.gamtopic.entity.TbGamTopicCriteria;
import com.jn.park.gamtopic.model.GamTopic;
import com.jn.park.gamtopic.model.GamTopicParam;
import com.jn.park.gamtopic.model.GamTopicVO;
import com.jn.park.gamtopic.service.GamTopicService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/27 17:38
 * @version： v1.0
 * @modified By:
 */
@Service
public class GamTopicServiceImpl implements GamTopicService {
    private static Logger logger = LoggerFactory.getLogger(GamTopicServiceImpl.class);

    @Autowired
    private FileImgService fileImgService;
    @Autowired
    private TbGamTopicMapper tbGamTopicMapper;
    @Autowired
    private GamTopicMapper gamTopicMapper;
    @Autowired
    private TbFileImgMapper tbFileImgMapper;
    @Autowired
    private UserExtensionClient userExtensionClient;


    /**
     * 话题状态 1有效0无效
     */
    private final static String GAM_TOPIC_STATUS_IS_EFFECTIVE = "1";
    private final static String GAM_TOPIC_STATUS_IS_INVALID = "0";
    /**
     * 数据状态 有效
     */
    private final static String RECORD_STATUS_VALID = "1";

    @Override
    @ServiceLog(doAction = "新增话题")
    public int saveGamTopic(GamTopic gamTopic, String account){
        TbGamTopic tbGamTopic = new TbGamTopic();
        BeanUtils.copyProperties(gamTopic,tbGamTopic);
        tbGamTopic.setTopicId(UUID.randomUUID().toString().replace("-",""));
        tbGamTopic.setTopicStatus(GAM_TOPIC_STATUS_IS_EFFECTIVE);
        tbGamTopic.setCreatedTime(new Date());
        tbGamTopic.setCreatorAccount(account);
        tbGamTopic.setRecordStatus(new Byte(RECORD_STATUS_VALID));
        List<FileImg> imgs = gamTopic.getImgs();
        fileImgService.saveFileImgList(imgs, account, tbGamTopic.getTopicId());
        return tbGamTopicMapper.insert(tbGamTopic);
    }

    @Override
    @ServiceLog(doAction = "删除话题[当前接口]")
    public int deleteGamTopic(String topicId,String account){
        TbGamTopic tbGamTopic = tbGamTopicMapper.selectByPrimaryKey(topicId);
        if(null == tbGamTopic){
            throw new JnSpringCloudException(GamTopicExceptionEnum.USER_GAM_TOPIC_IS_NOT_EXIST);
        }
        if(!StringUtils.equals(tbGamTopic.getCreatorAccount(),account)){
            throw new JnSpringCloudException(GamTopicExceptionEnum.GAM_TOPIC_IS_NOT_NOW_USER);
        }
        tbGamTopic.setTopicStatus(GAM_TOPIC_STATUS_IS_INVALID);
        tbGamTopic.setModifiedTime(new Date());
        tbGamTopic.setModifierAccount(account);
        return tbGamTopicMapper.updateByPrimaryKeySelective(tbGamTopic);
    }

    @Override
    @ServiceLog(doAction = "获得当前用户话题列表")
    public PaginationData<List<GamTopicVO>> getMyGamTopicList(Page page, String account){
        Result<UserExtensionInfo> userResult = userExtensionClient.getUserExtension(account);
        String nikeName="";
        if(userResult.getData()!=null){
            nikeName = userResult.getData().getNickName();
        }
        GamTopicParam gamTopicParam = new GamTopicParam();
        gamTopicParam.setCreatorAcount(account);
        BeanUtils.copyProperties(page,gamTopicParam);
        PaginationData<List<GamTopicVO>> data = getGamTopicListByParam(gamTopicParam);
        List<GamTopicVO> list = data .getRows();
        if(list != null && !list.isEmpty()){
            for(GamTopicVO vo : list){
                vo.setNikeName(nikeName);
            }
        }
        data.setRows(list);
        return data;
    }

    @Override
    @ServiceLog(doAction = "根据条件查询用户话题列表[后台管理接口]")
    public PaginationData<List<GamTopicVO>> getGamTopicListByParam(GamTopicParam gamTopicParam){
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(gamTopicParam.getPage(), gamTopicParam.getRows() == 0 ? 15 : gamTopicParam.getRows());
        TbGamTopicCriteria topicCriteria = new TbGamTopicCriteria();
        TbGamTopicCriteria.Criteria criteria = topicCriteria.createCriteria();
        if(StringUtils.isNotEmpty(gamTopicParam.getCreatorAcount())){
            criteria.andCreatorAccountEqualTo(gamTopicParam.getCreatorAcount());
        }
        if(StringUtils.isNotEmpty(gamTopicParam.getTopicContent())){
            criteria.andTopicContentEqualTo(gamTopicParam.getTopicContent());
        }
        if(StringUtils.isNotEmpty(gamTopicParam.getTopicType())){
            criteria.andTopicTypeEqualTo(gamTopicParam.getTopicType());
        }
        List<GamTopicVO> gamTopicVOS = gamTopicMapper.getUserFeedbackList(gamTopicParam);

        List<String> ids = new ArrayList<>(16);
        for (GamTopicVO tppic: gamTopicVOS
        ) {
            ids.add(tppic.getTopicId());
        }
        if(ids != null && !ids.isEmpty()) {
            TbFileImgCriteria imgCriteria = new TbFileImgCriteria();
            imgCriteria.createCriteria().andTopicIdIn(ids);
            List<TbFileImg> tbFileImgs = tbFileImgMapper.selectByExample(imgCriteria);
            for (GamTopicVO tppic : gamTopicVOS
            ) {
                for (TbFileImg img : tbFileImgs
                ) {
                    if (StringUtils.equals(tppic.getTopicId(), img.getTopicId())) {
                        FileImg i = new FileImg();
                        BeanUtils.copyProperties(img, i);
                        List<FileImg> imgs = tppic.getImgs();
                        if (imgs != null) {
                            imgs.add(i);
                            tppic.setImgs(imgs);
                        } else {
                            List<FileImg> fl = new ArrayList<>(4);
                            fl.add(i);
                            tppic.setImgs(fl);
                        }
                    }
                }
            }
        }
        PaginationData<List<GamTopicVO>> data = new PaginationData(gamTopicVOS, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "删除用户话题数据[后台管理接口]")
    public int deleteGamTopicForAdmin(String topicId,String account){
        TbGamTopic tbGamTopic = tbGamTopicMapper.selectByPrimaryKey(topicId);
        if(null == tbGamTopic){
            throw new JnSpringCloudException(GamTopicExceptionEnum.USER_GAM_TOPIC_IS_NOT_EXIST);
        }
        tbGamTopic.setTopicStatus(GAM_TOPIC_STATUS_IS_INVALID);
        tbGamTopic.setModifiedTime(new Date());
        tbGamTopic.setModifierAccount(account);
        return tbGamTopicMapper.updateByPrimaryKeySelective(tbGamTopic);
    }

}
