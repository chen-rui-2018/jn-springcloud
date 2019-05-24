package com.jn.park.gamtopic.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.care.model.ServiceEnterpriseCompany;
import com.jn.park.gamtopic.dao.CareDao;
import com.jn.park.gamtopic.dao.DynamicDao;
import com.jn.park.gamtopic.dao.TbPersonCareMapper;
import com.jn.park.gamtopic.entity.TbPersonCare;
import com.jn.park.gamtopic.entity.TbPersonCareCriteria;
import com.jn.park.gamtopic.model.*;
import com.jn.park.gamtopic.service.CareService;
import com.jn.park.gamtopic.service.DynamicService;
import com.jn.park.gamtopic.vo.CareDetailsVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/15 17:36
 * @version： v1.0
 * @modified By:
 */
@Service
public class CareServiceImpl implements CareService {
    /**
     * /记录状态 1 有效 0 无效
     */
    private final static String STATUS_IS_EFFECTIVE = "1";
    /**
     * /记录状态 1 有效 0 无效
     */
    private final static String STATUS_IS_INVALID = "0";

    @Autowired
    private TbPersonCareMapper tbPersonCareMapper;
    @Autowired
    private CareDao careDao;
    @Autowired
    private UserExtensionClient userExtensionClient;
     @Autowired
    private DynamicService dynamicService;



    @ServiceLog(doAction = "用户添加关注操作")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addCareOperate(String careId, CareAddParam careAddParam, String careAccount) {
        TbPersonCare tbPersonCare = new TbPersonCare();
        tbPersonCare.setRecordStatus(new Byte(STATUS_IS_EFFECTIVE));
        //如果记录已存在 则进行重新关注
        TbPersonCareCriteria careCriteria = new TbPersonCareCriteria();
        careCriteria.createCriteria().andCareAccountEqualTo(careAccount).andReceiveAccountEqualTo(careAddParam.getAccount());
        List<TbPersonCare> list =  tbPersonCareMapper.selectByExample(careCriteria);
        if(list!=null && list.size()>0){
            tbPersonCare.setModifiedTime(new Date());
            tbPersonCare.setModifierAccount(careAccount);
            int i = tbPersonCareMapper.updateByExampleSelective(tbPersonCare,careCriteria);
            return i;
        }
        //不存在则新增一条关注记录
        tbPersonCare.setCareId(careId);
        tbPersonCare.setCareAccount(careAccount);
        tbPersonCare.setReceiveAccount(careAddParam.getAccount());
        tbPersonCare.setCreatedTime(new Date());
        tbPersonCare.setCreatorAccount(careAccount);
        tbPersonCare.setReceiveType(careAddParam.getReceiveType());

        int i =  tbPersonCareMapper.insertSelective(tbPersonCare);
        return i;
    }
    @ServiceLog(doAction = "用户取消关注操作")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int cancelCareOperate(String account, String currentAccount) {
        TbPersonCareCriteria careCriteria = new TbPersonCareCriteria();
        careCriteria.createCriteria().andCareAccountEqualTo(currentAccount).andReceiveAccountEqualTo(account);
        TbPersonCare tbPersonCare = new TbPersonCare();
        tbPersonCare.setRecordStatus(new Byte(STATUS_IS_INVALID));
        tbPersonCare.setModifierAccount(currentAccount);
        tbPersonCare.setModifiedTime(new Date());
        int i = tbPersonCareMapper.updateByExampleSelective(tbPersonCare,careCriteria);
        return i;
    }
    @ServiceLog(doAction = "关注人列表查询")
    @Override
    public PaginationData<List<CareUserShow>> findCareList(Page page, String account) {
        int pageNum = page.getPage();
        int pageSize = page.getRows()==0?15:page.getRows();
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(pageNum,pageSize,true);
        List<CareUserShow> careList=  careDao.findCareList(account);
        if(!careList.isEmpty()){
            careList = approvalUserInfo(careList);
        }
        return new PaginationData<>(careList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "粉丝列表查询")
    @Override
    public PaginationData<List<CareUserShow>> findFansList(Page page, String account) {
        int pageNum = page.getPage();
        int pageSize = page.getRows()==0?15:page.getRows();
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(pageNum,pageSize,true);
        List<CareUserShow> careList=  careDao.findFansList(account);
        if(!careList.isEmpty()){
            careList = approvalUserInfo(careList);
        }
        return new PaginationData<>(careList,objects==null?0:objects.getTotal());

    }
    @ServiceLog(doAction = "关注详情(个人)")
    @Override
    public CareDetailsVo findCareDetails(CareDetailsQueryParam param,String currentAccount) {
        CareDetailsVo vo = new CareDetailsVo();
        CareUserDetails userDetails =  careDao.findCareDetails(param.getParamAccount(),currentAccount);
        vo.setUserDetails(userDetails);
        PaginationData<List<DynamicWebShow>> dynamicList =  dynamicService.findDynamicByAccount(param,currentAccount);
        vo.setDnmamicList(dynamicList);
        return vo;
    }
    @ServiceLog(doAction = "企业/个人粉丝数查询")
    @Override
    public CareUserDetails findCompanyCareInfo(String account,String currentAccount) {
        CareUserDetails userDetails =  careDao.findCareDetails(account,currentAccount);
        return userDetails;
    }

    @Override
    @ServiceLog(doAction = "查询关注的企业")
    public List<String> findCareCompanyList(String account) {
        return careDao.findCareCompanyList(account);
    }



    @Override
    @ServiceLog(doAction = "企业简介")
    public List<ServiceEnterpriseCompany> getCompanyNewList(List<ServiceEnterpriseCompany> serviceEnterpriseCompany) {
        List<ServiceEnterpriseCompany> getCompanyNewList=new ArrayList<>();
        //循环去通过企业ID查询相关联的评论及关注
        for(int i=0;i<serviceEnterpriseCompany.size();i++){
            //获取到一条数据
            ServiceEnterpriseCompany serviceEnterpriseCompany1=serviceEnterpriseCompany.get(i);
            //获取企业ID
            String id = serviceEnterpriseCompany1.getId();
            //通过企业ID去查询相关联的评论及关注
            CommentModel commentModel=careDao.findCareComment(id);
            //将返回的结果塞进这一条数据
            //评论数
            serviceEnterpriseCompany1.setCommentNumber(commentModel.getCommentNumber());
            //关注用户数
            serviceEnterpriseCompany1.setCareUser(commentModel.getCareUser());
            //处理完成之后保存数据,返回
            getCompanyNewList.add(serviceEnterpriseCompany1);
        }

        return getCompanyNewList;
    }




    /**
     * 完善用户扩展信息
     * @param showList
     * @return
     */
    private List<CareUserShow> approvalUserInfo(  List<CareUserShow> showList){
        List<String> accountList = new ArrayList<>();
        for(CareUserShow show : showList){
            accountList.add(show.getAccount());
        }
        Result<List<UserExtensionInfo>> result = userExtensionClient.getMoreUserExtension(accountList);
        if(!result.getData().isEmpty()){
            List<UserExtensionInfo> userList = result.getData();
            for(CareUserShow show : showList){
                for(UserExtensionInfo user : userList){
                    if(show.getAccount().equals(user.getAccount())){
                        show.setAvatar(user.getAvatar());
                        show.setNickName(user.getNickName());
                        show.setCompanyName(user.getCompanyName());
                    }
                }
            }
        }
        return showList;
    }


}
