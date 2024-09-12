package top.gsc.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.gsc.springbootthymeleaf.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private List<User> userList = new ArrayList<>();
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userList);
        return "userList";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String name,String email) {
        Long id = (long) (userList.size() + 1);
        User user  =new User(id,name,email);
        userList.add(user);
        return "redirect:/users";
    }
}

