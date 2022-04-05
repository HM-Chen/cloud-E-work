package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.TMailLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 邮件日志 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Mapper
@Repository
public interface TMailLogMapper extends BaseMapper<TMailLog> {

}
