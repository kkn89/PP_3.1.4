package com.kata.spring.bootstrap.spring_bootstrap.controller;


import com.kata.spring.bootstrap.spring_bootstrap.model.User;
import com.kata.spring.bootstrap.spring_bootstrap.service.RoleService;
import com.kata.spring.bootstrap.spring_bootstrap.service.UserService;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;


    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String allUsers(Model model) {
        List<User> allUsers = userService.allUsers();
        model.addAttribute("allUs",userService.allUsers());
        return "admin-page";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("role", roleService.allRoles());
        return "user-info";
    }
    @PostMapping("/new")
    public String newUser(@ModelAttribute User user, @RequestParam(value = "nameRoles") String[] nameRoles) throws NotFoundException {
        user.setRoles(roleService.getRoleSet(nameRoles));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("role", roleService.allRoles());
        return "edit-user";
    }
    @PutMapping(value = "/edit/{id}")
    public String editUser(@ModelAttribute User user, @RequestParam(value = "nameRoles") String[] nameRoles) throws NotFoundException {
        user.setRoles(roleService.getRoleSet(nameRoles));
        userService.update(user);
        return "redirect:/admin";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
