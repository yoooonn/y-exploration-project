package com.ycourlee.explore.notes.elk.repository;

import com.alibaba.fastjson.JSON;
import com.ycourlee.explore.notes.elk.ElkApplicationTests;
import com.ycourlee.explore.notes.elk.entity.EcommerceOrderEntity;
import com.ycourlee.explore.notes.elk.entity.ProductNestedEntity;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author yongjiang
 * @date 2022.03.10
 */
public class EcommerceOrderRepositoryTest extends ElkApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(EcommerceOrderRepositoryTest.class);

    @Autowired
    private EcommerceOrderRepository ecommerceOrderRepository;

    @Test
    void mainTest() {
        EcommerceOrderEntity order =
                ecommerceOrderRepository.findEcommerceOrderEntityByCustomerLastName("Jimenez");
        log.info("order.js: {}", JSON.toJSONString(order));
    }

    @Test
    void findEcommerceOrderEntityByProductsTest() {
        List<EcommerceOrderEntity> order =
                ecommerceOrderRepository.findEcommerceOrderEntityByProducts(
                        new ProductNestedEntity().setId("sold_product_570003_19751"));
        log.info("order.jso: {}", JSON.toJSONString(order));
    }

    @Test
    void existByIdTest() {
        boolean exists = ecommerceOrderRepository.existsById("hello");
        log.info("exists: {}", exists);
    }

    @Test
    void findByIdTest() {
        Optional<EcommerceOrderEntity> order = ecommerceOrderRepository.findById("QC_hcX8BUU2gGzLGDtzp");
        log.info("byId.json: {}", JSON.toJSONString(order.orElse(null)));
    }
}
