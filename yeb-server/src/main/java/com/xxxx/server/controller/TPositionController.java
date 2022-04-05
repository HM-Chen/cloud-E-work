package com.xxxx.server.controller;


import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TPosition;
import com.xxxx.server.service.ITPositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 职位 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Api(tags = "PositionController")
@RestController
@RequestMapping("/pos")
public class TPositionController {

    @Autowired
    private ITPositionService itPositionService;

    @ApiOperation(value = "获取所有职位信息")
    @GetMapping("/")
    public List<TPosition> getAllPosition(){
        return itPositionService.list();
    }

    @ApiOperation(value = "添加职位信息")
    @PostMapping("/")
    public RespBean addPosition(@RequestBody TPosition tPosition){
        tPosition.setCreate_date(LocalDateTime.now());
        if(itPositionService.save(tPosition)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "更新职位信息")
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody TPosition tPosition){
        if(itPositionService.updateById(tPosition)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id){
        if(itPositionService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除职位信息")
    @DeleteMapping("/")
    public RespBean deletePositionByIds(Integer[] ids){
        if(itPositionService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }



}
