package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.TSalaryMapper;
import com.xxxx.server.pojo.TSalary;
import com.xxxx.server.service.ITSalaryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工资表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Service
public class TSalaryServiceImpl extends ServiceImpl<TSalaryMapper, TSalary> implements ITSalaryService {

}
