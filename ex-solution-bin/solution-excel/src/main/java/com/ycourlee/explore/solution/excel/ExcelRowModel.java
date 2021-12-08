package com.ycourlee.explore.solution.excel;

import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;

import java.io.Serializable;

public class ExcelRowModel implements IExcelModel, IExcelDataModel, Serializable {

    private static final long   serialVersionUID = -5080157099218930683L;
    private              String errorMsg;
    private              int    rowNum;

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public Integer getRowNum() {
        return rowNum;
    }

    @Override
    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }
}