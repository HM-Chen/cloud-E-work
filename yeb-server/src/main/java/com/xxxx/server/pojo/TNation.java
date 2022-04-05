package com.xxxx.server.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 民族表
 * </p>
 *
 * @author chen
 * @since 2021-10-25
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@TableName("t_nation")
public class TNation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 民族
     */
    @Excel(name = "民族")
    @NonNull
    private String name;


}
