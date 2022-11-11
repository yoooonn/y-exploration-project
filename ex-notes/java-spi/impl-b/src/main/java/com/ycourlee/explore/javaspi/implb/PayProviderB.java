package com.ycourlee.explore.javaspi.implb;

import com.ycourlee.explore.javaspi.api.Payment;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yooonn
 */
@Slf4j
public class PayProviderB implements Payment {

    @Override
    public Integer payFor(Long amount, String businessLine) {
        log.info("Payment provider B: pay for business line {} {} money.", businessLine, amount);
        return amount.intValue();
    }

    @Override
    public Integer payStatus(String payUniqueKey, String businessLine) {
        log.info("Payment provider B: query payment status in business line {}, pay id: {}.", businessLine, payUniqueKey);
        return 1;
    }
}
