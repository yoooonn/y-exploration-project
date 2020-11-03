package com.ycourlee.demo.basicdao.core.service;

import com.ycourlee.demo.basicdao.core.po.Group;

public interface GroupService {

    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

}
