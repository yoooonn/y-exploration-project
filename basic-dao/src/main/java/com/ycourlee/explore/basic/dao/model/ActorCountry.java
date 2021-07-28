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
 * 演员国家关系表
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ActorCountry {
    private Long id;

    /**
     * 演员id
     */
    private Long actorId;

    /**
     * 国家id
     */
    private Integer countryId;

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
     * 记录是否删除
     */
    private Byte wasDelete;
}