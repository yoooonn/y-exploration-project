package com.ycourlee.explore.notes.elk.service;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetMappingsRequest;
import org.elasticsearch.client.indices.GetMappingsResponse;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yooonn
 * @date 2022.03.04
 */
@Service
public class EsIndexOperation {

    private final RequestOptions      options = RequestOptions.DEFAULT;
    @Autowired
    private       RestHighLevelClient client;

    @Nullable
    public Boolean exist(String index) {
        try {
            GetIndexRequest request = new GetIndexRequest(index);
            return client.indices().exists(request, this.options);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public Map<String, MappingMetaData> getMapping(String index) {
        try {
            GetMappingsRequest request = new GetMappingsRequest();
            request.indices(index);
            GetMappingsResponse response = client.indices().getMapping(request, options);
            return response.mappings();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public Boolean create(String indexName, @Nullable Map<String, Object> columnMap) {
        try {
            Boolean exist;
            if ((exist = exist(indexName)) == null) {
                return null;
            }
            if (!exist) {
                CreateIndexRequest request = new CreateIndexRequest(indexName);
                if (columnMap != null && columnMap.size() > 0) {
                    Map<String, Object> source = new HashMap<>();
                    source.put("properties", columnMap);
                    request.mapping(source);
                }
                this.client.indices().create(request, options);
                return Boolean.TRUE;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public Boolean delete(String indexName) {
        try {
            Boolean exist;
            if ((exist = exist(indexName)) == null) {
                return null;
            }
            if (exist) {
                DeleteIndexRequest request = new DeleteIndexRequest(indexName);
                AcknowledgedResponse response = client.indices().delete(request, options);
                return response.isAcknowledged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
