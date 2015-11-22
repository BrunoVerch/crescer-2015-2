package br.com.cwi.crescer.lavanderia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        String msg = "Bem Vindo, Lavanderia Crescer";
        model.addAttribute("msg", msg);
        return "index";
    }
}
