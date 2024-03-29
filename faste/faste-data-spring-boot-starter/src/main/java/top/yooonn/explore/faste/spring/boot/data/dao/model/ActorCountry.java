package top.yooonn.explore.faste.spring.boot.data.dao.model;

import lombok.*;

import java.util.Date;

/**
 * 演员国家关系表
 *
 * @author yooonn
 */
@Getter
@Setter
@Builder
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