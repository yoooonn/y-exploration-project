package com.ycourlee.explore.notes.bootweb.chain.followchain.follows;

import com.ycourlee.explore.notes.bootweb.chain.followchain.Follow;
import com.ycourlee.explore.notes.bootweb.chain.followchain.FollowChain;
import com.ycourlee.explore.notes.bootweb.chain.followchain.RuleData;
import com.ycourlee.explore.notes.bootweb.service.FileService;
import com.ycourlee.explore.notes.bootweb.service.GenericService;
import com.ycourlee.tranquil.web.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yooonn
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
    public boolean disabled() {
        return true;
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    public void doExecute(Response resp, RuleData ruleData, FollowChain chain) {
        System.out.println("genericService = " + genericService);
        System.out.println("fileService = " + fileService);
    }
}
