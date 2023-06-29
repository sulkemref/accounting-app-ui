package com.cydeo.accounting_app.controller;

import com.cydeo.accounting_app.dto.CompanyDTO;
import com.cydeo.accounting_app.dto.UserDTO;
import com.cydeo.accounting_app.service.RoleService;
import com.cydeo.accounting_app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("/create")
    public String userCreate(Model model){

        model.addAttribute("newUser", new UserDTO());
        model.addAttribute("userRoles", roleService.listAllRoles());
        model.addAttribute("companies", List.of(new CompanyDTO()));

        return "user/user-create";
    }

    @PostMapping("/create")
    public String userCreatePost(@ModelAttribute("newUser") UserDTO newlyCreatedUser){

        userService.save(newlyCreatedUser);
//        Not currently working Company is hardcoded -> Field error in object 'newUser' on field 'company': rejected value [];

        return "redirect:/users/create";

    }

    @GetMapping("/list")
    public String listUser(Model model){

        model.addAttribute("users", userService.listAllUsers() );

        return "user/user-list";

    }

    @GetMapping("/delete/{id}")
    public String userDelete(@PathVariable("id") Long id){

        userService.softDelete(id);

        return "redirect:/users/list";

    }

    @GetMapping("/update/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){

        model.addAttribute("user", userService.findById(id));
        model.addAttribute("userRoles", roleService.listAllRoles());
        model.addAttribute("companies", List.of(new CompanyDTO()));
        return "user/user-update";

    }



//    @PostMapping("/update")
//    public String editUserPost(@ModelAttribute("user") UserDTO updatedUser){
//
//        userService.save(updatedUser);
////        Not currently working Company is hardcoded -> Field error in object 'newUser' on field 'company': rejected value [];
//
//        return "redirect:user/user-update";
//
//    }


}
