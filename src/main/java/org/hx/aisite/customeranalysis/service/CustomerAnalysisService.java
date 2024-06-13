package org.hx.aisite.customeranalysis.service;

import org.hx.aisite.customeranalysis.model.CustomerAnalysis;
import org.hx.aisite.customeranalysis.model.CustomerAnalysisQueryReq;
import org.hx.aisite.customeranalysis.model.CustomerAnalysisVo;

import java.util.List;

/**
 * 用于存储和分析的客户信息表表服务接口
 *
 * @author zhanggk
 * @date 2024-06-13
 */
public interface CustomerAnalysisService{

    /**
     * 用于存储和分析的客户信息表获取分页记录数
     *
     * @param queryReq 用于存储和分析的客户信息表查询条件
     * @return
     * @author zhanggk
     */
    List<CustomerAnalysisVo> selectPageList(CustomerAnalysisQueryReq queryReq);

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     * @author zhanggk
     */
    CustomerAnalysisVo selectById(String id);

    /**
     * 获取单条数据
     *
     * @param customerAnalysis
     * @return
     * @author zhanggk
     */
    CustomerAnalysisVo save(CustomerAnalysisVo customerAnalysis);
}
