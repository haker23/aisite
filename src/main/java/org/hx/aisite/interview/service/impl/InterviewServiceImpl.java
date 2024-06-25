package org.hx.aisite.interview.service.impl;

import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hx.aisite.common.entity.ChatResponse;
import org.hx.aisite.common.server.AiChatServer;
import org.hx.aisite.interview.dao.InterviewDao;
import org.hx.aisite.interview.entity.Interview;
import org.hx.aisite.interview.entity.InterviewVo;
import org.hx.aisite.interview.service.InterviewService;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

@Service
public class InterviewServiceImpl extends ServiceImpl<InterviewDao, Interview> implements InterviewService {

    @Resource
    private InterviewDao interviewDao;

    @Resource
    private AiChatServer aiChatServer;

    @Override
    public InterviewVo createInterview(String userId) {
        InterviewVo interviewVo = new InterviewVo();

        interviewVo.setAppId(UUID.randomUUID().toString());

        interviewVo.setAppKey(UUID.randomUUID().toString());

        interviewVo.setCreator(userId);

        int insert = interviewDao.insert(interviewVo);

        return interviewVo;
    }

    @Override
    public InterviewVo join(String appId) {
        return null;
    }

    @Override
    public ChatResponse chat(String prompt) {
        String response = "";
        try {
            response = aiChatServer.qwenQuickStart(prompt);
        } catch (NoApiKeyException | InputRequiredException e) {
            throw new RuntimeException(e);
        }

        ChatResponse chatResponse = new ChatResponse();
        chatResponse.setResponseMsg(response);
        return chatResponse;
    }
}
