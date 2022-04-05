package com.xxxx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_employee")
public class TEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生日期
     */
    private LocalDateTime birthday;

    /**
     * 身份证号
     */
    private String id_card;

    /**
     * 婚姻状况
     */
    private String wedlock;

    /**
     * 民族
     */
    private Integer nation_id;

    /**
     * 籍贯
     */
    private String native_place;

    /**
     * 政治面貌
     */
    private Integer politic_id;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 所属部门
     */
    private Integer department_id;

    /**
     * 职称ID
     */
    private Integer job_level_id;

    /**
     * 职位ID
     */
    private Integer pos_id;

    /**
     * 聘用形式：劳动合同，劳务合同
     */
    private String engage_form;

    /**
     * 最高学历
     */
    private String tiptop_degree;

    /**
     * 所属专业
     */
    private String specialty;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 入职日期
     */
    private LocalDateTime begin_date;

    /**
     * 在职状态
     */
    private String work_state;

    /**
     * 工号
     */
    private String work_id;

    /**
     * 合同期限
     */
    private Double contract_term;

    /**
     * 转正日期
     */
    private LocalDateTime conversion_time;

    /**
     * 离职日期
     */
    private LocalDateTime notWork_date;

    /**
     * 合同起始日期
     */
    private LocalDateTime begin_contract;

    /**
     * 合同终止日期
     */
    private LocalDateTime end_contract;

    /**
     * 工龄
     */
    private Integer work_age;

    /**
     * 工资账套ID
     */
    private Integer salary_id;


}
