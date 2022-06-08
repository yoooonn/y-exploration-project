package com.ycourlee.explore.mybatis.com.ycourlee.explore.basic.dao;

import com.alibaba.fastjson.JSON;
import com.ycourlee.explore.basic.dao.ActorMapper;
import com.ycourlee.explore.basic.dao.model.Actor;
import com.ycourlee.explore.mybatis.EnvUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author yooonn
 * @date 2021.03.26
 */
@Slf4j
public class ActorMapperTest extends EnvUtil {

    @Test
    public void selectByPrimaryKeyTest() {
        SqlSession sqlSession = sqlSession();
        ActorMapper actorMapper = sqlSession.getMapper(ActorMapper.class);
        Actor actor = actorMapper.selectByPrimaryKey(1L);
        sqlSession.commit();
        log.info(JSON.toJSONString(actor));
        log.info("Proxy class {}", actorMapper.getClass());
    }

    @Test
    public void updateByPrimaryKeyTest() {
        SqlSession sqlSession = sqlSession();
        ActorMapper actorMapper = sqlSession.getMapper(ActorMapper.class);
        int rowsEffected = actorMapper.updateByPrimaryKey(new Actor());
        sqlSession.commit();
        log.info("rowsEffected = {}", rowsEffected);
    }

    @Test
    public void selectByGenderAndMinAgeOptNoAnnotatedTest() {
        SqlSession sqlSession = sqlSession();
        ActorMapper actorMapper = sqlSession.getMapper(ActorMapper.class);
        List<Actor> actorList = actorMapper.selectByGenderAndMinAgeOptNoAnnotated(1, 20);
        sqlSession.commit();
        log.info("JSON.toJSONString(actorList) = {}", JSON.toJSONString(actorList));
    }
}
