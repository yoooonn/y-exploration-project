package com.ycourlee.explore.javaspi.impla;

import com.ycourlee.explore.javaspi.api.Payment;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jiangyong
 * @date 2021.07.27
 */
@Slf4j
public class PayProviderA implements Payment {

    @Override
    public Integer payFor(Long amount, String businessLine) {
        log.info("Payment provider A: pay for business line {} {} money.", businessLine, amount);
        return amount.intValue();
    }

    @Override
    public Integer payStatus(String payUniqueKey, String businessLine) {
        log.info("Payment provider A: query payment status in business line {}, pay id: {}.", businessLine, payUniqueKey);
        return 1;
    }
}
