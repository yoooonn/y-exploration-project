package com.ycourlee.explore.notes.bootweb.service.impl;

import com.ycourlee.explore.basic.dao.CountryMapper;
import com.ycourlee.explore.notes.bootweb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yooonn
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private CountryMapper countryMapper;

    /**
     * delete语句在可重复读隔离级别下的表现：
     * <p>
     * spring事务默认使用jdbc连接的隔离级别，在默认情况下，InnoDB使用可重复读，即Spring事务默认隔离级别为：可重复读。
     * 下面的代码块演示了：当多请求执行到if条件时，只有先执行dao语句的线程才会进入到if块内
     *
     * @param rid rid
     * @return true
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteStatementTransactionVerify(Integer rid) {
        if (countryMapper.deleteByPrimaryKey(rid) == 1) {
            System.out.println("成功");
            return true;
        }
        return false;
    }
}
