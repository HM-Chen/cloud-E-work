package com.xxxx.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String messsage;
    private Object onj;

    public static RespBean success(String messsage){
        return new RespBean(200,messsage,null);
    }

    public static RespBean success(String messsage,Object obj){
        return new RespBean(200,messsage,obj);
    }

    public static RespBean error(String messsage){
        return new RespBean(500,messsage,null);
    }

    public static RespBean error(String messsage,Object obj){
        return new RespBean(500,messsage,obj);
    }
}
