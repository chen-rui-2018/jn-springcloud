package com.jn.park.activity.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.park.activity.dao.TbParkLikeMapper;
import com.jn.park.activity.entity.TbParkLikeCriteria;
import com.jn.park.comment.model.CommentAddParam;
import com.jn.park.comment.service.CommentService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.enums.CommentExceptionEnum;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.assertThat;

/**
 * 评论测试类
 * @Author: yangph
 * @Date: 2018/12/21 11:23
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudParkApplication.class})
public class CommentServiceImplTest {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);

    @Autowired
    private CommentService commentService;

    @Autowired
    private TbParkLikeMapper tbParkLikeMapper;


    /**
     * 活动id
     */
    private  String activityId;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 点赞状态  0：取消点赞   1：点赞
     */
    private String state;
    /**
     * 评论id
     */
    private String id;

    /**
     * 新增评论的传值信息
     */
    private CommentAddParam commentAddParam =new CommentAddParam();

    @Before
    public void setUp() throws Exception {
        //活动id/服务id
        commentAddParam.setRootId("4b761c29c00a49cdaa3c3d8d3bb0e440");
        //类型: 0:活动点评   1:服务点评
        commentAddParam.setComType("0");
        //点评ID/活动ID
        commentAddParam.setpId("ecfaffb2d2b24bfaa9b368e5f508b1ff");
        //评论内容
        commentAddParam.setComContent("测试评论的新增评论"+ DateUtils.getDate("yyyy-MM-dd HH:mm:ss"));
        //活动id
        activityId="4b761c29c00a49cdaa3c3d8d3bb0e440";
        //用户账号
        account="wangsong";
        //点赞状态
        state="1";
        //评论id
        id="cb9e41f3a0254d7687489303f7b37ce1";
    }

    /**
     * 活动评论/回复
     */
    @Test
    public void commentActivity() {
        try {
            commentService.commentActivity(commentAddParam, account);
            assertThat(anything(),anything());
        } catch (Exception e) {
            logger.info("活动评论/回复失败");
            assertThat(e.getMessage(),equalTo(CommentExceptionEnum.SENSITIVE_WORDS_IN_COMMENT.getMessage()));
        }
    }

    /**
     * 活动评论点赞
     */
    @Test
    public void commentActivityLike() {
        try {
            commentService.commentActivityLike(id, account);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("活动评论点赞失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ActivityExceptionEnum.APPLY_IS_NOT_EXIST.getCode()),
                            Matchers.containsString(CommentExceptionEnum.CURRENT_ACCOUNT_HAVE_LIKE.getCode()),
                            Matchers.containsString(CommentExceptionEnum.CURRENT_ACCOUNT_HAVE_CANCEL_LIKE.getCode())
                    ));
        }

    }

    /**
     * 活动评论取消点赞
     */
    @Test
    public void commentActivityCancelLike() {
        try {
            commentService.commentActivityCancelLike(id,account);
            assertThat(anything(),anything());
        } catch (JnSpringCloudException e) {
            logger.info("活动评论取消点赞失败");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(ActivityExceptionEnum.APPLY_IS_NOT_EXIST.getCode()),
                            Matchers.containsString(CommentExceptionEnum.CURRENT_ACCOUNT_HAVE_LIKE.getCode()),
                            Matchers.containsString(CommentExceptionEnum.CURRENT_ACCOUNT_HAVE_CANCEL_LIKE.getCode())
                    ));
        }

    }

    /**
     * 更新点赞状态
     */
    @Test
    public void updateParkLikeState() {
        commentService.updateParkLikeState(activityId,account,state);
        assertThat(anything(),anything());
    }

    /**
     * 新增点赞信息
     */
    @Test
    public void addActivityLike() {
        commentService.addActivityLike(activityId, account);
        assertThat(anything(),anything());
    }

    /**
     * 删除点赞信息
     */
    @Test
    public void delActivityLike(){
        TbParkLikeCriteria example=new TbParkLikeCriteria();
        example.createCriteria().andLikeParentIdEqualTo(activityId).andCreatorAccountEqualTo(account);
        tbParkLikeMapper.deleteByExample(example);
    }
}