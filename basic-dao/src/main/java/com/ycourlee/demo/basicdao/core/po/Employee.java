package com.ycourlee.demo.basicdao.core.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Employee {

    private Integer id;

    private Integer companyId;

    private String name;

    private Integer age;

    /**
     * 1女2男
     */
    private Byte sex;

    private Date birthday;

    private Integer salary;

    private String phoneNumber;

    private String remark;

    private Date modifiedTime;

    private Date createTime;

    private Byte isDel;
}