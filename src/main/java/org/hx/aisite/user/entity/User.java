package org.hx.aisite.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private int id;

    private String userId;

    private String account;

    private String password;

    private String userType;

    private String userName;

    private String telNumber;

    private int gender;
}
