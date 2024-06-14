package org.hx.aisite.user.entity;

import lombok.Data;

@Data
public class UserVo extends User {

    private String confirmPassword;

    private String genderValue;
}
