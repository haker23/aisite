/**
 * 版权所有：华信软件
 * 项目名称: 浙江ICT项目系统
 * 创建者: fanyihao
 * 创建日期: 2024-06-13
 * 文件说明: 见类描述
 */
package org.hx.aisite.counselor.control;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hx.aisite.counselor.model.Consultants;
import org.hx.aisite.counselor.model.ConsultantsQueryReq;
import org.hx.aisite.counselor.model.ConsultantsVo;
import org.hx.aisite.counselor.service.ConsultantsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 存储咨询师详细信息的表Control层
 *
 * @author fanyihao
 * @date 2024-06-13
 */
@RestController
@RequestMapping("/counselor")
public class ConsultantsControl {

    /**
     * 存储咨询师详细信息的表 服务接口
     */
    @Resource
    private ConsultantsService consultantsService;

    /**
     * 分页查询
     *
     * @author fyh
     * @param queryReq:
     * @return org.hx.aisite.counselor.model.Consultants
     * @date 2024/6/13 19:54
     **/
    @RequestMapping(value = "/query", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageInfo<ConsultantsVo> queryCounselorList(@RequestBody ConsultantsQueryReq queryReq) {
        return consultantsService.queryCounselorList(queryReq);
    }

    /**
     * 存储咨询师详细信息的表获取单条数据数据
     *
     * @param id 主键id
     * @return
     * @author fanyihao
     */
    @RequestMapping(value = "/consultants/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Consultants getConsultantsById(@PathVariable("id") String id) {
        return consultantsService.selectById(id);
    }

    /**
     * 存储咨询师详细信息的表新增或修改
     *
     * @param consultants 存储咨询师详细信息的表(Consultants)信息
     * @return
     * @author fanyihao
     */
    @RequestMapping(value = "/consultants/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Consultants saveConsultants(@RequestBody Consultants consultants) {
        consultantsService.save(consultants);
        return consultants;
    }
}
