package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.TMenuRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 菜单角色中间表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Mapper
@Repository
public interface TMenuRoleMapper extends BaseMapper<TMenuRole> {

    Integer insertRecord(Integer rid, Integer[] mids);
}
