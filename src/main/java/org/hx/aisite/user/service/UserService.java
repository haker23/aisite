package org.hx.aisite.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.hx.aisite.user.entity.User;
import org.hx.aisite.user.entity.UserVo;

public interface UserService extends IService<User> {

    /**
     * 获取用户基本信息
     *
     * @author fyh
     * @param userId:
     * @return org.hx.aisite.user.entity.UserVo
     * @date 2024/6/13 11:02
     **/
    UserVo getBaseInfo(@Param("userId") String userId);

    /**
     * 登录
     *
     * @author fyh
     * @param loginForm:
     * @return org.hx.aisite.user.entity.UserVo
     * @date 2024/6/13 11:02
     **/
    UserVo login(UserVo loginForm);

    /**
     * 注册
     *
     * @author fyh
     * @param userForm:
     * @return org.hx.aisite.user.entity.UserVo
     * @date 2024/6/13 15:51
     **/
    UserVo signUp(UserVo userForm);
}
