package com.xxxx.server.service.impl;

import com.xxxx.server.mapper.TAdminMapper;
import com.xxxx.server.pojo.TAdmin;
import com.xxxx.server.pojo.TMenu;
import com.xxxx.server.pojo.TRole;
import com.xxxx.server.service.ITAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class TMenuServiceImplTest {
    @Autowired
    private TMenuServiceImpl tMenuService;
    @Autowired
    private TAdminMapper tAdminMapper;
    @Autowired
    private ITAdminService itAdminService;

    @Test
    public void getMenusWithRole() {
//        TAdmin tAdmin = itAdminService.getAdminByUserName("admin");
//        System.out.println(tAdmin);


        System.out.println("查询角色");
        List<TRole> tRoles = new ArrayList<>();
        tRoles = tMenuService.getTRoles(4);
        for(Iterator it = tRoles.iterator();it.hasNext();) {
            System.out.println(it.next());
        }


//        List<TMenu> menus = new ArrayList<>();
//        menus = tMenuService.getMenusWithRole();
//        System.out.println("查询列表");
//        for(Iterator it = menus.iterator();it.hasNext();) {
//            System.out.println(it.next());
//        }


    }
}