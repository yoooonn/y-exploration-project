package com.ycourlee.explore.notes.elk.repository;

import com.ycourlee.explore.notes.elk.entity.EcommerceOrderEntity;
import com.ycourlee.explore.notes.elk.entity.ProductNestedEntity;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author yongjiang
 * @date 2022.03.10
 */
public interface EcommerceOrderRepository extends ElasticsearchRepository<EcommerceOrderEntity, String> {

    List<EcommerceOrderEntity> findEcommerceOrderEntityByProducts(ProductNestedEntity product);

    @Query(value = "{}")
    EcommerceOrderEntity findEcommerceOrderEntityByCustomerLastName(String name);
}
