package com.xxxx.server.controller;


import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TAdmin;
import com.xxxx.server.pojo.TRole;
import com.xxxx.server.service.ITAdminService;
import com.xxxx.server.service.ITRoleService;
import com.xxxx.server.service.impl.TRoleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Api(tags = "AdminController")
@RestController
@RequestMapping("/system/admin/t-admin")
public class TAdminController {
    @Autowired
    private ITAdminService itAdminService;
    @Autowired
    private ITRoleService itRoleService;

    @ApiOperation(value = "获取所有操作员")
    @GetMapping("/")
    public List<TAdmin> getAllAdmins(String keywords){
        return itAdminService.getAllAdmins(keywords);
    }

    @ApiOperation(value = "更新操作员")
    @PutMapping("/")
    public RespBean updateAdmin(@RequestBody TAdmin tAdmin){
        if( itAdminService.updateById(tAdmin)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除操作员")
    @DeleteMapping("{id}")
    public RespBean deleteAdmin(@PathVariable Integer id){
        if(itAdminService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
    @ApiOperation(value = "获取所有角色")
    @GetMapping("/roles")
    public List<TRole> getAllRoles(){
        return itRoleService.list();
    }

    @ApiOperation(value = "更新操作员角色")
    @PutMapping("/role")
    public RespBean updateAdminRole(Integer admin_id, Integer[] rids){
        return itAdminService.updateAdminAdminRole(admin_id, rids);
    }
}
