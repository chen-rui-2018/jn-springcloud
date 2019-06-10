package com.jn.park.gamtopic.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.comment.dao.TbCommentMapper;
import com.jn.park.enums.GamTopicExceptionEnum;
import com.jn.park.fileimg.dao.TbFileImgMapper;
import com.jn.park.fileimg.entity.TbFileImg;
import com.jn.park.fileimg.entity.TbFileImgCriteria;
import com.jn.park.fileimg.model.FileImg;
import com.jn.park.gamtopic.dao.TbGamTopicMapper;
import com.jn.park.gamtopic.model.*;
import com.jn.park.gamtopic.service.DynamicService;
import com.jn.park.gamtopic.vo.DnnamicCommentDetailsVo;
import com.jn.park.gamtopic.vo.DynamicWebDetailsVo;
import io.swagger.annotations.ApiModelProperty;
import org.hamcrest.Matchers;
import org.hibernate.validator.constraints.NotBlank;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * @author： chenr
 * @date： Created on 2019/4/13 9:16
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudParkApplication.class})
@FixMethodOrder(MethodSorters.JVM)
public class DynamicServiceImplTest {
    /**
     * 日志组件
     */
    Logger  logger = LoggerFactory.getLogger(DynamicServiceImplTest.class);

    private String  dynamicId;
    private String commentId;
    private String  account;
    private DynamicAddParam dynamicAddParam;
    private List<FileImg> imgs;
    private  FileImg img ;

    private DynamicQueryParam queryParam;
    private Page page;

    private DynamicCommentsParam  commentsParam;

    @Autowired
    private DynamicService dynamicService;
    @Autowired
    private TbCommentMapper  tbCommentMapper;
    @Autowired
    private TbFileImgMapper tbFileImgMapper;
    @Autowired
    private TbGamTopicMapper tbGamTopicMapper;






    @Before
    public void setUp() throws Exception {
        dynamicId ="ebf75324ccbe4614afbad37ca920aa08";
        account  = "wangsong";
        List<FileImg> imgs = new ArrayList<>();
        img = new FileImg();
        img.setImgUrl("http://123456797.jpg");
        imgs.add(img);
        //发布动态
        dynamicAddParam = new DynamicAddParam();
        dynamicAddParam.setAddress("长沙麓谷");
        dynamicAddParam.setIdentity("0");
        dynamicAddParam.setTopicContent("人生就有许多这样的奇迹，看似比登天还难的事...");
        dynamicAddParam.setTopicType("1");
        dynamicAddParam.setLongitude("55.5555");
        dynamicAddParam.setLatitude("66.6666");
        dynamicAddParam.setImgs(imgs);
        //后台动态列表查询
        queryParam = new DynamicQueryParam();
        queryParam.setStartTime("2019-04-03");
        queryParam.setEndTime("2019-04-30");
        queryParam.setNickName("");
        queryParam.setPhone("");
        //分页bean
        page = new Page();
        page.setPage(0);
        page.setRows(15);
        //评论查找入参
        commentsParam = new DynamicCommentsParam();
        commentsParam.setParamId(dynamicId);
        commentsParam.setPage(1);
        commentsParam.setRows(15);

        commentId = "fdc46ece154f43648fc278a80b904xxx";
    }

    /**
     * 发布动态
     */
    @Test
    public void addDynamicInfo() {

        try{
            int i =  dynamicService.addDynamicInfo(dynamicAddParam,dynamicId,account);
            assertThat(i,is(1));
        }catch (JnSpringCloudException e){
            logger.warn("新增动态异常",e);
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(GamTopicExceptionEnum.DYNAMIC_CONTENT_IS_NULL.getCode())
                    ));
        }
    }

    /**
     * 后台动态列表查询
     */
    @Test
    public void findDynamicList() {
            PaginationData<List<DynamicManageShow>> data  =  dynamicService.findDynamicList(queryParam);
            assertThat((int)data.getTotal(),greaterThanOrEqualTo(0));
    }
    /**
     * 后台动态详情查看
     */
    @Test
    public void findDynamicDetails() {
        DynamicManageDetails details =  dynamicService.findDynamicDetails(dynamicId);
        assertThat(anything(),anything());
    }

    /**
     * 后台动态删除
     */
    @Test
    public void deleteDynamicInfo() {
        try{
            int i =  dynamicService.deleteDynamicInfo(dynamicId,account);
            assertThat(i,is(1));
        }catch (JnSpringCloudException e){
            logger.warn("删除动态异常",e);
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(GamTopicExceptionEnum.DYNAMIC_CONTENT_IS_NULL.getCode())
                    ));
        }
    }

    /**
     * 查看前台动态列表
     */
    @Test
    public void findDynamicWebList() {
        PaginationData<List<DynamicWebShow>> list =  dynamicService.findDynamicWebList(page,account);
        assertThat((int)list.getTotal(),greaterThanOrEqualTo(0));
    }

    /**
     *
     */
    @Test
    public void findDynamicWebDetails() {
        DynamicWebDetailsVo vo =  dynamicService.findDynamicWebDetails(dynamicId,account);
        assertThat(anything(),anything());
    }

    /**
     * 动态评论列表查询
     */
    @Test
    public void findDynamicComments() {
      PaginationData<List<DynamicComments>> list =   dynamicService.findDynamicComments(commentsParam);
        assertThat((int)list.getTotal(),greaterThanOrEqualTo(0));
    }

    /**
     * 评论详情
     */
    @Test
    public void findDynamicCommentsDetails() {
        DnnamicCommentDetailsVo vo =   dynamicService.findDynamicCommentsDetails(commentId);
        assertThat(anything(),anything());
    }

    /**
     * 评论回复列表
     */
    @Test
    public void findCommentReplyList() {
        commentsParam.setParamId(commentId);
        PaginationData<List<DynamicComments>> list =  dynamicService.findCommentReplyList(commentsParam);
        assertThat((int)list.getTotal(),greaterThanOrEqualTo(0));
    }

    @Test
    public void findLikedUserInfoList() {
        commentsParam.setParamId(commentId);
        PaginationData<List<LikedUserInfo>> list =  dynamicService.findLikedUserInfoList(commentsParam);
        assertThat((int)list.getTotal(),greaterThanOrEqualTo(0));
    }
    @Test
    public void zDelete() {
       tbGamTopicMapper.deleteByPrimaryKey(dynamicId);
        TbFileImgCriteria criteria = new TbFileImgCriteria();
        criteria.createCriteria().andTopicIdEqualTo(dynamicId);
        tbFileImgMapper.deleteByExample(criteria);

    }

}