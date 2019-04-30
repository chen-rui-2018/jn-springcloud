package com.jn.park.sp.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.channel.MessageSource;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.company.model.ServiceCompanyParam;
import com.jn.news.vo.EmailVo;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.park.finance.service.impl.FinanceTypeServiceImpl;
import com.jn.park.sp.dao.*;
import com.jn.park.sp.entity.*;
import com.jn.park.sp.enums.SpStatusEnums;
import com.jn.park.sp.model.*;
import com.jn.park.sp.service.SpPowerPortalService;
import com.jn.park.sp.vo.SpPowerBusiDetailVo;
import com.jn.park.sp.vo.SpPowerDetailVo;
import com.jn.park.sp.vo.SpPowerVo;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.model.User;
import com.jn.system.vo.SysDictKeyValue;
import org.checkerframework.checker.units.qual.A;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
@EnableBinding(value = MessageSource.class)
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
    private TbSpMessageMapper tbSpMessageMapper;
    @Autowired
    private CompanyClient companyClient;
    @Autowired
    private SpAdDao spAdDao;
    @Autowired(required = false)
    private MessageSource messageSource;
    @Autowired
    private SystemClient systemClient;

    @Value("${ibps.url}")
    private String ibpsUrl;

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
        TbSpPowerBusiWithBLOBs tbSpPowerBusiWithBLOBs = tbSpPowerBusiMapper.selectByPrimaryKey(id);
        if (tbSpPowerBusiWithBLOBs == null){
            return null;
        }
        BeanUtils.copyProperties(tbSpPowerBusiWithBLOBs,spPowerBusiDetailVo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(tbSpPowerBusiWithBLOBs.getCreatedTime());
        spPowerBusiDetailVo.setTime(format);

        spPowerBusiDetailVo.setFlowPic(spPowerBusiDetailVo.getFlowPic().replace("/ibps/components/upload/ueditor/preview.htm",ibpsUrl+"/ibps/components/upload/ueditor/preview.htm"));
        //替换标签,只要纯文本
        String dealConditions = spPowerBusiDetailVo.getDealConditions();
        dealConditions = dealConditions.replace("<p><span style=\"color: rgb(50, 50, 50); font-family: &quot;Microsoft Yahei&quot;; font-size: 15px; background-color: rgb(255, 255, 255);\">","");
        dealConditions = dealConditions.replace("</span></p>","");
        spPowerBusiDetailVo.setDealConditions(dealConditions);
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
                String sample = spPowerBusiMaterialsModel.getSample();
                //拼接附件下载链接
                Object parse = JSONValue.parse(sample);
                JSONArray array=(JSONArray)parse;
                JSONObject obj2=(JSONObject)array.get(0);
                String spring =(String) obj2.get("id");
                String fileName =  (String)obj2.get("fileName");
                String sid = "/components/upload/preview.htm?downloadId=" + spring;
                spPowerBusiMaterialsModel.setSampleName(fileName);
                spPowerBusiMaterialsModel.setSample(sid);
                spPowerBusiMaterialsModelList.add(spPowerBusiMaterialsModel);
            }
            spPowerBusiDetailVo.setMaterialsModelList(spPowerBusiMaterialsModelList);
        }
        return spPowerBusiDetailVo;
    }

    /**
     *通过权力id查询权力的明细内容
     *
     * @param id
     * @return
     */
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
        if (tbSpPowerBusis != null){
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

    /**
     * 通过部门名称获取全部的实施部门(模糊查询)
     * @param name
     * @return
     */
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

    /**
     * 返回全部的权力清单(包含孩子)
     * @param name
     * @param parentId
     * @param departId
     * @param type
     * @param code
     * @param page
     * @return
     */
    @Override
    @ServiceLog(doAction = "返回全部的权力清单(包含孩子)")
    public PaginationData findByPage(String name, String parentId, String departId, String type, String code, Page page) {
        //根据条件动态查询权力清单
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        Map<String,Object> map = new HashMap<>(16);
        map.put("name",name);
        map.put("parentId",parentId);
        map.put("departId",departId);
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

    /**
     * 我要留言
     * @param spMessageModel
     * @param user
     * @return
     */
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
            if(StringUtils.isEmpty(tbSpMessage.getCompanyName())){
                tbSpMessage.setCompanyName(data.getComName());
            }
            //判断联系人名称是否为空
            if (StringUtils.isEmpty(tbSpMessage.getConcatName())){
                tbSpMessage.setConcatName(data.getContact());
            }
            //判断联系人电话是否为空
            if (StringUtils.isEmpty(tbSpMessage.getConcatPhone())){
                tbSpMessage.setConcatPhone(data.getConPhone());
            }
        }
        tbSpMessage.setCreatorAccount(user.getAccount());
        tbSpMessage.setCreateTime(new Date());
        int insert = tbSpMessageMapper.insert(tbSpMessage);
        logger.info("【添加】添加留言成功,对应ID为{}",tbSpMessage.getId());
        return insert;
    }

    /**
     * 获取最新的5例广告图
     *
     * @return
     */
    @Override
    @ServiceLog(doAction="轮播广告")
    public List<SpAdModel> getAdvertising() {
        List<SpAdModel> spAdModelList = spAdDao.getAdvertising();
        return spAdModelList;
    }

    /**
     * 获取在线受理地址
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取在线受理地址")
    public String getDealUrl(String id) {
        TbSpPowerBusiWithBLOBs tbSpPowerBusiWithBLOBs =tbSpPowerBusiMapper.selectByPrimaryKey(id);
        if((new Byte("1").equals(tbSpPowerBusiWithBLOBs.getRecordStatus()))){
            return tbSpPowerBusiWithBLOBs.getDealUrl();
        }
        return null;
    }

    private Integer pushPowerBusi(String powerBusiId,ServiceCompanyParam serviceCompanyParam,String userId){
        TbSpPowerBusiWithBLOBs tbSpPowerBusiWithBLOBs=tbSpPowerBusiMapper.selectByPrimaryKey(powerBusiId);
        if(tbSpPowerBusiWithBLOBs==null||!tbSpPowerBusiWithBLOBs.getRecordStatus().equals(new Byte("1"))){
            throw new JnSpringCloudException(new Result("-1","审批指南内容不存在"));
        }
        //所有企业
        serviceCompanyParam.setRows(99999999);//不分页
        Result<PaginationData<List<ServiceCompany>>> serviceCompany= companyClient.getCompanyList(serviceCompanyParam);
        int count=0;
        for(ServiceCompany e:serviceCompany.getData().getRows()){
            if(StringUtils.isBlank(e.getComAdmin())){
                logger.info("企业【{}】还未指定管理员",e.getComName());
                continue;
            }
            EmailVo emailVo = new EmailVo();
            User user=new User();
            user.setAccount(e.getComAdmin());
            Result<User> userResult=systemClient.getUser(user);
            if(userResult.getData()==null||StringUtils.isBlank(userResult.getData().getEmail())){
                logger.info("未找到管理员【{}】邮箱",e.getComAdmin());
                continue;
            }
            emailVo.setEmail(userResult.getData().getEmail());
            emailVo.setEmailSubject(tbSpPowerBusiWithBLOBs.getName());
            String url=getPortalUrl()+"serviceDetail?id="+tbSpPowerBusiWithBLOBs.getId();
            emailVo.setEmailContent(String.format("%s，您好，审批指南明细内容请点击 <a href='%s'>%s</a>",e.getContact(),url,tbSpPowerBusiWithBLOBs.getName()));
            logger.info("推送成功：接收邮箱：{},用户ID:{},邮件主题：{}，邮件内容：{}",emailVo.getEmail(),user.getId(),emailVo.getEmailSubject(),emailVo.getEmailContent());
            boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
            count++;
        }
        logger.info("成功向{}个企业推送了【{}】",serviceCompany.getData().getRows().size(),tbSpPowerBusiWithBLOBs.getName());
        return count;
    }

    @Override
    public void pushPowerBusiBatch(String powerBusiIds,ServiceCompanyParam serviceCompanyParam,String userId){
        String[] powerBusiIdArr=powerBusiIds.split(",");
        for(int i=0;i<powerBusiIdArr.length;i++){
            this.pushPowerBusi(powerBusiIdArr[i],serviceCompanyParam,userId);
        }
    }

    /**
     * 获取门户URL
     * @return
     */
    private String getPortalUrl(){
        SysDictInvoke sysDictInvoke=new SysDictInvoke();
        sysDictInvoke.setKey("portal_url");
        sysDictInvoke.setGroupCode("portal_url");
        Result<List<SysDictKeyValue>> sysDictKeyValueList= systemClient.getDict(new SysDictInvoke("common","portal_url","portal_url","portal_url"));
        if(sysDictKeyValueList.getData()!=null&&sysDictKeyValueList.getData().size()==1){
            return sysDictKeyValueList.getData().get(0).getLable();
        }
        throw new JnSpringCloudException(new Result("-1","portal_url未配置"));
    }
}
