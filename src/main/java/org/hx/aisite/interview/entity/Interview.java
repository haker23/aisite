package org.hx.aisite.interview.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Interview implements Serializable {

    @TableId(type = IdType.AUTO)
    private String id;
    /**
     * 访谈室 appId
     */
    private String appId;
    /**
     * 访谈时 appKey
     */
    private String appKey;
    /**
     * 访谈室名称
     */
    private String interviewName;
    /**
     * 发起方
     */
    private String creator;
    /**
     * 访谈方
     */
    private String interviewer;
}
