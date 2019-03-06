package com.zlg.bs.user.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class testController {
    @RequestMapping("/test/{name}")
    public String test(@PathVariable String name, HttpSession session) {
        //session.setAttribute("user","zlg");
        return name;
    }
}
