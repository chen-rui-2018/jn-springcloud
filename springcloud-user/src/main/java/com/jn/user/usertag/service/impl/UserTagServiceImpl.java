package com.jn.user.usertag.service.impl;

import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.usertag.dao.TbTagCodeMapper;
import com.jn.user.usertag.dao.TbUserTagMapper;
import com.jn.user.usertag.entity.TbTagCode;
import com.jn.user.usertag.entity.TbTagCodeCriteria;
import com.jn.user.usertag.entity.TbUserTag;
import com.jn.user.usertag.entity.TbUserTagCriteria;
import com.jn.user.usertag.model.TagCode;
import com.jn.user.usertag.service.UserTagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户标签
 * @author： jiangyl
 * @date： Created on 2019/3/6 16:48
 * @version： v1.0
 * @modified By:
 */
@Service
public class UserTagServiceImpl implements UserTagService {

    @Autowired
    private TbTagCodeMapper tbTagCodeMapper;

    /**
     * 数据状态 1:有效
     */
    private final static String RECORD_STATUS_VALID = "1";

    @Override
    @ServiceLog(doAction = "获取用户字典标签列表")
    public List<TagCode> getTagCodeList(){
        TbTagCodeCriteria codeCriteria = new TbTagCodeCriteria();
        codeCriteria.createCriteria().andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        List<TbTagCode> tbTagCodes = tbTagCodeMapper.selectByExample(codeCriteria);
        List<TagCode> codes = new ArrayList<>(8);
        for (TbTagCode tbTagCode:tbTagCodes) {
            TagCode tagCode = new TagCode();
            BeanUtils.copyProperties(tbTagCode,tagCode);
            codes.add(tagCode);
        }
        return codes;
    }


}
