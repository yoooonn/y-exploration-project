package com.ycourlee.explore.solution.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author yongjiang
 * @date 2021.11.16
 */
public class ExcelRowModelTest extends AbstractEnvironment {

    @Setter
    @Getter
    @ToString
    public static class InputBO extends ExcelRowModel {

        private static final long serialVersionUID = 2122316230153561328L;
        @Excel(name = "id")
        private Long id;
        @Excel(name = "name")
        private String name;
    }

    @Setter
    @Getter
    @ToString
    public static class OutputBO extends ExcelRowModel {

        private static final long serialVersionUID = 1629094754354290402L;
        @Excel(name = "id")
        private Long id;
        @Excel(name = "name")
        private String name;
        @Excel(name = "date", exportFormat = "yyyy-MM-dd HH:mm:ss")
        private Date date;
    }
}
