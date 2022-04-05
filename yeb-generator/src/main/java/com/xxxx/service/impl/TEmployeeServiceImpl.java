package com.xxxx.service.impl;

import com.xxxx.pojo.TEmployee;
import com.xxxx.mapper.TEmployeeMapper;
import com.xxxx.service.ITEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Service
public class TEmployeeServiceImpl extends ServiceImpl<TEmployeeMapper, TEmployee> implements ITEmployeeService {

}
