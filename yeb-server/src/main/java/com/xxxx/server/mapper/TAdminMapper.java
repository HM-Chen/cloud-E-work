package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.TAdmin;
import com.xxxx.server.pojo.TMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Mapper
@Repository
public interface TAdminMapper extends BaseMapper<TAdmin> {

    List<TMenu> getMenusByAdminId(Integer id);

    List<TAdmin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}
