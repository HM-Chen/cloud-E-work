package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.TMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Mapper
@Repository
public interface TMenuMapper extends BaseMapper<TMenu> {

    List<TMenu> getMenusByAdminId(Integer id);

    List<TMenu> getMenusWithRole();

    List<TMenu> getAllMenus();
}
