package com.xxxx.service.impl;

import com.xxxx.pojo.TRole;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TMenuServiceImplTest {
    @Test
    void getMenusWithRole() {
        TMenuServiceImpl tMenuService = new TMenuServiceImpl();

        System.out.println("查询角色");
        List<TRole> tRoles = new ArrayList<>();
        tRoles = tMenuService.getTRoles(4);
        for(Iterator it = tRoles.iterator(); it.hasNext();) {
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