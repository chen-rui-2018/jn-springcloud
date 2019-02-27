package com.jn.enterprise.servicemarket.comment.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.comment.dao.CommentMapper;
import com.jn.enterprise.servicemarket.comment.dao.TbServiceRatingMapper;
import com.jn.enterprise.servicemarket.comment.entity.TbServiceRating;
import com.jn.enterprise.servicemarket.comment.model.*;
import com.jn.enterprise.servicemarket.comment.service.CommentService;
import com.jn.enterprise.servicemarket.org.dao.TbServiceOrgMapper;
import com.jn.enterprise.servicemarket.require.dao.TbServiceRequireMapper;
import com.jn.enterprise.servicemarket.require.entity.TbServiceRequire;
import com.jn.enterprise.servicemarket.require.entity.TbServiceRequireCriteria;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
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

    @Autowired
    private TbServiceRequireMapper requireMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserExtensionClient userExtensionClient;
    @Autowired
    private TbServiceOrgMapper tbServiceOrgMapper;
    @Autowired
    private TbServiceRatingMapper tbServiceRatingMapper;

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
        if(StringUtils.isNotEmpty(ratingParameter.getOrgId())){
            criteria.andOrgIdEqualTo(ratingParameter.getOrgId());
        }
        if(StringUtils.isNotEmpty(ratingParameter.getAdvisorAccount())){
            criteria.andAdvisorAccountEqualTo(ratingParameter.getAdvisorAccount());
        }
        if(StringUtils.isNotEmpty(ratingParameter.getProductId())){
            criteria.andProductIdEqualTo(ratingParameter.getProductId());
        }
        // 对他人评价，发布人为自己。
        criteria.andHandleResultEqualTo(REAUIRE_HANDLE_SUCCESS).andIssueAccountEqualTo(userAccount);
        List<TbServiceRequire> tbServiceRequires = requireMapper.selectByExample(requireCriteria);
        List<Rating> ratings = new ArrayList<>(8);
        for (TbServiceRequire serviceRequire: tbServiceRequires) {
            Rating rating = new Rating();
            BeanUtils.copyProperties(serviceRequire,rating);
            ratings.add(rating);
        }
        PaginationData data = new PaginationData(ratings, objects.getTotal());
        return data;
    }

    @Override
    @ServiceLog(doAction = "获取我收到的评价列表(机构/顾问收到的评价)")
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
        //通过ID查询对应需求
        TbServiceRequire serviceRequire = requireMapper.selectByPrimaryKey(id);
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(serviceRequire.getIssueAccount());
        String companyName = userExtension.getData().getCompanyCode();
        RatingDetail ratingDetail = commentMapper.getRatingCommentDetail(id);
        ratingDetail.setCompanyName(companyName);
        return ratingDetail;
    }

    @Override
    @ServiceLog(doAction = "保存评价信息")
    public Boolean saveRatingComment(CommentParameter commentParameter, String account){
        TbServiceRating tbServiceRating = new TbServiceRating();
        TbServiceRequire serviceRequire = requireMapper.selectByPrimaryKey(commentParameter.getId());
        if(null == serviceRequire){
            throw new JnSpringCloudException(OrgExceptionEnum.REQUIRE_IS_NOT_EXIT);
        }
        BeanUtils.copyProperties(serviceRequire,tbServiceRating);
        tbServiceRating.setEvaluatorAccount(account);
        tbServiceRating.setCreatedTime(new Date());
        tbServiceRating.setCreatorAccount(account);
        BeanUtils.copyProperties(commentParameter,tbServiceRating);
        int insert = tbServiceRatingMapper.insert(tbServiceRating);
        return insert==1?true:false;
    }

}
