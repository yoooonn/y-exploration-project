package top.yooonn.explore.notes.nacos.provider.chain.followchain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yooonn
 * @date 2021.11.30
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class RuleData {

    private Object              request;
    private HttpServletRequest  servletRequest;
    private HttpServletResponse servletResponse;
}
