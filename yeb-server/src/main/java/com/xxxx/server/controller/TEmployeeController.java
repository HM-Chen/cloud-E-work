package com.xxxx.server.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.xxxx.server.pojo.*;
import com.xxxx.server.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Api(tags = "EmployeeController")
@RestController
@RequestMapping("/t-employee")
public class TEmployeeController {
    @Autowired
    private ITEmployeeService itEmployeeService;
    @Autowired
    private ITPoliticsStatusService itPoliticsStatusService;
    @Autowired
    private ITJoblevelService itJoblevelService;
    @Autowired
    private ITNationService itNationService;
    @Autowired
    private ITPositionService itPositionService;
    @Autowired
    private ITDepartmentService itDepartmentService;

    @ApiOperation(value = "获取所有员工")
    @GetMapping("/")
    public RespPageBean getEmployee(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10") Integer size,
                                    TEmployee tEmployee,
                                    LocalDate[] beginDateScope){
        return itEmployeeService.getEmployeeByPage(currentPage,size,tEmployee,beginDateScope);

    }

    @ApiOperation(value = "获取所有政治面貌")
    @GetMapping("/politicsstatus")
    public List<TPoliticsStatus> getAllPoliticsStatus(){
        return itPoliticsStatusService.list();
    }

    @ApiOperation(value = "获取所有职称")
    @GetMapping("/joblevels")
    public List<TJoblevel> getAllJoblevels(){
        return itJoblevelService.list();
    }

    @ApiOperation(value = "获取所有民族")
    @GetMapping("/nations")
    public List<TNation> getAllNations(){
        return itNationService.list();
    }

    @ApiOperation(value = "获取所有职位")
    @GetMapping("/positions")
    public List<TPosition> getAllPositions(){
        return itPositionService.list();
    }

    @ApiOperation(value = "获取所有部门")
    @GetMapping("/deps")
    public List<TDepartment> getAllDepartments(){
        return itDepartmentService.getAllDepartments();
    }

    @ApiOperation(value = "获取所有工号")
    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        return itEmployeeService.maxWorkID();
    }

    @ApiOperation(value = "添加员工")
    @PostMapping("/")
    public RespBean addEmp(@RequestBody TEmployee tEmployee){
        return itEmployeeService.addEmp(tEmployee);
    }

    @ApiOperation(value = "更新员工")
    @PutMapping("/")
    public RespBean updateEmp(@RequestBody TEmployee tEmployee){
        if(itEmployeeService.updateById(tEmployee)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除员工")
    @DeleteMapping("/{id}")
    public RespBean deleteEmp(@PathVariable Integer id){
        if(itEmployeeService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "导出员工数据")
    @GetMapping(value = "/export", produces = "application/octet-stream")
    public void exportEmployee(HttpServletResponse response){
        List<TEmployee> list = itEmployeeService.getEmployee(null);
        ExportParams params = new ExportParams("员工表", "员工表", ExcelType.HSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(params, TEmployee.class, list);
        ServletOutputStream out = null;
        try {
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("员工表.xls", "UTF-8"));
            out = response.getOutputStream();
            workbook.write(out);
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            if(null != out){
                try{
                    out.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @ApiOperation(value = "导入员工数据")
    @PostMapping("/import")
    public RespBean importEmployee(MultipartFile file){
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        List<TNation> tNationList = itNationService.list();
        List<TPoliticsStatus> tPoliticsStatusList = itPoliticsStatusService.list();
        List<TDepartment> tDepartmentList = itDepartmentService.list();
        List<TJoblevel> tJoblevelList = itJoblevelService.list();
        List<TPosition> tPositionList = itPositionService.list();
        try{
            List<TEmployee> list = ExcelImportUtil.importExcel(file.getInputStream(), TEmployee.class, params);
            list.forEach(tEmployee -> {
                tEmployee.setNation_id(tNationList.get(tNationList.indexOf(new TNation(tEmployee.getTNation().getName()))).getId());
                tEmployee.setPolitic_id(tPoliticsStatusList.get(tPoliticsStatusList.indexOf(new TPoliticsStatus(tEmployee.getTPoliticsStatus().getName()))).getId());
                tEmployee.setDepartment_id(tDepartmentList.get(tDepartmentList.indexOf(new TDepartment(tEmployee.getTDepartment().getName()))).getId());
                tEmployee.setJob_level_id(tJoblevelList.get(tJoblevelList.indexOf(new TJoblevel(tEmployee.getTJoblevel().getName()))).getId());
                tEmployee.setPos_id(tPositionList.get(tPositionList.indexOf(new TPosition(tEmployee.getTPosition().getName()))).getId());
            });
            if(itEmployeeService.saveBatch(list)){
                return RespBean.success("导入成功！");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return RespBean.error("导入失败！");
    }

}
