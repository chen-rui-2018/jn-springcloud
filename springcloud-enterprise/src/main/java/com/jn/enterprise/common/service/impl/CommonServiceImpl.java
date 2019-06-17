package com.jn.enterprise.common.service.impl;

import com.jn.enterprise.common.dao.TbServiceCodeMapper;
import com.jn.enterprise.common.entity.TbServiceCode;
import com.jn.enterprise.common.entity.TbServiceCodeCriteria;
import com.jn.enterprise.common.service.CommonService;
import com.jn.enterprise.common.vo.CodeVO;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 企业服务-公共Service
 * @author： huxw
 * @date： Created on 2019-4-3 15:12:12
 * @version： v1.0
 * @modified By:
 */
@Service
public class CommonServiceImpl implements CommonService {
    private static Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    private TbServiceCodeMapper tbServiceCodeMapper;

    /**
     * 数据状态 1有效
     */
    private final static String RECORD_STATUS_VALID = "1";

    @Override
    @ServiceLog(doAction = "根据分组ID获取数据列表")
    public List<CodeVO> getCodeList(String groupId) {
        TbServiceCodeCriteria codeCriteria = new TbServiceCodeCriteria();
        TbServiceCodeCriteria.Criteria criteria = codeCriteria.createCriteria().andRecordStatusEqualTo(new Byte(RECORD_STATUS_VALID));
        criteria.andGroupIdEqualTo(groupId);

        List<TbServiceCode> codeList = tbServiceCodeMapper.selectByExample(codeCriteria);
        List<CodeVO> dataList = new ArrayList<>(10);
        for (TbServiceCode tsc : codeList) {
            CodeVO codeVO = new CodeVO();
            BeanUtils.copyProperties(tsc,codeVO);
            dataList.add(codeVO);
        }
        return dataList;
    }
}
