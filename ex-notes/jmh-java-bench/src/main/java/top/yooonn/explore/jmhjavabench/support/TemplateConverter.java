package top.yooonn.explore.jmhjavabench.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author yooonn
 */
public class TemplateConverter {

    private static final BelFactory belFactory = new BelFactory();

    @SuppressWarnings({"unchecked", "rawtypes"})
    public JSONObject execConvert(JSONObject semiParam, Map<String, Object> pool) {
        if (semiParam == null) {
            return null;
        }
        Map<String, Object> innerMap = semiParam.getInnerMap();
        if (innerMap == null || innerMap.isEmpty()) {
            return null;
        }
        Map<String, Object> override = new HashMap<>(innerMap.size());
        Set<Map.Entry<String, Object>> entrySet = innerMap.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            Object val = entry.getValue();
            if (val == null) {
                continue;
            }

            if (val instanceof JSONObject) {
                execConvert(((JSONObject) val), pool);
                continue;
            }

            if (val instanceof Map) {
                execConvert(new JSONObject((Map) val), pool);
                continue;
            }

            if (val instanceof JSONArray) {
                /*
                 * 如果是数组，按照约定处理键。允许改变loading期间列表对象变量名
                 */
                String mirrorVar = entry.getKey();
                Bel bel = null;
                if (belFactory.hasBelFormat(entry.getKey())) {
                    bel = belFactory.newInstance(entry.getKey());
                    mirrorVar = bel.getVariable();
                }

                JSONArray result = new JSONArray();
                JSONArray array = (JSONArray) val;
                if (array.isEmpty()) {
                    continue;
                }
                List<Map<String, Object>> mapList = (List<Map<String, Object>>) pool.get(mirrorVar);
                if (mapList == null || mapList.isEmpty()) {
                    continue;
                }
                JSONObject jsonObjectTemp = array.getJSONObject(0);

                for (Map<String, Object> map : mapList) {
                    JSONObject converted = deepCopy(jsonObjectTemp);
                    execConvert(converted, map);
                    result.add(converted);
                }
                // bel not be null
                override.put(((String) bel.getValue()), result);
                iterator.remove();
                continue;
            }
            if (val instanceof String) {
                String valString = (String) val;
                if (belFactory.hasBelFormat(valString)) {
                    Bel bel = belFactory.newInstance(valString);
                    if (bel.getAccessPool()) {
                        bel.setValue(pool.get(bel.getVariable()));
                    }
                    entry.setValue(bel.getValue());
                }
            }
            // others, do nothing.
        }
        if (!override.isEmpty()) {
            // 覆盖
            innerMap.putAll(override);
        }
        return semiParam;
    }

    private JSONObject deepCopy(JSONObject src) {
        if (src == null || src.isEmpty()) {
            return new JSONObject(0);
        }
        return JSON.parseObject(JSON.toJSONString(src));
    }
}
