package org.hx.aisite.customeranalysis.model;

import lombok.Data;


/**
 * 用于存储和分析的客户信息表查询类
 *
 * @author zhanggk
 * @date 2024-06-13
 */
@Data
public class CustomerAnalysisQueryReq{

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
     * 客户姓名
     */
    private String customerName;
    /**
     * 客户居住地址
     */
    private String residentialAddress;
}
