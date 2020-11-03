package com.ycourlee.demo.basicdao.core.service;

import com.ycourlee.demo.basicdao.core.po.Company;

public interface CompanyService {

    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

}
