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
 * 员工奖罚表
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Data
@EqualsAndHashCode
@TableName("t_employee_ec")
public class TEmployeeEc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工编号
     */
    private Integer eid;

    /**
     * 奖罚日期
     */
    private LocalDateTime ec_date;

    /**
     * 奖罚原因
     */
    private String ec_reason;

    /**
     * 奖罚分
     */
    private Integer ec_point;

    /**
     * 奖罚类别，0：奖，1：罚
     */
    private Integer ec_type;

    /**
     * 备注
     */
    private String remark;


}
