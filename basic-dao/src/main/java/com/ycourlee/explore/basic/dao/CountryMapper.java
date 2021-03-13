package com.ycourlee.explore.basic.dao;

import com.ycourlee.explore.basic.dao.model.Country;

/**
 * @author yongjiang
 * @date 2021.03.14
 */
public interface CountryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}