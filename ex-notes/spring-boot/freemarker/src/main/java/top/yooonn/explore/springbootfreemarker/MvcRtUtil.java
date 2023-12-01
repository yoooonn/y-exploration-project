package top.yooonn.explore.springbootfreemarker;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author yooonn
 * @date 2021.03.28
 */
public class MvcRtUtil {

    public static ModelAndView success(String viewName, Map<String, Object> attributes) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addAllObjects(attributes);
        modelAndView.setStatus(HttpStatus.OK);
        return modelAndView;
    }
}
