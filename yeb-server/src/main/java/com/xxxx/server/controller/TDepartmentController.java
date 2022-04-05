package com.xxxx.server.controller;


import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TDepartment;
import com.xxxx.server.service.ITDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Api(tags = "DepartmentController")
@RestController
@RequestMapping("/t-department")
public class TDepartmentController {
    @Autowired
    private ITDepartmentService itDepartmentService;

    @ApiOperation(value = "获取所有部门")
    @GetMapping("/")
    public List<TDepartment> getAllDepartments(){
        return itDepartmentService.getAllDepartments();
    }

    @ApiOperation(value = "添加部门")
    @PostMapping("/")
    public RespBean addDep(@RequestBody TDepartment tdep){
        return itDepartmentService.addDep(tdep);
    }

    @ApiOperation(value = "删除部门")
    @DeleteMapping("/{id}")
    public RespBean addDep(@PathVariable Integer id) {
        return itDepartmentService.deleteDep(id);
    }

}
