/**
 * 版权所有：华信软件
 * 项目名称: 浙江ICT项目系统
 * 创建者: zhanggk
 * 创建日期: 2024-06-14
 * 文件说明: 见类描述
 */
package org.hx.aisite.interviewrecords.service;

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
public interface InterviewRecordsService{

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
}
