package com.ycourlee.explore.basic.dao;

import com.ycourlee.explore.basic.dao.model.Actor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     *
     * @param genderCode
     * @param minAge
     * @return
     */
    List<Actor> selectByGenderAndMinAgeOpt(@Param("gender") Integer genderCode, @Param("minAge") Integer minAge);

    List<Actor> selectByGenderAndMinAgeOptNoAnnotated(Integer genderCode, Integer minAge);
}
