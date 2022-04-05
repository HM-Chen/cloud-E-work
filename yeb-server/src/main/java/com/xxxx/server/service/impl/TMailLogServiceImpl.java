package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.TMailLogMapper;
import com.xxxx.server.pojo.TMailLog;
import com.xxxx.server.service.ITMailLogService;
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
