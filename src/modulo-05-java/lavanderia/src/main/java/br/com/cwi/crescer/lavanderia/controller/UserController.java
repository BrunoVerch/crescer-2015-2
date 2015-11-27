package br.com.cwi.crescer.lavanderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.lavanderia.services.UsersService;

@Controller
@RequestMapping("/users")
public class UserController {

	private UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(path = "/lista",method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("user/lista", "usuarios", usersService.listarTodos());
    }
}
