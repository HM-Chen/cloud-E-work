package com.xxxx.service.impl;

import com.xxxx.mapper.TRoleMapper;
import com.xxxx.pojo.TMenu;
import com.xxxx.mapper.TMenuMapper;
import com.xxxx.pojo.TRole;
import com.xxxx.service.ITMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private TRoleMapper tRoleMapper;

    @Override
    public List<TRole> getTRoles(Integer admin_id) {

        return tRoleMapper.getTRoles(admin_id);
    }
}
