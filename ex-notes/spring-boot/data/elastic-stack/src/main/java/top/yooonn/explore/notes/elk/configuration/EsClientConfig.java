package top.yooonn.explore.notes.elk.configuration;

import org.springframework.context.annotation.Configuration;

/**
 * @author yooonn
 * @date 2022.03.04
 */
@Configuration
public class EsClientConfig {

    // @Bean
    // public RestHighLevelClient restHighLevelClient() {
    //     CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    //     credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "yAdveMxIf86M+CH5N3*A"));
    //     return new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200))
    //             .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
    //                 @Override
    //                 public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
    //                     return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
    //                 }
    //             }));
    // }
}
