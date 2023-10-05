package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.RoleService;
import ru.itmentor.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @ModelAttribute
    public void allRoles(Model model) {
        model.addAttribute("allRoles", roleService.findAll());
    }

    @GetMapping(value = "")
    public ModelAndView getAllUser(ModelAndView modelAndView) {
        modelAndView.addObject("userList", userService.findAll());
        modelAndView.setViewName("allUsers");
        return modelAndView;
    }

    @GetMapping("/newUserForm")
    public String newForm(Model model) {
        model.addAttribute("newUser", new User());
        return "newUserForm";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(
            @ModelAttribute(value = "newUser") User user,
            @RequestParam("idRole") long[] idRole) {
        for (long l : idRole) {
            user.addRole(roleService.findRoleById(l));
        }
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/updateUser")
    public String updateUserForm(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "updateUserForm";
    }

    @PostMapping(value = "/updateUser")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam(value = "idRole", defaultValue = "2") long[] idRole) {
        for (long l : idRole) {
            user.addRole(roleService.findRoleById(l));
        }
        userService.update(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}