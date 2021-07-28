package com.ycourlee.explore.basic.dao.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yongjiang
 */

/**
 * 演员表
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    private Long id;

    /**
     * 编号
     */
    private String code;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 1 female; 2 mail
     */
    private Byte gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 备注
     */
    private String memo;

    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 记录更新时间
     */
    private Date updateTime;

    /**
     * 已删除
     */
    private Boolean wasDelete;
}