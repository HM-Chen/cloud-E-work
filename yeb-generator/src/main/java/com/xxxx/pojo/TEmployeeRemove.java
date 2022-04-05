package com.xxxx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工调动表
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_employee_remove")
public class TEmployeeRemove implements Serializable {

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
     * 调动后部门id
     */
    private Integer after_depId;

    /**
     * 调动后职位
     */
    private String after_jobId;

    /**
     * 调动日期
     */
    private LocalDateTime remove_date;

    /**
     * 调动原因
     */
    private String reason;

    /**
     * 备注
     */
    private String remark;


}
