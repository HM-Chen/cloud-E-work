package com.xxxx.server.controller;


import com.xxxx.server.pojo.TMenu;
import com.xxxx.server.service.ITAdminService;
import com.xxxx.server.service.impl.TMenuServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */

@Api(tags = "MenuController")
@RestController
@RequestMapping("/cfg")
public class TMenuController {
    @Autowired
    private TMenuServiceImpl tMenuService;

    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    private List<TMenu> getMenuByAdminId(){
        return tMenuService.getMenusByAdminId();
    }

}
