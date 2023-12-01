package top.yooonn.explore.basic.dao;

import top.yooonn.explore.basic.dao.model.Country;

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