package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class HelloController {
    private UserService userService;


    @Autowired
    public void HelloController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("newUser")
    public User getPerson() {
        return new User();
    }

    @GetMapping("/people")
    public String index(Model model) {
        model.addAttribute("people", userService.getAllUsers());
        return "index";
    }

    @PostMapping("/people")
    public String creat(@ModelAttribute("newUser") User user,
                        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("people", userService.getAllUsers());
            return "index";
        }

        return "redirect:/";
    }

    @DeleteMapping("/people/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

    @GetMapping("/people/{id}/edit")
    public String edit(@ModelAttribute("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/people/{id}")
    public String updatePerson(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.updateUser(user);
        return "redirect:/";
    }
}