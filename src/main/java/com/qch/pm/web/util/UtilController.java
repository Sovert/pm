package com.qch.pm.web.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : qiuchenhao
 * @date : 2019/3/24
 */
@Controller
@RequestMapping("/util")
public class UtilController {
    @GetMapping("/replace")
    public String add() {
        return "util/replace";
    }

}
