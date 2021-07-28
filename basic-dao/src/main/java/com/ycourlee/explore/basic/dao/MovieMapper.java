package com.ycourlee.explore.basic.dao;

import com.ycourlee.explore.basic.dao.model.Movie;

/**
 * @author yongjiang
 */
public interface MovieMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
}