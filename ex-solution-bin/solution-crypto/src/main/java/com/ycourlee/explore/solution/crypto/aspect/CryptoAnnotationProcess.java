package com.ycourlee.explore.solution.crypto.aspect;

import java.util.List;

/**
 * @author yongjiang
 * @date 2021.12.17
 */
public interface CryptoAnnotationProcess {

    void processInput(Object obj, List<String> enableGroups);
}
