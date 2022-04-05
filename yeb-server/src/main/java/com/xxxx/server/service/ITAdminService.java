package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TAdmin;
import com.xxxx.server.pojo.TRole;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
public interface ITAdminService extends IService<TAdmin> {

    RespBean login(String username, String password, String code, HttpServletRequest request);

    TAdmin getAdminByUserName(String username);

    List<TRole> getTRoles(Integer admin_id);


    List<TAdmin> getAllAdmins(String keywords);

    RespBean updateAdminAdminRole(Integer admin_id, Integer[] rids);
}
