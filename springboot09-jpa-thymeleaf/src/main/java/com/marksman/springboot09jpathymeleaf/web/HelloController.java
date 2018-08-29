package com.marksman.springboot09jpathymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author weilb
 * @date 2018/8/29
 * @description
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value = "name",required = false,defaultValue = "World") String name){
        model.addAttribute("name",name);
        return "hello";
    }
}