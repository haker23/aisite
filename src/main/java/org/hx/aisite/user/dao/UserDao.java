package org.hx.aisite.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.hx.aisite.user.entity.User;
import org.hx.aisite.user.entity.UserVo;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends BaseMapper<User> {

    /**
     * 获取用户基本信息
     *
     * @author fyh
     * @param userId:
     * @return org.hx.aisite.user.entity.UserVo
     * @date 2024/6/13 11:04
     **/
    UserVo getBaseInfo(String userId);

    /**
     * 根据用户名和用户类型获取用户
     *
     * @author fyh
     * @return org.hx.aisite.user.entity.UserVo
     * @date 2024/6/13 15:36
     **/
    UserVo getUserByAccountAndUserType(UserVo userVo);
}
