package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.TMenu;
import com.xxxx.server.pojo.TRole;
import javafx.scene.control.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
public interface ITMenuService extends IService<TMenu> {

    List<TMenu> getMenusByAdminId();

    List<TMenu> getMenusWithRole();

    List<TRole> getTRoles(Integer admin_id);


    List<TMenu> getAllMenu();
}
