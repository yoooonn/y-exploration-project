package com.ycourlee.explore.bootprocess.chain.followchain.follows;

import com.ycourlee.explore.bootprocess.chain.followchain.Follow;
import com.ycourlee.explore.bootprocess.chain.followchain.FollowChain;
import com.ycourlee.explore.bootprocess.chain.followchain.RuleData;
import com.ycourlee.explore.bootprocess.service.FileService;
import com.ycourlee.explore.bootprocess.service.GenericService;
import com.ycourlee.root.core.domain.context.Rtm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2021.12.09
 */
@Component
public class OneFollow implements Follow {

    @Autowired
    private GenericService genericService;

    private FileService fileService;

    public OneFollow(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    public void doExecute(Rtm rtm, RuleData ruleData, FollowChain chain) {
        System.out.println("genericService = " + genericService);
        System.out.println("fileService = " + fileService);
    }
}
