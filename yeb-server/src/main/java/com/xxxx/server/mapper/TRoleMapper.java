package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.TRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Mapper
@Repository
public interface TRoleMapper extends BaseMapper<TRole> {

    List<TRole> getTRoles(Integer admin_id);
}
