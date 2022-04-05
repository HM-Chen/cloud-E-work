package com.xxxx.server;

import com.xxxx.server.pojo.TAdmin;
import org.springframework.security.core.context.SecurityContextHolder;

public class AdminUtils {
    public static TAdmin getCurrentAdmin(){
        return (TAdmin) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
    }
}
