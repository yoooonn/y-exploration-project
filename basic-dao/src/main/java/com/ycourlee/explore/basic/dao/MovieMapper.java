package com.ycourlee.explore.basic.dao;

import com.ycourlee.explore.basic.dao.model.Movie;

/**
 * @author yongjiang
 * @date 2021.03.14
 */
public interface MovieMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
}