---
--- Generated by EmmyLua(https://github.com/EmmyLua)
--- Created by yooonn.
--- DateTime: 2022/4/2 15:11
---

orderQueue = {}

---@param KEYS table
---@param ARGV table
---@return boolean
function orderQueue.zAdd(KEYS, ARGV)
    redis.call('zRem', KEYS[1], ARGV[2]);
    redis.call('set', ARGV[2], ARGV[3], 'ex', ARGV[4]);
    return redis.call('zAdd', KEYS[1], ARGV[1], ARGV[2]);
end

function orderQueue.zPopMin(KEYS)
    local value = redis.call('zRange', KEYS[1], '0', '0');
    if (next(value) == nil) then
        return nil
    else
        redis.call('zRem', KEYS[1], value[1])
        local json = redis.call('get', value[1])
        redis.call('del', value[1])
        return json
    end ;
end

function orderQueue.zRem(KEYS, ARGV)
    redis.call('zRem', KEYS[1], ARGV[1])
    local json = redis.call('get', ARGV[1])
    redis.call('del', ARGV[1])
    return json
end

return orderQueue