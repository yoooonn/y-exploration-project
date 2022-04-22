package com.ycourlee.explore.jmhjavabench;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.ycourlee.tranquil.core.CommonConstants;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public abstract class GlobalVariablesAndMethods extends CommonConstants {

    protected void mkdirsIfNotExist(String filepath) {
        File file = new File(filepath);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                log.error("make directory error!");
            }
        }
    }

    protected JSONObject readJson(String filepath) {
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

    protected static String outputFile(String classname, long cases) {
        return outputFile(classname, cases, 1);
    }

    protected static String outputFile(String classname, long cases, int threads) {
        return outputFile(classname, cases, threads, 0);
    }

    protected static String outputFile(String classname, long cases, int threads, int scenes) {
        File file = new File(TEMP_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        String caseSuffix = "_" + cases + "_cases";
        String threadSuffix = "";
        String sceneSuffix = "";
        if (threads > 0) {
            threadSuffix = "_" + threads + "_threads";
        }
        if (scenes > 0) {
            sceneSuffix = "_" + scenes;
        }
        return TEMP_DIR + File.separator + classname + sceneSuffix + threadSuffix + caseSuffix + ".txt";
    }
}
