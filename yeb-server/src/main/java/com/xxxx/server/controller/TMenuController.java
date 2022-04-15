package com.xxxx.server.controller;


import com.xxxx.server.pojo.TAdmin;
import com.xxxx.server.pojo.TMenu;
import com.xxxx.server.service.ITAdminService;
import com.xxxx.server.service.impl.TMenuServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    private List<TMenu> getMenuByAdminId(){
        Integer adminId = ((TAdmin)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        List<TMenu> menus = (List<TMenu>)valueOperations.get("menu_"+adminId);
        if(menus == null){
            System.out.println("从数据库查询");
            menus = tMenuService.getMenusByAdminId();
            valueOperations.set("menu_"+adminId,menus);
            redisTemplate.expire("menu_"+adminId,60*60*24, TimeUnit.MILLISECONDS);
        }else{
            System.out.println("从redis查询");
        }
        return menus;
    }

}
