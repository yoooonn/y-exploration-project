local value = redis.call('zrange', KEYS[1], '0', '0');
if (next(value) == nil) then
    return nil
else
    redis.call('zrem', KEYS[1], value[1])
    return value[1]
end ;