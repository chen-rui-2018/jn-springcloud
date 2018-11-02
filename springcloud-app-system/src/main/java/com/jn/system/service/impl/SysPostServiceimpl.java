package com.jn.system.service.impl;

import com.jn.common.model.Result;
import com.jn.system.dao.SysPostMapper;
import com.jn.system.service.SysPostService;
import com.jn.system.vo.TbSysPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 岗位service实现
 * @author： shaobao
 * @date： Created on 2018/10/31 15:55
 * @version： v1.0
 * @modified By:
 **/
@Service
public class SysPostServiceimpl implements SysPostService {

    @Autowired
    private SysPostMapper sysPostMapper;

    /**
     * 查询所有岗位
     * @return
     */
    @Override
    public Result findSysPostAll() {
        Result result = new Result();
        List<TbSysPost> sysPostList = sysPostMapper.findSysPostAll();
        result.setData(sysPostList);
        return result;
    }

    /**
     * 根据部门id获取对应岗位
     * @param departmentId
     * @return
     */
    @Override
    public Result findSysPostByDepartmentId(String departmentId) {
        return new Result(sysPostMapper.findSysPostByDepartmentId(departmentId));
    }
}
