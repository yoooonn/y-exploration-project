package com.ycourlee.explore.faste.spring.boot.data.dao;

import com.ycourlee.explore.faste.spring.boot.data.dao.model.ActorCountry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yooonn
 */
public interface ActorCountryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ActorCountry record);

    int insertSelective(ActorCountry record);

    ActorCountry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ActorCountry record);

    int updateByPrimaryKey(ActorCountry record);

    List<ActorCountry> selectByCountryId(@Param("countryId") Long countryId);
}