package com.xxxx.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 工资表
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Data
@EqualsAndHashCode
@TableName("t_salary")
public class TSalary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 基本工资
     */
    private Integer basic_salary;

    /**
     * 奖金
     */
    private Integer bonus;

    /**
     * 午餐补助
     */
    private Integer lunch_salary;

    /**
     * 交通补助
     */
    private Integer traffic_salary;

    /**
     * 应发工资
     */
    private Integer all_salary;

    /**
     * 养老金基数
     */
    private Integer pension_base;

    /**
     * 养老金比率
     */
    private Float pension_per;

    /**
     * 启用时间
     */
    private LocalDateTime create_date;

    /**
     * 医疗基数
     */
    private Integer medical_base;

    /**
     * 医疗保险比率
     */
    private Float medical_per;

    /**
     * 公积金基数
     */
    private Integer accumulation_fund_base;

    /**
     * 公积金比率
     */
    private Float accumulation_fund_per;

    /**
     * 名称
     */
    private String name;


}
