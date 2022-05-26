package com.ycourlee.explore.javalib.cn.hutool.core.util;

import cn.hutool.core.util.IdcardUtil;
import com.ycourlee.explore.javalib.AbstractTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2022.01.06
 */
public class IdCardUtilTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(IdCardUtilTest.class);

    @Test
    void isValidCardTest() {
        boolean validCard = IdcardUtil.isValidCard("34122220000430123x");
        log.info("validCard: {}", validCard);
        log.info("0xFF: {}", 12 & 0xFF);
    }

    @Test
    void isValidCard2Test() {
        String idCard = "42010119980324756X";
        boolean validCard = IdcardUtil.isValidCard(idCard);
        log.info("IdcardUtil.getGenderByIdCard(idCard) = {}", IdcardUtil.getGenderByIdCard(idCard));
        ;
        log.info("validCard: {}", validCard);
    }
}
