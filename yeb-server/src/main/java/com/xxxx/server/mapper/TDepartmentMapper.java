package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.TDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Mapper
@Repository
public interface TDepartmentMapper extends BaseMapper<TDepartment> {
    List<TDepartment> getAllDepartments();

    List<TDepartment> getDepartment(Integer parent_Id);

    void addDep(TDepartment tdep);

    void deleteDep(TDepartment dep);
}
