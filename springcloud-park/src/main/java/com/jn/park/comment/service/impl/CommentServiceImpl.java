package com.jn.park.comment.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.common.util.cache.RedisCache;
import com.jn.park.comment.dao.TbCommentMapper;
import com.jn.park.comment.entity.TbComment;
import com.jn.park.comment.entity.TbCommentCriteria;
import com.jn.park.comment.model.CommentAdd;
import com.jn.park.comment.service.CommentService;
import com.jn.park.enums.CommentExceptionEnum;
import com.jn.park.utils.SensitiveWordUtil;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 评论/点评
 * @Author: yangph
 * @Date: 2018/12/11 10:51
 * @Version v1.0
 * @modified By:
 */
@Service
public class CommentServiceImpl implements CommentService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    private TbCommentMapper tbCommentMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Value(value = "${sensitive.word.key}")
    private String redisWordKey;

    @Value(value = "${sensitive.word.expire}")
    private int expire;

    @Value(value = "${sensitive.word.prefix}")
    private String prefix;

    /**
     * 活动评论/回复
     * @param commentAdd  点评信息   活动id,点评类型、点评内容
     * @param account     用户账号/点评人
     */
    @ServiceLog(doAction ="新增活动点评" )
    @Override
    public void commentActivity(CommentAdd commentAdd, String account) {
        //从redis中获取敏感词词库
        RedisCache cache = new RedisCache(redisTemplate, prefix, expire);
        List<String> wordList = ( List<String>) cache.get(redisWordKey);
        if(wordList==null){
            wordList=new ArrayList<>();
        }
        //判断敏感词条数是否为0条
        int wordNum=0;
        if(wordList.size()==wordNum){
            //若redis中没有，从数据库中获取词库
            //todo:从数据库中获取敏感词库数据
            wordList.add("太多");
            wordList.add("哈哈");
            wordList.add("发呆");
            //把数据库获取词库写入redis中
            cache.put(redisWordKey, wordList);
        }
        //初始化敏感词库
        Set<String> sensitiveWordSet = new HashSet<>();
        for(String word:wordList){
            sensitiveWordSet.add(word);
        }
        SensitiveWordUtil.init(sensitiveWordSet);
        //判断是否有敏感词
        boolean result = SensitiveWordUtil.contains(commentAdd.getComContent());
        if(result){
            logger.info("评论中有敏感词，不允许新增");
            throw new JnSpringCloudException(CommentExceptionEnum.SENSITIVE_WORDS_IN_COMMENT);
        }
        //新增活动点评
        addActivityComment(commentAdd, account);
    }

    /**
     * 活动评论点赞
     * @param commentAdd 点评信息   活动id,点评类型、
     * @param account    用户账号/点评人
     */
    @Override
    public void commentActivityLike(CommentAdd commentAdd, String account) {
        //根据点评id/活动id和点评人获取点评获赞数
        TbCommentCriteria example =new TbCommentCriteria();
        example.createCriteria().andIdEqualTo(commentAdd.getId());
        //在原有的点赞数上加1
        long likeNum = tbCommentMapper.countByExample(example)+1;
        TbComment tbComment=new TbComment();
        tbComment.setLikeNum((int)likeNum);
        tbCommentMapper.updateByExampleSelective(tbComment, example);
    }

    /**
     * 新增活动点评
     * @param commentAdd 点评信息
     * @param account    用户账号
     */
    private void addActivityComment(CommentAdd commentAdd, String account) {
        TbComment tbComment=new TbComment();
        //id
        tbComment.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //点评父标识（点评ID/活动id）
        tbComment.setpId(commentAdd.getId());
        //点评人
        tbComment.setComAccount(account);
        //点评时间
        tbComment.setComTime(DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd HH:mm:ss")));
        //点评获赞数 ,新增点评的获赞数为0
        int num=0;
        tbComment.setLikeNum(num);
        //点评状态 0:无效  1：有效 新增点评的状态为有效
        String state="1";
        tbComment.setState(state);
        //点评类型
        tbComment.setComType(commentAdd.getComType());
        //点评内容
        tbComment.setComContent(commentAdd.getComContent());

        tbCommentMapper.insertSelective(tbComment);
    }
}
