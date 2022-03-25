package com.ycourlee.explore.springredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 使用redisTemplate的操作实现类
 * @author zhang guo dong
 */
@Component
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 实现命令：TTL key，以秒为单位，返回给定 key的剩余生存时间(TTL, time to live)。
     * @param key key
     * @return x 秒
     */
    public long ttl(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 实现命令：expire 设置过期时间，单位秒
     * @param key key
     */
    public void expire(String key, long timeout) {
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 实现命令：INCR key，增加key一次
     * @param key key
     * @return 大小
     */
    public long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }


    public Long decr(String key, long delta) {
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    /**
     * 实现命令：KEYS pattern，查找所有符合给定模式 pattern的 key
     */
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 实现命令：DEL key，删除一个key
     * @param key key
     */
    public void del(String key) {
        redisTemplate.delete(key);
    }

    public void delByKeys(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    // String（字符串）

    /**
     * 实现命令：SET key value，设置一个key-value（将字符串值 value关联到 key）
     * @param key   key
     * @param value value
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 实现：MSET key1 value1 key2 value2 ...
     * @param keyValues 键值对map
     */
    public void multiSet(Map<String, String> keyValues) {
        redisTemplate.opsForValue().multiSet(keyValues);
    }

    /**
     * 实现命令：SET key value，设置一个key-value（将字符串值 value关联到 key）
     * @param key   key
     * @param value value
     */
    public void set(String key, String value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }


    /**
     * redis锁(自旋锁)  缺点 当并发请求量大时 大量相同的key会造成cpu占用量过高
     * @Author: Bi Xiang Ting
     * @Date: 2021/6/7 11:03 上午
     * @Description:
     * @Param: [key, value, expireTime]
     * @return: boolean
     */
    public boolean getSpinLock(String key, String value, long expireTime) throws InterruptedException {
        while (true) {
            Boolean redisLock = setNx(key, value, expireTime);
            if (!redisLock) {
                // 未获取锁等待10毫秒重试
                Thread.sleep(10);
            } else {
                return true;
            }
        }
    }

    public Boolean setNx(String key, String value, long expireTimeInSeconds) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, expireTimeInSeconds, TimeUnit.SECONDS);
    }


    /**
     * 实现命令：SET key value EX seconds，设置key-value和超时时间（秒）
     * @param key     key
     * @param value   value
     * @param timeout （以秒为单位）
     */
    public void set(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 实现命令：GET key，返回 key所关联的字符串值。
     * @param key key
     * @return value
     */
    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    public List<String> multiGet(Collection<String> keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }


    // Hash（哈希表）

    /**
     * 实现命令：HSET key field value，将哈希表 key中的域 field的值设为 value
     * @param key   key
     * @param field fields
     * @param value value
     */
    public void hset(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 实现命令：HSET key field value，将哈希表 key中的域 field的值设为 value
     * @param key     key
     * @param mapping fields<field, values>
     */
    public void hputAll(String key, Map<String, String> mapping) {
        redisTemplate.opsForHash().putAll(key, mapping);
    }

    /**
     * hash put
     * @param key
     * @param field
     * @param value
     */
    public void hput(String key, String field, String value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 实现命令：HGET key field，返回哈希表 key中给定域 field的值
     * @param key   key
     * @param field field
     * @return
     */
    public String hget(String key, String field) {
        return (String) redisTemplate.opsForHash().get(key, field);
    }

    public List<String> multiHgetOrNullToDefault(String key, Collection<Object> fields, String defaultValue) {
        return redisTemplate.opsForHash()
                .multiGet(key, fields).stream()
                .map(v -> v == null ? defaultValue : ((String) v))
                .collect(Collectors.toList());
    }

    public String hgetOrDefault(String key, String field, String defaultValue) {
        String value = (String) redisTemplate.opsForHash().get(key, field);
        return value == null ? defaultValue : value;
    }

    public Long hget(String key, String field, long increase) {
        return redisTemplate.opsForHash().increment(key, field, increase);
    }


    public Set<String> hKeys(String key) {
        HashOperations<String, String, String> operations = redisTemplate.opsForHash();
        return operations.keys(key);
    }


    /**
     * 实现命令：HDEL key field [field ...]，删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     * @param key    key
     * @param fields fields
     */
    public void hdel(String key, Object... fields) {
        redisTemplate.opsForHash().delete(key, fields);
    }

    /**
     * 实现命令：HGETALL key，返回哈希表 key中，所有的域和值。
     * @param key key
     * @return value
     */
    public Map<String, String> hgetall(String key) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        return hashOperations.entries(key);
    }


    /**
     * 实现命令：HGETALL key，返回哈希表 key中，所有的域和值。
     * @param key key
     * @return value
     */
    public List<String> hMultiGet(String key, Collection<String> fields) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        return hashOperations.multiGet(key, fields);
    }


    /**
     * 获取hash values
     * @param key
     * @return
     */
    public List<String> hValues(String key) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        return hashOperations.values(key);
    }
    // List（列表）

    /**
     * 实现命令：LPUSH key value，将一个值 value插入到列表 key的表头
     * @param key   key
     * @param value value
     * @return 执行 LPUSH命令后，列表的长度。
     */
    public long lpush(String key, String value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 实现命令：LPOP key，移除并返回列表 key的头元素。
     * @param key key
     * @return 列表key的头元素。
     */
    public String lpop(String key) {
        return (String) redisTemplate.opsForList().leftPop(key);
    }

    public List<String> lrang(String key, int start, int end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 实现命令：RPUSH key value，将一个值 value插入到列表 key的表尾(最右边)。
     * @param key   key
     * @param value value
     * @return 执行 LPUSH命令后，列表的长度。
     */
    public long rpush(String key, String value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }


    /**
     * 判断key是否存在
     * @Author: Bi Xiang Ting
     * @Date: 2021/9/13 4:29 下午
     * @Description:
     * @Param: [key]
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 像set中添加数据
     * @Author: Bi Xiang Ting
     * @Date: 2021/9/13 4:33 下午
     * @Description:
     * @Param: [key, values]
     */
    public void addSet(String key, Long expireTime, String... values) {
        Long add = redisTemplate.opsForSet().add(key, values);
        if (null != expireTime) {
            Boolean expire = redisTemplate.expire(key, expireTime / 1000, TimeUnit.SECONDS);
        }
    }

    public void sAdd(String key, String... values) {
        redisTemplate.opsForSet().add(key, values);
    }

    public Boolean isMember(String key, String value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    public Long sRemove(String key, String... values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

    public void executePipelined(RedisCallback callback) {
        redisTemplate.executePipelined(callback);
    }

    /**
     * zadd
     * @param key
     * @param tuples
     * @return
     */
    public long zAdd(String key, Set<ZSetOperations.TypedTuple<String>> tuples) {
        return redisTemplate.opsForZSet().add(key, tuples);
    }

    /**
     * zadd
     * @param key
     * @return
     */
    public Set<String> smembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }


    /**
     * zscore
     * @param key
     * @param value
     * @return
     */
    public Double zScore(String key, String value) {
        return redisTemplate.opsForZSet().score(key, value);
    }


    /**
     * zadd
     * @param key
     * @param value
     * @param score
     * @return
     */
    public Boolean zAdd(String key, String value, Double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * zRemove
     * @param key
     * @param values
     * @return
     */
    public Long zRemove(String key, String... values) {
        return redisTemplate.opsForZSet().remove(key, values);
    }

    public Long removeRangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().removeRangeByScore(key, min, max);
    }

    public Long reverseRank(String key, Object obj) {
        return redisTemplate.opsForZSet().reverseRank(key, obj);
    }

    public Set<String> zRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    public Long zSize(String key) {
        return redisTemplate.opsForZSet().size(key);
    }

    public Set<String> rangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    public Set<String> rangeByScore(String key, double min, double max, long offset, long count) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max, offset, count);
    }

    public Set<ZSetOperations.TypedTuple<String>> rangeByScoreWithScores(String key, double min, double max, long offset, long count) {
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max, offset, count);
    }

    public Set<ZSetOperations.TypedTuple<String>> rangeByScoreWithScores(String key, double min, double max) {
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
    }

    public Set<ZSetOperations.TypedTuple<String>> rangeWithScores(String key, int start, int end) {
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }


    public Double incrementScore(String key, String value, double delta) {
        return redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }

    @SuppressWarnings({"rawtypes", "ConstantConditions", "unchecked"})
    public Set<ZSetOperations.TypedTuple<String>> zPopMin(String key, int count) {
        RedisScript<List> script = new DefaultRedisScript<>(LuaScripts.Z_POP_MIN, List.class);
        List<String> results = redisTemplate.execute(script, Collections.singletonList(key), String.valueOf(count));

        // assert results != null && results.size() % 2 == 0;
        Set<ZSetOperations.TypedTuple<String>> valueWithScores = new LinkedHashSet<>();
        for (int i = 0; i < results.size(); ) {
            valueWithScores.add(new DefaultTypedTuple<>(results.get(i++), Double.parseDouble(results.get(i++))));
        }
        return valueWithScores;
    }

    @Nullable
    public ZSetOperations.TypedTuple<String> zPopMinOne(String key) {
        Set<ZSetOperations.TypedTuple<String>> typedTuples = zPopMin(key, 1);
        return typedTuples.isEmpty() ? null : typedTuples.stream().findFirst().orElse(null);
    }

    public Double incrDriverSeatsSafely(String key, String value, double delta) {
        RedisScript<Double> script = new DefaultRedisScript<>(LuaScripts.DRIVER_SEAT_INCR, Double.class);
        return redisTemplate.execute(script, Arrays.asList(key, value), delta);
    }

    public Object executeScript(String scriptString, List<String> keys, Object... args) {
        DefaultRedisScript<?> script = new DefaultRedisScript<>(scriptString, String.class);
        return redisTemplate.execute(script, keys, args);
    }
}