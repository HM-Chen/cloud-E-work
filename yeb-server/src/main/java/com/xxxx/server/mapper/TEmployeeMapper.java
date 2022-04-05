package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxxx.server.pojo.TEmployee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Mapper
@Repository
public interface TEmployeeMapper extends BaseMapper<TEmployee> {

    IPage<TEmployee> getEmployeeByPage(Page<TEmployee> page, @Param("tEmployee") TEmployee tEmployee, @Param("beginDateScope") LocalDate[] beginDateScope);

    List<TEmployee> getEmployee(Integer id);
}
