package org.hx.aisite.interview.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hx.aisite.common.entity.ChatResponse;
import org.hx.aisite.interview.entity.Interview;
import org.hx.aisite.interview.entity.InterviewVo;

public interface InterviewService extends IService<Interview> {
    InterviewVo createInterview(String userId);

    InterviewVo join(String appId);

    ChatResponse chat(String prompt);
}
