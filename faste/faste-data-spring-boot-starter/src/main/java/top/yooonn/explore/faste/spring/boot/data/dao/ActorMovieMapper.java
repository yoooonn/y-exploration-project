package top.yooonn.explore.faste.spring.boot.data.dao;

import top.yooonn.explore.faste.spring.boot.data.dao.model.ActorMovie;

/**
 * @author yooonn
 */
public interface ActorMovieMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ActorMovie record);

    int insertSelective(ActorMovie record);

    ActorMovie selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ActorMovie record);

    int updateByPrimaryKey(ActorMovie record);
}