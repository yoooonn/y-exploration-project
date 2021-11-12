package com.ycourlee.explore.jmhjavabench;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.ycourlee.explore.jmhjavabench.runner.java.util.stream.StreamForeachBmRunner;
import com.ycourlee.root.mocks.UnitTestResource;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public abstract class GlobalVariablesAndMethods extends UnitTestResource {

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
