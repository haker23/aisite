/**
 * 版权所有：华信软件
 * 项目名称: 浙江ICT项目系统
 * 创建者: fanyihao
 * 创建日期: 2024-06-13
 * 文件说明: 见类描述
 */
package org.hx.aisite.counselor.model;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 存储咨询师详细信息的表实体类
 *
 * @author fanyihao
 * @date 2024-06-13
 */
@Data
@TableName(value = "consultants", excludeProperty = "isNew")
public class Consultants implements Serializable {
    /**
     * 序列化变量
     */
    private static final long serialVersionUID = 540067324302780379L;

    /**
     * 咨询师ID，自增长主键
     */
    @TableId(type = IdType.AUTO)
    private int id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 咨询师姓名
     */
    private String name;
    /**
     * 咨询师性别
     */
    private String gender;
    /**
     * 咨询师年龄
     */
    private Integer age;
    /**
     * 专业领域，如心理咨询、职业规划等
     */
    private String expertise;
    /**
     * 教育背景，包括学位和毕业院校
     */
    private String educationBackground;
    /**
     * 持有证书，如心理咨询师资格证等，可为多个，用逗号分隔
     */
    private String certifications;
    /**
     * 从业年数
     */
    private Integer yearsOfExperience;
    /**
     * 个人简介或简历摘要
     */
    private String bio;
    /**
     * 联系方式—电话号码
     */
    private String contactPhone;
    /**
     * 联系方式—电子邮箱
     */
    private String email;
    /**
     * 办公地址或服务区域
     */
    private String address;
    /**
     * 上班时间
     */
    private String availability;
    /**
     * 每小时咨询费用
     */
    private Double hourlyRate;
    /**
     * 服务语言，如“中文，英语”
     */
    private String languages;
    /**
     * 个人照片URL
     */
    private String photoUrl;
    /**
     * 记录创建时间
     */
    private Date createDate;
    /**
     * 记录最后更新时间
     */
    private Date updateDate;
}
