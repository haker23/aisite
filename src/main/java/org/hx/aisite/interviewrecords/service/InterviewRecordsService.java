package org.hx.aisite.interviewrecords.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.hx.aisite.interviewrecords.model.InterviewRecords;
import org.hx.aisite.interviewrecords.model.InterviewRecordsQueryReq;
import org.hx.aisite.interviewrecords.model.InterviewRecordsVo;


/**
 * 存储咨询访谈详细记录的表表服务接口
 *
 * @author zhanggk
 * @date 2024-06-14
 */
public interface InterviewRecordsService extends IService<InterviewRecords> {

    /**
     * 存储咨询访谈详细记录的表获取分页记录数
     *
     * @param queryReq 存储咨询访谈详细记录的表查询条件
     * @return
     * @author zhanggk
     */
    PageInfo<InterviewRecordsVo> selectPageList(InterviewRecordsQueryReq queryReq);

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     * @author zhanggk
     */
    InterviewRecordsVo selectById(String id);

    void save(InterviewRecordsVo interviewRecordsVo);
}
