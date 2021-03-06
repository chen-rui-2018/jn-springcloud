package com.jn.system.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dept.entity.TbSysPost;
import com.jn.system.model.SysPost;
import com.jn.system.dept.model.SysPostPage;
import com.jn.system.dept.service.SysPostService;
import com.jn.system.model.User;
import org.apache.commons.lang.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SysPostServiceTest {

    @Autowired
    public SysPostService sysPostService;

    //岗位id
    private static String postId;
    //岗位名称
    private static String postName;
    //创建者
    private static User user;
    //岗位对象
    private static TbSysPost tbSysPost;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("10000");

        //初始化岗位id及岗位名称
        postId = UUID.randomUUID().toString();
        postName = "测试岗位" + RandomStringUtils.randomNumeric(4);

        //初始化岗位对象
        tbSysPost = new TbSysPost();
        tbSysPost.setId(postId);
        tbSysPost.setCreatorAccount(user.getAccount());
        tbSysPost.setCreatedTime(new Date());
        tbSysPost.setPostTypeId(UUID.randomUUID().toString());
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        tbSysPost.setRecordStatus(recordStatus);
        tbSysPost.setPostName(postName);
    }

    @Test
    public void addPost() {
        try {
            sysPostService.addPost(tbSysPost);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void findSysPostAll() {
        List<SysPost> data = sysPostService.findSysPostAll();
        Assert.assertThat(data, Matchers.anything());
    }


    @Test
    public void updatePost() {
        SysPost post = new SysPost();
        post.setId(postId);
        post.setPostName(postName);
        Byte recordStatus = Byte.parseByte(SysStatusEnums.INVALID.getCode());
        post.setRecordStatus(recordStatus);
        try {
            sysPostService.updatePost(post,user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void selectByPrimaryKey() {
        SysPost data = sysPostService.selectByPrimaryKey(postId);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void findByPage() {
        SysPostPage page = new SysPostPage();
        page.setPage(1);
        page.setRows(10);
        PaginationData data = sysPostService.findByPage(page);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void checkPostName() {
        String result = sysPostService.checkPostName(postName);
        Assert.assertThat(result, Matchers.anyOf(Matchers.equalTo(SysReturnMessageEnum.FAIL.getMessage()),
                Matchers.equalTo(SysReturnMessageEnum.SUCCESS.getMessage())));
    }

    @Test
    public void zDeletePostBranch() {
        String[] postIds = {postId};
        sysPostService.deletePostBranch(postIds,user);
    }

}
