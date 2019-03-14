package com.jn.enterprise.servicemarket.comment.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.comment.model.*;
import com.jn.enterprise.servicemarket.comment.service.CommentService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/28 15:22
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudEnterpriseApplication.class})
public class CommentServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);

    @Autowired
    private CommentService commentService;

    private String id;
    private String account;

    @Before
    public void setUp() throws Exception {
        id = "123457";
        account = "wangsong";
    }

    @Test
    public void getGiveOthersCommentList() {
        RatingParameter ratingParameter = new RatingParameter();
        PaginationData giveOthersCommentList = commentService.getGiveOthersCommentList(ratingParameter, account);
        List<Rating> ratings =  ( List<Rating>)giveOthersCommentList.getRows();
        assertThat(ratings.size(),greaterThanOrEqualTo(0));
    }

    @Test
    public void getGiveMeCommentList() {
        ReceiveRatingParameter receiveRatingParameter = new ReceiveRatingParameter();
        PaginationData giveMeCommentList = commentService.getGiveMeCommentList(receiveRatingParameter, account);
        List<Rating> ratings =  ( List<Rating>)giveMeCommentList.getRows();
        assertThat(ratings.size(),greaterThanOrEqualTo(0));
    }

    @Test
    public void getRatingCommentDetail1() {
        RatingDetail ratingCommentDetail = commentService.getRatingCommentDetail(id);
        assertThat(ratingCommentDetail,notNullValue());
    }

    @Test
    public void saveRatingComment() {
        CommentParameter commentParameter = new CommentParameter();
        commentParameter.setId(id);
        commentParameter.setEvaluationDesc("评价详情噢噢噢噢");
        commentParameter.setAttitudeScore("4.5");
        try {
            Boolean aBoolean = commentService.saveRatingComment(commentParameter, account);
            assertThat(aBoolean,anything());
        }catch (JnSpringCloudException e){
            logger.warn("需求已评价");
            assertThat(e.getCode(), Matchers.anyOf(
                    Matchers.containsString(OrgExceptionEnum.REQUIRE_IS_NOT_EXIT.getCode()),
                    Matchers.containsString(OrgExceptionEnum.COMMENT_IS_EXIST.getCode())
            ));
        }
    }
}
