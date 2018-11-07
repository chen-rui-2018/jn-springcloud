package com.jn.system.service.impl;

import com.jn.common.model.Result;
import com.jn.system.dao.TbSysPostMapper;
import com.jn.system.entity.TbSysPost;
import com.jn.system.entity.TbSysPostCriteria;
import com.jn.system.service.SysPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位service实现
 * @author： shaobao
 * @date： Created on 2018/10/31 15:55
 * @version： v1.0
 * @modified By:
 **/
@Service
public class SysPostServiceImpl implements SysPostService {

    @Autowired
    private TbSysPostMapper tbSysPostMapper;


    /**
     * 查询所有岗位
     * @return
     */
    @Override
    public Result findSysPostAll() {
        Result result = new Result();
        TbSysPostCriteria tbSysPostCriteria = new TbSysPostCriteria();
        TbSysPostCriteria.Criteria criteria = tbSysPostCriteria.createCriteria();
        criteria.andStatusEqualTo("1");
        List<TbSysPost> sysPostList = tbSysPostMapper.selectByExample(tbSysPostCriteria);
        result.setData(sysPostList);
        return result;
    }

}
