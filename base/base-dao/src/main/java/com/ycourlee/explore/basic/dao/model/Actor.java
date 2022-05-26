package com.ycourlee.explore.basic.dao.model;

import lombok.*;

import java.util.Date;

/**
 * @author yooonn
 */

/**
 * 演员表
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
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