/**
 * 版权所有：华信软件
 * 项目名称: 浙江ICT项目系统
 * 创建者: zhanggk
 * 创建日期: 2024-06-14
 * 文件说明: 见类描述
 */
package org.hx.aisite.interviewrecords.model;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


/**
 * 存储咨询访谈详细记录的表实体类
 *
 * @author zhanggk
 * @date 2024-06-14
 */
@Data
public class InterviewRecords implements Serializable {
    /**
     * 访谈记录ID，自增长主键
     */
    @TableId
    private Integer recordId;
    /**
     * 咨询师ID，关联consultants表中的咨询师
     */
    private Integer consultantId;
    /**
     * 客户ID，关联clients表中的客户
     */
    private Integer clientId;
    /**
     * 访谈日期
     */
    private Date interviewDate;
    /**
     * 访谈开始时间
     */
    private Date startTime;
    /**
     * 访谈结束时间
     */
    private Date endTime;
    /**
     * 访谈方式，线上或线下进行
     */
    private String interviewMode;
    /**
     * 访谈覆盖的主题或讨论要点
     */
    private String topicsCovered;
    /**
     * 客户提出的主要问题或关心点
     */
    private String clientConcerns;
    /**
     * 咨询师提供的建议或解决方案
     */
    private String adviceProvided;
    /**
     * 后续行动计划或建议的下一步
     */
    private String nextSteps;
    /**
     * 其他备注或细节记录
     */
    private String notes;
    /**
     * 记录创建时间
     */
    private Date createdAt;
    /**
     * 记录最后更新时间
     */
    private Date updatedAt;
}
