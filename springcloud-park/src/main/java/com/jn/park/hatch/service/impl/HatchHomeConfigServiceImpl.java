package com.jn.park.hatch.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.park.hatch.dao.TbHatchHomeConfigMapper;
import com.jn.park.hatch.dao.TbHatchIncubatorEnterpriseMapper;
import com.jn.park.hatch.dao.TbHatchIncubatorTeamMapper;
import com.jn.park.hatch.entity.TbHatchHomeConfig;
import com.jn.park.hatch.entity.TbHatchHomeConfigCriteria;
import com.jn.park.hatch.entity.TbHatchIncubatorEnterprise;
import com.jn.park.hatch.entity.TbHatchIncubatorTeam;
import com.jn.park.hatch.enums.DeclaratStatusEnums;
import com.jn.park.hatch.enums.HatchStatusEnums;
import com.jn.park.hatch.model.HatchHomeConfig;
import com.jn.park.hatch.service.HatchHomeConfigService;
import com.jn.park.hatch.model.HatchIncubatorEnterpriseParamModel;
import com.jn.park.hatch.model.HatchIncubatorTeamParamModel;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 众创空间配置管理(业务实现层)
 *
 * @author： wzy
 * @date： Created on 2019/5/15 16:22
 * @version： v1.0
 * @modified By:
 */
@Service
public class HatchHomeConfigServiceImpl implements HatchHomeConfigService {

    private static final Logger logger = LoggerFactory.getLogger(HatchHomeConfigServiceImpl.class);

    @Autowired
    private TbHatchHomeConfigMapper tbHatchHomeConfigMapper;

    @Autowired
    private TbHatchIncubatorEnterpriseMapper tbHatchIncubatorEnterpriseMapper;

    @Autowired
    private TbHatchIncubatorTeamMapper tbHatchIncubatorTeamMapper;

    @ServiceLog(doAction = "众创空间-首页信息查询")
    @Override
    public PaginationData<List<HatchHomeConfig>> list(String incubatorAbb, int page, int rows) {
        Page<Object> objects = PageHelper.startPage(page, rows);
        TbHatchHomeConfigCriteria tbHatchHomeConfigCriteria = new TbHatchHomeConfigCriteria();
        tbHatchHomeConfigCriteria.setOrderByClause("created_time desc");
        TbHatchHomeConfigCriteria.Criteria criteria = tbHatchHomeConfigCriteria.createCriteria();
        criteria.andRecordStatusEqualTo(HatchStatusEnums.EFFECTIVE.getCode());
        criteria.andStatusEqualTo(DeclaratStatusEnums.RELEASE.getCode());
        if(StringUtils.isNotBlank(incubatorAbb)){
            criteria.andIncubatorAbbLike('%'+incubatorAbb+'%');
        }
        List<TbHatchHomeConfig> list = tbHatchHomeConfigMapper.selectByExample(tbHatchHomeConfigCriteria);
        List<HatchHomeConfig> homgConfig = new ArrayList<>();
        if(list.size() > 0){
            for (TbHatchHomeConfig abr: list) {
                HatchHomeConfig hc = new HatchHomeConfig();
                BeanUtils.copyProperties(abr,hc);
                homgConfig.add(hc);
            }
        }
        return new PaginationData(homgConfig, objects.getTotal());
    }


    @Override
    @ServiceLog(doAction = "插入入孵企业信息")
    public void insertEnterpriseInfo(HatchIncubatorEnterpriseParamModel hatchIncubatorEnterpriseParamModel) {
        logger.info("插入入孵企业信息开始");
        TbHatchIncubatorEnterprise tb = new TbHatchIncubatorEnterprise();
        BeanUtils.copyProperties(hatchIncubatorEnterpriseParamModel,tb);
        tbHatchIncubatorEnterpriseMapper.insertSelective(tb);
        logger.info("插入入孵企业信息结束");
    }

    @Override
    @ServiceLog(doAction = "插入入孵团队信息")
    public void insertTeamInfo(HatchIncubatorTeamParamModel hatchIncubatorTeamParamModel) {
        logger.info("插入入孵团队信息开始");
        TbHatchIncubatorTeam tb = new TbHatchIncubatorTeam();
        BeanUtils.copyProperties(hatchIncubatorTeamParamModel,tb);
        tbHatchIncubatorTeamMapper.insertSelective(tb);
        logger.info("插入入孵团队信息结束");
    }
}
