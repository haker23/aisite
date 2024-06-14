package org.hx.aisite.interview.control;

import org.hx.aisite.common.entity.ChatResponse;
import org.hx.aisite.interview.entity.InterviewVo;
import org.hx.aisite.interview.service.InterviewService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/interview")
public class InterviewControl {

    @Resource
    private InterviewService interviewService;

    @RequestMapping("/create")
    @ResponseBody
    public InterviewVo createInterview(@RequestParam("userId") String userId) {
        return interviewService.createInterview(userId);
    }

    @RequestMapping("/join")
    @ResponseBody
    public InterviewVo joinInterview(@RequestParam("appId") String appId) {
        return interviewService.join(appId);
    }

    @RequestMapping("/chat/{prompt}")
    @ResponseBody
    public ChatResponse chat(@PathVariable("prompt") String prompt) {
        return interviewService.chat(prompt);
    }
}
