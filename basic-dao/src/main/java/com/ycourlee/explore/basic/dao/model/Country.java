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
 * 国家表
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private Integer id;

    /**
     * 编码
     */
    private String code;

    /**
     * 使用语言
     */
    private String language;

    /**
     * 首都
     */
    private String capital;

    /**
     * 世界地理区域
     */
    private String universalRegion;

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