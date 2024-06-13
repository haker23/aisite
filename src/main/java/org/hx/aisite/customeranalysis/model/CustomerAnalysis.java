package org.hx.aisite.customeranalysis.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 用于存储和分析的客户信息表实体类
 *
 * @author zhanggk
 * @date 2024-06-13
 */
@Data
@TableName("customer_analysis")
public class CustomerAnalysis implements Serializable {
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 客户姓名
     */
    private String name;
    /**
     * 客户性别
     */
    private String gender;
    /**
     * 客户年龄
     */
    private String age;
    /**
     * 客户联系电话
     */
    private String phoneNumber;
    /**
     * 客户电子邮箱
     */
    private String email;
    /**
     * 客户居住地址
     */
    private String residentialAddress;
    /**
     * 客户工作地点
     */
    private String workplace;
    /**
     * 客户教育背景
     */
    private String educationLevel;
    /**
     * 客户职业
     */
    private String occupation;
    /**
     * 客户家庭基本情况
     */
    private String familyStatus;
    /**
     * 客户平均每次消费金额
     */
    private Double averageSpending;
    /**
     * 客户购物的大致频率（例如，每月几次）
     */
    private String shoppingFrequency;
    /**
     * 客户活跃的社交媒体平台
     */
    private String socialMedia;
    /**
     * 客户的网络行为概述，包括常访问的网站或社群
     */
    private String onlineBehavior;
    /**
     * 客户的支付偏好和财务习惯概述
     */
    private String financialPreferences;
    /**
     * 客户常用的支付手段
     */
    private String paymentMethods;
    /**
     * 客户的信用评估分数，如有
     */
    private String creditScore;
    /**
     * 客户对产品或服务的反馈记录
     */
    private String customerFeedback;
    /**
     * 客户与客服或其他渠道的互动记录
     */
    private String interactionRecords;
    /**
     * 客户的会员等级
     */
    private String membershipLevel;
    /**
     * 客户累积的积分
     */
    private Integer points;
    /**
     * 客户参与会员活动的活跃度，0-不活跃，1-活跃
     */
    private String eventParticipation;
}
