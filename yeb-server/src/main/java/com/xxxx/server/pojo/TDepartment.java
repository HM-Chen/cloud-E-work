package com.xxxx.server.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@TableName("t_department")
public class TDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     *
     */
    @ApiModelProperty(value = "部门id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    @Excel(name = "部门")
    @NonNull
    private String name;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Integer parent_id;

    /**
     * 路径
     */
    @ApiModelProperty(value = "路径")
    private String dep_path;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    /**
     * 是否上级
     */
    @ApiModelProperty(value = "是否上级")
    private Boolean is_parent;

    @ApiModelProperty(value = "子部门列表")
    @TableField(exist = false)
    private List<TDepartment> children;

    @ApiModelProperty(value = "返回结果，存储过程使用")
    @TableField(exist = false)
    private Integer result;


}
