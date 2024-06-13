package org.hx.aisite.common.enums;

import lombok.Data;

/**
 * 统一返回状态码
 *
 * @author fyh
 * @date 2024/6/11 9:27
 **/
public enum ResponseCodeEnum {

    SUCCESS(200, "操作成功"),   // 成功

    NEED_LOGIN(401, "需要登陆后操作"),    // 登录
    NO_OPERATOR_AUTH(403, "无权限操作"),
    SYSTEM_ERROR(500, "出现错误"),
    REQUIRE_USERNAME(504, "必须填写用户名"),
    LOGIN_ERROR(505, "用户名或密码错误"),
    CONTENT_NOT_NULL(506, "内容不能为空"),
    FILE_TYPE_ERROR(507, "文件格式错误，请上传正确格式的文件"),
    FILE_TOO_LARGE(413, "上传失败，文件过大"),
    USERNAME_NOT_NULL(508, "用户名不能为空"),
    NICKNAME_NOT_NULL(509, "昵称不能为空"),
    PASSWORD_NOT_NULL(510, "密码不能为空"),
    EMAIL_NOT_NULL(511, "邮箱不能为空"),
    USERNAME_EXIST(501, "用户名已存在"),
    PHONENUMBER_EXIST(502, "手机号已存在"),
    EMAIL_EXIST(503, "邮箱已存在"),
    NICKNAME_EXIST(512, "昵称已存在"),
    NULL_APP_OBJECT(10001, "业务数据为空"),
    CONFIRM_PASSWORD_INCORRECT(10002, "两次输入密码不一致"),
    USER_SAVE_FAILURE(10003, "用户注册失败"),
    USER_EXIST(10004, "用户名已存在");

    private final int code;
    private final String msg;

    ResponseCodeEnum(int code, String errorMsg) {
        this.code = code;
        this.msg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}