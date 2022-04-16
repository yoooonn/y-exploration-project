package com.ycourlee.explore.bootprocess.model.bo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.ycourlee.explore.solution.excel.annotation.Idcard;
import com.ycourlee.explore.solution.excel.annotation.PhoneNumber;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yongjiang
 * @date 2021.11.17
 */
@Setter
@Getter
@ToString
public class ExcelImportBO {

    @NotNull
    @Excel(name = "id")
    private Long   id;
    @NotEmpty
    @Excel(name = "name")
    private String name;
    @NotEmpty
    @PhoneNumber
    @Excel(name = "手机号")
    private String phone;
    @Idcard
    @NotEmpty
    @Excel(name = "身份证号")
    private String idcard;
}
