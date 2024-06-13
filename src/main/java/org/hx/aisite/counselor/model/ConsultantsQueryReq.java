/**
 * 版权所有：华信软件
 * 项目名称: 浙江ICT项目系统
 * 创建者: fanyihao
 * 创建日期: 2024-06-13
 * 文件说明: 见类描述
 */
package org.hx.aisite.counselor.model;

import lombok.Data;

/**
 * 存储咨询师详细信息的表查询类
 *
 * @author fanyihao
 * @date 2024-06-13
 */
@Data
public class ConsultantsQueryReq {

    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 每页最大条数
     */
    private int pageSize;

}
