package top.yooonn.explore.jmhjavabench.support;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * bel: bus expression language.
 *
 * @author yooonn
 * @date 2021.01.23
 */
@Setter
@Getter
@ToString
public class Bel {

    private String original;

    private String variable;

    private Object value;

    private BelTypeEnum type;

    /**
     * 值是否从pool中拿
     */
    private Boolean accessPool;

    public Bel() {
    }

    public Object getValue() {
        if (!this.accessPool) {
            return this.value;
        }
        if (this.type == null) {
            return this.value;
        }
        switch (this.type) {
            case LONG:
                this.value = Long.parseLong(((String) this.value));
                break;
            case INTEGER:
                this.value = Integer.parseInt(((String) this.value));
                break;
            case DOUBLE:
                if (!(this.value instanceof Double)) {
                    this.value = Double.parseDouble(((String) this.value));
                }
                break;
            case STRING:
                this.value = String.valueOf(this.value);
                break;
            default:
                break;
        }
        return this.value;
    }

    public void set(Object value, BelTypeEnum belType, Boolean accessPool) {
        this.value = value;
        this.type = belType;
        this.accessPool = accessPool;
    }
}
