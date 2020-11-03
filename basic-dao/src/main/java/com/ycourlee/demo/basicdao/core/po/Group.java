package com.ycourlee.demo.basicdao.core.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Group {
    private Integer id;
    private String name;
    private Date establishmentTime;
    private String addr;
    private String remark;
    private Date modifiedTime;
    private Date createTime;
    private Byte isDel;
}