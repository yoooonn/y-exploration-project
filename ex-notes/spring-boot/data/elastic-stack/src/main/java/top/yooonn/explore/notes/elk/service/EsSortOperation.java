package top.yooonn.explore.notes.elk.service;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScriptSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.util.Pair;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EsSortOperation extends EsSearchOperation {

    private final RequestOptions      options = RequestOptions.DEFAULT;
    @Resource
    private       RestHighLevelClient client;

    @Nullable
    public List<Map<String, Object>> sort(String indexName, List<Pair<String, SortOrder>> sorts) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        if (!CollectionUtils.isEmpty(sorts)) {
            for (Pair<String, SortOrder> sort : sorts) {
                sourceBuilder.sort(sort.getFirst(), sort.getSecond());
            }
        }
        SearchRequest searchRequest = new SearchRequest(indexName).source(sourceBuilder);
        return executeSearchRequest(searchRequest);
    }

    @Nullable
    public List<Map<String, Object>> customSort(String indexName, Script sortScript, SortOrder order) {
        // [age 12-->60]\[age 19-->10]\[age 13-->30]\[age 18-->40],age其他值忽略为1
        // Script script = new Script("def _ageSort = doc['age'].value == 12?60:" +
        //         "(doc['age'].value == 19?10:" +
        //         "(doc['age'].value == 13?30:" +
        //         "(doc['age'].value == 18?40:1)));" + "_ageSort;");
        SearchRequest searchRequest = new SearchRequest(indexName)
                .source(new SearchSourceBuilder()
                        .sort(SortBuilders.scriptSort(sortScript, ScriptSortBuilder.ScriptSortType.NUMBER)
                                .order(order)));
        return executeSearchRequest(searchRequest);
    }
}