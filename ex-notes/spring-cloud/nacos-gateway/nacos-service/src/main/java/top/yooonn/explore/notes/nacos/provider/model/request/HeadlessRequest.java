package top.yooonn.explore.notes.nacos.provider.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @author yooonn
 * @date 2021.11.22
 */
@Setter
@Getter
@ToString
public class HeadlessRequest {

    @NotEmpty
    private String headless;
}
