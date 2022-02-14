package com.kata.spring.bootstrap.spring_bootstrap.controller;

import com.kata.spring.bootstrap.spring_bootstrap.model.Role;
import com.kata.spring.bootstrap.spring_bootstrap.model.User;
import com.kata.spring.bootstrap.spring_bootstrap.service.RoleService;
import com.kata.spring.bootstrap.spring_bootstrap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final UserService userService;
    private final RoleService roleService;


    public RestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/getAllUsers") //при переходе на http://localhost:8080/api/getAllUsers получаем json всех юзеров
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/getAllRoles") //при переходе на http://localhost:8080/api/getAllRoles получаем json всех ролей
    public ResponseEntity<Set<Role>> getAllRoles() {
        return ResponseEntity.ok().body(roleService.getAllRoles());
    }

    @GetMapping("/getUserById/{id}") //при переходе на http://localhost:8080/api/getUserById/{id} получаем json конкретного юзера
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping("/create") //пост запрос на http://localhost:8080/api/create" создание нового юзера из полученого json
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/edit") //пут запрос на http://localhost:8080/api/edit" обновление юзера из полученого json
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/delete/{id}") //делит запрос на http://localhost:8080/api/delete/{id}" удаление юзера из по id
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAuthorizedUser") //при переходе на http://localhost:8080/api/getAuthorizedUser получаем json авторизованного юзера
    public ResponseEntity<User> getAuthorizedUser() {
        User authorizedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(authorizedUser);
    }

}
