package br.com.cwi.crescer.lavanderia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public ModelAndView Sair() {
        return new ModelAndView("/logout");
    }
}
