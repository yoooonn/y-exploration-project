package com.ycourlee.explore.basic.dao;

import com.ycourlee.explore.basic.dao.model.Actor;

/**
 * @author yongjiang
 * @date 2021.03.14
 */
public interface ActorMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Actor record);

    int insertSelective(Actor record);

    Actor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Actor record);

    int updateByPrimaryKey(Actor record);
}