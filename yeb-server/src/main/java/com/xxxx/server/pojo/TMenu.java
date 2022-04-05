package com.xxxx.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Data
@EqualsAndHashCode
@TableName("t_menu")
public class TMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * url
     */
    @ApiModelProperty(value = "url")
    private String url;

    /**
     * path
     */
    @ApiModelProperty(value = "path")
    private String path;

    /**
     * 组件
     */
    @ApiModelProperty(value = "组件")
    private String component;

    /**
     * 菜单名
     */
    @ApiModelProperty(value = "菜单名")
    private String name;

    /**
     * 图标
     */
    @ApiModelProperty(value = "图标")
    private String icon_cls;

    /**
     * 是否保持激活
     */
    @ApiModelProperty(value = "是否保持激活")
    private Boolean keep_alive;

    /**
     * 是否要求权限
     */
    @ApiModelProperty(value = "是否要求权限")
    private Boolean require_auth;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Integer parent_id;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    @ApiModelProperty(value = "子菜单")
    @TableField(exist = false)
    private List<TMenu> children;

    @ApiModelProperty(value = "角色列表")
    @TableField(exist = false)
    private List<TRole> tRoles;


}
