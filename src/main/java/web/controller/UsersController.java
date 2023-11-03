package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.models.User;

@Controller
@RequestMapping
public class UsersController {
    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("people", userService.allUsers());
        return "/users";
    }
    @GetMapping("/user")
    public String showUser(Model model,@RequestParam(value = "nameId", required = false) int id) {
        model.addAttribute("user",userService.showUser(id));
        return "/user";
    }
    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        return "/newUser";
    }
    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/delete")
    public String delUser(@RequestParam(value = "id") int id) {
        userService.delUser(id);
        return "redirect:/users";
    }
}
