/**
 * 版权所有：华信软件
 * 项目名称: 浙江ICT项目系统
 * 创建者: fanyihao
 * 创建日期: 2024-06-13
 * 文件说明: 见类描述
 */
package org.hx.aisite.counselor.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.hx.aisite.counselor.model.Consultants;
import org.hx.aisite.counselor.model.ConsultantsQueryReq;
import org.hx.aisite.counselor.model.ConsultantsVo;

import java.io.Serializable;

/**
 * 存储咨询师详细信息的表Dao接口
 *
 * @author fanyihao
 * @date 2024-06-13
 */
public interface ConsultantsDao extends BaseMapper<Consultants> {

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     * @author fanyihao
     */
    @Override
    Consultants selectById(Serializable id);

    /**
     * 分页查询
     *
     * @author fyh
     * @param queryReq:
     * @return java.util.List<org.hx.aisite.counselor.model.ConsultantsVo>
     * @date 2024/6/13 19:58
     **/
    List<ConsultantsVo> queryCounselorList(ConsultantsQueryReq queryReq);
}

