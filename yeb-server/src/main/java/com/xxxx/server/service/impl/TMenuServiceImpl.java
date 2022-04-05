package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.AdminUtils;
import com.xxxx.server.mapper.TMenuMapper;
import com.xxxx.server.mapper.TRoleMapper;
import com.xxxx.server.pojo.TMenu;
import com.xxxx.server.pojo.TRole;
import com.xxxx.server.service.ITMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Service
public class TMenuServiceImpl extends ServiceImpl<TMenuMapper, TMenu> implements ITMenuService {
    @Autowired
    private TMenuMapper tMenuMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TRoleMapper tRoleMapper;

    @Override
    public List<TMenu> getMenusByAdminId() {
        Integer adminId = AdminUtils.getCurrentAdmin().getId();
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        List<TMenu> tmenus = (List<TMenu>) valueOperations.get("menu_" + adminId);
        if(CollectionUtils.isEmpty(tmenus)){
            tmenus = tMenuMapper.getMenusByAdminId(adminId);
            valueOperations.set("menu_" + adminId,tmenus);
        }
        return tmenus;

    }

    @Override
    public List<TMenu> getMenusWithRole() {

        return tMenuMapper.getMenusWithRole();
    }

    @Override
    public List<TRole> getTRoles(Integer admin_id) {

        return tRoleMapper.getTRoles(admin_id);
    }

    @Override
    public List<TMenu> getAllMenu() {
        return tMenuMapper.getAllMenus();
    }
}
