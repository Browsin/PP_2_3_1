package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users";
    }

    @GetMapping("/newUser")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "createOrUpdateUser";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam(name = "id") Integer id, ModelMap model) {
        model.addAttribute("user", userService.findById(id));
        return "createOrUpdateUser";
    }

    @PostMapping("/createOrUpdateUser")
    public String createOrUpdateUser(@ModelAttribute("user") User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
