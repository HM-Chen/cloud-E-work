package com.xxxx.service.impl;

import com.xxxx.pojo.TMailLog;
import com.xxxx.mapper.TMailLogMapper;
import com.xxxx.service.ITMailLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 邮件日志 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Service
public class TMailLogServiceImpl extends ServiceImpl<TMailLogMapper, TMailLog> implements ITMailLogService {

}
