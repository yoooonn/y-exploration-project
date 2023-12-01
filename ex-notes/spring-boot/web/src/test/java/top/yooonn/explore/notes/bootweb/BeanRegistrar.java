package top.yooonn.explore.notes.bootweb;

import top.yooonn.explore.basic.dao.ActorMapper;
import top.yooonn.explore.basic.dao.MovieMapper;
import top.yooonn.explore.notes.bootweb.annotation.TimeCostLoggerUsages;
import top.yooonn.explore.notes.bootweb.com.ycourlee.tranquil.annotation.LockableUsages;
import top.yooonn.explore.notes.bootweb.org.springframework.transaction.support.Tx;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class BeanRegistrar {

    @Bean
    public TimeCostLoggerUsages timeCostLoggerUsages() {
        return new TimeCostLoggerUsages();
    }

    @Bean
    public LockableUsages lockableUsages(StringRedisTemplate redisTemplate) {
        return new LockableUsages(redisTemplate);
    }

    @Bean
    @ConditionalOnClass({ActorMapper.class, MovieMapper.class})
    public Tx tx(ActorMapper actorMapper, MovieMapper movieMapper) {
        return new Tx(movieMapper, actorMapper);
    }
}