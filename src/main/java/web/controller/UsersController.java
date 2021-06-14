package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("users", userDao.getAllUsers());
        return "users/index";
    }

    @GetMapping("{id}")
    public String oneUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userDao.getUser(id));
        return "users/user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userDao.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userDao.getUser(id));
        return "users/edit";
    }

    @PatchMapping("{/id}")
    public String update(Model model, @ModelAttribute("user") User user,
                         @PathVariable("id") long id) {
        userDao.update(user, id);
        return "redirect:/users";
    }
}