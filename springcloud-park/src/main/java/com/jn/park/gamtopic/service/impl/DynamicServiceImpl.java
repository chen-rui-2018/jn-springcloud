package com.jn.park.gamtopic.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.comment.dao.TbCommentMapper;
import com.jn.park.enums.GamTopicExceptionEnum;
import com.jn.park.fileimg.service.FileImgService;
import com.jn.park.gamtopic.dao.DynamicDao;
import com.jn.park.gamtopic.dao.TbGamTopicMapper;
import com.jn.park.gamtopic.dao.TbPersonCareMapper;
import com.jn.park.gamtopic.entity.TbGamTopic;
import com.jn.park.gamtopic.entity.TbPersonCare;
import com.jn.park.gamtopic.entity.TbPersonCareCriteria;
import com.jn.park.gamtopic.enums.DynamicEnum;
import com.jn.park.gamtopic.model.*;
import com.jn.park.gamtopic.service.DynamicService;
import com.jn.park.gamtopic.vo.DnnamicCommentDetailsVo;
import com.jn.park.gamtopic.vo.DynamicWebDetailsVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import com.jn.user.model.UserInfoQueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/10 11:07
 * @version： v1.0
 * @modified By:
 */
@Service
public class DynamicServiceImpl implements DynamicService {
    /**
     * 日志组件
     */
    Logger logger  = LoggerFactory.getLogger(DynamicServiceImpl.class);

    @Autowired
    private FileImgService fileImgService;

    @Autowired
    private TbGamTopicMapper tbGamTopicMapper;

    @Autowired
    private  UserExtensionClient userExtensionClient;

    @Autowired
    private DynamicDao dynamicDao;
    @Autowired
    private TbPersonCareMapper tbPersonCareMapper;
    @Autowired
    private TbCommentMapper tbCommentMapper;


    @ServiceLog(doAction = "发布匝道")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addDynamicInfo(DynamicAddParam dynamicAddParam, String dynamicId, String account) {
        // 状态值为 1 ( 有效 )
        byte recordStatus = 1;
        String  status = "1";
        //如果内容和图片均为空,则不允许发表态,提示进行内容输入
        if (StringUtils.isBlank(dynamicAddParam.getTopicContent()) && dynamicAddParam.getImgs()== null ){
            logger.info("{发布动态时,动态文本 和 图片不能都为空!}");
            throw new JnSpringCloudException(GamTopicExceptionEnum.DYNAMIC_CONTENT_IS_NULL);

        }
        // 完善动态基本信息
        TbGamTopic tbGamTopic = new TbGamTopic();
        BeanUtils.copyProperties(dynamicAddParam,tbGamTopic);
        tbGamTopic.setTopicId(dynamicId);
        tbGamTopic.setCreatorAccount(account);
        tbGamTopic.setCreatedTime(new Date());
        tbGamTopic.setRecordStatus(recordStatus);
        tbGamTopic.setTopicStatus(status);
        //保存动态信息
        int i = tbGamTopicMapper.insertSelective(tbGamTopic);
        //图片列表不为空则 进行图片路径的存储
        if(dynamicAddParam.getImgs() !=null && dynamicAddParam.getImgs().size()>0){
            fileImgService.saveFileImgList(dynamicAddParam.getImgs(),account,dynamicId);
        }
        return i;
    }
    @ServiceLog(doAction = "根据条件查找后台动态列表")
    @Override
    public PaginationData<List<DynamicManageShow>> findDynamicList(DynamicQueryParam queryParam) {
        Result<List<String>> result = null;
        Page<Object> objects = null;
        int pageSize = queryParam.getRows()==0 ? 15 :  queryParam.getRows();
        int pageNum  = queryParam.getPage();
        // 如果 昵称和 电话不为空,则进行用户的查询;
        if(StringUtils.isNotBlank(queryParam.getNickName()) || StringUtils.isNotBlank(queryParam.getPhone())){
            UserInfoQueryParam param= new UserInfoQueryParam();
            param.setNickName(queryParam.getNickName());
            param.setPhone(queryParam.getPhone());
            result =  userExtensionClient.getAccountList(param);
            // 未找到此用户则返回null
            if(result.getData().isEmpty()){
                return  null;
            }
            // 根据账号列表 和 其他条件查找动态列表
            List<String> accountList = result.getData();
            objects = PageHelper.startPage(pageNum,pageSize,true);
            List<DynamicManageShow>  dynamicList = dynamicDao.findDynamicList(queryParam.getStartTime(),queryParam.getEndTime(),accountList);
            if(!dynamicList.isEmpty()) {
                dynamicList = improveUserInfo(dynamicList);
            }
            return  new PaginationData<>(dynamicList,objects==null?0:objects.getTotal());
        }else{
            objects = PageHelper.startPage(pageNum,pageSize,true);
            List<DynamicManageShow>  dynamicList = dynamicDao.findDynamicList(queryParam.getStartTime(),queryParam.getEndTime(),null);
            if(!dynamicList.isEmpty()) {
                dynamicList = improveUserInfo(dynamicList);
            }
            return  new PaginationData<>(dynamicList,objects==null?0:objects.getTotal());
        }
    }
    @ServiceLog(doAction = "后台查看动态详情")
    @Override
    public DynamicManageDetails findDynamicDetails(String dynamicId) {
        DynamicManageDetails details =  dynamicDao.findDynamicDetails(dynamicId);
        if(details == null){
            logger.info("{此条动态已不存在!}");
            throw new JnSpringCloudException(GamTopicExceptionEnum.DYNAMIC_IS_NOT_EXIST);
        }
        //完善用户信息
        Result<UserExtensionInfo> reault=  userExtensionClient.getUserExtension(details.getCreatorAccount());
        UserExtensionInfo userExtensionInfo = reault.getData();
        details.setAvatar(userExtensionInfo.getAvatar());
        details.setNickName(userExtensionInfo.getNickName());
        return details;
    }
    @ServiceLog(doAction = "后台删除动态")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteDynamicInfo(String dynamicId,String account) {
        //进行逻辑删除,将动态状态和记录状态均设为无效;
         String topicStatus = "0";
         Byte recordStatus = 0;
         TbGamTopic gamTopic = new TbGamTopic();
         gamTopic.setTopicId(dynamicId);
         gamTopic.setTopicStatus(topicStatus);
         gamTopic.setRecordStatus(recordStatus);
         gamTopic.setModifierAccount(account);
         gamTopic.setModifiedTime(new Date());
        int i = tbGamTopicMapper.updateByPrimaryKeySelective(gamTopic);
        return i;
    }
    @ServiceLog(doAction = "查找前台用户的动态列表")
    @Override
    public PaginationData<List<DynamicWebShow>> findDynamicWebList(com.jn.common.model.Page page,String account) {
        int pageNum = page.getPage();
        int pageSize = page.getRows()==0?15:page.getRows();
        //获得用户关注的账号,可获取已关注,类型为需关注才能查看的动态列表
        List<String>  accountList = new ArrayList<>();
        TbPersonCareCriteria careCriteria = new TbPersonCareCriteria();
        careCriteria.createCriteria().andCareAccountEqualTo(account);
        List<TbPersonCare> cares =  tbPersonCareMapper.selectByExample(careCriteria);
        if(!cares.isEmpty()){
            for(TbPersonCare care : cares){
                accountList.add(care.getReceiveAccount());
            }
        }else{
            accountList =null;
        }
        Page<Object> objects = PageHelper.startPage(pageNum,pageSize,true);
        List<DynamicWebShow> dynamicWebList =   dynamicDao.findDynamicWebList(accountList,account);
        if(!dynamicWebList.isEmpty()) {
            dynamicWebList = improveWebUserInfo(dynamicWebList);
        }
        for(DynamicWebShow show :dynamicWebList){
            show.setIsSelf(show.getCreatorAccount().equals(account)? DynamicEnum.IS_SELF.getCode():DynamicEnum.NOT_IS_SELF.getCode());
        }
        return new PaginationData<>(dynamicWebList,objects==null?0:objects.getTotal() );
    }
    @ServiceLog(doAction = "查找前台用户关注的用户的动态列表")
    @Override
    public PaginationData<List<DynamicWebShow>> findCareDynamicList(com.jn.common.model.Page page, String account) {
        int pageNum = page.getPage();
        int pageSize = page.getRows()==0?15:page.getRows();
        Page<Object> objects = PageHelper.startPage(pageNum,pageSize,true);
        List<DynamicWebShow> dynamicWebList =   dynamicDao.findCareDynamicList(account);
        if(!dynamicWebList.isEmpty()) {
            dynamicWebList = improveWebUserInfo(dynamicWebList);
        }
        return new PaginationData<>(dynamicWebList,objects==null?0:objects.getTotal() );
    }

    @ServiceLog(doAction = "查找前台动态详情+评论列表")
    @Override
    public DynamicWebDetailsVo findDynamicWebDetails(String dynamicId,String account) {
        DynamicWebDetailsVo  vo = new DynamicWebDetailsVo();
       //获取动态详情
        DynamicWebShow dynamicWebShow =  dynamicDao.findDynamicWebDetails(dynamicId);

        if(dynamicWebShow != null){
            Result<UserExtensionInfo> result = userExtensionClient.getUserExtension(dynamicWebShow.getCreatorAccount());
            UserExtensionInfo info = result.getData();
            if(info!=null) {
                dynamicWebShow.setAvatar(info.getAvatar());
                dynamicWebShow.setNickName(info.getNickName());
            }
            if (StringUtils.isNotBlank(dynamicWebShow.getImgString())){
                String imgString = dynamicWebShow.getImgString();
                dynamicWebShow.setImgList(Arrays.asList(imgString.split(",")));
            }
            //是否为自己发布的动态
            if(dynamicWebShow.getCreatorAccount().equals(account)){
                dynamicWebShow.setIsSelf(DynamicEnum.IS_SELF.getCode());
            }else{
                dynamicWebShow.setIsSelf(DynamicEnum.NOT_IS_SELF.getCode());
            }
            vo.setDynamicWebShow(dynamicWebShow);
            DynamicCommentsParam param = new DynamicCommentsParam();
            param.setParamId(dynamicId);
            param.setPage(1);
            param.setRows(10);
            //获取评论列表
            PaginationData<List<DynamicCommentReplyShow>> data = findDynamicCommentAndReplyList(param);
            if(data != null) {
                List<DynamicCommentReplyShow> commentsList = data.getRows();
                if (!commentsList.isEmpty()) {
                    commentsList = improveWebCommentAndReplyUserInfo(commentsList);
                    vo.setCommentList(data);
                }
            }

        }
        return vo;
    }
    @ServiceLog(doAction = "动态评论列表查询")
    @Override
    public PaginationData<List<DynamicComments>> findDynamicComments(DynamicCommentsParam param) {
       int pageSize  = param.getRows()==0?15:param.getRows();
       int pageNum = param.getPage();
        Page objects = PageHelper.startPage(pageNum,pageSize,true);
        List<DynamicComments> commentsList = dynamicDao.findDynamicComments(param.getParamId());
        if(!commentsList.isEmpty()){
            commentsList = improveWebCommentUserInfo(commentsList);
        }
        return new PaginationData<>(commentsList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "评论详情(评论信息+回复列表+点赞信息)")
    @Override
    public DnnamicCommentDetailsVo findDynamicCommentsDetails(String commentId) {
        DnnamicCommentDetailsVo vo =  new DnnamicCommentDetailsVo();
        //当前评论信息
        DynamicComments comments =  dynamicDao.findCommentsInfo(commentId);
        Result<UserExtensionInfo> result = userExtensionClient.getUserExtension(comments.getCreatorAccount());
        UserExtensionInfo info = result.getData();
        if(info!=null) {
            comments.setAvatar(info.getAvatar());
            comments.setNickName(info.getNickName());
        }
        vo.setDynamicComments(comments);
        //评论回复列表
        DynamicCommentsParam paramComment = new DynamicCommentsParam();
        paramComment.setParamId(commentId);
        vo.setCommentList(findCommentReplyList(paramComment));
        //点赞人列表
        DynamicCommentsParam paramLike = new DynamicCommentsParam();
        paramLike.setParamId(commentId);
        vo.setUserList(findLikedUserInfoList(paramLike));
        return vo;
    }
    @ServiceLog(doAction = "评论回复列表")
    @Override
    public PaginationData<List<DynamicComments>> findCommentReplyList(DynamicCommentsParam param) {
        int pageSize  = param.getRows()==0?15:param.getRows();
        int pageNum = param.getPage();
        Page objects = PageHelper.startPage(pageNum,pageSize,true);
        List<DynamicComments> commentsList = dynamicDao.findCommentReplyList(param.getParamId());
        if(!commentsList.isEmpty()){
            commentsList = improveWebCommentUserInfo(commentsList);
        }
        return new PaginationData<>(commentsList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "点赞用户列表")
    @Override
    public PaginationData<List<LikedUserInfo>> findLikedUserInfoList(DynamicCommentsParam param) {
        int pageSize  = param.getRows()==0?15:param.getRows();
        int pageNum = param.getPage();
        Page objects = PageHelper.startPage(pageNum,pageSize,true);
        List<LikedUserInfo> userInfoList =   dynamicDao.findLikedUserInfoList(param.getParamId());
        if(!userInfoList.isEmpty()){
            userInfoList =   improveLikedUserInfo(userInfoList);
        }
        return new PaginationData<>(userInfoList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "根据评用户账号,当前用户动态列表")
    @Override
    public PaginationData<List<DynamicWebShow>> findDynamicByAccount(CareDetailsQueryParam param,String currentAccount) {
        int pageNum = param.getPage();
        int pageSize = param.getRows()==0?15:param.getRows();
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(pageNum,pageSize,true);
        //如果 当前的登录账号和 要查看的账号一致,则可以查看自身所有类型 动态,否则只能查看 公开 或关注 类型的动态
        if(param.getParamAccount().equals(currentAccount)){
            currentAccount = null;
        }
        List<DynamicWebShow> dynamicList = dynamicDao.findDynamicByAccount(param.getParamAccount(),currentAccount);
        if(!dynamicList.isEmpty()){
            dynamicList = improveWebUserInfo(dynamicList);
        }
        return new PaginationData<>(dynamicList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "根据动态id 返回动态评论列表+ 评论回复列表")
    @Override
    public PaginationData<List<DynamicCommentReplyShow>> findDynamicCommentAndReplyList(DynamicCommentsParam param) {
        int pageSize  = param.getRows()==0?15:param.getRows();
        int pageNum = param.getPage();
        Page objects = PageHelper.startPage(pageNum,pageSize,true);
        List<DynamicCommentReplyShow> commentsList = dynamicDao.findDynamicCommentAndReplyList(param.getParamId());
        if(!commentsList.isEmpty()){
            commentsList = improveWebCommentAndReplyUserInfo(commentsList);
            List<String> parentIdList = new ArrayList<>();
            for (DynamicCommentReplyShow show : commentsList){
                      parentIdList.add(show.getCommentId());
            }
            List<DynamicComments> replyList =  dynamicDao.findReplyList(parentIdList);
            if(!replyList.isEmpty()){
                replyList = improveWebCommentUserInfo(replyList);
            }
            for(DynamicCommentReplyShow show : commentsList){
                List<DynamicComments>  list = new ArrayList<>();
                show.setReplyList(list);
                for (DynamicComments comments : replyList){
                    if(comments.getParentId().equals(show.getCommentId())){
                        show.getReplyList().add(comments);
                    }
                }
            }
        }


        return new PaginationData(commentsList,objects==null?0:objects.getTotal());
    }

    /**
     * 完善点赞用户信息
     * @param userInfos
     * @return
     */
    private  List<LikedUserInfo> improveLikedUserInfo(List<LikedUserInfo> userInfos){
        List<String> accountList = new ArrayList<>();
        for(LikedUserInfo show : userInfos){
            accountList.add(show.getAccount());
        }
        Result<List<UserExtensionInfo>> result = userExtensionClient.getMoreUserExtension(accountList);
        if(!result.getData().isEmpty()){
            List<UserExtensionInfo> userList = result.getData();
            for(LikedUserInfo show : userInfos){
                for(UserExtensionInfo user : userList){
                    if(show.getAccount().equals(user.getAccount())){
                        show.setAvatar(user.getAvatar());
                        show.setNickName(user.getNickName());
                        show.setSignature(user.getSignature());
                    }
                }
            }
        }
        return userInfos;
    }

    /**
     * 前台动态详情完善评论用户信息
     * @return
     */
    private  List<DynamicComments>  improveWebCommentUserInfo( List<DynamicComments> commentsList){
        List<String> accountList = new ArrayList<>();
        for(DynamicComments show : commentsList){
            accountList.add(show.getCreatorAccount());
        }
        Result<List<UserExtensionInfo>> result = userExtensionClient.getMoreUserExtension(accountList);
        if(!result.getData().isEmpty()){
            List<UserExtensionInfo> userList = result.getData();
            for(DynamicComments show : commentsList){
                for(UserExtensionInfo user : userList){
                    if(show.getCreatorAccount().equals(user.getAccount())){
                        show.setAvatar(user.getAvatar());
                        show.setNickName(user.getNickName());
                    }
                }
            }
        }
        return commentsList;
    }
    /**
     * 前台动态详情完善评论用户信息
     * @return
     */
    private   List<DynamicCommentReplyShow>  improveWebCommentAndReplyUserInfo(List<DynamicCommentReplyShow> commentsList){
        List<String> accountList = new ArrayList<>();
        for(DynamicCommentReplyShow show : commentsList){
            accountList.add(show.getCreatorAccount());
        }
        Result<List<UserExtensionInfo>> result = userExtensionClient.getMoreUserExtension(accountList);
        if(!result.getData().isEmpty()){
            List<UserExtensionInfo> userList = result.getData();
            for(DynamicCommentReplyShow show : commentsList){
                for(UserExtensionInfo user : userList){
                    if(show.getCreatorAccount().equals(user.getAccount())){
                        show.setAvatar(user.getAvatar());
                        show.setNickName(user.getNickName());
                    }
                }
            }
        }
        return commentsList;
    }
    /**
     * 前台列表完善用户信息
     * @return
     */
    private  List<DynamicWebShow> improveWebUserInfo( List<DynamicWebShow> dynamicList){
        List<String> accountList = new ArrayList<>();
        for(DynamicWebShow show : dynamicList){
            accountList.add(show.getCreatorAccount());
        }
        Result<List<UserExtensionInfo>> result = userExtensionClient.getMoreUserExtension(accountList);
        if(!result.getData().isEmpty()){
            List<UserExtensionInfo> userList = result.getData();
            for(DynamicWebShow show : dynamicList){
                for(UserExtensionInfo user : userList){
                    if(show.getCreatorAccount().equals(user.getAccount())){
                        show.setAvatar(user.getAvatar());
                        show.setNickName(user.getNickName());
                        show.setCompanyName(user.getCompanyName());
                        if(StringUtils.isNotBlank(show.getImgString())){
                            String imgs = show.getImgString();
                            show.setImgList(Arrays.asList(imgs.split(",")));
                            show.setImgString("");
                        }
                    }
                }
            }
        }
        return dynamicList;
    }

    /**
     * 后台列表完善用户信息
     * @return
     */
    private List<DynamicManageShow> improveUserInfo(List<DynamicManageShow> dynamicList){
        List<String> accountList = new ArrayList<>();
        for(DynamicManageShow show : dynamicList){
            accountList.add(show.getCreatorAccount());
        }
        Result<List<UserExtensionInfo>> result = userExtensionClient.getMoreUserExtension(accountList);
        if(!result.getData().isEmpty()){
            List<UserExtensionInfo> userList = result.getData();
            for(DynamicManageShow show : dynamicList){
                for(UserExtensionInfo user : userList){
                    if(show.getCreatorAccount().equals(user.getAccount())){
                        show.setAvatar(user.getAvatar());
                        show.setNickName(user.getNickName());
                        show.setPhone(user.getPhone());
                        show.setSex(user.getSex());
                    }
                }
            }
        }
        return dynamicList;
    }
}
