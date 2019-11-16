package haianh.com.edu.sodaubai.controller;

import haianh.com.edu.sodaubai.entity.User;
import haianh.com.edu.sodaubai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("registration")
    public void registration(@ModelAttribute("userForm") User user) {
        user.setStatus(User.Status.ACTIVE);
        user.setFullName("");
        userService.save(user);
    }

    @GetMapping("registration")
    public String getRegistration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }
}
