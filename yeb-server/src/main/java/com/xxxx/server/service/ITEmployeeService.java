package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.RespPageBean;
import com.xxxx.server.pojo.TEmployee;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
public interface ITEmployeeService extends IService<TEmployee> {

    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, TEmployee tEmployee, LocalDate[] beginDateScope);

    RespBean maxWorkID();

    RespBean addEmp(TEmployee tEmployee);

    List<TEmployee> getEmployee(Integer id);
}
