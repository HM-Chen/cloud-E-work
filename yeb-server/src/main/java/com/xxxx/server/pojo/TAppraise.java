package com.xxxx.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 考评表
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Data
@EqualsAndHashCode
@TableName("t_appraise")
public class TAppraise implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工id
     */
    private Integer eid;

    /**
     * 考评日期
     */
    private LocalDateTime app_date;

    /**
     * 考评结果
     */
    private String app_result;

    /**
     * 考评内容
     */
    private String app_content;

    /**
     * 备注
     */
    private String remark;


}
