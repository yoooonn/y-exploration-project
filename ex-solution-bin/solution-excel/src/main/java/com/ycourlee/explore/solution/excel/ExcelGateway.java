package com.ycourlee.explore.solution.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

/**
 * @author yongjiang
 * @date 2021.11.12
 */
public class ExcelGateway {


    public static <T> List<T> importExcel(InputStream inputStream, Class<? extends ExcelRowModel> annotatedClass, ImportParams importParams) throws Exception {
        return ExcelImportUtil.importExcel(inputStream, annotatedClass, importParams);
    }

    public static <T> List<T> importExcel(InputStream inputStream, Class<? extends ExcelRowModel> annotatedClass) throws Exception {
        return importExcel(inputStream, annotatedClass, defaultImportParams());
    }

    public static <T> ExcelImportResult<T> importExcelMore(InputStream inputStream, Class<? extends ExcelRowModel> annotatedClass, ImportParams params) throws Exception {
        return ExcelImportUtil.importExcelMore(inputStream, annotatedClass, params);
    }

    public static <T> ExcelImportResult<T> importExcelMore(InputStream inputStream, Class<? extends ExcelRowModel> annotatedClass) throws Exception {
        return importExcelMore(inputStream, annotatedClass, defaultNeedVerifyImportParams());
    }

    public static void exportExcel(OutputStream outputStream, Collection<?> dataColl, Class<? extends ExcelRowModel> annotatedClass) throws Exception {
        ExportParams params = new ExportParams();
        Workbook sheets = ExcelExportUtil.exportExcel(params, annotatedClass, dataColl);
        sheets.write(outputStream);
        sheets.close();
    }

    public static ImportParams defaultImportParams() {
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(1);
        importParams.setTitleRows(0);
        return importParams;
    }

    public static ImportParams defaultNeedVerifyImportParams() {
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(1);
        importParams.setTitleRows(0);
        importParams.setNeedVerify(true);
        return importParams;
    }
}
