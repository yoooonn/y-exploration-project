package com.ycourlee.explore.notes.elk.service;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EsDataOperation {

    private final RequestOptions      options = RequestOptions.DEFAULT;
    @Resource
    private       RestHighLevelClient client;

    public Boolean insert(String indexName, Map<String, Object> dataMap) {
        try {
            BulkRequest request = new BulkRequest();
            request.add(new IndexRequest(indexName, "doc").id(dataMap.remove("id").toString())
                    .opType("create").source(dataMap, XContentType.JSON));
            this.client.bulk(request, options);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public Boolean batchInsert(String indexName, List<Map<String, Object>> userIndexList) {
        try {
            BulkRequest request = new BulkRequest();
            for (Map<String, Object> dataMap : userIndexList) {
                request.add(new IndexRequest(indexName, "doc").id(dataMap.remove("id").toString())
                        .opType("create").source(dataMap, XContentType.JSON));
            }
            this.client.bulk(request, options);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public Boolean update(String indexName, Map<String, Object> dataMap) {
        try {
            UpdateRequest updateRequest = new UpdateRequest(indexName, "doc", dataMap.remove("id").toString());
            updateRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            updateRequest.doc(dataMap);
            this.client.update(updateRequest, options);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(String indexName, String id) {
        try {
            DeleteRequest deleteRequest = new DeleteRequest(indexName, "doc", id);
            this.client.delete(deleteRequest, options);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}