package com.jn.oa.dingTalk.service.impl;

import com.alibaba.fastjson.JSON;
import com.jn.common.model.Result;
import com.jn.hardware.api.DingTalkClient;
import com.jn.hardware.model.dingtalk.user.*;
import com.jn.oa.common.enums.OaDingTalkEnums;
import com.jn.oa.dingTalk.dao.TbOaDingTalkUserMapper;
import com.jn.oa.dingTalk.entity.TbOaDingTalkUser;
import com.jn.oa.dingTalk.service.DingTalkUserService;
import com.jn.oa.enums.AddressBookEventTypeEnum;
import com.jn.oa.model.AddressBookNotice;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * 钉钉用户service
 *
 * @author： yuanyy
 * @date： Created on 2019/4/17 10:49
 * @version： v1.0
 * @modified By:
 */
@Service
public class DingTalkServiceImpl implements DingTalkUserService {

    private static Logger logger = LoggerFactory.getLogger(DingTalkServiceImpl.class);

    @Autowired
    private TbOaDingTalkUserMapper tbOaDingTalkUserMapper;

    @Autowired
    private DingTalkClient dingTalkClient;


    /**
     * 批量更新钉钉用户表
     *
     * @return
     */
    @Override
    @ServiceLog(doAction ="批量更新钉钉用户表" )
    @Transactional(rollbackFor = Exception.class)
    public void batchInsertDingTalkUser() {
        DepartmentListParam departmentListParam=new DepartmentListParam();
        departmentListParam.setFetchChild(true);
        Result<DepartmentListResult> departmentListResult=dingTalkClient.getDepartmentList(departmentListParam);
        logger.info("[钉钉用户]批量更新钉钉用户表,departmentListResult{}", JSON.toJSON(departmentListResult));
        if(departmentListResult!=null&&departmentListResult.getData().getDepartment().size()>0){
            for(int i=0;i<departmentListResult.getData().getDepartment().size();i++){
                DepartmentInfo departmentInfo=departmentListResult.getData().getDepartment().get(i);
                DepartmentUserInfoParam departmentUserInfoParam=new DepartmentUserInfoParam();
                departmentUserInfoParam.setOffset(Long.valueOf(OaDingTalkEnums.OFFSET.getCode()));
                departmentUserInfoParam.setSize(Long.valueOf(OaDingTalkEnums.SIZE.getCode()));
                departmentUserInfoParam.setDepartmentId(departmentInfo.getId());
                Result<DepartmentUserInfoResult>  departmentUserInfoResult=dingTalkClient.getDepartUserByPage(departmentUserInfoParam);
                logger.info("[钉钉用户]批量更新钉钉用户表,departmentUserInfoResult{}", JSON.toJSON(departmentUserInfoResult));
                if(departmentUserInfoResult!=null&&departmentUserInfoResult.getData()!=null&&departmentUserInfoResult.getData().getUserlist()!=null&&departmentUserInfoResult.getData().getUserlist().size()>0){
                    searchUserAndInsert(departmentUserInfoResult, departmentUserInfoParam);

                }

            }
        }

    }
    private void searchUserAndInsert(Result<DepartmentUserInfoResult>  departmentUserInfoResult,DepartmentUserInfoParam departmentUserInfoParam){

        List<DingTalkUser> data=departmentUserInfoResult.getData().getUserlist();
        for(DingTalkUser dingTalkUser:data){

            //设置钉钉表中的部门id
            TbOaDingTalkUser tbOaDingTalkUser=new TbOaDingTalkUser();
            tbOaDingTalkUser.setDepartment(String.valueOf(dingTalkUser.getDepartment()).substring(1,String.valueOf(dingTalkUser.getDepartment()).length()-1));
            tbOaDingTalkUser.setUnionId(dingTalkUser.getUnionid());

            //时间戳转换成date
            ZonedDateTime checkTimeZdt= LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(dingTalkUser.getHiredDate())), ZoneId.systemDefault()).atZone(ZoneId.systemDefault());
            tbOaDingTalkUser.setHiredDate(Date.from(checkTimeZdt.toInstant()));

            //默认在职
            tbOaDingTalkUser.setStatus(OaDingTalkEnums.JOB_STATUS_ON_JOB.getCode());
            tbOaDingTalkUser.setJobNumber(dingTalkUser.getJobnumber());
            tbOaDingTalkUser.setMobile(dingTalkUser.getMobile());
            tbOaDingTalkUser.setName(dingTalkUser.getName());
            tbOaDingTalkUser.setOpenId(dingTalkUser.getOpenId());
            tbOaDingTalkUser.setPosition(dingTalkUser.getPosition());
            tbOaDingTalkUser.setUserId(dingTalkUser.getUserid());

            TbOaDingTalkUser user=tbOaDingTalkUserMapper.selectByPrimaryKey(tbOaDingTalkUser.getUserId());
            //判断是否新增多条数据,可能存在一个人在多个部门中
            if(user==null){
                logger.info("[钉钉用户]新增钉钉用户表,tbOaDingTalkUser{}", JSON.toJSON(tbOaDingTalkUser));
                tbOaDingTalkUserMapper.insert(tbOaDingTalkUser);
            }
            if(departmentUserInfoResult.getData().getHasMore()){
                departmentUserInfoParam.setOffset(departmentUserInfoParam.getOffset()+departmentUserInfoParam.getSize());
                logger.info("[钉钉用户]递归分页查询下一页用户数据,请求参数departmentUserInfoParam：{}", JSON.toJSON(departmentUserInfoParam));
                Result<DepartmentUserInfoResult>  result=dingTalkClient.getDepartUserByPage(departmentUserInfoParam);
                searchUserAndInsert(result,departmentUserInfoParam);
            }

        }
    }

    /**
     * 更新用户信息
     *
     * @param addressBookNotice
     */
    @Override
    public void updateOrInsertDingTalkUser(AddressBookNotice addressBookNotice) {
        logger.info("[钉钉用户]变更钉钉用户信息回调,addressBookNotice{}", JSON.toJSON(addressBookNotice));

        if(AddressBookEventTypeEnum.USER_ADD_ORG.getCode().equals(addressBookNotice.getEventType().getCode())){
            logger.info("[钉钉用户]新增钉钉用户信息回调,addressBookNotice{}", JSON.toJSON(addressBookNotice));
            //钉钉通讯录新增事件
            for(String id:addressBookNotice.getUserId()){
                UserDetailsInfoParam userInfoParam=new UserDetailsInfoParam();
                userInfoParam.setUserid(id);
                Result<UserDetailsInfoResult> userDetailsInfoResultResult=dingTalkClient.getUserInfo(userInfoParam);
                if(userDetailsInfoResultResult!=null&&userDetailsInfoResultResult.getData()!=null){
                    UserDetailsInfoResult result=userDetailsInfoResultResult.getData();
                    logger.info("[钉钉用户]新增钉钉用户信息回调,查询钉钉对应信息,userInfoParam：{}，result{}", JSON.toJSON(userInfoParam),JSON.toJSON(result));
                    TbOaDingTalkUser user=copyBeanProperty(result);
                    //默认在职
                    user.setStatus(OaDingTalkEnums.JOB_STATUS_ON_JOB.getCode());
                    tbOaDingTalkUserMapper.insert(user);
                }
            }

        }else if(AddressBookEventTypeEnum.USER_MODIFY_ORG.getCode().equals(addressBookNotice.getEventType().getCode())){
            logger.info("[钉钉用户]更新钉钉用户信息回调,addressBookNotice{}", JSON.toJSON(addressBookNotice));
            //钉钉通讯录更新事件
            for(String id:addressBookNotice.getUserId()){
                UserDetailsInfoParam userInfoParam=new UserDetailsInfoParam();
                userInfoParam.setUserid(id);
                Result<UserDetailsInfoResult> userDetailsInfoResultResult=dingTalkClient.getUserInfo(userInfoParam);
                if(userDetailsInfoResultResult!=null&&userDetailsInfoResultResult.getData()!=null){
                    UserDetailsInfoResult result=userDetailsInfoResultResult.getData();
                    logger.info("[钉钉用户]新增钉钉用户信息回调,查询钉钉对应信息,userInfoParam：{}，result{}", JSON.toJSON(userInfoParam),JSON.toJSON(result));
                    TbOaDingTalkUser user=copyBeanProperty(result);
                    //默认在职
                    user.setStatus(OaDingTalkEnums.JOB_STATUS_ON_JOB.getCode());
                    tbOaDingTalkUserMapper.updateByPrimaryKey(user);
                }
            }

        }else if(AddressBookEventTypeEnum.USER_LEAVE_ORG.getCode().equals(addressBookNotice.getEventType().getCode())){
            logger.info("[钉钉用户]离职钉钉用户信息回调,addressBookNotice{}", JSON.toJSON(addressBookNotice));
            //钉钉通讯录离职事件
            for(String id:addressBookNotice.getUserId()){
                UserDetailsInfoParam userInfoParam=new UserDetailsInfoParam();
                userInfoParam.setUserid(id);
                Result<UserDetailsInfoResult> userDetailsInfoResultResult=dingTalkClient.getUserInfo(userInfoParam);
                if(userDetailsInfoResultResult!=null&&userDetailsInfoResultResult.getData()!=null){
                    UserDetailsInfoResult result=userDetailsInfoResultResult.getData();
                    logger.info("[钉钉用户]新增钉钉用户信息回调,查询钉钉对应信息,userInfoParam：{}，result{}", JSON.toJSON(userInfoParam),JSON.toJSON(result));
                    TbOaDingTalkUser user=copyBeanProperty(result);
                    //修改为离职
                    user.setStatus(OaDingTalkEnums.JOB_STATUS_LEAVE.getCode());
                    tbOaDingTalkUserMapper.updateByPrimaryKey(user);
                }
            }
        }
    }

    /**
     * 拷贝钉钉用户属性
     * @param result
     * @return
     */
    private TbOaDingTalkUser copyBeanProperty(UserDetailsInfoResult result){

        TbOaDingTalkUser tbOaDingTalkUser=new TbOaDingTalkUser();
        //时间戳转换成date
        ZonedDateTime checkTimeZdt= LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(result.getHiredDate())), ZoneId.systemDefault()).atZone(ZoneId.systemDefault());
        tbOaDingTalkUser.setHiredDate(Date.from(checkTimeZdt.toInstant()));

        tbOaDingTalkUser.setDepartment(String.valueOf(result.getDepartment()).substring(1,String.valueOf(result.getDepartment()).length()-1));
        tbOaDingTalkUser.setUnionId(result.getUnionid());

        tbOaDingTalkUser.setJobNumber(result.getJobnumber());
        tbOaDingTalkUser.setMobile(result.getMobile());
        tbOaDingTalkUser.setName(result.getName());
        tbOaDingTalkUser.setPosition(result.getPosition());
        tbOaDingTalkUser.setUserId(result.getUserid());

        return tbOaDingTalkUser;
    }

}

