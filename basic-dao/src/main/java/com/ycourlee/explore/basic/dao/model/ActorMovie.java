package com.ycourlee.explore.basic.dao.model;

import lombok.*;

import java.util.Date;

/**
 * 演员电影关系表
 *
 * @author yongjiang
 * @date 2021.03.14
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ActorMovie {

    private Long   id;
    /**
     * 演员id
     */
    private Long   actorId;
    /**
     * 电影id
     */
    private Long   movieId;
    /**
     * 备注
     */
    private String memo;
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