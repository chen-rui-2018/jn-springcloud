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
import com.jn.park.comment.dao.TbCommentSensitiveWordMapper;
import com.jn.park.comment.entity.TbComment;
import com.jn.park.comment.entity.TbCommentCriteria;
import com.jn.park.comment.entity.TbCommentSensitiveWord;
import com.jn.park.comment.entity.TbCommentSensitiveWordCriteria;
import com.jn.park.activity.model.CommentAddParam;
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
    private TbCommentSensitiveWordMapper tbCommentSensitiveWordMapper;

    @Autowired
    private RedisCacheFactory redisCacheFactory;

    /**
     * 删除状态 0：已删除   1：有效
     */
    private static final byte RECORD_STATUS=1;

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
     * 新增评论/回复
     * @param commentAddParam  点评信息   活动id,点评类型、点评内容
     */
    @ServiceLog(doAction ="新增评论/回复" )
    @Override
    public void commentActivity(CommentAddParam commentAddParam) {
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
            TbCommentSensitiveWordCriteria example=new TbCommentSensitiveWordCriteria();
            //敏感词分类（0：评论敏感词   1：其他敏感词）
            example.createCriteria().andSensitiveTypeEqualTo("0").andRecordStatusEqualTo(RECORD_STATUS);
            List<TbCommentSensitiveWord> tbCommentSensitiveWordList = tbCommentSensitiveWordMapper.selectByExample(example);
            for(TbCommentSensitiveWord tbCommentSensitiveWord:tbCommentSensitiveWordList){
                wordList.add(tbCommentSensitiveWord.getSensitiveWord());
            }
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
        boolean result = SensitiveWordUtil.contains(commentAddParam.getComContent());
        if(result){
            logger.info("评论中有敏感词，不允许新增");
            throw new JnSpringCloudException(CommentExceptionEnum.SENSITIVE_WORDS_IN_COMMENT);
        }
        //新增点评
        addActivityComment(commentAddParam, commentAddParam.getAccount());
    }

    /**
     * 评论点赞
     * @param id         点评ID/活动ID
     * @param account    用户账号/点评人
     */
    @ServiceLog(doAction = "评论点赞")
    @Override
    public void commentActivityLike(String  id,String account) {
        //状态为点赞  0：取消点赞  1：点赞
        String state="1";
        updateApplyLikeNumAndParkLikeInfo(id, account, state);

    }

    /**
     * 评论取消点赞
     * @param id         点评ID/活动ID
     * @param account    用户账号/点评人
     */
    @ServiceLog(doAction = "评论取消点赞")
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
        example.createCriteria().andIdEqualTo(id).andComStatusEqualTo(applyState).andRecordStatusEqualTo(RECORD_STATUS);
        List<TbComment> commentList = tbCommentMapper.selectByExample(example);
        if(commentList==null || commentList.isEmpty()){
            throw new JnSpringCloudException(ActivityExceptionEnum.APPLY_IS_NOT_EXIST);
        }
        //查询园区点赞表（tb_park_like），根据活动id/评论id,用户判断是否存在点赞信息
        TbParkLikeCriteria existExample=new TbParkLikeCriteria();
        existExample.createCriteria().andLikeParentIdEqualTo(id).andCreatorAccountEqualTo(account).andRecordStatusEqualTo(RECORD_STATUS);
        long existLikeNum = tbParkLikeMapper.countByExample(existExample);
        //查询园区点赞表（tb_park_like），根据活动id/评论id,用户以及状态为点赞,删除状态为未删除来判断是否已点赞/取消点赞
        TbParkLikeCriteria optionLikeExample=new TbParkLikeCriteria();
        optionLikeExample.createCriteria().andLikeParentIdEqualTo(id).andCreatorAccountEqualTo(account).andLikeStatusEqualTo(state).andRecordStatusEqualTo(RECORD_STATUS);
        long optionLikeNum = tbParkLikeMapper.countByExample(optionLikeExample);
        //已点赞/已取消点赞，不做操作
        if(optionLikeNum>0){
            if(Integer.parseInt(state)>0){
                logger.warn("当前用户已点赞，请勿重复操作");
                throw new JnSpringCloudException(CommentExceptionEnum.CURRENT_ACCOUNT_HAVE_LIKE);
            }else{
                logger.warn("当前用户已取消点赞，请勿重复操作");
                throw new JnSpringCloudException(CommentExceptionEnum.CURRENT_ACCOUNT_HAVE_CANCEL_LIKE);
            }
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
     * @param applyState    有效点评状态  0：无效  1：有效
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
        example.createCriteria().andIdEqualTo(id).andComStatusEqualTo(applyState);
        tbCommentMapper.updateByExampleSelective(tbComment, example);
    }


    /**
     * 新增点评
     * @param commentAddParam 点评信息
     * @param account    用户账号
     */
    @ServiceLog(doAction = "新增点评")
    private void addActivityComment(CommentAddParam commentAddParam, String account) {
        TbComment tbComment=new TbComment();
        //id
        tbComment.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //根节点id  活动id/服务id/话题id
        tbComment.setRootId(commentAddParam.getRootId());
        //点评父标识（点评ID/活动id）
        tbComment.setpId(commentAddParam.getpId());
        //点评人
        tbComment.setCreatorAccount(account);
        //点评状态 0:无效  1：有效 新增点评的状态为有效
        String state="1";
        tbComment.setComStatus(state);
        //根据点评父id得到被点评人
        TbCommentCriteria example=new TbCommentCriteria();
        example.createCriteria().andIdEqualTo(commentAddParam.getpId()).andComStatusEqualTo(state);
        List<TbComment> commentList = tbCommentMapper.selectByExample(example);
        if(commentList!=null && !commentList.isEmpty()){
            //把被点评信息的点评人设置为当前信息的被点评人
            tbComment.setParentAccount(commentList.get(0).getCreatorAccount());
        }
        //点评时间
        tbComment.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(TIME_FORMAT)));
        //点评获赞数 ,新增点评的获赞数为0
        int num=0;
        tbComment.setLikeNum(num);
        //点评类型
        tbComment.setComType(commentAddParam.getComType());
        //点评内容
        tbComment.setComContent(commentAddParam.getComContent());
        tbComment.setRecordStatus(RECORD_STATUS);
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
        example.createCriteria().andLikeParentIdEqualTo(likeParentId).andCreatorAccountEqualTo(account);
        TbParkLike tbParkLike=new TbParkLike();
        //状态
        tbParkLike.setLikeStatus(state);
        //点赞时间
        tbParkLike.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(TIME_FORMAT)));
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
        parkLike.setCreatorAccount(account);
        //点赞时间
        parkLike.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(TIME_FORMAT)));
        //状态 0：取消点赞  1：点赞
        String likeState="1";
        parkLike.setLikeStatus(likeState);
        parkLike.setRecordStatus(RECORD_STATUS);
        tbParkLikeMapper.insertSelective(parkLike);
    }
}
