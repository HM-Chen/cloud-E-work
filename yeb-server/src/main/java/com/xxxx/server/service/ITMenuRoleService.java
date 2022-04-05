package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TMenuRole;

/**
 * <p>
 * 菜单角色中间表 服务类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
public interface ITMenuRoleService extends IService<TMenuRole> {

    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
