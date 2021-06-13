package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.dao.UserDao;

@Controller
public class UsersController {

    @Autowired
    private UserDao userDao;
    @GetMapping(value = "/users")
    public String printWelcome(ModelMap model) {
        model.addAttribute("users", "Hello!");
        return "users/index";
    }
}
