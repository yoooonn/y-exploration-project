package com.ycourlee.explore.solution.crypto.aspect;

import com.ycourlee.explore.solution.crypto.aes.AesCrypto;
import com.ycourlee.explore.solution.crypto.annotation.Ciphertext;
import com.ycourlee.explore.solution.crypto.annotation.CryptoAnnotationMetadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @author yongjiang
 * @date 2021.12.17
 */
class CiphertextProcessor extends AbstractCryptoAnnotationProcess {

    public CiphertextProcessor(AesCrypto aesCrypto) {
        super(aesCrypto);
    }

    @Override
    public void processInput(Object obj, List<String> enableGroups) {
        Map<Field, Annotation> fields = findAnnotatedFields(obj.getClass(), Ciphertext.class);
        for (Map.Entry<Field, Annotation> entry : fields.entrySet()) {
            Field field = entry.getKey();
            Ciphertext annoMeta = ((Ciphertext) entry.getValue());
            if (annoMeta == null || shouldBeIgnore(annoMeta.group(), enableGroups)) {
                continue;
            }
            processField(obj, field, CryptoAnnotationMetadata.from(annoMeta));
        }
    }
}
