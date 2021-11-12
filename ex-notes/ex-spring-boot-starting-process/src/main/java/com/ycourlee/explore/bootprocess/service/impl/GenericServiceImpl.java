package com.ycourlee.explore.bootprocess.service.impl;

import com.ycourlee.explore.bootprocess.service.GenericService;
import com.ycourlee.root.core.domain.context.Rtm;
import org.springframework.stereotype.Service;

/**
 * @author yongjiang
 * @date 2021.11.01
 */
@Service
public class GenericServiceImpl implements GenericService {

    @Override
    public Rtm ping(String message) {
        return Rtm.success("pong").pin("callback", message);
    }
}
