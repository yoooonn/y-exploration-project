package com.ycourlee.explore.notes.mybatisplusboot.mapper;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ycourlee.explore.notes.mybatisplusboot.MybatisPlusBootApplicationTests;
import com.ycourlee.explore.notes.mybatisplusboot.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yooonn
 * @date 2022.03.30
 */
public class UserMapperTests extends MybatisPlusBootApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(UserMapperTests.class);

    @Resource
    private UserMapper userMapper;

    @Test
    void main2Test() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.and(qw -> qw.eq(User::getName, "name").eq(User::getAge, 18))
                .or(qw -> {qw.eq(User::getEmail, "a@baomidou.com").eq(User::getAge, 18);})
                .eq(User::getId, 1);
        List<User> users = userMapper.selectList(queryWrapper);
        log.info("users.json: {}", JSON.toJSONString(users));
    }

    @Test
    void mainTest() {
        List<User> users = userMapper.selectList(null);
        log.info("users.json: {}", JSON.toJSONString(users));
    }
}
