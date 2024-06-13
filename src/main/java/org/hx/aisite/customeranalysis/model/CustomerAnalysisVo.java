package org.hx.aisite.customeranalysis.model;

import lombok.Data;


/**
 * 用于存储和分析的客户信息表实体类
 *
 * @author zhanggk
 * @date 2024-06-13
 */
@Data
public class CustomerAnalysisVo extends CustomerAnalysis {
    /**
     * 客户参与会员活动的活跃度，0-不活跃，1-活跃
     */
    private boolean isNew;
}
