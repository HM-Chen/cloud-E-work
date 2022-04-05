package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.TDepartmentMapper;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TDepartment;
import com.xxxx.server.service.ITDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Service
public class TDepartmentServiceImpl extends ServiceImpl<TDepartmentMapper, TDepartment> implements ITDepartmentService {
    @Autowired
    private TDepartmentMapper tDepartmentMapper;

    @Override
    public List<TDepartment> getAllDepartments() {
        return tDepartmentMapper.getAllDepartments();
    }

    @Override
    public List<TDepartment> getDepartment(Integer id) {
        return tDepartmentMapper.getDepartment(id);
    }

    @Override
    public RespBean addDep(TDepartment tdep) {
        tdep.setEnabled(true);
        tDepartmentMapper.addDep(tdep);
        if(1 == tdep.getResult()){
            return RespBean.success("添加成功！", tdep);
        }
        return RespBean.error("添加失败！");

    }

    @Override
    public RespBean deleteDep(Integer id) {
        TDepartment dep = new TDepartment();
        dep.setId(id);
        tDepartmentMapper.deleteDep(dep);
        if(-2 == dep.getResult()){
            RespBean.error("该部门下还有子部门，删除失败！");
        }
        if(-1 == dep.getResult()){
            RespBean.error("该部门下还有员工，删除失败！");
        }
        if(1 == dep.getResult()){
            RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
