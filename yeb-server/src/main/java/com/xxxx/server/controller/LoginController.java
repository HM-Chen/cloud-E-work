package com.xxxx.server.controller;


import com.xxxx.server.pojo.AdminLoginParam;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TAdmin;
import com.xxxx.server.service.ITAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Api(tags = "LoginController")
@RestController
public class LoginController {
    @Autowired
    private ITAdminService itAdminService;


    @ApiOperation(value = "登录之后返回true")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request){
        return itAdminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),
                adminLoginParam.getCode(), request);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @PostMapping("/admin/info")
    public TAdmin getAdminInfo(Principal principal){
        if(null == principal){
            return null;
        }
        String username = principal.getName();
        TAdmin tAdmin = itAdminService.getAdminByUserName(username);
        tAdmin.setPassword(null);
        tAdmin.setTRoles(itAdminService.getTRoles(tAdmin.getId()));
        return tAdmin;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功！");
    }
}
