package top.yooonn.explore.notes.elk.repository;

import top.yooonn.explore.notes.elk.entity.EcommerceOrderEntity;
import top.yooonn.explore.notes.elk.entity.ProductNestedEntity;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author yooonn
 * @date 2022.03.10
 */
public interface EcommerceOrderRepository extends ElasticsearchRepository<EcommerceOrderEntity, String> {

    List<EcommerceOrderEntity> findEcommerceOrderEntityByProducts(ProductNestedEntity product);

    @Query(value = "{}")
    EcommerceOrderEntity findEcommerceOrderEntityByCustomerLastName(String name);
}
