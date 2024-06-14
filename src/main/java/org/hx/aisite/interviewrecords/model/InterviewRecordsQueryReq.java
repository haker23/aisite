package org.hx.aisite.interviewrecords.model;

import lombok.Data;


/**
 * 存储咨询访谈详细记录的表查询类
 *
 * @author zhanggk
 * @date 2024-06-14
 */
@Data
public class InterviewRecordsQueryReq {

    /**
     * 当前页
     */
    private int page;

    /**
     * 当前用户ID
     */
    private String currentUserId;
    /**
     * 权限策略
     */
    private String policyType;
    /**
     * 一级部门
     */
    private String firstDept;
    /**
     * 二级部门
     */
    private String secondDept;
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 每页最大条数
     */
    private int pageSize;
    private int name;
    private int customerName;
}
