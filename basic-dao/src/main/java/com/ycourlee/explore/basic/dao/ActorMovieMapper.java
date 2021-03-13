package com.ycourlee.explore.basic.dao;

import com.ycourlee.explore.basic.dao.model.ActorMovie;

/**
 * @author yongjiang
 * @date 2021.03.14
 */
public interface ActorMovieMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ActorMovie record);

    int insertSelective(ActorMovie record);

    ActorMovie selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ActorMovie record);

    int updateByPrimaryKey(ActorMovie record);
}