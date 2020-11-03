package com.ycourlee.demo.basicdao.core.po;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Company {
    private Integer id;

    private Integer groupId;

    private String name;

    private Long totalIncome;

    private Integer employeeNum;

    private Date establishmentTime;

    private String addr;

    private String remark;

    private Date modifiedTime;

    private Date createTime;

    private Byte isDel;
}