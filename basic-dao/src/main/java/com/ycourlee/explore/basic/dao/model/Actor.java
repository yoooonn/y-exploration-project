package com.ycourlee.explore.basic.dao.model;

import lombok.*;

import java.util.Date;

/**
 * 演员表
 *
 * @author yongjiang
 * @date 2021.03.14
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

    private Long    id;
    /**
     * 编号
     */
    private String  code;
    /**
     * 姓名
     */
    private String  name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 1 female; 2 mail
     */
    private Byte    sex;
    /**
     * 生日
     */
    private Date    birthday;
    /**
     * 备注
     */
    private String  memo;
    /**
     * 记录创建时间
     */
    private Date    createTime;
    /**
     * 记录更新时间
     */
    private Date    updateTime;
    /**
     * 记录是否删除
     */
    private Byte    wasDelete;
}