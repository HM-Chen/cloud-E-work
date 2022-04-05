package com.xxxx.service;

import com.xxxx.pojo.TMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.pojo.TRole;

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
    List<TRole> getTRoles(Integer admin_id);

}
