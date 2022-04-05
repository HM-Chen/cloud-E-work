package com.xxxx.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TMenu;
import com.xxxx.server.pojo.TMenuRole;
import com.xxxx.server.pojo.TRole;
import com.xxxx.server.service.ITMenuRoleService;
import com.xxxx.server.service.ITMenuService;
import com.xxxx.server.service.ITRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "RoleController")
@RestController
@RequestMapping("/permiss")
public class TPermissionController {
    @Autowired
    private ITRoleService itRoleService;
    @Autowired
    private ITMenuService itMenuService;
    @Autowired
    private ITMenuRoleService itMenuRoleService;

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<TRole> getAllRoles(){
        return itRoleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/role")
    public RespBean addRole(@RequestBody TRole tRole){
        if(!tRole.getName().startsWith("ROLE_")){
            tRole.setName("ROLE_"+tRole.getName());
        }
        if(itRoleService.save(tRole)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{id}")
    public RespBean deleteRole(@PathVariable Integer id){
        if(itRoleService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<TMenu> getAllMenus(){
        return itMenuService.getAllMenu();
    }

    @ApiOperation(value = "根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid){
        return itMenuRoleService.list(new QueryWrapper<TMenuRole>().eq("rid",rid)).stream().map(TMenuRole::getMid)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids){
        return itMenuRoleService.updateMenuRole(rid, mids);
    }
 }
