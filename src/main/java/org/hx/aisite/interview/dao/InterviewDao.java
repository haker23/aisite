package org.hx.aisite.interview.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hx.aisite.interview.entity.Interview;

@Mapper
public interface InterviewDao extends BaseMapper<Interview> {
}
