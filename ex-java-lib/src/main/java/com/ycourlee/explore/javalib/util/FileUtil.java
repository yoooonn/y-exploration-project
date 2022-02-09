package com.ycourlee.explore.javalib.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author yongjiang
 * @date 2021.04.20
 */
public class FileUtil {

    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    public static void writeToFile(byte[] buffer, String filepath) {
        File file = new File(filepath);
        mkdirsIfNotExist(file.getParent());
        FileOutputStream fileOutputStream = null;

        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(buffer, 0, buffer.length);
            bufferedOutputStream.flush();
        } catch (IOException e) {
            log.error("I/O error, filepath: {}, e: {}", filepath, e.getMessage());
        } finally {
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                log.error("I/O error, e: {}", e.getMessage());
            }
        }
    }

    public static void rmDirOrFile(String filepath) {
        File file = new File(filepath);
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            if (file.delete()) {
                log.debug("delete a file! filepath: {}", filepath);
            }
        } else if (file.isDirectory()) {
            File[] files;
            if ((files = file.listFiles()) != null) {
                log.debug("delete all files in directory: {}, they are output in log", filepath);
                for (File f : files) {
                    rmDirOrFile(f.getAbsolutePath());
                }
            }
            if (file.delete()) {
                log.debug("delete the directory at last");
            }
        }
    }

    public static void mkdirsIfNotExist(String filepath) {
        File file = new File(filepath);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                log.error("make directory error!");
            }
        }
    }

    public static JSONObject readJson(String filepath) {
        File file = new File(filepath);
        if (!file.exists()) {
            return new JSONObject(0);
        }
        FileReader fileReader = null;
        JSONReader jsonReader = null;
        try {
            fileReader = new FileReader(file);
            jsonReader = new JSONReader(fileReader);
            return jsonReader.readObject(JSONObject.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (jsonReader != null) {
                    jsonReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new JSONObject(0);
    }
}
