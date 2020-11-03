package com.ycourlee.demo.basicdao.core.service;

import com.ycourlee.demo.basicdao.core.po.Employee;

public interface EmployeeService {

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

}
