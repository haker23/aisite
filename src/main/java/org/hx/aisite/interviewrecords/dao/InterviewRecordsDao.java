package org.hx.aisite.interviewrecords.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.hx.aisite.interviewrecords.model.InterviewRecords;
import org.hx.aisite.interviewrecords.model.InterviewRecordsQueryReq;
import org.hx.aisite.interviewrecords.model.InterviewRecordsVo;

import java.io.Serializable;

/**
 * 存储咨询访谈详细记录的表Dao接口
 *
 * @author zhanggk
 * @date 2024-06-14
 */
public interface InterviewRecordsDao extends BaseMapper<InterviewRecords> {

    /**
     * 存储咨询访谈详细记录的表分页查询
     *
     * @param queryReq
     * @return
     * @author zhanggk
     */
    List<InterviewRecordsVo> selectPageList(InterviewRecordsQueryReq queryReq);

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     * @author zhanggk
     */
    @Override
    InterviewRecordsVo selectById(Serializable id);

}

