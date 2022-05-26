package com.ycourlee.explore.javalib;

import com.ycourlee.tranquil.core.CommonConstants;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yooonn
 * @date 2021.12.14
 */
public abstract class AbstractTest extends CommonConstants {

    protected File newFile(String path) {
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            mkdirQuietly(file.getParentFile());
        }
        return file;
    }

    protected void mkdirQuietly(File dir) {
        if (!dir.exists()) {
            boolean v = dir.mkdirs();
        }
    }

    protected Date timeOf(Date date, Integer hour, Integer minute, Integer second) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.set(Calendar.HOUR_OF_DAY, hour);
        todayEnd.set(Calendar.MINUTE, minute);
        todayEnd.set(Calendar.SECOND, second);
        todayEnd.set(Calendar.MILLISECOND, 0);
        return todayEnd.getTime();
    }

    protected Date timeOf(Date date, Integer hour, Integer minute) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.set(Calendar.HOUR_OF_DAY, hour);
        todayEnd.set(Calendar.MINUTE, minute);
        todayEnd.set(Calendar.MILLISECOND, 0);
        return todayEnd.getTime();
    }

    protected Date timeOf(Date date, Integer hour) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.set(Calendar.HOUR_OF_DAY, hour);
        todayEnd.set(Calendar.MILLISECOND, 0);
        return todayEnd.getTime();
    }

    protected Date timeOf(Integer hour) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(new Date());
        todayEnd.set(Calendar.HOUR_OF_DAY, hour);
        todayEnd.set(Calendar.MILLISECOND, 0);
        return todayEnd.getTime();
    }

    protected String dateFormat(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
}
