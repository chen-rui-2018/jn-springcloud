package com.jn.park.sp.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.park.finance.service.impl.FinanceTypeServiceImpl;
import com.jn.park.sp.dao.*;
import com.jn.park.sp.entity.*;
import com.jn.park.sp.enums.SpStatusEnums;
import com.jn.park.sp.model.SpDictDepartModel;
import com.jn.park.sp.model.SpMessageModel;
import com.jn.park.sp.model.SpPowerBusiMaterialsModel;
import com.jn.park.sp.model.SpPowerBusiModel;
import com.jn.park.sp.service.SpPowerPortalService;
import com.jn.park.sp.vo.SpPowerBusiDetailVo;
import com.jn.park.sp.vo.SpPowerDetailVo;
import com.jn.park.sp.vo.SpPowerVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 对外行政审批中心-门户service
 *
 * @author： zhuyz
 * @date： Created on 2019/3/25 16:12
 * @version： v1.0
 * @modified By:
 */
@Service
public class SpPowerPortalServiceImpl implements SpPowerPortalService {

    private static Logger logger = LoggerFactory.getLogger(FinanceTypeServiceImpl.class);

    @Autowired
    private TbSpDictDepartMapper tbSpDictDepartMapper;
    @Autowired
    private TbSpPowerBusiMapper tbSpPowerBusiMapper;
    @Autowired
    private TbSpPowerBusiMaterialsMapper tbSpPowerBusiMaterialsMapper;
    @Autowired
    private SpPowerDao spPowerDao;
    @Autowired
    private SpPowerBusiDao spPowerBusiDao;
    @Autowired
    private TbSpMessageMapper tbSpMessageMapper;
    @Autowired
    private CompanyClient companyClient;

    /**
     *通过业务id查询业务明细内容
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction="通过业务id查询业务明细内容")
    public SpPowerBusiDetailVo getBusi(String id) {
        SpPowerBusiDetailVo spPowerBusiDetailVo = new SpPowerBusiDetailVo();
        //通过业务id查询业务内容
        TbSpPowerBusiWithBLOBs tbSpPowerBusiWithBLOBs = spPowerBusiDao.selectBusiByKey(id);
        if (tbSpPowerBusiWithBLOBs == null){
            return null;
        }
        BeanUtils.copyProperties(tbSpPowerBusiWithBLOBs,spPowerBusiDetailVo);
        //通过业务id查询业务对象的办理材料集合
        TbSpPowerBusiMaterialsCriteria tbSpPowerBusiMaterialsCriteria = new TbSpPowerBusiMaterialsCriteria();
        TbSpPowerBusiMaterialsCriteria.Criteria criteria = tbSpPowerBusiMaterialsCriteria.createCriteria();
        criteria.andBusiIdEqualTo(id);
        //只查询有效的办理材料
        Byte recordStatus = Byte.parseByte(SpStatusEnums.DELETED.getCode());
        criteria.andRecordStatusNotEqualTo(recordStatus);
        List<TbSpPowerBusiMaterials> tbSpPowerBusiMaterials = tbSpPowerBusiMaterialsMapper.selectByExample(tbSpPowerBusiMaterialsCriteria);
        //封装办理材料清单集合
        List<SpPowerBusiMaterialsModel> spPowerBusiMaterialsModelList = new ArrayList<>();
        if (tbSpPowerBusiMaterials != null){
            for (TbSpPowerBusiMaterials tbSpPowerBusiMaterial : tbSpPowerBusiMaterials) {
                SpPowerBusiMaterialsModel spPowerBusiMaterialsModel = new SpPowerBusiMaterialsModel();
                BeanUtils.copyProperties(tbSpPowerBusiMaterial,spPowerBusiMaterialsModel);
                spPowerBusiMaterialsModelList.add(spPowerBusiMaterialsModel);
            }
            spPowerBusiDetailVo.setMaterialsModelList(spPowerBusiMaterialsModelList);
        }
        return spPowerBusiDetailVo;
    }

    @Override
    @ServiceLog(doAction = "通过权力id查询权力的明细内容")
    public List<SpPowerDetailVo> get(String id) {
        List<SpPowerDetailVo> spPowerDetailVoList = new ArrayList<SpPowerDetailVo>();
        SpPowerDetailVo spPowerDetailVo = new SpPowerDetailVo();
        //通过权力id查询对应的权力明细
        TbSpPower tbSpPower =  spPowerDao.selectPowerByKey(id);
        if (tbSpPower != null){
            BeanUtils.copyProperties(tbSpPower,spPowerDetailVo);
        }
        //获取权力对应的业务列表
        TbSpPowerBusiCriteria tbSpPowerBusiCriteria = new TbSpPowerBusiCriteria();
        TbSpPowerBusiCriteria.Criteria criteria = tbSpPowerBusiCriteria.createCriteria();
        criteria.andPowerIdEqualTo(id);
        //只查询有效的业务
        Byte recordStatus = Byte.parseByte(SpStatusEnums.EFFECTIVE.getCode());
        criteria.andRecordStatusEqualTo(recordStatus);
        List<TbSpPowerBusi> tbSpPowerBusis = tbSpPowerBusiMapper.selectByExample(tbSpPowerBusiCriteria);
        //封装业务列表
        List<SpPowerBusiModel> spPowerBusiModelList = new ArrayList<SpPowerBusiModel>();
        if (spPowerBusiModelList != null){
            for (TbSpPowerBusi tbSpPowerBusi : tbSpPowerBusis) {
                SpPowerBusiModel spPowerBusiModel = new SpPowerBusiModel();
                BeanUtils.copyProperties(tbSpPowerBusi,spPowerBusiModel);
                spPowerBusiModelList.add(spPowerBusiModel);
            }
            spPowerDetailVo.setBusiModelList(spPowerBusiModelList);
        }
        spPowerDetailVoList.add(spPowerDetailVo);
        return spPowerDetailVoList;
    }

    @Override
    @ServiceLog(doAction = "通过部门名称获取全部的实施部门(模糊查询)")
    public List<SpDictDepartModel> departList(String name) {
       List<SpDictDepartModel> spDictDepartModelList = new ArrayList<SpDictDepartModel>();
       //根据名称模糊查询出全部的实施部门
       TbSpDictDepartCriteria tbSpDictDepartCriteria = new TbSpDictDepartCriteria();
       TbSpDictDepartCriteria.Criteria criteria = tbSpDictDepartCriteria.createCriteria();
       if(name != null){
           //模糊查询实施部门
           criteria.andNameLike("%"+name+"%");
       }
       //只查询有效的部门
        Byte recordStatus = Byte.parseByte(SpStatusEnums.EFFECTIVE.getCode());
        criteria.andRecordStatusEqualTo(recordStatus);
        List<TbSpDictDepart> tbSpDictDeparts = tbSpDictDepartMapper.selectByExample(tbSpDictDepartCriteria);
        if (tbSpDictDeparts != null && tbSpDictDeparts.size() > 0){
            for (TbSpDictDepart tbSpDictDepart : tbSpDictDeparts) {
                SpDictDepartModel spDictDepartModel = new SpDictDepartModel();
                BeanUtils.copyProperties(tbSpDictDepart,spDictDepartModel);
                spDictDepartModelList.add(spDictDepartModel);
            }
        }
        return spDictDepartModelList;
    }

    @Override
    @ServiceLog(doAction = "返回全部的权力清单(包含孩子)")
    public PaginationData findByPage(String name, String parentId, String departId, String type, String code, Page page) {
        //根据条件动态查询权力清单
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        Map<String,Object> map = new HashMap<>(16);
        map.put("name",name);
        map.put("parentId",parentId);
        map.put("type",type);
        map.put("code",code);
        List<SpPowerVo> spPowerVoList = spPowerDao.findByPage(map);
        //查询权力清单的孩子
        for (SpPowerVo spPowerVo : spPowerVoList) {
            String id = spPowerVo.getId();
            List<SpPowerVo> childs = spPowerDao.selectChilds(id);
            if (childs != null){
                spPowerVo.setChilds(childs);
            }
        }
        PaginationData data = new PaginationData(spPowerVoList,objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction="我要留言")
    @Transactional(rollbackFor = Exception.class)
    public Integer SpMessage(SpMessageModel spMessageModel, User user) {
        //调用企业详细查询接口通过账号查询企业详情信息
        Result<ServiceCompany> companyDetailByAccountOrCompanyId = companyClient.getCompanyDetailByAccountOrCompanyId(user.getAccount());
        ServiceCompany data = companyDetailByAccountOrCompanyId.getData();
        TbSpMessage tbSpMessage = new TbSpMessage();
        BeanUtils.copyProperties(spMessageModel,tbSpMessage);
        //判断企业信息是否为空
        if(data != null){
            //判断企业名称是否为空
            if (tbSpMessage.getCompanyName() == null || tbSpMessage.getCompanyName() == ""){
                tbSpMessage.setCompanyName(data.getComName());
            }
            //判断联系人名称是否为空
            if (tbSpMessage.getConcatName() == null || tbSpMessage.getConcatName() == ""){
                tbSpMessage.setConcatName(data.getContact());
            }
            //判断联系人电话是否为空
            if (tbSpMessage.getConcatPhone() == null || tbSpMessage.getConcatPhone() == ""){
                tbSpMessage.setConcatPhone(data.getConPhone());
            }
        }
        tbSpMessage.setCreatorAccount(user.getAccount());
        tbSpMessage.setCreateTime(new Date());
        int insert = tbSpMessageMapper.insert(tbSpMessage);
        logger.info("【添加】添加留言成功,对应ID为{}",tbSpMessage.getId());
        return insert;
    }
}
