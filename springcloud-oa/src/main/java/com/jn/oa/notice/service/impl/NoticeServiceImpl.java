package com.jn.oa.notice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.notice.dao.NoticeMapper;
import com.jn.oa.notice.dao.TbOaNoticeMapper;
import com.jn.oa.notice.enmus.NoticeExceptionEnmus;
import com.jn.oa.notice.entity.TbOaNotice;
import com.jn.oa.notice.entity.TbOaNoticeCriteria;
import com.jn.oa.notice.model.Notice;
import com.jn.oa.notice.model.NoticeAdd;
import com.jn.oa.notice.model.NoticePage;
import com.jn.oa.notice.service.NoticeService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 公告管理业务层
 *
 * @author： shaobao
 * @date： Created on 2019/2/12 15:32
 * @version： v1.0
 * @modified By:
 **/
@Service
public class NoticeServiceImpl implements NoticeService {

    private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

    @Autowired
    private TbOaNoticeMapper tbOaNoticeMapper;
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 添加/修改公告
     *
     * @param noticeAdd
     * @param user      当前用户信息
     * @param flag      添加修改标记,true添加,false删除
     */
    @Override
    @ServiceLog(doAction = "添加/修改公告")
    @Transactional(rollbackFor = Exception.class)
    public void addOrUpdateNotice(NoticeAdd noticeAdd, User user, Boolean flag) {
        String account = user.getAccount();
        String noticeId = noticeAdd.getId();

        TbOaNotice tbOaNotice = new TbOaNotice();
        BeanUtils.copyProperties(noticeAdd, tbOaNotice);

        //转换生效时间及失效时间格式
        try {
            Date effectiveTime = null;
            Date failureTime = null;
            //设置有效时间
            effectiveTime = DateUtils.parseDate(noticeAdd.getEffectiveTime(), "yyyy-MM-dd HH:mm:ss");
            tbOaNotice.setEffectiveTime(effectiveTime);

            //设置失效时间
            failureTime = DateUtils.parseDate(noticeAdd.getFailureTime(), "yyyy-MM-dd HH:mm:ss");
            tbOaNotice.setFailureTime(failureTime);

            if (effectiveTime != null && failureTime != null && effectiveTime.after(failureTime)) {
                throw new JnSpringCloudException(NoticeExceptionEnmus.NOTICE_TIME_ERROR);
            }
        } catch (ParseException e) {
            logger.warn("[公告管理] 新增公告时间转换失败。失败原因{}", e.getMessage(), e);
            throw new JnSpringCloudException(NoticeExceptionEnmus.NOTICE_TIME_PARSE_ERROR);
        }

        if (flag) {
            //添加操作,设置创建人及创建时间
            tbOaNotice.setCreatorAccount(account);
            tbOaNotice.setCreatedTime(new Date());

            tbOaNoticeMapper.insert(tbOaNotice);
            logger.info("[公告管理] 新增公告成功,noticeId:{}", noticeId);
        } else {
            //修改操作
            TbOaNotice tbOaNotice1 = tbOaNoticeMapper.selectByPrimaryKey(tbOaNotice.getId());
            if (tbOaNotice1 == null ||
                    StringUtils.equals(tbOaNotice1.getRecordStatus().toString(), OaStatusEnums.DELETED.getCode())) {
                logger.warn("[公告管理] 修改公告失败,修改信息不存在,noticeId:{}", noticeId);
                throw new JnSpringCloudException(NoticeExceptionEnmus.NOTICE_NOT_EXIST);
            }

            //设置最新修改人及修改时间
            tbOaNotice.setModifierAccount(account);
            tbOaNotice.setModifiedTime(new Date());

            tbOaNoticeMapper.updateByPrimaryKeySelective(tbOaNotice);
            logger.info("[公告管理] 修改公告成功,noticeId:{}", noticeId);
        }
    }

    /**
     * 条件分页获取公告列表信息
     *
     * @param noticePage 查询条件
     * @return
     */
    @Override
    @ServiceLog(doAction = "条件分页获取公告列表信息")
    public PaginationData<List<Notice>> list(NoticePage noticePage) {
        Page<Object> objects = PageHelper.startPage(noticePage.getPage(), noticePage.getRows());
        List<Notice> noticeList = noticeMapper.list(noticePage);
        PaginationData<List<Notice>> date = new PaginationData(noticeList, objects.getTotal());
        return date;
    }

    /**
     * 查询公告详情
     *
     * @param noticeId 公告id
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询公告详情")
    public Notice getNoticeById(String noticeId) {
        TbOaNotice tbOaNotice = tbOaNoticeMapper.selectByPrimaryKey(noticeId);
        //判断公告存在,且为删除时,返回公告内容
        if (tbOaNotice != null && !new Byte(OaStatusEnums.DELETED.getCode()).equals(tbOaNotice.getRecordStatus())) {
            Notice notice = new Notice();
            BeanUtils.copyProperties(tbOaNotice, notice);
            return notice;
        } else {
            logger.warn("[公告管理] 查询公告详情失败,noticeId:{}", noticeId);
            throw new JnSpringCloudException(NoticeExceptionEnmus.GET_NOTICE_ERROR);
        }
    }

    /**
     * 发布公告
     *
     * @param platformType 平台类型
     * @return
     */
    @Override
    @ServiceLog(doAction = "发布公告")
    public List<Notice> publishNotice(String platformType) {
        //设置查询条件
        TbOaNoticeCriteria tbOaNoticeCriteria = new TbOaNoticeCriteria();
        //设置排序
        tbOaNoticeCriteria.setOrderByClause("created_time desc");

        TbOaNoticeCriteria.Criteria criteria = tbOaNoticeCriteria.createCriteria();
        //查询状态有效的公告
        criteria.andRecordStatusEqualTo(new Byte(OaStatusEnums.EFFECTIVE.getCode()));
        //查询对应发布平台公告
        criteria.andPlatformTypeLike("%\"key\":\"" + platformType + "\"%");
        //查询复合当前发布日期的公告
        criteria.andEffectiveTimeLessThan(new Date());
        criteria.andFailureTimeGreaterThan(new Date());

        List<TbOaNotice> tbOaNotices = tbOaNoticeMapper.selectByExample(tbOaNoticeCriteria);

        List<Notice> noticeList = new ArrayList<Notice>(16);
        for (TbOaNotice tbOaNotice : tbOaNotices) {
            Notice notice = new Notice();
            BeanUtils.copyProperties(tbOaNotice, notice);
            notice.setNoticeContent(null);
            noticeList.add(notice);
        }
        return noticeList;
    }

    /**
     * (逻辑)删除公告
     *
     * @param noticeId 公告id
     * @param user     当前用户信息
     */
    @Override
    @ServiceLog(doAction = "(逻辑)删除公告")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String noticeId, User user) {
        TbOaNotice tbOaNotice = tbOaNoticeMapper.selectByPrimaryKey(noticeId);
        if (tbOaNotice != null) {
            //设置状态为删除状态
            tbOaNotice.setRecordStatus(new Byte(OaStatusEnums.DELETED.getCode()));
            //设置最新更新人及更新时间
            tbOaNotice.setModifiedTime(new Date());
            tbOaNotice.setModifierAccount(user.getAccount());
            tbOaNoticeMapper.updateByPrimaryKeySelective(tbOaNotice);
        }
        logger.info("[公告管理] (逻辑)删除公告成功,noticeId:{}", noticeId);
    }
}
