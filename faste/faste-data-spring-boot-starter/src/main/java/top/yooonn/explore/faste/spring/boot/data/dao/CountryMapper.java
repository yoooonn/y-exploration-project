package top.yooonn.explore.faste.spring.boot.data.dao;

import top.yooonn.explore.faste.spring.boot.data.dao.model.Country;

/**
 * @author yooonn
 */
public interface CountryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}