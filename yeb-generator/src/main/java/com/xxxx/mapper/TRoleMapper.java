package com.xxxx.mapper;

import com.xxxx.pojo.TRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
public interface TRoleMapper extends BaseMapper<TRole> {
    List<TRole> getTRoles(Integer admin_id);

}
