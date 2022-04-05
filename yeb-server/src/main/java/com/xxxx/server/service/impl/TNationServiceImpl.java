package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.TNationMapper;
import com.xxxx.server.pojo.TNation;
import com.xxxx.server.service.ITNationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 民族表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Service
public class TNationServiceImpl extends ServiceImpl<TNationMapper, TNation> implements ITNationService {

}
