package top.yooonn.explore.faste.spring.boot.data.dao.model;

import lombok.*;

import java.util.Date;

/**
 * 演员电影关系表
 *
 * @author yooonn
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ActorMovie {

    private Long id;

    /**
     * 演员id
     */
    private Long actorId;

    /**
     * 电影id
     */
    private Long movieId;

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