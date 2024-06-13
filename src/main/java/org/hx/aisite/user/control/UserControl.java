package org.hx.aisite.user.control;

import org.hx.aisite.user.entity.UserVo;
import org.hx.aisite.user.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 *
 * @return
 * @date 2024/6/5 8:47
 **/
@Controller
@RequestMapping("/")
public class UserControl {

    @Resource(name = "defaultUserServiceImpl")
    private UserService defaultUserService;

    /**
     * 获取用户基本信息你
     *
     * @author fyh
     * @param userId:
     * @return org.hx.aisite.user.entity.UserVo
     * @date 2024/6/13 11:01
     **/
    @RequestMapping(value = "/baseinfo/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserVo getBaseInfo(@PathVariable("userId") String userId) {
        return defaultUserService.getBaseInfo(userId);
    }

    /**
     * 登录
     *
     * @author fyh
     * @param loginForm:
     * @return org.hx.aisite.user.entity.UserVo
     * @date 2024/6/13 11:01
     **/
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserVo login(@RequestBody UserVo loginForm) {
        return defaultUserService.login(loginForm);
    }

    /**
     * 注册
     *
     * @author fyh
     * @param userForm:
     * @return org.hx.aisite.user.entity.UserVo
     * @date 2024/6/13 11:01
     **/
    @RequestMapping(value = "/signup", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserVo signUp(@RequestBody UserVo userForm) {
        return defaultUserService.signUp(userForm);
    }
}
