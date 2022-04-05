package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.TMenuMapper;
import com.xxxx.server.mapper.TMenuRoleMapper;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TMenuRole;
import com.xxxx.server.service.ITMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 菜单角色中间表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Service
public class TMenuRoleServiceImpl extends ServiceImpl<TMenuRoleMapper, TMenuRole> implements ITMenuRoleService {

    @Autowired
    private TMenuRoleMapper tMenuRoleMapper;
    @Override
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        tMenuRoleMapper.delete(new QueryWrapper<TMenuRole>().eq("rid",rid));
        if(null == mids || 0 == mids.length){
            return RespBean.success("更新成功！");
        }
        Integer result = tMenuRoleMapper.insertRecord(rid, mids);
        if(result == mids.length){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}
