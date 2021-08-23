package com.ycourlee.explore.springbootfreemarker.controller;


import com.ycourlee.root.core.domain.context.Rtm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author yongjiang
 * @date 2021.03.28
 */
@Controller
public class StudyFreemarkerSyntaxController {

    @RequestMapping("/syntax-use")
    public ModelAndView welcome() {

        Rtm.success();

        return null;
    }
}
