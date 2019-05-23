package com.jn.park.sp.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.sp.model.SpDictDepartModel;
import com.jn.park.sp.model.SpMessageModel;
import com.jn.park.sp.service.SpPowerPortalService;
import com.jn.park.sp.vo.SpPowerBusiDetailVo;
import com.jn.park.sp.vo.SpPowerDetailVo;
import com.jn.system.model.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 *
 *
 * @author： zhuyz
 * @date： Created on 2019/3/28 11:34
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpPowerPortalServiceImplTest {

    @Autowired
    private SpPowerPortalService spPowerPortalService;

    //权力id
    private static String id;
    //业务id
    private static String busiId;
    //实施部门名称
    private static String busiName;

    //权力编码
    private static String code;
    //实施部门id
    private static String departId;
    //权力名称
    private static String name;
    //父节点id
    private static String parentId;
    //权力类型
    private static String type;
    //分页对象
    private static Page page;
    //留言
    private static SpMessageModel spMessageModel;
    //创建者
    private static User user;

    @BeforeClass
    public static void init(){
        //初始化
        id = "1";
        busiId = "559447847364198400";
        busiName = "秦淮区";
        name = "危险";
        page = new Page();

        //初始化模块
        user = new User();
        user.setId("10000");
        user.setAccount("wangsong");

        //初始化留言信息
        spMessageModel = new SpMessageModel();
        spMessageModel.setId(UUID.randomUUID().toString());
        spMessageModel.setCompanyName("企业");
        spMessageModel.setConcatName("陈先生");
        spMessageModel.setConcatPhone("12342132131");
        spMessageModel.setTitle("企业+陈先生");
        spMessageModel.setMessage("第六条 县级以上绿化委员会应当组织本地区各单位积极开展义务植树的宣传教育工作，增强公民履行植树义务的意识，推动全社会义务植树和造林绿化事业的发展");

    }

    /**
     * 业务明细
     */
    @Test
    public void getBusi(){
            SpPowerBusiDetailVo spPowerBusiDetailVo = spPowerPortalService.getBusi(busiId);
            assertThat(spPowerBusiDetailVo,notNullValue());
    }

    /**
     * 权力明细
     */
    @Test
    public void get(){
        List<SpPowerDetailVo> spPowerDetailVoList = spPowerPortalService.get(id);
        assertThat(spPowerDetailVoList,notNullValue());
    }

    /**
     * 实施部门列表
     */
    @Test
    public void departList(){
        List<SpDictDepartModel> spDictDepartModelList = spPowerPortalService.departList(busiName);
        assertThat(spDictDepartModelList,notNullValue());
    }

    /**
     * 权力清单列表
     */
    @Test
    public void findByPage(){
        page.setRows(10);
        page.setPage(1);
        PaginationData data = spPowerPortalService.findByPage(name, parentId, departId, type, code, page);
        Assert.assertThat(data, Matchers.anything());
    }

    /**
     * 我要留言
     */
    @Test
    public void SpMessage(){
        spPowerPortalService.SpMessage(spMessageModel, user);
    }

}
