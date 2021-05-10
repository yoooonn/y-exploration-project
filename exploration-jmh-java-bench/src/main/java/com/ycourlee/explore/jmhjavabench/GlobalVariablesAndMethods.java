package com.ycourlee.explore.jmhjavabench;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public abstract class GlobalVariablesAndMethods {

    protected static final String DOC_DIR                = System.getProperty("user.dir") + "/doc";
    protected static final String TEMP_DIR               = DOC_DIR + "/temp";
    protected static final String RESOURCE_DIR           = DOC_DIR + "/resource";
    protected static final String TEMP_JSON_FILE_DIR     = DOC_DIR + "/temp" + "/json";
    protected static final String RESOURCE_JSON_FILE_DIR = DOC_DIR + "/resource" + "/json";

    protected static final SerializeConfig SNAKE_CASE_SERIALIZE_CONFIG;


    protected static final Integer TEST_CASE_TEN          = 10;
    protected static final Integer TEST_CASE_ONE_HUNDRED  = 100;
    protected static final Integer TEST_CASE_ONE_THOUSAND = 1000;
    protected static final Integer TEST_CASE_TEN_THOUSAND = 10000;

    static {
        SNAKE_CASE_SERIALIZE_CONFIG = new SerializeConfig();
        SNAKE_CASE_SERIALIZE_CONFIG.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
    }

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
}
