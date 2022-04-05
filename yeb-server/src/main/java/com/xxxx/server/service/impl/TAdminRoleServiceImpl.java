package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.TAdminRoleMapper;
import com.xxxx.server.pojo.TAdminRole;
import com.xxxx.server.service.ITAdminRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员角色中间表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Service
public class TAdminRoleServiceImpl extends ServiceImpl<TAdminRoleMapper, TAdminRole> implements ITAdminRoleService {

}
