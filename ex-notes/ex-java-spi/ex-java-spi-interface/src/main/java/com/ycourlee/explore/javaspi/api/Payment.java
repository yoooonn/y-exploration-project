package com.ycourlee.explore.javaspi.api;

/**
 * @author yongjiang
 * @date 2021.03.30
 */
public interface Payment {

    Integer payFor(Long amount, String businessLine);

    Integer payStatus(String payUniqueKey, String businessLine);
}
