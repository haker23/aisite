package org.hx.aisite.user.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hx.aisite.common.entity.BizException;
import org.hx.aisite.common.entity.ResponseResult;
import org.hx.aisite.common.enums.ResponseCodeEnum;
import org.hx.aisite.user.dao.UserDao;
import org.hx.aisite.user.entity.User;
import org.hx.aisite.user.entity.UserVo;
import org.hx.aisite.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class DefaultUserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    /**
     * User Dao
     */
    @Resource
    private UserDao userDao;

    /**
     * 获取用户基本信息
     *
     * @author fyh
     * @param userId:
     * @return org.hx.aisite.user.entity.UserVo
     * @date 2024/6/13 11:02
     **/
    @Override
    public UserVo getBaseInfo(String userId) {
        return userDao.getBaseInfo(userId);
    }

    /**
     * 登录
     *
     * @author fyh
     * @param loginForm:
     * @return org.hx.aisite.user.entity.UserVo
     * @date 2024/6/13 11:02
     **/
    @Override
    public UserVo login(UserVo loginForm) {
        String password = loginForm.getPassword();
        UserVo userVo = userDao.getUserByAccountAndUserType(loginForm);

        if (ObjectUtils.isNull(userVo)) {
            // 用户为空
            throw new BizException(ResponseResult.errorResult(ResponseCodeEnum.NULL_APP_OBJECT));
        } else if (!StringUtils.equals(password, userVo.getPassword())) {
            // 密码不正确
            throw new BizException(ResponseResult.errorResult(ResponseCodeEnum.LOGIN_ERROR));
        }

        return userVo;
    }

    /**
     * 注册
     *
     * @author fyh
     * @param userForm:
     * @return org.hx.aisite.user.entity.UserVo
     * @date 2024/6/13 15:52
     **/
    @Override
    public UserVo signUp(UserVo userForm) {

        UserVo existedUser = userDao.getUserByAccountAndUserType(userForm);

        if (ObjectUtils.isNotNull(existedUser)) {
            // 用户已存在
            throw new BizException(ResponseResult.errorResult(ResponseCodeEnum.USER_EXIST));
        } else if (!StringUtils.equals(userForm.getPassword(), userForm.getConfirmPassword())) {
            throw new BizException(ResponseResult.errorResult(ResponseCodeEnum.CONFIRM_PASSWORD_INCORRECT));
        }

        userForm.setUserId(UUID.randomUUID().toString());

        int insert = userDao.insert(userForm);
        if (insert != 1) {
            throw new BizException(ResponseResult.errorResult(ResponseCodeEnum.USER_SAVE_FAILURE));
        }

        return userForm;
    }
}
