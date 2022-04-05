package com.xxxx.server.config.security.component;


import com.xxxx.server.pojo.TMenu;
import com.xxxx.server.pojo.TRole;
import com.xxxx.server.service.ITMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private ITMenuService itMenuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException{
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<TMenu> tMenus = itMenuService.getMenusWithRole();
        for(TMenu tMenu : tMenus){
            if(antPathMatcher.match(tMenu.getUrl(),requestUrl)){
                String[] str = tMenu.getTRoles().stream().map(TRole::getName).toArray(String[]::new);
                return SecurityConfig.createList(str);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes(){
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

}
