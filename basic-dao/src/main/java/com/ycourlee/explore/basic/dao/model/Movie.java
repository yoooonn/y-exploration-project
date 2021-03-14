package com.ycourlee.explore.basic.dao.model;

import lombok.*;

import java.util.Date;

/**
 * 电影表
 *
 * @author yongjiang
 * @date 2021.03.14
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private Long   id;
    /**
     * 电影编码
     */
    private String code;
    /**
     * 电影名称
     */
    private String name;
    /**
     * 别名
     */
    private String alias;
    /**
     * 导演
     */
    private String director;
    /**
     * 电影类型
     */
    private String type;
    /**
     * 描述
     */
    private String memo;
    /**
     * 上映时间
     */
    private Date   releaseDatetime;
    /**
     * 发布时间
     */
    private Date   postDate;
    /**
     * 记录创建时间
     */
    private Date   createTime;
    /**
     * 记录更新时间
     */
    private Date   updateTime;
    /**
     * 记录是否删除
     */
    private Byte   wasDelete;
}