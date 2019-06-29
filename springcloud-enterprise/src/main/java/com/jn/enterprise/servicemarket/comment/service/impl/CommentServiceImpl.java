package com.jn.enterprise.servicemarket.comment.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.enterprise.servicemarket.comment.dao.CommentMapper;
import com.jn.enterprise.servicemarket.comment.dao.TbServiceRatingMapper;
import com.jn.enterprise.servicemarket.comment.entity.TbServiceRating;
import com.jn.enterprise.servicemarket.comment.enums.HandleResultEnum;
import com.jn.enterprise.servicemarket.comment.model.*;
import com.jn.enterprise.servicemarket.comment.service.CommentService;
import com.jn.enterprise.servicemarket.require.dao.TbServiceRequireMapper;
import com.jn.enterprise.servicemarket.require.entity.TbServiceRequire;
import com.jn.enterprise.servicemarket.require.entity.TbServiceRequireCriteria;
import com.jn.park.enums.CommentExceptionEnum;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/25 15:36
 * @version： v1.0
 * @modified By:
 */
@Service
public class CommentServiceImpl implements CommentService {
    private static Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    private TbServiceRequireMapper requireMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private TbServiceRatingMapper tbServiceRatingMapper;

    @Autowired
    private UserExtensionClient userExtensionClient;

    /**
     * 需求对接状态 1成功
     */
    private static final String REAUIRE_HANDLE_SUCCESS = "1";

    @Override
    @ServiceLog(doAction = "获取对他人的评价列表(客户对机构的评价)")
    public PaginationData getGiveOthersCommentList(RatingParameter ratingParameter,String userAccount){
        Page<Object> objects = PageHelper.startPage(ratingParameter.getPage(), ratingParameter.getRows() == 0 ? 15 : ratingParameter.getRows());
        TbServiceRequireCriteria requireCriteria = new TbServiceRequireCriteria();
        TbServiceRequireCriteria.Criteria criteria = requireCriteria.createCriteria();
        if(StringUtils.isNotEmpty(ratingParameter.getOrgName())){
            criteria.andOrgNameLike("%"+ratingParameter.getOrgName()+"%");
        }
        if(StringUtils.isNotEmpty(ratingParameter.getAdvisorAccount())){
            criteria.andAdvisorAccountEqualTo(ratingParameter.getAdvisorAccount());
        }
        if(StringUtils.isNotEmpty(ratingParameter.getProductName())){
            criteria.andProductNameLike("%"+ratingParameter.getProductName()+"%");
        }
        // 对他人评价，发布人为自己。
        criteria.andHandleResultEqualTo(REAUIRE_HANDLE_SUCCESS).andIssueAccountEqualTo(userAccount);
        List<TbServiceRequire> tbServiceRequires = requireMapper.selectByExample(requireCriteria);
        List<Rating> ratings = new ArrayList<>(8);
        for (TbServiceRequire serviceRequire: tbServiceRequires) {
            Rating rating = new Rating();
            BeanUtils.copyProperties(serviceRequire,rating);
            rating.setIssueTime(serviceRequire.getIssueTime()==null?"":(DateUtils.formatDate(serviceRequire.getIssueTime(),"yyyy-MM-dd HH:mm:ss")));
            rating.setCommentTime(serviceRequire.getCommentTime()==null?"":(DateUtils.formatDate(serviceRequire.getCommentTime(),"yyyy-MM-dd HH:mm:ss")));
            rating.setHandleTime(serviceRequire.getHandleTime()==null?"":(DateUtils.formatDate(serviceRequire.getHandleTime(),"yyyy-MM-dd HH:mm:ss")));
            rating.setBusinessId(serviceRequire.getBusinessId());
            ratings.add(rating);
        }
        PaginationData data = new PaginationData(ratings, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "获取我收到的评价列表(机构/专员收到的评价)")
    public PaginationData getGiveMeCommentList(ReceiveRatingParameter receiveRatingParameter, String userAccount){
        Page<Object> objects = PageHelper.startPage(receiveRatingParameter.getPage(), receiveRatingParameter.getRows() == 0 ? 15 : receiveRatingParameter.getRows());
        receiveRatingParameter.setAccount(userAccount);
        List<Rating> giveMeCommentList = commentMapper.getGiveMeCommentList(receiveRatingParameter);
        PaginationData data = new PaginationData(giveMeCommentList, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "获取评价页详情")
    public RatingDetail getRatingCommentDetail(String id){
        RatingDetail ratingDetail = commentMapper.getRatingCommentDetail(id);
        if (StringUtils.isNotBlank(ratingDetail.getReqPhone())) {
            String account = ratingDetail.getReqPhone();
            Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(account);
            if (userExtension != null && userExtension.getData() != null) {
                UserExtensionInfo userExtensionInfo = userExtension.getData();
                if (StringUtils.isNotBlank(userExtensionInfo.getCompanyName())) {
                    ratingDetail.setCompanyName(userExtensionInfo.getCompanyName());
                }
            }
        }
        return ratingDetail;
    }

    @Override
    @ServiceLog(doAction = "保存评价信息")
    public Boolean saveRatingComment(CommentParameter commentParameter, String account){
        TbServiceRating tbServiceRating = new TbServiceRating();
        TbServiceRequire serviceRequire = requireMapper.selectByPrimaryKey(commentParameter.getId());
        if(null == serviceRequire){
            logger.warn("需求不存在，请核实数据");
            throw new JnSpringCloudException(OrgExceptionEnum.REQUIRE_IS_NOT_EXIT);
        }
        //判断当前需求是否允许评价(对接成功才允许评价)
        //对接结果(1:对接成功  2:对接失败  3:企业需求撤销 4:未对接)
        long existNum = successRequireIsExist(commentParameter);
        if(existNum==0){
            logger.warn("当前需求对接结果非“对接成功”,不允许评价");
            throw new JnSpringCloudException(CommentExceptionEnum.NOT_ALLOW_COMMENT);
        }
        TbServiceRating ratingOld = tbServiceRatingMapper.selectByPrimaryKey(commentParameter.getId());
        if(null != ratingOld){
            throw new JnSpringCloudException(OrgExceptionEnum.COMMENT_IS_EXIST);
        }
        BeanUtils.copyProperties(serviceRequire,tbServiceRating);
        tbServiceRating.setEvaluatorAccount(account);
        tbServiceRating.setCreatedTime(new Date());
        tbServiceRating.setCreatorAccount(account);
        tbServiceRating.setRequireId(commentParameter.getId());
        BeanUtils.copyProperties(commentParameter,tbServiceRating);

        TbServiceRequire tbServiceRequire = new TbServiceRequire();
        tbServiceRequire.setId(commentParameter.getId());
        tbServiceRequire.setIsComment("1");
        tbServiceRequire.setCommentTime(new Date());
        int i = requireMapper.updateByPrimaryKeySelective(tbServiceRequire);
        logger.info("提交评论，修改需求表评论状态，需求iD：{}，响应条数：{}",commentParameter.getId(),i);
        int insert = tbServiceRatingMapper.insert(tbServiceRating);
        return insert==1?true:false;
    }

    /**
     * 对接成功需求是否存在
     * @param commentParameter
     * @return
     */
    @ServiceLog(doAction = "对接成功需求是否存在")
    private long successRequireIsExist(CommentParameter commentParameter) {
        TbServiceRequireCriteria example=new TbServiceRequireCriteria();
        example.createCriteria().andIdEqualTo(commentParameter.getId())
                .andHandleResultEqualTo(HandleResultEnum.DOCKING_SUCCESS.getCode())
                .andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        return requireMapper.countByExample(example);
    }

}
