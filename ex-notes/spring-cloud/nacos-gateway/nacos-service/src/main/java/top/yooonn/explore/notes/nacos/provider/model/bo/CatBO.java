package top.yooonn.explore.notes.nacos.provider.model.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author yooonn
 * @date 2022.01.15
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class CatBO {

    private String name;

    private Long id;
}
