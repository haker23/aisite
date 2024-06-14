package org.hx.aisite.interviewrecords.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hx.aisite.interviewrecords.dao.InterviewRecordsDao;
import org.hx.aisite.interviewrecords.model.InterviewRecords;
import org.hx.aisite.interviewrecords.model.InterviewRecordsQueryReq;
import org.hx.aisite.interviewrecords.model.InterviewRecordsVo;
import org.hx.aisite.interviewrecords.service.InterviewRecordsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 存储咨询访谈详细记录的表服务实现类
 *
 * @author zhanggk
 * @date 2024-06-14
 */
@Service
public class InterviewRecordsServiceImpl implements InterviewRecordsService {

    /**
     * 存储咨询访谈详细记录的表(InterviewRecords) 数据访问
     */
    @Resource
    private InterviewRecordsDao interviewRecordsDao;

    /**
     * 存储咨询访谈详细记录的表获取分页记录数
     *
     * @param queryReq 存储咨询访谈详细记录的表(InterviewRecords)信息
     * @return
     * @author zhanggk
     */
    @Override
    public PageInfo<InterviewRecordsVo> selectPageList(InterviewRecordsQueryReq queryReq) {
        Page<InterviewRecordsVo> page = PageHelper.startPage(queryReq.getPageNum(), queryReq.getPageSize());

        List<InterviewRecordsVo> list = interviewRecordsDao.selectPageList(queryReq);

        return page.toPageInfo();
    }

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     * @author zhanggk
     */
    @Override
    public InterviewRecordsVo selectById(String id) {
        return interviewRecordsDao.selectById(id);
    }
}

