package org.hx.aisite.customeranalysis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hx.aisite.counselor.model.ConsultantsVo;
import org.hx.aisite.customeranalysis.dao.CustomerAnalysisDao;
import org.hx.aisite.customeranalysis.model.CustomerAnalysis;
import org.hx.aisite.customeranalysis.model.CustomerAnalysisQueryReq;
import org.hx.aisite.customeranalysis.model.CustomerAnalysisVo;
import org.hx.aisite.customeranalysis.service.CustomerAnalysisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用于存储和分析的客户信息表服务实现类
 *
 * @author zhanggk
 * @date 2024-06-13
 */
@Service
public class CustomerAnalysisServiceImpl implements CustomerAnalysisService {

    /**
     * 用于存储和分析的客户信息表(CustomerAnalysis) 数据访问
     */
    @Resource
    private CustomerAnalysisDao customerAnalysisDao;

    /**
     * 用于存储和分析的客户信息表获取分页记录数
     *
     * @param queryReq 用于存储和分析的客户信息表(CustomerAnalysis)信息
     * @return
     * @author zhanggk
     */
    @Override
    public PageInfo<CustomerAnalysisVo> selectPageList(CustomerAnalysisQueryReq queryReq) {
        Page<CustomerAnalysisVo> page = PageHelper.startPage(queryReq.getPageNum(), queryReq.getPageSize());

        List<CustomerAnalysisVo> list = customerAnalysisDao.selectPageList(queryReq);

        return page.toPageInfo();
    }

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     * @author zhanggk
     */
    @Override
    public CustomerAnalysisVo selectById(String id) {
        return customerAnalysisDao.selectById(id);
    }

    /**
     * 保存数据(没有数据插入，有数据修改)
     *
     * @param t 用于存储和分析的客户信息表(CustomerAnalysis)信息
     * @return
     * @author zhanggk
     */
    @Override
    public CustomerAnalysisVo save(CustomerAnalysisVo customerAnalysis) {
        if (customerAnalysis.isNew()) {
            customerAnalysisDao.insert(customerAnalysis);
        } else {
            customerAnalysisDao.updateById(customerAnalysis);
        }
        return customerAnalysis;
    }
}

