package org.hx.aisite.customeranalysis.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.hx.aisite.customeranalysis.model.CustomerAnalysis;
import org.hx.aisite.customeranalysis.model.CustomerAnalysisQueryReq;
import org.hx.aisite.customeranalysis.model.CustomerAnalysisVo;

import java.io.Serializable;

/**
 * 用于存储和分析的客户信息表Dao接口
 *
 * @author zhanggk
 * @date 2024-06-13
 */
public interface CustomerAnalysisDao extends BaseMapper<CustomerAnalysis> {

    /**
     * 用于存储和分析的客户信息表分页查询
     *
     * @param queryReq
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
    @Override
    CustomerAnalysisVo selectById(Serializable id);

}

