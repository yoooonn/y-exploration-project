package com.ycourlee.explore.bootprocess.inject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ycourlee.explore.bootprocess.model.bo.CatBO;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yongjiang
 * @date 2022.01.11
 */
@Setter
@Getter
@Component
public class InjectView {

    private static final Logger log = LoggerFactory.getLogger(InjectView.class);

    @Value("#{'${list.numbers:123,2345}'}")
    private List<Long> list;

    @Value("#{@injectView.setList(${invokeBeanMethod.numbers})}")
    private String invokeBeanMethod;

    @Value("#{@injectView.setCat(${catConfig.json:'[]'})}")
    private String catConfig;

    @Value("#{'${complex-${string${x}}}'}")
    private String complexString;

    private CatBO cat;

    public void setInvokeBeanMethod(String invokeBeanMethod) {
        setList(invokeBeanMethod);
    }

    public String setList(String list) {
        log.info("old.list.json: {}", JSON.toJSONString(this.list));
        this.list = Arrays.stream(list.split(",")).map(Long::parseLong).collect(Collectors.toList());
        log.info("new.list.json: {}", JSON.toJSONString(this.list));
        return list;
    }

    public String setCat(String catConfig) {
        List<CatBO> catBOS = JSON.parseObject(catConfig, new TypeReference<List<CatBO>>() {});
        this.cat = catBOS.isEmpty() ? null : catBOS.get(0);
        return catConfig;
    }
}
