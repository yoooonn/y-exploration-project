package top.yooonn.explore.faste.spring.boot.data.dao;

import top.yooonn.explore.faste.spring.boot.data.dao.model.Movie;

/**
 * @author yooonn
 */
public interface MovieMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
}