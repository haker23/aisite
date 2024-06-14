/**
 * 版权所有：华信软件
 * 项目名称: 浙江ICT项目系统
 * 创建者: zhanggk
 * 创建日期: 2024-06-14
 * 文件说明: 见类描述
 */
package org.hx.aisite.interviewrecords.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 存储咨询访谈详细记录的表实体类
 *
 * @author zhanggk
 * @date 2024-06-14
 */
@Data
public class InterviewRecordsVo extends InterviewRecords {
    private boolean isNew;
}
