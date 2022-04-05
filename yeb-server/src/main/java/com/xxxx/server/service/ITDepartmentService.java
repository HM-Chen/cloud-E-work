package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TDepartment;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
public interface ITDepartmentService extends IService<TDepartment> {
    List<TDepartment> getAllDepartments();

    List<TDepartment> getDepartment(Integer id);

    RespBean addDep(TDepartment tdep);

    RespBean deleteDep(Integer id);
}
