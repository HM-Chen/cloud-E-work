package com.xxxx.server.controller;

import com.xxxx.server.pojo.TAdmin;
import com.xxxx.server.service.ITAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "ChatController")
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ITAdminService itAdminService;

    @ApiOperation(value = "获取所有操作员")
    @GetMapping("/admin")
    public List<TAdmin> getAllAdmins(String keywords){
        return itAdminService.getAllAdmins(keywords);
    }
}
