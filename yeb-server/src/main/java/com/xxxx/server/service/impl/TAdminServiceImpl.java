package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.AdminUtils;
import com.xxxx.server.config.security.JwtTokenUtil;
import com.xxxx.server.mapper.TAdminMapper;
import com.xxxx.server.mapper.TAdminRoleMapper;
import com.xxxx.server.mapper.TRoleMapper;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.TAdmin;
import com.xxxx.server.pojo.TAdminRole;
import com.xxxx.server.pojo.TRole;
import com.xxxx.server.service.ITAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Service
public class TAdminServiceImpl extends ServiceImpl<TAdminMapper, TAdmin> implements ITAdminService {

    @Autowired
    private TAdminMapper tAdminMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private TRoleMapper tRoleMapper;
    @Autowired
    private TAdminRoleMapper tAdminRoleMapper;

    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
        String captcha = (String)request.getSession().getAttribute("captcha");
        if(StringUtils.isEmpty(code) || !captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码输入错误，请重新输入！");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(null == userDetails || passwordEncoder.matches(password,userDetails.getPassword())){
            return RespBean.error("用户名或密码不正确");
        }
        if(!userDetails.isEnabled()){
            return RespBean.error("账号被盗，请联系管理员！");
        }

        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(userDetails
                ,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);


        return RespBean.success("登录成功",tokenMap);
    }

    @Override
    public TAdmin getAdminByUserName(String username) {
        return tAdminMapper.selectOne(new QueryWrapper<TAdmin>().eq("username",username).eq
                ("enabled",true));
    }

    @Override
    public List<TRole> getTRoles(Integer admin_id) {
        return tRoleMapper.getTRoles(admin_id);
    }

    @Override
    public List<TAdmin> getAllAdmins(String keywords) {

        return tAdminMapper.getAllAdmins(AdminUtils.getCurrentAdmin().getId(),keywords);
    }

    @Override
    public RespBean updateAdminAdminRole(Integer admin_id, Integer[] rids) {
        tAdminRoleMapper.delete(new QueryWrapper<TAdminRole>().eq("admin_id",admin_id));
        Integer result = tAdminRoleMapper.addAdminRole(admin_id,rids);
        if(rids.length == result){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }


}
