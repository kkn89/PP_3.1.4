package com.kata.spring.bootstrap.spring_bootstrap.controller;

import com.kata.spring.bootstrap.spring_bootstrap.model.User;
import com.kata.spring.bootstrap.spring_bootstrap.service.RoleService;
import com.kata.spring.bootstrap.spring_bootstrap.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class    RestController {

    private final UserService userService;
    private final RoleService roleService;


    public RestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public List<User> allUsers() {
        return userService.getAllUsers();
    }

//    @PostMapping("/new")
//    public String newUser(@ModelAttribute User user, @RequestParam(value = "nameRoles") String[] nameRoles) throws NotFoundException {
//        user.setRoles(roleService.getRoleSet(nameRoles));
//        userService.saveUser(user);
//        return "redirect:/admin";
//    }
//    @GetMapping("/edit/{id}")
//    public String editUser(@PathVariable("id") long id, Model model) {
//        model.addAttribute("user", userService.getById(id));
//        model.addAttribute("role", roleService.allRoles());
//        return "edit-user";
//    }
//
//
//    @PatchMapping(value = "/edit/{id}")
//    public String editUser(@ModelAttribute User user, @RequestParam(value = "nameRoles") String[] nameRoles) throws NotFoundException {
//        user.setRoles(roleService.getRoleSet(nameRoles));
//        userService.update(user);
//        return "redirect:/admin";
//    }
//    @DeleteMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") long id) {
//        userService.delete(id);
//        return "redirect:/admin";
//    }
}
