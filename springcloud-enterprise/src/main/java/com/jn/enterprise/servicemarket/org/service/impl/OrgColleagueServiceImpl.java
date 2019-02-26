package com.jn.enterprise.servicemarket.org.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.model.OrgColleagueQuery;
import com.jn.enterprise.servicemarket.org.service.OrgColleagueService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 机构同事
 * @Author: yangph
 * @Date: 2019/2/26 10:12
 * @Version v1.0
 * @modified By:
 */
@Service
public class OrgColleagueServiceImpl implements OrgColleagueService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(OrgColleagueServiceImpl.class);

    /**
     * 机构同事列表查询
     * @param account  当前登录用户账号
     * @param orgColleagueQuery 机构同事列表查询入参（是否分页）
     * @return
     */
    @ServiceLog(doAction = "机构同事列表查询")
    @Override
    public PaginationData getOrgColleagueList(String account, OrgColleagueQuery orgColleagueQuery) {
        com.github.pagehelper.Page<Object> objects = null;
        //是否分页标识
        boolean needPage=false;
        if(orgColleagueQuery!= null && orgColleagueQuery.getNeedPage()!=null
                && Boolean.TRUE.toString().equals(orgColleagueQuery.getNeedPage().toLowerCase())){
            needPage=true;
        }
        if(needPage){
            objects = PageHelper.startPage(orgColleagueQuery.getPage(),
                    orgColleagueQuery.getRows() == 0 ? 15 : orgColleagueQuery.getRows(), true);
        }

        return new PaginationData();
    }
}
