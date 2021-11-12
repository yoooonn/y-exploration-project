package com.ycourlee.explore.mybatis.org.apache.ibatis.reflection;

import com.alibaba.fastjson.JSON;
import com.ycourlee.explore.basic.dao.ActorMapper;
import com.ycourlee.explore.basic.dao.model.Actor;
import com.ycourlee.explore.mybatis.EnvUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.reflection.ParamNameResolver;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author yongjiang
 * @date 2021.03.26
 */
@Slf4j
public class ParamNameResolverTest extends EnvUtil {

    private ParamNameResolver actionMapperSelectByPrimaryKeyParamNameResolver() throws NoSuchMethodException {
        Method selectByPrimaryKeyMethod = ActorMapper.class.getDeclaredMethod("selectByPrimaryKey", Long.class);
        return new ParamNameResolver(configuration(), selectByPrimaryKeyMethod);
    }

    private ParamNameResolver actionMapperUpdateByPrimaryKeyParamNameResolver() throws NoSuchMethodException {
        Method updateByPrimaryKeyMethod = ActorMapper.class.getDeclaredMethod("updateByPrimaryKey", Actor.class);
        return new ParamNameResolver(configuration(), updateByPrimaryKeyMethod);
    }

    private ParamNameResolver actionMapperSelectByGenderAndMinAgeOptParamNameResolver() throws NoSuchMethodException {
        Method selectByGenderAndMinAgeOptMethodParamAnnotated = ActorMapper.class.getDeclaredMethod("selectByGenderAndMinAgeOpt", Integer.class, Integer.class);
        return new ParamNameResolver(configuration(), selectByGenderAndMinAgeOptMethodParamAnnotated);
    }

    private ParamNameResolver actionMapperSelectByGenderAndMinAgeOptNoAnnotatedParamNameResolver() throws NoSuchMethodException {
        Method selectByGenderAndMinAgeOptMethodNoAnnotated = ActorMapper.class.getDeclaredMethod("selectByGenderAndMinAgeOptNoAnnotated", Integer.class, Integer.class);
        return new ParamNameResolver(configuration(), selectByGenderAndMinAgeOptMethodNoAnnotated);
    }

    @Test
    public void SelectByPrimaryKeyTest() throws NoSuchMethodException {
        ParamNameResolver paramNameResolver = actionMapperSelectByPrimaryKeyParamNameResolver();
        String[] names = paramNameResolver.getNames();
        log.info("names = {}", Arrays.toString(names));
    }

    @Test
    public void selectByPrimaryKeyTest() throws NoSuchMethodException {
        ParamNameResolver paramNameResolver = actionMapperSelectByPrimaryKeyParamNameResolver();
        Object params = paramNameResolver.getNamedParams(new Object[]{1L});
        log.info("JSON.toJSONString(params) = {}", JSON.toJSONString(params));
    }

    @Test
    public void updateByPrimaryKeyTest() throws NoSuchMethodException {
        ParamNameResolver nameResolver = actionMapperUpdateByPrimaryKeyParamNameResolver();
        Object params = nameResolver.getNamedParams(new Object[]{new Actor()});
        log.info("params = {}", params);
    }

    @Test
    public void SelectByGenderAndMinAgeOptTest() throws NoSuchMethodException {
        ParamNameResolver nameResolver = actionMapperSelectByGenderAndMinAgeOptParamNameResolver();
        Object params = nameResolver.getNamedParams(new Object[]{1, 20});
        log.info("params = {}", params);
    }

    /**
     * 不使用注解{@link Param}
     * 3.5.3: params = {arg1=20, arg0=1, param1=1, param2=20}
     * 3.5.4: params = {genderCode=1, minAge=20, param1=1, param2=20}
     * 3.5.5: params = {genderCode=1, minAge=20, param1=1, param2=20}
     * 3.5.6: params = {genderCode=1, minAge=20, param1=1, param2=20}
     *
     * @throws NoSuchMethodException e
     */
    @Test
    public void selectByGenderAndMinAgeOptNoAnnotatedTest() throws NoSuchMethodException {
        ParamNameResolver nameResolver = actionMapperSelectByGenderAndMinAgeOptNoAnnotatedParamNameResolver();
        Object params = nameResolver.getNamedParams(new Object[]{1, 20});
        log.info("params = {}", params);
    }
}
