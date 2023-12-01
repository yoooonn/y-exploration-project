package top.yooonn.explore.notes.elk.org.elasticsearch.client;

import top.yooonn.explore.notes.elk.ElkApplicationTests;
import lombok.SneakyThrows;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yooonn
 * @date 2022.03.08
 */
public class RestHighLevelClientTests extends ElkApplicationTests {


    @Autowired
    private RestHighLevelClient highLevelClient;

    @Test
    @SneakyThrows
    void mainTest() {
        GetRequest request = new GetRequest();
        request.index(INDEX);
        highLevelClient.get(request, RequestOptions.DEFAULT);
    }
}
