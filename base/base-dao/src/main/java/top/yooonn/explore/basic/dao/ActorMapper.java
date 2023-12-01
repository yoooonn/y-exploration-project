package top.yooonn.explore.basic.dao;

import top.yooonn.explore.basic.dao.model.Actor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yooonn
 */
public interface ActorMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Actor record);

    int insertSelective(Actor record);

    Actor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Actor record);

    int updateByPrimaryKey(Actor record);

    Actor selectByPrimaryKeyNoDel(Long id);

    /**
     * @param genderCode gender code
     * @param minAge     min age
     * @return
     */
    List<Actor> selectByGenderAndMinAgeOpt(@Param("gender") Integer genderCode, @Param("minAge") Integer minAge);

    List<Actor> selectByGenderAndMinAgeOptNoAnnotated(Integer genderCode, Integer minAge);
}