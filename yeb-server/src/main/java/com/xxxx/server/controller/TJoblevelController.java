package com.xxxx.server.controller;


import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TJoblevel;
import com.xxxx.server.service.ITJoblevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 职称等级表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Api(tags = "JoblevelController")
@RestController
@RequestMapping("/joblevel")
public class TJoblevelController {
    @Autowired
    private ITJoblevelService itJoblevelService;

    @ApiOperation(value = "获取所有职称")
    @GetMapping("/")
    public List<TJoblevel> getAllJobLevels(){
        return itJoblevelService.list();
    }

    @ApiOperation(value = "添加职称")
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody TJoblevel tJoblevel){
        tJoblevel.setCreate_date(LocalDateTime.now());
        if(itJoblevelService.save(tJoblevel)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "更新职位")
    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody TJoblevel tJoblevel){
        if(itJoblevelService.updateById(tJoblevel)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除职称")
    @DeleteMapping("{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id){
        if(itJoblevelService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/")
    public RespBean deleteJobLevelByIds(Integer[] ids){
        if(itJoblevelService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
