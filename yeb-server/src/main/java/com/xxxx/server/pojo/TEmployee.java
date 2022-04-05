package com.xxxx.server.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Data
@EqualsAndHashCode
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
    @Excel(name = "员工姓名")
    private String name;

    /**
     * 性别
     */
    @Excel(name = "性别")
    private String gender;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @Excel(name = "出生日期", width = 20, format = "yyyy-MM-dd")
    private LocalDateTime birthday;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号", width = 30)
    private String id_card;

    /**
     * 婚姻状况
     */
    @Excel(name = "婚姻状况")
    private String wedlock;

    /**
     * 民族
     */
    private Integer nation_id;

    /**
     * 籍贯
     */
    @Excel(name = "籍贯")
    private String native_place;

    /**
     * 政治面貌
     */
    @Excel(name = "政治面貌")
    private Integer politic_id;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;

    /**
     * 电话号码
     */
    @Excel(name = "电话号码", width = 15)
    private String phone;

    /**
     * 联系地址
     */
    @Excel(name = "联系地址", width = 40)
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
    @Excel(name = "聘用形式")
    private String engage_form;

    /**
     * 最高学历
     */
    @Excel(name = "最高学历")
    private String tiptop_degree;

    /**
     * 所属专业
     */
    @Excel(name = "所属专业", width = 20)
    private String specialty;

    /**
     * 毕业院校
     */
    @Excel(name = "毕业院校", width = 20)
    private String school;

    /**
     * 入职日期
     */
    @Excel(name = "入职日期", width = 20, format = "yyyy-MM-dd")
    private LocalDateTime begin_date;

    /**
     * 在职状态
     */
    @Excel(name = "在职状态")
    private String work_state;

    /**
     * 工号
     */
    @Excel(name = "工号")
    private String work_id;

    /**
     * 合同期限
     */
    @Excel(name = "合同期限", suffix = "年")
    private Double contract_term;

    /**
     * 转正日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @Excel(name = "转正日期", width = 20, format = "yyyy-MM-dd")
    private LocalDateTime conversion_time;

    /**
     * 离职日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @Excel(name = "离职日期", width = 20, format = "yyyy-MM-dd")
    private LocalDateTime notWork_date;

    /**
     * 合同起始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @Excel(name = "合同起始日期", width = 20, format = "yyyy-MM-dd")
    private LocalDateTime begin_contract;

    /**
     * 合同终止日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @Excel(name = "合同终止日期", width = 20, format = "yyyy-MM-dd")
    private LocalDateTime end_contract;

    /**
     * 工龄
     */
    @Excel(name = "工龄")
    private Integer work_age;

    /**
     * 工资账套ID
     */
    private Integer salary_id;


    @TableField(exist = false)
    @ExcelEntity(name = "民族")
    private TNation tNation;


    @TableField(exist = false)
    @ExcelEntity(name = "政治面貌")
    private TPoliticsStatus tPoliticsStatus;

    @TableField(exist = false)
    @ExcelEntity(name = "部门")
    private TDepartment tDepartment;

    @TableField(exist = false)
    @ExcelEntity(name = "职称")
    private TJoblevel tJoblevel;

    @TableField(exist = false)
    @ExcelEntity(name = "职位")
    private TPosition tPosition;


}
