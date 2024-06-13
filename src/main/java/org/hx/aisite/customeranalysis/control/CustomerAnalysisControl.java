package org.hx.aisite.customeranalysis.control;

import org.hx.aisite.customeranalysis.model.CustomerAnalysisQueryReq;
import org.hx.aisite.customeranalysis.model.CustomerAnalysisVo;
import org.hx.aisite.customeranalysis.service.CustomerAnalysisService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用于存储和分析的客户信息表Control层
 *
 * @author zhanggk
 * @date 2024-06-13
 */
@Controller
public class CustomerAnalysisControl {

    /**
     * 用于存储和分析的客户信息表 服务接口
     */
    @Resource
    private CustomerAnalysisService customerAnalysisService;

    /**
     * 用于存储和分析的客户信息表获取单条数据数据
     *
     * @param id 主键id
     * @return
     * @author zhanggk
     */
    @RequestMapping(value = "/customeranalysis/customeranalysis/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CustomerAnalysisVo getCustomerAnalysisById(@PathVariable("id") String id) {
        return customerAnalysisService.selectById(id);
    }

    /**
     * 用于存储和分析的客户信息表新增或修改
     *
     * @param customerAnalysis 用于存储和分析的客户信息表(CustomerAnalysis)信息
     * @return
     * @author zhanggk
     */
    @RequestMapping(value = "/customeranalysis/customeranalysis/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CustomerAnalysisVo saveCustomerAnalysis(@RequestBody CustomerAnalysisVo customerAnalysis) {
        customerAnalysisService.save(customerAnalysis);
        return customerAnalysis;
    }

    /**
     * 用于存储和分析的客户信息表分页查询
     *
     * @param queryReq 用于存储和分析的客户信息表(CustomerAnalysis)信息
     * @return
     * @author zhanggk
     */
    @RequestMapping(value = "/customeranalysis/customeranalysis/query", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CustomerAnalysisVo> queryCustomerAnalysis(@RequestBody CustomerAnalysisQueryReq queryReq) {
        return customerAnalysisService.selectPageList(queryReq);
    }
}
