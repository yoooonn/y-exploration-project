package com.ycourlee.explore.notes.elk.configuration;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yongjiang
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
