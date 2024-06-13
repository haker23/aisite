/**
 * 版权所有：华信软件
 * 项目名称: 浙江ICT项目系统
 * 创建者: fanyihao
 * 创建日期: 2024-06-13
 * 文件说明: 见类描述
 */
package org.hx.aisite.counselor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.hx.aisite.counselor.model.Consultants;
import org.hx.aisite.counselor.model.ConsultantsQueryReq;
import org.hx.aisite.counselor.model.ConsultantsVo;

import java.util.List;

/**
 * 存储咨询师详细信息的表表服务接口
 *
 * @author fanyihao
 * @date 2024-06-13
 */
public interface ConsultantsService extends IService<Consultants> {

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     * @author fanyihao
     */
    Consultants selectById(String id);

    /**
     * 分页查询
     *
     * @author fyh
     * @param queryReq:
     * @return org.hx.aisite.counselor.model.Consultants
     * @date 2024/6/13 19:55
     **/
    PageInfo<ConsultantsVo> queryCounselorList(ConsultantsQueryReq queryReq);
}
