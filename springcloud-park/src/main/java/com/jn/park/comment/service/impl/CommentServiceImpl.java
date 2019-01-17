package com.jn.park.comment.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import com.jn.park.activity.dao.TbParkLikeMapper;
import com.jn.park.activity.entity.TbParkLike;
import com.jn.park.activity.entity.TbParkLikeCriteria;
import com.jn.park.comment.dao.TbCommentMapper;
import com.jn.park.comment.entity.TbComment;
import com.jn.park.comment.entity.TbCommentCriteria;
import com.jn.park.comment.model.CommentAdd;
import com.jn.park.comment.service.CommentService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.enums.CommentExceptionEnum;
import com.jn.park.utils.SensitiveWordUtil;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private TbParkLikeMapper tbParkLikeMapper;

    @Autowired
    private RedisCacheFactory redisCacheFactory;
    /**
     * 时间格式
     */
    private static final String TIME_FORMAT="yyyy-MM-dd HH:mm:ss";

    /**
     * 点赞状态：1:点赞
     */
    private static final String PARK_LIKE_STATE="1";
    /**
     * 点赞状态：0:取消点赞
     */
    private static final String PARK_CANCEL_LIKE_STATE="0";

    /**
     * 敏感词redis组名
     */
    private static final String SENSITIVE_WORD_CACHE="sensitive_word_cache";
    /**
     * 敏感词redis的key
     */
    private static final String SENSITIVE_WORD="sensitive_word";

    @Value(value = "${sensitive.word.expire}")
    private int expire;


    /**
     * 活动评论/回复
     * @param commentAdd  点评信息   活动id,点评类型、点评内容
     * @param account     用户账号/点评人
     */
    @ServiceLog(doAction ="新增活动点评" )
    @Override
    public void commentActivity(CommentAdd commentAdd, String account) {
        //从redis中获取敏感词词库
        Cache<Object> cache = redisCacheFactory.getCache(SENSITIVE_WORD_CACHE, expire);
        List<String> wordList = ( List<String>) cache.get(SENSITIVE_WORD);
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
            cache.put(SENSITIVE_WORD, wordList);
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
     * @param id         点评ID/活动ID
     * @param account    用户账号/点评人
     */
    @ServiceLog(doAction = "活动评论点赞")
    @Override
    public void commentActivityLike(String  id,String account) {
        //状态为点赞  0：取消点赞  1：点赞
        String state="1";
        updateApplyLikeNumAndParkLikeInfo(id, account, state);

    }

    /**
     * 活动评论取消点赞
     * @param id         点评ID/活动ID
     * @param account    用户账号/点评人
     */
    @ServiceLog(doAction = "活动评论取消点赞")
    @Override
    public void commentActivityCancelLike(String id,String account) {
        //状态为点赞  0：取消点赞  1：点赞
        String state="0";
        updateApplyLikeNumAndParkLikeInfo(id, account, state);
    }

    /**
     * 更新点评表操作数和点赞表信息
     * @param id        点评id/点赞父id
     * @param account   用户账号
     * @param state     点赞状态   0：取消点赞   1：点赞
     */
    @ServiceLog(doAction = "更新点评表操作数和点赞表信息")
    private void updateApplyLikeNumAndParkLikeInfo(String id, String account, String state) {
        //查询点评表，判断点赞的活动、评论或服务存在
        //根据活动、评论、服务id以及点评状态为有效查询点评信息
        TbCommentCriteria example=new TbCommentCriteria();
        //有效点评状态
        String applyState="1";
        example.createCriteria().andIdEqualTo(id).andStatusEqualTo(applyState);
        List<TbComment> commentList = tbCommentMapper.selectByExample(example);
        if(commentList==null || commentList.isEmpty()){
            throw new JnSpringCloudException(ActivityExceptionEnum.APPLY_IS_NOT_EXIST);
        }
        //查询园区点赞表（tb_park_like），根据活动id/评论id,用户判断是否存在点赞信息
        TbParkLikeCriteria existExample=new TbParkLikeCriteria();
        existExample.createCriteria().andLikeParentIdEqualTo(id).andLikeAccountEqualTo(account);
        long existLikeNum = tbParkLikeMapper.countByExample(existExample);
        //查询园区点赞表（tb_park_like），根据活动id/评论id,用户以及状态为点赞来判断是否已点赞/取消点赞
        TbParkLikeCriteria optionLikeExample=new TbParkLikeCriteria();
        optionLikeExample.createCriteria().andLikeParentIdEqualTo(id).andLikeAccountEqualTo(account).andStatusEqualTo(state);
        long optionLikeNum = tbParkLikeMapper.countByExample(optionLikeExample);
        //已点赞/已取消点赞，不做操作
        if(optionLikeNum>0){
            //ignore
        }else if(existLikeNum>0){
            //当前活动、评论、服务存在当前用户的点赞信息，更新点赞表点赞状态
            updateParkLikeState(id, account, state);
            //若是点赞，点评表对应活动、评论、服务的点赞数加1，否则点赞数减1
            updateApplyLikeNum(id, applyState, commentList, state);
        }else{
            //没有点过赞，点赞表新增点赞
            addActivityLike(id,account);
            //评论表新增点评获赞数
            String addState="1";
            updateApplyLikeNum(id, applyState, commentList, addState);
        }
    }

    /**
     * 更新点评表点评获赞数
     * @param id            当前活动、评论、服务的id(非pid)
     * @param applyState    有效点评装填  0：无效  1：有效
     * @param commentList   点评信息
     * @param state         点赞状态  0：取消点赞  1：点赞
     */
    @ServiceLog(doAction = "更新点评表点评获赞数")
    private void updateApplyLikeNum(String id,String applyState,List<TbComment> commentList, String state) {
        TbComment tbComment = commentList.get(0);
        //若是点赞标志，若是点赞加1，否则减1
        String addFlag="1";
        int likeNum=state.equals(addFlag)?1:-1;
        tbComment.setLikeNum(tbComment.getLikeNum()+likeNum);
        TbCommentCriteria example=new TbCommentCriteria();
        example.createCriteria().andIdEqualTo(id).andStatusEqualTo(applyState);
        tbCommentMapper.updateByExampleSelective(tbComment, example);
    }

    /**
     * 新增活动点评
     * @param commentAdd 点评信息
     * @param account    用户账号
     */
    @ServiceLog(doAction = "新增活动点评")
    private void addActivityComment(CommentAdd commentAdd, String account) {
        TbComment tbComment=new TbComment();
        //id
        tbComment.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //根节点id  活动id/服务id
        tbComment.setRootId(commentAdd.getRootId());
        //点评父标识（点评ID/活动id）
        tbComment.setpId(commentAdd.getpId());
        //点评人
        tbComment.setComAccount(account);
        //点评状态 0:无效  1：有效 新增点评的状态为有效
        String state="1";
        tbComment.setStatus(state);
        //根据点评父id得到被点评人
        TbCommentCriteria example=new TbCommentCriteria();
        example.createCriteria().andIdEqualTo(commentAdd.getpId()).andStatusEqualTo(state);
        List<TbComment> commentList = tbCommentMapper.selectByExample(example);
        if(commentList!=null && !commentList.isEmpty()){
            //把被点评信息的点评人设置为当前信息的被点评人
            tbComment.setParentAccount(commentList.get(0).getComAccount());
        }
        //点评时间
        tbComment.setComTime(DateUtils.parseDate(DateUtils.getDate(TIME_FORMAT)));
        //点评获赞数 ,新增点评的获赞数为0
        int num=0;
        tbComment.setLikeNum(num);
        //点评类型
        tbComment.setComType(commentAdd.getComType());
        //点评内容
        tbComment.setComContent(commentAdd.getComContent());

        tbCommentMapper.insertSelective(tbComment);
    }


    /**
     * 更新点赞状态
     * @param likeParentId  点赞父id
     * @param account       用户账号
     * @param state         点赞状态  0：取消点赞   1：点赞
     */
    @ServiceLog(doAction = "更新点赞状态")
    @Override
    public void updateParkLikeState(String likeParentId, String account, String state) {
        if( !StringUtils.equals(PARK_LIKE_STATE, state) && !StringUtils.equals(PARK_CANCEL_LIKE_STATE, state)){
            throw new JnSpringCloudException(ActivityExceptionEnum.LIKE_STATE_NOT_ALLOW);
        }
        TbParkLikeCriteria example=new TbParkLikeCriteria();
        example.createCriteria().andLikeParentIdEqualTo(likeParentId).andLikeAccountEqualTo(account);
        TbParkLike tbParkLike=new TbParkLike();
        //状态
        tbParkLike.setStatus(state);
        //点赞时间
        tbParkLike.setLikeTime(DateUtils.parseDate(DateUtils.getDate(TIME_FORMAT)));
        tbParkLikeMapper.updateByExampleSelective(tbParkLike, example);
    }

    /**
     * 新增点赞信息
     * @param activityId 活动id
     * @param account    用户账号
     */
    @ServiceLog(doAction = "新增点赞信息")
    @Override
    public void addActivityLike(String activityId, String account) {
        TbParkLike parkLike=new TbParkLike();
        //点赞id
        parkLike.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //点赞父id
        parkLike.setLikeParentId(activityId);
        //点赞人
        parkLike.setLikeAccount(account);
        //点赞时间
        parkLike.setLikeTime(DateUtils.parseDate(DateUtils.getDate(TIME_FORMAT)));
        //状态 0：取消点赞  1：点赞
        String likeState="1";
        parkLike.setStatus(likeState);
        tbParkLikeMapper.insertSelective(parkLike);
    }
}
