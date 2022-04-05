package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TAdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 管理员角色中间表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Mapper
@Repository
public interface TAdminRoleMapper extends BaseMapper<TAdminRole> {

    Integer addAdminRole(@Param("admin_id")Integer admin_id, @Param("rids") Integer[] rids);
}
